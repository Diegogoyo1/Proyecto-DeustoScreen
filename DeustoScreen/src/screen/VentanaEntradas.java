package screen;

import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.Peliculas;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;


public class VentanaEntradas extends JFrame{
	protected JPanel panelNorth, panelEast, panelWest, panelCenter, panelSouth;
	protected JButton BtnAtras, BtnSiguiente;
	private JLabel lblEntradas, lblPelicula, lblHorarios;
	private JFrame vActual, vAnterior;
	//private List<Peliculas> listaPeliculas; 

	
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
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		getContentPane().add(panelEast, BorderLayout.EAST);
		getContentPane().add(panelEast, BorderLayout.EAST);
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		getContentPane().add(panelSouth, BorderLayout.SOUTH);
		panelCenter.setLayout(new GridLayout(0, 2, 0, 0));
		
		//Creacion de Labels, ComboBox y Botones
		lblEntradas = new JLabel("Entradas");
		lblPelicula = new JLabel("Pelicula");
		lblHorarios = new JLabel("Horarios");
		JComboBox<Peliculas> comBoxPelicula = new JComboBox<Peliculas>();
		JComboBox comBoxHorarios = new JComboBox();
		BtnAtras = new JButton("Atrás");
		BtnSiguiente = new JButton("Siguiente");
		
		// Tamaño del ComboBox
		//comBoxHorarios.setPreferredSize(new Dimension(10,5));
		//comBoxPelicula.setPreferredSize(new Dimension(10,5));
		
		//Añadimos todo lo anterior a paneles
		panelNorth.add(lblEntradas);
		panelCenter.add(lblPelicula);
		panelCenter.add(comBoxPelicula);
		panelCenter.add(lblHorarios);
		panelCenter.add(comBoxHorarios);
		panelSouth.add(BtnAtras);
		panelSouth.add(BtnSiguiente);
		
		
		
		
		//if (!listaPeliculas.isEmpty()) {
            //comBoxPelicula.addItem(listaPeliculas.get(0)); // Agrega el primer elemento
        //}
  
			
			
		
		
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
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300,500, 500);
		setTitle("ENTRADAS");
		setVisible(true);
	}
	

}
