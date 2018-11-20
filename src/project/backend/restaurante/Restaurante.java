package project.backend.restaurante;

/**
 *
 * @author fabricio
 */
public class Restaurante {

    private int id;
    private String nombre;
    private String direccion;
    private int estado;
    private int independiente;
    private int idHotel;
    private String nombreHotel;

    private Restaurante(){
    }

    Restaurante(RestauranteBuilder builder){
        
        if(builder.getNombre() == null){
            throw new IllegalArgumentException("Nombre es requerido");
        } else if(builder.getDireccion() == null){
            throw new IllegalArgumentException("Direccion es requerida");
        }
        
        this.id = builder.getId();
        this.nombre = builder.getNombre();
        this.direccion = builder.getDireccion();
        this.estado = builder.getEstado();
        this.independiente = builder.getIndependiente();
        this.idHotel = builder.getIdHotel();
        this.nombreHotel = builder.getNombreHotel();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getIndependiente() {
        return independiente;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setIndependiente(int independiente) {
        this.independiente = independiente;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }
    
}
