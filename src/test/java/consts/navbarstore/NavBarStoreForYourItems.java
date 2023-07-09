package consts.navbarstore;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NavBarStoreForYourItems {
    HOME_ITEM("store"),
    COMMUNITY_RECOMMENDATIONS_ITEM("communityrecommendations"),
    RECENTLY_VIEWED_ITEM("recommended"),
    STEAM_CURATORS_ITEM("curators"),
    NEWS_ITEM_ITEM("News");

    public final String label;
}
