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
	private JPanel PanelNorte, PanelCentro,PanelEste,PanelOeste,PanelSur;
	private JButton btnPrecios, btnIniciarSesion, btnCartelera;
	private JFrame vAnterior,vActual;
	private JLabel lblImg;
	private VentanaPrincipal vp;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	PanelConFondo panelFondo;
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
		PanelOeste= new JPanel();
		PanelEste = new JPanel();
		PanelSur = new JPanel();
		
		panelFondo = new PanelConFondo(new ImageIcon("imagenes/ImagenFondoVPrincipal.jpg").getImage());
		
		panelFondo.add(PanelCentro, BorderLayout.CENTER);
		panelFondo.add(PanelNorte, BorderLayout.NORTH);
		panelFondo.add(PanelSur, BorderLayout.SOUTH);
		panelFondo.add(PanelEste, BorderLayout.EAST);
		panelFondo.add(PanelOeste, BorderLayout.WEST);
		
		int espacioEntrePeneles = 200;
		PanelNorte.setBorder(new EmptyBorder(espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles));

		//Eventos Botones
		btnPrecios = new JButton("PRECIOS");
		btnPrecios.setForeground(new Color(255, 255, 255));
		btnPrecios.setBackground(new Color(0, 0, 0));
		btnPrecios.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON PRECIOS");
			new VentanaPrecios(vActual);
			vActual.setVisible(false);
			vActual.dispose();
		});
		
		btnIniciarSesion = new JButton("INICIAR SESION");
		btnIniciarSesion.setForeground(new Color(255, 255, 255));
		btnIniciarSesion.setBackground(new Color(0, 0, 0));
		btnIniciarSesion.addActionListener((e)->{
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON INICIAR SESION");
			new VentanaInicioSesion(vActual);
			vActual.setVisible(false);
			vActual.dispose();
		});
		
		btnCartelera = new JButton("CARTELERA");
		btnCartelera.setForeground(new Color(255, 255, 255));
		btnCartelera.setBackground(new Color(0, 0, 0));
		btnCartelera.addActionListener((e)-> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON CARTELERA");
			new VentanaCartelera(vActual);
			vActual.setVisible(false);
			vActual.dispose();
			
		});
		
		PanelOeste.add(btnIniciarSesion);
		PanelOeste.add(btnPrecios);
		PanelOeste.add(btnCartelera);
		PanelNorte.setOpaque(false);
		PanelCentro.setOpaque(false);
		PanelSur.setOpaque(false);
		PanelEste.setOpaque(false);
		PanelOeste.setOpaque(false);
		
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 450, 300);
		setTitle("INICIO");
		setContentPane(panelFondo);
		setVisible(true);
		
	}
	

public static void main(String[] args) {
	VentanaPrincipal vp = new VentanaPrincipal(null);
}
	

}
