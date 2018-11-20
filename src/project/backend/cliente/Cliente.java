package project.backend.cliente;

/**
 *
 * @author fabricio
 */
public class Cliente {
    
    private int dpi;
    private String nombre;
    private String direccion;
    private int telefono;
    
    private Cliente(){
    }

    Cliente(ClienteBuilder builder){
        
        this.dpi = builder.getDpi();
        this.nombre = builder.getNombre();
        this.direccion = builder.getDireccion();
        this.telefono = builder.getTelefono();
        
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
    
}
