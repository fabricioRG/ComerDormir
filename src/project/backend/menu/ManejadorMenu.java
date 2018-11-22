/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.backend.menu;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import project.backend.basedatos.ManejadorBaseDatos;
import project.backend.hotel.Hotel;
import project.backend.restaurante.Restaurante;

/**
 *
 * @author fabricio
 */
public class ManejadorMenu {
 
    private static ManejadorMenu INSTANCE = null;
    private SimpleDateFormat fechaFormat = null;

    private ManejadorMenu() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorMenu();
        }
    }

    public static ManejadorMenu getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }
    
    public void setMenu(String nombre, String descripcion, String tipo, String precio, String costo, Restaurante rest) throws Exception {
        if (nombre.isEmpty() || descripcion.isEmpty() || precio.isEmpty() || costo.isEmpty()) {
            throw new Exception("Ingrese todo los datos necesarios");
        } else if (nombre.length() > 20 || descripcion.length() > 100) {
            throw new Exception("El tamaño de las cadenas de 'Nombre' o 'Descripcion' superan el limite maximo");
        } else {
            String accion = "INSERT INTO MENU ( NOMBRE, DESCRIPCION, TIPO, PRECIO, COSTO, ID_RESTAURANTE,"
                    + "NOMBRE_RESTAURANTE) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            Menu menu = new MenuBuilder().nombre(nombre).descripcion(descripcion).tipo(tipo).precio(Double.parseDouble(precio)).
                    idRestaurante(rest.getId()).nombreRestaurante(rest.getNombre()).costo(Double.parseDouble(costo)).build();
            ManejadorBaseDatos.getInstance().setMenu(accion, menu);
            JOptionPane.showMessageDialog(null, "Se ha creado exitosamente un nuevo elemento en el menu",
                    "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public List getMenus() {
        String consulta = "SELECT * FROM MENU";
        return ManejadorBaseDatos.getInstance().getMenu(consulta, 0, null);
    }
    
    public List getMenusByRestaurante(Restaurante restaurante) {
        String consulta = "SELECT * FROM MENU WHERE ID_RESTAURANTE = ?";
        return ManejadorBaseDatos.getInstance().getMenu(consulta, 1, Integer.toString(restaurante.getId()));
    }
    
    public Menu getMenu(int idMenu) {
        String consulta = "SELECT * FROM MENU WHERE ID = ?";
        return ManejadorBaseDatos.getInstance().getMenu(consulta, idMenu);
    }

    public List getMenuByTipo(String tipo) {
        String consulta = "SELECT * FROM MENU WHERE TIPO = ?";
        return ManejadorBaseDatos.getInstance().getMenu(consulta, 1, tipo);
    }
    
    public void updateMenu(Menu menu, String nombre, String precio) throws Exception {
        if (nombre.isEmpty() || precio.isEmpty()) {
            throw new Exception("Ingrese los campos necesarios");
        } else if (nombre.length() > 20 || precio.contains("-")) {
            throw new Exception("Datos invalidos, intentelo de nuevo");
        } else {
            menu.setNombre(nombre);
            menu.setPrecio(Double.parseDouble(precio));
            String accion = "UPDATE MENU SET NOMBRE = ?, PRECIO = ? WHERE ID = ?";
            ManejadorBaseDatos.getInstance().updateMenu(accion, menu, 1);
            JOptionPane.showMessageDialog(null, "Se ha modificado correctamente el elemento con ID '" + 
                    menu.getId() + "'", "Accion Exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
