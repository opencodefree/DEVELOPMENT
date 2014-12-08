package conexion;

import java.io.FileInputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
 
public class connPos
{
   
    static String host_Server="localhost";
    static String user_Server="postgres";
    String pass_Server="postgres";
      
    static String db_Server="bdsa4";
 
    Statement  st=null;
    Connection con=null;
    
    FileInputStream fis;
      
    static Connection conexion;
    static Statement sentencia;
    static ResultSet resultado;
    static String query="";
    static Connection contacto=null;        
    public connPos()
    {        
    }

    public boolean cone()
    {
        try
        {
              /* Driver */
              String driver = "org.postgresql.Driver";
             System.out.println( "=> Cargando el Driver:" );
              Class.forName( driver );
              System.out.println("OK");
              /* Definiendo Base de Datos */
              String url  = "jdbc:postgresql://"+host_Server+":5432/"+db_Server ;
              String user = user_Server;
             String pass = pass_Server;
              /* Conectando */
              System.out.println( "=> conectando:" );
              con = DriverManager.getConnection(url,user,pass);
             System.out.println("OK");
              /* Mostrando Resultados */
              st= con.createStatement();
             return true;
        }catch( Exception x )
        {
             JOptionPane.showMessageDialog(null,x.toString());
             return false;
        }
    }
    

    public static Connection getConexion(){
              String url  = "jdbc:postgresql://"+host_Server+":5432/"+db_Server ;
             
      try{
           Class.forName("org.postgresql.Driver");
      
      }catch(ClassNotFoundException e){
             JOptionPane.showMessageDialog(null,"No se pudo realizar la conexion"+e.getMessage(),"Error de conexion",JOptionPane.ERROR_MESSAGE);
      }
      try{
         contacto= DriverManager.getConnection(url,"postgres","postgres");
      }
      
      catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error:"+e.getMessage(),"Error de conexion",JOptionPane.ERROR_MESSAGE);
      }
      return contacto;
    }
    
    public static void ejecutaConsulta(String q){
    
         query = q;
         try{
             resultado = sentencia.executeQuery(query);
             
         }
         catch(SQLException e){
             System.out.println("NO SE EJECUTO CORRECTAMENTE");
             e.printStackTrace();
         }          
    }
    
   public static ResultSet Consulta (String consulta){
      Connection con = getConexion();
      Statement declara;
      try{
          declara=con.createStatement();
          ResultSet respuesta=declara.executeQuery(consulta);
          return respuesta;
      }
      catch(SQLException e){
          JOptionPane.showMessageDialog(null,"Error:"+e.getMessage(),"Error de conexion",JOptionPane.ERROR_MESSAGE);
          return null;
      }
   }
   
   public ResultSet seleccionarTodoAnimales(){
       Connection cn = getConexion();
       Statement st;
       ResultSet rs=null;
       try{
           st=cn.createStatement();
           rs=st.executeQuery("SELECT * FROM ANIMAL");
           
       }
       catch (SQLException ex) {
            Logger.getLogger(connPos.class.getName()).log(Level.SEVERE, null, ex);
        }
       return rs;
   }
   
    public ResultSet seleccionarTodoRegistrante(){
       Connection cn = getConexion();
       Statement st;
       ResultSet rs=null;
       try{
           st=cn.createStatement();
           rs=st.executeQuery("SELECT * FROM REGISTRANTE");
           
       }
       catch (SQLException ex) {
            Logger.getLogger(connPos.class.getName()).log(Level.SEVERE, null, ex);
        }
       return rs;
   }
    
     public ResultSet seleccionarTodoPlantas(){
       Connection cn = getConexion();
       Statement st;
       ResultSet rs=null;
       try{
           st=cn.createStatement();
           rs=st.executeQuery("SELECT * FROM PLANTA");
           
       }
       catch (SQLException ex) {
            Logger.getLogger(connPos.class.getName()).log(Level.SEVERE, null, ex);
        }
       return rs;
   }
   
   public  ResultSet seleccionarAnimal(String nombre){
      //Connection con = getConexion();
       Connection cn;
      PreparedStatement pst;
      ResultSet rs=null;
         try{
             cn =  getConexion();
             pst= cn.prepareStatement("SELECT * FROM ANIMAL WHERE NOMBRE_CIENTIFICO=?");
             pst.setString(1, nombre);
             rs=pst.executeQuery();
          }
         catch( Exception e){
         
         
         }
           return rs; 
   }
   
 public void insertarDatos(String cod_animal,int cod_region,String nombre_nativo,
                            String nombre_cientifico,String especie,String color,FileInputStream foto_animal,FileInputStream dibujo,
                            String tipo_uso,String parte_uso,String manera_uso,String deplazamiento,
                            String descripcion_animal,String nro_de_registro_animal,String fecha_registro,
                            String fuente_de_datos,String idioma_region,int longitud){
     Connection cn=getConexion();
        try {
            PreparedStatement pst=cn.prepareStatement("INSERT INTO ANIMAL "
            + "(cod_animal,cod_region,nombre_nativo,nombre_cientifico,especie,color,foto_animal,dibujo,tipo_uso,parte_uso,manera_uso,deplazamiento,descripcion_animal,nro_de_registro_animal,fecha_registro,fuente_de_datos,idioma_region) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, cod_animal);
            pst.setInt(2, cod_region);
            pst.setString(3, nombre_nativo);
            pst.setString(4, nombre_cientifico);
            pst.setString(5, especie);
            pst.setString(6, color);
            pst.setBlob(7, foto_animal,longitud);
            pst.setBlob(8, dibujo,longitud);
            pst.setString(9, tipo_uso);
            pst.setString(10, parte_uso);
            pst.setString(11, manera_uso);
            pst.setString(12,deplazamiento);
            pst.setString(13,descripcion_animal);
            pst.setString(14,nro_de_registro_animal);
            pst.setString(15,fecha_registro);
            pst.setString(16,fuente_de_datos);
            pst.setString(17,idioma_region);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(connPos.class.getName()).log(Level.SEVERE, null, ex);
        }
   }  
   
 public void actualizarAnimal(String cod_animal,int cod_region,String nombre_nativo,String nombre_cientifico,
                              String especie,String color,String tipo_uso,String parte_uso,String manera_uso,
                              String desplazamiento,String descripcion_animal,String nro_de_registro_animal,
                              String fecha_registro,String fuente_de_datos,String idioma_region)
   {
    Connection cn=getConexion();
        try {
            PreparedStatement pst=cn.prepareStatement("UPDATE ANIMAL SET cod_region=?,nombre_nativo=?,nombre_cientifico=?,especie=?,color=?,tipo_uso=?,parte_uso=?,manera_uso=?,desplazamiento=?,descripcion_animal=?,nro_de_registro_animal=?,fecha_registro=?,fuente_de_datos=?,idioma_region=? WHERE cod_animal=?");
            
            pst.setInt(1,cod_region);
            pst.setString(2, nombre_nativo);
            pst.setString(3, nombre_cientifico);
            pst.setString(4, especie);
            pst.setString(5, color);
            pst.setString(6, tipo_uso);
            pst.setString(7, parte_uso);
            pst.setString(8, manera_uso);
            pst.setString(9, desplazamiento);
            pst.setString(10, descripcion_animal);
            pst.setString(11, nro_de_registro_animal);
            pst.setString(12, fecha_registro);
            pst.setString(13, fuente_de_datos);
            pst.setString(14, idioma_region);
            pst.setString(15, cod_animal);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(connPos.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
 
 public void borrarAnimal(String codigo){
       Connection cn=getConexion();
       PreparedStatement pst;
       try{
          pst=cn.prepareStatement("DELETE FROM ANIMAL WHERE cod_animal=?");
          pst.setString(1, codigo);
          pst.executeQuery();    
        } catch (SQLException ex) {
            Logger.getLogger(connPos.class.getName()).log(Level.SEVERE, null, ex);
        }
   } 
 
 public void insertarDatosRegistrante(String codigo,String paterno,String materno,String nombre){
     Connection cn=getConexion();
        try {
            PreparedStatement pst=cn.prepareStatement("INSERT INTO REGISTRANTE (cod_registrante,ap_registrante,am_registrante,nom_registrante) VALUES(?,?,?,?)");
            pst.setString(1, codigo);
            pst.setString(2, paterno);
            pst.setString(3, materno);
            pst.setString(4, nombre);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(connPos.class.getName()).log(Level.SEVERE, null, ex);
        }
   } 
 
  public void actualizarRegion(int cod_region,String tipo_region,String ecoregion,String dpto){
    Connection cn=getConexion();
        try {
            PreparedStatement pst=cn.prepareStatement("UPDATE REGION SET tipo_region=?, ecoregion=?, dpto=? WHERE cod_region=?");
            pst.setString(1, tipo_region);
            pst.setString(2, ecoregion);
            pst.setString(3, dpto);
            pst.setInt(4, cod_region);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(connPos.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
  
   public void borrarRegistrante(String codReg){
       Connection cn=getConexion();
       PreparedStatement pst;
       try{
          pst=cn.prepareStatement("DELETE FROM REGISTRANTE WHERE cod_registrante=?");
          pst.setString(1,codReg);
          pst.executeQuery();    
        } catch (SQLException ex) {
            Logger.getLogger(connPos.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
    public void actualizarPlanta(String cod_planta,int cod_region,String nombre_nativo,String nombre_cientifico,
                              String tipo_planta,String color_planta,String mes_semilla,String nro_de_registro_planta,
                              String fecha_registro,String fuente_de_datos,String idioma_region,String tipo_uso,String parte_uso,
                              String manera_uso,String descripcion_pla)
   {
    Connection cn=getConexion();
        try {
            PreparedStatement pst=cn.prepareStatement("UPDATE PLANTA SET cod_region=?,nombre_nativo=?,nombre_cientifico=?,tipo_planta=?,color_planta=?,mes_semilla=?,nro_de_registro_planta=?,fecha_registro=?,fuente_de_datos=?,idioma_region=?,tipo_uso=?,parte_uso=?,manera_uso=?,descripcion_pla=? WHERE cod_planta=?");
            
            pst.setInt(1,cod_region);
            pst.setString(2, nombre_nativo);
            pst.setString(3, nombre_cientifico);
            pst.setString(4, tipo_planta);
            pst.setString(5, color_planta);
            pst.setString(6, mes_semilla);
            pst.setString(7, nro_de_registro_planta);
            pst.setString(8, fecha_registro);
            pst.setString(9, fuente_de_datos);
            pst.setString(10,idioma_region);
            pst.setString(11, tipo_uso);
            pst.setString(12, parte_uso);
            pst.setString(13, manera_uso);
            pst.setString(14, descripcion_pla);
            pst.setString(15, cod_planta);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(connPos.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
     public void borrarPlanta(String codigo){
       Connection cn=getConexion();
       PreparedStatement pst;
       try{
          pst=cn.prepareStatement("DELETE FROM PLANTA WHERE cod_planta=?");
          pst.setString(1, codigo);
          pst.executeQuery();    
        } catch (SQLException ex) {
            Logger.getLogger(connPos.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
 
 
 /*public void cerrarConexion(){
        try {
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(connPos.class.getName()).log(Level.SEVERE, null, ex);
        }
   }*/
         
}


