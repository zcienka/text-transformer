package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InverseTest {
    TextTransformer textTransformerMock = null;

    @BeforeEach
    void setUp() {
        textTransformerMock = mock(TextTransformer.class);
    }

    @Test
    void testSpace() {
        when(textTransformerMock.get()).thenReturn(" ");
        Text newText = new Inverse(textTransformerMock);
        assertEquals(" ", newText.get());
    }

    @Test
    void testEmptyString() {
        when(textTransformerMock.get()).thenReturn("");
        Text newText = new Inverse(textTransformerMock);
        assertEquals("", newText.get());
    }

    @Test
    void testSpecialCharacters() {
        when(textTransformerMock.get()).thenReturn("!@#$%^&*()");
        Text newText = new Inverse(textTransformerMock);
        assertEquals(")(*&^%$#@!", newText.get());
    }

    @Test
    void testNumber() {
        when(textTransformerMock.get()).thenReturn("12345");
        Text newText = new Inverse(textTransformerMock);
        assertEquals("54321", newText.get());
    }

    @Test
    void testUppercaseLetters() {
        when(textTransformerMock.get()).thenReturn("LOREM IPSUM");
        Text newText = new Inverse(textTransformerMock);
        assertEquals("MUSPI MEROL", newText.get());
    }

    @Test
    void testLowercaseLetters() {
        when(textTransformerMock.get()).thenReturn("lorem ipsum");
        Text newText = new Inverse(textTransformerMock);
        assertEquals("muspi merol", newText.get());
    }

    @Test
    void testMixedLetters() {
        when(textTransformerMock.get()).thenReturn("Lorem ipsUm");
        Text newText = new Inverse(textTransformerMock);
        assertEquals("Muspi merOl", newText.get());
    }

    @Test
    void testMixedLettersFalse() {
        when(textTransformerMock.get()).thenReturn("Lorem ipsUm");
        Text newText = new Inverse(textTransformerMock);
        assertNotEquals("mUspi meroL", newText.get());
    }

    @Test
    void testOneLetter() {
        when(textTransformerMock.get()).thenReturn("A");
        Text newText = new Inverse(textTransformerMock);
        assertEquals("A", newText.get());
    }
}