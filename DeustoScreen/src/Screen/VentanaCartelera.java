package Screen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class VentanaCartelera extends JFrame{

	private JPanel pCentro, pSur;
	private JButton btnAtras; 
	private DefaultTableModel modelo;
	private JTable tabla;
	private JScrollPane scroll;
	private FlowLayout layoutTabla;
	
	 
	
	public VentanaCartelera() {
		super();
		setBounds(300, 300, 600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//PANELES
		pCentro = new JPanel();
		pSur = new JPanel();
		
		//POSICION DE PANELES
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		//BOTONES
		btnAtras = new JButton("ATRÁS");
		
		//ACCIONES DE BOTONES
				btnAtras.addActionListener((e)-> {
					dispose();
					
						
					});
		
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
		modelo.addRow(fila1);
		modelo.addRow(fila2);
		modelo.addRow(fila3);
		modelo.addRow(fila4);
		
		
		//AÑADIR LOS COMPONENTES A LOS PANELES
		pCentro.add(tabla);
		pSur.add(btnAtras);
		
		
		//DEFINIR VENTANA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds (0,0,1000,750);
		setVisible(true);
		
		
}
	
	//PRUEBA DE LA VENTANA CON MAIN
		public static void main(String[] args) {
			VentanaCartelera VC = new VentanaCartelera();	
				
		
		}
}