package com.example.casaemordem.pojo;

public class UsuarioProfissional {

    private String UUID;

    private String nome;

    private String email;

    private String senha;

    private String confirmaSenha;

    private String profissao;

    public UsuarioProfissional(){}

    public UsuarioProfissional(String UUID, String nome, String email, String senha, String profissao) {
        this.UUID = UUID;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.profissao = profissao;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}
