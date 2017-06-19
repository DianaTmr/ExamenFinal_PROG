package models;


public class Pokemon {
	
	// Atributos
	private String nombre, region, comentarios, tipo;
	private int numero, nivel;
	private boolean existe;
	
	
	// Constructor
	public Pokemon(String nombre, String region, String tipo, String comentarios, int numero, int nivel) {
		super();
		this.nombre = nombre;
		this.region = region;
		this.tipo = tipo;
		this.comentarios = comentarios;
		this.numero = numero;
		this.nivel = nivel;
		this.existe = true;
	}
	
	
	// Getters && Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public boolean isExiste() {
		return existe;
	}
	public void setExiste(boolean existe) {
		this.existe = existe;
	}
	
	
}