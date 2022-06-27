/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PCliente;
import Enums.TipoCliente;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Joshua
 */
public class Cliente extends Usuario{
    private Scanner sc = new Scanner(System.in);
    
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
        System.out.print("Ingrese fecha de entrada: ");
        String fEntrada = sc.nextLine();
        System.out.print("Ingrese fecha de salida: ");
        String fSalida = sc.nextLine();
        
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
            
            System.out.println();
            //Elegido el hotel elegimos las habitaciones
            System.out.println("Habitaciones disponibles:");
            ArrayList<String> habitaciones = ManejoArchivos.LeeFichero("habitaciones.txt");
            for(String habitacion: habitaciones){
                String[] cuartosInformacion=habitacion.split(",");
                if(cuartosInformacion[5].equals("DISPONIBLE")){
                    System.out.printf("%s - %s - %s",cuartosInformacion[1],cuartosInformacion[3],cuartosInformacion[2]);
                }
            }
            
            
        }
        else if(opcionHospedaje==2){
            System.out.println("Estos son los departamentos disponibles: ");
            ArrayList<String> lineas = ManejoArchivos.LeeFichero("departamentos.txt");
            for(int i=1; i<lineas.size();i++){
                System.out.println(i+") "+lineas.get(i).split(",")[1]);
            }
            
            System.out.println();
            System.out.print("Elija una opción: ");
            int opcionDepa = sc.nextInt();
            System.out.println();
            
            String[] informacion = lineas.get(opcionDepa).split(",");
            
            mostrarInformacion(informacion);
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
        System.out.println("Datos de "+informacion[1]);
        System.out.println();
        System.out.println("/**********************/");
        System.out.println("Dirección: "+informacion[4]);
        System.out.println("Costo por noche: "+ informacion[1]);
        System.out.println("Incluye Desayuno: "+ informacion[5]);
        System.out.println("Incluye Parqueo: "+informacion[6]);
        System.out.println("Permite cancelación gratis: "+informacion[7]);
        System.out.println("/**********************/");
    }
}
