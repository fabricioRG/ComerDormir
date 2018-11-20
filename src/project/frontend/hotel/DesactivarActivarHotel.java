/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.frontend.hotel;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import project.backend.hotel.Hotel;
import project.backend.hotel.ManejadorHotel;

/**
 *
 * @author fabricio
 */
public class DesactivarActivarHotel extends javax.swing.JInternalFrame {

    private List<Hotel> listaUsuario = null;
    private ObservableList<Hotel> listaHotelesObser = null;
    private Hotel hotelSelect = null;
    public String path;
    private final static String BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH = "src/project/frontend/images/blur1.jpg";

    /**
     * Creates new form CreadorUsuario
     */
    public DesactivarActivarHotel() {
        this.listaUsuario = new LinkedList<>();
        this.listaHotelesObser = ObservableCollections.observableList(listaUsuario);
        this.path = BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH;
        initComponents();
        actualizarLista();
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
        buttonHabilitar = new javax.swing.JButton();
        buttonDeshabilitar = new javax.swing.JButton();
        buttonActualizar2 = new javax.swing.JButton();
        buttonActualizar1 = new javax.swing.JButton();

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
        setTitle("Modificar Usuario");
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(2, 161, 192));

        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Modificar Usuario");

        jSeparator1.setForeground(new java.awt.Color(254, 254, 254));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaHotelesObser}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${direccion}"));
        columnBinding.setColumnName("Direccion");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estado}"));
        columnBinding.setColumnName("Estado");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${hotelSelect}"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        buttonActualizar.setBackground(new java.awt.Color(246, 145, 1));
        buttonActualizar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonActualizar.setForeground(new java.awt.Color(254, 254, 254));
        buttonActualizar.setText("Actualizar");
        buttonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarActionPerformed(evt);
            }
        });

        buttonHabilitar.setBackground(new java.awt.Color(50, 205, 50));
        buttonHabilitar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonHabilitar.setForeground(new java.awt.Color(254, 254, 254));
        buttonHabilitar.setText("Habilitar");
        buttonHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHabilitarActionPerformed(evt);
            }
        });

        buttonDeshabilitar.setBackground(new java.awt.Color(254, 87, 87));
        buttonDeshabilitar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonDeshabilitar.setForeground(new java.awt.Color(254, 254, 254));
        buttonDeshabilitar.setText("Deshabilitar");
        buttonDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeshabilitarActionPerformed(evt);
            }
        });

        buttonActualizar2.setBackground(new java.awt.Color(246, 145, 1));
        buttonActualizar2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonActualizar2.setForeground(new java.awt.Color(254, 254, 254));
        buttonActualizar2.setText("Desactivo");
        buttonActualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizar2ActionPerformed(evt);
            }
        });

        buttonActualizar1.setBackground(new java.awt.Color(246, 145, 1));
        buttonActualizar1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonActualizar1.setForeground(new java.awt.Color(254, 254, 254));
        buttonActualizar1.setText("Activo");

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
                                .addGap(39, 39, 39)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(buttonActualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonActualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(buttonDeshabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(buttonHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonActualizar)
                    .addComponent(buttonActualizar2)
                    .addComponent(buttonActualizar1))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDeshabilitar)
                    .addComponent(buttonHabilitar))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarActionPerformed
        actualizarLista();
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        modificarBotones(hotelSelect.getEstado());
    }//GEN-LAST:event_jTable1MouseClicked

    private void buttonHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHabilitarActionPerformed
        ManejadorHotel.getInstance().deshabilitarHabilitarMenu(hotelSelect, 1);
        JOptionPane.showMessageDialog(rootPane, "Se ha habilitado correctamente");
        actualizarLista();
    }//GEN-LAST:event_buttonHabilitarActionPerformed

    private void buttonDeshabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeshabilitarActionPerformed
        ManejadorHotel.getInstance().deshabilitarHabilitarMenu(hotelSelect, 0);
        JOptionPane.showMessageDialog(rootPane, "Se ha deshabilitado correctamente");
        actualizarLista();
    }//GEN-LAST:event_buttonDeshabilitarActionPerformed

    private void buttonActualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizar2ActionPerformed
        actualizarListaByEstado(0);
    }//GEN-LAST:event_buttonActualizar2ActionPerformed

    private void actualizarLista() {
        listaHotelesObser.clear();
        if (ManejadorHotel.getInstance().getHoteles() != null) {
            listaHotelesObser.addAll(ManejadorHotel.getInstance().getHoteles());
        }
        deshabilitarBotons();
    }

    private void deshabilitarBotons() {
        buttonDeshabilitar.setEnabled(false);
        buttonHabilitar.setEnabled(false);
    }

    private void modificarBotones(int estado) {
        if (estado == 1) {
            buttonDeshabilitar.setEnabled(true);
            buttonHabilitar.setEnabled(false);
        } else {
            buttonDeshabilitar.setEnabled(false);
            buttonHabilitar.setEnabled(true);
        }
    }
    
    private void actualizarListaByEstado(int estado){
        listaHotelesObser.clear();
        if(ManejadorHotel.getInstance().getHotelesByState(estado) != null){
            listaHotelesObser.addAll(ManejadorHotel.getInstance().getHotelesByState(estado));
        }
    }

    public ObservableList<Hotel> getListaHotelesObser() {
        return listaHotelesObser;
    }

    public void setListaHotelesObser(ObservableList<Hotel> listaHotelesObser) {
        this.listaHotelesObser = listaHotelesObser;
    }

    public Hotel getHotelSelect() {
        return hotelSelect;
    }

    public void setHotelSelect(Hotel hotelSelect) {
        this.hotelSelect = hotelSelect;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonActualizar1;
    private javax.swing.JButton buttonActualizar2;
    private javax.swing.JButton buttonDeshabilitar;
    private javax.swing.JButton buttonHabilitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}