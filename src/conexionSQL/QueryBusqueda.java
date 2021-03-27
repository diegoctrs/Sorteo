/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionSQL;

import ListaPuntos.ListaSorteo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import conexionSQL.ClsConexion;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class QueryBusqueda {
     
    public void BusquedaSorteo(){ 
       
        ListaSorteo sorteo = new ListaSorteo();
        ClsConexion cn = new ClsConexion();
        
        try{                    
            cn.AbrirConexion();
            String nombresorteo = "SELECT nombrelista FROM tbsorteo ORDER BY rand() LIMIT 10";
            Statement st = cn.conexion.createStatement();        
            ResultSet rs = st.executeQuery(nombresorteo);
                                   
            System.out.println("SORTEO!!!");
            while (rs.next()){
               
               //aqui esta obteniendo los datos de la primera posicion en Mysql
               sorteo.setNombres(rs.getString(1)); 
               //sorteando...
               List<String> ar = Arrays.asList(sorteo.getNombres());
               Collections.shuffle(ar);
               imprimirGanador(ar);                              
            }           
        }catch(SQLException ex){            
            System.out.println("error: "+ ex.getMessage());
        }   
        finally{
            cn.CerrarConexion();
        }    
    }
    
    public void BusquedaOrden(){ 
        
        ListaSorteo ordenado = new ListaSorteo();
        ClsConexion cn = new ClsConexion(); 
        
        try{                    
            cn.AbrirConexion();
            String nombreslista = "SELECT nombrelista FROM tbsorteo ORDER BY nombrelista ASC";
            Statement st = cn.conexion.createStatement();        
            ResultSet rs = st.executeQuery(nombreslista);
                                   
            System.out.println("ORDENADO!!!");
            while (rs.next()){
               
               //aqui esta obteniendo los datos de la primera posicion en Mysql
               ordenado.setNombres(rs.getString(1)); 
               //ordenando...
               List<String> ar = Arrays.asList(ordenado.getNombres());
               Collections.sort(ar);
               imprimirListaOrdenada(ar);                              
            }           
        }catch(SQLException ex){            
            System.out.println("error: "+ ex.getMessage());
        }   
        finally{
            cn.CerrarConexion();
        }    
    }
    
    public void imprimirListaOrdenada(Collection coll)
    {
        Iterator iter = coll.iterator();
       
        while(iter.hasNext()){
            System.out.println("Nombre = " + iter.next());
        }
    }
    
    public void imprimirGanador(Collection coll)
    {
        Iterator iter = coll.iterator();
       
        while(iter.hasNext()){
            System.out.println("Ganador del Sorteo = " + iter.next());
        }
    }
   
}
