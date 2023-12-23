package screen;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class VentanaCarga extends JFrame{
	protected JPanel pCentro;
	protected JLabel lblImg;
	protected JProgressBar barCargando;
	protected JFrame vActual;
	
	public VentanaCarga() {
		super();
		vActual = this;
		
		pCentro = new JPanel();
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		int espacioEntrePeneles = 200;
		pCentro.setBorder(new EmptyBorder(espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles));
		
		
		
		
		lblImg = new JLabel(new ImageIcon ("imagenes/Logo.jpg"));
		lblImg.setLayout(new BorderLayout());
		
		barCargando = new JProgressBar(0,100);
		barCargando.setStringPainted(true);
		barCargando.setForeground(new Color(164, 241, 242));
		
		barCargando.setUI(new BasicProgressBarUI() {
			protected Color getSelectionBackground() {
				return new Color(0, 0, 0);
			}
			
			protected Color getSelectionForeground() {
				return new Color(0, 0, 0);
			}
		});
		
		lblImg.add(barCargando, BorderLayout.SOUTH);
		getContentPane().setBackground(new Color(253,243,228));
		getContentPane().add(lblImg);
		
        Thread hilo = new Thread(new Runnable() {

        	
			@Override
			public void run() {
				try {
					
					for (int i = 0;i<101; i++) {
						Thread.sleep(35);
						barCargando.setValue(i);
					}
					
				}catch(InterruptedException ie){
					JOptionPane.showMessageDialog(null, "Error al cargar ventana", "Error", JOptionPane.ERROR_MESSAGE);
					
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
		setTitle("CARGANDO");
		setVisible(true);
		
	}
	
	
	
	
	
	
	
	
	

}
