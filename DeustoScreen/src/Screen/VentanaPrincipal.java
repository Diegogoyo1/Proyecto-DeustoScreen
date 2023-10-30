package Screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;



public class VentanaPrincipal extends JFrame{
	private JPanel PanelNorte, PanelCentro;
	private JButton btnPrecios, btnIniciarSesion,btnHorario, btnCartelera;
	private JFrame vAnterior,vActual;
	
	public VentanaPrincipal(JFrame va) {
		super();
		vAnterior= va;
		vActual=this;
		
		PanelNorte = new JPanel();
		PanelCentro = new JPanel();
		getContentPane().add(PanelNorte, BorderLayout.NORTH);
		getContentPane().add(PanelCentro,BorderLayout.CENTER);
		
				
		btnPrecios = new JButton("Precios");
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnCartelera = new JButton("Cartelera");
		btnHorario = new JButton("Horario");
		
		 

		PanelNorte.add(btnIniciarSesion);
		PanelNorte.add(btnPrecios);
		PanelNorte.add(btnCartelera);
		PanelNorte.add(btnHorario);
		

		
		//Eventos Botones
		
		btnPrecios.addActionListener((e)->{
			VentanaPrecios ventanaPrecios = new VentanaPrecios();
			ventanaPrecios.setVisible(true);
		});
		
		btnIniciarSesion.addActionListener((e)->{
			VentanaInicioSesion ventanaInicioSesion = new VentanaInicioSesion();
			ventanaInicioSesion.setVisible(true);
		});
		
		btnHorario.addActionListener((e)->{
			VentanaHorario ventanaHorario = new VentanaHorario();
			ventanaHorario.setVisible(true);
		});
		
		btnCartelera.addActionListener((e)-> {
			VentanaCartelera ventanaCartelera = new VentanaCartelera();
			ventanaCartelera.setVisible(true);
			
		});
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 450, 300);
		setTitle("INICIO");
		setVisible(true);
		
	}
	


	

}


