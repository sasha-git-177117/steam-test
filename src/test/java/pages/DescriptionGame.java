package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class DescriptionGame extends Form {
    private static final By CHECK_ELEMENT = By.id("tabletGrid");

    private final ILabel labelGameName = AqualityServices.getElementFactory()
            .getLabel(By.xpath("//*[@id='appHubAppName']"), "nameGame");
    private final ILabel labelGameDateReleased = AqualityServices.getElementFactory()
            .getLabel(By.xpath("//*[contains(@class,'release_date')]//*[contains(@class,'date')]"), "dateReleasedGame");
    private final ILabel labelGamePrice = AqualityServices.getElementFactory()
            .getLabel(By.xpath("(//*[contains(@class,'game_purchase_price')])[1]"), "priceGame");

    public DescriptionGame() {
        super(CHECK_ELEMENT, "checkElementDescriptionGame");
    }

    public String getNameGame() {
        return labelGameName.getText();
    }

    public String getDataReleasedGame() {
        return labelGameDateReleased.getText();
    }

    public String getPriceGame() {
        return labelGamePrice.getText();
    }
}
