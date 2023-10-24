package Screen;

import java.awt.BorderLayout;
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
	private JScrollPane scrollTblButacas1, scrollTblButacas2;
	
	public VentanaButacas() {
		
		
		pNorte = new JPanel();
		pSur = new JPanel();
		pEste = new JPanel();
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
			
		
		
		Object [] titulos = {""};
		modTblButacas1 = new DefaultTableModel();
		modTblButacas1.setColumnIdentifiers(titulos);
		tblButacas1 = new JTable(modTblButacas1);
		scrollTblButacas1 = new JScrollPane(tblButacas1);
		getContentPane().add(scrollTblButacas1, BorderLayout.EAST);
		String fila1[] =  {""};
		modTblButacas1.addRow(fila1);
		
		
		modTblButacas1 = new DefaultTableModel();
		tblButacas2 = new JTable(modTblButacas2);
		getContentPane().add(tblButacas2, BorderLayout.WEST);
		
		
		
		
		pOeste.add(tblButacas2);
		pEste.add(tblButacas1);
		pSur.add(btnAtras);
		pSur.add(btnSiguiente);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds (100,100,600,400);
		setVisible(true);
		
		
		
		
	
}
	public static void main(String[] args) {
		VentanaButacas VB = new VentanaButacas();	
			
	
	}

	
	
	
	
	
	
	
	

}
