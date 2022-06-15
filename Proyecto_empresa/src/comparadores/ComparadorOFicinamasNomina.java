package comparadores;

import java.util.Comparator;

import entidades.Empleado;

public class ComparadorOFicinamasNomina implements Comparator<Empleado> {

	@Override
	public int compare(Empleado e1, Empleado e2) {
		// TODO Auto-generated method stub
		String s1=e1.getOficina().getNombre()+e1.getNombre();
		String s2=e2.getOficina().getNombre()+e2.getNombre();
		return s1.compareTo(s2);
	}

}
