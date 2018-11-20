package project.backend.empleado;

import comerdormir.frontend.ComerDormirDesktop;
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
                        throw new Exception("No es posible ingresar al sistema, pues el hotel no esta disponible");
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
        return ManejadorBaseDatos.getInstance().getEmpleados(tipo, consulta, 1);
    }
    
    public List getEmpleadosByEstado(int estado){
        String consulta = "SELECT * FROM EMPLEADO WHERE ESTADO = ?";
        return ManejadorBaseDatos.getInstance().getEmpleados(Integer.toString(estado), consulta, 1);
    }
    
    public List getEmpleados(){
        String consulta = "SELECT * FROM EMPLEADO";
        return ManejadorBaseDatos.getInstance().getEmpleados(null, consulta, 0);
    }
    

    public void setGerente(String DPI, String nombre, String usuario, String contrasena, Hotel hotel, int opcion) throws Exception {
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
        } else if (getEmpleadoByDpi(DPI) != null) {
            throw new Exception("DPI no valido, pues ya ha sido registrado");
        } else if (getEmpleadoByUsuario(usuario) != null) {
            throw new Exception("No es posible crear el usuario, pues ya ha sido registrado");
        } else {
            if (opcion == 1) {
                Empleado empleado = new EmpleadoBuilder().dpi(Integer.parseInt(DPI)).nombre(nombre).
                        usuario(usuario).contrasena(contrasena).tipo(1).build();
                String accion = "INSERT INTO EMPLEADO(DPI, NOMBRE, TIPO, USUARIO, CONTRASENA) VALUES(?,?,?,?,?)";
                ManejadorBaseDatos.getInstance().setEmpleado(accion, empleado, 0);
            } else if (opcion == 2) {
                Empleado empleado = new EmpleadoBuilder().dpi(Integer.parseInt(DPI)).nombre(nombre).
                        usuario(usuario).contrasena(contrasena).tipo(2).idHotel(hotel.getId()).build();
                String accion = "INSERT INTO EMPLEADO(DPI, NOMBRE, TIPO, USUARIO, CONTRASENA, ID_HOTEL) VALUES(?,?,?,?,?,?)";
                ManejadorBaseDatos.getInstance().setEmpleado(accion, empleado, 1);
            }
        }
    }
    
    public void setEncargadoRes(String DPI, String nombre, String usuario, String contrasena, Restaurante rest) throws Exception{
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
        } else if (getEmpleadoByDpi(DPI) != null) {
            throw new Exception("DPI no valido, pues ya ha sido registrado");
        } else if (getEmpleadoByUsuario(usuario) != null) {
            throw new Exception("No es posible crear el usuario, pues ya ha sido registrado");
        } else {
            Empleado empleado = new EmpleadoBuilder().dpi(Integer.parseInt(DPI)).nombre(nombre).
                    usuario(usuario).tipo(4).contrasena(contrasena).idRestaurante(rest.getId()).build();
            String accion = "INSERT INTO EMPLEADO(DPI, NOMBRE, TIPO, USUARIO, CONTRASENA, ID_RESTAURANTE) VALUES(?,?,?,?,?,?)";
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
