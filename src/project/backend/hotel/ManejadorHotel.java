package project.backend.hotel;

import java.util.List;
import javax.swing.JOptionPane;
import project.backend.basedatos.ManejadorBaseDatos;

/**
 *
 * @author fabricio
 */
public class ManejadorHotel {

    private static ManejadorHotel INSTANCE = null;

    private ManejadorHotel() {
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorHotel();
        }
    }

    public static ManejadorHotel getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public Hotel getHotelById(int id) {
        String consulta = "SELECT * FROM HOTEL WHERE ID = ?";
        return ManejadorBaseDatos.getInstance().getHotel(consulta, id);
    }

    public List getHoteles() {
        String consulta = "SELECT * FROM HOTEL";
        return ManejadorBaseDatos.getInstance().getHotel(null, consulta, 0);
    }
    
    public List getHotelesByState(int estado) {
        String consulta = "SELECT * FROM HOTEL WHERE ESTADO = ?";
        return ManejadorBaseDatos.getInstance().getHotel(Integer.toString(estado), consulta, 1);
    }

    public void setHotel(String nombre, String direccion) throws Exception {
        if (nombre.isEmpty()) {
            throw new Exception("Ingrese un nombre valido");
        } else if (direccion.isEmpty()) {
            throw new Exception("Ingrese una direccion valida");
        } else if (nombre.length() > 30 || direccion.length() > 40) {
            throw new Exception("Se ha superado la cantidad maxima de caracteres");
        } else {
            String accion = "INSERT INTO HOTEL (NOMBRE,DIRECCION) VALUES (?,?)";
            Hotel hotel = new HotelBuilder().nombre(nombre).direccion(direccion).build();
            ManejadorBaseDatos.getInstance().setHotel(accion, hotel);
        }
    }

    public void updateHotel(Hotel hotel, String nombre, String direccion) throws Exception {
        if(nombre.isEmpty() || direccion.isEmpty()) {
            throw new Exception("Campos vacios");
        } else if ((nombre.length() > 30) || (direccion.length() > 40)) {
            throw new Exception("El Nombre o direccion del Hotel supera el tamaño maximo");
        } else {
            String accion = "UPDATE HOTEL SET NOMBRE = ?, DIRECCION = ? WHERE ID = ?";
            hotel.setNombre(nombre);
            hotel.setDireccion(direccion);
            ManejadorBaseDatos.getInstance().updateHotel(accion, hotel, 1);
        }
    }

    public void deshabilitarHabilitarMenu(Hotel hotel, int estado) {
        hotel.setEstado(estado);
        String accion = "UPDATE HOTEL SET ESTADO = ? WHERE ID = ?";
        ManejadorBaseDatos.getInstance().updateHotel(accion, hotel, 2);
//        throw new Exception("Se ha modificado correctamente el elemento con ID '"+ hotel.getId());
    }

}
