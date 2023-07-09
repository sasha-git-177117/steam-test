package steps;

import consts.topsellerswithfilters.*;
import pages.TopSellersWithFiltersPage;

public class TopSellersWithFiltersPageSteps {

    public static void checkCheckBoxOnNarrowByDeskComm(NarrowByDeskCompatibility item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        if (!topSellersWithFilters.isOpenedBlock(BlocksOnTopSelling.NARROW_BY_DECK_COMPATIBILITY)) {
            topSellersWithFilters.clickBlock(BlocksOnTopSelling.NARROW_BY_DECK_COMPATIBILITY);
        }
        if(topSellersWithFilters.isBlockWithItemsDisplayed(BlocksOnTopSelling.NARROW_BY_DECK_COMPATIBILITY)) {
            topSellersWithFilters.waitOpeningBlockWithItems(BlocksOnTopSelling.NARROW_BY_DECK_COMPATIBILITY);
        }
        if(!isCheckBoxCheckedNarrowByDeskComm(item)) {
            topSellersWithFilters.clickCheckBox(BlocksOnTopSelling.NARROW_BY_DECK_COMPATIBILITY.label,item.label);
        }
        topSellersWithFilters.waitingGamesLoad();
    }

    public static void checkCheckBoxOnNarrowByFeature(NarrowByFeature item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        if (!topSellersWithFilters.isOpenedBlock(BlocksOnTopSelling.NARROW_BY_FEATURE)) {
            topSellersWithFilters.clickBlock(BlocksOnTopSelling.NARROW_BY_FEATURE);
        }
        if(topSellersWithFilters.isBlockWithItemsDisplayed(BlocksOnTopSelling.NARROW_BY_FEATURE)) {
            topSellersWithFilters.waitOpeningBlockWithItems(BlocksOnTopSelling.NARROW_BY_FEATURE);
        }
        if(!isCheckBoxCheckedNarrowByFeature(item)) {
            topSellersWithFilters.clickCheckBox(BlocksOnTopSelling.NARROW_BY_FEATURE.label,item.label);
        }
        topSellersWithFilters.waitingGamesLoad();
    }

    public static void checkCheckBoxOnNarrowBySelectedTypes(SelectedTypes item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        if (!topSellersWithFilters.isOpenedBlock(BlocksOnTopSelling.NARROW_BY_BLOCK_SELECTED_TYPES)) {
            topSellersWithFilters.clickBlock(BlocksOnTopSelling.NARROW_BY_BLOCK_SELECTED_TYPES);
        }
        if(topSellersWithFilters.isBlockWithItemsDisplayed(BlocksOnTopSelling.NARROW_BY_BLOCK_SELECTED_TYPES)) {
            topSellersWithFilters.waitOpeningBlockWithItems(BlocksOnTopSelling.NARROW_BY_BLOCK_SELECTED_TYPES);
        }
        if(!isCheckBoxCheckedSelectedTypes(item)) {
            topSellersWithFilters.clickCheckBox(BlocksOnTopSelling.NARROW_BY_BLOCK_SELECTED_TYPES.label,item.label);
        }
        topSellersWithFilters.waitingGamesLoad();
    }

    public static void checkCheckBoxOnNarrowByOS(NarrowByOS item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        if (!topSellersWithFilters.isOpenedBlock(BlocksOnTopSelling.NARROW_BY_OS)) {
            topSellersWithFilters.clickBlock(BlocksOnTopSelling.NARROW_BY_OS);
        }
        if(topSellersWithFilters.isBlockWithItemsDisplayed(BlocksOnTopSelling.NARROW_BY_OS)) {
            topSellersWithFilters.waitOpeningBlockWithItems(BlocksOnTopSelling.NARROW_BY_OS);
        }
        if(!isCheckBoxCheckedNarrowByOS(item)) {
            topSellersWithFilters.clickCheckBox(BlocksOnTopSelling.NARROW_BY_OS.label,item.label);
        }
        topSellersWithFilters.waitingGamesLoad();
    }

    public static void checkCheckBoxOnNumberOfPlayers(NarrowByNumberOfPlayers item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        if (!topSellersWithFilters.isOpenedBlock(BlocksOnTopSelling.NARROW_BY_OF_NUMBER_PLAYERS)) {
            topSellersWithFilters.clickBlock(BlocksOnTopSelling.NARROW_BY_OF_NUMBER_PLAYERS);
        }
        if(topSellersWithFilters.isBlockWithItemsDisplayed(BlocksOnTopSelling.NARROW_BY_OF_NUMBER_PLAYERS)) {
            topSellersWithFilters.waitOpeningBlockWithItems(BlocksOnTopSelling.NARROW_BY_OF_NUMBER_PLAYERS);
        }
        if(!isCheckBoxCheckedNumberOfPlayers(item)) {
            topSellersWithFilters.clickCheckBox(BlocksOnTopSelling.NARROW_BY_OF_NUMBER_PLAYERS.label,item.label);
        }
        topSellersWithFilters.waitingGamesLoad();
    }

    public static void checkCheckBoxOnNarrowByTags(NarrowByTags item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        if (!topSellersWithFilters.isOpenedBlock(BlocksOnTopSelling.NARROW_BY_TAG)) {
            topSellersWithFilters.clickBlock(BlocksOnTopSelling.NARROW_BY_TAG);
        }
        if(topSellersWithFilters.isBlockWithItemsDisplayed(BlocksOnTopSelling.NARROW_BY_TAG)) {
            topSellersWithFilters.waitOpeningBlockWithItems(BlocksOnTopSelling.NARROW_BY_TAG);
        }
        if(!isCheckBoxCheckedNarrowByTags(item)) {
            topSellersWithFilters.setTextOnSearchBoxTags(
                    topSellersWithFilters.getTextOnCheckBox(BlocksOnTopSelling.NARROW_BY_TAG.label, item.label));
            topSellersWithFilters.clickCheckBox(BlocksOnTopSelling.NARROW_BY_TAG.label,item.label);
        }
        topSellersWithFilters.waitingGamesLoad();
    }

    public static void checkCheckBoxOnNarrowByLanguage(NarrowByLanguage item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        if (!topSellersWithFilters.isOpenedBlock(BlocksOnTopSelling.NARROW_BY_LANGUAGE)) {
            topSellersWithFilters.clickBlock(BlocksOnTopSelling.NARROW_BY_LANGUAGE);
        }
        if(topSellersWithFilters.isBlockWithItemsDisplayed(BlocksOnTopSelling.NARROW_BY_LANGUAGE)) {
            topSellersWithFilters.waitOpeningBlockWithItems(BlocksOnTopSelling.NARROW_BY_LANGUAGE);
        }
        if(!isCheckBoxCheckedNarrowByLanguage(item)) {
            topSellersWithFilters.setTextOnSearchBoxLanguage(
                    topSellersWithFilters.getTextOnCheckBox(BlocksOnTopSelling.NARROW_BY_LANGUAGE.label, item.label));
            topSellersWithFilters.clickCheckBox(BlocksOnTopSelling.NARROW_BY_LANGUAGE.label,item.label);
        }
        topSellersWithFilters.waitingGamesLoad();
    }

    public static void checkCheckBoxOnVRSupports(NarrowByVRSupport item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        if (!topSellersWithFilters.isOpenedBlock(BlocksOnTopSelling.NARROW_BY_VR_SUPPORT)) {
            topSellersWithFilters.clickBlock(BlocksOnTopSelling.NARROW_BY_VR_SUPPORT);
        }
        if(topSellersWithFilters.isBlockWithItemsDisplayed(BlocksOnTopSelling.NARROW_BY_VR_SUPPORT)) {
            topSellersWithFilters.waitOpeningBlockWithItems(BlocksOnTopSelling.NARROW_BY_VR_SUPPORT);
        }
        if(!isCheckBoxCheckedNarrowByVRSupports(item)) {
            topSellersWithFilters.clickCheckBox(BlocksOnTopSelling.NARROW_BY_VR_SUPPORT.label,item.label);
        }
        topSellersWithFilters.waitingGamesLoad();
    }

    public static boolean isCheckBoxCheckedNarrowByLanguage(NarrowByLanguage item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        return topSellersWithFilters.isCheckBoxChecked(BlocksOnTopSelling.NARROW_BY_LANGUAGE.label, item.label);
    }

    public static boolean isCheckBoxCheckedNarrowByVRSupports(NarrowByVRSupport item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        return topSellersWithFilters.isCheckBoxChecked(BlocksOnTopSelling.NARROW_BY_VR_SUPPORT.label, item.label);
    }

    public static boolean isCheckBoxCheckedNarrowByDeskComm(NarrowByDeskCompatibility item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        return topSellersWithFilters.isCheckBoxChecked(BlocksOnTopSelling.NARROW_BY_DECK_COMPATIBILITY.label, item.label);
    }

    public static boolean isCheckBoxCheckedNarrowByTags(NarrowByTags item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        return topSellersWithFilters.isCheckBoxChecked(BlocksOnTopSelling.NARROW_BY_TAG.label, item.label);
    }

    public static boolean isCheckBoxCheckedNarrowByFeature(NarrowByFeature item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        return topSellersWithFilters.isCheckBoxChecked(BlocksOnTopSelling.NARROW_BY_FEATURE.label, item.label);
    }

    public static boolean isCheckBoxCheckedNumberOfPlayers(NarrowByNumberOfPlayers item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        return topSellersWithFilters.isCheckBoxChecked(BlocksOnTopSelling.NARROW_BY_OF_NUMBER_PLAYERS.label, item.label);
    }

    public static boolean isCheckBoxCheckedNarrowByOS(NarrowByOS item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        return topSellersWithFilters.isCheckBoxChecked(BlocksOnTopSelling.NARROW_BY_OS.label, item.label);
    }

    public static boolean isCheckBoxCheckedSelectedTypes(SelectedTypes item) {
        TopSellersWithFiltersPage topSellersWithFilters = new TopSellersWithFiltersPage();
        return topSellersWithFilters.isCheckBoxChecked(BlocksOnTopSelling.NARROW_BY_BLOCK_SELECTED_TYPES.label, item.label);
    }

}
