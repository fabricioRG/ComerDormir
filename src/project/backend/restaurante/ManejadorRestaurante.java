package project.backend.restaurante;

import java.util.LinkedList;
import java.util.List;
import project.backend.basedatos.ManejadorBaseDatos;
import project.backend.hotel.Hotel;
import project.backend.opinion.ManejadorOpinion;
import project.backend.opinion.Opinion;

/**
 *
 * @author fabricio
 */
public class ManejadorRestaurante {

    private static ManejadorRestaurante INSTANCE = null;

    private ManejadorRestaurante() {
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorRestaurante();
        }
    }

    public static ManejadorRestaurante getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    public Restaurante getRestauranteByID(int id) {
        String consulta = "SELECT * FROM RESTAURANTE WHERE ID = ?";
        return ManejadorBaseDatos.getInstance().getRestaurante(consulta, id);
    }

    public List getRestaurantesByState(int estado) {
        String consulta = "SELECT * FROM RESTAURANTE WHERE ESTADO = ?";
        return ManejadorBaseDatos.getInstance().getRestaurantes(Integer.toString(estado), consulta, 1);
    }

    public List getRestaurantes() {
        String consulta = "SELECT * FROM RESTAURANTE";
        return ManejadorBaseDatos.getInstance().getRestaurantes(null, consulta, 0);
    }

    public void setRestaurante(String nombre, String direccion, Hotel hotel) throws Exception {
        if (nombre.isEmpty() || direccion.isEmpty()) {
            throw new Exception("Campos vacios");
        } else if (nombre.length() > 30) {
            throw new Exception("Nombre no valido");
        } else if (direccion.length() > 30) {
            throw new Exception("Direccion no valida");
        } else {
            if (hotel != null) {
                Restaurante rest = new RestauranteBuilder().nombre(nombre).direccion(direccion).
                        independiente(0).idHotel(hotel.getId()).nombreHotel(hotel.getNombre()).build();
                String accion = "INSERT INTO RESTAURANTE(NOMBRE, DIRECCION, INDEPENDIENTE, ID_HOTEL, NOMBRE_HOTEL) VALUES (?,?,?,?,?)";
                ManejadorBaseDatos.getInstance().setRestaurante(accion, rest, 1);
            } else {
                Restaurante rest = new RestauranteBuilder().nombre(nombre).direccion(direccion).
                        independiente(1).build();
                String accion = "INSERT INTO RESTAURANTE(NOMBRE, DIRECCION, INDEPENDIENTE) VALUES (?,?,?)";
                ManejadorBaseDatos.getInstance().setRestaurante(accion, rest, 0);
            }
        }
    }

    public void updateRestaurante(Restaurante restaurante, String dato, int opcion) throws Exception {
        if (dato.isEmpty()) {
            throw new Exception("Campo vacio");
        } else if (dato.length() > 30) {
            throw new Exception("Nombre no valido");
        } else {
            if (opcion == 1) {
                String accion = "UPDATE RESTAURANTE SET NOMBRE = ? WHERE ID = ?";
                restaurante.setNombre(dato);
                ManejadorBaseDatos.getInstance().updateRestaurante(accion, restaurante, 1);
            } else if (opcion == 2) {
                String accion = "UPDATE RESTAURANTE SET ESTADO = ? WHERE ID = ?";
                restaurante.setEstado(Integer.parseInt(dato));
                ManejadorBaseDatos.getInstance().updateRestaurante(accion, restaurante, 2);
            }
        }
    }

    public Restaurante getRestaurantePopular() {
        int restauranteId = 0;
        int puntuacion = 0;
        List<Opinion> opinionRests = new LinkedList<>();
        if (ManejadorOpinion.getInstance().getOpinionesRestaurante() != null) {
            opinionRests.addAll(ManejadorOpinion.getInstance().getOpinionesRestaurante());
            int puntuacionTemporal = 0;
            for (int i = 0; i < opinionRests.size(); i++) {
                for (int j = 0; j < opinionRests.size(); j++) {
                    if (opinionRests.get(i).getId() != opinionRests.get(j).getId()) {
                        if (opinionRests.get(i).getIdRestaurante() == opinionRests.get(j).getIdRestaurante()) {
                            puntuacionTemporal += opinionRests.get(j).getPuntuacion();
                        }
                    } else {
                        puntuacionTemporal += opinionRests.get(i).getPuntuacion();
                    }
                }
                if (puntuacionTemporal > puntuacion) {
                    puntuacion = puntuacionTemporal;
                    restauranteId = opinionRests.get(i).getIdRestaurante();
                }
                puntuacionTemporal = 0;
            }
            System.out.println("Cantidad:" + puntuacion);
            return getRestauranteByID(restauranteId);
        } else {
            return null;
        }
    }

}
