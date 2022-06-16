package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import accesoadatos.RepositorioVendedor;
import entidades.Vendedor;
import excepciones.ExcepcionDni;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ListadoVendedores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;


	/**
	 * Create the dialog.
	 * @throws ExcepcionDni 
	 * @throws ParseException 
	 */
	public ListadoVendedores() throws ParseException, ExcepcionDni {
		setModal(true);
		setBounds(100, 100, 802, 435);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 73, 766, 279);
		contentPanel.add(table);
		DefaultListModel<ArrayList<Vendedor>> modelo = new DefaultListModel<ArrayList<Vendedor>>();
		modelo.addElement(RepositorioVendedor.listarVendedores());
		
		JLabel lblNewLabel = new JLabel("Listado de Vendedores");
		lblNewLabel.setBounds(10, 48, 192, 14);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirmar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
