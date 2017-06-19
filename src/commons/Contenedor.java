package commons;
import java.util.ArrayList;

import models.Pokemon;

public class Contenedor {
	private static final Contenedor contenedor = new Contenedor();
	private static ListaOrdenada<Pokemon> lista;
	private static int index;
	
	/**
	 * Crea un nuevo objeto de tipo contenedor.
	 */
	
	public Contenedor() {
		index = 0;
	}
	/**
	 * Devuelve la ListaOrdenada que contiene el contenedor.
	 * @return
	 */
	public ListaOrdenada getLista(){
		if(lista == null)
			lista = new ListaOrdenada<Pokemon>(
					(Pokemon p1, Pokemon p2) -> p2.getNumero()-(p1.getNumero()));
		return lista;
	}
	
	/*
	 * Devuelve la única instancia de la clase Contenedor que puede existir.
	 * @return una referencia al objeto Contenedor.
	 */
	public static Contenedor getInstance() {
        return contenedor;
    }
	/***
	 * Añade un Pokemon
	 * @param p
	 * @return Pokemon añadido
	 */
	public static boolean aniadirPokemon(Pokemon p) {
		return lista.add(p);
	}
	/* Obtiene los datos
	 * @param index la posicion del parte en la lista
	 * @return el parte
	 */
	public static Pokemon obtenerDatos(int index) {
		if (lista.get(index) != null) {
			return lista.get(index);
		} else {
			return null;
		}
	}
	/**
	 * Obtener un indice de la lista
	 * @return el indice del parte
	 */
	public static Pokemon obtenerDatos() {
		if (!lista.isEmpty()) {
			return obtenerDatos(index);
		} else {
			return null;
		}
	}
	/**
	 * Aumenta en 1 el indice
	 */
	public static void aumentarIndex() {
		if (index < lista.size() - 1 && !lista.isEmpty())
			index++;
	}
	/**
	 * Disminuye en 1 el indice
	 */
	public static void disminuirIndex() {
		if (index > 0 && !lista.isEmpty()) {
			index--;
		}
	}
	
}
