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
public class Menu {

    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private double costo;
    private int idRestaurante;
    private String nombreRestaurante;
    private String tipo;

    Menu(MenuBuilder builder) {
        this.id = builder.getId();
        this.nombre = builder.getNombre();
        this.precio = builder.getPrecio();
        this.costo = builder.getCosto();
        this.idRestaurante = builder.getIdRestaurante();
        this.nombreRestaurante = builder.getNombreRestaurante();
        this.tipo = builder.getTipo();
        this.descripcion = builder.getDescripcion();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
