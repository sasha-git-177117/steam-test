package consts.topsellerswithfilters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SortCombobox {
    RELEVANCE("_ASC"),
    RELEASE_DATA("Released_DESC"),
    NAME("Name_ASC"),
    LOWEST_PRICE("Price_ASC"),
    HIGHEST_PRICE("Price_DESC"),
    USER_REVIEWS("Reviews_DESC"),
    STEAM_DESK("Reviews_DESC");

    public final String label;
}
