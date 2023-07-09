package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AboutPage extends Form {
    private static final By CHECK_ELEMENT = By.id("about_header_area");

    private final ILabel gamersOnlineLabel = AqualityServices.getElementFactory()
            .getLabel(By.xpath("(//*[contains(@class,'gamers_online')]//parent::node())[1]"), "gamersOnlineLabel");
    private final ILabel gamersInGameLabel = AqualityServices.getElementFactory()
            .getLabel(By.xpath("(//*[contains(@class,'gamers_in_game')]//parent::node())[1]"), "gamersInGameLabel");

    public AboutPage() {
        super(CHECK_ELEMENT, "checkElementAboutPage");
    }

    public String getCountGamersOnline() {
        return gamersOnlineLabel.getText();
    }

    public String getCountGamersInGame() {
        return gamersInGameLabel.getText();
    }
}
