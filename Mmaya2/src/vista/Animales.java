
package vista;

import static conexion.connPos.getConexion;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.animal;
import conexion.*;
import conexion.connPos;
import java.awt.Color;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class Animales extends javax.swing.JInternalFrame {

    static ResultSet res; 
    public FileInputStream fisfoto;
    FileInputStream fisI;
    
     public FileInputStream fisA;
        public   FileInputStream fisB;
            public  FileInputStream fisC;
                
    int longitudBytes;
    public animal an;
    
    
   
   
    
    public Animales() {
        initComponents();
        cargaTodoAnimales();
          
        //CAPTURANDO FECHAS ACTUALES
        Date d=new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
        txtFecha.setText(String.valueOf(formato.format(d)));
        //MOSTRANDO ERRORES EN LA VALIDACION
        lblerrorParteUso.setVisible(false);
        lblerrorParteUso2.setVisible(false);
        lblerrorParteUso1.setVisible(false);
        lblFotoAnimal1.setVisible(true);
        lblDibAnimal1.setVisible(true);
        AcodDep.setVisible(false);  
        AmunCod.setVisible(false);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getSize();
        int horizontal=(pantalla.width-ventana.width)/2;
        int vertical=(pantalla.height-ventana.height)/2;
        this.setLocation(horizontal,vertical);
        btnBorrarAni.setVisible(false);
    
        //DESHABILITANDO MOVER LA VENTANA
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        
        // MOSTRANDO DATOS TIPO DE REGION  EN EL COMBOBOX DESDE LA BD
         this.cmbTipoRegion.removeAllItems();
         try{
             Connection cn=getConexion();
             Statement sent=cn.createStatement();
             ResultSet rs=sent.executeQuery("select distinct tipo_region from region");
             while(rs.next()){
                  this.cmbTipoRegion.addItem(rs.getString("tipo_region"));
             }
             
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         
         // MOSTRANDO DATOS ECOREGION EN EL COMBOBOX DESDE LA BD
         this.jComboregani.removeAllItems();
         try{
             Connection cn=getConexion();
             Statement sent=cn.createStatement();
             ResultSet rs=sent.executeQuery("SELECT ecoregion FROM REGION");
             while(rs.next()){
                  this.jComboregani.addItem(rs.getString("ecoregion"));
             }
             
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         
         
         
         // MOSTRANDO DATOS DE MUNICIPIO EN EL COMBOBOX 
         this.cmbMunicipio.removeAllItems();
         try{
             Connection cn=getConexion();
             Statement sent=cn.createStatement();
             ResultSet rs=sent.executeQuery("SELECT * FROM MUNICIPIOS");
             while(rs.next()){
                  this.cmbMunicipio.addItem(rs.getString("nom_mncp"));
             }
             
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         
           // MOSTRANDO DATOS DE DEPARTAMENTOS EN EL COMBOBOX 
         this.cmbDepto.removeAllItems();
         try{
             Connection cn=getConexion();
             Statement sent=cn.createStatement();
             ResultSet rs=sent.executeQuery("SELECT * FROM DEPARTAMENTO");
             while(rs.next()){
                  this.cmbDepto.addItem(rs.getString("nom_dpto"));
             }
             
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         
         
          // MOSTRANDO DATOS DE RESGITRANTE EN EL COMBOBOX 
         this.cmbRegisCI.removeAllItems();
         try{
             Connection cn=getConexion();
             Statement sent=cn.createStatement();
             ResultSet rs=sent.executeQuery("SELECT * FROM registrante");
             while(rs.next()){
                  this.cmbRegisCI.addItem(rs.getString("cod_registrante"));
             }
             
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
       
    }
    
      public void cargaTodoAnimales(){
       DefaultTableModel modelo=(DefaultTableModel)tablaAnimal.getModel();
       modelo.setRowCount(0);
//      res = conexion.connPos.Consulta("SELECT cod_animal,cod_region,nombre_nativo,nombre_cientifico,nombre_tco,nombre_comunidad,nom_repnat,ap_repnat,am_repnat,cargo_repnat,especie,color,coorx,coory,foto_animal,dibujo,acta_ani,tipo_uso,parte_uso,manera_uso,descripcion_animal,fecha_registro,fuente_de_datos,idioma_region,uso_combinado,observaciones FROM ANIMAL");
       res = conexion.connPos.Consulta("SELECT cod_animal,nombre_nativo,nombre_cientifico,tipo_uso,parte_uso,manera_uso,descripcion_animal,observaciones FROM animal");
       try{
         while(res.next()){
             Vector v = new Vector();
             v.add(res.getString(1));
             v.add(res.getString(2));
//             v.add(res.getInt(2));
             v.add(res.getString(3));
             v.add(res.getString(4));
             v.add(res.getString(5));
             v.add(res.getString(6));
             v.add(res.getString(7));
             v.add(res.getString(8));
             
//             v.add(res.getString(5));  AtxtObs
//             v.add(res.getString(6));
//             v.add(res.getString(7));
//             v.add(res.getString(8));
//             v.add(res.getString(9));
//             v.add(res.getString(10));
//             v.add(res.getString(11));
//             v.add(res.getString(12));
//             v.add(res.getString(13));
//             v.add(res.getString(14));
//             v.add(res.getString(15));
//             v.add(res.getString(16));
//             v.add(res.getString(17));
//             v.add(res.getString(18));
//             v.add(res.getString(19));
//             v.add(res.getString(20));
//             v.add(res.getString(21));
//             v.add(res.getString(22));
//             v.add(res.getString(23));
//             v.add(res.getString(24));
//             v.add(res.getString(25));
//             v.add(res.getString(26));
//             
//             
             
             
             modelo.addRow(v);
             tablaAnimal.setModel(modelo);
             }
       }
       catch(SQLException e){
       
       }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboregani = new javax.swing.JComboBox();
        txtCodReg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbMunicipio = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtComunidad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtCoordXGrados = new javax.swing.JTextField();
        txtTco = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtCoordYGrados = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        cmbDepto = new javax.swing.JComboBox();
        jLabel52 = new javax.swing.JLabel();
        cmbTipoRegion = new javax.swing.JComboBox();
        AcodDep = new javax.swing.JTextField();
        AmunCod = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNativo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCientifico = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cmbIdioma = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        txtFuente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AtxtObsA = new javax.swing.JTextArea();
        lblerrorParteUso2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblcontarParteUso2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txtRegPaterno = new javax.swing.JTextField();
        txtRegMaterno = new javax.swing.JTextField();
        txtRegNombre = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtInfPaterno = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtInfMaterno = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtInfNombre = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        btnActa = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        AtxtObs2 = new javax.swing.JTextArea();
        lblActaAnimal = new javax.swing.JLabel();
        cmbRegisCI = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtEspecie = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtColorA = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblFotoAnimal1 = new javax.swing.JLabel();
        lblDibAnimal1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtUso = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtParteUso = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        lblerrorParteUso = new javax.swing.JLabel();
        lblcontarParteUso = new javax.swing.JLabel();
        lblcontarParteUso1 = new javax.swing.JLabel();
        lblerrorParteUso1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AtxtComoUso = new javax.swing.JTextArea();
        chkCombinado = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnRegAnimales = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnBorrarAni = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaAnimal = new javax.swing.JTable();

        jMenuItem1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jMenuItem1.setText("MODIFICAR");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jMenuItem2.setText("ELIMINAR");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setForeground(new java.awt.Color(0, 0, 0));
        setTitle("REGISTRAR ANIMALES");
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(900, 700));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("REGION HABITAD DEL ANIMAL"));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Departamento:");

        jComboregani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboreganiActionPerformed(evt);
            }
        });

        txtCodReg.setEditable(false);
        txtCodReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodRegActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Codigo de Region :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Municipio:");

        cmbMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMunicipioActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Comunidad:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("TCO/Area Protegida:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Coord X");

        txtCoordXGrados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCoordXGradosKeyTyped(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Coord Y");

        txtCoordYGrados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCoordYGradosKeyTyped(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Tipo Region:");

        cmbDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDeptoActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Ecoregion :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5)
                            .addComponent(jLabel12))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbMunicipio, 0, 128, Short.MAX_VALUE)
                                    .addComponent(txtComunidad)
                                    .addComponent(txtTco)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cmbDepto, 0, 129, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel28)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCoordXGrados, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                        .addComponent(txtCoordYGrados)
                                        .addComponent(txtCodReg, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                    .addComponent(jLabel51)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbTipoRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboregani, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(AcodDep, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AmunCod, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbDepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtComunidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtTco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cmbMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(txtCoordXGrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCoordYGrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipoRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AcodDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AmunCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel52)
                    .addComponent(jComboregani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DEL ANIMAL"));
        jPanel7.setAutoscrolls(true);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Codigo:");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Nombre Nativo:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Nombre Cientifico:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Idioma:");

        cmbIdioma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Elegir Idioma>", "Aymara", "Araona", "Baure", "Bésiro", "Canichana", "Cavineño", "Cayubaba", "Chácobo", "Ese ejja", "Guaraní", "Guarasu’we", "Guarayu", "Itonama", "Leco", "Machajuyai-kallawaya", "Machineri", "Maropa", "Mojeño-trinitario", "Mojeño-ignaciano", "Moré", "Tsimane", "Mosetén", "Movima", "Pacawara", "Puquina", "Quechua ", "Sirionó", "Tacana ", "Tapiete ", "Toromona", "Uru-chipaya", "Weenhayek", "Yaminawa", "Yuki", "Yuracaré ", "Zamuco" }));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Fuente Información:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Descripción:");

        AtxtObsA.setColumns(20);
        AtxtObsA.setRows(5);
        AtxtObsA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AtxtObsAKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(AtxtObsA);

        lblerrorParteUso2.setForeground(new java.awt.Color(255, 0, 0));
        lblerrorParteUso2.setText("Se ha llegado al limite de caracteres");

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel13.setText("(No debe sobrepasar 2000 caracteres)");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel7)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo)
                            .addComponent(txtNativo)
                            .addComponent(txtCientifico, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbIdioma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFuente))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(129, 129, 129)
                        .addComponent(lblcontarParteUso2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lblerrorParteUso2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(357, 368, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(cmbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtNativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtCientifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel8))
                    .addComponent(lblcontarParteUso2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblerrorParteUso2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("DATOS GENERALES", jPanel4);

        jLabel32.setText("Datos del Registrante:");

        txtRegPaterno.setEditable(false);

        txtRegMaterno.setEditable(false);

        txtRegNombre.setEditable(false);

        jLabel33.setText("Paterno");

        jLabel34.setText("Materno");

        jLabel35.setText("Nombre(s)");

        jLabel36.setText("Datos del Informante");

        jLabel37.setText("Paterno");

        jLabel38.setText("Materno");

        jLabel39.setText("Nombre(s)");

        jLabel40.setText("Cargo del Informante");

        btnActa.setText("Examinar ...");
        btnActa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActaActionPerformed(evt);
            }
        });

        jLabel41.setText("Cargar foto de Acta");

        jLabel42.setText("Observaciones (Anexos, datos extras anotar si existen grabaciones o videos anexos adjuntos)");

        AtxtObs2.setColumns(20);
        AtxtObs2.setRows(5);
        jScrollPane5.setViewportView(AtxtObs2);

        lblActaAnimal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cmbRegisCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRegisCIActionPerformed(evt);
            }
        });

        jLabel24.setText("C I  Registrante  :");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtRegPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel33))
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRegMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtRegNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel35)))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtCargo, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtInfPaterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                                .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(btnActa, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtInfMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel38))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtInfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel39)))
                                                    .addComponent(jLabel34)))
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(lblActaAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(cmbRegisCI, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel42)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel41)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRegisCI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(7, 7, 7)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRegPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRegMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRegNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(37, 37, 37)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtInfPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtInfMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtInfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel41)
                            .addComponent(btnActa)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblActaAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("DATOS DE LA FUENTE", jPanel8);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DESCRIPCION DEL ANIMAL"));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Especie:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Color:");

        jButton2.setText("Examinar...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Examinar...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Añadir Imagen del Animal : ");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Añadir Dibujo del Animal :");

        lblFotoAnimal1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblDibAnimal1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel14)
                        .addGap(38, 38, 38)
                        .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel15)
                                .addGap(35, 35, 35)
                                .addComponent(txtColorA, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblDibAnimal1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(lblFotoAnimal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)
                                .addComponent(txtColorA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(101, 101, 101)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(lblFotoAnimal1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jLabel21))
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblDibAnimal1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MORFOLOGIA", jPanel5);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("USO DEL ANIMAL"));
        jPanel3.setEnabled(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 700));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Tipo de Uso:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Se utiliza esta parte del Animal :");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Se utiliza de esta manera:");

        txtParteUso.setColumns(20);
        txtParteUso.setRows(5);
        txtParteUso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtParteUsoKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txtParteUso);

        jLabel10.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel10.setText("(No debe sobrepasar 1000 caracteres)");

        lblerrorParteUso.setForeground(new java.awt.Color(255, 0, 0));
        lblerrorParteUso.setText("Se ha llegado all limite de caracteres");

        lblerrorParteUso1.setForeground(new java.awt.Color(255, 0, 0));
        lblerrorParteUso1.setText("Se ha llegado all limite de caracteres");

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel11.setText("(No debe sobrepasar 1000 caracteres)");

        AtxtComoUso.setColumns(20);
        AtxtComoUso.setRows(5);
        AtxtComoUso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AtxtComoUsoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(AtxtComoUso);

        chkCombinado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCombinadoActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Combinado : ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUso, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkCombinado)
                                .addGap(181, 181, 181)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblerrorParteUso1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblcontarParteUso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblcontarParteUso1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblerrorParteUso, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel27))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtUso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(chkCombinado))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcontarParteUso, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(lblerrorParteUso))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcontarParteUso1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(lblerrorParteUso1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(377, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("USO", jPanel6);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("FORMULARIO DE REGISTRO DE ANIMALES");

        jLabel2.setText("Fecha Registro:");

        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFecha.setText("jTextField1");
        txtFecha.setEnabled(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        btnRegAnimales.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegAnimales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/registrar.png"))); // NOI18N
        btnRegAnimales.setText("REGISTRAR");
        btnRegAnimales.setToolTipText("");
        btnRegAnimales.setActionCommand("NUEVO REGISTRO");
        btnRegAnimales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegAnimalesActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        jButton1.setText("EDITAR REGISTRO");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnBorrarAni.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBorrarAni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnBorrarAni.setText("BORRAR REGISTRO");
        btnBorrarAni.setToolTipText("");
        btnBorrarAni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarAniActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setText("TABLA DE REGISTROS");

        jScrollPane7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaAnimal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "codigo", "nombre nativo", "nombre cientifico", "tipo uso", "parte uso", "manera uso", "descripcion", "obervaciones"
            }
        ));
        tablaAnimal.setComponentPopupMenu(jPopupMenu1);
        jScrollPane4.setViewportView(tablaAnimal);

        jScrollPane7.setViewportView(jScrollPane4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(257, 257, 257)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(226, 226, 226))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrarAni))
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFecha))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnRegAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnBorrarAni, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtParteUsoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParteUsoKeyTyped
        int cuenta=txtParteUso.getText().length();
        String k=txtParteUso.getText();
        lblcontarParteUso.setText(String.valueOf(cuenta));
        if(cuenta > 999){
         String nueva= k.substring(0, k.length()-1 );
         txtParteUso.setText(nueva);
         lblerrorParteUso.setVisible(true);      
        }
        txtParteUso.setLineWrap(true);
        txtParteUso.setWrapStyleWord(true);
    }//GEN-LAST:event_txtParteUsoKeyTyped

    private void btnRegAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegAnimalesActionPerformed

            try{
            String sql="INSERT INTO \"animal\"(cod_animal,cod_region,cod_registrante,cod_dpto,cod_mncp,nombre_nativo,nombre_cientifico,nombre_tco,nombre_comunidad,nom_repnat,ap_repnat,am_repnat,cargo_repnat,especie,color,coorx,coory,foto_animal,dibujo,acta_ani,tipo_uso,parte_uso,manera_uso,descripcion_animal,fecha_registro,fuente_de_datos,idioma_region,uso_combinado,observaciones) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

           connPos cn=new connPos();
           PreparedStatement pst=cn.getConexion().prepareStatement(sql);
          
            pst.setString(1, txtCodigo.getText());
            pst.setInt(2, Integer.parseInt(txtCodReg.getText()));
            pst.setString(3,(String)cmbRegisCI.getSelectedItem());
            pst.setInt(4, Integer.parseInt(AcodDep.getText()));
            pst.setString(5, AmunCod.getText()); 
            pst.setString(6, txtNativo.getText());
            pst.setString(7, txtCientifico.getText());
            pst.setString(8, txtTco.getText());
            pst.setString(9, txtComunidad.getText());
            pst.setString(10, txtInfNombre.getText());
            pst.setString(11, txtInfPaterno.getText());
            pst.setString(12, txtInfMaterno.getText());  
            pst.setString(13, txtCargo.getText());                    
            pst.setString(14, txtEspecie.getText());
            pst.setString(15, txtColorA.getText());
            pst.setString(16, txtCoordXGrados.getText());
            pst.setString(17, txtCoordYGrados.getText());
            pst.setBinaryStream(18,fisA,longitudBytes);
            pst.setBinaryStream(19,fisB,longitudBytes);
            pst.setBinaryStream(20,fisC,longitudBytes);  
            pst.setString(21, txtUso.getText());
            pst.setString(22, txtParteUso.getText());            
            pst.setString(23, AtxtComoUso.getText());
            pst.setString(24,AtxtObsA.getText());
            pst.setString(25,txtFecha.getText());
            pst.setString(26,txtFuente.getText());
            pst.setString(27,(String)cmbIdioma.getSelectedItem());
            pst.setString(28,(String)chkCombinado.getText());
            pst.setString(29,AtxtObs2.getText());
           // pst.setString(10,(String)cmbDesplaza.getSelectedItem());   chkCombinado
            
           
            pst.execute();
            pst.close();
           //cn.insertarDatosRegion(tipo, ecoregion, dpto);
            
            txtCodigo.setText("");
            txtCodReg.setText("");
            cmbRegisCI.setSelectedItem("");
            AcodDep.setText("");
            AmunCod.setText(""); 
            txtNativo.setText("");
            txtCientifico.setText("");
            txtTco.setText("");
            txtComunidad.setText("");
            txtInfNombre.setText("");
            txtInfPaterno.setText("");
            txtInfMaterno.setText("");  
            txtCargo.setText("");                    
            txtEspecie.setText("");
            txtColorA.setText("");
            txtCoordXGrados.setText("");
            txtCoordYGrados.setText("");
            lblFotoAnimal1.setIcon(null);
            lblDibAnimal1.setIcon(null); 
            lblActaAnimal.setIcon(null); 
            txtUso.setText("");
            txtParteUso.setText("");            
            AtxtComoUso.setText("");
            AtxtObsA.setText("");
            txtFecha.setText("");
            txtFuente.setText("");
            cmbIdioma.setSelectedItem("");
            chkCombinado.setText("");
            AtxtObs2.setText("");
            
        
                  
            JOptionPane.showMessageDialog(rootPane,"Guardado correctamente");
        }catch(SQLException x){
            JOptionPane.showMessageDialog(rootPane, "exception 2 "+x);
        }    

      
    }//GEN-LAST:event_btnRegAnimalesActionPerformed

    private void txtCodRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodRegActionPerformed

    private void jComboreganiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboreganiActionPerformed
      
        try{
            Connection cn=getConexion();
            Statement sent1=cn.createStatement();
            ResultSet rs1=sent1.executeQuery("SELECT * FROM REGION WHERE ECOREGION= '"+this.jComboregani.getSelectedItem()+"'");
            rs1.next();
            this.txtCodReg.setText(String.valueOf(rs1.getInt("cod_region")));
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jComboreganiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          
         try {
            Connection cn=getConexion();
           // PreparedStatement pst=cn.prepareStatement("UPDATE ANIMAL SET nombre_nativo='"+txtNativo.getText()+"',nombre_cientifico='"+txtCientifico.getText()+"',tipo_uso='"+txtUso.getText()+"',parte_uso='"+txtParteUso.getText()+"',manera_uso='"+AtxtComoUso.getText()+"',descripcion_animal='"+AtxtObsA.getText()+"',observaciones='"+AtxtObs2.getText()+"' WHERE cod_animal='"+txtCodigo.getText()+"'");
          
            PreparedStatement pst=cn.prepareStatement("UPDATE ANIMAL SET nombre_nativo=?,nombre_cientifico=?,tipo_uso=?,parte_uso=?,manera_uso=?,descripcion_animal=?,observaciones=? WHERE cod_animal='"+txtCodigo.getText()+"'");
           
            pst.setString(1,txtNativo.getText());
            pst.setString(2, txtCientifico.getText());
            pst.setString(3, txtUso.getText());
            pst.setString(4, txtParteUso.getText());
            pst.setString(5, AtxtComoUso.getText());
            pst.setString(6,AtxtObsA.getText());
            pst.setString(7, AtxtObs2.getText());
          
            int N=pst.executeUpdate();
         
            if(N>0){
            JOptionPane.showMessageDialog(null,"adicionado correctamente");
            cargaTodoAnimales();
                    }
            else{
               JOptionPane.showMessageDialog(null,"error no se adiciono");
            }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(connPos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

//        String cod_animal;
//        int cod_region;
//        String nombre_nativo;
//        String nombre_cientifico;
//        String especie;
//        String color;
//        String tipo_uso;
//        String parte_uso;
//        String manera_uso;
//        String desplazamiento;
//        String descripcion_animal;
//        String nro_de_registro_animal;
//        String fecha_registro;
//        String fuente_de_datos;
//        String idioma_region;
//              
//        int fila = this.tablaAnimal.getSelectedRow();
//
//        cod_animal=this.tablaAnimal.getValueAt(fila, 0).toString();
//        cod_region=Integer.parseInt(this.tablaAnimal.getValueAt(fila, 1).toString());
//        nombre_nativo=this.tablaAnimal.getValueAt(fila, 2).toString();
//        nombre_cientifico=this.tablaAnimal.getValueAt(fila, 3).toString();
//        especie=this.tablaAnimal.getValueAt(fila, 4).toString();
//        color=this.tablaAnimal.getValueAt(fila, 5).toString();
//        tipo_uso=this.tablaAnimal.getValueAt(fila, 6).toString();
//        parte_uso=this.tablaAnimal.getValueAt(fila, 7).toString();
//        manera_uso=this.tablaAnimal.getValueAt(fila, 8).toString();
//        desplazamiento=this.tablaAnimal.getValueAt(fila, 9).toString();
//        descripcion_animal=this.tablaAnimal.getValueAt(fila, 10).toString();
//        nro_de_registro_animal=this.tablaAnimal.getValueAt(fila, 11).toString();
//        fecha_registro=this.tablaAnimal.getValueAt(fila, 12).toString();
//        fuente_de_datos=this.tablaAnimal.getValueAt(fila, 13).toString();
//        idioma_region=this.tablaAnimal.getValueAt(fila, 14).toString();
//       
//        
//        
//        editaAnimal er= new editaAnimal(cod_animal,cod_region, nombre_nativo, nombre_cientifico,
//                               especie, color, tipo_uso, parte_uso, manera_uso,
//                               desplazamiento,descripcion_animal,nro_de_registro_animal,
//                              fecha_registro,fuente_de_datos,idioma_region);
//        er.setVisible(true);
//        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBorrarAniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarAniActionPerformed
        
        
        
//        int fila;
//        fila=(Integer)this.tablaAnimal.getSelectedRow();
//        String codigo=this.tablaAnimal.getValueAt(fila, 0).toString();
//        connPos cn= new connPos();
//        cn.borrarAnimal(codigo);
//        
//        DefaultTableModel dfmDelete = new DefaultTableModel();
//        this.tablaAnimal.setModel(dfmDelete);
//        dfmDelete.setColumnIdentifiers(new Object[]{"cod_animal","cod_region","nombre_nativo","nombre_cientifico","especie",
//                                                    "color","tipo_uso","parte_uso","manera_uso","desplazamiento",
//                                                    "descripcion_animal","nro_de_registro_animal",
//                                                    "fecha_registro","fuente_de_datos","idioma_region"});
//        ResultSet rs=cn.seleccionarTodoAnimales();
//        
//        try{
//            while(rs.next()){
//            dfmDelete.addRow(new Object[]{rs.getString("cod_animal"),rs.getInt("cod_region"),rs.getString("nombre_nativo"),
//                                          rs.getString("nombre_cientifico"),rs.getString("especie"),
//                                          rs.getString("color"),rs.getString("tipo_uso"),rs.getString("parte_uso"),
//                                          rs.getString("manera_uso"),rs.getString("desplazamiento"),rs.getString("desplazamiento"), 
//                                          rs.getString("descripcion_animal"),rs.getString("nro_de_registro_animal"),
//                                          rs.getString("fecha_registro"),rs.getString("fuente_de_datos"),rs.getString("idioma_region")});    
//            }
//        }
//        catch(Exception e){
//        
//        }
        
    }//GEN-LAST:event_btnBorrarAniActionPerformed

    private void AtxtObsAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AtxtObsAKeyTyped
        
        int cuenta=AtxtObsA.getText().length();
        String k=AtxtObsA.getText();
        lblcontarParteUso2.setText(String.valueOf(cuenta));
        if(cuenta > 1999){
         String nueva= k.substring(0, k.length()-1 );
         AtxtObsA.setText(nueva);
         lblerrorParteUso2.setVisible(true);      
        }
        AtxtObsA.setLineWrap(true);
        AtxtObsA.setWrapStyleWord(true);
        AtxtObsA.setBackground(Color.black);
        AtxtObsA.setForeground(Color.green);
    }//GEN-LAST:event_AtxtObsAKeyTyped

    private void AtxtComoUsoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AtxtComoUsoKeyTyped
        int cuenta=AtxtComoUso.getText().length();
        String k=AtxtComoUso.getText();
        lblcontarParteUso1.setText(String.valueOf(cuenta));
        if(cuenta > 999){
         String nueva= k.substring(0, k.length()-1 );
         AtxtComoUso.setText(nueva);
         lblerrorParteUso1.setVisible(true);      
        }
        AtxtComoUso.setLineWrap(true);
        AtxtComoUso.setWrapStyleWord(true);
        
    }//GEN-LAST:event_AtxtComoUsoKeyTyped

    private void txtCoordXGradosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCoordXGradosKeyTyped
        char val=evt.getKeyChar();
        if(Character.isLetter(val) || Character.isSpaceChar(val)){
            getToolkit().beep();               
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo se acepta el formato de coordenadas decimales");
        }
        
    }//GEN-LAST:event_txtCoordXGradosKeyTyped

    private void txtCoordYGradosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCoordYGradosKeyTyped
        char val=evt.getKeyChar();
        if(Character.isLetter(val) || Character.isSpaceChar(val)){
            getToolkit().beep();               
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo se acepta el formato de coordenadas decimales");
        }
        
    }//GEN-LAST:event_txtCoordYGradosKeyTyped

    private void cmbMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMunicipioActionPerformed
        try{
            Connection cn=getConexion();
            Statement sent1=cn.createStatement();
            ResultSet rs1=sent1.executeQuery("SELECT * FROM MUNICIPIOS WHERE nom_mncp= '"+this.cmbMunicipio.getSelectedItem()+"'");
            rs1.next();
           this.AmunCod.setText(String.valueOf(rs1.getInt("cod_mncp")));
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_cmbMunicipioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         lblFotoAnimal1.setIcon(null);
       JFileChooser j=new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado=j.showOpenDialog(null);
        if(estado== JFileChooser.APPROVE_OPTION){
            try{
                fisA=new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes=(int)j.getSelectedFile().length();
                try {
                    Image icono=ImageIO.read(j.getSelectedFile()).getScaledInstance
                            (lblFotoAnimal1.getWidth(),lblFotoAnimal1.getHeight(),Image.SCALE_DEFAULT);
                    lblFotoAnimal1.setIcon(new ImageIcon(icono));
                    lblFotoAnimal1.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: "+ex);
                }
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        lblDibAnimal1.setIcon(null);
       JFileChooser j=new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado=j.showOpenDialog(null);
        if(estado== JFileChooser.APPROVE_OPTION){
            try{
                fisB=new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes=(int)j.getSelectedFile().length();
                try {
                    Image icono=ImageIO.read(j.getSelectedFile()).getScaledInstance
                            (lblDibAnimal1.getWidth(),lblDibAnimal1.getHeight(),Image.SCALE_DEFAULT);
                    lblDibAnimal1.setIcon(new ImageIcon(icono));
                    lblDibAnimal1.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: "+ex);
                }
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnActaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActaActionPerformed
       lblActaAnimal.setIcon(null);
       JFileChooser j=new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado=j.showOpenDialog(null);
        if(estado== JFileChooser.APPROVE_OPTION){
            try{
                fisC=new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes=(int)j.getSelectedFile().length();
                try {
                    Image icono=ImageIO.read(j.getSelectedFile()).getScaledInstance
                            (lblActaAnimal.getWidth(),lblActaAnimal.getHeight(),Image.SCALE_DEFAULT);
                    lblActaAnimal.setIcon(new ImageIcon(icono));
                    lblActaAnimal.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: "+ex);
                }
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
        } 
    }//GEN-LAST:event_btnActaActionPerformed

    
    public void validarCheck(){
        //String c = "";
      if(chkCombinado.isSelected()){
          
          chkCombinado.setText("si");
          }
      
      else if(chkCombinado.isSelected()==false){
          chkCombinado.setText("no");
         }
       // return c ;
    }
    private void chkCombinadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCombinadoActionPerformed
       validarCheck();
    }//GEN-LAST:event_chkCombinadoActionPerformed

    private void cmbDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDeptoActionPerformed
        try{
            Connection cn=getConexion();
            Statement sent1=cn.createStatement();
            ResultSet rs1=sent1.executeQuery("SELECT * FROM DEPARTAMENTO WHERE nom_dpto= '"+this.cmbDepto.getSelectedItem()+"'");
            rs1.next();
            this.AcodDep.setText(String.valueOf(rs1.getInt("cod_dpto")));
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
        }           
        
    }//GEN-LAST:event_cmbDeptoActionPerformed

    private void cmbRegisCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRegisCIActionPerformed
         try{
            Connection cn=getConexion();
            Statement sent1=cn.createStatement();
            ResultSet rs1=sent1.executeQuery("SELECT * FROM REGISTRANTE WHERE cod_registrante= '"+this.cmbRegisCI.getSelectedItem()+"'");
            rs1.next();
            this.txtRegNombre.setText(String.valueOf(rs1.getString("nom_registrante")));
            this.txtRegPaterno.setText(String.valueOf(rs1.getString("ap_registrante")));
            this.txtRegMaterno.setText(String.valueOf(rs1.getString("am_registrante")));
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
        }  
    }//GEN-LAST:event_cmbRegisCIActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        int fila = tablaAnimal.getSelectedRow();
  
    if(fila>=0)
    {
     
       //  nombre_nativo,nombre_cientifico,tipo_uso,parte_uso,manera_uso,descripcion_animal
        txtCodigo.setText(tablaAnimal.getValueAt(fila, 0).toString());
        txtNativo.setText(tablaAnimal.getValueAt(fila, 1).toString());
        txtCientifico.setText(tablaAnimal.getValueAt(fila, 2).toString());
        txtUso.setText(tablaAnimal.getValueAt(fila, 3).toString());
        txtParteUso.setText(tablaAnimal.getValueAt(fila, 4).toString());
        AtxtComoUso.setText(tablaAnimal.getValueAt(fila, 5).toString());
        AtxtObsA.setText(tablaAnimal.getValueAt(fila, 6).toString());
        AtxtObs2.setText(tablaAnimal.getValueAt(fila, 7).toString());
       
        
        cmbDepto.setEnabled(false);
        cmbMunicipio.setEnabled(false);
        txtComunidad.setEnabled(false);
        txtTco.setEnabled(false);
        txtCoordXGrados.setEnabled(false);
        txtCoordYGrados.setEnabled(false);
        cmbTipoRegion.setEnabled(false);
        jComboregani.setEnabled(false);
        txtCodigo.setEnabled(false);
        cmbIdioma.setEnabled(false);
        txtFuente.setEnabled(false);
        cmbRegisCI.setEnabled(false);
        txtInfPaterno.setEnabled(false);
        txtInfMaterno.setEnabled(false);
        txtInfNombre.setEnabled(false);
        txtCargo.setEnabled(false);
        btnActa.setEnabled(false);
        txtEspecie.setEnabled(false);
        txtColorA.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        chkCombinado.setEnabled(false);
                
        
        
//        String des=tbpro.getValueAt(fila, 1).toString();
//        String pre=tbpro.getValueAt(fila, 2).toString();
//        String img=tbpro.getValueAt(fila, 3).toString();
//        txtcod.setText(cod);
//        txtdes.setText(des);
//        txtpre.setText(pre);      
//        txtnomimagen.setText(img);
//        Image foto = getToolkit().getImage(img);
//        foto= foto.getScaledInstance(110, 110, 1);
//        lblfoto.setIcon(new ImageIcon(foto));
     
    }
    else
    {
       JOptionPane.showMessageDialog(null, "Elija una fila...llene la Tabla");
    }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
      int fila=tablaAnimal.getSelectedRow();
    if(fila>-1)
    {
        String cod=tablaAnimal.getValueAt(fila, 0).toString();
        String sqlElim="DELETE FROM animal WHERE cod_animal='"+cod+"'";
            try {
                Connection cn=getConexion();
                PreparedStatement pst = cn.prepareStatement(sqlElim);
                int n=pst.executeUpdate();
                if(n>0)
                {
                     JOptionPane.showMessageDialog(null, "Los datos fueron eliminados con exito");
                     cargaTodoAnimales();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Hubo Problemas al querer eliminar datos");
                }
            } catch (SQLException ex) {
               
            }
        
    }
    else
    {
    
    }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AcodDep;
    private javax.swing.JTextField AmunCod;
    private javax.swing.JTextArea AtxtComoUso;
    private javax.swing.JTextArea AtxtObs2;
    private javax.swing.JTextArea AtxtObsA;
    private javax.swing.JButton btnActa;
    private javax.swing.JButton btnBorrarAni;
    private javax.swing.JButton btnRegAnimales;
    private javax.swing.JCheckBox chkCombinado;
    private javax.swing.JComboBox cmbDepto;
    private javax.swing.JComboBox cmbIdioma;
    private javax.swing.JComboBox cmbMunicipio;
    private javax.swing.JComboBox cmbRegisCI;
    private javax.swing.JComboBox cmbTipoRegion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboregani;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblActaAnimal;
    private javax.swing.JLabel lblDibAnimal1;
    private javax.swing.JLabel lblFotoAnimal1;
    private javax.swing.JLabel lblcontarParteUso;
    private javax.swing.JLabel lblcontarParteUso1;
    private javax.swing.JLabel lblcontarParteUso2;
    private javax.swing.JLabel lblerrorParteUso;
    private javax.swing.JLabel lblerrorParteUso1;
    private javax.swing.JLabel lblerrorParteUso2;
    private javax.swing.JTable tablaAnimal;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCientifico;
    private javax.swing.JTextField txtCodReg;
    public javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtColorA;
    private javax.swing.JTextField txtComunidad;
    private javax.swing.JTextField txtCoordXGrados;
    private javax.swing.JTextField txtCoordYGrados;
    private javax.swing.JTextField txtEspecie;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFuente;
    private javax.swing.JTextField txtInfMaterno;
    private javax.swing.JTextField txtInfNombre;
    private javax.swing.JTextField txtInfPaterno;
    private javax.swing.JTextField txtNativo;
    private javax.swing.JTextArea txtParteUso;
    private javax.swing.JTextField txtRegMaterno;
    private javax.swing.JTextField txtRegNombre;
    private javax.swing.JTextField txtRegPaterno;
    private javax.swing.JTextField txtTco;
    private javax.swing.JTextField txtUso;
    // End of variables declaration//GEN-END:variables
}
