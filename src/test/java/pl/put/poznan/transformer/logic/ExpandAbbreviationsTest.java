package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpandAbbreviationsTest {

    @Test
    public void testEmpty() {
        String testedString = "";
        Text newText = new ExpandAbbreviations(new PlainText(testedString));
        assertEquals("", newText.get());
    }

    @Test
    public void testExpand1() {
        String testedString = "prof.";
        Text newText = new ExpandAbbreviations(new PlainText(testedString));
        assertEquals("profesor", newText.get());
    }

    @Test
    public void testExpand2() {
        String testedString = "dr";
        Text newText = new ExpandAbbreviations(new PlainText(testedString));
        assertEquals("doktor", newText.get());
    }

    @Test
    public void testExpand3() {
        String testedString = "itp.";
        Text newText = new ExpandAbbreviations(new PlainText(testedString));
        assertEquals("i tym podobne", newText.get());
    }

    @Test
    public void testSequenceExpand() {
        String testedString = "itp. itd. prof. dr";
        Text newText = new ExpandAbbreviations(new PlainText(testedString));
        assertEquals("i tym podobne i tak dalej profesor doktor", newText.get());
    }

    @Test
    public void testNoExpand() {
        String testedString = "Przykładowa sentencja nie zawierająca zwrotów do rozwinięcia.";
        Text newText = new ExpandAbbreviations(new PlainText(testedString));
        assertEquals("Przykładowa sentencja nie zawierająca zwrotów do rozwinięcia.", newText.get());
    }

    @Test
    public void testInSequence() {
        String testedString = "Padre";
        Text newText = new ExpandAbbreviations(new PlainText(testedString));
        assertEquals("Padre", newText.get());
    }

    @Test
    public void testBackspaced() {
        String testedString = "i t p .";
        Text newText = new ExpandAbbreviations(new PlainText(testedString));
        assertEquals("i t p .", newText.get());
    }
}