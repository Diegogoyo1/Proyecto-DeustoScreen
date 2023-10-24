package Screen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaButacas extends JFrame{
	private JPanel pNorte, pSur, pEste, pOeste;
	private JButton btnSiguiente, btnAtras;
	private JTable tblButacas1, tblButacas2;
	private DefaultTableModel modTblButacas1, modTblButacas2;
	private FlowLayout layoutTabButacas1, layoutTabButacas2;
	
	public VentanaButacas() {
		
		
		pNorte = new JPanel();
		pSur = new JPanel();
		pEste = new JPanel(new GridLayout(3,0));
		pOeste = new JPanel();
		
		

		
		
		
		
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pEste, BorderLayout.EAST );
		getContentPane().add(pOeste, BorderLayout.WEST);

		
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener((e)-> {
			System.exit(0);
			
				
			});
		
		btnSiguiente = new JButton ("Siguiente");
		btnSiguiente.addActionListener((e)-> {
			
		});
					
		Object [] titulos1 = {"", "", "", "", ""};
		modTblButacas1 = new DefaultTableModel();
		modTblButacas1.setColumnIdentifiers(titulos1);
		tblButacas1 = new JTable(modTblButacas1);
		layoutTabButacas1  = new FlowLayout();
		layoutTabButacas1.setVgap(200);
		pOeste.setLayout(layoutTabButacas1);
		
		String fila1[] =  {"01","02","03","04", "05"};
		String fila2[] =  {"11","12","13","14", "15"};
		String fila3[] =  {"21","22","23","24", "25"};
		modTblButacas1.addRow(fila1);
		modTblButacas1.addRow(fila2);
		modTblButacas1.addRow(fila3);
		
		
		
		Object [] titulos2 = {"", "", "", "", ""};
		modTblButacas2 = new DefaultTableModel();
		modTblButacas2.setColumnIdentifiers(titulos2);
		tblButacas2 = new JTable(modTblButacas2);
		layoutTabButacas2  = new FlowLayout();
		layoutTabButacas2.setVgap(200);
		pEste.setLayout(layoutTabButacas2);
		
		String fila4[] =  {"06","07","08","09", "10"};
		String fila5[] =  {"16","17","18","19", "20"};
		String fila6[] =  {"26","27","28","29", "30"};
		modTblButacas2.addRow(fila4);
		modTblButacas2.addRow(fila5);
		modTblButacas2.addRow(fila6);
		
		
		
		pOeste.add(tblButacas1);
		pEste.add(tblButacas2);
		pSur.add(btnAtras);
		pSur.add(btnSiguiente);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds (100,100,1000,600);
		setVisible(true);
		
		
		
		
	
}
	public static void main(String[] args) {
		VentanaButacas VB = new VentanaButacas();	
			
	
	}

	
	
	
	
	
	
	
	

}
