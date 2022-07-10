/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteServicio;
import Enums.TipoHabitacion;
import Enums.Estado;
/**
 *
 * @author Dell
 */
public class Habitacion {
    private TipoHabitacion habitacion;
    private double precio;
    private int capacidad;
    private String n_habitacion;
    private Estado estado;
    
    public Habitacion(TipoHabitacion habitacion, double precio, int capacidad, String n_habitacion, Estado estado){
        this.habitacion = habitacion;
        this.precio = precio;
        this.capacidad = capacidad;
        this.n_habitacion = n_habitacion;
        this.estado = estado;
        
    }
}
