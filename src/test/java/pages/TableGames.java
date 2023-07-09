package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import consts.AttributeAndValue;
import customelements.Table;
import models.GameInfo;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

public class TableGames extends Table {

    private static final By GAMES = By.xpath("//*[contains(@class,'app_impression_tracked')]");
    private static final By GAME_IMAGE = By.xpath("//*[contains(@class,'search_capsule')]//img");
    private static final By GAME_NAME = By.xpath("//*[contains(@class,'search_name')]//*[contains(@class,'title')]");
    private static final By GAME_DATE_RELEASED = By.xpath("//*[contains(@class,'search_released')]");
    private static final By GAME_PRICE = By.xpath("//*[contains(@class,'search_price')]");
    private static final By GAME_DISCOUNT = By.xpath("//*[contains(@class,'search_discount')]");
    private static final By GAME_REVIEW = By.xpath("//*[contains(@class,'search_review_summary')]");
    private static final By GAME_PLATFORM = By.xpath("//*[contains(@class,'platform_img')]");

    private static final ILabel TABLE = AqualityServices.getElementFactory().getLabel(By.id("search_result_container"),"table");

    protected TableGames(By loc, String name, ElementState elementState) {
        super(loc, name, elementState);
    }

    public List<GameInfo> getAllGames() {
        List<IButton> games = TABLE.findChildElements(GAMES, ElementType.BUTTON);
        List<GameInfo> resGames = new ArrayList<>();
        for (int i = 0; i < games.size(); i++) {
            resGames.add(getGameByIndex(i));
        }
        return resGames;
    }

    public GameInfo getGameByIndex(int index){
        return new GameInfo(getSrcGameByIndex(index),
                getNameGameByIndex(index),
                getDateReleasedGameByIndex(index),
                getGameReview(index),
                getGameDiscount(index),
                getGamePrice(index),
                getGamePlatform(index));
    }

    public String getNameGameByIndex(int index) {
        List<IButton> games = TABLE.findChildElements(GAMES, ElementType.BUTTON);
        return games.get(index-1).findChildElement(GAME_NAME,ElementType.LABEL).getText();
    }

    public String getSrcGameByIndex(int index) {
        List<IButton> games = TABLE.findChildElements(GAMES, ElementType.BUTTON);
        return games.get(index-1).findChildElement(GAME_IMAGE,ElementType.LABEL).getText();
    }

    public String getDateReleasedGameByIndex(int index) {
        List<IButton> games = TABLE.findChildElements(GAMES, ElementType.BUTTON);
        return games.get(index-1).findChildElement(GAME_DATE_RELEASED,ElementType.LABEL).getText();
    }

    public String getGamePrice(int index) {
        List<IButton> games = TABLE.findChildElements(GAMES, ElementType.BUTTON);
        return games.get(index-1).findChildElement(GAME_PRICE,ElementType.LABEL).getText();
    }

    public String getGameDiscount(int index) {
        List<IButton> games = TABLE.findChildElements(GAMES, ElementType.BUTTON);
        return games.get(index-1).findChildElement(GAME_DISCOUNT,ElementType.LABEL).getText();
    }

    public String getGameReview(int index) {
        List<IButton> games = TABLE.findChildElements(GAMES, ElementType.BUTTON);
        String review = games.get(index-1).findChildElement(GAME_REVIEW,ElementType.LABEL).getAttribute(AttributeAndValue.CLASS.label);
        if(review.contains(AttributeAndValue.MIXED.label)) {
            return AttributeAndValue.MIXED.label;
        }
        else return AttributeAndValue.POSITIVE.label;
    }

    public List<String> getGamePlatform(int index) {
        List<String> resPlatforms = new ArrayList<>();
        List<IButton> games = TABLE.findChildElements(GAMES, ElementType.BUTTON);
        List<ILabel> platforms  = games.get(index-1).findChildElements(GAME_PLATFORM,ElementType.LABEL);
        for (ILabel platform: platforms) {
            if(platform.getAttribute(AttributeAndValue.CLASS.label).contains(AttributeAndValue.WIN.label)) resPlatforms.add(AttributeAndValue.WIN.label);
            else if(platform.getAttribute(AttributeAndValue.CLASS.label).contains(AttributeAndValue.MAC.label)) resPlatforms.add(AttributeAndValue.MAC.label);
            else resPlatforms.add(AttributeAndValue.LINUX.label);
        }
        return resPlatforms;
    }

    public void clickGameByIndex(int index) {
        List<IButton> games = TABLE.findChildElements(GAMES, ElementType.BUTTON);
        games.get(index-1).click();
    }

}
