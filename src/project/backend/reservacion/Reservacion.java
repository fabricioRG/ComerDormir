package project.backend.reservacion;

import java.util.Date;

/**
 *
 * @author fabricio
 */
public class Reservacion {

    private int id;
    private int idHabitacion;
    private int noHabitacion;
    private double precioHabitacion;
    private int cantidadDias;
    private int dpiCliente;
    private String nombreCliente;
    private String nombreHotel;
    private Date fechaInicio;
    private Date fechaSalida;
    private int estado;
    private double costoMantenimiento;
    private int confirmado;
    
    Reservacion(ReservacionBuilder builder){
        this.id = builder.getId();
        this.idHabitacion = builder.getIdHabitacion();
        this.noHabitacion = builder.getNoHabitacion();
        this.precioHabitacion = builder.getPrecioHabitacion();
        this.cantidadDias = builder.getCantidadDias();
        this.dpiCliente = builder.getDpiCliente();
        this.nombreCliente = builder.getNombreCliente();
        this.nombreHotel = builder.getNombreHotel();
        this.fechaInicio = builder.getFechaInicio();
        this.fechaSalida = builder.getFechaSalida();
        this.estado = builder.getEstado();
        this.costoMantenimiento = builder.getCostoMantenimiento();
        this.confirmado = builder.getConfirmado();
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

    public int getNoHabitacion() {
        return noHabitacion;
    }

    public void setNoHabitacion(int noHabitacion) {
        this.noHabitacion = noHabitacion;
    }

    public double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public int getDpiCliente() {
        return dpiCliente;
    }

    public void setDpiCliente(int dpiCliente) {
        this.dpiCliente = dpiCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public void setCostoMantenimiento(double costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }
    
}
