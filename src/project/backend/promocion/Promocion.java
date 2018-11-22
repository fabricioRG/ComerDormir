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
public class Promocion {

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

    Promocion(PromocionBuilder builder) {
        this.id = builder.getId();
        this.idHabitacion = builder.getIdHabitacion();
        this.idRestaurante = builder.getIdRestaurante();
        this.dpiCliente = builder.getDpiCliente();
        this.porcentaje = builder.getPorcentaje();
        this.fechaInicio = builder.getFechaInicio();
        this.fechaFinal = builder.getFechaFinal();
        this.numeroHabitacion = builder.getNumeroHabitacion();
        this.nombreHotel = builder.getNombreHotel();
        this.nombreRestaurante = builder.getNombreRestaurante();
        this.nombreCliente = builder.getNombreCliente();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public int getDpiCliente() {
        return dpiCliente;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setDpiCliente(int dpiCliente) {
        this.dpiCliente = dpiCliente;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

}
