package edu.teamrocket.bicipalma.domain.bicicleta;

public class Bicicleta implements Movil {

    private Integer id;

    public Bicicleta(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id.intValue();
    }

    @Override
    public String toString() {
        return this.id.toString();
    }
}