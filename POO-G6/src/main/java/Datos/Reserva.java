/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import Enums.TipoCliente;
import PaqueteServicio.Servicio;
import PaqueteUsuario.Cliente;
import PaqueteUsuario.ManejoArchivos;
import java.util.ArrayList;
/**
 *
 * @author Gerson
 */
public class Reserva {
    private String nReserva;
    private String fecha;
    private Servicio tServicio;
    private TipoCliente cliente;
    protected static int contReserva;

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
    
    public static int aumentarContReserva(){
        contReserva+=1;
        return contReserva;
    }
    
    public static void actualizarReserva(){
        ArrayList<String> reservas= ManejoArchivos.LeeFichero("reservas.txt");
        for(int i=1;i<reservas.size();i++){
            if(!reservas.get(i).split(",")[0].equals("")){
                contReserva = Integer.parseInt(reservas.get(i).split(",")[0]);
            }
        }
    }
    
}
