/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.backend.promocion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import project.backend.basedatos.ManejadorBaseDatos;
import project.backend.habitacion.Habitacion;
import project.backend.restaurante.Restaurante;

/**
 *
 * @author fabricio
 */
public class ManejadorPromocion {

    private static ManejadorPromocion INSTANCE = null;
    private SimpleDateFormat fechaFormat = null;

    private ManejadorPromocion() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorPromocion();
        }
    }

    public static ManejadorPromocion getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public void setPromocionHabitacion(Habitacion habitacion, String porcentaje,
            Date fechaInicio, Date fechaFinal) throws Exception {
        if (getPromocionByDateHabitacion(fechaInicio, fechaFinal) != null) {
            throw new Exception("No es posible registrar la promocion, ya hay una promocion en las fechas indicadas");
        } else if (porcentaje.isEmpty()) {
            throw new Exception("Porcentaje no valido");
        } else {
            Promocion promo = new PromocionBuilder().idHabitacion(habitacion.getId()).numeroHabitacion(habitacion.getNumero()).
                    nombreHotel(habitacion.getNombreHotel()).porcentaje(Double.parseDouble(porcentaje)).fechaInicio(fechaInicio).fechaFinal(fechaFinal).build();
            String accion = "INSERT INTO PROMOCION_HABITACION ( ID_HABITACION, NUMERO_HABITACION, NOMBRE_HOTEL, PORCENTAJE,"
                    + "FECHA_INICIO, FECHA_FINAL) VALUES (?,?,?,?,?,?)";
            ManejadorBaseDatos.getInstance().setPromocionHabitacion(accion, promo);
        }
    }

    public Promocion getPromocionByDateHabitacion(Date fechaInicio, Date fechaFinal) {
        String consulta = "SELECT * FROM PROMOCION_HABITACION WHERE ID_HABITACION IN  (SELECT ID_HABITACION FROM "
                + "PROMOCION_HABITACION WHERE  FECHA_INICIO < '" + fechaFormat.format(fechaFinal) + "' && FECHA_FINAL > '"
                + fechaFormat.format(fechaInicio) + "')";
        return ManejadorBaseDatos.getInstance().getPromocionHabitacion(consulta, null, 0);
    }

    public List getPromocionesByDateHabitacion(Date fechaInicio, Date fechaFinal) throws Exception {
        if (fechaInicio == null || fechaFinal == null) {
            throw new Exception("Fechas vacias, intentelo de nuevo");
        } else {
            String consulta = "SELECT * FROM PROMOCION_HABITACION WHERE ID_HABITACION IN  (SELECT ID_HABITACION FROM "
                    + "PROMOCION_HABITACION WHERE  FECHA_INICIO < '" + fechaFormat.format(fechaFinal) + "' && FECHA_FINAL > '"
                    + fechaFormat.format(fechaInicio) + "')";
            return ManejadorBaseDatos.getInstance().getPromocionesHabitacion(consulta, null, 0);
        }
    }
    
    public List getPromocionesByDateHabitacion(Date fechaInicio, Date fechaFinal, int idHabitacion) throws Exception {
        if (fechaInicio == null || fechaFinal == null) {
            throw new Exception("Fechas vacias, intentelo de nuevo");
        } else {
            String consulta = "SELECT * FROM PROMOCION_HABITACION WHERE ID_HABITACION IN  (SELECT ID_HABITACION FROM "
                    + "PROMOCION_HABITACION WHERE  FECHA_INICIO < '" + fechaFormat.format(fechaFinal) + "' && FECHA_FINAL > '"
                    + fechaFormat.format(fechaInicio) + "')";
            return ManejadorBaseDatos.getInstance().getPromocionesHabitacion(consulta, null, 0);
        }
    }

    public List getPromocionHabitacion() {
        String consulta = "SELECT * FROM PROMOCION_HABITACION";
        return ManejadorBaseDatos.getInstance().getPromocionesHabitacion(consulta, null, 0);
    }

    public Promocion getPromocionByDateRestaurante(Date fechaInicio, Date fechaFinal) {
        String consulta = "SELECT * FROM PROMOCION_RESTAURANTE WHERE ID_RESTAURANTE IN  (SELECT ID_RESTAURANTE FROM "
                + "PROMOCION_RESTAURANTE WHERE  FECHA_INICIO < '" + fechaFormat.format(fechaFinal) + "' && FECHA_FINAL > '"
                + fechaFormat.format(fechaInicio) + "')";
        return ManejadorBaseDatos.getInstance().getPromocionRestaurante(consulta, null, 0);
    }

    public Promocion getPromocionBySingleDateRestaurante(Date fecha, Restaurante rest) {
        String consulta = "SELECT * FROM PROMOCION_RESTAURANTE WHERE ID_RESTAURANTE IN  (SELECT ID_RESTAURANTE FROM "
                + "PROMOCION_RESTAURANTE WHERE  FECHA_INICIO <= '" + fechaFormat.format(fecha) + "' && FECHA_FINAL >= '"
                + fechaFormat.format(fecha) + "' AND ID_RESTAURANTE = ?)";
        return ManejadorBaseDatos.getInstance().getPromocionRestaurante(consulta, Integer.toString(rest.getId()), 1);
    }
    
    public List getPromocionesByDateRestaurante(Date fechaInicio, Date fechaFinal) throws Exception {
        if (fechaInicio == null || fechaFinal == null) {
            throw new Exception("Fechas vacias, intentelo de nuevo");
        } else {
            String consulta = "SELECT * FROM PROMOCION_RESTAURANTE WHERE ID_RESTAURANTE IN  (SELECT ID_RESTAURANTE FROM "
                    + "PROMOCION_RESTAURANTE WHERE  FECHA_INICIO < '" + fechaFormat.format(fechaFinal) + "' && FECHA_FINAL > '"
                    + fechaFormat.format(fechaInicio) + "')";
            return ManejadorBaseDatos.getInstance().getPromocionesRestaurante(consulta, null, 0);
        }
    }

    public List getPromocionesByDateRestauranteAndId(Date fechaInicio, Date fechaFinal, int idRestaurante) throws Exception {
        if (fechaInicio == null || fechaFinal == null) {
            throw new Exception("Fechas vacias, intentelo de nuevo");
        } else {
            String consulta = "SELECT * FROM PROMOCION_RESTAURANTE WHERE ID_RESTAURANTE IN  (SELECT ID_RESTAURANTE FROM "
                    + "PROMOCION_RESTAURANTE WHERE  FECHA_INICIO < '" + fechaFormat.format(fechaFinal) + "' && FECHA_FINAL > '"
                    + fechaFormat.format(fechaInicio) + "' AND ID_RESTAURANTE = ?)";
            return ManejadorBaseDatos.getInstance().getPromocionesRestaurante(consulta, Integer.toString(idRestaurante), 1);
        }
    }

    public List getPromocionRestaurante() {
        String consulta = "SELECT * FROM PROMOCION_RESTAURANTE";
        return ManejadorBaseDatos.getInstance().getPromocionesRestaurante(consulta, null, 0);
    }

    public void setPromocionRestaurante(Restaurante restaurante, String porcentaje,
            Date fechaInicio, Date fechaFinal) throws Exception {
        if (getPromocionByDateRestaurante(fechaInicio, fechaFinal) != null) {
            throw new Exception("No es posible registrar la promocion, ya hay una promocion en las fechas indicadas");
        } else if (porcentaje.isEmpty()) {
            throw new Exception("Porcentaje no valido");
        } else {
            Promocion promo = new PromocionBuilder().idRestaurante(restaurante.getId()).nombreRestaurante(restaurante.getNombre()).
                    porcentaje(Double.parseDouble(porcentaje)).fechaInicio(fechaInicio).fechaFinal(fechaFinal).build();
            String accion = "INSERT INTO PROMOCION_RESTAURANTE (ID_RESTAURANTE, NOMBRE_RESTAURANTE, PORCENTAJE,"
                    + "FECHA_INICIO, FECHA_FINAL) VALUES (?,?,?,?,?)";
            ManejadorBaseDatos.getInstance().setPromocionRestaurante(accion, promo);
        }
    }

}
