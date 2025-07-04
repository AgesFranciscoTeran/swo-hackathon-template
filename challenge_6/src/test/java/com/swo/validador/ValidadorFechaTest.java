package com.swo.validador;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidadorFechaTest {
    @Test
    void fechaValida_EnFormatosPermitidos_retornaTrue() {
        assertTrue(ValidadorFecha.esFechaValida("2024-12-01"));
        assertTrue(ValidadorFecha.esFechaValida("01/01/2025"));
        assertTrue(ValidadorFecha.esFechaValida("12-31-2025"));
        assertTrue(ValidadorFecha.esFechaValida("31-12-2025"));
    }

    @Test
    void fechaFueraDeRango_retornaFalse() {
        assertFalse(ValidadorFecha.esFechaValida("1999-12-31"));
        assertFalse(ValidadorFecha.esFechaValida("2100-01-01"));
    }

    @Test
    void fechaVaciaONula_retornaFalse() {
        assertFalse(ValidadorFecha.esFechaValida(""));
        assertFalse(ValidadorFecha.esFechaValida(null));
        assertFalse(ValidadorFecha.esFechaValida(" "));
    }

    @Test
    void formatoInvalido_retornaFalse() {
        assertFalse(ValidadorFecha.esFechaValida("31.12.2023"));
        assertFalse(ValidadorFecha.esFechaValida("2023/12/31"));
        assertFalse(ValidadorFecha.esFechaValida("fecha-random"));
    }

    @Test
    void fechaBisiestoCorrecta_retornaTrue() {
        assertTrue(ValidadorFecha.esFechaValida("29/02/2024"));
    }

    @Test
    void fechaBisiestoIncorrecta_retornaFalse() {
        assertFalse(ValidadorFecha.esFechaValida("29/02/2023"));
    }
}
