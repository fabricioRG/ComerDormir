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
public class OpinionBuilder {
    
    private int id;
    private int idHotel;
    private String nombreHotel;
    private int idRestaurante;
    private String nombreRestaurante;
    private String comentario;
    private int puntuacion;
    private String nombreCliente;
    
    public OpinionBuilder(){
    }

    public OpinionBuilder id(int id){
        this.id = id;
        return this;
    }
    
    public OpinionBuilder idHotel (int idHotel){
        this.idHotel = idHotel;
        return this;
    }
    
    public OpinionBuilder nombreHotel(String nombreHotel){
        this.nombreHotel = nombreHotel;
        return this;
    }
    
    public OpinionBuilder comentario(String comentario){
        this.comentario = comentario;
        return this;
    }
    
    public OpinionBuilder puntuacion(int puntuacion){
        this.puntuacion = puntuacion;
        return this;
    }
    
    public OpinionBuilder nombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
        return this;
    }
    
    public OpinionBuilder idRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
        return this;
    }
    
    public OpinionBuilder nombreRestaurante(String nombreRestaurante){
        this.nombreRestaurante = nombreRestaurante;
        return this;
    }
    
    public Opinion build(){
        return new Opinion(this);
    }

    public int getId() {
        return id;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public String getComentario() {
        return comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    
}
