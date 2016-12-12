/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import Dominio.Contraseña;
import Repository.ContraseñaRepository;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Alaña
 */
public class frmlogin extends javax.swing.JFrame {

    ContraseñaRepository contraseñaRepository = new ContraseñaRepository();
    public static int contador=0;
    public frmlogin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void Ingresar(){
        
        Contraseña con= new Contraseña();
        con.setUsuario(txtusuario.getText().toUpperCase());
        con.setPassword(txtcontraseña.getText());
        boolean c=contraseñaRepository.Consultar(con);
        if(c==true){
            JOptionPane.showMessageDialog(null, "BIENVENIDOS AL SISTEMA EL TENGUELITO:\n"+txtusuario.getText().toUpperCase(),"MENSAJE", JOptionPane.INFORMATION_MESSAGE);
            new frmmenu().setVisible(true);
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "NO EXISTE EN LA BD","MENSAJE", JOptionPane.ERROR_MESSAGE);
        }
        contador++;
        if(contador==3){
                JOptionPane.showMessageDialog(null,"INTENTOS FALLIDOS,ESPERE 7s.","Error", JOptionPane.ERROR_MESSAGE); 
                try{
                   Thread.sleep(9000);
                  
                }catch(Exception ex){}
                contador=0;
                
        }
        Limpiar();
        txtusuario.requestFocus();  
        
        
    }
    public void Limpiar(){
        txtusuario.setText("");
        txtcontraseña.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtusuario = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtcontraseña = new javax.swing.JPasswordField();
        bnentrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });
        getContentPane().add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 150, 30));

        jLabel17.setFont(new java.awt.Font("Bodoni MT Black", 1, 24)); // NOI18N
        jLabel17.setText("Usuario");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 110, 50));

        jLabel16.setFont(new java.awt.Font("Bodoni MT Black", 1, 24)); // NOI18N
        jLabel16.setText("Contraseña");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 100, 150, 30));

        txtcontraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontraseñaKeyTyped(evt);
            }
        });
        getContentPane().add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 150, 30));

        bnentrar.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 11)); // NOI18N
        bnentrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Boton-Entrar-Plateado.gif"))); // NOI18N
        bnentrar.setBorder(null);
        bnentrar.setBorderPainted(false);
        bnentrar.setContentAreaFilled(false);
        bnentrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bnentrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bnentrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnentrarActionPerformed(evt);
            }
        });
        getContentPane().add(bnentrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 140, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ImgLogin.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 580, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        txtcontraseña.requestFocus();
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
        //Validar solo letras
        int c = evt.getKeyChar();
        if((c < 97 || c > 122) && (c< 65 || c > 90) &&  (c != 32)){
            evt.consume();
        }
    }//GEN-LAST:event_txtusuarioKeyTyped

    private void txtcontraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraseñaKeyTyped
        if(txtcontraseña.getText().length()==4){evt.consume();}
    }//GEN-LAST:event_txtcontraseñaKeyTyped

    private void bnentrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnentrarActionPerformed
        if(txtusuario.getText().equals("")|| txtcontraseña.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Falta datos por Ingresar", "MENSAJE",JOptionPane.ERROR_MESSAGE);
            txtusuario.requestFocus();
        }else{
            Ingresar();
        }

    }//GEN-LAST:event_bnentrarActionPerformed

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
            java.util.logging.Logger.getLogger(frmlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmlogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnentrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPasswordField txtcontraseña;
    public javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}