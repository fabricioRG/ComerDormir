package project.backend.empleado;

/**
 *
 * @author fabricio
 */
public class EmpleadoBuilder {
    
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
    
    public EmpleadoBuilder(){
    }
    
    public EmpleadoBuilder dpi(int dpi){
        this.dpi = dpi;
        return this;
    }
    
    public EmpleadoBuilder nombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    
    public EmpleadoBuilder usuario(String usuario){
        this.usuario = usuario;
        return this;
    }
    
    public EmpleadoBuilder contrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }
    
    public EmpleadoBuilder tipo(int tipo){
        this.tipo = tipo;
        return this;
    }
    
    public EmpleadoBuilder estado(int estado){
        this.estado = estado;
        return this;
    }
    
    public EmpleadoBuilder nombreHotel(String nombreHotel){
        this.nombreHotel = nombreHotel;
        return this;
    }
    
    public EmpleadoBuilder direccionHotel(String direccionHotel){
        this.direccionHotel = direccionHotel;
        return this;
    }
    
    public EmpleadoBuilder idHotel(int idHotel){
        this.idHotel = idHotel;
        return this;
    }
    
    public EmpleadoBuilder nombreRestaurante(String nombreRestaurante){
        this.nombreRestaurante = nombreRestaurante;
        return this;
    }
    
    public EmpleadoBuilder direccionRestaurante(String direccionRestaurante){
        this.direccionRestaurante = direccionRestaurante;
        return this;
    }
    
    public EmpleadoBuilder idRestaurante(int idRestaurante){
        this.idRestaurante = idRestaurante;
        return this;
    }
    
    public Empleado build(){
        return new Empleado(this);
    }
    
    //Getters
    
    public int getDpi(){
        return dpi;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getTipo(){
        return tipo;
    }
    
    public int getEstado(){
        return estado;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public String getContrasena(){
        return contrasena;
    }
    
    public String getNombreHotel(){
        return nombreHotel;
    }
    
    public String getDireccionHotel(){
        return direccionHotel;
    }
    
    public int getIdHotel(){
        return idHotel;
    }
    
    public String getNombreRestaurante(){
        return nombreRestaurante;
    }
    
    public String getDireccionRestaurante(){
        return direccionRestaurante;
    }
    
    public int getIdRestaurante(){
        return idRestaurante;
    }
    
}
