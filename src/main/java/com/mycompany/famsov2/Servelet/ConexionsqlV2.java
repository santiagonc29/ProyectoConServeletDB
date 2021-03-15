/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.famsov2.Servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author santi
 */
public class ConexionsqlV2 extends HttpServlet {

    
    public String driver = "org.mariadb.jdbc.Driver";
    
    public String database ="famsodb";
    
    public String host="localhost";
    
    public String port="3306";
    
    public String url="jdbc:mysql://" +  host + ":" + port + "/" + database + "?useSSL=false";
    
    // creacion de adminitrador
    public String username ="root";
    public String password ="";
    
    
    public  Connection conectarMariaDB (){
    
       Connection resultadoConexion =  null;
       
       try{
        Class.forName(driver);
        resultadoConexion= DriverManager.getConnection(url, username, password);
       }
    
       catch(ClassNotFoundException | SQLException err ){
           System.err.println("Error Username o password " + err);
       }
       return resultadoConexion;
    }
    
    public void consultarBDFamso( Connection resultadoConexion  ){
        String consultaSQL="SELECT * FROM famsodb";
     
        try{
         // preparedStatement : preparacion de la consulta que se va hacer

 

        PreparedStatement miConsulta = resultadoConexion.prepareStatement(consultaSQL);
        ResultSet resultadosConsulta = miConsulta.executeQuery();
        
        int id_Area = 0;
        String nom_Area ="";
        int id_Suc = 0;
        String nom_Suc ="";
        String Ciudad ="";
        
            while (resultadosConsulta.next()){
            
            id_Suc = resultadosConsulta.getInt("id_Suc");
            nom_Suc = resultadosConsulta.getString("nom_Suc");
            Ciudad = resultadosConsulta.getString("ciudad");            
            id_Area = resultadosConsulta.getInt("id_Area");
            nom_Area = resultadosConsulta.getString("nom_Area");
            System.out.println("El id de la sucursal es: " + id_Suc);
            System.out.println("El nombre de la sucursal : " + nom_Suc);
            System.out.println("La ciudad es : " + Ciudad);
            System.out.println("El id del area: " + id_Area);
            System.out.println("El nombre del area: " + nom_Area);
            System.out.println("_____________________________");
            
            }
        
        }
        catch(SQLException err){
         System.out.println ("Ocurrio  algo en la consulta " + err);    
       }
    }
    
}
