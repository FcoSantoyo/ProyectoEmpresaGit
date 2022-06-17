package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CentrarVentana {
	public static void centrar(JFrame a)
	{
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		a.setLocation(dim.width/2-a.getSize().width/2, dim.height/2-a.getSize().height/2);
}
	public static void centrarPrincipal(JPanel a)
	{
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		a.setLocation(dim.width/2-a.getSize().width/2, dim.height/2-a.getSize().height/2);
}
	public static void centrarPrincipal(JDialog a)
	{
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		a.setLocation(dim.width/2-a.getSize().width/2, dim.height/2-a.getSize().height/2);
}
}
