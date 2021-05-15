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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.x.ConfinedInputStream;

import metodos.Metodos;
import metodos.MetodosSQL;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Cursor;

public class InterfazPro extends JFrame implements ActionListener, MouseListener, MouseMotionListener, KeyListener {
	
	boolean n,d,c,p;
	
	String id;
	float unidadesTotales, peso;
	int variable;
	int fil;
	Metodos me = new Metodos();
	MetodosSQL sql = new MetodosSQL();
	TextPrompt tp;
	private TextPrompt tp_3;
	private TextPrompt tp_2;
	private TextPrompt tp_1;
	private JPanel contentPane, panel;
	private JButton cerrar, minimizar, regresar, agregar, eliminar, modificar;
	private JLabel label;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JTextField nombre;
	private JTextArea textArea;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JTable table_rec;
	int xx,xy;
	private JTextField buscadorrec;
	private JScrollPane scrollPane_1;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JTable table_inv;
	private JTextField producto;
	private JTextField descripcion;
	private JSeparator separator_5;
	private JTextField cantidad;
	private JSeparator separator_6;
	private JTextField precio;
	private JSeparator separator_7;
	private JPanel panel_9;
	private JPanel panel_10;
	private JScrollPane scrollPane_3;
	private JPanel panel_11;
	private JTextField buscadorpro;
	private JSeparator separator_8;
	private JPanel panel_12;
	private JTextField buscadorinv;
	private JSeparator separator_9;
	private JPanel panel_13;
	private JTextField cantidadinv;
	private JSeparator separator_10;
	private JButton modificarInv;
	private JPanel panel_14;
	private JSeparator separator_11;
	private JSeparator separator_12;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTable table_pro;
	private JPanel panel_15;
	private JLabel labelId;
	private JSeparator separator_13;
	public JLabel panadero;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPro frame = new InterfazPro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public InterfazPro() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 715);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(150,150,150));
		setContentPane(contentPane);
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/pasteleria.png")).getImage());
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(41,41,41));
		panel.setBounds(0, 0, 1100, 100);
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		contentPane.setLayout(null);
		contentPane.add(panel);
		
		

		minimizar = new JButton("-");
		minimizar.setForeground(new Color(200,200,200));		
		minimizar.setFont(new Font("Arial Black", Font.BOLD, 24));
		minimizar.setFocusPainted(false);
		minimizar.setBorderPainted(false);
		minimizar.setBounds(996, 7, 43, 25);
		minimizar.setBackground(new Color(41,41,41));
		minimizar.addMouseListener(this);
		minimizar.addActionListener(this);
		panel.add(minimizar);
		
		label = new JLabel("");
		label.setBounds(10, 5, 100, 67);
		me.vLMostrarIMG(label, "/imagenes/pasteleria.png");
		panel.add(label);
		
		JLabel label2 = new JLabel("Reposteria Charlie");
		label2.setForeground(new Color(255, 255, 255));
		label2.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 52));
		label2.setBounds(120, 5, 433, 67);
		panel.add(label2);
		
		JSeparator separador = new JSeparator();
		separador.setBounds(10, 83, 1080, 6);
		panel.add(separador);
		
		cerrar = new JButton("X");
		cerrar.setFont(new Font("Arial Black", Font.BOLD, 12));
		cerrar.setForeground(new Color(200, 200, 200));
		cerrar.setFocusPainted(false);
		cerrar.setBorderPainted(false);
		cerrar.setBounds(1040, 7, 45, 25);
		cerrar.setBackground(new Color(41,41,41));
		cerrar.addActionListener(this);
		cerrar.addMouseListener(this);
		panel.add(cerrar);
		
		regresar = new JButton("\u2190");
		regresar.setBounds(954, 7, 41, 25);
		panel.add(regresar);
		regresar.setForeground(new Color(200,200,200));
		regresar.setFocusPainted(false);
		regresar.setBorder(null);
		regresar.setBackground(new Color(41,41,41));
		regresar.addActionListener(this);
		regresar.addMouseListener(this);
		regresar.setVisible(true);
		regresar.setFont(new Font("Arial Black", Font.BOLD, 22));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 111, 1080, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 832, 1080, 2);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(1088, 114, 2, 695);
		contentPane.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(10, 111, 2, 698);
		contentPane.add(separator_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(490, 209, 342, 322);
		panel_1.setBackground(new Color(200,200,200));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 122, 587, 187);
		scrollPane_1.setSize(320, 189);
		panel_1.add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setForeground(Color.BLACK);
		textArea.setEditable(false);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textArea.setLineWrap(true);
		
		nombre = new JTextField();
		nombre.setBorder(null);
		nombre.setBackground(new Color(200,200,200));
		nombre.setForeground(Color.BLACK);
		nombre.setFont(new Font("Times New Roman", Font.BOLD, 14));
		nombre.setBounds(10, 81, 320, 30);
		nombre.setEditable(false);
		panel_1.add(nombre);
		nombre.setColumns(10);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(41,41,41));
		panel_4.setBounds(10, 11, 320, 57);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Receta");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 28));
		lblNewLabel_2.setBounds(0, 0, 320, 57);
		panel_4.add(lblNewLabel_2);
		
		separator_12 = new JSeparator();
		separator_12.setForeground(Color.BLACK);
		separator_12.setBackground(Color.BLACK);
		separator_12.setBounds(10, 112, 320, 2);
		panel_1.add(separator_12);
		
		panel_2 = new JPanel();
		panel_2.setBounds(842, 209, 236, 322);
		panel_2.setBackground(new Color(200,200,200));
		contentPane.add(panel_2);
		
		scrollPane = new JScrollPane();
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(41,41,41));
		
		panel_14 = new JPanel();
		panel_14.setBackground(new Color(200,200,200));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
						.addComponent(panel_14, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(panel_14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_5.setLayout(null);
		
		lblNewLabel_3 = new JLabel("Recetas");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 28));
		lblNewLabel_3.setBounds(0, 0, 216, 56);
		panel_5.add(lblNewLabel_3);
		panel_14.setLayout(null);
		
		buscadorrec = new JTextField();
		buscadorrec.setForeground(Color.BLACK);
		buscadorrec.setBackground(new Color(200,200,200));
		buscadorrec.setFont(new Font("Times New Roman", Font.BOLD, 14));
		buscadorrec.setBounds(0, 5, 206, 30);
		tp = new TextPrompt("Buscar receta", buscadorrec);
		panel_14.add(buscadorrec);
		buscadorrec.setBorder(null);
		buscadorrec.addKeyListener(this);
		buscadorrec.setColumns(10);
		
		separator_11 = new JSeparator();
		separator_11.setBackground(Color.BLACK);
		separator_11.setForeground(Color.BLACK);
		separator_11.setBounds(0, 35, 206, 7);
		panel_14.add(separator_11);
		
		table_rec = new JTable();
		table_rec.setShowGrid(false);
		table_rec.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table_rec);
		panel_2.setLayout(gl_panel_2);
		table_rec.addMouseListener(this);		
		table_rec.getTableHeader().setBackground(new Color(41,41,41));
		table_rec.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,14));
		table_rec.getTableHeader().setForeground(new Color(255,255,255));
		table_rec.setBackground(Color.WHITE);
		table_rec.setSelectionBackground(new Color(200,200,200));
		table_rec.setFont(new Font("Times New Roman", Font.BOLD, 14));
		me.vTabla3(table_rec);
		sql.tablaReceta(table_rec, me.modelo);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(200,200,200));
		panel_3.setBounds(490, 542, 588, 281);
		contentPane.add(panel_3);
		
		panel_8 = new JPanel();
		panel_8.setBackground(new Color(41,41,41));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		panel_12 = new JPanel();
		panel_12.setBackground(new Color(200,200,200));
		
		panel_13 = new JPanel();
		panel_13.setBackground(new Color(200,200,200));
		
		modificarInv = new JButton("Modificar");
		modificarInv.setBorder(null);
		modificarInv.setForeground(new Color(255,255,255));
		modificarInv.setBackground(new Color(41,41,41));
		modificarInv.addActionListener(this);
		modificarInv.addMouseListener(this);
		modificarInv.setFocusPainted(false);
		modificarInv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		panel_15 = new JPanel();
		panel_15.setBackground(new Color(200,200,200));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(10)
							.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_12, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_15, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_13, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(modificarInv, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(11)
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(modificarInv, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_13, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel_15, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_12, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_15.setLayout(null);
		
		labelId = new JLabel("ID:");
		labelId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labelId.setBounds(0, 0, 83, 36);
		panel_15.add(labelId);
		
		separator_13 = new JSeparator();
		separator_13.setBackground(Color.BLACK);
		separator_13.setForeground(Color.BLACK);
		separator_13.setBounds(0, 30, 73, 2);
		panel_15.add(separator_13);
		panel_8.setLayout(null);
		
		lblNewLabel_5 = new JLabel("Inventario");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 28));
		lblNewLabel_5.setBounds(0, 0, 568, 57);
		panel_8.add(lblNewLabel_5);
		panel_13.setLayout(null);
		
		cantidadinv = new JTextField();
		cantidadinv.setBorder(null);
		cantidadinv.setBackground(new Color(200,200,200));
		cantidadinv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tp_1 = new TextPrompt("Cantidad a restar", cantidadinv);
		tp_1.setText("Restar en Kg/Ls");
		cantidadinv.setBounds(0, 0, 168, 30);
		panel_13.add(cantidadinv);
		cantidadinv.setEnabled(false);
		cantidadinv.setColumns(10);
		
		separator_10 = new JSeparator();
		separator_10.setBackground(Color.BLACK);
		separator_10.setForeground(Color.BLACK);
		separator_10.setBounds(0, 30, 168, 2);
		panel_13.add(separator_10);
		panel_12.setLayout(null);
		
		buscadorinv = new JTextField();
		buscadorinv.setBorder(null);
		buscadorinv.setBackground(new Color(200,200,200));
		buscadorinv.setForeground(Color.BLACK);
		buscadorinv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tp = new TextPrompt("Buscar por nombre o tipo",buscadorinv );
		buscadorinv.setBounds(0, 0, 173, 30);
		buscadorinv.addKeyListener(this);
		panel_12.add(buscadorinv);
		buscadorinv.setColumns(10);
		
		separator_9 = new JSeparator();
		separator_9.setBackground(Color.BLACK);
		separator_9.setForeground(Color.BLACK);
		separator_9.setBounds(0, 30, 173, 2);
		panel_12.add(separator_9);
		
		table_inv = new JTable();
		table_inv.setShowGrid(false);
		table_inv.setDefaultEditor(Object.class, null);
		table_inv.addMouseListener(this);
		table_inv.getTableHeader().setBackground(new Color(41,41,41));
		table_inv.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,14));
		table_inv.getTableHeader().setForeground(new Color(255,255,255));
		table_inv.setBackground(Color.WHITE);		
		table_inv.setSelectionBackground(new Color(200,200,200));				
		table_inv.setFont(new Font("Times New Roman", Font.BOLD, 14));
		table_inv.addMouseListener(this);
		scrollPane_2.setViewportView(table_inv);
		panel_3.setLayout(gl_panel_3);
		me.tablaInventario2(table_inv);
		sql.tablaInv2(table_inv, me.modelo2);
		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(200,200,200));
		panel_6.setBounds(20, 209, 460, 322);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		panel_7 = new JPanel();
		panel_7.setBackground(new Color(41,41,41));
		panel_7.setBounds(10, 11, 440, 57);
		panel_6.add(panel_7);
		panel_7.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Datos del producto");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 28));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 440, 57);
		panel_7.add(lblNewLabel_1);
		
		producto = new JTextField();
		producto.setBorder(null);
		producto.setBackground(new Color(200,200,200));
		producto.setBounds(10, 79, 440, 30);
		producto.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tp = new TextPrompt("Nombre del producto", producto); 
		producto.addKeyListener(this);
		panel_6.add(producto);
		producto.setColumns(10);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.BLACK);
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(10, 110, 440, 2);
		panel_6.add(separator_4);
		
		descripcion = new JTextField();
		descripcion.setForeground(Color.BLACK);
		descripcion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		descripcion.setBorder(null);
		descripcion.setBackground(new Color(200,200,200));
		descripcion.addKeyListener(this);
		tp = new TextPrompt("Descripcion del producto", descripcion);
		descripcion.setBounds(10, 120, 440, 30);
		panel_6.add(descripcion);
		descripcion.setColumns(10);
		
		separator_5 = new JSeparator();
		separator_5.setBackground(Color.BLACK);
		separator_5.setForeground(Color.BLACK);
		separator_5.setBounds(10, 150, 440, 2);
		panel_6.add(separator_5);
		
		cantidad = new JTextField();
		cantidad.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cantidad.setBorder(null);
		cantidad.setBounds(10, 159, 440, 30);
		cantidad.setBackground(new Color(200,200,200));
		cantidad.addKeyListener(this);
		tp = new TextPrompt("Unidades del producto", cantidad);
		panel_6.add(cantidad);
		
		cantidad.setColumns(10);
		
		separator_6 = new JSeparator();
		separator_6.setBackground(Color.BLACK);
		separator_6.setForeground(Color.BLACK);
		separator_6.setBounds(10, 189, 440, 2);
		panel_6.add(separator_6);
		
		precio = new JTextField();
		precio.setBorder(null);
		precio.setBackground(new Color(200,200,200));
		precio.setForeground(Color.BLACK);
		precio.setFont(new Font("Times New Roman", Font.BOLD, 14));
		precio.setBounds(10, 200, 440, 28);
		precio.addKeyListener(this);
		tp_2 = new TextPrompt("Precio del producto", precio);
		tp_2.setText("Precio del producto por pieza");
		panel_6.add(precio);
		precio.setColumns(10);
		
		separator_7 = new JSeparator();
		separator_7.setBackground(Color.BLACK);
		separator_7.setForeground(Color.BLACK);
		separator_7.setBounds(10, 228, 440, 2);
		panel_6.add(separator_7);
		
		agregar = new JButton("Agregar producto");
		agregar.setBackground(new Color(41,41,41));
		agregar.setForeground(Color.WHITE);
		agregar.setFocusPainted(false);
		agregar.addActionListener(this);
		agregar.addMouseListener(this);
		agregar.setBorder(null);
		agregar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		agregar.setBounds(10, 240, 440, 30);
		panel_6.add(agregar);
		
		modificar = new JButton("Modificar");
		modificar.setBackground(new Color(41,41,41));
		modificar.setForeground(Color.WHITE);
		modificar.addActionListener(this);
		modificar.addMouseListener(this);
		modificar.setFocusPainted(false);
		modificar.setBorder(null);
		modificar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		modificar.setBounds(10, 281, 210, 30);
		modificar.setEnabled(false);
		panel_6.add(modificar);
		
		eliminar = new JButton("Eliminar");
		eliminar.setBackground(new Color(41,41,41));
		eliminar.setForeground(Color.WHITE);
		eliminar.addActionListener(this);
		eliminar.addMouseListener(this);
		eliminar.setFocusPainted(false);
		eliminar.setBorder(null);
		eliminar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		eliminar.setBounds(240, 281, 210, 30);
		eliminar.setEnabled(false);
		panel_6.add(eliminar);
		
		panel_9 = new JPanel();
		panel_9.setBounds(22, 542, 458, 281);
		panel_9.setBackground(new Color(200,200,200));
		contentPane.add(panel_9);
		
		panel_10 = new JPanel();
		panel_10.setBackground(new Color(41,41,41));
		
		scrollPane_3 = new JScrollPane();
		
		panel_11 = new JPanel();
		panel_11.setBackground(new Color(200,200,200));
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_11, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
						.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
						.addComponent(panel_10, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table_pro = new JTable();
		table_pro.setShowGrid(false);
		table_pro.setDefaultEditor(Object.class, null);
		table_pro.addMouseListener(this);
		table_pro.getTableHeader().setBackground(new Color(41,41,41));
		table_pro.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,14));
		table_pro.getTableHeader().setForeground(new Color(255,255,255));
		table_pro.setBackground(Color.WHITE);
		table_pro.setSelectionBackground(new Color(200,200,200));
		table_pro.setFont(new Font("Times New Roman", Font.BOLD, 14));		
		me.tablaProductos(table_pro);
		sql.tablaProductos(table_pro, me.modelo3);
		scrollPane_3.setViewportView(table_pro);
		panel_10.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Productos");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 28));
		lblNewLabel_4.setBounds(0, 0, 438, 58);
		panel_10.add(lblNewLabel_4);
		panel_11.setLayout(null);
		
		buscadorpro = new JTextField();
		buscadorpro.setBackground(new Color(200,200,200));
		buscadorpro.setForeground(Color.BLACK);
		buscadorpro.setFont(new Font("Times New Roman", Font.BOLD, 14));
		buscadorpro.setBorder(null);
		buscadorpro.setBackground(new Color(200,200,200));
		tp_3 = new TextPrompt("Buscar por nombre", buscadorpro);
		tp_3.setText("Buscar por nombre o ID");
		buscadorpro.setBounds(0, 0, 180, 30);
		buscadorpro.addKeyListener(this);
		panel_11.add(buscadorpro);
		buscadorpro.setColumns(10);
		
		separator_8 = new JSeparator();
		separator_8.setBackground(Color.BLACK);
		separator_8.setForeground(Color.BLACK);
		separator_8.setBounds(0, 30, 180, 2);
		panel_11.add(separator_8);
		panel_9.setLayout(gl_panel_9);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(22, 124, 1056, 74);
		panel_16.setBackground(new Color(200,200,200));
		contentPane.add(panel_16);
		panel_16.setLayout(null);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(10, 11, 1036, 52);
		panel_17.setBackground(new Color(41,41,41));
		panel_16.add(panel_17);
		panel_17.setLayout(null);
		
		panadero = new JLabel("");
		panadero.setHorizontalAlignment(SwingConstants.CENTER);
		panadero.setBounds(0, 0, 1036, 48);
		panel_17.add(panadero);
		panadero.setFont(new Font("Times New Roman", Font.BOLD, 32));
		panadero.setForeground(new Color(200,200,200));
		
		setTitle("Productos");
		this.setSize(1100, 845);
		
		
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getSource() == buscadorrec) {
			sql.buscarReceta(me.modelo, buscadorrec.getText(), table_rec);
						
		}
		if(arg0.getSource() == buscadorinv) {
			sql.buscarDatos2(me.modelo2, buscadorinv.getText(), table_inv);
			
		}
		if(arg0.getSource() == buscadorpro) {
			sql.buscarProducto(me.modelo3, buscadorpro.getText(), table_pro);
		}
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		
			
		

		
	}



	
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(arg0.getSource() == cerrar) {
			cerrar.setForeground(new Color(255,255,255));
			cerrar.setBackground(new Color(255,0,0));
		}
		if(arg0.getSource() == minimizar) {
			minimizar.setForeground(new Color(255,255,255));
			minimizar.setBackground(new Color(60,60,60));
		}
		if(arg0.getSource() == regresar) {
			regresar.setForeground(new Color(255,255,255));
			regresar.setBackground(new Color(60,60,60));
			
		}
		if(arg0.getSource() == agregar) {
			agregar.setBackground(new Color(60,60,60));
			
		}
		if(arg0.getSource() == modificar) {
			modificar.setBackground(new Color(60,60,60));
			
		}
		if(arg0.getSource() == eliminar) {
			eliminar.setBackground(new Color(60,60,60));
			
		}
		if(arg0.getSource() == modificarInv) {
			modificarInv.setBackground(new Color(60,60,60));
		}
		
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		if(arg0.getSource() == cerrar) {
			cerrar.setForeground(new Color(200,200,200));
			cerrar.setBackground(new Color(41,41,41));
			
		}
		if(arg0.getSource() == minimizar) {
			minimizar.setForeground(new Color(200,200,200));
			minimizar.setBackground(new Color(41,41,41));
			
		}
		if(arg0.getSource() == regresar) {
			regresar.setForeground(new Color(200,200,200));
			regresar.setBackground(new Color(41,41,41));
			
		}
		if(arg0.getSource() == agregar) {
			agregar.setBackground(new Color(41,41,41));
			
		}
		if(arg0.getSource() == modificar) {
			modificar.setBackground(new Color(41,41,41));
			
		}
		if(arg0.getSource() == eliminar) {
			eliminar.setBackground(new Color(41,41,41));
			
		}
		if(arg0.getSource() == modificarInv) {
			modificarInv.setBackground(new Color(41,41,41));
		}
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		if(arg0.getSource() == panel) {
			xx = arg0.getX();
			xy = arg0.getY();			
		}
		if(arg0.getSource() == table_rec) {
		      
			if(arg0.getClickCount() == 2) {
			   int fila = table_rec.getSelectedRow();
		       String dato;
		        if(fila>=0){
		        	
		        	dato = table_rec.getValueAt(fila,1).toString();		        	
		        	sql.mostrarReceta(textArea, nombre, dato);		            		           		           		            		           		           		          		            		           		       
		        }
		        else{
		            JOptionPane.showMessageDialog(null,"No se ha seleccionado una fila");
		        }
			
			}else {
				int row1;
				row1=table_rec.getSelectedRow();
				table_rec.getSelectionModel().removeSelectionInterval(row1, row1);
				nombre.setText(null);
				textArea.setText(null);
				
				
			}
		}
		if(arg0.getSource() == table_inv) {
			
		if(arg0.getClickCount()==2) {
			   int fila = table_inv.getSelectedRow();
		       
		       if(fila>=0) {
		    	   
		    	   labelId.setText("ID: " + table_inv.getValueAt(fila, 0) );
		    	   unidadesTotales = Float.parseFloat(table_inv.getValueAt(fila, 4).toString());
		    	   peso = Float.parseFloat(table_inv.getValueAt(fila, 3).toString()); 
		    	   id = table_inv.getValueAt(fila, 0).toString();
		    	   cantidadinv.setEnabled(true);
		       }
			}else {
				int row1;
				row1=table_inv.getSelectedRow();
				table_inv.getSelectionModel().removeSelectionInterval(row1, row1);
				labelId.setText("ID:");
				cantidadinv.setEnabled(false);
				
			}
		       
		}
		if(arg0.getSource() == table_pro) {
			if(arg0.getClickCount() == 2) {
				int fila = table_pro.getSelectedRow();
				
				if(fila >=0) {
					producto.setText(table_pro.getValueAt(fila, 1).toString());		
					descripcion.setText(table_pro.getValueAt(fila, 2).toString());
					cantidad.setText(table_pro.getValueAt(fila, 3).toString());
					precio.setText(table_pro.getValueAt(fila, 4).toString());
					agregar.setEnabled(false);
					fil = table_pro.getSelectedRow();
					variable = Integer.parseInt(table_pro.getValueAt(fila, 0).toString());
					modificar.setEnabled(true);
					eliminar.setEnabled(true);
					
				}
				
				
				
				
			}else {
				int row1;
				row1=table_pro.getSelectedRow();
				table_pro.getSelectionModel().removeSelectionInterval(row1, row1);
				producto.setText(null);
				descripcion.setText(null);
				cantidad.setText(null);
				precio.setText(null);
			}
			
			
			
			
			
			
		}
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cerrar) {
			System.exit(0);
		}
		if(e.getSource() == minimizar) {
			this.setExtendedState(ICONIFIED);
			
		}
		if(e.getSource() == regresar) {
			InterfazPanadero in  = new InterfazPanadero();
			in.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource() == modificarInv) {
			float restar= Float.parseFloat(cantidadinv.getText());
			float total1 = unidadesTotales;
			labelId.setText("ID:");
			
			sql.modificarCantidad(restar, id, total1, peso);
			sql.tablaInv2(table_inv, me.modelo2);
			cantidadinv.setText("");
			cantidadinv.setEnabled(false);
			
		}
		if(e.getSource() == agregar) {
			
			sql.insertarProductos(producto, descripcion, cantidad, precio);
			sql.tablaProductos(table_pro, me.modelo3);
			producto.setText(null);
			descripcion.setText(null);
			cantidad.setText(null);
			precio.setText(null);
		}
		if(e.getSource() == eliminar) {
			
			sql.eliminarProductos(fil, variable);
			sql.tablaProductos(table_pro, me.modelo3);
			producto.setText(null);
			descripcion.setText(null);
			cantidad.setText(null);
			precio.setText(null);
			eliminar.setEnabled(false);
			modificar.setEnabled(false);
			agregar.setEnabled(true);
			
		}
		if(e.getSource() == modificar) {
			sql.modificarProductos(producto, descripcion, cantidad, precio, variable);
			sql.tablaProductos(table_pro, me.modelo3);
			producto.setText(null);
			descripcion.setText(null);
			cantidad.setText(null);
			precio.setText(null);
			eliminar.setEnabled(false);
			modificar.setEnabled(false);
			agregar.setEnabled(true);
		}
		
	}
}
