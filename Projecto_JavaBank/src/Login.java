import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField jLoginUsername;
	private JPasswordField jLoginPassword;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			Login window = new Login();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GestaoBanco gb = new GestaoBanco();
		gb.run();

		gb.javabank.pagajuros(gb.javabank.getContas());

		frame = new JFrame();
		frame.setBounds(100, 100, 1086, 741);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1280, 746);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					gb.javabank.escreveFicheiro("222222 22222 22");
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		btnNewButton.setBounds(27, 40, 74, 63);
		panel.add(btnNewButton);

		JLabel label = new JLabel("JavaBank");
		label.setVerifyInputWhenFocusTarget(false);
		label.setForeground(new Color(188, 127, 82));
		label.setFont(new Font("Tahoma", Font.BOLD, 90));
		label.setBounds(377, 45, 438, 138);
		panel.add(label);

		JLabel label_1 = new JLabel("Username:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 30));
		label_1.setBounds(533, 232, 166, 52);
		panel.add(label_1);

		jLoginUsername = new JTextField();
		jLoginUsername.setFont(new Font("Dialog", Font.PLAIN, 17));
		jLoginUsername.setColumns(10);
		jLoginUsername.setBounds(463, 296, 297, 43);
		panel.add(jLoginUsername);

		JLabel label_2 = new JLabel("Password:");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 30));
		label_2.setBounds(533, 386, 155, 25);
		panel.add(label_2);

		jLoginPassword = new JPasswordField();
		jLoginPassword.setFont(new Font("Dialog", Font.PLAIN, 17));
		jLoginPassword.setBounds(463, 437, 297, 43);
		panel.add(jLoginPassword);

		JButton button = new JButton("Login");

		button.setFont(new Font("Dialog", Font.PLAIN, 17));
		button.setActionCommand("OK");
		button.setBounds(461, 553, 124, 43);
		panel.add(button);

		JButton button_1 = new JButton("Cancel");
		button_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		button_1.setActionCommand("Cancel");
		button_1.setBounds(642, 555, 127, 41);
		panel.add(button_1);

		// imagem de fundo
		JLabel imagemfundo = new JLabel(
				new ImageIcon("/Users/tamarabarros/Dropbox/IPJ_ProjectoFinal/Design/JavaBank2/imagens/12.jpg"));
		imagemfundo.setOpaque(true);
		imagemfundo.setBackground(new Color(0, 128, 128));
		imagemfundo.setBounds(-1, -1, 1289, 755);
		panel.add(imagemfundo);
		imagemfundo.setVisible(true);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String user = jLoginUsername.getText();
				String pass = new String(jLoginPassword.getPassword());
				Utilizador logado = gb.javabank.logado(user, pass);
				boolean v = gb.javabank.verificarUserPass(user, pass);

				if (v) {
					if (logado instanceof Funcionario) {
						BancoAppFun fun = new BancoAppFun((Funcionario) logado, gb);
						fun.run();
						frame.setVisible(false);

					}
					if (logado instanceof Administrador) {
						BancoAppAdm adm = new BancoAppAdm((Administrador) logado, gb);
						adm.run();
						frame.setVisible(false);

					}
					if (logado instanceof Cliente) {
						BancoAppClt clt = new BancoAppClt((Cliente) logado, gb);
						clt.run();
						frame.setVisible(false);

					}

				}

			}
		});

	}
}
