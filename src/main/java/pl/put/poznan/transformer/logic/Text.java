package pl.put.poznan.transformer.logic;

/**
 * Interfejs dla dekoratora oraz klasy PlainText.
 */
public interface Text {
    /**
     * Tekst poddawany transformacjom.
     */
    String tempText = null;

    /**
     * Funkcja zwracająca zawierany tekst.
     * @return Zmienną poddawaną transformacjom.
     */
    String get();
}
