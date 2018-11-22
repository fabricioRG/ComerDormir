package project.backend.alojamiento;

import java.util.Date;

/**
 *
 * @author fabricio
 */
public class Alojamiento {
    
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
    
    Alojamiento(AlojamientoBuilder builder){
        this.id = builder.getId();
        this.idReservacion = builder.getIdReservacion();
        this.fechaEntrada = builder.getFechaEntrada();
        this.fechaSalida = builder.getFechaSalida();
        this.dpiCliente = builder.getDpiCliente();
        this.costoHabitacion = builder.getCostoHabitacion();
        this.cantidadDias = builder.getCantidadDias();
        this.precioHabitacion = builder.getPrecioHabitacion();
        this.activo = builder.getActivo();
        this.idHotel = builder.getIdHotel();
        this.nombreHotel = builder.getNombreHotel();
        this.nombreCliente = builder.getNombreCliente();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getDpiCliente() {
        return dpiCliente;
    }

    public void setDpiCliente(int dpiCliente) {
        this.dpiCliente = dpiCliente;
    }

    public double getCostoHabitacion() {
        return costoHabitacion;
    }

    public void setCostoHabitacion(double costoHabitacion) {
        this.costoHabitacion = costoHabitacion;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
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
    
}
