package pl.put.poznan.transformer.logic;

/**
 * Dekorator utrzymujący referencje do komponentu oraz z nim zgodny.
 */
abstract class TextTransformer implements Text {

    /**
     * Referencjowana zmienna podlegająca transformacjom.
     */
    protected Text tempText;

    /**
     * Konstruktor dla referencjowanej zmiennej podlegającej transformacjom.
     * @param newText Klasa poddawana transformacjom.
     */
    public TextTransformer(Text newText){
        tempText = newText;
    }

    /**
     * Przekazuje bazowy tekst.
     * @return Bazowy tekst.
     */
    public String get(){
        return tempText.get();
    }
}
