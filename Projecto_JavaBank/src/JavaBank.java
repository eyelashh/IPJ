import javax.swing.JDialog;

public class JavaBank {
	public static void main(String[] args) {
		Login log = new Login();
		log.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		log.setVisible(true);  
	}
 
}
