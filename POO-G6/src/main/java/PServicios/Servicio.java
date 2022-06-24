/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PServicios;

/**
 *
 * @author Joshua
 */
public class Servicio {
    protected String identificador;
    protected double valorPagar;
    protected int puntuacion;
    protected String ciudad_reserva;
    
    public Servicio(String identificador,double valorPagar,int puntuacion, String ciudad_reserva){
        this.identificador = identificador;
        this.valorPagar = valorPagar;
        this.puntuacion = puntuacion;
        this.ciudad_reserva = ciudad_reserva;
    }
    
    public String getidentificador(){
        return identificador;
    }
    public void setifentificador(String identificador){
        this.identificador = identificador;
    }
    public double getvalorPagar(){
        return valorPagar;
    }
    public void setvalorPagar(double valorPagar){
        this.valorPagar = valorPagar;
    }
    public int getpuntuacion(){
        return puntuacion;
    }
    public void setpuntuacion(int puntuacion){
        this.puntuacion = puntuacion;
    }
    public String getciudad_reserva(){
        return ciudad_reserva;
    }
    public void setciudad_reserva(String ciudad_reserva){
        this.ciudad_reserva = ciudad_reserva;
    }
    
    public void mostrarDatos(){
        System.out.println("");
    }
}
