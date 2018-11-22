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
public class ConsumoBuilder {
    
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
    
    public ConsumoBuilder(){
    }

    public ConsumoBuilder idRestaurante(int idRestaurante){
        this.idRestaurante = idRestaurante;
        return this;
    }
    
    public ConsumoBuilder id(int id){
        this.id = id;
        return this;
    }
    public ConsumoBuilder monto(double monto) {
        this.monto = monto;
        return this;
    }
    public ConsumoBuilder costo(double costo){
        this.costo = costo;
        return this;
    }
    public ConsumoBuilder fecha(Date fecha){
        this.fecha = fecha;
        return this;
    }
    public ConsumoBuilder idMenu(int idMenu){
        this.idMenu = idMenu;
        return this;
    }
    public ConsumoBuilder idAlojamiento(int idAlojamiento){
        this.idAlojamiento = idAlojamiento;
        return this;
    }
    public ConsumoBuilder nombreMenu(String nombreMenu){
        this.nombreMenu = nombreMenu;
        return this;
    }
    public ConsumoBuilder nombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
        return this;
    }
    
    public ConsumoBuilder nombreRestaurante(String nombreRestaurante){
        this.nombreRestaurante = nombreRestaurante;
        return this;
    }
    
    public Consumo build(){
        return new Consumo(this);
    }

    public int getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public double getCosto() {
        return costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }
    
}
