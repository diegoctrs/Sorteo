/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarealistas;

import conexionSQL.QueryBusqueda;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class TareaListas {

    public void menu(){
        QueryBusqueda query = new QueryBusqueda();
        
        Scanner s = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        
        while(!salir){
            
           System.out.println("1. Lista de Nombres Ordenados");
           System.out.println("2. Lista de Ganadores del Sorteo");
           System.out.println("3. Salir del Programa");
            
           System.out.println("Escribe una de las opciones");
           opcion = s.nextInt();
           
           try{
           
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado Lista de Nombres Ordenados");
                        query.BusquedaOrden();
                        break;
                    case 2:
                        System.out.println("Has seleccionado Lista de Ganadores del Sorteo");
                        query.BusquedaSorteo();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e);
                s.next();
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        new TareaListas().menu();
    }
    
}
