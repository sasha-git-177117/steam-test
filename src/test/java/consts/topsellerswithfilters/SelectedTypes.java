package consts.topsellerswithfilters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SelectedTypes {
    GAMES("998"),
    SOFTWARE("994"),
    DOWNLOADABLE_CONTENT("21"),
    DEMOS("10"),
    SOUNDTRACKS("990"),
    PLAYTESTS("989"),
    VIDEOS("992"),
    MODS("997"),
    HARDWARE("993"),
    INCLUDE_BUNDLES("996");

    public final String label;
}
