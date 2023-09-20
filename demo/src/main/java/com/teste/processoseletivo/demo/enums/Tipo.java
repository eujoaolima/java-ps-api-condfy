package com.teste.processoseletivo.demo.enums;

public enum Tipo {
    MAIN(0), SUB(1);

    private int codigo;

    private Tipo (int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static Tipo valueOf(int codigo) {
        for (Tipo value : Tipo.values()) {
            if (value.getCodigo() == codigo) {
                return value;
            }
        }
        throw new IllegalArgumentException("Tipo de protocolo inválido");
    }
}
