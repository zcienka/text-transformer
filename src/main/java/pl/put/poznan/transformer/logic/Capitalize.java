package pl.put.poznan.transformer.logic;

/**
 * Transformuje pierwszą literę poszczególnych wyrazów na wielką.
 */
public class Capitalize extends TextTransformer {

    /**
     * Konstruktor dla obiektu dekorującego dany tekst.
     * @param newText Tekst na którym zostanie wykonana transformacja.
     */
    public Capitalize(Text newText) {
        super(newText);
    }

    /**
     * Przekazuje odpowiednio zmodyfikowany tekst.
     * @return Zmodyfikowany tekst.
     */
    public String get() {
        return transform(tempText.get());
    }

    /**
     * Wykonuje operacje zmiany pierwszej litery poszczególnych wyrazów na wielką.
     * @param text Tekst poddawany transformacji.
     * @return Tekst po wykonaniu transfomacji.
     */
    private String transform(String text) {
        String[] words = text.trim().split("\\s");
        StringBuilder cappedText = new StringBuilder();

        for (String word : words) {
            char capLetter = Character.toUpperCase(word.charAt(0));

            cappedText.append(" ").append(capLetter).append(word.substring(1));

        }
        return cappedText.toString().trim();
    }
}
