
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JDialog {

	private JTextField jLoginUsername;
	private JPasswordField jLoginPassword;

//	public void run() {
//		try {
//			Login window = new Login();
//			window.frame.setVisible(true);
//		}catch (Exception e) {
//			e.printStackTrace();
//		
//		}
//	}

	/**
	 * 
	 * Create the dialog.
	 */
	public Login() {

		GestoaBanco gb = new GestoaBanco();

		// frame principal
		setResizable(false);
		setBounds(100, 100, 1280, 768);
		getContentPane().setLayout(null);

		{
			// painel geral
			JPanel painelGeral = new JPanel();
			painelGeral.setBounds(0, 0, 1280, 746);
			getContentPane().add(painelGeral);

			{
				// Botao login
				JButton okButton = new JButton("Login");
				okButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
				okButton.setBounds(490, 621, 124, 43);

				// fazer login:
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						String user=jLoginUsername.getText();
						String pass=new String(jLoginPassword.getPassword());
						//vai buscar o metodo do banco onde verifica o utilizador
						Utilizador logado = Banco.getInstance().logado(user, pass);
						//Converti para string o nome
						String nome =  Banco.getInstance().logado(user, pass).getNome();
						
						boolean v = Banco.getInstance().verificarUserPass(user, pass);
						
						if (v) {
				
							if(logado instanceof Funcionario) {
								
							BancoAppFun fun = new BancoAppFun(nome);
							fun.run();
							
							
						} else if (logado instanceof Administrador) {
							
							BancoAppAdm adm = new BancoAppAdm(nome);
							adm.run();

						}else if(logado instanceof Cliente) {
							
							BancoAppClt clt = new BancoAppClt(nome);
							clt.run();
							
						}
						
						}
					}
				});

				painelGeral.setLayout(null);
				okButton.setActionCommand("OK");
				painelGeral.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				// Botao cancelar que serve para limpar
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
				cancelButton.setBounds(671, 623, 127, 41);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();

					}
				});
				cancelButton.setActionCommand("Cancel");
				painelGeral.add(cancelButton);
			}

			// box texto para a username
			jLoginUsername = new JTextField();
			jLoginUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			jLoginUsername.setBounds(492, 364, 297, 43);
			painelGeral.add(jLoginUsername);
			jLoginUsername.setColumns(10);

			// box texto para a password
			jLoginPassword = new JPasswordField();
			jLoginPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			jLoginPassword.setBounds(492, 505, 297, 43);
			painelGeral.add(jLoginPassword);

			// texto : username
			JLabel lblNewLabel = new JLabel("Username:");
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setBounds(562, 300, 166, 52);
			painelGeral.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));

			// text : password
			JLabel lblPassword = new JLabel("Password:");
			lblPassword.setForeground(new Color(0, 0, 0));
			lblPassword.setBounds(562, 454, 155, 25);
			painelGeral.add(lblPassword);
			lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 30));

			// titulo :Java
			JLabel tituloJava = new JLabel("JavaBank");
			tituloJava.setVerifyInputWhenFocusTarget(false);
			tituloJava.setFont(new Font("Tahoma", Font.BOLD, 90));
			tituloJava.setForeground(new Color(188, 127, 82));
			tituloJava.setBounds(406, 113, 438, 138);
			painelGeral.add(tituloJava);

			// imagem de fundo
			JLabel imagemfundo = new JLabel(
					new ImageIcon("/Users/tamarabarros/Dropbox/IPJ_ProjectoFinal/Design/JavaBank2/imagens/12.jpg"));
			imagemfundo.setOpaque(true);
			imagemfundo.setBackground(new Color(0, 128, 128));
			imagemfundo.setBounds(-1, -1, 1289, 755);
			painelGeral.add(imagemfundo);
			imagemfundo.setVisible(true);
		}
	}
}
