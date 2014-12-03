package conexion;
import java.io.FileInputStream;
 import java.sql.*;
 import modelo.animal; 

public class transaccionAnimal {
    
  static String cod_animal;
  static int cod_region=0;
  static String nombre_nativo;
  static String nombre_cientifico;
  static String especie;
  static String color ;
  static FileInputStream foto_animal;
  static FileInputStream dibujo;
  static String tipo_uso;
  static String parte_uso;
  static String manera_uso;
  static String desplazamiento;
  static String descripcion_animal;
  static String nro_de_registro_animal;
  static String fecha_registro;
  static String fuente_de_datos;
  static String idioma_region;
   
  public static animal obtenerAnimal(){
  animal r=null;
      try{
          if(connPos.resultado.next())
          {
          cod_animal=connPos.resultado.getString(cod_animal);
          cod_region=connPos.resultado.getInt(cod_region);
          nombre_nativo=connPos.resultado.getString(nombre_nativo);
          nombre_cientifico=connPos.resultado.getString(nombre_cientifico);
          especie=connPos.resultado.getString(especie);
          color=connPos.resultado.getString(color);
          tipo_uso=connPos.resultado.getString(tipo_uso);
          parte_uso=connPos.resultado.getString(parte_uso);
          manera_uso=connPos.resultado.getString(manera_uso);
          desplazamiento=connPos.resultado.getString(desplazamiento);
          descripcion_animal=connPos.resultado.getString(descripcion_animal);
          nro_de_registro_animal=connPos.resultado.getString(nro_de_registro_animal);
          fecha_registro=connPos.resultado.getString(fecha_registro);
          fuente_de_datos=connPos.resultado.getString(fuente_de_datos);
          idioma_region=connPos.resultado.getString(idioma_region);
          
          
          r = new animal (cod_animal, cod_region, nombre_nativo,nombre_cientifico, especie, color, foto_animal, dibujo,tipo_uso,parte_uso,manera_uso, desplazamiento, descripcion_animal,nro_de_registro_animal,fecha_registro, fuente_de_datos,idioma_region);
          }
      }catch(SQLException e){
       System.out.println("OCURRIO UN ERROR AL EJECUTAR LA CONSULTA");
       e.printStackTrace();
      } 
  return r;
  }
  
//  public static void insertaAnimal(animal x){
//      String q=("INSERT INTO ANIMAL VALUES('"+x.getCod_animal()+"','"+x.getNombre_nativo()+"','"+x.getNombre_cientifico()+"')");
//  }
  
  public static animal todoAnimal(String nombre_cientifico){
     
    animal r=null;
    String q = "SELECT * FROM ANIMAL"+"WHERE nombre_cientifico='"+ nombre_cientifico + "'";
    connPos.ejecutaConsulta(q);
    r=obtenerAnimal();
    return r;
  }
  
}
