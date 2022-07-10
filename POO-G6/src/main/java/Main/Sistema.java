/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import PaqueteUsuario.ManejoArchivos;
import PaqueteUsuario.Usuario;
import PaqueteUsuario.Cliente;
import PaqueteUsuario.Administrador;
import java.util.Scanner;
import Enums.TipoCliente;
import java.util.ArrayList;

/**
 *
 * @author Gerson
 */
public class Sistema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        
                
        ArrayList<String> usuarios1 = ManejoArchivos.LeeFichero("usuarios.txt");
        ArrayList<String> clientes = ManejoArchivos.LeeFichero("clientes.txt");
        
        
        for (int i = 1; i<usuarios1.size(); i++){
            if (!usuarios1.get(i).split(",")[6].equals("A")) {
                String[] datosU = usuarios1.get(i).split(",");
                for (int j = 1; j<clientes.size(); j++) {
                    String[] datosC = clientes.get(j).split(",");
                    if (datosU[0].equals(datosC[0])) {
                        usuarios.add(new Cliente(datosU[0],datosU[1],datosU[2],datosU[3],datosU[4],datosU[5],TipoCliente.valueOf(datosU[6]),Integer.parseInt(datosC[1]),datosC[2]));
                    }
                }
            } else {
                String[] datosU = usuarios1.get(i).split(",");
                usuarios.add(new Administrador(datosU[0],datosU[1],datosU[2],datosU[3],datosU[4],datosU[5]));
            }
        }
        
//         System.out.println(usuarios);
 

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

                    for (int i = 0; i < usuarios.size(); i++) {
                        if (usuarios.get(i).getNombreUsuario().equals(user) && usuarios.get(i).getContrasenia().equals(contrasenia)) {
                            if (usuarios.get(i) instanceof Cliente) {
                                Cliente c = (Cliente) usuarios.get(i);
                                if (c.getTipoCliente().equals(TipoCliente.C) || c.getTipoCliente().equals(TipoCliente.V)) {
                                    System.out.println("Bienvenido cliente " + c.getNombre() + " " + c.getApellido() + ".");
                                    System.out.println("1. Reservar hospedaje");
                                    System.out.println("2. Reservar transporte");
                                    System.out.println("3. Reservar entretenimiento");
                                    System.out.println("4. Pagar Reserva");
                                    System.out.println("5. Consultar reservas");
                                    System.out.println("6. Salir");
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
                                                String cheque = sc.nextLine();
                                                c.PagarReserva(cheque);
                                            } else {
                                                System.out.print("Ingrese su número de tarjeta: ");
                                                String nt = sc.nextLine();
                                                System.out.print("Ingrese año de vencimiento: ");
                                                String anioV = sc.nextLine();
                                                System.out.print("Ingrese mes de vencimiento: ");
                                                String mesV = sc.nextLine();
                                                c.PagarReserva(nt,anioV,mesV);
                                            }
                                            break;
                                        case "5":
                                            c.consultarReserva();
                                        case "6":
                                            break;
                                    }
                                }
                            } else if (usuarios.get(i) instanceof Administrador) {
                                Administrador a = (Administrador) usuarios.get(i);
                                System.out.println("Bienvenido administrador " + a.getNombre() + " " + a.getApellido() + ".");
                                System.out.println("1. Consultar Reservas");
                                System.out.println("2. Salir");
                                System.out.print("Ingrese su opción: ");
                                String op = sc.nextLine();
                                switch (op){
                                    case "1":
                                        a.consultarReserva();
                                        break;
                                    case "2":
                                        break;
                                }
                            }
                        }
                    }
                    System.out.println("Usuario no encontrado");
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
                if(usuarios.add(new Cliente(nCedula,nombre,apellido,nUsuario,contrasenia,celular,TipoCliente.valueOf(tipoCliente),Integer.parseInt(edad),nTCredito))){
                    System.out.println("Se registró su usuario con éxito");
                }
                break;
                
            case "3":
                System.out.println("Gracias por su atención.");
                break;

            default:
                break;
        }
    }
}
