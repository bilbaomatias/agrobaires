package com.agrobaires.agrobaires.context;


public enum RolUsuarioEnum {
    VENDEDOR("1"),
    PRODUCTOR("2"),
    COMPRADOR("3"),
    DEFAULT("4");

    private String rol;
    RolUsuarioEnum(String rol) {
        this.rol = rol;
    }

    public int getUserStatusNumber() {
        return Integer.valueOf(rol);
    }
}
