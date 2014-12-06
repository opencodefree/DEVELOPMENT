/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.connPos;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static vista.ReportesAnimales.res;

/**
 *
 * @author gfrm
 */
public class ReportesPlantas extends javax.swing.JInternalFrame {
private final String logotipo="/Reportes/encabezado.png";

    public ReportesPlantas() {
        initComponents();
        cargaParaReportes();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getSize();
        int horizontal=(pantalla.width-ventana.width)/2;
        int vertical=(pantalla.height-ventana.height)/2;
        this.setLocation(horizontal,vertical);
    
        //DESHABILITANDO MOVER LA VENTANA
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    }

   public void cargaParaReportes(){
       DefaultTableModel modelo=(DefaultTableModel)tablaPlantaRep.getModel();
       modelo.setRowCount(0);
      res = conexion.connPos.Consulta("SELECT cod_planta,nombre_nativo,nombre_cientifico,tipo_planta,idioma_region FROM planta");
       try{
         while(res.next()){
             Vector v = new Vector();
             v.add(res.getString(1));
             v.add(res.getString(2));
             v.add(res.getString(3));
             v.add(res.getString(4));
             v.add(res.getString(5));
             modelo.addRow(v);
             tablaPlantaRep.setModel(modelo);
             }
       }
       catch(SQLException e){
       
       }
    }
   
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        btnRepEspecifico = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnRepGeneral = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPlantaRep = new javax.swing.JTable();

        jLabel5.setText("Elija un dato de la tabla y presione Generar para ver el archivo");

        btnRepEspecifico.setText("GENERAR ");
        btnRepEspecifico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepEspecificoActionPerformed(evt);
            }
        });

        jLabel4.setText("Generar reportes individuales (DESCRIPCION COMPLETA DE UN DETERMINADO ANIMAL)");

        btnRepGeneral.setText("REPORTE GENERAL");
        btnRepGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepGeneralActionPerformed(evt);
            }
        });

        jLabel3.setText("Generar reportes generales (LISTADO COMPLETO DE LA BASE DE DATOS)");

        jLabel2.setText("Seleccione una opción para generar sus reportes:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("FORMULARIO DE REPORTES DE PLANTAS");

        tablaPlantaRep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo Planta", "Nombre Nativo", "Nombre Cientifico", "Tipo Planta", "Idioma"
            }
        ));
        jScrollPane1.setViewportView(tablaPlantaRep);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel6)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(btnRepGeneral))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(79, 79, 79)
                            .addComponent(btnRepEspecifico)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRepGeneral)
                            .addComponent(jLabel3))
                        .addGap(41, 41, 41)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnRepEspecifico))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRepEspecificoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepEspecificoActionPerformed

        int fila=tablaPlantaRep.getSelectedRow();
        String cod_planta=this.tablaPlantaRep.getValueAt(fila, 0).toString();
        //VALIDAR LA SELECCION DE UN DATO
        JOptionPane.showMessageDialog(null, "Generando el Reporte espere un momento por favor!!!!");
        try{
           URL  in=this.getClass().getResource("/Reportes/report2.jasper");
            JasperReport reporteA=(JasperReport)JRLoader.loadObject(in);
            Map parametro=new HashMap();
            parametro.put("CodPlanta", cod_planta);
            parametro.put("logo",this.getClass().getResourceAsStream(logotipo));
            JasperPrint printA = JasperFillManager.fillReport(reporteA, parametro, connPos.getConexion());
            JasperViewer.viewReport(printA,false);
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_btnRepEspecificoActionPerformed

    private void btnRepGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepGeneralActionPerformed
        JOptionPane.showMessageDialog(null, "Generando el Reporte espere un momento por favor!!!!");
        try{
            URL  in=this.getClass().getResource("/Reportes/Plantas.jasper");
            JasperReport reporte=(JasperReport)JRLoader.loadObject(in);
            Map parametros = new HashMap();
            parametros.clear();
            parametros.put("logo", this.getClass().getResourceAsStream(logotipo));
            JasperPrint print = JasperFillManager.fillReport(reporte, parametros, connPos.getConexion());
            JasperViewer.viewReport(print,false);
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_btnRepGeneralActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRepEspecifico;
    private javax.swing.JButton btnRepGeneral;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPlantaRep;
    // End of variables declaration//GEN-END:variables
}
