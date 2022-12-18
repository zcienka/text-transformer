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

    public String get(){
        return transform(tempText.get());
    }

    private String transform(String text) {
        if (abbreviationsList.contains(text.toLowerCase())) {
            int abbreviationIndex = abbreviationsList.indexOf(text.toLowerCase());
            String word = expandedWords.get(abbreviationIndex);

            return text.charAt(0) + word.substring(1);
        }
        return text;
    }
}
