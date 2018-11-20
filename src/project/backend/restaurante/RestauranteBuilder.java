package project.backend.restaurante;

/**
 *
 * @author fabricio
 */
public class RestauranteBuilder {
    
    private int id;
    private String nombre;
    private String direccion;
    private int estado;
    private int independiente;
    private int idHotel;
    private String nombreHotel;
    
    public RestauranteBuilder(){
    }

    public RestauranteBuilder id(int id){
        this.id = id;
        return this;
    }
    
    public RestauranteBuilder nombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    
    public RestauranteBuilder direccion(String direccion){
        this.direccion = direccion;
        return this;
    }
    
    public RestauranteBuilder independiente(int independiente){
        this.independiente = independiente;
        return this;
    }
    
    public RestauranteBuilder idHotel(int idHotel){
        this.idHotel = idHotel;
        return this;
    }
    
    public RestauranteBuilder nombreHotel(String nombreHotel){
        this.nombreHotel = nombreHotel;
        return this;
    }
    
    public RestauranteBuilder estado(int estado){
        this.estado = estado;
        return this;
    }
    
    public Restaurante build(){
        return new Restaurante(this);
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
    
}
