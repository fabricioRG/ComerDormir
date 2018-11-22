/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.backend.promocion;

import java.util.Date;

/**
 *
 * @author fabricio
 */
public class PromocionBuilder {
    
    private int id;
    private int idHabitacion;
    private int numeroHabitacion;
    private String nombreHotel;
    private int idRestaurante;
    private String nombreRestaurante;
    private int dpiCliente;
    private String nombreCliente;
    private double porcentaje;
    private Date fechaInicio;
    private Date fechaFinal;
    
    public PromocionBuilder(){
    }

    public PromocionBuilder id(int id){
        this.id = id;
        return this;
    }
    public PromocionBuilder numeroHabitacion(int numeroHabitacion){
        this.numeroHabitacion = numeroHabitacion;
        return this;
    }
    
    public PromocionBuilder nombreHotel(String nombreHotel){
        this.nombreHotel = nombreHotel;
        return this;
    }
    
    public PromocionBuilder nombreRestaurante(String nombreRestaurante){
        this.nombreRestaurante = nombreRestaurante;
        return this;
    }
    
    public PromocionBuilder nombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
        return this;
    }
    
    public PromocionBuilder idHabitacion(int idHabitacion){
        this.idHabitacion = idHabitacion;
        return this;
    }
    
    public PromocionBuilder porcentaje(double porcentaje){
        this.porcentaje = porcentaje;
        return this;
    }
    
    public PromocionBuilder idRestaurante(int idRestaurante){
        this.idRestaurante = idRestaurante;
        return this;
    }
    
    public PromocionBuilder dpiCliente(int dpiCliente){
        this.dpiCliente = dpiCliente;
        return this;
    }
    
    public PromocionBuilder fechaInicio(Date fechaInicio){
        this.fechaInicio = fechaInicio;
        return this;
    }
    
    public PromocionBuilder fechaFinal(Date fechaFinal){
        this.fechaFinal = fechaFinal;
        return this;
    }
    
    public Promocion build(){
        return new Promocion(this);
    }

    public int getId() {
        return id;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getDpiCliente() {
        return dpiCliente;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }
    
}

