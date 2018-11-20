package project.backend.hotel;

/**
 *
 * @author fabricio
 */
public class Hotel {
    
    private int id;
    private String nombre;
    private String direccion;
    private int estado;
    
    Hotel(HotelBuilder builder){
        
        if(builder.getNombre() == null){
            throw new IllegalArgumentException("Nombre es requerido");
        } else if(builder.getDireccion() == null){
            throw new IllegalArgumentException("Direccion es requerida");
        }
        
        this.id = builder.getId();
        this.nombre = builder.getNombre();
        this.direccion = builder.getDireccion();
        this.estado = builder.getEstado();
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
    
}
