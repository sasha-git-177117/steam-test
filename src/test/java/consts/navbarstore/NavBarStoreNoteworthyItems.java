package consts.navbarstore;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NavBarStoreNoteworthyItems {
    STEAM_REPLAY("replay"),
    TOP_SELLERS("topselling"),
    MOST_PLAYED("mostplayed"),
    NEW_AND_TRENDING("new"),
    SPECIAL_OFFERS("specials"),
    RECENTLY_UPDATED("newshub"),
    POPULAR_UPCOMING("upcoming");

    public final String label;
}
