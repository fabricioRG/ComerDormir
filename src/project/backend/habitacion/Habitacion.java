/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.backend.habitacion;

import java.util.Date;

/**
 *
 * @author fabricio
 */
public class Habitacion {
    
    private int id;
    private int idHotel;
    private String nombreHotel;
    private String direccionHotel;
    private int numero;
    private String tipo;
    private int nivel;
    private double precio;
    private Date fechaRegistro;
    private double costoMantenimiento;
    
    private Habitacion(){
    }

    Habitacion(HabitacionBuilder builder){
        
        this.id = builder.getId();
        this.idHotel = builder.getIdHotel();
        this.nombreHotel = builder.getDireccionHotel();
        this.direccionHotel = builder.getDireccionHotel();
        this.numero = builder.getNumero();
        this.tipo = builder.getTipo();
        this.nivel = builder.getNivel();
        this.precio = builder.getPrecio();
        this.costoMantenimiento = builder.getCostoMantenimiento();
        this.fechaRegistro = builder.getFechaRegistro();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDireccionHotel() {
        return direccionHotel;
    }

    public void setDireccionHotel(String direccionHotel) {
        this.direccionHotel = direccionHotel;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public void setCostoMantenimiento(double costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
    }
    
}
