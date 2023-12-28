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
import java.util.ArrayList;
import java.util.Arrays;
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
	public static int dia;
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
		pOeste.add(calendario);
		
		DefaultTableModel modelo = new DefaultTableModel();
		String [] titulos = {"HORA","SALA1","SALA2","SALA3"};
		modelo.setColumnIdentifiers(titulos);
		JTable tabla = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(tabla);
		
		
		//ACCIONES DE CALENDARIO
		calendario.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				Date d = calendario.getDate();
				dia = d.getDay(); 
				if(dia == 0) {
					dia = 7;
				}
				dia--;
				//Mapa de clave horario , valor mapa de clave sala y valor lista de películas película
				/*TreeMap<String, HashMap<Integer, ArrayList<String>>> mapa = new TreeMap<>();
				List<String> peliculas = Arrays.asList("P1","P3","P1","P4","P1","P3","P2");
				HashMap<Integer, ArrayList<String>> m = new HashMap<>();
				m.put(1, new ArrayList<>(peliculas));
				m.put(2, new ArrayList<>(peliculas));
				m.put(3, new ArrayList<>(peliculas));
				mapa.put("07:00", new HashMap<>(m));
				mapa.put("09:00", new HashMap<>(m));
				mapa.put("11:00", new HashMap<>(m));
				*/
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
			}
		});
		tabla.addMouseListener(new MouseListener() {
			
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
				/*if(e.getClickCount()==2) {
					Object intemSeleccionado = ((JComboBox<String>) e.getSource()).getSelectedItem();
					Cine..add(intemSeleccionado.toString());
					
				}
				
			}*/
				
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
			new VentanaEntradas(vActual, u);
			vActual.setVisible(false);
			vActual.dispose();
		});
				
		//LABEL
		pNorte.add(lblTituloH);
		
		//CREACIÓN TABLA
		/*Object [] titulos = {"HORA","LUNES","MARTES", "MIÉRCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"};
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(titulos);
		tabla = new JTable(modelo);
		layoutTabla = new FlowLayout();
		layoutTabla.setVgap(175);
		pCentro.setLayout(layoutTabla);
		scroll = new JScrollPane(tabla);
		
		getContentPane().add(scroll, BorderLayout.EAST);
		
		tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(5).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(6).setPreferredWidth(100);
		tabla.getColumnModel().getColumn(7).setPreferredWidth(100);
		tabla.setRowHeight(75);
		
		
		String fila1[] =  {"7:00","P1(sala1)","P3(sala1)","P3(sala1)", "P1(sala1)", "P1(sala1)", "P1(sala1)", "P1(sala1)"};
		String fila2[] =  {"----","P2(sala2)","P3(sala1)","P3(sala1)", "P1(sala1)", "P1(sala1)", "P1(sala1)", "P1(sala1)"};
		String fila3[] =  {"8:15"," X ","P3(sala1)","P3(sala1)", "P1(sala1)", "P1(sala1)", "P1(sala1)", "P1(sala1)"};
		String fila4[] =  {"9:30","P1(sala4)","P3(sala1)","P3(sala1)", "P1(sala1)", "P1(sala1)", "P1(sala1)", "P1(sala1)"};
		modelo.addRow(titulos);
		modelo.addRow(fila1);
		modelo.addRow(fila2);
		modelo.addRow(fila3);
		modelo.addRow(fila4);
		*/
		
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
		setTitle("CARTELERA");
		setVisible(true);
		
	}	
}
