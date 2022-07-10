/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteServicio;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Dell
 */
public class Hotel extends Hospedaje{
    private int h_identificador;
    private String nombre;
    private int rating;
    private String direccion;
    private boolean inc_Desayuno;
    private boolean inc_Parquep;
    private boolean free_cancel;
    private ArrayList<Habitacion> Habitaciones;
    
    public Hotel(int h_identificador, String nombre, int rating, String direccion, boolean inc_Desayuno, boolean inc_Parquep, boolean free_cancel,String FechaEntrada, String FechaSalida, String identificador,
            double valorPagar,int puntuacion, String ciudad_reserva){
        super(FechaEntrada,FechaSalida,identificador,valorPagar,puntuacion,ciudad_reserva);
        this.h_identificador = h_identificador;
        this.nombre = nombre;
        this.rating = rating;
        this.direccion = direccion;
        this.inc_Desayuno = inc_Desayuno;
        this.inc_Parquep = inc_Parquep;
        this.free_cancel = free_cancel;
    }
    
    
}
