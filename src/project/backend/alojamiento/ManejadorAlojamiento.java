package project.backend.alojamiento;

import java.text.SimpleDateFormat;
import java.util.List;
import project.backend.basedatos.ManejadorBaseDatos;
import project.backend.reservacion.ManejadorReservacion;
import project.backend.reservacion.Reservacion;

/**
 *
 * @author fabricio
 */
public class ManejadorAlojamiento {
    
    private static ManejadorAlojamiento INSTANCE = null;
    private SimpleDateFormat fechaFormat = null;

    private ManejadorAlojamiento() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorAlojamiento();
        }
    }

    public static ManejadorAlojamiento getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }
    
    public void setAlojamiento(Reservacion reservacion){
        String accion = "INSERT INTO ALOJAMIENTO (ID_RESERVACION, FECHA_ENTRADA, FECHA_SALIDA, DPI_CLIENTE, NOMBRE_CLIENTE,"
                + "COSTO_HABITACION, CANTIDAD_DIAS, PRECIO_HABITACION, ID_HOTEL, NOMBRE_HOTEL) VALUES (?,?,?,?,?,?,?,?,?,?)";
        ManejadorBaseDatos.getInstance().setAlojamiento(accion, reservacion);
        ManejadorReservacion.getInstance().updateConfirmadoReservacion(reservacion.getId());
    }
    
    public List getAlojamientos(int idHotel){
        Alojamiento aloj = new AlojamientoBuilder().idHotel(idHotel).builder();
        String consulta = "SELECT * FROM ALOJAMIENTO WHERE ID_HOTEL = ?";
        return ManejadorBaseDatos.getInstance().getAlojamientos(consulta, aloj, 1);
    }
    
    public List getAlojamientosByIdHabitacion(int idHabitacion){
        String consulta = "SELECT ALOJAMIENTO.* FROM ALOJAMIENTO, RESERVACION WHERE ALOJAMIENTO.ID_RESERVACION = "
                + "RESERVACION.ID AND RESERVACION.ID_HABITACION =  '" + idHabitacion + "'";
        return ManejadorBaseDatos.getInstance().getAlojamientos(consulta, null, 0);
    }
    
    public List getAlojamientos(){
        String consulta = "SELECT * FROM ALOJAMIENTO";
        return ManejadorBaseDatos.getInstance().getAlojamientos(consulta, null, 0);
    }
    
    public List getAlojamientosByCliente(int dpiCliente){
        Alojamiento aloj = new AlojamientoBuilder().dpiCliente(dpiCliente).builder();
        String consulta = "SELECT ALOJAMIENTO.* FROM ALOJAMIENTO, CLIENTE WHERE ALOJAMIENTO.DPI_CLIENTE = CLIENTE.DPI AND CLIENTE.DPI = ?";
        return ManejadorBaseDatos.getInstance().getAlojamientos(consulta, aloj, 3);
    }
    
}
