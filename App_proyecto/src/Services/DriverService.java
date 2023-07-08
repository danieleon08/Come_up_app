package Services;

import Model.Driver;
import Model.ProfileDriver;
import java.util.Map;
import java.util.HashMap;


public class DriverService {
	private Map<String, Driver> driverByUsername = new HashMap<>();
	private Map<Integer,Driver> driverById = new HashMap<>();
	private Map<Integer, ProfileDriver> PerfilById = new HashMap<>();

	public Map<String, Driver> getDriverByUsername() {
		return driverByUsername;
	}

	public Map<Integer, Driver> getDriverById() {
		return driverById;
	}

	public Map<Integer, ProfileDriver> getPerfilById() {
		return PerfilById;
	}

	public DriverService(){}
	public void addDriver(int id,String username,String password,String name,int rate, String localidad) {
		boolean existeUsername = driverByUsername.containsKey(username);


		if (existeUsername) {
			throw new IllegalArgumentException("Ya existe este usuario");
		}


		ProfileDriver perf = new ProfileDriver(name, id, rate, localidad);
		Driver driver = new Driver(id, username, password, perf);

		boolean tamañoApropiado = (username.length() >= 8) && (username.length() <= 30);
		if (!tamañoApropiado) {
			throw new IllegalArgumentException("El nombre puede tener entre 8 y 30 caracteres");
		}

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

			this.driverByUsername.put(driver.getUsername(), driver);
			this.driverById.put(driver.getId(), driver);
			this.PerfilById.put(driver.getId(), perf);

	}
	public Driver buscarDriverById(int id) {
		boolean existeId = driverById.containsKey(id);
		if(!existeId) {
			throw new IllegalArgumentException("No existe este Id ");
		}
		
		return driverById.get(id);
	}
	public Driver buscarDriverByUsername(String username) {
		boolean existeId = driverByUsername.containsKey(username);
		if (!existeId) {
			throw new IllegalArgumentException("No existe este nombre de usuario ");
		}

		return driverByUsername.get(username);
	}

	/*public void mostrarLista() {
		Driver di=new Driver();
		for(int i=0;i<listdrive.size();i++) {
			System.out.println("Driver: "+listdrive.get(i).getUsername());
			for(int e=0;e<((List<Driver>) listdrive.get(i)).size();e++) {
				System.out.println("IdV: "+listdrive.get(i).Vehiculos.get(e).getIdV());
				System.out.println("Placa: "+listdrive.get(i).Vehiculos.get(e).getPlaca());
				System.out.println("marca:"+listdrive.get(i).Vehiculos.get(e).getMarca());
				System.out.println("Modelo: "+listdrive.get(i).Vehiculos.get(e).getModelo());
				System.out.println("Color: "+listdrive.get(i).Vehiculos.get(e).getColor());
				System.out.println("Capacidad: "+listdrive.get(i).Vehiculos.get(e).getCapacidad());
			}
			}
		}*/
	}