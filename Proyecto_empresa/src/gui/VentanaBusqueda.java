package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class VentanaBusqueda extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JScrollPane scrollPane;
		private JTable table;
		private JButton btnSeleccionar;
		private JPanel buttonPane;
		private String titulo;
		private ArrayList<Columna> columna;
		private String nombremetodoCargadatos;
		DefaultTableModel modelo;
		Method metodoCargadatos;
		public Object objetoSeleccionado;
		private JLabel lblFiltroColumna;
		private JTextField textFieldFiltro_1;
		private JLabel lblFiltroColumna_1;
		private JTextField textFieldFiltro2;
		private TableRowSorter<DefaultTableModel> trs;
		/**
		 * Create the dialog.
		 */
		public VentanaBusqueda(String titulo, ArrayList<Columna> columna, String nombremetodoCargadatos) {
			setIconImage(Toolkit.getDefaultToolkit().getImage("lib\\buscar.png"));
			setModal(true);
			this.titulo=titulo;
			this.columna=columna;
			this.nombremetodoCargadatos=nombremetodoCargadatos;
			initGUI();
			preparaTabla();
			this.setLocationRelativeTo(null);//Lo centramos
			this.setVisible(true);
		}
		
		private void preparaTabla()
		{
			Interfaz.anyadecolumnas(table, columna);
			
			
			try {
				metodoCargadatos= new Interfaz().getClass().getDeclaredMethod(nombremetodoCargadatos, DefaultTableModel.class);
				metodoCargadatos.invoke(null,modelo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Interfaz.muestraError(e);
			
			}
			try {
				if(hayOpciones())
				{
					table.setRowSelectionInterval(0,0);
				}
			} catch (sinOpciones e) {
				// TODO Auto-generated catch block
				Interfaz.muestraError(e);
			}
			scrollPane.setViewportView(table);
		}
		private void initGUI() {
			// TODO Auto-generated method stub
			setTitle(titulo);
			
			setBounds(100,100,640,300);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5,5,5,5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			
			contentPanel.setLayout(new BorderLayout(0,0));
			
			creaPaneles();
			creaTabla();
			creaBotones();
			
			
		}
		private void creaTabla()
		{
			{
				modelo= new DefaultTableModel();
				table = new JTable(modelo);
				scrollPane.setViewportView(table);
				table.setAutoCreateRowSorter(true);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				
				
			}
			
		}
		private void creaPaneles()
		{
			{
				scrollPane = new JScrollPane();
				contentPanel.add(scrollPane, BorderLayout.CENTER);
				
			}
			{
				buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				
			}
		}
		private void creaBotones()
		{
			{
				lblFiltroColumna = new JLabel("Filtro columna1");
				buttonPane.add(lblFiltroColumna);
			}
			{
				textFieldFiltro_1 = new JTextField();
				textFieldFiltro_1.addKeyListener(new TextFieldFiltro_1KeyListener());
				buttonPane.add(textFieldFiltro_1);
				textFieldFiltro_1.setColumns(10);
			}
			{
				lblFiltroColumna_1 = new JLabel("Filtro columna 2");
				buttonPane.add(lblFiltroColumna_1);
			}
			{
				textFieldFiltro2 = new JTextField();
				textFieldFiltro2.addKeyListener(new TextFieldFiltro2KeyListener());
				buttonPane.add(textFieldFiltro2);
				textFieldFiltro2.setColumns(10);
			}
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			btnSeleccionar= new JButton("Seleccionar");
			btnSeleccionar.addActionListener(new BtnSeleccionarActionListener(this));
			buttonPane.add(btnSeleccionar);
		}
		private class BtnSeleccionarActionListener implements ActionListener {
			private VentanaBusqueda padre;
			private BtnSeleccionarActionListener(VentanaBusqueda padre)
			{
				this.padre=padre;
			}
			public void actionPerformed(ActionEvent arg0) {
				int filaselec=table.getSelectedRow();
				Object objeto = modelo.getValueAt(filaselec, 0);
				objetoSeleccionado =objeto;
				
				padre.setVisible(false);
			}
		}
		private class TextFieldFiltro_1KeyListener extends KeyAdapter {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldFiltro_1.addKeyListener(new KeyAdapter() {
					
					@Override
					public void keyReleased(KeyEvent ke)
					{
						trs.setRowFilter(RowFilter.regexFilter("(?i)"+textFieldFiltro_1.getText(), 0));
					}
				});
				trs= new TableRowSorter<>(modelo);
				table.setRowSorter(trs);
			}
		}
		private class TextFieldFiltro2KeyListener extends KeyAdapter {
			@Override
			public void keyTyped(KeyEvent e) {
				textFieldFiltro2.addKeyListener(new KeyAdapter() {
					
					@Override
					public void keyReleased(KeyEvent ke)
					{
						trs.setRowFilter(RowFilter.regexFilter("(?i)"+textFieldFiltro2.getText(), 1));
					}
				});
				trs= new TableRowSorter<>(modelo);
				table.setRowSorter(trs);
			}
		}
		private boolean hayOpciones() throws sinOpciones
		{
			if(modelo.getRowCount()>0)
			{
				table.setRowSelectionInterval(0,0);
				return true;
			}else {
				btnSeleccionar.setEnabled(false);
				throw new sinOpciones("No hay ningúna opción para seleccionar");
				
			}
			
		}
		class sinOpciones extends Exception
		{
			public sinOpciones() {}
			public sinOpciones(String mensaje) {
				super(mensaje);
			}
	}

}
