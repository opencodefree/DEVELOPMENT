/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.connPos;
import javax.swing.JOptionPane;

/**
 *
 * @author gfrm
 */
public class editaAnimal extends javax.swing.JFrame {
     String cod_animal="";
     int cod_region=0;
    /**
     * Creates new form editaAnimal
     */
     public editaAnimal() {
        
        initComponents();
    }
     
    public editaAnimal(String cod_animal,int cod_region,String nombre_nativo,String nombre_cientifico,
                              String especie,String color,String tipo_uso,String parte_uso,String manera_uso,
                              String desplazamiento,String descripcion_animal,String nro_de_registro_animal,
                              String fecha_registro,String fuente_de_datos,String idioma_region) {
        
        initComponents();
        this.cod_animal=cod_animal;
        this.cod_region=cod_region;
        this.EANomNat.setText(nombre_nativo);
        this.EANomCie.setText(nombre_cientifico);
        this.EAEsp.setText(especie);
        this.EACol.setText(color);
        this.EATipUso.setText(tipo_uso);
        this.EAPartUso.setText(parte_uso);
        this.EAManUso.setText(manera_uso);
        this.EADesp.setText(desplazamiento);
        this.EADesAni.setText(descripcion_animal);
        this.EANumReg.setText(nro_de_registro_animal);
        this.EAFec.setText(fecha_registro);
        this.EAFue.setText(fuente_de_datos);
        this.EAIdi.setText(idioma_region); 
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        EANomNat = new javax.swing.JTextField();
        EANomCie = new javax.swing.JTextField();
        EAEsp = new javax.swing.JTextField();
        EACol = new javax.swing.JTextField();
        EATipUso = new javax.swing.JTextField();
        EAPartUso = new javax.swing.JTextField();
        EAManUso = new javax.swing.JTextField();
        EADesp = new javax.swing.JTextField();
        EADesAni = new javax.swing.JTextField();
        EANumReg = new javax.swing.JTextField();
        EAFec = new javax.swing.JTextField();
        EAFue = new javax.swing.JTextField();
        EAIdi = new javax.swing.JTextField();
        btnEditAni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NOMBRE NATIVO :");

        jLabel3.setText("NOMBRE CIENTIFICO :");

        jLabel4.setText("ESPECIE :");

        jLabel5.setText("COLOR :");

        jLabel6.setText("TIPO DE USO :");

        jLabel7.setText("PARTE EN USO :");

        jLabel8.setText("MANERA DE USO :");

        jLabel9.setText("DESPLAZAMIENTO :");

        jLabel10.setText("DESCRIPCION DEL ANIMAL :");

        jLabel11.setText("NUMERO DE REGISTRO :");

        jLabel12.setText("FECHA DE REGISTRO :");

        jLabel13.setText("FUENTE DE DATOS :");

        jLabel14.setText("IDIOMA REGION :");

        EANomCie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EANomCieActionPerformed(evt);
            }
        });

        btnEditAni.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditAni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditAni.setText("ACTUALIZAR");
        btnEditAni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(EANomNat)
                        .addComponent(EANomCie)
                        .addComponent(EAEsp)
                        .addComponent(EACol)
                        .addComponent(EATipUso)
                        .addComponent(EAPartUso)
                        .addComponent(EADesp)
                        .addComponent(EAManUso)
                        .addComponent(EADesAni)
                        .addComponent(EANumReg)
                        .addComponent(EAFec)
                        .addComponent(EAFue, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
                    .addComponent(EAIdi, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditAni, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(136, 136, 136))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(EANomNat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(EANomCie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(EAEsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(EACol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(EATipUso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EAPartUso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EAManUso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addComponent(EADesp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EADesAni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EANumReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EAFec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EAFue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(EAIdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnEditAni)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EANomCieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EANomCieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EANomCieActionPerformed

    private void btnEditAniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAniActionPerformed
        
        connPos cn= new connPos();
        
        String nombre_nativo=this.EANomNat.getText().toString();
        String nombre_cientifico=this.EANomCie.getText().toString();
        String especie=this.EAEsp.getText().toString();
        String color=this.EACol.getText().toString();
        String tipo_uso=this.EATipUso.getText().toString();
        String parte_uso=this.EAPartUso.getText().toString();
        String manera_uso=this.EAManUso.getText().toString();
        String desplazamiento=this.EADesp.getText().toString();
        String descripcion_animal=this.EADesAni.getText().toString();
        String nro_de_registro_animal=this.EANumReg.getText().toString();
        String fecha_registro=this.EAFec.getText().toString();
        String fuente_de_datos=this.EAFue.getText().toString();
        String idioma_region=this.EAIdi.getText().toString();
        
        cn.actualizarAnimal(cod_animal,cod_region,nombre_nativo, nombre_cientifico,
                              especie,color, tipo_uso, parte_uso, manera_uso,
                               desplazamiento,descripcion_animal,nro_de_registro_animal,
                              fecha_registro,fuente_de_datos, idioma_region);
        //cn.cerrarConexion();
        JOptionPane.showMessageDialog(rootPane,"Registro Actualizado");
        this.dispose();
        Animales ani=new Animales();
        ani.setVisible(true);
        
    }//GEN-LAST:event_btnEditAniActionPerformed

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
            java.util.logging.Logger.getLogger(editaAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editaAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editaAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editaAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editaAnimal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EACol;
    private javax.swing.JTextField EADesAni;
    private javax.swing.JTextField EADesp;
    private javax.swing.JTextField EAEsp;
    private javax.swing.JTextField EAFec;
    private javax.swing.JTextField EAFue;
    private javax.swing.JTextField EAIdi;
    private javax.swing.JTextField EAManUso;
    private javax.swing.JTextField EANomCie;
    private javax.swing.JTextField EANomNat;
    private javax.swing.JTextField EANumReg;
    private javax.swing.JTextField EAPartUso;
    private javax.swing.JTextField EATipUso;
    private javax.swing.JButton btnEditAni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
