package View;

import Model.RideUser;
import Model.User;
import Services.UserService;
import java.util.Scanner;

public class MainUser extends Main {

	public static void main(String[] args) {
		int indicador = 0;
		
		Scanner scanner = new Scanner(System.in);
		UserService servicio = new UserService();
		
		while(indicador!=8) {
            System.out.println("|Menu Usuario                |");
			System.out.println("+----------------------------+");
			System.out.println("|Crear Cuenta        1       |");
			System.out.println("|Buscar  Perfil      2       |");
			System.out.println("|Iniciar Sesion      3       |");
			System.out.println("|Salir               8       |");
			System.out.println("Que operacion quiere hacer: ");

			String aux = scanner.nextLine();

			try {
				indicador = Integer.parseInt(aux);
			} catch (NumberFormatException e){
				indicador=0;
			}

			 switch(indicador) {
				 case 1: {
					 try {
						 crearCuenta(servicio);
					 }catch (IllegalArgumentException e){
						 System.out.println((e.getMessage()));
					 }
					 break;
				 }
				 case 2: {
					 try {
						 buscarPerfil(servicio);
					 }catch (IllegalArgumentException e){
						 System.out.println(e.getMessage());
					 }
					 break;
				 }
				 case 3: {
					 try {
						 iniciarSesion(servicio);
					 }catch (IllegalArgumentException e){
						 System.out.println(e.getMessage());
					 }
					 break;
				 }
				 case 8: {
					 System.out.println("Saliendo...");
					 break;
				 }
				 default:
					 System.out.println("Operacion no valida");
					 break;
			 }
		}
	}

	public static void loggedMenu(User usuario){
		int indicador = 0;
		Scanner scanner = new Scanner(System.in);

		while(indicador!=8) {
			System.out.println("+----------------------------+");
			System.out.println("|Motrar Perfil       1       |");
			System.out.println("|Solicitar carrera   2       |");
			System.out.println("|Cerrar Sesion       8       |");
			System.out.println("Que operacion quiere hacer: ");

			String aux = scanner.nextLine();

			try {
				indicador = Integer.parseInt(aux);
			}catch (NumberFormatException e){
				indicador=0;
			}

			switch(indicador) {
				case 1: {
					// Mostrar Perfil
					int indimodi;
					mostrarPerfil(usuario);
					System.out.println("|Modificar       2       |");
					System.out.println("|Salir           8       |");
					String aux2 = scanner.nextLine();

					try {
						indimodi = Integer.parseInt(aux2);
					}catch (NumberFormatException e){
						indimodi=0;
					}

					if(indimodi == 2) {
					modificarPerfil(usuario);
					}
					break;
				}

				case 2: {
					// Solicitar Carrera
					RideUser ri = new RideUser();
					System.out.println("Ubicacion Origen");
					String ubiO = scanner.nextLine();
					System.out.println("---------------------------");
					System.out.println("Ubicacion Destino");
					String ubiD =scanner.nextLine();

					ri.solicitarCarrera(ubiO,ubiD, usuario.getPerfil().getName());
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

	public static void iniciarSesion(UserService servicio){

		Scanner scanner = new Scanner((System.in));
		System.out.println("Ingrese nombre de usuario:");
		String username = scanner.nextLine();
		System.out.println("Ingrese su contraseña:");
		String password = scanner.nextLine();

		User usuario = servicio.buscarUserByUsername(username);

		if(password.equals(usuario.getPassword())){
			loggedMenu(usuario);
		}
		else{
			System.out.println("El usuario o la contraseña son incorrectos");
		}
	}

	public static void mostrarPerfil(User usuario) {
		
		System.out.println("Perfil del usuario: ");
		System.out.println("Name: "+usuario.getPerfil().getName());
		System.out.println("Id: "+ usuario.getId());
		System.out.println("Rate: "+usuario.getPerfil().getRate());
	}

	public static void modificarPerfil(User usuario) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("name: ");
		String name=scan.nextLine();
		System.out.println("------------------------");
		System.out.println("phone number: ");
		String phonenumber=scan.nextLine();

		usuario.getPerfil().setName(name);
		usuario.getPerfil().setPhonenumber(phonenumber);
		
		System.out.println("Nuevo perfil: ");
	}
}
