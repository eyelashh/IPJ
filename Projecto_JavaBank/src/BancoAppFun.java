
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.List;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Canvas;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class BancoAppFun {

	private JFrame frame;
	private JTextField tbCltNome;
	private JTextField tbCltDnasc;
	private JTextField tbCltNum;
	private JTextField tbCltContacto;
	private JTextField tbCltUser;
	private JPasswordField tbCltPass;
	private JTextField tbContasOrdenar;
	private JTextField tbContasnum;
	private JTextField tbContasdtcriacao;
	private JTextField tbContaslimitelev;
	private JTextField tbGestaoUsername;
	private JTextField tbGestaopass;
	private JTextField tbGestaoNovoUser;
	private JPasswordField tbGestaoPass;
	private JPasswordField tbGestaoNovapass;
	private JPasswordField tbGestaoConfirmPass;
	private JTextField textField;
	private JTextField tbDepMontante;
	private JTextField tbDepData;
	private JTextField tbLevMontante;
	private JTextField tbLevData;
	private JTextField tbTransMontante;
	private JTextField tbTransContaDestino;
	private JTextField tbTransData;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			BancoAppFun window = new BancoAppFun();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public BancoAppFun() {
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

		// Botao de logout, metodo que vai buscar a class
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
		btnLogin.setBounds(1070, 30, 143, 42);
		JpanelCabecalho.add(btnLogin);

		// texto no cabeçalho :Java
		JLabel lblNewLabel = new JLabel("JavaBank");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setVerifyInputWhenFocusTarget(false);
		lblNewLabel.setForeground(new Color(188, 127, 82));
		lblNewLabel.setBounds(34, 21, 227, 74);
		JpanelCabecalho.add(lblNewLabel);

		// texto no cabeçalho : Bem vindo
		JLabel lblBemVindo = new JLabel("Bem-Vindo(a) ");
		lblBemVindo.setVerifyInputWhenFocusTarget(false);
		lblBemVindo.setForeground(new Color(0, 0, 0));
		lblBemVindo.setFont(new Font("Helvetica", Font.PLAIN, 33));
		lblBemVindo.setBounds(348, 41, 243, 52);
		JpanelCabecalho.add(lblBemVindo);

		// texto no cabeçalho : utilizador
		JLabel lUtilizador = new JLabel("Funcionario");
		lUtilizador.setVerifyInputWhenFocusTarget(false);
		lUtilizador.setForeground(new Color(0, 0, 0));
		lUtilizador.setFont(new Font("Helvetica", Font.PLAIN, 45));
		lUtilizador.setBounds(585, 41, 308, 52);
		JpanelCabecalho.add(lUtilizador);

		// separador no cabeçalho
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setAlignmentX(0.0f);
		separator.setBounds(983, 19, 29, 94);
		JpanelCabecalho.add(separator);

		// Painel menu que tem os botoes
		JPanel JpanelMenu = new JPanel();
		JpanelMenu.setBackground(Color.WHITE);
		JpanelMenu.setBounds(10, 135, 170, 605);
		frame.getContentPane().add(JpanelMenu);
		JpanelMenu.setLayout(null);

		// Painel principal
		JPanel JpanelPrincipal = new JPanel();
		JpanelPrincipal.setBounds(198, 142, 1065, 598);
		frame.getContentPane().add(JpanelPrincipal);
		JpanelPrincipal.setLayout(null);

		// Painel principal CLientes
		JPanel jpanelClientes = new JPanel();
		jpanelClientes.setVisible(false);
		
				// Painel da gestao do administrador
				JPanel jpanelGestao = new JPanel();
				jpanelGestao.setVisible(false);
				jpanelGestao.setBounds(0, 0, 1042, 576);
				JpanelPrincipal.add(jpanelGestao);
				jpanelGestao.setLayout(null);
				
						JLabel lblUsername_1 = new JLabel("UserName:");
						lblUsername_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
						lblUsername_1.setBounds(96, 118, 113, 24);
						jpanelGestao.add(lblUsername_1);
						
								tbGestaoUsername = new JTextField();
								tbGestaoUsername.setBounds(96, 155, 279, 31);
								jpanelGestao.add(tbGestaoUsername);
								
										JLabel lblPassword_1 = new JLabel("Password:");
										lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
										lblPassword_1.setBounds(96, 199, 113, 24);
										jpanelGestao.add(lblPassword_1);
										
												tbGestaopass = new JTextField();
												tbGestaopass.setBounds(96, 236, 279, 31);
												jpanelGestao.add(tbGestaopass);
												
														JLabel lblNovaPassword = new JLabel("Novo UserName:");
														lblNovaPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
														lblNovaPassword.setBounds(96, 280, 171, 24);
														jpanelGestao.add(lblNovaPassword);
														
																tbGestaoNovoUser = new JTextField();
																tbGestaoNovoUser.setBounds(96, 310, 279, 31);
																jpanelGestao.add(tbGestaoNovoUser);
																
																		JButton btGestaouserconfirmar = new JButton("Confirmar");
																		btGestaouserconfirmar.setBounds(96, 385, 97, 25);
																		jpanelGestao.add(btGestaouserconfirmar);
																		
																				JButton btGestaouserCancelar = new JButton("Cancelar");
																				btGestaouserCancelar.setBounds(278, 385, 97, 25);
																				jpanelGestao.add(btGestaouserCancelar);
																				
																						JLabel lblPassword_2 = new JLabel("Password:");
																						lblPassword_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
																						lblPassword_2.setBounds(669, 118, 113, 24);
																						jpanelGestao.add(lblPassword_2);
																						
																								tbGestaoPass = new JPasswordField();
																								tbGestaoPass.setBounds(669, 155, 279, 31);
																								jpanelGestao.add(tbGestaoPass);
																								
																										JLabel lblPassword_3 = new JLabel("Nova Password:");
																										lblPassword_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
																										lblPassword_3.setBounds(669, 199, 113, 24);
																										jpanelGestao.add(lblPassword_3);
																										
																												tbGestaoNovapass = new JPasswordField();
																												tbGestaoNovapass.setBounds(669, 236, 279, 31);
																												jpanelGestao.add(tbGestaoNovapass);
																												
																														JLabel lblConfirmarPassword = new JLabel("Confirmar Password:");
																														lblConfirmarPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
																														lblConfirmarPassword.setBounds(669, 280, 171, 24);
																														jpanelGestao.add(lblConfirmarPassword);
																														
																																tbGestaoConfirmPass = new JPasswordField();
																																tbGestaoConfirmPass.setBounds(669, 310, 279, 31);
																																jpanelGestao.add(tbGestaoConfirmPass);
																																
																																		JButton btGestaopassConfirmar = new JButton("Confirmar");
																																		btGestaopassConfirmar.setBounds(669, 385, 97, 25);
																																		jpanelGestao.add(btGestaopassConfirmar);
																																		
																																				JButton btGestaopassCancelar = new JButton("Cancelar");
																																				btGestaopassCancelar.setBounds(851, 385, 97, 25);
																																				jpanelGestao.add(btGestaopassCancelar);
																																				
																																						JLabel lblAlterarUsername = new JLabel("Alterar UserName:");
																																						lblAlterarUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
																																						lblAlterarUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
																																						lblAlterarUsername.setBounds(134, 74, 203, 31);
																																						jpanelGestao.add(lblAlterarUsername);
																																						
																																								JLabel lblAlterarPassword = new JLabel("Alterar PassWord:");
																																								lblAlterarPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
																																								lblAlterarPassword.setAlignmentX(0.5f);
																																								lblAlterarPassword.setBounds(707, 74, 203, 31);
																																								jpanelGestao.add(lblAlterarPassword);
		jpanelClientes.setBounds(0, 0, 1042, 576);
		JpanelPrincipal.add(jpanelClientes);
		jpanelClientes.setLayout(null);

		// Painel principal da operaçoes
		JPanel jpanelOperacoes = new JPanel();
		jpanelOperacoes.setVisible(false);
		jpanelOperacoes.setBounds(0, 0, 1042, 576);
		JpanelPrincipal.add(jpanelOperacoes);
		jpanelOperacoes.setLayout(null);

		JComboBox cbOperacoespesqClt = new JComboBox();
		cbOperacoespesqClt.setBounds(12, 13, 250, 30);
		jpanelOperacoes.add(cbOperacoespesqClt);

		JTextField tbOperacoespesqClt = new JTextField();
		tbOperacoespesqClt.setBounds(12, 56, 250, 30);
		jpanelOperacoes.add(tbOperacoespesqClt);

		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setBounds(12, 99, 97, 30);
		jpanelOperacoes.add(btnNewButton);

		JComboBox cbOperacoesConta = new JComboBox();
		cbOperacoesConta.setBounds(295, 56, 250, 30);
		jpanelOperacoes.add(cbOperacoesConta);

		JLabel lblNewLabel_3 = new JLabel("Saldo Disponivel:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(677, 14, 162, 23);
		jpanelOperacoes.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(633, 56, 250, 30);
		jpanelOperacoes.add(textField);

		JLabel lblConta = new JLabel("Conta:");
		lblConta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConta.setBounds(388, 20, 64, 23);
		jpanelOperacoes.add(lblConta);

		JButton cbOperacoDep = new JButton("Deposito");
		cbOperacoDep.setBounds(170, 143, 97, 30);
		jpanelOperacoes.add(cbOperacoDep);

		JButton btnLevantamento = new JButton("Levantamento");
		btnLevantamento.setBounds(355, 143, 113, 30);
		jpanelOperacoes.add(btnLevantamento);

		JButton btnTransferncia = new JButton("Transfer\u00EAncia");
		btnTransferncia.setBounds(633, 143, 113, 30);
		jpanelOperacoes.add(btnTransferncia);

		JPanel JpanelOpTransferencia = new JPanel();
		JpanelOpTransferencia.setVisible(false);

		JPanel JpanelOpDeposito = new JPanel();
		JpanelOpDeposito.setVisible(false);
		JpanelOpDeposito.setBackground(SystemColor.inactiveCaptionBorder);
		JpanelOpDeposito.setBounds(170, 180, 575, 360);
		jpanelOperacoes.add(JpanelOpDeposito);
		JpanelOpDeposito.setLayout(null);

		tbDepMontante = new JTextField();
		tbDepMontante.setBounds(183, 105, 162, 30);
		JpanelOpDeposito.add(tbDepMontante);

		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblData.setBounds(239, 161, 50, 23);
		JpanelOpDeposito.add(lblData);

		JLabel lblMontantem = new JLabel("Montante:");
		lblMontantem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMontantem.setBounds(216, 69, 97, 23);
		JpanelOpDeposito.add(lblMontantem);

		tbDepData = new JTextField();
		tbDepData.setBounds(183, 197, 162, 30);
		JpanelOpDeposito.add(tbDepData);

		JButton btDepConfirmar = new JButton("Confirmar");
		btDepConfirmar.setBounds(148, 274, 97, 30);
		JpanelOpDeposito.add(btDepConfirmar);

		JButton btDepCancelar = new JButton("Cancelar");
		btDepCancelar.setBounds(272, 274, 97, 30);
		JpanelOpDeposito.add(btDepCancelar);

		JLabel lblDeposito = new JLabel("Deposito:");
		lblDeposito.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDeposito.setBounds(201, 13, 144, 43);
		JpanelOpDeposito.add(lblDeposito);
		JpanelOpTransferencia.setLayout(null);
		JpanelOpTransferencia.setBackground(SystemColor.inactiveCaptionBorder);
		JpanelOpTransferencia.setBounds(170, 180, 575, 360);
		jpanelOperacoes.add(JpanelOpTransferencia);

		tbTransMontante = new JTextField();
		tbTransMontante.setBounds(183, 105, 162, 30);
		JpanelOpTransferencia.add(tbTransMontante);

		JLabel lblContaDestino = new JLabel("Conta destino:");
		lblContaDestino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContaDestino.setBounds(196, 148, 137, 23);
		JpanelOpTransferencia.add(lblContaDestino);

		JLabel label_5 = new JLabel("Montante:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBounds(216, 69, 97, 23);
		JpanelOpTransferencia.add(label_5);

		tbTransContaDestino = new JTextField();
		tbTransContaDestino.setBounds(183, 183, 162, 30);
		JpanelOpTransferencia.add(tbTransContaDestino);

		JButton btTransConfirmar = new JButton("Confirmar");
		btTransConfirmar.setBounds(146, 317, 97, 30);
		JpanelOpTransferencia.add(btTransConfirmar);

		JButton btTransCancelar = new JButton("Cancelar");
		btTransCancelar.setBounds(275, 317, 97, 30);
		JpanelOpTransferencia.add(btTransCancelar);

		JLabel lblTransferencia = new JLabel("Transferencia:");
		lblTransferencia.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTransferencia.setBounds(168, 13, 193, 43);
		JpanelOpTransferencia.add(lblTransferencia);

		JLabel label_7 = new JLabel("Data:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_7.setBounds(239, 226, 50, 23);
		JpanelOpTransferencia.add(label_7);

		tbTransData = new JTextField();
		tbTransData.setBounds(183, 253, 162, 30);
		JpanelOpTransferencia.add(tbTransData);

		JPanel JpanelOpLevantamento = new JPanel();
		JpanelOpLevantamento.setVisible(false);
		JpanelOpLevantamento.setBounds(170, 180, 575, 360);
		jpanelOperacoes.add(JpanelOpLevantamento);
		JpanelOpLevantamento.setLayout(null);
		JpanelOpLevantamento.setBackground(SystemColor.inactiveCaptionBorder);

		tbLevMontante = new JTextField();
		tbLevMontante.setBounds(183, 105, 162, 30);
		JpanelOpLevantamento.add(tbLevMontante);

		JLabel label = new JLabel("Data:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(239, 148, 50, 23);
		JpanelOpLevantamento.add(label);

		JLabel label_1 = new JLabel("Montante:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(216, 69, 97, 23);
		JpanelOpLevantamento.add(label_1);

		tbLevData = new JTextField();
		tbLevData.setBounds(183, 183, 162, 30);
		JpanelOpLevantamento.add(tbLevData);

		JButton btLevConfirmar = new JButton("Confirmar");
		btLevConfirmar.setBounds(161, 241, 97, 30);
		JpanelOpLevantamento.add(btLevConfirmar);

		JButton btLevCancelar = new JButton("Cancelar");
		btLevCancelar.setBounds(270, 241, 97, 30);
		JpanelOpLevantamento.add(btLevCancelar);

		JLabel lblLevantamento = new JLabel("Levantamento:");
		lblLevantamento.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLevantamento.setBounds(162, 13, 205, 43);
		JpanelOpLevantamento.add(lblLevantamento);

		// Painel da conta da parte funcionario
		JPanel jpanelContas = new JPanel();
		jpanelContas.setVisible(false);
		jpanelContas.setBounds(0, 0, 1042, 576);
		JpanelPrincipal.add(jpanelContas);
		jpanelContas.setLayout(null);

		JComboBox cbContaspesqconta = new JComboBox();
		cbContaspesqconta.setBounds(12, 13, 279, 31);
		jpanelContas.add(cbContaspesqconta);

		JTextField tbContaspesqconta = new JTextField();
		tbContaspesqconta.setBounds(12, 57, 279, 31);
		jpanelContas.add(tbContaspesqconta);

		JComboBox cbContasOrdenar = new JComboBox();
		cbContasOrdenar.setBounds(366, 13, 279, 31);
		jpanelContas.add(cbContasOrdenar);

		tbContasOrdenar = new JTextField();
		tbContasOrdenar.setBounds(366, 57, 279, 31);
		jpanelContas.add(tbContasOrdenar);

		JList lContas = new JList();
		lContas.setBounds(12, 101, 279, 442);
		jpanelContas.add(lContas);

		JList lClientes = new JList();
		lClientes.setBounds(741, 101, 279, 442);
		jpanelContas.add(lClientes);

		JLabel lblNewLabel_2 = new JLabel("N\u00BA de Conta:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(366, 124, 113, 24);
		jpanelContas.add(lblNewLabel_2);

		JLabel lblDataDeOperao = new JLabel("Data de Cria\u00E7\u00E3o:");
		lblDataDeOperao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataDeOperao.setBounds(366, 205, 113, 24);
		jpanelContas.add(lblDataDeOperao);

		JLabel lblLimiteDeLevantamento = new JLabel("Limite de Levantamento:");
		lblLimiteDeLevantamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLimiteDeLevantamento.setBounds(366, 286, 171, 24);
		jpanelContas.add(lblLimiteDeLevantamento);

		tbContasnum = new JTextField();
		tbContasnum.setBounds(366, 161, 279, 31);
		jpanelContas.add(tbContasnum);

		tbContasdtcriacao = new JTextField();
		tbContasdtcriacao.setBounds(366, 242, 279, 31);
		jpanelContas.add(tbContasdtcriacao);

		tbContaslimitelev = new JTextField();
		tbContaslimitelev.setBounds(366, 316, 279, 31);
		jpanelContas.add(tbContaslimitelev);

		JButton btContasConfirmar = new JButton("Confirmar");
		btContasConfirmar.setBounds(366, 391, 97, 25);
		jpanelContas.add(btContasConfirmar);

		JButton btContasCancelar = new JButton("Limpar");
		btContasCancelar.setBounds(548, 391, 97, 25);
		jpanelContas.add(btContasCancelar);

		JButton btContasNovo = new JButton("Novo");
		btContasNovo.setBounds(350, 471, 97, 25);
		jpanelContas.add(btContasNovo);

		JButton btContasEliminar = new JButton("Eliminar");
		btContasEliminar.setBounds(461, 471, 97, 25);
		jpanelContas.add(btContasEliminar);

		JButton btContasLimpar = new JButton("Cancelar");
		btContasLimpar.setBounds(570, 471, 97, 25);
		jpanelContas.add(btContasLimpar);

		JLabel lblClientes_1 = new JLabel("Clientes");
		lblClientes_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClientes_1.setBounds(741, 64, 57, 24);
		jpanelContas.add(lblClientes_1);
		jpanelClientes.setBounds(12, 13, 1032, 556);
		JpanelPrincipal.add(jpanelClientes);
		jpanelClientes.setLayout(null);

		JComboBox cbCltPesq = new JComboBox();
		cbCltPesq.setBounds(12, 13, 250, 30);
		jpanelClientes.add(cbCltPesq);

		JTextField tbCltPesq = new JTextField();
		tbCltPesq.setBounds(12, 56, 250, 30);
		jpanelClientes.add(tbCltPesq);
		

		JList lbClt = new JList();
		lbClt.setBounds(12, 142, 250, 401);
		jpanelClientes.add(lbClt);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(387, 99, 44, 30);
		jpanelClientes.add(lblNewLabel_1);

		JLabel lblDNascimento = new JLabel("D. Nascimento:");
		lblDNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDNascimento.setBounds(330, 142, 101, 30);
		jpanelClientes.add(lblDNascimento);

		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDocumento.setBounds(351, 185, 80, 30);
		jpanelClientes.add(lblDocumento);

		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNmero.setBounds(369, 228, 62, 30);
		jpanelClientes.add(lblNmero);

		JLabel lblContacto = new JLabel("Contacto:");
		lblContacto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContacto.setBounds(368, 271, 63, 30);
		jpanelClientes.add(lblContacto);

		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(351, 314, 80, 30);
		jpanelClientes.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(359, 357, 72, 30);
		jpanelClientes.add(lblPassword);

		tbCltNome = new JTextField();
		tbCltNome.setBounds(443, 97, 250, 30);
		jpanelClientes.add(tbCltNome);

		tbCltDnasc = new JTextField();
		tbCltDnasc.setBounds(443, 147, 250, 30);
		jpanelClientes.add(tbCltDnasc);

		tbCltNum = new JTextField();
		tbCltNum.setBounds(443, 233, 250, 30);
		jpanelClientes.add(tbCltNum);

		tbCltContacto = new JTextField();
		tbCltContacto.setBounds(443, 276, 250, 30);
		jpanelClientes.add(tbCltContacto);

		tbCltUser = new JTextField();
		tbCltUser.setBounds(443, 319, 250, 30);
		jpanelClientes.add(tbCltUser);

		tbCltPass = new JPasswordField();
		tbCltPass.setBounds(443, 362, 250, 30);
		jpanelClientes.add(tbCltPass);

		JList lbCltConta = new JList();
		lbCltConta.setBounds(770, 142, 250, 401);
		jpanelClientes.add(lbCltConta);

		JButton btCltPesquisa = new JButton("Pesquisa");
		btCltPesquisa.setBounds(280, 16, 97, 30);
		jpanelClientes.add(btCltPesquisa);

		JButton btCltNovo = new JButton("Novo");
		btCltNovo.setBounds(387, 16, 97, 30);
		jpanelClientes.add(btCltNovo);

		JButton btCltEliminar = new JButton("Eliminar");
		btCltEliminar.setBounds(496, 16, 97, 30);
		jpanelClientes.add(btCltEliminar);

		JButton btCltconfirmar = new JButton("Confirmar");
		btCltconfirmar.setBounds(443, 405, 97, 30);
		jpanelClientes.add(btCltconfirmar);

		JButton btCltLimpar = new JButton("Limpar");
		btCltLimpar.setBounds(596, 405, 97, 30);
		jpanelClientes.add(btCltLimpar);

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClientes.setBounds(12, 99, 56, 30);
		jpanelClientes.add(lblClientes);

		JLabel lblContas = new JLabel("Contas");
		lblContas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContas.setBounds(770, 99, 56, 30);
		jpanelClientes.add(lblContas);

		JRadioButton rbCltcc = new JRadioButton("C.C.");
		rbCltcc.setBounds(439, 189, 56, 25);
		jpanelClientes.add(rbCltcc);

		JRadioButton rbCltbi = new JRadioButton("B.I.");
		rbCltbi.setBounds(512, 189, 56, 25);
		jpanelClientes.add(rbCltbi);

		JRadioButton rbCltPassaporte = new JRadioButton("Passaporte");
		rbCltPassaporte.setBounds(582, 189, 111, 25);
		jpanelClientes.add(rbCltPassaporte);

		// Botao Menu Cliente
		JButton btFunCliente = new JButton("Clientes");
		btFunCliente.setBorderPainted(false);
		btFunCliente.setOpaque(true);
		btFunCliente.setForeground(Color.BLACK);
		btFunCliente.setBounds(0, 6, 170, 130);
		btFunCliente.setBackground(new Color(188, 127, 82));
		JpanelMenu.add(btFunCliente);

		// Eventos:
		// coloca o painel cliente visivel:
		btFunCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpanelClientes.setVisible(true);
				jpanelContas.setVisible(false);
				jpanelGestao.setVisible(false);
				jpanelOperacoes.setVisible(false);
			}
		});

		btFunCliente.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		// Botao Menu Conta
		JButton btFunConta = new JButton("Contas");
		btFunConta.setBorderPainted(false);
		btFunConta.setBorder(UIManager.getBorder("Button.border"));
		btFunConta.setOpaque(true);
		btFunConta.setBackground(new Color(188, 127, 82));
		btFunConta.setBounds(0, 148, 170, 144);
		JpanelMenu.add(btFunConta);

		// coloca o painel conta visivel:
		btFunConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpanelClientes.setVisible(false);
				jpanelContas.setVisible(true);
				jpanelGestao.setVisible(false);
				jpanelOperacoes.setVisible(false);
			}
		});
		btFunConta.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		// Botao Menu Operacoes
		JButton btFunOperaes = new JButton("Opera\u00E7\u00F5es");
		btFunOperaes.setOpaque(true);
		btFunOperaes.setBorderPainted(false);
		btFunOperaes.setBackground(new Color(188, 127, 82));
		btFunOperaes.setBounds(0, 304, 170, 139);
		JpanelMenu.add(btFunOperaes);

		// coloca o painel operacoes visivel:
		btFunOperaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpanelClientes.setVisible(false);
				jpanelContas.setVisible(false);
				jpanelGestao.setVisible(false);
				jpanelOperacoes.setVisible(true);
			}
		});
		btFunOperaes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		// Botao Menu Gestao
		JButton btFunGesto = new JButton("Gest\u00E3o");
		btFunGesto.setBorderPainted(false);
		btFunGesto.setOpaque(true);
		btFunGesto.setBounds(0, 455, 170, 150);
		btFunGesto.setBackground(new Color(188, 127, 82));
		JpanelMenu.add(btFunGesto);

		// coloca o painel gestao visivel:
		btFunGesto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpanelClientes.setVisible(false);
				jpanelContas.setVisible(false);
				jpanelGestao.setVisible(true);
				jpanelOperacoes.setVisible(false);
			}
		});
		btFunGesto.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		// Dentro do painel gestao:
		// coloca o painel depositos visivel:
		cbOperacoDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JpanelOpDeposito.setVisible(true);
				JpanelOpLevantamento.setVisible(false);
				JpanelOpTransferencia.setVisible(false);

			}
		});

		// coloca o painel depositos visivel:
		btnLevantamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JpanelOpDeposito.setVisible(false);
				JpanelOpLevantamento.setVisible(true);
				JpanelOpTransferencia.setVisible(false);
			}
		});

		// coloca o painel depositos visivel:
		btnTransferncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JpanelOpDeposito.setVisible(false);
				JpanelOpLevantamento.setVisible(false);
				JpanelOpTransferencia.setVisible(true);
			}
		});

		// botao cliente accao que muda de cor
		btFunCliente.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				btFunCliente.setBackground(new Color(188, 127, 82));
			}
			
			

			@Override
			public void mousePressed(MouseEvent e) {
				btFunCliente.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btFunCliente.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btFunCliente.setBackground(new Color(65, 106, 105));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btFunCliente.setBackground(new Color(65, 106, 105));
			}
		});

		// botao conta accao que muda de cor
		btFunConta.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				btFunConta.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btFunConta.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btFunConta.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btFunConta.setBackground(new Color(65, 106, 105));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btFunConta.setBackground(new Color(65, 106, 105));
			}
		});

		// botao funcionario accao que muda de cor
		btFunOperaes.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				btFunOperaes.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btFunOperaes.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btFunOperaes.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btFunOperaes.setBackground(new Color(65, 106, 105));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btFunOperaes.setBackground(new Color(65, 106, 105));
			}
		});

		// botao funcionario accao que muda de cor
		btFunGesto.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				btFunGesto.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btFunGesto.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btFunGesto.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btFunGesto.setBackground(new Color(65, 106, 105));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btFunGesto.setBackground(new Color(65, 106, 105));
			}
		});

	}
}
