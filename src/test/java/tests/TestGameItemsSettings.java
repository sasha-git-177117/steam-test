package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import consts.DataTest;
import consts.navbartop.NavBarTopCommunityPopupItems;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommMarketResultsPage;
import pages.CommunityMarketPage;
import pages.DescriptionItem;
import pages.FormSearchCommMarket;
import steps.CommMarketResultsSteps;

import java.util.List;

public class TestGameItemsSettings extends BaseTest{
    @Test
    public void testGameItemsSettings() {
        Logger log = AqualityServices.getLogger();
        ISettingsFile environment = new JsonSettingsFile(DataTest.FILE_PATH.label);
        String hero = environment.getValue(DataTest.HERO_FILTER.label).toString();
        String searchItem = environment.getValue(DataTest.SEARCH_ITEM_FILTER.label).toString();
        String rarity = environment.getValue(DataTest.RARITY_FILTER.label).toString();
        String game = environment.getValue(DataTest.GAME_FILTER.label).toString();
        String searchTextInItemName = environment.getValue(DataTest.SEARCH_TEXT_IN_ITEM_NAME.label).toString();
        int numberItem = Integer.parseInt(environment.getValue(DataTest.NUMBER_ITEM.label).toString());
        int countSelectGame = Integer.parseInt(environment.getValue(DataTest.COUNT_SELECT_GAME.label).toString());

        log.info("Шаг 2 - Открытие страницы Community Market (COMMUNITY -> MARKET)");
        mainPage.getNavBar().clickPopupItemFromCommunity(NavBarTopCommunityPopupItems.MARKET);
        CommunityMarketPage communityMarketPage = new CommunityMarketPage();
        Assert.assertTrue(communityMarketPage.state().waitForDisplayed(),"Не удалось открыть страницу CommunityMarket");

        log.info("Шаг 3 - Открытие формы настройки поиска по торговой площадке (Show advanced options...)");
        communityMarketPage.clickShowAdvancedOptions();
        FormSearchCommMarket formSearchCommMarket = communityMarketPage.getFormSearchCommunityMarket();
        Assert.assertTrue(formSearchCommMarket.state().waitForDisplayed(),"Не удалось открыть formSearchCommMarket");

        log.info("Шаг 4 - Выбор следующие параметры для поиска: Game - Dota 2, hero -  Lifestealer, Rarity - Immortal, Search - golden");
        formSearchCommMarket.clickSelectGame();
        formSearchCommMarket.clickDota2();
        formSearchCommMarket.clickHero(hero);
        formSearchCommMarket.clickCheckBoxImmortal();
        formSearchCommMarket.setTextInSearchBox(searchItem);

        log.info("Шаг 5 - Нажатие кнопка 'Search'");
        formSearchCommMarket.clickSearchButton();

        CommMarketResultsPage commMarketResultsPage = new CommMarketResultsPage();
        Assert.assertTrue(commMarketResultsPage.state().waitForDisplayed(),"Не удалось открыть страницу игр по фильтрам");
        Assert.assertTrue(commMarketResultsPage.isFilterDisplayed(game),"фильтр "+ game+ " не найден");
        Assert.assertTrue(commMarketResultsPage.isFilterDisplayed(hero),"фильтр "+ hero+ " не найден");
        Assert.assertTrue(commMarketResultsPage.isFilterDisplayed(rarity),"фильтр "+ rarity+ " не найден");
        Assert.assertTrue(commMarketResultsPage.isFilterDisplayed(searchItem),"фильтр "+ searchItem+ " не найден");

        List<String> itemNames = commMarketResultsPage.getTextAllItems();
        Assert.assertTrue(CommMarketResultsSteps.isItemsNameContainsText(countSelectGame,itemNames,searchTextInItemName),
                "Первые 5 элементов не содержат в имени "+searchTextInItemName);

        log.info("Шаг 6 - Удаление фильтров 'golden' и 'Immortal'");
        commMarketResultsPage.deleteFilter(searchItem);
        commMarketResultsPage.deleteFilter(rarity);
        List<String> itemNamesAfterDeleteFilters = commMarketResultsPage.getTextAllItems();
        Assert.assertNotEquals(itemNames,itemNamesAfterDeleteFilters,"Элементы не обновились");

        log.info("Шаг 7 - Переход на страницу первого предмета списка");
        commMarketResultsPage.clickItemByNumber(numberItem);
        DescriptionItem descriptionItem = new DescriptionItem();
        Assert.assertTrue(descriptionItem.state().waitForDisplayed(),"Страница описания игры не открылась");

        Assert.assertEquals(itemNamesAfterDeleteFilters.get(numberItem-1),descriptionItem.getItemName(),
                "Название первого элемента со страницы элементов не соответствует нажатому элементу");
        Assert.assertTrue(descriptionItem.getGameName().contains(game),
                "Фильтр "+game+" отсутствует на странице описания предмета");
        Assert.assertTrue(descriptionItem.getDescriptor().contains(hero),
                "Фильтр "+hero+" отсутствует на странице описания предмета");

    }
}
