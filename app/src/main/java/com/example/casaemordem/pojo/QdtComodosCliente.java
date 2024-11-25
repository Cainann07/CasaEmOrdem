package com.example.casaemordem.pojo;

public class QdtComodosCliente {

    private String UUID;

    private String QuantidadeComodosCliente;

    public QdtComodosCliente(){}

    public QdtComodosCliente(String UUID, String quantidadeComodosCliente) {
        this.UUID = UUID;
        this.QuantidadeComodosCliente = quantidadeComodosCliente;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getQuantidadeComodosCliente() {
        return QuantidadeComodosCliente;
    }

    public void setQuantidadeComodosCliente(String quantidadeComodosCliente) {
        QuantidadeComodosCliente = quantidadeComodosCliente;
    }
}
