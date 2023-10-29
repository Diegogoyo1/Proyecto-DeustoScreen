package Screen;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaSawX extends JFrame {
	protected JPanel pNorte, pSur, pEste, pOeste;
	protected JButton btnAtras;
	protected JLabel lblSetNombre,lblNombre,lblSetReparto, lblReparto, lblSetDuracion, lblDuracion, lblSetCategoria,lblCategoria, lblSetSinopsis;  ;
	
	
	public VentanaSawX() {
		
		pNorte = new JPanel();
		pSur = new JPanel();
		pEste = new JPanel(new GridLayout(2,0));
		pOeste = new JPanel();
		
		getContentPane().add(pNorte, BorderLayout.NORTH);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pEste, BorderLayout.EAST);
		getContentPane().add(pOeste, BorderLayout.WEST);
		
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener((e)-> {
			dispose();
			
		});
		//DEFINIR VENTANA
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds (600,300,380,400);
		setTitle("BARBIE");
		setVisible(true);
		
	}
	//PRUEBA DE LA VENTANA CON MAIN
	public static void main(String[] args) {
		VentanaSawX VSaw = new VentanaSawX();	
						
		}
	
	
	
}
