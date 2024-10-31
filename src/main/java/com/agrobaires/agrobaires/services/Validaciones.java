package com.agrobaires.agrobaires.services;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class Validaciones {

    private static final int LONGITUD_NRO_TELEFONICO = 10;
    private static final int LONGITUD_CUIT = 11;
    private static final String REGEX_NUMERICO = "^[0-9]+$";
    private static final String EMAIL_REGEX = "^[\\w!#$%&'*+-]+(\\.[\\w!#$%&'*+-]+)*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    public boolean isEmailValido(String email){
        email = email.toLowerCase();
        if (email != null && email != "") {
            String[] localPart = email.split("@",2);
            if (localPart[0].length() <= 64 && email.length() <= 253) {
                if (Pattern.matches(EMAIL_REGEX, email) )
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    public boolean validarNumeroTelefono(String telefono) {
        return contieneSoloNumeros(telefono) && longitudValidaTelefono(telefono);
    }

    public boolean validarFormatoCuit(String cuit) {
        return contieneSoloNumeros(cuit) && longitudValidaCuit(cuit);
    }

    private static boolean longitudValidaTelefono(String telefono) {
        return telefono.length() == LONGITUD_NRO_TELEFONICO;
    }

    private static boolean longitudValidaCuit(String cuit) {
        return cuit.length() == LONGITUD_CUIT;
    }

    private static boolean contieneSoloNumeros(String numero) {
        if (numero != null && numero != "") {
            return Pattern.matches(REGEX_NUMERICO, numero);
        }
        return false;
    }


}
