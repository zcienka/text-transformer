package pl.put.poznan.transformer.logic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DuplicatesElimination extends TextTransformer {
    public DuplicatesElimination(Text newText) {
        super(newText);
    }

    public String get() {
        return transform(tempText.get());
    }

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
