package consts.topsellerswithfilters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NarrowByPrice {
    SPECIAL_OFFERS("specials"),
    HIDE_FREE_TO_PLAY_ITEMS("hidef2p");

    public final String label;
}
