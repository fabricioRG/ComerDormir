/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.frontend.habitacion;

import project.frontend.empleado.*;
import project.frontend.hotel.*;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import project.backend.empleado.ManejadorEmpleado;
import project.backend.habitacion.ManejadorHabitacion;
import project.backend.hotel.Hotel;
import project.backend.hotel.ManejadorHotel;

/**
 *
 * @author fabricio
 */
public class CreadorHabitacion extends javax.swing.JInternalFrame {

    public String path;
    private final static String BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH = "src/project/frontend/images/blur1.jpg";
    private Hotel hotel = null;
    
    /**
     * Creates new form CreadorUsuario
     */
    public CreadorHabitacion() {
        this.path = BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH;
        initComponents();
        textFieldHotel.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textFieldNombre2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel(){

            public void paintComponent(Graphics g){
                ImageIcon im = new ImageIcon(path);
                Image i = im.getImage();
                g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this);
            }

        };
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buttonSelect = new javax.swing.JButton();
        textFieldTipo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textFieldHotel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        formattedTextFieldDPI = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        buttonRegistrar = new javax.swing.JButton();
        formattedTextFieldPrecio = new javax.swing.JFormattedTextField();
        formattedTextFieldCosto = new javax.swing.JFormattedTextField();

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

        textFieldNombre2.setBackground(new java.awt.Color(254, 254, 254));
        textFieldNombre2.setForeground(new java.awt.Color(139, 71, 33));
        textFieldNombre2.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldNombre2.setCaretColor(new java.awt.Color(139, 71, 33));
        textFieldNombre2.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jLabel6.setForeground(new java.awt.Color(139, 71, 33));
        jLabel6.setText("Nombre*:");

        jLabel12.setForeground(new java.awt.Color(199, 123, 71));
        jLabel12.setText("Max: 30");

        setBackground(new java.awt.Color(2, 161, 192));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setTitle("Reporte de Usuarios");
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(2, 161, 192));

        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Crear Habitacion");

        jSeparator1.setForeground(new java.awt.Color(254, 254, 254));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        buttonSelect.setBackground(new java.awt.Color(246, 145, 1));
        buttonSelect.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonSelect.setForeground(new java.awt.Color(254, 254, 254));
        buttonSelect.setText("Seleccionar Hotel");
        buttonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSelectActionPerformed(evt);
            }
        });

        textFieldTipo.setBackground(new java.awt.Color(254, 254, 254));
        textFieldTipo.setForeground(new java.awt.Color(139, 71, 33));
        textFieldTipo.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldTipo.setCaretColor(new java.awt.Color(139, 71, 33));
        textFieldTipo.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jLabel2.setForeground(new java.awt.Color(139, 71, 33));
        jLabel2.setText("Tipo*:");

        jLabel8.setForeground(new java.awt.Color(199, 123, 71));
        jLabel8.setText("Max: 40");

        textFieldHotel.setBackground(new java.awt.Color(254, 254, 254));
        textFieldHotel.setForeground(new java.awt.Color(139, 71, 33));
        textFieldHotel.setText("Sin Seleccionar");
        textFieldHotel.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldHotel.setCaretColor(new java.awt.Color(139, 71, 33));
        textFieldHotel.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jLabel3.setForeground(new java.awt.Color(139, 71, 33));
        jLabel3.setText("Hotel*:");

        formattedTextFieldDPI.setBackground(new java.awt.Color(254, 254, 254));
        formattedTextFieldDPI.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        formattedTextFieldDPI.setForeground(new java.awt.Color(139, 71, 33));
        formattedTextFieldDPI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        formattedTextFieldDPI.setCaretColor(new java.awt.Color(139, 71, 33));

        jLabel4.setForeground(new java.awt.Color(139, 71, 33));
        jLabel4.setText("Numero*:");

        jLabel9.setForeground(new java.awt.Color(199, 123, 71));
        jLabel9.setText("Max: 8");

        jLabel5.setForeground(new java.awt.Color(139, 71, 33));
        jLabel5.setText("Precio*:");

        jLabel7.setForeground(new java.awt.Color(139, 71, 33));
        jLabel7.setText("Costo Mantenimiento*:");

        buttonRegistrar.setBackground(new java.awt.Color(246, 145, 1));
        buttonRegistrar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        buttonRegistrar.setForeground(new java.awt.Color(254, 254, 254));
        buttonRegistrar.setText("Registrar");
        buttonRegistrar.setEnabled(false);
        buttonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarActionPerformed(evt);
            }
        });

        formattedTextFieldPrecio.setBackground(new java.awt.Color(254, 254, 254));
        formattedTextFieldPrecio.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        formattedTextFieldPrecio.setForeground(new java.awt.Color(139, 71, 33));
        formattedTextFieldPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        formattedTextFieldPrecio.setCaretColor(new java.awt.Color(139, 71, 33));

        formattedTextFieldCosto.setBackground(new java.awt.Color(254, 254, 254));
        formattedTextFieldCosto.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        formattedTextFieldCosto.setForeground(new java.awt.Color(139, 71, 33));
        formattedTextFieldCosto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        formattedTextFieldCosto.setCaretColor(new java.awt.Color(139, 71, 33));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(buttonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9))
                                    .addComponent(formattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addComponent(buttonSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldTipo)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(99, 99, 99)
                                        .addComponent(jLabel8)))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(formattedTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(formattedTextFieldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textFieldHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1)))
                .addGap(0, 58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(formattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonSelect))))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(formattedTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formattedTextFieldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(buttonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSelectActionPerformed
        SelectHotel sh = new SelectHotel(null, closable);
        sh.setVisible(true);
        if(sh.getHotelSeleccionado() != null){
            setHotel(sh.getHotelSeleccionado());
            textFieldHotel.setText(hotel.getNombre());
            buttonRegistrar.setEnabled(true);
        } else {
            textFieldHotel.setText("Sin Seleccionar");
            buttonRegistrar.setEnabled(false);
        }
    }//GEN-LAST:event_buttonSelectActionPerformed

    private void buttonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarActionPerformed
        try {
            ManejadorHabitacion.getInstance().setHabitacion(hotel, formattedTextFieldDPI.getText().trim(), 
                    textFieldTipo.getText(), formattedTextFieldPrecio.getText(), formattedTextFieldCosto.getText());
            JOptionPane.showMessageDialog(rootPane, "Se ha creado exitosamente la habitacion \"" 
                    + textFieldTipo.getText() + "\" en el Sistema.", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de validacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonRegistrarActionPerformed

    private void limpiarCampos (){
        formattedTextFieldDPI.setText("");
        textFieldHotel.setText("Sin seleccionar");
        textFieldTipo.setText("");
        formattedTextFieldPrecio.setText("");
        formattedTextFieldCosto.setText("");
        buttonRegistrar.setEnabled(false);
    }
    
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRegistrar;
    private javax.swing.JButton buttonSelect;
    private javax.swing.JFormattedTextField formattedTextFieldCosto;
    private javax.swing.JFormattedTextField formattedTextFieldDPI;
    private javax.swing.JFormattedTextField formattedTextFieldPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField textFieldHotel;
    private javax.swing.JTextField textFieldNombre2;
    private javax.swing.JTextField textFieldTipo;
    // End of variables declaration//GEN-END:variables
}