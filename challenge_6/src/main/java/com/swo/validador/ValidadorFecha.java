package com.swo.validador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public class ValidadorFecha {
    private static final List<DateTimeFormatter> FORMATTERS = Arrays.asList(
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
            DateTimeFormatter.ofPattern("MM-dd-yyyy"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy")
    );

    public static boolean esFechaValida(String fecha) {
        if (fecha == null || fecha.trim().isEmpty()) {
            return false;
        }
        String input = fecha.trim();
        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                LocalDate date = LocalDate.parse(input, formatter);
                // Validar que la fecha formateada sea igual a la entrada normalizada
                if (!date.format(formatter).equals(input)) {
                    continue;
                }
                if (date.getYear() < 2000 || date.getYear() > 2099) {
                    return false;
                }
                return true;
            } catch (DateTimeParseException e) {
                // Intenta con el siguiente formato
            }
        }
        return false;
    }
}
