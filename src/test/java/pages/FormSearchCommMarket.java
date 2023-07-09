package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FormSearchCommMarket extends Form {
    private static final By CHECK_ELEMENT = By.xpath("//*[contains(@class,'newmodal_background')]");

    private final IButton buttonSelectGames = AqualityServices.getElementFactory()
            .getButton(By.id("market_advancedsearch_appselect_activeapp"), "buttonAllGames");
    private final IButton buttonDota2 = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[@id='market_advancedsearch_appselect_options_apps']//*[contains(text(),'Dota 2')]"),"buttonDota2");
    private final IComboBox comboboxHero = AqualityServices.getElementFactory()
            .getComboBox(By.xpath("//select[contains(@name,'Hero')]"),"comboboxHero");
    private final ICheckBox checkboxImmortal = AqualityServices.getElementFactory()
            .getCheckBox(By.xpath("//*[contains(@id,'Rarity_Rarity_Immortal')]"),"checkboxImmortal");
    private final ITextBox searchBox = AqualityServices.getElementFactory()
            .getTextBox(By.id("advancedSearchBox"),"searchBox");
    private final IButton searchButton = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[contains(@class,'market_advancedsearch_bottombuttons')]//*[contains(text(),'Поиск') or contains(text(),'Search')]"),"searchButton");

    public FormSearchCommMarket() {
        super(CHECK_ELEMENT, "checkElementFormSearchCommMarket");
    }

    public void clickSelectGame() {
        buttonSelectGames.click();
    }

    public void clickDota2() {
        buttonDota2.click();
    }

    public void clickHero(String text) {
        comboboxHero.clickAndSelectByText(text);
    }

    public void clickCheckBoxImmortal() {
        checkboxImmortal.check();
    }

    public void setTextInSearchBox(String text) {
        searchBox.clearAndType(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
