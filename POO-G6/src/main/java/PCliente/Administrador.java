/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PCliente;

import java.util.ArrayList;

/**
 *
 * @author Gerson
 */
public class Administrador extends Usuario{
    
    /**
     * Administrador recibe primero el # de cédula luego el nombre, apellido, usuario, y contraseña.
     * @param nCedula
     * @param nombre
     * @param apellido
     * @param nombreUsuario
     * @param contrasenia 
     */
    
    public Administrador(String nCedula, String nombre, String apellido, String nombreUsuario, String contrasenia, String nCelular){
        super(nCedula, nombre, apellido, nombreUsuario, contrasenia, nCelular);
    }
        /**
     * Consultar el total de reservas por ciudad y el total general
     */
    public void consultarReserva() {
        System.out.println("""
                           /****************Resumen de Servicios Reservados*****************/
                           /*                                                              */
                           /****************************************************************/""");
        ArrayList<String> ciudades = new ArrayList<>(); //ArrayList vacio donde agregaré todas las ciudades en dónde existen reservas
        ArrayList<String> reservas = ManejoArchivos.LeeFichero("reservas.txt"); //lee el archivo de todas las reservas

        for (int i = 1; i < reservas.size(); i++) {

            String verificaCiudad = reservas.get(i).split(",")[7];//
            if (!ciudades.contains(verificaCiudad)) {
                ciudades.add(verificaCiudad);
            }
        }
        int sumandoR = 0;
        for (int j = 0; j < ciudades.size(); j++) {
            
            System.out.println("********************" + ciudades.get(j) + "********************");
            int contRE = 0;
            int contRH = 0;
            int contRT = 0;
            for (int i = 1; i < reservas.size(); i++) {
                
                if (ciudades.get(j).equals(reservas.get(i).split(",")[7])) {
                    if (reservas.get(i).split(",")[2].equals("transporte")) {
                        contRT++;
                    } else if (reservas.get(i).split(",")[2].equals("entretenimiento")) {
                        contRE++;
                    }else if (reservas.get(i).split(",")[2].equals("hospedaje")){
                        contRH++;
                    }
                }
            }
            System.out.println("Entretenmientos reservados: "+contRE);
            System.out.println("Hospedajes reservados: "+contRH);
            System.out.println("Transportes reservados: "+contRT);
            sumandoR+=contRE+contRH+contRT;
        }
        System.out.println("***************************************");
        System.out.println("Reservas totales: "+sumandoR);
        
    }
    
}
