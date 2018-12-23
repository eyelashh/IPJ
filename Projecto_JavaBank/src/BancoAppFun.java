
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
import javax.swing.JScrollBar;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;

public class BancoAppFun {

	private JFrame frame;
	private JTextField tbCltNome;
	private JTextField tbCltNum;
	private JTextField tbCltContacto;
	private JTextField tbCltUser;
	private JPasswordField tbCltPass;
	private JTextField tbContasnum;
	private JTextField tbContaslimitelev;
	private JTextField tbGestaoUsername;
	private JTextField tbGestaopass;
	private JTextField tbGestaoNovoUser;
	private JPasswordField tbGestaoPass;
	private JPasswordField tbGestaoNovapass;
	private JPasswordField tbGestaoConfirmPass;
	private JTextField textField;
	private JTextField tbDepMontante;
	private JTextField tbLevMontante;
	private JTextField tbLevData;
	private JTextField tbTransMontante;
	private JTextField tbTransContaDestino;

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
						
								// Painel da gestao do administrador
								JPanel jpanelGestao = new JPanel();
								jpanelGestao.setVisible(false);
										
										
												// Painel principal da operaçoes
												JPanel jpanelOperacoes = new JPanel();
												jpanelOperacoes.setVisible(false);
												
												
														// Painel da conta da parte funcionario
														JPanel jpanelContas = new JPanel();
														jpanelContas.setVisible(false);
														
																// Painel principal CLientes
																JPanel jpanelClientes = new JPanel();
																jpanelClientes.setBounds(0, 0, 1032, 556);
																JpanelPrincipal.add(jpanelClientes);
																jpanelClientes.setVisible(false);
																jpanelClientes.setLayout(null);
																jpanelClientes.setLayout(null);
																
																		JComboBox cbCltPesq = new JComboBox();
																		cbCltPesq.setBounds(56, 16, 218, 38);
																		jpanelClientes.add(cbCltPesq);
																		
																				JTextField tbCltPesq = new JTextField();
																				tbCltPesq.setBounds(56, 50, 218, 30);
																				jpanelClientes.add(tbCltPesq);
																				
																						JLabel lblClientes = new JLabel("Clientes");
																						lblClientes.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																						lblClientes.setBounds(56, 92, 118, 30);
																						jpanelClientes.add(lblClientes);
																						
																								JScrollBar scrollBar_2 = new JScrollBar();
																								scrollBar_2.setBounds(273, 92, 15, 441);
																								jpanelClientes.add(scrollBar_2);
																								
																										JList lbClt = new JList();
																										lbClt.setBounds(48, 92, 240, 441);
																										jpanelClientes.add(lbClt);
																										
																												JLabel lblNewLabel_1 = new JLabel("Nome:");
																												lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																												lblNewLabel_1.setBounds(335, 72, 57, 30);
																												jpanelClientes.add(lblNewLabel_1);
																												
																														JLabel lblDNascimento = new JLabel("D. Nascimento:");
																														lblDNascimento.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																														lblDNascimento.setBounds(335, 132, 177, 30);
																														jpanelClientes.add(lblDNascimento);
																														
																																JLabel lblDocumento = new JLabel("Documento:");
																																lblDocumento.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																lblDocumento.setBounds(335, 193, 108, 30);
																																jpanelClientes.add(lblDocumento);
																																
																																		JLabel lblNmero = new JLabel("N\u00FAmero:");
																																		lblNmero.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																		lblNmero.setBounds(335, 221, 227, 30);
																																		jpanelClientes.add(lblNmero);
																																		
																																				JLabel lblContacto = new JLabel("Contacto:");
																																				lblContacto.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																				lblContacto.setBounds(335, 287, 81, 31);
																																				jpanelClientes.add(lblContacto);
																																				
																																						JLabel lblUsername = new JLabel("Username:");
																																						lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																						lblUsername.setBounds(335, 351, 120, 30);
																																						jpanelClientes.add(lblUsername);
																																						
																																								JLabel lblPassword = new JLabel("Password:");
																																								lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																								lblPassword.setBounds(335, 411, 153, 30);
																																								jpanelClientes.add(lblPassword);
																																								
																																										tbCltNome = new JTextField();
																																										tbCltNome.setBounds(345, 103, 351, 31);
																																										jpanelClientes.add(tbCltNome);
																																												
																																														tbCltNum = new JTextField();
																																														tbCltNum.setBounds(345, 254, 225, 31);
																																														jpanelClientes.add(tbCltNum);
																																														
																																																tbCltContacto = new JTextField();
																																																tbCltContacto.setBounds(345, 318, 225, 31);
																																																jpanelClientes.add(tbCltContacto);
																																																
																																																		tbCltUser = new JTextField();
																																																		tbCltUser.setBounds(345, 379, 225, 31);
																																																		jpanelClientes.add(tbCltUser);
																																																		
																																																				tbCltPass = new JPasswordField();
																																																				tbCltPass.setBounds(345, 440, 225, 31);
																																																				jpanelClientes.add(tbCltPass);
																																																				
																																																						JLabel lblContas = new JLabel("Contas");
																																																						lblContas.setFont(new Font("Tahoma", Font.PLAIN, 15));
																																																						lblContas.setBounds(760, 93, 56, 30);
																																																						jpanelClientes.add(lblContas);
																																																						
																																																								JScrollBar scrollBar_3 = new JScrollBar();
																																																								scrollBar_3.setBounds(974, 92, 15, 441);
																																																								jpanelClientes.add(scrollBar_3);
																																																								
																																																										JList lbCltConta = new JList();
																																																										lbCltConta.setBounds(749, 92, 240, 441);
																																																										jpanelClientes.add(lbCltConta);
																																																										
																																																												JButton btCltPesquisa = new JButton("Pesquisa");
																																																												btCltPesquisa.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																																												btCltPesquisa.setBounds(325, 22, 120, 38);
																																																												jpanelClientes.add(btCltPesquisa);
																																																												
																																																														JButton btCltNovo = new JButton("Novo");
																																																														btCltNovo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																																														btCltNovo.setBounds(467, 22, 120, 38);
																																																														jpanelClientes.add(btCltNovo);
																																																														
																																																																JButton btCltEliminar = new JButton("Eliminar");
																																																																btCltEliminar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																																																btCltEliminar.setBounds(609, 22, 120, 38);
																																																																jpanelClientes.add(btCltEliminar);
																																																																
																																																																		JButton btCltconfirmar = new JButton("Confirmar");
																																																																		btCltconfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																																																		btCltconfirmar.setBounds(394, 495, 120, 38);
																																																																		jpanelClientes.add(btCltconfirmar);
																																																																		
																																																																				JButton btCltLimpar = new JButton("Limpar");
																																																																				btCltLimpar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																																																				btCltLimpar.setBounds(557, 493, 120, 38);
																																																																				jpanelClientes.add(btCltLimpar);
																																																																				
																																																																						JRadioButton rbCltcc = new JRadioButton("C.C.");
																																																																						rbCltcc.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																																																						rbCltcc.setBounds(446, 196, 66, 25);
																																																																						jpanelClientes.add(rbCltcc);
																																																																						
																																																																								JRadioButton rbCltbi = new JRadioButton("B.I.");
																																																																								rbCltbi.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																																																								rbCltbi.setBounds(525, 196, 57, 25);
																																																																								jpanelClientes.add(rbCltbi);
																																																																								
																																																																										JRadioButton rbCltPassaporte = new JRadioButton("Passaporte");
																																																																										rbCltPassaporte.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																																																										rbCltPassaporte.setBounds(594, 196, 138, 25);
																																																																										jpanelClientes.add(rbCltPassaporte);
																																																																										
																																																																										JDateChooser dateChooser_3 = new JDateChooser();
																																																																										dateChooser_3.setBounds(345, 163, 217, 31);
																																																																										jpanelClientes.add(dateChooser_3);
														jpanelContas.setBounds(0, 0, 1042, 576);
														JpanelPrincipal.add(jpanelContas);
														jpanelContas.setLayout(null);
														
																JComboBox cbContaspesqconta = new JComboBox();
																cbContaspesqconta.setBounds(61, 40, 219, 38);
																jpanelContas.add(cbContaspesqconta);
																
																		JTextField tbContaspesqconta = new JTextField();
																		tbContaspesqconta.setBounds(61, 84, 219, 31);
																		jpanelContas.add(tbContaspesqconta);
																		
																				JScrollBar scrollBar = new JScrollBar();
																				scrollBar.setBounds(983, 129, 15, 441);
																				jpanelContas.add(scrollBar);
																				
																						JScrollBar scrollBar_1 = new JScrollBar();
																						scrollBar_1.setBounds(279, 127, 15, 441);
																						jpanelContas.add(scrollBar_1);
																						
																								JCheckBox chckbxBruno = new JCheckBox("Bruno");
																								chckbxBruno.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																								chckbxBruno.setBounds(776, 163, 128, 23);
																								jpanelContas.add(chckbxBruno);
																								
																										JCheckBox checkBoxJoana = new JCheckBox("Joana");
																										checkBoxJoana.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																										checkBoxJoana.setBounds(776, 233, 128, 23);
																										jpanelContas.add(checkBoxJoana);
																										
																												JCheckBox checkBoxTamara = new JCheckBox("Tamara");
																												checkBoxTamara.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																												checkBoxTamara.setBounds(776, 198, 128, 23);
																												jpanelContas.add(checkBoxTamara);
																												
																														JList lContas = new JList();
																														lContas.setBounds(54, 127, 240, 442);
																														jpanelContas.add(lContas);
																														
																																JList lClientes = new JList();
																																lClientes.setBounds(758, 128, 240, 442);
																																jpanelContas.add(lClientes);
																																
																																		JLabel lblNewLabel_2 = new JLabel("N\u00BA de Conta:");
																																		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																		lblNewLabel_2.setBounds(378, 128, 113, 24);
																																		jpanelContas.add(lblNewLabel_2);
																																		
																																				JLabel lblDataDeOperao = new JLabel("Data da operação:");
																																				lblDataDeOperao.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																				lblDataDeOperao.setBounds(378, 205, 240, 24);
																																				jpanelContas.add(lblDataDeOperao);
																																				
																																						JLabel lblLimiteDeLevantamento = new JLabel("Limite de Levantamento:");
																																						lblLimiteDeLevantamento.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																						lblLimiteDeLevantamento.setBounds(378, 286, 219, 24);
																																						jpanelContas.add(lblLimiteDeLevantamento);
																																						
																																								tbContasnum = new JTextField();
																																								tbContasnum.setBounds(388, 162, 279, 31);
																																								jpanelContas.add(tbContasnum);
																																										
																																												tbContaslimitelev = new JTextField();
																																												tbContaslimitelev.setBounds(388, 316, 279, 31);
																																												jpanelContas.add(tbContaslimitelev);
																																												
																																														JButton btContasConfirmar = new JButton("Confirmar");
																																														btContasConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																														btContasConfirmar.setBounds(389, 391, 120, 38);
																																														jpanelContas.add(btContasConfirmar);
																																														
																																																JButton btContasCancelar = new JButton("Limpar");
																																																btContasCancelar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																																btContasCancelar.setBounds(536, 391, 120, 38);
																																																jpanelContas.add(btContasCancelar);
																																																
																																																		JButton btContasNovo = new JButton("Novo");
																																																		btContasNovo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																																		btContasNovo.setBounds(317, 464, 120, 38);
																																																		jpanelContas.add(btContasNovo);
																																																		
																																																				JButton btContasEliminar = new JButton("Eliminar");
																																																				btContasEliminar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																																				btContasEliminar.setBounds(461, 464, 120, 38);
																																																				jpanelContas.add(btContasEliminar);
																																																				
																																																						JButton btContasLimpar = new JButton("Cancelar");
																																																						btContasLimpar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																																						btContasLimpar.setBounds(608, 464, 120, 38);
																																																						jpanelContas.add(btContasLimpar);
																																																						
																																																								JLabel lblClientes_1 = new JLabel("Clientes");
																																																								lblClientes_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																																								lblClientes_1.setBounds(759, 98, 164, 24);
																																																								jpanelContas.add(lblClientes_1);
																																																								
																																																								JDateChooser dateChooser_2 = new JDateChooser();
																																																								dateChooser_2.setBounds(388, 243, 279, 31);
																																																								jpanelContas.add(dateChooser_2);
												jpanelOperacoes.setBounds(0, 0, 1042, 576);
												JpanelPrincipal.add(jpanelOperacoes);
												jpanelOperacoes.setLayout(null);
												
														JComboBox cbOperacoespesqClt = new JComboBox();
														cbOperacoespesqClt.setBounds(188, 49, 249, 39);
														jpanelOperacoes.add(cbOperacoespesqClt);
														
																JTextField tbOperacoespesqClt = new JTextField();
																tbOperacoespesqClt.setBounds(188, 92, 250, 31);
																jpanelOperacoes.add(tbOperacoespesqClt);
																
																		JButton btnNewButton = new JButton("Pesquisar");
																		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																		btnNewButton.setBounds(258, 131, 116, 38);
																		jpanelOperacoes.add(btnNewButton);
																		
																				JComboBox cbOperacoesConta = new JComboBox();
																				cbOperacoesConta.addItem("Conta");
																				cbOperacoesConta.setSelectedItem(null);
																				cbOperacoesConta.setBounds(578, 72, 249, 39);
																				jpanelOperacoes.add(cbOperacoesConta);
																				
																						JLabel lblNewLabel_3 = new JLabel("Saldo :");
																						lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																						lblNewLabel_3.setBounds(568, 107, 162, 23);
																						jpanelOperacoes.add(lblNewLabel_3);
																						
																								textField = new JTextField();
																								textField.setBounds(578, 133, 169, 31);
																								jpanelOperacoes.add(textField);
																								
																										JLabel lblConta = new JLabel("Conta:");
																										lblConta.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																										lblConta.setBounds(568, 49, 64, 23);
																										jpanelOperacoes.add(lblConta);
																										
																												JButton cbOperacoDep = new JButton("Depósito");
																												cbOperacoDep.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																												cbOperacoDep.setBounds(243, 207, 176, 38);
																												jpanelOperacoes.add(cbOperacoDep);
																												
																														JButton btnLevantamento = new JButton("Levantamento");
																														btnLevantamento.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																														btnLevantamento.setBounds(432, 207, 176, 38);
																														jpanelOperacoes.add(btnLevantamento);
																														
																																JButton btnTransferncia = new JButton("Transfer\u00EAncia");
																																btnTransferncia.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																btnTransferncia.setBounds(620, 207, 176, 38);
																																jpanelOperacoes.add(btnTransferncia);
																																
																																		JPanel JpanelOpLevantamento = new JPanel();
																																		JpanelOpLevantamento.setVisible(false);
																																		
																																		JDateChooser dateChooser4 = new JDateChooser();
																																		dateChooser4.setBounds(174, 166, 162, 31);
																																		JpanelOpLevantamento.add(dateChooser4);
																																				
																																						JPanel JpanelOpDeposito = new JPanel();
																																						JpanelOpDeposito.setVisible(false);
																																						
																																								JPanel JpanelOpTransferencia = new JPanel();
																																								JpanelOpTransferencia.setVisible(false);
																																								JpanelOpTransferencia.setLayout(null);
																																								JpanelOpTransferencia.setBounds(263, 247, 516, 313);
																																								jpanelOperacoes.add(JpanelOpTransferencia);
																																								
																																										tbTransMontante = new JTextField();
																																										tbTransMontante.setBounds(168, 59, 162, 30);
																																										JpanelOpTransferencia.add(tbTransMontante);
																																										
																																												JLabel lblContaDestino = new JLabel("Conta destino:");
																																												lblContaDestino.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																												lblContaDestino.setBounds(158, 101, 137, 23);
																																												JpanelOpTransferencia.add(lblContaDestino);
																																												
																																														JLabel label_5 = new JLabel("Montante:");
																																														label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																														label_5.setBounds(158, 34, 97, 23);
																																														JpanelOpTransferencia.add(label_5);
																																														
																																																tbTransContaDestino = new JTextField();
																																																tbTransContaDestino.setBounds(168, 126, 162, 30);
																																																JpanelOpTransferencia.add(tbTransContaDestino);
																																																
																																																		JButton btTransConfirmar = new JButton("Confirmar");
																																																		btTransConfirmar.setBounds(146, 317, 97, 30);
																																																		JpanelOpTransferencia.add(btTransConfirmar);
																																																		
																																																				JButton btTransCancelar = new JButton("Cancelar");
																																																				btTransCancelar.setBounds(275, 317, 97, 30);
																																																				JpanelOpTransferencia.add(btTransCancelar);
																																																				
																																																						JLabel lblDataDaOperao = new JLabel("Data da Operação:");
																																																						lblDataDaOperao.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																																						lblDataDaOperao.setBounds(158, 168, 189, 23);
																																																						JpanelOpTransferencia.add(lblDataDaOperao);
																																																								
																																																										JButton btnConfirmar = new JButton("Confirmar");
																																																										btnConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																																										btnConfirmar.setBounds(118, 253, 116, 38);
																																																										JpanelOpTransferencia.add(btnConfirmar);
																																																										
																																																												JButton btnCancelar = new JButton("Cancelar");
																																																												btnCancelar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																																												btnCancelar.setBounds(256, 253, 116, 38);
																																																												JpanelOpTransferencia.add(btnCancelar);
																																																												
																																																												JDateChooser dateChooser_1 = new JDateChooser();
																																																												dateChooser_1.setBounds(168, 198, 162, 31);
																																																												JpanelOpTransferencia.add(dateChooser_1);
																																																												
																																																												
																																						JpanelOpDeposito.setBounds(263, 247, 516, 313);
																																						jpanelOperacoes.add(JpanelOpDeposito);
																																						JpanelOpDeposito.setLayout(null);
																																						
																																								tbDepMontante = new JTextField();
																																								tbDepMontante.setBounds(174, 83, 162, 31);
																																								JpanelOpDeposito.add(tbDepMontante);
																																								
																																										JLabel lblData = new JLabel("Data:");
																																										lblData.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																										lblData.setBounds(164, 131, 50, 23);
																																										JpanelOpDeposito.add(lblData);
																																										
																																												JLabel lblMontantem = new JLabel("Montante Depósito:");
																																												lblMontantem.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																												lblMontantem.setBounds(164, 55, 229, 23);
																																												JpanelOpDeposito.add(lblMontantem);
																																														
																																																JButton btDepConfirmar = new JButton("Confirmar");
																																																btDepConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																																btDepConfirmar.setBounds(129, 223, 120, 38);
																																																JpanelOpDeposito.add(btDepConfirmar);
																																																
																																																		JButton btDepCancelar = new JButton("Cancelar");
																																																		btDepCancelar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																																		btDepCancelar.setBounds(273, 224, 120, 38);
																																																		JpanelOpDeposito.add(btDepCancelar);
																																																		
																																																		JDateChooser dateChooser = new JDateChooser();
																																																		dateChooser.setBounds(174, 166, 162, 31);
																																																		JpanelOpDeposito.add(dateChooser);
																																																																						JpanelOpLevantamento.setBounds(263, 247, 516, 313);
																																																																						jpanelOperacoes.add(JpanelOpLevantamento);
																																																																						JpanelOpLevantamento.setLayout(null);
																																																																						

																																																																							tbLevMontante = new JTextField();
																																																																							tbLevMontante.setBounds(174, 83, 162, 31);
																																																																							JpanelOpLevantamento.add(tbLevMontante);
																																																																							
																																																																									JLabel label = new JLabel("Data:");
																																																																									label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																																																									label.setBounds(164, 131, 50, 23);
																																																																									JpanelOpLevantamento.add(label);
																																																																									
																																																																											JLabel lblMontanteLevantamento = new JLabel("Montante Levantamento:");
																																																																											lblMontanteLevantamento.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
																																																																											lblMontanteLevantamento.setBounds(164, 55, 267, 23);
																																																																											JpanelOpLevantamento.add(lblMontanteLevantamento);
																																																																											
																																																																													tbLevData = new JTextField();
																																																																													tbLevData.setBounds(176, 155, 162, 30);
																																																																													JpanelOpLevantamento.add(tbLevData);
																																																																													
																																																																															JButton btLevConfirmar = new JButton("Confirmar");
																																																																															btLevConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																																																															btLevConfirmar.setBounds(129, 223, 120, 38);
																																																																															JpanelOpLevantamento.add(btLevConfirmar);
																																																																															
																																																																																	JButton btLevCancelar = new JButton("Cancelar");
																																																																																	btLevCancelar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																																																																	btLevCancelar.setBounds(273, 224, 120, 38);
																																																																																	JpanelOpLevantamento.add(btLevCancelar);
																																																																																	
																																																																																			JLabel lblLevantamento = new JLabel("Levantamento:");
																																																																																			lblLevantamento.setFont(new Font("Tahoma", Font.PLAIN, 30));
																																																																																			lblLevantamento.setBounds(162, 13, 205, 43);
																																																																																			JpanelOpLevantamento.add(lblLevantamento);
																																																																																			
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
								jpanelGestao.setBounds(0, 0, 1042, 576);
								JpanelPrincipal.add(jpanelGestao);
								jpanelGestao.setLayout(null);
								
										JLabel lblUsername_1 = new JLabel("Username:");
										lblUsername_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
										lblUsername_1.setBounds(144, 81, 131, 41);
										jpanelGestao.add(lblUsername_1);
										
												tbGestaoUsername = new JTextField();
												tbGestaoUsername.setBounds(144, 134, 271, 33);
												jpanelGestao.add(tbGestaoUsername);
												
														JLabel lblPassword_1 = new JLabel("Password:");
														lblPassword_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
														lblPassword_1.setBounds(144, 178, 131, 41);
														jpanelGestao.add(lblPassword_1);
														
																tbGestaopass = new JTextField();
																tbGestaopass.setBounds(144, 230, 271, 33);
																jpanelGestao.add(tbGestaopass);
																
																		JLabel lblNovaPassword = new JLabel("Novo UserName:");
																		lblNovaPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
																		lblNovaPassword.setBounds(144, 275, 191, 41);
																		jpanelGestao.add(lblNovaPassword);
																		
																				tbGestaoNovoUser = new JTextField();
																				tbGestaoNovoUser.setBounds(144, 327, 271, 33);
																				jpanelGestao.add(tbGestaoNovoUser);
																				
																						JButton btGestaouserconfirmar = new JButton("Confirmar");
																						btGestaouserconfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																						btGestaouserconfirmar.addActionListener(new ActionListener() {
																							public void actionPerformed(ActionEvent e) {

																							}
																						});
																						btGestaouserconfirmar.setBounds(144, 415, 131, 41);
																						jpanelGestao.add(btGestaouserconfirmar);
																						
																								JButton btGestaouserCancelar = new JButton("Cancelar");
																								btGestaouserCancelar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																								btGestaouserCancelar.setBounds(294, 415, 131, 41);
																								jpanelGestao.add(btGestaouserCancelar);
																								
																										JLabel lblPassword_2 = new JLabel("Password:");
																										lblPassword_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
																										lblPassword_2.setBounds(579, 81, 131, 41);
																										jpanelGestao.add(lblPassword_2);
																										
																												tbGestaoPass = new JPasswordField();
																												tbGestaoPass.setBounds(579, 134, 271, 33);
																												jpanelGestao.add(tbGestaoPass);
																												
																														JLabel lblPassword_3 = new JLabel("Nova Password:");
																														lblPassword_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
																														lblPassword_3.setBounds(579, 178, 168, 41);
																														jpanelGestao.add(lblPassword_3);
																														
																																tbGestaoNovapass = new JPasswordField();
																																tbGestaoNovapass.setBounds(579, 230, 271, 33);
																																jpanelGestao.add(tbGestaoNovapass);
																																
																																		JLabel lblConfirmarPassword = new JLabel("Confirmar Password:");
																																		lblConfirmarPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
																																		lblConfirmarPassword.setBounds(579, 275, 271, 41);
																																		jpanelGestao.add(lblConfirmarPassword);
																																		
																																				tbGestaoConfirmPass = new JPasswordField();
																																				tbGestaoConfirmPass.setBounds(579, 327, 271, 33);
																																				jpanelGestao.add(tbGestaoConfirmPass);
																																				
																																						JButton btGestaopassConfirmar = new JButton("Confirmar");
																																						btGestaopassConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																						btGestaopassConfirmar.setBounds(579, 415, 131, 41);
																																						jpanelGestao.add(btGestaopassConfirmar);
																																						
																																								JButton btGestaopassCancelar = new JButton("Cancelar");
																																								btGestaopassCancelar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
																																								btGestaopassCancelar.setBounds(729, 415, 131, 41);
																																								jpanelGestao.add(btGestaopassCancelar);
																																								
																																										JSeparator separator_1 = new JSeparator();
																																										separator_1.setOrientation(SwingConstants.VERTICAL);
																																										separator_1.setForeground(Color.BLACK);
																																										separator_1.setAlignmentX(0.0f);
																																										separator_1.setBounds(483, 68, 29, 433);
																																										jpanelGestao.add(separator_1);

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
