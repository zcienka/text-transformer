package pl.put.poznan.transformer.logic;

public class PlainText implements Text {

    private final String tempText;

    public PlainText(String initText){
            tempText = initText;
    }
    @Override
    public String get() {
        return tempText;
    }
}
