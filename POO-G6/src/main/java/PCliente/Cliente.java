/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PCliente;
import Enums.TipoCliente;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Joshua
 */
public class Cliente extends Usuario{
    private Scanner sc = new Scanner(System.in);
    private static int numeroReserva = 0;
    private TipoCliente tipoCliente;
    private int edad;
    private String nT_credito;
    
    public Cliente(String nCedula, String nombre, String apellido, String nombreUsuario, String contrasenia, TipoCliente tipoCliente, int edad, String nT_credito){
        super(nCedula, nombre, apellido, nombreUsuario, contrasenia);
        this.tipoCliente =tipoCliente;
        this.edad = edad;
        this.nT_credito = nT_credito;
    }
    
    //Metodos getters
    public TipoCliente getTipoCliente(){return tipoCliente;}
    public int getEdad(){return edad;}
    public String getNT_credito(){return nT_credito;}
    
    //Metodos setters
    public void setTipoCliente(){this.tipoCliente = tipoCliente;}
    public void setEdad(){this.edad = edad;}
    public void setNT_credito(){this.nT_credito = nT_credito;}
    

    public void consultarReserva(){
    }
    public void reservarHospedaje(){
        boolean condition=false;
        while(!condition){
            System.out.println("MM/dd/yyyy");
            System.out.print("Ingrese fecha de entrada: ");
            String fEntrada = sc.nextLine();
            System.out.print("Ingrese fecha de salida: ");
            String fSalida = sc.nextLine();
            //2022-01-03
            LocalDate f1= LocalDate.parse(fEntrada, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            LocalDate f2= LocalDate.parse(fSalida, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            Duration dd = Duration.between(f1.atStartOfDay(),f2.atStartOfDay());

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
            if(opcionHospedaje==1){
                System.out.println("Estos son los hoteles disponibles: ");
                ArrayList<String> lineas = ManejoArchivos.LeeFichero("hoteles.txt");

                for(int i=1; i<lineas.size();i++){
                    System.out.println(i+") "+lineas.get(i).split(",")[2]);
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
                String codigo=informacion[0];
                for(String habitacion: habitaciones){
                    String[] cuartosInformacion=habitacion.split(",");
                    if(cuartosInformacion[0].equals(informacion[0])){
                        if(cuartosInformacion[5].equals("DISPONIBLE")){
                            habitacionesLibres.add(cuartosInformacion);
                            System.out.printf("%s - %s personas - %s %n",cuartosInformacion[1],cuartosInformacion[3],cuartosInformacion[2]);
                        }

                    }
                }
                if(!habitacionesLibres.isEmpty()){
                    int index = (int)(Math.random()*habitacionesLibres.size());
                    String[] habitacionRandom = habitacionesLibres.get(index);
                    System.out.println("Se le ha elegido una habitación "+ habitacionRandom[1]+" por "+dd.toDays()+" noches");
                    System.out.println("El costo por a pagar es de: " + (Float.parseFloat(habitacionRandom[2])*dd.toDays()));
                    System.out.println();
                    sc.nextLine();
                    System.out.println("Desea reservar? ");
                    String resp = sc.nextLine();
                    if(resp.toLowerCase().equals("si")){
                        System.out.println("Reserva realizada :)");
                        condition = true;
                        numeroReserva=numeroReserva+1;
                        String registro =String.format("%b,%s,Hotel,%s,%f%n", numeroReserva,LocalDate.now(),nombre,(Float.parseFloat(habitacionRandom[2])*dd.toDays()));
                        ManejoArchivos.EscribirArchivo("reservas.txt", registro);
                    }
                    //else MandarAlMenu()
                }
                else{//No hay habitaciones libres en ese hotel, hay que elegir de nu nuevo
                    System.out.println("No hay habitaciones libres");
                    continue;
                }

            }
            else if(opcionHospedaje==2){ //Departamento
                System.out.println("Estos son los departamentos disponibles: ");
                ArrayList<String> lineas = ManejoArchivos.LeeFichero("departamentos.txt");
                for(int i=1; i<lineas.size();i++){
                    System.out.println(i+") "+lineas.get(i).split(",")[2]);
                }

                System.out.println();
                System.out.print("Elija una opción: ");
                int opcionDepa = sc.nextInt();
                System.out.println();

                String[] informacion = lineas.get(opcionDepa).split(",");

                mostrarInformacion(informacion);

                //Elejido el departamento, no hay que mostrar habitaciones
                sc.nextLine();
                System.out.println("Se le ha elegido el departamento "+informacion[2] +"por "+dd.toDays()+" noches");
                System.out.print("Quiere registrarse Aquí? ");
                String resp = sc.nextLine();
                if(resp.toLowerCase().equals("si")){
                        condition = true;
                        numeroReserva=numeroReserva+1;
                        String registro =String.format("%b,%s,Departamento,%s,%s%n", numeroReserva,LocalDate.now(),nombre,informacion[1]);
                        ManejoArchivos.EscribirArchivo("reservas.txt", registro);
                        
                }
                //else mandarAlMenu();
            }
            sc.close();
        }
    }
    
    
    
    
    
    
    
    public void reservarTransporte(){
        
    }
    public void ReservarEntretenimiento(){
        
    }
    public double PagarReserva(String nT_credito, int anio_venc, int mes_venc){
        return 0.1f;
    }
    public double PagarReserva(int n_cheque){
        return 0.1f;
    }
    
    private void mostrarInformacion(String[] informacion){
        //código,Costo,nombre,rating,dirección,incluye desayuno,incluye parqueo,permite cancelación gratis
        System.out.println("Datos de "+informacion[2]);
        System.out.println();
        System.out.println("/**********************/");
        System.out.println("Dirección: "+informacion[4]);
        System.out.println("Costo por noche: "+ informacion[1]);
        System.out.println("Incluye Desayuno: "+ informacion[5]);
        System.out.println("Incluye Parqueo: "+informacion[6]);
        System.out.println("Permite cancelación gratis: "+informacion[7]);
        System.out.println("/**********************/");
        System.out.println();
    }
}
