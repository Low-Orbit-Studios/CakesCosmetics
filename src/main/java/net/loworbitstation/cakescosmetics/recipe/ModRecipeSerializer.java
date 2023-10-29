package net.loworbitstation.cakescosmetics.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import org.jetbrains.annotations.Nullable;

public class ModRecipeSerializer implements RecipeSerializer<SewingStationRecipe> {
    public static final ModRecipeSerializer INSTANCE = new ModRecipeSerializer();
    public static final ResourceLocation ID =
            new ResourceLocation(CakesCosmetics.MOD_ID, "sewing");

    @Override
    public SewingStationRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
        ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));

        JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");

        var input = Ingredient.fromJson(ingredients.get(0));

        return new SewingStationRecipe(ID, pRecipeId, input, output);
    }

    @Override
    public @Nullable SewingStationRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        return null;
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, SewingStationRecipe pRecipe) {

    }
}
