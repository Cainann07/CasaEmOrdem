package com.example.casaemordem.pojo;

public class HorarioCliente {

    private String UUID;

    private String HorarioClente;

    public HorarioCliente(String UUID, String horarioClente) {
        this.UUID = UUID;
        this.HorarioClente = horarioClente;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getHorarioClente() {
        return HorarioClente;
    }

    public void setHorarioClente(String horarioClente) {
        HorarioClente = horarioClente;
    }
}
