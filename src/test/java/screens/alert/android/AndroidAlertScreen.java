package screens.alert.android;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import enums.localization.catalog.EnumActionButtonsForBooksAndAlertsKeys;
import org.openqa.selenium.By;
import screens.alert.AlertScreen;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidAlertScreen extends AlertScreen {
    private static final String UNIQUE_ELEMENT_LOC = "//android.widget.LinearLayout[contains(@resource-id, \"grant_dialog\")]";
    private static final String ACTION_BUTTON_LOC = UNIQUE_ELEMENT_LOC + "//android.widget.Button[@text=\"%s\"]";
    
    public AndroidAlertScreen() {
        super(By.xpath("//android.widget.LinearLayout[contains(@resource-id, \"grant_dialog\")]"));
    }

    @Override
    public void waitAndPerformAlertActionIfDisplayed(EnumActionButtonsForBooksAndAlertsKeys actionButtonNamesAlertKeys) {
        IButton actionButton = getElementFactory().getButton(By.xpath(String.format(ACTION_BUTTON_LOC, actionButtonNamesAlertKeys.getDefaultLocalizedValue())), String.format("%s ActionButtonAlert", actionButtonNamesAlertKeys.getDefaultLocalizedValue()));
        if(actionButton.state().waitForDisplayed()){
            actionButton.click();
        }
    }

    @Override
    public void performAlertActionIfDisplayedInSpanish(String actionBtnKey) {
        //for ios
    }

    @Override
    public void performAlertActionIfDisplayedInItalian(String actionBtnKey) {
        //for ios
    }

    @Override
    public String getTextFromAlertHeader() {
        //for android
        return null;
    }
}
