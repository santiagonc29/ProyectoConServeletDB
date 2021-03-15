/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.mycompany.famsov2.Servelet.ConexionsqlV2;
import java.sql.Connection;
/**
 *
 * @author santi
 */
public class Conexion {
    
     public static void main(String[] args) {
        // TODO code application logic here
        
     Connection tempResultado=null;
     
     ConexionsqlV2 Con = new ConexionsqlV2();
        
     tempResultado = Con.conectarMariaDB();
     
     System.out.println("El resultado de la conexion es :" + tempResultado);
     
     Con.consultarBDFamso(tempResultado);
     
    }
}
