package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LatexFormat extends TextTransformer {
    final private List<String> specialCharacters = Arrays.asList("&", "$", "_", "#", "}", "~", "%", "^", "{");

    public LatexFormat(Text newText) {
        super(newText);
    }

    public String get() {
        return transform(tempText.get());
    }

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
