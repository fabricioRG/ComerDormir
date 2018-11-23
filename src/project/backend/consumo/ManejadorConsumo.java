/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.backend.consumo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import project.backend.alojamiento.Alojamiento;
import project.backend.basedatos.ManejadorBaseDatos;
import project.backend.cliente.Cliente;
import project.backend.menu.Menu;
import project.backend.restaurante.Restaurante;

/**
 *
 * @author fabricio
 */
public class ManejadorConsumo {

    private static ManejadorConsumo INSTANCE = null;
    private SimpleDateFormat fechaFormat = null;

    private ManejadorConsumo() {
        fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorConsumo();
        }
    }

    public static ManejadorConsumo getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public void setConsumo(Menu menu, Alojamiento aloja, Date fecha) throws Exception {
        if (aloja == null) {
            throw new Exception("No se ha seleccionado un alojamiento");
        } else if (fecha == null) {
            throw new Exception("No se he ingresado un fecha");
        } else {
            Consumo consumo = new ConsumoBuilder().monto(menu.getPrecio()).costo(menu.getCosto()).fecha(fecha).
                    idMenu(menu.getId()).idAlojamiento(aloja.getId()).nombreMenu(menu.getNombre()).nombreCliente(aloja.getNombreCliente())
                    .nombreRestaurante(menu.getNombreRestaurante()).idRestaurante(menu.getIdRestaurante()).build();
            String accion = "INSERT INTO CONSUMO ( MONTO, COSTO, FECHA, ID_MENU, ID_ALOJAMIENTO, NOMBRE_MENU,"
                    + "NOMBRE_CLIENTE, NOMBRE_RESTAURANTE, ID_RESTAURANTE) VALUES (?,?,?,?,?,?,?,?,?)";
            ManejadorBaseDatos.getInstance().setConsumo(accion, consumo);
        }
    }

    public List getConsumos() {
        String consulta = "SELECT * FROM CONSUMO ORDER BY FECHA DESC";
        return ManejadorBaseDatos.getInstance().getConsumos(consulta, 0, null);
    }

    public List getConsumosByRest(int idRestaurante) {
        String consulta = "SELECT * FROM CONSUMO WHERE ID_RESTAURANTE = ? ORDER BY FECHA DESC";
        return ManejadorBaseDatos.getInstance().getConsumos(consulta, 1, Integer.toString(idRestaurante));
    }

    public List getConsumosByEntradaSalida(Date inicio, Date salida) {
        String consulta = "SELECT * FROM CONSUMO WHERE FECHA < '" + fechaFormat.format(salida) + "' && FECHA >= '"
                + fechaFormat.format(inicio) + "'";
        return ManejadorBaseDatos.getInstance().getConsumos(consulta, 0, null);
    }

    public List getConsumosByClienteAndDate(Date inicio, Date salida, Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("No se ha cargado el cliente");
        } else if (inicio == null || salida == null) {
            throw new Exception("Fechas incorrectas");
        } else {
            String consulta = "SELECT CONSUMO.* FROM CONSUMO, ALOJAMIENTO WHERE CONSUMO.FECHA < '" + fechaFormat.format(salida) + "' && "
                    + " CONSUMO.FECHA >= '" + fechaFormat.format(inicio) + "' AND ALOJAMIENTO.ID = CONSUMO.ID_ALOJAMIENTO AND "
                    + "ALOJAMIENTO.DPI_CLIENTE = ' " + cliente.getDpi() + "' ORDER BY CONSUMO.FECHA DESC";
            return ManejadorBaseDatos.getInstance().getConsumos(consulta, 0, null);
        }
    }

    public List getConsumosByCliente(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("No se ha cargado el cliente");
        } else {
            String consulta = "SELECT CONSUMO.* FROM CONSUMO, ALOJAMIENTO WHERE  ALOJAMIENTO.ID = CONSUMO.ID_ALOJAMIENTO AND "
                    + "ALOJAMIENTO.DPI_CLIENTE = ' " + cliente.getDpi() + "' ORDER BY CONSUMO.FECHA DESC";
            return ManejadorBaseDatos.getInstance().getConsumos(consulta, 0, null);
        }
    }

    public List getConsumosByClienteAndDateAndRest(Date inicio, Date salida, Cliente cliente, Restaurante resta) throws Exception {
        if (cliente == null) {
            throw new Exception("No se ha cargado el cliente");
        } else if (inicio == null || salida == null) {
            throw new Exception("Fechas incorrectas");
        } else {
            String consulta = "SELECT CONSUMO.* FROM CONSUMO, ALOJAMIENTO WHERE CONSUMO.FECHA < '" + fechaFormat.format(salida) + "' && "
                    + " CONSUMO.FECHA >= '" + fechaFormat.format(inicio) + "' AND ALOJAMIENTO.ID = CONSUMO.ID_ALOJAMIENTO AND "
                    + "ALOJAMIENTO.DPI_CLIENTE = ' " + cliente.getDpi() + "' AND CONSUMO.ID_RESTAURANTE = '" + resta.getId() + "' ORDER BY CONSUMO.FECHA DESC";
            return ManejadorBaseDatos.getInstance().getConsumos(consulta, 0, null);
        }
    }
    
}
