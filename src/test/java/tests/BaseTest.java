package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import consts.Config;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.MainPage;

abstract public class BaseTest {
    protected MainPage mainPage;
    @BeforeClass
    public void setupClass() {
        AqualityServices.getLogger().info("Настройка браузера");
        ISettingsFile environment = new JsonSettingsFile(Config.FILE_PATH.label);
        String url = environment.getValue(Config.BASE_URL.label).toString();
        Browser browser = AqualityServices.getBrowser();
        browser.maximize();
        AqualityServices.getBrowser().goTo(url);
        AqualityServices.getBrowser().waitForPageToLoad();

        AqualityServices.getLogger().info("Шаг 1 - Открытие главной страницы");
        mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(),"Не удалось открыть главную страницу");
    }
    @AfterClass
    public void tearDown() {
        AqualityServices.getBrowser().quit();
    }
}
