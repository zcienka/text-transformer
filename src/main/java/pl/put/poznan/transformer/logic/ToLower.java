package pl.put.poznan.transformer.logic;

public class ToLower extends TextTransformer {

    public ToLower(Text newText){
        super(newText);
    }

    public String get(){
        return tempText.get().toLowerCase();
    }
}
