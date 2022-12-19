package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Rozwija wybrane skróty do pełnych postaci.
 */
public class ExpandAbbreviations extends TextTransformer {
    /** Lista skrótów podlegających rozwijaniu.
     */
	final private List<String> abbreviationsList = Arrays.asList("prof.", "dr", "np.", "itp.", "itd.");
    /** Lista kolejno rozwiniętych skrótów z listy skrótów.
     */
	final private List<String> expandedWords =
            Arrays.asList("profesor", "doktor", "na przykład", "i tym podobne", "i tak dalej");

	/**
     * Konstruktor dla obiektu dekorującego dany tekst.
     * @param newText Tekst na którym zostanie wykonana transformacja.
     */
    public ExpandAbbreviations(Text newText) {
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
     * Wykonuje operacje rozwijania wybranych skrótów do pełnych postaci.
     * @param text Tekst poddawany transformacji.
     * @return Tekst po wykonaniu transfomacji.
     */
    private String transform(String text) {
        String[] textList = text.split(" ");
        List<String> transformedList = new ArrayList<>();

        for (String word : textList) {
            if (abbreviationsList.contains(word.toLowerCase())) {
                int abbreviationIndex = abbreviationsList.indexOf(word.toLowerCase());
                String expandedWord = expandedWords.get(abbreviationIndex);

                transformedList.add(word.charAt(0) + expandedWord.substring(1));
            } else {
                transformedList.add(word);
            }

        }
        return String.join(" ", transformedList);
    }
}
