package screen;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import domain.Compra;

public class ModeloCompra extends DefaultTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Compra> lista;
	private List<String> titulos = (List<String>) Arrays.asList("FECHA","HORA","PELICULA","SALA","USUARIO","Nº ENTRADAS");
	
	public ModeloCompra(List<Compra> l) {
		lista = l;
	}
	
	@Override
	public int getRowCount() {
		if(lista==null)
			return 0;
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return titulos.size();
	}

	@Override
	public String getColumnName(int column) {
		return titulos.get(column);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		return null;
		}
	}
