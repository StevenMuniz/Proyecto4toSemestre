/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import Conexion.conexion;
import Dominio.Consumo;
import Dominio.Producto;
import Repository.ConsumoRepository;
import Repository.ProductoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Steven
 */
public class frmIngresarProducto extends javax.swing.JFrame {

 
    ConsumoRepository consumoRepository= new ConsumoRepository();
    ProductoRepository productoRepository= new ProductoRepository();
    public frmIngresarProducto() {
        initComponents();
        codigo.setVisible(false);
        this.setLocationRelativeTo(null);
        BuscarConsumo();
        MostrarTabla();
        Desabilitar();
    }
    // **** BUSCAR LOS DATOS DE CONSUMO QUE EXISTE EN LA DB
    public void BuscarConsumo(){
        List<Consumo> con= consumoRepository.Cargar();
        for(Consumo consumo:con){
            cbconsumo.addItem(consumo);
        }
        cbconsumo.setSelectedIndex(-1);
    }
    
    //*******        PRODUCTOS       ****************
    public void Guardar(){
        Producto p= new Producto(0,txtdescripcion.getText().toUpperCase(),Integer.parseInt(txtcantidad.getText()),
                Double.parseDouble(txtprecio.getText()), (Consumo) cbconsumo.getSelectedItem());
        productoRepository.Guardar(p);
    }
    
    public void Modificar(){
        Producto p= new Producto(Integer.parseInt(codigo.getText()),txtdescripcion.getText().toUpperCase(),
                Integer.parseInt(txtcantidad.getText()),Double.parseDouble(txtprecio.getText()), (Consumo) cbconsumo.getSelectedItem());
        productoRepository.Modificar(p);
        
    }
    public void Eliminar(){
        Producto p= new Producto();
        p.setId_producto(Integer.parseInt(codigo.getText()));
        productoRepository.Eliminar(p);
    }
    public void MostrarTabla(){
        
        List<Producto> p= productoRepository.LLenarTabla();
        Object matriz [][]= new Object[p.size()][5];
       
        for(int i=0;i< p.size();i++){
            matriz[i][0]= Integer.toString(p.get(i).getId_producto()) ;
            matriz[i][1]= p.get(i).getConsumo() ;
            matriz[i][2]= p.get(i).getDescripcion();
            matriz[i][3]= Integer.toString(p.get(i).getCantidad());
            matriz[i][4]= Double.toString(p.get(i).getPrecio())  ; 
        }
        Ttabla.setModel(new javax.swing.table.DefaultTableModel(
            matriz, new String [] {
                "ID", "CONSUMO", "DESCRIPCION", "CANTIDAD", "PRECIO" 
            }
        ));
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        EXTRAER = new javax.swing.JMenuItem();
        jLabel17 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        bnguardar = new javax.swing.JButton();
        bnnuevo = new javax.swing.JButton();
        bncancelar = new javax.swing.JButton();
        bneliminar = new javax.swing.JToggleButton();
        txtbuscar = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cbconsumo = new javax.swing.JComboBox();
        bnmodificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ttabla = new javax.swing.JTable();
        codigo = new javax.swing.JTextField();
        salir = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        EXTRAER.setText("EXTRAER");
        EXTRAER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXTRAERActionPerformed(evt);
            }
        });
        jPopupMenu1.add(EXTRAER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PRODUCTO");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jLabel17.setText("Descrpcion");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        txtdescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtdescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescripcionActionPerformed(evt);
            }
        });
        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyTyped(evt);
            }
        });
        getContentPane().add(txtdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 210, 25));

        txtprecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioKeyTyped(evt);
            }
        });
        getContentPane().add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 60, 25));

        jLabel18.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jLabel18.setText("Precio");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 64, 30));

        jLabel19.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jLabel19.setText("Cantidad");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 91, -1));

        txtcantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });
        getContentPane().add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 40, 25));

        bnguardar.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 11)); // NOI18N
        bnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        bnguardar.setBorderPainted(false);
        bnguardar.setContentAreaFilled(false);
        bnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bnguardar.setIconTextGap(-1);
        bnguardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar1.png"))); // NOI18N
        bnguardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar2.png"))); // NOI18N
        bnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnguardarActionPerformed(evt);
            }
        });
        getContentPane().add(bnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, 40));

        bnnuevo.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 11)); // NOI18N
        bnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new.png"))); // NOI18N
        bnnuevo.setBorderPainted(false);
        bnnuevo.setContentAreaFilled(false);
        bnnuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bnnuevo.setIconTextGap(-1);
        bnnuevo.setInheritsPopupMenu(true);
        bnnuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new_1.png"))); // NOI18N
        bnnuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new_2.png"))); // NOI18N
        bnnuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnnuevoActionPerformed(evt);
            }
        });
        getContentPane().add(bnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 60, 40));

        bncancelar.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 11)); // NOI18N
        bncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar.png"))); // NOI18N
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
        getContentPane().add(bncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 60, 40));

        bneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete_user.png"))); // NOI18N
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
        getContentPane().add(bneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        txtbuscar.setBorder(javax.swing.BorderFactory.createTitledBorder("Introducir Tipo de Consumo"));
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 300, 60));

        jLabel20.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jLabel20.setText("Consumo");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 24));

        cbconsumo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbconsumoItemStateChanged(evt);
            }
        });
        getContentPane().add(cbconsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 145, 28));

        bnmodificar.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 11)); // NOI18N
        bnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit.png"))); // NOI18N
        bnmodificar.setBorderPainted(false);
        bnmodificar.setContentAreaFilled(false);
        bnmodificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bnmodificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bnmodificar.setIconTextGap(-1);
        bnmodificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit_1.png"))); // NOI18N
        bnmodificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit_2.png"))); // NOI18N
        bnmodificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(bnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 60, 40));

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
        Ttabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TtablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Ttabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 570, 220));

        codigo.setEditable(false);
        getContentPane().add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 40, -1));

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/boton salir.gif"))); // NOI18N
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 110, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/blanco.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescripcionActionPerformed
        txtcantidad.requestFocus();
    }//GEN-LAST:event_txtdescripcionActionPerformed

    private void txtdescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyTyped
        //Validar solo letras
        int c = evt.getKeyChar();
        if((c < 97 || c > 122) && (c< 65 || c > 90) &&  (c != 32)){
            evt.consume();
        }
        //Validar hasta el rango de acuerdo a la base de datos "limite 50"
        String texto = txtdescripcion.getText();
        if(texto.length() == 100){
            evt.consume();
        }
    }//GEN-LAST:event_txtdescripcionKeyTyped

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        bnguardar.requestFocus();
    }//GEN-LAST:event_txtprecioActionPerformed

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped

        //Validar numero y signos
        int c = evt.getKeyChar();
        if(!(c < 97 || c > 122) && (c< 65 || c > 90) &&  (c != 32)){
            evt.consume();
        }
    }//GEN-LAST:event_txtprecioKeyTyped

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
        txtprecio.requestFocus();
    }//GEN-LAST:event_txtcantidadActionPerformed

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        char c=evt.getKeyChar();
        if (c<'0'|| c>'9' ){
            evt.consume();
        }
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void bnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnguardarActionPerformed
        if(cbconsumo.getActionCommand().equals("")|| txtdescripcion.getText().equals("") || txtcantidad.getText().equals("") || txtprecio.getText().equals("") ){
            JOptionPane.showMessageDialog(null,"FALTA DATOS POR LLENAR","MENSAJE", JOptionPane.ERROR_MESSAGE);
            
        }else{
            Guardar();
            MostrarTabla();
            Desabilitar();
            Limpiar();
        }

        
    }//GEN-LAST:event_bnguardarActionPerformed

    private void bnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnnuevoActionPerformed
        Habilitar();

    }//GEN-LAST:event_bnnuevoActionPerformed

    private void bncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bncancelarActionPerformed
        Desabilitar();
        Limpiar();
        bneliminar.setVisible(false);
    }//GEN-LAST:event_bncancelarActionPerformed

    private void cbconsumoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbconsumoItemStateChanged
        txtdescripcion.requestFocus();
    }//GEN-LAST:event_cbconsumoItemStateChanged

    private void EXTRAERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXTRAERActionPerformed
      int fila= Ttabla.getSelectedRow();
      if(fila>=0){
        codigo.setText(Ttabla.getValueAt(fila, 0).toString());
        cbconsumo.setSelectedItem(Ttabla.getValueAt(fila, 1));
        txtdescripcion.setText(Ttabla.getValueAt(fila, 2).toString());
        txtcantidad.setText(Ttabla.getValueAt(fila, 3).toString());
        txtprecio.setText(Ttabla.getValueAt(fila, 4).toString());
      }else{
       JOptionPane.showMessageDialog(null,"no seleciono fila");
      }
      Habilitar();
     
        bnguardar.setVisible(false);
        
        bnmodificar.setVisible(true);
        bneliminar.setVisible(true);
    
    }//GEN-LAST:event_EXTRAERActionPerformed

    private void bnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnmodificarActionPerformed
        if(cbconsumo.getActionCommand().equals("")|| txtdescripcion.getText().equals("") || txtcantidad.getText().equals("") || txtprecio.getText().equals("") ){
            JOptionPane.showMessageDialog(null,"FALTA DATOS POR LLENAR","MENSAJE", JOptionPane.ERROR_MESSAGE);
            
        }else{
            Modificar();
            MostrarTabla();
            JOptionPane.showMessageDialog(null,"DATOS MODIFICADOS","MENSAJE", JOptionPane.INFORMATION_MESSAGE);
            bnnuevo.setVisible(true);
            bneliminar.setVisible(false);
            bncancelar.setVisible(false);
            bnmodificar.setVisible(false);
            Limpiar();
        }
        
    }//GEN-LAST:event_bnmodificarActionPerformed

    private void TtablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TtablaMouseClicked
        int fila =Ttabla.getSelectedRow();
        codigo.setText(Ttabla.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_TtablaMouseClicked

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        new frmmenu().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_salirMouseClicked

    private void bneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bneliminarActionPerformed

        if(cbconsumo.getActionCommand().equals("")|| txtdescripcion.getText().equals("") || txtcantidad.getText().equals("") || txtprecio.getText().equals("") ){
            JOptionPane.showMessageDialog(null,"FALTA DATOS POR LLENAR","MENSAJE", JOptionPane.ERROR_MESSAGE);    
        }else{
            Eliminar();
            MostrarTabla();
            JOptionPane.showMessageDialog(null,"DATOS ELIMINADOS","MENSAJE", JOptionPane.INFORMATION_MESSAGE);
            bnnuevo.setVisible(true);
            bneliminar.setVisible(false);
            bncancelar.setVisible(false);
            bnmodificar.setVisible(false);
            Limpiar();
        }
    }//GEN-LAST:event_bneliminarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        List<Producto> p= productoRepository.Consultar(txtbuscar.getText().toUpperCase());
         Object matriz [][]= new Object[p.size()][5];
       
        for(int i=0;i< p.size();i++){
            matriz[i][0]= Integer.toString(p.get(i).getId_producto()) ;
            matriz[i][1]= p.get(i).getConsumo() ;
            matriz[i][2]= p.get(i).getDescripcion();
            matriz[i][3]= Integer.toString(p.get(i).getCantidad());
            matriz[i][4]= Double.toString(p.get(i).getPrecio())  ; 
        }
        Ttabla.setModel(new javax.swing.table.DefaultTableModel(
            matriz, new String [] {
                "ID", "CONSUMO", "DESCRIPCION", "CANTIDAD", "PRECIO" 
            }
        ));
        
        
    }//GEN-LAST:event_txtbuscarKeyReleased


    public void Limpiar(){
        txtdescripcion.setText("");
        txtcantidad.setText("");
        txtprecio.setText("");
        cbconsumo.setSelectedIndex(-1);
        txtbuscar.setText("");
    }
    public void Habilitar(){
        txtdescripcion.setEnabled(true);
        txtcantidad.setEnabled(true);
        txtprecio.setEnabled(true);
        cbconsumo.setEnabled(true);
        
        bnnuevo.setVisible(false);
        bnguardar.setVisible(true);
        bncancelar.setVisible(true);
        
    }
    public void Desabilitar(){
        txtdescripcion.setEnabled(false);
        txtcantidad.setEnabled(false);
        txtprecio.setEnabled(false);
        cbconsumo.setEnabled(false);
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
            java.util.logging.Logger.getLogger(frmIngresarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmIngresarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmIngresarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmIngresarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmIngresarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem EXTRAER;
    private javax.swing.JTable Ttabla;
    private javax.swing.JButton bncancelar;
    private javax.swing.JToggleButton bneliminar;
    private javax.swing.JButton bnguardar;
    private javax.swing.JButton bnmodificar;
    private javax.swing.JButton bnnuevo;
    private javax.swing.JComboBox cbconsumo;
    private javax.swing.JTextField codigo;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel salir;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
