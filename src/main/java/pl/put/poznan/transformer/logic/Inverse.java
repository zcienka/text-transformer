package pl.put.poznan.transformer.logic;

public class Inverse extends TextTransformer{
    public Inverse(Text newText) {
        super(newText);
    }

    public String get() {
        return transform(tempText.get());
    }

    public String transform(String text) {
        StringBuilder inversedText = new StringBuilder();
        inversedText.append(text);
        inversedText.reverse();

        StringBuilder outputText = new StringBuilder();
        for(int i=0; i<text.length(); i++){
            boolean inputIsCapital = Character.isUpperCase(text.charAt(i));
            if(inputIsCapital){
                outputText.append(Character.toUpperCase(inversedText.charAt(i)));
            }
            else{
                outputText.append(Character.toLowerCase(inversedText.charAt(i)));
            }
        }
        return outputText.toString();
    }
}
