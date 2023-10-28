package Screen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class VentanaButacas extends JFrame{
	private JPanel pNorte, pSur, pEste, pOeste;
	private JButton btnSiguiente, btnAtras;
	private JTable tblButacas1, tblButacas2;
	private DefaultTableModel modTblButacas1, modTblButacas2;
	private FlowLayout layoutTabButacas1, layoutTabButacas2;
	
	
	
	public VentanaButacas() {
		
		
		
		//PANELES
		pNorte = new JPanel();
		pSur = new JPanel();
		pEste = new JPanel();
		pOeste = new JPanel();
		
		
		
		//POSICION DE PANELES
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pEste, BorderLayout.EAST );
		getContentPane().add(pOeste, BorderLayout.WEST);

		
		//LABELS		
		
		
		
		//BOTONES
		btnAtras = new JButton("Atras");
		btnSiguiente = new JButton ("Siguiente");
		
		
		
		//ACCIONES DE BOTONES
		btnAtras.addActionListener((e)-> {
			dispose();
			
				
			});
		
		btnSiguiente.addActionListener((e)-> {
			VentanaPuntos ventanaPuntos = new VentanaPuntos();
			ventanaPuntos.setVisible(true);
		});
					
		
		
		//CREACION PRIMERA TABLA BUTACAS
		Object [] titulos1 = {"", "", "", "", "",""};
		modTblButacas1 = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modTblButacas1.setColumnIdentifiers(titulos1);
		tblButacas1 = new JTable(modTblButacas1);
		layoutTabButacas1  = new FlowLayout();
		layoutTabButacas1.setVgap(250);
		layoutTabButacas1.setHgap(100);
		pOeste.setLayout(layoutTabButacas1);
		
		tblButacas1.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(4).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(5).setPreferredWidth(100);
		tblButacas1.setRowHeight(100);
		/*tblButacas1.setIntercellSpacing(new Dimension(10,10));*/  //Para dejar espacio entre celdas
		tblButacas1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		
		String fila1[] =  {"A","01","02","03","04", "05"};
		String fila2[] =  {"B","01","02","03","04", "05"};
		String fila3[] =  {"C","01","02","03","04", "05"};
		String fila4[] =  {"D","01","02","03","04", "05"};
		String fila5[] =  {"E","01","02","03","04", "05"};
		
		modTblButacas1.addRow(fila1);
		modTblButacas1.addRow(fila2);
		modTblButacas1.addRow(fila3);
		modTblButacas1.addRow(fila4);
		modTblButacas1.addRow(fila5);
		
		
		
		
		
		//CREACION SEGUNDA TABLA BUTACAS
		Object [] titulos2 = {"", "", "", "", ""};
		modTblButacas2 = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modTblButacas2.setColumnIdentifiers(titulos2);
		tblButacas2 = new JTable(modTblButacas2);
		layoutTabButacas2  = new FlowLayout();
		layoutTabButacas2.setVgap(250);
		layoutTabButacas2.setHgap(200);
		pEste.setLayout(layoutTabButacas2);
		
		tblButacas2.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblButacas2.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblButacas2.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblButacas2.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblButacas2.getColumnModel().getColumn(4).setPreferredWidth(100);
		tblButacas2.setRowHeight(100);
		/*tblButacas2.setIntercellSpacing(new Dimension(10,10));*/
		tblButacas2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		String fila6[] =  {"06","07","08","09", "10"};
		String fila7[] =  {"06","07","08","09", "10"};
		String fila8[] =  {"06","07","08","09", "10"};
		String fila9[] =  {"06","07","08","09", "10"};
		String fila10[] = {"06","07","08","09", "10"};
		
		modTblButacas2.addRow(fila6);
		modTblButacas2.addRow(fila7);
		modTblButacas2.addRow(fila8);
		modTblButacas2.addRow(fila9);
		modTblButacas2.addRow(fila10);
		
		//RENDERER DE LAS TABLAS
		
		
		
		
		
		//ANYADIR LOS COMPONENTES A LOS PANELES
		pOeste.add(tblButacas1);
		pEste.add(tblButacas2);
		
		pSur.add(btnAtras);
		pSur.add(btnSiguiente);
		
		
		
		//DEFINIR LA VENTANA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600,300, 600, 400);
		setTitle("BUTACAS");
		setVisible(true);
		
		
		

		
		
}
	//PRUEBA DE LA VENTANA CON MAIN
	public static void main(String[] args) {
		VentanaButacas VB = new VentanaButacas();	
			
	
	}

	
	
	
	
	
	
	
	

}
