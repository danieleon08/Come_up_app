package Model;

public class ProfileUser {
	
	private String name; 
	private String phonenumber;
	private int id;
	private int rate;

	
	public ProfileUser(String name, String phonenumber, int id, int rate) {
		this.name=name;
		this.phonenumber=phonenumber; 
		this.id=id;
		this.rate=rate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getRate(){
		return rate;
	}
	public void setRate(int rate){
		this.rate=rate;
	}
}

