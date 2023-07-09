package consts.topsellerswithfilters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NarrowByOS {
    WINDOWS("win"),
    MAC_OS("macOS"),
    STEAM_OS_AND_LINUX("linux");
    public final String label;
}
