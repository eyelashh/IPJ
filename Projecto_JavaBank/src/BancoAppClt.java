
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;

public class BancoAppClt {

	private JFrame frame;
	private JTextField textFieldCltNumero;
	private JTextField textFieldCltData;
	private JTextField textFieldCltSaldo;
	private JTextField textFieldCltCartao;
	private JTextField textFieldCltSaldo2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			BancoAppClt window = new BancoAppClt();
			window.frame.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// });
	// }

	/**
	 * Create the application.
	 */
	public BancoAppClt() {
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
		JLabel lblBemVindo = new JLabel("Bem-Vindo(a) -");
		lblBemVindo.setVerifyInputWhenFocusTarget(false);
		lblBemVindo.setForeground(new Color(0, 0, 0));
		lblBemVindo.setFont(new Font("Helvetica", Font.PLAIN, 33));
		lblBemVindo.setBounds(348, 41, 243, 52);
		JpanelCabecalho.add(lblBemVindo);

		// texto no cabeçalho : utilizador
		JLabel lUtilizador = new JLabel("Cliente");
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

		// Painel do menu que tem os botoes
		JPanel JpanelMenu = new JPanel();
		JpanelMenu.setBackground(Color.WHITE);
		JpanelMenu.setBounds(10, 135, 170, 605);
		frame.getContentPane().add(JpanelMenu);
		JpanelMenu.setLayout(null);

		// Painel principal
		JPanel JpanelPrincipal = new JPanel();
		// JpanelPrincipal.setBackground(Color.WHITE);
		JpanelPrincipal.setBounds(198, 142, 1065, 598);
		frame.getContentPane().add(JpanelPrincipal);
		JpanelPrincipal.setLayout(null);

		// Painel principal cartao
		JPanel JPCltCartao = new JPanel();
		JPCltCartao.setBounds(16, 16, 1032, 563);
		JpanelPrincipal.add(JPCltCartao);
		JPCltCartao.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(581, 135, 249, 39);
		JPCltCartao.add(comboBox);

		textField_9 = new JTextField();
		textField_9.setBounds(581, 178, 250, 31);
		JPCltCartao.add(textField_9);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(581, 69, 249, 39);
		JPCltCartao.add(comboBox_1);

		JLabel lblNomeAGravar = new JLabel("Nome a gravar");
		lblNomeAGravar.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNomeAGravar.setBounds(591, 251, 229, 23);
		JPCltCartao.add(lblNomeAGravar);

		textField_10 = new JTextField();
		textField_10.setBounds(601, 279, 229, 31);
		JPCltCartao.add(textField_10);

		JLabel lblCdigoDigitos = new JLabel("Código 3 digitos:");
		lblCdigoDigitos.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblCdigoDigitos.setBounds(591, 327, 172, 23);
		JPCltCartao.add(lblCdigoDigitos);

		textField_11 = new JTextField();
		textField_11.setBounds(603, 351, 227, 30);
		JPCltCartao.add(textField_11);

		JButton btnPedirCarto = new JButton("Pedir Cartão");
		btnPedirCarto.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnPedirCarto.setBounds(583, 416, 120, 38);
		JPCltCartao.add(btnPedirCarto);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnLimpar.setBounds(727, 417, 120, 38);
		JPCltCartao.add(btnLimpar);
		
		JLabel lblCartoVerde = new JLabel("Cartão Verde");
		lblCartoVerde.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblCartoVerde.setBounds(116, 341, 151, 16);
		JPCltCartao.add(lblCartoVerde);
		
		JLabel lblValidadeAnos = new JLabel("Validade: 5 anos");
		lblValidadeAnos.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblValidadeAnos.setBounds(116, 371, 151, 16);
		JPCltCartao.add(lblValidadeAnos);
		
		JLabel lblRedeVisaE = new JLabel("Rede: Visa e Multibanco");
		lblRedeVisaE.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblRedeVisaE.setBounds(116, 402, 264, 16);
		JPCltCartao.add(lblRedeVisaE);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/tamarabarros/Dropbox/IPJ_ProjectoFinal/Design/JavaBank2/imagens/cartao34.jpg"));
		lblNewLabel_1.setBounds(99, 93, 335, 207);
		JPCltCartao.add(lblNewLabel_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setAlignmentX(0.0f);
		separator_2.setBounds(509, 69, 29, 433);
		JPCltCartao.add(separator_2);

		

		// Painel principal gestao
		JPanel JPCltGestao = new JPanel();
		JPCltGestao.setBounds(16, 16, 1032, 563);
		JpanelPrincipal.add(JPCltGestao);
		JPCltGestao.setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setAlignmentX(0.0f);
		separator_1.setBounds(483, 68, 29, 433);
		JPCltGestao.add(separator_1);

		JLabel label = new JLabel("Password :");
		label.setVerifyInputWhenFocusTarget(false);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label.setBounds(570, 95, 131, 41);
		JPCltGestao.add(label);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(570, 148, 271, 33);
		JPCltGestao.add(textField_3);

		JLabel label_1 = new JLabel("Nova Password :");
		label_1.setVerifyInputWhenFocusTarget(false);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_1.setBounds(570, 192, 168, 41);
		JPCltGestao.add(label_1);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(570, 244, 271, 33);
		JPCltGestao.add(textField_4);

		JLabel label_2 = new JLabel("Confirmar Password :");
		label_2.setVerifyInputWhenFocusTarget(false);
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_2.setBounds(570, 289, 271, 41);
		JPCltGestao.add(label_2);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(570, 341, 271, 33);
		JPCltGestao.add(textField_5);

		JButton button = new JButton("Confirmar");
		button.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button.setBounds(570, 429, 131, 41);
		JPCltGestao.add(button);

		JButton button_2 = new JButton("Cancelar");
		button_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button_2.setBounds(720, 429, 131, 41);
		JPCltGestao.add(button_2);

		JButton button_3 = new JButton("Cancelar");
		button_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button_3.setBounds(285, 429, 131, 41);
		JPCltGestao.add(button_3);

		JButton button_4 = new JButton("Confirmar");
		button_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button_4.setBounds(135, 429, 131, 41);
		JPCltGestao.add(button_4);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(135, 341, 271, 33);
		JPCltGestao.add(textField_6);

		JLabel label_3 = new JLabel("Nova Username :");
		label_3.setVerifyInputWhenFocusTarget(false);
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_3.setBounds(135, 289, 191, 41);
		JPCltGestao.add(label_3);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(135, 244, 271, 33);
		JPCltGestao.add(textField_7);

		JLabel label_4 = new JLabel("Password :");
		label_4.setVerifyInputWhenFocusTarget(false);
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_4.setBounds(135, 192, 131, 41);
		JPCltGestao.add(label_4);

		textField_8 = new JTextField();
		textField_8.setBounds(135, 148, 271, 33);
		JPCltGestao.add(textField_8);

		JLabel label_5 = new JLabel("Username :");
		label_5.setVerifyInputWhenFocusTarget(false);
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_5.setBounds(135, 95, 131, 41);
		JPCltGestao.add(label_5);

		// Painel principal transferencia
		JPanel JPCltTransf = new JPanel();
		JPCltTransf.setBounds(16, 16, 1032, 563);
		JpanelPrincipal.add(JPCltTransf);
		JPCltTransf.setLayout(null);

		// Box pesquisa da conta do cliente
		JComboBox comboBoxCLTPesquisa = new JComboBox();
		comboBoxCLTPesquisa.setBounds(211, 67, 249, 39);
		JPCltTransf.add(comboBoxCLTPesquisa);

		JLabel labelClt = new JLabel("Saldo:");
		labelClt.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		labelClt.setBounds(550, 67, 66, 16);
		JPCltTransf.add(labelClt);

		textFieldCltSaldo2 = new JTextField();
		textFieldCltSaldo2.setBounds(560, 95, 185, 30);
		JPCltTransf.add(textFieldCltSaldo2);

		textField = new JTextField();
		textField.setBounds(367, 204, 185, 30);
		JPCltTransf.add(textField);

		JLabel lblMontante = new JLabel("Montante:");
		lblMontante.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblMontante.setBounds(357, 176, 131, 16);
		JPCltTransf.add(lblMontante);

		textField_1 = new JTextField();
		textField_1.setBounds(367, 285, 287, 30);
		JPCltTransf.add(textField_1);

		JLabel lblContaDestino = new JLabel("Conta Destino:");
		lblContaDestino.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblContaDestino.setBounds(357, 257, 147, 16);
		JPCltTransf.add(lblContaDestino);

		textField_2 = new JTextField();
		textField_2.setBounds(367, 367, 185, 30);
		JPCltTransf.add(textField_2);

		JLabel lblDataDaOperao = new JLabel("Data da Operação:");
		lblDataDaOperao.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblDataDaOperao.setBounds(357, 339, 190, 16);
		JPCltTransf.add(lblDataDaOperao);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnConfirmar.setBounds(337, 435, 120, 38);
		JPCltTransf.add(btnConfirmar);

		JButton button_1 = new JButton("Limpar");
		button_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button_1.setBounds(509, 435, 120, 38);
		JPCltTransf.add(button_1);

		// Painel principal cliente
		JPanel JPCltCM = new JPanel();
		JPCltCM.setBounds(16, 16, 1032, 563);
		JpanelPrincipal.add(JPCltCM);
		JPCltCM.setLayout(null);

		// box onde escolhemos qual conta o cliente quer ver
		JComboBox comboBoxCltConta = new JComboBox();
		comboBoxCltConta.setBounds(121, 67, 287, 39);
		JPCltCM.add(comboBoxCltConta);

		JLabel textFieldCltNumero1 = new JLabel("Número:");
		textFieldCltNumero1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textFieldCltNumero1.setBounds(121, 148, 94, 16);
		JPCltCM.add(textFieldCltNumero1);

		textFieldCltNumero = new JTextField();
		textFieldCltNumero.setBounds(121, 177, 322, 30);
		JPCltCM.add(textFieldCltNumero);

		JLabel textFieldCltData1 = new JLabel("Data de Criação:");
		textFieldCltData1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textFieldCltData1.setBounds(121, 219, 270, 16);
		JPCltCM.add(textFieldCltData1);

		textFieldCltData = new JTextField();
		textFieldCltData.setBounds(121, 246, 185, 30);
		JPCltCM.add(textFieldCltData);

		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblSaldo.setBounds(121, 293, 270, 16);
		JPCltCM.add(lblSaldo);

		textFieldCltSaldo = new JTextField();
		textFieldCltSaldo.setBounds(121, 322, 185, 30);
		JPCltCM.add(textFieldCltSaldo);

		JButton btnCltLimpar = new JButton("Limpar");
		btnCltLimpar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnCltLimpar.setBounds(209, 404, 120, 38);
		JPCltCM.add(btnCltLimpar);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(889, 149, 20, 355);
		JPCltCM.add(scrollBar);

		JList listCltListaMovimentos = new JList();
		listCltListaMovimentos.setBounds(527, 150, 379, 354);
		JPCltCM.add(listCltListaMovimentos);

		JLabel textCltCartao = new JLabel("Cartão:");
		textCltCartao.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textCltCartao.setBounds(527, 67, 270, 16);
		JPCltCM.add(textCltCartao);

		textFieldCltCartao = new JTextField();
		textFieldCltCartao.setBounds(527, 94, 344, 30);
		JPCltCM.add(textFieldCltCartao);

		JTextField tbAdmFunPesq = new JTextField();
		tbAdmFunPesq.setBounds(12, 52, 240, 30);
		tbAdmFunPesq.setColumns(10);

		// Botão conta/movimentos do menu
		JButton btCltConmov = new JButton();
		btCltConmov.setText("Conta");
		btCltConmov.setBorderPainted(false);
		btCltConmov.setOpaque(true);
		btCltConmov.setForeground(Color.BLACK);
		btCltConmov.setBounds(0, 6, 170, 130);
		btCltConmov.setBackground(new Color(188, 127, 82));
		JpanelMenu.add(btCltConmov);

		// quando carrego no batao conta/movimentos , os outros paineis nao ficam
		// visiveis
		btCltConmov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPCltCM.setVisible(true);
				JPCltCartao.setVisible(false);
				JPCltTransf.setVisible(false);
				JPCltGestao.setVisible(false);

			}
		});
		btCltConmov.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		// Botão transferencia do menu
		JButton btCltTransferencia = new JButton("Transfer\u00EAncia");
		btCltTransferencia.setBorderPainted(false);
		btCltTransferencia.setOpaque(true);
		btCltTransferencia.setBackground(new Color(188, 127, 82));
		btCltTransferencia.setBounds(0, 148, 170, 144);
		JpanelMenu.add(btCltTransferencia);

		// quando carrego no batao transferencia, os outros paineis nao ficam visiveis
		btCltTransferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				JPCltTransf.setVisible(true);
				JPCltCM.setVisible(false);
				JPCltCartao.setVisible(false);
				JPCltGestao.setVisible(false);
			}
		});

		btCltTransferencia.setFont(new Font("Lucida Grande", Font.PLAIN, 19));

		// Botão cartao do menu
		JButton btCltCartao = new JButton("Cart\u00E3o");
		btCltCartao.setOpaque(true);
		btCltCartao.setBorderPainted(false);
		btCltCartao.setBackground(new Color(188, 127, 82));
		btCltCartao.setBounds(0, 304, 170, 139);
		JpanelMenu.add(btCltCartao);

		// quando carrego no batao cartao, os outros paineis nao ficam visiveis
		btCltCartao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPCltCM.setVisible(false);
				JPCltCartao.setVisible(true);
				JPCltTransf.setVisible(false);
				JPCltGestao.setVisible(false);

			}
		});

		btCltCartao.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		// Botão gestao do menu
		JButton btCltGestao = new JButton("Gest\u00E3o");
		btCltGestao.setBorderPainted(false);
		btCltGestao.setOpaque(true);
		btCltGestao.setBounds(0, 455, 170, 150);
		btCltGestao.setBackground(new Color(188, 127, 82));
		JpanelMenu.add(btCltGestao);

		// quando carrego no batao gestao, os outros paineis nao ficam visiveis
		btCltGestao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPCltCM.setVisible(false);
				JPCltCartao.setVisible(false);
				JPCltTransf.setVisible(false);
				JPCltGestao.setVisible(true);
			}
		});

		btCltGestao.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		// botao conta/movimentos accao que muda de cor
		btCltConmov.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				btCltConmov.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btCltConmov.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btCltConmov.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btCltConmov.setBackground(new Color(65, 106, 105));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btCltConmov.setBackground(new Color(65, 106, 105));
			}
		});

		// botao transferencia accao que muda de cor
		btCltTransferencia.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				btCltTransferencia.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btCltTransferencia.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btCltTransferencia.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btCltTransferencia.setBackground(new Color(65, 106, 105));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btCltTransferencia.setBackground(new Color(65, 106, 105));
			}
		});

		// botao cartao accao que muda de cor
		btCltCartao.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				btCltCartao.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btCltCartao.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btCltCartao.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btCltCartao.setBackground(new Color(65, 106, 105));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btCltCartao.setBackground(new Color(65, 106, 105));
			}
		});

		// botao funcionario accao que muda de cor
		btCltGestao.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				btCltGestao.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				btCltGestao.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btCltGestao.setBackground(new Color(188, 127, 82));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btCltGestao.setBackground(new Color(65, 106, 105));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				btCltGestao.setBackground(new Color(65, 106, 105));
			}
		});
	}
}
