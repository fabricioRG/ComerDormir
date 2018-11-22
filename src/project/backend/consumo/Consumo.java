/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.backend.consumo;

import java.util.Date;

/**
 *
 * @author fabricio
 */
public class Consumo {
    
    private int id;
    private double monto;
    private double costo;
    private Date fecha;
    private int idMenu;
    private int idAlojamiento;
    private int idRestaurante;
    private String nombreMenu;
    private String nombreCliente;
    private String nombreRestaurante;
    
    Consumo(ConsumoBuilder builder ){
        this.id = builder.getId();
        this.monto = builder.getMonto();
        this.costo = builder.getCosto();
        this.fecha = builder.getFecha();
        this.idMenu = builder.getIdMenu();
        this.idAlojamiento = builder.getIdAlojamiento();
        this.nombreMenu = builder.getNombreMenu();
        this.nombreCliente = builder.getNombreCliente();
        this.nombreRestaurante = builder.getNombreRestaurante();
        this.idRestaurante = builder.getIdRestaurante();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }
    
}
