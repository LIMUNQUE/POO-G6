/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PServicios;

import Enums.Estado;
import Enums.TransmisionV;
/**
 *
 * @author Dell
 */
public class Vehiculo extends Servicio {
    private String marca;
    private String modelo;
    private String placa;
    private String color;
    private int capacidad;
    private Estado estado;
    private double valorxDia;
    private TransmisionV transmision;
    
    public Vehiculo(String marca, String modelo, String placa, String color, int capacidad, 
            Estado estado, double valorxDia, TransmisionV transmision, String identificador,
            double valorPagar,int puntuacion, String ciudad_reserva ){
        super(identificador,valorPagar,puntuacion,ciudad_reserva);
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.color = color;
        this.capacidad = capacidad;
        this.estado = estado;
        this.valorxDia = valorxDia;
        this.transmision = transmision;
    }
    
     public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public double getValorxDia() {
        return valorxDia;
    }
    public void setValorxDia(double valorxDia) {
        this.valorxDia = valorxDia;
    }
    public TransmisionV getTransmision() {
        return transmision;
    }
    public void setTransmision(TransmisionV transmision) {
        this.transmision = transmision;
    }
    
    @Override
    public void mostrarDatosReserva(){
        super.mostrarDatosReserva();
        System.out.println("TIPO RESERVA: TRANSPORTE\nCódigo vehiculo: "+placa+"\nCosto por día: "+valorxDia);
    }
}
