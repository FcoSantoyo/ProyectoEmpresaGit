package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import accesoadatos.RepositorioProgramador;
import entidades.Programador;
import excepciones.ExcepcionDni;

public class ListadoProgramadores extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JTable tablaProgramador;
	private DefaultTableModel model;
	private ArrayList<Programador> listado;
	public Programador p;

	

	/**
	 * Create the dialog.
	 */
	public ListadoProgramadores() {
		setModal(true);
		setBounds(100, 100, 1108, 404);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
//		tablaProgramador.addMouseListener(new MouseAdapter() {
//			public void mousePressed(MouseEvent mousevt) {
//				JTable table = (JTable) mousevt.getSource();
//				Point point = mousevt.getPoint();
//			}
//			
//			
//		});
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 84, 1072, 237);
			contentPanel.add(scrollPane);
			{
				tablaProgramador = new JTable();
				model = new DefaultTableModel();
				tablaProgramador.setModel(model);
			
				TableRowSorter<TableModel> ordenaTabla = new TableRowSorter<TableModel>(model);
				tablaProgramador.setRowSorter(ordenaTabla);
				
				model.addColumn("Dni");
				model.addColumn("Nombre");
				model.addColumn("Primer apellido");
				model.addColumn("Segundo apellido");
				model.addColumn("Fecha de nacimiento");
				model.addColumn("Direcci�n");
				model.addColumn("Fecha de alta");
				model.addColumn("Oficina");
				model.addColumn("Tecnologias que domina");
				
				
				
				scrollPane.setViewportView(tablaProgramador);
				
				
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
		
		JLabel lblNewLabel = new JLabel("Listado de Programadores");
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setForeground(SystemColor.text);
				cancelButton.setBackground(SystemColor.textHighlight);
				cancelButton.setIcon(new ImageIcon("C:\\Users\\avexw\\git\\proyectojunio\\sources_img\\cancelar.png"));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
		}
	}
	public void llenartabla() throws ParseException, ExcepcionDni {
		 listado = RepositorioProgramador.listarProgramadores();
		
		for (Programador Programador : listado) {
			Object[] fila = new Object[9];
			fila[0]=Programador;
			fila[1]=Programador.getNombre();
			fila[2]=Programador.getAp1();
			fila[3]=Programador.getAp2();
			fila[4]=Programador.getFecha_nac();
			fila[5]=Programador.getDireccion().getNombre_via();
			fila[6]=Programador.getFecha_alta();
			fila[7]=Programador.getOficina().getNombre();
			fila[8]=Programador.getTecnologias();
			
			model.addRow(fila);
		}
	}

}
