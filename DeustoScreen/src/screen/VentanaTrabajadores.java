package screen;

import java.awt.BorderLayout; 
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import domain.Cine;
import domain.Compra;
import domain.Usuario;


public class VentanaTrabajadores extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame vActual, vAnterior;
	private JButton btnAtras,btnEliminar;
	private JTable tblCompras;
	private DefaultTableModel modelo;
	private JPanel pSur,pCentro, pOeste;
	private JScrollPane scroll;
	private JTree arbolUsuarios;
	private HashMap<String, Usuario> mapa;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	public VentanaTrabajadores(JFrame va) {
		super();
		vActual = this;
		vAnterior = va; 
		mapa = new HashMap<>();
		Cine.cargarMapaCompras("ficheros/Compras.dat");
		
		//CREAR PANELES
		pCentro = new JPanel(new GridLayout(1,1));
		pSur = new JPanel();
		pOeste = new JPanel();
		
		getContentPane().add(pCentro, BorderLayout.CENTER);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pOeste, BorderLayout.WEST);
		
		//CREACION DE BOTONES
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener((e)-> {
			logger.log(Level.INFO, "SE HA CLICKADO EL BOTON ATRAS");
			vActual.dispose();
			vAnterior.setVisible(true);
		});
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener((e)-> {
		
		});
		
		//CREACION DE LA TABLA
		modelo = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		String [] titulos = {"FECHA","HORA","PELICULA","SALA","USUARIO","Nº ENTRADAS"};
		modelo.setColumnIdentifiers(titulos);
		tblCompras = new JTable(modelo);
		scroll = new JScrollPane(tblCompras);
		
		cargarArbol();
		
		
		//ANIADIR LOS COMPONENTES A LOS PANELES
		pSur.add(btnAtras);
		pSur.add(btnEliminar);
		pCentro.add(scroll);
		pOeste.add(arbolUsuarios);
		
	
		arbolUsuarios.addTreeSelectionListener(new TreeSelectionListener() {
			
				@Override
				public void valueChanged(TreeSelectionEvent e) {
					TreePath tp = e.getPath();
					String nick = tp.getLastPathComponent().toString();
					List<Compra> compraDelUsuario = Cine.getMapaCompras().get(mapa.get(nick));
					tblCompras.setModel(new ModeloCompra(compraDelUsuario));
				}
			});
	
		
		
		int anchoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
		int altoP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		setSize(anchoP, altoP);
		setExtendedState(MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 450, 300);
		setTitle("AREA TRABAJADORES");
		setVisible(true);
		
	}
	
	
	/**
	 * Metodo que carga el arbol con los usuarios
	 */
	private void cargarArbol() {
		Cine.cargarUsuarioEnLista("ficheros/Usuarios.csv");
		List<Usuario> usuarios = Cine.getListaUsuarios();
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("USUARIOS");
		DefaultTreeModel modeloArbol = new DefaultTreeModel(raiz);
		int i=0;
		arbolUsuarios = new JTree();
		
		for(Usuario u: usuarios) {
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(u.getCorreoElectronico());
			mapa.put(u.getCorreoElectronico(), u);
			modeloArbol.insertNodeInto(nodo, raiz, i);
			i++;
		}
		
		arbolUsuarios.setModel(modeloArbol);
	}
	
}
