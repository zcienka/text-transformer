package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CapitalizeTest {
    TextTransformer textTransformerMock = null;

    @BeforeEach
    void setUp() {
        textTransformerMock = mock(TextTransformer.class);
    }
    @Test
    void testLowercaseLetters() {
        when(textTransformerMock.get()).thenReturn("lorem ipsum dolor sit amet consectetur adipiscing elit");
        Text newText = new Capitalize(textTransformerMock);
        assertEquals("Lorem Ipsum Dolor Sit Amet Consectetur Adipiscing Elit", newText.get());
    }
    @Test
    void testUppercaseLetters() {
        when(textTransformerMock.get()).thenReturn("LOREM IPSUM DOLOR SIT AMET CONSECTETUR ADIPISCING ELIT");
        Text newText = new Capitalize(textTransformerMock);
        assertEquals("Lorem Ipsum Dolor Sit Amet Consectetur Adipiscing Elit", newText.get());
    }

    @Test
    void testUppercaseLettersFalse() {
        when(textTransformerMock.get()).thenReturn("LOREM IPSUM");
        Text newText = new Capitalize(textTransformerMock);
            assertNotEquals("LOREM IPSUM", newText.get());
    }
    @Test
    void testMixedLetters() {
        when(textTransformerMock.get()).thenReturn("lorem ipsum Dolor Sit amet Consectetur adipiscing Elit");
        Text newText = new Capitalize(textTransformerMock);
        assertEquals("Lorem Ipsum Dolor Sit Amet Consectetur Adipiscing Elit", newText.get());
    }
    @Test
    void testEmptyString() {
        when(textTransformerMock.get()).thenReturn("");
        Text newText = new Capitalize(textTransformerMock);
        assertEquals("", newText.get());
    }
    @Test
    void testSpecialCharacters() {
        when(textTransformerMock.get()).thenReturn("!@#$%^&*()");
        Text newText = new Capitalize(textTransformerMock);
        assertEquals("!@#$%^&*()", newText.get());
    }
    @Test
    void testSpace() {
        when(textTransformerMock.get()).thenReturn(" ");
        Text newText = new Capitalize(textTransformerMock);
        assertEquals(" ", newText.get());
    }

    @Test
    void testNumber() {
        when(textTransformerMock.get()).thenReturn("dywizjon 303");
        Text newText = new Capitalize(textTransformerMock);
        assertEquals("Dywizjon 303", newText.get());
    }

    @Test
    void testPolishLanguage() {
        when(textTransformerMock.get()).thenReturn("śnieg ćma ą ę ósmy");
        Text newText = new Capitalize(textTransformerMock);
        assertEquals("Śnieg Ćma Ą Ę Ósmy", newText.get());
    }
}
