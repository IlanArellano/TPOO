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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import metodos.Metodos;
import metodos.MetodosSQL;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JInternalFrame;

public class InterfazVentas extends JFrame implements KeyListener, MouseListener, MouseMotionListener, ActionListener {
	
	int xx,xy, fil, cantidad1, identificacion, identificacionCliente, cantot, factura;
	float total1, precio, totalFinal, feria;
	int disponible=0;
	String nombre;
	private JPanel contentPane, panel;
	private JButton bCerrar, bRegresar, bMinimizar, agregar, borrar, pagar;	
	private TextPrompt tp_1;
	private JTable table,table_1;
	private JTextField cantidad, total, efectivo, cambio, buscador;
	private JLabel  labelId, labelProducto, labelDes, labelPrecio, labelcant;
	public JLabel labelNom;
	Metodos me = new Metodos(); 
	MetodosSQL sql = new MetodosSQL();
	TextPrompt tp;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazVentas frame = new InterfazVentas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public InterfazVentas() {
		setTitle("Ventas");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 715);
		setLocationRelativeTo(null);
		setSize(1100,700);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(150,150,150));
		setContentPane(contentPane);
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/pasteleria.png")).getImage());
		panel = new JPanel();
		panel.setBounds(0, 0, 1100, 100);
		panel.setLayout(null);
		panel.setBackground(new Color(41, 41, 41));
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		contentPane.setLayout(null);
		contentPane.add(panel);
			
		bMinimizar = new JButton("-");
		bMinimizar.setForeground(new Color(200,200,200));		
		bMinimizar.setFont(new Font("Arial Black", Font.BOLD, 24));
		bMinimizar.setFocusPainted(false);
		bMinimizar.setBorderPainted(false);
		bMinimizar.setBounds(986, 7, 43, 25);
		bMinimizar.addMouseListener(this);
		bMinimizar.addActionListener(this);
		bMinimizar.setBackground(new Color(41,41,41));
		panel.add(bMinimizar);
		
		JLabel label = new JLabel("");
		label.setBounds(35, 5, 109, 67);
		me.vLMostrarIMG(label, "/imagenes/pasteleria.png");
		panel.add(label);
		
		JLabel label2 = new JLabel("Reposteria Charlie");
		label2.setForeground(new Color(255, 255, 255));
		label2.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 52));
		label2.setBounds(160, 5, 526, 67);
		panel.add(label2);
		
		JSeparator separador = new JSeparator();
		separador.setBounds(10, 87, 1080, 2);
		panel.add(separador);
		
		bCerrar = new JButton("X");
		bCerrar.setFont(new Font("Arial Black", Font.BOLD, 12));
		bCerrar.setForeground(new Color(200, 200, 200));
		bCerrar.setFocusPainted(false);
		bCerrar.setBorderPainted(false);
		bCerrar.setBounds(1032, 7, 45, 25);
		bCerrar.addActionListener(this);
		bCerrar.setBackground(new Color(41,41,41));
		bCerrar.addMouseListener(this);
		panel.add(bCerrar);
		
		bRegresar = new JButton("Cerrar sesion");
		bRegresar.setBounds(968, 47, 109, 25);
		panel.add(bRegresar);
		bRegresar.setForeground(new Color(200,200,200));
		bRegresar.setFocusPainted(false);
		bRegresar.setBorder(null);
		bRegresar.addActionListener(this);
		bRegresar.addMouseListener(this);
		bRegresar.setFont(new Font("Arial Black", Font.BOLD, 12));	
		bRegresar.setBackground(new Color(41,41,41));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 111, 1080, 2);
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 687, 1080, 2);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(1088, 111, 2, 578);
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 111, 2, 578);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		contentPane.add(separator_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(200,200,200));
		panel_1.setBounds(20, 209, 463, 467);
		contentPane.add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(41,41,41));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(200,200,200));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(200,200,200));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_7, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
						.addComponent(panel_9, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_9.setLayout(null);
		
		buscador = new JTextField();
		buscador.setBackground(new Color(200,200,200));
		buscador.setBorder(null);
		buscador.setForeground(Color.BLACK);
		buscador.setFont(new Font("Times New Roman", Font.BOLD, 14));
		buscador.setBounds(0, 0, 253, 30);
		tp = new TextPrompt("Buscar por nombre", buscador);
		tp.setText("Buscar por nombre o ID");
		panel_9.add(buscador);
		buscador.addKeyListener(this);
		buscador.setColumns(10);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.BLACK);
		separator_6.setBackground(Color.BLACK);
		separator_6.setBounds(0, 31, 253, 2);
		panel_9.add(separator_6);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Productos");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 29));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 443, 55);
		panel_3.add(lblNewLabel);
		panel_7.setLayout(null);
		
		labelId = new JLabel("ID:");
		labelId.setForeground(Color.BLACK);
		labelId.setFont(new Font("Times New Roman", Font.BOLD, 14));		
		labelId.setBounds(10, 11, 90, 30);
		panel_7.add(labelId);
		
		labelProducto = new JLabel("Producto: ");
		labelProducto.setForeground(Color.BLACK);
		labelProducto.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labelProducto.setBounds(125, 11, 249, 30);
		panel_7.add(labelProducto);
		
		cantidad = new JTextField();
		cantidad.setBorder(null);		
		cantidad.setForeground(Color.BLACK);
		cantidad.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cantidad.setBackground(new Color(200,200,200));
		tp = new TextPrompt("Cantidad deseada", cantidad);
		cantidad.setBounds(10, 119, 120, 30);
		panel_7.add(cantidad);
		cantidad.addKeyListener(this);
		cantidad.setColumns(10);
		cantidad.setEnabled(false);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.BLACK);
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(10, 42, 90, 2);
		panel_7.add(separator_4);
		
		JSeparator separator_4_1 = new JSeparator();
		separator_4_1.setForeground(Color.BLACK);
		separator_4_1.setBackground(Color.BLACK);
		separator_4_1.setBounds(125, 42, 249, 2);
		panel_7.add(separator_4_1);
		
		JSeparator separator_4_2 = new JSeparator();
		separator_4_2.setForeground(Color.BLACK);
		separator_4_2.setBackground(Color.BLACK);
		separator_4_2.setBounds(10, 149, 120, 2);
		panel_7.add(separator_4_2);
		
		agregar = new JButton("Agregar");
		agregar.setForeground(Color.WHITE);
		agregar.setBackground(new Color(41,41,41));
		agregar.setFocusPainted(false);
		agregar.setBorder(null);
		agregar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		agregar.addActionListener(this);
		agregar.addMouseListener(this);
		agregar.setBounds(273, 93, 101, 30);
		agregar.setEnabled(false);
		panel_7.add(agregar);
		
		labelDes = new JLabel("Descripcion: ");
		labelDes.setForeground(Color.BLACK);
		labelDes.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labelDes.setBounds(10, 52, 369, 30);
		panel_7.add(labelDes);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBackground(Color.BLACK);
		separator_7.setForeground(Color.BLACK);
		separator_7.setBounds(10, 80, 364, 2);
		panel_7.add(separator_7);
		
		labelPrecio = new JLabel("Precio:");
		labelPrecio.setForeground(Color.BLACK);
		labelPrecio.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labelPrecio.setBounds(10, 83, 90, 30);
		panel_7.add(labelPrecio);
		
		labelcant = new JLabel("Disponible: ");
		labelcant.setForeground(Color.BLACK);
		labelcant.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labelcant.setBounds(126, 80, 109, 30);
		panel_7.add(labelcant);
		
		JSeparator separator_4_3 = new JSeparator();
		separator_4_3.setForeground(Color.BLACK);
		separator_4_3.setBackground(Color.BLACK);
		separator_4_3.setBounds(10, 111, 90, 2);
		panel_7.add(separator_4_3);
		
		JSeparator separator_4_4 = new JSeparator();
		separator_4_4.setForeground(Color.BLACK);
		separator_4_4.setBackground(Color.BLACK);
		separator_4_4.setBounds(125, 111, 110, 2);
		panel_7.add(separator_4_4);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setBackground(new Color(41,41,41));
		table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,14));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setBackground(Color.WHITE);
		table.setSelectionBackground(new Color(200,200,200));
		table.addMouseListener(this);
		table.addKeyListener(this);
		me.tablaProductos(table);
		sql.tablaProductosIf(table, me.modelo3);
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(493, 209, 585, 467);
		panel_2.setBackground(new Color(200,200,200));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 11, 575, 55);
		panel_4.setBackground(new Color(41,41,41));
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Factura");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 29));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(10, 0, 555, 55);
		panel_4.add(lblNewLabel_4);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 77, 565, 201);
		panel_2.add(panel_8);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
		);
		
		table_1 = new JTable();
		table_1.setShowGrid(false);
		table_1.setDefaultEditor(Object.class, null);
		table_1.getTableHeader().setBackground(new Color(41,41,41));
		table_1.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,14));
		table_1.getTableHeader().setForeground(new Color(255,255,255));
		table_1.setBackground(Color.WHITE);
		table_1.setSelectionBackground(new Color(200,200,200));
		table_1.addMouseListener(this);
		table_1.addKeyListener(this);
		table_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		me.tablaVenta(table_1);
		scrollPane_1.setViewportView(table_1);
		panel_8.setLayout(gl_panel_8);
		
		borrar = new JButton("Borrar producto");
		borrar.setBounds(10, 289, 131, 30);
		borrar.setForeground(Color.WHITE);
		borrar.setFocusPainted(false);
		borrar.setBackground(new Color(41,41,41));
		borrar.addActionListener(this);
		borrar.addMouseListener(this);
		borrar.setBorder(null);
		borrar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		borrar.setEnabled(false);
		panel_2.add(borrar);
		
		total = new JTextField();
		total.setText("0.00");
		total.setBounds(409, 290, 150, 30);
		total.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		total.setForeground(Color.BLACK);
		total.setFont(new Font("Times New Roman", Font.BOLD, 14));
		total.setEditable(false);
		panel_2.add(total);
		total.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Total:");
		lblNewLabel_1.setBounds(331, 289, 68, 30);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Efectivo:");
		lblNewLabel_2.setBounds(331, 330, 57, 30);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(lblNewLabel_2);
		
		efectivo = new JTextField();
		efectivo.setBounds(409, 331, 150, 30);
		efectivo.setBorder(null);
		efectivo.setForeground(Color.BLACK);
		efectivo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		efectivo.setBackground(new Color(200,200,200));
		tp_1 = new TextPrompt("Efectivo", efectivo);
		tp_1.setBorder(null);
		efectivo.setEnabled(false);
		efectivo.addKeyListener(this);
		panel_2.add(efectivo);
		efectivo.setColumns(10);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(409, 362, 150, 2);
		separator_5.setBackground(Color.BLACK);
		separator_5.setForeground(Color.BLACK);
		panel_2.add(separator_5);
		
		JLabel lblNewLabel_3 = new JLabel("Cambio:");
		lblNewLabel_3.setBounds(331, 371, 68, 30);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(lblNewLabel_3);
		
		cambio = new JTextField();
		cambio.setBounds(409, 372, 150, 30);
		cambio.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cambio.setForeground(Color.BLACK);
		cambio.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cambio.setEditable(false);
		panel_2.add(cambio);
		cambio.setColumns(10);
		
		pagar = new JButton("Generar venta");
		pagar.setFocusPainted(false);
		pagar.setBorder(null);
		pagar.setForeground(Color.WHITE);
		pagar.setBackground(new Color(41,41,41));
		pagar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pagar.setBounds(331, 426, 228, 30);
		pagar.addActionListener(this);
		pagar.addMouseListener(this);
		pagar.setEnabled(false);
		panel_2.add(pagar);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(200,200,200));
		panel_5.setBounds(22, 124, 1050, 74);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(41,41,41));
		panel_6.setBounds(10, 11, 1030, 52);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		labelNom = new JLabel("");
		labelNom.setHorizontalAlignment(SwingConstants.CENTER);
		labelNom.setFont(new Font("Times New Roman", Font.BOLD, 29));
		labelNom.setForeground(new Color(200,200,200));
		labelNom.setBounds(10, 0, 1010, 52);
		panel_6.add(labelNom);
	
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
	public void keyPressed(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getSource() == cantidad) {
			
			char validar = arg0.getKeyChar();
			if(Character.isLetter(validar)) {
				getToolkit().beep();
				arg0.consume();								
				
			}else {
				int cantidadL;
				if(cantidad.getText().equals("")) {
					
					cantidadL = 0;
					
				}else {
					cantidadL = Integer.parseInt(cantidad.getText());					
					if(cantidadL>disponible) {
						cantidad.setForeground(new Color(150,0,0));	
						agregar.setEnabled(false);
					}
									
					else if(cantidadL<=disponible) {
						agregar.setEnabled(true);
						cantidad.setForeground(new Color(0,150,0));	
											
					}											
					cantidad1 = cantidadL;
					total1 = (cantidad1) * precio;
			}
			}
			

			
			
		}
		if(arg0.getSource() == buscador) {
			
			sql.buscarProducto(me.modelo3,buscador.getText(), table);
			
		}
		
		if(arg0.getSource() == efectivo) {
			
			char validar = arg0.getKeyChar();
			if(Character.isLetter(validar)) {
				getToolkit().beep();
				arg0.consume();
				
				
				
			}else {
				float efectivoL;
				if(efectivo.getText().equals("")) {
					
					efectivoL = 0;
					
				}else {
					efectivoL = Float.parseFloat(efectivo.getText());					
					if(efectivoL<totalFinal) {
						efectivo.setForeground(new Color(150,0,0));	
						pagar.setEnabled(false);
						cambio.setText("0.00");
					}
									
					else if(efectivoL>=totalFinal) {
						efectivo.setForeground(new Color(0,150,0));	
						feria =efectivoL - totalFinal ;
						cambio.setText(String.valueOf(feria));
						pagar.setEnabled(true);
					}
					
	
					

			}
			}
			

			
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		if(arg0.getSource() == cantidad) {
			char validar = arg0.getKeyChar();
			if(Character.isLetter(validar) ) {
				getToolkit().beep();
				arg0.consume();
				
				
				
			}
			
			

		}

		if(arg0.getSource() == efectivo) {
			char validar = arg0.getKeyChar();
			if(Character.isLetter(validar) ) {
				getToolkit().beep();
				arg0.consume();
				
				
				
			}
			
			

		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(arg0.getSource() == bCerrar) {
			bCerrar.setForeground(new Color(255,255,255));
			bCerrar.setBackground(new Color(255,0,0));
		}
		if(arg0.getSource() == bMinimizar) {
			bMinimizar.setForeground(new Color(255,255,255));
			bMinimizar.setBackground(new Color(60,60,60));
		}
		if(arg0.getSource() == bRegresar) {
			bRegresar.setForeground(new Color(255,255,255));
			bRegresar.setBackground(new Color(60,60,60));
		}
		if(arg0.getSource() == agregar) {
			
			agregar.setBackground(new Color(60,60,60));
		}
		if(arg0.getSource() == borrar) {
			borrar.setBackground(new Color(60,60,60));
			
		}
		if(arg0.getSource() == pagar) {
			pagar.setBackground(new Color(60,60,60));
		}
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if(arg0.getSource() == bRegresar) {
			bRegresar.setForeground(new Color(200,200,200));
			bRegresar.setBackground(new Color(41,41,41));
		}
		if(arg0.getSource() == bCerrar) {
			bCerrar.setForeground(new Color(200,200,200));
			bCerrar.setBackground(new Color(41,41,41));
		}
		if(arg0.getSource() == bMinimizar) {
			bMinimizar.setForeground(new Color(200,200,200));
			bMinimizar.setBackground(new Color(41,41,41));
		}
		if(arg0.getSource() == agregar) {
			agregar.setBackground(new Color(41,41,41));
		}
		if(arg0.getSource() == borrar) {
			borrar.setBackground(new Color(41,41,41));
			
		}
		if(arg0.getSource() == pagar) {
			pagar.setBackground(new Color(41,41,41));
		}
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(arg0.getSource() == panel) {
			xx = arg0.getX();
			xy = arg0.getY();			
		}
		if(arg0.getSource() == table) {
			
			if(arg0.getClickCount() == 2) {
				int fila=table.getSelectedRow();	
					if(fila >=0) {
						fil = table.getSelectedRow();
						labelId.setText("ID: "+table.getValueAt(fila, 0).toString());
						labelProducto.setText("Producto:" + table.getValueAt(fila, 1));
						labelDes.setText("Descripcion: " + table.getValueAt(fila, 2));
						labelcant.setText("Disponible: " + table.getValueAt(fila, 3) );
						labelPrecio.setText("Precio: " + table.getValueAt(fila, 4 ) + " $");
						precio = Float.parseFloat(table.getValueAt(fila, 4).toString());
						disponible = Integer.parseInt(table.getValueAt(fila, 3).toString());
						cantidad.setEnabled(true);
						//agregar.setEnabled(true);
					}																		
			}else {
				int row1;
				row1=table.getSelectedRow();
				table.getSelectionModel().removeSelectionInterval(row1, row1);
				labelId.setText("ID:");
				labelProducto.setText("Producto");
				labelDes.setText("Descripcion: ");
				labelcant.setText("Disponible:" );
				labelPrecio.setText("Precio: ");
				cantidad.setText(null);
				disponible =0;
				cantidad.setEnabled(false);
				agregar.setEnabled(false);
				
			}
						
			
		}
		
		if(arg0.getSource() == table_1) {
			borrar.setEnabled(true);
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

		
	}
	int contador = 0;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == bCerrar) {
			if(table_1.getRowCount() >0) {
				for(int e=0;e<table_1.getRowCount();e++) {
					sql.actualizarProductos(me.cantTot(table_1, table,e), Integer.parseInt(table_1.getValueAt(e, 2).toString()), Integer.parseInt(table_1.getValueAt(e,0 ).toString()),false);
				}
			}
			
			System.exit(0);
			
		}
		if(arg0.getSource() == bRegresar) {
			if(table_1.getRowCount() >0) {
				for(int e=0;e<table_1.getRowCount();e++) {
					sql.actualizarProductos(me.cantTot(table_1, table,e), Integer.parseInt(table_1.getValueAt(e, 2).toString()), Integer.parseInt(table_1.getValueAt(e,0 ).toString()),false);
				}
			}
			InterfazLogin in =new InterfazLogin();
			in.setVisible(true);
			this.setVisible(false);
			
		}
		if(arg0.getSource() == bMinimizar) {
			this.setExtendedState(ICONIFIED);
			
		}
		if(arg0.getSource() == agregar) {
			boolean estatus=true;
			int i = table.getSelectedRow();
			
			me.agregrarVenta(table_1, table, fil, cantidad1, total1, me.modelo);
			
			cantot = Integer.parseInt(table.getValueAt(i, 3).toString());
			total.setText(String.valueOf(me.calcularTotal(table_1)));
			totalFinal = me.calcularTotal(table_1);
			agregar.setEnabled(false);
			labelId.setText("ID:");
			labelProducto.setText("Producto");
			labelDes.setText("Descripcion: ");
			labelcant.setText("Disponible:" );
			labelPrecio.setText("Precio: ");
			
			efectivo.setEnabled(true);
			contador++;
			if(contador>1) {
				
				if(efectivo.getText().isEmpty()) {
					
				}				
				else {
				if(Float.parseFloat(efectivo.getText()) < totalFinal) {
				efectivo.setForeground(new Color(150,0,0));	
				pagar.setEnabled(false);
				cambio.setText("0.00");
				}else if(Float.parseFloat(efectivo.getText()) >= totalFinal) {
				efectivo.setForeground(new Color(0,150,0));	
				feria =Float.parseFloat(efectivo.getText()) - totalFinal ;
				cambio.setText(String.valueOf(feria));
				pagar.setEnabled(true);
				}

				
			}
				
			}
			sql.actualizarProductos(cantot, Integer.parseInt(cantidad.getText()), Integer.parseInt(table.getValueAt(i,0 ).toString()),estatus);
			sql.tablaProductosIf(table, me.modelo3);
			cantidad.setEnabled(false);
			cantidad.setText(null);
			
		}
		if(arg0.getSource() == borrar) {
			boolean estatus = false;
			int i = table_1.getSelectedRow();
			sql.actualizarProductos(me.seleccionarFila(table_1, table), Integer.parseInt(table_1.getValueAt(i, 2).toString()), Integer.parseInt(table_1.getValueAt(i,0 ).toString()),estatus);
			sql.tablaProductosIf(table, me.modelo3);
			DefaultTableModel mod = (DefaultTableModel)table_1.getModel();			
			mod.removeRow(table_1.getSelectedRow());
			total.setText(String.valueOf(me.calcularTotal(table_1)));
			borrar.setEnabled(false);
			totalFinal = me.calcularTotal(table_1);
			if(efectivo.getText().isEmpty()) {
								
			}else {
				if(Float.parseFloat(efectivo.getText()) < totalFinal) {
				efectivo.setForeground(new Color(150,0,0));	
				pagar.setEnabled(false);
				cambio.setText("0.00");
			}else if(cambio.getText() != "0.00") {
				
				if(Float.parseFloat(efectivo.getText()) >= totalFinal) {
				efectivo.setForeground(new Color(0,150,0));	
				feria =Float.parseFloat(efectivo.getText()) - totalFinal ;
				cambio.setText(String.valueOf(feria));
				pagar.setEnabled(true);
					
				}

				
			}
				
			}

			cantidad.setEnabled(false);
			
			
		}
	
		if(arg0.getSource() == pagar) {
			identificacionCliente = sql.insertarCliente(identificacion);
			java.util.Date date = new java.util.Date();		

			Timestamp tiempo = new Timestamp(date.getTime());
			
			
			
			int fila = table_1.getRowCount();
			for(int i=0;i<fila;i++)	{
		/*///*/		sql.insertarDetalle(table_1, identificacionCliente, Integer.parseInt(table_1.getValueAt(i, 0).toString()),table_1.getValueAt(i, 1).toString(), Integer.parseInt(table_1.getValueAt(i, 2).toString()), Float.parseFloat(table_1.getValueAt(i, 3).toString()), Float.parseFloat(table_1.getValueAt(i, 4).toString()));
				
			}
			factura = sql.insertarFactura(identificacionCliente, identificacion, totalFinal, Float.parseFloat(efectivo.getText()), Float.parseFloat(cambio.getText()), tiempo);
			sql.tablaProductosIf(table, me.modelo3);
			JOptionPane.showMessageDialog(null, "Venta generada");		
			
			sql.Jasper(String.valueOf(identificacionCliente), total.getText(), efectivo.getText(), cambio.getText(), String.valueOf(factura),nombre ,tiempo);
			DefaultTableModel mod = (DefaultTableModel)table_1.getModel();
			mod.setRowCount(0);
			
			total.setText(null);
			efectivo.setText(null);
			cambio.setText(null);
			pagar.setEnabled(false);
			
		}

	}
}
