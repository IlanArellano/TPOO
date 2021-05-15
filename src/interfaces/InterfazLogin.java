package interfaces;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import metodos.MetodosSQL;
import java.awt.Point;

public class InterfazLogin extends JFrame implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
	
	int xx,xy;
	private JPanel contentPane;
	private JButton minimizar, cerrar, entrar;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JSeparator separator;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_1, labelnom;
	private JTextField nombre;
	private JComboBox puesto;
	private JPasswordField id;
	final String idAdm = "1234";
	final String nomAdm = "Admin";
	
	MetodosSQL sql = new MetodosSQL();
	private JLabel labelid;
	private JTextField id1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazLogin frame = new InterfazLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public InterfazLogin() {
		setUndecorated(true);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(150,150,150));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/pasteleria.png")).getImage());
		setSize(472,440);
		setLocationRelativeTo(null);
		
		minimizar = new JButton("-");
		minimizar.setBounds(378, 11, 43, 25);
		contentPane.add(minimizar);
		minimizar.setForeground(new Color(200,200,200));		
		minimizar.setFont(new Font("Arial Black", Font.BOLD, 24));
		minimizar.setFocusPainted(false);
		minimizar.setBorderPainted(false);
		minimizar.setBackground(new Color(41,41,41));
		
		cerrar = new JButton("X");
		cerrar.setBounds(422, 11, 45, 25);
		contentPane.add(cerrar);
		cerrar.setFont(new Font("Arial Black", Font.BOLD, 12));
		cerrar.setForeground(new Color(200, 200, 200));
		cerrar.setBackground(new Color(41,41,41));
		cerrar.setFocusPainted(false);
		cerrar.setBorderPainted(false);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 472, 93);
		panel.setBackground(new Color(41,41,41));
		contentPane.add(panel);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Reposteria Charlie");
		lblNewLabel.setBounds(10, 5, 388, 69);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 47));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setForeground(Color.WHITE);
		separator.setBounds(10, 80, 452, 2);
		panel.add(separator);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 102, 452, 325);
		panel_1.setBackground(new Color(200,200,200));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 432, 70);
		panel_2.setBackground(new Color(41,41,41));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 40));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 11, 412, 48);
		panel_2.add(lblNewLabel_1);
		
		puesto = new JComboBox();
		puesto.setForeground(Color.BLACK);
		puesto.setModel(new DefaultComboBoxModel(new String[] {"Panadero", "Cajero", "Administrador"}));
		puesto.setFont(new Font("Times New Roman", Font.BOLD, 17));
		puesto.setBackground(new Color(230,230,230));
		puesto.addMouseListener(this);
		puesto.setBounds(68, 109, 320, 33);
		panel_1.add(puesto);
		
		JLabel lblNewLabel_2 = new JLabel("Puesto:");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(68, 80, 319, 30);
		panel_1.add(lblNewLabel_2);
		
		nombre = new JTextField();
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		nombre.setForeground(Color.BLACK);
		nombre.setFont(new Font("Times New Roman", Font.BOLD, 17));
		nombre.setBackground(new Color(230,230,230));
		
		nombre.setBounds(67, 238, 320, 33);
		panel_1.add(nombre);
		nombre.setColumns(10);
		
		labelnom = new JLabel("Nombre completo:");
		labelnom.setForeground(Color.DARK_GRAY);
		labelnom.setHorizontalAlignment(SwingConstants.CENTER);
		labelnom.setFont(new Font("Times New Roman", Font.BOLD, 17));
		labelnom.setBounds(68, 208, 320, 30);
		panel_1.add(labelnom);
		
		entrar = new JButton("Entrar");
		entrar.setFocusPainted(false);
		entrar.setForeground(Color.WHITE);
		entrar.setBackground(new Color(40,40,40));
		entrar.setBorder(null);
		entrar.setFont(new Font("Times New Roman", Font.BOLD, 17));
		entrar.setBounds(142, 279, 175, 33);
		panel_1.add(entrar);
		
		labelid = new JLabel("ID:");
		labelid.setHorizontalAlignment(SwingConstants.CENTER);
		labelid.setForeground(Color.DARK_GRAY);
		labelid.setFont(new Font("Times New Roman", Font.BOLD, 17));
		labelid.setBounds(68, 142, 319, 30);
		panel_1.add(labelid);
		
		id = new JPasswordField();
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setForeground(Color.BLACK);
		id.setFont(new Font("Times New Roman", Font.BOLD, 17));
		id.setColumns(10);
		id.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		id.setBackground(new Color(230, 230, 230));
		id.setBounds(68, 172, 320, 33);
		panel_1.add(id);
		
		entrar.addActionListener(this);
		entrar.addMouseListener(this);
		cerrar.addActionListener(this);
		cerrar.addMouseListener(this);
		minimizar.addMouseListener(this);
		minimizar.addActionListener(this);
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
		if(arg0.getSource() == entrar) {
			
			entrar.setBackground(new Color(60,60,60));
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
		if(arg0.getSource() == entrar) {
			
			entrar.setBackground(new Color(41,41,41));
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
	public void keyPressed(KeyEvent arg0) {
		
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
	
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == minimizar) {
			this.setExtendedState(ICONIFIED);
		}
		if(arg0.getSource() == cerrar) {
			System.exit(0);
			
		}
		if(arg0.getSource() == entrar) {
			boolean dato;

				dato = sql.loginEmpleado(puesto.getSelectedItem().toString(), nombre.getText(),id.getText());
				if(dato == true) {
				if(puesto.getSelectedItem().equals("Administrador")) {
					
					InterfazAdministrador epa = new InterfazAdministrador();
					epa.setVisible(true);
					this.setVisible(false);

				}	
				else if(puesto.getSelectedItem().equals("Panadero")) {
					InterfazPanadero pro = new InterfazPanadero();
					pro.setVisible(true);					
					pro.nombre = "Empleado: " + nombre.getText() ; //.("Empleado: " + nombre.getText());					
					this.setVisible(false);

				}else if(puesto.getSelectedItem().equals("Cajero")) {
					InterfazVentas ven = new InterfazVentas();
					ven.setVisible(true);
					ven.nombre = nombre.getText();
					ven.labelNom.setText("Empleado: " + nombre.getText());
					ven.identificacion = Integer.parseInt(id.getText());
					this.setVisible(false);
				}
					
				}else {
	              	
				JOptionPane.showMessageDialog(null, "Los datos son incorrectos o no se ha registrado el empleado");
				}
				
				
			
			
			
			
		}
		
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
}
