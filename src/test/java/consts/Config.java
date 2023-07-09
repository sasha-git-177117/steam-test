package consts;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Config {
    BASE_URL("/baseURL"),
    FILE_PATH("config.json");
    public final String label;
}
