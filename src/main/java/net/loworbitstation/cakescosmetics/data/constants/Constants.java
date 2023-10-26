package net.loworbitstation.cakescosmetics.data.constants;

public class Constants {
    public static final int ANIM_CONTROLLER_TRANSITION_LENGTH_TICKS = 20;

    /**How many fields in players hotbar.*/
    public static final int PLAYER_HOTBAR_SLOT_COUNT = 9;
    /**How many fields in player's equipment (no hotbar).*/
    public static final int PLAYER_EQ_SLOT_COUNT = 27;
    /**How many rows in player's equipment (no hotbar).*/
    public static final int PLAYER_EQ_ROW_COUNT = 3;
    /**How many columns in player's equipment (no hotbar).*/
    public static final int PLAYER_EQ_COLUMN_COUNT = 3;
    public static final int PLAYER_TOTAL_SLOT_COUNT = PLAYER_HOTBAR_SLOT_COUNT + PLAYER_EQ_SLOT_COUNT;
    public static final int PLAYER_EQ_FIRST_SLOT_INDEX = 0;
    public static final int PLAYER_TOTAL_LAST_SLOT_INDEX = PLAYER_EQ_FIRST_SLOT_INDEX + PLAYER_TOTAL_SLOT_COUNT;
    public static final int PLAYER_EQ_LAST_SLOT_INDEX = PLAYER_EQ_FIRST_SLOT_INDEX + PLAYER_EQ_SLOT_COUNT;
    public static final int PLAYER_HOTBAR_FIRST_SLOT_INDEX = PLAYER_EQ_LAST_SLOT_INDEX;
    public static final int PLAYER_HOTBAR_LAST_SLOT_INDEX = PLAYER_TOTAL_LAST_SLOT_INDEX;

    public static final int SEWING_STATION_FIRST_SLOT_INDEX = PLAYER_TOTAL_LAST_SLOT_INDEX;
    public static final int SEWING_STATION_INPUT_SLOT_INDEX = SEWING_STATION_FIRST_SLOT_INDEX;
    public static final int SEWING_STATION_OUTPUT_SLOT_INDEX = SEWING_STATION_INPUT_SLOT_INDEX + 1;
    public static final int SEWING_STATION_SLOT_COUNT = 2;


}
