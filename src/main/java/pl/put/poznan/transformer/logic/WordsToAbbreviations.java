package pl.put.poznan.transformer.logic;

import java.util.*;

public class WordsToAbbreviations extends TextTransformer {
    Map<String, String> wordsAbbreviationsMap = new HashMap<String, String>() {{
        put("na przykład", "np.");
        put("między innymi", "m.in.");
        put("i tak dalej", "itd.");
        put("i tym podobne", "itp.");
    }};
    public WordsToAbbreviations(Text newText) {
        super(newText);
    }

    public String get() {
        return transform(tempText.get());
    }
    private String transform(String text) {

        for (Map.Entry<String, String> set : wordsAbbreviationsMap.entrySet()) {
            if (text.contains(set.getKey()))
            {
                text = text.replace(set.getKey(), set.getValue());
            }
        }

        return text;
    }
}
