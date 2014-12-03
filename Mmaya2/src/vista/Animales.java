
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
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author LAB_COMP
 */
public class Animales extends javax.swing.JInternalFrame {

    static ResultSet res; 
    public FileInputStream fisfoto;
    FileInputStream fisI;
    public int longitudBytes;
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
        lblFotoAnimal.setVisible(false);
        lblDibAnimal.setVisible(false);
        txtNroRegAni.setVisible(false);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getSize();
        int horizontal=(pantalla.width-ventana.width)/2;
        int vertical=(pantalla.height-ventana.height)/2;
        this.setLocation(horizontal,vertical);
        
    
        //DESHABILITANDO MOVER LA VENTANA
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        
        // MOSTRANDO DATOS EN EL COMBOBOX DESDE LA BD
         this.jComboregani.removeAllItems();
         try{
             Connection cn=getConexion();
             Statement sent=cn.createStatement();
             ResultSet rs=sent.executeQuery("SELECT * FROM REGION");
             while(rs.next()){
                  this.jComboregani.addItem(rs.getString("ecoregion"));
             }
             
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
       
    }
    
      public void cargaTodoAnimales(){
       DefaultTableModel modelo=(DefaultTableModel)tablaAnimal.getModel();
       modelo.setRowCount(0);
      res = conexion.connPos.Consulta("SELECT cod_animal,cod_region,nombre_nativo,nombre_cientifico,especie,color,tipo_uso,parte_uso,manera_uso,desplazamiento,descripcion_animal,nro_de_registro_animal,fecha_registro,fuente_de_datos,idioma_region FROM ANIMAL");
       try{
         while(res.next()){
             Vector v = new Vector();
             v.add(res.getString(1));
             v.add(res.getInt(2));
             v.add(res.getString(3));
             v.add(res.getString(4));
             v.add(res.getString(5));
             v.add(res.getString(6));
             v.add(res.getString(7));
             v.add(res.getString(8));
             v.add(res.getString(9));
             v.add(res.getString(10));
             v.add(res.getString(11));
             v.add(res.getString(12));
             v.add(res.getString(13));
             v.add(res.getString(14));
             v.add(res.getString(15));
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
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtCoordXMin = new javax.swing.JTextField();
        txtCoordXSeg = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtCoordYGrados = new javax.swing.JTextField();
        txtCoordYMin = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtCoordYSeg = new javax.swing.JTextField();
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
        AtxtObs = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtEspecie = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtColorA = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cmbDesplaza = new javax.swing.JComboBox();
        lblFotoAnimal = new javax.swing.JLabel();
        lblDibAnimal = new javax.swing.JLabel();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnRegAnimales = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaAnimal = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnBorrarAni = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNroRegAni = new javax.swing.JTextField();

        setForeground(new java.awt.Color(0, 0, 0));
        setTitle("REGISTRAR ANIMALES");
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(900, 700));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("REGION HABITAD DEL ANIMAL"));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Departamento");

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
        jLabel9.setText("Municipio");

        cmbMunicipio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Comunidad");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("TCO");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Coord X");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Grados");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Minutos");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Segundos");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Coord Y");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Grados");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Minutos");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Segundos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboregani, 0, 128, Short.MAX_VALUE)
                    .addComponent(cmbMunicipio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtComunidad)
                    .addComponent(txtTco))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(txtCoordYGrados, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel29)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel31)
                                .addGap(74, 74, 74))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCoordYMin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCoordYSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCoordXGrados, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCoordXMin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(txtCoordXSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(27, 27, 27)
                                .addComponent(txtCodReg, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboregani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
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
                            .addComponent(txtTco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCoordXGrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCoordXMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCoordXSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCoordYGrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCoordYMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCoordYSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DEL ANIMAL"));

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
        jLabel13.setText("(No debe sobrepasar 200 caracteres)");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(39, 39, 39)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel22))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbIdioma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFuente))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblcontarParteUso2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(lblerrorParteUso2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(357, 357, 357)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtNativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(txtFuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtCientifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblcontarParteUso2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblerrorParteUso2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
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

        jLabel41.setText("Cargar foto de Acta");

        jLabel42.setText("Observaciones (Anexos, datos extras anotar si existen grabaciones o videos anexos adjuntos)");

        AtxtObs.setColumns(20);
        AtxtObs.setRows(5);
        jScrollPane5.setViewportView(AtxtObs);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel42)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(jLabel36)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41))
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
                                    .addComponent(txtInfMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtInfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39)))))
                    .addComponent(jScrollPane5))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(38, 38, 38)
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
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActa)
                    .addComponent(jLabel41))
                .addGap(28, 28, 28)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DATOS DE LA FUENTE", jPanel8);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DESCRIPCION DEL ANIMAL"));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Especie:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Color:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Como se desplaza:");

        cmbDesplaza.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Camina", "Se arrastra", "Nada", "Vuela" }));

        lblFotoAnimal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblDibAnimal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbDesplaza, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(104, 104, 104)))
                        .addGap(18, 18, 18)
                        .addComponent(txtColorA, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(lblFotoAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(lblDibAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtColorA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cmbDesplaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFotoAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDibAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jLabel10.setText("(No debe sobrepasar 200 caracteres)");

        lblerrorParteUso.setForeground(new java.awt.Color(255, 0, 0));
        lblerrorParteUso.setText("Se ha llegado all limite de caracteres");

        lblerrorParteUso1.setForeground(new java.awt.Color(255, 0, 0));
        lblerrorParteUso1.setText("Se ha llegado all limite de caracteres");

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel11.setText("(No debe sobrepasar 200 caracteres)");

        AtxtComoUso.setColumns(20);
        AtxtComoUso.setRows(5);
        AtxtComoUso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AtxtComoUsoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(AtxtComoUso);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(lblerrorParteUso, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(lblcontarParteUso, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(lblerrorParteUso1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lblcontarParteUso1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUso, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtUso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addContainerGap(426, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
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

        tablaAnimal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "codigo animal", "codigo region", "nombre nativo", "nombre cientifico", "especie", "color", "tipo de uso", "parte utilizada", "manera de uso", "desplazamiento", "descripcion ", "numero de registro", "fecha de registro", "fuente de datos", "idioma regional"
            }
        ));
        jScrollPane4.setViewportView(tablaAnimal);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRegAnimales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBorrarAni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(226, 226, 226))
                    .addComponent(jScrollPane4)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNroRegAni, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtNroRegAni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFecha))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnRegAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnBorrarAni, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
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
        if(cuenta > 199){
         String nueva= k.substring(0, k.length()-1 );
         txtParteUso.setText(nueva);
         lblerrorParteUso.setVisible(true);      
        }
        txtParteUso.setLineWrap(true);
        txtParteUso.setWrapStyleWord(true);
    }//GEN-LAST:event_txtParteUsoKeyTyped

    private void btnRegAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegAnimalesActionPerformed

             try{
            String sql="INSERT INTO \"animal\"(cod_animal,cod_region,nombre_nativo,nombre_cientifico,especie,color,foto_animal,dibujo,tipo_uso,parte_uso,manera_uso,desplazamiento,descripcion_animal,nro_de_registro_animal,fecha_registro,fuente_de_datos,idioma_region) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

           connPos cn=new connPos();
           PreparedStatement pst=cn.getConexion().prepareStatement(sql);
          
            
            pst.setString(1, txtCodigo.getText());
            pst.setInt(2, Integer.parseInt(txtCodReg.getText()));
            pst.setString(3, txtNativo.getText());
            pst.setString(4, txtCientifico.getText());
            pst.setString(5, txtEspecie.getText());
            pst.setString(6, txtColorA.getText());
            pst.setBinaryStream(7, fisI,longitudBytes);
            pst.setBinaryStream(8, fisI,longitudBytes);
            pst.setString(9, txtUso.getText());
            pst.setString(10, txtParteUso.getText());
            pst.setString(11, AtxtComoUso.getText());
            pst.setString(12,(String)cmbDesplaza.getSelectedItem());
            pst.setString(13,AtxtObsA.getText());
            pst.setString(14,txtNroRegAni.getText());
            pst.setString(15,txtFecha.getText());
            pst.setString(16,txtFuente.getText());
            pst.setString(17,(String)cmbIdioma.getSelectedItem());
           
            pst.execute();
           //cn.insertarDatosRegion(tipo, ecoregion, dpto);
            
             txtCodigo.setText("");
             txtCodReg.setText("");
             txtNativo.setText("");
             txtCientifico.setText("");
             txtEspecie.setText("");
             txtColorA.setText("");
             lblFotoAnimal.setIcon(null);
             lblDibAnimal.setIcon(null);
             txtUso.setText("");
             txtParteUso.setText("");
             AtxtComoUso.setText("");
             cmbDesplaza.setSelectedItem("");
             AtxtObsA.setText("");
             txtNroRegAni.setText("");
             txtFecha.setText("");
             txtFuente.setText("");
             cmbIdioma.setSelectedItem("");
                  
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
          
//        int cod_region;
//        String tipo_region;
//        String ecoregion;
//        String dpto;
        ////////////
        String cod_animal;
        int cod_region;
        String nombre_nativo;
        String nombre_cientifico;
        String especie;
        String color;
        String tipo_uso;
        String parte_uso;
        String manera_uso;
        String desplazamiento;
        String descripcion_animal;
        String nro_de_registro_animal;
        String fecha_registro;
        String fuente_de_datos;
        String idioma_region;
     
        
        ///////////
        
        int fila = this.tablaAnimal.getSelectedRow();
        //
        //conv=Integer.parseInt(cod_region);
        cod_animal=this.tablaAnimal.getValueAt(fila, 0).toString();
        cod_region=Integer.parseInt(this.tablaAnimal.getValueAt(fila, 1).toString());
        nombre_nativo=this.tablaAnimal.getValueAt(fila, 2).toString();
        nombre_cientifico=this.tablaAnimal.getValueAt(fila, 3).toString();
        especie=this.tablaAnimal.getValueAt(fila, 4).toString();
        color=this.tablaAnimal.getValueAt(fila, 5).toString();
        tipo_uso=this.tablaAnimal.getValueAt(fila, 6).toString();
        parte_uso=this.tablaAnimal.getValueAt(fila, 7).toString();
        manera_uso=this.tablaAnimal.getValueAt(fila, 8).toString();
        desplazamiento=this.tablaAnimal.getValueAt(fila, 9).toString();
        descripcion_animal=this.tablaAnimal.getValueAt(fila, 10).toString();
        nro_de_registro_animal=this.tablaAnimal.getValueAt(fila, 11).toString();
        fecha_registro=this.tablaAnimal.getValueAt(fila, 12).toString();
        fuente_de_datos=this.tablaAnimal.getValueAt(fila, 13).toString();
        idioma_region=this.tablaAnimal.getValueAt(fila, 14).toString();
       
        
        
        editaAnimal er= new editaAnimal(cod_animal,cod_region, nombre_nativo, nombre_cientifico,
                               especie, color, tipo_uso, parte_uso, manera_uso,
                               desplazamiento,descripcion_animal,nro_de_registro_animal,
                              fecha_registro,fuente_de_datos,idioma_region);
        er.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBorrarAniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarAniActionPerformed
        
        int fila;
        fila=(Integer)this.tablaAnimal.getSelectedRow();
        //int codigo=Integer.parseInt(this.tablaRegion.getValueAt(fila, 0).toString());
        String codigo=this.tablaAnimal.getValueAt(fila, 0).toString();
        connPos cn= new connPos();
        cn.borrarAnimal(codigo);
        
        DefaultTableModel dfmDelete = new DefaultTableModel();
        this.tablaAnimal.setModel(dfmDelete);
        dfmDelete.setColumnIdentifiers(new Object[]{"cod_animal","cod_region","nombre_nativo","nombre_cientifico","especie",
                                                    "color","tipo_uso","parte_uso","manera_uso","desplazamiento",
                                                    "descripcion_animal","nro_de_registro_animal",
                                                    "fecha_registro","fuente_de_datos","idioma_region"});
        ResultSet rs=cn.seleccionarTodoAnimales();
        
        try{
            while(rs.next()){
            dfmDelete.addRow(new Object[]{rs.getString("cod_animal"),rs.getInt("cod_region"),rs.getString("nombre_nativo"),
                                          rs.getString("nombre_cientifico"),rs.getString("especie"),
                                          rs.getString("color"),rs.getString("tipo_uso"),rs.getString("parte_uso"),
                                          rs.getString("manera_uso"),rs.getString("desplazamiento"),rs.getString("desplazamiento"), 
                                          rs.getString("descripcion_animal"),rs.getString("nro_de_registro_animal"),
                                          rs.getString("fecha_registro"),rs.getString("fuente_de_datos"),rs.getString("idioma_region")});    
            }
        }
        catch(Exception e){
        
        }
        
    }//GEN-LAST:event_btnBorrarAniActionPerformed

    private void AtxtObsAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AtxtObsAKeyTyped
        
        int cuenta=AtxtObsA.getText().length();
        String k=AtxtObsA.getText();
        lblcontarParteUso2.setText(String.valueOf(cuenta));
        if(cuenta > 199){
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
        if(cuenta > 199){
         String nueva= k.substring(0, k.length()-1 );
         AtxtComoUso.setText(nueva);
         lblerrorParteUso1.setVisible(true);      
        }
        AtxtComoUso.setLineWrap(true);
        AtxtComoUso.setWrapStyleWord(true);
        
    }//GEN-LAST:event_AtxtComoUsoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AtxtComoUso;
    private javax.swing.JTextArea AtxtObs;
    private javax.swing.JTextArea AtxtObsA;
    private javax.swing.JButton btnActa;
    private javax.swing.JButton btnBorrarAni;
    private javax.swing.JButton btnRegAnimales;
    private javax.swing.JComboBox cmbDesplaza;
    private javax.swing.JComboBox cmbIdioma;
    private javax.swing.JComboBox cmbMunicipio;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDibAnimal;
    private javax.swing.JLabel lblFotoAnimal;
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
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtColorA;
    private javax.swing.JTextField txtComunidad;
    private javax.swing.JTextField txtCoordXGrados;
    private javax.swing.JTextField txtCoordXMin;
    private javax.swing.JTextField txtCoordXSeg;
    private javax.swing.JTextField txtCoordYGrados;
    private javax.swing.JTextField txtCoordYMin;
    private javax.swing.JTextField txtCoordYSeg;
    private javax.swing.JTextField txtEspecie;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFuente;
    private javax.swing.JTextField txtInfMaterno;
    private javax.swing.JTextField txtInfNombre;
    private javax.swing.JTextField txtInfPaterno;
    private javax.swing.JTextField txtNativo;
    private javax.swing.JTextField txtNroRegAni;
    private javax.swing.JTextArea txtParteUso;
    private javax.swing.JTextField txtRegMaterno;
    private javax.swing.JTextField txtRegNombre;
    private javax.swing.JTextField txtRegPaterno;
    private javax.swing.JTextField txtTco;
    private javax.swing.JTextField txtUso;
    // End of variables declaration//GEN-END:variables
}
