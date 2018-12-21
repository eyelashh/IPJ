import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JDialog {

	private JTextField jLoginUsername;
	private JPasswordField jLoginPassword;
	private JLabel imagem_1;

	/**
	 * Create the dialog.
	 */
	public Login() {

		setResizable(false);
		setBounds(100, 100, 1280, 768);
		getContentPane().setLayout(null);

		{
			JPanel painelGeral = new JPanel();
			painelGeral.setBounds(0, 0, 1280, 746);
			getContentPane().add(painelGeral);

			{
				JButton okButton = new JButton("Login");
				okButton.setBounds(436, 622, 124, 43);

				// fazer login:
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						if (jLoginUsername.getText().equals("j")
								&& new String(jLoginPassword.getPassword()).equals("j")) {
							BancoAppClt bc = new BancoAppClt();
							bc.run();
							dispose();
						}

						if (jLoginUsername.getText().equals("b")
								&& new String(jLoginPassword.getPassword()).equals("b")) {
							BancoAppFun bf = new BancoAppFun();
							bf.run();
							dispose();
						}
						if (jLoginUsername.getText().equals("t")
								&& new String(jLoginPassword.getPassword()).equals("t")) {
							BancoAppAdm ba = new BancoAppAdm();
							ba.run();
							dispose();
						}

					}
				});
				painelGeral.setLayout(null);
				okButton.setActionCommand("OK");
				painelGeral.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBounds(617, 624, 127, 41);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				painelGeral.add(cancelButton);
			}

			jLoginUsername = new JTextField();
			jLoginUsername.setBounds(438, 365, 297, 36);
			painelGeral.add(jLoginUsername);
			jLoginUsername.setColumns(10);

			jLoginPassword = new JPasswordField();
			jLoginPassword.setBounds(438, 506, 297, 36);
			painelGeral.add(jLoginPassword);

			JLabel lblNewLabel = new JLabel("Username:");
			lblNewLabel.setBounds(508, 301, 166, 52);
			painelGeral.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));

			JLabel lblPassword = new JLabel("Password:");
			lblPassword.setBounds(508, 455, 136, 25);
			painelGeral.add(lblPassword);
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));
			
			// texto no cabeçalho :Java
			JLabel tituloJava = new JLabel("JavaBank");
			tituloJava.setVerifyInputWhenFocusTarget(false);
			tituloJava.setFont(new Font("Tahoma", Font.BOLD, 90));
			tituloJava.setForeground(new Color(188, 127, 82));
			tituloJava.setBounds(351, 114, 438, 138);
			painelGeral.add(tituloJava);

			
			JLabel imagem_1 = new JLabel(new ImageIcon("/Users/tamarabarros/Dropbox/IPJ_ProjectoFinal/Design/JavaBank2/imagens/mLncE-cópia (1).jpg"));
			imagem_1.setOpaque(true);
			imagem_1.setBackground(new Color(0, 128, 128));
			imagem_1.setBounds(0, 0, 1294, 767);
			painelGeral.add(imagem_1);
			imagem_1.setVisible(true);
		}
	}
}
