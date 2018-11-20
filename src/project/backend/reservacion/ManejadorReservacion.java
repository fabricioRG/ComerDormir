package project.backend.reservacion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import project.backend.basedatos.ManejadorBaseDatos;
import project.backend.cliente.ManejadorCliente;
import project.backend.habitacion.Habitacion;
import project.backend.hotel.Hotel;
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
            String accion = "INSERT INTO RESERVACION(ID_HABITACION, DPI_CLIENTE, PRECIO_HABITACION, "
                    + "CANTIDAD_DIAS, COSTO_MANTE, FECHA_INICIAL, FECHA_FINAL) VALUES (?,?,?,?,?,?,?)";
            if (ManejadorCliente.getInstance().getClienteByDPI(dpiCliente) == null) {
                CreadorCliente cc = new CreadorCliente(null, true, Integer.parseInt(dpiCliente));
                cc.setVisible(true);
                if (cc.isEstado()) {
                    Reservacion reservacion = new ReservacionBuilder().idHabitacion(habitacion.getId()).dpiCliente(Integer.parseInt(dpiCliente)).
                            precioHabitacion(habitacion.getPrecio()).costoMantenimiento(habitacion.getCostoMantenimiento()).
                            fechaInicio(fechaInicio).fechaSalida(fechaSalida).cantidadDias(getCantidadDias(fechaInicio, fechaSalida)).build();
                    ManejadorBaseDatos.getInstance().setReservacion(accion, reservacion);
                    JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente la reservacion", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);

                }
            } else {
                Reservacion reservacion = new ReservacionBuilder().idHabitacion(habitacion.getId()).dpiCliente(Integer.parseInt(dpiCliente)).
                        precioHabitacion(habitacion.getPrecio()).costoMantenimiento(habitacion.getCostoMantenimiento()).
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

}
