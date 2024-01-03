package screen;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
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
import domain.Entrada;
import domain.Usuario;


public class VentanaButacas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2821724812420567703L;
	private JPanel pNorte, pSur, pEste, pOeste,pCentro;
	private JButton btnSiguiente, btnAtras;
	private JTable tblButacas1, tblButacas2;
	private DefaultTableModel modTblButacas1, modTblButacas2;
	//private FlowLayout layoutTabButacas1, layoutTabButacas2;
	private JFrame vActual, vAnterior;
	private static final String nomfich1 = "ficheros/Butacas1.csv";
	private static final String nomfich2 = "ficheros/Butacas2.csv";
	private static int cont;
	private int fila1, columna1, fila2, columna2;
	private boolean [][]m1;
	private boolean [][]m2;
	private static Logger logger = Logger.getLogger(Main.class.getName());

	public VentanaButacas(JFrame va,Usuario u, int sala, int butacasA, int butacasB) {
		super();
		m1 = new boolean[5][butacasA];
		m2 = new boolean[5][butacasB];
		fila1 = -1;
		fila2 = -1;
		columna1 = -1;
		columna2 = -1;
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
				new VentanaPuntos(vActual, u,sala, fila1*columna1);
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
		pOeste.add(tblButacas1);
		tblButacas1.setRowHeight(100);
		tblButacas1.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(4).setPreferredWidth(100);
		tblButacas1.getColumnModel().getColumn(5).setPreferredWidth(100);
		

		cargarFichero1(nomfich1);

		// CREACION SEGUNDA TABLA BUTACAS
		//Object[] titulos2 = { "", "", "", "", "" };
		Object[] titulos2 = new Object[butacasB];
		for(int i=0;i<butacasB;i++) {
			titulos1[i] = "";
		}
		modTblButacas2 = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modTblButacas2.setColumnIdentifiers(titulos2);

		tblButacas2 = new JTable(modTblButacas2);

		/*layoutTabButacas2 = new FlowLayout();
		layoutTabButacas2.setVgap(250);
		layoutTabButacas2.setHgap(200);
		pEste.setLayout(layoutTabButacas2);
		 */
		pEste.add(tblButacas2);
		tblButacas2.setRowHeight(100);
		tblButacas2.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblButacas2.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblButacas2.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblButacas2.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblButacas2.getColumnModel().getColumn(4).setPreferredWidth(100);

		cargarFichero2(nomfich2);
		
		JLabel l = new JLabel("P");
		pCentro.add(l);

		// MOUSE LISTENER DE LAS TABLAS
		tblButacas1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				fila1 = tblButacas1.rowAtPoint(p);
				columna1 = tblButacas1.columnAtPoint(p);
				if(columna1!=0) {
					if(!m1[fila1][columna1]) {
						cont++;
					}else {
						cont--;
					}
					System.out.print(cont+" - "+VentanaSeleccionEntradas.getTotalEntradas());
					m1[fila1][columna1] = !m1[fila1][columna1];
					tblButacas1.repaint();
					logger.log(Level.INFO, "SE HA ESCOGIDO UNA BUTACA");
					Entrada en = new Entrada(sala, fila1*columna1);
					if(!Cine.getMapaCompras().containsKey(VentanaInicioSesion.getUsuario())) {
						Cine.getMapaCompras().put(VentanaInicioSesion.getUsuario(), new ArrayList<>());
					}
					Cine.getMapaCompras().get(VentanaInicioSesion.getUsuario()).add(en);
				}
			}
		});
		tblButacas2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point p = e.getPoint();
				fila2 = tblButacas2.rowAtPoint(p);
				columna2 = tblButacas2.columnAtPoint(p);
				if(!m2[fila2][columna2]) {
					
					cont++;
				}else {
					cont--;
				}
				m2[fila2][columna2] = !m2[fila2][columna2];
				tblButacas2.repaint();
				logger.log(Level.INFO, "SE HA ESCOGIDO UNA BUTACA");
				Entrada en = new Entrada(sala, fila1*columna1);
				if(!Cine.getMapaCompras().containsKey(VentanaInicioSesion.getUsuario())) {
					Cine.getMapaCompras().put(VentanaInicioSesion.getUsuario(), new ArrayList<>());
				}
				Cine.getMapaCompras().get(VentanaInicioSesion.getUsuario()).add(en);
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
				}else if(row==0) {
					return l;
				}else {
					if(row==fila1 && column==columna1){
						if(isSelected) {
							ImageIcon im = new ImageIcon("imagenes/ButacaVerde.png");
							l.setIcon(im);
						}else {
							ImageIcon im = new ImageIcon("imagenes/ButacaGris.png");
							l.setIcon(im);
						}
					}else {
						ImageIcon im = new ImageIcon("imagenes/ButacaGris.png");
						l.setIcon(im);
				
					}
				}
				/*if(fila1!=-1 && columna1!=-1) {
					if(columna1!=0) {
						if (row == fila1 && column == columna1) {
							if(m1[fila1][columna1]) {
								l.setBackground(table.getSelectionBackground());
								l.setSize(100, 100);
								ImageIcon im = new ImageIcon("imagenes/ButacaVerde.png");
								ImageIcon imtam = new ImageIcon(im.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
								l.setIcon(imtam);
							}
							else {
								l.setBackground(table.getBackground());
								l.setSize(100, 100);
								ImageIcon im = new ImageIcon("imagenes/ButacaGris.png");
								ImageIcon imtam = new ImageIcon(im.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
								l.setIcon(imtam);
							}
						} else {
							if(m1[row][column]) {
								l.setBackground(table.getSelectionBackground());
								l.setSize(100, 100);
								ImageIcon im = new ImageIcon("imagenes/ButacaVerde.png");
								ImageIcon imtam = new ImageIcon(im.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
								l.setIcon(imtam);
							}
							else {
								l.setBackground(table.getBackground());
								l.setSize(100, 100);
								ImageIcon im = new ImageIcon("imagenes/ButacaGris.png");
								ImageIcon imtam = new ImageIcon(im.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
								l.setIcon(imtam);
							}
						}
					}else {
						l.setBackground(table.getBackground());
					}
				}
				else {
					l.setBackground(table.getBackground());
					l.setSize(100, 100);
					ImageIcon im = new ImageIcon("imagenes/ButacaGris.png");
					ImageIcon imtam = new ImageIcon(im.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
					l.setIcon(imtam);
					
				}*/
				return l;
			}
		});

		tblButacas2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
				if(fila2!=-1 && columna2!=-1) {
					if (row == fila2 && column == columna2) {
						if(m2[fila2][columna2]) {
							l.setBackground(table.getSelectionBackground());
							l.setSize(100, 100);
							ImageIcon im = new ImageIcon("imagenes/ButacaVerde.png");
							ImageIcon imtam = new ImageIcon(im.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
							l.setIcon(imtam);
						}
						else {
							l.setBackground(table.getBackground());
							l.setSize(100, 100);
							ImageIcon im = new ImageIcon("imagenes/ButacaGris.png");
							ImageIcon imtam = new ImageIcon(im.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
							l.setIcon(imtam);
						}
					} else {
						if(m2[row][column]) {
							l.setBackground(table.getSelectionBackground());
							l.setSize(100, 100);
							ImageIcon im = new ImageIcon("imagenes/ButacaVerde.png");
							ImageIcon imtam = new ImageIcon(im.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
							l.setIcon(imtam);
						}
						else {
							l.setBackground(table.getBackground());
							l.setSize(100, 100);
							ImageIcon im = new ImageIcon("imagenes/ButacaGris.png");
							ImageIcon imtam = new ImageIcon(im.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
							l.setIcon(imtam);
						}
					}
				}
			else {
				l.setBackground(table.getBackground());
				l.setSize(100, 100);
				ImageIcon im = new ImageIcon("imagenes/ButacaGris.png");
				ImageIcon imtam = new ImageIcon(im.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
				l.setIcon(imtam);
				
			}
			return l;
		}
	});

		// ANYADIR LOS COMPONENTES A LOS PANELES
		//pOeste.add(tblButacas1);
		//pEste.add(tblButacas2);

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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void cargarFichero2(String nomfich2) {

		try {
			Scanner sc = new Scanner(new FileReader(nomfich2));
			String linea;
			while (sc.hasNext()) {
				linea = sc.nextLine();
				String[] fila = linea.split(";");
				modTblButacas2.addRow(fila);
			}
			sc.close();
		} catch (FileNotFoundException e) {
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
	
	/*public static void main(String[] args) {
		new VentanaButacas(null, null, 0, 0, 0);
	}*/

}
