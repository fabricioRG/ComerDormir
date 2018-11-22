package project.backend.alojamiento;

import java.util.Date;

/**
 *
 * @author fabricio
 */
public class AlojamientoBuilder {
    
    private int id;
    private int idReservacion;
    private Date fechaEntrada;
    private Date fechaSalida;
    private int dpiCliente;
    private String nombreCliente;
    private double costoHabitacion;
    private int cantidadDias;
    private double precioHabitacion;
    private int activo;
    private int idHotel;
    private String nombreHotel;
    
    public AlojamientoBuilder(){
    }
    
    public AlojamientoBuilder id(int id){
        this.id = id;
        return this;
    }
    
    public AlojamientoBuilder idReservacion(int idReservacion){
        this.idReservacion = idReservacion;
        return this;
    }
    
    public AlojamientoBuilder fechaEntrada(Date fechaEntrada){
        this.fechaEntrada = fechaEntrada;
        return this;
    }
    
    public AlojamientoBuilder nombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
        return this;
    }
    
    public AlojamientoBuilder fechaSalida(Date fechaSalida){
        this.fechaSalida = fechaSalida;
        return this;
    }
    
    public AlojamientoBuilder dpiCliente(int dpiCliente){
        this.dpiCliente = dpiCliente;
        return this;
    }
    
    public AlojamientoBuilder costoHabitacion(double costoHabitacion){
        this.costoHabitacion = costoHabitacion;
        return this;
    }
    
    public AlojamientoBuilder cantidadDias(int cantidadDias){
        this.cantidadDias = cantidadDias;
        return this;
    }
    
    public AlojamientoBuilder precioHabitacion(double precioHabitacion){
        this.precioHabitacion = precioHabitacion;
        return this;
    }
    
    public AlojamientoBuilder activo(int activo){
        this.activo = activo;
        return this;
    }
    
    public AlojamientoBuilder idHotel(int idHotel){
        this.idHotel = idHotel;
        return this;
    }
    
    public AlojamientoBuilder nombreHotel(String nombreHotel){
        this.nombreHotel = nombreHotel;
        return this;
    }
    
    public Alojamiento builder(){
        return new Alojamiento(this);
    }

    public int getId() {
        return id;
    }

    public int getIdReservacion() {
        return idReservacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public int getDpiCliente() {
        return dpiCliente;
    }

    public double getCostoHabitacion() {
        return costoHabitacion;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public int getActivo() {
        return activo;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }
    
}
