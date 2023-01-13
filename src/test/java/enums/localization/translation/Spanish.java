package enums.localization.translation;

import constants.localization.providers.AbstractILocalizationProvider;
import constants.localization.providers.LocalizationProviderFactory;
import constants.localization.providers.LocalizedValue;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Locale;

@AllArgsConstructor
public enum Spanish implements LocalizedValue {

    FIND_YOUR_LIBRARY("find_your_library"),
    ADD_ACCOUNT("add_account"),
    BACK("back"),
    CATALOG("catalog"),
    MORE("more");

    private static final AbstractILocalizationProvider localizationProvider =
            LocalizationProviderFactory.getProvider("translation.Spanish");

    private final String key;

    @Override
    public String i18n() {
        return localizationProvider.getLocalization(key);
    }

    @Override
    public String i18n(@NonNull Locale locale) {
        return localizationProvider.getLocalization(key, locale);
    }
}