package metodos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import interfaces.InterfazRec;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * 
 * @author EQUIPO 4 TPOO
 *
 */

public class Metodos extends JFrame {
	
	int xx, xy;
	public DefaultTableModel modelo = new DefaultTableModel();
	public DefaultTableModel modelo2 = new DefaultTableModel();
	public DefaultTableModel modelo3 = new DefaultTableModel();
	//arg0 = null;
	public void vLMostrarIMG(JLabel label, String ubicacion) {
	ImageIcon icon = new ImageIcon(getClass().getResource(ubicacion));
	ImageIcon img = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_AREA_AVERAGING ));
	label.setIcon(img);
	
	}
	
	public void vBMostrarIMG(JButton boton, String ubicacion) {
		
	ImageIcon icono = new ImageIcon(getClass().getResource(ubicacion));
	ImageIcon imge = new ImageIcon(icono.getImage().getScaledInstance(boton.getWidth(),boton.getHeight(), Image.SCALE_AREA_AVERAGING ));
	boton.setIcon(imge);
	}
	

	/**
	 * 
	 * @param Inventario - Genera la tabla de inventario 
	 */
	
	public void vTabla(JTable tabla) {
        
        modelo.addColumn("Id");
        modelo.addColumn("Articulo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Tipo");
        modelo.addColumn("Peso");
        modelo.addColumn("Unidades");
        
        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(5);
		
	}
	
	/**
	 * 
	 * @param Empleados - Genera la tabla de empleados
	 */
	
	public void vTabla2(JTable tabla) {
        modelo.addColumn("Id");
        modelo.addColumn("Empleado");
        modelo.addColumn("Puesto");
        modelo.addColumn("CURP");
        modelo.addColumn("RFC");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Edad");
        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(5);
        //tabla.getColumnModel().getColumn(4).setPreferredWidth(15);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(3);
		
	}
	
	/**
	 * 
	 * @param Recetas - Genera la tabla de recetas
	 */

	public void vTabla3(JTable tabla) {
		
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        
        
        tabla.setModel(modelo);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(5);
		
		
		
		
	}
	
	/**
	 * 
	 * @param Inventario - Genera la tabla de inventario en la interfaz de productos del panadero
	 */
	
	public void tablaInventario2(JTable tabla) {
		
		
		modelo2.addColumn("ID");
		modelo2.addColumn("Articulo");
		modelo2.addColumn("Tipo");
		modelo2.addColumn("Peso");
		modelo2.addColumn("Cantidad");
		
		tabla.setModel(modelo2);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(5);
	}
	
	/**
	 * 
	 * @param Productos - Genera la tabla de productos
	 */
	
	public void tablaProductos(JTable tabla) {
		modelo3.addColumn("ID");
		modelo3.addColumn("Producto");
		modelo3.addColumn("Descripcion");
		modelo3.addColumn("Cantidad");
		modelo3.addColumn("Precio");
		
		tabla.setModel(modelo3);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(5);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(5);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(5);
	}
	
	/**
	 * 
	 * @param Facturas - Genera la tabla de facturas
	 */
	
	public void tablaVenta(JTable tabla) {
		modelo.addColumn("ID");
		modelo.addColumn("Producto");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio");
		modelo.addColumn("Total");
				
		tabla.setModel(modelo);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(5);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(5);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(5);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(5);
	}
	
	/**
	 * Agrega una nueva venta a la Tabla
	 * @param tablaP - Es la nueva tabla con los datos agregados
	 * @param tablaS - Es la tabla anterior que será modificada
	 * @param fila - La nueva fila
	 *  
	 * 
	 * @param modelo - Modelo de la tabla
	 */
	
	public void agregrarVenta(JTable tablaP, JTable tablaS, int fila, int cantidad, float total, DefaultTableModel modelo) {
		DecimalFormat df = new DecimalFormat("#.00");
		total = Float.parseFloat(df.format(total));
		String datos[] = new String[5];
		datos[0] = tablaS.getValueAt(fila, 0).toString();
		datos[1] = tablaS.getValueAt(fila, 1).toString();
		datos[2] = String.valueOf(cantidad);
		datos[3] = tablaS.getValueAt(fila, 4).toString();
		datos[4] = String.valueOf(total);
		
		modelo.addRow(datos);
		
		tablaP.setModel(modelo);
		
	}
	
	/**
	 * 
	 * @param tablaP - Tabla Productos de Venta?
	 * @return - Devuelve el total de la venta?
	 */
	
	public float calcularTotal(JTable tablaP) {
		int filas = tablaP.getRowCount();
		float tot=0;
		for(int i=0;i<filas;i++) {
			tot += Float.parseFloat(tablaP.getValueAt(i, 4).toString());						
						
		}
		
		return tot;
	}
	
	/**
	 * 
	 * @param seleccionar - Selecciona la fila del producto en Ventas para que sea eliminada?
	 * 
	 * 
	 */
	
	
	public int seleccionarFila(JTable tablaP, JTable tablaS) {
		int i = tablaP.getSelectedRow();
		int id = Integer.parseInt(tablaP.getValueAt(i, 0).toString());
		int cantidadtot=0;
		int e=tablaS.getRowCount();
		for(int j=0;j<e;j++) {
			if(id == Integer.parseInt(tablaS.getValueAt(j, 0).toString())) {
				
				cantidadtot= Integer.parseInt(tablaS.getValueAt(j, 3).toString());
				
			}
			
			
		}
		
		return cantidadtot;
		
		
	}
	
	/**
	 * 
	 * @param Cantidad Total - Devuelve la cantidad total de la venta?
	 * 
	 * 
	 * 
	 */
	
	public int cantTot(JTable tablaP, JTable tablaS, int i) {
		

		int in = tablaP.getSelectedRow();
		
		int id = Integer.parseInt(tablaP.getValueAt(i, 0).toString());
		int cantidadtot=0;
		int e=tablaS.getRowCount();
		for(int j=0;j<e;j++) {
			if(id == Integer.parseInt(tablaS.getValueAt(j, 0).toString())) {
				
				cantidadtot= Integer.parseInt(tablaS.getValueAt(j, 3).toString());
				
			}
			
			
		}
		
		return cantidadtot;
	}
	
	/**
	 * 
	 * @param Factura - Genera la tabla de factura 
	 */
	
	public void tablaFactura(JTable tabla) {
		modelo3.addColumn("Factura");
		modelo3.addColumn("Cliente");
		modelo3.addColumn("Empleado");
		modelo3.addColumn("Total");
		modelo3.addColumn("Efectivo");
		modelo3.addColumn("Cambio");
		modelo3.addColumn("Fecha");
		tabla.setModel(modelo3);
		
		tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(0);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(0);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(0);
		tabla.getColumnModel().getColumn(5).setPreferredWidth(0);
		tabla.getColumnModel().getColumn(6).setPreferredWidth(20);
	}

}
