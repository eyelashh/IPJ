package qualquer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class appAdministrator {

	private JFrame frame;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private static User u;
	

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					appAdministrator window = new appAdministrator(u);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

	/**
	 * Create the application.
	 */
	public appAdministrator(User u) {
		initialize();
		appAdministrator.u=u;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(73, 80, 129, 29);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnAddusertolist = new JButton("addUserToList");
		
		btnAddusertolist.setBounds(90, 197, 122, 23);
		frame.getContentPane().add(btnAddusertolist);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(73, 58, 110, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(73, 120, 110, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(77, 145, 135, 23);
		frame.getContentPane().add(txtPassword);
		
		JLabel txtWelcome = new JLabel("New label");
		txtWelcome.setBounds(39, 11, 228, 29);
		frame.getContentPane().add(txtWelcome);
		txtWelcome.setText("Welcome"+this.u.getUsername());
		
		
		//addUser
		//preciso de importar o banco
		
		
		btnAddusertolist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username =txtUser.getText();
				String pass=new String(txtPassword.getPassword());
				
				User u=new User(username,pass);
				Bank.getInstance().addUser(u);
				
//				
//				User u=new User(txtUser,txtPass);
			}
		});
	}
}
