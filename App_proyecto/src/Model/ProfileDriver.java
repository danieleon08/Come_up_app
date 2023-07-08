package Model;

public class ProfileDriver {
	private String name;
	private int id;
	private int rate;
	private String localidad;
	
	public ProfileDriver(String name, int id, int rate, String localidad) {
		this.name = name;
		this.id = id;
		this.rate = rate;
		this.localidad = localidad;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getRate() {
		return rate;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void setName(String name) {
		this.name = name;
	}
}
