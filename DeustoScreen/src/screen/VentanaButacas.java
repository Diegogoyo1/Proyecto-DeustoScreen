package screen;

import java.awt.BorderLayout;   

import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import domain.Cine;
import domain.Usuario;


public class VentanaButacas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2821724812420567703L;
	private JPanel pNorte, pSur, pEste, pOeste,pCentro;
	private JButton btnSiguiente, btnAtras;
	private JTable tblButacas1;
	private JLabel lblPantalla;
	private DefaultTableModel modTblButacas1;
	//private FlowLayout layoutTabButacas1, layoutTabButacas2;
	private JFrame vActual, vAnterior;
	private static final String nomfich1 = "ficheros/Butacas.csv";
	private static int cont;
	private int fila1, columna1;
	private int [][]m1;
	ArrayList<String> asientosSeleccionados;
	//private boolean [][]m2;
	private static Logger logger = Logger.getLogger(Main.class.getName());

	public VentanaButacas(JFrame va,Usuario u, int sala, int butacasA, int dia, int mes, int anio, String hora) {
		super();
		//m1 = new int[7][butacasA];
		Cine.cargarButacasDesdeFichero("ficheros/ButacasSala"+sala+"_"+dia+"_"+mes+"_"+anio+"_"+hora+".dat");
		m1 = Cine.getM1();
		asientosSeleccionados = new ArrayList<>();
		//m2 = new boolean[5][butacasB];
		fila1 = -1;
		//fila2 = -1;
		columna1 = -1;
		//columna2 = -1;
		cont = 0;
		vActual = this;
		vAnterior = va;

		// PANELES
		pNorte = new JPanel();
		pSur = new JPanel();
		pEste = new JPanel();
		pOeste = new JPanel();
		pCentro = new JPanel(new GridLayout(1, 1));

		// POSICION DE PANELES
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pEste, BorderLayout.EAST);
		getContentPane().add(pOeste, BorderLayout.WEST);
		getContentPane().add(pCentro, BorderLayout.CENTER);

		// LABELS
		lblPantalla = new JLabel();
		// BOTONES
		btnAtras = new JButton("Atras");
		btnSiguiente = new JButton("Siguiente");

		// ACCIONES DE BOTONES
		btnAtras.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			vActual.dispose();
			vAnterior.setVisible(true);

		});

		btnSiguiente.addActionListener((e) -> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON SIGUIENTE");
			if (cont == VentanaSeleccionEntradas.getTotalEntradas()) {
				new VentanaPuntos(vActual, u,sala, asientosSeleccionados);
				for(int i=0;i<m1.length;i++) {
					for(int j=0;j<m1[i].length;j++) {
						if(m1[i][j]!=0) {
							m1[i][j] = 2;
						}
					}
				}
				Cine.setM1(m1);
				Cine.guardarButacasEnFichero("ficheros/ButacasSala"+sala+"_"+dia+"_"+mes+"_"+anio+"_"+hora+".dat");
				vActual.setVisible(false);
				vActual.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "No has seleccionado todas las entradas");
			}
		});

		// CREACION PRIMERA TABLA BUTACAS
		//Object[] titulos1 = { "", "", "", "", "", "" };
		Object[] titulos1 = new Object[butacasA];
		for(int i=0;i<butacasA;i++) {
			titulos1[i] = "";
		}
			
		modTblButacas1 = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		modTblButacas1.setColumnIdentifiers(titulos1);

		tblButacas1 = new JTable(modTblButacas1);
		Border b = BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.BLACK	, Color.DARK_GRAY);
		tblButacas1.setBorder(b);

		/*layoutTabButacas1 = new FlowLayout();
		layoutTabButacas1.setVgap(250);
		layoutTabButacas1.setHgap(100);
		pOeste.setLayout(layoutTabButacas1);
		 */
		pCentro.add(tblButacas1);
		tblButacas1.setRowHeight(100);
		tblButacas1.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(4).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(5).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(6).setPreferredWidth(75);
		tblButacas1.getColumnModel().getColumn(7).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(8).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(9).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(10).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(11).setPreferredWidth(100);
		
		cargarFichero1(nomfich1);

		// MOUSE LISTENER DE LAS TABLAS
		tblButacas1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String letras = "ABCDEFG";
				Point p = e.getPoint();
				fila1 = tblButacas1.rowAtPoint(p);
				columna1 = tblButacas1.columnAtPoint(p);
				if(columna1!=0 || columna1!=6) {
					if(m1[fila1][columna1] != 2) {
						String asiento = letras.charAt(fila1)+String.valueOf(columna1);
						if(m1[fila1][columna1]==0) {
							logger.log(Level.INFO, "SE HA ESCOGIDO UNA BUTACA");
							cont++;
							asientosSeleccionados.add(asiento);
							m1[fila1][columna1] = 1;
							
						}else if(m1[fila1][columna1]==1){
							logger.log(Level.INFO, "SE HA QUITADO UNA BUTACA");
							cont--;
							asientosSeleccionados.remove(asiento);
							m1[fila1][columna1] = 0;
							
						}
						System.out.print(cont+" - "+VentanaSeleccionEntradas.getTotalEntradas());
						tblButacas1.repaint();
						
					}
				}
			}
		});

		
		// RENDERER DE LAS TABLAS

		tblButacas1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				JLabel l = new JLabel(value.toString());
				l.setHorizontalAlignment(JLabel.CENTER);
				l.setOpaque(true);
				if(column==0) {
					return l;
				}else if(column==6) {
					return l;
				}else {
					if(m1[row][column]==1) {
						ImageIcon im = new ImageIcon("imagenes/ButacaVerde.png");
						l.setIcon(im);
					}else if(m1[row][column]==0){
						ImageIcon im = new ImageIcon("imagenes/ButacaGris.png");
						l.setIcon(im);
					}else {
						ImageIcon im = new ImageIcon("imagenes/ButacaRoja.png");
						l.setIcon(im);
					}
					
				}
				return l;
			}
		});



		// ANYADIR LOS COMPONENTES A LOS PANELES
		//pOeste.add(tblButacas1);
		//pEste.add(tblButacas2);
		ImageIcon imPantalla = new ImageIcon("imagenes/Pantalla.png");
		lblPantalla.setIcon(imPantalla);
		pNorte.add(lblPantalla);
		pSur.add(btnAtras);
		pSur.add(btnSiguiente);
	}

	// CARGAR LOS FICHEROS DE LAS TABLAS
	public void cargarFichero1(String nomfich1) {

		try {
			Scanner sc = new Scanner(new FileReader(nomfich1));
			String linea;
			while (sc.hasNext()) {
				linea = sc.nextLine();
				String[] fila = linea.split(";");
				
				modTblButacas1.addRow(fila);
			}
			sc.close();
			logger.log(Level.INFO, "SE HA CARGADO LOS FICHEROS DE LAS TABLAS");
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "NO SE HA PODIDO CARGAR LOS FICHEROS DE LAS TABLAS");
			e.printStackTrace();
		}

		// DEFINIR LA VENTANA

		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
				.getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode()
				.getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 600, 400);
		setTitle("BUTACAS");
		setVisible(true);

	}

}
