package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import com.toedter.components.JLocaleChooser;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;

public class FormularioProgramador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JDateChooser fechas;
	private JTextField textField_4;
	/**
	 * Create the frame.
	 */
	public FormularioProgramador() {
		setTitle("Formulario Programador");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\nut.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 535);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dni");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(27, 90, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(27, 146, 103, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido 1");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setBounds(27, 202, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido 2");
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setBounds(27, 258, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(27, 115, 103, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(27, 171, 103, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(27, 227, 103, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(27, 283, 103, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
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
			}
		});
		btnNewButton_2.setBounds(163, 453, 113, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("Programador");
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblNewLabel_4.setBounds(27, 33, 140, 45);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(SystemColor.textHighlight);
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\buscarf2.png"));
		btnNewButton_3.setBounds(142, 114, 35, 23);
		contentPane.add(btnNewButton_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(237, 114, 285, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Oficina");
		lblNewLabel_5.setForeground(SystemColor.textHighlight);
		lblNewLabel_5.setBounds(237, 90, 49, 14);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(237, 170, 285, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_6 = new JLabel("Direcci\u00F3n");
		lblNewLabel_6.setForeground(SystemColor.textHighlight);
		lblNewLabel_6.setBounds(237, 146, 71, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha de nacimiento");
		lblNewLabel_7.setForeground(SystemColor.textHighlight);
		lblNewLabel_7.setBounds(27, 314, 140, 14);
		contentPane.add(lblNewLabel_7);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(27, 339, 103, 20);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_8 = new JLabel("Fecha de alta");
		lblNewLabel_8.setForeground(SystemColor.textHighlight);
		lblNewLabel_8.setBounds(27, 370, 103, 14);
		contentPane.add(lblNewLabel_8);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(27, 399, 103, 20);
		contentPane.add(dateChooser_1);
		
		JLabel lblNewLabel_9 = new JLabel("Tecnologias que domina");
		lblNewLabel_9.setForeground(SystemColor.textHighlight);
		lblNewLabel_9.setBounds(237, 202, 140, 14);
		contentPane.add(lblNewLabel_9);
		
		textField_4 = new JTextField();
		textField_4.setBounds(237, 227, 255, 132);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
	}
	}


