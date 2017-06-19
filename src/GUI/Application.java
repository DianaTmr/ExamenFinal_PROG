package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import commons.Contenedor;
import commons.ListaOrdenada;
import controlador.Controlador;
import models.Pokemon;

public class Application extends JFrame {

	private ListaOrdenada<Pokemon> lista;
	private JTextField txtNombre;
	private JTextField txtNumero;
	private JTextField txtNivel;
	private JTextField txtRegion;
	private JLabel lblNombre;
	private JLabel lblNumero;
	private JLabel lblNivelEvolucion;
	private JLabel lblRegin;
	private JLabel lblTipo;
	private JLabel lblComentarios;
	private JButton btnInsertar;
	private JButton btnBuscar;
	private JLabel lblPokedex;
	private JTextArea txtAreaComent;
	private JComboBox cmboxTipo;
	private JButton btnLeft, btnRight;
	private JLabel lblContador;
	
	
	/**
	 * Create the application.
	 */
	public Application() {
		lista = Contenedor.getInstance().getLista();
		getContentPane().setBackground(new Color(240, 230, 140));
		setTitle("Pokedex v1.0");
		setBounds(100, 100, 549, 345);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//=======//
		initialize();
		addons();
		setProperties();
		listeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		lblNombre = new JLabel("Nombre");
		lblNumero = new JLabel("N\u00FAmero");
		lblNivelEvolucion = new JLabel("Nivel");
		lblRegin = new JLabel("Regi\u00F3n");
		lblTipo = new JLabel("Tipo");
		lblComentarios = new JLabel("Comentarios");
		btnInsertar = new JButton("Insertar nuevo");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}});
		btnBuscar = new JButton("Buscar");
		lblPokedex = new JLabel("POKEDEX");
		txtNombre = new JTextField();
		txtNumero = new JTextField();
		txtNivel = new JTextField();
		txtRegion = new JTextField();
		txtAreaComent = new JTextArea();
		cmboxTipo = new JComboBox();
		cmboxTipo.setModel(new DefaultComboBoxModel(new String[] {"Fuego", "Agua", "Planta", "El\u00E9ctrico"}));
		btnLeft = new JButton("<");
		btnRight = new JButton(">");
		lblContador = new JLabel("0/0");
	}
	
	private void addons(){
		getContentPane().setLayout(null);
		getContentPane().add(lblNombre);
		getContentPane().add(lblNumero);
		getContentPane().add(lblNivelEvolucion);
		getContentPane().add(lblRegin);
		getContentPane().add(lblTipo);
		getContentPane().add(lblComentarios);
		getContentPane().add(btnInsertar);
		getContentPane().add(btnBuscar);
		getContentPane().add(lblPokedex);
		getContentPane().add(txtNombre);
		getContentPane().add(txtNumero);
		getContentPane().add(txtNivel);
		getContentPane().add(txtRegion);
		getContentPane().add(txtAreaComent);
		getContentPane().add(cmboxTipo);
		getContentPane().add(btnLeft);
		getContentPane().add(btnRight);
		getContentPane().add(lblContador);
	}
	
	private void setProperties(){
		lblNombre.setBounds(36, 70, 71, 14);
		lblNumero.setBounds(36, 106, 71, 14); 
		lblNivelEvolucion.setBounds(36, 140, 71, 14);
		lblRegin.setBounds(36, 177, 71, 14);	
		lblTipo.setBounds(279, 70, 57, 14);		
		lblComentarios.setBounds(279, 149, 96, 20);	
		btnInsertar.setBounds(70, 250, 130, 34);		
		btnBuscar.setBounds(309, 250, 123, 34);
		lblPokedex.setFont(new Font("Stencil", Font.BOLD, 23));
		lblPokedex.setBounds(195, 14, 143, 27);
		txtNombre.setBounds(128, 67, 86, 20);	
		txtNombre.setColumns(10);	
		txtNumero.setBounds(128, 103, 86, 20);
		txtNumero.setColumns(10);
		txtNivel.setColumns(10);
		txtNivel.setBounds(128, 137, 86, 20);
		txtRegion.setColumns(10);
		txtRegion.setBounds(128, 174, 86, 20);	
		txtAreaComent.setBounds(279, 172, 181, 56);	
		cmboxTipo.setBounds(317, 67, 143, 20);
		btnLeft.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnLeft.setBounds(10, 11, 41, 34);	
		btnRight.setBounds(482, 11, 41, 34);
		lblContador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContador.setBounds(422, 15, 38, 23);
	}

	private void listeners(){
			// Boton insertar
			btnInsertar.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					Controlador.guardarPokemon();
					lista.add(new Pokemon(getNombre(), getRegion(), getTipo(), getComentarios(), getNumero(), getNivel()));
				}
		});
			btnBuscar.addMouseListener(new MouseAdapter(){
				@Override
				public void mousePressed(MouseEvent e){
		
					txtNombre.setEditable(false);
					txtNumero.setEditable(false);
					txtRegion.setEditable(false);
					cmboxTipo.setEnabled(false);
					txtNivel.setEditable(false);
					txtAreaComent.setEditable(false);
					txtAreaComent.setEnabled(false);
					Controlador.cargarVentana();
					
				}
			});
			
			
			
	}	

	
	/**
	 * Asigna el numero edl pokemon por parametro 
	 * @param s txtNumero
	 */
	public void setTxtNumero(String s) {
		txtNumero.setText(s);
	}
	/**
	 * Asigna el nivel del pokemon por parametro
	 * @param s 
	 */
	public void setTxtNivel(String s) {
		txtNivel.setText(s);
	}
	/**
	 * Asigna la region por parametro
	 * @param s region
	 */
	public void setTxtRegion(String s) {
		txtRegion.setText(s);
	}
	/**
	 * Asigna el comentario por parametro
	 * @param s comentario
	 */
	public void setTxtAreaComent(String s) {
		txtAreaComent.setText(s);
	}

	/**
	 * Devuelve el atributo nivel 
	 * @return nivel
	 */
	public int getNivel(){
		return Integer.parseInt(txtNivel.getText());
	}
	/**
	 * Devuelve el atributo comentario
	 * @return txtAreaComent
	 */
	public String getComentarios() {
		return txtAreaComent.getText();
	}
	/**
	 * Devuelve el atributo tipo del pokemon
	 * @return tipo
	 */
	public String getTipo(){
		return String.valueOf(cmboxTipo.getSelectedItem().toString());
	}
	/**
	 * Asigna el tipo del pokemon pasado por parametro
	 * @param string tipo del pokemon
	 */
	public void setTipo(String string){
		cmboxTipo.setSelectedItem(string);	
	}
	
	/**
	 * Devuelve el atributo nombre
	 * @return nombre
	 */
	public String getNombre() {
		return txtNombre.getText();
	}
	/**
	 * Devuelve el atributo numero
	 * @return numero
	 */
	public int getNumero(){
		return Integer.parseInt(txtNumero.getText());
	}
	/**
	 * Devuele el atributo region
	 * @return region
	 */
	public String getRegion() {
		return txtRegion.getText();
	}

	/***
	 * Asigna al atributo LblContador el parámetro
	 * @param e el LblContador que se quiere asignar
	 */
	public void setLblContador(String e) {
		lblContador.setText(e);
	}
	/**
	 * Asigna el atributo TxtNombre el parametro
	 * @param nombre el Nombre que se desea asignar
	 */
	public void setTxtNombre(String nombre) {
		txtNombre.setText(nombre);
	}
	
}
