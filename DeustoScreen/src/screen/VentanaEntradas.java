package screen;

import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import domain.Cine;
import domain.Entrada;
import domain.Peliculas;
import domain.Usuario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class VentanaEntradas extends JFrame{
	protected JPanel panelNorth, panelEast, panelWest, panelCenter, panelSouth;
	protected JButton BtnAtras, BtnSiguiente;
	private JLabel lblEntradas, lblPelicula, lblHorarios;
	private JFrame vActual, vAnterior;
	private List<String> listaPeliHora; 

	private static JComboBox<String> cbTitulos;
	private static JComboBox<String> cbHorarios;

	private static Logger logger = Logger.getLogger(Main.class.getName());

	

	public VentanaEntradas(JFrame va, Usuario u) {
		
		Cine.crearMapaHorarios();
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
		 panelCenter.setBorder(BorderFactory.createEmptyBorder(40, 1000, 10, 1000));

		//Creacion de Labels, ComboBox y Botones
		lblEntradas = new JLabel("Entradas", SwingConstants.CENTER);
		lblEntradas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelNorth.add(lblEntradas);
		
		lblPelicula = new JLabel("Pelicula", SwingConstants.CENTER);
		lblPelicula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCenter.add(lblPelicula);
		panelCenter.add(Box.createVerticalStrut(50));
		
		Cine.cargarPeliculasEnLista("ficheros/TitulosPeliculas.csv");
		String []  titulos = Cine.obtenerTitulos();
		cbTitulos = new JComboBox<>(titulos);
		Dimension comboBoxSizeT = new Dimension(400, 40);
        cbTitulos.setPreferredSize(comboBoxSizeT);
        panelCenter.add(cbTitulos);
        panelCenter.add(Box.createVerticalStrut(100));
        
		lblHorarios = new JLabel("Horarios", SwingConstants.CENTER);
		lblHorarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCenter.add(lblHorarios);
		panelCenter.add(Box.createVerticalStrut(50));
		
		cbHorarios = new JComboBox<>();
        cbHorarios.setPreferredSize(comboBoxSizeT);
        panelCenter.add(cbHorarios);
        
        lblEntradas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPelicula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHorarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		cbTitulos.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1) {
					Object PeliculaSeleccionada = ((JComboBox<String>) e.getSource()).getSelectedItem();
					listaPeliHora.add(PeliculaSeleccionada.toString());

				}

			}
		});


		cbHorarios.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==1) {
					Object horaSeleccinada = ((JComboBox<String>) e.getSource()).getSelectedItem();
					listaPeliHora.add(horaSeleccinada.toString());

				}



			
				
			}
		});
	

		System.out.println(listaPeliHora);
		BtnAtras = new JButton("Atrás");
		BtnSiguiente = new JButton("Siguiente");
		panelSouth.add(BtnAtras);
		panelSouth.add(BtnSiguiente);
		
		cbTitulos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarComboHorarios();
			}
		});
		
		
		//ActionListener de los botones
		BtnAtras.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			vActual.dispose();
			vAnterior.setVisible(true);
		});
		
		BtnSiguiente.addActionListener((e)->{
			Cine.aniadirEntrada((Entrada) listaPeliHora);
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON SIGUIENTE");
			new VentanaSeleccionEntradas(vActual, u);

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
	
	public static String getComboTitulos() {
		return (String) cbTitulos.getSelectedItem();
	}
	
	
	private void cargarComboHorarios() {
		cbHorarios.removeAllItems();
		String pelicula = cbTitulos.getSelectedItem().toString();
		TreeMap<String, HashMap<Integer, ArrayList<String>>> mapa = new TreeMap<>(Cine.getMapaHorarios());
		for(String hora: mapa.keySet()) {
			for(int sala: mapa.get(hora).keySet()) {
				if(mapa.get(hora).get(sala).get(VentanaHorario.dia).equals(pelicula)) {
					cbHorarios.addItem(hora);
				}
				
			}
		}
	}
	
	public static String getComboHorarios() {
		return (String) cbHorarios.getSelectedItem();
	}
	
	public static void main(String[] args) {
		new VentanaEntradas(null, null);
	}
}
