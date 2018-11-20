package project.backend.empleado;

/**
 *
 * @author fabricio
 */
public class Empleado {

    private int dpi;
    private String nombre;
    private String usuario;
    private int tipo;
    private int estado;
    private String contrasena;
    private String nombreHotel;
    private String direccionHotel;
    private int idHotel;
    private String nombreRestaurante;
    private String direccionRestaurante;
    private int idRestaurante;

    private Empleado() {
    }

    Empleado(EmpleadoBuilder builder) {

        if (builder.getDpi() == 0) {
            throw new IllegalArgumentException("DPI es requerido");
        } else if (builder.getNombre() == null) {
            throw new IllegalArgumentException("Nombre de empleado es requerido");
        } else if (builder.getUsuario() == null) {
            throw new IllegalArgumentException("Usuario es requerido");
        } else if (builder.getContrasena() == null) {
            throw new IllegalArgumentException("Contrasena es requerida");
        }

        this.dpi = builder.getDpi();
        this.nombre = builder.getNombre();
        this.usuario = builder.getUsuario();
        this.tipo = builder.getTipo();
        this.estado = builder.getEstado();
        this.contrasena = builder.getContrasena();
        this.nombreHotel = builder.getNombreHotel();
        this.direccionHotel = builder.getDireccionHotel();
        this.idHotel = builder.getIdHotel();
        this.nombreRestaurante = builder.getNombreRestaurante();
        this.direccionRestaurante = builder.getDireccionRestaurante();
        this.idRestaurante = builder.getIdRestaurante();
    }

    public int getDpi() {
        return dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getTipo() {
        return tipo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public String getDireccionHotel() {
        return direccionHotel;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public String getDireccionRestaurante() {
        return direccionRestaurante;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public int getEstado() {
        return estado;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public void setDireccionHotel(String direccionHotel) {
        this.direccionHotel = direccionHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public void setDireccionRestaurante(String direccionRestaurante) {
        this.direccionRestaurante = direccionRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

}
