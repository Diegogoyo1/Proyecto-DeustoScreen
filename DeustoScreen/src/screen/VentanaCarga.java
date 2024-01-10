package screen;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;

import domain.Cine;

public class VentanaCarga extends JFrame{
	protected JPanel pCentro, pSur;
	protected JLabel lblImg;
	protected JProgressBar barCargando;
	protected JFrame vActual;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	PanelConFondo panelFondo;
	
	public VentanaCarga() {
		super();
		Cine.cargarMapaCompras("ficheros/Compras.dat");
		vActual = this;
		
		pCentro = new JPanel();
		pSur = new JPanel();
		panelFondo = new PanelConFondo(new ImageIcon("imagenes/8V9H.gif").getImage());
		panelFondo.add(pCentro, BorderLayout.CENTER);
		panelFondo.add(pSur, BorderLayout.SOUTH);
		int espacioEntrePeneles = 200;
		pCentro.setBorder(new EmptyBorder(espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles));
		
		
		
		
		
		
		barCargando = new JProgressBar(0,100);
		barCargando.setStringPainted(true);
		barCargando.setForeground(new Color(0,0,0));
		
		barCargando.setUI(new BasicProgressBarUI() {
			protected Color getSelectionBackground() {
				return new Color(0, 0, 0);
			}
			
			protected Color getSelectionForeground() {
				return new Color(255,255,255);
			}
		});
		barCargando.setPreferredSize(new Dimension(1000,25));
		barCargando.setSize(300, 300);
		pSur.add(barCargando);
		pCentro.setOpaque(false);
		pSur.setOpaque(false);


        Thread hilo = new Thread(new Runnable() {

        	
			@Override
			public void run() {
				try {
					
					for (int i = 0;i<101; i++) {
						Thread.sleep(35);
						barCargando.setValue(i);
						
					}
					logger.log(Level.INFO, "SE ESTA CARGANDO LA VENTANA");
				}catch(InterruptedException ie){
					JOptionPane.showMessageDialog(null, "Error al cargar ventana", "Error", JOptionPane.ERROR_MESSAGE);
					logger.log(Level.WARNING, "ERROR AL CARGAR VENTANA");
				}
				dispose();
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new VentanaPrincipal(vActual);
								
					}
				});
				vActual.setVisible(false);
			}
        	
        });hilo.start();
		
		setVisible(true);
        
		

		
        int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
        int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
        setSize(anchoP, altoP);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 1600, 800);
		setContentPane(panelFondo);
		setTitle("CARGANDO");
		setVisible(true);
		
	}
	
	
	
	
	
	
	
	
	

}
