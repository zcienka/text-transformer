package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Przekształca tekst do formatu wspieranego przez Latex (znaki specjalne).
 */
public class LatexFormat extends TextTransformer {
    /** Predefiniowana lista znaków specjalnych podlegających przekształceniu.
     */
    final private List<String> specialCharacters = Arrays.asList("&", "$", "_", "#", "}", "~", "%", "^", "{");

    /**
     * Konstruktor dla obiektu dekorującego dany tekst.
     * @param newText Tekst na którym zostanie wykonana transformacja.
     */
    public LatexFormat(Text newText) {
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
     * Wykonuje operacje przekształcanie tekstu do formatu wspieranego przez Latex.
     * @param text Tekst poddawany transformacji.
     * @return Tekst po wykonaniu transfomacji.
     */
    private String transform(String text) {
        String transformedText = text;

        for (String specialCharacter : specialCharacters) {

            if (text.contains(specialCharacter)) {
                List<Integer> characterIndexes = new ArrayList<>();
                int index = -1;

                while (true) {
                    index = transformedText.indexOf(specialCharacter, index + 1);
                    if (index == -1) {
                        break;
                    }
                    characterIndexes.add(index);
                }

                int i = 0;
                for (Integer characterIndex : characterIndexes) {
                    String textCopy = transformedText;

                    transformedText = textCopy.substring(0, characterIndex + i) + "\\";
                    transformedText = transformedText + textCopy.substring(characterIndex + i);
                    i++;
                }
            }
        }
        return transformedText;
    }
}
