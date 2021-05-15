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
import java.sql.Timestamp;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JTextField;

public class InterfazGastos extends JFrame implements ActionListener, MouseListener, MouseMotionListener, KeyListener{
	
	int xx,xy;
	private JPanel contentPane, panel;
	private JButton bCerrar, bMinimizar, bRegresar;
	Metodos me = new Metodos();
	MetodosSQL sql = new MetodosSQL();
	TextPrompt tp;
	private JTable table;
	private JTextField buscador;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGastos frame = new InterfazGastos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public InterfazGastos() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 715);
		setLocationRelativeTo(null);
		setSize(767,606);
		contentPane = new JPanel();
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(150,150,150));
		setContentPane(contentPane);
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/pasteleria.png")).getImage());
		panel = new JPanel();
		panel.setBounds(0, 0, 767, 100);
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
		bMinimizar.setBounds(671, 7, 43, 25);
		bMinimizar.addMouseListener(this);
		bMinimizar.addActionListener(this);
		bMinimizar.setBackground(new Color(41,41,41));
		panel.add(bMinimizar);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 5, 100, 67);
		me.vLMostrarIMG(label, "/imagenes/pasteleria.png");
		panel.add(label);
		
		JLabel label2 = new JLabel("Reposteria Charlie");
		label2.setForeground(new Color(255, 255, 255));
		label2.setFont(new Font("Harlow Solid Italic", Font.ITALIC, 52));
		label2.setBounds(120, 11, 435, 61);
		panel.add(label2);
		
		JSeparator separador = new JSeparator();
		separador.setBounds(10, 83, 747, 6);
		panel.add(separador);
		
		bCerrar = new JButton("X");
		bCerrar.setFont(new Font("Arial Black", Font.BOLD, 12));
		bCerrar.setForeground(new Color(200, 200, 200));
		bCerrar.setFocusPainted(false);
		bCerrar.setBorderPainted(false);
		bCerrar.setBounds(714, 7, 45, 25);
		bCerrar.addActionListener(this);
		bCerrar.setBackground(new Color(41,41,41));
		bCerrar.addMouseListener(this);
		panel.add(bCerrar);
		
		bRegresar = new JButton("\u2190");
		bRegresar.setBounds(630, 7, 41, 25);
		panel.add(bRegresar);
		bRegresar.setForeground(new Color(200,200,200));
		bRegresar.setFocusPainted(false);
		bRegresar.setBorder(null);
		bRegresar.addActionListener(this);
		bRegresar.addMouseListener(this);
		bRegresar.setFont(new Font("Arial Black", Font.BOLD, 22));
		bRegresar.setBackground(new Color(41,41,41));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 111, 747, 2);
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 591, 747, 2);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(755, 111, 2, 482);
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 111, 2, 482);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		contentPane.add(separator_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 209, 723, 371);
		panel_1.setBackground(new Color(200,200,200));
		contentPane.add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(200,200,200));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel_3.setLayout(null);
		
		buscador = new JTextField();
		buscador.setBorder(null);		
		buscador.addKeyListener(this);
		buscador.setFont(new Font("Times New Roman", Font.BOLD, 14));
		buscador.setBounds(0, 11, 280, 30);
		buscador.setBackground(new Color(200,200,200));
		panel_3.add(buscador);
		tp = new TextPrompt("Buscar por ID de factura, cliente o empleado", buscador);
		buscador.setColumns(10);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(0, 41, 280, 2);
		panel_3.add(separator_4);
		
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
		me.tablaFactura(table);
		sql.tablaFacturas(table, me.modelo3);
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(41,41,41));
		panel_4.setBounds(20, 124, 725, 74);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Facturas");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 687, 52);
		panel_4.add(lblNewLabel);
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
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		if(arg0.getSource() == panel) {
			xx = arg0.getX();
			xy = arg0.getY();			
		}
		if(arg0.getSource() == table) {
			if(arg0.getClickCount() == 2) {
				int i = table.getSelectedRow();
				int e = Integer.parseInt(table.getValueAt(i, 2).toString());
				
				sql.Jasper(table.getValueAt(i, 1).toString(),table.getValueAt(i, 3).toString() , table.getValueAt(i, 4).toString(), table.getValueAt(i, 5).toString(), table.getValueAt(i, 0).toString(), sql.buscarEmpleado(e), Timestamp.valueOf(table.getValueAt(i, 6).toString()));
				
				
				
			}else {
				int row1;
				row1=table.getSelectedRow();
				table.getSelectionModel().removeSelectionInterval(row1, row1);
			}
			
			
			
		}
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == bCerrar)
		System.exit(0);
		if(arg0.getSource() == bMinimizar)
		this.setExtendedState(ICONIFIED);
		if(arg0.getSource() == bRegresar) {
			InterfazAdministrador in = new InterfazAdministrador();
			in.setVisible(true);
			this.setVisible(false);
			
			
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


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getSource() == buscador) {
			sql.buscarFacturas(table, buscador.getText(), me.modelo3);
			
			
		}
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
