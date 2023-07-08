package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {
	
	private int id;
	private String username;
	private String password;
	private static final int LIMITE_VEHICULOS = 5;
	private ProfileDriver perfil;
	private List<Vehicle> vehiculos = new ArrayList<>();
	private Map<Integer, Vehicle> vehiculoById = new HashMap<>();
	private List<RideDriver> carrerasPendientes = new ArrayList<>();

	public ProfileDriver getPerfil() {
		return perfil;
	}

	public void setPerfil(ProfileDriver perfil) {
		this.perfil = perfil;
	}

	public void setVehiculos(List<Vehicle> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public void setVehiculoById(Map<Integer, Vehicle> vehiculoById) {
		this.vehiculoById = vehiculoById;
	}

	public void setCarrerasPendientes(List<RideDriver> carrerasPendientes) {
		this.carrerasPendientes = carrerasPendientes;
	}

	public Map<Integer, Vehicle> getVehiculoById() {
		return vehiculoById;
	}

	public List<RideDriver> getCarrerasPendientes() {
		return carrerasPendientes;
	}

	public Driver() {
		
	}
	
	public Driver(int id, String username, String password, ProfileDriver perfil) {
		this.id=id;
		this.username=username;
		this.password=password;
		this.perfil=perfil;
	}
	
	
	public void addVehiculo(int idV,String placa,String marca,int modelo,String color,int capacidad,int tipoVehiculo){
		if(modelo > 2023 && !marca.equals("deLorean")) {
			throw new IllegalArgumentException("El modelo no puede estar en el futuro (a menos que sea un deLorean)");
		}
		if(modelo < 1985 && !marca.equals("deLorean")) {
			throw new IllegalArgumentException("El modelo no puede estar en el futuro (a menos que sea un deLorean)");
		}
		if(vehiculoById.size()> LIMITE_VEHICULOS) {
			throw new IllegalArgumentException("No puedes tener mas carros :c");
		}
		boolean existeIdv = vehiculoById.containsKey(idV);
		if(existeIdv) {
			throw new IllegalArgumentException("Ya existe este Id de Vehiculo");
		}
		boolean vehiculoValido = (tipoVehiculo == 1)||(tipoVehiculo == 2);
		if(!vehiculoValido){
			throw new IllegalArgumentException("Tipo de vehiculo no valido");
		}

		if(tipoVehiculo==1) {
			Vehicle vehiCarro = new Carro(idV, placa, marca, modelo, color, capacidad);
			this.vehiculoById.put(idV, vehiCarro);
			vehiculos.add(vehiCarro);
		}else if(tipoVehiculo==2){
			Vehicle vehiMoto = new Moto(idV, placa, marca, modelo, color, capacidad);
			this.vehiculoById.put(idV,vehiMoto);
			vehiculos.add(vehiMoto);
		}
		else{
			throw new IllegalArgumentException("Tipo de vehiculo no valido");
		}

	}


	
	public Vehicle buscarVehiculo(int idV) {
		boolean existeVehiculo = vehiculoById.containsKey(idV);
		if(!existeVehiculo) {
			throw new IllegalArgumentException("No existe esta Id de Vehiculo ");
		}
		return vehiculoById.get(idV);
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {

		boolean tam = (password.length() >= 8) && (password.length() <= 30);
		if (!tam) {
			throw new IllegalArgumentException("La contraseña debe tener entre 8 y 30 caracteres");
		}

		boolean mayus = false;
		for (int i = 0; i < password.length(); i++){
			if (Character.isUpperCase(password.charAt(i))) {
				mayus = true;
				break;
			}
		}
		if (!mayus){
			throw new IllegalArgumentException("La contraseña debe tener al menos una mayúscula");
		}

		this.password = password;
	}
	public List<Vehicle> getVehiculos() {
		return vehiculos;
	}
}
