package edu.teamrocket.bicipalma.main.domain.bicicleta;

public class Bicicleta implements Movil {

    private Integer id;

    Bicicleta(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return Integer.toString(getId());
    }
}