package com.agrobaires.agrobaires.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidacionesTest {
    @Autowired Validaciones validaciones;

    @Test
    public void testIsEmailValido(){
        assertFalse(validaciones.isEmailValido("tst@ejemplo"));
        assertFalse(validaciones.isEmailValido("4user.bilbao@yo.com.com.com"));

        assertTrue(validaciones.isEmailValido("matiasbilbao@gmail.com"));
    }

    @Test
    public void longitudValidaTelefono(){
        assertFalse(validaciones.validarNumeroTelefono("12345678123123"));
        assertFalse(validaciones.validarNumeroTelefono("11-3030-9090"));

        assertTrue(validaciones.validarNumeroTelefono("1130309090"));
    }

    @Test
    public void validarFormatoCuit(){
        assertTrue(validaciones.validarFormatoCuit("20123456789"));
        assertTrue(validaciones.validarFormatoCuit("20023456789"));

        assertFalse(validaciones.validarFormatoCuit("20-02345678-9"));
        assertFalse(validaciones.validarFormatoCuit("20-02.345.678-9"));
    }
}
