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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import metodos.Metodos;
import metodos.MetodosSQL;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class InterfazAdPro extends JFrame implements ActionListener, MouseListener, MouseMotionListener, KeyListener{

	
	private int xx,xy;
	public JPanel contentPane , panel;
	private JButton cerrar, minimizar, regresar;
	private JLabel label, label2;
	private JSeparator separator_5;
	private JSeparator separator_7;
	private JSeparator separator_6;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTable table;
	TextPrompt tp ;
	Metodos metodo = new Metodos();
	MetodosSQL sql = new MetodosSQL();
	private JTextField buscador;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazAdPro frame = new InterfazAdPro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public InterfazAdPro() {
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
		setSize(867,540);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 867, 100);
		panel.setBackground(new Color(41,41,41)); 
		contentPane.add(panel);
		panel.setLayout(null);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		
		cerrar=new JButton("X");	
		panel.add(cerrar);
		cerrar.setBounds(803, 7, 45, 25);		
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
		minimizar.setBounds(757, 7, 43, 25);
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
		label2.setBounds(130, 11, 526, 67);
		panel.add(label2);
		
		JSeparator separador = new JSeparator();
		separador.setBounds(10, 87, 851, 2);
		panel.add(separador);
		
		regresar = new JButton("\u2190");
		regresar.setForeground(SystemColor.scrollbar);
		regresar.setFont(new Font("Arial Black", Font.BOLD, 22));
		regresar.setFocusPainted(false);
		regresar.setBorder(null);
		regresar.setBackground(new Color(41, 41, 41));
		regresar.setBounds(713, 7, 41, 25);
		regresar.addMouseListener(this);
		regresar.addActionListener(this);
		panel.add(regresar);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 111, 845, 2);
		separator.setOpaque(true);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		contentPane.add(separator);
		
		separator_5 = new JSeparator();
		separator_5.setBounds(10, 527, 845, 2);
		separator_5.setForeground(Color.BLACK);
		separator_5.setBackground(Color.BLACK);
		contentPane.add(separator_5);
		
		separator_7 = new JSeparator();
		separator_7.setBounds(10, 111, 2, 418);
		separator_7.setOpaque(true);
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setForeground(Color.BLACK);
		separator_7.setBackground(Color.BLACK);
		contentPane.add(separator_7);
	
	
		
		separator_6 = new JSeparator();
		separator_6.setBounds(853, 111, 2, 418);
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setOpaque(true);
		separator_6.setForeground(Color.BLACK);
		separator_6.setBackground(Color.BLACK);
		contentPane.add(separator_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 122, 823, 384);
		panel_1.setBackground(new Color(200,200,200));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 803, 55);
		panel_2.setBackground(new Color(41,41,41));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Productos");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 29));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 803, 55);
		panel_2.add(lblNewLabel);
		
		panel_3 = new JPanel();
		panel_3.setBounds(10, 121, 803, 252);
		panel_1.add(panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
		);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setDefaultEditor(Object.class, null);
		table.addMouseListener(this);
		table.getTableHeader().setBackground(new Color(41,41,41));
		table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,14));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setBackground(Color.WHITE);
		table.setSelectionBackground(new Color(200,200,200));
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));		
		metodo.tablaProductos(table);
		sql.tablaProductos(table, metodo.modelo3);
		scrollPane.setViewportView(table);
		panel_3.setLayout(gl_panel_3);
		
		buscador = new JTextField();
		buscador.setBorder(null);
		buscador.setForeground(Color.BLACK);
		buscador.setFont(new Font("Times New Roman", Font.BOLD, 14));
		buscador.setBounds(10, 77, 252, 30);
		panel_1.add(buscador);
		buscador.addKeyListener(this);
		tp = new TextPrompt("Buscar por nombre", buscador);
		buscador.setBackground(new Color(200,200,200));
		buscador.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 107, 252, 2);
		panel_1.add(separator_1);
		
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
		if(arg0.getSource() == regresar) {
			InterfazAdministrador in = new InterfazAdministrador();
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


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getSource() == buscador) {
			sql.buscarProducto(metodo.modelo3, buscador.getText(), table);
		}
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
