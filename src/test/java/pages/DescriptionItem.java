package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class DescriptionItem extends Form {
    private static final By CHECK_ELEMENT = By.xpath("//*[contains(@class,'market_listing_iteminfo')]");

    private final ILabel gameName = AqualityServices.getElementFactory()
            .getLabel(By.id("largeiteminfo_game_name"),"itemType");
    private final ILabel itemName = AqualityServices.getElementFactory()
            .getLabel(By.id("largeiteminfo_item_name"),"itemName");
    private final ILabel descriptor = AqualityServices.getElementFactory()
            .getLabel(By.xpath("//*[contains(@class,'item_desc_descriptors')]//*[contains(@class,'descriptor')][1]"),"descriptor");

    public DescriptionItem() {
        super(CHECK_ELEMENT,"checkElementDecrItem");
    }

    public String getGameName() {
        return gameName.getText();
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getDescriptor() {
        return descriptor.getText();
    }
}
