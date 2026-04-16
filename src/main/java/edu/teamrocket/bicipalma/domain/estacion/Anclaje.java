package edu.teamrocket.bicipalma.domain.estacion;

import edu.teamrocket.bicipalma.domain.bicicleta.*;

public class Anclaje {

    private Boolean ocupado = false;
    private Movil bici;

    Boolean isOcupado() {
        return this.ocupado;
    }

    Movil getBici() {
        return bici;
    }

    void anclarBici(Movil bici) {
        this.bici = bici;
    }

    void liberarBici() {
        this.bici = null;
        this.ocupado = false;
    }

    @Override
    public String toString() {
        return "ocupado: " + Boolean.toString(isOcupado());
    }

}