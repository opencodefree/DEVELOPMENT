
package vista;

import conexion.connPos;
import static conexion.connPos.getConexion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import static vista.Animales.res;


public class Plantas extends javax.swing.JInternalFrame {
  
    public FileInputStream fisfoto;
    FileInputStream fisI;
    
        public FileInputStream fisA;
           public FileInputStream fisB;
              public FileInputStream fisC;
                 public FileInputStream fisD;
         int longitudBytes;         
                  
    public Plantas() {
        initComponents();
        cargaTodoPlanta();
          //CAPTURANDO FECHAS ACTUALES
        Date d=new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
        txtFecha.setText(String.valueOf(formato.format(d)));
        //MOSTRANDO ERRORES EN LA VALIDACION
        lblerrorParteUso.setVisible(false);
        lblerrorManeraUso.setVisible(false);
        lblerrorParteUso2.setVisible(false);
        
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getSize();
        int horizontal=(pantalla.width-ventana.width)/2;
        int vertical=(pantalla.height-ventana.height)/2;
        this.setLocation(horizontal,vertical);
        
    
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
        //MOSTRANDO DATOS EN EL COMBOBOX  DESDE LA BD A PLANTAS
         this.jComboRegPlan.removeAllItems();
         try{
             Connection cn=getConexion();
             Statement sent=cn.createStatement();
             ResultSet rs=sent.executeQuery("SELECT * FROM REGION");
             while(rs.next()){
                  this.jComboRegPlan.addItem(rs.getString("ecoregion"));
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
         this.cmbRegPla.removeAllItems();
         try{
             Connection cn=getConexion();
             Statement sent=cn.createStatement();
             ResultSet rs=sent.executeQuery("SELECT * FROM registrante");
             while(rs.next()){
                  this.cmbRegPla.addItem(rs.getString("cod_registrante"));
             }
             
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
    }
    
     public void cargaTodoPlanta(){
       DefaultTableModel modelo=(DefaultTableModel)tablaPlanta.getModel();
       modelo.setRowCount(0);
//      res = conexion.connPos.Consulta("SELECT cod_planta,cod_region,nombre_nativo,"
//                            + "nombre_cientifico,tipo_planta,color_planta,mes_semilla,"
//                            + "nro_de_registro_planta,fecha_registro,fuente_de_datos,"
//                            + "idioma_region,tipo_uso,parte_uso,manera_uso,descripcion_pla FROM PLANTA");
      
       res = conexion.connPos.Consulta("SELECT cod_planta FROM PLANTA");
       try{
         while(res.next()){
             Vector v = new Vector();
             v.add(res.getString(1));
//             v.add(res.getInt(2));
//             v.add(res.getString(3));
//             v.add(res.getString(4));
//             v.add(res.getString(5));
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
             modelo.addRow(v);
             tablaPlanta.setModel(modelo);
             }
       }
       catch(SQLException e){
       
       }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        pnlDatosRegPlanta = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboRegPlan = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtCodRegion = new javax.swing.JTextField();
        cmbDepto = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbMunicipio = new javax.swing.JComboBox();
        txtComunidad = new javax.swing.JTextField();
        txtTco = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCoordY = new javax.swing.JTextField();
        txtCoordX = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        cmbTipoRegion = new javax.swing.JComboBox();
        jLabel51 = new javax.swing.JLabel();
        txtCodDepPla = new javax.swing.JTextField();
        txtCodMunPla = new javax.swing.JTextField();
        pnlDatosPlanta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcionPlanta = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombreNativo = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        cmbIdioma = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        txtNombreCientifico = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtFuente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lblcontarParteUso2 = new javax.swing.JLabel();
        lblerrorParteUso2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtRegPla = new javax.swing.JTextPane();
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
        jScrollPane7 = new javax.swing.JScrollPane();
        AtxtObs = new javax.swing.JTextArea();
        cmbRegPla = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        lblFotoActaPla = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cmbTipoPlanta = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        cmbMesProduccion = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblFotoPlanta = new javax.swing.JLabel();
        lblDibuPlanta = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblSemillaPlanta = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtUso = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtParteUso = new javax.swing.JTextArea();
        lblerrorParteUso = new javax.swing.JLabel();
        lblcontarParteUso = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblerrorManeraUso = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtComoUso = new javax.swing.JTextArea();
        lblcontarParteUso1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        chkCombinado = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnRegPlantas = new javax.swing.JButton();
        btnActPlan = new javax.swing.JButton();
        btnBorrarPlanta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaPlanta = new javax.swing.JTable();

        setTitle("REGISTRAR PLANTAS");
        setAutoscrolls(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(900, 700));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("FORMULARIO DE REGISTRO DE PLANTAS");

        jLabel2.setText("Fecha Registro:");

        pnlDatosRegPlanta.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DE LA REGION"));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Ecoregion :");

        jComboRegPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboRegPlanActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Codigo Region :");

        txtCodRegion.setEditable(false);

        cmbDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDeptoActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Departamento");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Municipio");

        cmbMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMunicipioActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("TCO");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Comunidad");

        txtCoordY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCoordYKeyTyped(evt);
            }
        });

        txtCoordX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCoordXKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Coord X");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Coord Y");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Tipo Region:");

        javax.swing.GroupLayout pnlDatosRegPlantaLayout = new javax.swing.GroupLayout(pnlDatosRegPlanta);
        pnlDatosRegPlanta.setLayout(pnlDatosRegPlantaLayout);
        pnlDatosRegPlantaLayout.setHorizontalGroup(
            pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(txtCodDepPla))
                .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbMunicipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtComunidad)
                            .addComponent(txtTco, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cmbDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodMunPla, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jComboRegPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel47))
                                .addGap(20, 20, 20)
                                .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtCoordY, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCoordX, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                        .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel5))
                            .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel51)
                                .addGap(18, 18, 18)
                                .addComponent(cmbTipoRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(34, 34, 34))
        );
        pnlDatosRegPlantaLayout.setVerticalGroup(
            pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                        .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCodRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCoordX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCoordY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipoRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51)))
                    .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                        .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cmbDepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(txtComunidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtTco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cmbMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboRegPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(pnlDatosRegPlantaLayout.createSequentialGroup()
                        .addGroup(pnlDatosRegPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodDepPla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodMunPla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pnlDatosPlanta.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DE LA PLANTA"));

        txtDescripcionPlanta.setColumns(20);
        txtDescripcionPlanta.setRows(5);
        txtDescripcionPlanta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionPlantaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcionPlanta);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Descripcion");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Codigo:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Nombre Nativo:");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        txtNombreNativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreNativoActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Idioma:");

        cmbIdioma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Elegir Idioma>", "Aymara", "Araona", "Baure", "Bésiro", "Canichana", "Cavineño", "Cayubaba", "Chácobo", "Ese ejja", "Guaraní", "Guarasu’we", "Guarayu", "Itonama", "Leco", "Machajuyai-kallawaya", "Machineri", "Maropa", "Mojeño-trinitario", "Mojeño-ignaciano", "Moré", "Tsimane", "Mosetén", "Movima", "Pacawara", "Puquina", "Quechua ", "Sirionó", "Tacana ", "Tapiete ", "Toromona", "Uru-chipaya", "Weenhayek", "Yaminawa", "Yuki", "Yuracaré ", "Zamuco" }));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Nombre Cientifico:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Fuente Información :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel13.setText("(No debe sobrepasar 200 caracteres)");

        lblerrorParteUso2.setForeground(new java.awt.Color(255, 0, 0));
        lblerrorParteUso2.setText("Se ha llegado al limite de caracteres");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Numero de Registro Planta : ");

        jScrollPane4.setViewportView(txtRegPla);

        javax.swing.GroupLayout pnlDatosPlantaLayout = new javax.swing.GroupLayout(pnlDatosPlanta);
        pnlDatosPlanta.setLayout(pnlDatosPlantaLayout);
        pnlDatosPlantaLayout.setHorizontalGroup(
            pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosPlantaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosPlantaLayout.createSequentialGroup()
                        .addComponent(lblerrorParteUso2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(346, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosPlantaLayout.createSequentialGroup()
                        .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosPlantaLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblcontarParteUso2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDatosPlantaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pnlDatosPlantaLayout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombreCientifico))
                                    .addGroup(pnlDatosPlantaLayout.createSequentialGroup()
                                        .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel28))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                        .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombreNativo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlDatosPlantaLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosPlantaLayout.createSequentialGroup()
                                                .addComponent(jLabel29)
                                                .addGap(18, 18, 18)
                                                .addComponent(cmbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosPlantaLayout.createSequentialGroup()
                                                .addComponent(jLabel31)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(pnlDatosPlantaLayout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(14, 14, 14))))
        );
        pnlDatosPlantaLayout.setVerticalGroup(
            pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosPlantaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosPlantaLayout.createSequentialGroup()
                        .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlDatosPlantaLayout.createSequentialGroup()
                                .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(txtNombreNativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(txtNombreCientifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16))
                            .addGroup(pnlDatosPlantaLayout.createSequentialGroup()
                                .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29))
                                .addGap(4, 4, 4)
                                .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)))
                        .addGroup(pnlDatosPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13)))
                    .addComponent(lblcontarParteUso2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerrorParteUso2)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDatosPlanta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDatosRegPlanta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(pnlDatosRegPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDatosPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(381, 381, 381))
        );

        jTabbedPane1.addTab("DATOS GENERALES", jPanel4);

        jLabel32.setText("Datos del Registrante:");

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

        AtxtObs.setColumns(20);
        AtxtObs.setRows(5);
        jScrollPane7.setViewportView(AtxtObs);

        cmbRegPla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRegPlaActionPerformed(evt);
            }
        });

        jLabel3.setText("C.I. Registrante :");

        lblFotoActaPla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel42)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel36)
                            .addComponent(jLabel40)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRegPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRegMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRegNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnActa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCargo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtInfPaterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtInfMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel38))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtInfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel39)))
                                    .addComponent(lblFotoActaPla, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cmbRegPla, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane7))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRegPla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
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
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel41)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(lblFotoActaPla, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel40)
                                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnActa)
                                .addGap(26, 26, 26)))))
                .addComponent(jLabel42)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("DATOS DE LA FUENTE", jPanel8);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DESCRIPCION DE LA PLANTA"));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Tipo Planta:");

        cmbTipoPlanta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Arbol", "Arbusto", "Hierba", "Cactáceas", "Tubérculos", "Raíces", "Otro" }));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Color:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Mes de produccion de la semilla:");

        cmbMesProduccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre" }));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Añadir Imagen de la Planta :");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Añadir Dibujo de la Planta :");

        lblFotoPlanta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblDibuPlanta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Añadir Foto de Semilla:");

        lblSemillaPlanta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Examinar...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(cmbMesProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(lblFotoPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel21))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addComponent(lblDibuPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSemillaPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel22)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(254, 254, 254)
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbTipoPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(60, 60, 60)
                .addComponent(jButton3)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbTipoPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cmbMesProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSemillaPlanta, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(lblFotoPlanta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDibuPlanta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MORFOLOGIA", jPanel5);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("USO DE LA PLANTA"));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Tipo de Uso:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Se utiliza esta parte de la planta:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Se utiliza de esta manera:");

        txtParteUso.setColumns(20);
        txtParteUso.setRows(5);
        txtParteUso.setWrapStyleWord(true);
        txtParteUso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtParteUsoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtParteUso);

        lblerrorParteUso.setForeground(new java.awt.Color(255, 0, 0));
        lblerrorParteUso.setText("Se ha llegado al limite de caracteres");

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel11.setText("(No debe sobrepasar 1000 caracteres)");

        lblerrorManeraUso.setForeground(new java.awt.Color(255, 0, 0));
        lblerrorManeraUso.setText("Se ha llegado al limite de caracteres");

        txtComoUso.setColumns(20);
        txtComoUso.setRows(5);
        txtComoUso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtComoUsoKeyTyped(evt);
            }
        });
        jScrollPane6.setViewportView(txtComoUso);

        jLabel12.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel12.setText("(No debe sobrepasar 1000 caracteres)");

        chkCombinado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCombinadoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Combinado :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblerrorParteUso, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblerrorManeraUso, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lblcontarParteUso1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addComponent(lblcontarParteUso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUso, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(chkCombinado)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(76, 76, 76))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtUso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkCombinado)
                    .addComponent(jLabel14))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(9, 9, 9)
                        .addComponent(lblcontarParteUso, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblerrorParteUso))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(lblcontarParteUso1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblerrorManeraUso))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("USO", jPanel6);

        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFecha.setText("jTextField1");
        txtFecha.setEnabled(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        btnRegPlantas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegPlantas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/registrar.png"))); // NOI18N
        btnRegPlantas.setText("      REGISTRAR");
        btnRegPlantas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegPlantasActionPerformed(evt);
            }
        });

        btnActPlan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnActPlan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnActPlan.setText("EDITAR REGISTRO");
        btnActPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActPlanActionPerformed(evt);
            }
        });

        btnBorrarPlanta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBorrarPlanta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnBorrarPlanta.setText("BORRAR REGISTRO");
        btnBorrarPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPlantaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setText("TABLA DE REGISTROS");

        jScrollPane3.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaPlanta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "codigo de planta", "codigo de region", "nombre nativo", "nombre cientifico", "tipo de planta ", "color planta", "mes produccion semilla", "numero de registro", "fecha de registro", "fuente de datos", "idioma", "tipo de uso", "parte de uso", "manera de uso", "descripcion"
            }
        ));
        jScrollPane5.setViewportView(tablaPlanta);

        jScrollPane3.setViewportView(jScrollPane5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(33, 33, 33)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegPlantas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActPlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBorrarPlanta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnRegPlantas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnActPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnBorrarPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed


    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtNombreNativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreNativoActionPerformed

    }//GEN-LAST:event_txtNombreNativoActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
   
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped

    }//GEN-LAST:event_txtCodigoKeyTyped

    private void btnRegPlantasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegPlantasActionPerformed
           try{
            String sql="INSERT INTO \"planta\"(cod_planta,cod_region,cod_registrante,cod_dpto,cod_mncp,nombre_nativo,"
                    + "nombre_cientifico,nombre_tco,nombre_comunidad,nom_repnat,ap_repnat,am_repnat,cargo_repnat,tipo_planta,color_planta,coorx,"
                    + "coory,foto_semilla,foto_planta,dibujo,acta_pla,"
                    + "mes_semilla,fecha_registro,fuente_de_datos,idioma_region,tipo_uso,parte_uso,manera_uso,descripcion_pla,uso_combinado,observaciones) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

           connPos cn=new connPos();
           PreparedStatement pst=cn.getConexion().prepareStatement(sql);
          
            
            pst.setString(1, txtCodigo.getText());
            pst.setInt(2, Integer.parseInt(txtCodRegion.getText()));
            pst.setString(3,(String)cmbRegPla.getSelectedItem());
            pst.setInt(4, Integer.parseInt(txtCodDepPla.getText()));
            pst.setString(5, txtCodMunPla.getText());  
            pst.setString(6, txtNombreNativo.getText());
            pst.setString(7, txtNombreCientifico.getText());
            pst.setString(8, txtTco.getText());  
            pst.setString(9, txtComunidad.getText()); 
            pst.setString(10,txtInfNombre.getText()); 
            pst.setString(11, txtInfPaterno.getText()); 
            pst.setString(12, txtInfMaterno.getText()); 
            pst.setString(13, txtCargo.getText()); 
            pst.setString(14,(String)cmbTipoPlanta.getSelectedItem());
            pst.setString(15, txtColor.getText());  
            pst.setString(16, txtCoordX.getText());
            pst.setString(17, txtCoordY.getText());
            pst.setBinaryStream(18,fisA,longitudBytes);
            pst.setBinaryStream(19,fisB,longitudBytes);
            pst.setBinaryStream(20,fisC,longitudBytes);  
            pst.setBinaryStream(21,fisD,longitudBytes); 
            pst.setString(22, (String)cmbMesProduccion.getSelectedItem());
            pst.setString(23,txtFecha.getText());
            pst.setString(24,txtFuente.getText());  
            pst.setString(25,(String)cmbIdioma.getSelectedItem()); 
            pst.setString(26,txtUso.getText());
            pst.setString(27, txtParteUso.getText());
            pst.setString(28, txtComoUso.getText());
            pst.setString(29, txtDescripcionPlanta.getText());
            pst.setString(30,(String)chkCombinado.getText());
            pst.setString(31,AtxtObs.getText());
            
     
            pst.execute();
            pst.close();
           
            txtCodigo.setText("");
            txtCodRegion.setText("");
            cmbRegPla.setSelectedItem("");
            txtCodDepPla.setText("");
            txtCodMunPla.setText("");  
            txtNombreNativo.setText("");
            txtNombreCientifico.setText("");
            txtTco.setText("");  
            txtComunidad.setText("");  
            txtInfNombre.setText(""); 
            txtInfPaterno.setText(""); 
            txtInfMaterno.setText(""); 
            txtCargo.setText(""); 
            cmbTipoPlanta.setSelectedItem("");
            txtColor.setText("");  
            txtCoordX.setText("");
            txtCoordY.setText("");
            lblSemillaPlanta.setIcon(null);
            lblFotoPlanta.setIcon(null); 
            lblDibuPlanta.setIcon(null);  
            lblFotoActaPla.setIcon(null);  
            cmbMesProduccion.setSelectedItem("");
            txtFecha.setText("");
            txtFuente.setText("");  
            cmbIdioma.setSelectedItem(""); 
            txtUso.setText("");
            txtParteUso.setText("");
            txtComoUso.setText("");
            txtDescripcionPlanta.setText("");
            chkCombinado.setText("");
            AtxtObs.setText("");
   
            JOptionPane.showMessageDialog(rootPane,"Guardado correctamente");
        }catch(SQLException x){
            JOptionPane.showMessageDialog(rootPane, "exception 2 "+x);
        }  
          
    }//GEN-LAST:event_btnRegPlantasActionPerformed

    private void jComboRegPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboRegPlanActionPerformed
         try{
            Connection cn=getConexion();
            Statement sent1=cn.createStatement();
            ResultSet rs1=sent1.executeQuery("SELECT * FROM REGION WHERE ECOREGION= '"+this.jComboRegPlan.getSelectedItem()+"'");
            rs1.next();
            this.txtCodRegion.setText(String.valueOf(rs1.getInt("cod_region")));
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jComboRegPlanActionPerformed

    private void btnActPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActPlanActionPerformed
       
        
        String cod_planta;
        int cod_region;
        String nombre_nativo;
        String nombre_cientifico;
        String tipo_planta;
        String color_planta;
        String mes_semilla;
        String nro_de_registro_planta;
        String fecha_registro;
        String fuente_de_datos;
        String idioma_region;
        String tipo_uso;
        String parte_uso;
        String manera_uso;
        String descripcion_pla; 
        
        int fila = this.tablaPlanta.getSelectedRow();
        
        cod_planta=this.tablaPlanta.getValueAt(fila, 0).toString();
        cod_region=Integer.parseInt(this.tablaPlanta.getValueAt(fila, 1).toString());
        nombre_nativo=this.tablaPlanta.getValueAt(fila, 2).toString();
        nombre_cientifico=this.tablaPlanta.getValueAt(fila, 3).toString();
        tipo_planta=this.tablaPlanta.getValueAt(fila, 4).toString();
        color_planta=this.tablaPlanta.getValueAt(fila, 5).toString();
        mes_semilla=this.tablaPlanta.getValueAt(fila, 6).toString();
        nro_de_registro_planta=this.tablaPlanta.getValueAt(fila, 7).toString();
        fecha_registro=this.tablaPlanta.getValueAt(fila, 8).toString();
        fuente_de_datos=this.tablaPlanta.getValueAt(fila, 9).toString();
        idioma_region=this.tablaPlanta.getValueAt(fila, 10).toString();
        tipo_uso=this.tablaPlanta.getValueAt(fila, 11).toString();
        parte_uso=this.tablaPlanta.getValueAt(fila, 12).toString();
        manera_uso=this.tablaPlanta.getValueAt(fila, 13).toString();
        descripcion_pla=this.tablaPlanta.getValueAt(fila, 14).toString();
        
        editaPlanta ep= new editaPlanta(cod_planta,cod_region,nombre_nativo,nombre_cientifico,tipo_planta,color_planta,mes_semilla,
                            nro_de_registro_planta,fecha_registro,fuente_de_datos,idioma_region,tipo_uso,parte_uso,
                            manera_uso,descripcion_pla);
        
        ep.setVisible(true);
        this.dispose();
       
        
    }//GEN-LAST:event_btnActPlanActionPerformed

    private void btnBorrarPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPlantaActionPerformed
        
        int fila;
        fila=(Integer)this.tablaPlanta.getSelectedRow();
        //int codigo=Integer.parseInt(this.tablaRegion.getValueAt(fila, 0).toString());
        String codigo=this.tablaPlanta.getValueAt(fila, 0).toString();
        connPos cn= new connPos();
        cn.borrarPlanta(codigo);
        
        DefaultTableModel dfmDelete = new DefaultTableModel();
        this.tablaPlanta.setModel(dfmDelete);
        dfmDelete.setColumnIdentifiers(new Object[]{ "cod_planta", "cod_region", "nombre_nativo", "nombre_cientifico",
                              "tipo_planta", "color_planta", "mes_semilla", "nro_de_registro_planta",
                              "fecha_registro", "fuente_de_datos", "idioma_region", "tipo_uso", "parte_uso",
                              "manera_uso", "descripcion_pla"});
        ResultSet rs=cn.seleccionarTodoPlantas();
        
        try{
            while(rs.next()){
            dfmDelete.addRow(new Object[]{rs.getString("cod_planta"),rs.getInt("cod_region"),rs.getString("nombre_nativo"),
                                          rs.getString("nombre_cientifico"),rs.getString("tipo_planta"),
                                          rs.getString("color_planta"),rs.getString("mes_semilla"),rs.getString("nro_de_registro_planta"),
                                          rs.getString("fecha_registro"),rs.getString("fuente_de_datos"),rs.getString("idioma_region"), 
                                          rs.getString("tipo_uso"),rs.getString("parte_uso"),
                                          rs.getString("manera_uso"),rs.getString("descripcion_pla")});    
            }
        }
        catch(Exception e){
        
        }
        
    }//GEN-LAST:event_btnBorrarPlantaActionPerformed

    private void txtDescripcionPlantaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionPlantaKeyPressed
        int cuenta=txtDescripcionPlanta.getText().length();
        String k=txtDescripcionPlanta.getText();
        lblcontarParteUso2.setText(String.valueOf(cuenta));
        if(cuenta > 1499){
         String nueva= k.substring(0, k.length()-1 );
         txtDescripcionPlanta.setText(nueva);
         lblerrorParteUso.setVisible(true);      
        }
        txtDescripcionPlanta.setLineWrap(true);
        txtDescripcionPlanta.setWrapStyleWord(true);
        txtDescripcionPlanta.setBackground(Color.black);
        txtDescripcionPlanta.setForeground(Color.green);
    }//GEN-LAST:event_txtDescripcionPlantaKeyPressed

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

    private void txtComoUsoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComoUsoKeyTyped
        int cuenta=txtComoUso.getText().length();
        String k=txtComoUso.getText();
        lblcontarParteUso1.setText(String.valueOf(cuenta));
        if(cuenta > 999){
         String nueva= k.substring(0, k.length()-1 );
         txtComoUso.setText(nueva);
         lblerrorManeraUso.setVisible(true);      
        }
        txtComoUso.setLineWrap(true);
        txtComoUso.setWrapStyleWord(true);
    }//GEN-LAST:event_txtComoUsoKeyTyped

    private void txtCoordXKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCoordXKeyTyped
        char val=evt.getKeyChar();
        if(Character.isLetter(val) || Character.isSpaceChar(val)){
            getToolkit().beep();               
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo se acepta el formato de coordenadas decimales");
        }     
              
    }//GEN-LAST:event_txtCoordXKeyTyped

    private void txtCoordYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCoordYKeyTyped
        char val=evt.getKeyChar();
        if(Character.isLetter(val) || Character.isSpaceChar(val)){
            getToolkit().beep();               
            evt.consume();
            JOptionPane.showMessageDialog(null,"Solo se acepta el formato de coordenadas decimales");
        }
    }//GEN-LAST:event_txtCoordYKeyTyped

    private void cmbDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDeptoActionPerformed
            try{
            Connection cn=getConexion();
            Statement sent1=cn.createStatement();
            ResultSet rs1=sent1.executeQuery("SELECT * FROM DEPARTAMENTO WHERE nom_dpto= '"+this.cmbDepto.getSelectedItem()+"'");
            rs1.next();
            this.txtCodDepPla.setText(String.valueOf(rs1.getInt("cod_dpto")));
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
        }    
    }//GEN-LAST:event_cmbDeptoActionPerformed

    private void cmbMunicipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMunicipioActionPerformed
          try{
            Connection cn=getConexion();
            Statement sent1=cn.createStatement();
            ResultSet rs1=sent1.executeQuery("SELECT * FROM MUNICIPIOS WHERE nom_mncp= '"+this.cmbMunicipio.getSelectedItem()+"'");
            rs1.next();
           this.txtCodMunPla.setText(String.valueOf(rs1.getInt("cod_mncp")));
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_cmbMunicipioActionPerformed

    private void cmbRegPlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRegPlaActionPerformed
        
            try{
            Connection cn=getConexion();
            Statement sent1=cn.createStatement();
            ResultSet rs1=sent1.executeQuery("SELECT * FROM REGISTRANTE WHERE cod_registrante= '"+this.cmbRegPla.getSelectedItem()+"'");
            rs1.next();
            this.txtRegNombre.setText(String.valueOf(rs1.getString("nom_registrante")));
            this.txtRegPaterno.setText(String.valueOf(rs1.getString("ap_registrante")));
            this.txtRegMaterno.setText(String.valueOf(rs1.getString("am_registrante")));
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
        }  
        
    }//GEN-LAST:event_cmbRegPlaActionPerformed

    private void btnActaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActaActionPerformed
        
           lblFotoActaPla.setIcon(null);
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
                            (lblFotoActaPla.getWidth(),lblFotoActaPla.getHeight(),Image.SCALE_DEFAULT);
                    lblFotoActaPla.setIcon(new ImageIcon(icono));
                    lblFotoActaPla.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: "+ex);
                }
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
        } 
    }//GEN-LAST:event_btnActaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
              lblFotoPlanta.setIcon(null);
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
                            (lblFotoPlanta.getWidth(),lblFotoPlanta.getHeight(),Image.SCALE_DEFAULT);
                    lblFotoPlanta.setIcon(new ImageIcon(icono));
                    lblFotoPlanta.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: "+ex);
                }
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
                lblDibuPlanta.setIcon(null);
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
                            (lblDibuPlanta.getWidth(),lblDibuPlanta.getHeight(),Image.SCALE_DEFAULT);
                    lblDibuPlanta.setIcon(new ImageIcon(icono));
                    lblDibuPlanta.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: "+ex);
                }
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
         lblSemillaPlanta.setIcon(null);
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
                            (lblSemillaPlanta.getWidth(),lblSemillaPlanta.getHeight(),Image.SCALE_DEFAULT);
                    lblSemillaPlanta.setIcon(new ImageIcon(icono));
                    lblSemillaPlanta.updateUI();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: "+ex);
                }
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AtxtObs;
    private javax.swing.JButton btnActPlan;
    private javax.swing.JButton btnActa;
    private javax.swing.JButton btnBorrarPlanta;
    private javax.swing.JButton btnRegPlantas;
    private javax.swing.JCheckBox chkCombinado;
    private javax.swing.JComboBox cmbDepto;
    private javax.swing.JComboBox cmbIdioma;
    private javax.swing.JComboBox cmbMesProduccion;
    private javax.swing.JComboBox cmbMunicipio;
    private javax.swing.JComboBox cmbRegPla;
    private javax.swing.JComboBox cmbTipoPlanta;
    private javax.swing.JComboBox cmbTipoRegion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboRegPlan;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
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
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDibuPlanta;
    private javax.swing.JLabel lblFotoActaPla;
    private javax.swing.JLabel lblFotoPlanta;
    private javax.swing.JLabel lblSemillaPlanta;
    private javax.swing.JLabel lblcontarParteUso;
    private javax.swing.JLabel lblcontarParteUso1;
    private javax.swing.JLabel lblcontarParteUso2;
    private javax.swing.JLabel lblerrorManeraUso;
    private javax.swing.JLabel lblerrorParteUso;
    private javax.swing.JLabel lblerrorParteUso2;
    private javax.swing.JPanel pnlDatosPlanta;
    private javax.swing.JPanel pnlDatosRegPlanta;
    private javax.swing.JTable tablaPlanta;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCodDepPla;
    private javax.swing.JTextField txtCodMunPla;
    private javax.swing.JTextField txtCodRegion;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextArea txtComoUso;
    private javax.swing.JTextField txtComunidad;
    private javax.swing.JTextField txtCoordX;
    private javax.swing.JTextField txtCoordY;
    private javax.swing.JTextArea txtDescripcionPlanta;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFuente;
    private javax.swing.JTextField txtInfMaterno;
    private javax.swing.JTextField txtInfNombre;
    private javax.swing.JTextField txtInfPaterno;
    private javax.swing.JTextField txtNombreCientifico;
    private javax.swing.JTextField txtNombreNativo;
    private javax.swing.JTextArea txtParteUso;
    private javax.swing.JTextField txtRegMaterno;
    private javax.swing.JTextField txtRegNombre;
    private javax.swing.JTextField txtRegPaterno;
    private javax.swing.JTextPane txtRegPla;
    private javax.swing.JTextField txtTco;
    private javax.swing.JTextField txtUso;
    // End of variables declaration//GEN-END:variables
}
