package consts.topsellerswithfilters;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NarrowByLanguage {
    SIMPLIFIED_CHINESE("schinese"),
    TRADITIONAL_CHINESE("tchinese"),
    KOREANA("koreana"),
    THAI("thai"),
    BULGARIAN("bulgarian"),
    CZECH("czech"),
    DANISH("danish"),
    GERMAN("german"),
    ENGLISH("english"),
    SPANISH("spanish"),
    LATAM("latam"),
    GREEK("greek"),
    FRENCH("french"),
    ITALIAN("italian"),
    HUNGARIAN("hungarian");

    public final String label;
}
