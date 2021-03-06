/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.frontend.habitacion;

import project.frontend.alojamiento.*;
import project.frontend.empleado.*;
import java.util.LinkedList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import project.backend.empleado.Empleado;
import project.backend.empleado.ManejadorEmpleado;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import project.backend.alojamiento.Alojamiento;
import project.backend.alojamiento.ManejadorAlojamiento;
import project.backend.habitacion.Habitacion;
import project.backend.habitacion.ManejadorHabitacion;
import project.backend.hotel.Hotel;
import project.backend.hotel.ManejadorHotel;
import project.frontend.hotel.SelectHotel;

/**
 *
 * @author fabricio
 */
public class HabitacionMasPopular extends javax.swing.JInternalFrame {

    private List<Alojamiento> listaAloj = null;
    private ObservableList<Alojamiento> listaAlojamientosObser = null;
    public String path;
    private final static String BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH ="src/project/frontend/images/blur1.jpg";
    private Habitacion habitacion;
    private Hotel hotel = null;

    /**
     * Creates new form CreadorUsuario
     */
    public HabitacionMasPopular() {
        this.listaAloj = new LinkedList<>();
        this.listaAlojamientosObser = ObservableCollections.observableList(listaAloj);
        this.path = BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH;
        initComponents();
//        actualizarLista();
        obtenerHabitacion(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel(){

            public void paintComponent(Graphics g){
                ImageIcon im = new ImageIcon(path);
                Image i = im.getImage();
                g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this);
            }

        };
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonActualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelHotel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelAlojamientos = new javax.swing.JLabel();
        buttonSelect = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        textFieldHotel = new javax.swing.JTextField();

        jTextField7.setBackground(new java.awt.Color(254, 254, 254));
        jTextField7.setForeground(new java.awt.Color(1, 1, 1));
        jTextField7.setCaretColor(new java.awt.Color(1, 1, 1));
        jTextField7.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jTextField8.setBackground(new java.awt.Color(254, 254, 254));
        jTextField8.setForeground(new java.awt.Color(1, 1, 1));
        jTextField8.setCaretColor(new java.awt.Color(1, 1, 1));
        jTextField8.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jLabel10.setForeground(new java.awt.Color(54, 209, 238));
        jLabel10.setText("Max: 20");

        setBackground(new java.awt.Color(2, 161, 192));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setTitle("Reporte de Usuarios");
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(2, 161, 192));

        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Habitacion mas popular");

        jSeparator1.setForeground(new java.awt.Color(254, 254, 254));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaAlojamientosObser}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombreCliente}"));
        columnBinding.setColumnName("Nombre Cliente");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dpiCliente}"));
        columnBinding.setColumnName("Dpi Cliente");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${activo}"));
        columnBinding.setColumnName("Activo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombreHotel}"));
        columnBinding.setColumnName("Nombre Hotel");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cantidadDias}"));
        columnBinding.setColumnName("Cantidad Dias");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaEntrada}"));
        columnBinding.setColumnName("Fecha Entrada");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaSalida}"));
        columnBinding.setColumnName("Fecha Salida");
        columnBinding.setColumnClass(java.util.Date.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        buttonActualizar.setBackground(new java.awt.Color(246, 145, 1));
        buttonActualizar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonActualizar.setForeground(new java.awt.Color(254, 254, 254));
        buttonActualizar.setText("GLOBAL");
        buttonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Caviar Dreams", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(139, 71, 33));
        jLabel2.setText("Numero:");

        jLabelNumero.setFont(new java.awt.Font("Caviar Dreams", 1, 24)); // NOI18N
        jLabelNumero.setForeground(new java.awt.Color(139, 71, 33));
        jLabelNumero.setText(" ");

        jLabel4.setFont(new java.awt.Font("Caviar Dreams", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(139, 71, 33));
        jLabel4.setText("Alojamientos:");

        jLabelHotel.setFont(new java.awt.Font("Caviar Dreams", 1, 24)); // NOI18N
        jLabelHotel.setForeground(new java.awt.Color(139, 71, 33));
        jLabelHotel.setText(" ");

        jLabel6.setFont(new java.awt.Font("Caviar Dreams", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(139, 71, 33));
        jLabel6.setText("Hotel:");

        jLabel3.setFont(new java.awt.Font("Caviar Dreams", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(139, 71, 33));
        jLabel3.setText("Alojamientos:");

        jLabelAlojamientos.setFont(new java.awt.Font("Caviar Dreams", 1, 24)); // NOI18N
        jLabelAlojamientos.setForeground(new java.awt.Color(139, 71, 33));
        jLabelAlojamientos.setText(" ");

        buttonSelect.setBackground(new java.awt.Color(246, 145, 1));
        buttonSelect.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonSelect.setForeground(new java.awt.Color(254, 254, 254));
        buttonSelect.setText("Seleccionar Hotel");
        buttonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSelectActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(139, 71, 33));
        jLabel5.setText("Hotel*:");

        textFieldHotel.setBackground(new java.awt.Color(254, 254, 254));
        textFieldHotel.setForeground(new java.awt.Color(139, 71, 33));
        textFieldHotel.setText("Sin Seleccionar");
        textFieldHotel.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldHotel.setCaretColor(new java.awt.Color(139, 71, 33));
        textFieldHotel.setMargin(new java.awt.Insets(5, 5, 5, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelAlojamientos, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(buttonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textFieldHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)))))
                        .addGap(0, 43, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelNumero)
                    .addComponent(jLabel6)
                    .addComponent(jLabelHotel)
                    .addComponent(jLabel3)
                    .addComponent(jLabelAlojamientos))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonSelect)
                        .addComponent(buttonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarActionPerformed
        obtenerHabitacion(null);
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void buttonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSelectActionPerformed
        SelectHotel sh = new SelectHotel(null, closable);
        sh.setVisible(true);
        if(sh.getHotelSeleccionado() != null){
            setHotel(sh.getHotelSeleccionado());
            textFieldHotel.setText(hotel.getNombre());
            obtenerHabitacion(hotel);
        } else {
            textFieldHotel.setText("Sin Seleccionar");
            obtenerHabitacion(null);
        }
    }//GEN-LAST:event_buttonSelectActionPerformed

    private void obtenerHabitacion(Hotel htl) {
        listaAlojamientosObser.clear();
        if (htl == null) {
            if (ManejadorHabitacion.getInstance().getHabitacionPopular() != null) {
                habitacion = ManejadorHabitacion.getInstance().getHabitacionPopular();
                jLabelAlojamientos.setText(Integer.toString(habitacion.getNumero()));
                habitacion.setNumero(ManejadorHabitacion.getInstance().getHabitacionByID(habitacion.getId()).getNumero());
                habitacion.setIdHotel(ManejadorHabitacion.getInstance().getHabitacionByID(habitacion.getId()).getIdHotel());
                jLabelNumero.setText(Integer.toString(habitacion.getNumero()));
                jLabelHotel.setText(ManejadorHotel.getInstance().getHotelById(habitacion.getIdHotel()).getNombre());
                if(ManejadorAlojamiento.getInstance().getAlojamientosByIdHabitacion(habitacion.getId()) != null) {
                    listaAlojamientosObser.addAll(ManejadorAlojamiento.getInstance().getAlojamientosByIdHabitacion(habitacion.getId()));
                }
            } else {
                jLabelNumero.setText("");
                jLabelHotel.setText("");
                jLabelAlojamientos.setText("");
            }
        } else {
            if (ManejadorHabitacion.getInstance().getHabitacionPopular(htl) != null) {
                habitacion = ManejadorHabitacion.getInstance().getHabitacionPopular(htl);
                jLabelAlojamientos.setText(Integer.toString(habitacion.getNumero()));
                habitacion.setNumero(ManejadorHabitacion.getInstance().getHabitacionByID(habitacion.getId()).getNumero());
                habitacion.setIdHotel(ManejadorHabitacion.getInstance().getHabitacionByID(habitacion.getId()).getIdHotel());
                jLabelNumero.setText(Integer.toString(habitacion.getNumero()));
                jLabelHotel.setText(ManejadorHotel.getInstance().getHotelById(habitacion.getIdHotel()).getNombre());
                if(ManejadorAlojamiento.getInstance().getAlojamientosByIdHabitacion(habitacion.getId()) != null) {
                    listaAlojamientosObser.addAll(ManejadorAlojamiento.getInstance().getAlojamientosByIdHabitacion(habitacion.getId()));
                }
            } else {
                jLabelNumero.setText("");
                jLabelHotel.setText("");
                jLabelAlojamientos.setText("");
            }
        }
    }

    public ObservableList<Alojamiento> getListaAlojamientosObser() {
        return listaAlojamientosObser;
    }

    public void setListaAlojamientosObser(ObservableList<Alojamiento> listaAlojamientosObser) {
        this.listaAlojamientosObser = listaAlojamientosObser;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelAlojamientos;
    private javax.swing.JLabel jLabelHotel;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField textFieldHotel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
