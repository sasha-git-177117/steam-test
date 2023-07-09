package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameInfo {
    private String srcImg;
    private String gameName;
    private String dataReleased;
    private String review;
    private String discount;
    private String price;
    private List<String> platforms;
}
