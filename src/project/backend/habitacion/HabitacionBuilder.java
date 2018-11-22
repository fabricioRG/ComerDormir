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
public class HabitacionBuilder {
    
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
    
    public HabitacionBuilder(){
    }

    public HabitacionBuilder id(int id){
        this.id = id;
        return this;
    }
    
    public HabitacionBuilder idHotel(int idHotel){
        this.idHotel = idHotel;
        return this;
    }
    
    public HabitacionBuilder fechaRegistro(Date fechaRegistro){
        this.fechaRegistro = fechaRegistro;
        return this;
    }
    
    public HabitacionBuilder nombreHotel(String nombreHotel){
        this.nombreHotel = nombreHotel;
        return this;
    }
    
    public HabitacionBuilder direccionHotel(String direccionHotel){
        this.direccionHotel = direccionHotel;
        return this;
    }
    
    public HabitacionBuilder numero(int numero){
        this.numero = numero;
        return this;
    }
    
    public HabitacionBuilder tipo(String tipo){
        this.tipo = tipo;
        return this;
    }
    
    public HabitacionBuilder nivel(int nivel){
        this.nivel = nivel;
        return this;
    }
    
    public HabitacionBuilder precio(double precio){
        this.precio = precio;
        return this;
    }
    
    public HabitacionBuilder costoMantenimiento(double costoMantenimiento){
        this.costoMantenimiento = costoMantenimiento;
        return this;
    }
    
    public Habitacion build(){
        return new Habitacion(this);
    }

    public int getId() {
        return id;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public String getDireccionHotel() {
        return direccionHotel;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public double getPrecio() {
        return precio;
    }

    public double getCostoMantenimiento() {
        return costoMantenimiento;
    }
    
}
