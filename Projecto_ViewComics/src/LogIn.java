import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LogIn extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jLoginUsername;
	private JPasswordField jLoginPassword;


	/**
	 * Create the application.
	 */
	public LogIn() {
		setResizable(false);
		setBounds(100, 100, 1280, 768);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(12, 13, 114, 26);
		contentPanel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(22, 52, 91, 26);
		contentPanel.add(lblPassword);
		
		jLoginUsername = new JTextField();
		jLoginUsername.setBounds(138, 18, 192, 22);
		contentPanel.add(jLoginUsername);
		jLoginUsername.setColumns(10);
		
		jLoginPassword = new JPasswordField();
		jLoginPassword.setBounds(135, 57, 195, 22);
		contentPanel.add(jLoginPassword);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Login");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						// fazer login 
						
						if(jLoginUsername.getText().equals("Bruno") && new String(jLoginPassword.getPassword()).equals("Supegal"))
						{
							JOptionPane.showMessageDialog(null, "Login efectuado com sucesso");
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Login n�o efectuado! So as pessoas do Supegal sao Fixes");
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}