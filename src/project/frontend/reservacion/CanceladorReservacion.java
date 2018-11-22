package project.frontend.reservacion;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import project.backend.hotel.Hotel;
import project.backend.reservacion.ManejadorReservacion;
import project.backend.reservacion.Reservacion;

/**
 *
 * @author fabricio
 */
public class CanceladorReservacion extends javax.swing.JInternalFrame {

    private List<Reservacion> listaReser = null;
    private ObservableList<Reservacion> listaReserObser = null;
    private Reservacion reserSelec = null;
    public String path;
    private Hotel hotel;
    private final static String BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH = "src/project/frontend/images/blur2.jpg";

    public CanceladorReservacion(Hotel hotel) {
        this.hotel = hotel;
        this.listaReser = new LinkedList<>();
        this.listaReserObser = ObservableCollections.observableList(listaReser);
        this.path = BACKGROUNDD_IMAGE_PARENT_RELATIVE_PATH;
        initComponents();
        actualizarLista(1);
        buttonCancelar.setEnabled(false);
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

        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                ImageIcon im = new ImageIcon(path);
                Image i = im.getImage();
                g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        buttonCancelar = new javax.swing.JButton();
        jDateChooserInicio = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonFiltrar = new javax.swing.JButton();
        formattedTextFieldDPI = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        buttonBuscar = new javax.swing.JButton();
        buttonActualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 99, 71));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setTitle("Cancelar Reservacion");

        jPanel1.setBackground(new java.awt.Color(255, 99, 71));

        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Cancelar Reservacion");

        jSeparator1.setForeground(new java.awt.Color(254, 254, 254));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Fecha de Actual:");

        buttonCancelar.setBackground(new java.awt.Color(70, 130, 180));
        buttonCancelar.setFont(new java.awt.Font("Caviar Dreams", 0, 18)); // NOI18N
        buttonCancelar.setForeground(new java.awt.Color(254, 254, 254));
        buttonCancelar.setText("Cancelar Reservacion");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaReserObser}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dpiCliente}"));
        columnBinding.setColumnName("Dpi Cliente");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombreCliente}"));
        columnBinding.setColumnName("Nombre Cliente");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${noHabitacion}"));
        columnBinding.setColumnName("No Habitacion");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombreHotel}"));
        columnBinding.setColumnName("Nombre Hotel");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaInicio}"));
        columnBinding.setColumnName("Fecha Inicio");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaSalida}"));
        columnBinding.setColumnName("Fecha Salida");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cantidadDias}"));
        columnBinding.setColumnName("Cantidad Dias");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${reserSelec}"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        buttonFiltrar.setBackground(new java.awt.Color(70, 130, 180));
        buttonFiltrar.setFont(new java.awt.Font("Caviar Dreams", 0, 14)); // NOI18N
        buttonFiltrar.setForeground(new java.awt.Color(254, 254, 254));
        buttonFiltrar.setText("Filtrar");
        buttonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFiltrarActionPerformed(evt);
            }
        });

        formattedTextFieldDPI.setBackground(new java.awt.Color(254, 254, 254));
        formattedTextFieldDPI.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        formattedTextFieldDPI.setForeground(new java.awt.Color(237, 71, 71));
        try {
            formattedTextFieldDPI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formattedTextFieldDPI.setCaretColor(new java.awt.Color(237, 71, 71));

        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("DPI:");

        buttonBuscar.setBackground(new java.awt.Color(70, 130, 180));
        buttonBuscar.setFont(new java.awt.Font("Caviar Dreams", 0, 14)); // NOI18N
        buttonBuscar.setForeground(new java.awt.Color(254, 254, 254));
        buttonBuscar.setText("Buscar");
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });

        buttonActualizar.setBackground(new java.awt.Color(70, 130, 180));
        buttonActualizar.setFont(new java.awt.Font("Caviar Dreams", 0, 14)); // NOI18N
        buttonActualizar.setForeground(new java.awt.Color(254, 254, 254));
        buttonActualizar.setText("Actualizar");
        buttonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarActionPerformed(evt);
            }
        });

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
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(jDateChooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(buttonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonFiltrar)
                        .addComponent(formattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonBuscar)
                        .addComponent(jLabel6)
                        .addComponent(buttonActualizar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(buttonCancelar)
                .addContainerGap())
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

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        ManejadorReservacion.getInstance().deleteReservacionByID(reserSelec.getId());
        JOptionPane.showMessageDialog(rootPane, "Se ha eliminado la reservacion con ID \"" + reserSelec.getId() + "\"", "Accion exitosa", JOptionPane.INFORMATION_MESSAGE);
        buttonCancelar.setEnabled(false);
        actualizarLista(1);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFiltrarActionPerformed
        if (jDateChooserInicio.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "No es posible filtrar las reservaciones, intentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            actualizarLista(2);
        }
    }//GEN-LAST:event_buttonFiltrarActionPerformed

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed
        if (formattedTextFieldDPI.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "DPI que ha ingresado no es valido", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            actualizarLista(3);
        }
    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void buttonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarActionPerformed
        actualizarLista(1);
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        buttonCancelar.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void actualizarLista(int opcion) {
        listaReserObser.clear();
        if (opcion == 1) {
            if (ManejadorReservacion.getInstance().getReservacionesByConfirmado(hotel.getId(), 0) != null) {
                listaReserObser.addAll(ManejadorReservacion.getInstance().getReservacionesByConfirmado(hotel.getId(), 0));
            }
        } else if (opcion == 2) {
            if (ManejadorReservacion.getInstance().getReservacionesByDateEntrada(jDateChooserInicio.getDate(), hotel.getId(), 0) != null) {
                listaReserObser.addAll(ManejadorReservacion.getInstance().getReservacionesByDateEntrada(jDateChooserInicio.getDate(), hotel.getId(), 0));
            }
        } else if (opcion == 3) {
            if (ManejadorReservacion.getInstance().getReservacionesByDPICliente(Integer.parseInt(formattedTextFieldDPI.getText().trim()), hotel.getId()) != null) {
                listaReserObser.addAll(ManejadorReservacion.getInstance().getReservacionesByDPICliente(Integer.parseInt(formattedTextFieldDPI.getText().trim()), hotel.getId()));
            }
        }
        buttonCancelar.setEnabled(false);
    }

    public ObservableList<Reservacion> getListaReserObser() {
        return listaReserObser;
    }

    public void setListaReserObser(ObservableList<Reservacion> listaReserObser) {
        this.listaReserObser = listaReserObser;
    }

    public Reservacion getReserSelec() {
        return reserSelec;
    }

    public void setReserSelec(Reservacion reserSelec) {
        this.reserSelec = reserSelec;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonFiltrar;
    private javax.swing.JFormattedTextField formattedTextFieldDPI;
    private com.toedter.calendar.JDateChooser jDateChooserInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
