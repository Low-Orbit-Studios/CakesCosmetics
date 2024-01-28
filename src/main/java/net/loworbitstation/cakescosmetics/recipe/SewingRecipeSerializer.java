package net.loworbitstation.cakescosmetics.recipe;

import com.google.gson.JsonObject;
import net.loworbitstation.cakescosmetics.CakesCosmetics;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import static net.loworbitstation.cakescosmetics.data.constants.Constants.*;

public class SewingRecipeSerializer implements RecipeSerializer<SewingStationRecipe> {
    public static final SewingRecipeSerializer INSTANCE = new SewingRecipeSerializer();
    public static final ResourceLocation GROUP_ID =
            new ResourceLocation(CakesCosmetics.MOD_ID, SEWING_SERIALIZER_PATH);

    @Override
    public SewingStationRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
        var outputKey = GsonHelper.getAsString(pSerializedRecipe, SEWING_STATION_OUTPUT_KEY);
        var resourceLocation = new ResourceLocation(outputKey);
        ItemStack output = new ItemStack(ForgeRegistries.ITEMS.getValue(resourceLocation), 1);

        var ingredientJSONObj = GsonHelper.getAsJsonObject(pSerializedRecipe, SEWING_STATION_INGREDIENT_KEY);

        var input = Ingredient.fromJson(ingredientJSONObj);

        return new SewingStationRecipe(pRecipeId, GROUP_ID.toString(), input, output);
    }
    //order and amount of fields in fromNetwork and toNetwork have to match!!
    @Override
    public @Nullable SewingStationRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);

        //We expect only 1 input.
        inputs.set(0, Ingredient.fromNetwork(pBuffer));

        ItemStack output = pBuffer.readItem();
        return new SewingStationRecipe(pRecipeId, GROUP_ID.toString(), inputs.get(0), output);
    }

    //order and amount of fields in fromNetwork and toNetwork have to match!!
    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, SewingStationRecipe pRecipe) {
        pBuffer.writeInt(pRecipe.getIngredients().size());

        //We expect only 1 input.
        var ingredients = pRecipe.getIngredients();
        ingredients.get(0).toNetwork(pBuffer);

        pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
    }
}
