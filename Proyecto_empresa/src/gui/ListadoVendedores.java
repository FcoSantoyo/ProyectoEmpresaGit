package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import accesoadatos.RepositorioVendedor;
import entidades.Vendedor;
import excepciones.ExcepcionDni;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoVendedores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tablaVendedores;
	private DefaultTableModel model;
	private ArrayList<Vendedor> listado;
	public Vendedor v;
	/**
	 * Create the dialog.
	 */
	public ListadoVendedores() {
		setModal(true);
		setBounds(100, 100, 1108, 404);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 84, 1072, 237);
			contentPanel.add(scrollPane);
			{
				tablaVendedores = new JTable();
				model = new DefaultTableModel();
				tablaVendedores.setModel(model);
				
				model.addColumn("Dni");
				model.addColumn("Nombre");
				model.addColumn("Primer apellido");
				model.addColumn("Segundo apellido");
				model.addColumn("Fecha de nacimiento");
				model.addColumn("Dirección");
				model.addColumn("Fecha de alta");
				model.addColumn("Oficina");
				model.addColumn("Zonas donde trabaja");
				
				
				
				scrollPane.setViewportView(tablaVendedores);
				
				
				try {
					this.llenartabla();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExcepcionDni e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		JLabel lblNewLabel = new JLabel("Listado de vendedores");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(10, 55, 160, 14);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirmar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				okButton.setForeground(SystemColor.text);
				okButton.setBackground(SystemColor.textHighlight);
				okButton.setIcon(new ImageIcon("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\comprobado (1).png"));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setForeground(SystemColor.text);
				cancelButton.setBackground(SystemColor.textHighlight);
				cancelButton.setIcon(new ImageIcon("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\cancelar.png"));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			
			
		}
	}
	public void llenartabla() throws ParseException, ExcepcionDni {
		 listado = RepositorioVendedor.listarVendedores();
		
		for (Vendedor vendedor : listado) {
			Object[] fila = new Object[9];
			fila[0]=vendedor.getDni();
			fila[1]=vendedor.getNombre();
			fila[2]=vendedor.getAp1();
			fila[3]=vendedor.getAp2();
			fila[4]=vendedor.getFecha_nac();
			fila[5]=vendedor.getDireccion().getNombre_via();
			fila[6]=vendedor.getFecha_alta();
			fila[7]=vendedor.getOficina().getNombre();
			fila[8]=vendedor.getZona();
			
			model.addRow(fila);
		}
	}
}
