/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.frontend.empleado;

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
import project.backend.hotel.Hotel;
import project.backend.hotel.ManejadorHotel;

/**
 *
 * @author fabricio
 */
public class CreadorGerenteG extends javax.swing.JInternalFrame {

    public String path;
    private final static String BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH = "src/project/frontend/images/blur1.jpg";
    private Hotel hotel = null;
    
    /**
     * Creates new form CreadorUsuario
     */
    public CreadorGerenteG() {
        this.path = BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH;
        initComponents();
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
        textFieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        formattedTextFieldDPI = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textFieldUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textFieldContrasena = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        buttonRegistrar = new javax.swing.JButton();

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
        jLabel1.setText("Crear Gerente General");

        jSeparator1.setForeground(new java.awt.Color(254, 254, 254));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        textFieldNombre.setBackground(new java.awt.Color(254, 254, 254));
        textFieldNombre.setForeground(new java.awt.Color(139, 71, 33));
        textFieldNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldNombre.setCaretColor(new java.awt.Color(139, 71, 33));
        textFieldNombre.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jLabel2.setForeground(new java.awt.Color(139, 71, 33));
        jLabel2.setText("Nombre*:");

        jLabel8.setForeground(new java.awt.Color(199, 123, 71));
        jLabel8.setText("Max: 40");

        formattedTextFieldDPI.setBackground(new java.awt.Color(254, 254, 254));
        formattedTextFieldDPI.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        formattedTextFieldDPI.setForeground(new java.awt.Color(139, 71, 33));
        try {
            formattedTextFieldDPI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formattedTextFieldDPI.setCaretColor(new java.awt.Color(139, 71, 33));

        jLabel4.setForeground(new java.awt.Color(139, 71, 33));
        jLabel4.setText("DPI*:");

        jLabel9.setForeground(new java.awt.Color(199, 123, 71));
        jLabel9.setText("Max: 8");

        textFieldUsuario.setBackground(new java.awt.Color(254, 254, 254));
        textFieldUsuario.setForeground(new java.awt.Color(139, 71, 33));
        textFieldUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldUsuario.setCaretColor(new java.awt.Color(139, 71, 33));
        textFieldUsuario.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jLabel5.setForeground(new java.awt.Color(139, 71, 33));
        jLabel5.setText("Usuario*:");

        jLabel11.setForeground(new java.awt.Color(199, 123, 71));
        jLabel11.setText("Max: 10");

        textFieldContrasena.setBackground(new java.awt.Color(254, 254, 254));
        textFieldContrasena.setForeground(new java.awt.Color(139, 71, 33));
        textFieldContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldContrasena.setCaretColor(new java.awt.Color(139, 71, 33));
        textFieldContrasena.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jLabel7.setForeground(new java.awt.Color(139, 71, 33));
        jLabel7.setText("Contraseña*:");

        jLabel13.setForeground(new java.awt.Color(199, 123, 71));
        jLabel13.setText("Max: 15");

        buttonRegistrar.setBackground(new java.awt.Color(246, 145, 1));
        buttonRegistrar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        buttonRegistrar.setForeground(new java.awt.Color(254, 254, 254));
        buttonRegistrar.setText("Registrar");
        buttonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textFieldUsuario)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(99, 99, 99)
                                            .addComponent(jLabel11)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(126, 126, 126)
                                            .addComponent(jLabel9))
                                        .addComponent(formattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(87, 87, 87)
                                        .addComponent(jLabel13))
                                    .addComponent(textFieldContrasena)
                                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(buttonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addComponent(buttonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarActionPerformed
        try {
            ManejadorEmpleado.getInstance().setGerente(formattedTextFieldDPI.getText().trim(),
                    textFieldNombre.getText().trim(), textFieldUsuario.getText().trim(), textFieldContrasena.getText().trim(), null, 1);
            JOptionPane.showMessageDialog(rootPane, "Se ha creado exitosamente el Gerente general \"" + textFieldNombre.getText() + "\" en el Sistema.", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de validacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonRegistrarActionPerformed

    private void limpiarCampos (){
        formattedTextFieldDPI.setText("");
        textFieldNombre.setText("");
        textFieldUsuario.setText("");
        textFieldContrasena.setText("");
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
    private javax.swing.JFormattedTextField formattedTextFieldDPI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTextField textFieldContrasena;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldNombre2;
    private javax.swing.JTextField textFieldUsuario;
    // End of variables declaration//GEN-END:variables
}