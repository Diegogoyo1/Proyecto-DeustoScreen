package screen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.Cine;
import domain.Peliculas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;


public class VentanaEntradas extends JFrame{
	protected JPanel panelNorth, panelEast, panelWest, panelCenter, panelSouth;
	protected JButton BtnAtras, BtnSiguiente;
	private JLabel lblEntradas, lblPelicula, lblHorarios;
	private JFrame vActual, vAnterior;
	//private List<Peliculas> listaPeliculas; 

	private JComboBox<String> cbTitulos;
	//private JComboBox<String> cbHorarios;
	
	public VentanaEntradas(JFrame va) {
		
		//cargarFichero("datos/Peliculas.csv");
		vActual=this;
		vAnterior=va;
		
		//Creacion de Paneles
		 panelNorth = new JPanel();
		 panelEast = new JPanel();
		 panelWest = new JPanel();
		 panelCenter = new JPanel();
		 panelSouth = new JPanel();
		 
		//Añadimos localizacion a paneles y columnas
		panelCenter.setBorder(BorderFactory.createEmptyBorder(40, 100, 10, 100));
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		getContentPane().add(panelEast, BorderLayout.EAST);
		getContentPane().add(panelEast, BorderLayout.EAST);
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		getContentPane().add(panelSouth, BorderLayout.SOUTH);
		panelCenter.setLayout(new GridLayout(0, 2, 0, 0));
		 panelCenter.setBorder(BorderFactory.createEmptyBorder(40, 100, 10, 100));

		//Creacion de Labels, ComboBox y Botones
		lblEntradas = new JLabel("Entradas", SwingConstants.CENTER);
		lblPelicula = new JLabel("Pelicula", SwingConstants.CENTER);
		lblHorarios = new JLabel("Horarios", SwingConstants.CENTER);
		Cine.cargarPeliculasEnLista("ficheros/TitulosPeliculas.csv");
		String []  titulos = Cine.obtenerTitulos();
		cbTitulos = new JComboBox<>(titulos);
		Dimension comboBoxSizeT = new Dimension(200, 30);
        cbTitulos.setPreferredSize(comboBoxSizeT);
        //cbHorarios.setPreferredSize(comboBoxSize);
        lblEntradas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPelicula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHorarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JComboBox<String> comBoxPelicula = new JComboBox<String>();
		JComboBox comBoxHorarios = new JComboBox();

		BtnAtras = new JButton("Atrás");
		BtnSiguiente = new JButton("Siguiente");
		lblEntradas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPelicula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHorarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		Dimension comboBoxSizeH = new Dimension(200, 30);
        comBoxPelicula.setPreferredSize(comboBoxSizeH);
		
		//Añadimos todo lo anterior a paneles
		panelNorth.add(lblEntradas);
		panelCenter.add(lblPelicula);
		panelCenter.add(cbTitulos);
		panelCenter.add(lblHorarios);
		//panelCenter.add(comBoxHorarios);
		panelSouth.add(BtnAtras);
		panelSouth.add(BtnSiguiente);
		
		
		List<Peliculas> listaPeliculas = Cine.obtenerListaPeliculas();

		for (Peliculas pelicula : listaPeliculas) {
			    comBoxPelicula.addItem(pelicula.getNombrePeli());
			}
		
		//ActionListener de los botones
		BtnAtras.addActionListener((e)->{
			vActual.dispose();
			vAnterior.setVisible(true);
		});
		
		BtnSiguiente.addActionListener((e)->{
			new VentanaSeleccionEntradas(vActual);
			vActual.setVisible(false);
			vActual.dispose();
		});
		
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300,500, 500);
		setTitle("ENTRADAS");
		setVisible(true);
	}
	
//	public static void main(String[] args) {
//		VentanaEntradas va = new VentanaEntradas(null);
//	}
}
