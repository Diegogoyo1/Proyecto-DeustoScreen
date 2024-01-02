package screen;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import domain.Usuario;

public class VentanaPerfilUsuario extends JFrame {
	private JPanel pCentro, pNorte,pSur;
	private JLabel lblNombre,lblApellido,lblFechaNaciminto,lbltlf,CorreoElectronico,lblPuntos,txtNombre,txtApellido,txtfNac,txtTlf,txtPuntos;
	private JFrame vActual, vAnterior;
	
	public VentanaPerfilUsuario(JFrame va, Usuario u) {
		vActual=this;
		vAnterior=va;
	
		//CREACIÓN PANELES
		pCentro = new JPanel ();
		pSur = new JPanel();
		pNorte = new JPanel();
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);

		getContentPane().add(pNorte, BorderLayout.NORTH);
		
		lblNombre = new JLabel(" NOMBRE: " + u.getNombre());
		lblApellido = new JLabel (" APELLIDO: " +u.getApellido());
		lblFechaNaciminto = new JLabel(" FECHA DE NACIMIENTO: ");
		lbltlf = new JLabel (" TELÉFONO: ");
		lblPuntos = new JLabel (" PUNTOS: ");
		
		txtNombre = new JLabel(u.getCorreoElectronico());
		txtApellido = new JLabel(u.getCorreoElectronico());
		txtfNac = new JLabel(u.getCorreoElectronico());
		txtTlf = new JLabel(u.getCorreoElectronico());
		txtPuntos = new JLabel(u.getCorreoElectronico());
				
		
		pCentro.add(lblNombre);
		pCentro.add(txtNombre);
		pCentro.add(lblApellido);
		pCentro.add(txtApellido);
		pCentro.add(lblFechaNaciminto);
		pCentro.add(txtfNac);
		pCentro.add(lbltlf);
		pCentro.add(txtTlf);
		pCentro.add(lblPuntos);
		pCentro.add(txtPuntos);
		pCentro.add(Box.createVerticalStrut(30));
		
		pCentro.setBorder(new EmptyBorder(150, 150, 150, 150 ));


		
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
