package controlador;



import java.util.Calendar;

import GUI.Application;
import commons.*;
import models.Pokemon;

public class Controlador {
	private static Application app;
	private static boolean firstTime = true;
	
	
	public Controlador(){
		app = new Application();
	}

	public static void cargarVentana() {
		if (firstTime) {
			app.setTxtNombre("");
			app.setTxtRegion("");
			app.setTxtAreaComent("");
			app.setTxtNumero("");
			app.setTxtNivel("");
			app.setTipo("");
			firstTime = false;
		}else if (obtenerDatosActuales() != null) {
			app.setTxtNombre(String.valueOf(Contenedor.obtenerDatos().getNombre()));
			app.setTxtRegion(String.valueOf(Contenedor.obtenerDatos().getRegion()));
			app.setTxtAreaComent(String.valueOf(Contenedor.obtenerDatos().getComentarios()));
			app.setTxtNumero(String.valueOf(Contenedor.obtenerDatos().getNumero()));
			app.setTxtNivel(String.valueOf(Contenedor.obtenerDatos().getNivel()));
			app.setTipo(String.valueOf(Contenedor.obtenerDatos().getTipo()));
		}
	}
	public static Pokemon obtenerDatosActuales() {
		return Contenedor.obtenerDatos();
	}
	
	public void pulsarLeftArrow() {
		Contenedor.disminuirIndex();
		cargarVentana();
	}

	public void pulsarRightArrow() {
		Contenedor.aumentarIndex();
		cargarVentana();
	}
	public static void guardarPokemon() {
		Contenedor.aniadirPokemon(
				new Pokemon(app.getNombre(), app.getRegion(), app.getTipo(), app.getComentarios(), app.getNumero(), app.getNivel()));
		firstTime = true;
		cargarVentana();
	}
	public void pulsarBuscar() {
		Controlador.cargarVentana();
	}
	
}
