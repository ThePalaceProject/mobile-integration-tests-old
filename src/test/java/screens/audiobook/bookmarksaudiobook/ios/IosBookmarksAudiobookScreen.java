package screens.audiobook.bookmarksaudiobook.ios;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import constants.applicationattributes.IosAttributes;
import framework.utilities.DateUtils;
import org.openqa.selenium.By;
import screens.audiobook.bookmarksaudiobook.BookmarksAudiobookScreen;

@ScreenType(platform = PlatformName.IOS)
public class IosBookmarksAudiobookScreen extends BookmarksAudiobookScreen {

    private final ILabel lblNoBookmarks = getElementFactory().getLabel(By.xpath("//XCUIElementTypeStaticText[contains(@name=\"no bookmarks\")]"), "No bookmarks label");
    private final ILabel lblChapterName = getElementFactory().getLabel(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]"), "Chapter name");
    private final ILabel lblChapterTime = getElementFactory().getLabel(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[3]"), "Chapter time");
    private static final String CHAPTER_TIME_LOCATOR = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[@name=\"%s\"]";
    private static final String CHAPTER_NAME_LOCATOR = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[@name=\"%s\"]";

    public IosBookmarksAudiobookScreen() {
        super(By.xpath("//XCUIElementTypeButton[@name=\"Bookmarks\"]"));
    }

    @Override
    public boolean isBookmarksScreenSelected() {
        return lblNoBookmarks.state().waitForDisplayed();
    }

    @Override
    public boolean isNoBookmarksMessageDisplayed() {
        return lblNoBookmarks.state().waitForDisplayed();
    }

    @Override
    public String getFirstChapterName() {
        return lblChapterName.getText();
    }

    @Override
    public String getFirstChapterTime() {
        return DateUtils.getDuration(lblChapterTime.getAttribute(IosAttributes.VALUE)).toString();
    }

    @Override
    public boolean isBookmarkPresent(String chapterName, String chapterTime) {
        ILabel lblChapterTime = getElementFactory().getLabel(By.xpath(String.format(CHAPTER_TIME_LOCATOR, chapterTime)), "Chapter time");
        ILabel lblChapterName = getElementFactory().getLabel(By.xpath(String.format(CHAPTER_NAME_LOCATOR, chapterName)), "Chapter time");
        return lblChapterTime.state().waitForDisplayed() && lblChapterName.state().waitForDisplayed();
    }

    @Override
    public void chooseBookmark(String chapterName, String chapterTime) {

    }
}
