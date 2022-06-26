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
    protected String contrasenia;
    
    public Usuario(String nCedula, String nombre, String apellido, String nombreUsuario, String contrasenia){
        this.nCedula = nCedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }
    
    //Metodos getters
    public String getNCedula(){return nCedula;}
    public String getNombre(){return nombre;}
    public String getApellido(){return apellido;}
    public String getNombreUsuario(){return nombreUsuario;}
    public String getContrasenia(){return contrasenia;}
    
    //Metodos setters
    public void setNCedula(String nCedula){this.nCedula = nCedula;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setApellido(String apellido){this.apellido = apellido;}
    public void setNombreUsuario(String nombreUsuario){this.nombreUsuario = nombreUsuario;}
    public void setContraseñia(String contrasenia){this.contrasenia = contrasenia;}
    
    
    public abstract void consultarReserva();
    
}
