package consts.topsellerswithfilters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NarrowByFeature {
    PLAYED_WITH_STEAM_CONTROLLER("601"),
    ADDITIONAL_HIGH_QUALITY_AUDIO("50"),
    STEAM_ACHIEVEMENTS("22"),
    FULL_CONTROLLER_SUPPORT("28"),
    TRACKED_CONTROLLER_SUPPORT("52"),
    STEAM_TRADING_CARDS("29"),
    CAPTIONS_AVAILABLE("13"),
    STEAM_WORKSHOP("51"),
    STEAM_VR_COLLECTIBLES("40"),
    PARTIAL_CONTROLLER_SUPPORT("18"),
    STEAM_CLOUD("23"),
    VALVE_ANTI_CHEAT_ENABLED("8"),
    INCLUDES_SOURCE_SDK("16"),
    REMOTE_PLAY_ON_PHONE("41"),
    REMOTE_PLAY_ON_TABLET("42"),
    REMOTE_PLAY_ON_TV("43"),
    REMOTE_PLAY_TOGETHER("44");

    public final String label;
}
