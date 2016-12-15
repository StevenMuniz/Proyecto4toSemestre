/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import Dominio.Cliente;
import Repository.ClienteRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


public class frmCliente extends javax.swing.JFrame {
    ClienteRepository clienteRepository= new ClienteRepository();
    
    public frmCliente() {
        initComponents();
        codigo.setVisible(false);
        //Poner el formulario en el centro
        this.setLocationRelativeTo(null);
        this.Desabilitar();
        //Desabilitar botones
        bnguardar.setVisible(false); bnmodificar.setVisible(false); bneliminar.setVisible(false);bncancelar.setVisible(false);
        txtcedula.requestFocus();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtnombres = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtapellidos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbsexo = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Buscar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bnnuevo = new javax.swing.JToggleButton();
        bncancelar = new javax.swing.JToggleButton();
        bnguardar = new javax.swing.JToggleButton();
        bnmodificar = new javax.swing.JToggleButton();
        bneliminar = new javax.swing.JToggleButton();
        lblsalir = new javax.swing.JLabel();
        txttelefono2 = new javax.swing.JTextField();
        codigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dcfecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DATOS DEL CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 24), new java.awt.Color(51, 0, 204))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Bodoni MT Black", 1, 24)); // NOI18N
        jLabel8.setText("C.I");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 50, 48));

        txtcedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtcedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcedulaActionPerformed(evt);
            }
        });
        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });
        jPanel1.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 217, 24));

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel9.setText("NOMBRES");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 129, -1));

        txtnombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtnombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombresActionPerformed(evt);
            }
        });
        txtnombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombresKeyTyped(evt);
            }
        });
        jPanel1.add(txtnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 242, 24));

        jLabel10.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel10.setText("APELLIDOS");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        txtapellidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtapellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidosActionPerformed(evt);
            }
        });
        txtapellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidosKeyTyped(evt);
            }
        });
        jPanel1.add(txtapellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 242, 24));

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel11.setText("FECHA NACIMIENTO");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 245, -1));

        jLabel12.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel12.setText("SEXO");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 88, -1));

        cbsexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FEMENINO", "MASCULINO" }));
        cbsexo.setSelectedIndex(-1);
        cbsexo.setBorder(null);
        cbsexo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbsexoItemStateChanged(evt);
            }
        });
        jPanel1.add(cbsexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 136, 20));

        jLabel14.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel14.setText("DIRECCION");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        txtdireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });
        jPanel1.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 240, 20));

        jLabel13.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel13.setText("TELEFONO");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 131, -1));

        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Consultar.png"))); // NOI18N
        Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarMouseClicked(evt);
            }
        });
        jPanel1.add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 37, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        bnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new.png"))); // NOI18N
        bnnuevo.setBorder(null);
        bnnuevo.setBorderPainted(false);
        bnnuevo.setContentAreaFilled(false);
        bnnuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bnnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bnnuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new_1.png"))); // NOI18N
        bnnuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new_2.png"))); // NOI18N
        bnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnnuevoActionPerformed(evt);
            }
        });

        bncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar.png"))); // NOI18N
        bncancelar.setBorder(null);
        bncancelar.setBorderPainted(false);
        bncancelar.setContentAreaFilled(false);
        bncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bncancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bncancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar1.png"))); // NOI18N
        bncancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar2.png"))); // NOI18N
        bncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bncancelarActionPerformed(evt);
            }
        });

        bnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add_user.png"))); // NOI18N
        bnguardar.setBorder(null);
        bnguardar.setBorderPainted(false);
        bnguardar.setContentAreaFilled(false);
        bnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bnguardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add_user_1.png"))); // NOI18N
        bnguardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add_user_2.png"))); // NOI18N
        bnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnguardarActionPerformed(evt);
            }
        });

        bnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar.png"))); // NOI18N
        bnmodificar.setBorder(null);
        bnmodificar.setBorderPainted(false);
        bnmodificar.setContentAreaFilled(false);
        bnmodificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bnmodificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bnmodificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar1.png"))); // NOI18N
        bnmodificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar2.png"))); // NOI18N
        bnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnmodificarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(bnnuevo)
                .addGap(1, 1, 1)
                .addComponent(bncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bnmodificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 37, 90, -1));

        lblsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/boton salir.gif"))); // NOI18N
        lblsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsalirMouseClicked(evt);
            }
        });
        jPanel1.add(lblsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 276, -1, 65));

        txttelefono2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txttelefono2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefono2ActionPerformed(evt);
            }
        });
        txttelefono2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefono2KeyTyped(evt);
            }
        });
        jPanel1.add(txttelefono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 240, 20));

        codigo.setEditable(false);
        jPanel1.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 48, 45, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cliente.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 62, 200, 160));
        jPanel1.add(dcfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaActionPerformed
        txtnombres.requestFocus();
    }//GEN-LAST:event_txtcedulaActionPerformed

    private void txtcedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyReleased

        if(txtcedula.getText().equals("")){
            this.Limpiar();
            this.Desabilitar();

        }

    }//GEN-LAST:event_txtcedulaKeyReleased

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
        //Validar solo numeros del rango 1 al 10
        if(txtcedula.getText().length()==10){
            evt.consume();
        }
        char c=evt.getKeyChar();
        if (c<'0'|| c>'9' ){
            evt.consume();
        }
    }//GEN-LAST:event_txtcedulaKeyTyped

    private void txtnombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombresActionPerformed
        txtapellidos.requestFocus();
    }//GEN-LAST:event_txtnombresActionPerformed

    private void txtnombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombresKeyTyped
        //Validar hasta el rango de acuerdo a la base de datos "limite 50"
        if(txtnombres.getText().length() == 50){
            evt.consume();
        }
        //Validar solo letras
        char c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c< 'A' || c > 'Z')&&(c!=32)){
            evt.consume();
        }

    }//GEN-LAST:event_txtnombresKeyTyped

    private void txtapellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidosActionPerformed
        dcfecha.requestFocus();
    }//GEN-LAST:event_txtapellidosActionPerformed

    private void txtapellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosKeyTyped
        //Validar hasta el rango de acuerdo a la base de datos "limite 50"
        if(txtapellidos.getText().length() == 50){
            evt.consume();
        }
        //Validar solo letras
        char c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c< 'A' || c > 'Z')&&(c!=32)){
            evt.consume();
        }
    }//GEN-LAST:event_txtapellidosKeyTyped

    private void cbsexoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbsexoItemStateChanged
        txtdireccion.requestFocus();
    }//GEN-LAST:event_cbsexoItemStateChanged

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        txttelefono2.requestFocus();
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        //Validar hasta el rango de acuerdo a la base de datos "limite 100"
        if(txtdireccion.getText().length() == 100){
            evt.consume();
        }
        //Validar solo letras
        char c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c< 'A' || c > 'Z')&& (c< '.' )&&(c!=32)){
            evt.consume();
        }
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseClicked

        ConsultarCliente();
          bncancelar.setVisible(false);bnguardar.setVisible(false);
            bnmodificar.setVisible(true); bneliminar.setVisible(true);
            bnnuevo.setVisible(false);Buscar.setEnabled(true);
            bncancelar.setVisible(true);

    }//GEN-LAST:event_BuscarMouseClicked

    private void bnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnnuevoActionPerformed
        Limpiar();
        Habilitar();
        bnnuevo.setVisible(false);Buscar.setEnabled(false);
        bnguardar.setVisible(true); bncancelar.setVisible(true);
    }//GEN-LAST:event_bnnuevoActionPerformed

    private void bncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bncancelarActionPerformed

        if(JOptionPane.showConfirmDialog(null, "Desea Cancelar", "Error", JOptionPane.ERROR_MESSAGE)==0){
            Desabilitar();
            bncancelar.setVisible(false);bnguardar.setVisible(false);
            bnmodificar.setVisible(false); bneliminar.setVisible(false);
            bnnuevo.setVisible(true);Buscar.setEnabled(true);
            Limpiar();
        }
    }//GEN-LAST:event_bncancelarActionPerformed

    private void bnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnguardarActionPerformed
        if(txtcedula.getText().length()<10){
            JOptionPane.showMessageDialog(null, "Digitos Incompletos","Error",JOptionPane.ERROR_MESSAGE);
            txtcedula.requestFocus();
        }else{
            if(txtcedula.getText().equals("")||txtnombres.getText().equals("") ||txtapellidos.getText().equals("") ||
            dcfecha.getDate()==null || cbsexo.getActionCommand().equals("")||
            txtdireccion.getText().equals("")|| txttelefono2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Falta datos por ingresar","Error",JOptionPane.ERROR_MESSAGE);
            txtcedula.requestFocus();
            }else
                if(JOptionPane.showConfirmDialog(null,"Guardar Datos", "Confirmar",1)==0){
                Guardar();
                Desabilitar();
                bncancelar.setVisible(false);bnguardar.setVisible(false);
                bnmodificar.setVisible(false); bneliminar.setVisible(false);
                bnnuevo.setVisible(true);Buscar.setEnabled(true);
                Limpiar();
            }   
        }
        
        
        
        
        

    }//GEN-LAST:event_bnguardarActionPerformed

    private void bnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnmodificarActionPerformed
        if(txtcedula.getText().equals("")||txtnombres.getText().equals("") ||txtapellidos.getText().equals("") ||
            dcfecha.getDate()==null || cbsexo.getActionCommand().equals("")||
            txtdireccion.getText().equals("")|| txttelefono2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Falta datos por ingresar","Error",JOptionPane.ERROR_MESSAGE);
        }else
        if(JOptionPane.showConfirmDialog(null,"Guardar Datos", "Confirmar",1)==0){
            Modificar();
        }
         bncancelar.setVisible(false);bnguardar.setVisible(false);
            bnmodificar.setVisible(false); bneliminar.setVisible(false);
            bnnuevo.setVisible(true);Buscar.setEnabled(true);
        Limpiar();
        Desabilitar();
    }//GEN-LAST:event_bnmodificarActionPerformed

    private void bneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bneliminarActionPerformed
        Eliminar();
        JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS","MENSAJE",JOptionPane.INFORMATION_MESSAGE);
        Limpiar();
        bnnuevo.setVisible(true);
        Desabilitar();
        bncancelar.setVisible(false);bnguardar.setVisible(false);
            bnmodificar.setVisible(false); bneliminar.setVisible(false);
            bnnuevo.setVisible(true);Buscar.setVisible(true);

    }//GEN-LAST:event_bneliminarActionPerformed

    private void lblsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsalirMouseClicked
        frmmenu.main(null);
        this.setVisible(false);
    }//GEN-LAST:event_lblsalirMouseClicked

    private void txttelefono2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefono2KeyTyped
        //Validar solo numeros y -
        char c=evt.getKeyChar();
        if (c<'0'|| c>'9' ){
            evt.consume();
        }
        //Validar hasta el rando de la base de datos
        if(txttelefono2.getText().length() == 10){
            evt.consume();
        }
    }//GEN-LAST:event_txttelefono2KeyTyped

    private void txttelefono2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefono2ActionPerformed
        bnguardar.requestFocus();
    }//GEN-LAST:event_txttelefono2ActionPerformed
    
    
    //METDO GUARDAR EN LA BD.- CREA UN OBJETO CARGO DONDE GUARDA LOS DATOS Y LLAMA AL REPOSITORY PAFRA ALMACENARLO
    public void Guardar(){
        Cliente t= new Cliente(0, txtcedula.getText(),txtnombres.getText(),
                txtapellidos.getText(),Convertirfecha(),(String) cbsexo.getSelectedItem(),
                txtdireccion.getText(), txttelefono2.getText());
        clienteRepository.Guardar(t); 
        Limpiar();
    }
    
    //METODO CONSULTAR.- PERMNITE
    public void ConsultarCliente(){
        List<Cliente> cliente=clienteRepository.Consultar(txtcedula.getText());
        
        for(Cliente cli: cliente){ 
            codigo.setText(Integer.toString(cli.getClienteid()));
            txtcedula.setText(cli.getCedula()); // la direccion de ruta no es la misma por eso no coje
            txtnombres.setText(cli.getNombre());
            txtapellidos.setText(cli.getApellido());
            dcfecha.setDate(cli.getFecha_nac());
            cbsexo.setSelectedItem(cli.getSexo());
            txtdireccion.setText(cli.getDireccion());
            txttelefono2.setText(cli.getTelefono());     
        }   
        Habilitar();
    }
    
    
     //METDO MODIFICAR EN LA BD.- CREA UN OBJETO CARGO DONDE GUARDA LOS DATOS Y LLAMA AL REPOSITORY PAFRA MODIFCARLO
    public void Modificar(){
        Cliente t= new Cliente(Integer.parseInt(codigo.getText()), txtcedula.getText(),txtnombres.getText(), txtapellidos.getText(),Convertirfecha(),
            (String) cbsexo.getSelectedItem(),txtdireccion.getText(), txttelefono2.getText());
        clienteRepository.Modificar(t); 
    } 
    
     public void Eliminar(){
        Cliente t= new Cliente(Integer.parseInt(codigo.getText()), txtcedula.getText(),txtnombres.getText(), txtapellidos.getText(),Convertirfecha(),
            (String) cbsexo.getSelectedItem(),txtdireccion.getText(), txttelefono2.getText());
        clienteRepository.Eliminar(t); 
     }
     
    
    public void Habilitar(){
         //Cajas de texto
        txtcedula.setEnabled(true);
        txtnombres.setEnabled(true);
        txtapellidos.setEnabled(true);
        dcfecha.setEnabled(true);
        cbsexo.setEnabled(true);
        txtdireccion.setEnabled(true);
        txttelefono2.setEnabled(true);
        

    }
    public void Desabilitar(){
         //Cajas de texto
        txtcedula.setEnabled(true);
        txtnombres.setEnabled(false);
        txtapellidos.setEnabled(false);
        dcfecha.setEnabled(false);
        cbsexo.setEnabled(false);
        txtdireccion.setEnabled(false);
        txttelefono2.setEnabled(false);
        
    }
    public void Limpiar(){
       txtcedula.setText("");
       txtnombres.setText("");
       txtapellidos.setText("");
       dcfecha.setDate(null);
       cbsexo.setSelectedIndex(-1);
       txtdireccion.setText("");
       txttelefono2.setText("");
       codigo.setText("");
    }
    //------- CONVERTIDOR DE FECHA  ------------
    public java.sql.Date Convertirfecha(){
        java.sql.Date fecha = new   java.sql.Date(dcfecha.getDate().getTime());
        return fecha;
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
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Buscar;
    private javax.swing.JToggleButton bncancelar;
    private javax.swing.JToggleButton bneliminar;
    private javax.swing.JToggleButton bnguardar;
    private javax.swing.JToggleButton bnmodificar;
    private javax.swing.JToggleButton bnnuevo;
    private javax.swing.JComboBox<String> cbsexo;
    private javax.swing.JTextField codigo;
    private com.toedter.calendar.JDateChooser dcfecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblsalir;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JTextField txttelefono2;
    // End of variables declaration//GEN-END:variables
}
