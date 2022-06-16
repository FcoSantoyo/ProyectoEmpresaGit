package gui;

public class Columna {
	private String titulo;
	private int anchomin;
	private int anchomax;
	
	public Columna (String _titulo, int anchomin, int _anchomax)
	{
		this.setTitulo(_titulo);
		this.setAnchomin(anchomin);
		this.setAnchomax(_anchomax);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnchomin() {
		return anchomin;
	}

	public void setAnchomin(int anchomin) {
		this.anchomin = anchomin;
	}

	public int getAnchomax() {
		return anchomax;
	}

	public void setAnchomax(int anchomax) {
		this.anchomax = anchomax;
	}
}
