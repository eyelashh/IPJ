
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.List;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.Window;
import java.awt.Canvas;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class BancoAppFun implements Serializable {

	private JFrame frame;
	private JTextField tbCltNome;
	private JTextField tbCltMorada;
	private JTextField tbCltContacto;
	private JTextField tbCltUser;
	private JTextField tbCltPass;
	private JTextField tbContasnum;
	private JTextField tbContaslimitelevop;
	private JTextField tbGestaoUsername;
	private JPasswordField tbGestaopassuser;
	private JTextField tbGestaoNovoUser;
	private JPasswordField tbGestaoPass;
	private JPasswordField tbGestaoNovapass;
	private JPasswordField tbGestaoConfirmPass;
	private JTextField tbContasaldoc;
	private JTextField tbDepMontante;
	private JTextField tbLevMontante;
	private JTextField tbLevData;
	private JTextField tbTransMontante;
	private JTextField tbTransContaDestino;
	private static Funcionario func;
	private static GestaoBanco gb;
	private JTextField tbCltApelido;
	private JTextField tbCltNum;
	private JTextField tbContasSaldo;
	private JTextField tbContaslimitelevdia;
	private JTextField tblJuros;
	private JTextField tbllimitemes;
	private JList lContas;
	private JDateChooser dateChooser_2;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			BancoAppFun window = new BancoAppFun(func, gb);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public BancoAppFun(Funcionario f, GestaoBanco g) {
		func = f;
		gb = g;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				gb.atualizaficheiro(gb.javabank.getUtlizadores(), gb.javabank.getContas());
			}
		});
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
		JButton btnLogOut = new JButton("Logout");
		btnLogOut.setFont(new Font("Lucida Grande", Font.PLAIN, 17));

		// logOut

		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				gb.atualizaficheiro(gb.javabank.getUtlizadores(), gb.javabank.getContas());

				Login logout = new Login();
				logout.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				logout.setLocationRelativeTo(frame);
				logout.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnLogOut.setBounds(1070, 30, 143, 42);
		JpanelCabecalho.add(btnLogOut);

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
		JLabel lUtilizador = new JLabel(func.getNome());
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

		// Painel da conta da parte funcionario
		JPanel jpanelContas = new JPanel();
		jpanelContas.setVisible(false);

		// Painel da gestao do administrador
		JPanel jpanelGestao = new JPanel();
		jpanelGestao.setVisible(false);

		// Painel principal da operaçoes
		JPanel jpanelOperacoes = new JPanel();
		jpanelOperacoes.setBounds(0, 0, 1042, 576);
		JpanelPrincipal.add(jpanelOperacoes);
		jpanelOperacoes.setVisible(false);
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

		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
		JComboBox<String> cbOperacoesConta = new JComboBox<String>(dcbm);
		dcbm.addElement("Contas");
		gb.javabank.addelementoslist(gb.javabank.listanumerodecontas(gb.javabank.getContas()),dcbm);
		cbOperacoesConta.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(!cbOperacoesConta.getSelectedItem().equals("Contas"))
				{
				String s = (String) cbOperacoesConta.getSelectedItem();
				Conta c = gb.javabank.SelectConta(Integer.parseInt(s), gb.javabank.getContas());
				tbContasaldoc.setText(""+c.getSaldo());
				}
				else
				{
					tbContasaldoc.setText("");
				}
			}
		});
		cbOperacoesConta.setBounds(578, 72, 249, 39);
		jpanelOperacoes.add(cbOperacoesConta);

		JLabel lblNewLabel_3 = new JLabel("Saldo :");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(568, 107, 162, 23);
		jpanelOperacoes.add(lblNewLabel_3);

		tbContasaldoc = new JTextField();
		tbContasaldoc.setEditable(false);
		tbContasaldoc.setBounds(578, 133, 169, 31);
		jpanelOperacoes.add(tbContasaldoc);

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

		JPanel JpanelOpTransferencia = new JPanel();
		JpanelOpTransferencia.setVisible(false);

		JPanel JpanelOpLevantamento = new JPanel();
		JpanelOpLevantamento.setVisible(false);

		JPanel JpanelOpDeposito = new JPanel();
		JpanelOpDeposito.setVisible(false);

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
		btDepConfirmar.setBounds(192, 225, 120, 38);
		JpanelOpDeposito.add(btDepConfirmar);

		JDateChooser dtchdeposito = new JDateChooser();
		dtchdeposito.setBounds(174, 166, 162, 31);
		JpanelOpDeposito.add(dtchdeposito);

		JDateChooser dateChooser4 = new JDateChooser();
		dateChooser4.setBounds(174, 166, 162, 31);
		JpanelOpLevantamento.add(dateChooser4);
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

		JButton btLevConfirmar = new JButton("Confirmar");
		btLevConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btLevConfirmar.setBounds(129, 223, 120, 38);
		JpanelOpLevantamento.add(btLevConfirmar);

		JButton btLevCancelar = new JButton("Cancelar");
		btLevCancelar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btLevCancelar.setBounds(273, 224, 120, 38);
		JpanelOpLevantamento.add(btLevCancelar);
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

		//// acaba a constru�ao dos botoes e come�a todos os metedos:

		// Dentro do painel gestao:
		// coloca o painel depositos visivel:
		cbOperacoDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// paineis:
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
		tbGestaoUsername.setEditable(false);
		tbGestaoUsername.setBounds(144, 134, 271, 33);
		jpanelGestao.add(tbGestaoUsername);

		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword_1.setBounds(144, 178, 131, 41);
		jpanelGestao.add(lblPassword_1);

		tbGestaopassuser = new JPasswordField();
		tbGestaopassuser.setBounds(144, 230, 271, 33);
		jpanelGestao.add(tbGestaopassuser);

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
				if (func.getPassword().equals(new String(tbGestaopassuser.getPassword()))) {
					func.setUsername(tbGestaoNovoUser.getText());
					tbGestaoUsername.setText(null);
					tbGestaopassuser.setText(null);
					tbGestaoNovoUser.setText(null);
					JOptionPane.showMessageDialog(null, "Altera��o de Nome efectuado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Dados errados! Confirme o que escreveu!");
				}
			}
		});
		btGestaouserconfirmar.setBounds(144, 415, 131, 41);
		jpanelGestao.add(btGestaouserconfirmar);

		JButton btGestaouserCancelar = new JButton("Cancelar");
		btGestaouserCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbGestaopassuser.setText(null);
				tbGestaoNovoUser.setText(null);
			}
		});
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
		btGestaopassConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((func.getPassword().equals(new String(tbGestaoPass.getPassword())))
						&& new String(tbGestaoNovapass.getPassword())
								.equals(new String(tbGestaoConfirmPass.getPassword()))) {

					func.setPassword(new String(tbGestaoNovapass.getPassword()));
					JOptionPane.showMessageDialog(null, "Altera��o efectuada com sucesso!");
					tbGestaoPass.setText(null);
					tbGestaoNovapass.setText(null);
					tbGestaoConfirmPass.setText(null);

				} else {
					JOptionPane.showMessageDialog(null, "Dados errados! Confirme os dados introduzidos!");
				}
			}
		});
		btGestaopassConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btGestaopassConfirmar.setBounds(579, 415, 131, 41);
		jpanelGestao.add(btGestaopassConfirmar);

		JButton btGestaopassCancelar = new JButton("Cancelar");
		btGestaopassCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbGestaoPass.setText(null);
				tbGestaoNovapass.setText(null);
				tbGestaoConfirmPass.setText(null);
			}
		});
		btGestaopassCancelar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btGestaopassCancelar.setBounds(729, 415, 131, 41);
		jpanelGestao.add(btGestaopassCancelar);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setAlignmentX(0.0f);
		separator_1.setBounds(483, 68, 29, 433);
		jpanelGestao.add(separator_1);

		jpanelContas.setBounds(0, 0, 1042, 576);
		JpanelPrincipal.add(jpanelContas);
		jpanelContas.setLayout(null);

		JComboBox cbContaspesqconta = new JComboBox();
		cbContaspesqconta.setBounds(26, 12, 219, 38);
		jpanelContas.add(cbContaspesqconta);

		JTextField tbContaspesqconta = new JTextField();
		tbContaspesqconta.setBounds(26, 63, 238, 31);
		jpanelContas.add(tbContaspesqconta);

		// Lista contas painel conta:
		DefaultListModel<String> dmconta = new DefaultListModel<String>();
		lContas = new JList(dmconta);
		lContas.setBounds(24, 99, 240, 471);
		gb.javabank.addelementoslist(gb.javabank.listanumerodecontas(gb.javabank.getContas()), dmconta);
		jpanelContas.add(lContas);

		JList lClientes = new JList();
		lClientes.setBounds(758, 44, 240, 526);
		jpanelContas.add(lClientes);

		JLabel lblNewLabel_2 = new JLabel("N\u00BA de Conta:");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(323, 118, 113, 24);
		jpanelContas.add(lblNewLabel_2);

		JLabel lblDataDeCriacao = new JLabel("Data da Cria\u00E7\u00E3o");
		lblDataDeCriacao.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblDataDeCriacao.setBounds(304, 168, 132, 24);
		jpanelContas.add(lblDataDeCriacao);

		JLabel lblLimiteDeLevantamento = new JLabel("Limite de Levantamento:");
		lblLimiteDeLevantamento.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblLimiteDeLevantamento.setBounds(485, 212, 183, 24);
		jpanelContas.add(lblLimiteDeLevantamento);

		tbContasnum = new JTextField();
		tbContasnum.setEditable(false);
		tbContasnum.setBounds(448, 117, 279, 31);
		jpanelContas.add(tbContasnum);

		tbContaslimitelevop = new JTextField();
		tbContaslimitelevop.setBounds(448, 249, 279, 31);
		jpanelContas.add(tbContaslimitelevop);

		JButton btContasConfirmar = new JButton("Confirmar");

		btContasConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btContasConfirmar.setBounds(470, 472, 120, 38);
		jpanelContas.add(btContasConfirmar);

		JButton btContasNovo = new JButton("Novo");

		btContasNovo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btContasNovo.setBounds(352, 523, 120, 38);
		jpanelContas.add(btContasNovo);

		JButton btContasEliminar = new JButton("Eliminar");

		btContasEliminar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btContasEliminar.setBounds(484, 523, 120, 38);
		jpanelContas.add(btContasEliminar);

		JLabel lblClientes_1 = new JLabel("Clientes");
		lblClientes_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblClientes_1.setBounds(758, 19, 164, 24);
		jpanelContas.add(lblClientes_1);

		dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(448, 168, 279, 31);
		jpanelContas.add(dateChooser_2);

		tbContasSaldo = new JTextField();
		tbContasSaldo.setEditable(false);
		tbContasSaldo.setBounds(448, 337, 279, 31);
		jpanelContas.add(tbContasSaldo);

		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblSaldo.setBounds(366, 338, 57, 24);
		jpanelContas.add(lblSaldo);

		JButton btContaslimpar = new JButton("Limpar");

		btContaslimpar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btContaslimpar.setBounds(626, 523, 120, 38);
		jpanelContas.add(btContaslimpar);

		JLabel lblLimiteDeLevantamento_1 = new JLabel("Por dia:");
		lblLimiteDeLevantamento_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblLimiteDeLevantamento_1.setBounds(356, 294, 67, 24);
		jpanelContas.add(lblLimiteDeLevantamento_1);

		tbContaslimitelevdia = new JTextField();
		tbContaslimitelevdia.setBounds(448, 293, 279, 31);
		jpanelContas.add(tbContaslimitelevdia);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnPesquisar.setBounds(257, 11, 99, 38);
		jpanelContas.add(btnPesquisar);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblTipo.setBounds(379, 63, 44, 24);
		jpanelContas.add(lblTipo);

		JLabel lblDia = new JLabel("Por Opera\u00E7ao:");
		lblDia.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblDia.setBounds(304, 250, 119, 24);
		jpanelContas.add(lblDia);

		tblJuros = new JTextField();
		tblJuros.setVisible(false);
		tblJuros.setBounds(448, 381, 279, 31);
		jpanelContas.add(tblJuros);

		JLabel lblJuros = new JLabel("Juros (%):");
		lblJuros.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblJuros.setBounds(352, 382, 83, 24);
		jpanelContas.add(lblJuros);
		lblJuros.setVisible(false);

		JRadioButton rdbtnContaCorrente = new JRadioButton("Conta Corrente");
		rdbtnContaCorrente.setSelected(true);

		rdbtnContaCorrente.setBounds(447, 65, 132, 25);
		jpanelContas.add(rdbtnContaCorrente);

		JRadioButton rdbtnContaPoupanca = new JRadioButton("Conta Poupan\u00E7a");

		rdbtnContaPoupanca.setBounds(583, 65, 144, 25);
		jpanelContas.add(rdbtnContaPoupanca);

		ButtonGroup bgconta = new ButtonGroup();
		bgconta.add(rdbtnContaPoupanca);
		bgconta.add(rdbtnContaCorrente);

		tbllimitemes = new JTextField();
		tbllimitemes.setVisible(false);
		tbllimitemes.setBounds(450, 425, 277, 31);
		jpanelContas.add(tbllimitemes);
		tbllimitemes.setColumns(10);

		JLabel lbllimitemes = new JLabel("Limite Mes:");
		lbllimitemes.setVisible(false);
		lbllimitemes.setFont(new Font("Dialog", Font.PLAIN, 17));
		lbllimitemes.setBounds(346, 426, 90, 24);
		jpanelContas.add(lbllimitemes);

		// Painel principal CLientes
		JPanel jpanelClientes = new JPanel();
		jpanelClientes.setBounds(0, 0, 1042, 576);
		JpanelPrincipal.add(jpanelClientes);
		jpanelClientes.setVisible(true);
		jpanelClientes.setLayout(null);
		jpanelClientes.setLayout(null);

		// Aqui estive a adicionar itens ao combobox de pesquisa
		String[] itens = new String[] { "Nome", "ID" };
		JComboBox cbCltPesq = new JComboBox(itens);
		cbCltPesq.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		cbCltPesq.setBounds(47, 12, 227, 34);
		jpanelClientes.add(cbCltPesq);

		JTextField tbCltPesq = new JTextField();
		tbCltPesq.setBounds(47, 49, 227, 30);
		jpanelClientes.add(tbCltPesq);

		JScrollBar scrollBar_2 = new JScrollBar();
		scrollBar_2.setBounds(273, 92, 15, 441);
		jpanelClientes.add(scrollBar_2);

		// lista de clientes no painel de clientes;
		DefaultListModel<String> dmclt = new DefaultListModel<String>();
		JList<String> lbClt = new JList<String>(dmclt);
		lbClt.setBounds(48, 92, 240, 441);
		gb.javabank.addelementoslist(gb.javabank.listarClientes(gb.javabank.getUtlizadores()), dmclt);
		jpanelClientes.add(lbClt);

		JButton btCltPesquisa = new JButton("Pesquisa");
		btCltPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btCltPesquisa.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btCltPesquisa.setBounds(325, 22, 120, 38);
		jpanelClientes.add(btCltPesquisa);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(345, 72, 57, 30);
		jpanelClientes.add(lblNewLabel_1);

		JLabel lblDNascimento = new JLabel("D. Nascimento:");
		lblDNascimento.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblDNascimento.setBounds(325, 147, 120, 30);
		jpanelClientes.add(lblDNascimento);

		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblDocumento.setBounds(335, 193, 108, 30);
		jpanelClientes.add(lblDocumento);

		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNmero.setBounds(345, 236, 66, 30);
		jpanelClientes.add(lblNmero);

		JLabel lblContacto = new JLabel("Contacto:");
		lblContacto.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblContacto.setBounds(335, 329, 81, 31);
		jpanelClientes.add(lblContacto);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblUsername.setBounds(330, 392, 81, 30);
		jpanelClientes.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblPassword.setBounds(335, 459, 81, 30);
		jpanelClientes.add(lblPassword);

		tbCltNome = new JTextField();
		tbCltNome.setBounds(345, 103, 179, 31);
		jpanelClientes.add(tbCltNome);

		tbCltMorada = new JTextField();
		tbCltMorada.setBounds(420, 274, 309, 31);
		jpanelClientes.add(tbCltMorada);

		tbCltContacto = new JTextField();
		tbCltContacto.setBounds(420, 331, 309, 31);
		jpanelClientes.add(tbCltContacto);

		tbCltUser = new JTextField();
		tbCltUser.setBounds(420, 394, 309, 31);
		jpanelClientes.add(tbCltUser);

		tbCltPass = new JTextField();
		tbCltPass.setBounds(420, 461, 309, 31);
		jpanelClientes.add(tbCltPass);

		JLabel lblContas = new JLabel("Contas");
		lblContas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContas.setBounds(780, 48, 56, 30);
		jpanelClientes.add(lblContas);

		JScrollBar scrollBar_3 = new JScrollBar();
		scrollBar_3.setBounds(1005, 92, 15, 441);
		jpanelClientes.add(scrollBar_3);

		JList lbCltConta = new JList();
		lbCltConta.setBounds(780, 92, 240, 441);
		jpanelClientes.add(lbCltConta);

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
		btCltconfirmar.setBounds(506, 505, 120, 38);
		jpanelClientes.add(btCltconfirmar);

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

		ButtonGroup bg = new ButtonGroup();
		bg.add(rbCltcc);
		bg.add(rbCltbi);
		bg.add(rbCltPassaporte);

		JDateChooser dateChooser_3 = new JDateChooser();
		dateChooser_3.setBounds(457, 147, 260, 31);
		jpanelClientes.add(dateChooser_3);

		tbCltApelido = new JTextField();
		tbCltApelido.setBounds(536, 103, 193, 31);
		jpanelClientes.add(tbCltApelido);

		JLabel lblApelido = new JLabel("Apelido:");
		lblApelido.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblApelido.setBounds(536, 72, 72, 30);
		jpanelClientes.add(lblApelido);

		tbCltNum = new JTextField();
		tbCltNum.setBounds(420, 230, 309, 31);
		jpanelClientes.add(tbCltNum);

		JLabel lblMorada = new JLabel("Morada:");
		lblMorada.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblMorada.setBounds(345, 272, 66, 30);
		jpanelClientes.add(lblMorada);

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
				tbGestaoUsername.setText(func.getUsername());
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

		// a�ao do botao novo:
		btCltNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// limpa tudo:

				lbClt.clearSelection();
				lbCltConta.clearSelection();
				tbCltNome.setText("");
				tbCltApelido.setText("");
				tbCltMorada.setText(null);
				tbCltContacto.setText(null);
				bg.clearSelection();
				tbCltUser.setText("");
				tbCltPass.setText("");
				tbCltNum.setText("");
				dateChooser_3.setDate(null);

			}
		});

		// painel de clientes:

		// bt confirmar (adicionar ou alterar )
		btCltconfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String opselect = "";
				if (rbCltcc.isSelected()) {
					opselect = rbCltcc.getText();
				}
				if (rbCltbi.isSelected()) {
					opselect = rbCltbi.getText();
				}
				if (rbCltPassaporte.isSelected()) {
					opselect = rbCltPassaporte.getText();
				}

				// se nao estiver selecionado nenhum cliente entao cria um novo/ caso exista
				// algum elemento selecionado da lista faz um update:
				if (lbClt.isSelectionEmpty()) {

					// adicionar Cliente:
					// criar automaticamente o id;
					int id = (gb.javabank.getUtlizadores().get(gb.javabank.getUtlizadores().size() - 1)
							.getIdUtilizador()) + 1;
					if (id == 0) {
						id++;
					}

					// valida qual dos botoes estao atualizados:

					// esta a ser criasdo o novo cliente:
					Utilizador clt = new Cliente(id, tbCltNome.getText(), tbCltApelido.getText(),
							dateChooser_3.getDate(), opselect, Integer.parseInt(tbCltNum.getText()),
							tbCltMorada.getText(), Integer.parseInt(tbCltContacto.getText()), tbCltUser.getText(),
							tbCltPass.getText());
					gb.javabank.getUtlizadores().add(clt);

					// faz atualiza�ao da lista (elimina e de seguida preenche tudo)
					dmclt.removeAllElements();
					gb.javabank.addelementoslist(gb.javabank.listarClientes(gb.javabank.getUtlizadores()), dmclt);
					JOptionPane.showMessageDialog(null, "Cliente criado com sucesso!");
				} else {
					// atualizar Cliente:
					// seleciona id;
					String s = (String) lbClt.getSelectedValue();
					s = s.substring(0, s.indexOf("*"));

					// metedo para atualizar:
					gb.javabank.atualizacliente(
							(Cliente) gb.javabank.selectUtilizador(Integer.parseInt(s), gb.javabank.getUtlizadores()),
							tbCltNome.getText(), tbCltApelido.getText(), dateChooser_3.getDate(), opselect,
							Integer.parseInt(tbCltNum.getText()), tbCltMorada.getText(),
							Integer.parseInt(tbCltContacto.getText()), tbCltUser.getText(), tbCltPass.getText());
					JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
				}

				lbClt.clearSelection();
				lbCltConta.clearSelection();
				tbCltNome.setText("");
				tbCltApelido.setText("");
				tbCltMorada.setText(null);
				tbCltContacto.setText(null);
				bg.clearSelection();
				tbCltUser.setText("");
				tbCltPass.setText("");
				tbCltNum.setText("");
				dateChooser_3.setDate(null);

			}
		});

		// Metedo que seleciona e passa todos os argumentos para as caixas de texto :
		lbClt.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				bg.clearSelection();
				if (!lbClt.isSelectionEmpty()) {
					String s = (String) lbClt.getSelectedValue();
					s = s.substring(0, s.indexOf("*"));
					Cliente c = (Cliente) gb.javabank.selectUtilizador(Integer.parseInt(s),
							gb.javabank.getUtlizadores());
					tbCltNome.setText(c.getNome());
					tbCltApelido.setText(c.getSobrenome());
					tbCltMorada.setText(c.getMorada());
					tbCltContacto.setText("" + c.getContacto());
					tbCltUser.setText(c.getUsername());
					tbCltPass.setText(c.getPassword());
					tbCltNum.setText("" + c.getNumidentificacao());
					dateChooser_3.setDate(c.getDataDeNascimento());
					if (c.getTipoIndentificacao().equals("C.C.")) {
						rbCltcc.setSelected(true);
					}
					if (c.getTipoIndentificacao().equals("B.I.")) {
						rbCltbi.setSelected(true);
					}
					if (c.getTipoIndentificacao().equals("Passaporte")) {
						rbCltPassaporte.setSelected(true);
					}

				}
			}
		});

		// botao eliminar

		btCltEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// primeiro ve qual o id selecionado!
				String s = lbClt.getSelectedValue();
				s = s.substring(0, s.indexOf("*"));

				// elimina o cliente:
				gb.javabank.eliminautilizador(Integer.parseInt(s), gb.javabank.getUtlizadores());

				// depois limpa os campos do formulario:
				lbClt.clearSelection();
				lbCltConta.clearSelection();
				tbCltNome.setText("");
				tbCltApelido.setText("");
				tbCltMorada.setText(null);
				tbCltContacto.setText(null);
				bg.clearSelection();
				tbCltUser.setText("");
				tbCltPass.setText("");
				tbCltNum.setText("");
				dateChooser_3.setDate(null);
				rdbtnContaCorrente.setSelected(false);
				rdbtnContaPoupanca.setSelected(false);

				// atualiza lista:
				dmclt.removeAllElements();
				gb.javabank.addelementoslist(gb.javabank.listarClientes(gb.javabank.getUtlizadores()), dmclt);

			}
		});

		// metedos depainel de contas:

		// muda a conta corrente e conta ordem
		rdbtnContaCorrente.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnContaCorrente.isSelected()) {
					lblJuros.setVisible(false);
					tblJuros.setVisible(false);
					lbllimitemes.setVisible(false);
					tbllimitemes.setVisible(false);

				}

			}
		});

		rdbtnContaPoupanca.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnContaPoupanca.isSelected()) {
					lblJuros.setVisible(true);
					tblJuros.setVisible(true);
					lbllimitemes.setVisible(true);
					tbllimitemes.setVisible(true);
				}
			}
		});

		// adicionar nova conta ou atualizar:
		btContasConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (lContas.isSelectionEmpty()) {

					ArrayList<Cliente> cliente = new ArrayList<Cliente>();
					Cartao cartao = new Cartao();

					if (rdbtnContaCorrente.isSelected()) {
						Conta c = new ContaCorrente(Integer.parseInt(tbContasnum.getText()), dateChooser_2.getDate(),
								Double.parseDouble(tbContasSaldo.getText()), cliente,
								Double.parseDouble(tbContaslimitelevop.getText()),
								Double.parseDouble(tbContaslimitelevdia.getText()), cartao);
						gb.javabank.getContas().add(c);
					} else {

						Conta c = new ContaPoupanca(Integer.parseInt(tbContasnum.getText()), dateChooser_2.getDate(),
								Double.parseDouble(tbContasSaldo.getText()), cliente,
								Double.parseDouble(tbContaslimitelevop.getText()),
								Double.parseDouble(tbContaslimitelevdia.getText()),
								Double.parseDouble(tblJuros.getText()), Double.parseDouble(tbllimitemes.getText()));
						gb.javabank.getContas().add(c);
					}
					JOptionPane.showMessageDialog(null, "Conta adicionada com sucesso!");

				} else {
					// atualizar:

					Conta c = gb.javabank.SelectConta(Integer.parseInt((String) lContas.getSelectedValue()),
							gb.javabank.getContas());

					if (c instanceof ContaCorrente) {
						// gb.javabank.atualizarconta(c, Double.parseDouble(tbLevMontante.getText()) ,
						// Double.parseDouble(tbContaslimitelevdia.getText()) , 0.0, 0.0);
						gb.javabank.atualizarconta(c, Double.parseDouble(tbContaslimitelevop.getText()),
								Double.parseDouble(tbContaslimitelevdia.getText()), 0.0, 0.0);
					} else {

						gb.javabank.atualizarconta(c, Double.parseDouble(tbContaslimitelevop.getText()),
								Double.parseDouble(tbContaslimitelevdia.getText()),
								Double.parseDouble(tblJuros.getText()), Double.parseDouble(tbllimitemes.getText()));
					}

					JOptionPane.showMessageDialog(null, "Conta atualizada com sucesso!");

				}

				lContas.clearSelection();
				tbContasnum.setText(null);
				dateChooser_2.setDate(null);
				tbContaslimitelevop.setText(null);
				tbContasSaldo.setText(null);
				tbContasSaldo.setEditable(false);
				tbContasnum.setText(null);
				tbContaslimitelevdia.setText(null);
				tblJuros.setText(null);
				tbllimitemes.setText(null);
				dmconta.removeAllElements();
				gb.javabank.addelementoslist(gb.javabank.listanumerodecontas(gb.javabank.getContas()), dmconta);

			}
		});

		// limpar campos:
		btContaslimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lContas.clearSelection();
				tbContasnum.setText(null);
				dateChooser_2.setDate(null);
				tbContaslimitelevop.setText(null);
				tbContasSaldo.setText(null);
				tbContasSaldo.setEditable(false);
				tbContaslimitelevdia.setText(null);
				rdbtnContaCorrente.setSelected(true);
				rdbtnContaPoupanca.setSelected(false);
				tblJuros.setText(null);
				dateChooser_2.setEnabled(true);
				tbllimitemes.setText(null);

			}
		});

		// prepara campos para cria�ao de nova conta ou atualiza a lista selecionada:
		btContasNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numconta;
				if (gb.javabank.getContas().size() == 0) {
					numconta = 1;
				} else {
					numconta = gb.javabank.getContas().get(gb.javabank.getContas().size() - 1).getIdConta() + 1;
				}
				lContas.clearSelection();
				tbContasnum.setText("" + numconta);
				dateChooser_2.setDate(null);
				tbContaslimitelevop.setText(null);
				tbContasSaldo.setText(null);
				tbContasSaldo.setEditable(true);
				dateChooser_2.setEnabled(true);
				tbContaslimitelevdia.setText(null);
				rdbtnContaCorrente.setSelected(true);
				rdbtnContaPoupanca.setSelected(false);
				tblJuros.setText(null);
				tbllimitemes.setText(null);

			}
		});
		// selecionar conta e preencher so campos correctos:
		lContas.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				if (!lContas.isSelectionEmpty()) {

					Conta c = gb.javabank.SelectConta(Integer.parseInt((String) lContas.getSelectedValue()),
							gb.javabank.getContas());
					tbContasnum.setText("" + c.getIdConta());
					dateChooser_2.setDate(c.getDataCriacao());
					dateChooser_2.setEnabled(false);
					tbContaslimitelevop.setText("" + c.getValorMaxLevantamento());
					tbContasSaldo.setText("" + c.getSaldo());
					tbContasSaldo.setEditable(false);
					tbContaslimitelevdia.setText(c.getValorMaxDia() + "");

					if (c instanceof ContaPoupanca) {
						rdbtnContaPoupanca.setSelected(true);
						rdbtnContaCorrente.setSelected(false);
						Double juros = ((ContaPoupanca) c).getTaxaJuros();
						tblJuros.setText(juros + "");
						Double limite = ((ContaPoupanca) c).getLimiteMensalDebito();
						tbllimitemes.setText("" + limite);
					} else {
						rdbtnContaPoupanca.setSelected(false);
						rdbtnContaCorrente.setSelected(true);
					}

				}
			}
		});

		
		// elimina contas:
		btContasEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!lContas.isSelectionEmpty()) {
					gb.javabank.eliminaconta(Integer.parseInt(tbContasnum.getText()), gb.javabank.getContas());
					lContas.clearSelection();
					tbContasnum.setText(null);
					dateChooser_2.setDate(null);
					tbContaslimitelevop.setText(null);
					tbContasSaldo.setText(null);
					tbContasSaldo.setEditable(false);
					tbContaslimitelevdia.setText(null);
					rdbtnContaCorrente.setSelected(true);
					rdbtnContaPoupanca.setSelected(false);
					tblJuros.setText(null);
					dateChooser_2.setEnabled(true);
					tbllimitemes.setText(null);
					dmconta.removeAllElements();
					gb.javabank.addelementoslist(gb.javabank.listanumerodecontas(gb.javabank.getContas()), dmconta);
					JOptionPane.showMessageDialog(null, "Conta eliminada com sucesso!");

				}

			}
		});

		
		// efectuar deposito:
				btDepConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Seleciona conta:
						String s = (String) cbOperacoesConta.getSelectedItem();
						Conta c = gb.javabank.SelectConta(Integer.parseInt(s), gb.javabank.getContas());
						
						// alterar conta (faz deposito):
						c.setSaldo(c.getSaldo()+Double.parseDouble(tbContasaldoc.getText()));
						
						// cria opera�ao:
						String descricao = dtchdeposito.getDate()+" - Deposito: valor "+tbContasaldoc.getText();
						int idop = 1;
						if(c.getOperacoes().size()!=0)
						{
						idop = 	c.getOperacoes().get(c.getOperacoes().size()-1).getIdOperacao()+1;
						}
						Operacao op = new Deposito(idop,func,dtchdeposito.getDate(),Double.parseDouble(tbContasaldoc.getText()),descricao);
						c.getOperacoes().add(op);
						JOptionPane.showMessageDialog(null, "Deposito efectuado!");

					}
				});
		
	}
}
