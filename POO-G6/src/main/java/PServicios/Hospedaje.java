/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PServicios;

/**
 *
 * @author Dell
 */
public class Hospedaje extends Servicio{
    protected String FechaEntrada;
    protected String FechaSalida;
    
    public Hospedaje(String FechaEntrada, String FechaSalida, String identificador,double valorPagar,int puntuacion, String ciudad_reserva){
        super(identificador,valorPagar,puntuacion,ciudad_reserva);
        this.FechaEntrada = FechaEntrada;
        this.FechaSalida = FechaSalida;
    }
    
    public String getFechaEntrada(){
        return FechaEntrada;
    }
    public void setFechaEntrada(String FechaEntrada){
        this.FechaEntrada = FechaEntrada;
    }
    public String getFechaSalida(){
        return FechaSalida;
    }
    public void setFechaSalida(String FechaSalida){
        this.FechaSalida = FechaSalida;
    }
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("");
    }
}
