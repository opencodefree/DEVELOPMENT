
package vista;

import conexion.connPos;
import java.awt.image.ImageObserver;
import javax.swing.JOptionPane;
import conexion.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class Region extends javax.swing.JInternalFrame {

   static ResultSet res; 
   
    public Region() {
        initComponents();
        cargaTodoRegion();
        
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getSize();
        int horizontal=(pantalla.width-ventana.width)/2;
        int vertical=(pantalla.height-ventana.height)/2;
        this.setLocation(horizontal,vertical);
        
    
        //DESHABILITANDO MOVER LA VENTANA
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    }
    
      public void cargaTodoRegion(){
       DefaultTableModel modelo=(DefaultTableModel)tablaRegion.getModel();
       modelo.setRowCount(0);
       res = conexion.connPos.Consulta("SELECT * FROM REGION");
       try{
         while(res.next()){
             Vector v = new Vector();
             v.add(res.getString(1));
             v.add(res.getString(2));
             v.add(res.getString(3));
             v.add(res.getString(4));
             modelo.addRow(v);
             tablaRegion.setModel(modelo);
             }
       }
       catch(SQLException e){
       
       }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbDepto = new javax.swing.JComboBox();
        cmbTipoRegion = new javax.swing.JComboBox();
        cmbEcoRegion = new javax.swing.JComboBox();
        btnregistra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegion = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("FORMULARIO DE REGIONES");

        jLabel3.setText("Tipo Region:");

        jLabel4.setText("EcoRegion:");

        jLabel5.setText("Departamento:");

        cmbDepto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione Depto>", "La Paz", "Oruro", "Potosi", "Santa Cruz", "Pando", "Beni", "Tarija", "Cochabamba", "Chuquisaca", " " }));
        cmbDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDeptoActionPerformed(evt);
            }
        });

        cmbTipoRegion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Elija Tipo Region>", "Tierras Bajas", "Vertiente Oriental y Valles Interandinos", "Cordilleras Altas y Altiplano" }));
        cmbTipoRegion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoRegionItemStateChanged(evt);
            }
        });
        cmbTipoRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoRegionActionPerformed(evt);
            }
        });

        btnregistra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnregistra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/registrar.png"))); // NOI18N
        btnregistra.setText("REGISTRAR");
        btnregistra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistraActionPerformed(evt);
            }
        });

        tablaRegion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "codigo region", "tipo region", "ecoregion", "departamento "
            }
        ));
        jScrollPane1.setViewportView(tablaRegion);

        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnActualizar.setText("EDITAR REGISTRO");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        btnBorrar.setText("BORRAR REGISTRO");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("TABLA DE REGISTROS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbTipoRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbEcoRegion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnregistra, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnActualizar))
                            .addComponent(btnBorrar))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbDepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbTipoRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbEcoRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnregistra, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoRegionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoRegionItemStateChanged
        // TODO add your handling code here:
        int pos=cmbTipoRegion.getSelectedIndex();
        if (pos==1){
        cmbEcoRegion.removeAllItems();
        cmbEcoRegion.addItem("Bosques del sudoeste de la amazonia"); 
        cmbEcoRegion.addItem("Cerrado"); 
        cmbEcoRegion.addItem("Sabanas inundables");
        }
        if(pos==2){
        cmbEcoRegion.removeAllItems();
        cmbEcoRegion.addItem("Bosque seco Chiquitano"); 
        cmbEcoRegion.addItem("Gran Chaco");
        cmbEcoRegion.addItem("Yungas"); 
        cmbEcoRegion.addItem("Bosque Tucumano Boliviano"); 
        cmbEcoRegion.addItem("Chaco Serrano"); 
        cmbEcoRegion.addItem("Bosques Serranos Interandinos"); 
        
        }
        if(pos==3){
        cmbEcoRegion.removeAllItems();
        cmbEcoRegion.addItem("Prepeuna"); 
        cmbEcoRegion.addItem("Puna Norteña"); 
        cmbEcoRegion.addItem("Puna Sureña"); 
        }
    }//GEN-LAST:event_cmbTipoRegionItemStateChanged

    private void btnregistraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistraActionPerformed
       
        String tipo=(String)this.cmbTipoRegion.getSelectedItem();
        String ecoregion=(String)this.cmbEcoRegion.getSelectedItem();
        String dpto=(String)this.cmbDepto.getSelectedItem();
        connPos cn=new connPos();
        cn.insertarDatosRegion(tipo, ecoregion, dpto);
        JOptionPane.showMessageDialog(rootPane,"Guardado correctamente");
    }//GEN-LAST:event_btnregistraActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //int conv;
        int cod_region;
        String tipo_region;
        String ecoregion;
        String dpto;
        int fila = this.tablaRegion.getSelectedRow();
        cod_region=Integer.parseInt(this.tablaRegion.getValueAt(fila, 0).toString());
        //conv=Integer.parseInt(cod_region);
        tipo_region=this.tablaRegion.getValueAt(fila, 1).toString();
        ecoregion=this.tablaRegion.getValueAt(fila, 2).toString();
        dpto=this.tablaRegion.getValueAt(fila, 3).toString();
        
        editaRegion er= new editaRegion(cod_region, tipo_region, ecoregion, dpto);
        er.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
         
        int fila;
        fila=(Integer)this.tablaRegion.getSelectedRow();
        //int codigo=Integer.parseInt(this.tablaRegion.getValueAt(fila, 0).toString());
        int codigo=Integer.parseInt(this.tablaRegion.getValueAt(fila, 0).toString());
        connPos cn= new connPos();
        cn.borrarRegion(codigo);
        
        DefaultTableModel dfmDelete = new DefaultTableModel();
        this.tablaRegion.setModel(dfmDelete);
        dfmDelete.setColumnIdentifiers(new Object[]{"cod_region","tipo_region","ecoregion","dpto"});
        ResultSet rs=cn.seleccionarTodoRegion();
        
        try{
            while(rs.next()){
            dfmDelete.addRow(new Object[]{rs.getInt("cod_region"),rs.getString("tipo_region"),rs.getString("ecoregion"),rs.getString("dpto")});    
            }
        }
        catch(Exception e){
        
        }
        
    
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void cmbDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDeptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDeptoActionPerformed

    private void cmbTipoRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoRegionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoRegionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnregistra;
    private javax.swing.JComboBox cmbDepto;
    private javax.swing.JComboBox cmbEcoRegion;
    private javax.swing.JComboBox cmbTipoRegion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaRegion;
    // End of variables declaration//GEN-END:variables
}
