package Model;

public class Moto extends Vehicle{
    private static final int COSTO_5MIN_MOTO=200;

    public Moto(int idV, String placa, String marca, int modelo, String color, int capacidad){
        super(idV,placa,marca,modelo,color,capacidad);
    }

    @Override
    public String imprimirInfo(){
        return "Moto{" +
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
            costo = (COSTO_5MIN_MOTO + 200);
        }
        if (modelo > 2009 && modelo < 2017) {
            costo = (COSTO_5MIN_MOTO + 500);
        }
        if (modelo >= 2017) {
            costo = (COSTO_5MIN_MOTO+ 1500);
        }
        return costo;
    }
}
