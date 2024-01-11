package screen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Usuario;

public class VentanaPerfilUsuario extends JFrame {
	private JPanel pCentro,pSur,pOeste;
	private JLabel imagenUsuario, lblNombre,lblApellido,lblFechaNaciminto,lbltlf,lblCorreoElectronico,lblPuntos;
	private JFrame vActual, vAnterior;
	private JButton btnAtras;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	public VentanaPerfilUsuario(JFrame va, Usuario u) {
		vActual=this;
		vAnterior=va;
	
		//CREACIÓN PANELES
		pCentro = new JPanel ();
		pSur = new JPanel();
		pOeste = new JPanel();
		
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pOeste, BorderLayout.WEST);
		
		
		imagenUsuario = new JLabel(new ImageIcon("imagenes/foto.png"));
        imagenUsuario.setPreferredSize(new Dimension(100,100));
		lblNombre = new JLabel("-> NOMBRE: " + u.getNombre());
		lblApellido = new JLabel ("-> APELLIDO: " +u.getApellido());
		lblFechaNaciminto = new JLabel("-> FECHA DE NACIMIENTO: "+ u.getFechaNacimientoStr());
		lbltlf = new JLabel ("-> TELÉFONO: " + u.getTlf());
		lblCorreoElectronico = new JLabel("-> CORREO ELECTRONICO" + u.getCorreoElectronico());
		lblPuntos = new JLabel ("-> PUNTOS: " +u.getContadorPuntos());
		
		
		
		
			
		pOeste.add(imagenUsuario);
		pCentro.add(lblNombre);
		pCentro.add(lblApellido);
		pCentro.add(lblFechaNaciminto);
		pCentro.add(lbltlf);
		pCentro.add(lblPuntos);
		pCentro.add(Box.createVerticalStrut(60));
		
		
		pCentro.setBorder(new EmptyBorder(50,150,150,150));

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds (600,300,380,400);
		setTitle("Usuario");
	
		setVisible(true);
		
	}
	/*public static void main(String[] args) {
		VentanaPerfilUsuario vpu = new VentanaPerfilUsuario(null, null);
	}*/
}