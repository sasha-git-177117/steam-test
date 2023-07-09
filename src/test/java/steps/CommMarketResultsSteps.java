package steps;

import java.util.List;

public class CommMarketResultsSteps {

    public static boolean isItemsNameContainsText(int countItems, List<String> names, String searchText) {
        for(int i = 0; i < countItems; i++) {
            if(!names.get(i).contains(searchText)) return false;
        }
        return true;
    }

}
