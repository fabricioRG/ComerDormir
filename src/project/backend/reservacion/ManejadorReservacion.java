package project.backend.reservacion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import project.backend.basedatos.ManejadorBaseDatos;
import project.backend.cliente.Cliente;
import project.backend.cliente.ManejadorCliente;
import project.backend.habitacion.Habitacion;
import project.backend.hotel.Hotel;
import project.backend.hotel.ManejadorHotel;
import project.frontend.cliente.CreadorCliente;
import project.frontend.cliente.RegistradorCliente;

/**
 *
 * @author fabricio
 */
public class ManejadorReservacion {

    private static ManejadorReservacion INSTANCE = null;
    private SimpleDateFormat fechaFormat = null;

    private ManejadorReservacion() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorReservacion();
        }
    }

    public static ManejadorReservacion getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public void setReservacion(String dpiCliente, Habitacion habitacion, Date fechaInicio, Date fechaSalida, Hotel hotel) throws Exception {
        if (dpiCliente.isEmpty()) {
            throw new Exception("DPI no valido, intentelo de nuevo");
        } else {
            String accion = "INSERT INTO RESERVACION(ID_HABITACION, NUMERO_HABITACION, DPI_CLIENTE, NOMBRE_CLIENTE, PRECIO_HABITACION, "
                    + "CANTIDAD_DIAS, COSTO_MANTE, FECHA_INICIAL, FECHA_FINAL, NOMBRE_HOTEL, ID_HOTEL) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            Cliente cliente = ManejadorCliente.getInstance().getClienteByDPI(dpiCliente);
            if (cliente == null) {
                CreadorCliente cc = new CreadorCliente(null, true, Integer.parseInt(dpiCliente));
                cc.setVisible(true);
                if (cc.isEstado()) {
                    cliente = ManejadorCliente.getInstance().getClienteByDPI(dpiCliente);
                    Reservacion reservacion = new ReservacionBuilder().idHabitacion(habitacion.getId()).dpiCliente(cliente.getDpi()).
                            nombreCliente(cliente.getNombre()).noHabitacion(habitacion.getNumero()).nombreHotel(hotel.getNombre()).idHotel(hotel.getId()).
                            precioHabitacion(habitacion.getPrecio()).costoMantenimiento(habitacion.getCostoMantenimiento()).
                            fechaInicio(fechaInicio).fechaSalida(fechaSalida).cantidadDias(getCantidadDias(fechaInicio, fechaSalida)).build();
                    ManejadorBaseDatos.getInstance().setReservacion(accion, reservacion);
                    JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente la reservacion", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                Reservacion reservacion = new ReservacionBuilder().idHabitacion(habitacion.getId()).dpiCliente(cliente.getDpi()).
                        precioHabitacion(habitacion.getPrecio()).costoMantenimiento(habitacion.getCostoMantenimiento()).idHotel(hotel.getId()).
                        nombreCliente(cliente.getNombre()).noHabitacion(habitacion.getNumero()).nombreHotel(hotel.getNombre()).
                        fechaInicio(fechaInicio).fechaSalida(fechaSalida).cantidadDias(getCantidadDias(fechaInicio, fechaSalida)).build();
                ManejadorBaseDatos.getInstance().setReservacion(accion, reservacion);
                JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente la reservacion", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public int getCantidadDias(Date inicio, Date salida) {
        String consulta = "SELECT DATEDIFF(?,?)";
        return ManejadorBaseDatos.getInstance().getCantidadDias(consulta, fechaFormat.format(inicio), fechaFormat.format(salida));
    }

    public List getReservaciones(int idHotel) {
        Reservacion reser = new ReservacionBuilder().idHotel(idHotel).build();
        String consulta = "SELECT * FROM RESERVACION WHERE ID_HOTEL = ?";
        return ManejadorBaseDatos.getInstance().getReservacion(consulta, reser, 1);
    }

    public List getReservacionesByConfirmacion(int confi, int idHotel) {
        Reservacion reser = new ReservacionBuilder().idHotel(idHotel).confirmado(confi).build();
        String consulta = "SELECT * FROM RESERVACION WHERE ID_HOTEL = ? AND CONFIRMADO = ?";
        return ManejadorBaseDatos.getInstance().getReservacion(consulta, reser, 2);
    }

    public List getReservacionesByDateEntrada(Date limite, int estado, int idHotel) {
        Reservacion reser = new ReservacionBuilder().idHotel(idHotel).confirmado(estado).build();
        String consulta = "SELECT * FROM RESERVACION WHERE FECHA_INICIO < '" + fechaFormat.format(limite)
                + "' AND ID_HOTEL = ? AND CONFIRMADO = ?";
        return ManejadorBaseDatos.getInstance().getReservacion(consulta, reser, 2);
    }

    public List getReservacionesByConfirmado(int idHotel, int estado) {
        Reservacion reser = new ReservacionBuilder().idHotel(idHotel).confirmado(estado).build();
        String consulta = "SELECT * FROM RESERVACION WHERE ID_HOTEL = ? AND CONFIRMADO = ? ";
        return ManejadorBaseDatos.getInstance().getReservacion(consulta, reser, 2);
    }

    public List getReservacionesByDPICliente(int dpi, int idHotel) {
        Reservacion reser = new ReservacionBuilder().dpiCliente(dpi).idHotel(idHotel).build();
        String consulta = "SELECT * FROM RESERVACION WHERE ID_HOTEL = ? AND DPI_CLIENTE = '" + dpi + "' AND CONFIRMADO = '0'";
        return ManejadorBaseDatos.getInstance().getReservacion(consulta, reser, 1);
    }

    public void deleteReservacionByID(int id) {
        String accion = "DELETE FROM RESERVACION WHERE ID = ?";
        ManejadorBaseDatos.getInstance().deleteReservacion(accion, id);
    }

    public void updateConfirmadoReservacion(int id) {
        String accion = "UPDATE RESERVACION SET CONFIRMADO = '1' WHERE ID = ?";
        ManejadorBaseDatos.getInstance().updateReservacion(accion, Integer.toString(id));
    }

}
