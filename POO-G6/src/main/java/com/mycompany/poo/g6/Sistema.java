/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo.g6;

import java.util.Scanner;
import PCliente.*;
import Enums.TipoCliente;
import java.util.ArrayList;

/**
 *
 * @author Joshua
 */
public class Sistema {

    private ArrayList<Usuario> usuarios;

    public void cargarSistema() {
        ArrayList<String> usuarios1 = ManejoArchivos.LeeFichero("usuarios.txt");
        ArrayList<String> clientes = ManejoArchivos.LeeFichero("clientes.txt");

        for (int i = 1; i < usuarios1.size(); i++) {
            for (int x = 1; x < clientes.size(); x++) {

                String[] datosU = usuarios1.get(i).split(",");
                String[] datosC = clientes.get(x).split(",");

                int edad = Integer.parseInt(datosC[1]);
                
                if (datosU[0].equals(datosC[0])) {
                    if (TipoCliente.valueOf(datosU[6]) == TipoCliente.C || TipoCliente.valueOf(datosU[6]) == TipoCliente.V) {

                        usuarios.add(new Cliente(datosU[0], datosU[1], datosU[2], datosU[3], datosU[4], TipoCliente.valueOf(datosU[6]), edad, datosC[2]));

                    }
                }

            }
        }
    }

    

    public static void main(String[] args) {

        Sistema s = new Sistema();
        s.usuarios = new ArrayList<>();
        s.cargarSistema();

        Scanner sc = new Scanner(System.in);

        System.out.println(""
                + "+++++++++++++++++++++++++++++++++++++++++++++"
                + "            BIENVENIDO AL SISTEMA            "
                + "+++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("1 : Iniciar sesión");
        System.out.println("2 : Registrarse");
        System.out.println("3 : Salir");
        System.out.print("Ingrese su opción: ");
        String o = sc.nextLine();
        String seguir = "S";
        switch (o) {
            case "1":
                while (seguir.equals("S")) {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.print("Ingrese su usuario: ");
                    String user = sc.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    String contrasenia = sc.nextLine();

                    for (int i = 0; i < s.usuarios.size(); i++) {
                        if (s.usuarios.get(i).getNombreUsuario().equals(user) && s.usuarios.get(i).getContrasenia().equals(contrasenia)) {
                            if (s.usuarios.get(i) instanceof Cliente) {
                                Cliente c = (Cliente) s.usuarios.get(i);
                                if (c.getTipoCliente().equals(TipoCliente.C)) {
                                    System.out.println("Bienvenido " + c.getNombre() + " " + c.getApellido() + " cliente estándar.");
                                    System.out.println("1. Reservar hospedaje");
                                    System.out.println("2. Reservar transporte");
                                    System.out.println("3. Reservar entretenimiento");
                                    System.out.println("4. Pagar Reserva");
                                    System.out.println("5. Consultar reservas");
                                    System.out.println("5. Salir");
                                    System.out.print("Ingrese el número de su opción: ");
                                    String op = sc.nextLine();
                                    switch (op){
                                        case "1":
                                            c.reservarHospedaje();
                                            break;
                                        case "2":
                                            c.reservarTransporte();
                                            break;
                                        case "3":
                                            c.ReservarEntretenimiento();
                                            break;
                                        case "4":
                                            System.out.println("¿Desea pagar con tarjeta de crédito o cheque?");
                                            String pago = sc.nextLine();
                                            if (pago.equals("cheque")){
                                                System.out.print("Ingrese el número de cheque: ");
                                                int cheque = sc.nextInt();
                                                sc.nextLine();
                                                c.PagarReserva(cheque);
                                            } else {
                                                System.out.print("Ingrese su número de trajeta: ");
                                                String nt = sc.nextLine();
                                                System.out.print("Ingrese año de vencimiento: ");
                                                int anioV = sc.nextInt();
                                                sc.nextLine();
                                                System.out.print("Ingrese mes de vencimiento: ");
                                                int mesV = sc.nextInt();
                                                sc.nextLine();
                                                c.PagarReserva(nt,anioV,mesV);
                                            }
                                            
                                    }
                                    break;
                                } else if (c.getTipoCliente().equals(TipoCliente.V)) {
                                    System.out.println("Bienvenido " + c.getNombre() + " " + c.getApellido() + " cliente VIP.");
                                    break;
                                }
                            } else if (s.usuarios.get(i) instanceof Administrador) {
                                Administrador a = (Administrador) s.usuarios.get(i);
                                System.out.println("Bienvenido administrador" + a.getNombre() + " " + a.getApellido() + ".");
                                break;
                            }
                        } else {
                            System.out.println("Usuario no encontrado.");
                            break;
                        }
                    }
                    System.out.println("¿Desea seguir intentando? S/N");
                    seguir = sc.nextLine();
                }
                break;

            case "2":
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Ingrese los datos requeridos: ");
                System.out.print("Ingrese su número de cédula: ");
                String nCedula = sc.nextLine();
                System.out.print("Ingrese su nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese su apellido: ");
                String apellido = sc.nextLine();
                System.out.print("Ingrese su nombre de usuario: ");
                String nUsuario = sc.nextLine();
                System.out.print("Ingrese su contraseña: ");
                String contrasenia = sc.nextLine();
                System.out.print("Ingrese su número de celular: ");
                String celular = sc.nextLine();
                System.out.print("Ingrese el tipo de cliente que desea ser (Sólo existen 2 [C,V]):");
                String tipoCliente = sc.nextLine();
                System.out.print("Ingrese su edad: ");
                String edad = sc.nextLine();
                System.out.print("Ingrese su número de tarjeta de crédito: ");
                String nTCredito = sc.nextLine();
                String linea = nCedula + "," + nombre + "," + apellido + "," + nUsuario + "," + contrasenia + "," + celular + "," + tipoCliente + "\n";
                String linea1 =  nCedula + "," + edad + "," + nTCredito + "\n";
                ManejoArchivos.EscribirArchivo("usuarios.txt", linea);
                ManejoArchivos.EscribirArchivo("clientes.txt", linea1);
                if(s.usuarios.add(new Cliente(nCedula,nombre,apellido,nUsuario,contrasenia,TipoCliente.valueOf(tipoCliente),Integer.parseInt(edad),nTCredito))){
                    System.out.println("Se registró su usuario con éxito");
                }
                
            case "3":
                System.out.println("Gracias por su atención.");
                break;

            default:
                break;
        }
    }
}
