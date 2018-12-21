
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
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
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BancoAppAdm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1280, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		// Painel de cabeçalho
		JPanel JpanelCabecalho = new JPanel();
		JpanelCabecalho.setBackground(new Color(65, 106, 105));
		JpanelCabecalho.setBounds(0, 0, 1280, 130);
		frame.getContentPane().add(JpanelCabecalho);
		JpanelCabecalho.setLayout(null);

		// Painel de cabeçalho imagem
		// imagem_1 = new JLabel(new
		// ImageIcon("/Users/tamarabarros/Desktop/projectoJava/Layout-Banco/mLncE-co�pia
		// (1).jpg"));
		// imagem_1.setBounds(0, 0, 1238, 100);
		// JpanelCabecalho.add(imagem_1);
		// imagem_1.setVisible(true);

		// Botao de login, metodo que vai buscar a class
		JButton btnLogin = new JButton("Logout");
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
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
		btnLogin.setBounds(1077, 41, 143, 42);
		JpanelCabecalho.add(btnLogin);

		// texto no cabeçalho :Java
		JLabel lblNewLabel = new JLabel("JavaBank");
		lblNewLabel.setVerifyInputWhenFocusTarget(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setForeground(new Color(188, 127, 82));
		lblNewLabel.setBounds(41, 26, 225, 74);
		JpanelCabecalho.add(lblNewLabel);

		// texto no cabeçalho : Bem vindo
		JLabel lblBemVindo = new JLabel("Bem-Vindo(a) -");
		lblBemVindo.setVerifyInputWhenFocusTarget(false);
		lblBemVindo.setForeground(new Color(0, 0, 0));
		lblBemVindo.setFont(new Font("Helvetica", Font.PLAIN, 33));
		lblBemVindo.setBounds(348, 41, 243, 52);
		JpanelCabecalho.add(lblBemVindo);

		// texto no cabeçalho : utilizador
		JLabel lUtilizador = new JLabel("Tamara Barros");
		lUtilizador.setVerifyInputWhenFocusTarget(false);
		lUtilizador.setForeground(new Color(0, 0, 0));
		lUtilizador.setFont(new Font("Helvetica", Font.PLAIN, 45));
		lUtilizador.setBounds(585, 41, 308, 52);
		JpanelCabecalho.add(lUtilizador);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setAlignmentX(0.0f);
		separator.setBounds(983, 19, 29, 94);
		JpanelCabecalho.add(separator);

		// Painel do Administrador que tem os botoes
		JPanel JPanelAdmin = new JPanel();
		JPanelAdmin.setBounds(10, 135, 170, 605);
		JPanelAdmin.setBackground(Color.WHITE);
		frame.getContentPane().add(JPanelAdmin);
		JPanelAdmin.setLayout(null);

		// Painel branco
		JPanel JpanelPrincipal = new JPanel();
		// JpanelPrincipal.setBackground(Color.LIGHT_GRAY);
		JpanelPrincipal.setBounds(198, 142, 1065, 598);
		frame.getContentPane().add(JpanelPrincipal);
		JpanelPrincipal.setLayout(null);

		// Painel do administrador
		JPanel JPAdm = new JPanel();
		JPAdm.setBackground(Color.WHITE);
		JPAdm.setBounds(12, 13, 1042, 576);
		JpanelPrincipal.add(JPAdm);
		JPAdm.setLayout(null);

		// Painel da funcionario da parte administrador
		JPanel JPAdmFuncionario = new JPanel();
		JPAdmFuncionario.setVisible(false);
		
				// Painel da gestao do administrador
				JPanel JPAdmGestao = new JPanel();
				JPAdmGestao.setLayout(null);
				JPAdmGestao.setBounds(0, 0, 1042, 576);
				JPAdm.add(JPAdmGestao);
				
						// linha que separa na parte da gestao
						JSeparator separator_1 = new JSeparator();
						separator_1.setForeground(Color.BLACK);
						separator_1.setOrientation(SwingConstants.VERTICAL);
						separator_1.setAlignmentX(Component.LEFT_ALIGNMENT);
						separator_1.setBounds(483, 68, 29, 433);
						JPAdmGestao.add(separator_1);
						
								// texto : username
								JLabel lblUsername_1 = new JLabel("Username :");
								lblUsername_1.setVerifyInputWhenFocusTarget(false);
								lblUsername_1.setFont(new Font("Arial", Font.PLAIN, 20));
								lblUsername_1.setBounds(144, 81, 131, 41);
								JPAdmGestao.add(lblUsername_1);
								
										// campo de texto na gestão da parte do administrador
										textField = new JTextField();
										textField.setBounds(144, 134, 271, 33);
										JPAdmGestao.add(textField);
										textField.setColumns(10);
										
												// texto : password
												JLabel lblPassword_1 = new JLabel("Password :");
												lblPassword_1.setVerifyInputWhenFocusTarget(false);
												lblPassword_1.setFont(new Font("Arial", Font.PLAIN, 20));
												lblPassword_1.setBounds(144, 178, 99, 41);
												JPAdmGestao.add(lblPassword_1);
												
														// campo de texto na gestão da parte do administrador
														textField_1 = new JTextField();
														textField_1.setColumns(10);
														textField_1.setBounds(144, 230, 271, 33);
														JPAdmGestao.add(textField_1);
														
																// texto : novausername
																JLabel lblNovaUsername = new JLabel("Nova Username :");
																lblNovaUsername.setVerifyInputWhenFocusTarget(false);
																lblNovaUsername.setFont(new Font("Arial", Font.PLAIN, 20));
																lblNovaUsername.setBounds(144, 275, 191, 41);
																JPAdmGestao.add(lblNovaUsername);
																
																		// campo de texto na gestão da parte do administrador
																		textField_2 = new JTextField();
																		textField_2.setColumns(10);
																		textField_2.setBounds(144, 327, 271, 33);
																		JPAdmGestao.add(textField_2);
																		
																				// botao de confimar - submete a nova username
																				JButton btnConfirmar = new JButton("Confirmar");
																				btnConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																				btnConfirmar.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {

																					}
																				});
																				btnConfirmar.setBounds(144, 415, 131, 41);
																				JPAdmGestao.add(btnConfirmar);
																				
																						// botao de cancelar - limpar
																						JButton btnCancelar = new JButton("Cancelar");
																						btnCancelar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																						btnCancelar.setBounds(294, 415, 131, 41);
																						JPAdmGestao.add(btnCancelar);
																						
																								textField_3 = new JTextField();
																								textField_3.setColumns(10);
																								textField_3.setBounds(579, 134, 271, 33);
																								JPAdmGestao.add(textField_3);
																								
																										JLabel lblPassword_2 = new JLabel("Password :");
																										lblPassword_2.setVerifyInputWhenFocusTarget(false);
																										lblPassword_2.setFont(new Font("Arial", Font.PLAIN, 20));
																										lblPassword_2.setBounds(579, 81, 99, 41);
																										JPAdmGestao.add(lblPassword_2);
																										
																												JLabel lblNovaPassword = new JLabel("Nova Password :");
																												lblNovaPassword.setVerifyInputWhenFocusTarget(false);
																												lblNovaPassword.setFont(new Font("Arial", Font.PLAIN, 20));
																												lblNovaPassword.setBounds(579, 178, 168, 41);
																												JPAdmGestao.add(lblNovaPassword);
																												
																														textField_4 = new JTextField();
																														textField_4.setColumns(10);
																														textField_4.setBounds(579, 230, 271, 33);
																														JPAdmGestao.add(textField_4);
																														
																																JLabel lblConfirmarNovaUsername = new JLabel("Confirmar Nova Password :");
																																lblConfirmarNovaUsername.setVerifyInputWhenFocusTarget(false);
																																lblConfirmarNovaUsername.setFont(new Font("Arial", Font.PLAIN, 20));
																																lblConfirmarNovaUsername.setBounds(579, 275, 271, 41);
																																JPAdmGestao.add(lblConfirmarNovaUsername);
																																
																																		textField_5 = new JTextField();
																																		textField_5.setColumns(10);
																																		textField_5.setBounds(579, 327, 271, 33);
																																		JPAdmGestao.add(textField_5);
																																		
																																				JButton button = new JButton("Confirmar");
																																				button.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																				button.setBounds(579, 415, 131, 41);
																																				JPAdmGestao.add(button);
																																				
																																						JButton button_1 = new JButton("Cancelar");
																																						button_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																						button_1.setBounds(729, 415, 131, 41);
																																						JPAdmGestao.add(button_1);
		JPAdmFuncionario.setLayout(null);
		JPAdmFuncionario.setBounds(0, 0, 1042, 576);
		JPAdm.add(JPAdmFuncionario);

		// Painel do cliente da parte administrador
		JPanel JPAdmCliente = new JPanel();
		JPAdmCliente.setBounds(0, 0, 1042, 576);
		JPAdm.add(JPAdmCliente);
		JPAdmCliente.setVisible(false);
		JPAdmCliente.setLayout(null);

		// Painel da estatistica da parte administrador
		JPanel JPAdmEstatistica = new JPanel();
		JPAdmEstatistica.setVisible(false);
		JPAdmEstatistica.setBounds(0, 0, 1042, 576);
		JPAdm.add(JPAdmEstatistica);
		JPAdmEstatistica.setLayout(null);

		// box onde escolhemos como queremos fazer a pesquisa do funcionario
		JComboBox cbAdmFunPesq = new JComboBox();
		cbAdmFunPesq.setBounds(12, 13, 240, 30);
		JPAdmFuncionario.add(cbAdmFunPesq);

		// caixa de texto para escrever a procura do funcionario
		JTextField tbAdmFunPesq = new JTextField();
		tbAdmFunPesq.setBounds(12, 52, 240, 30);
		JPAdmFuncionario.add(tbAdmFunPesq);
		tbAdmFunPesq.setColumns(10);

		// lista dos funcionarios
		JList lbLAdmFunLivros = new JList();
		lbLAdmFunLivros.setBounds(12, 102, 240, 441);
		JPAdmFuncionario.add(lbLAdmFunLivros);

		// Botao de procurar
		JButton btAdmFunPesq = new JButton("Procurar");
		btAdmFunPesq.setBounds(264, 13, 97, 30);
		JPAdmFuncionario.add(btAdmFunPesq);

		// Botao para criar novo funcionario
		JButton btAdmFunNovo = new JButton("Novo");
		btAdmFunNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}

		});
		btAdmFunNovo.setBounds(396, 13, 97, 30);
		JPAdmFuncionario.add(btAdmFunNovo);

		// Botao de eliminar funcionario
		JButton btAdmFunEliminar = new JButton("Eliminar");
		btAdmFunEliminar.setBounds(520, 13, 97, 30);
		JPAdmFuncionario.add(btAdmFunEliminar);

		// Botao de limpar a informacao
		JButton btAdmFunConfirmarLimpar = new JButton("Limpar");
		btAdmFunConfirmarLimpar.setBounds(685, 428, 97, 30);
		JPAdmFuncionario.add(btAdmFunConfirmarLimpar);

		// texto : Nome
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(391, 102, 47, 30);
		JPAdmFuncionario.add(lblNewLabel_1);

		// caixa de texto para o nome
		JTextPane tbAdmFunNome = new JTextPane();
		tbAdmFunNome.setBounds(450, 110, 496, 22);
		JPAdmFuncionario.add(tbAdmFunNome);

		// texto : data de nascimento
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataDeNascimento.setBounds(296, 137, 142, 30);
		JPAdmFuncionario.add(lblDataDeNascimento);

		// caixa de texto para a data
		JTextPane tbAdmFunDtnasc = new JTextPane();
		tbAdmFunDtnasc.setBounds(450, 145, 496, 22);
		JPAdmFuncionario.add(tbAdmFunDtnasc);

		// texto : documento
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDocumento.setBounds(357, 177, 81, 30);
		JPAdmFuncionario.add(lblDocumento);

		// radiobutton : documento
		JRadioButton rbAdmFunCC = new JRadioButton("C.C.");
		rbAdmFunCC.setBounds(446, 181, 57, 25);
		JPAdmFuncionario.add(rbAdmFunCC);

		// radiobutton : documento
		JRadioButton rbAdmFunBI = new JRadioButton("B.I.");
		rbAdmFunBI.setBounds(507, 181, 57, 25);
		JPAdmFuncionario.add(rbAdmFunBI);

		// radiobutton : documento
		JRadioButton rbAdmFunPass = new JRadioButton("Passaporte");
		rbAdmFunPass.setBounds(571, 181, 97, 25);
		JPAdmFuncionario.add(rbAdmFunPass);

		// texto : numero do documento
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumero.setBounds(381, 220, 57, 30);
		JPAdmFuncionario.add(lblNumero);

		// caixa de texto para o numero
		JTextPane tbAdmFunNIden = new JTextPane();
		tbAdmFunNIden.setBounds(456, 220, 490, 22);
		JPAdmFuncionario.add(tbAdmFunNIden);

		// texto : contato
		JLabel lblContacto = new JLabel("Contacto:");
		lblContacto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContacto.setBounds(381, 268, 69, 30);
		JPAdmFuncionario.add(lblContacto);

		// caixa de texto para o contato
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(462, 268, 484, 22);
		JPAdmFuncionario.add(textPane_3);

		// texto : username
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(369, 311, 81, 30);
		JPAdmFuncionario.add(lblUsername);

		// caixa de texto para o username
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(460, 311, 486, 22);
		JPAdmFuncionario.add(textPane_4);

		// texto : username
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(372, 354, 66, 30);
		JPAdmFuncionario.add(lblPassword);

		// caixa de texto para a password
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(460, 354, 486, 22);
		JPAdmFuncionario.add(textPane_5);

		// texto : confirmar
		JButton btAdmFunConfirmar = new JButton("Confirmar");
		btAdmFunConfirmar.setBounds(467, 428, 97, 30);
		JPAdmFuncionario.add(btAdmFunConfirmar);

		// Botão da estatistica do menu
		JButton btAdmEstatistica = new JButton("Estatist\u00EDcas");
		btAdmEstatistica.setBorderPainted(false);
		btAdmEstatistica.setOpaque(true);
		btAdmEstatistica.setForeground(Color.BLACK);
		btAdmEstatistica.setBounds(0, 6, 170, 130);
		btAdmEstatistica.setBackground(new Color(188, 127, 82));
		btAdmEstatistica.setIcon(null);
		JPanelAdmin.add(btAdmEstatistica);

		// quando carrego no batao estatistica, os outros paineis nao ficam visiveis
		btAdmEstatistica.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JPAdmEstatistica.setVisible(true);
				JPAdmCliente.setVisible(false);
				JPAdmFuncionario.setVisible(false);
				JPAdmGestao.setVisible(false);
			}
		});
		btAdmEstatistica.setFont(new Font("Tahoma", Font.PLAIN, 20));

		// Botão dos Clientes do menu
		JButton btAdmClientes = new JButton("Cliente");
		btAdmClientes.setOpaque(true);
		btAdmClientes.setBorderPainted(false);
		btAdmClientes.setBackground(new Color(188, 127, 82));
		btAdmClientes.setBounds(0, 304, 170, 139);
		JPanelAdmin.add(btAdmClientes);

		// quando carrego no batao cliente, os outros paineis nao ficam visiveis
		btAdmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPAdmGestao.setVisible(false);
				JPAdmCliente.setVisible(true);
				JPAdmFuncionario.setVisible(false);
				JPAdmEstatistica.setVisible(false);
			}
		});
		btAdmClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));

		// Botão de gestao do menu
		JButton btAdmGestao = new JButton("Gest\u00E3o");
		btAdmGestao.setBorderPainted(false);
		btAdmGestao.setOpaque(true);
		btAdmGestao.setBounds(0, 455, 170, 150);
		btAdmGestao.setBackground(new Color(188, 127, 82));
		JPanelAdmin.add(btAdmGestao);

		// quando carrego no batao gestao, os outros paineis nao ficam visiveis
		btAdmGestao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPAdmGestao.setVisible(true);
				JPAdmCliente.setVisible(false);
				JPAdmFuncionario.setVisible(false);
				JPAdmEstatistica.setVisible(false);
			}
		});
		btAdmGestao.setFont(new Font("Tahoma", Font.PLAIN, 20));

		// Botão dos funcionarios do menu
		JButton btAdmFuncionarios = new JButton("Funcion\u00E1rios");
		btAdmFuncionarios.setBorderPainted(false);
		btAdmFuncionarios.setBorder(UIManager.getBorder("Button.border"));
		btAdmFuncionarios.setOpaque(true);
		btAdmFuncionarios.setBackground(new Color(188, 127, 82));
		btAdmFuncionarios.setBounds(0, 148, 170, 144);
		JPanelAdmin.add(btAdmFuncionarios);

		// quando carrego no batao funcionario, os outros paineis nao ficam visiveis
		btAdmFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPAdmGestao.setVisible(false);
				JPAdmCliente.setVisible(false);
				JPAdmFuncionario.setVisible(true);
				JPAdmEstatistica.setVisible(false);
			}
		});
		btAdmFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 17));

		// botao estatistica accao que muda de cor
		btAdmEstatistica.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				btAdmEstatistica.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btAdmEstatistica.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btAdmEstatistica.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btAdmEstatistica.setBackground(new Color(65, 106, 105));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btAdmEstatistica.setBackground(new Color(65, 106, 105));
			}
		});

		// botao cliente accao que muda de cor
		btAdmClientes.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				btAdmClientes.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btAdmClientes.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btAdmClientes.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btAdmClientes.setBackground(new Color(65, 106, 105));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btAdmClientes.setBackground(new Color(65, 106, 105));
			}
		});

		// botao funcionario accao que muda de cor
		btAdmFuncionarios.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				btAdmFuncionarios.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btAdmFuncionarios.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btAdmFuncionarios.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btAdmFuncionarios.setBackground(new Color(65, 106, 105));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btAdmFuncionarios.setBackground(new Color(65, 106, 105));
			}
		});

		// botao funcionario accao que muda de cor
		btAdmGestao.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				btAdmGestao.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btAdmGestao.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btAdmGestao.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btAdmGestao.setBackground(new Color(65, 106, 105));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btAdmGestao.setBackground(new Color(65, 106, 105));
			}
		});

	}
}
