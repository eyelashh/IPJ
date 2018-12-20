
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;

public class BancoAppAdm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	

			public void run() {
				try {
					BancoAppAdm window = new BancoAppAdm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	

	/**
	 * Create the application.
	 */
	public BancoAppAdm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		JPanel JpanelCabecalho = new JPanel();
		JpanelCabecalho.setBackground(new Color(65, 106, 105));
		JpanelCabecalho.setBounds(12, 13, 1238, 100);
		frame.getContentPane().add(JpanelCabecalho);
		JpanelCabecalho.setLayout(null);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Login dialog = new Login();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(frame);
					dialog.setVisible(true);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(1070, 30, 117, 38);
		JpanelCabecalho.add(btnLogin);

		JLabel lblNewLabel = new JLabel("JavaBank");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setVerifyInputWhenFocusTarget(false);
		lblNewLabel.setForeground(new Color(188, 127, 82));
		lblNewLabel.setBounds(37, 13, 175, 74);
		JpanelCabecalho.add(lblNewLabel);

		JLabel lblBemVindo = new JLabel("Bem-Vindo(a) -");
		lblBemVindo.setVerifyInputWhenFocusTarget(false);
		lblBemVindo.setForeground(new Color(0, 0, 0));
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblBemVindo.setBounds(332, 13, 277, 74);
		JpanelCabecalho.add(lblBemVindo);

		
	

		JLabel lUtilizador = new JLabel("Utilizador");
		lUtilizador.setVerifyInputWhenFocusTarget(false);
		lUtilizador.setForeground(new Color(0, 0, 0));
		lUtilizador.setFont(new Font("Tahoma", Font.BOLD, 35));
		lUtilizador.setBounds(673, 13, 189, 74);
		JpanelCabecalho.add(lUtilizador);

		// dentro do painel
		// imagem_1 = new JLabel(new
		// ImageIcon("/Users/tamarabarros/Desktop/projectoJava/Layout-Banco/mLncE-co�pia
		// (1).jpg"));
		// imagem_1.setBounds(0, 0, 1238, 100);
		// JpanelCabecalho.add(imagem_1);
		// imagem_1.setVisible(true);

		//Painel do menu
		JPanel JpanelMenu = new JPanel();
		JpanelMenu.setBackground(new Color(255, 255, 255));
		JpanelMenu.setBounds(12, 126, 170, 580);
		frame.getContentPane().add(JpanelMenu);
		JpanelMenu.setLayout(null);

		//Painel do Administrador
		JPanel JPanelAdmin = new JPanel();
		JPanelAdmin.setLayout(null);
		JPanelAdmin.setBackground(Color.WHITE);
		JPanelAdmin.setBounds(0, 0, 170, 580);
		JpanelMenu.add(JPanelAdmin);

		//Botão da estatistica
		JButton btAdmEstatistica = new JButton("Estatist\u00EDcas");
		btAdmEstatistica.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btAdmEstatistica.setBounds(12, 13, 146, 130);
		JPanelAdmin.add(btAdmEstatistica);

		//Botão dos funcionarios
		JButton btAdmFuncionarios = new JButton("Funcion\u00E1rios");
		btAdmFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btAdmFuncionarios.setBounds(12, 156, 146, 130);
		JPanelAdmin.add(btAdmFuncionarios);

		//Botão dos Clientes
		JButton btAdmClientes = new JButton("Cliente");
		btAdmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btAdmClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btAdmClientes.setBounds(12, 299, 146, 130);
		JPanelAdmin.add(btAdmClientes);

		
		//Painel branco 
		JPanel JpanelPrincipal = new JPanel();
		JpanelPrincipal.setBackground(Color.WHITE);
		JpanelPrincipal.setBounds(194, 126, 1056, 582);
		frame.getContentPane().add(JpanelPrincipal);
		JpanelPrincipal.setLayout(null);

		//Painel da gestao do administrador
		JPanel JPAdm = new JPanel();
		JPAdm.setBackground(Color.WHITE);
		JPAdm.setBounds(12, 13, 1032, 556);
		JpanelPrincipal.add(JPAdm);
		JPAdm.setLayout(null);
		//Painel da gestao do administrador
		JPanel JPAdmGestao = new JPanel();
		JPAdmGestao.setVisible(false);
		JPAdmGestao.setLayout(null);
		JPAdmGestao.setBounds(0, 0, 1032, 556);
		JPAdm.add(JPAdmGestao);

		
		
		
		textField = new JTextField();
		textField.setBounds(144, 134, 271, 33);
		JPAdmGestao.add(textField);
		textField.setColumns(10);

		JLabel lblUsername_1 = new JLabel("Username");
		lblUsername_1.setVerifyInputWhenFocusTarget(false);
		lblUsername_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblUsername_1.setBounds(144, 81, 99, 41);
		JPAdmGestao.add(lblUsername_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		separator_1.setBounds(475, 68, 29, 433);
		JPAdmGestao.add(separator_1);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setVerifyInputWhenFocusTarget(false);
		lblPassword_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPassword_1.setBounds(144, 178, 99, 41);
		JPAdmGestao.add(lblPassword_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(154, 230, 271, 33);
		JPAdmGestao.add(textField_1);
		
		JLabel lblNovaUsername = new JLabel("Nova Username");
		lblNovaUsername.setVerifyInputWhenFocusTarget(false);
		lblNovaUsername.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNovaUsername.setBounds(144, 275, 191, 41);
		JPAdmGestao.add(lblNovaUsername);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(154, 327, 271, 33);
		JPAdmGestao.add(textField_2);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnConfirmar.setBounds(144, 415, 131, 41);
		JPAdmGestao.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(294, 415, 131, 41);
		JPAdmGestao.add(btnCancelar);

		//Painel do cartao da parte administrador
		JPanel JPAdmCartao = new JPanel();
		JPAdmCartao.setVisible(false);
		JPAdmCartao.setLayout(null);
		JPAdmCartao.setBounds(0, 0, 1032, 556);
		JPAdm.add(JPAdmCartao);

		//Painel da estatistica da parte administrador
		JPanel JPAdmEstatistica = new JPanel();
		JPAdmEstatistica.setVisible(false);
		JPAdmEstatistica.setBounds(0, 0, 1032, 556);
		JPAdm.add(JPAdmEstatistica);
		JPAdmEstatistica.setLayout(null);

		//Painel da funcionario da parte administrador
		JPanel JPAdmFuncionario = new JPanel();
		JPAdmFuncionario.setVisible(false);
		JPAdmFuncionario.setLayout(null);
		JPAdmFuncionario.setBounds(0, 0, 1032, 556);
		JPAdm.add(JPAdmFuncionario);

		JComboBox cbAdmFunPesq = new JComboBox();
		cbAdmFunPesq.setBounds(12, 13, 240, 30);
		JPAdmFuncionario.add(cbAdmFunPesq);

		JTextField tbAdmFunPesq = new JTextField();
		tbAdmFunPesq.setBounds(12, 52, 240, 30);
		JPAdmFuncionario.add(tbAdmFunPesq);
		tbAdmFunPesq.setColumns(10);

		JList lbLAdmFunLivros = new JList();
		lbLAdmFunLivros.setBounds(12, 102, 240, 441);
		JPAdmFuncionario.add(lbLAdmFunLivros);

		JButton btAdmFunPesq = new JButton("Procurar");
		btAdmFunPesq.setBounds(264, 13, 97, 30);
		JPAdmFuncionario.add(btAdmFunPesq);

		JButton btAdmFunNovo = new JButton("Novo");
		btAdmFunNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
			
			
		});
		btAdmFunNovo.setBounds(396, 13, 97, 30);
		JPAdmFuncionario.add(btAdmFunNovo);

		JButton btAdmFunEliminar = new JButton("Eliminar");
		btAdmFunEliminar.setBounds(520, 13, 97, 30);
		JPAdmFuncionario.add(btAdmFunEliminar);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(391, 102, 47, 30);
		JPAdmFuncionario.add(lblNewLabel_1);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataDeNascimento.setBounds(296, 137, 142, 30);
		JPAdmFuncionario.add(lblDataDeNascimento);

		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDocumento.setBounds(357, 177, 81, 30);
		JPAdmFuncionario.add(lblDocumento);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumero.setBounds(381, 220, 57, 30);
		JPAdmFuncionario.add(lblNumero);

		JLabel lblContacto = new JLabel("Contacto:");
		lblContacto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContacto.setBounds(381, 268, 69, 30);
		JPAdmFuncionario.add(lblContacto);

		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(369, 311, 81, 30);
		JPAdmFuncionario.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(372, 354, 66, 30);
		JPAdmFuncionario.add(lblPassword);

		JRadioButton rbAdmFunCC = new JRadioButton("C.C.");
		rbAdmFunCC.setBounds(446, 181, 57, 25);
		JPAdmFuncionario.add(rbAdmFunCC);

		JRadioButton rbAdmFunBI = new JRadioButton("B.I.");
		rbAdmFunBI.setBounds(507, 181, 57, 25);
		JPAdmFuncionario.add(rbAdmFunBI);

		JRadioButton rbAdmFunPass = new JRadioButton("Passaporte");
		rbAdmFunPass.setBounds(571, 181, 97, 25);
		JPAdmFuncionario.add(rbAdmFunPass);

		JTextPane tbAdmFunNome = new JTextPane();
		tbAdmFunNome.setBounds(450, 110, 496, 22);
		JPAdmFuncionario.add(tbAdmFunNome);

		JTextPane tbAdmFunDtnasc = new JTextPane();
		tbAdmFunDtnasc.setBounds(450, 145, 496, 22);
		JPAdmFuncionario.add(tbAdmFunDtnasc);

		JTextPane tbAdmFunNIden = new JTextPane();
		tbAdmFunNIden.setBounds(456, 220, 490, 22);
		JPAdmFuncionario.add(tbAdmFunNIden);

		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(462, 268, 484, 22);
		JPAdmFuncionario.add(textPane_3);

		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(460, 311, 486, 22);
		JPAdmFuncionario.add(textPane_4);

		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(460, 354, 486, 22);
		JPAdmFuncionario.add(textPane_5);

		JButton btAdmFunConfirmar = new JButton("Confirmar");
		btAdmFunConfirmar.setBounds(467, 428, 97, 30);
		JPAdmFuncionario.add(btAdmFunConfirmar);

		JButton btAdmFunConfirmarLimpar = new JButton("Limpar");
		btAdmFunConfirmarLimpar.setBounds(685, 428, 97, 30);
		JPAdmFuncionario.add(btAdmFunConfirmarLimpar);
		
		
		
		//Botão de gestao
				JButton btAdmGestao = new JButton("Gest\u00E3o");
				btAdmGestao.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						JPAdmGestao.setVisible(true);
						JPAdmCartao.setVisible(false);
						JPanelAdmin.setVisible(false);
						JPAdmEstatistica.setVisible(false);
					}
				});
				btAdmGestao.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btAdmGestao.setBounds(12, 442, 146, 130);
				JPanelAdmin.add(btAdmGestao);
	}
}
