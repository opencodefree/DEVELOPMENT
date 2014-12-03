package conexion;

import java.sql.*;
 
import javax.swing.JOptionPane;
  
public class cone 
{
    public static void main(String args[])
    {
        connPos con=new connPos();
        if(con.cone())
        {
            JOptionPane.showMessageDialog(null, "Conexion Satisfactoria");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error de Conexion");
        }      
    }
}
