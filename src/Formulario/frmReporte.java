/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;


import Conexion.Conexion_1;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Steven
 */
public class frmReporte extends javax.swing.JFrame {

    Connection conn;
    String cargo="";
    public frmReporte() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtcajero.setVisible(false);
        txtcliente.setVisible(false);
        dcfecha.setVisible(false);
        Reporte();
        
    }
     public void Reporte(){
        DefaultTableModel modelo= new DefaultTableModel();
        String sql="";
       modelo.addColumn("FECHA");
        modelo.addColumn("CAJERO");
        modelo.addColumn("CLIENTE");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("TOTAL");
        String registro[]= new String[7];
 
        
        if(opFecha.isSelected() ==true){
            
            sql="select a.fecha,a.cajero,a.cliente,e.descripcion,e.precio,e.cantidad,e.total from factura a join detallefactura e " +
                    " on a.id_factura= e.factura where fecha='"+dcfecha.getDate()+"'";
        }else{
            if(opCliente.isSelected()==true){
                sql="select a.fecha,a.cajero,a.cliente,e.descripcion,e.precio,e.cantidad,e.total from factura a join detallefactura e " +
                        " on a.id_factura= e.factura where cliente like '%"+ txtcliente.getText().toUpperCase()+"%'";
            }else{
                if(opCajero.isSelected()==true){
                    sql="select a.fecha,a.cajero,a.cliente,e.descripcion,e.precio,e.cantidad,e.total from factura a join detallefactura e " +
                        " on a.id_factura= e.factura where cajero like '%"+ txtcajero.getText().toUpperCase()+"%'";
                }else{
                    sql="select a.fecha,a.cajero,a.cliente,e.descripcion,e.precio,e.cantidad,e.total from factura a join detallefactura e " +
                        " on a.id_factura= e.factura";
                }
            }
        }
        try{
            conn= Conexion_1.open();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery(sql);
            while(rs.next()){
                registro[0]= rs.getDate(1).toString();
                registro[1]= rs.getString(2);
                registro[2]= rs.getString(3);
                registro[3]= rs.getString(4);
                registro[4]= Double.toString(rs.getDouble(5));
                registro[5]= Integer.toString(rs.getInt(6));
                registro[6]= Double.toString(rs.getDouble(7));
                modelo.addRow(registro);
                Ttabla.setModel(modelo);
            }  
        }catch(Exception ex){
            
        }  
        
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Criterio = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ttabla = new javax.swing.JTable();
        opFecha = new javax.swing.JRadioButton();
        opCliente = new javax.swing.JRadioButton();
        opCajero = new javax.swing.JRadioButton();
        txtcliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bnImprimir = new javax.swing.JButton();
        txtcajero = new javax.swing.JTextField();
        dcfecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        lblsalir = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REPORTES");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        Ttabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(Ttabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 740, 210));

        Criterio.add(opFecha);
        opFecha.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        opFecha.setText("Fecha");
        opFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opFechaMouseClicked(evt);
            }
        });
        opFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opFechaActionPerformed(evt);
            }
        });
        getContentPane().add(opFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        Criterio.add(opCliente);
        opCliente.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        opCliente.setText("Cliente");
        opCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opClienteMouseClicked(evt);
            }
        });
        opCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opClienteActionPerformed(evt);
            }
        });
        getContentPane().add(opCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        Criterio.add(opCajero);
        opCajero.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        opCajero.setText("Cajero");
        opCajero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opCajeroMouseClicked(evt);
            }
        });
        opCajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opCajeroActionPerformed(evt);
            }
        });
        getContentPane().add(opCajero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txtcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtclienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtclienteKeyTyped(evt);
            }
        });
        getContentPane().add(txtcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 195, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ImgLogo.JPG"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, -1));

        bnImprimir.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 11)); // NOI18N
        bnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imprimir.png"))); // NOI18N
        bnImprimir.setText("Imprimir");
        bnImprimir.setBorder(null);
        bnImprimir.setBorderPainted(false);
        bnImprimir.setContentAreaFilled(false);
        bnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bnImprimir.setIconTextGap(-1);
        bnImprimir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imprimir1.png"))); // NOI18N
        bnImprimir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imprimir2.png"))); // NOI18N
        bnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(bnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        txtcajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcajeroActionPerformed(evt);
            }
        });
        txtcajero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcajeroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcajeroKeyTyped(evt);
            }
        });
        getContentPane().add(txtcajero, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 193, 30));

        dcfecha.setBackground(new java.awt.Color(255, 255, 255));
        dcfecha.setDateFormatString("yyyy-MM-dd");
        dcfecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcfechaPropertyChange(evt);
            }
        });
        getContentPane().add(dcfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 130, -1));

        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel2.setText("DETALLE DE VENTAS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        lblsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/boton salir.gif"))); // NOI18N
        lblsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsalirMouseClicked(evt);
            }
        });
        getContentPane().add(lblsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/blanco.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -90, 740, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclienteKeyReleased
        Reporte();
    }//GEN-LAST:event_txtclienteKeyReleased

    private void txtcajeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcajeroKeyReleased
        Reporte();
    }//GEN-LAST:event_txtcajeroKeyReleased

    private void opFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opFechaMouseClicked
        dcfecha.setVisible(true);
        txtcliente.setVisible(false);
        txtcajero.setVisible(false);
        
    }//GEN-LAST:event_opFechaMouseClicked

    private void opClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opClienteMouseClicked
        dcfecha.setVisible(false);
        txtcliente.setVisible(true);
        txtcajero.setVisible(false);
    }//GEN-LAST:event_opClienteMouseClicked

    private void opCajeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opCajeroMouseClicked
        dcfecha.setVisible(false);
        txtcliente.setVisible(false);
        txtcajero.setVisible(true);
    }//GEN-LAST:event_opCajeroMouseClicked

    private void txtclienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclienteKeyTyped
        char e= evt.getKeyChar();
        if((e<'a' || e>'z') &&(e<'A' || e>'Z')){ evt.consume(); }
    }//GEN-LAST:event_txtclienteKeyTyped

    private void txtcajeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcajeroKeyTyped
        char e= evt.getKeyChar();
        if((e<'a' || e>'z') &&(e<'A' || e>'Z')){ evt.consume(); }
    }//GEN-LAST:event_txtcajeroKeyTyped

    private void bnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnImprimirActionPerformed
        MessageFormat header = new MessageFormat("Listado de Reportes");
        MessageFormat footer = new MessageFormat("Pagina{ 0, number, integer}");
        try{
            Ttabla.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        } catch (PrinterException ex) {
            System.err.format("Error, no puede imprimir %s %n ", ex.getMessage());
        }
    }//GEN-LAST:event_bnImprimirActionPerformed

    private void opCajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opCajeroActionPerformed
         txtcliente.setText("");
         txtcajero.setText("");
         dcfecha.setDate(null);
    }//GEN-LAST:event_opCajeroActionPerformed

    private void opClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opClienteActionPerformed
        txtcliente.setText("");
        txtcajero.setText("");
        dcfecha.setDate(null);
    }//GEN-LAST:event_opClienteActionPerformed

    private void opFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opFechaActionPerformed
        txtcliente.setText("");
        txtcajero.setText("");
        dcfecha.setDate(null);
    }//GEN-LAST:event_opFechaActionPerformed

    private void dcfechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcfechaPropertyChange
        Reporte();
    }//GEN-LAST:event_dcfechaPropertyChange

    private void lblsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsalirMouseClicked
        frmmenu.main(null);
        this.setVisible(false);
    }//GEN-LAST:event_lblsalirMouseClicked

    private void txtcajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcajeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcajeroActionPerformed

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
            java.util.logging.Logger.getLogger(frmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.ButtonGroup Criterio;
    private javax.swing.JTable Ttabla;
    private javax.swing.JButton bnImprimir;
    private com.toedter.calendar.JDateChooser dcfecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblsalir;
    private javax.swing.JRadioButton opCajero;
    private javax.swing.JRadioButton opCliente;
    private javax.swing.JRadioButton opFecha;
    private javax.swing.JTextField txtcajero;
    private javax.swing.JTextField txtcliente;
    // End of variables declaration//GEN-END:variables
}
