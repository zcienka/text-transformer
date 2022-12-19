package pl.put.poznan.transformer.logic;

/**
 * Klasa zawierająca bazowy tekst podlegająca transformacjom.
 */
public class PlainText implements Text {

    /**
     * Zmienna do której sięga dekorator wykonujący transformacje.
     */
    private final String tempText;

    /**
     * Konstruktor inicjalizujący transformowany tekst.
     * @param initText Tekst podlegający transformacjom.
     */
    public PlainText(String initText){
            tempText = initText;
    }

    /**
     * Przekazuje bazowy tekst.
     * @return Bazowy tekst.
     */
    @Override
    public String get() {
        return tempText;
    }
}
