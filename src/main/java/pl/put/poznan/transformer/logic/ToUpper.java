package pl.put.poznan.transformer.logic;

public class ToUpper extends TextTransformer{

    public ToUpper(Text newText){
        super(newText);
    }

    public String get(){
        return tempText.get().toUpperCase();
    }
}
