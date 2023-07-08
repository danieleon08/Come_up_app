package Services;


import Model.User;
import Model.ProfileUser;

import java.util.HashMap;
import java.util.Map;

public class UserService {

	//has a map by userid of user 
	
	Map<String, User> userByUsername = new HashMap<>();
	Map<Integer,User> userById = new HashMap<>();
	Map<Integer, ProfileUser> PerfilById = new HashMap<>();
	
	
	//Constructor 
	public UserService(){}   
	
	//find userbyId()
	
	public User buscarUserById(int id) {
		boolean existeId = userById.containsKey(id);
		if(!existeId) {
			throw new IllegalArgumentException("No existe este Id ");
		}
		return userById.get(id);
	}
	
	public User buscarUserByUsername(String username) {
		boolean existeUsername = userByUsername.containsKey(username);
		if(!existeUsername) {
			throw new IllegalArgumentException("No existe este nombre de usuario");
		}
		return userByUsername.get(username);
	}

	public Map<String, User> getUserByUsername() {
		return userByUsername;
	}

	public Map<Integer, User> getUserById() {
		return userById;
	}

	public Map<Integer, ProfileUser> getPerfilById() {
		return PerfilById;
	}

	//AddNewUser()
	public void addUser(int id,String username,String password,String name,String phonenumber) {

		boolean existeUsername = userByUsername.containsKey(username);
		if(existeUsername) {
			throw new IllegalArgumentException("Ya existe este usuario");
		}
		if(phonenumber.length() != 10){
			throw new IllegalArgumentException("El numero celular es incorrecto");
		}
		ProfileUser profileUser = new ProfileUser(name, phonenumber, id, 5);
		User user=new User(id,username,password,profileUser);

		// verificar user length
		boolean tam_user = (username.length() >= 8)&&(username.length()<= 30);
		if(!tam_user){
			throw new IllegalArgumentException("El nombre de usuario debe tener entre 8 y 30 caracteres");
		}

		String user_lowercase = username.toLowerCase();

		// El primer valor de un nombre de usuario debe ser una letra del alfabeto, puede ser mayúscula o minúscula
		if (!Character.isLetter(user_lowercase.charAt(0))) {
			throw new IllegalArgumentException("El primer valor de un nombre de usuario debe ser una letra del alfabeto, puede ser mayúscula o minúscula");
		}

		// el nombre de usuario puede contener valores alfanuméricos (letras de la a a la z y números de 0 a 9) y el símbolo ‘underscore’ (_)
		boolean user_values = true;


		for (int i = 1; i < user_lowercase.length(); i++) {
			char c = user_lowercase.charAt(i);
			if (!Character.isLetterOrDigit(c) && (c != '_')) {
				user_values= false;
			}
		}
		if (!user_values){
			throw new IllegalArgumentException("El nombre de usuario solo puede contener valores alfanuméricos (letras de la a a la z y números de 0 a 9) y el símbolo ‘underscore’ (_)");
		}

		// 8-30 caracters
		boolean tam = (password.length() >= 8)&&(password.length()<= 30);

		if(!tam){
			throw new IllegalArgumentException("La contraseña debe tener entre 8 y 30 caracteres");
		}
		// Se lee caracter por caracter,y se revisa si la letra es mayúscula, si hay una, el booleano es true
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

		this.userByUsername.put(user.getUsername(), user);
		this.userById.put(user.getId(), user);
		this.PerfilById.put(user.getId(),profileUser);
	}
}