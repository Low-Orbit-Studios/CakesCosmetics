package net.loworbitstation.cakescosmetics.screen;

import com.google.common.collect.Lists;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.block.ModBlocks;
import net.loworbitstation.cakescosmetics.block.entity.SewingStationBlockEntity;
import net.loworbitstation.cakescosmetics.recipe.SewingRecipeType;
import net.loworbitstation.cakescosmetics.recipe.SewingStationRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import java.util.List;

import static net.loworbitstation.cakescosmetics.data.constants.Constants.*;
import static net.loworbitstation.cakescosmetics.recipe.ModRecipes.SEWING_RECIPE_TYPE;


public class SewingStationMenu extends AbstractContainerMenu {
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
    public final SewingStationBlockEntity blockEntity;
    private final Level level;
    private final DataSlot selectedRecipeIndex = DataSlot.standalone();
    private List<SewingStationRecipe> recipes = Lists.newArrayList();
    public final Container container = new SimpleContainer(1) {
        /**
         * For block entities, ensures the chunk containing the block entity is saved to disk later - the game won't think
         * it hasn't changed and skip it.
         */
        public void setChanged() {
            super.setChanged();
            SewingStationMenu.this.slotsChanged(this);
            SewingStationMenu.this.slotUpdateListener.run();
        }
    };
    /** The inventory that stores the output of the crafting recipe. */
    final ResultContainer resultContainer = new ResultContainer();

    public SewingStationMenu(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf extraData) {
        this(pContainerId, pPlayerInventory, pPlayerInventory.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public SewingStationMenu(int pContainerId, Inventory pPlayerInventory, BlockEntity entity) {
        super(ModMenuTypes.SEWING_STATION_MENU.get(), pContainerId);
        checkContainerSize(pPlayerInventory, SEWING_STATION_SLOT_COUNT);
        blockEntity = (SewingStationBlockEntity) entity;
        this.level = pPlayerInventory.player.level();
        this.access = ContainerLevelAccess.create(level, blockEntity.getBlockPos());;

        addPlayerInventory(pPlayerInventory);
        addPlayerHotbar(pPlayerInventory);

        var itemHandlerCapability = this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER);
        if(itemHandlerCapability.isPresent()){
            //Position values akin to Stonecutter's.
            inputSlot = this.addSlot(new Slot(this.container, SEWING_STATION_INPUT_SLOT_INDEX,20, 33));
            outputSlot = this.addSlot(new Slot(this.resultContainer, SEWING_STATION_OUTPUT_SLOT_INDEX,143, 33){
                //From StonecutterMenu.java
                /**
                 * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
                 */
                public boolean mayPlace(ItemStack p_40362_) {
                    return false;
                }

                //From StonecutterMenu.java
                public void onTake(Player p_150672_, ItemStack p_150673_) {
                    p_150673_.onCraftedBy(p_150672_.level(), p_150672_, p_150673_.getCount());
                    SewingStationMenu.this.resultContainer.awardUsedRecipes(p_150672_, this.getRelevantItems());
                    ItemStack itemstack = SewingStationMenu.this.inputSlot.remove(1);
                    if (!itemstack.isEmpty()) {
                        SewingStationMenu.this.setupResultSlot();
                    }

                    access.execute((level, levelPosConsumer) -> {
                        long l = level.getGameTime();
                        if (SewingStationMenu.this.lastSoundTime != l) {
                            level.playSound((Player)null, levelPosConsumer, SoundEvents.ARMOR_EQUIP_LEATHER, SoundSource.BLOCKS, 1.0F, 1.0F);
                            SewingStationMenu.this.lastSoundTime = l;
                        }

                    });
                    super.onTake(p_150672_, p_150673_);
                }

                private List<ItemStack> getRelevantItems() {
                    return List.of(SewingStationMenu.this.inputSlot.getItem());
                }
            });
        }
        else{
            CakesCosmetics.LOGGER.error("No item handler capability found upon creating Sewing Station Menu!");
        }

        addDataSlot(selectedRecipeIndex);
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
    //From StonecutterMenu.java
    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }
    //From StonecutterMenu.java
    public void registerUpdateListener(Runnable pListener) {
        this.slotUpdateListener = pListener;
    }
    //From StonecutterMenu.java
    private void setupRecipeList(Container pContainer, ItemStack pStack) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.outputSlot.set(ItemStack.EMPTY);
        if (!pStack.isEmpty()) {
            var recipeType = SEWING_RECIPE_TYPE.get();
            var recipeTypeKey = SEWING_RECIPE_TYPE.getKey();
            var recipeManager = this.level.getRecipeManager();

            this.recipes = recipeManager.getRecipesFor(recipeType, pContainer, this.level);
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
            var sewingStationRecipe = this.recipes.get(this.selectedRecipeIndex.get());
            this.resultContainer.setRecipeUsed(sewingStationRecipe);
            this.outputSlot.set(sewingStationRecipe.assemble(this.container, this.level.registryAccess()));
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
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            Item item = itemstack1.getItem();
            itemstack = itemstack1.copy();

            if (pIndex == SEWING_STATION_OUTPUT_SLOT_INDEX) {
                item.onCraftedBy(itemstack1, pPlayer.level(), pPlayer);
                if (!this.moveItemStackTo(itemstack1, PLAYER_EQ_FIRST_SLOT_INDEX,
                        PLAYER_TOTAL_LAST_SLOT_INDEX, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (pIndex == SEWING_STATION_INPUT_SLOT_INDEX) {
                if (!this.moveItemStackTo(itemstack1, PLAYER_EQ_FIRST_SLOT_INDEX,
                        PLAYER_TOTAL_LAST_SLOT_INDEX,
                        false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(RecipeType.STONECUTTING, new SimpleContainer(itemstack1), this.level).isPresent()) {
                if (!this.moveItemStackTo(itemstack1, SEWING_STATION_INPUT_SLOT_INDEX, SEWING_STATION_OUTPUT_SLOT_INDEX, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (pIndex >= PLAYER_EQ_FIRST_SLOT_INDEX && pIndex < PLAYER_EQ_LAST_SLOT_INDEX) {
                if (!this.moveItemStackTo(itemstack1,
                        PLAYER_EQ_LAST_SLOT_INDEX,
                        PLAYER_TOTAL_LAST_SLOT_INDEX,
                        false)) {
                    return ItemStack.EMPTY;
                }
            } else if (pIndex >= PLAYER_EQ_LAST_SLOT_INDEX && pIndex < PLAYER_TOTAL_LAST_SLOT_INDEX && !this.moveItemStackTo(itemstack1, PLAYER_EQ_FIRST_SLOT_INDEX, PLAYER_EQ_LAST_SLOT_INDEX, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(pPlayer, itemstack1);
            this.broadcastChanges();
        }

        return itemstack;
    }

    public List<SewingStationRecipe> getRecipes(){
        return recipes;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(this.access,//ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.SEWING_STATION.get());
    }

    //From StonecutterMenu.java
    @Override
    public void removed(Player pPlayer) {
        super.removed(pPlayer);
        this.resultContainer.removeItemNoUpdate(1);
        ContainerLevelAccess.create(level, blockEntity.getBlockPos()).execute((arg1, arg2) -> {
            this.clearContainer(pPlayer, this.container);
        });
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < PLAYER_EQ_ROW_COUNT; ++i) {
            for (int l = 0; l < PLAYER_EQ_COLUMN_COUNT; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < PLAYER_EQ_COLUMN_COUNT; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}