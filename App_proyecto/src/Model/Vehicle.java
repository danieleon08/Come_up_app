package Model;

public abstract class Vehicle {

	protected int idV;
	protected String placa;
	protected String marca;
	protected int modelo;
	protected String color;
	protected int capacidad;
	
	public Vehicle() {

	}
	public int definirNivel(){
		int nivel = 0;

		if(modelo <= 2009){
			nivel=1;
		}
		else if(modelo < 2018){
			nivel=2;
		}
		else {
			nivel=3;
		}
		return nivel;
	}

	public abstract String imprimirInfo();
	public abstract int definirtCostoPor5Minutos();

	public Vehicle(int idV, String placa, String Marca, int modelo, String color, int capacidad) {
		this.idV=idV;
		this.placa=placa;
		this.marca = Marca;
		this.modelo=modelo;
		this.color=color;
		this.capacidad=capacidad;

	}

	public int getIdV() {
		return idV;
	}
	public void setIdV(int idV) {
		this.idV = idV;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getModelo() {
		return modelo;
	}
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
}