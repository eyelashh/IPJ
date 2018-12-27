package qualquer;

public class Manage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		appLogIn login =new appLogIn();
		login.run();
		
		Bank.getInstance().addUser(new User("Hanna","hanna1234"));
		Bank.getInstance().addUser(new User("John","john1234"));
		Bank.getInstance().addUser(new User("Tom","tom1234"));
		
		

	}

}
