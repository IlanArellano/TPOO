package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import metodos.Metodos;
import java.awt.SystemColor;

public class InterfazAdministrador extends JFrame implements ActionListener, MouseListener, MouseMotionListener{

	

	private int xx,xy;
	public JPanel contentPane , panel;
	private JButton cerrar, minimizar, inventario, facturas;
	private JLabel label, label2, label3;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_5;
	private JSeparator separator_7;
	private JSeparator separator_8;
	private JSeparator separator_9;
	private JButton empleados;
	private JButton productos;
	private JLabel lblEmpleados;
	private JLabel lblGastos;
	
	Metodos metodo = new Metodos();
	private JButton regresar;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazAdministrador frame = new InterfazAdministrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public InterfazAdministrador() {
		
		setBackground(new Color(150, 150, 150));		
		setTitle("Menu principal");
		setResizable(false);
		setUndecorated(true);
		//setSize(450,463);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 655);		
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/pasteleria.png")).getImage());
		
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label3 = new JLabel("Inventario");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Arial Black", Font.BOLD, 18));
		label3.setBounds(45, 326, 290, 25);
		label3.setForeground(new Color(0,0,0));
		contentPane.add(label3);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 738, 100);
		panel.setBackground(new Color(41,41,41)); 
		contentPane.add(panel);
		panel.setLayout(null);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		
		cerrar=new JButton("X");	
		panel.add(cerrar);
		cerrar.setBounds(680, 7, 45, 25);		
		cerrar.setBorderPainted(false);
		cerrar.setFont(new Font("Arial Black", Font.PLAIN, 12));		
		cerrar.setForeground(new Color(200,200,200));
		cerrar.setFocusTraversalKeysEnabled(false);		
		cerrar.setBackground(new Color(41,41,41));
		cerrar.setFocusPainted(false);
		cerrar.addActionListener(this);
		cerrar.addMouseListener(this);
		
		minimizar = new JButton("-");
		minimizar.setFocusPainted(false);
		panel.add(minimizar);
		minimizar.setFont(new Font("Arial Black", Font.BOLD, 24));
		minimizar.setBorderPainted(false);
		minimizar.setBounds(637, 7, 43, 25);
		minimizar.setForeground(new Color(200,200,200));
		minimizar.setBackground(new Color(41,41,41));
		minimizar.addMouseListener(this);
		minimizar.addActionListener(this);
		
		label = new JLabel("");
		label.setBounds(20, 11, 100, 67);
		metodo.vLMostrarIMG(label, "/imagenes/panaderia.png");
		panel.add(label);
		
		label2 = new JLabel("Reposteria Charlie");
		label2.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 52));
		label2.setForeground(new Color(255, 255, 255));
		label2.setBounds(130, 11, 427, 67);
		panel.add(label2);
		
		JSeparator separador = new JSeparator();
		separador.setBounds(10, 87, 709, 2);
		panel.add(separador);
		
		regresar = new JButton("Cerrar sesion");
		regresar.setForeground(SystemColor.scrollbar);
		regresar.setFont(new Font("Arial Black", Font.BOLD, 12));
		regresar.setFocusPainted(false);
		regresar.setBorder(null);
		regresar.setBackground(new Color(41, 41, 41));
		regresar.addActionListener(this);
		regresar.addMouseListener(this);
		regresar.setBounds(610, 53, 120, 25);
		panel.add(regresar);
		
		inventario = new JButton("");
		inventario.setFocusTraversalPolicyProvider(true);
		inventario.setFocusable(false);
		inventario.setBorderPainted(false);
		inventario.setBorder(null);
		inventario.setFont(new Font("Arial Black", Font.BOLD, 17));
		inventario.setVerticalTextPosition(SwingConstants.BOTTOM);
		inventario.setHorizontalTextPosition(SwingConstants.CENTER);
		inventario.setFocusPainted(false);
		inventario.setSize(220, 200);
		metodo.vBMostrarIMG(inventario, "/imagenes/inventario.png");		
		inventario.setForeground(new Color(0,0,0));
		inventario.setBackground(new Color(150,150,150));
		inventario.setBounds(45, 128, 290, 200);
		inventario.addMouseListener(this);
		inventario.addActionListener(this);
		contentPane.add(inventario);
		
		JSeparator separator = new JSeparator();
		separator.setOpaque(true);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(10, 111, 716, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setOpaque(true);
		separator_1.setFocusTraversalKeysEnabled(false);
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(45, 355, 290, 2);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setOpaque(true);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(367, 111, 2, 530);
		contentPane.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setOpaque(true);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(724, 111, 2, 530);
		contentPane.add(separator_3);
		
		separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setBackground(Color.BLACK);
		separator_5.setBounds(10, 375, 716, 10);
		contentPane.add(separator_5);
		
		separator_7 = new JSeparator();
		separator_7.setOpaque(true);
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setForeground(Color.BLACK);
		separator_7.setBackground(Color.BLACK);
		separator_7.setBounds(10, 111, 2, 530);
		contentPane.add(separator_7);
		
		separator_8 = new JSeparator();
		separator_8.setOpaque(true);
		separator_8.setForeground(Color.BLACK);
		separator_8.setFocusTraversalKeysEnabled(false);
		separator_8.setBackground(Color.BLACK);
		separator_8.setBounds(405, 355, 290, 2);
		contentPane.add(separator_8);
		
		separator_9 = new JSeparator();
		separator_9.setOpaque(true);
		separator_9.setForeground(Color.BLACK);
		separator_9.setFocusTraversalKeysEnabled(false);
		separator_9.setBackground(Color.BLACK);
		separator_9.setBounds(45, 620, 290, 2);
		contentPane.add(separator_9);
		
		empleados = new JButton("");
		empleados.setVerticalTextPosition(SwingConstants.BOTTOM);
		empleados.setHorizontalTextPosition(SwingConstants.CENTER);
		empleados.setForeground(Color.BLACK);
		empleados.setFont(new Font("Arial Black", Font.BOLD, 17));
		empleados.setFocusable(false);
		empleados.setFocusTraversalPolicyProvider(true);
		empleados.setFocusPainted(false);
		empleados.setBorderPainted(false);
		empleados.setBorder(null);
		empleados.setSize(220, 200);
		empleados.setBackground(new Color(150, 150, 150));
		empleados.setBounds(402, 128, 290, 200);
		empleados.addActionListener(this);
		empleados.addMouseListener(this);
		metodo.vBMostrarIMG(empleados, "/imagenes/empleado1.png");
		contentPane.add(empleados);
		
		productos = new JButton("");
		productos.setVerticalTextPosition(SwingConstants.BOTTOM);
		productos.setHorizontalTextPosition(SwingConstants.CENTER);
		productos.setForeground(Color.BLACK);
		productos.setFont(new Font("Arial Black", Font.BOLD, 17));
		productos.setFocusable(false);
		productos.setFocusTraversalPolicyProvider(true);
		productos.setFocusPainted(false);
		productos.setBorderPainted(false);
		productos.setBorder(null);
		productos.setBackground(new Color(150, 150, 150));
		productos.setBounds(45, 391, 290, 200);
		productos.addActionListener(this);
		productos.addMouseListener(this);
		metodo.vBMostrarIMG(productos, "/imagenes/pan1.png");
		contentPane.add(productos);
		
		lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleados.setForeground(Color.BLACK);
		lblEmpleados.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblEmpleados.setBounds(405, 320, 290, 36);
		contentPane.add(lblEmpleados);
		
		lblGastos = new JLabel("Productos");
		lblGastos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGastos.setForeground(Color.BLACK);
		lblGastos.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblGastos.setBounds(45, 584, 290, 36);
		contentPane.add(lblGastos);
		
		facturas = new JButton("");
		facturas.setVerticalTextPosition(SwingConstants.BOTTOM);
		facturas.setHorizontalTextPosition(SwingConstants.CENTER);
		facturas.setForeground(Color.BLACK);
		facturas.setFont(new Font("Arial Black", Font.BOLD, 17));
		facturas.setFocusable(false);
		facturas.setFocusTraversalPolicyProvider(true);
		facturas.setFocusPainted(false);
		facturas.setBorderPainted(false);
		facturas.setBorder(null);
		facturas.addMouseListener(this);
		facturas.setSize(280,190);
		facturas.addActionListener(this);
		facturas.setBackground(new Color(150, 150, 150));
		metodo.vBMostrarIMG(facturas, "/imagenes/cuenta.png");
		facturas.setBounds(405, 391, 290, 200);
		contentPane.add(facturas);
		
		JSeparator separator_5_1 = new JSeparator();
		separator_5_1.setForeground(Color.BLACK);
		separator_5_1.setBackground(Color.BLACK);
		separator_5_1.setBounds(10, 640, 716, 10);
		contentPane.add(separator_5_1);
		
		JLabel lblFacturas = new JLabel("Facturas");
		lblFacturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacturas.setForeground(Color.BLACK);
		lblFacturas.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblFacturas.setBounds(405, 586, 290, 36);
		contentPane.add(lblFacturas);
		
		JSeparator separator_9_1 = new JSeparator();
		separator_9_1.setOpaque(true);
		separator_9_1.setForeground(Color.BLACK);
		separator_9_1.setFocusTraversalKeysEnabled(false);
		separator_9_1.setBackground(Color.BLACK);
		separator_9_1.setBounds(405, 620, 290, 2);
		contentPane.add(separator_9_1);
		
		setLocationRelativeTo(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == cerrar) {							
			System.exit(0);
		}
		if(arg0.getSource() == minimizar) {
			this.setExtendedState(ICONIFIED);
		}
		if(arg0.getSource() == inventario) {
			InterfazInv inv = new InterfazInv();
			inv.setVisible(true);
			this.setVisible(false);
		}
		if(arg0.getSource() == empleados) {
			InterfazEmp emp = new InterfazEmp();
			emp.setVisible(true);
			this.setVisible(false);
			
		}
		if(arg0.getSource() == productos) {
			InterfazAdPro pro = new InterfazAdPro();
			pro.setVisible(true);
			this.setVisible(false);
		}
		if(arg0.getSource() == regresar) {
			InterfazLogin in = new InterfazLogin();
			in.setVisible(true);
			this.setVisible(false);
			
		}
		if(arg0.getSource() == facturas) {
			InterfazGastos in = new InterfazGastos();
			in.setVisible(true);
			this.setVisible(false);
			
		}
		
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
		if(arg0.getSource() == inventario) {
			
			inventario.setBackground(new Color(200,200,200));
			
		}
		if(arg0.getSource() == facturas) {
			
			facturas.setBackground(new Color(200,200,200));
			
		}
		if(arg0.getSource() == empleados) {
			
			empleados.setBackground(new Color(200,200,200));
		}
		if(arg0.getSource() == productos) {
			
			productos.setBackground(new Color(200,200,200));
		}
		if(arg0.getSource() == regresar) {
			regresar.setForeground(new Color(255,255,255));
			regresar.setBackground(new Color(60,60,60));
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
		if(arg0.getSource() == inventario) {
			
			inventario.setBackground(new Color(150,150,150));
		}
		if(arg0.getSource() == empleados) {
			
			empleados.setBackground(new Color(150,150,150));
		}
		if(arg0.getSource() == productos) {
			
			productos.setBackground(new Color(150,150,150));
		}
		if(arg0.getSource() == regresar) {
			regresar.setForeground(new Color(200,200,200));
			regresar.setBackground(new Color(41,41,41));
			
		}
		if(arg0.getSource() == facturas) {
			
			facturas.setBackground(new Color(150,150,150));
		}

		
		
		
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		if(arg0.getSource() == panel) {
			xx = arg0.getX();
			xy = arg0.getY();			
		}
		

		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {

		
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		int x= arg0.getXOnScreen();
		int y = arg0.getYOnScreen();
		
		this.setLocation(x-xx, y-xy);
		
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
	
		
	}
}

	

