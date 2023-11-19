package screen;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class VentanaHorario extends JFrame{
	private JPanel pCentro, pSur, pNorte;
	private JButton btnAtras; 
	private DefaultTableModel modelo;
	private JTable tabla;
	private JScrollPane scroll;
	private FlowLayout layoutTabla;
	private JLabel lblTituloH;
	private JFrame vActual, vAnterior;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	 
	
	public VentanaHorario(JFrame va) {
		super();
		vActual=this;
		vAnterior = va;
		
		
		//LABEL
		lblTituloH = new JLabel("HORARIOS");
		
		
		//PANELES
		pCentro = new JPanel();
		pSur = new JPanel();
		pNorte = new JPanel();
		
		//POSICION DE PANELES
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pNorte, BorderLayout.NORTH);
		
		
		//BOTONES
		btnAtras = new JButton("Atrás");
		
		//ACCIONES DE BOTONES
		btnAtras.addActionListener((e)-> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			vActual.dispose();
			vAnterior.setVisible(true);
						
					});
				
		//LABEL
		pNorte.add(lblTituloH);
		
		//CREACIÓN TABLA
		Object [] titulos = {"HORA","LUNES","MARTES", "MIÉRCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"};
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
		
		
		//AÑADIR LOS COMPONENTES A LOS PANELES
		pCentro.add(tabla);
		pSur.add(btnAtras);
		
		
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
