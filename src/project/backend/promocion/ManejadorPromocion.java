/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.backend.promocion;

import java.text.SimpleDateFormat;
import java.util.Date;
import project.backend.basedatos.ManejadorBaseDatos;
import project.backend.habitacion.Habitacion;

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
            Date fechaInicio, Date fechaFinal) throws Exception{
            if(getPromocionByDate(fechaInicio, fechaFinal) != null){
                throw new Exception("No es posible registrar la promocion, ya hay una promocion en las fechas indicadas");
            } else if (porcentaje.isEmpty()) {
                throw new Exception("Porcentaje no valido");
            }else {
                Promocion promo = new PromocionBuilder().idHabitacion(habitacion.getId()).numeroHabitacion(habitacion.getNumero()).
                        nombreHotel(habitacion.getNombreHotel()).porcentaje(Double.parseDouble(porcentaje)).fechaInicio(fechaInicio).fechaFinal(fechaFinal).build();
                String accion = "INSERT INTO PROMOCION_HABITACION ( ID_HABITACION, NUMERO_HABITACION, NOMBRE_HOTEL, PORCENTAJE,"
                        + "FECHA_INICIO, FECHA_FINAL) VALUES (?,?,?,?,?,?)";
                ManejadorBaseDatos.getInstance().setPromocionHabitacion(accion, promo);
            }
    }
    
    public Promocion getPromocionByDate(Date fechaInicio, Date fechaFinal){
        String consulta = "SELECT * FROM PROMOCION_HABITACION WHERE ID_HABITACION IN  (SELECT ID_HABITACION FROM "
                + "PROMOCION_HABITACION WHERE  FECHA_INICIO < '" + fechaFormat.format(fechaFinal) + "' && FECHA_FINAL > '"
                + fechaFormat.format(fechaInicio) + "')";
        return ManejadorBaseDatos.getInstance().getPromocionHabitacion(consulta, null, 0);
    }
    
}
