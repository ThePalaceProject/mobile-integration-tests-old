package screens.audiobook.bookmarksaudiobook;

import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public abstract class BookmarksAudiobookScreen extends Screen {

    protected BookmarksAudiobookScreen(By locator) {
        super(locator, "Bookmarks audiobook screen");
    }

    public abstract boolean isBookmarksScreenSelected();

    public abstract boolean isNoBookmarksMessageDisplayed();

    public abstract String getFirstChapterName();

    public abstract String getFirstChapterTime();

    public abstract boolean isBookmarkPresent(String chapterName, String chapterTime);

    public abstract void chooseBookmark(String chapterName, String chapterTime);
}
