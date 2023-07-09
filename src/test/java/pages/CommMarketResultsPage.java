package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

public class CommMarketResultsPage extends Form {
    private static final By CHECK_ELEMENT = By.id("searchResultsRows");
    private final String FILTERS = "//*[contains(@class,'market_searchedForTerm') and contains(.,'%s')]";
    private static final By DELETE_BUTTON_FILTER = By.xpath("//*[contains(@class,'removeIcon')]");
    private static final By RESULT_ITEMS = By.xpath("//*[contains(@class,'market_listing_row_link')]");
    private static final By RESULT_ITEM_NAME = By.xpath("//*[contains(@class,'market_listing_item_name') and contains(@id,'result')]");
    private static List<IButton> items = new ArrayList<>();

    public CommMarketResultsPage() {
        super(CHECK_ELEMENT, "checkElementCommMarketResults");
    }

    public String getTextItemByIndex(int number) {
        items = AqualityServices.getElementFactory().findElements(RESULT_ITEMS, ElementType.BUTTON);
        return items.get(number-1).findChildElement(RESULT_ITEM_NAME,ElementType.LABEL).getText();
    }

    public List<String> getTextAllItems() {
        items = AqualityServices.getElementFactory().findElements(RESULT_ITEMS, ElementType.BUTTON);
        List<String> names = new ArrayList<>();
        for (IButton item : items) {
            names.add(item.findChildElement(RESULT_ITEM_NAME, ElementType.LABEL).getText());
        }
        return names;
    }

    public void deleteFilter(String filter) {
        IButton filterButton = AqualityServices.getElementFactory().getButton(By.xpath(String.format(this.FILTERS,filter)),"filter");
        IButton deleteFilterButton = filterButton.findChildElement(DELETE_BUTTON_FILTER,"deleteButton", ElementType.BUTTON);
        deleteFilterButton.click();
    }

    public void clickItemByNumber(int number){
        items = AqualityServices.getElementFactory().findElements(RESULT_ITEMS, ElementType.BUTTON);
        items.get(number-1).click();
    }

    public boolean isFilterDisplayed(String filter) {
        return AqualityServices.getElementFactory().getButton(By.xpath(String.format(FILTERS,filter)),"filter")
                .state().isDisplayed();
    }
}
