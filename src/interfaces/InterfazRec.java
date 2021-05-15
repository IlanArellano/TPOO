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
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import metodos.Metodos;
import metodos.MetodosSQL;

import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Cursor;


public class InterfazRec extends JFrame implements ActionListener, MouseListener, MouseMotionListener, KeyListener{

	int xx,xy;
	private JPanel contentPane,panel;
	JButton cerrar, minimizar, regresar, bBorrar, bCrear, bModificar;
	JLabel label, label1, label2;
	JSeparator separador;
	Metodos me = new Metodos();
	MetodosSQL sql = new MetodosSQL();
	//InterfazRec rec;
	TextPrompt tp; 
	int fil;
	String variable;
	private JTable table;
	private JTextArea textArea;
	private JTextField tfNombre;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel;
	private JPanel panel_4;
	private JPanel panel_5;
	private JTextField tfBuscador;
	private JSeparator separator_5;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazRec frame = new InterfazRec();
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
	public InterfazRec() {
		setUndecorated(true);
		setTitle("Recetas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(150, 150, 150));
		
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/pasteleria.png")).getImage());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(829,474);
		setLocationRelativeTo(null);
		
		contentPane.setLayout(null);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(41, 41, 41));
		panel.setBounds(0, 0, 829, 100);
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		contentPane.add(panel);
			
		minimizar = new JButton("-");
		minimizar.setForeground(new Color(200,200,200));		
		minimizar.setFont(new Font("Arial Black", Font.BOLD, 24));
		minimizar.setFocusPainted(false);
		minimizar.setBorderPainted(false);
		minimizar.setBackground(new Color(41,41,41));
		minimizar.setBounds(730, 7, 43, 25);
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
		label2.setBounds(120, 5, 526, 67);
		panel.add(label2);
		
		JSeparator separador = new JSeparator();
		separador.setBounds(10, 87, 809, 2);
		panel.add(separador);
		
		cerrar = new JButton("X");
		cerrar.setFont(new Font("Arial Black", Font.BOLD, 12));
		cerrar.setForeground(new Color(200, 200, 200));
		cerrar.setBackground(new Color(41,41,41));
		cerrar.setFocusPainted(false);
		cerrar.setBorderPainted(false);
		cerrar.setBounds(775, 7, 45, 25);
		cerrar.addActionListener(this);
		cerrar.addMouseListener(this);
		panel.add(cerrar);
		
		regresar = new JButton("\u2190");
		regresar.setBounds(687, 7, 41, 25);
		panel.add(regresar);
		regresar.setForeground(new Color(200,200,200));
		regresar.setFocusPainted(false);
		regresar.setBackground(new Color(41,41,41));
		regresar.setBorder(null);
		regresar.addActionListener(this);
		regresar.addMouseListener(this);
		regresar.setVisible(true);
		regresar.setFont(new Font("Arial Black", Font.BOLD, 22));
		
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 111, 806, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 458, 806, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(814, 111, 2, 347);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(10, 111, 2, 347);
		contentPane.add(separator_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 124, 471, 323);
		panel_1.setBackground(new Color(200,200,200));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("Datos de la receta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Harlow Solid Italic", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 11, 447, 55);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		panel_1.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 447, 61);
		panel_3.setBackground(new Color(41,41,41));
		panel_1.add(panel_3);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 123, 320, 189);
		panel_1.add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textArea.setBackground(new Color(240, 240, 240));
		tp = new TextPrompt("Datos de la receta", textArea);
		tp.setVerticalAlignment(SwingConstants.TOP);
		scrollPane_1.setViewportView(textArea);
		textArea.setLineWrap(true);
		scrollPane_1.getHeight();
		
	
		
		bCrear = new JButton("Registrar ");
		bCrear.setBorder(null);
		bCrear.setFocusPainted(false);
		bCrear.setForeground(new Color(255, 255, 255));
		bCrear.setFont(new Font("Times New Roman", Font.BOLD, 14));
		bCrear.addActionListener(this);
		bCrear.addMouseListener(this);
		bCrear.setBounds(340, 129, 105, 30);
		bCrear.setBackground(new Color(41,41,41));
		
		panel_1.add(bCrear);
		
		bModificar = new JButton("Modificar");
		bModificar.setBorder(null);
		bModificar.setFocusPainted(false);
		bModificar.setForeground(new Color(255, 255, 255));
		bModificar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		bModificar.setBounds(340, 170, 105, 30);
		bModificar.setBackground(new Color(41,41,41));
		bModificar.addActionListener(this);
		bModificar.addMouseListener(this);
		bModificar.setEnabled(false);
		panel_1.add(bModificar);
		
		bBorrar = new JButton("Borrar");
		bBorrar.setBorder(null);
		bBorrar.setFocusPainted(false);
		bBorrar.setForeground(new Color(255, 255, 255));
		bBorrar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		bBorrar.setBounds(340, 211, 105, 30);
		bBorrar.addActionListener(this);
		bBorrar.addMouseListener(this);
		bBorrar.setBackground(new Color(41,41,41));
		panel_1.add(bBorrar);
		
		tfNombre = new JTextField();
		tfNombre.setBorder(null);
		tfNombre.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tfNombre.setBounds(10, 83, 320, 30);
		tfNombre.setBackground(new Color(200,200,200));
		tp = new TextPrompt("Nombre de la receta", tfNombre);
		tfNombre.addKeyListener(this);
		panel_1.add(tfNombre);
		tfNombre.setColumns(10);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(Color.BLACK);
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(10, 113, 320, 2);
		panel_1.add(separator_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(501, 124, 303, 323);
		panel_2.setBackground(new Color(200,200,200));
		contentPane.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(41,41,41));
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(200,200,200));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
						.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_4.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Recetas");
		lblNewLabel_1.setFont(new Font("Harlow Solid Italic", Font.BOLD, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 5, 273, 58);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel_4.add(lblNewLabel_1);
		panel_5.setLayout(null);
		
		tfBuscador = new JTextField();
		tfBuscador.setBorder(null);
		tfBuscador.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tfBuscador.setBounds(0, 0, 283, 30);
		tp = new TextPrompt("Buscar por nombre", tfBuscador);
		tfBuscador.addKeyListener(this);
		tfBuscador.setBackground(new Color(200,200,200));
	
		panel_5.add(tfBuscador);
		tfBuscador.setColumns(10);
		
		separator_5 = new JSeparator();
		separator_5.setForeground(new Color(0, 0, 0));
		separator_5.setBackground(new Color(0, 0, 0));
		separator_5.setBounds(0, 30, 283, 2);
		panel_5.add(separator_5);
		
		table = new JTable();
		table.setShowGrid(false);
		me.vTabla3(table);
		table.getTableHeader().setBackground(new Color(41,41,41));
		table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD,14));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.setBackground(Color.WHITE);
		table.setSelectionBackground(new Color(200,200,200));
		table.addMouseListener(this);
		table.setDefaultEditor(Object.class, null);
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);
		sql.tablaReceta(table, me.modelo);
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
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == cerrar) {
			cerrar.setForeground(new Color(255,255,255));
			cerrar.setBackground(new Color(255,0,0));
		}
		if(e.getSource() == minimizar) {
			minimizar.setForeground(new Color(255,255,255));
			minimizar.setBackground(new Color(60,60,60));
		}
		if(e.getSource() == regresar) {
			regresar.setForeground(new Color(255,255,255));
			regresar.setBackground(new Color(60,60,60));
		}
		if(e.getSource() == bCrear) {
			bCrear.setBackground(new Color(60,60,60));
			
		}
		if(e.getSource() == bModificar) {
			bModificar.setBackground(new Color(60,60,60));
			
		}
		if(e.getSource() == bBorrar) {
			bBorrar.setBackground(new Color(60,60,60));
			
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == regresar) {
			regresar.setForeground(new Color(200,200,200));
			regresar.setBackground(new Color(41,41,41));
		}
		if(e.getSource() == cerrar) {
			cerrar.setForeground(new Color(200,200,200));
			cerrar.setBackground(new Color(41,41,41));
		}
		if(e.getSource() == minimizar) {
			minimizar.setForeground(new Color(200,200,200));
			minimizar.setBackground(new Color(41,41,41));
		}
		if(e.getSource() == bCrear) {
			bCrear.setBackground(new Color(41,41,41));
			
		}
		if(e.getSource() == bModificar) {
			bModificar.setBackground(new Color(41,41,41));
			
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
			            /*tfNombre.setText(table.getValueAt(fila,0).toString());
			            textArea.setText(table.getValueAt(fila,1).toString());		           
			            
			          
			            bModificar.setEnabled(true);
			            bCrear.setEnabled(false);
			            bBorrar.setEnabled(true);*/
			        	variable = table.getValueAt(fila, 1).toString();
			        	fil=table.getSelectedRow();
			        	sql.mostrarReceta(textArea, tfNombre, variable);
			            bCrear.setEnabled(false);
			            bBorrar.setEnabled(true);
			            bModificar.setEnabled(true);
			            
			           // variable=producto.getText();
			            
			        }
			        else{
			            JOptionPane.showMessageDialog(null,"No se ha seleccionado una fila");
			        }
			        
			        
				}else {
					int row1;
					row1=table.getSelectedRow();
					table.getSelectionModel().removeSelectionInterval(row1, row1);
					tfNombre.setText(null);
					textArea.setText(null);
					bCrear.setEnabled(true);
					bModificar.setEnabled(false);
					bBorrar.setEnabled(false);

					}
				
		}
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == regresar) {
			InterfazPanadero in1 = new InterfazPanadero();
			in1.setVisible(true);
			this.setVisible(false);
			
		}

		if(e.getSource() == minimizar) {
			this.setExtendedState(ICONIFIED);
			
		}
		
		if(e.getSource() == cerrar) {
			
			System.exit(0);
		}
		if(e.getSource() == bCrear) {
			sql.insertarReceta(tfNombre, textArea);
			tfNombre.setText(null);
			textArea.setText(null);
			sql.tablaReceta(table, me.modelo);
		}
		if(e.getSource() == bModificar) {
			sql.modificarReceta(textArea, tfNombre, variable);
			sql.tablaReceta(table, me.modelo);
			tfNombre.setText(null);
			textArea.setText(null);
			bCrear.setEnabled(true);
			bBorrar.setEnabled(false);
			bModificar.setEnabled(false);
		}
		if(e.getSource() == bBorrar) {
			sql.borrarReceta(fil, variable);
			sql.tablaReceta(table, me.modelo);
			tfNombre.setText(null);
			textArea.setText(null);
			bCrear.setEnabled(true);
			bBorrar.setEnabled(false);
			bModificar.setEnabled(false);
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getSource() == tfBuscador) {
			sql.buscarReceta(me.modelo, tfBuscador.getText(), table);
			
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
