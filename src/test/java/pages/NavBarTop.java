package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import consts.navbartop.NavBarTopCommunityPopupItems;
import consts.navbartop.NavBarTopLanguagePopupItems;
import consts.navbartop.NavBarTopStorePopupItems;
import org.openqa.selenium.By;

public class NavBarTop extends Form {
    private static final By CHECK_ELEMENT = By.id("global_header");

    private static final By BY_POPUP_LIST_STORE = By.xpath("//*[contains(@class,'supernav_container')]//*[@data-submenuid='store']");
    private static final By BY_POPUP_LIST_COMMUNITY = By.xpath("//*[contains(@class,'supernav_container')]//*[@data-submenuid='community']");
    private static final String BY_POPUP_ITEM = "//*[text()='%s']";
    private static final String POPUP_ITEMS_LANGUAGE = "//*[contains(@onclick,'%s')]";

    private final IButton aboutButton = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[contains(@class,'supernav_container')]//*[contains(@class,'menuitem') and contains(text(),'ABOUT')]"),"aboutButton");
    private final IButton storeButton = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[contains(@class,'supernav_container')]//*[contains(@class,'menuitem') and contains(text(),'STORE')]"),"storeButton");
    private final IButton communityButton = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[contains(@class,'supernav_container')]//*[contains(@class,'menuitem') and contains(text(),'COMMUNITY')]"),"communityButton");
    private final IButton supportButton = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[contains(@class,'supernav_container')]//*[contains(@class,'menuitem') and contains(text(),'SUPPORT')]"),"supportButton");
    private final IButton logo = AqualityServices.getElementFactory()
            .getButton(By.id("logo_holder"),"logo");
    private final IButton login = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[contains(@class,'global_action_link') and (text()='login') or (text()='войти')]"),"login");
    private final IButton language = AqualityServices.getElementFactory()
            .getButton(By.id("language_pulldown"),"language");

    public NavBarTop() {
        super(CHECK_ELEMENT,"checkElementNavBarTop");
    }

    public void clickButtonPopup(IButton button) {
        button.click();
    }

    public void moveMouseStoreBtn() {
        storeButton.getMouseActions().moveMouseToElement();
    }

    public void moveMouseCommunityBtn() {
        communityButton.getMouseActions().moveMouseToElement();
    }

    public void clickAbout() {
        aboutButton.click();
    }

    public void clickStore() {
        storeButton.click();
    }

    public void clickCommunity() {
        communityButton.click();
    }

    public void clickSupport() {
        storeButton.click();
    }

    public void clickLogo() {
        logo.click();
    }

    public void clickLogin() {
        login.click();
    }

    public void clickLanguage() {
        language.click();
    }

    public void clickPopupItemFromStore(NavBarTopStorePopupItems item) {
        moveMouseStoreBtn();
        IButton list = AqualityServices.getElementFactory().getButton(BY_POPUP_LIST_STORE, "popupListStore");
        IButton storeItem = AqualityServices.getElementFactory()
                .findChildElement(list,By.xpath(String.format(BY_POPUP_ITEM,item.label)), ElementType.BUTTON);
        storeItem.state().waitForClickable();
        storeItem.click();
    }

    public void clickPopupItemFromCommunity(NavBarTopCommunityPopupItems item) {
        moveMouseCommunityBtn();
        IButton list = AqualityServices.getElementFactory().getButton(BY_POPUP_LIST_COMMUNITY, "popupListComm");
        IButton storeItem = AqualityServices.getElementFactory()
                .findChildElement(list,By.xpath(String.format(BY_POPUP_ITEM,item.label)), ElementType.BUTTON);
        storeItem.state().waitForClickable();
        storeItem.click();
    }

    public void changeLanguage(NavBarTopLanguagePopupItems item) {
        IButton langItem = AqualityServices.getElementFactory()
                .getButton(By.xpath(String.format(POPUP_ITEMS_LANGUAGE,item.label)),"langButton");
        langItem.state().waitForClickable();
        langItem.click();
    }
}
