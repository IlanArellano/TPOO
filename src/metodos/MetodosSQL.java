package metodos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.HashMap;
import java.lang.Object;
import org.apache.commons.logging.*;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sun.javafx.collections.MappingChange.Map;
import net.sf.jasperreports.data.DataAdapterParameterContributorExtensionsRegistryFactory;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * 
 * @author EQUIPO 4 TPOO
 *
 */

public class MetodosSQL {
	
	/**
	 * Se crea la instancia de la conexion con nuestra base de datos
	 */
	
	ConexionSQL con = new ConexionSQL();
	DefaultTableModel modelo = new DefaultTableModel();
	
	/**
	 * 
	 * @param Tabla - Hacemos la consulta para traer los datos de inventario de nuestra DB
	 * 
	 */
	
	public void Tabla(JTable tabla, DefaultTableModel modelo) {
		
		
		Connection cn = con.conexion();
		try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM inventario"  );
            String datos[] = new String [6];
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5] = rs.getString(6);
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
            
           
           st.close();
           rs.close();
           
        } catch (SQLException ex) {
            //Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Ocurrio un error");
        }
		
		con.Desconectar();
		
		
		
	}
	
	/**
	 * 
	 * @param tablaOriginal - Hacemos la consulta para traer los datos de inventario de nuestra DB
	 * 
	 */
	
	/*--------------------------------------------------------------------I N V E N T A R I O--------------------------------------------------------------------*/ 
	public void tablaOriginal(JTable tabla, DefaultTableModel mod) {
		Connection cn = con.conexion();
		
		
		try {
		
		Statement st = cn.createStatement();	
		ResultSet rs = st.executeQuery("SELECT * FROM inventario");
		String datos[] = new String [6];	
		mod.setRowCount(0);
		while(rs.next()) {
			datos[0] = rs.getString(1);
			datos[1] = rs.getString(2);
			datos[2] = rs.getString(3);
			datos[3] = rs.getString(4);
			datos[4] = rs.getString(5);
			datos[5] = rs.getString(6);
			
			mod.addRow(datos);
			
		}
		tabla.setModel(mod);
		st.close();
		rs.close();
		}catch (SQLException e) {
		
		e.printStackTrace();
	}
		con.Desconectar();
		
	}
	
	
	/**
	 * 
	 * @param tablaParametros - Hacemos la consulta para traer los parametros de inventario a nuestra DB
	 * 
	 */
	
	
	
	public void tablaParametros(JTable tabla, JCheckBox caja, DefaultTableModel mod) {
		Connection cn = con.conexion();
		String datos[] = new String[6];
		
		
		String parametro = caja.getText();
		
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM inventario WHERE tipo = '" + parametro +  "'");
			mod.setRowCount(0);
			while(rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);
				datos[4] = rs.getString(5);
				datos[5] = rs.getString(6);
				mod.addRow(datos);
				
			}
			tabla.setModel(mod);
			st.close();
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}								
		con.Desconectar();
	
	
	}
	
	/**
	 * 
	 * @param insertarDatos - Agregamos datos al nuestro inventario a nuestra BD y despues actualizamos la tabla
	 * 
	 */

	public void insertarDatos(JTextField producto, JTextField descripcion, JRadioButton masa, JRadioButton liquido, JTextField peso, JTextField unidades, JTable tabla,DefaultTableModel modelo) {
		Connection cn = con.conexion();
		try {
			PreparedStatement pps = cn.prepareStatement("INSERT INTO inventario(nom_art, des_art, tipo_art, peso_art , unidades_art) VALUES(?,?,?,?,?)");
			pps.setString(1, producto.getText());
			pps.setString(2, descripcion.getText() );
			if(masa.isSelected()) {
				
				pps.setString(3,"Masa");
			}
			
			else if(liquido.isSelected()) {
				
				pps.setString(3,"Liquido");
			}				
			
			pps.setString(4, peso.getText());	
			pps.setString(5, unidades.getText());
			pps.executeUpdate();
			pps.close();

			

		} catch (SQLException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Los campos no fueron llenados");
			
		}											
		
		
		try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM inventario"  );
            String datos[] = new String [6];
            modelo.setRowCount(0);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
            
           
           st.close();
           rs.close();
           
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"Ocurrio un error");
        }
		con.Desconectar();
	}
	
	/**
	 * 
	 * @param buscarDatos - Busca informacion de un producto del inventario?
	 * 
	 */

	public void buscarDatos(DefaultTableModel modelo, String dato, JTable tabla) {
		Connection cn = con.conexion();
		String datos[] = new String[6];

		

		try {
			Statement st = cn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM inventario WHERE nom_art LIKE '%" + dato + "%' or tipo_art LIKE '%" + dato + "%' ");				
			modelo.setRowCount(0);
			while(rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);
				datos[4] = rs.getString(5);
				datos[5] = rs.getString(6);
				modelo.addRow(datos);
				
			}
			tabla.setModel(modelo);
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			con.Desconectar();
		
		
	}
	
	/**
	 * 
	 * @param buscarDatos - Busca informacion de un producto del inventario?
	 * 
	 */
	
	public void buscarDatos2(DefaultTableModel modelo, String dato, JTable tabla) {
		Connection cn = con.conexion();
		String datos[] = new String[4];

		

		try {
			Statement st = cn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM inventario WHERE nom_art LIKE '%" + dato + "%' or tipo_art LIKE '%" + dato + "%' ");				
			modelo.setRowCount(0);
			while(rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(4);
				datos[3] = rs.getString(6);

				modelo.addRow(datos);
				
			}
			tabla.setModel(modelo);
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			con.Desconectar();
		
		
	}
	
	/**
	 * 
	 * @param modificarDatos - Actualiza un producto en inventario
	 * 
	 */

	public void modificarDatos(JTextField articulo, JTextField descripcion, JTextField peso, JTextField unidades, String nombre) {
		Connection cn = con.conexion();
		
		try {
				
	            PreparedStatement pps = cn.prepareStatement("UPDATE inventario SET nom_art ='" + articulo.getText()+"', des_art = '" + descripcion.getText()+"',peso_art='"+peso.getText()+"',unidades_art='"+unidades.getText()+"'WHERE id_art='"+ nombre +"';");
	            pps.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Registro modificado");
	            
	            pps.close();
	        } catch (SQLException ex) {

	            //Logger.getLogger(Negocio1.class.getName()).log(Level.SEVERE, null, ex);
	            JOptionPane.showMessageDialog(null, ex);
	        }
		con.Desconectar();
	}
	
	/**
	 * 
	 * @param borrarDatos - Borra articulo del inventario
	 * 
	 */
	
	public void borrarDatos(int fila, String valor) {
		if(fila>=0) {
			Connection cn = con.conexion();
			try {
				PreparedStatement pps = cn.prepareStatement("DELETE FROM inventario WHERE id_art ='" + valor + "'");
				pps.executeUpdate();
				JOptionPane.showMessageDialog(null,"Articulo dado de baja");
				pps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				
			
			con.Desconectar();
		}
	}
	
	/**
	 * 
	 * @param tablaInv2 - Hacemos la consulta para traer los parametros de inventario a nuestra DB
	 * 
	 */
	
	public void tablaInv2(JTable tabla, DefaultTableModel mod) {
		Connection cn = con.conexion();
		
		
		try {
		
		Statement st = cn.createStatement();	
		ResultSet rs = st.executeQuery("SELECT * FROM inventario");
		String datos[] = new String [5];	
		mod.setRowCount(0);
		while(rs.next()) {
			datos[0] = rs.getString(1);
			datos[1] = rs.getString(2);
			datos[2] = rs.getString(4);
			datos[3] = rs.getString(5);
			datos[4] = rs.getString(6);
			
			mod.addRow(datos);
			
		}
		tabla.setModel(mod);
		st.close();
		rs.close();
		}catch (SQLException e) {
		
		e.printStackTrace();
	}
		con.Desconectar();
		
		
	}
	
	/**
	 * 
	 * @param modificarCantidad - Hacemos la consulta para traer un articulo de inventario con su ID para actualizarlo
	 * 
	 */
	
	public void modificarCantidad(float total, String id, float total1, float peso) {
		Connection cn = con.conexion();
		float cantidad = 1;
		try {
			
			Statement st = cn.createStatement();	
			ResultSet rs = st.executeQuery("SELECT * FROM inventario WHERE id_art ='" + id +  "'");
				
			
			while(rs.next()) {
				
				cantidad = rs.getFloat(5);
				
			}
			
			st.close();
			rs.close();
			}catch (SQLException e) {
			
			e.printStackTrace();
		}
		total = total / cantidad; 
		total1 = total1 - total;
		try {
				
	            PreparedStatement pps = cn.prepareStatement("UPDATE inventario SET unidades_art ='"+ total1 + "'WHERE id_art='"+ id +"';");
	            pps.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Registro modificado");
	            
	            pps.close();
	        } catch (SQLException ex) {

	            //Logger.getLogger(Negocio1.class.getName()).log(Level.SEVERE, null, ex);
	            JOptionPane.showMessageDialog(null, ex);
	        }
		con.Desconectar();
		
	}
	/*--------------------------------------------------------------------E M P L E A D O S--------------------------------------------------------------------*/                                
	
	/**
	 * 
	 * @param insertarEmpleados - Permite insertar empleados a la DB y actualizarlos en tabla
	 * 
	 */
	
	public void insertarEmpleados(JTextField empleado, JComboBox combo, JTextField curp, JTextField rfc, JTextField direccion, JTextField telefono, JTextField edad) {
		Connection cn = con.conexion();
		try {
			PreparedStatement pps = cn.prepareStatement("INSERT INTO empleados(nom_emp, puesto_emp, curp_emp, rfc_emp , dir_emp, tel_emp,edad_emp) VALUES(?,?,?,?,?,?,?)");
			pps.setString(1, empleado.getText());
			pps.setString(2, combo.getSelectedItem().toString() );
			pps.setString(3, curp.getText());			
			pps.setString(4, rfc.getText());	
			pps.setString(5, direccion.getText());
			pps.setString(6, telefono.getText());
			pps.setString(7, edad.getText());
			pps.executeUpdate();
			pps.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Los campos no fueron llenados");
			
		}											
		
		con.Desconectar();
	}
	
	/**
	 * 
	 * @param tablaParametros - Pinta la tabla de empleados con nuestra DB
	 * 
	 */
	public void tablaEmpleados(JTable tabla, DefaultTableModel modelo) {
		Connection cn = con.conexion();
		String datos[] = new String [8];
		
		try {
		Statement st = cn.createStatement();	
		ResultSet rs = st.executeQuery("SELECT * FROM empleados");
		modelo.setRowCount(0);
		while(rs.next()) {
			datos[0] = rs.getString(1);
			datos[1] = rs.getString(2);
			datos[2] = rs.getString(3);
			datos[3] = rs.getString(4);
			datos[4] = rs.getString(5);
			datos[5] = rs.getString(6);
			datos[6] = rs.getString(7);
			datos[7] = rs.getString(8);
			modelo.addRow(datos);
			
		}
		tabla.setModel(modelo);
		st.close();
		rs.close();
		}catch (SQLException e) {
		
		e.printStackTrace();
	}
		con.Desconectar();
		
		
		
	}
	

	public void buscarEmpleados(DefaultTableModel modelo, String dato, JTable tabla) {
		Connection cn = con.conexion();
		String datos[] = new String[8];

		

		try {
			Statement st = cn.createStatement();
			
			//ResultSet rs = st.executeQuery("SELECT * FROM empleados WHERE nom_emp LIKE '%" + dato + "%'");		
			ResultSet rs = st.executeQuery("SELECT * FROM empleados WHERE nom_emp LIKE '%" + dato + "%'");
			modelo.setRowCount(0);
			while(rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);
				datos[4] = rs.getString(5);
				datos[5] = rs.getString(6);
				datos[6] = rs.getString(7);
				datos[7] = rs.getString(8);
				modelo.addRow(datos);
				
			}
			tabla.setModel(modelo);
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			con.Desconectar();
		
		
	}
	
	
	public void modificarEmpleados(JTextField nom, JComboBox combo, JTextField curp, JTextField rfc, JTextField dir, JTextField tel, JTextField edad,String id) {
			Connection cn = con.conexion();
		
			try {
				
	            PreparedStatement pps = cn.prepareStatement("UPDATE empleados SET nom_emp ='" + nom.getText()+"', puesto_emp ='" + combo.getSelectedItem().toString()+"',curp_emp='"+curp.getText()+"',rfc_emp='"+rfc.getText()+"', dir_emp ='" +dir.getText()+ "', tel_emp='" + tel.getText() +"', edad_emp ='" +edad.getText() +"'WHERE id_emp='"+ id +"';");
	            pps.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Registro modificado");
	            
	            pps.close();
	        } catch (SQLException ex) {

	            //Logger.getLogger(Negocio1.class.getName()).log(Level.SEVERE, null, ex);
	            JOptionPane.showMessageDialog(null, ex);
	        }
			con.Desconectar();
	}

	public void borrarEmpleados(int fila, String valor) {
		if(fila>=0) {
			Connection cn = con.conexion();
			try {
				PreparedStatement pps = cn.prepareStatement("DELETE FROM empleados WHERE id_emp ='" + valor + "'");
				pps.executeUpdate();
				pps.close();
				JOptionPane.showMessageDialog(null,"Empleado dado de baja");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				
			
			con.Desconectar();
			
			
					
		}
		
	}
	
	/**
	 * 
	 * @param loginEmpleados - Inicio de sesion para los empleados, si se cumple devuelve true para posteriormente mostrar el menu principal
	 * 
	 */	
	
	public boolean loginEmpleado(String puesto, String nombre, String id) {
		Connection cn = con.conexion();
		boolean dato=false;
		try {
			Statement st = cn.createStatement();	
			ResultSet rs = st.executeQuery("SELECT * FROM empleados");
			
			while(rs.next()) {
				if(id.equals(rs.getString(1)) && puesto.equals(rs.getString(3)) && nombre.equals(rs.getString(2))) {
					
					dato=true;
					
				}
				
				
				
			}
			
			st.close();
			rs.close();
			}catch (SQLException e) {
			
			e.printStackTrace();
		}
			con.Desconectar();
		
		return dato;
	}
	
	public void empleadoID(String nombre) {
		Connection cn = con.conexion();
		try {
			Statement st = cn.createStatement();	
			ResultSet rs = st.executeQuery("SELECT * FROM empleados");
			
			while(rs.next()) {
				/*if(puesto.equals(rs.getString(3)) && nombre.equals(rs.getString(2))) {
					
					dato=true;
					
				}*/
				
				
				
			}
			
			st.close();
			rs.close();
			}catch (SQLException e) {
			
			e.printStackTrace();
		}
			con.Desconectar();
		
	}

	public String buscarEmpleado(int id) {
		Connection cn = con.conexion();
		String nombre="";
		
		try {
		Statement st = cn.createStatement();	
		ResultSet rs = st.executeQuery("SELECT * FROM empleados WHERE id_emp='" + id + "'");
		
		while(rs.next()) {
			nombre = rs.getString(2);
		
		}
		
		st.close();
		rs.close();
		}catch (SQLException e) {
		
		e.printStackTrace();
	}
		con.Desconectar();
		
		return nombre;
	}
	/*--------------------------------------------------------------------R E C E T A S--------------------------------------------------------------------*/    

	
	public void insertarReceta(JTextField nom, JTextArea area) {
		Connection cn = con.conexion();
		
		try {
			PreparedStatement pps = cn.prepareStatement("INSERT INTO recetas( nom_rec, ing_rec) VALUES(?,?)");
			pps.setString(1, nom.getText());
			pps.setString(2, area.getText() );

			pps.executeUpdate();
			pps.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Los campos no fueron llenados");
			
		}											
		
		con.Desconectar();
		
		
	}
	
	/**
	 * 
	 * @param tabalaReceta - Pinta la tabla de recetas con los datos de nuestra DB
	 * 
	 */

	public void tablaReceta(JTable tabla, DefaultTableModel modelo) {
		Connection cn = con.conexion();
		String datos[] = new String [2];
		
		try {
		Statement st = cn.createStatement();	
		ResultSet rs = st.executeQuery("SELECT * FROM recetas");
		modelo.setRowCount(0);
		while(rs.next()) {
			datos[0] = rs.getString(1);
			datos[1] = rs.getString(2);

			modelo.addRow(datos);
			
		}
		tabla.setModel(modelo);
		st.close();
		rs.close();
		}catch (SQLException e) {
		
		e.printStackTrace();
	}
		con.Desconectar();
		
		
	}
	
	public void mostrarReceta(JTextArea area, JTextField nom,String dato) {
		Connection cn = con.conexion();
		String datos[] = new String [2];
		
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM recetas WHERE nom_rec  LIKE '%" + dato + "%'");
			
			while(rs.next()) {
				/*datos[0] = rs.getString(2);
				datos[1] = rs.getString(3);*/
				
				nom.setText(rs.getString(2));
				area.setText(rs.getString(3));
				
			}
			
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
		
		
	}

	public void modificarReceta(JTextArea area, JTextField nom, String valor) {
		Connection cn = con.conexion();
		try {
			PreparedStatement pps = cn.prepareStatement("UPDATE recetas SET nom_rec ='"+ nom.getText() + "', ing_rec ='" + area.getText() + "' WHERE nom_rec='" + valor + "';");
			pps.executeLargeUpdate();
			JOptionPane.showMessageDialog(null, "Registro modificado");
			pps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		con.Desconectar();
		
	}
	
	public void borrarReceta(int fila, String valor) {
		if(fila>=0) {
			Connection cn = con.conexion();
			try {
				PreparedStatement pps = cn.prepareStatement("DELETE FROM recetas WHERE nom_rec='" + valor + "'");
				pps.executeUpdate();
				pps.close();
				JOptionPane.showMessageDialog(null,"Receta eliminada");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			con.Desconectar();
			
		}
	}

	public void buscarReceta(DefaultTableModel modelo, String dato, JTable tabla) {
		Connection cn = con.conexion();
		String datos[] = new String[2];
		
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM recetas WHERE nom_rec LIKE '%" + dato + "%'");
			modelo.setRowCount(0);
			while(rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);

				modelo.addRow(datos);
				
			}
			tabla.setModel(modelo);
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		con.Desconectar();
	}
	
	
	/*--------------------------------------------------------------------C L I E N T E S--------------------------------------------------------------------*/ 
	public int insertarCliente(int id) {
		Connection cn = con.conexion();
		int id_cli=0;
		try {
			PreparedStatement pps = cn.prepareStatement("INSERT INTO cliente( empleados_id_emp) VALUES(?)");
			pps.setString(1, String.valueOf(id));
			

			pps.executeUpdate();
			pps.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Los campos no fueron llenados");
			
		}	
		try {
			Statement st = cn.createStatement();	
			//ResultSet rs = st.executeQuery("SELECT MAX(id_cliente) FROM cliente");
			ResultSet rs = st.executeQuery("SELECT * FROM cliente ORDER BY id_cliente DESC");
			while(rs.next()) {
				
				if(rs.isFirst())
				id_cli = rs.getInt(1);
				
				
			}
			
			st.close();
			rs.close();
			}catch (SQLException e) {
			
			e.printStackTrace();
		}
		con.Desconectar();
		return id_cli;
	}
	
	/*--------------------------------------------------------------------D E T A L L E  C P-------------------------------------------------------------------*/ 
	
	public void insertarDetalle(JTable tabla,int id_cli,int id_pro,String pro, int cantidad, float precio, float total) {
		Connection cn = con.conexion();		
			try {
				PreparedStatement pps = cn.prepareStatement("INSERT INTO cliente_has_producto(cliente_id_cliente, producto_id_pro,producto ,cantidad, precio, total) VALUES(?,?,?,?,?,?)");
				pps.setString(1, String.valueOf(id_cli));
				pps.setString(2, String.valueOf(id_pro));
				pps.setString(3, pro);
				pps.setString(4, String.valueOf(cantidad));
				pps.setString(5, String.valueOf(precio));
				pps.setString(6, String.valueOf(total));

				pps.executeUpdate();
				pps.close();
				

			} catch (SQLException e) {
				
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Los campos no fueron llenados");
				
			}		
		con.Desconectar();	
		
	}
	
	/*--------------------------------------------------------------------F A C T U R A-------------------------------------------------------------------*/ 
	public int insertarFactura(int cliente, int empleado, float total, float efectivo, float cambio, Timestamp tiempo) {
		Connection cn = con.conexion();		
		int id_cli=0;
		try {
			PreparedStatement pps = cn.prepareStatement("INSERT INTO factura(cliente_id_cliente, cliente_empleados_id_emp, total, efectivo, cambio, fecha) VALUES(?,?,?,?,?,?)");
			pps.setInt(1, cliente);
			pps.setInt(2, empleado);
			pps.setFloat(3, total);
			pps.setFloat(4, efectivo);
			pps.setFloat(5, cambio);
			pps.setTimestamp(6, tiempo, Calendar.getInstance());

			pps.executeUpdate();
			pps.close();
			

		} catch (SQLException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Los campos no fueron llenados");
			
		}	
		try {
			Statement st = cn.createStatement();	
			//ResultSet rs = st.executeQuery("SELECT MAX(id_fac) FROM factura");
			//ResultSet rs = st.executeQuery("SELECT FROM factura WHERE id_fac = (SELECT MAX(id_fac) FROM factura");
			ResultSet rs = st.executeQuery("SELECT * FROM factura ORDER BY id_fac DESC");
			while(rs.next()) {
				
				if(rs.isFirst()) {
					id_cli = rs.getInt(1);
					
				}
				
				
				
			}
			
			st.close();
			rs.close();
			}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		con.Desconectar();
		return id_cli;
		
		
		
	}
	
	/**
	 * 
	 * @param tabalaReceta - Pinta la tabla de Facturas con los datos de nuestra DB
	 * 
	 */
	
	public void tablaFacturas(JTable tabla, DefaultTableModel modelo) {
		Connection cn = con.conexion();
		String datos[] = new String [7];
		
		try {
		Statement st = cn.createStatement();	
		ResultSet rs = st.executeQuery("SELECT * FROM factura");
		modelo.setRowCount(0);
		while(rs.next()) {
			datos[0] = rs.getString(1);
			datos[1] = rs.getString(2);
			datos[2] = rs.getString(3);
			datos[3] = rs.getString(4);
			datos[4] = rs.getString(5);
			datos[5] = rs.getString(6);
			datos[6] = rs.getString(7);
			modelo.addRow(datos);
			
		}
		tabla.setModel(modelo);
		st.close();
		rs.close();
		}catch (SQLException e) {
		
		e.printStackTrace();
	}
		con.Desconectar();
	}
	
	public void buscarFacturas(JTable tabla, String dato, DefaultTableModel modelo) {
		Connection cn = con.conexion();
		String datos[] = new String[7];
		
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM factura WHERE id_fac LIKE '%" + dato + "%' OR cliente_id_cliente LIKE '%" + dato + "' OR cliente_empleados_id_emp LIKE'" + dato + "'");
			modelo.setRowCount(0);
			while(rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);
				datos[4] = rs.getString(5);
				datos[5] = rs.getString(6);
				datos[6] = rs.getString(7);

				modelo.addRow(datos);
				
			}
			tabla.setModel(modelo);
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		con.Desconectar();
	}
	
	
	
	/*--------------------------------------------------------------------P R O D U C T O S--------------------------------------------------------------------*/ 
	
	public void insertarProductos(JTextField producto, JTextField descripcion, JTextField unidades, JTextField precio) { //JTextField producto, JTextField descripcion, JTextField unidades, JTextField precio //String producto, String descripcion, int unidades, JTextField precio
		Connection cn = con.conexion();
		try {
			PreparedStatement pps = cn.prepareStatement("INSERT INTO producto(nom_pro, des_pro, uni_pro, pre_pro ) VALUES(?,?,?,?)");
			pps.setString(1, producto.getText());
			pps.setString(2, descripcion.getText());
			pps.setString(3, unidades.getText());			
			pps.setString(4, precio.getText());	
			pps.executeUpdate();
			pps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Los campos no fueron llenados");
			
		}											
		
		con.Desconectar();
		
	}
	
	/**
	 * 
	 * @param tabalaProductos - Pinta la tabla de Productos con los datos de nuestra DB
	 * 
	 */

	public void tablaProductos(JTable tabla, DefaultTableModel modelo) {
		Connection cn = con.conexion();
		String datos[] = new String [5];
		
		try {
		Statement st = cn.createStatement();	
		ResultSet rs = st.executeQuery("SELECT * FROM producto");
		modelo.setRowCount(0);
		while(rs.next()) {
			datos[0] = rs.getString(1);
			datos[1] = rs.getString(2);
			datos[2] = rs.getString(3);
			datos[3] = rs.getString(4);
			datos[4] = rs.getString(5);
			modelo.addRow(datos);
			
		}
		tabla.setModel(modelo);
		st.close();
		rs.close();
		}catch (SQLException e) {
		
		e.printStackTrace();
	}
		con.Desconectar();
		
		
	}

	public void eliminarProductos(int fila,int valor) {
		
			Connection cn = con.conexion();
			try {
				PreparedStatement pps = cn.prepareStatement("DELETE FROM producto WHERE id_pro='" + valor + "'");
				pps.executeUpdate();
				pps.close();
				JOptionPane.showMessageDialog(null,"Receta eliminada");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			con.Desconectar();
			
		
		
	}
	
	public void modificarProductos(JTextField producto, JTextField descripcion, JTextField cantidad, JTextField precio, int id) {
		Connection cn = con.conexion();
		
		try {
				
	            PreparedStatement pps = cn.prepareStatement("UPDATE producto SET nom_pro ='" + producto.getText()+"', des_pro = '" + descripcion.getText()+"',uni_pro='"+cantidad.getText()+"',pre_pro='"+precio.getText()+"'WHERE id_pro='"+ id +"';");
	            pps.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Registro modificado");
	            
	            pps.close();
	        } catch (SQLException ex) {

	            //Logger.getLogger(Negocio1.class.getName()).log(Level.SEVERE, null, ex);
	            JOptionPane.showMessageDialog(null, "Error al modificar el registro, los datos no se llenaron correctamente");
	        }
		con.Desconectar();
		
	}
	
	public void buscarProducto(DefaultTableModel modelo, String dato, JTable tabla) {
		Connection cn = con.conexion();
		String datos[] = new String[5];
		
		try {
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM producto WHERE nom_pro LIKE '%" + dato + "%' OR id_pro LIKE '%" + dato + "%'");
			modelo.setRowCount(0);
			while(rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);
				datos[4] = rs.getString(5);
				modelo.addRow(datos);
				
			}
			tabla.setModel(modelo);
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		con.Desconectar();	
		
	}
	
	public void actualizarProductos(int cantidadtot,int cantidad, int id, boolean estatus) {
		Connection cn = con.conexion();
		if(estatus == true) {
			cantidadtot = cantidadtot - cantidad;
			
		}else {
			cantidadtot = cantidadtot + cantidad;
		}
						
		try {
				
	            PreparedStatement pps = cn.prepareStatement("UPDATE producto SET uni_pro ='" + cantidadtot +"'WHERE id_pro='"+ id +"';");
	            pps.executeUpdate();
	           // JOptionPane.showMessageDialog(null, "Registro modificado");
	            
	            pps.close();
	        } catch (SQLException ex) {

	            //Logger.getLogger(Negocio1.class.getName()).log(Level.SEVERE, null, ex);
	            JOptionPane.showMessageDialog(null, "Error al modificar el registro, los datos no se llenaron correctamente");
	        }
		con.Desconectar();
		
		
	}
	
	/**
	 * 
	 * @param tabalaReceta - Pinta la tabla de productos con los datos de nuestra DB si existen unidades
	 * 
	 */
	
	public void tablaProductosIf(JTable tabla, DefaultTableModel modelo) {
		Connection cn = con.conexion();
		String datos[] = new String [5];
		
		try {
		Statement st = cn.createStatement();	
		ResultSet rs = st.executeQuery("SELECT * FROM producto WHERE uni_pro > 0");
		modelo.setRowCount(0);
		while(rs.next()) {
			datos[0] = rs.getString(1);
			datos[1] = rs.getString(2);
			datos[2] = rs.getString(3);
			datos[3] = rs.getString(4);
			datos[4] = rs.getString(5);
			modelo.addRow(datos);
			
		}
		tabla.setModel(modelo);
		st.close();
		rs.close();
		}catch (SQLException e) {
		
		e.printStackTrace();
	}
		con.Desconectar();
		
	}
	
	/**
	 * 
	 * @param Jasper - Genera la Factura
	 * 
	 */
	
	public void Jasper(String id, String total, String efectivo, String cambio, String idFac, String idEmp, Timestamp fecha) {
		try {
	        LocalDate hoy = LocalDate.now();
	        LocalTime ahora = LocalTime.now();
	        LocalDateTime fecha3 = LocalDateTime.of(hoy, ahora);
			
			JasperReport report = (JasperReport)JRLoader.loadObjectFromFile("C:\\Users\\Diego\\JaspersoftWorkspace\\PIA\\PIA.jasper");  
			java.util.Map<String, Object> parametros = new HashMap<String, Object>();						
			parametros.put("cliente", id);
			parametros.put("tot", total);
			parametros.put("efect", efectivo);
			parametros.put("cam", cambio );
			parametros.put("fac",idFac);
			parametros.put("emp", idEmp);
			parametros.put("fech",fecha);									
			JasperPrint print = JasperFillManager.fillReport(report, parametros, con.conexion());
			
			JasperViewer.viewReport(print, false);
			
		
		
		} catch (JRException e) {
			
			e.printStackTrace();
		}
	
		
		
		
		
		con.Desconectar();
	}

	
}
