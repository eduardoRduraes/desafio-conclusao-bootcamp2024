package com.erd.desafio.model;

public enum UnidadeMedida {
    UNIDADE("Unidade", "UN"),
    PC("Peca", "PC"),
    MT("Metro", "MT"),
    KG("Kilograma", "KG"),
    PT("Pacote", "PT"),

    LT("Litro", "LT")
    ;

    private final String fullName;
    private final String abreviacao;

    UnidadeMedida(String fullName, String abreviacao) {
        this.fullName = fullName;
        this.abreviacao = abreviacao;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAbreviacao() {
        return abreviacao;
    }
}
