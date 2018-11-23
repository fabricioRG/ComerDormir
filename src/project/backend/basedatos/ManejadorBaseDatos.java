package project.backend.basedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import project.backend.alojamiento.Alojamiento;
import project.backend.alojamiento.AlojamientoBuilder;
import project.backend.cliente.Cliente;
import project.backend.cliente.ClienteBuilder;
import project.backend.consumo.Consumo;
import project.backend.consumo.ConsumoBuilder;
import project.backend.empleado.Empleado;
import project.backend.empleado.EmpleadoBuilder;
import project.backend.habitacion.Habitacion;
import project.backend.habitacion.HabitacionBuilder;
import project.backend.hotel.Hotel;
import project.backend.hotel.HotelBuilder;
import project.backend.menu.Menu;
import project.backend.menu.MenuBuilder;
import project.backend.opinion.Opinion;
import project.backend.opinion.OpinionBuilder;
import project.backend.promocion.Promocion;
import project.backend.promocion.PromocionBuilder;
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

    public List getEmpleados(String dato, String dato2, String consulta, int opcion) {
        List<Empleado> listaEmpleados = new LinkedList<>();
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            } else if (opcion == 2) {
                sentencia.setString(1, dato);
                sentencia.setString(2, dato2);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int dpi = resultado.getInt("DPI");
                String nombre = resultado.getString("NOMBRE");
                int tipo = resultado.getInt("TIPO");
                int estado = resultado.getInt("ESTADO");
                String usuario = resultado.getString("USUARIO");
                String contrasena = resultado.getString("CONTRASENA");
                Date fecha = resultado.getDate("FECHA_REGISTRO");
                Double sueldo = resultado.getDouble("SUELDO_SEMANA");
                int idHotel = resultado.getInt("ID_HOTEL");
                String nombreHotel = resultado.getString("NOMBRE_HOTEL");
                int idRestaurante = resultado.getInt("ID_RESTAURANTE");
                String nombreRest = resultado.getString("NOMBRE_RESTAURANTE");
                Empleado empleado = new EmpleadoBuilder().
                        dpi(dpi).
                        nombre(nombre).
                        tipo(tipo).
                        estado(estado).
                        usuario(usuario).
                        contrasena(contrasena).
                        idHotel(idHotel).
                        idRestaurante(idRestaurante).
                        fechaRegistro(fecha).
                        sueldoSemanal(sueldo).nombreHotel(nombreHotel).nombreRestaurante(nombreRest).
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
            sentencia.setDouble(6, empleado.getSueldoSemanal());
            sentencia.setString(7, fechaFormat.format(empleado.getFechaRegistro()));
            if (opcion == 1) {
                sentencia.setInt(8, empleado.getIdHotel());
                sentencia.setString(9, empleado.getNombreHotel());
            } else if (opcion == 2) {
                sentencia.setInt(8, empleado.getIdRestaurante());
                sentencia.setString(9, empleado.getNombreRestaurante());
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
                int estado = resultado.getInt("ESTADO");
                restaurante = new RestauranteBuilder().
                        id(id).
                        nombre(nombre).
                        direccion(direccion).
                        independiente(independiente).
                        idHotel(idHotel).estado(estado).
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
                String nombreHotel = resultado.getString("NOMBRE_HOTEL");
                Restaurante restaurante = new RestauranteBuilder().id(id).nombre(nombre).direccion(direccion).
                        independiente(independiente).idHotel(idHotel).estado(estado).nombreHotel(nombreHotel).build();
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
                sentencia.setString(5, rest.getNombreHotel());
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

    public Habitacion getHabitacionPopular(String consulta) {

        Habitacion habit = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt(1);
                int numero = resultado.getInt(2);
                habit = new HabitacionBuilder().id(id).numero(numero).build();
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return habit;
    }

    public Habitacion getHabitacionNumero(String consulta) {
        Habitacion habit = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int numero = resultado.getInt(1);
                int idHotel = resultado.getInt(2);
                habit = new HabitacionBuilder().numero(numero).idHotel(idHotel).build();
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return habit;
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

    public List getReservacion(String consulta, Reservacion reser, int opcion) {
        List<Reservacion> reservaciones = new LinkedList<>();
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setInt(1, reser.getIdHotel());
            } else if (opcion == 2) {
                sentencia.setInt(1, reser.getIdHotel());
                sentencia.setInt(2, reser.getConfirmado());
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                int idHabitacion = resultado.getInt("ID_HABITACION");
                int numeroHabitacion = resultado.getInt("NUMERO_HABITACION");
                int dpiCliente = resultado.getInt("DPI_CLIENTE");
                String nombreCliente = resultado.getString("NOMBRE_CLIENTE");
                Date fechaInicio = resultado.getDate("FECHA_INICIAL");
                Date fechaSalida = resultado.getDate("FECHA_FINAL");
                double precio = resultado.getDouble("PRECIO_HABITACION");
                double costoMantenimiento = resultado.getDouble("COSTO_MANTE");
                int confirmado = resultado.getInt("CONFIRMADO");
                int cantidadDias = resultado.getInt("CANTIDAD_DIAS");
                int idHotel = resultado.getInt("ID_HOTEL");
                String nombreHotel = resultado.getString("NOMBRE_HOTEL");
                Reservacion reservacion = new ReservacionBuilder().id(id).idHabitacion(idHabitacion).
                        dpiCliente(dpiCliente).fechaInicio(fechaInicio).fechaSalida(fechaSalida).precioHabitacion(precio).
                        costoMantenimiento(costoMantenimiento).confirmado(confirmado).
                        noHabitacion(numeroHabitacion).nombreCliente(nombreCliente).cantidadDias(cantidadDias).
                        idHotel(idHotel).nombreHotel(nombreHotel).build();
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

    public void deleteReservacion(String accion, int id) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void setReservacion(String accion, Reservacion reservacion) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, reservacion.getIdHabitacion());
            sentencia.setInt(2, reservacion.getNoHabitacion());
            sentencia.setInt(3, reservacion.getDpiCliente());
            sentencia.setString(4, reservacion.getNombreCliente());
            sentencia.setDouble(5, reservacion.getPrecioHabitacion());
            sentencia.setInt(6, reservacion.getCantidadDias());
            sentencia.setDouble(7, reservacion.getCostoMantenimiento());
            sentencia.setString(8, fechaFormat.format(reservacion.getFechaInicio()));
            sentencia.setString(9, fechaFormat.format(reservacion.getFechaSalida()));
            sentencia.setString(10, reservacion.getNombreHotel());
            sentencia.setInt(11, reservacion.getIdHotel());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List gerReservaciones(String consulta, String dato, int opcion) {
        List<Reservacion> reservaciones = new LinkedList<>();
        Reservacion reservacion = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                int idHabitacion = resultado.getInt("ID_HABITACION");
                int noHabitacion = resultado.getInt("NUMERO_HABITACION");
                int dpiCliente = resultado.getInt("DPI_CLIENTE");
                String nombreCliente = resultado.getString("NOMBRE_CLIENTE");
                double precioHabitacion = resultado.getDouble("PRECIO_HABITACION");
                int cantidadDias = resultado.getInt("CANTIDAD_DIAS");
                double costoMantenimiento = resultado.getDouble("COSTO_MANTE");
                Date fechaInicial = resultado.getDate("FECHA_INICIAL");
                Date fechaFinal = resultado.getDate("FECHA_FINAL");
                int confirmado = resultado.getInt("CONFIRMADO");
                String nombreHotel = resultado.getString("NOMBRE_HOTEL");
                int IdHotel = resultado.getInt("ID_HOTEL");
                reservacion = new ReservacionBuilder().id(id).idHabitacion(idHabitacion).noHabitacion(noHabitacion).
                        dpiCliente(dpiCliente).nombreCliente(nombreCliente).precioHabitacion(precioHabitacion).
                        cantidadDias(cantidadDias).costoMantenimiento(costoMantenimiento).fechaInicio(fechaInicial).
                        fechaSalida(fechaFinal).confirmado(confirmado).nombreHotel(nombreHotel).idHotel(IdHotel).build();
                reservaciones.add(reservacion);
            }
            sentencia.close();
            if (reservaciones.isEmpty()) {
                reservaciones = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return reservaciones;
    }

    public void updateReservacion(String accion, String dato) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setString(1, dato);
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
            sentencia.setInt(2, cliente.getTelefono());
            sentencia.setInt(3, cliente.getDpi());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void setAlojamiento(String accion, Reservacion reservacion) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, reservacion.getId());
            sentencia.setString(2, fechaFormat.format(reservacion.getFechaInicio()));
            sentencia.setString(3, fechaFormat.format(reservacion.getFechaSalida()));
            sentencia.setInt(4, reservacion.getDpiCliente());
            sentencia.setString(5, reservacion.getNombreCliente());
            sentencia.setDouble(6, reservacion.getCostoMantenimiento());
            sentencia.setInt(7, reservacion.getCantidadDias());
            sentencia.setDouble(8, reservacion.getPrecioHabitacion());
            sentencia.setInt(9, reservacion.getIdHotel());
            sentencia.setString(10, reservacion.getNombreHotel());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List getAlojamientos(String consulta, Alojamiento aloj, int opcion) {
        List<Alojamiento> alojamientos = new LinkedList<>();
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setInt(1, aloj.getIdHotel());
            } else if (opcion == 2) {
                sentencia.setInt(1, aloj.getIdHotel());
                sentencia.setInt(2, aloj.getActivo());
            } else if (opcion == 3) {
                sentencia.setInt(1, aloj.getDpiCliente());
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                int idReservacion = resultado.getInt("ID_RESERVACION");
                int dpiCliente = resultado.getInt("DPI_CLIENTE");
                String nombreCliente = resultado.getString("NOMBRE_CLIENTE");
                Date fechaInicio = resultado.getDate("FECHA_ENTRADA");
                Date fechaSalida = resultado.getDate("FECHA_SALIDA");
                double precio = resultado.getDouble("PRECIO_HABITACION");
                double costoMantenimiento = resultado.getDouble("COSTO_HABITACION");
                int activo = resultado.getInt("ACTIVO");
                int cantidadDias = resultado.getInt("CANTIDAD_DIAS");
                int idHotel = resultado.getInt("ID_HOTEL");
                String nombreHotel = resultado.getString("NOMBRE_HOTEL");
                Alojamiento alojamiento = new AlojamientoBuilder().id(id).idReservacion(idReservacion).dpiCliente(dpiCliente).
                        nombreCliente(nombreCliente).fechaEntrada(fechaInicio).fechaSalida(fechaSalida).precioHabitacion(precio).
                        costoHabitacion(costoMantenimiento).activo(activo).cantidadDias(cantidadDias).idHotel(idHotel).
                        nombreHotel(nombreHotel).builder();
                alojamientos.add(alojamiento);
            }
            sentencia.close();
            if (alojamientos.isEmpty()) {
                alojamientos = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alojamientos;
    }

    public void setMenu(String accion, Menu menu) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setString(1, menu.getNombre());
            sentencia.setString(2, menu.getDescripcion());
            sentencia.setString(3, menu.getTipo());
            sentencia.setDouble(4, menu.getPrecio());
            sentencia.setDouble(5, menu.getCosto());
            sentencia.setInt(6, menu.getIdRestaurante());
            sentencia.setString(7, menu.getNombreRestaurante());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List getMenu(String consulta, int opcion, String dato) {
        List<Menu> elementosMenu = new LinkedList<>();
        Menu elemento = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                String nombre = resultado.getString("NOMBRE");
                String descripcion = resultado.getString("DESCRIPCION");
                String tipo = resultado.getString("TIPO");
                double precio = resultado.getDouble("PRECIO");
                double costo = resultado.getDouble("COSTO");
                int idRestaurante = resultado.getInt("ID_RESTAURANTE");
                String nombreRestaurante = resultado.getString("NOMBRE_RESTAURANTE");
                elemento = new MenuBuilder().id(id).nombre(nombre).descripcion(descripcion).tipo(tipo).precio(precio).
                        costo(costo).idRestaurante(idRestaurante).nombreRestaurante(nombreRestaurante).build();
                elementosMenu.add(elemento);
            }
            sentencia.close();
            if (elementosMenu.isEmpty()) {
                elementosMenu = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return elementosMenu;
    }

    public Menu getMenu(String consulta, int idMenu) {
        Menu elemento = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            sentencia.setInt(1, idMenu);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                String nombre = resultado.getString("NOMBRE");
                String descripcion = resultado.getString("DESCRIPCION");
                String tipo = resultado.getString("TIPO");
                double precio = resultado.getDouble("PRECIO");
                double costo = resultado.getDouble("COSTO");
                int idRestaurante = resultado.getInt("ID_RESTAURANTE");
                String nombreRestaurante = resultado.getString("NOMBRE_RESTAURANTE");
                elemento = new MenuBuilder().id(id).nombre(nombre).descripcion(descripcion).tipo(tipo).precio(precio).
                        costo(costo).idRestaurante(idRestaurante).nombreRestaurante(nombreRestaurante).build();
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return elemento;
    }

    public void updateMenu(String accion, Menu menu, int opcion) {
        try {
            sentencia = connection.prepareStatement(accion);
            if (opcion == 1) {
                sentencia.setString(1, menu.getNombre());
                sentencia.setDouble(2, menu.getPrecio());
                sentencia.setInt(3, menu.getId());
            }
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public Promocion getPromocionHabitacion(String consulta, String dato, int opcion) {
        Promocion promo = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                int idHabitacion = resultado.getInt("ID_HABITACION");
                int numeroHabitacion = resultado.getInt("NUMERO_HABITACION");
                String nombreHotel = resultado.getString("NOMBRE_HOTEL");
                double porcentaje = resultado.getDouble("PORCENTAJE");
                Date fechaInicio = resultado.getDate("FECHA_INICIO");
                Date fechaFinal = resultado.getDate("FECHA_FINAL");
                promo = new PromocionBuilder().id(id).idHabitacion(idHabitacion).numeroHabitacion(numeroHabitacion).
                        nombreHotel(nombreHotel).porcentaje(porcentaje).fechaInicio(fechaInicio).fechaFinal(fechaFinal).build();
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return promo;
    }

    public List getPromocionesHabitacion(String consulta, String dato, int opcion) {
        List<Promocion> promociones = new LinkedList<>();
        Promocion promo = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                int idHabitacion = resultado.getInt("ID_HABITACION");
                int numeroHabitacion = resultado.getInt("NUMERO_HABITACION");
                String nombreHotel = resultado.getString("NOMBRE_HOTEL");
                double porcentaje = resultado.getDouble("PORCENTAJE");
                Date fechaInicio = resultado.getDate("FECHA_INICIO");
                Date fechaFinal = resultado.getDate("FECHA_FINAL");
                promo = new PromocionBuilder().id(id).idHabitacion(idHabitacion).numeroHabitacion(numeroHabitacion).
                        nombreHotel(nombreHotel).porcentaje(porcentaje).fechaInicio(fechaInicio).fechaFinal(fechaFinal).build();
                promociones.add(promo);
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return promociones;
    }
    
    public void setPromocionHabitacion(String accion, Promocion promo) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, promo.getIdHabitacion());
            sentencia.setInt(2, promo.getNumeroHabitacion());
            sentencia.setString(3, promo.getNombreHotel());
            sentencia.setDouble(4, promo.getPorcentaje());
            sentencia.setString(5, fechaFormat.format(promo.getFechaInicio()));
            sentencia.setString(6, fechaFormat.format(promo.getFechaFinal()));
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public void setPromocionRestaurante(String accion, Promocion promo) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, promo.getIdRestaurante());
            sentencia.setString(2, promo.getNombreRestaurante());
            sentencia.setDouble(3, promo.getPorcentaje());
            sentencia.setString(4, fechaFormat.format(promo.getFechaInicio()));
            sentencia.setString(5, fechaFormat.format(promo.getFechaFinal()));
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public Promocion getPromocionRestaurante(String consulta, String dato, int opcion) {
        Promocion promo = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                int idRestaurante = resultado.getInt("ID_RESTAURANTE");
                String nombreRestaurante = resultado.getString("NOMBRE_RESTAURANTE");
                double porcentaje = resultado.getDouble("PORCENTAJE");
                Date fechaInicio = resultado.getDate("FECHA_INICIO");
                Date fechaFinal = resultado.getDate("FECHA_FINAL");
                promo = new PromocionBuilder().id(id).idRestaurante(idRestaurante).nombreRestaurante(nombreRestaurante)
                        .porcentaje(porcentaje).fechaInicio(fechaInicio).fechaFinal(fechaFinal).build();
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return promo;
    }
    
    public List getPromocionesRestaurante(String consulta, String dato, int opcion) {
        List<Promocion> promociones = new LinkedList<>();
        Promocion promo = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                int idRestaurante = resultado.getInt("ID_RESTAURANTE");
                String nombreRestaurante = resultado.getString("NOMBRE_RESTAURANTE");
                double porcentaje = resultado.getDouble("PORCENTAJE");
                Date fechaInicio = resultado.getDate("FECHA_INICIO");
                Date fechaFinal = resultado.getDate("FECHA_FINAL");
                promo = new PromocionBuilder().id(id).idRestaurante(idRestaurante).nombreRestaurante(nombreRestaurante)
                        .porcentaje(porcentaje).fechaInicio(fechaInicio).fechaFinal(fechaFinal).build();
                promociones.add(promo);
            }
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return promociones;
    }
    
    public void setOpinionHotel(String accion, Opinion opinion, int opcion) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, opinion.getIdHotel());
            sentencia.setString(2, opinion.getComentario());
            sentencia.setInt(3, opinion.getPuntuacion());
            sentencia.setString(4, opinion.getNombreHotel());
            if (opcion == 1) {
                sentencia.setString(5, opinion.getNombreCliente());
            }
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void setOpinionRestaurante(String accion, Opinion opinion, int opcion) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setInt(1, opinion.getIdRestaurante());
            sentencia.setString(2, opinion.getComentario());
            sentencia.setInt(3, opinion.getPuntuacion());
            sentencia.setString(4, opinion.getNombreRestaurante());
            if (opcion == 1) {
                sentencia.setString(5, opinion.getNombreCliente());
            }
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List getOpinionesHotel(String consulta, int opcion, String dato) {
        List<Opinion> elementosOpinion = new LinkedList<>();
        Opinion opinion = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                int idHotel = resultado.getInt("ID_HOTEL");
                int puntuacion = resultado.getInt("PUNTUACION");
                String comentario = resultado.getString("COMENTARIO");
                String nombreCliente = resultado.getString("NOMBRE_CLIENTE");
                String nombreHotel = resultado.getString("NOMBRE_HOTEL");
                opinion = new OpinionBuilder().id(id).idHotel(idHotel).puntuacion(puntuacion).comentario(comentario).
                        nombreCliente(nombreCliente).nombreHotel(nombreHotel).build();
                elementosOpinion.add(opinion);
            }
            sentencia.close();
            if (elementosOpinion.isEmpty()) {
                elementosOpinion = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return elementosOpinion;
    }

    public List getOpinionesRestaurante(String consulta, int opcion, String dato) {
        List<Opinion> elementosOpinion = new LinkedList<>();
        Opinion opinion = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                int idRestaurante = resultado.getInt("ID_RESTAURANTE");
                int puntuacion = resultado.getInt("PUNTUACION");
                String comentario = resultado.getString("COMENTARIO");
                String nombreCliente = resultado.getString("NOMBRE_CLIENTE");
                String nombreRestaurante = resultado.getString("NOMBRE_RESTAURANTE");
                opinion = new OpinionBuilder().id(id).idRestaurante(idRestaurante).puntuacion(puntuacion).comentario(comentario).
                        nombreCliente(nombreCliente).nombreRestaurante(nombreRestaurante).build();
                elementosOpinion.add(opinion);
            }
            sentencia.close();
            if (elementosOpinion.isEmpty()) {
                elementosOpinion = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return elementosOpinion;
    }

    public void setConsumo(String accion, Consumo consumo) {
        try {
            sentencia = connection.prepareStatement(accion);
            sentencia.setDouble(1, consumo.getMonto());
            sentencia.setDouble(2, consumo.getCosto());
            sentencia.setString(3, fechaFormat.format(consumo.getFecha()));
            sentencia.setInt(4, consumo.getIdMenu());
            sentencia.setInt(5, consumo.getIdAlojamiento());
            sentencia.setString(6, consumo.getNombreMenu());
            sentencia.setString(7, consumo.getNombreCliente());
            sentencia.setString(8, consumo.getNombreRestaurante());
            sentencia.setInt(9, consumo.getIdRestaurante());
            sentencia.executeUpdate();
            sentencia.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public List getConsumos(String consulta, int opcion, String dato) {
        List<Consumo> elementosConsumo = new LinkedList<>();
        Consumo consumo = null;
        try {
            sentencia = connection.prepareStatement(consulta);
            if (opcion == 1) {
                sentencia.setString(1, dato);
            }
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                double monto = resultado.getDouble("MONTO");
                double costo = resultado.getDouble("COSTO");
                Date fecha = resultado.getDate("FECHA");
                int idMenu = resultado.getInt("ID_MENU");
                int idRestaurante = resultado.getInt("ID_RESTAURANTE");
                int idAlojamiento = resultado.getInt("ID_ALOJAMIENTO");
                String nombreCliente = resultado.getString("NOMBRE_CLIENTE");
                String nombreMenu = resultado.getString("NOMBRE_MENU");
                String nombreRestaurante = resultado.getString("NOMBRE_RESTAURANTE");
                consumo = new ConsumoBuilder().id(id).monto(monto).costo(costo).fecha(fecha).idMenu(idMenu).idRestaurante(idRestaurante).
                        idAlojamiento(idAlojamiento).nombreCliente(nombreCliente).nombreMenu(nombreMenu).nombreRestaurante(nombreRestaurante).build();
                elementosConsumo.add(consumo);
            }
            sentencia.close();
            if (elementosConsumo.isEmpty()) {
                elementosConsumo = null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return elementosConsumo;
    }

}
