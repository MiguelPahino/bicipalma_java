package edu.teamrocket.bicipalma.domain.tarjetausuario;

public class TarjetaUsuario implements Autenticacion {
    private String id;
    private boolean activada = false;

    TarjetaUsuario(String idInicio, Boolean activo) {
        this.id = idInicio;
        this.activada = activo;
    }

    @Override
    public Boolean isActivada() {
        return this.activada;
    }

    public void setActivada(Boolean estado) {
        this.activada = estado;
    }

    @Override
    public String toString() {
        return this.id;
    }

}