package ru.whitek0t.xo.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileBasedXOProperty implements IXOProperty{

    static FileBasedXOProperty instance;

    private static final String PROPERTY_FILE = "xo.properties";

    private static final String SEPARATOR_KEY = "Separator";

    private static final String TEMPLATE_LINE = "TemplateLine";

    private final Properties properties;

    public static FileBasedXOProperty getInstance() throws IOException {
        if (instance == null) {
            synchronized (FileBasedXOProperty.class) {
                if (instance == null) {
                    final Properties properties = new Properties();
                    InputStream is = FileBasedXOProperty.class.getResourceAsStream(PROPERTY_FILE);
                    properties.load(is);
                    is.close();
                    instance = new FileBasedXOProperty(properties);
                }
            }
        }
        return instance;
    }

    @Override
    public Character getSeparatorChar() {
        return properties.getProperty(SEPARATOR_KEY).charAt(0);
    }

    @Override
    public String getTemplateLine() {
        return properties.getProperty(TEMPLATE_LINE);
    }

    private FileBasedXOProperty(Properties properties) {
        this.properties = properties;
    }
}
