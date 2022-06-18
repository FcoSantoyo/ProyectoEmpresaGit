package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import accesoadatos.RepositorioDireccion;
import entidades.Direccion;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Toolkit;

public class FormularioDireccion extends JFrame {

	private JPanel contentPane;
	private JTextField Codigo;
	private JTextField N_via;
	private JTextField Nm_via;
	private JTextField Cod_postal;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;


	/**
	 * Create the frame.
	 */
	public FormularioDireccion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\nut.png"));
		setTitle("Formulario de Direcci\u00F3n");
		setBackground(SystemColor.text);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 535);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(27, 97, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la calle");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(27, 153, 140, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero del portal");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setBounds(27, 209, 129, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("C\u00F3digo postal");
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setBounds(27, 265, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		Codigo = new JTextField();
		Codigo.setBounds(27, 122, 46, 20);
		contentPane.add(Codigo);
		Codigo.setColumns(10);
		
		N_via = new JTextField();
		N_via.setBounds(27, 178, 103, 20);
		contentPane.add(N_via);
		N_via.setColumns(10);
		
		Nm_via = new JTextField();
		Nm_via.setBounds(28, 234, 24, 20);
		contentPane.add(Nm_via);
		Nm_via.setColumns(10);
		
		Cod_postal = new JTextField();
		Cod_postal.setBounds(27, 290, 46, 20);
		contentPane.add(Cod_postal);
		Cod_postal.setColumns(10);
		
		
		btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Primero valido si es una dirección válida (campos vacíos...) METERLE AUTOINCREMENTABLE DESDE ORACLE PARA QUE EL CODIGO PK SEA ALEATORIO Y ME LO DE ORACLE
				Direccion d = null;
				d= new Direccion(Integer.valueOf(Codigo.getText()),N_via.getText(),Integer.valueOf(Nm_via.getText()),Integer.valueOf(Cod_postal.getText()));
				RepositorioDireccion.crearDireccion(d);
			}
		});
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\guardarF.png"));
		btnNewButton.setBounds(409, 453, 113, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Borrar");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\BorrarF.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Direccion d = null;
				d= new Direccion(Integer.valueOf(Codigo.getText()),N_via.getText(),Integer.valueOf(Nm_via.getText()),Integer.valueOf(Cod_postal.getText()));
				try {
					RepositorioDireccion.borrarDireccion(d.getCodigo_direccion());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(286, 453, 113, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\modificarF.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Direccion d = null;
				d= new Direccion(Integer.valueOf(Codigo.getSelectedText()),N_via.getSelectedText(),Integer.valueOf(Nm_via.getSelectedText()),Integer.valueOf(Cod_postal.getSelectedText()));
				RepositorioDireccion.modificarDireccion(d);
			}
		});
		btnNewButton_2.setBounds(163, 453, 113, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion");
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblNewLabel_4.setBounds(27, 26, 140, 45);
		contentPane.add(lblNewLabel_4);
	}
}
