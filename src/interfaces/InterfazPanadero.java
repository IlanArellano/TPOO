package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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
import javax.swing.border.EmptyBorder;

import metodos.Metodos;

public class InterfazPanadero extends JFrame implements ActionListener, MouseListener, MouseMotionListener{

	private int xx,xy;
	
	public JPanel contentPane , panel;
	private JButton cerrar, minimizar, recetas, regresar;
	private JLabel label, label2, label3;
	private JSeparator separator_2;
	private JSeparator separator_5;
	private JSeparator separator_7;
	private JSeparator separator_9;
	private JButton productos;
	private JLabel lblGastos;
	private JSeparator separator_6;
	public static String nombre;
	Metodos metodo = new Metodos();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPanadero frame = new InterfazPanadero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazPanadero() {
		setBackground(new Color(150, 150, 150));
		setTitle("Menu principal");
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/pasteleria.png")).getImage());
		
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		setSize(757,410);
		contentPane.setLayout(null);
		
		label3 = new JLabel("Recetas");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Arial Black", Font.BOLD, 18));
		label3.setBounds(33, 340, 309, 36);
		label3.setForeground(new Color(0,0,0));
		contentPane.add(label3);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 757, 100);
		panel.setBackground(new Color(41,41,41)); 
		contentPane.add(panel);
		panel.setLayout(null);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		
		cerrar=new JButton("X");	
		panel.add(cerrar);
		cerrar.setBounds(706, 7, 45, 25);		
		cerrar.setBorderPainted(false);
		cerrar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		//cerrar.setForeground(Color.BLACK);
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
		minimizar.setBounds(662, 7, 43, 25);
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
		label2.setBounds(130, 11, 447, 67);
		panel.add(label2);
		
		JSeparator separador = new JSeparator();
		separador.setBounds(10, 87, 732, 2);
		panel.add(separador);
		
		regresar = new JButton("Cerrar sesion");
		regresar.setForeground(SystemColor.scrollbar);
		regresar.setFont(new Font("Arial Black", Font.BOLD, 12));
		regresar.setFocusPainted(false);
		regresar.setBorder(null);
		regresar.setBackground(new Color(41, 41, 41));
		regresar.setBounds(627, 53, 124, 25);
		regresar.addMouseListener(this);
		regresar.addActionListener(this);
		panel.add(regresar);
		
		recetas = new JButton("");
		recetas.setFocusTraversalPolicyProvider(true);
		recetas.setFocusable(false);
		recetas.setBorderPainted(false);
		recetas.setBorder(null);
		recetas.setFont(new Font("Arial Black", Font.BOLD, 17));
		recetas.setVerticalTextPosition(SwingConstants.BOTTOM);
		recetas.setHorizontalTextPosition(SwingConstants.CENTER);
		recetas.setFocusPainted(false);
		recetas.setSize(220, 200);
		metodo.vBMostrarIMG(recetas, "/imagenes/recetas.png");		
		recetas.setForeground(new Color(0,0,0));
		recetas.setBackground(new Color(150,150,150));
		recetas.setBounds(33, 140, 309, 200);
		recetas.addMouseListener(this);
		recetas.addActionListener(this);
		contentPane.add(recetas);
		
		JSeparator separator = new JSeparator();
		separator.setOpaque(true);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(10, 111, 731, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setOpaque(true);
		separator_1.setFocusTraversalKeysEnabled(false);
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(33, 373, 309, 2);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setOpaque(true);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(365, 111, 2, 284);
		contentPane.add(separator_2);
		
		separator_5 = new JSeparator();
		separator_5.setForeground(Color.BLACK);
		separator_5.setBackground(Color.BLACK);
		separator_5.setBounds(10, 393, 731, 2);
		contentPane.add(separator_5);
		
		separator_7 = new JSeparator();
		separator_7.setOpaque(true);
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setForeground(Color.BLACK);
		separator_7.setBackground(Color.BLACK);
		separator_7.setBounds(10, 111, 2, 284);
		contentPane.add(separator_7);
		
		separator_9 = new JSeparator();
		separator_9.setOpaque(true);
		separator_9.setForeground(Color.BLACK);
		separator_9.setFocusTraversalKeysEnabled(false);
		separator_9.setBackground(Color.BLACK);
		separator_9.setBounds(391, 373, 311, 2);
		contentPane.add(separator_9);
		
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
		productos.setBounds(391, 140, 321, 200);
		productos.addActionListener(this);
		productos.addMouseListener(this);
		metodo.vBMostrarIMG(productos, "/imagenes/un-pan.png");
		contentPane.add(productos);
		
		lblGastos = new JLabel("Productos");
		lblGastos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGastos.setForeground(Color.BLACK);
		lblGastos.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblGastos.setBounds(391, 340, 321, 36);
		contentPane.add(lblGastos);
		
		separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setOpaque(true);
		separator_6.setForeground(Color.BLACK);
		separator_6.setBackground(Color.BLACK);
		separator_6.setBounds(739, 111, 2, 284);
		contentPane.add(separator_6);
		

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
		if(arg0.getSource() == recetas) {
			InterfazRec rec = new InterfazRec();
			rec.setVisible(true);
			this.setVisible(false);
		}
		if(arg0.getSource() == productos) {
			InterfazPro pro = new InterfazPro();
			pro.panadero.setText(nombre);
			pro.setVisible(true);
			this.setVisible(false);
		}
		if(arg0.getSource() == regresar) {
			InterfazLogin in = new InterfazLogin();
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
		
		if(arg0.getSource() == recetas) {
			
			recetas.setBackground(new Color(200,200,200));
			
		}
		if(arg0.getSource() == regresar) {
			regresar.setForeground(new Color(255,255,255));
			regresar.setBackground(new Color(60,60,60));
		}
		if(arg0.getSource() == productos) {
			
			productos.setBackground(new Color(200,200,200));
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
		if(arg0.getSource() == recetas) {
			
			recetas.setBackground(new Color(150,150,150));
		}
		if(arg0.getSource() == productos) {
			
			productos.setBackground(new Color(150,150,150));
		}
		if(arg0.getSource() == regresar) {
			regresar.setForeground(new Color(200,200,200));
			regresar.setBackground(new Color(41,41,41));
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
