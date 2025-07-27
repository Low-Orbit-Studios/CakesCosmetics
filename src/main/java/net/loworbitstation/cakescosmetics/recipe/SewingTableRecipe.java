package net.loworbitstation.cakescosmetics.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault

public record SewingTableRecipe(Ingredient inputItem, ItemStack output) implements Recipe<SewingTableRecipeInput> {

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(SewingTableRecipeInput sewingTableRecipeInput, Level level) {
//        if(level.isClientSide()) {
//            return false;
//        }

        return inputItem.test(sewingTableRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(SewingTableRecipeInput sewingTableRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return false;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.SEWING_TABLE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.SEWING_TABLE_TYPE.get();
    }


    public static class Serializer implements RecipeSerializer<SewingTableRecipe> {
        public static final MapCodec<SewingTableRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(SewingTableRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(SewingTableRecipe::output)
        ).apply(inst, SewingTableRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, SewingTableRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC, SewingTableRecipe::inputItem,
                    ItemStack.STREAM_CODEC, SewingTableRecipe::output,
                    SewingTableRecipe::new);

        @Override
        public MapCodec<SewingTableRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, SewingTableRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
