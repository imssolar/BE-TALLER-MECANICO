package com.tallermecanico.util;

public class TextUtils {

    /**
     * Normaliza un texto: trim, lowercase, y convierte espacios múltiples en uno solo
     * Equivalente a la función normalizeText() de NestJS
     *
     * @param text el texto a normalizar
     * @return el texto normalizado
     */
    public static String normalizeText(String text) {
        if (text == null || text.isBlank()) {
            return text;
        }

        return text.trim()
                   .toLowerCase()
                   .replaceAll("\\s+", " ");
    }

    private TextUtils() {
        // Utility class, no se debe instanciar
    }
}
