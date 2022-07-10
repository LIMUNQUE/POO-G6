/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteUsuario;

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
    protected String nCelular;
    /**
     * Creación de un usuario
     * @param nCedula el número de cedula
     * @param nombre el nombre del usuario
     * @param apellido el apellido del usuario
     * @param nombreUsuario el usuario ID con el que está registardo
     * @param contrasenia la contraseña para ingresar
     * @param nCelular su número de celular
     */
    public Usuario(String nCedula, String nombre, String apellido, String nombreUsuario, String contrasenia, String nCelular){
        this.nCedula = nCedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.nCelular = nCelular;
    }
    //Metodos getters
    public String getNCedula(){return nCedula;}
    public String getNombre(){return nombre;}
    public String getApellido(){return apellido;}
    public String getNombreUsuario(){return nombreUsuario;}
    public String getContrasenia(){return contrasenia;}
    public String getNCelular(){return nCelular;}
    //Metodos setters
    public void setNCedula(String nCedula){this.nCedula = nCedula;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setApellido(String apellido){this.apellido = apellido;}
    public void setNombreUsuario(String nombreUsuario){this.nombreUsuario = nombreUsuario;}
    public void setContrasenia(String contrasenia){this.contrasenia = contrasenia;}
    public void setNCelular(String nCelular){this.nCelular = nCelular;}
    
    /**
     * Método abstracto consultarReservas de usuario que se sobreescribirá en cliente y administrador
     */
    public abstract void consultarReserva();
    
}
