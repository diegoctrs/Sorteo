/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionSQL;

import ListaPuntos.ListaSorteo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

/**
 *
 * @author USUARIO
 */
public class ClsConexion {
    
    public Connection conexion;
    private final String servidor_conexion = "jdbc:mysql://localhost:3306/sorteodb";
    static private final String usuario = "root";
    static private final String clave = "dcontrerasg3";
    
    public void AbrirConexion(){
       try{
           conexion = DriverManager.getConnection(servidor_conexion, usuario, clave);          
        }catch(SQLException ex){
           System.out.print("ERROR:" + ex.getMessage());
        } 
    }
    
    public void CerrarConexion(){
        try{
           conexion.close(); 
        }catch(SQLException ex){
            System.out.print("ERROR:" + ex.getMessage());
        }
    }
        
}
