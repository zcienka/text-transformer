package pl.put.poznan.transformer.logic;

/**
 * Odwraca ciąg znaków z zachowaniem wielkości liter na konkretnych pozycjach.
 */
public class Inverse extends TextTransformer{
    /**
     * Konstruktor dla obiektu dekorującego dany tekst.
     * @param newText Tekst na którym zostanie wykonana transformacja.
     */
    public Inverse(Text newText) {
        super(newText);
    }

    /**
     * Przekazuje odpowiednio zmodyfikowany tekst.
     * @return Zmodyfikowany tekst.
     */
    public String get() {
        return transform(tempText.get());
    }

    /**
     * Wykonuje operacje odwracania ciągu znaków.
     * @param text Tekst poddawany transformacji.
     * @return Tekst po wykonaniu transfomacji.
     */
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
