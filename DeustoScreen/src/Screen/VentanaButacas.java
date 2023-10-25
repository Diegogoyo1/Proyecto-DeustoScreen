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
	private JLabel lblPasillo;
	
	
	
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
		lblPasillo = new JLabel("P"); //¿Como poner un label en vertical?
		
		
		//BOTONES
		btnAtras = new JButton("Atras");
		btnSiguiente = new JButton ("Siguiente");
		
		
		
		//ACCIONES DE BOTONES
		btnAtras.addActionListener((e)-> {
			dispose();
			
				
			});
		
		btnSiguiente.addActionListener((e)-> {
			
		});
					
		
		
		//CREACION PRIMERA TABLA BUTACAS
		Object [] titulos1 = {"A", "B", "C", "D", "E"};
		modTblButacas1 = new DefaultTableModel();
		modTblButacas1.setColumnIdentifiers(titulos1);
		tblButacas1 = new JTable(modTblButacas1);
		layoutTabButacas1  = new FlowLayout();
		layoutTabButacas1.setVgap(200);
		layoutTabButacas1.setHgap(60);
		pOeste.setLayout(layoutTabButacas1);
		
		tblButacas1.getColumnModel().getColumn(0).setPreferredWidth(75);
		tblButacas1.getColumnModel().getColumn(1).setPreferredWidth(75);
		tblButacas1.getColumnModel().getColumn(2).setPreferredWidth(75);
		tblButacas1.getColumnModel().getColumn(3).setPreferredWidth(75);
		tblButacas1.getColumnModel().getColumn(4).setPreferredWidth(75);
		tblButacas1.setRowHeight(75);
		/*tblButacas1.setIntercellSpacing(new Dimension(10,10));  //Para dejar espacio entre celdas
		
		JTableHeader header = tblButacas1.getTableHeader();
		DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.LEFT);*/  //Para mover los titulos a la derecha
		


		
		String fila1[] =  {"01","02","03","04", "05"};
		String fila2[] =  {"01","02","03","04", "05"};
		String fila3[] =  {"01","02","03","04", "05"};
		String fila4[] =  {"01","02","03","04", "05"};
		modTblButacas1.addRow(fila1);
		modTblButacas1.addRow(fila2);
		modTblButacas1.addRow(fila3);
		modTblButacas1.addRow(fila4);
		
		
		
		//CREACION SEGUNDA TABLA BUTACAS
		Object [] titulos2 = {"", "", "", "", ""};
		modTblButacas2 = new DefaultTableModel();
		modTblButacas2.setColumnIdentifiers(titulos2);
		tblButacas2 = new JTable(modTblButacas2);
		layoutTabButacas2  = new FlowLayout();
		layoutTabButacas2.setVgap(200);
		layoutTabButacas2.setHgap(60);
		pEste.setLayout(layoutTabButacas2);
		
		tblButacas2.getColumnModel().getColumn(0).setPreferredWidth(75);
		tblButacas2.getColumnModel().getColumn(1).setPreferredWidth(75);
		tblButacas2.getColumnModel().getColumn(2).setPreferredWidth(75);
		tblButacas2.getColumnModel().getColumn(3).setPreferredWidth(75);
		tblButacas2.getColumnModel().getColumn(4).setPreferredWidth(75);
		tblButacas2.setRowHeight(75);
		/*tblButacas2.setIntercellSpacing(new Dimension(10,10));*/
		
		
		String fila5[] =  {"06","07","08","09", "10"};
		String fila6[] =  {"06","07","08","09", "10"};
		String fila7[] =  {"06","07","08","09", "10"};
		String fila8[] =  {"06","07","08","09", "10"};
		
		modTblButacas2.addRow(fila5);
		modTblButacas2.addRow(fila6);
		modTblButacas2.addRow(fila7);
		modTblButacas2.addRow(fila8);
		
		
		
		
		//ANYADIR LOS COMPONENTES A LOS PANELES
		pOeste.add(tblButacas1);
		pEste.add(tblButacas2);
		pSur.add(btnAtras);
		pSur.add(btnSiguiente);
		
		
		
		//DEFINIR LA VENTANA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds (0,0,1000,750);
		setVisible(true);
		

		
		
}
	//PRUEBA DE LA VENTANA CON MAIN
	public static void main(String[] args) {
		VentanaButacas VB = new VentanaButacas();	
			
	
	}

	
	
	
	
	
	
	
	

}
