/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PCliente;

/**
 *
 * @author Joshua
 */
public abstract class Usuario {
    
    protected String nCedula;
    protected String nombre;
    protected String apellido;
    protected String nombreUsuario;
    protected String contraseña;
    
    
    
    public abstract void consultarReserva();
    
}
