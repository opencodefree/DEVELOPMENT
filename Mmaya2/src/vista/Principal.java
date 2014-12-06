
package vista;

import javax.swing.JOptionPane;
import modelo.ImagenFondo;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        //CENTRAR EL FORMULARIO 
       //this.setLocationRelativeTo(null);
       
        //MAXIMIZADO POR DEFECTO
        this.setExtendedState(Principal.MAXIMIZED_BOTH);
        
        this.escritorio.setBorder(new ImagenFondo());
               
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuBar6 = new javax.swing.JMenuBar();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuForms = new javax.swing.JMenu();
        mnuRegPlantas = new javax.swing.JMenuItem();
        mnuRegAnimales = new javax.swing.JMenuItem();
        mnuRegRegion = new javax.swing.JMenuItem();
        mnuReportes = new javax.swing.JMenu();
        mnuRepPlantas = new javax.swing.JMenuItem();
        mnuRepAnimales = new javax.swing.JMenuItem();
        mnuImagenes = new javax.swing.JMenu();
        mnuImgPlantas = new javax.swing.JMenuItem();
        mnuImgAnimal = new javax.swing.JMenuItem();
        mnuImgSemilla = new javax.swing.JMenuItem();
        mnuDibPlanta = new javax.swing.JMenuItem();
        mnuDibAnimal = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        mnuUsuario = new javax.swing.JMenuItem();
        mnuAcerca = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mnuSalir = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        jMenu2.setText("File");
        jMenuBar5.add(jMenu2);

        jMenu9.setText("Edit");
        jMenuBar5.add(jMenu9);

        jMenu10.setText("File");
        jMenuBar6.add(jMenu10);

        jMenu11.setText("Edit");
        jMenuBar6.add(jMenu11);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().add(escritorio, java.awt.BorderLayout.CENTER);

        mnuForms.setText("Formularios");

        mnuRegPlantas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ico_hoja.gif"))); // NOI18N
        mnuRegPlantas.setText("Registrar Plantas");
        mnuRegPlantas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegPlantasActionPerformed(evt);
            }
        });
        mnuForms.add(mnuRegPlantas);

        mnuRegAnimales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/animales-ico.gif"))); // NOI18N
        mnuRegAnimales.setText("Registrar Animales");
        mnuRegAnimales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegAnimalesActionPerformed(evt);
            }
        });
        mnuForms.add(mnuRegAnimales);

        mnuRegRegion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapa_ico.gif"))); // NOI18N
        mnuRegRegion.setText("Registrar Personas Registradoras");
        mnuRegRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegRegionActionPerformed(evt);
            }
        });
        mnuForms.add(mnuRegRegion);

        jMenuBar1.add(mnuForms);

        mnuReportes.setText("Reportes");

        mnuRepPlantas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ico_report.gif"))); // NOI18N
        mnuRepPlantas.setText("Ver Reportes Plantas");
        mnuRepPlantas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRepPlantasActionPerformed(evt);
            }
        });
        mnuReportes.add(mnuRepPlantas);

        mnuRepAnimales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ico_pdf.gif"))); // NOI18N
        mnuRepAnimales.setText("Ver Reportes Animales");
        mnuRepAnimales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRepAnimalesActionPerformed(evt);
            }
        });
        mnuReportes.add(mnuRepAnimales);

        jMenuBar1.add(mnuReportes);

        mnuImagenes.setText("Imagenes");

        mnuImgPlantas.setText("Añadir Imagen de Planta");
        mnuImgPlantas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuImgPlantasActionPerformed(evt);
            }
        });
        mnuImagenes.add(mnuImgPlantas);

        mnuImgAnimal.setText("Añadir Imagen de Animal");
        mnuImgAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuImgAnimalActionPerformed(evt);
            }
        });
        mnuImagenes.add(mnuImgAnimal);

        mnuImgSemilla.setText("Añadir Imagen de Semilla");
        mnuImgSemilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuImgSemillaActionPerformed(evt);
            }
        });
        mnuImagenes.add(mnuImgSemilla);

        mnuDibPlanta.setText("Añadir Dibujo Planta");
        mnuDibPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDibPlantaActionPerformed(evt);
            }
        });
        mnuImagenes.add(mnuDibPlanta);

        mnuDibAnimal.setText("Añadir Dibujo Animal");
        mnuDibAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDibAnimalActionPerformed(evt);
            }
        });
        mnuImagenes.add(mnuDibAnimal);

        jMenuBar1.add(mnuImagenes);

        mnuAyuda.setText("Ayuda");

        mnuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ico_ayuda.gif"))); // NOI18N
        mnuUsuario.setText("Manual Usuario");
        mnuAyuda.add(mnuUsuario);

        mnuAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/acerca_de.gif"))); // NOI18N
        mnuAcerca.setText("Acerca de...");
        mnuAyuda.add(mnuAcerca);

        jMenuBar1.add(mnuAyuda);

        jMenu1.setText("Salir");

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ico_cerrar.gif"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        
     int confirmado = JOptionPane.showConfirmDialog(this.escritorio,"¿CONFIRMA QUE DESEA SALIR?");

    if (JOptionPane.OK_OPTION == confirmado)
     System.exit(0);
    else
    this.setVisible(true);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuRegAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegAnimalesActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        Animales animal=new Animales();
        escritorio.add(animal);
        animal.setVisible(true);
    }//GEN-LAST:event_mnuRegAnimalesActionPerformed

    private void mnuRegPlantasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegPlantasActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        Plantas plantas=new Plantas();
        escritorio.add(plantas);
        plantas.setVisible(true);
        
    }//GEN-LAST:event_mnuRegPlantasActionPerformed

    private void mnuRegRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegRegionActionPerformed
        // TODO add your handling code here:
       escritorio.removeAll();
        escritorio.repaint();
        Registrante region=new Registrante();
        escritorio.add(region);
        region.setVisible(true);
    }//GEN-LAST:event_mnuRegRegionActionPerformed

    private void mnuRepPlantasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRepPlantasActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ReportesPlantas repPlantas=new ReportesPlantas();
        escritorio.add(repPlantas);
        repPlantas.setVisible(true);
        
    }//GEN-LAST:event_mnuRepPlantasActionPerformed

    private void mnuRepAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRepAnimalesActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ReportesAnimales repAnimales=new ReportesAnimales();
        escritorio.add(repAnimales);
        repAnimales.setVisible(true);
    }//GEN-LAST:event_mnuRepAnimalesActionPerformed


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       /*miPanel p = new miPanel();
        this.add( p , BorderLayout.CENTER);
        p.repaint();*/
    }//GEN-LAST:event_formWindowOpened

    private void mnuImgPlantasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuImgPlantasActionPerformed
         escritorio.removeAll();
        escritorio.repaint();
        fotoPlanta fotoP=new fotoPlanta();
        escritorio.add(fotoP);
        fotoP.setVisible(true);
    }//GEN-LAST:event_mnuImgPlantasActionPerformed

    private void mnuImgAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuImgAnimalActionPerformed
         escritorio.removeAll();
        escritorio.repaint();
        fotoAnimals fotoA=new fotoAnimals();
       escritorio.add(fotoA);
        fotoA.setVisible(true);
       
    }//GEN-LAST:event_mnuImgAnimalActionPerformed

    private void mnuImgSemillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuImgSemillaActionPerformed
       escritorio.removeAll();
        escritorio.repaint();
        fotoSemilla fotoS=new fotoSemilla();
       escritorio.add(fotoS);
        fotoS.setVisible(true);
    }//GEN-LAST:event_mnuImgSemillaActionPerformed

    private void mnuDibPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDibPlantaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        DibujoPlanta dibPla=new DibujoPlanta();
       escritorio.add(dibPla);
        dibPla.setVisible(true);
    }//GEN-LAST:event_mnuDibPlantaActionPerformed

    private void mnuDibAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDibAnimalActionPerformed
       escritorio.removeAll();
        escritorio.repaint();
        DibujoAnimal dibAni=new DibujoAnimal();
       escritorio.add(dibAni);
        dibAni.setVisible(true);
    }//GEN-LAST:event_mnuDibAnimalActionPerformed

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuBar jMenuBar6;
    private javax.swing.JMenuItem mnuAcerca;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenuItem mnuDibAnimal;
    private javax.swing.JMenuItem mnuDibPlanta;
    private javax.swing.JMenu mnuForms;
    private javax.swing.JMenu mnuImagenes;
    private javax.swing.JMenuItem mnuImgAnimal;
    private javax.swing.JMenuItem mnuImgPlantas;
    private javax.swing.JMenuItem mnuImgSemilla;
    private javax.swing.JMenuItem mnuRegAnimales;
    private javax.swing.JMenuItem mnuRegPlantas;
    private javax.swing.JMenuItem mnuRegRegion;
    private javax.swing.JMenuItem mnuRepAnimales;
    private javax.swing.JMenuItem mnuRepPlantas;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenuItem mnuUsuario;
    // End of variables declaration//GEN-END:variables
}
