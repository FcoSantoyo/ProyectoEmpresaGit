package gui;

import javax.swing.JComboBox;

import accesoadatos.RepositorioOficina;
import entidades.Oficina;

public class MetodosOficina {
	/**
	 * Metodo que devuelve un Jcombobox con un array de las oficinas
	 * @return
	 */
	public static JComboBox<Oficina> comboBoxOficinas(){
		JComboBox<Oficina> comboBoxOficina = new JComboBox<Oficina>();
		
		for (Oficina a : RepositorioOficina.listarOficinas() ){
			comboBoxOficina.addItem(a);
		}
		return comboBoxOficina;
	}
}
