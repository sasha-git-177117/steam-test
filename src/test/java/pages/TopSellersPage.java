package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class TopSellersPage extends Form {
    private static final By CHECK_ELEMENT = By.xpath("//*[contains(@class,'DialogButton')]");

    private final IButton buttonMoreTopSellers = AqualityServices
            .getElementFactory().getButton(By.xpath("//*[contains(@class,'DialogButton')]"),"moreTopSellersButton");

    public TopSellersPage() {
        super(CHECK_ELEMENT, "checkElementTopSallersPage");
    }

    public void clickBrowseMoreTopSellers() {
        buttonMoreTopSellers.click();
    }
}
