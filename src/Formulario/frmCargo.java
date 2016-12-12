
package Formulario;

import Dominio.Cargo;
import Repository.CargoRepository;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Steven
 */
public class frmCargo extends javax.swing.JFrame {

    CargoRepository cargoRepository = new CargoRepository();
    
    public frmCargo() {
        initComponents();
        Desabilitar();
        codigo.setVisible(false);
        this.setLocationRelativeTo(null);   //Poner el formulario en el centro
        CargarTabla();
    }
    //METODO CARGA DESDE ARRAYLIST.- PERMINITE EXTRAER TODOS DATOS DE ARRAY"CARGOREPOSITORY"
    public void CargarTabla(){
        List<Cargo> cargo= cargoRepository.CargarTabla();
        Object matriz [][]= new Object[cargo.size()][3];
       
        for(int i=0;i< cargo.size();i++){
            matriz[i][0]= cargo.get(i).getCargoid() ;
            matriz[i][1]= cargo.get(i).getCargo() ;
            matriz[i][2]= cargo.get(i).getSueldo();
           
        }
        Ttabla.setModel(new javax.swing.table.DefaultTableModel(
            matriz, new String [] {
                "ID", "CARGO", "SUELDO"
            }
        ));
    }
    //METDO GUARDAR EN LA BD.- CREA UN OBJETO CARGO DONDE GUARDA LOS DATOS Y LLAMA AL REPOSITORY PAFRA ALMACENARLO
    public void Guardar(){
        Cargo cargo = new Cargo();
        cargo.setCargo(txtcargo.getText().toUpperCase());
        cargo.setSueldo(Double.parseDouble(txtsueldo.getText()));
        cargoRepository.Guardar(cargo);
    }
    //METDO MODIFICAR EN LA BD.- CREA UN OBJETO CARGO DONDE GUARDA LOS DATOS Y LLAMA AL REPOSITORY PAFRA MODIFCARLO
    public void Modificar(){
        Cargo cargo = new Cargo();
        cargo.setCargoid(Integer.parseInt(codigo.getText()));
        cargo.setCargo(txtcargo.getText().toUpperCase());
        cargo.setSueldo(Double.parseDouble(txtsueldo.getText()));
        cargoRepository.Modificar(cargo);
    }
    //METODO EMILINAR EN LA BD.- CREA UN OBJETO CARGO DONDE GUARDA LOS DATOS Y LLAMA AL REPOSITORY PAFRA ELIMINARLO
    public void Eliminar(){
        Cargo cargo = new Cargo();
        cargo.setCargoid(Integer.parseInt(codigo.getText()));
        cargoRepository.Eliminar(cargo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        EXTRAER = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtcargo = new javax.swing.JTextField();
        txtsueldo = new javax.swing.JTextField();
        bnguardar = new javax.swing.JButton();
        bncancelar = new javax.swing.JButton();
        bnnuevo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblsalir = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ttabla = new javax.swing.JTable();
        codigo = new javax.swing.JTextField();
        bnmodificar = new javax.swing.JButton();
        bneliminar = new javax.swing.JButton();

        EXTRAER.setText("EXTRAER");
        EXTRAER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXTRAERActionPerformed(evt);
            }
        });
        jPopupMenu1.add(EXTRAER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INGRESAR CARGO");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Bodoni MT Black", 1, 24)); // NOI18N
        jLabel16.setText("Sueldo");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 48, 99, -1));

        jLabel17.setFont(new java.awt.Font("Bodoni MT Black", 1, 24)); // NOI18N
        jLabel17.setText("Cargo");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 11, 99, -1));

        txtcargo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtcargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcargoActionPerformed(evt);
            }
        });
        txtcargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcargoKeyTyped(evt);
            }
        });
        jPanel1.add(txtcargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 17, 107, 25));

        txtsueldo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtsueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsueldoActionPerformed(evt);
            }
        });
        txtsueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsueldoKeyTyped(evt);
            }
        });
        jPanel1.add(txtsueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 54, 107, 25));

        bnguardar.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 11)); // NOI18N
        bnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        bnguardar.setBorder(null);
        bnguardar.setBorderPainted(false);
        bnguardar.setContentAreaFilled(false);
        bnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bnguardar.setIconTextGap(-1);
        bnguardar.setInheritsPopupMenu(true);
        bnguardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar1.png"))); // NOI18N
        bnguardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar2.png"))); // NOI18N
        bnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnguardarActionPerformed(evt);
            }
        });
        jPanel1.add(bnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, 60));

        bncancelar.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 11)); // NOI18N
        bncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar.png"))); // NOI18N
        bncancelar.setBorder(null);
        bncancelar.setBorderPainted(false);
        bncancelar.setContentAreaFilled(false);
        bncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bncancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bncancelar.setIconTextGap(-1);
        bncancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar1.png"))); // NOI18N
        bncancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar2.png"))); // NOI18N
        bncancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bncancelarActionPerformed(evt);
            }
        });
        jPanel1.add(bncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 50, 60));

        bnnuevo.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 11)); // NOI18N
        bnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new.png"))); // NOI18N
        bnnuevo.setBorder(null);
        bnnuevo.setBorderPainted(false);
        bnnuevo.setContentAreaFilled(false);
        bnnuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bnnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bnnuevo.setIconTextGap(-1);
        bnnuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new_1.png"))); // NOI18N
        bnnuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new_2.png"))); // NOI18N
        bnnuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnnuevoActionPerformed(evt);
            }
        });
        jPanel1.add(bnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 64, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/agregar.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        lblsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/boton salir.gif"))); // NOI18N
        lblsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsalirMouseClicked(evt);
            }
        });
        jPanel1.add(lblsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, 65));

        Ttabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Ttabla.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(Ttabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 202, 479, 144));

        codigo.setEditable(false);
        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });
        jPanel1.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 38, -1));

        bnmodificar.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 11)); // NOI18N
        bnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit.png"))); // NOI18N
        bnmodificar.setBorder(null);
        bnmodificar.setBorderPainted(false);
        bnmodificar.setContentAreaFilled(false);
        bnmodificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bnmodificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bnmodificar.setIconTextGap(-1);
        bnmodificar.setInheritsPopupMenu(true);
        bnmodificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit_1.png"))); // NOI18N
        bnmodificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit_2.png"))); // NOI18N
        bnmodificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnmodificarActionPerformed(evt);
            }
        });
        jPanel1.add(bnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, 60));

        bneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete_user.png"))); // NOI18N
        bneliminar.setBorder(null);
        bneliminar.setBorderPainted(false);
        bneliminar.setContentAreaFilled(false);
        bneliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bneliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bneliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete_user_1.png"))); // NOI18N
        bneliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete_user_2.png"))); // NOI18N
        bneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bneliminarActionPerformed(evt);
            }
        });
        jPanel1.add(bneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 66, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcargoActionPerformed
         txtsueldo.requestFocus();
    }//GEN-LAST:event_txtcargoActionPerformed

    private void txtsueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsueldoActionPerformed
        bnguardar.requestFocus();
    }//GEN-LAST:event_txtsueldoActionPerformed

    private void txtsueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsueldoKeyTyped

        //Validar numero y signos
        int c = evt.getKeyChar();
        if(!(c < 97 || c > 122) && (c< 65 || c > 90) &&  (c != 32)){
            evt.consume();
        }

    }//GEN-LAST:event_txtsueldoKeyTyped

    private void bnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnguardarActionPerformed
        Guardar();
        JOptionPane.showMessageDialog(null,"Datos Guardado","",JOptionPane.QUESTION_MESSAGE);
        Limpiar();
        CargarTabla();
    }//GEN-LAST:event_bnguardarActionPerformed

    private void bncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bncancelarActionPerformed
        Desabilitar();
        Limpiar();
    }//GEN-LAST:event_bncancelarActionPerformed

    private void txtcargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcargoKeyTyped
         //Validar solo letras
        int c = evt.getKeyChar();
        if((c < 97 || c > 122) && (c< 65 || c > 90) &&  (c != 32)){
            evt.consume();
        }
        //Validar hasta el rango de acuerdo a la base de datos "limite 50" 
        String texto = txtcargo.getText();
        if(texto.length() == 20){
            evt.consume();
        }
    }//GEN-LAST:event_txtcargoKeyTyped

    private void bnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnnuevoActionPerformed
        Habilitar();
        bnmodificar.setVisible(false); bneliminar.setVisible(false);
    }//GEN-LAST:event_bnnuevoActionPerformed

    private void lblsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsalirMouseClicked
        frmmenu.main(null);
        this.setVisible(false);
    }//GEN-LAST:event_lblsalirMouseClicked

    private void EXTRAERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXTRAERActionPerformed
         int fila= Ttabla.getSelectedRow();
    if(fila>=0){
        codigo.setText(Ttabla.getValueAt(fila, 0).toString());
        txtcargo.setText(Ttabla.getValueAt(fila, 1).toString());
        txtsueldo.setText(Ttabla.getValueAt(fila, 2).toString());
    }else{
       JOptionPane.showMessageDialog(null,"no seleciono fila");
      }
    Habilitar();
    bnguardar.setVisible(false);
    }//GEN-LAST:event_EXTRAERActionPerformed

    private void bnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnmodificarActionPerformed
        Modificar();
        JOptionPane.showMessageDialog(null,"DATOS MODIFICADOS EXISTOSAMENTE");
        CargarTabla();
        Limpiar();
        Desabilitar();
    }//GEN-LAST:event_bnmodificarActionPerformed

    private void bneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bneliminarActionPerformed
        Eliminar();
        JOptionPane.showMessageDialog(null,"DATOS ELIMINADOS EXISTOSAMENTE");
        CargarTabla();
        Limpiar();
        Desabilitar();
    }//GEN-LAST:event_bneliminarActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    
    
    public void Limpiar(){
        txtcargo.setText("");
        txtsueldo.setText("");
        
    }
    public void Habilitar(){
        txtcargo.setEnabled(true);
        txtsueldo.setEnabled(true);
        bnnuevo.setVisible(false);
        bnguardar.setVisible(true);
        bncancelar.setVisible(true);
        bnmodificar.setVisible(true);
        bneliminar.setVisible(true);
    }
    public void Desabilitar(){
        txtcargo.setEnabled(false);
        txtsueldo.setEnabled(false);
        //Botones
        bnnuevo.setVisible(true);
        bnguardar.setVisible(false);
        bncancelar.setVisible(false);
        bnmodificar.setVisible(false);
        bneliminar.setVisible(false);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCargo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem EXTRAER;
    private javax.swing.JTable Ttabla;
    private javax.swing.JButton bncancelar;
    private javax.swing.JButton bneliminar;
    private javax.swing.JButton bnguardar;
    private javax.swing.JButton bnmodificar;
    private javax.swing.JButton bnnuevo;
    private javax.swing.JTextField codigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblsalir;
    private javax.swing.JTextField txtcargo;
    private javax.swing.JTextField txtsueldo;
    // End of variables declaration//GEN-END:variables
}
