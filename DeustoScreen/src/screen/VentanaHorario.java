package screen;

import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

import com.toedter.calendar.JCalendar;

import domain.Cine;
import domain.Usuario;

public class VentanaHorario extends JFrame{
	private JPanel pCentro, pSur, pNorte,pOeste;
	private JButton btnAtras, btnSiguiente; 
	private DefaultTableModel modelo;
	private JTable tabla;
	private JScrollPane scroll;
	private FlowLayout layoutTabla;
	private JLabel lblTituloH;
	private JFrame vActual, vAnterior;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	private JCalendar calendario; 
	public static int dia,mes,anio,dia2;
	public VentanaHorario(JFrame va, Usuario u) {
		super();
		vActual=this;
		vAnterior = va;
		
		Cine.crearMapaHorarios();
		
		//LABEL
		lblTituloH = new JLabel("HORARIOS");
		
		
		//PANELES
		pCentro = new JPanel();
		pSur = new JPanel();
		pNorte = new JPanel();
		pOeste = new JPanel();
		
		//POSICION DE PANELES
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pOeste, BorderLayout.WEST);
		
		//CALENDARIO
		calendario = new JCalendar(new Date());
		setMinimumDate(calendario);
		pOeste.add(calendario);
		
		modelo = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		String [] titulos = {"HORA","SALA1","SALA2","SALA3"};
		modelo.setColumnIdentifiers(titulos);
		tabla = new JTable(modelo);
		scroll = new JScrollPane(tabla);
		
		
		//ACCIONES DE CALENDARIO
		calendario.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				Date d = calendario.getDate();
				dia = d.getDay(); 
				//mes = d.getMonth();
				//anio = d.getYear();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String fecha = sdf.format(d);
				dia2 = Integer.parseInt(fecha.split("-")[0]);
				mes = Integer.parseInt(fecha.split("-")[1]);
				anio = Integer.parseInt(fecha.split("-")[2]);
				System.out.println(dia+"-"+mes+"-"+anio);
				if(dia == 0) {
					dia = 7;
				}
				
				dia--;
				modelo.setRowCount(0);
				TreeMap<String, HashMap<Integer, ArrayList<String>>> mapa = new TreeMap<>(Cine.getMapaHorarios());
				for(String hora: mapa.keySet()) {
					Object [] fila = new Object[4];
					fila[0] = hora;
					int i=1;
					for(int sala: mapa.get(hora).keySet()) {
						String peli = mapa.get(hora).get(sala).get(dia);
						fila[i++] = peli;
					}
					modelo.addRow(fila);
				}
				logger.log(Level.INFO, "SE HAN HECHO LAS ACCIONES DEL CALENDARIO");
				}
		});
		
		
		
		
		//BOTONES
		btnAtras = new JButton("Atrás");
		btnSiguiente = new JButton("Siguiente");
		
		//ACCIONES DE BOTONES
		btnAtras.addActionListener((e)-> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			vActual.dispose();
			vAnterior.setVisible(true);
						
					});
		btnSiguiente.addActionListener((e)-> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON SIGUIENTE");
			
			new VentanaEntradas(vActual, u, dia2, mes , anio);
			vActual.setVisible(false);
			vActual.dispose();
		});
				
		//LABEL
		pNorte.add(lblTituloH);
		
		//AÑADIR LOS COMPONENTES A LOS PANELES
		pCentro.add(scroll);
		pSur.add(btnAtras);
		pSur.add(btnSiguiente);
		
		
		//DEFINIR VENTANA
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds (600,300,1000,750);
		setTitle("HORARIO");
		setVisible(true);
		
	}	
	private static void setMinimumDate(JCalendar calendario) {
        Calendar minDate = Calendar.getInstance();
        minDate.setTime(new Date());  // Establece la fecha mínima como la fecha y hora actuales

       
        calendario.setMinSelectableDate(minDate.getTime());
    }
}
