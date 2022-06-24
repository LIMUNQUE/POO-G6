/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PServicios;
import Enums.Estado;
/**
 *
 * @author Dell
 */
public class Departamento extends Hospedaje{
    private int n_habitacion;
    private boolean inc_wifi;
    private boolean inc_pisc;
    private Estado estado;
    
    public Departamento(int n_habitacion, boolean inc_wifi, boolean inc_pisc, 
            Estado estado,String FechaEntrada, String FechaSalida, String identificador,
            double valorPagar,int puntuacion, String ciudad_reserva){
        super(FechaEntrada,FechaSalida,identificador,valorPagar,puntuacion,ciudad_reserva);
        this.n_habitacion = n_habitacion;
        this.inc_wifi = inc_wifi;
        this.inc_pisc = inc_pisc;
        this.estado = estado;
    }
    
}
