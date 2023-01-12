package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordsToAbbreviationsTest {

    @Test
    public void testSpace() {
        String testedString = "   ";
        Text newText = new WordsToAbbreviations(new PlainText(testedString));
        assertEquals("   ", newText.get());
    }

    @Test
    public void testEmpty() {
        String testedString = "";
        Text newText = new WordsToAbbreviations(new PlainText(testedString));
        assertEquals("", newText.get());
    }

    @Test
    public void testAbbreviate1() {
        String testedString = "Przykładowe zdanie zawierające \"na przykład\"";
        Text newText = new WordsToAbbreviations(new PlainText(testedString));
        assertEquals("Przykładowe zdanie zawierające \"np.\"", newText.get());
    }

    @Test
    public void testAbbreviate2() {
        String testedString = "Przykładowe zdanie zawierające \"między innymi\"";
        Text newText = new WordsToAbbreviations(new PlainText(testedString));
        assertEquals("Przykładowe zdanie zawierające \"m.in.\"", newText.get());
    }

    @Test
    public void testAbbreviate3() {
        String testedString = "Przykładowe zdanie zawierające \"i tak dalej\"";
        Text newText = new WordsToAbbreviations(new PlainText(testedString));
        assertEquals("Przykładowe zdanie zawierające \"itd.\"", newText.get());
    }

    @Test
    public void testAbbreviate4() {
        String testedString = "Przykładowe zdanie zawierające \"i tym podobne\"";
        Text newText = new WordsToAbbreviations(new PlainText(testedString));
        assertEquals("Przykładowe zdanie zawierające \"itp.\"", newText.get());
    }

    @Test
    public void testSequenceAbbreviate() {
        String testedString = "na przykład i tym podobne między innymi";
        Text newText = new WordsToAbbreviations(new PlainText(testedString));
        assertEquals("np. itp. m.in.", newText.get());
    }

    @Test
    public void testUppercase() {
        String testedString = "Na przykład";
        Text newText = new WordsToAbbreviations(new PlainText(testedString));
        assertEquals("Na przykład", newText.get());
    }

    @Test
    public void testNoAbbreviations() {
        String testedString = "Przykładowa sentencja nie zawierająca zwrotów do skrócenia.";
        Text newText = new WordsToAbbreviations(new PlainText(testedString));
        assertEquals("Przykładowa sentencja nie zawierająca zwrotów do skrócenia.", newText.get());
    }
}