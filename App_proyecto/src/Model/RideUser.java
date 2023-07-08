package Model;

import java.io.*;

public class RideUser {

    private int rideId;
    private String ubicacion;
    private String destino;
    private int costo;
    private String passengerName;

    public RideUser(){

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


    public void solicitarCarrera(String ubicacion, String destino, String passengerName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("carrera.txt"));
            writer.append(ubicacion + ' ' + destino + ' ' + passengerName + '\n');

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}