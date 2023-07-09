package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutPage;
import utils.StringUtil;

public class TestAboutInformation extends BaseTest {
    @Test
    public void testAboutInformation() {
        Logger log = AqualityServices.getLogger();

        log.info("Шаг 2 - Нажатие кнопки About");
        mainPage.getNavBar().clickAbout();
        AboutPage aboutPage = new AboutPage();

        log.info("Шаг 3 - Сравнение игроков онлайн и в игре");
        Assert.assertTrue(aboutPage.state().waitForDisplayed(),"Не удалось открыть страницу ABOUT");
        Assert.assertTrue(StringUtil.getNumberFromString(aboutPage.getCountGamersInGame())
                        < StringUtil.getNumberFromString(aboutPage.getCountGamersOnline()),
                "Игроков сейчас не меньше чем игроков онлайн");

        log.info("Шаг 4 - Переход на страницу магазина");
        mainPage.getNavBar().clickStore();
        Assert.assertTrue(mainPage.state().waitForDisplayed(),"Страница магазина не открылась");

    }
}