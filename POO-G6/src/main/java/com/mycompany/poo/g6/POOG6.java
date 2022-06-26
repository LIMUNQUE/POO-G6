/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.poo.g6;
import PCliente.Cliente;
import Enums.TipoCliente;
/**
 *
 * @author Joshua
 */
public class POOG6 {
public static void main(String[] args) {
        Cliente cl1 = new Cliente("0909","Juan","Torres","aaa","123",TipoCliente.C,18,"55");
        cl1.consultarReserva();
        
    }
}
