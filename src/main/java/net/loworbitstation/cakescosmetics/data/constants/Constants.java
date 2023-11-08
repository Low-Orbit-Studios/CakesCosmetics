package net.loworbitstation.cakescosmetics.data.constants;

import mezz.jei.api.constants.ModIds;
import net.minecraft.resources.ResourceLocation;

public class Constants {
    //Keywords, resource locations, ids
    /**Used as path part for serializers and recipes*/
    public static final String SEWING_SERIALIZER_PATH = "sewing";
    public static final String SEWING_STATION_PATH = "sewing_station";
    /**The keyword used in recipes to mark sewing ingredient.*/
    public static final String SEWING_STATION_INGREDIENT_KEY = "ingredient";
    /**The keyword used in recipes to mark the output of the recipe.*/
    public static final String SEWING_STATION_OUTPUT_KEY = "result";

    /**The x coord of input slot in GUI.*/
    public static final int SEWING_STATION_INPUT_SLOT_X = 20;
    /**The y coord of input slot in GUI.*/
    public static final int SEWING_STATION_INPUT_SLOT_Y = 33;
    /**The x coord of output slot in GUI.*/
    public static final int SEWING_STATION_OUTPUT_SLOT_X = 143;
    /**The y coord of output slot in GUI.*/
    public static final int SEWING_STATION_OUTPUT_SLOT_Y = 33;
    public static final ResourceLocation RECIPE_GUI_VANILLA_FROM_JEI = new ResourceLocation(ModIds.JEI_ID, "textures/gui/gui_vanilla.png");
    public static final int SEWING_STATION_INPUT_SLOT_JEI_X = 1;
    public static final int SEWING_STATION_INPUT_SLOT_JEI_Y = 9;
    public static final int SEWING_STATION_OUTPUT_SLOT_JEI_X = 61;
    public static final int SEWING_STATION_OUTPUT_SLOT_JEI_Y = 9;
    public static final String SEWING_STATION_GUI_RES_LOCATION = "textures/gui/container/stonecutter.png";

    //Data values
    public static final int ANIM_CONTROLLER_TRANSITION_LENGTH_TICKS = 20;

    /**How many fields in players hotbar.*/
    public static final int PLAYER_HOTBAR_SLOT_COUNT = 9;
    /**How many fields in player's equipment (no hotbar).*/
    public static final int PLAYER_EQ_SLOT_COUNT = 27;
    /**How many rows in player's equipment (no hotbar).*/
    public static final int PLAYER_EQ_ROW_COUNT = 3;
    /**How many columns in player's equipment (no hotbar).*/
    public static final int PLAYER_EQ_COLUMN_COUNT = 9;
    public static final int PLAYER_TOTAL_SLOT_COUNT = PLAYER_HOTBAR_SLOT_COUNT + PLAYER_EQ_SLOT_COUNT;
    public static final int PLAYER_EQ_FIRST_SLOT_INDEX = 0;
    public static final int PLAYER_TOTAL_LAST_SLOT_INDEX = PLAYER_EQ_FIRST_SLOT_INDEX + PLAYER_TOTAL_SLOT_COUNT;
    public static final int PLAYER_EQ_LAST_SLOT_INDEX = PLAYER_EQ_FIRST_SLOT_INDEX + PLAYER_EQ_SLOT_COUNT;
    public static final int PLAYER_HOTBAR_FIRST_SLOT_INDEX = PLAYER_EQ_LAST_SLOT_INDEX;
    public static final int PLAYER_HOTBAR_LAST_SLOT_INDEX = PLAYER_TOTAL_LAST_SLOT_INDEX;

    public static final int SEWING_STATION_FIRST_SLOT_INDEX = 0;
    public static final int SEWING_STATION_INPUT_SLOT_INDEX = SEWING_STATION_FIRST_SLOT_INDEX;
    public static final int SEWING_STATION_OUTPUT_SLOT_INDEX = SEWING_STATION_INPUT_SLOT_INDEX + 1;
    public static final int SEWING_STATION_SLOT_COUNT = 2;


}
