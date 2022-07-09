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
       Cliente cl1 = new Cliente("0923547362","Juan","Lopez","lmancero","qwerty",TipoCliente.C,20,"21252369853125");
       
       cl1.reservarHospedaje();
       
       
        
    }
}
