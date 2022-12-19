package pl.put.poznan.transformer.logic;

/**
 * Zawiera oraz zwraca tekst uprzednio poddany transformacjom.
 */
public class Response {
    /**
     * Przetransformowana zmienna.
     */
    public String text;

    /**
     * Konstruktor dla zmiennej zawierającej zmodyfikowany tekst.
     * @param text Uprzednio zmodyfikowany tekst.
     */
    public Response(String text){
        this.text = text;
    }

}
