package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import consts.navbarstore.NavBarStoreCategory;
import consts.navbarstore.NavBarStoreForYourItems;
import consts.navbarstore.NavBarStoreNoteworthyItems;
import org.openqa.selenium.By;

public class NavBarStore extends Form {
    private static final By CHECK_ELEMENT = By.xpath("//*[contains(@class,'store_nav_bg')]//*[contains(@class,'store_nav')]");

    private static final String POPUP_ITEMS_FOR_YOUR = "//*[@id='foryou_flyout']//*[contains(@href,'%s')]";
    private static final String POPUP_ITEMS_NOTEWORTHY_ITEMS ="//*[@id='noteworthy_flyout']//*[contains(@href,'%s')]";
    private static final String POPUP_ITEMS_CATEGORY = "//*[@id='genre_flyout']//*[contains(@href,'%s')]";

    private final IButton noteworthyTab = AqualityServices.getElementFactory()
            .getButton(By.id("noteworthy_tab"),"noteworthyTab");
    private final IButton yourStoreTab = AqualityServices.getElementFactory()
            .getButton(By.id("foryou_tab"), "yourStoreBtn");
    private final IButton categoryTab = AqualityServices.getElementFactory()
            .getButton(By.id("genre_tab"),"categoryTab");
    private final IButton pointsShopBtn = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[contains(@class,'store_nav' )]//*[contains(@class,'tab' ) and contains(@href,'points')]"),"pointsShopBtn");
    private final IButton newsButton = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[contains(@class,'store_nav' )]//*[contains(@class,'tab' ) and contains(@href,'news')]"),"newsButton");
    private final IButton labsButton = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[contains(@class,'store_nav' )]//*[contains(@class,'tab' ) and contains(@href,'labs')]"), "labsButton");
    private final ITextBox searchBox = AqualityServices.getElementFactory()
            .getTextBox(By.id("store_nav_search_term"),"searchBox");
    private final IButton searchButton = AqualityServices.getElementFactory()
            .getButton(By.id("store_search_link"),"searchButton");

    public NavBarStore() {
        super(CHECK_ELEMENT,"checkElementNavBarStore");
    }

    public void moveMouseYourStore() {
        yourStoreTab.getMouseActions().moveMouseToElement();
    }

    public void moveMouseNoteworthy() {
        noteworthyTab.getMouseActions().moveMouseToElement();
    }

    public void moveMouseCategory() {
        categoryTab.getMouseActions().moveMouseToElement();
    }

    public void clickPointsShop() {
        pointsShopBtn.click();
    }

    public void clickNews() {
        newsButton.click();
    }

    public void clickLabs() {
        labsButton.click();
    }

    public void clickPopupItem(IButton button) {
        button.click();
    }

    public void setTextInSearchBox(String text) {
        searchBox.clearAndType(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickPopupItemFromForYour(NavBarStoreForYourItems item) {
        moveMouseYourStore();
        IButton yourItem = AqualityServices.getElementFactory()
                .getButton(By.xpath(String.format(POPUP_ITEMS_FOR_YOUR,item.label)),"yourItem" + item.label);
        yourItem.state().waitForClickable();
        yourItem.click();
    }

    public void clickPopupItemFromNoteworthy(NavBarStoreNoteworthyItems item) {
        moveMouseNoteworthy();
        IButton noteworthyItem = AqualityServices.getElementFactory()
                .getButton(By.xpath(String.format(POPUP_ITEMS_NOTEWORTHY_ITEMS,item.label)),"noteworthy" + item.label);
        noteworthyItem.state().waitForClickable();
        noteworthyItem.click();
    }

    public void clickPopupItemFromCategory(NavBarStoreCategory item) {
        moveMouseCategory();
        IButton categoryItem = AqualityServices.getElementFactory()
                .getButton(By.xpath(String.format(POPUP_ITEMS_CATEGORY,item.label)),"category" + item.label);
        categoryItem.state().waitForClickable();
        categoryItem.click();
    }
}
