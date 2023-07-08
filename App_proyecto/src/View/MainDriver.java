package View;

import Model.Driver;
import Services.DriverService;
import Model.RideDriver;
import java.util.Scanner;
import java.util.Random;

public class MainDriver extends Main {

	public static void main(String[] args) {

		DriverService servicio = new DriverService();
		menuPrincipal(servicio);
	}

	public static void menuPrincipal(DriverService servicio) {

		Scanner scanner = new Scanner(System.in);
		int indicador = 0;

		while (indicador != 8) {
			System.out.println("+----------------------------+");
			System.out.println("|Crear Cuenta        1       |");
			System.out.println("|Buscar  Perfil      2       |");
			System.out.println("|Iniciar Sesion      3       |");
			System.out.println("|Salir               8       |");
			System.out.println("Que operacion quiere hacer: ");

			String aux = scanner.nextLine();

			try {
				indicador = Integer.parseInt(aux);
			}catch (NumberFormatException e){
				indicador = 0;
			}

			switch (indicador) {
				case 1: {
					try {
						crearCuenta(servicio);
						break;
					}catch (IllegalArgumentException e){
						System.out.println(e.getMessage());
					}
				}
				case 2: {
					buscarPerfil(servicio);
					break;
				}
				case 3: {
					iniciarSesion(servicio);
					break;
				}
				default: {
					System.out.println("Operacion no valida");
					break;
				}
			}
		}
	}

	public static void loggedMenu(Driver driver) {

		int indicador = 0;
		Scanner scanner = new Scanner(System.in);

		while (indicador != 8) {
			System.out.println("+---------------------------+");
			System.out.println("|Añadir Vehiculo       1    |");
			System.out.println("|Buscar Vehiculo       2    |");
			System.out.println("|Motrar Perfil         3    |");
			System.out.println("|Modificar Perfil      4    |");
			System.out.println("|Actualizar Ubicación  5    |");
			System.out.println("|Buscar Carreras       6    |");
			System.out.println("|Cerrar Sesion         8    |");
			System.out.println("+---------------------------+");
			System.out.println("Que operacion quiere hacer: ");
			String aux = scanner.nextLine();
			try {
				indicador = Integer.parseInt(aux);
			}catch (NumberFormatException e){
				indicador=0;
			}

			switch (indicador) {
				case 1: {
					agregarVehiculo(driver);
					break;
				}
				case 2: {
					try {
						buscarVehiculoById(driver);
					}catch (IllegalArgumentException e){
						System.out.println(e.getMessage());
					}
					break;
				}
				case 3: {
					mostrarPerfil(driver);
					break;
				}
				case 4: {
					modificarPerfil(driver);
					break;
				}
				case 5: {
					actualizarUbicacion(driver);
					break;
				}
				case 6: {
					RideDriver.recibirCarrera(driver);
					for (int i = 0; i < driver.getCarrerasPendientes().size(); i++) {
						System.out.println("RideId: " + driver.getCarrerasPendientes().get(i).getRideId());
						System.out.println("Nombre: " + driver.getCarrerasPendientes().get(i).getPassengerName());
						System.out.println("Destino: " + driver.getCarrerasPendientes().get(i).getDestino());
						System.out.println("Origen: " + driver.getCarrerasPendientes().get(i).getUbicacion());
					}
					break;
				}
				case 8: {
					System.out.println("Cerrando sesión...");
					break;
				}
				default: {
					System.out.println("Operacion no valida");
					break;
				}
			}
		}
	}

	private static void buscarCarreras(Driver driver) {

	}

	private static void actualizarUbicacion(Driver driver) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese su nueva ubicacion ");
		String localidad = scanner.nextLine();
		driver.getPerfil().setLocalidad(localidad);
	}

	public static void iniciarSesion(DriverService servicio) {

		Scanner scanner = new Scanner((System.in));
		System.out.println("Ingrese nombre de usuario:");
		String username = scanner.nextLine();
		System.out.println("Ingrese su contraseña:");
		String password = scanner.nextLine();

		Driver driver = servicio.getDriverByUsername().get(username);

		if(driver != null) {
			if (password.equals(driver.getPassword())) {
				loggedMenu(driver);
			} else {
				System.out.println("El usuario o la contraseña son incorrectos");
			}
		}else{
			System.out.println("El usuario o la contraseña son incorrectos");
		}
	}

	public static void agregarVehiculo(Driver driver) {

		boolean flag = true;
		int idV=0;

		while(flag) {
			Random random = new Random();
			boolean flag2=true;

			while(flag2) {
				idV = random.nextInt(100);
				if(!driver.getVehiculoById().containsKey(idV)){
					flag2 = false;
				}
			}

			Scanner scan = new Scanner(System.in);
			System.out.println("Escriba 1 si es  carro y 2 si es moto");
			int tipoVehiculo = Integer.parseInt(scan.nextLine());
			System.out.println("Ingresa placa: ");
			String placa = scan.nextLine();

			System.out.println("Ingresa marca: ");
			String marca = scan.nextLine();

			System.out.println("Ingresa modelo: ");
			String aux2 = scan.nextLine();
			int modelo;
			try {
				modelo = Integer.parseInt(aux2);
			}catch (NumberFormatException e){
				modelo = 2076;
			}

			System.out.println("Ingresa color: ");
			String color = scan.nextLine();

			System.out.println("Ingresa capacidad: ");
			String aux1 = scan.nextLine();
			int capacidad;

			try {
				capacidad = Integer.parseInt(aux1);
			}catch (NumberFormatException e){
				capacidad = 0;
			}

			flag = false;

			try {
				driver.addVehiculo(idV, placa, marca, modelo, color, capacidad, tipoVehiculo);
				System.out.println("El id del vehiculo es: " + idV);
				System.out.println("Recomendacion: No olvidar esta Id");
			}catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
				flag = true;
			}
		}
	}

	public static void buscarVehiculoById(Driver driver) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id del vehiculo a buscar:");
		int idV = Integer.parseInt(scanner.nextLine());
		System.out.println(driver.buscarVehiculo(idV).imprimirInfo());
		System.out.println("El nivel de su vehiculo es: ");
		System.out.println(driver.buscarVehiculo(idV).definirNivel());
		System.out.println("El costo por 5 min es de: ");
		System.out.println(driver.buscarVehiculo(idV).definirtCostoPor5Minutos());
	}

	public static void mostrarPerfil(Driver driver) {

		System.out.println("Perfil del usuario: ");
		System.out.println("Name: " + driver.getPerfil().getName());
		System.out.println("Id: " + driver.getId());
		System.out.println("Rate: " + driver.getPerfil().getRate());
		System.out.println("Ubicacion: " + driver.getPerfil().getLocalidad());

	}

	public static void modificarPerfil(Driver driver) {

		Scanner scanner = new Scanner(System.in);
		int indicador = 0;

		while (indicador != 8) {
			System.out.println("+----------------------------+");
			System.out.println("|Cambiar nombre      1       |");
			System.out.println("|Cambiar Contraseña  2       |");
			System.out.println("|Salir               8       |");
			System.out.println("Que operacion quiere hacer: ");
			String aux = scanner.nextLine();

			try {
				indicador = Integer.parseInt(aux);
			}catch (NumberFormatException e){
				indicador=0;
			}

			switch (indicador) {
				case 1: {
					Scanner scannom = new Scanner(System.in);
					System.out.println("nombre: ");
					String name = scannom.nextLine();
					System.out.println("------------------------");
					driver.getPerfil().setName(name);
					break;
				}
				case 2: {
					Scanner scanpass = new Scanner(System.in);
					System.out.println("Ingrese contraseña actual: ");
					String passwordActual = scanpass.nextLine();
					boolean ciclo=true;
					while(ciclo) {
						if (passwordActual.equals(driver.getPassword())) {
							System.out.println("Ingrese nueva contraseña: ");
							String password = scanpass.nextLine();
							try {
								driver.setPassword(password);
								ciclo=false;
							} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
							}

							System.out.println("------------------------");

						} else {
							System.out.println("Contraseña actual invalida");
							ciclo=false;
						}

					}
					break;
				}
				case 8: {
					System.out.println("Saliendo...");
					break;
				}
				default: {
					System.out.println("Operacion no valida");
				}
			}
		}
	}
}
