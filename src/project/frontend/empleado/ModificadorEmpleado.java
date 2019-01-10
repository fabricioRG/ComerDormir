/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.frontend.empleado;

import project.frontend.hotel.*;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import project.backend.empleado.Empleado;
import project.backend.empleado.ManejadorEmpleado;
import project.backend.hotel.Hotel;
import project.backend.hotel.ManejadorHotel;

/**
 *
 * @author fabricio
 */
public class ModificadorEmpleado extends javax.swing.JInternalFrame {

    private List<Empleado> listaUsuario = null;
    private ObservableList<Empleado> listaEmpleadoObser = null;
    private Empleado empleadoSelect = null;
    public String path;
    private final static String BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH ="src/project/frontend/images/blur1.jpg";
    private Empleado empleadoActual = null;

    /**
     * Creates new form CreadorUsuario
     */
    public ModificadorEmpleado(Empleado empleado) {
        this.empleadoActual = empleado;
        this.listaUsuario = new LinkedList<>();
        this.listaEmpleadoObser = ObservableCollections.observableList(listaUsuario);
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
        buttonModificar = new javax.swing.JButton();
        textFieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        buttonActualizar2 = new javax.swing.JButton();
        buttonActualizar1 = new javax.swing.JButton();
        buttonEstado = new javax.swing.JButton();

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
        jLabel1.setText("Modificar Empleado");

        jSeparator1.setForeground(new java.awt.Color(254, 254, 254));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaEmpleadoObser}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombre}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dpi}"));
        columnBinding.setColumnName("Dpi");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${usuario}"));
        columnBinding.setColumnName("Usuario");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estado}"));
        columnBinding.setColumnName("Estado");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${empleadoSelect}"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
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

        buttonModificar.setBackground(new java.awt.Color(246, 145, 1));
        buttonModificar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonModificar.setForeground(new java.awt.Color(254, 254, 254));
        buttonModificar.setText("MODIFICAR");
        buttonModificar.setEnabled(false);
        buttonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarActionPerformed(evt);
            }
        });

        textFieldNombre.setBackground(new java.awt.Color(254, 254, 254));
        textFieldNombre.setForeground(new java.awt.Color(139, 71, 33));
        textFieldNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldNombre.setCaretColor(new java.awt.Color(139, 71, 33));
        textFieldNombre.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Nombre:");

        jLabel8.setForeground(new java.awt.Color(139, 71, 33));
        jLabel8.setText("Max: 40");

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
        buttonActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizar1ActionPerformed(evt);
            }
        });

        buttonEstado.setBackground(new java.awt.Color(246, 145, 1));
        buttonEstado.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonEstado.setForeground(new java.awt.Color(254, 254, 254));
        buttonEstado.setText("ESTADO");
        buttonEstado.setEnabled(false);
        buttonEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(buttonActualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(buttonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(buttonActualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(94, 94, 94))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(82, 82, 82)
                                .addComponent(jLabel8))
                            .addComponent(textFieldNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(52, 52, 52))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonActualizar)
                    .addComponent(buttonActualizar1)
                    .addComponent(buttonActualizar2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonEstado))))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, Short.MAX_VALUE)
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
        buttonModificar.setEnabled(false);
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        buttonModificar.setEnabled(true);
        textFieldNombre.setText(empleadoSelect.getNombre());
        if (empleadoSelect.getEstado() == 1) {
            buttonEstado.setText("Desactivar");
        } else {
            buttonEstado.setText("Activar");
        }
        buttonEstado.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void buttonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarActionPerformed
        try {
            ManejadorEmpleado.getInstance().updateEmpleado(empleadoSelect, textFieldNombre.getText(), 1);
            JOptionPane.showMessageDialog(rootPane, "Se ha modificado exitosamente el empleado con nombre \""
                    + empleadoSelect.getNombre() + "\"", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
            buttonModificar.setEnabled(false);
            actualizarLista();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            textFieldNombre.setText(empleadoSelect.getNombre());
        }
    }//GEN-LAST:event_buttonModificarActionPerformed

    private void buttonActualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizar2ActionPerformed
        actualizarListaByEstado(0);
    }//GEN-LAST:event_buttonActualizar2ActionPerformed

    private void buttonActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizar1ActionPerformed
        actualizarListaByEstado(1);
    }//GEN-LAST:event_buttonActualizar1ActionPerformed

    private void buttonEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEstadoActionPerformed
        try {
            if (empleadoSelect.getEstado() == 0) {
                empleadoSelect.setEstado(1);
            } else {
                empleadoSelect.setEstado(0);
            }
            ManejadorEmpleado.getInstance().updateEmpleado(empleadoSelect, Integer.toString(empleadoSelect.getEstado()), 2);
            JOptionPane.showMessageDialog(rootPane, "Se ha modificado exitosamente el empleado con nombre \""
                    + empleadoSelect.getNombre() + "\"", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
            buttonModificar.setEnabled(false);
            if(empleadoSelect.getDpi() == empleadoActual.getDpi()){
                JOptionPane.showMessageDialog(rootPane, "El empleado actual ya no tiene acceso al sistema, se cerrara el programa");
                System.exit(0);
            }
            actualizarLista();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            textFieldNombre.setText(empleadoSelect.getNombre());
        }
    }//GEN-LAST:event_buttonEstadoActionPerformed

    private void actualizarLista() {
        listaEmpleadoObser.clear();
        if (ManejadorEmpleado.getInstance().getEmpleados() != null) {
            listaEmpleadoObser.addAll(ManejadorEmpleado.getInstance().getEmpleados());
        }
        buttonEstado.setEnabled(false);
    }

    private void actualizarListaByEstado(int estado) {
        listaEmpleadoObser.clear();
        if (ManejadorEmpleado.getInstance().getEmpleadosByEstado(estado) != null) {
            listaEmpleadoObser.addAll(ManejadorEmpleado.getInstance().getEmpleadosByEstado(estado));
        }
        buttonEstado.setEnabled(false);
    }

    public ObservableList<Empleado> getListaEmpleadoObser() {
        return listaEmpleadoObser;
    }

    public void setListaEmpleadoObser(ObservableList<Empleado> listaEmpleadoObser) {
        this.listaEmpleadoObser = listaEmpleadoObser;
    }

    public Empleado getEmpleadoSelect() {
        return empleadoSelect;
    }

    public void setEmpleadoSelect(Empleado empleadoSelect) {
        this.empleadoSelect = empleadoSelect;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonActualizar1;
    private javax.swing.JButton buttonActualizar2;
    private javax.swing.JButton buttonEstado;
    private javax.swing.JButton buttonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField textFieldNombre;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
