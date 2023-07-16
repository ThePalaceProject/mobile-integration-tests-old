package screens.audiobook.bookmarksaudiobook.android;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import constants.applicationattributes.AndroidAttributes;
import framework.utilities.DateUtils;
import org.openqa.selenium.By;
import screens.audiobook.bookmarksaudiobook.BookmarksAudiobookScreen;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidBookmarksAudiobookScreen extends BookmarksAudiobookScreen {

    private final IButton btnBookmarks = getElementFactory().getButton(By.xpath("//android.widget.LinearLayout[@content-desc=\"Bookmarks\"]"), "Bookmarks tab");
    private final ILabel lblChapterName = getElementFactory().getLabel(By.id("player_toc_bookmark_item_view_title"), "Chapter name");
    private final ILabel lblChapterTime = getElementFactory().getLabel(By.id("player_toc_bookmark_item_view_offset"), "Chapter time");
    private static final String CHAPTER_TIME_LOCATOR = "//android.widget.LinearLayout/android.widget.TextView[@text=\"%s\"]";
    private static final String CHAPTER_NAME_LOCATOR = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@text=\"%s\"]";

    public AndroidBookmarksAudiobookScreen() {
        super(By.xpath("//android.widget.LinearLayout[@content-desc=\"Bookmarks\"]"));
    }

    @Override
    public boolean isBookmarksScreenSelected() {
        return btnBookmarks.getAttribute(AndroidAttributes.SELECTED).equals(Boolean.TRUE.toString());
    }

    @Override
    public boolean isNoBookmarksMessageDisplayed() {
        //should be added on Android
        return true;
    }

    @Override
    public String getFirstChapterName() {
        return lblChapterName.getText();
    }

    @Override
    public String getFirstChapterTime() {
        return DateUtils.getDuration(lblChapterTime.getText()).toString();
    }

    @Override
    public boolean isBookmarkPresent(String chapterName, String chapterTime) {
        ILabel lblChapterName = getElementFactory().getLabel(By.xpath(String.format(CHAPTER_NAME_LOCATOR, chapterName)), "Chapter name");
        ILabel lblChapterTime = getElementFactory().getLabel(By.xpath(String.format(CHAPTER_TIME_LOCATOR, chapterTime)), "Chapter time");
        return lblChapterName.state().waitForDisplayed() && lblChapterTime.state().waitForDisplayed();
    }

    @Override
    public void chooseBookmark(String chapterName, String chapterTime) {

    }

}
