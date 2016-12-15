/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;


import Dominio.Cargo;
import Dominio.Trabajador;
import Repository.CargoRepository;
import Repository.TrabajadorRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alaña
 */
public class frmTrabajador extends javax.swing.JFrame {
    TrabajadorRepository trabajadorRepository= new TrabajadorRepository();
    CargoRepository cargoRepository= new CargoRepository();
    
//    public int cargos;
    
    public frmTrabajador() {
        initComponents();
        this.setLocationRelativeTo(null);
        CargarCargo();
        codigo.setVisible(false);
        lblmensaje.setVisible(false); jLabel20.setVisible(false);pfconfirmarcont.setVisible(false);pfcontrasena.setVisible(false);
        bncancelar.setVisible(false);bneliminar.setVisible(false);bnguardar.setVisible(false);bnmodificar.setVisible(false);
        
        
        txtcedula.requestFocus();
    }
    //METODO CARGAR CARGO.- EXTRAE TODOS LOS DATOS DEL ARRAY CARGOREPOSITORY PARA ALMACENARLO EN EL COMBO
    public void CargarCargo(){
        List<Cargo> cargo= cargoRepository.Cargar();
        for(Cargo c: cargo){
            cbcargo.addItem(c);
        }
        cbcargo.setSelectedIndex(-1);
    }
    //METDO GUARDAR EN LA BD.- CREA UN OBJETO CARGO DONDE GUARDA LOS DATOS Y LLAMA AL REPOSITORY PAFRA ALMACENARLO
    public void Guardar(){
        Trabajador t= new Trabajador(0, txtcedula.getText(),txtnombres.getText().toUpperCase(),
                txtapellidos.getText().toUpperCase(),Convertirfecha(),(String) cbsexo.getSelectedItem(),
                txtdireccion.getText().toUpperCase(),txttelefono.getText(), pfcontrasena.getText(),(Cargo)cbcargo.getSelectedItem());
        
        trabajadorRepository.Guardar(t);  
    }
    //METODO CONSULTAR.- PERMNITE
    public void ConsultarTrabajador(){
        List<Trabajador> trabajador=trabajadorRepository.Consultar(txtcedula.getText());
        if(trabajador.size()==0){
            JOptionPane.showMessageDialog(null, "NO EXISTE EN LA BASE DE DATOS","Error",JOptionPane.ERROR_MESSAGE);
            Buscar.setVisible(true);bnnuevo.setVisible(true);
            bncancelar.setVisible(false);bneliminar.setVisible(false);bnmodificar.setVisible(false);
            txtcedula.setText("");
        }else{
           for(Trabajador trab: trabajador){ 
            codigo.setText(Integer.toString(trab.getTrabajadorid()));
            cbcargo.setSelectedItem(trab.getCargo());
            txtnombres.setText(trab.getNombres());
            txtapellidos.setText(trab.getApellidos());
            dcfecha.setDate(trab.getFecha_nac());
            cbsexo.setSelectedItem(trab.getSexo());
            txtdireccion.setText(trab.getDireccion());
            txttelefono.setText(trab.getTelefono());
            txtcontraseña.setText(trab.getContraseña());      
        } 
        }
        
       
    }
    //METDO MODIFICAR EN LA BD.- CREA UN OBJETO CARGO DONDE GUARDA LOS DATOS Y LLAMA AL REPOSITORY PAFRA MODIFCARLO
    public void Modificar(){
        Trabajador t= new Trabajador(Integer.parseInt(codigo.getText()), txtcedula.getText(),txtnombres.getText().toUpperCase(),
                txtapellidos.getText().toUpperCase(),Convertirfecha(),(String) cbsexo.getSelectedItem(),
                txtdireccion.getText(),txttelefono.getText().toUpperCase(), txtcontraseña.getText(),(Cargo)cbcargo.getSelectedItem());
        trabajadorRepository.Modificar(t); 
    }
     public void Eliminar(){
        Trabajador t= new Trabajador(Integer.parseInt(codigo.getText()), txtcedula.getText(),txtnombres.getText(), txtapellidos.getText(),Convertirfecha(),
            (String) cbsexo.getSelectedItem(),txtdireccion.getText(),txttelefono.getText(), txtcontraseña.getText(),(Cargo)cbcargo.getSelectedItem());
        trabajadorRepository.Eliminar(t);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        txtnombres = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txtcontraseña = new javax.swing.JTextField();
        pfcontrasena = new javax.swing.JPasswordField();
        txttelefono = new javax.swing.JTextField();
        pfconfirmarcont = new javax.swing.JPasswordField();
        cbsexo = new javax.swing.JComboBox<>();
        codigo = new javax.swing.JLabel();
        lblmensaje = new javax.swing.JLabel();
        lblsalir = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Buscar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bnnuevo = new javax.swing.JToggleButton();
        bncancelar = new javax.swing.JToggleButton();
        bnguardar = new javax.swing.JToggleButton();
        bnmodificar = new javax.swing.JToggleButton();
        bneliminar = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        cbcargo = new javax.swing.JComboBox();
        dcfecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos de Empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 24), new java.awt.Color(51, 51, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Bodoni MT Black", 1, 24)); // NOI18N
        jLabel8.setText("C.I");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 43, 24));

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel9.setText("NOMBRES");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel10.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel10.setText("APELLIDOS");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 28));

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel11.setText("FECHA NACIMIENTO");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 276, -1));

        jLabel12.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel12.setText("SEXO");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 99, -1));

        jLabel14.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel14.setText("DIRECCION");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel13.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel13.setText("TELEFONO");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 124, -1));

        jLabel19.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel19.setText("CONTRASEÑA");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 164, 28));

        jLabel20.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel20.setText("CONFIRMAR CONTRASEÑA");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 304, -1));

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
        jPanel1.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 60, 180, 24));

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
        jPanel1.add(txtnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 272, 24));

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
        jPanel1.add(txtapellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 272, 24));

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
        jPanel1.add(txtdireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 240, 24));

        txtcontraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraseñaActionPerformed(evt);
            }
        });
        txtcontraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontraseñaKeyTyped(evt);
            }
        });
        jPanel1.add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 101, 24));

        pfcontrasena.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pfcontrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfcontrasenaActionPerformed(evt);
            }
        });
        pfcontrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pfcontrasenaKeyTyped(evt);
            }
        });
        jPanel1.add(pfcontrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 110, 25));

        txttelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 100, 24));

        pfconfirmarcont.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pfconfirmarcont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfconfirmarcontActionPerformed(evt);
            }
        });
        pfconfirmarcont.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pfconfirmarcontKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pfconfirmarcontKeyTyped(evt);
            }
        });
        jPanel1.add(pfconfirmarcont, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 110, 25));

        cbsexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FEMENINO", "MASCULINO" }));
        cbsexo.setSelectedIndex(-1);
        cbsexo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbsexoItemStateChanged(evt);
            }
        });
        jPanel1.add(cbsexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 130, 20));

        codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        codigo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 40, 27));

        lblmensaje.setForeground(new java.awt.Color(255, 51, 51));
        lblmensaje.setText("La Contraseña no coincide ");
        jPanel1.add(lblmensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));

        lblsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/boton salir.gif"))); // NOI18N
        lblsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsalirMouseClicked(evt);
            }
        });
        jPanel1.add(lblsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 80, 70));

        jLabel16.setFont(new java.awt.Font("Bodoni MT", 1, 24)); // NOI18N
        jLabel16.setText("CARGO");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 104, -1));

        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Consultar.png"))); // NOI18N
        Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarMouseClicked(evt);
            }
        });
        jPanel1.add(Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, 46));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        bnnuevo.setBackground(new java.awt.Color(255, 255, 51));
        bnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new.png"))); // NOI18N
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
        bnguardar.setToolTipText("");
        bnguardar.setBorderPainted(false);
        bnguardar.setContentAreaFilled(false);
        bnguardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add_user_1.png"))); // NOI18N
        bnguardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/add_user_2.png"))); // NOI18N
        bnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnguardarActionPerformed(evt);
            }
        });

        bnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar.png"))); // NOI18N
        bnmodificar.setBorderPainted(false);
        bnmodificar.setContentAreaFilled(false);
        bnmodificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bnmodificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar1.png"))); // NOI18N
        bnmodificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar2.png"))); // NOI18N
        bnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnmodificarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bnmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(bnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bnmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(93, 93, 93))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 120, 250));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Imgpersona.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        cbcargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcargoActionPerformed(evt);
            }
        });
        jPanel1.add(cbcargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 90, 180, -1));
        jPanel1.add(dcfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 136, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcedulaActionPerformed
        cbcargo.requestFocus();
    }//GEN-LAST:event_txtcedulaActionPerformed

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

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        txttelefono.requestFocus();
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        pfcontrasena.requestFocus();
    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        //Validar solo numeros y -
        char c=evt.getKeyChar();
        if (c<'0'|| c>'9' ){
            evt.consume();
        }
        //Validar hasta el rando de la base de datos
        String telefono = txttelefono.getText();
        if(telefono.length() == 10){
            evt.consume();
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void pfcontrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfcontrasenaActionPerformed
        pfconfirmarcont.requestFocus();
    }//GEN-LAST:event_pfcontrasenaActionPerformed

    private void pfcontrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfcontrasenaKeyTyped
        //Validar hasta el rango de la base de datos "4"
        String telefono = pfcontrasena.getText();
        if(telefono.length() == 4){
            evt.consume();
        }
    }//GEN-LAST:event_pfcontrasenaKeyTyped

    private void pfconfirmarcontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfconfirmarcontActionPerformed

    }//GEN-LAST:event_pfconfirmarcontActionPerformed

    private void pfconfirmarcontKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfconfirmarcontKeyReleased
        ConfirmarContraseña();           
    }//GEN-LAST:event_pfconfirmarcontKeyReleased

    private void pfconfirmarcontKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfconfirmarcontKeyTyped
        //Validar hasta el rango de la base de datos "4"
        String telefono = pfconfirmarcont.getText();
        if(telefono.length() == 4){
            evt.consume();
        }
    }//GEN-LAST:event_pfconfirmarcontKeyTyped

    private void cbsexoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbsexoItemStateChanged
        txtdireccion.requestFocus();
    }//GEN-LAST:event_cbsexoItemStateChanged

    private void lblsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsalirMouseClicked
        frmmenu.main(null);
        this.setVisible(false);
    }//GEN-LAST:event_lblsalirMouseClicked

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        //Validar hasta el rango de acuerdo a la base de datos "limite 50"
        if(txtdireccion.getText().length() == 100){
            evt.consume();
        }
        
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void txtcedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyReleased
   
    }//GEN-LAST:event_txtcedulaKeyReleased

    private void bnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnmodificarActionPerformed
        if(txtcedula.getText().length()<10){
            JOptionPane.showMessageDialog(null, "Digitos Incompletos","Error",JOptionPane.ERROR_MESSAGE);
            txtcedula.requestFocus();
        }else{
            if(txtcedula.getText().equals(" ")|| txtnombres.getText().equals("") ||txtapellidos.getText().equals("") ||
                dcfecha.getDate()==null || cbsexo.getActionCommand().equals("")||
                txtdireccion.getText().equals("")||txttelefono.getText().equals("")||txtcontraseña.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Falta datos por ingresar","Error",JOptionPane.ERROR_MESSAGE);
            }else{
                if(JOptionPane.showConfirmDialog(null,"Actualizar Datos", "Confirmar",1)==0){
                    Modificar();
                    Buscar.setVisible(true);bnnuevo.setVisible(true);
                    bncancelar.setVisible(false);bneliminar.setVisible(false);bnmodificar.setVisible(false);
                    Limpiar();
                }
            }
        } 
        
    }//GEN-LAST:event_bnmodificarActionPerformed

    private void bneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bneliminarActionPerformed

        Eliminar();
        JOptionPane.showMessageDialog(null,"DATOS ELIMINADOS EXISTOSAMENTE");
        Buscar.setVisible(true);bnnuevo.setVisible(true);
        bncancelar.setVisible(false);bneliminar.setVisible(false);bnmodificar.setVisible(false);
        Limpiar();
    }//GEN-LAST:event_bneliminarActionPerformed

    private void bnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnguardarActionPerformed
        
        if(txtcedula.getText().length()<10){
            JOptionPane.showMessageDialog(null, "Digitos Incompletos","Error",JOptionPane.ERROR_MESSAGE);
            txtcedula.requestFocus();
        }else{
            if(txtcedula.getText().equals("")||txtnombres.getText().equals("") ||txtapellidos.getText().equals("") ||
                dcfecha.getDate()==null || cbsexo.getActionCommand().equals("")||
                txtdireccion.getText().equals("")|| txttelefono.getText().equals("")||
                pfcontrasena.getText().equals(" ")){
                JOptionPane.showMessageDialog(null, "FALTA DATOS POR INGRESAR","Error",JOptionPane.ERROR_MESSAGE);   
            }
            if(JOptionPane.showConfirmDialog(null,"GUARDAR DATOS", "Confirmar",1)==0){
               Guardar();
               JOptionPane.showMessageDialog(null,"DATOS GUARDADOS EXISTOSAMENTE","",JOptionPane.QUESTION_MESSAGE);
               Limpiar();
           
           
               lblmensaje.setVisible(false); jLabel20.setVisible(false);pfconfirmarcont.setVisible(false);pfcontrasena.setVisible(false);
               bncancelar.setVisible(false);bneliminar.setVisible(false);bnguardar.setVisible(false);bnmodificar.setVisible(false);
               Buscar.setVisible(true);bnnuevo.setVisible(true);txtcontraseña.setVisible(true);
         
        
            }
            
        }       
    }//GEN-LAST:event_bnguardarActionPerformed

    private void BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseClicked
        Buscar.setVisible(false);bnnuevo.setVisible(false);
        bncancelar.setVisible(true);bneliminar.setVisible(true);bnmodificar.setVisible(true);
        txtcontraseña.setVisible(true); 
        ConsultarTrabajador();
        
      
        
    }//GEN-LAST:event_BuscarMouseClicked

    private void bnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnnuevoActionPerformed

        Buscar.setVisible(false);bnnuevo.setVisible(false);bnguardar.setVisible(true);bncancelar.setVisible(true);
        jLabel20.setVisible(true);pfconfirmarcont.setVisible(true);
        txtcontraseña.setVisible(false);pfcontrasena.setVisible(true);
        Limpiar();
        
        
        
        
    }//GEN-LAST:event_bnnuevoActionPerformed

    private void bncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bncancelarActionPerformed

       if(JOptionPane.showConfirmDialog(null, "Desea Cancelar", "Error", JOptionPane.ERROR_MESSAGE)==0){
            Buscar.setVisible(true);bnnuevo.setVisible(true);
            bncancelar.setVisible(false);bneliminar.setVisible(false);bnmodificar.setVisible(false);bnguardar.setVisible(false);
            pfconfirmarcont.setVisible(false);jLabel20.setVisible(false);
            Buscar.setVisible(true);bnnuevo.setVisible(true);
            Limpiar();
            txtcedula.requestFocus();
        }
    }//GEN-LAST:event_bncancelarActionPerformed

    private void cbcargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcargoActionPerformed

    }//GEN-LAST:event_cbcargoActionPerformed

    private void txtcontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraseñaActionPerformed

    private void txtcontraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraseñaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraseñaKeyTyped


    
    //--------- CONFIRMAR LA CONTRASEÑA SI ES CORRECTA O NO -----------
    public void ConfirmarContraseña(){
         if(pfconfirmarcont.getText().length()==4){ 
            if(pfconfirmarcont.getText().equals(pfcontrasena.getText())){
                bnguardar.requestFocus();
            }else{
                lblmensaje.setVisible(true);
                pfconfirmarcont.requestFocus();  
            }
          
        }
        if(pfconfirmarcont.getText().equals("")){
            lblmensaje.setVisible(false);
        }
    }
    
   
    public void Limpiar(){
       codigo.setText("");
       cbcargo.setSelectedIndex(-1);
       txtcedula.setText("");
       txtnombres.setText("");
       txtapellidos.setText("");
       dcfecha.setDate(null);
       cbsexo.setSelectedIndex(-1);
       txtdireccion.setText("");
       
       txttelefono.setText("");
       pfcontrasena.setText("");
       pfconfirmarcont.setText(""); 
       txtcontraseña.setText(" ");
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
            java.util.logging.Logger.getLogger(frmTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTrabajador().setVisible(true);
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
    private javax.swing.JComboBox cbcargo;
    private javax.swing.JComboBox<String> cbsexo;
    private javax.swing.JLabel codigo;
    private com.toedter.calendar.JDateChooser dcfecha;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblmensaje;
    private javax.swing.JLabel lblsalir;
    private javax.swing.JPasswordField pfconfirmarcont;
    private javax.swing.JPasswordField pfcontrasena;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtcontraseña;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
