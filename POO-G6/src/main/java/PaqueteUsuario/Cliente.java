/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteUsuario;

import Enums.Estado;
import Enums.TipoCliente;
import Enums.TransmisionV;
import PaqueteServicio.Entretenimiento;
import PaqueteServicio.Vehiculo;
import Datos.Pago;
import Datos.Reserva;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Joshua
 */
public class Cliente extends Usuario {

    private Scanner sc = new Scanner(System.in);
    private TipoCliente tipoCliente;
    private int edad;
    private String nT_credito;

    public Cliente(String nCedula, String nombre, String apellido, String nombreUsuario, String contrasenia, String nCelular, TipoCliente tipoCliente, int edad, String nT_credito) {
        super(nCedula, nombre, apellido, nombreUsuario, contrasenia, nCelular);
        this.tipoCliente = tipoCliente;
        this.edad = edad;
        this.nT_credito = nT_credito;
    }

    //Metodos getters
    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public int getEdad() {
        return edad;
    }

    public String getNT_credito() {
        return nT_credito;
    }

    //Metodos setters
    public void setTipoCliente() {
        this.tipoCliente = tipoCliente;
    }

    public void setEdad() {
        this.edad = edad;
    }

    public void setNT_credito() {
        this.nT_credito = nT_credito;
    }

    @Override
    public void consultarReserva() {
        System.out.println("/*************SERVICIOS RESERVADOS*************/");
        System.out.println("/*                                            */");
        System.out.println("/**********************************************/");
        System.out.println();

        //Parte que se repite
        ArrayList<String> reservas = ManejoArchivos.LeeFichero("reservas.txt");
        for (int i = 1; i < reservas.size(); i++) {
            String[] informacion = reservas.get(i).split(",");
            if (informacion[3].equals(nombre + " " + apellido)) {
                System.out.println("Servicio: " + informacion[2]);
                if (informacion[2].toLowerCase().equals("entretenimiento")) {
                    System.out.print("Paquete: ");
                    System.out.println("null");
                }
                if (informacion[2].toLowerCase().equals("transporte")) {
                    System.out.print("Vehículo: ");
                    System.out.println("null");
                }
                if (informacion[2].toLowerCase().equals("hospedaje")) {
                    System.out.print("Hotel: ");
                    ArrayList<String> reserva = ManejoArchivos.LeeFichero("reservaHospedaje.txt");
                    for (int j = 1; j < reserva.size(); j++) {
                        String[] informacionReserva = reserva.get(j).split(",");
                        if (informacionReserva[0].equals(informacion[0])) {
                            if (informacionReserva[2].equals("Departamento")) {
                                System.out.println("Departamento");
                            } else {
                                System.out.println("Hotel");
                            }
                        }
                    }
                }
                System.out.println("Fecha Reserva: " + informacion[1]);
                System.out.println("Desde: " + informacion[4]);
                System.out.println("Hasta: " + informacion[5]);
                System.out.println("Pago: " + informacion[6]);

                System.out.println("/**********************************************/");
                System.out.println();
            }
        }

    }

    public void reservarHospedaje() {
        Reserva.actualizarReserva();
        System.out.println("/****************RESERVACION*****************/"
                + "\n/*                                          */"
                + "\n/********************************************/");
        boolean condition = false;
        while (!condition) {
            System.out.println("MM/dd/yyyy");
            System.out.print("Ingrese fecha de entrada: ");
            String fEntrada = sc.nextLine();
            System.out.print("Ingrese fecha de salida: ");
            String fSalida = sc.nextLine();
            //2022-01-03
            LocalDate f1 = LocalDate.parse(fEntrada, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            LocalDate f2 = LocalDate.parse(fSalida, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            Duration dd = Duration.between(f1.atStartOfDay(), f2.atStartOfDay());

            System.out.println("Que tipo de hospedaje busca?");
            System.out.println("1. Hotel");
            System.out.println("2. Despartamento");
            System.out.println();

            System.out.print("Elija una opción: ");
            int opcionHospedaje = sc.nextInt();
            System.out.println();

            System.out.print("Ingrese el nombre de la ciudad donde se alojará: ");
            String ciudad = sc.nextLine();
            System.out.println();
            if (opcionHospedaje == 1) {
                System.out.println("Estos son los hoteles disponibles: ");
                ArrayList<String> lineas = ManejoArchivos.LeeFichero("hoteles.txt");

                for (int i = 1; i < lineas.size(); i++) {
                    System.out.println(i + ") " + lineas.get(i).split(",")[2]);
                }

                System.out.println();
                System.out.print("Elija una opción: ");
                int opcionHotel = sc.nextInt();
                System.out.println();

                String[] informacion = lineas.get(opcionHotel).split(",");

                mostrarInformacion(informacion);

                //Elegido el hotel elegimos las habitaciones
                System.out.println("Habitaciones disponibles:");
                ArrayList<String> habitaciones = ManejoArchivos.LeeFichero("habitaciones.txt");
                ArrayList<String[]> habitacionesLibres = new ArrayList<>();
                String codigo = informacion[0];
                for (String habitacion : habitaciones) {
                    String[] cuartosInformacion = habitacion.split(",");
                    if (cuartosInformacion[0].equals(informacion[0])) {
                        if (cuartosInformacion[5].equals("DISPONIBLE")) {
                            habitacionesLibres.add(cuartosInformacion);
                            System.out.printf("%s - %s personas - %s %n", cuartosInformacion[1], cuartosInformacion[3], cuartosInformacion[2]);
                        }

                    }
                }
                if (!habitacionesLibres.isEmpty()) {
                    int index = (int) (Math.random() * habitacionesLibres.size());
                    String[] habitacionRandom = habitacionesLibres.get(index);
                    System.out.println("Se le ha elegido una habitación " + habitacionRandom[1] + " por " + dd.toDays() + " noches");
                    System.out.println("El costo por a pagar es de: " + (Float.parseFloat(habitacionRandom[2]) * dd.toDays()));
                    System.out.println();
                    sc.nextLine();
                    System.out.println("Desea reservar? ");
                    String resp = sc.nextLine();
                    if (resp.toLowerCase().equals("si")) {
                        System.out.println("Reserva realizada :)");
                        condition = true;
                        int numeroReserva = Reserva.aumentarContReserva();
                        String registro = String.format("%d,%s,Hospedaje,%s,%s,%s,%f,%s%n", numeroReserva, LocalDate.now(), nombre + " " + apellido, fEntrada, fSalida, (Float.parseFloat(habitacionRandom[2]) * dd.toDays()), ciudad);
                        ManejoArchivos.EscribirArchivo("reservas.txt", registro);
                        registro = String.format("%d,%s,%s,%f,%n", numeroReserva, informacion[0], habitacionRandom[1], (Float.parseFloat(habitacionRandom[2]) * dd.toDays()));
                        ManejoArchivos.EscribirArchivo("reservaHospedaje.txt", registro);
                    }
                    //else MandarAlMenu()
                } else {//No hay habitaciones libres en ese hotel, hay que elegir de nu nuevo
                    System.out.println("No hay habitaciones libres");
                    continue;
                }

            } else if (opcionHospedaje == 2) { //Departamento
                System.out.println("Estos son los departamentos disponibles: ");
                ArrayList<String> lineas = ManejoArchivos.LeeFichero("departamentos.txt");
                for (int i = 1; i < lineas.size(); i++) {
                    System.out.println(i + ") " + lineas.get(i).split(",")[2]);
                }

                System.out.println();
                System.out.print("Elija una opción: ");
                int opcionDepa = sc.nextInt();
                System.out.println();

                String[] informacion = lineas.get(opcionDepa).split(",");

                mostrarInformacion(informacion);

                //Elejido el departamento, no hay que mostrar habitaciones
                sc.nextLine();
                System.out.println("Se le ha elegido el departamento " + informacion[2] + "por " + dd.toDays() + " noches");
                System.out.print("Quiere registrarse Aquí? ");
                String resp = sc.nextLine();
                if (resp.toLowerCase().equals("si")) {
                    condition = true;
                    int numeroReserva = Reserva.aumentarContReserva();
                    String registro = String.format("%d,%s,Hospedaje,%s,%s,%s,%f,%s%n", numeroReserva, LocalDate.now(), nombre + " " + apellido, fEntrada, fSalida, (Float.parseFloat(informacion[1]) * dd.toDays()), ciudad);
                    ManejoArchivos.EscribirArchivo("reservas.txt", registro);
                    registro = String.format("%d,%s,Departamento,%f,%n", numeroReserva, informacion[0], (Float.parseFloat(informacion[1]) * dd.toDays()));
                    ManejoArchivos.EscribirArchivo("reservaHospedaje.txt", registro);

                }
                //else mandarAlMenu();
            }
            sc.close();
        }
    }

    public void reservarTransporte() {
        Reserva.actualizarReserva();
        System.out.println("/****************RESERVACION*****************/"
                + "\n/*                                          */"
                + "\n/********************************************/");
        boolean condicion = false;
        while (!condicion) {
            System.out.println("Ingrese fecha en formato yyyy-mm-dd");
            System.out.print("Ingrese la fecha de inicio de reserva del vehículo: ");
            String FechaInicio = sc.nextLine();
            System.out.print("Ingrese la fecha de fin de reserva del vehículo: ");
            String FechaFin = sc.nextLine();
            System.out.print("Ingrese la capacidad del vehículo: ");
            String capacidad = sc.nextLine();
            ArrayList<String> vehiculos = ManejoArchivos.LeeFichero("vehiculos.txt");
            System.out.println("---------------Vehículos Disponibles----------------");
            for (int i = 1; i < vehiculos.size(); i++) {
                if (capacidad.equals(vehiculos.get(i).split(",")[5]) && Estado.DISPONIBLE.toString().equals((vehiculos.get(i).split(",")[6]))) {
                    System.out.println(i + ")" + vehiculos.get(i).replace(",", "|"));
                }
            }

            System.out.print("Escoja el literal deseado: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            System.out.println("************************************************************");
            System.out.println("Usted ha escogido el vehiculo: " + vehiculos.get(opcion));
            System.out.print("¿Desea Reservar?\n1) Si\n2) No\nSeleccione una opcion:");
            int op = sc.nextInt();
            sc.nextLine();
            //Creacion del reservasTransporte.txt
            if (op == 1) {
                int numeroReserva = Reserva.aumentarContReserva();
                String codigoV = vehiculos.get(opcion).split(",")[0];
                String valorxdia = vehiculos.get(opcion).split(",")[7];
                String ciudad = vehiculos.get(opcion).split(",")[9];

                LocalDate fechaIni = LocalDate.parse(FechaInicio);
                LocalDate fechaFin = LocalDate.parse(FechaFin);
                int diasOcupacion = fechaFin.getDayOfYear() - fechaIni.getDayOfYear();
                double valorxdia_conv = Double.parseDouble(valorxdia);
                double valorTotal = diasOcupacion * valorxdia_conv;

                System.out.println("/************RESERVA GENERADA****************/\n/*                                          */\n/********************************************/");
                Vehiculo v1 = new Vehiculo(codigoV, "", "", "", "", 0, Estado.DISPONIBLE,
                        valorxdia_conv, TransmisionV.MANUAL, String.valueOf(numeroReserva), valorTotal, 0, ciudad);
                v1.mostrarDatosReserva();

                ManejoArchivos.EscribirArchivo("reservasTransporte.txt", numeroReserva + "," + codigoV + "," + valorTotal);
                ManejoArchivos.EscribirArchivo("reservas.txt", numeroReserva + "," + LocalDate.now() + ","
                        + "transporte" + "," + nombre + " " + apellido + "," + FechaInicio + "," + FechaFin + "," + valorTotal
                        + "," + ciudad);

                //Volver a reservar
                System.out.println("*************************************************");
                System.out.println("¿Desea reservar otro vehículo?");
                System.out.print("1) Si\n2) No\nSeleccione una opcion:");
                int otraReserva = sc.nextInt();
                sc.nextLine();
                if (otraReserva == 2) {
                    //Finalizar la reserva
                    condicion = true;

                }

            } else {
                //Regresar al menú principal
            }

        }
    }

    public void ReservarEntretenimiento() {
        Reserva.actualizarReserva();
        System.out.println("/****************RESERVACION*****************/"
                + "\n/*                                          */"
                + "\n/********************************************/");
        boolean condicion = false;
        boolean encontrarPaquete = false;
        while (!condicion) {
            System.out.print("Ingrese el nombre de la ciudad donde se alojará: ");
            String ciudadEnt = sc.nextLine();
            System.out.print("Ingrese el número de personas que asistirán: ");
            int numero_persona = sc.nextInt();
            sc.nextLine();
            System.out.println("Paquetes Entretenimiento");
            System.out.println("*********************************************************************");
            ArrayList<String> entretenimientos = ManejoArchivos.LeeFichero("entretenimiento.txt");
            for (int i = 1; i < entretenimientos.size(); i++) {
                if (entretenimientos.get(i).split(";")[0].equals(ciudadEnt)) {
                    System.out.println(i + "." + entretenimientos.get(i).split(";")[1]);
                    encontrarPaquete = true;
                } else {
                    System.out.println("No se encontraron paquetes para la ciudad indicada.");
                    break;
                    //Hacer volver al menu principal.
                }

            }
            if (encontrarPaquete) {
                System.out.print("Elija una opción para conocer más: ");
                int opcion = sc.nextInt();
                sc.nextLine();
                System.out.println("*********************************************************************");
                System.out.println("Descripcion: " + entretenimientos.get(opcion).split(";")[2]);
                System.out.println("Costo por persona: " + entretenimientos.get(opcion).split(";")[3]);
                System.out.println("Salidas: " + entretenimientos.get(opcion).split(";")[4]);
                System.out.println("Fecha para realizar la ruta: " + entretenimientos.get(opcion).split(";")[5]);
                System.out.println("*********************************************************************");

                System.out.println("¿Desea reservar?"
                        + "\n 1) Si"
                        + "\n 2) No");
                System.out.print("Escoja una opcion: ");
                int validarReserva = sc.nextInt();
                sc.nextLine();
                if (validarReserva == 1) {
                    System.out.println("/************RESERVA GENERADA****************/"
                            + "\n/*                                          */"
                            + "\n/********************************************/");
                    int numeroReserva = Reserva.aumentarContReserva();
                    String FechaInicio_Fin = entretenimientos.get(opcion).split(";")[5];
                    String costo_persona = entretenimientos.get(opcion).split(";")[3];
                    double costo_persona_conv = Double.parseDouble(costo_persona);
                    double ValorPagar = numero_persona * costo_persona_conv;

                    Entretenimiento e = new Entretenimiento(FechaInicio_Fin,
                            entretenimientos.get(opcion).split(";")[1], Estado.DISPONIBLE,
                            String.valueOf(numeroReserva), ValorPagar, 0, ciudadEnt);
                    e.mostrarDatosReserva();
                    ManejoArchivos.EscribirArchivo("reservas.txt", numeroReserva + "," + LocalDate.now()
                            + ",entretenimiento," + nombre + " " + apellido + "," + FechaInicio_Fin + ","
                            + FechaInicio_Fin + "," + ValorPagar + "," + ciudadEnt);
                }
                System.out.println("********************************************************");
                System.out.println("¿Desea reservar otro paquete de entretenimiento?");
                System.out.print("1) Si\n2) No\nSeleccione una opcion:");
                int otraReserva = sc.nextInt();
                sc.nextLine();
                if (otraReserva == 2) {
                    //Finalizar la reserva
                    condicion = true;
                }
            } else {
                break;
                //Regresar al menú principal
            }
        }
    }
    
    public double PagarReserva(String nT_credito, String anio_venc, String mes_venc) {
        Pago.actualizarContPago();
        System.out.println("/**************PAGO DE RESERVA***************/"
                + "\n/*                                          */"
                + "\n/********************************************/");
        System.out.print("Ingrese el código de la reserva: ");
        String codigoReserva = sc.nextLine();
        ArrayList<String> reservas = ManejoArchivos.LeeFichero("reservas.txt");
        for (int i = 1; i < reservas.size(); i++) {
            if (reservas.get(i).split(",")[0].equals(codigoReserva)) {
                if (tipoCliente == TipoCliente.C) {
                    String valorPagar = reservas.get(i).split(",")[6];
                    double valorPagar_conv = Double.parseDouble(valorPagar);
                    double valorTotalPagar = valorPagar_conv + (valorPagar_conv * 0.10);
                    int numeroPago = Pago.aumentarContPago();
                    System.out.println("¿Desea confirmar el pago?"
                            + "\n1) Si"
                            + "\n2) No");
                    int opcionpago = sc.nextInt();
                    sc.nextLine();
                    if (opcionpago == 1) {
                        System.out.println("El costo total del pago es: " + valorTotalPagar);

                        ManejoArchivos.EscribirArchivo("pagos.txt", reservas.get(i).split(",")[0] + ","
                                + numeroPago + "," + nombre + " " + apellido + "," + LocalDate.now() + ","
                                + valorPagar + "," + valorTotalPagar + ",TARJETA," + nT_credito + ","
                                + "(" + anio_venc + "/" + mes_venc + ")");
                        return valorTotalPagar;
                    } else {
                        //retornar al menú principal
                    }
                } else {
                    String valorPagar = reservas.get(i).split(",")[6];
                    double valorPagar_conv = Double.parseDouble(valorPagar);
                    double descuento = valorPagar_conv * 0.15;
                    double valorTotalPagar = (valorPagar_conv + (valorPagar_conv * 0.10)) - descuento;
                    int numeroPago = Pago.aumentarContPago();
                    System.out.println("¿Desea confirmar el pago?"
                            + "\n1) Si"
                            + "\n2) No");
                    System.out.println("Ingrese una opcion");
                    int opcionpago = sc.nextInt();
                    sc.nextLine();
                    if (opcionpago == 1) {
                        System.out.println("El costo total del pago es: " + valorTotalPagar);

                        ManejoArchivos.EscribirArchivo("pagos.txt", reservas.get(i).split(",")[0] + ","
                                + numeroPago + "," + nombre + " " + apellido + "," + LocalDate.now() + ","
                                + valorPagar + "," + valorTotalPagar + ",TARJETA," + nT_credito + ","
                                + "(" + anio_venc + "/" + mes_venc + ")");
                        return valorTotalPagar;
                    } else {
                        //Retornar al menu principal
                    }
                }
            } else {
                //Retornar al menú principal.
            }
        }
        return 0.0;
    }

    public double PagarReserva(String n_cheque) {
        Pago.actualizarContPago();
        System.out.println("/**************PAGO DE RESERVA***************/"
                + "\n/*                                          */"
                + "\n/********************************************/");
        System.out.print("Ingrese el código de la reserva: ");
        String codigoReserva = sc.nextLine();
        ArrayList<String> reservas = ManejoArchivos.LeeFichero("reservas.txt");
        for (int i = 1; i < reservas.size(); i++) {
            if (reservas.get(i).split(",")[0].equals(codigoReserva)) {
                if (tipoCliente == TipoCliente.C) {
                    String valorPagar = reservas.get(i).split(",")[6];
                    double valorPagar_conv = Double.parseDouble(valorPagar);
                    double valorTotalPagar = valorPagar_conv + (valorPagar_conv * 0.10);
                    int numeroPago = Pago.aumentarContPago();
                    System.out.println("¿Desea confirmar el pago?"
                            + "\n1) Si"
                            + "\n2) No");
                    int opcionpago = sc.nextInt();
                    sc.nextLine();
                    if (opcionpago == 1) {
                        LocalDate fechaActual = LocalDate.now();
                        LocalDate fechaCaducidad = fechaActual.plusDays(1);

                        System.out.println("El costo total del pago es: " + valorTotalPagar);

                        ManejoArchivos.EscribirArchivo("pagos.txt", reservas.get(i).split(",")[0] + ","
                                + numeroPago + "," + nombre + " " + apellido + "," + fechaActual + ","
                                + valorPagar + "," + valorTotalPagar + ",CHEQUE," + nT_credito + ","
                                + fechaCaducidad);

                        System.out.println("AVISO: Debe depositar el cheque en las proximas 24 horas o"
                                + " de lo contrario su pago no será válido y la reserva no será considerada.");
                    } else {
                        //Regresar al menú principal
                    }
                } else {
                    String valorPagar = reservas.get(i).split(",")[6];
                    double valorPagar_conv = Double.parseDouble(valorPagar);
                    double descuento = valorPagar_conv * 0.15;
                    double valorTotalPagar = (valorPagar_conv + (valorPagar_conv * 0.10)) - descuento;
                    int numeroPago = Pago.aumentarContPago();
                    System.out.println("¿Desea confirmar el pago?"
                            + "\n1) Si"
                            + "\n2) No");
                    System.out.print("Ingrese una opcion: ");
                    int opcionpago = sc.nextInt();
                    sc.nextLine();
                    if (opcionpago == 1) {
                        LocalDate fechaActual = LocalDate.now();
                        LocalDate fechaCaducidad = fechaActual.plusDays(1);
                        System.out.println("El costo total del pago es: " + valorTotalPagar);

                        ManejoArchivos.EscribirArchivo("pagos.txt", reservas.get(i).split(",")[0] + ","
                                + numeroPago + "," + nombre + " " + apellido + "," + fechaActual + ","
                                + valorPagar + "," + valorTotalPagar + ",CHEQUE," + nT_credito + ","
                                + fechaCaducidad);

                        System.out.println("AVISO: Debe depositar el cheque en las proximas 24 horas o"
                                + " de lo contrario su pago no será válido y la reserva no será considerada.");
                    } else {
                        //Retornar al menu principal
                    }
                }
            } else {
                //Retornar al menú principal.
            }
        }
        return 0.1f;
    }

    private void mostrarInformacion(String[] informacion) {
        //código,Costo,nombre,rating,dirección,incluye desayuno,incluye parqueo,permite cancelación gratis
        System.out.println("Datos de " + informacion[2]);
        System.out.println();
        System.out.println("/**********************/");
        System.out.println("Dirección: " + informacion[4]);
        System.out.println("Costo por noche: " + informacion[1]);
        System.out.println("Incluye Desayuno: " + informacion[5]);
        System.out.println("Incluye Parqueo: " + informacion[6]);
        System.out.println("Permite cancelación gratis: " + informacion[7]);
        System.out.println("/**********************/");
        System.out.println();
    }

    @Override
    public String toString() {
        return nombreUsuario + " " + contrasenia;
    }
}
