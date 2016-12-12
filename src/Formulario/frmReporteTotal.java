/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import Conexion.Conexion_1;
import Conexion.conexion;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Steven
 */
public class frmReporteTotal extends javax.swing.JFrame {

    Connection conn;
    public frmReporteTotal() {
        initComponents();
        this.setLocationRelativeTo(null);
        opDia.setVisible(false); opMes.setVisible(false);
        dcfecha.setVisible(false);dcfecha2.setVisible(false);dcfecha3.setVisible(false);
        jLabel5.setVisible(false);
        LlenarTabla();
    }
    public void LlenarTabla(){
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.removeTableModelListener(Ttabla);
        String sql="select * from factura";
        modelo.addColumn("FECHA");
        modelo.addColumn("CAJERO");
        modelo.addColumn("RECAUDADO");
        String registro[]= new String[3];
        try{
            conn= Conexion_1.open();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery(sql);
            while(rs.next()){
                registro[0]= rs.getDate(5).toString();
                registro[1]= rs.getString(2);
                registro[2]= Double.toString(rs.getDouble(4));
                
                modelo.addRow(registro);
                Ttabla.setModel(modelo);
            }  
        }catch(Exception ex){
            
        }   
        
    }

    public void Reporte(){
        DefaultTableModel modelo= new DefaultTableModel();
        String sql="";
        modelo.removeTableModelListener(Ttabla);
        modelo.addColumn("CAJERO");
        modelo.addColumn("VENTAS");
        modelo.addColumn("RECAUDADO");
        String registro[]= new String[3];
        
        if(opDia.isSelected()==true){
            sql="select count(*),cajero,sum(valor_cancelado) from factura where fecha='"+dcfecha.getDate()+"'"
                + " group by cajero order by cajero asc";
        }else{
            if(opMes.isSelected()==true){
                sql="select count(*),cajero,sum(valor_cancelado) from factura where fecha>='"+dcfecha2.getDate()+"' and fecha<='" +dcfecha3.getDate()+"'"
                   + " group by cajero order by cajero asc";
            }else{
                sql="select count(*),cajero, sum(valor_cancelado) from factura group by cajero";
            }
        }
        
        try{
            conn= Conexion_1.open();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery(sql);
            while(rs.next()){
                registro[0]= rs.getString(2);
                registro[1]= Integer.toString(rs.getInt(1));
                registro[2]= Double.toString(rs.getDouble(3));
                
                modelo.addRow(registro);
                Ttabla.setModel(modelo);
            }
            
        }catch(Exception ex){
            
        } 
        
        Caja();
    } 
    
    public void Caja(){
        double valor=0.0d;
        for(int fila=0; fila<Ttabla.getRowCount();fila++){
            valor= valor+ Double.parseDouble(Ttabla.getValueAt(fila, 2).toString());
        }
        caja.setText( Double.toString(valor) );
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        criterio = new javax.swing.ButtonGroup();
        fecha = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ttabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        caja = new javax.swing.JLabel();
        opFecha = new javax.swing.JRadioButton();
        dcfecha = new com.toedter.calendar.JDateChooser();
        dcfecha2 = new com.toedter.calendar.JDateChooser();
        dcfecha3 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        bnImprimir = new javax.swing.JButton();
        lblsalir = new javax.swing.JLabel();
        opMes = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        opDia = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 420, 163));

        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel1.setText("REPORTE TOTALES DE CAJERO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        caja.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(caja, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 130, 30));

        criterio.add(opFecha);
        opFecha.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        opFecha.setText("Fecha");
        opFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opFechaActionPerformed(evt);
            }
        });
        getContentPane().add(opFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 44, -1, -1));

        dcfecha.setBackground(new java.awt.Color(255, 255, 255));
        dcfecha.setDateFormatString("yyyy-MM-dd");
        dcfecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcfechaPropertyChange(evt);
            }
        });
        getContentPane().add(dcfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 116, -1));

        dcfecha2.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(dcfecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 130, -1));

        dcfecha3.setBackground(new java.awt.Color(255, 255, 255));
        dcfecha3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcfecha3PropertyChange(evt);
            }
        });
        getContentPane().add(dcfecha3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 130, -1));

        jLabel5.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jLabel5.setText("-");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 70, 10, 20));

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
        getContentPane().add(bnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));

        lblsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/boton salir.gif"))); // NOI18N
        lblsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsalirMouseClicked(evt);
            }
        });
        getContentPane().add(lblsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, -1, -1));

        fecha.add(opMes);
        opMes.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        opMes.setText("Mes");
        opMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opMesActionPerformed(evt);
            }
        });
        getContentPane().add(opMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        criterio.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jRadioButton1.setText("Todos ");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        fecha.add(opDia);
        opDia.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        opDia.setText("Dia");
        opDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opDiaActionPerformed(evt);
            }
        });
        getContentPane().add(opDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jLabel2.setText("CAJA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, -1, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ImgLogo.JPG"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/blanco.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opFechaActionPerformed
        opDia.setVisible(true);opMes.setVisible(true);
        
        
    }//GEN-LAST:event_opFechaActionPerformed

    private void opDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opDiaActionPerformed
        dcfecha.setVisible(true);dcfecha2.setVisible(false);dcfecha3.setVisible(false);
        dcfecha.setDate(null);dcfecha2.setDate(null);dcfecha3.setDate(null);
        jLabel5.setVisible(false);
    }//GEN-LAST:event_opDiaActionPerformed

    private void opMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opMesActionPerformed
        dcfecha.setVisible(false);dcfecha2.setVisible(true);dcfecha3.setVisible(true);
         dcfecha.setDate(null);dcfecha2.setDate(null);dcfecha3.setDate(null);
         jLabel5.setVisible(true);
    }//GEN-LAST:event_opMesActionPerformed

    private void dcfechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcfechaPropertyChange
        Reporte();
    }//GEN-LAST:event_dcfechaPropertyChange

    private void bnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnImprimirActionPerformed
        MessageFormat header = new MessageFormat("Listado de Reportes ");
        MessageFormat footer = new MessageFormat("Pagina{ 0, number, integer}");
        try{
            Ttabla.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        } catch (PrinterException ex) {
            System.err.format("Error, no puede imprimir %s %n ", ex.getMessage());
        }
    }//GEN-LAST:event_bnImprimirActionPerformed

    private void lblsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsalirMouseClicked
        frmmenu.main(null);
        this.setVisible(false);
    }//GEN-LAST:event_lblsalirMouseClicked

    private void dcfecha3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcfecha3PropertyChange
        Reporte();
    }//GEN-LAST:event_dcfecha3PropertyChange

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
       LlenarTabla();        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmReporteTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReporteTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReporteTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReporteTotal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReporteTotal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Ttabla;
    private javax.swing.JButton bnImprimir;
    private javax.swing.JLabel caja;
    public static javax.swing.ButtonGroup criterio;
    private com.toedter.calendar.JDateChooser dcfecha;
    private com.toedter.calendar.JDateChooser dcfecha2;
    private com.toedter.calendar.JDateChooser dcfecha3;
    public static javax.swing.ButtonGroup fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblsalir;
    private javax.swing.JRadioButton opDia;
    private javax.swing.JRadioButton opFecha;
    private javax.swing.JRadioButton opMes;
    // End of variables declaration//GEN-END:variables
}
