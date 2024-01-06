package screen;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaTrabajadores extends JFrame {
	private JFrame vActual, vAnterior;
	private JButton btnAtras,btnEliminar;
	private JTable tblCompras;
	private DefaultTableModel modelo;
	private JPanel pSur,pCentro;
	private JScrollPane scroll;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	public VentanaTrabajadores(JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		
		//CREAR PANELES
		pCentro = new JPanel(new GridLayout(1,1));
		pSur = new JPanel();
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		
		//CREACION DE BOTONES
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener((e)-> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			vActual.dispose();
			vAnterior.setVisible(true);
		});
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener((e)-> {
		
		});
		
		//CREACION DE LA TABLA
		modelo = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		String [] titulos = {"FECHA","HORA","PELICULA","SALA","USUARIO","Nº ENTRADAS"};
		modelo.setColumnIdentifiers(titulos);
		tblCompras = new JTable(modelo);
		scroll = new JScrollPane(tblCompras);
		
		
		//ANIADIR LOS COMPONENTES A LOS PANELES
		pSur.add(btnAtras);
		pSur.add(btnEliminar);
		pCentro.add(scroll);
		
		
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 450, 300);
		setTitle("AREA TRABAJADORES");
		setVisible(true);
		
	}
	
	
}
