package View;

import Model.Driver;
import Model.User;
import Services.DriverService;
import Services.UserService;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public abstract class Main {
    public static void crearCuenta(DriverService servicio){
            Scanner scan = new Scanner(System.in);
            boolean flag = true;
            int idr = 0;
        while(flag){
            Random random = new Random();
            idr = random.nextInt(100);
            if(!servicio.getDriverById().containsKey(idr)){
                flag = false;
            }
        }
        flag = true;

        while(flag) {
            System.out.println("Creando Cuenta: ");
            System.out.println("username: ");
            String username = scan.nextLine();
            System.out.println("------------------------");
            System.out.println("password: ");
            String password = scan.nextLine();
            System.out.println("------------------------");
            System.out.println("nombre: ");
            String name = scan.nextLine();
            System.out.println("------------------------");
            System.out.println("Ubicacion actual: ");
            String localidad = scan.nextLine();
            System.out.println("------------------------");
            int rate = 5;
            boolean hayCatch = false;
            try {
                servicio.addDriver(idr, username, password, name, rate, localidad);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                hayCatch = true;
            }
            flag = hayCatch;
        }
        System.out.println("Ya quedo registrado, su Id es: "+idr);
        System.out.println("Recomendacion: No olvidar esta Id");
    }
    public static void crearCuenta(UserService servicio){
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        boolean flag = true;
        int idr = 0;
        while(flag){
            idr = random.nextInt(100);
            if(!servicio.getUserById().containsKey(idr)){
                flag = false;
            }
        }
        flag = true;

        while(flag) {

            System.out.println("Creando Cuenta: ");
            System.out.println("username (debe tener entre 8 y 30 caracteres y solo puede contener valores alfanuméricos (letras de la a a la z y números de 0 a 9) y el símbolo ‘underscore’ (_)) : ");
            String username = scan.nextLine();

            System.out.println("------------------------");
            System.out.println("password (debe tener entre 8 y 30 caracteres y debe tener al menos una mayúscula) : ");
            String password = scan.nextLine();
            System.out.println("------------------------");
            System.out.println("nombre: ");
            String name = scan.nextLine();
            System.out.println("------------------------");
            System.out.println("phone Number (número de diez dijitos) : ");
            String phoneNumber = scan.nextLine();

            boolean hayCatch = false;
            try {
                servicio.addUser(idr, username, password, name, phoneNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                hayCatch = true;
            }
            flag = hayCatch;
        }
            System.out.println("Ya quedo registrado, su Id es: " + idr);
            System.out.println("Recomendacion: No olvidar esta Id");

    }
    public static void buscarPerfil(DriverService servicio){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa el perfil que quieres buscar (con el Id): ");
        int id = 0;
        boolean encontrado = true;
        try {
            id = scan.nextInt();
        }catch (InputMismatchException e){
            encontrado = false;
        }
        scan.nextLine();
        Driver driv;
        try {
            driv = servicio.buscarDriverById(id);
            System.out.println("Su username es: " + driv.getUsername());
        }catch (IllegalArgumentException e){
            encontrado = false;
        }
        if (!encontrado){
            System.out.println("Conductor no encontrado");
        }
    }
    public static void buscarPerfil(UserService servicio){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa el perfil que quieres buscar (con el Id): ");
        int id = 0;
        String aux = scan.nextLine();
        try {
            id = Integer.parseInt(aux);
        }catch (NumberFormatException e){
            id = 1000;
        }
        scan.nextLine();
        User user = servicio.buscarUserById(id);
        System.out.println("Su username es: " + user.getUsername());
    }
}