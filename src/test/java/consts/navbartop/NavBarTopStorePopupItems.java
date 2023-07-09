package consts.navbartop;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NavBarTopStorePopupItems {
    HOME_ITEM("Home"),
    DISCOVERY_QUEUE_ITEM("Discovery queue"),
    WISHLIST_ITEM("Wishlist"),
    POINTS_SHOP_ITEM("Points Shop"),
    NEWS_ITEM("News"),
    STATS_ITEM("Stats");

    public final String label;
}
