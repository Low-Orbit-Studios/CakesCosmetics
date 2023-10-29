package net.loworbitstation.cakescosmetics.screen;

import com.google.common.collect.Lists;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.loworbitstation.cakescosmetics.block.ModBlocks;
import net.loworbitstation.cakescosmetics.block.entity.SewingStationBlockEntity;
import net.loworbitstation.cakescosmetics.recipe.ModRecipeType;
import net.loworbitstation.cakescosmetics.recipe.SewingStationRecipe;
import net.minecraft.network.FriendlyByteBuf;
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


public class SewingStationMenu extends AbstractContainerMenu {
    private static final int INV_SLOT_START = 2;
    private static final int INV_SLOT_END = 29;
    private static final int USE_ROW_SLOT_START = 29;
    private static final int USE_ROW_SLOT_END = 38;

    private Slot inputSlot;
    private Slot outputSlot;

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
        this(pContainerId, pPlayerInventory, pPlayerInventory.player.level.getBlockEntity(extraData.readBlockPos()));
    }

    public SewingStationMenu(int pContainerId, Inventory pPlayerInventory, BlockEntity entity) {
        super(ModMenuTypes.SEWING_STATION_MENU.get(), pContainerId);
        checkContainerSize(pPlayerInventory, SEWING_STATION_SLOT_COUNT);
        blockEntity = (SewingStationBlockEntity) entity;
        this.level = pPlayerInventory.player.level;

        addPlayerInventory(pPlayerInventory);
        addPlayerHotbar(pPlayerInventory);

        var itemHandlerCapability = this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER);
        if(itemHandlerCapability.isPresent()){
            //Position values akin to Stonecutter's.
            inputSlot = this.addSlot(new Slot(this.container, SEWING_STATION_INPUT_SLOT_INDEX,20, 33));
            outputSlot = this.addSlot(new Slot(this.resultContainer, SEWING_STATION_OUTPUT_SLOT_INDEX,143, 33));
        }
        else{
            CakesCosmetics.LOGGER.error("No item handler capability found upon creating Sewing Station Menu!");
        }

        addDataSlot(selectedRecipeIndex);
    }

    //From StonecutterMenu.java
    private void setupRecipeList(Container pContainer, ItemStack pStack) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.outputSlot.set(ItemStack.EMPTY);
        if (!pStack.isEmpty()) {
            this.recipes = this.level.getRecipeManager().getRecipesFor(ModRecipeType.SEWING, pContainer, this.level);
        }

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
                item.onCraftedBy(itemstack1, pPlayer.level, pPlayer);
                if (!this.moveItemStackTo(itemstack1, PLAYER_EQ_FIRST_SLOT_INDEX,
                        PLAYER_TOTAL_LAST_SLOT_INDEX, true)) {
                    return ItemStack.EMPTY;
                }
                //TODO Setup indices for slots. Unify them. https://youtu.be/jo0BTisGpJk?list=PLKGarocXCE1HrC60yuTNTGRoZc6hf5Uvl&t=1716
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

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.SEWING_STATION.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }
}
