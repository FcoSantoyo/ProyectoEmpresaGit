package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import com.toedter.components.JLocaleChooser;

import accesoadatos.RepositorioDireccion;
import accesoadatos.RepositorioOficina;
import accesoadatos.RepositorioProgramador;
import accesoadatos.RepositorioVendedor;
import entidades.Direccion;
import entidades.Oficina;
import entidades.Programador;
import entidades.Vendedor;
import excepciones.ExcepcionDni;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;

public class FormularioProgramador extends JFrame {

	private JPanel contentPane;
	private JTextField Dni;
	private JTextField Nombre;
	private JTextField Ap1;
	private JTextField Ap2;
	private JDateChooser Fechanac = new JDateChooser();
	private JDateChooser Fechalta = new JDateChooser();
	private JComboBox<Oficina> comboBoxOficina;
	private JComboBox<Direccion> comboBoxDireccion;
	private JTextPane Tecnologias;
	private DefaultComboBoxModel<Oficina> combitoOficina;
	private DefaultComboBoxModel<Direccion> combitoDireccion;
	
	
	/**
	 * Create the frame.
	 */
	public FormularioProgramador() {
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
					String tecnologias = Tecnologias.getText();
					
					String[] array = tecnologias.split("/",-1);
					for (int i=0; i<array.length; i++)
						System.out.println(array[i]);
					ArrayList<String> tecnologia = new ArrayList<String>();
					
					for (String tecno : array)
						tecnologia.add(tecno);
					
					
					
					Programador p = null;
					
					try {
						p = new Programador(dni,nombre,ap1,ap2,fechanac,direccion,fechalta,oficina,tecnologia);
					} catch (ExcepcionDni e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					RepositorioProgramador.creaProgramador(p);
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

                try {
					RepositorioProgramador.borrarProgramador(dni);
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
				String tecnologias = Tecnologias.getText();
				
				String[] array = tecnologias.split("/",-1);
				for (int i=0; i<array.length; i++)
					System.out.println(array[i]);
				ArrayList<String> tecnologia = new ArrayList<String>();
				
				for (String tecno : array)
					tecnologia.add(tecno);
				
				
				
				Programador p = null;
				
				try {
					p = new Programador(dni,nombre,ap1,ap2,fechanac,direccion,fechalta,oficina,tecnologia);
				} catch (ExcepcionDni e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				RepositorioProgramador.modificarProgramador(p);
			}
		});
		btnNewButton_2.setBounds(163, 453, 113, 23);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_2);
		JLabel lblNewLabel_4 = new JLabel("Programador");
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblNewLabel_4.setBounds(27, 33, 140, 45);
		contentPane.add(lblNewLabel_4);
		
		
		//Boton buscar para abrir formulario de búsqueda
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoProgramadores lp = new ListadoProgramadores();
				lp.setVisible(true);
				
				//Rellenar jtextfields
				Dni.setText(lp.p.getDni());
				Nombre.setText(lp.p.getNombre());
				Ap1.setText(lp.p.getAp1());
				Ap2.setText(lp.p.getAp2());
				Fechanac.setDateFormatString(lp.p.getFecha_nac());
				comboBoxDireccion.setSelectedItem(lp.p.getDireccion());
				Fechalta.setDateFormatString(lp.p.getFecha_alta());
				comboBoxOficina.setSelectedItem((Oficina )lp.p.getOficina());
				//Tecnologias.setText((String) lp.p.getTecnologias());
				
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
		
		JLabel lblNewLabel_9 = new JLabel("Tecnologias que domina");
		lblNewLabel_9.setForeground(SystemColor.textHighlight);
		lblNewLabel_9.setBounds(237, 202, 140, 14);
		contentPane.add(lblNewLabel_9);
		
		Tecnologias = new JTextPane();
		Tecnologias.setBorder(new LineBorder(UIManager.getColor("Button.focus")));
		Tecnologias.setBackground(UIManager.getColor("Button.disabledShadow"));
		Tecnologias.setBounds(237, 227, 258, 132);
		contentPane.add(Tecnologias);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(237, 227, 171, 101);
		contentPane.add(textPane_1);
		
		JButton btnNewButton_4 = new JButton("Limpiar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Dni.setText("");
			Nombre.setText("");
			Ap1.setText("");
			Ap2.setText("");
			Fechanac.setDate(null);
			comboBoxDireccion.setSelectedItem(null);
			Fechalta.setDate(null);
			comboBoxOficina.setSelectedItem(null);
			Tecnologias.setText("");
			}
		});
		btnNewButton_4.setForeground(SystemColor.text);
		btnNewButton_4.setBackground(SystemColor.textHighlight);
		btnNewButton_4.setBounds(10, 453, 89, 23);
		contentPane.add(btnNewButton_4);
		
		
	}
	}


