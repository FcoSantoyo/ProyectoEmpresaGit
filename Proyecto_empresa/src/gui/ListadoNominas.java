package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import accesoadatos.RepositorioOficina;
import accesoadatos.RepositorioProgramador;
import accesoadatos.RepositorioVendedor;
import entidades.Empleado;
import entidades.Mes;
import entidades.Oficina;
import entidades.Programador;
import entidades.Vendedor;
import excepciones.ExcepcionDni;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.SystemColor;
import com.toedter.calendar.JMonthChooser;

public class ListadoNominas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBoxOficina;
	private DefaultComboBoxModel<Oficina> combitoOficina;
	private JTable tablaMultiple;
	private DefaultTableModel model;
	private ArrayList<Empleado> listado;
	private ArrayList<Programador> programadores;
	private ArrayList<Vendedor> vendedores;
	private DefaultComboBoxModel<Mes> Mesitos;
	JComboBox Meses;
	String nombremes = "Incio";
	Mes messi;
	int posicion;



	/**
	 * Create the frame.
	 * @throws ExcepcionDni 
	 * @throws ParseException 
	 */
	public ListadoNominas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 696, 470);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00F3minas");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 22));
		lblNewLabel.setBounds(25, 0, 154, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mes");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(25, 80, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Oficina");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setBounds(25, 125, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		Meses = new JComboBox();
		Meses.setBounds(92, 76, 121, 22);
		contentPane.add(Meses);
		Mesitos = new DefaultComboBoxModel<Mes>();
		Mesitos.addAll(Mes.losMeses());
		Meses.setModel(Mesitos);
		
		
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
		model = new DefaultTableModel();
		tablaMultiple.setModel(model);
		
		model.addColumn("Dni");
		model.addColumn("Oficina");
		model.addColumn("Empleado");
		model.addColumn("Nómina");
		
		scrollPane.setViewportView(tablaMultiple);

		
		
		try {
			this.rellenaTablaP();
		} catch (ExcepcionDni e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.rellenaTablaV();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionDni e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void rellenaTablaV() throws ParseException, ExcepcionDni {
        ArrayList<Vendedor> listaEmple = RepositorioVendedor.listarVendedores();
         
        messi =(Mes) Meses.getSelectedItem();
        posicion = messi.getPosicion();
        
        
        
        for(Vendedor e : listaEmple) {
            Object[] fila = new Object[6];
            fila[0]= e.getDni();
            fila[1]= e.getOficina();
            fila[2]= e.getNombre() + " " + e.getAp1();
            fila[5]= e.nominaf(posicion);

            model.addRow(fila);
        }

    }

    public void rellenaTablaP() throws ExcepcionDni {
        ArrayList<Programador> listaEmple = RepositorioProgramador.listarProgramadores();
        
        messi =(Mes) Meses.getSelectedItem();
        posicion = messi.getPosicion();
        
        
        for(Programador e : listaEmple) {
            Object[] fila = new Object[6];
            fila[0]= e.getDni();
            fila[1]= e.getOficina();
            fila[2]= e.getNombre() + " " + e.getAp1();
            fila[5]= e.nominaf(posicion);

            model.addRow(fila);
        }

    }
}
