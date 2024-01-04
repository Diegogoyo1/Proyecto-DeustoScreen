package screen;

import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Usuario;

public class VentanaPerfilUsuario extends JFrame {
	private JPanel pCentro,pSur,pEste;
	private JLabel lblNombre,lblApellido,lblFechaNaciminto,lbltlf,lblCorreoElectronico,lblPuntos,lblImagen;
	private JFrame vActual, vAnterior;
	private JButton btnAtras;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	public VentanaPerfilUsuario(JFrame va, Usuario u) {
		vActual=this;
		vAnterior=va;
	
		//CREACIÓN PANELES
		pCentro = new JPanel ();
		pSur = new JPanel();
		pEste = new JPanel();
		
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pEste,BorderLayout.EAST);

        //ImageIcon imagen = new ImageIcon("imagenes/foto.png");
		//lblImagen = new JLabel(imagen);
		lblNombre = new JLabel("NOMBRE: " + u.getNombre());
		lblApellido = new JLabel ("APELLIDO: " +u.getApellido());
		lblFechaNaciminto = new JLabel("FECHA DE NACIMIENTO: "+ u.getFechaNacimientoStr());
		lbltlf = new JLabel ("TELÉFONO: " + u.getTlf());
		lblCorreoElectronico = new JLabel("CORREO ELECTRONICO" + u.getCorreoElectronico());
		lblPuntos = new JLabel ("PUNTOS: " +u.getContadorPuntos());
		
		
		
		btnAtras = new JButton("Atras");
				
		//pEste.add(lblImagen);
		pCentro.add(lblNombre);
		pCentro.add(lblApellido);
		pCentro.add(lblFechaNaciminto);
		pCentro.add(lbltlf);
		pCentro.add(lblPuntos);
		pCentro.add(Box.createVerticalStrut(60));
		pSur.add(btnAtras);
		
		pCentro.setBorder(new EmptyBorder(50,150,150,150));

		btnAtras.addActionListener((e)-> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			
			vActual.dispose();
			vAnterior.setVisible(true);
		});
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
