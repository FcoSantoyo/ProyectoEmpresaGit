package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import accesoadatos.RepositorioOficina;
import entidades.Oficina;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListadoNominas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBoxOficina;
	private DefaultComboBoxModel<Oficina> combitoOficina;
	private JTable tablaMultiple;
	private DefaultTableModel model;

	/**
	 * Create the frame.
	 */
	public ListadoNominas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00F3minas");
		lblNewLabel.setBounds(295, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mes");
		lblNewLabel_1.setBounds(25, 80, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Oficina");
		lblNewLabel_2.setBounds(25, 125, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(92, 76, 87, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBoxOficina = new JComboBox();
		DefaultComboBoxModel<Oficina> combitoOficina = new DefaultComboBoxModel<Oficina>();
		comboBoxOficina.setBackground(Color.WHITE);
		comboBoxOficina.setBounds(92, 121, 237, 22);
		contentPane.add(comboBoxOficina);
		combitoOficina.addAll(RepositorioOficina.listarOficinas());
		comboBoxOficina.setModel(combitoOficina);
		//....................................................................................................................................................................
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 169, 660, 201);
		contentPane.add(scrollPane);
		JTable tablaMultiple = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		tablaMultiple.setModel(model);
		
		model.addColumn("Oficina");
		model.addColumn("Empleado");
		model.addColumn("Nómina");
		
		scrollPane.setViewportView(tablaMultiple);
	}
}
