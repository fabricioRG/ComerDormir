package project.backend.cliente;

/**
 *
 * @author fabricio
 */
public class ClienteBuilder {
    
    private int dpi;
    private String nombre;
    private String direccion;
    private int telefono;
    
    public ClienteBuilder(){
    }

    public ClienteBuilder dpi(int dpi){
        this.dpi = dpi;
        return this;
    }
    
    public ClienteBuilder nombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    
    public ClienteBuilder direccion(String direccion){
        this.direccion = direccion;
        return this;
    }
    
    public ClienteBuilder telefono(int telefono){
        this.telefono = telefono;
        return this;
    }
    
    public Cliente build(){
        return new Cliente(this);
    }

    public int getDpi() {
        return dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }
    
}
