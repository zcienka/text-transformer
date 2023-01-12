package pl.put.poznan.transformer.logic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LatexFormatTest {

    @Test
    public void testSpace() {
        String testedString = "   ";
        Text newText = new LatexFormat(new PlainText(testedString));
        assertEquals("   ", newText.get());
    }

    @Test
    public void testEmpty() {
        String testedString = "";
        Text newText = new LatexFormat(new PlainText(testedString));
        assertEquals("", newText.get());
    }

    @Test
    public void testMixedWithinWords() {
        String testedString = "to%testowy&string.";
        Text newText = new LatexFormat(new PlainText(testedString));
        assertEquals("to\\%testowy\\&string.", newText.get());
    }

    @Test
    public void testSequenceOfLatexCharacters() {
        String testedString = "%%$^&$";
        Text newText = new LatexFormat(new PlainText(testedString));
        assertEquals("\\%\\%\\$\\^\\&\\$", newText.get());
    }

    @Test
    public void testAlreadyLatexed() {
        String testedString = "\\%\\%\\$\\^\\&\\$";
        Text newText = new LatexFormat(new PlainText(testedString));
        assertEquals("\\\\%\\\\%\\\\$\\\\^\\\\&\\\\$", newText.get());
    }

    @Test
    public void testAmpersand() {
        String testedString = "&";
        Text newText = new LatexFormat(new PlainText(testedString));
        assertEquals("\\&", newText.get());
    }

    @Test
    public void testHash() {
        String testedString = "#";
        Text newText = new LatexFormat(new PlainText(testedString));
        assertEquals("\\#", newText.get());
    }

    @Test
    public void testUnderscore() {
        String testedString = "_";
        Text newText = new LatexFormat(new PlainText(testedString));
        assertEquals("\\_", newText.get());
    }
}