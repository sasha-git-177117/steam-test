package consts.topsellerswithfilters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BlocksOnTopSelling {
    NARROW_BY_BLOCK_SELECTED_TYPES("category1"),
    NARROW_BY_OF_NUMBER_PLAYERS("category3"),
    NARROW_BY_FEATURE("category2"),
    NARROW_BY_DECK_COMPATIBILITY("deck_compatibility"),
    NARROW_BY_VR_SUPPORT("vrsupport"),
    NARROW_BY_PRICE("price"),
    NARROW_BY_TAG("tags"),
    NARROW_BY_OS("os"),
    NARROW_BY_LANGUAGE("language");

    public final String label;
}
