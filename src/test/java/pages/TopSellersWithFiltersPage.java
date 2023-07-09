package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.CheckBox;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import consts.AttributeAndValue;
import consts.topsellerswithfilters.BlocksOnTopSelling;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class TopSellersWithFiltersPage extends Form {
    private static final By CHECK_ELEMENT = By.id("advsearchform");
    private static final String CHECK_BOXES = "//*[contains(@class,'tab_filter_control_row') and @data-value='%s']";
    private static final String BLOCKS = "//*[contains(@class,'search_collapse_block') and @data-collapse-name='%s']";
    private static final By BUTTONS_ON_BLOCKS = By.xpath("//*[contains(@class,'block_header')]");
    private static final By BLOCKS_WITH_ITEMS = By.xpath("//*[contains(@class,'block_content')]");

    private static final By BLOCK_OF_ALL_GAMES =
            By.xpath("//*[@id='search_result_container']");

    private final ITextBox searchBoxTags = AqualityServices.getElementFactory()
            .getTextBox(By.id("TagSuggest"),"searchBoxTags");
    private final ITextBox searchBoxLanguage = AqualityServices.getElementFactory()
            .getTextBox(By.id("LanguageSuggest"),"searchBoxLanguage");
    private final ITextBox searchBoxTermOrTag = AqualityServices.getElementFactory()
            .getTextBox(By.id("term"),"searchBoxTermOrTag");
    private final IButton searchTermOrTagButton = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[contains(@class,'btnv6_blue_hoverfade')]"),"searchTermOrTagButton");
    private final IButton sortButton = AqualityServices.getElementFactory()
            .getButton(By.id("sort_by_dselect_container"),"sortButton");
    private final ILabel gameResultsSearch = AqualityServices.getElementFactory()
            .getLabel(By.xpath("//*[@id='search_results']//*[contains(@class,'search_results_count')]"),"gameResultsSearch");
    private final IButton settingsSearchButton = AqualityServices.getElementFactory()
            .getButton(By.xpath("//*[@id='search_results_filtered_warning_persistent']//*[contains(@class,'settings_tab')]"),"settingsSearchButton");
    private final TableGames gameTable = new TableGames(By.id("search_result_container"),"gameTable", ElementState.EXISTS_IN_ANY_STATE);
    private static final By BY_ALL_GAMES = By.xpath("//*[@id='search_resultsRows']//*[contains(@class,'search_result_row')]");
    private final NavBarTop navBarTop = new NavBarTop();
    private final NavBarStore navBarStore = new NavBarStore();

    public TopSellersWithFiltersPage() {
        super(CHECK_ELEMENT,"checkElementTopSellersWithFilters");
    }

    public void setTextOnSearchBoxTags(String text) {
        searchBoxTags.clearAndType(text);
    }

    public void setTextOnSearchBoxLanguage(String text) {
        searchBoxLanguage.clearAndType(text);
    }

    public void clickCheckBox(ICheckBox checkBox) {
        checkBox.click();
    }

    public void clickButton(IButton button) {
        button.click();
    }

    public void clickSearchTermOrTagButton() {
        searchTermOrTagButton.click();
    }

    public void setTextOnSearchBoxTermOrTag(String text) {
        searchBoxTermOrTag.clearAndType(text);
    }

    public void clickSortButton() {
        sortButton.click();
    }

    public String getGameResultsSearch() {
        return gameResultsSearch.getText();
    }

    public void clickSettingSearchButton() {
        settingsSearchButton.click();
    }

    public int getCountFoundGames() {
        return AqualityServices.getElementFactory().findElements(BY_ALL_GAMES, ElementType.BUTTON).size();
    }

    public void waitingGamesLoad()
    {
        AqualityServices.getConditionalWait()
                .waitFor(ExpectedConditions.stalenessOf(
                        AqualityServices.getBrowser().getDriver().findElement(BY_ALL_GAMES)));

        AqualityServices.getConditionalWait()
                .waitFor(ExpectedConditions.presenceOfElementLocated(BY_ALL_GAMES));
    }

    public void waitOpeningBlockWithItems(BlocksOnTopSelling blockName) {
        ILabel block = AqualityServices.getElementFactory()
                .getLabel(By.xpath(String.format(BLOCKS,blockName.label)), "block");
        ILabel blockWithItems = AqualityServices.getElementFactory()
                .findChildElement(block,BLOCKS_WITH_ITEMS, ElementType.LABEL);
        AqualityServices.getConditionalWait()
                .waitFor(ExpectedConditions.attributeToBe(blockWithItems.getLocator(),
                        AttributeAndValue.STYLE.label, AttributeAndValue.DISPLAY_BLOCK.label));

    }

    public boolean isBlockWithItemsDisplayed(BlocksOnTopSelling blockName) {
        ILabel block = AqualityServices.getElementFactory()
                .getLabel(By.xpath(String.format(BLOCKS,blockName.label)), "block");
        ILabel blockWithItems = AqualityServices.getElementFactory()
                .findChildElement(block,BLOCKS_WITH_ITEMS, ElementType.LABEL);
         return blockWithItems.getAttribute(AttributeAndValue.STYLE.label).contains(AttributeAndValue.DISPLAY.label);
    }

    public boolean isOpenedBlock(BlocksOnTopSelling itemBlock) {
        ILabel block = AqualityServices.getElementFactory()
                .getLabel(By.xpath(String.format(BLOCKS,itemBlock.label)), "block");
        return !block.getAttribute(AttributeAndValue.CLASS.label).contains(AttributeAndValue.COLLAPSED.label);
    }

    public boolean isCheckBoxChecked(String block, String checkBoxItem) {
        ILabel blocks = AqualityServices.getElementFactory()
                .getLabel(By.xpath(String.format(BLOCKS,block)), "block");
        CheckBox checkBox = AqualityServices.getElementFactory()
                .findChildElement(blocks,By.xpath(String.format(CHECK_BOXES,checkBoxItem)),ElementType.CHECKBOX);
        return checkBox.getAttribute(AttributeAndValue.CLASS.label).contains(AttributeAndValue.CHECKED.label);
    }

    public void clickBlock(BlocksOnTopSelling itemBlock) {
        ILabel blocks = AqualityServices.getElementFactory()
                .getLabel(By.xpath(String.format(BLOCKS,itemBlock.label)), "block");
        blocks.findChildElement(BUTTONS_ON_BLOCKS,ElementType.BUTTON).click();
    }

    public void clickCheckBox(String block, String checkBoxItem) {
        ILabel blocks = AqualityServices.getElementFactory()
                .getLabel(By.xpath(String.format(BLOCKS,block)), "block");
        CheckBox checkBox = AqualityServices.getElementFactory()
                .findChildElement(blocks,By.xpath(String.format(CHECK_BOXES,checkBoxItem)),ElementType.CHECKBOX);
        checkBox.click();
    }

    public String getTextOnCheckBox(String block, String checkBoxItem) {
        ILabel blocks = AqualityServices.getElementFactory()
                .getLabel(By.xpath(String.format(BLOCKS,block)), "block");
        CheckBox checkBox = AqualityServices.getElementFactory()
                .findChildElement(blocks,By.xpath(String.format(CHECK_BOXES,checkBoxItem)),ElementType.CHECKBOX);
        return checkBox.getAttribute(AttributeAndValue.DATA_LOC.label);
    }
}
