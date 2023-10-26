package net.loworbitstation.cakescosmetics.block.entity;

import net.loworbitstation.cakescosmetics.block.ModBlocks;
import net.loworbitstation.cakescosmetics.block.custom.SewingStationBlock;
import net.loworbitstation.cakescosmetics.item.ModItems;
import net.loworbitstation.cakescosmetics.screen.SewingStationMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.loworbitstation.cakescosmetics.data.constants.Constants.SEWING_STATION_SLOT_COUNT;

public class SewingStationBlockEntity extends BlockEntity implements MenuProvider {
    public static final int INPUT_SLOT_ID = 0;
    public static final int OUTPUT_SLOT_ID = 1;
    private final String INVENTORY_TAG_KEY = "inventory";
    private final ItemStackHandler itemHandler = new ItemStackHandler(SEWING_STATION_SLOT_COUNT){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public SewingStationBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.SEWING_STATION.get(), pPos, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Sewing station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new SewingStationMenu(pContainerId, pPlayerInventory, this);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER){
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        //pTag == nbt
        pTag.put(INVENTORY_TAG_KEY, itemHandler.serializeNBT());

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        itemHandler.deserializeNBT(pTag.getCompound(INVENTORY_TAG_KEY));
    }

    public void drops(){
        var slotsCount = itemHandler.getSlots();
        var inventory = new SimpleContainer(slotsCount);
        for(int i = 0; i < slotsCount; i++){
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            pPlayer.openMenu(pState.getMenuProvider(pLevel, pPos));
            return InteractionResult.CONSUME;
        }
    }
    public static void tick(Level level, BlockPos blockPos, BlockState blockState, SewingStationBlockEntity blockEntity) {
        if(level.isClientSide()) {
            return;
        }
    }

    private static void craftItem(SewingStationBlockEntity pEntity){
        if(hasRecipe(pEntity)){
            pEntity.itemHandler.extractItem(INPUT_SLOT_ID,1, false);
            pEntity.itemHandler.setStackInSlot(OUTPUT_SLOT_ID, new ItemStack(ModItems.CAPTAINS_HAT.get()
                    , pEntity.itemHandler.getStackInSlot(OUTPUT_SLOT_ID).getCount() + 1));
            //WILL HAVE TO CHANGE LATER PROBABLY
        }
    }
    private static boolean hasRecipe(SewingStationBlockEntity pEntity){
        var inventorySlots = pEntity.itemHandler.getSlots();
        var inventory = new SimpleContainer(inventorySlots);
        for(int i = 0; i < inventorySlots; i++){
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        var hasTemplateItemInSlot = pEntity.itemHandler.getStackInSlot(1).getItem() == ModItems.COSMETICS_TEMPLATE.get();

        return hasTemplateItemInSlot;
    }
}
