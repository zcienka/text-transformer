package pl.put.poznan.transformer.logic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Usuwa powtarzające się po sobie słowa. np. Ala ma ma kota. -> Ala ma kota.
 */
public class DuplicatesElimination extends TextTransformer {
    /**
     * Konstruktor dla obiektu dekorującego dany tekst.
     * @param newText Tekst na którym zostanie wykonana transformacja.
     */
    public DuplicatesElimination(Text newText) {
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
     * Wykonuje operacje usunięcia powtarzających się po sobie słów.
     * @param text Tekst poddawany transformacji.
     * @return Tekst po wykonaniu transfomacji.
     */
    private String transform(String text) {
        List<String> textList = Arrays.asList(text.split(" "));
        List<String> eliminatedDuplicates = new java.util.ArrayList<>();
        eliminatedDuplicates.add(textList.get(0));

        for (int i = 1; i < textList.size(); i++) {
            if (!Objects.equals(textList.get(i), textList.get(i - 1))) {
                eliminatedDuplicates.add(textList.get(i));
            }
        }

        return String.join(" ", eliminatedDuplicates);
    }
}
