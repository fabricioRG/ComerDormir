/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.backend.opinion;

/**
 *
 * @author fabricio
 */
public class Opinion {
    
    private int id;
    private int idHotel;
    private String nombreHotel;
    private int idRestaurante;
    private String nombreRestaurante;
    private String comentario;
    private int puntuacion;
    private String nombreCliente;
    
    Opinion(OpinionBuilder builder){
        this.id = builder.getId();
        this.idHotel = builder.getIdHotel();
        this.nombreHotel = builder.getNombreHotel();
        this.idRestaurante = builder.getIdRestaurante();
        this.nombreRestaurante = builder.getNombreRestaurante();
        this.comentario = builder.getComentario();
        this.puntuacion = builder.getPuntuacion();
        this.nombreCliente = builder.getNombreCliente();
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

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
}
