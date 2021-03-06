package project.frontend.opinion;

import project.frontend.hotel.*;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import project.backend.hotel.Hotel;
import project.backend.hotel.ManejadorHotel;
import project.backend.opinion.ManejadorOpinion;
import project.backend.restaurante.Restaurante;
import project.frontend.restaurante.SelectRestaurante;

/**
 *
 * @author fabricio
 */
public class CreadorOpinionRestaurante extends javax.swing.JInternalFrame {

    public String path;
    private final static String BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH ="src/project/frontend/images/blur1.jpg";
    private Restaurante restaurante;
    
    /**
     * Creates new form CreadorUsuario
     */
    public CreadorOpinionRestaurante() {
        path = BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH;
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
        jPanel1 = new javax.swing.JPanel(){

            public void paintComponent(Graphics g){
                ImageIcon im = new ImageIcon(path);
                Image i = im.getImage();
                g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this);
            }

        };
        textFieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textFieldOpinion = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        textFieldHotel = new javax.swing.JTextField();
        buttonSelect3 = new javax.swing.JButton();

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
        setTitle("Creacion/Registro de Usuario");
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(2, 161, 192));

        textFieldNombre.setBackground(new java.awt.Color(254, 254, 254));
        textFieldNombre.setForeground(new java.awt.Color(139, 71, 33));
        textFieldNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldNombre.setCaretColor(new java.awt.Color(139, 71, 33));
        textFieldNombre.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jLabel2.setForeground(new java.awt.Color(139, 71, 33));
        jLabel2.setText("Nombre Cliente:");

        jLabel4.setForeground(new java.awt.Color(139, 71, 33));
        jLabel4.setText("Opinion*:");

        buttonRegistrar.setBackground(new java.awt.Color(246, 145, 1));
        buttonRegistrar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        buttonRegistrar.setForeground(new java.awt.Color(254, 254, 254));
        buttonRegistrar.setText("OPINAR");
        buttonRegistrar.setEnabled(false);
        buttonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Opinion Restaurante");

        jSeparator1.setForeground(new java.awt.Color(254, 254, 254));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        jLabel8.setForeground(new java.awt.Color(199, 123, 71));
        jLabel8.setText("Max: 20");

        jLabel11.setForeground(new java.awt.Color(199, 123, 71));
        jLabel11.setText("Max: 100");

        textFieldOpinion.setBackground(new java.awt.Color(254, 254, 254));
        textFieldOpinion.setForeground(new java.awt.Color(139, 71, 33));
        textFieldOpinion.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldOpinion.setCaretColor(new java.awt.Color(139, 71, 33));
        textFieldOpinion.setMargin(new java.awt.Insets(5, 5, 5, 5));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel5.setForeground(new java.awt.Color(139, 71, 33));
        jLabel5.setText("Puntos*:");

        textFieldHotel.setBackground(new java.awt.Color(254, 254, 254));
        textFieldHotel.setForeground(new java.awt.Color(139, 71, 33));
        textFieldHotel.setText("Sin Seleccionar");
        textFieldHotel.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        textFieldHotel.setCaretColor(new java.awt.Color(139, 71, 33));
        textFieldHotel.setMargin(new java.awt.Insets(5, 5, 5, 5));

        buttonSelect3.setBackground(new java.awt.Color(246, 145, 1));
        buttonSelect3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buttonSelect3.setForeground(new java.awt.Color(254, 254, 254));
        buttonSelect3.setText("Restaurante");
        buttonSelect3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSelect3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11)
                                .addComponent(textFieldOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel8))
                            .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(buttonSelect3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textFieldHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSelect3))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarActionPerformed
        String punto = jComboBox1.getSelectedItem().toString();
        try {
            ManejadorOpinion.getInstance().setOpinionRestaurante(restaurante, textFieldOpinion.getText().trim(), punto, textFieldNombre.getText().trim());
            JOptionPane.showMessageDialog(rootPane, "Gracias por su opinion, se ha registrado exitosamente");
            limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de validacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonRegistrarActionPerformed

    private void buttonSelect3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSelect3ActionPerformed
        SelectRestaurante sr = new SelectRestaurante(null, closable);
        sr.setVisible(true);
        if (sr.getRestauSeleccionado() != null) {
            setRestaurante(sr.getRestauSeleccionado());
            textFieldHotel.setText(restaurante.getNombre());
            buttonRegistrar.setEnabled(true);
        } else {
            textFieldHotel.setText("Sin Seleccionar");
            buttonRegistrar.setEnabled(false);
        }
    }//GEN-LAST:event_buttonSelect3ActionPerformed

    private void limpiarCampos(){
        textFieldOpinion.setText("");
        textFieldNombre.setText("");
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRegistrar;
    private javax.swing.JButton buttonSelect3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField textFieldHotel;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldOpinion;
    // End of variables declaration//GEN-END:variables
}
