package framework.utilities;

public class TranslationUtils {

    public static boolean isTranslationCorrect(String actualWord, String expectedTranslation) {
        return actualWord.equals(expectedTranslation);
    }
}
