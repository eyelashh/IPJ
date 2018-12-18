
/**
* Breve descrição do código
*
* @sid 2013
* @aid 1.1
*/

public class User {
	
	private String userName;
	private String name;
	private int contact;
	private int password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String name, int contact, int password) {
		super();
		this.userName = userName;
		this.name = name;
		this.contact = contact;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContacto() {
		return contacto;
	}
	public void setContacto(int contacto) {
		this.contacto = contacto;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	

}
