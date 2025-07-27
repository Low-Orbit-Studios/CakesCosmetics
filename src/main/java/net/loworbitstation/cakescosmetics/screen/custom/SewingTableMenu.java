package net.loworbitstation.cakescosmetics.screen.custom;

import com.google.common.collect.Lists;
import net.loworbitstation.cakescosmetics.block.entity.SewingTableBlockEntity;
import net.loworbitstation.cakescosmetics.recipe.SewingTableRecipe;
import net.loworbitstation.cakescosmetics.recipe.SewingTableRecipeInput;
import net.loworbitstation.cakescosmetics.screen.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;

import java.util.List;

import static net.loworbitstation.cakescosmetics.recipe.ModRecipes.SEWING_TABLE_TYPE;


public class SewingTableMenu extends AbstractContainerMenu {
    //From StonecutterMenu.java
    private final ContainerLevelAccess access;
    //From StonecutterMenu.java
    private Slot inputSlot;
    //From StonecutterMenu.java
    private Slot outputSlot;
    //From StonecutterMenu.java
    /** The ItemStack set in the input slot by the player. */
    private ItemStack input = ItemStack.EMPTY;
    //From StonecutterMenu.java
    /**
     * Stores the game time of the last time the player took items from the the crafting result slot. This is used to
     * prevent the sound from being played multiple times on the same tick.
     */
    long lastSoundTime;

    Runnable slotUpdateListener = () -> {
    };

    public final SewingTableBlockEntity blockEntity;
    private final Level level;
    private final DataSlot selectedRecipeIndex = DataSlot.standalone();
    private List<RecipeHolder<SewingTableRecipe>> recipes = Lists.newArrayList();
    public final Container container = new SimpleContainer(1) {
        /**
         * For block entities, ensures the chunk containing the block entity is saved to disk later - the game won't think
         * it hasn't changed and skip it.
         */
        public void setChanged() {
            super.setChanged();
            SewingTableMenu.this.slotsChanged(this);
            SewingTableMenu.this.slotUpdateListener.run();
        }

    };
    /** The inventory that stores the output of the crafting recipe. */
    final ResultContainer resultContainer = new ResultContainer();

    public SewingTableMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public SewingTableMenu(int containerId, Inventory inv, BlockEntity blockEntity) {
        super(ModMenuTypes.SEWING_TABLE_MENU.get(), containerId);
        checkContainerSize(inv, 2);

        this.blockEntity = ((SewingTableBlockEntity) blockEntity);
        this.level = inv.player.level();
        this.access = ContainerLevelAccess.create(level, blockEntity.getBlockPos());;

        //Position values akin to Stonecutter's.
        inputSlot = this.addSlot(new Slot(this.container, 0,20, 33));
        outputSlot = this.addSlot(new Slot(this.resultContainer, 1,143, 33){

        //From StonecutterMenu.java
        /**
         * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
         */
        @Override
        public boolean mayPlace(ItemStack p_40362_) {
            return false;
        }

        //From StonecutterMenu.java
        @Override
        public void onTake(Player p_150672_, ItemStack p_150673_) {
            p_150673_.onCraftedBy(p_150672_.level(), p_150672_, p_150673_.getCount());
            SewingTableMenu.this.resultContainer.awardUsedRecipes(p_150672_, this.getRelevantItems());
            ItemStack itemstack = SewingTableMenu.this.inputSlot.remove(1);
            if (!itemstack.isEmpty()) {
                SewingTableMenu.this.setupResultSlot();
            }

            access.execute((level, pos) -> {
                long l = level.getGameTime();
                if (SewingTableMenu.this.lastSoundTime != l) {
                    level.playSound((Player) p_150672_, pos, SoundEvents.ARMOR_EQUIP_LEATHER.value(), SoundSource.BLOCKS, 1f, 1f);
                    SewingTableMenu.this.lastSoundTime = l;
                }
            });
            super.onTake(p_150672_, p_150673_);
        }

            private List<ItemStack> getRelevantItems() {
                return List.of(SewingTableMenu.this.inputSlot.getItem());
            }
        });


        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 0,20, 33));
    }


    //From StonecutterMenu.java
    @Override
    public void slotsChanged(Container pInventory) {
        var itemStack = this.inputSlot.getItem();
        if(!itemStack.is(this.input.getItem())){
            this.input = itemStack.copy();
            this.setupRecipeList(pInventory, itemStack);
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    //From StonecutterMenu.java
    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }

    //From StonecutterMenu.java
    public void registerUpdateListener(Runnable pListener) {
        this.slotUpdateListener = pListener;
    }

    //From StonecutterMenu.java
    private static SewingTableRecipeInput createRecipeInput(Container container) {
        return new SewingTableRecipeInput(container.getItem(0));
    }

    //From StonecutterMenu.java
    private void setupRecipeList(Container container, ItemStack stack) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.outputSlot.set(ItemStack.EMPTY);
        if (!stack.isEmpty()) {
            var recipeType = SEWING_TABLE_TYPE.get();
            var recipeManager = this.level.getRecipeManager();

            this.recipes = recipeManager.getRecipesFor(recipeType, createRecipeInput(container), this.level);
        }
    }


    //From StonecutterMenu.java
    public boolean clickMenuButton(Player pPlayer, int pId) {
        if (this.isValidRecipeIndex(pId)) {
            this.selectedRecipeIndex.set(pId);
            this.setupResultSlot();
        }

        return true;
    }

    //From StonecutterMenu.java
    void setupResultSlot() {
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            RecipeHolder<SewingTableRecipe> recipeholder = this.recipes.get(this.selectedRecipeIndex.get());
            ItemStack itemstack = recipeholder.value().assemble(createRecipeInput(this.container), this.level.registryAccess());
            if (itemstack.isItemEnabled(this.level.enabledFeatures())) {
                this.resultContainer.setRecipeUsed(recipeholder);
                this.outputSlot.set(itemstack);
            } else {
                this.outputSlot.set(ItemStack.EMPTY);
            }
        } else {
            this.outputSlot.set(ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    //From StonecutterMenu.java
    private boolean isValidRecipeIndex(int pRecipeIndex) {
        return pRecipeIndex >= 0 && pRecipeIndex < this.recipes.size();
    }

    //From StonecutterMenu.java
    /**
     * Returns the index of the selected recipe.
     */
    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    //From StonecutterMenu.java
    public int getNumRecipes() {
        return this.recipes.size();
    }

    //From StonecutterMenu.java
    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
     * inventory and the other inventory(s).
     */
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            Item item = itemstack1.getItem();
            itemstack = itemstack1.copy();
            if (index == 1) {
                item.onCraftedBy(itemstack1, player.level(), player);
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (index == 0) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(SEWING_TABLE_TYPE.get(), new SewingTableRecipeInput(itemstack1), this.level).isPresent()) {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 2 && index < 29) {
                if (!this.moveItemStackTo(itemstack1, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 29 && index < 38 && !this.moveItemStackTo(itemstack1, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
            this.broadcastChanges();
        }

        return itemstack;
    }

    //From StonecutterMenu.java
    @Override
    public void removed(Player player) {
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((p_40313_, p_40314_) -> this.clearContainer(player, this.container));
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    public List<RecipeHolder<SewingTableRecipe>> getRecipes(){
        return recipes;
    }


    }
