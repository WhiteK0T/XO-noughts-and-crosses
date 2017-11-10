package ru.whitek0t.xo.common;

import ru.whitek0t.xo.model.exceptions.XOCriticalException;

import java.io.IOException;

public interface IXOProperty {

    Character getSeparatorChar();

    String getTemplateLine();

    static IXOProperty getDefaultProperties() {
        try {
            return FileBasedXOProperty.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
            throw new XOCriticalException(e);
        }
    }
}
