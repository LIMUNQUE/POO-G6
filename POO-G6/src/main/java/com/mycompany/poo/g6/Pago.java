/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.g6;

import PCliente.ManejoArchivos;
import java.util.ArrayList;

/**
 *
 * @author Gerson
 */
public class Pago {
    private String idPago;
    private double valorPagar;
    private String fechaPago;
    private double cancReserva;
    protected static int contPago;

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getCancReserva() {
        return cancReserva;
    }

    public void setCancReserva(double cancReserva) {
        this.cancReserva = cancReserva;
    }
    
    public static int aumentarContPago(){
        contPago +=1;
        return contPago;
    }
    
    public static void actualizarContPago(){
        ArrayList<String> pagos = ManejoArchivos.LeeFichero("pagos.txt");
        for(int i=1;i<pagos.size();i++){
            if(pagos.get(i).split(",")[1].equals("")){
                contPago = Integer.parseInt(pagos.get(i).split(",")[1]);
            }
        }
    }
    
    
}
