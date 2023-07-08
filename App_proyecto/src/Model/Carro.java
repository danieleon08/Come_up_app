package Model;

public class Carro extends Vehicle{
    private static final int COSTO_5MIN_CARRO = 500;

    public Carro(int idV, String placa, String marca, int modelo, String color, int capacidad){
        super(idV,placa,marca,modelo,color,capacidad);
    }

    @Override
    public String imprimirInfo(){
        return "Carro{" +
                "idV=" + idV +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo=" + modelo +
                ", color='" + color + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }

    public int definirtCostoPor5Minutos() {
        int costo = 0;
        if (modelo <= 2009) {
            costo = (COSTO_5MIN_CARRO + 200);
        }
        if (modelo > 2009 && modelo < 2017) {
            costo = (COSTO_5MIN_CARRO + 500);
        }
        if (modelo >= 2017) {
            costo = (COSTO_5MIN_CARRO + 1500);
        }
        return costo;
        }
    }