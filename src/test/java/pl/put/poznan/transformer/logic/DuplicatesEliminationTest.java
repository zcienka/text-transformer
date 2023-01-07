package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DuplicatesEliminationTest {
    TextTransformer textTransformerMock = null;

    @BeforeEach
    void setUp() {
        textTransformerMock = mock(TextTransformer.class);
    }

    @Test
    void testSpace() {
        when(textTransformerMock.get()).thenReturn(" ");
        Text newText = new DuplicatesElimination(textTransformerMock);
        assertEquals(" ", newText.get());
    }

    @Test
    void testConsecutiveDuplicates() {
        when(textTransformerMock.get()).thenReturn("do do do do");
        Text newText = new DuplicatesElimination(textTransformerMock);
        assertEquals("do", newText.get());
    }

    @Test
    void testSeparatedDuplicates() {
        when(textTransformerMock.get()).thenReturn("do do abc do do");
        Text newText = new DuplicatesElimination(textTransformerMock);
        assertEquals("do abc do", newText.get());
    }

    @Test
    void testSpecialCharacters() {
        when(textTransformerMock.get()).thenReturn("#$%^&*()");
        Text newText = new DuplicatesElimination(textTransformerMock);
        assertEquals("#$%^&*()", newText.get());
    }

    @Test
    void testEmptyString() {
        when(textTransformerMock.get()).thenReturn("");
        Text newText = new DuplicatesElimination(textTransformerMock);
        assertEquals("", newText.get());
    }
}