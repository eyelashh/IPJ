
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

		// Painel principal transferencia
		JPanel JPCltTransf = new JPanel();
		JPCltTransf.setBounds(16, 16, 1032, 563);
		JpanelPrincipal.add(JPCltTransf);
		JPCltTransf.setLayout(null);

		// Box pesquisa da conta do cliente
		JComboBox comboBoxCLTPesquisa = new JComboBox();
		comboBoxCLTPesquisa.setBounds(211, 67, 287, 39);
		JPCltTransf.add(comboBoxCLTPesquisa);

		JLabel labelClt = new JLabel("Saldo:");
		labelClt.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		labelClt.setBounds(550, 67, 66, 16);
		JPCltTransf.add(labelClt);

		textFieldCltSaldo2 = new JTextField();
		textFieldCltSaldo2.setBounds(550, 96, 185, 30);
		JPCltTransf.add(textFieldCltSaldo2);

		textField = new JTextField();
		textField.setBounds(423, 200, 185, 30);
		JPCltTransf.add(textField);

		JLabel lblMontante = new JLabel("Montante:");
		lblMontante.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblMontante.setBounds(413, 172, 131, 16);
		JPCltTransf.add(lblMontante);

		textField_1 = new JTextField();
		textField_1.setBounds(423, 283, 287, 30);
		JPCltTransf.add(textField_1);

		JLabel lblContaDestino = new JLabel("Conta Destino:");
		lblContaDestino.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblContaDestino.setBounds(413, 255, 147, 16);
		JPCltTransf.add(lblContaDestino);

		textField_2 = new JTextField();
		textField_2.setBounds(423, 372, 185, 30);
		JPCltTransf.add(textField_2);

		JLabel lblDataDaOperao = new JLabel("Data da Operação:");
		lblDataDaOperao.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblDataDaOperao.setBounds(413, 344, 190, 16);
		JPCltTransf.add(lblDataDaOperao);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnConfirmar.setBounds(378, 448, 120, 38);
		JPCltTransf.add(btnConfirmar);

		JButton button_1 = new JButton("Limpar");
		button_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button_1.setBounds(550, 448, 120, 38);
		JPCltTransf.add(button_1);

		// Painel principal gestao
		JPanel JPCltGestao = new JPanel();
		JPCltGestao.setBounds(16, 16, 1032, 563);
		JpanelPrincipal.add(JPCltGestao);

		// Painel principal cartao
		JPanel JPCltCartao = new JPanel();
		JPCltCartao.setBounds(16, 16, 1032, 563);
		JpanelPrincipal.add(JPCltCartao);

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
		btCltConmov.setIcon(null);
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
		btCltTransferencia.setBorder(UIManager.getBorder("Button.border"));
		btCltTransferencia.setOpaque(true);
		btCltTransferencia.setBackground(new Color(188, 127, 82));
		btCltTransferencia.setBounds(0, 148, 170, 144);
		JpanelMenu.add(btCltTransferencia);

		// quando carrego no batao transferencia, os outros paineis nao ficam visiveis
		btCltTransferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPCltCM.setVisible(false);
				JPCltCartao.setVisible(false);
				JPCltTransf.setVisible(true);
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
