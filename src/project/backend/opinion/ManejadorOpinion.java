/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.backend.opinion;

import java.text.SimpleDateFormat;
import java.util.List;
import project.backend.basedatos.ManejadorBaseDatos;
import project.backend.hotel.Hotel;
import project.backend.restaurante.Restaurante;

/**
 *
 * @author fabricio
 */
public class ManejadorOpinion {

    private static ManejadorOpinion INSTANCE = null;
    private SimpleDateFormat fechaFormat = null;

    private ManejadorOpinion() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorOpinion();
        }
    }

    public static ManejadorOpinion getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public void setOpinionHotel(Hotel hotel, String comentario, String puntuacion, String nombreCliente) throws Exception {
        String accion = " ";
        if (comentario.isEmpty()) {
            throw new Exception("Comentario vacios");
        } else if (nombreCliente.length() > 20) {
            throw new Exception("Nombre no valido");
        } else if (comentario.length() > 100) {
            throw new Exception("Comentario no valido");
        } else {
            Opinion opinion = new OpinionBuilder().idHotel(hotel.getId()).comentario(comentario).puntuacion(Integer.parseInt(puntuacion)).
                    nombreCliente(nombreCliente).nombreHotel(hotel.getNombre()).build();
            if (nombreCliente.isEmpty()) {
                accion = "INSERT INTO OPINION_HOTEL (ID_HOTEL, COMENTARIO, PUNTUACION, "
                        + " NOMBRE_HOTEL) VALUES (?,?,?,?)";
                ManejadorBaseDatos.getInstance().setOpinionHotel(accion, opinion, 0);
            } else {
                accion = "INSERT INTO OPINION_HOTEL (ID_HOTEL, COMENTARIO, PUNTUACION, "
                        + "NOMBRE_HOTEL, NOMBRE_CLIENTE) VALUES (?,?,?,?,?)";
                ManejadorBaseDatos.getInstance().setOpinionHotel(accion, opinion, 1);
            }
        }
    }
    
    public void setOpinionRestaurante(Restaurante restaurante, String comentario, String puntuacion, String nombreCliente) throws Exception {
        String accion = " ";
        if (comentario.isEmpty()) {
            throw new Exception("Comentario vacios");
        } else if (nombreCliente.length() > 20) {
            throw new Exception("Nombre no valido");
        } else if (comentario.length() > 100) {
            throw new Exception("Comentario no valido");
        } else {
            Opinion opinion = new OpinionBuilder().idRestaurante(restaurante.getId()).comentario(comentario).puntuacion(Integer.parseInt(puntuacion)).
                    nombreCliente(nombreCliente).nombreRestaurante(restaurante.getNombre()).build();
            if (nombreCliente.isEmpty()) {
                accion = "INSERT INTO OPINION_RESTAURANTE (ID_RESTAURANTE, COMENTARIO, PUNTUACION, "
                        + " NOMBRE_RESTAURANTE) VALUES (?,?,?,?)";
                ManejadorBaseDatos.getInstance().setOpinionRestaurante(accion, opinion, 0);
            } else {
                accion = "INSERT INTO OPINION_RESTAURANTE (ID_RESTAURANTE, COMENTARIO, PUNTUACION, "
                        + "NOMBRE_RESTAURANTE, NOMBRE_CLIENTE) VALUES (?,?,?,?,?)";
                ManejadorBaseDatos.getInstance().setOpinionRestaurante(accion, opinion, 1);
            }
        }
    }
    
    public List getOpinionesHotel(){
        String accion = "SELECT * FROM OPINION_HOTEL ORDER BY PUNTUACION DESC";
        return ManejadorBaseDatos.getInstance().getOpinionesHotel(accion, 0, null);
    }
    
    public List getOpinionesRestaurante(){
        String accion = "SELECT * FROM OPINION_RESTAURANTE ORDER BY PUNTUACION DESC";
        return ManejadorBaseDatos.getInstance().getOpinionesRestaurante(accion, 0, null);
    }
    
    public List getOpinionesByIdRestaurante(int idRestaurante){
        String consulta = "SELECT * FROM OPINION_RESTAURANTE WHERE ID_RESTAURANTE = ? ORDER BY PUNTUACION DESC";
        return ManejadorBaseDatos.getInstance().getOpinionesRestaurante(consulta, 1, Integer.toString(idRestaurante));
    }
    
}
