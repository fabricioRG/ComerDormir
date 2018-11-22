package project.backend.reservacion;

import java.util.Date;

/**
 *
 * @author fabricio
 */
public class ReservacionBuilder {
    
    private int id;
    private int idHabitacion;
    private int noHabitacion;
    private double precioHabitacion;
    private int cantidadDias;
    private int dpiCliente;
    private String nombreCliente;
    private String nombreHotel;
    private int idHotel;
    private Date fechaInicio;
    private Date fechaSalida;
    private int estado;
    private double costoMantenimiento;
    private int confirmado;
    
    public ReservacionBuilder(){
    }

    public ReservacionBuilder id(int id){
        this.id = id;
        return this;
    }
    public ReservacionBuilder idHabitacion(int idHabitacion){
        this.idHabitacion = idHabitacion;
        return this;
    }
    public ReservacionBuilder noHabitacion(int noHabitacion){
        this.noHabitacion = noHabitacion;
        return this;
    }
    public ReservacionBuilder precioHabitacion(double precioHabitacion){
        this.precioHabitacion = precioHabitacion;
        return this;
    }
    
    public ReservacionBuilder idHotel(int idHotel){
        this.idHotel = idHotel;
        return this;
    }
    
    public ReservacionBuilder cantidadDias(int cantidadDias){
        this.cantidadDias = cantidadDias;
        return this;
    }
    
    public ReservacionBuilder dpiCliente(int dpiCliente){
        this.dpiCliente = dpiCliente;
        return this;
    }
    public ReservacionBuilder nombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
        return this;
    }
    public ReservacionBuilder nombreHotel(String nombreHotel){
        this.nombreHotel = nombreHotel;
        return this;
    }
    public ReservacionBuilder fechaInicio(Date fechaInicio){
        this.fechaInicio = fechaInicio;
        return this;
    }
    public ReservacionBuilder fechaSalida(Date fechaSalida){
        this.fechaSalida = fechaSalida;
        return this;
    }
    public ReservacionBuilder costoMantenimiento(double costoMantenimiento){
        this.costoMantenimiento = costoMantenimiento;
        return this;
    }
    public ReservacionBuilder confirmado(int confirmado){
        this.confirmado = confirmado;
        return this;
    }
    
    public Reservacion build(){
        return new Reservacion(this);
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public int getId() {
        return id;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public int getNoHabitacion() {
        return noHabitacion;
    }

    public double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public int getDpiCliente() {
        return dpiCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public int getEstado() {
        return estado;
    }

    public double getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public int getConfirmado() {
        return confirmado;
    }
    
}
