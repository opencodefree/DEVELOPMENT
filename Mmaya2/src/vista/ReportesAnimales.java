
package vista;

import conexion.connPos;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;



public class ReportesAnimales extends javax.swing.JInternalFrame {
private final String logotipo="/Reportes/encabezado.png";
    static ResultSet res; 

    public ReportesAnimales() {
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
       DefaultTableModel modelo=(DefaultTableModel)tablaAnimalRep.getModel();
       modelo.setRowCount(0);
      res = conexion.connPos.Consulta("SELECT cod_animal,nombre_nativo,nombre_cientifico,especie,color,nro_de_registro_animal,fecha_registro,fuente_de_datos,idioma_region FROM ANIMAL");
       try{
         while(res.next()){
             Vector v = new Vector();
             v.add(res.getString(1));
             v.add(res.getString(2));
             v.add(res.getString(3));
             v.add(res.getString(4));
             v.add(res.getString(5));
             v.add(res.getString(6));
             v.add(res.getString(7));
             v.add(res.getString(8));
             v.add(res.getString(9));
             modelo.addRow(v);
             tablaAnimalRep.setModel(modelo);
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
        jLabel3 = new javax.swing.JLabel();
        btnRepGeneral = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnRepEspecifico = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaAnimalRep = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("FORMULARIO DE REPORTES DE ANIMALES");

        jLabel2.setText("Seleccione una opción para generar sus reportes:");

        jLabel3.setText("Generar reportes generales (LISTADO COMPLETO DE LA BASE DE DATOS)");

        btnRepGeneral.setText("REPORTE GENERAL");
        btnRepGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepGeneralActionPerformed(evt);
            }
        });

        jLabel4.setText("Generar reportes individuales (DESCRIPCION COMPLETA DE UN DETERMINADO ANIMAL)");

        btnRepEspecifico.setText("GENERAR ");
        btnRepEspecifico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepEspecificoActionPerformed(evt);
            }
        });

        jLabel5.setText("Elija un dato de la tabla y presione Generar para ver el archivo");

        tablaAnimalRep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "codigo animal", "nombre nativo", "nombre cientifico", "especie", "color", "numero de registro", "fecha de registro", "fuente de datos", "idioma regional"
            }
        ));
        jScrollPane4.setViewportView(tablaAnimalRep);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRepGeneral))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(69, 69, 69)
                                .addComponent(btnRepEspecifico))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addContainerGap(106, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRepGeneral)
                            .addComponent(jLabel3))
                        .addGap(41, 41, 41)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnRepEspecifico))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRepGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepGeneralActionPerformed
       
        JOptionPane.showMessageDialog(null, "Generando el Reporte espere un momento por favor!!!!");
        try{
            URL  in=this.getClass().getResource("/Reportes/Animales.jasper");
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

    private void btnRepEspecificoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepEspecificoActionPerformed
                
        int fila=tablaAnimalRep.getSelectedRow();
        String cod_animal=this.tablaAnimalRep.getValueAt(fila, 0).toString();

        JOptionPane.showMessageDialog(null, "Generando el Reporte espere un momento por favor!!!!");
        try{
            URL  in=this.getClass().getResource("/Reportes/report1.jasper");
            JasperReport reporteA=(JasperReport)JRLoader.loadObject(in);
            Map parametro=new HashMap();
            parametro.put("parameter1", cod_animal);
            parametro.put("logo",this.getClass().getResourceAsStream(logotipo));
            //JasperReport reporteA= JasperCompileManager.compileReport("src/Reportes/report1.jrxml");
            JasperPrint printA = JasperFillManager.fillReport(reporteA, parametro, connPos.getConexion());
            JasperViewer.viewReport(printA,false);
        }catch(Exception e){
        //JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_btnRepEspecificoActionPerformed

     
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRepEspecifico;
    private javax.swing.JButton btnRepGeneral;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaAnimalRep;
    // End of variables declaration//GEN-END:variables
}
