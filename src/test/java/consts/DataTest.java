package consts;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DataTest {
    FILE_PATH("dataTest.json"),
    HERO_FILTER("/heroFilter"),
    SEARCH_ITEM_FILTER("/searchItemFilter"),
    RARITY_FILTER("/rarityFilter"),
    GAME_FILTER("/gameFilter"),
    SEARCH_TEXT_IN_ITEM_NAME("/searchTextInItemName"),
    NUMBER_ITEM("/numberItem"),
    NUMBER_GAME("/numberGame"),
    COUNT_SELECT_GAME("/countSelectGame");

    public final String label;
}
