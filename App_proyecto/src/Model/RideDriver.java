package Model;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class RideDriver {

    private int rideId;
    private String ubicacion;
    private String destino;
    private int costo;
    private String passengerName;

    public RideDriver(){

    }
    public RideDriver(int rideId, String ubicacion, String destino, int costo, String passengerName) {
        this.rideId = rideId;
        this.ubicacion = ubicacion;
        this.destino = destino;
        this.costo = costo;
        this.passengerName = passengerName;
    }
    public int getRideId(){
        return rideId;
    }

    public void setRideId(int rideId){
        this.rideId=rideId;
    }

    public String getUbicacion(){
        return ubicacion;
    }

    public void setUbicacion(String ubicacion){
        this.ubicacion=ubicacion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getDestino(){
        return destino;
    }

    public void setDestino(String destino){
        this.destino=destino;
    }

    public String getPassengerName(){
        return passengerName;
    }

    public void setPassengerName(String passengerName){
        this.passengerName=passengerName;
    }



    public static void recibirCarrera(Driver driver){
        Random random = new Random();
        int rideId = random.nextInt(100);
        int costo = 10000;
        try{
            File archivo = new File("carrera.txt");
            Scanner lector = new Scanner(archivo);

            while (lector.hasNextLine()) {

                String linea = lector.nextLine();
                Scanner scannerLinea = new Scanner(linea);
                scannerLinea.useDelimiter(" ");
                String ubicacion = scannerLinea.next();
                String destino = scannerLinea.next();
                String passengerName = scannerLinea.next();
                        if(driver.getPerfil().getLocalidad().equals(ubicacion)){
                            RideDriver ride = new RideDriver(rideId,ubicacion,destino,costo,passengerName);
                            driver.getCarrerasPendientes().add(ride);
                        }
            }
            lector.close();
        }
        catch (Exception e){
            System.out.println("No se pudo leer el archivo.");
        }
    }
}
/*while (scanner.hasNextLine()) {
        String linea = scanner.nextLine();
        Scanner scannerLinea = new Scanner(linea);
        scannerLinea.useDelimiter(",");
        // Aquí procesamos los tokens de la línea
        }

        while (scanner.hasNextLine()) {
    String linea = scanner.nextLine();
    Scanner scannerLinea = new Scanner(linea);
    scannerLinea.useDelimiter(",");
    String nombre = scannerLinea.next();
    int edad = scannerLinea.nextInt();
    String pais = scannerLinea.next();
    // Aquí hacemos algo con los tokens leídos
}*/