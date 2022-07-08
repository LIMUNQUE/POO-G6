/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PCliente;

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
    
    public Administrador(String nCedula, String nombre, String apellido, String nombreUsuario, String contrasenia){
        super(nCedula, nombre, apellido, nombreUsuario, contrasenia);
    }
    
    public void consultarReserva(){
        System.out.println("/****************Resumen de Servicios Reservados*****************/"
                       + "\n/*                                                              */"
                       + "\n/****************************************************************/");
    }
    
}
