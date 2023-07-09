package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class CommunityMarketPage extends Form {
    private static final By CHECK_ELEMENT = By.id("BG_top");

    private final FormSearchCommMarket formSearchCommunityMarket = new FormSearchCommMarket();
    private final IButton buttonShowAdvancedOptions = AqualityServices.getElementFactory()
            .getButton(By.id("market_search_advanced_show"), "showAdvancedOptionsButton");

    public CommunityMarketPage() {
        super(CHECK_ELEMENT, "checkElementCommMarketPage");
    }

    public void clickShowAdvancedOptions() {
        buttonShowAdvancedOptions.click();
    }

}
