package pl.put.poznan.transformer.logic;

/**
 * Transformuje wszystkie litery zawierane w tekście na duże.
 */
public class ToUpper extends TextTransformer{

    /**
     * Konstruktor dla obiektu dekorującego dany tekst.
     * @param newText Tekst na którym zostanie wykonana transformacja.
     */
    public ToUpper(Text newText){
        super(newText);
    }

    /**
     * Przekazuje odpowiednio zmodyfikowany tekst.
     * @return Zmodyfikowany tekst.
     */
    public String get(){
        return tempText.get().toUpperCase();
    }
}
