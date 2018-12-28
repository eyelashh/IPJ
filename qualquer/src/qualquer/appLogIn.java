package qualquer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class appLogIn {

	private JFrame frame;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JButton btnNewButton;
	

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			appLogIn window = new appLogIn();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public appLogIn() {
		initialize();
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
		txtUser.setBounds(66, 64, 152, 34);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);

		txtPass = new JPasswordField();
		txtPass.setBounds(66, 145, 152, 34);
		frame.getContentPane().add(txtPass);

		JLabel Username = new JLabel("Username");
		Username.setBounds(66, 39, 89, 14);
		frame.getContentPane().add(Username);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(66, 121, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);

		btnNewButton = new JButton("New button");

		btnNewButton.setBounds(66, 190, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea txtUsers = new JTextArea();
		txtUsers.setBounds(250, 11, 174, 146);
		frame.getContentPane().add(txtUsers);
		txtUsers.setLineWrap(true);
		
//	LOGIN

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String user=txtUser.getText();
				String pass=new String(txtPass.getPassword());
				
				txtUsers.setText(Bank.getInstance().getUsers().toString());

				boolean v = Bank.getInstance().verify(user, pass);
				if (v) {
					User userloggedIn=Bank.getInstance().logged(user, pass);
					appAdministrator adm = new appAdministrator(userloggedIn);
					adm.run();
				} else {

				}
			}
		});

	}
}
