
package modelo;

import java.io.FileInputStream;

public class animal {

    //  String  cod_animal;
    //  int cod_region;
    //  String nombre_nativo;
    //  String nombre_cientifico;
    //  String especie;
    //  String color;
    //  String deplazamiento;
    //  String descripcion_animal;
    //  String nro_de_registro_animal;
    //  String observaciones;
    //  String observaciones;
  String cod_animal;
  int cod_region;
  String nombre_nativo;
  String nombre_cientifico;
  String especie;
  String color ;
  FileInputStream foto_animal;
  FileInputStream dibujo;
  String tipo_uso;
  String parte_uso;
  String manera_uso;
  String desplazamiento;
  String descripcion_animal;
  String nro_de_registro_animal;
  String fecha_registro;
  String fuente_de_datos;
  String idioma_region;

    
    public animal(String cod_animal, int cod_region, String nombre_nativo, String nombre_cientifico, String especie, String color, FileInputStream foto_animal, FileInputStream dibujo, String tipo_uso, String parte_uso, String manera_uso, String desplazamiento, String descripcion_animal, String nro_de_registro_animal, String fecha_registro, String fuente_de_datos, String idioma_region) {
        this.cod_animal = cod_animal;
        this.cod_region = cod_region;
        this.nombre_nativo = nombre_nativo;
        this.nombre_cientifico = nombre_cientifico;
        this.especie = especie;
        this.color = color;
        this.foto_animal = foto_animal;
        this.dibujo = dibujo;
        this.tipo_uso = tipo_uso;
        this.parte_uso = parte_uso;
        this.manera_uso = manera_uso;
        this.desplazamiento = desplazamiento;
        this.descripcion_animal = descripcion_animal;
        this.nro_de_registro_animal = nro_de_registro_animal;
        this.fecha_registro = fecha_registro;
        this.fuente_de_datos = fuente_de_datos;
        this.idioma_region = idioma_region;
    }

    public animal() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCod_animal() {
        return cod_animal;
    }

    public void setCod_animal(String cod_animal) {
        this.cod_animal = cod_animal;
    }

    public int getCod_region() {
        return cod_region;
    }

    public void setCod_region(int cod_region) {
        this.cod_region = cod_region;
    }

    public String getNombre_nativo() {
        return nombre_nativo;
    }

    public void setNombre_nativo(String nombre_nativo) {
        this.nombre_nativo = nombre_nativo;
    }

    public String getNombre_cientifico() {
        return nombre_cientifico;
    }

    public void setNombre_cientifico(String nombre_cientifico) {
        this.nombre_cientifico = nombre_cientifico;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public FileInputStream getFoto_animal() {
        return foto_animal;
    }

    public void setFoto_animal(FileInputStream foto_animal) {
        this.foto_animal = foto_animal;
    }

    public FileInputStream getDibujo() {
        return dibujo;
    }

    public void setDibujo(FileInputStream dibujo) {
        this.dibujo = dibujo;
    }

    public String getTipo_uso() {
        return tipo_uso;
    }

    public void setTipo_uso(String tipo_uso) {
        this.tipo_uso = tipo_uso;
    }

    public String getParte_uso() {
        return parte_uso;
    }

    public void setParte_uso(String parte_uso) {
        this.parte_uso = parte_uso;
    }

    public String getManera_uso() {
        return manera_uso;
    }

    public void setManera_uso(String manera_uso) {
        this.manera_uso = manera_uso;
    }

    public String getDesplazamiento() {
        return desplazamiento;
    }

    public void setDesplazamiento(String desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    public String getDescripcion_animal() {
        return descripcion_animal;
    }

    public void setDescripcion_animal(String descripcion_animal) {
        this.descripcion_animal = descripcion_animal;
    }

    public String getNro_de_registro_animal() {
        return nro_de_registro_animal;
    }

    public void setNro_de_registro_animal(String nro_de_registro_animal) {
        this.nro_de_registro_animal = nro_de_registro_animal;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getFuente_de_datos() {
        return fuente_de_datos;
    }

    public void setFuente_de_datos(String fuente_de_datos) {
        this.fuente_de_datos = fuente_de_datos;
    }

    public String getIdioma_region() {
        return idioma_region;
    }

    public void setIdioma_region(String idioma_region) {
        this.idioma_region = idioma_region;
    }
    
    
  
  
   
}
