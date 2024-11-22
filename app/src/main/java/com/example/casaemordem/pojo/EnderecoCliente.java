package com.example.casaemordem.pojo;

public class EnderecoCliente {

    private String UUID;

    private String LocalEndereco;

    private String NumeroEndereco;

    private String Complemento;

    private String Referencia;

    public EnderecoCliente(){}

    public EnderecoCliente(String UUID, String localEndereco, String numeroEndereco, String complemento, String referencia) {
        this.UUID = UUID;
        this.LocalEndereco = localEndereco;
        this.NumeroEndereco = numeroEndereco;
        this.Complemento = complemento;
        this.Referencia = referencia;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getLocalEndereco() {
        return LocalEndereco;
    }

    public void setLocalEndereco(String localEndereco) {
        LocalEndereco = localEndereco;
    }

    public String getNumeroEndereco() {
        return NumeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        NumeroEndereco = numeroEndereco;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String referencia) {
        Referencia = referencia;
    }
}
