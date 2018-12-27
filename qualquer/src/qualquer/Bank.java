package qualquer;

import java.util.ArrayList;

public class Bank {

	private static Bank soleinstance = new Bank();
	private ArrayList<User> users;

	private Bank() {
		super();
		users = new ArrayList();
	}

	public static Bank getInstance() {
		return soleinstance;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public void addUser(User u) {
		this.users.add(u);

	}

	@Override
	public String toString() {
		return "Bank [users=" + users + "]";
	}

	public boolean verify(String user, String pass) {

		boolean verified = false;

		for (User u : this.users) {
			if (pass.equals(u.getPassword()) && (user.equals(u.getUsername()))) {
				verified = true;
			}

		}
		return verified;
	}
	
}
