package screen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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
	private JFrame vActual, vAnterior;
	private static final String nomfich1 = "src/Ficheros/Butacas1.csv";
	private static final String nomfich2 = "src/Ficheros/Butacas2.csv";
	
	
	public VentanaButacas(JFrame va) {
		super();
		vActual=this;
		vAnterior=va;
		
		
		
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
			vActual.dispose();
			vAnterior.setVisible(true);
				
			});
		
		btnSiguiente.addActionListener((e)-> {
			new VentanaPuntos(vActual);
			vActual.setVisible(false);
			vActual.dispose();
		});
	
					
		
		//CREACION PRIMERA TABLA BUTACAS
		Object[] titulos1 = {"","","","","",""};
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
		
		tblButacas1.setRowHeight(100);
		tblButacas1.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(4).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(5).setPreferredWidth(100);
		
		tblButacas1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cargarFichero1(nomfich1);
		
		
		
		
	
		
		
			
		
			
			//CREACION SEGUNDA TABLA BUTACAS
			Object[] titulos2 = {"","","","",""};
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
			
			tblButacas2.setRowHeight(100);
			tblButacas2.getColumnModel().getColumn(0).setPreferredWidth(100);
			tblButacas2.getColumnModel().getColumn(1).setPreferredWidth(100);
			tblButacas2.getColumnModel().getColumn(2).setPreferredWidth(100);
			tblButacas2.getColumnModel().getColumn(3).setPreferredWidth(100);
			tblButacas2.getColumnModel().getColumn(4).setPreferredWidth(100);
			
			tblButacas2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			cargarFichero2(nomfich2);
			
			
		
			
			
		
				
		//RENDERER DE LAS TABLAS
		
		
		
		
		
		//ANYADIR LOS COMPONENTES A LOS PANELES
		pOeste.add(tblButacas1);
		pEste.add(tblButacas2);
		
		pSur.add(btnAtras);
		pSur.add(btnSiguiente);
}
		
		
		
		
		
		
		//CARGAR LOS FICHEROS DE LAS TABLAS
				public void cargarFichero1(String nomfich1) {
					
					try {
						Scanner sc = new Scanner(new FileReader(nomfich1));
						String linea;
						while(sc.hasNext()) { 
							linea = sc.nextLine(); 
							String [] partes = linea.split(";");
							Object [] fila = {partes[0],partes[1],partes[2],partes[3],partes[4], partes[5]};
							modTblButacas1.addRow(fila);
						}
						sc.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace(); 
					}
				} 
				
					public void cargarFichero2(String nomfich2) {
						
						try {
							Scanner sc = new Scanner(new FileReader(nomfich2)); 
							String linea;
							while(sc.hasNext()) { 
								linea = sc.nextLine(); 
								String [] partes = linea.split(";");
								Object [] fila = {partes[0],partes[1],partes[2],partes[3],partes[4]};
								modTblButacas2.addRow(fila);
							}
							sc.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace(); 
						}
			
		
		
		
		//DEFINIR LA VENTANA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600,300, 600, 400);
		setTitle("BUTACAS");
		setVisible(true);
		
		
		

		
		
	}

}
