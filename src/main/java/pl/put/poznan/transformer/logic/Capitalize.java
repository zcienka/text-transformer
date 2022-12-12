package pl.put.poznan.transformer.logic;

public class Capitalize extends TextTransformer{

    public Capitalize(Text newText){
        super(newText);
    }

    public String get(){
        return transform(tempText.get());
    }

    private String transform(String text){
        String[] words = text.split("\\s");
        StringBuilder cappedText = new StringBuilder();

        for (String word : words) {
            char capLetter = Character.toUpperCase(word.charAt(0));
            cappedText.append(" ").append(capLetter).append(word.substring(1));
        }

        return cappedText.toString();
    }
}
