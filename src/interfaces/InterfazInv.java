package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metodos.ConexionSQL;
import metodos.Metodos;
import metodos.MetodosSQL;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import java.awt.Cursor;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import java.awt.Rectangle;

public class InterfazInv extends JFrame implements ActionListener, MouseListener, MouseMotionListener, KeyListener {

	public JPanel contentPane, panel, panel_1;
	public JButton minimizar, cerrar, agregar,mostrar,regresar;
	public JLabel label,label16;
	int xx, xy;
	int fil;
	protected JSeparator separator_2;
	protected JSeparator separator_3;
	
	protected JPanel panel_3;
	protected JLabel lblNewLabel;
	protected JTextField producto;
	private JTextField descripcion;
	private JSeparator separator_5;
	private JRadioButton masa, liquido;
	private JLabel lblNewLabel_1;
	private JSeparator separator_6;
	private JTextField peso;
	private JSeparator separator_7;
	private JButton modificar;
	private ButtonGroup grupo, grupo2;
	private JScrollPane scrollPane;
	private JTable table;
	
	Metodos metodo = new Metodos();
	MetodosSQL sql = new MetodosSQL();
	ConexionSQL con = new ConexionSQL();
	TextPrompt tp ;
	String variable;
	private JTextField unidades;
	private JTextField buscador;
	private JSeparator separator_9;
	private JButton borrar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazInv frame = new InterfazInv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public InterfazInv() {
	
		setBackground(new Color(169, 169, 169));
		setTitle("Inventario");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/pasteleria.png")).getImage());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(150, 150, 150));
		contentPane.addMouseListener(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(41, 41, 41));
		panel.setBounds(0, 0, 1081, 100);
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		contentPane.add(panel);
		
		

		minimizar = new JButton("-");
		minimizar.setForeground(new Color(200,200,200));		
		minimizar.setBackground(new Color(41,41,41));
		minimizar.setFont(new Font("Arial Black", Font.BOLD, 24));
		minimizar.setFocusPainted(false);
		minimizar.setBorderPainted(false);
		minimizar.setBounds(990, 7, 43, 25);
		minimizar.addMouseListener(this);
		minimizar.addActionListener(this);
		panel.add(minimizar);
		
		label = new JLabel("");
		label.setBounds(10, 5, 100, 67);
		metodo.vLMostrarIMG(label, "/imagenes/pasteleria.png");
		panel.add(label);
		
		JLabel label2 = new JLabel("Reposteria Charlie");
		label2.setForeground(new Color(255, 255, 255));
		label2.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 52));
		label2.setBounds(120, 5, 526, 67);
		panel.add(label2);
		
		JSeparator separador = new JSeparator();
		separador.setBounds(10, 87, 1061, 2);
		panel.add(separador);
		
		cerrar = new JButton("X");
		cerrar.setBackground(new Color(41,41,41));
		cerrar.setFont(new Font("Arial Black", Font.BOLD, 12));
		cerrar.setForeground(new Color(200, 200, 200));
		cerrar.setFocusPainted(false);
		cerrar.setBorderPainted(false);
		cerrar.setBounds(1032, 7, 45, 25);
		cerrar.addActionListener(this);
		cerrar.addMouseListener(this);
		panel.add(cerrar);
		
		regresar = new JButton("\u2190");
		regresar.setBackground(new Color(41,41,41));
		regresar.setBounds(950, 7, 41, 25);
		panel.add(regresar);
		regresar.setForeground(new Color(200,200,200));
		regresar.setFocusPainted(false);
		regresar.setBorder(null);
		regresar.addActionListener(this);
		regresar.addMouseListener(this);
		regresar.setFont(new Font("Arial Black", Font.BOLD, 22));
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 111, 1061, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 640, 1061, 2);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(1069, 111, 2, 531);
		contentPane.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(10, 111, 2, 531);
		contentPane.add(separator_3);
		
		panel_1 = new JPanel();
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel_1.setBounds(379, 124, 680, 505);
		panel_1.setBackground(new Color(200,200,200));
		contentPane.add(panel_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(41, 41, 41));
		
		JLabel lblInventario = new JLabel("Inventario");
		lblInventario.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventario.setForeground(new Color(255, 255, 255));
		lblInventario.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 28));
		lblInventario.setBounds(0, 0, 657, 50);
		panel_3_1.add(lblInventario);
		
		scrollPane = new JScrollPane();
		
		mostrar = new JButton("");
		mostrar.setFocusPainted(false);
		mostrar.setContentAreaFilled(false);
		mostrar.setBorder(null);
		mostrar.setSize(30, 30);
		mostrar.addActionListener(this);
		mostrar.addMouseListener(this);
		
		JPanel panel_4 = new JPanel();
		
		grupo2 = new ButtonGroup();
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(mostrar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_3_1, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(mostrar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(16)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(200,200,200));
		
		buscador = new JTextField();
		buscador.setBounds(0, 0, 283, 28);
		panel_4.add(buscador);
		buscador.setFont(new Font("Times New Roman", Font.BOLD, 14));
		buscador.setBackground(new Color(200,200,200));
		tp = new TextPrompt("Buscar por nombre o por tipo", buscador);
		buscador.addKeyListener(this);
		buscador.setBorder(null);			
		buscador.setColumns(10);
		
		separator_9 = new JSeparator();
		separator_9.setBounds(0, 28, 283, 10);
		panel_4.add(separator_9);
		separator_9.setBackground(new Color(0, 0, 0));
		separator_9.setForeground(new Color(0, 0, 0));
		
		//metodo.vBMostrarIMG(mostrar, "/imagenes/ojo.png");
		table = new JTable();
		table.setShowGrid(false);
		table.getTableHeader().setBackground(new Color(41,41,41));
		table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,14));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setBackground(Color.WHITE);
		table.setSelectionBackground(new Color(200,200,200));
		table.addMouseListener(this);
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		

		metodo.vTabla(table);
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
	
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 124, 349, 505);
		panel_2.setBackground(new Color(200,200,200));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 329, 50);
		panel_2.add(panel_3);
		panel_3.setBackground(new Color(41,41,41));
		panel_3.setLayout(null);
		
		lblNewLabel = new JLabel("Datos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 28));
		lblNewLabel.setBounds(0, 0, 329, 50);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel_3.add(lblNewLabel);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(new Color(0, 0, 0));
		separator_4.setForeground(new Color(0, 0, 0));
		separator_4.setBounds(10, 97, 329, 2);
		panel_2.add(separator_4);
		
		separator_5 = new JSeparator();
		separator_5.setBackground(new Color(0, 0, 0));
		separator_5.setForeground(new Color(0, 0, 0));
		separator_5.setBounds(10, 141, 329, 13);
		panel_2.add(separator_5);
		
		masa = new JRadioButton("Masa");
		masa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		masa.setBackground(new Color(200,200,200));
		masa.setBounds(10, 191, 67, 23);
		masa.addActionListener(this);
		panel_2.add(masa);
		
		liquido = new JRadioButton("Liquido");
		liquido.setFont(new Font("Times New Roman", Font.BOLD, 14));
		liquido.setBackground(new Color(200,200,200));
		liquido.setBounds(79, 191, 93, 23);
		liquido.addActionListener(this);
		panel_2.add(liquido);
		
		grupo = new ButtonGroup();
		grupo.add(liquido);
		grupo.add(masa);
		
		lblNewLabel_1 = new JLabel("Tipo:");
		lblNewLabel_1.setForeground(new Color(105, 105, 105));
		lblNewLabel_1.setBackground(new Color(105, 105, 105));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 159, 180, 25);
		panel_2.add(lblNewLabel_1);
		
		separator_6 = new JSeparator();
		separator_6.setBackground(new Color(0, 0, 0));
		separator_6.setForeground(new Color(0, 0, 0));
		separator_6.setBounds(16, 221, 323, 2);
		panel_2.add(separator_6);
		
		separator_7 = new JSeparator();
		separator_7.setBackground(new Color(0, 0, 0));
		separator_7.setForeground(new Color(0, 0, 0));
		separator_7.setBounds(10, 276, 329, 13);
		panel_2.add(separator_7);
		
		agregar = new JButton("Agregar");
		agregar.setForeground(new Color(255, 255, 255));
		agregar.setFocusPainted(false);
		agregar.setBorder(null);
		agregar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		agregar.setBounds(10, 361, 329, 30);
		agregar.setBackground(new Color(41,41,41));
		agregar.addActionListener(this);
		agregar.addMouseListener(this);
		
		
		producto = new JTextField();
		producto.setBorder(null);
		
		producto.setForeground(new Color(0, 0, 0));
		producto.setFont(new Font("Times New Roman", Font.BOLD, 14));	
		tp = new TextPrompt("Nombre del producto", producto);
		producto.setBackground(new Color(200,200,200));
		producto.setBounds(10, 72, 300, 25);				
		panel_2.add(producto);
		producto.setColumns(10);
		panel_2.add(agregar);
		
		descripcion = new JTextField();
		descripcion.setBorder(null);
		descripcion.setForeground(new Color(0, 0, 0));
		descripcion.setBackground(new Color(200,200,200));
		descripcion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		descripcion.setBounds(10, 116, 300, 25);
		tp = new TextPrompt("Descripcion del producto", descripcion);
		descripcion.addKeyListener(this);
		panel_2.add(descripcion);
		descripcion.setColumns(10);
		
		peso = new JTextField();
		peso.setBorder(null);
		peso.setFont(new Font("Times New Roman", Font.BOLD, 14));
		peso.setBackground(new Color(200,200,200));
		peso.setBounds(10, 250, 223, 25);
		tp = new TextPrompt("Peso del articulo", peso); 		
		peso.addKeyListener(this);
		panel_2.add(peso);
		peso.setColumns(10);
		
		modificar = new JButton("Modificar");
		modificar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		modificar.setBackground(new Color(41,41,41));
		modificar.setForeground(new Color(255,255,255));
		modificar.setBorder(null);
		modificar.setBounds(10, 402, 329, 30);
		modificar.addActionListener(this);
		modificar.addMouseListener(this);
		modificar.setEnabled(false);
		panel_2.add(modificar);
		
		label16 = new JLabel("");
		label16.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label16.setBounds(293, 250, 46, 25);
		panel_2.add(label16);
		
		unidades = new JTextField();
		unidades.setBorder(null);
		unidades.setFont(new Font("Times New Roman", Font.BOLD, 14));
		unidades.setBounds(10, 300, 139, 25);
		tp = new TextPrompt("Unidades del articulo", unidades);
		unidades.addKeyListener(this);
		unidades.setBackground(new Color(200,200,200));
		
		panel_2.add(unidades);
		unidades.setColumns(10);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setForeground(Color.BLACK);
		separator_8.setBackground(Color.BLACK);
		separator_8.setBounds(10, 325, 329, 2);
		panel_2.add(separator_8);
		
		borrar = new JButton("Borrar");
		borrar.setFocusPainted(false);
		borrar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		borrar.setBackground(new Color(41,41,41));
		borrar.setForeground(new Color(255,255,255));
		borrar.addActionListener(this);
		borrar.addMouseListener(this);		
		borrar.setBounds(10, 442, 329, 30);
		borrar.setEnabled(false);
		panel_2.add(borrar);
		
		setSize(1081, 653);
		this.setLocationRelativeTo(null);	
		//sql.tablaOriginal(table, metodo.modelo);
		sql.tablaOriginal(table, metodo.modelo);
		table.setDefaultEditor(Object.class, null);
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
		if(arg0.getSource() == mostrar) {
			mostrar.setSize(42,42);
			metodo.vBMostrarIMG(mostrar, "/imagenes/ojo.png");
			mostrar.setForeground(new Color(255,255,255));
			
		}
		if(arg0.getSource() == agregar) {
			agregar.setBackground(new Color(60,60,60));
		}
		if(arg0.getSource() == modificar) {
			modificar.setBackground(new Color(60,60,60));
		}
		if(arg0.getSource() == regresar) {
			regresar.setForeground(new Color(255,255,255));
			regresar.setBackground(new Color(60,60,60));
		}
		if(arg0.getSource() == borrar) {
			
			borrar.setBackground(new Color(60,60,60));
			
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
		if(arg0.getSource() == mostrar) {
			mostrar.setSize(30,30);
			metodo.vBMostrarIMG(mostrar, "/imagenes/ojo.png");
			mostrar.setBackground(new Color(200,200,200));
			
		}
		if(arg0.getSource() == agregar) {
			agregar.setBackground(new Color(41,41,41));
		}
		if(arg0.getSource() == modificar) {
			modificar.setBackground(new Color(41,41,41));
		}
		if(arg0.getSource() == regresar) {
			regresar.setForeground(new Color(200,200,200));
			regresar.setBackground(new Color(41,41,41));
		}
		if(arg0.getSource() == borrar) {
			borrar.setBackground(new Color(41,41,41));
			
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
		       int fila = table.getSelectedRow();
		       
		        if(fila>=0){
		            producto.setText(table.getValueAt(fila,1).toString());
		            descripcion.setText(table.getValueAt(fila,2).toString());		           
		            String tip= table.getValueAt(fila, 3).toString();
		            if(tip.equals("Masa"))
		            grupo.setSelected(masa.getModel(), true);	
		            else
		            grupo.setSelected(liquido.getModel(), true);	
		            peso.setText(table.getValueAt(fila,4).toString());
		            unidades.setText(table.getValueAt(fila,5).toString());
		          
		            modificar.setEnabled(true);
		            agregar.setEnabled(false);
		            borrar.setEnabled(true);
		            fil=table.getSelectedRow();
		            variable = table.getValueAt(fila, 0).toString();
		           // variable=producto.getText();
		            
		        }
		        else{
		            JOptionPane.showMessageDialog(null,"No se ha seleccionado una fila");
		        }
			
		        
			}else {
				int row1;
				row1=table.getSelectedRow();
				table.getSelectionModel().removeSelectionInterval(row1, row1);
				producto.setText(null);
				descripcion.setText(null);
				unidades.setText(null);
				peso.setText(null);
				agregar.setEnabled(true);
				borrar.setEnabled(false);
				modificar.setEnabled(false);
				}
			
				
		}
		if(arg0.getSource() == contentPane) {
			/*int row1;
			row1=table.getSelectedRow();
			table.getSelectionModel().removeSelectionInterval(row1, row1);
			producto.setText(null);
			descripcion.setText(null);
			unidades.setText(null);
			peso.setText(null);
			agregar.setEnabled(true);
			borrar.setEnabled(false);
			modificar.setEnabled(false);*/
		}
		
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == minimizar) {
			this.setExtendedState(ICONIFIED);
			

		}
		if(arg0.getSource() == cerrar) {
			
			System.exit(0);
		}
		if(arg0.getSource() == agregar) {
						
			sql.insertarDatos(producto, descripcion, masa, liquido, peso, unidades, table, metodo.modelo);			
			mostrar.setEnabled(false);
			producto.setText(null);
			descripcion.setText(null);
			unidades.setText(null);
			peso.setText(null);
			
		}
		if(arg0.getSource() == mostrar) {
			//sql.tablaOriginal(table, metodo.modelo);
			//mostrar.setEnabled(false);
			//buscador.setEnabled(true);
		}
		if(arg0.getSource() == masa) {
			label16.setText("Kg");
			
		}
		if(arg0.getSource() == liquido) {
			label16.setText("Lts");
		}
		if(arg0.getSource() == regresar) {
			InterfazAdministrador in1 = new InterfazAdministrador();
			in1.setVisible(true);
			this.setVisible(false);
			
		}
		if(arg0.getSource() == modificar) {
			sql.modificarDatos(producto, descripcion, peso, unidades, variable);
			sql.tablaOriginal(table, metodo.modelo);
			modificar.setEnabled(false);
			borrar.setEnabled(false);
			agregar.setEnabled(true);
			producto.setText(null);
			descripcion.setText(null);
			unidades.setText(null);
			peso.setText(null);
			
		}
		if(arg0.getSource() == borrar) {			
			sql.borrarDatos(fil,variable);
			sql.tablaOriginal(table, metodo.modelo);
			modificar.setEnabled(false);
			borrar.setEnabled(false);
			agregar.setEnabled(true);
			producto.setText(null);
			descripcion.setText(null);
			unidades.setText(null);
			peso.setText(null);
			
		}
		
	}


	@Override
	public void keyPressed(KeyEvent arg0) {


		
		
		
	}

	

	@Override
	public void keyReleased(KeyEvent arg0) {

		if(arg0.getSource() == buscador) {
		
			sql.buscarDatos(metodo.modelo, buscador.getText(), table);
		}

		
		
		
	}
			

	@Override
	public void keyTyped(KeyEvent arg0) {

		
	}
}
