package com.example.casaemordem;

import android.app.Application;

public class DadosCompartilhadosActivity extends Application {

    private String UuidUsuarioLogado;

    public DadosCompartilhadosActivity(String uuidUsuarioLogado) {
        UuidUsuarioLogado = uuidUsuarioLogado;
    }

    public DadosCompartilhadosActivity(){

    }

    public String getUuidUsuarioLogado() {
        return UuidUsuarioLogado;
    }

    public void setUuidUsuarioLogado(String uuidUsuarioLogado) {
        UuidUsuarioLogado = uuidUsuarioLogado;
    }
}