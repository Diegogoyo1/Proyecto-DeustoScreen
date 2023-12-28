package screen;

import java.awt.BorderLayout; 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import domain.Usuario;
import javax.swing.border.EmptyBorder;

import domain.Usuario;



public class VentanaPrincipal extends JFrame{
	private JPanel PanelNorte, PanelCentro;
	private JButton btnPrecios, btnIniciarSesion, btnCartelera;
	private JFrame vAnterior,vActual;
	private JLabel lblImg;
	private VentanaPrincipal vp;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	/*@Override
    public void paint(Graphics g){
        Dimension dimension = this.getSize();
        ImageIcon icon = new ImageIcon("src/imagenes/FondoCartelera.jpg");
        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
        vp.setOpaque(false);
        super.paintComponents(g);
    }*/


	public VentanaPrincipal(JFrame va) {
		super();
		vAnterior= va;
		vActual=this;
		
		PanelNorte = new JPanel();
		PanelCentro = new JPanel();
		getContentPane().add(PanelNorte, BorderLayout.NORTH);
		getContentPane().add(PanelCentro,BorderLayout.CENTER);
		int espacioEntrePeneles = 200;
		PanelCentro.setBorder(new EmptyBorder(espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles));
		
		
				
		btnPrecios = new JButton("Precios");
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnCartelera = new JButton("Cartelera");
		
		lblImg = new JLabel(new ImageIcon ("imagenes/Imagen-animada-Claqueta-21.gif"));
		lblImg.setLayout(new BorderLayout());
		 

		
		PanelNorte.add(btnIniciarSesion);
		PanelNorte.add(btnPrecios);
		PanelNorte.add(btnCartelera);
		PanelCentro.add(lblImg);
		

		
		//Eventos Botones
		
		btnPrecios.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON PRECIOS");
			new VentanaPrecios(vActual);
			vActual.setVisible(false);
			vActual.dispose();
		});
		
		btnIniciarSesion.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON INICIAR SESION");
			new VentanaInicioSesion(vActual);
			vActual.setVisible(false);
			vActual.dispose();
		});
		
		btnCartelera.addActionListener((e)-> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON CARTELERA");
			new VentanaCartelera(vActual);
			vActual.setVisible(false);
			vActual.dispose();
			
		});
		
		
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 450, 300);
		setTitle("INICIO");
		setVisible(true);
		
	}
	


	

}
