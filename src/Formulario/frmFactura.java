/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import Dominio.Cliente;
import Dominio.Consumo;
import Dominio.DetalleFactura;
import Dominio.Factura;
import Dominio.Producto;
import Repository.ClienteRepository;
import Repository.ConsumoRepository;
import static Repository.ContraseñaRepository.usuario;
import Repository.DetalleFacturaRepository;
import Repository.FacturaRepository;
import Repository.ProductoRepository;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus Alaña
 */
public class frmFactura extends javax.swing.JFrame implements Printable{
    DefaultTableModel modelo = new DefaultTableModel();
    FacturaRepository facturaRepository= new FacturaRepository();
    DetalleFacturaRepository detalleFacturaRepository = new DetalleFacturaRepository();
    ConsumoRepository consumoRepository= new ConsumoRepository();
    ProductoRepository productoRepository= new ProductoRepository();
    ClienteRepository clienteRepository= new ClienteRepository();
    int x=0,codigo=0;
    DateFormat df= DateFormat.getDateInstance(); 
    
    public frmFactura() {
        initComponents();
        Date FechaActual = new Date();     //FORMATO DE dd/mm/yyyy HORA
        lblfecha.setText(df.format(FechaActual)); // VALIDAR SOLO FECHA
        dcfecha.setDate(FechaActual);
        dcfecha.setVisible(false);
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("VALOR");
        Ttabla.setModel(modelo);
        vendedor.setText(usuario);
        vendedor.setVisible(true);
        CodigoFactura();
        TiposConsumo();
        
        
    }
     //  ********** CARGAR TABLA     ****************
    public void CargarTable(){
        
        String []registro = new String[4];
        int cantidad = Integer.parseInt(txtcantidad.getText());
        double precio = Double.parseDouble(txtprecio.getText());
        double valor = cantidad* precio;
        registro[0] = cbdescripcion.getSelectedItem().toString();
        registro[1] = txtprecio.getText();
        registro[2] = txtcantidad.getText();
        registro[3] = Double.toString(valor);
        modelo.addRow(registro);
        Ttabla.setModel(modelo);

        Calcular();
        txtcantidad.setText("");

    }
    public int Calcular(){
        Double valor=0.0d;
        for(int c=0; c<Ttabla.getRowCount();c++){
            valor= valor+ Double.parseDouble(Ttabla.getValueAt(c, 3).toString());
        }
        Double iva = Math.rint(valor*0.14*10)/10;
       
        txttotal.setText(Double.toString(valor));
        txtiva.setText(Double.toString(iva));
        txttotalpagar.setText(Double.toString(valor+iva));   
        return x++;
    }
    
    // ******     CODIGO DE LA FACTURA     *******
    public void CodigoFactura(){
        codigo= facturaRepository.CodigoFactura()+1;
        codfactura.setText("000-00"+codigo);
    }
    // ******     CONSUMOS     *******
    public void TiposConsumo(){
        
        List<Consumo> con= consumoRepository.Cargar();
        for(Consumo c: con){
            cbconsumo.addItem(c);
        }
        
        cbconsumo.setSelectedIndex(-1);
        
    }
    //     Descripcion Producto
    public void DescripcionProducto(){
        
        cbdescripcion.removeAllItems();
        List<Producto> pro= productoRepository.DescripcionProducto(cbconsumo.getSelectedItem().toString());
        for(Producto producto: pro){
            cbdescripcion.addItem(producto.getDescripcion());
           
        }
        cbdescripcion.setSelectedIndex(-1);
    }
    //     Descripcion Precio y Cantidad
    public void Precio(){
        List<Producto> pro= productoRepository.Precio(cbdescripcion.getSelectedItem().toString());
        for(Producto producto: pro){
            txtprecio.setText( Double.toString(producto.getPrecio()));
            txtcantbase.setText( Integer.toString(producto.getCantidad()));
           
        }
    }
    //    MODIFICACION DEL STOCK
    public void Stock(){
        int fila=0;
       Producto producto = new Producto();
       while(fila<x){
           producto.setDescripcion( Ttabla.getValueAt(fila,0).toString() );
           producto.setCantidad( Integer.parseInt(Ttabla.getValueAt(fila,2).toString()) );
           productoRepository.Stock(producto);
           fila++;
       }
    }
    
    
    // ******      CONSULTAR CLIENTE   *******
    public void ConsultarCliente(){
        
        List<Cliente> cliente= clienteRepository.Consultar(txtcedula.getText());
        for(Cliente c: cliente){
            txtcliente.setText( c.getNombre()+" "+ c.getApellido() );
        }
    }
    //   ********      GUARDAR FACTURA     *************
    public void IngresarFactura(){
        Factura f= new Factura();
        f.setCajero(vendedor.getText());
        f.setCliente(txtcliente.getText());
        f.setValor_cancelado(Double.parseDouble(txttotalpagar.getText()));
        f.setFecha( Convertirfecha());
        facturaRepository.Ingresar(f);
        
    }
    //  *********     DETALLE DE FACTURA   ************
    public void IngresarDetalleF(){
        DetalleFactura d= new DetalleFactura();
        Factura fac= new Factura();
        int fila=0;
        while(fila<x){
            d.setDescripcion(Ttabla.getValueAt(fila,0).toString());
            d.setPrecio(Double.parseDouble( Ttabla.getValueAt(fila,1).toString()));
            d.setCantidad(Integer.parseInt(Ttabla.getValueAt(fila,2).toString()));
            d.setTotal(Double.parseDouble( Ttabla.getValueAt(fila,3).toString()));  
            fac.setFacturaid(codigo);
            d.setFactura( fac );
            detalleFacturaRepository.IngresarDetalleF(d);
            fila++; 
        }
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Eliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Ttabla = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        txtiva = new javax.swing.JTextField();
        txttotalpagar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        vendedor = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        codfactura = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dcfecha = new com.toedter.calendar.JDateChooser();
        bnbuscar = new javax.swing.JButton();
        txtcedula = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cbdescripcion = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        Precio = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        Precio1 = new javax.swing.JLabel();
        txtcantbase = new javax.swing.JTextField();
        txtcantidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cbconsumo = new javax.swing.JComboBox();
        lblsalir1 = new javax.swing.JLabel();
        bnguardar = new javax.swing.JButton();

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

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
        jScrollPane2.setViewportView(Ttabla);

        jLabel17.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        jLabel17.setText("Total");

        jLabel18.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        jLabel18.setText("iva");

        jLabel19.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        jLabel19.setText("Total a pagar");

        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel1.setText("Factura ");

        vendedor.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        vendedor.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        jLabel10.setText("Cédula");

        jLabel20.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        jLabel20.setText("Fecha emisión");

        codfactura.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtcliente.setEditable(false);
        txtcliente.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        jLabel11.setText("Cliente");

        jLabel13.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        jLabel13.setText("N °");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ImgLogo.JPG"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/detalle.JPG"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/vendedor.JPG"))); // NOI18N

        bnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1472724945_Zoom.png"))); // NOI18N
        bnbuscar.setBorderPainted(false);
        bnbuscar.setContentAreaFilled(false);
        bnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnbuscarActionPerformed(evt);
            }
        });

        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel11)
                        .addGap(17, 17, 17)
                        .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(278, 278, 278)
                                .addComponent(jLabel19)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(55, 55, 55)))
                        .addComponent(txttotalpagar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jLabel17)
                        .addGap(17, 17, 17)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLabel18)
                        .addGap(23, 23, 23)
                        .addComponent(txtiva, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(bnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(27, 27, 27)
                                    .addComponent(jLabel13)
                                    .addGap(12, 12, 12)
                                    .addComponent(codfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(10, 10, 10)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(dcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(codfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20)
                                    .addComponent(lblfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(dcfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bnbuscar)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel17))
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(txtiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txttotalpagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 490));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "PRODUCTOS ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 0, 14))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        jLabel14.setText("Consumo");

        cbdescripcion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbdescripcionItemStateChanged(evt);
            }
        });
        cbdescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbdescripcionActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        jLabel15.setText("Descripción");

        Precio.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        Precio.setText("Precio");

        jLabel16.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        jLabel16.setText("Cantidad");

        txtprecio.setEditable(false);

        Precio1.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        Precio1.setText("Stock");

        txtcantbase.setEditable(false);

        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit_1.png"))); // NOI18N
        jButton1.setText("AGREGAR");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit_2.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/edit_2.png"))); // NOI18N
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbconsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbconsumoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(Precio)
                                        .addGap(34, 34, 34)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtprecio, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                    .addComponent(txtcantidad))
                                .addGap(52, 52, 52)
                                .addComponent(Precio1)))
                        .addGap(18, 18, 18)
                        .addComponent(txtcantbase, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(cbdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbconsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel15))
                    .addComponent(cbdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcantbase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Precio)
                            .addComponent(Precio1))))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 270));

        lblsalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/boton salir.gif"))); // NOI18N
        lblsalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblsalir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblsalir1MouseClicked(evt);
            }
        });
        jPanel3.add(lblsalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, 90));

        bnguardar.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        bnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imprimir.png"))); // NOI18N
        bnguardar.setText("IMPRIMIR");
        bnguardar.setBorderPainted(false);
        bnguardar.setContentAreaFilled(false);
        bnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bnguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bnguardar.setIconTextGap(-1);
        bnguardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imprimir1.png"))); // NOI18N
        bnguardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imprimir2.png"))); // NOI18N
        bnguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnguardarActionPerformed(evt);
            }
        });
        jPanel3.add(bnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 126, 120));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 0, 330, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnbuscarActionPerformed
       if(txtcedula.getText().length()<10){
            JOptionPane.showMessageDialog(null, "Digitos Incompletos","Error",JOptionPane.ERROR_MESSAGE);
            txtcedula.requestFocus();
        }else{
            ConsultarCliente();
            if(txtcliente.getText().equals("")){
                JOptionPane.showMessageDialog(null,"No existe en la base de dstos", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
                if(JOptionPane.showConfirmDialog(null,"Ingresar Cliente", "CONFIRMAR",1)==0){
                    new frmCliente().setVisible(true);
                    this.setVisible(false);
                }
            }
        }
        if(txtcedula.getText().equals("")){ txtcliente.setText(" ");}
        
    }//GEN-LAST:event_bnbuscarActionPerformed

    private void cbdescripcionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbdescripcionItemStateChanged
        txtcantidad.requestFocus();
    }//GEN-LAST:event_cbdescripcionItemStateChanged

    private void cbdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbdescripcionActionPerformed
         if(cbdescripcion.getSelectedIndex() !=-1){
             Precio();
         }else{
             txtprecio.setText("");
             txtcantbase.setText("");
         }
    }//GEN-LAST:event_cbdescripcionActionPerformed

    private void bnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnguardarActionPerformed
        if(txtcedula.getText().equals("")|| txtcliente.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Falta datos por ingresar","Error",JOptionPane.ERROR_MESSAGE);
            txtcedula.requestFocus();

        }else{
            IngresarFactura();
            IngresarDetalleF();
            Stock();
            Imprimir();
            new frmmenu().setVisible(true);
            this.setVisible(false);
        }

    }//GEN-LAST:event_bnguardarActionPerformed

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        if(txtcantidad.getText().length()==2){evt.consume();}
        char e=evt.getKeyChar();
        if(e<'0'|| e>'9'){evt.consume();}

    }//GEN-LAST:event_txtcantidadKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(txtcantidad.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese Cantidad","ERROR",JOptionPane.ERROR_MESSAGE );
        }else{
            int n= Integer.parseInt(txtcantidad.getText());
            int n2=Integer.parseInt(txtcantbase.getText());
            if(n==0){
                JOptionPane.showMessageDialog(null,"Ingrese Cantidad mayor a 0","ERROR",JOptionPane.ERROR_MESSAGE );
                txtcantidad.requestFocus();
            }else{
                if(n>n2 ){
                    JOptionPane.showMessageDialog(null, "Excede de la cantidad de stock");
                    txtcantidad.requestFocus();
                }else{
                    CargarTable();
                    Limpiar();
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblsalir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblsalir1MouseClicked
        frmmenu.main(null);
        this.setVisible(false);
    }//GEN-LAST:event_lblsalir1MouseClicked

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int fila= Ttabla.getSelectedRow();
        Double valor=0.0d;
        if(fila>=0){
            modelo.removeRow(fila);
        }
        x--;
        Calcular();

    }//GEN-LAST:event_EliminarActionPerformed

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
       if(txtcedula.getText().length()==10){evt.consume();}
        char e=evt.getKeyChar();
        if(e<'0'|| e>'9'){evt.consume();}
    }//GEN-LAST:event_txtcedulaKeyTyped

    private void cbconsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbconsumoActionPerformed
        if(cbconsumo.getSelectedIndex() !=-1){ 
            DescripcionProducto();
        }
    }//GEN-LAST:event_cbconsumoActionPerformed

    public void Limpiar(){
        txtcantidad.setText("");
        txtprecio.setText("");
        txtcantbase.setText("");
    }
     //------- CONVERTIDOR DE FECHA  ------------
    public java.sql.Date Convertirfecha(){
        java.sql.Date fecha = new   java.sql.Date(dcfecha.getDate().getTime());
        return fecha;
    }
     public void Imprimir(){
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(this);
        if(printerJob.printDialog()){
            try{
                printerJob.print();
            }catch(PrinterException ex){
                JOptionPane.showMessageDialog(null, "Error!", "Error\n"+ ex,JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException{
        if(pageIndex == 0){
               Graphics2D g2d = (Graphics2D) graphics;
               g2d.translate(pageFormat.getImageableX() + 30,pageFormat.getImageableY()+ 30);
               jPanel1.printAll(graphics);
               return PAGE_EXISTS;
            }else{
                 return NO_SUCH_PAGE;
             }
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
            java.util.logging.Logger.getLogger(frmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JLabel Precio;
    private javax.swing.JLabel Precio1;
    private javax.swing.JTable Ttabla;
    private javax.swing.JButton bnbuscar;
    private javax.swing.JButton bnguardar;
    private javax.swing.JComboBox cbconsumo;
    public javax.swing.JComboBox cbdescripcion;
    private javax.swing.JLabel codfactura;
    private com.toedter.calendar.JDateChooser dcfecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblsalir1;
    private javax.swing.JTextField txtcantbase;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtiva;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txttotalpagar;
    private javax.swing.JLabel vendedor;
    // End of variables declaration//GEN-END:variables

 
    
}
