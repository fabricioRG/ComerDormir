package project.backend.hotel;

/**
 *
 * @author fabricio
 */
public class HotelBuilder {

    private int id;
    private String nombre;
    private String direccion;
    private int estado;

    public HotelBuilder(){
    }

    public HotelBuilder id(int id){
        this.id = id;
        return this;
    }
    
    public HotelBuilder nombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    
    public HotelBuilder direccion(String direccion){
        this.direccion = direccion;
        return this;
    }
    
    public HotelBuilder estado(int estado){
        this.estado = estado;
        return this;
    }
    
    public Hotel build(){
        return new Hotel(this);
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

    public int getEstado() {
        return estado;
    }
    
}
