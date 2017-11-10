package ru.whitek0t.xo.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileBasedXOPropertyTest {
    @Test
    public void testGetInstance() throws Exception {
        FileBasedXOProperty testInstance = FileBasedXOProperty.getInstance();
        assertNotNull(testInstance);
    }

    @Test
    public void testGetSeparatorChar() throws Exception {
        final Character exceptedResult = '~';
        FileBasedXOProperty testInstance = FileBasedXOProperty.getInstance();
        final Character actualResult = testInstance.getSeparatorChar();

        assertEquals(exceptedResult, actualResult);
    }

    @Test
    public void testGetTemplateLine() throws Exception {
        final String exceptedResult = "%2s | %s | %s";
        FileBasedXOProperty testInstance = FileBasedXOProperty.getInstance();
        final String actualResult = testInstance.getTemplateLine();

        assertEquals(exceptedResult, actualResult);
    }
}