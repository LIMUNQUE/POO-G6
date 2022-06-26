/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PCliente;
import Enums.TipoCliente;
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
        
        System.out.println("Estos son los hoteles disponibles: ");
        String[] hoteles = {"Flore Hotel Boutique","Mansión Alcazar", "Four Points by Sheraton Cuenca", "Selina Cuenca", "Morenica del Rosario", "Hotel Presidente"};
        for (int i=0; i<hoteles.length;i++){
            System.out.println((i+1)+hoteles[i]);
        }
        System.out.println();
        
        System.out.print("Elija una opción: ");
        int opcionHotel = sc.nextInt();
        
        System.out.println();
        System.out.println("Datos de "+hoteles[opcionHotel]);
    }
    public void reservarHospedaje(){
        
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
}
