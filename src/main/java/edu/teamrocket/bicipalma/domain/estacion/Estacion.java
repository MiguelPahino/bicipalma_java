package edu.teamrocket.bicipalma.domain.estacion;

import java.util.Arrays;
import java.util.Optional;

import edu.teamrocket.bicipalma.domain.bicicleta.Movil;
import edu.teamrocket.bicipalma.domain.tarjetausuario.Autenticacion;

public class Estacion {

private final int id;
private final String direccion;
private final Anclajes anclajes;

public Estacion(int id, String direccion, int numeroAnclajes){
    this.id = id;
    this.direccion = direccion;
    this.anclajes = new Anclajes(numeroAnclajes);
}

public int getId() {
    return id;
}

public String getDireccion() {
    return direccion;
}

private Anclaje[] anclajes(){
    return this.anclajes.anclajes();
}

private int numAnclajes(){
    return this.anclajes.numAnclajes();
}

public void consultarEstacion() {
    System.out.println(this);
}

public long anclajesLibres() {
    long numAnclajesLibres = 0; 
    for (int i = 0; i < anclajes().length;i++ ){
        if ( !anclajes.isAnclajeOcupado(i)){
            numAnclajesLibres ++;
        }
    }
    return numAnclajesLibres;
}

public void anclarBicicleta(Movil bici){
    Optional<Anclaje> anclajeLibre = Optional.empty();

    for(int i = 0; i < anclajes().length;i++){
        if (!anclajes.isAnclajeOcupado(i)){
            anclajeLibre = Optional.of(anclajes()[i]);
        }
    }

    if (anclajeLibre.isPresent()) {
			anclajeLibre.get().anclarBici(bici);
		} else {
			System.out.println("No existen anclajes disponibles para bici " + bici);
		}

}

public boolean leerTarjetaUsuario(Autenticacion tarjetaUsuario) {
		return tarjetaUsuario.isActivada();
}


public void retirarBicicleta(Autenticacion tarjetaUsuario) {

		if (leerTarjetaUsuario(tarjetaUsuario)) {
			Optional<Anclaje> anclajeOcupado = Arrays.stream(anclajes()).filter(Anclaje::isOcupado).findAny();

			anclajeOcupado.ifPresentOrElse(Anclaje::liberarBici, Estacion::mensajeNoBiciDisponible);
        } 
        else {
			System.out.println("Tarjeta de usuario inactiva :(");
		}
	}

private static void mensajeNoBiciDisponible() {
		System.out.println("No hay bicis");	
}

public void consultarAnclajes() {

	for(int i = 0; i < anclajes().length;i++){
        Optional<Movil> bici = Optional.ofNullable(anclajes()[i].getBici());
        System.out.println("Anclaje " + bici.map(Movil::toString).orElse("libre"));
    }

	}

@Override
public String toString() {	
	return String.format("id: %d %ndireccion: %s %nanclajes: %s", 
							getId(), getDireccion(), numAnclajes());
}



}