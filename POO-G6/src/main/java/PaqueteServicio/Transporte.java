/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteServicio;

/**
 *
 * @author Dell
 */
public class Transporte {
    
    private Vehiculo vehiculo;    
    
    public Transporte(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }
    
    public Vehiculo getvehiculo(){
        return vehiculo;
    }
    public void setvehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }
}
