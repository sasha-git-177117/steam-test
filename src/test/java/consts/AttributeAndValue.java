package consts;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AttributeAndValue {
    STYLE("style"),
    CLASS("class"),
    CHECKED("checked"),
    DISPLAY("display"),
    DISPLAY_BLOCK("display: block;"),
    WIN("win"),
    MAC("mac"),
    LINUX("linux"),
    MIXED("mixed"),
    POSITIVE("positive"),
    DATA_LOC("data-loc"),
    COLLAPSED("collapsed");

    public final String label;
}
