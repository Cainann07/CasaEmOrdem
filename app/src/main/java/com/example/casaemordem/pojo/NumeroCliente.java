package com.example.casaemordem.pojo;

public class NumeroCliente {

    private String UUID;

    private String NumeroClente;

    public NumeroCliente(String UUID, String numeroClente) {
        this.UUID = UUID;
        this.NumeroClente = numeroClente;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getNumeroClente() {
        return NumeroClente;
    }

    public void setNumeroClente(String numeroClente) {
        NumeroClente = numeroClente;
    }
}
