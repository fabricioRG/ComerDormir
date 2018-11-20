package project.backend.habitacion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import project.backend.basedatos.ManejadorBaseDatos;
import project.backend.hotel.Hotel;

/**
 *
 * @author fabricio
 */
public class ManejadorHabitacion {

    private static ManejadorHabitacion INSTANCE = null;
    private SimpleDateFormat fechaFormat = null;

    private ManejadorHabitacion() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorHabitacion();
        }
    }

    public static ManejadorHabitacion getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public List getHabitacionByIdHotelAndNumero(Habitacion habitacion) {
        String consulta = "SELECT * FROM HABITACION WHERE ID_HOTEL = ? AND NUMERO = ?";
        return ManejadorBaseDatos.getInstance().getHabitacionesByIdHotelAnd(consulta, habitacion);
    }

    public List getHabitaciones() {
        String consulta = "SELECT * FROM HABITACION";
        return ManejadorBaseDatos.getInstance().getHabitaciones(consulta, null, 0);
    }

    public List getHabitacionesByTipo(String tipo) {
        String consulta = "SELECT * FROM HABITACION WHERE TIPO = ?";
        return ManejadorBaseDatos.getInstance().getHabitaciones(consulta, tipo, 1);
    }

    public List getHabitacionesByIdHotel(int idHotel) {
        String consulta = "SELECT * FROM HABITACIONES WHERE ID_HOTEL = ?";
        return ManejadorBaseDatos.getInstance().getHabitaciones(consulta, Integer.toString(idHotel), 1);
    }

    public void setHabitacion(Hotel hotel, String numero, String tipo, String precio, String costoManten) throws Exception {
        if (numero.isEmpty() || numero.isEmpty() || tipo.isEmpty() || precio.isEmpty() || costoManten.isEmpty()) {
            throw new Exception("Campos vacios");
        } else if (tipo.length() > 30) {
            throw new Exception("Tipo no valido");
        } else if (precio.contains("-") || costoManten.contains("-") || numero.contains("-")) {
            throw new Exception("No se permiten numeros negativos");
        } else {
            Habitacion habitacion = new HabitacionBuilder().idHotel(hotel.getId()).numero(Integer.parseInt(numero)).
                    tipo(tipo).precio(Double.parseDouble(precio)).costoMantenimiento(Double.parseDouble(costoManten)).build();
            if (getHabitacionByIdHotelAndNumero(habitacion) != null) {
                throw new Exception("La habitacion ya existe");
            }
            String accion = "INSERT INTO HABITACION (ID_HOTEL, NUMERO, TIPO, PRECIO, COSTO_MANTENIMIENTO) VALUES (?,?,?,?,?)";
            ManejadorBaseDatos.getInstance().setHabitacion(accion, habitacion);
        }
    }

    public void updateHabitacion(Habitacion habitacion, String precio, String costo) throws Exception {
        if (precio.isEmpty() || costo.isEmpty()) {
            throw new Exception("Campos vacios");
        } else if (precio.length() > 40) {
            throw new Exception("Nombre no valido");
        } else {
            String accion = "UPDATE HABITACION SET PRECIO = ?, COSTO_MANTENIMIENTO = ? WHERE TIPO = ?";
            habitacion.setPrecio(Double.parseDouble(precio));
            habitacion.setCostoMantenimiento(Double.parseDouble(costo));
            ManejadorBaseDatos.getInstance().updateHabitacion(accion, habitacion);
        }
    }
    
    public List getHabitacionesByDate(Date inicio, Date salida, Hotel hotel) {
        String consulta = "SELECT * FROM HABITACION WHERE ID NOT IN  (SELECT ID_HABITACION FROM "
                + "RESERVACION WHERE  FECHA_INICIAL < '" + fechaFormat.format(salida) + "' && FECHA_FINAL > '"
                + fechaFormat.format(inicio) + "') && ID_HOTEL = ?";
        return ManejadorBaseDatos.getInstance().getHabitaciones(consulta, Integer.toString(hotel.getId()), 1);
    }

}
