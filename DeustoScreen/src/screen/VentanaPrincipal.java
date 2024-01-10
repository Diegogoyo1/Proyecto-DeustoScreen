package screen;

import java.awt.BorderLayout;



import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import domain.Cine;
import domain.PuestoTrabajo;
import domain.Trabajador;
import javax.swing.border.EmptyBorder;




public class VentanaPrincipal extends JFrame{
	private JPanel pNorte, pCentro,pEste, pOeste, pSur;
	private JButton btnPrecios, btnIniciarSesion, btnCartelera;
	private JComboBox<PuestoTrabajo> puestoComboBox;
	private JFrame vAnterior,vActual;
	private JLabel lblImg;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem itPersonal;
	private static final String nomfichTrabajadores = "ficheros/Trabajadores.csv";
	private Trabajador trabajador;
	private VentanaPrincipal vp;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	PanelConFondo panelFondo;


	public VentanaPrincipal(JFrame va) {
		super();
		vAnterior= va;
		vActual=this;
		
		Cine.cargarTrabajadoresEnLista(nomfichTrabajadores);

		pNorte = new JPanel();
		pCentro = new JPanel();
		pEste = new JPanel();
		pOeste = new JPanel();
		pSur = new JPanel();

		

		panelFondo = new PanelConFondo(new ImageIcon("imagenes/imagenFonndoVentPrin.png").getImage());
		
		puestoComboBox = new JComboBox<>(PuestoTrabajo.values());
		
		menuBar = new JMenuBar();
		menu = new JMenu ("Area del personal");
		menu.setFont(new Font("Arial", Font.BOLD, 15));
		menu.setBackground(new Color(125,192,230));
		menu.setForeground(Color.BLACK);
		itPersonal = new JMenuItem("Personal");
		itPersonal.setFont(new Font ("Arial", Font.BOLD, 15));
		itPersonal.addActionListener(new ActionListener() {
			
	    	 @Override
			    public void actionPerformed(ActionEvent e) {
	    		 	logger.log(Level.INFO, "SE HA CLICKADO EN PERSONAL");
	    		 
			        String dni = "";
			        Trabajador t = null;

			        while (t == null) {
			            dni = JOptionPane.showInputDialog("Ingrese su DNI:");

			            if (dni == null) {
			            	logger.log(Level.INFO, "SE HA INTENADO ENTRAR EN PERSONAL");
			                break;
			            }

			            if (dni.isEmpty()) {
			                JOptionPane.showMessageDialog(null, "Inserte el DNI", "ERROR", JOptionPane.ERROR_MESSAGE);
			                logger.log(Level.INFO, "NO SE HA INSERTADO DNI");
			            } else {
			                t = Cine.buscarTrabajador(dni);

			                if (t == null) {
			                    JOptionPane.showMessageDialog(null, "Trabajador no encontrado", "ERROR", JOptionPane.WARNING_MESSAGE);
			                    logger.log(Level.INFO, "NO SE HA ENCONTRADO EL DNI");
			                }
			            }
			        }
			       
			        if (t != null) {
			            PuestoTrabajo selectedCargo = null;
			            while (selectedCargo == null) {
			                puestoComboBox.setSelectedItem(t.getPuesto());
			                Object[] mensaje = {
			                        "Nombre y Apellidos:", t.getNombreApellidosTrabajador(),
			                        "Teléfono:", t.getTelefonoTrabajador(),
			                        "DNI:", dni,
			                        "Seleccione el cargo:", puestoComboBox
			                };

			                int result = JOptionPane.showConfirmDialog(null, mensaje, "Ingrese su información",
			                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

			                if (result == JOptionPane.OK_OPTION) {
			                    selectedCargo = (PuestoTrabajo) puestoComboBox.getSelectedItem();

			                    if (!dni.equals(t.getDni()) || !selectedCargo.equals(t.getPuesto())) {
			                        JOptionPane.showMessageDialog(null, "Cargo incorrecto", "ERROR", JOptionPane.WARNING_MESSAGE);
			                        logger.log(Level.INFO, "SE HA ESCOGIDO CARGO INCORRECTO");

			                        selectedCargo = null;
			                    } else {
			                        JOptionPane.showMessageDialog(null, "¡Bienvenido!", "SESIÓN INICIADA", JOptionPane.INFORMATION_MESSAGE);
			                        logger.log(Level.INFO, "PERSONAL HA INICIADO SESION");
			                        trabajador = t;
			                       new VentanaTrabajadores(vActual);
			                        vActual.setVisible(false);
			                    }
			                } else {
			                   
			                    break;
			                }
			            }
			        }
			    }
		});
		
		menu.add(itPersonal);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		panelFondo.add(pCentro, BorderLayout.CENTER);
		panelFondo.add(pNorte, BorderLayout.NORTH);
		panelFondo.add(pSur, BorderLayout.SOUTH);
		panelFondo.add(pEste, BorderLayout.EAST);
		panelFondo.add(pOeste, BorderLayout.WEST);

		int espacioEntrePeneles = 200;
		pNorte.setBorder(new EmptyBorder(espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles,espacioEntrePeneles));
		
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
		
		pSur.add(btnIniciarSesion);
		pSur.add(btnPrecios);
		pSur.add(btnCartelera);
		pNorte.setOpaque(false);
		pCentro.setOpaque(false);
		pSur.setOpaque(false);
		pEste.setOpaque(false);
		pOeste.setOpaque(false);
		
		
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
