package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\nut.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 504);
		//Barra de menú principal
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//Menu item para seleccionas las opciones del menú de mantenimiento de formularios
		JMenu barrademenu = new JMenu("Mantenimiento");
		menuBar.add(barrademenu);
		
		//LLamada al formulario de direccion
		JMenuItem mntmNewMenuItem = new JMenuItem("Dirección");
		barrademenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		FormularioDireccion fDireccion = new FormularioDireccion();
		 		fDireccion.setVisible(true);
		 		CentrarVentana.centrar(fDireccion);
		 	}
		 });
		
		//LLamada al formulario de Oficinas
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Oficinas");
		barrademenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		FormularioOficina fOficina = new FormularioOficina();
		 		fOficina.setVisible(true);
		 		CentrarVentana.centrar(fOficina);
		 	}
		 });
		
		//LLamada al formulario de Vendedores
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Vendedor");
		barrademenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		FormularioVendedor fVendedor = new FormularioVendedor();
		 		fVendedor.setVisible(true);
		 		CentrarVentana.centrar(fVendedor);
		 	}
		 });
		
		//LLamada al formulario de Programadores
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Programador");
		barrademenu.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		FormularioProgramador fProgramador = new FormularioProgramador();
		 		fProgramador.setVisible(true);
		 		CentrarVentana.centrar(fProgramador);
		 	}
		 });
		JMenu mnNewMenu_1 = new JMenu("N\u00F3minas");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Calcular N\u00F3minas");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(SystemColor.inactiveCaptionBorder);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\officelogo.jpg"));
		lblNewLabel.setBounds(-34, -18, 818, 486);
		contentPane.add(lblNewLabel);
		 	}
	}
	
