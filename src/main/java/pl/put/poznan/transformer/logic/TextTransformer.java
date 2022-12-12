package pl.put.poznan.transformer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer implements Text{

    protected Text tempText;

    public TextTransformer(Text newText){
        tempText = newText;
    }

    public String get(){
        return tempText.get();
    }
}
