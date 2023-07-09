package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import consts.DataTest;
import models.GameInfo;
import consts.navbarstore.NavBarStoreNoteworthyItems;
import consts.topsellerswithfilters.NarrowByNumberOfPlayers;
import consts.topsellerswithfilters.NarrowByOS;
import consts.topsellerswithfilters.NarrowByTags;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DescriptionGame;
import pages.TopSellersPage;
import pages.TopSellersWithFiltersPage;
import steps.TopSellersWithFiltersPageSteps;
import utils.StringUtil;

public class TestGameSettings extends BaseTest {
    @Test
    public void testGameSettings() {
        Logger log = AqualityServices.getLogger();
        ISettingsFile environment = new JsonSettingsFile(DataTest.FILE_PATH.label);
        int numberGame = Integer.parseInt(environment.getValue(DataTest.NUMBER_GAME.label).toString());

        log.info("Шаг 2 - Наведение курсора на 'Новое и примечательное' в меню страницы");
        mainPage.getNavBarStore().clickPopupItemFromNoteworthy(NavBarStoreNoteworthyItems.TOP_SELLERS);
        TopSellersPage topSellersPage = new TopSellersPage();
        Assert.assertTrue(topSellersPage.state().waitForDisplayed(), "Не удалось открыть страницу с лидерами продаж");

        log.info("Шаг 3 - Нажатие кнопки 'Просмотреть больше лидеров продаж'");
        topSellersPage.clickBrowseMoreTopSellers();
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        Assert.assertTrue(topSellersWithFilters.state().waitForDisplayed(), "Не удалось открыть страницу лидеры продаж с фильтрами");

        log.info("Шаг 4 - В правом меню, в блоке 'Операционная система' выбран чекбокс 'SteamOS + Linux'");
        TopSellersWithFiltersPageSteps.checkCheckBoxOnNarrowByOS(NarrowByOS.STEAM_OS_AND_LINUX);
        Assert.assertTrue(TopSellersWithFiltersPageSteps.isCheckBoxCheckedNarrowByOS(NarrowByOS.STEAM_OS_AND_LINUX), "Чекбокс ОС Linux не выбран");

        log.info("Шаг 5 - В правом меню, в блоке 'Количество игроков' выбран чекбокс 'Кооператив (LAN)'");
        TopSellersWithFiltersPageSteps.checkCheckBoxOnNumberOfPlayers(NarrowByNumberOfPlayers.LAN_CO_OP);
        Assert.assertTrue(TopSellersWithFiltersPageSteps.isCheckBoxCheckedNumberOfPlayers(NarrowByNumberOfPlayers.LAN_CO_OP), "Чекбокс кол-во игроков кооперативный LAN не выбран");

        log.info("Шаг 6 - В правом меню, в блоке 'Метки' выбран чекбокс 'Экшен'");
        TopSellersWithFiltersPageSteps.checkCheckBoxOnNarrowByTags(NarrowByTags.ACTION);
        Assert.assertTrue(TopSellersWithFiltersPageSteps.isCheckBoxCheckedNarrowByTags(NarrowByTags.ACTION), "Чекбокс Action не выбран");
        Assert.assertEquals(StringUtil.getNumberFromString(topSellersWithFilters.getGameResultsSearch()), topSellersWithFilters.getCountFoundGames(),
                "Количество игр с описания не соответствует реальному количеству игр на странице");

        log.info("Шаг 7 - Для первого результата из списка получены название игры, дату релиза и цену");
        GameInfo gameInfoFromTopSellers = new GameInfo();
        gameInfoFromTopSellers.setGameName(topSellersWithFilters.getGameTable().getNameGameByIndex(numberGame));
        gameInfoFromTopSellers.setDataReleased(topSellersWithFilters.getGameTable().getDateReleasedGameByIndex(numberGame));
        gameInfoFromTopSellers.setPrice(topSellersWithFilters.getGameTable().getGamePrice(numberGame));

        log.info("Шаг 8 - Кликнут первый результат в списке");
        topSellersWithFilters.getGameTable().clickGameByIndex(numberGame);
        DescriptionGame descriptionGame = new DescriptionGame();
        Assert.assertTrue(descriptionGame.state().waitForDisplayed(), "Не удалось открыть страницу описания игры");

        GameInfo gameInfoFromGameDescription = new GameInfo();
        gameInfoFromGameDescription.setGameName(descriptionGame.getNameGame());
        gameInfoFromGameDescription.setPrice(descriptionGame.getPriceGame());
        gameInfoFromGameDescription.setDataReleased(descriptionGame.getDataReleasedGame());

        Assert.assertEquals(gameInfoFromTopSellers,gameInfoFromGameDescription,"Игра со страницы TopSellers не эквивалентна нажатой игре");
    }
}
