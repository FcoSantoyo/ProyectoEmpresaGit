package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import accesoadatos.RepositorioDireccion;
import accesoadatos.RepositorioOficina;
import entidades.Direccion;
import entidades.Oficina;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JComboBox;

public class FormularioOficina extends JFrame {

	private JPanel contentPane;
	private JTextField Codigo;
	private JTextField Nombre;
	private JComboBox comboBoxDireccion;
	private DefaultComboBoxModel<Direccion> combitoDireccion;
	

	/**
	 * Create the frame.
	 */
	public FormularioOficina() {
		setTitle("Formulario Oficinas");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\nut.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 535);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(27, 97, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la oficina");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(27, 153, 140, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo de la direcci\u00F3n");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setBounds(27, 209, 127, 14);
		contentPane.add(lblNewLabel_2);
		
		Codigo = new JTextField();
		Codigo.setBounds(27, 122, 46, 20);
		contentPane.add(Codigo);
		Codigo.setColumns(10);
		
		Nombre = new JTextField();
		Nombre.setBounds(27, 178, 103, 20);
		contentPane.add(Nombre);
		Nombre.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oficina o = null;
				o = new Oficina(Integer.parseInt(Codigo.getText()),Nombre.getText(),(Direccion ) comboBoxDireccion.getSelectedItem());
				RepositorioOficina.creaOficina(o);
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
				Oficina o = null;
				o = new Oficina(Integer.parseInt(Codigo.getText()),Nombre.getText(),(Direccion ) comboBoxDireccion.getSelectedItem());
				try {
					RepositorioOficina.borraOficina(o.getCodigo());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(286, 453, 113, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\modificarF.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oficina o = null;
				o = new Oficina(Integer.parseInt(Codigo.getText()),Nombre.getText(),(Direccion ) comboBoxDireccion.getSelectedItem());
				RepositorioOficina.modificarOficina(o);
			}
		});
		btnNewButton_2.setBounds(163, 453, 113, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Oficinas");
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblNewLabel_4.setBounds(27, 26, 140, 45);
		contentPane.add(lblNewLabel_4);
		
		comboBoxDireccion = new JComboBox();
		combitoDireccion = new DefaultComboBoxModel<Direccion>();
		comboBoxDireccion.setForeground(SystemColor.textHighlight);
		comboBoxDireccion.setBackground(Color.WHITE);
		comboBoxDireccion.setBounds(27, 234, 285, 22);
		contentPane.add(comboBoxDireccion);
		combitoDireccion.addAll(RepositorioDireccion.listarDirecciones());
		comboBoxDireccion.setModel(combitoDireccion);
	}
}
