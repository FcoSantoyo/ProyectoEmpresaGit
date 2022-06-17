package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import accesoadatos.RepositorioDireccion;
import accesoadatos.RepositorioOficina;
import accesoadatos.RepositorioVendedor;
import entidades.Direccion;
import entidades.Oficina;
import entidades.Vendedor;
import excepciones.ExcepcionDni;

import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSeparator;

public class FormularioVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField Dni;
	private JTextField Nombre;
	private JTextField Ap1;
	private JTextField Ap2;
	private JDateChooser Fechanac = new JDateChooser();
	private JDateChooser Fechalta = new JDateChooser();
	private JComboBox<Oficina> comboBoxOficina;
	private JComboBox<Direccion> comboBoxDireccion;
	private JTextPane Zonas;
	private DefaultComboBoxModel<Oficina> combitoOficina;
	private DefaultComboBoxModel<Direccion> combitoDireccion;
	/**
	 * Create the frame.
	 */
	public FormularioVendedor() {
		setForeground(SystemColor.textHighlight);
		setBackground(SystemColor.infoText);
		setTitle("Formulario Vendedor");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\nut.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 535);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDNI = new JLabel("Dni");
		lblDNI.setForeground(SystemColor.textHighlight);
		lblDNI.setBounds(27, 90, 46, 14);
		contentPane.add(lblDNI);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(SystemColor.textHighlight);
		lblNombre.setBounds(27, 146, 103, 14);
		contentPane.add(lblNombre);
		
		JLabel lblAp1 = new JLabel("Apellido 1");
		lblAp1.setForeground(SystemColor.textHighlight);
		lblAp1.setBounds(27, 202, 86, 14);
		contentPane.add(lblAp1);
		
		JLabel lblAp2 = new JLabel("Apellido 2");
		lblAp2.setForeground(SystemColor.textHighlight);
		lblAp2.setBounds(27, 258, 86, 14);
		contentPane.add(lblAp2);
		//Text field de dni
		Dni = new JTextField();
		Dni.setBounds(27, 115, 103, 20);
		contentPane.add(Dni);
		Dni.setColumns(10);
		//Text field de nombre
		Nombre = new JTextField();
		Nombre.setBounds(27, 171, 103, 20);
		contentPane.add(Nombre);
		Nombre.setColumns(10);
		//Text field de primer apelldio
		Ap1 = new JTextField();
		Ap1.setBounds(27, 227, 103, 20);
		contentPane.add(Ap1);
		Ap1.setColumns(10);
		
		Ap2 = new JTextField();
		Ap2.setBounds(27, 283, 103, 20);
		contentPane.add(Ap2);
		Ap2.setColumns(10);
		//Boton guardar que crea un vendedor
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String dni = Dni.getText();
					String nombre= Nombre.getText();
					String ap1= Ap1.getText();
					String ap2=Ap2.getText();
					String fechanac= metodos.fechas.convierteDateString(Fechanac.getDate());
					Direccion direccion = (Direccion) comboBoxDireccion.getSelectedItem();
					String fechalta = metodos.fechas.convierteDateString(Fechalta.getDate());
					Oficina oficina = (Oficina) comboBoxOficina.getSelectedItem();
					String zona = Zonas.getText();

					Vendedor v = null;
					
					try {
						v = new Vendedor(dni,nombre,ap1,ap2,fechanac,direccion,fechalta,oficina,zona);
					} catch (ExcepcionDni e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					RepositorioVendedor.creaVendedor(v);
			  }
		});
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\guardarF.png"));
		btnNewButton.setBounds(409, 453, 113, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Borrar");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\BorrarF.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = Dni.getText();
				String nombre= Nombre.getText();
				String ap1= Ap1.getText();
				String ap2=Ap2.getText();
				String fechanac= metodos.fechas.convierteDateString(Fechanac.getDate());
				Direccion direccion = (Direccion) comboBoxDireccion.getSelectedItem();
				String fechalta = metodos.fechas.convierteDateString(Fechalta.getDate());
				Oficina oficina = (Oficina) comboBoxOficina.getSelectedItem();
				String zona = Zonas.getText();

				Vendedor v = null;
				
				try {
					v = new Vendedor(dni,nombre,ap1,ap2,fechanac,direccion,fechalta,oficina,zona);
				} catch (ExcepcionDni e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					RepositorioVendedor.borrarVendedor(dni);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		  }
		});
		btnNewButton_1.setBounds(286, 453, 113, 23);
		contentPane.add(btnNewButton_1);
		
		
		//Boton modificar
		JButton btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\modificarF.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = Dni.getText();
				String nombre= Nombre.getText();
				String ap1= Ap1.getText();
				String ap2=Ap2.getText();
				String fechanac= metodos.fechas.convierteDateString(Fechanac.getDate());
				Direccion direccion = (Direccion) comboBoxDireccion.getSelectedItem();
				String fechalta = metodos.fechas.convierteDateString(Fechalta.getDate());
				Oficina oficina = (Oficina) comboBoxOficina.getSelectedItem();
				String zona = Zonas.getText();

				Vendedor v = null;
				
				try {
					v = new Vendedor(dni,nombre,ap1,ap2,fechanac,direccion,fechalta,oficina,zona);
				} catch (ExcepcionDni e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				RepositorioVendedor.modificarVendedor(v);
			}
		});
		btnNewButton_2.setBounds(163, 453, 113, 23);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_2);
		JLabel lblNewLabel_4 = new JLabel("Vendedor");
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblNewLabel_4.setBounds(27, 33, 140, 45);
		contentPane.add(lblNewLabel_4);
		
		
		//Boton buscar para abrir formulario de búsqueda
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoVendedores lv = new ListadoVendedores();
				lv.setVisible(true);
				CentrarVentana.centrarPrincipal(lv);
				try {
					lv.llenartabla();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExcepcionDni e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setBackground(SystemColor.textHighlight);
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\buscarf2.png"));
		btnNewButton_3.setBounds(142, 114, 35, 23);
		contentPane.add(btnNewButton_3);
		
		
		//Combo box de Oficina
		comboBoxOficina = new JComboBox();
		combitoOficina = new DefaultComboBoxModel<Oficina>();
		comboBoxOficina.setBackground(Color.WHITE);
		comboBoxOficina.setBounds(237, 114, 285, 22);
		contentPane.add(comboBoxOficina);
		combitoOficina.addAll(RepositorioOficina.listarOficinas());
		comboBoxOficina.setModel(combitoOficina);
		
		
		JLabel lblNewLabel_5 = new JLabel("Oficina");
		lblNewLabel_5.setForeground(SystemColor.textHighlight);
		lblNewLabel_5.setBounds(237, 90, 49, 14);
		contentPane.add(lblNewLabel_5);
		
		//Combo box de Direccion
		comboBoxDireccion = new JComboBox();
		combitoDireccion = new DefaultComboBoxModel<Direccion>();
		comboBoxDireccion.setForeground(SystemColor.textHighlight);
		comboBoxDireccion.setBackground(Color.WHITE);
		comboBoxDireccion.setBounds(237, 170, 285, 22);
		contentPane.add(comboBoxDireccion);
		combitoDireccion.addAll(RepositorioDireccion.listarDirecciones());
		comboBoxDireccion.setModel(combitoDireccion);
		
		
		JLabel lblNewLabel_6 = new JLabel("Direcci\u00F3n");
		lblNewLabel_6.setForeground(SystemColor.textHighlight);
		lblNewLabel_6.setBounds(237, 146, 86, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha de nacimiento");
		lblNewLabel_7.setForeground(SystemColor.textHighlight);
		lblNewLabel_7.setBounds(27, 314, 140, 14);
		contentPane.add(lblNewLabel_7);
		
		Fechalta.setDateFormatString("dd-MM-yyyy");
		Fechalta.setBounds(27, 339, 103, 20);
		contentPane.add(Fechalta);
		
		JLabel lblNewLabel_8 = new JLabel("Fecha de alta");
		lblNewLabel_8.setForeground(SystemColor.textHighlight);
		lblNewLabel_8.setBounds(27, 370, 103, 14);
		contentPane.add(lblNewLabel_8);
		
		
		Fechanac.setDateFormatString("dd-MM-yyyy");
		Fechanac.setBounds(27, 399, 103, 20);
		contentPane.add(Fechanac);
		
		JLabel lblNewLabel_9 = new JLabel("Zonas donde trabaja");
		lblNewLabel_9.setForeground(SystemColor.textHighlight);
		lblNewLabel_9.setBounds(237, 202, 140, 14);
		contentPane.add(lblNewLabel_9);
		
		Zonas = new JTextPane();
		Zonas.setBorder(new LineBorder(UIManager.getColor("Button.focus")));
		Zonas.setBackground(UIManager.getColor("Button.disabledShadow"));
		Zonas.setBounds(237, 227, 258, 132);
		contentPane.add(Zonas);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(237, 227, 171, 101);
		contentPane.add(textPane_1);
		
		
	}
	}



