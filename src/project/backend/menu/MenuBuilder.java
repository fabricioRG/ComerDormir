/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.backend.menu;

/**
 *
 * @author fabricio
 */
public class MenuBuilder {
    
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private double costo;
    private int idRestaurante;
    private String nombreRestaurante;
    private String tipo;
    
    public MenuBuilder(){
    }

    public MenuBuilder id(int id){
        this.id = id;
        return this;
    }
    
    public MenuBuilder nombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    
    public MenuBuilder precio(double precio){
        this.precio = precio;
        return this;
    }
    
    public MenuBuilder descripcion(String descripcion){
        this.descripcion = descripcion;
        return this;
    }
    
    public MenuBuilder costo(double costo){
        this.costo = costo;
        return this;
    }
    
    public MenuBuilder idRestaurante(int idRestaurante){
        this.idRestaurante = idRestaurante;
        return this;
    }
    
    public MenuBuilder nombreRestaurante(String nombreRestaurante){
        this.nombreRestaurante = nombreRestaurante;
        return this;
    }
    
    public MenuBuilder tipo(String tipo){
        this.tipo = tipo;
        return this;
    }
    
    public Menu build(){
        return new Menu(this);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public String getTipo() {
        return tipo;
    }
    
    
    
}
