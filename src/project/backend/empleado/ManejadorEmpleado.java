package project.backend.empleado;

import comerdormir.frontend.ComerDormirDesktop;
import java.util.Date;
import java.util.List;
import project.backend.basedatos.ManejadorBaseDatos;
import project.backend.hotel.Hotel;
import project.backend.hotel.ManejadorHotel;
import project.backend.restaurante.ManejadorRestaurante;
import project.backend.restaurante.Restaurante;

/**
 *
 * @author fabricio
 */
public class ManejadorEmpleado {

    private static ManejadorEmpleado INSTANCE = null;

    private ManejadorEmpleado() {
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorEmpleado();
        }
    }

    public static ManejadorEmpleado getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public void showHotelDesktop(String usuario, char[] password) throws Exception {
        String passwordUsuario = new String(password);
        Empleado empleado = null;
        if (usuario.isEmpty()) {
            throw new Exception("No se ha ingresado un \"nombre de usuario\" valido");
        } else if (passwordUsuario.replaceAll(" ", "").isEmpty()) {
            throw new Exception("No se ha ingresado una \"contraseña\" valida");
        }
        if (getEmpleadoByUsuario(usuario) != null) {
            empleado = getEmpleadoByUsuario(usuario);
            if (!(empleado.getContrasena().equals(passwordUsuario))) {
                throw new Exception("La contraseña es incorrecta");
            } else if (empleado.getEstado() != 1) {
                throw new Exception("Usuario sin acceso al sistema");
            } else {
                if (empleado.getTipo() == 2 || empleado.getTipo() == 3) {
                    Hotel hotel = ManejadorHotel.getInstance().getHotelById(empleado.getIdHotel());
                    if (hotel.getEstado() == 0) {
                        throw new Exception("No es posible ingresar al sistema, pues el hotel no esta disponible");
                    }
                    empleado.setNombreHotel(hotel.getNombre());
                    empleado.setDireccionHotel(hotel.getDireccion());
                } else if (empleado.getTipo() == 4) {
                    Restaurante restaurante = ManejadorRestaurante.getInstance().getRestauranteByID(empleado.getIdRestaurante());
                    if (restaurante.getEstado() == 0) {
                        throw new Exception("No es posible ingresar al sistema, pues el restaurante no esta disponible");
                    }
                    empleado.setNombreRestaurante(restaurante.getNombre());
                    empleado.setDireccionRestaurante(restaurante.getDireccion());
                }
                ComerDormirDesktop cdd = new ComerDormirDesktop(empleado);
                cdd.setVisible(true);
            }
        } else {
            throw new Exception("El usuario no existe");
        }
    }

    public Empleado getEmpleadoByUsuario(String usuario) {
        String consulta = "SELECT * FROM EMPLEADO WHERE USUARIO = ?";
        return ManejadorBaseDatos.getInstance().getEmpleado(consulta, usuario);
    }
    
    public Empleado getEmpleadoByDpi(String dpi){
        String consulta = "SELECT * FROM EMPLEADO WHERE DPI = ?";
        return ManejadorBaseDatos.getInstance().getEmpleado(consulta, dpi);
    }
    
    public List getEmpleadosByTipo(String tipo){
        String consulta = "SELECT * FROM EMPLEADO WHERE TIPO = ?";
        return ManejadorBaseDatos.getInstance().getEmpleados(tipo, null, consulta, 1);
    }
    
    public List getEmpleadosByEstado(int estado){
        String consulta = "SELECT * FROM EMPLEADO WHERE ESTADO = ?";
        return ManejadorBaseDatos.getInstance().getEmpleados(Integer.toString(estado), null, consulta, 1);
    }
    
    public List getEmpleadosByEstadoAndHotel(int estado, int idHotel){
        String consulta = "SELECT * FROM EMPLEADO WHERE ESTADO = ? AND ID_HOTEL = ?";
        return ManejadorBaseDatos.getInstance().getEmpleados(Integer.toString(estado), Integer.toString(idHotel), consulta, 2);
    }
    
    public List getEmpleadosByHotel(int idHotel){
        String consulta = "SELECT * FROM EMPLEADO WHERE ID_HOTEL = ?";
        return ManejadorBaseDatos.getInstance().getEmpleados(Integer.toString(idHotel), null, consulta, 1);
    }
    
    public List getEmpleadosByRestaurante(int idRestaurante){
        String consulta = "SELECT * FROM EMPLEADO WHERE ID_HOTEL = ?";
        return ManejadorBaseDatos.getInstance().getEmpleados(Integer.toString(idRestaurante), null, consulta, 1);
    }
    
    public List getEmpleadosByHotelAndTipo(int idHotel, String tipo){
        String consulta = "SELECT * FROM EMPLEADO WHERE ID_HOTEL = ? AND TIPO = ?";
        return ManejadorBaseDatos.getInstance().getEmpleados(Integer.toString(idHotel), tipo, consulta, 2);
    }
    
    public List getEmpleados(){
        String consulta = "SELECT * FROM EMPLEADO";
        return ManejadorBaseDatos.getInstance().getEmpleados(null, null, consulta, 0);
    }
    

    public void setGerente(String DPI, String nombre, String usuario, String contrasena, 
            String sueldo, Date fecha, Hotel hotel, int tipo, int opcion) throws Exception {
        if (DPI.isEmpty() || nombre.isEmpty() || usuario.isEmpty() || contrasena.isEmpty()) {
            throw new Exception("No es posible realizar la accion, existen campos vacios");
        } else if (DPI.length() != 8) {
            throw new Exception("DPI no valido");
        } else if (nombre.length() > 40) {
            throw new Exception("Nombre no valido");
        } else if (usuario.length() > 10) {
            throw new Exception("Usuario no valido");
        } else if (contrasena.length() > 15) {
            throw new Exception("Contraseña no valida");
        } else if (sueldo.isEmpty() || sueldo.contains("-")) {
            throw new Exception("Sueldo semana no valido");
        } else if (fecha == null) {
            throw new Exception("Fecha de registro no valida");
        } else if (getEmpleadoByDpi(DPI) != null) {
            throw new Exception("DPI no valido, pues ya ha sido registrado");
        } else if (getEmpleadoByUsuario(usuario) != null) {
            throw new Exception("No es posible crear el usuario, pues ya ha sido registrado");
        } else {
            if (opcion == 1) {
                Empleado empleado = new EmpleadoBuilder().dpi(Integer.parseInt(DPI)).nombre(nombre).
                        usuario(usuario).contrasena(contrasena).tipo(tipo).sueldoSemanal(Double.parseDouble(sueldo)).fechaRegistro(fecha).build();
                String accion = "INSERT INTO EMPLEADO(DPI, NOMBRE, TIPO, USUARIO, CONTRASENA, "
                        + "SUELDO_SEMANA, FECHA_REGISTRO) VALUES(?,?,?,?,?,?,?)";
                ManejadorBaseDatos.getInstance().setEmpleado(accion, empleado, 0);
            } else if (opcion == 2) {
                Empleado empleado = new EmpleadoBuilder().dpi(Integer.parseInt(DPI)).nombre(nombre).
                        usuario(usuario).contrasena(contrasena).tipo(tipo).idHotel(hotel.getId()).
                        sueldoSemanal(Double.parseDouble(sueldo)).fechaRegistro(fecha).nombreHotel(hotel.getNombre()).build();
                String accion = "INSERT INTO EMPLEADO(DPI, NOMBRE, TIPO, USUARIO, "
                        + "CONTRASENA, SUELDO_SEMANA, FECHA_REGISTRO, ID_HOTEL, NOMBRE_HOTEL) VALUES(?,?,?,?,?,?,?,?,?)";
                ManejadorBaseDatos.getInstance().setEmpleado(accion, empleado, 1);
            }
        }
    }
    
    public void setEncargadoRes(String DPI, String nombre, String usuario, String contrasena,
            String sueldo, Date fecha, Restaurante rest) throws Exception{
        if (DPI.isEmpty() || nombre.isEmpty() || usuario.isEmpty() || contrasena.isEmpty()) {
            throw new Exception("No es posible realizar la accion, existen campos vacios");
        } else if (DPI.length() != 8) {
            throw new Exception("DPI no valido");
        } else if (nombre.length() > 40) {
            throw new Exception("Nombre no valido");
        } else if (usuario.length() > 10) {
            throw new Exception("Usuario no valido");
        } else if (contrasena.length() > 15) {
            throw new Exception("Contraseña no valida");
        } else if (sueldo.isEmpty() || sueldo.contains("-")) {
            throw new Exception("Sueldo semana no valido");
        } else if (fecha == null) {
            throw new Exception("Fecha de registro no valida");
        } else if (getEmpleadoByDpi(DPI) != null) {
            throw new Exception("DPI no valido, pues ya ha sido registrado");
        } else if (getEmpleadoByUsuario(usuario) != null) {
            throw new Exception("No es posible crear el usuario, pues ya ha sido registrado");
        } else {
            Empleado empleado = new EmpleadoBuilder().dpi(Integer.parseInt(DPI)).nombre(nombre).
                    usuario(usuario).tipo(4).contrasena(contrasena).sueldoSemanal(Double.parseDouble(sueldo)).
                    fechaRegistro(fecha).idRestaurante(rest.getId()).nombreRestaurante(rest.getNombre()).build();
            String accion = "INSERT INTO EMPLEADO(DPI, NOMBRE, TIPO, USUARIO, "
                    + "CONTRASENA, SUELDO_SEMANA, FECHA_REGISTRO, ID_RESTAURANTE, NOMBRE_RESTAURANTE) VALUES(?,?,?,?,?,?,?,?,?)";
                ManejadorBaseDatos.getInstance().setEmpleado(accion, empleado, 2);
        }
    }

    public void updateEmpleado(Empleado empleado, String dato, int opcion) throws Exception {
        if(dato.isEmpty()){
            throw new Exception("Campo vacio");
        } else if (dato.length() > 40){
            throw new Exception("Nombre no valido");
        } else {
            if(opcion == 1){
                String accion = "UPDATE EMPLEADO SET NOMBRE = ? WHERE DPI = ?";
                empleado.setNombre(dato);
                ManejadorBaseDatos.getInstance().updateEmpleado(empleado, accion, 1);
            } else if (opcion == 2){
                String accion = "UPDATE EMPLEADO SET ESTADO = ? WHERE DPI = ?";
                empleado.setEstado(Integer.parseInt(dato));
                ManejadorBaseDatos.getInstance().updateEmpleado(empleado, accion, 2);
            }
        }
    }
    
}
