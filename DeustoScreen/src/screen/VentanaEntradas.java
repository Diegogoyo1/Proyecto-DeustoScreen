package screen;

import javax.swing.JFrame;   
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import domain.Cine;
import domain.Usuario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;



public class VentanaEntradas extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel panelNorth, panelEast, panelWest, panelCenter, panelSouth;
	protected JButton BtnAtras, BtnSiguiente;
	private JLabel lblEntradas, lblPelicula, lblHorarios;
	private JFrame vActual, vAnterior;


	private static JComboBox<String> cbTitulos;
	private static JComboBox<String> cbHorarios;

	private static Logger logger = Logger.getLogger(Main.class.getName());

	private static String hora;

	public VentanaEntradas(JFrame va, Usuario u, int dia, int mes, int anio) {
		
		Cine.crearMapaHorarios();
		vActual=this;
		vAnterior=va;
		
		//CREACION DE PANELES
		 panelNorth = new JPanel();
		 panelEast = new JPanel();
		 panelWest = new JPanel();
		 panelCenter = new JPanel();
		 panelSouth = new JPanel();
		 
		//AÑADIMOS LOCALIZACION A PANELES Y COLUMNAS
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		getContentPane().add(panelEast, BorderLayout.EAST);
		getContentPane().add(panelEast, BorderLayout.EAST);
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		getContentPane().add(panelSouth, BorderLayout.SOUTH);
		 panelCenter.setBorder(BorderFactory.createEmptyBorder(40, 1000, 10, 1000));

		//CREACION DE LABELS, COMBOBOX Y BOTONES
		lblEntradas = new JLabel("Entradas", SwingConstants.CENTER);
		lblEntradas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelNorth.add(lblEntradas);
		
		lblPelicula = new JLabel("Pelicula", SwingConstants.CENTER);
		lblPelicula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCenter.add(lblPelicula);
		panelCenter.add(Box.createVerticalStrut(50));
		
		String []  titulos = Cine.obtenerTitulos();
		cbTitulos = new JComboBox<>(titulos);
		Dimension comboBoxSizeT = new Dimension(400, 40);
        cbTitulos.setPreferredSize(comboBoxSizeT);
        panelCenter.add(cbTitulos);
        panelCenter.add(Box.createVerticalStrut(100));
        
		lblHorarios = new JLabel("Sala y Horarios", SwingConstants.CENTER);
		lblHorarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelCenter.add(lblHorarios);
		panelCenter.add(Box.createVerticalStrut(50));
		
		cbHorarios = new JComboBox<>();
        cbHorarios.setPreferredSize(comboBoxSizeT);
        panelCenter.add(cbHorarios);
        
        lblEntradas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPelicula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHorarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		

		BtnAtras = new JButton("Atrás");
		BtnSiguiente = new JButton("Siguiente");
		panelSouth.add(BtnAtras);
		panelSouth.add(BtnSiguiente);
		
		cbTitulos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA CAMBIADO DE PELICULA");
				cargarComboHorarios();
				
			}
			
		});
		
		cbHorarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.INFO, "SE HA SELECCIONADO EL HORARIO");
				String sel = cbHorarios.getSelectedItem().toString();
				hora = sel.split(":")[0]+"_"+sel.split(":")[1];
			}
		});
		
		
		//ACTIONLISTENER DE LOS BOTONES
		BtnAtras.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			vActual.dispose();
			vAnterior.setVisible(true);
		});
		
		BtnSiguiente.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON SIGUIENTE");
			int sala = Integer.parseInt(cbHorarios.getSelectedItem().toString().split("-")[0]);
			new VentanaSeleccionEntradas(vActual, u, sala,dia,mes,anio,hora);

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
	
	/**
	 * Metodo que obtiene el item del combo titulos
	 * @return devuelve el item del combo titulos
	 */
	public static String getComboTitulos() {
		return (String) cbTitulos.getSelectedItem();
	}
	
	/**
	 * Metodo que carga el combo de horarios
	 */
	private void cargarComboHorarios() {
		cbHorarios.removeAllItems();
		String pelicula = cbTitulos.getSelectedItem().toString();
		TreeMap<String, HashMap<Integer, ArrayList<String>>> mapa = new TreeMap<>(Cine.getMapaHorarios());
		for(String hora: mapa.keySet()) {
			for(int sala: mapa.get(hora).keySet()) {
				if(mapa.get(hora).get(sala).get(VentanaHorario.dia).equals(pelicula)) {
					cbHorarios.addItem(sala+"-"+hora);
					logger.log(Level.INFO, "SE HA CARGADO EN LA COMBO LOS HORARIOS");
				}
				
			}
		}
	}
	
	
	public static String getComboHorarios() {
		return (String) cbHorarios.getSelectedItem();
	}
}
