package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import metodos.Metodos;
import metodos.MetodosSQL;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Cursor;

public class InterfazEmp extends JFrame implements ActionListener, MouseListener, MouseMotionListener, KeyListener {

	private JPanel contentPane, panel;
	private JButton bMinimizar, bRegresar, bCerrar, bAgregar, bModificar,mostrar,bBorrar;
	private JComboBox cbPuesto;
	private JLabel label,label1, label2;
	int xx,xy;
	String variable;
	int fil;
	int contador;
	MetodosSQL sql = new MetodosSQL();
	Metodos me = new Metodos(); 
	TextPrompt tp ;
	private JTextField tfNombre;
	private JTextField tfCurp;
	private JTextField tfRfc;
	private JTextField tfDireccion;
	private JTextField tfTelefono;
	private JTable table;
	private JTextField tfBuscador;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JTextField tfEdad;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazEmp frame = new InterfazEmp();
					frame.setVisible(true);
				

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public InterfazEmp() {
		setUndecorated(true);
		setTitle("Empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(150, 150, 150));
		contentPane.addMouseListener(this);
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/pasteleria.png")).getImage());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(1132,650);
		setLocationRelativeTo(null);
		
		contentPane.setLayout(null);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(41, 41, 41));
		panel.setBounds(0, 0, 1132, 100);
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		contentPane.add(panel);
			
		bMinimizar = new JButton("-");
		bMinimizar.setForeground(new Color(200,200,200));		
		bMinimizar.setFont(new Font("Arial Black", Font.BOLD, 24));
		bMinimizar.setFocusPainted(false);
		bMinimizar.setBorderPainted(false);
		bMinimizar.setBounds(1035, 7, 43, 25);
		bMinimizar.addMouseListener(this);
		bMinimizar.addActionListener(this);
		bMinimizar.setBackground(new Color(41,41,41));
		panel.add(bMinimizar);
		
		label = new JLabel("");
		label.setBounds(10, 5, 100, 67);
		me.vLMostrarIMG(label, "/imagenes/pasteleria.png");
		panel.add(label);
		
		JLabel label2 = new JLabel("Reposteria Charlie");
		label2.setForeground(new Color(255, 255, 255));
		label2.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 52));
		label2.setBounds(120, 5, 526, 67);
		panel.add(label2);
		
		JSeparator separador = new JSeparator();
		separador.setBounds(10, 87, 1112, 2);
		panel.add(separador);
		
		bCerrar = new JButton("X");
		bCerrar.setFont(new Font("Arial Black", Font.BOLD, 12));
		bCerrar.setForeground(new Color(200, 200, 200));
		bCerrar.setFocusPainted(false);
		bCerrar.setBorderPainted(false);
		bCerrar.setBounds(1080, 7, 45, 25);
		bCerrar.addActionListener(this);
		bCerrar.setBackground(new Color(41,41,41));
		bCerrar.addMouseListener(this);
		panel.add(bCerrar);
		
		bRegresar = new JButton("\u2190");
		bRegresar.setBounds(991, 7, 41, 25);
		panel.add(bRegresar);
		bRegresar.setForeground(new Color(200,200,200));
		bRegresar.setFocusPainted(false);
		bRegresar.setBorder(null);
		bRegresar.addActionListener(this);
		bRegresar.addMouseListener(this);
		bRegresar.setFont(new Font("Arial Black", Font.BOLD, 22));
		bRegresar.setBackground(new Color(41,41,41));
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 111, 1112, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 637, 1112, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(1120, 111, 2, 528);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(10, 111, 2, 528);
		contentPane.add(separator_3);
		
		JPanel pPanel2 = new JPanel();
		pPanel2.setBounds(20, 124, 349, 502);
		pPanel2.setBackground(new Color(200,200,200));
		contentPane.add(pPanel2);
		pPanel2.setLayout(null);
		
		JPanel pPanel4 = new JPanel();
		pPanel4.setBounds(10, 11, 329, 50);
		pPanel2.add(pPanel4);
		pPanel4.setLayout(null);	
		pPanel4.setBackground(new Color(41,41,41));
		
		JLabel lblNewLabel = new JLabel("Datos empleado");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 28));
		lblNewLabel.setBounds(0, 0, 329, 46);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		pPanel4.add(lblNewLabel);
		
		mostrar = new JButton("");
		mostrar.setBounds(303, 23, 16, 16);
		pPanel4.add(mostrar);
		mostrar.setFocusPainted(false);
		mostrar.setContentAreaFilled(false);
		mostrar.setBorder(null);
		mostrar.setSize(16,16);
		mostrar.addActionListener(this);
		mostrar.addMouseListener(this);
		
		tfNombre = new JTextField();
		tfNombre.setBorder(null);
		tfNombre.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tfNombre.setBounds(10, 72, 329, 28);
		tp = new TextPrompt("Nombre del empleado", tfNombre);
		tfNombre.setBackground(new Color(200,200,200));				
		pPanel2.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfCurp = new JTextField();
		tfCurp.setBorder(null);
		tfCurp.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tfCurp.setBounds(10, 195, 329, 28);
		tp = new TextPrompt("CURP del empleado", tfCurp);
		tfCurp.setBackground(new Color(200,200,200));		
		pPanel2.add(tfCurp);
		tfCurp.setColumns(10);
		
		tfRfc = new JTextField();
		tfRfc.setBorder(null);
		tfRfc.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tfRfc.setBounds(10, 241, 329, 28);
		tfRfc.setBackground(new Color(200,200,200));
		tp = new TextPrompt("RFC del empleado", tfRfc);		
		pPanel2.add(tfRfc);
		tfRfc.setColumns(10);
		
		cbPuesto = new JComboBox();
		cbPuesto.setModel(new DefaultComboBoxModel(new String[] {"Panadero", "Cajero", "Administrador"}));
		cbPuesto.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cbPuesto.setBounds(10, 146, 329, 28);
		cbPuesto.setBackground(new Color(230,230,230));
		
		pPanel2.add(cbPuesto);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(10, 270, 329, 2);
		pPanel2.add(separator_4);
		
		JSeparator separator_4_1 = new JSeparator();
		separator_4_1.setForeground(Color.BLACK);
		separator_4_1.setBackground(Color.BLACK);
		separator_4_1.setBounds(10, 223, 329, 2);
		pPanel2.add(separator_4_1);
		
		JSeparator separator_4_2 = new JSeparator();
		separator_4_2.setForeground(Color.BLACK);
		separator_4_2.setBackground(Color.BLACK);
		separator_4_2.setBounds(10, 175, 329, 2);
		pPanel2.add(separator_4_2);
		
		JSeparator separator_4_3 = new JSeparator();
		separator_4_3.setForeground(Color.BLACK);
		separator_4_3.setBackground(Color.BLACK);
		separator_4_3.setBounds(10, 100, 329, 2);
		pPanel2.add(separator_4_3);
		
		tfDireccion = new JTextField();
		tfDireccion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tfDireccion.setBorder(null);
		tp = new TextPrompt("Direccion del empleado", tfDireccion);
		tfDireccion.setBounds(10, 295, 329, 28);
		tfDireccion.setBackground(new Color(200,200,200));
		pPanel2.add(tfDireccion);
		tfDireccion.setColumns(10);
		
		JSeparator separator_4_2_1 = new JSeparator();
		separator_4_2_1.setForeground(Color.BLACK);
		separator_4_2_1.setBackground(Color.BLACK);
		separator_4_2_1.setBounds(10, 323, 329, 2);
		pPanel2.add(separator_4_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("  Puesto");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 111, 141, 24);
		pPanel2.add(lblNewLabel_2);
		
		tfTelefono = new JTextField();
		tfTelefono.setBorder(null);
		tfTelefono.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tfTelefono.setBounds(10, 345, 150, 28);
		tfTelefono.addKeyListener(this);
		tfTelefono.setBackground(new Color(200,200,200));
		tp = new TextPrompt("Telefono del empleado", tfTelefono);
		pPanel2.add(tfTelefono);
		tfTelefono.setColumns(10);
		
		JSeparator separator_4_1_1 = new JSeparator();
		separator_4_1_1.setForeground(Color.BLACK);
		separator_4_1_1.setBackground(Color.BLACK);
		separator_4_1_1.setBounds(10, 373, 150, 2);
		pPanel2.add(separator_4_1_1);
		
		bAgregar = new JButton("Registrar registro");
		bAgregar.setBorder(null);
		bAgregar.setFocusPainted(false);
		bAgregar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		bAgregar.setBounds(10, 390, 329, 30);
		bAgregar.setBackground(new Color(41,41,41));
		bAgregar.setForeground(new Color(255,255,255));
		bAgregar.addActionListener(this);
		bAgregar.addMouseListener(this);
		pPanel2.add(bAgregar);
		
		bModificar = new JButton("Modificar registro");
		bModificar.setBorder(null);
		bModificar.setFocusPainted(false);
		bModificar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		bModificar.setBounds(10, 425, 329, 30);
		bModificar.setBackground(new Color(41,41,41));
		bModificar.setForeground(new Color(255,255,255));
		bModificar.addActionListener(this);
		bModificar.addMouseListener(this);
		bModificar.setEnabled(false);
		pPanel2.add(bModificar);
		
		tfEdad = new JTextField();
		tfEdad.setBorder(null);
		tfEdad.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tfEdad.setBackground(new Color(200,200,200));
		tfEdad.setBounds(189, 345, 150, 28);
		tp = new TextPrompt("Edad del empleado", tfEdad);
		pPanel2.add(tfEdad);
		tfEdad.setColumns(10);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.BLACK);
		separator_6.setBackground(Color.BLACK);
		separator_6.setBounds(189, 373, 150, 2);
		pPanel2.add(separator_6);
		
		bBorrar = new JButton("Dar de baja");
		bBorrar.setForeground(Color.WHITE);
		bBorrar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		bBorrar.setFocusPainted(false);
		bBorrar.setBorder(null);
		bBorrar.setBackground(new Color(41,41,41));
		bBorrar.setBounds(10, 460, 329, 30);
		bBorrar.addActionListener(this);
		bBorrar.addMouseListener(this);
		bBorrar.setEnabled(false);
		pPanel2.add(bBorrar);
		
		JPanel pPanel3 = new JPanel();
		pPanel3.setBounds(379, 124, 731, 502);
		pPanel3.setBackground(new Color(200,200,200));
		contentPane.add(pPanel3);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(200,200,200));
		//me.vBMostrarIMG(mostrar, "/imagenes/ojo.png");
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(41,41,41));
		
		GroupLayout gl_pPanel3 = new GroupLayout(pPanel3);
		gl_pPanel3.setHorizontalGroup(
			gl_pPanel3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pPanel3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pPanel3.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE))
					.addGap(18))
		);
		gl_pPanel3.setVerticalGroup(
			gl_pPanel3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pPanel3.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Empleados");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(0, 0, 671, 52);
		panel_2.add(lblNewLabel_1);
		panel_1.setLayout(null);
		
		tfBuscador = new JTextField();
		tfBuscador.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tfBuscador.setBorder(null);
		tfBuscador.setBounds(0, 0, 264, 33);
		tp = new TextPrompt("Buscar por nombre", tfBuscador);
		panel_1.add(tfBuscador);
		tfBuscador.setColumns(10);
		tfBuscador.setBackground(new Color(200,200,200));
		tfBuscador.addKeyListener(this);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBackground(Color.BLACK);
		separator_5.setForeground(Color.BLACK);
		separator_5.setBounds(0, 33, 264, 2);
		panel_1.add(separator_5);
		
		table = new JTable();		
		table.setShowGrid(false);
		table.addKeyListener(this);
		table.setDefaultEditor(Object.class, null);
		me.vTabla2(table);
		scrollPane.setViewportView(table);
		table.getTableHeader().setBackground(new Color(41,41,41));
		table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,14));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setBackground(Color.WHITE);
		table.setSelectionBackground(new Color(200,200,200));
		table.addMouseListener(this);
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pPanel3.setLayout(gl_pPanel3);

		sql.tablaEmpleados(table, me.modelo);
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		if(arg0.getSource() == panel) {
		int x= arg0.getXOnScreen();
		int y = arg0.getYOnScreen();
		
		this.setLocation(x-xx, y-xy);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		/*if(e.getSource() == table) {
			int fila = table.getSelectedRow();
		       
	        if(fila>=0){
	            tfNombre.setText(table.getValueAt(fila,1).toString());
	            cbPuesto.setSelectedItem(table.getValueAt(fila,2));
	            tfCurp.setText(table.getValueAt(fila,3).toString());
	            tfRfc.setText(table.getValueAt(fila,4).toString());
	            tfDireccion.setText(table.getValueAt(fila,5).toString());
	            tfTelefono.setText(table.getValueAt(fila,6).toString());
	            tfEdad.setText(table.getValueAt(fila, 7).toString());
	            
	            bBorrar.setEnabled(true);
	            bModificar.setEnabled(true);
	            bAgregar.setEnabled(false);
	            fil = table.getSelectedRow();
	            variable=table.getValueAt(fila, 0).toString();
	            //System.out.println(variable);
	            
	        }
	        else{
	            JOptionPane.showMessageDialog(null,"No se ha seleccionado una fila");
	        }
		
			
		}*/
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == bCerrar) {
			bCerrar.setForeground(new Color(255,255,255));
			bCerrar.setBackground(new Color(255,0,0));
		}
		if(e.getSource() == bMinimizar) {
			bMinimizar.setForeground(new Color(255,255,255));
			bMinimizar.setBackground(new Color(60,60,60));
		}
		if(e.getSource() == bRegresar) {
			bRegresar.setForeground(new Color(255,255,255));
			bRegresar.setBackground(new Color(60,60,60));
		}
		if(e.getSource() == bAgregar) {
			bAgregar.setBackground(new Color(60,60,60));
		}
		if(e.getSource() == bModificar) {
			bModificar.setBackground(new Color(60,60,60));
		}
		if(e.getSource() == mostrar) {
			
			mostrar.setSize(24,24);
			me.vBMostrarIMG(mostrar, "/imagenes/ojo.png");
			
		}
		if(e.getSource() == bBorrar) {
			bBorrar.setBackground(new Color(60,60,60));			
			
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == bRegresar) {
			bRegresar.setForeground(new Color(200,200,200));
			bRegresar.setBackground(new Color(41,41,41));
		}
		if(e.getSource() == bCerrar) {
			bCerrar.setForeground(new Color(200,200,200));
			bCerrar.setBackground(new Color(41,41,41));
		}
		if(e.getSource() == bMinimizar) {
			bMinimizar.setForeground(new Color(200,200,200));
			bMinimizar.setBackground(new Color(41,41,41));
		}
		if(e.getSource() == bAgregar) {
			bAgregar.setBackground(new Color(41,41,41));
		}
		if(e.getSource() == bModificar) {
			bModificar.setBackground(new Color(41,41,41));
		}
		if(e.getSource() == mostrar) {
			
			mostrar.setSize(16,16);
			me.vBMostrarIMG(mostrar, "/imagenes/ojo.png");
			
		}
		if(e.getSource() == bBorrar) {
			bBorrar.setBackground(new Color(41,41,41));
			
			
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == panel) {
			xx = e.getX();
			xy = e.getY();			
		}
		
		if(e.getSource() == table) {
			
			if(e.getClickCount() == 2) {
			int fila = table.getSelectedRow();
		       
	        if(fila>=0){
	            tfNombre.setText(table.getValueAt(fila,1).toString());
	            cbPuesto.setSelectedItem(table.getValueAt(fila,2));
	            tfCurp.setText(table.getValueAt(fila,3).toString());
	            tfRfc.setText(table.getValueAt(fila,4).toString());
	            tfDireccion.setText(table.getValueAt(fila,5).toString());
	            tfTelefono.setText(table.getValueAt(fila,6).toString());
	            tfEdad.setText(table.getValueAt(fila, 7).toString());
	            
	            bBorrar.setEnabled(true);
	            bModificar.setEnabled(true);
	            bAgregar.setEnabled(false);
	            fil = table.getSelectedRow();
	            variable=table.getValueAt(fila, 0).toString();
	            //System.out.println(variable);
	            
	        }
	        else{
	            JOptionPane.showMessageDialog(null,"No se ha seleccionado una fila");
	        }
		
			
		}else {
			int row=table.getSelectedRow();
			table.getSelectionModel().removeSelectionInterval(row, row);
			tfNombre.setText(null);
			tfDireccion.setText(null);
			tfCurp.setText(null);
			tfRfc.setText(null);
			tfTelefono.setText(null);
			tfEdad.setText(null);
			bAgregar.setEnabled(true);
			bBorrar.setEnabled(false);
			bModificar.setEnabled(false);
			
			
		}
		}
		if(e.getSource() == contentPane) {
			/*int row=table.getSelectedRow();
			table.getSelectionModel().removeSelectionInterval(row, row);
			tfNombre.setText(null);
			tfDireccion.setText(null);
			tfCurp.setText(null);
			tfRfc.setText(null);
			tfTelefono.setText(null);
			tfEdad.setText(null);
			bAgregar.setEnabled(true);
			bBorrar.setEnabled(false);
			bModificar.setEnabled(false);	*/					
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bRegresar) {
			InterfazAdministrador in1 = new InterfazAdministrador();
			in1.setVisible(true);
			this.setVisible(false);
			
		}

		if(e.getSource() == bMinimizar) {
			this.setExtendedState(ICONIFIED);
			

		}
		
		if(e.getSource() == bCerrar) {
			
			System.exit(0);
		}
		
		if(e.getSource() == bAgregar) {
			
			sql.insertarEmpleados(tfNombre, cbPuesto, tfCurp, tfRfc, tfDireccion, tfTelefono, tfEdad);
			sql.tablaEmpleados(table, me.modelo);
			tfNombre.setText(null);
			tfDireccion.setText(null);
			tfCurp.setText(null);
			tfRfc.setText(null);
			tfTelefono.setText(null);
			tfEdad.setText(null);
			contador = 1;



			
		}
		
		if(e.getSource() == mostrar) {
			
			//mostrar.setEnabled(false);
		}
		if(e.getSource() == bModificar) {
			
			sql.modificarEmpleados(tfNombre, cbPuesto, tfCurp, tfRfc, tfDireccion, tfTelefono, tfEdad,variable);
			tfNombre.setText(null);
			tfNombre.setText(null);
			tfDireccion.setText(null);
			tfCurp.setText(null);
			tfRfc.setText(null);
			tfTelefono.setText(null);
			tfEdad.setText(null);
			bModificar.setEnabled(false);
			bAgregar.setEnabled(true);
			bBorrar.setEnabled(false);
			sql.tablaEmpleados(table, me.modelo);
		}
		
		if(e.getSource() == bBorrar) {
			
			sql.borrarEmpleados(fil, variable);
			sql.tablaEmpleados(table, me.modelo);
			tfNombre.setText(null);
			tfDireccion.setText(null);
			tfCurp.setText(null);
			tfRfc.setText(null);
			tfTelefono.setText(null);
			tfEdad.setText(null);
			bBorrar.setEnabled(false);
			bModificar.setEnabled(false);
			bAgregar.setEnabled(true);
			
		}
		
	}


	@Override
	public void keyPressed(KeyEvent arg0) {

		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {

		if(arg0.getSource() == tfBuscador)
			sql.buscarEmpleados(me.modelo, tfBuscador.getText(), table);
		
		if(arg0.getSource() == table) {
			int fila = table.getSelectedRow();
		       
	        if(fila>=0){
	            tfNombre.setText(table.getValueAt(fila,1).toString());
	            cbPuesto.setSelectedItem(table.getValueAt(fila,2));
	            tfCurp.setText(table.getValueAt(fila,3).toString());
	            tfRfc.setText(table.getValueAt(fila,4).toString());
	            tfDireccion.setText(table.getValueAt(fila,5).toString());
	            tfTelefono.setText(table.getValueAt(fila,6).toString());
	            
	            bBorrar.setEnabled(true);
	            bModificar.setEnabled(true);
	            variable=table.getValueAt(fila, 0).toString();
	            System.out.println(variable);
	            
	        }
	        else{
	            JOptionPane.showMessageDialog(null,"No se ha seleccionado una fila");
	        }
		
			
		}
		
		
		
		
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {

		
		
		
		
	}
}
