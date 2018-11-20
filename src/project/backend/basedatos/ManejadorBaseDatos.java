package project.backend.basedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import project.backend.cliente.Cliente;
import project.backend.cliente.ClienteBuilder;
import project.backend.empleado.Empleado;
import project.backend.empleado.EmpleadoBuilder;
import project.backend.habitacion.Habitacion;
import project.backend.habitacion.HabitacionBuilder;
import project.backend.hotel.Hotel;
import project.backend.hotel.HotelBuilder;
import project.backend.reservacion.Reservacion;
import project.backend.reservacion.ReservacionBuilder;
import project.backend.restaurante.Restaurante;
import project.backend.restaurante.RestauranteBuilder;

/**
 *
 * @author fabricio
 */
public class ManejadorBaseDatos {

    private static BaseDatos baseDatos = null;
    private static Connection connection = null;
    private PreparedStatement sentencia = null;
    private SimpleDateFormat fechaFormat = null;
    private static ManejadorBaseDatos INSTANCE = null;

    private ManejadorBaseDatos() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorBaseDatos();
            baseDatos = BaseDatos.getInstance();
        }
    }

    public static ManejadorBaseDatos getInstance() {
        if (INSTANCE == null) {
            createInstance();
            connection = baseDatos.getConection();
        }
        return INSTANCE;
    }

    public Empleado getEmpleado(String consulta, String dato) {
        Empleado empleado = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            sentencia.setString(1, dato);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int dpi = resultado.getInt("DPI");
                String nombre = resultado.getString("NOMBRE");
                int tipo = resultado.getInt("TIPO");
                int estado = resultado.getInt("ESTADO");
                String usuario = resultado.getString("USUARIO");
                String contrasena = resultado.getString("CONTRASENA");
                int idHotel = resultado.getInt("ID_HOTEL");
                int idRestaurante = resultado.getInt("ID_RESTAURANTE");
                empleado = new EmpleadoBuilder().
                        dpi(dpi).
                        nombre(nombre).
                        tipo(tipo).
                        estado(estado).
                        usuario(usuario).
                        contrasena(contrasena).
                        idHotel(idHotel).
                        idRestaurante(idRestaurante).
                        build();
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return empleado;
    }

    public List getEmpleados(String dato, String consulta, int opcion) {
        List<Empleado> listaEmpleados = new LinkedList<>();
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int dpi = resultado.getInt("DPI");
                String nombre = resultado.getString("NOMBRE");
                int tipo = resultado.getInt("TIPO");
                int estado = resultado.getInt("ESTADO");
                String usuario = resultado.getString("USUARIO");
                String contrasena = resultado.getString("CONTRASENA");
                int idHotel = resultado.getInt("ID_HOTEL");
                int idRestaurante = resultado.getInt("ID_RESTAURANTE");
                Empleado empleado = new EmpleadoBuilder().
                        dpi(dpi).
                        nombre(nombre).
                        tipo(tipo).
                        estado(estado).
                        usuario(usuario).
                        contrasena(contrasena).
                        idHotel(idHotel).
                        idRestaurante(idRestaurante).
                        build();
                listaEmpleados.add(empleado);
            }
            sentencia.close();
            if (listaEmpleados.isEmpty()) {
                listaEmpleados = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listaEmpleados;
    }

    public void setEmpleado(String accion, Empleado empleado, int opcion) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, empleado.getDpi());
            sentencia.setString(2, empleado.getNombre());
            sentencia.setInt(3, empleado.getTipo());
            sentencia.setString(4, empleado.getUsuario());
            sentencia.setString(5, empleado.getContrasena());
            if (opcion == 1) {
                sentencia.setInt(6, empleado.getIdHotel());
            } else if (opcion == 2) {
                sentencia.setInt(6, empleado.getIdRestaurante());
            }
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void updateEmpleado(Empleado empleado, String accion, int opcion) {
        try {
            sentencia = connection.prepareStatement(accion);
            if (opcion == 1) {
                sentencia.setString(1, empleado.getNombre());
                sentencia.setInt(2, empleado.getDpi());
            } else if (opcion == 2) {
                sentencia.setInt(1, empleado.getEstado());
                sentencia.setInt(2, empleado.getDpi());
            }
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public Hotel getHotel(String consulta, int dato) {
        Hotel hotel = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            sentencia.setInt(1, dato);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                String nombre = resultado.getString("NOMBRE");
                String direccion = resultado.getString("DIRECCION");
                int estado = resultado.getInt("ESTADO");
                hotel = new HotelBuilder().id(id).nombre(nombre).direccion(direccion).estado(estado).build();
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hotel;
    }

    public List getHotel(String datoUsuario, String consulta, int opcion) {
        List<Hotel> hoteles = new LinkedList<>();
        Hotel hotel = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, datoUsuario);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                String nombre = resultado.getString("NOMBRE");
                String direccion = resultado.getString("DIRECCION");
                int id = resultado.getInt("ID");
                int estado = resultado.getInt("ESTADO");
                hotel = new HotelBuilder().nombre(nombre).direccion(direccion).id(id).estado(estado).build();
                hoteles.add(hotel);
            }
            sentencia.close();
            if (hoteles.isEmpty()) {
                hoteles = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return hoteles;
    }

    public void setHotel(String accion, Hotel hotel) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setString(1, hotel.getNombre());
            sentencia.setString(2, hotel.getDireccion());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void updateHotel(String accion, Hotel hotel, int opcion) {
        try {
            sentencia = connection.prepareStatement(accion);
            if (opcion == 1) {
                sentencia.setString(1, hotel.getNombre());
                sentencia.setString(2, hotel.getDireccion());
                sentencia.setInt(3, hotel.getId());
            } else if (opcion == 2) {
                sentencia.setInt(1, hotel.getEstado());
                sentencia.setInt(2, hotel.getId());
            }
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public Restaurante getRestaurante(String consulta, int dato) {
        Restaurante restaurante = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            sentencia.setInt(1, dato);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                String nombre = resultado.getString("NOMBRE");
                String direccion = resultado.getString("DIRECCION");
                int independiente = resultado.getInt("INDEPENDIENTE");
                int idHotel = resultado.getInt("ID_HOTEL");
                restaurante = new RestauranteBuilder().
                        id(id).
                        nombre(nombre).
                        direccion(direccion).
                        independiente(independiente).
                        idHotel(idHotel).
                        build();
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return restaurante;
    }

    public List getRestaurantes(String datoUsuario, String consulta, int opcion) {
        List<Restaurante> rests = new LinkedList<>();
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, datoUsuario);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                String nombre = resultado.getString("NOMBRE");
                String direccion = resultado.getString("DIRECCION");
                int independiente = resultado.getInt("INDEPENDIENTE");
                int idHotel = resultado.getInt("ID_HOTEL");
                int estado = resultado.getInt("ESTADO");
                Restaurante restaurante = new RestauranteBuilder().id(id).nombre(nombre).direccion(direccion).
                        independiente(independiente).idHotel(idHotel).estado(estado).build();
                rests.add(restaurante);
            }
            sentencia.close();
            if (rests.isEmpty()) {
                rests = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rests;
    }

    public void setRestaurante(String accion, Restaurante rest, int opcion) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setString(1, rest.getNombre());
            sentencia.setString(2, rest.getDireccion());
            sentencia.setInt(3, rest.getIndependiente());
            if (opcion == 1) {
                sentencia.setInt(4, rest.getIdHotel());
            }
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void updateRestaurante(String accion, Restaurante restaurante, int opcion) {
        try {
            sentencia = connection.prepareStatement(accion);
            if (opcion == 1) {
                sentencia.setString(1, restaurante.getNombre());
                sentencia.setInt(2, restaurante.getId());
            } else if (opcion == 2) {
                sentencia.setInt(1, restaurante.getEstado());
                sentencia.setInt(2, restaurante.getId());
            }
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void setHabitacion(String accion, Habitacion habit) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, habit.getIdHotel());
            sentencia.setInt(2, habit.getNumero());
            sentencia.setString(3, habit.getTipo());
            sentencia.setDouble(4, habit.getPrecio());
            sentencia.setDouble(5, habit.getCostoMantenimiento());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List getHabitacionesByIdHotelAnd(String consulta, Habitacion habitacion) {
        List<Habitacion> habits = new LinkedList<>();
        try {
            sentencia = connection.prepareStatement(consulta);
            sentencia.setInt(1, habitacion.getIdHotel());
            sentencia.setInt(2, habitacion.getNumero());

            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                int numero = resultado.getInt("NUMERO");
                int idHotel = resultado.getInt("ID_HOTEL");
                Habitacion habit = new HabitacionBuilder().id(id).numero(numero).idHotel(idHotel).build();
                habits.add(habit);
            }
            sentencia.close();
            if (habits.isEmpty()) {
                habits = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return habits;
    }

    public List getHabitaciones(String consulta, String dato, int opcion) {
        List<Habitacion> habits = new LinkedList<>();
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                int idHotel = resultado.getInt("ID_HOTEL");
                int numero = resultado.getInt("NUMERO");
                String tipo = resultado.getString("TIPO");
                double precio = resultado.getDouble("PRECIO");
                double costo = resultado.getDouble("COSTO_MANTENIMIENTO");
                Habitacion habit = new HabitacionBuilder().id(id).numero(numero).idHotel(idHotel).
                        tipo(tipo).precio(precio).costoMantenimiento(costo).build();
                habits.add(habit);
            }
            sentencia.close();
            if (habits.isEmpty()) {
                habits = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return habits;
    }

    public void updateHabitacion(String accion, Habitacion habitacion) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setDouble(1, habitacion.getPrecio());
            sentencia.setDouble(2, habitacion.getCostoMantenimiento());
            sentencia.setString(3, habitacion.getTipo());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List getReservacion(String consulta, int opcion, String dato) {
        List<Reservacion> reservaciones = new LinkedList<>();
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                int idHabitacion = resultado.getInt("ID_HABITACION");
                int dpiCliente = resultado.getInt("DPI_Cliente");
                Date fechaInicio = resultado.getDate("Fecha_Inicio");
                Date fechaSalida = resultado.getDate("Fecha_Salida");
                double precio = resultado.getDouble("Precio_Habitacion");
                double costoMantenimiento = resultado.getDouble("COSTO_MANTE");
                int confirmado = resultado.getInt("CONFIRMADO");
                Reservacion reservacion = new ReservacionBuilder().id(id).idHabitacion(idHabitacion).
                        dpiCliente(dpiCliente).fechaInicio(fechaInicio).fechaSalida(fechaSalida).precioHabitacion(precio).
                        costoMantenimiento(costoMantenimiento).confirmado(confirmado).build();
                reservaciones.add(reservacion);
            }
            sentencia.close();
            if (reservaciones.isEmpty()) {
                reservaciones = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservaciones;
    }
    
    public void setReservacion(String accion, Reservacion reservacion) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, reservacion.getIdHabitacion());
            sentencia.setInt(2, reservacion.getDpiCliente());
            sentencia.setDouble(3, reservacion.getPrecioHabitacion());
            sentencia.setInt(4, reservacion.getCantidadDias());
            sentencia.setDouble(5, reservacion.getCostoMantenimiento());
            sentencia.setString(6, fechaFormat.format(reservacion.getFechaInicio()));
            sentencia.setString(7, fechaFormat.format(reservacion.getFechaSalida()));
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public int getCantidadDias(String consulta, String inicio, String salida) {
        int cantidadDias = 0;
        try {
            sentencia = connection.prepareStatement(consulta);
            sentencia.setString(1, salida);
            sentencia.setString(2, inicio);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                cantidadDias = resultado.getInt(1);
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return cantidadDias;
    }
    
    public Cliente getCliente(String consulta, String dato) {
        Cliente cliente = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            sentencia.setString(1, dato);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int dpi = resultado.getInt("DPI");
                String nombre = resultado.getString("NOMBRE");
                String direccion = resultado.getString("DIRECCION");
                int telefono = resultado.getInt("TELEFONO");
                cliente = new ClienteBuilder().dpi(dpi).nombre(nombre).direccion(direccion).telefono(telefono).build();
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return cliente;
    }
    
    public List getCliente(String consulta, String dato, int opcion) {
        List<Cliente> clientes = new LinkedList<>();
        Cliente cliente = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int dpi = resultado.getInt("DPI");
                String nombre = resultado.getString("NOMBRE");
                String direccion = resultado.getString("DIRECCION");
                int telefono = resultado.getInt("TELEFONO");
                cliente = new ClienteBuilder().dpi(dpi).nombre(nombre).direccion(direccion).telefono(telefono).build();
                clientes.add(cliente);
            }
            sentencia.close();
            if (clientes.isEmpty()) {
                clientes = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return clientes;
    }

    public void setCliente(String accion, Cliente cliente) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, cliente.getDpi());
            sentencia.setString(2, cliente.getNombre());
            sentencia.setString(3, cliente.getDireccion());
            sentencia.setInt(4, cliente.getTelefono());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void updateCliente(String accion, Cliente cliente) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2, cliente.getDireccion());
            sentencia.setInt(3, cliente.getTelefono());
            sentencia.setInt(4, cliente.getDpi());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
}
