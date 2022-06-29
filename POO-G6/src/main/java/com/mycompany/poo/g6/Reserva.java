/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.g6;
import Enums.TipoCliente;
/**
 *
 * @author Gerson
 */
public class Reserva {
    private String nReserva;
    private String fecha;
    private Servicio tServicio;
    private TipoCliente cliente;
    private int contReserva;
    
    public void setnReserva(String nReserva){
        this.nReserva=nReserva;
    }
    
    public String getnReserva(){
        return nReserva;
    }
    
    public void setfecha(String fecha){
        this.fecha=fecha;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public void setTServicio(Servicio servicio){
        this.tServicio=servicio;
    }
    
    public Servicio getTServicio(){
        return tServicio;
    }
    
    public void setCliente(TipoCliente cliente){
        this.cliente=cliente;
    }
    
    public TipoCliente getCliente(){
        return cliente;
    }
    
    public void setContReserva(int reserva){
        this.contReserva=reserva;
    }
    
    public int getContReserva(){
        return contReserva;
    }
    
}
