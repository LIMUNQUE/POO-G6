/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteServicio;

import Enums.Estado;

/**
 *
 * @author Dell
 */
public class Entretenimiento extends Servicio{
    private String dias;
    private String descripcion;
    private Estado estado;
    
    public Entretenimiento(String dias, String descripcion, Estado estado, String identificador,
            double valorPagar,int puntuacion, String ciudad_reserva){
        super(identificador,valorPagar,puntuacion,ciudad_reserva);
        this.dias = dias;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    
    public String getdias(){
        return dias;
    }
    public void setdias(String dias){
        this.dias = dias;
    }
    public String getdescripcion(){
        return descripcion;
    }
    public void setdescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public Estado getestado(){
        return estado;
    }
    public void setestado(Estado estado){
        this.estado = estado;
    }
    
    
    @Override
    public void mostrarDatosReserva(){
        super.mostrarDatosReserva();
        System.out.println("TIPO RESERVA: ENTRETENIMIENTO\nFecha: "+dias+"\nPAQUETE: "+descripcion);
    }
}
