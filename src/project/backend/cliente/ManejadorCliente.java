/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.backend.cliente;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import project.backend.basedatos.ManejadorBaseDatos;

/**
 *
 * @author fabricio
 */
public class ManejadorCliente {
    
    private static ManejadorCliente INSTANCE = null;
    private SimpleDateFormat fechaFormat = null;

    private ManejadorCliente() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorCliente();
        }
    }

    public static ManejadorCliente getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }
    
    public List getClientes(){
        String consulta = "SELECT * FROM CLIENTE";
        return ManejadorBaseDatos.getInstance().getCliente(consulta, null, 0);
    }
    
    public List getClientesByName(String nombre){
        String consulta = "SELECT * FROM CLIENTE WHERE NOMBRE = ?";
        return ManejadorBaseDatos.getInstance().getCliente(consulta, nombre, 1);
    }
    
    public List getClientesByDPI(String dpi){
        String consulta = "SELECT * FROM CLIENTE WHERE DPI = ?";
        return ManejadorBaseDatos.getInstance().getCliente(consulta, dpi, 1);
    }
    
    public Cliente getClienteByDPI(String dpi){
        String consulta = "SELECT * FROM CLIENTE WHERE DPI = ?";
        return ManejadorBaseDatos.getInstance().getCliente(consulta, dpi);
    }
    
    public void crearCliente(String dpi, String nombre, String direccion, String telefono) throws Exception{
        if(dpi.isEmpty() || nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty()){
            throw new Exception("Hay datos sin llenar, intentelo de nuevo");
        } else if(nombre.length() > 40 || direccion.length() > 30){
            throw new Exception("Ha superado el maximo de caracteres validos");
        } else if(getClienteByDPI(dpi) != null){
            throw new Exception("Ingrese de nuevo el DPI, pues ya existe");
        } else {
            String accion = "INSERT INTO CLIENTE (DPI,NOMBRE,DIRECCION,TELEFONO) VALUES (?,?,?,?)";
            Cliente cliente = new ClienteBuilder().dpi(Integer.parseInt(dpi)).nombre(nombre).
                    direccion(direccion).telefono(Integer.parseInt(telefono)).build();
            ManejadorBaseDatos.getInstance().setCliente(accion, cliente);
            JOptionPane.showMessageDialog(null, "Se ha creado exitosamente el cliente '" + nombre + "'", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void updateCliente(Cliente cliente, String nombre, String telefono) throws Exception{
        if(nombre.isEmpty() || telefono.isEmpty()){
            throw new Exception("Hay datos sin llenar, intentelo de nuevo");
        } else if(nombre.length() > 40 ){
            throw new Exception("Ha superado el maximo de caracteres validos (20)");
        } else {
            cliente.setNombre(nombre);
            cliente.setTelefono(Integer.parseInt(telefono));
            String accion = "UPDATE CLIENTE SET NOMBRE = ?, TELEFONO = ? WHERE DPI = ?";
            JOptionPane.showMessageDialog(null, "Se ha Modificado exitosamente el cliente'" + nombre + "'", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
            ManejadorBaseDatos.getInstance().updateCliente(accion, cliente);
        }
    }
    
}
