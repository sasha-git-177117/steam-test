package consts.topsellerswithfilters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NarrowByNumberOfPlayers {
    SINGLE_PLAYER("2"),
    MULTI_PLAYER("1"),
    PVP("49"),
    ONLINE_PVP("36"),
    LAN_PVP("47"),
    SHARED_SPLIT_SCREEN_PVP("37"),
    CO_OP("9"),
    ONLINE_CO_OP("38"),
    LAN_CO_OP("48"),
    SHARED_SPLIT_SCREEN_CO_OP("39"),
    SHARED_SPLIT_SCREEN("24"),
    CROSS_PLATFORM_MULTIPLAYER("27");

    public final String label;
}
