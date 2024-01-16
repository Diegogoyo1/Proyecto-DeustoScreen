package screen;

import java.awt.BorderLayout; 
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
	private JFrame vActual, vAnterior;
	private JButton btnAtras,btnEliminar;
	private JTable tblCompras;
	private DefaultTableModel modelo;
	private JPanel pSur,pCentro, pOeste;
	private JScrollPane scroll;
	private JTree arbolUsuarios;
	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	public VentanaTrabajadores(JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		
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
		setVisible(true);
		
//		arbolUsuarios.addTreeSelectionListener(new TreeSelectionListener() {
//			
//				@Override
//				public void valueChanged(TreeSelectionEvent e) {
//					TreePath tp = e.getPath();
//					String nick = tp.getLastPathComponent().toString();
//			
//					/*Cargamos la primera tabla*/
//					Map<Usuario, List<Compra>> compras = Cine.getMapaCompras();
//					List<Compra> compraDelUsuario = new ArrayList<>();
//					List<Compra> co = Cine.Lis
//					for(Usuario u: compras.keySet()) {
//						if(!compras.containsKey(u)) {
//							compras.put(u, compraDelUsuario);
//						}else {
//							compras.get(u).add();
//						}
//					}
//					tblCompras.getModel();
//				
//				}
//			});
//	
		
		
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
	
	
	
	private void cargarArbol() {
		Cine.cargarUsuarioEnLista("ficheros/Usuarios.csv");
		List<Usuario> usuarios = Cine.getListaUsuarios();
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("USUARIOS");
		DefaultTreeModel modeloArbol = new DefaultTreeModel(raiz);
		int i=0;
		arbolUsuarios = new JTree();
		
		for(Usuario u: usuarios) {
			//DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(u); Si queremos que los nodos contengan el objeto usuario
			DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(u.getCorreoElectronico());
			modeloArbol.insertNodeInto(nodo, raiz, i);
			i++;
		}
		
		arbolUsuarios.setModel(modeloArbol);
	}
	
}
