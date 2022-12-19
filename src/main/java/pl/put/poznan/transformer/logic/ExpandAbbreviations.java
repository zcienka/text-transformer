package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpandAbbreviations extends TextTransformer {
    final private List<String> abbreviationsList = Arrays.asList("prof.", "dr", "np.", "itp.", "itd.");
    final private List<String> expandedWords =
            Arrays.asList("profesor", "doktor", "na przykład", "i tym podobne", "i tak dalej");

    public ExpandAbbreviations(Text newText) {
        super(newText);
    }

    public String get() {
        return transform(tempText.get());
    }

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
