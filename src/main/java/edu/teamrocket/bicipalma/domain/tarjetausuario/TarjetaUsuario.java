package edu.teamrocket.bicipalma.domain.tarjetausuario;

public class TarjetaUsuario implements Autenticacion {
    private String id;
    private boolean activada = false;

    TarjetaUsuario(String id_inicio, Boolean activo) {
        this.id = id_inicio;
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