
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
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;

public class BancoAppAdm {

	private JFrame frame;
	private JTextField lblAdminGestUsername;
	private JTextField textAdminGestPass;
	private JTextField textFieldAdminGestNovaUser;
	private JTextField textFieldAdminGestPass1;
	private JTextField textFieldAdminGestNovaPass;
	private JTextField textFieldAdminGestConf;
	private JTextField textAdminCliePesquisa;
	private JTextField textAdminClieNome;
	private JTextField textAdminClieData;
	private JTextField textAdminClieContato;
	private JTextField textAdminClieEndereco;
	private JTextField textAdminClieNif;
	private JTextField textAdmFunNome;
	private JTextField textAdmFunData;
	private JTextField textAdmFunNumero;
	private JTextField textAdmFunContato;
	private JTextField textAdmFunUser;
	private JTextField textAdmFunPass;

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
		lblNewLabel.setVerifyInputWhenFocusTarget(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
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
		JLabel lUtilizador = new JLabel("Tamara Barros");
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

		// Painel do Administrador que tem os botoes
		JPanel JPanelAdmin = new JPanel();
		JPanelAdmin.setBounds(10, 135, 170, 605);
		JPanelAdmin.setBackground(Color.WHITE);
		frame.getContentPane().add(JPanelAdmin);
		JPanelAdmin.setLayout(null);

		// Painel principal
		JPanel JpanelPrincipal = new JPanel();
		JpanelPrincipal.setBounds(198, 142, 1065, 598);
		frame.getContentPane().add(JpanelPrincipal);
		JpanelPrincipal.setLayout(null);

		// Painel do administrador
		JPanel JPAdm = new JPanel();
		JPAdm.setBackground(Color.WHITE);
		JPAdm.setBounds(12, 13, 1042, 576);
		JpanelPrincipal.add(JPAdm);
		JPAdm.setLayout(null);

		;

		// Painel da funcionario da parte administrador
		JPanel JPAdmFuncionario = new JPanel();
		JPAdmFuncionario.setVisible(false);
		JPAdmFuncionario.setLayout(null);
		JPAdmFuncionario.setBounds(0, 0, 1042, 576);
		JPAdm.add(JPAdmFuncionario);

		// box onde escolhemos como queremos fazer a pesquisa do funcionario
		JComboBox cbAdmFunPesq = new JComboBox();
		cbAdmFunPesq.setBounds(123, 28, 249, 39);
		JPAdmFuncionario.add(cbAdmFunPesq);

		// caixa de texto para escrever a procura do funcionario
		JTextField tbAdmFunPesq = new JTextField();
		tbAdmFunPesq.setBounds(123, 79, 249, 31);
		JPAdmFuncionario.add(tbAdmFunPesq);

		// Botao de procurar
		JButton btAdmFunProc = new JButton("Procurar");
		btAdmFunProc.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btAdmFunProc.setBounds(443, 38, 120, 38);
		JPAdmFuncionario.add(btAdmFunProc);

		// Botao para criar novo funcionario
		JButton btAdmFunNovo = new JButton("Novo");
		btAdmFunNovo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btAdmFunNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btAdmFunNovo.setBounds(585, 38, 120, 38);
		JPAdmFuncionario.add(btAdmFunNovo);

		// texto : Nome
		JLabel lblAdmFunNome = new JLabel("Nome:");
		lblAdmFunNome.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunNome.setBounds(453, 88, 57, 30);
		JPAdmFuncionario.add(lblAdmFunNome);

		// texto : data de nascimento
		JLabel lblAdmFunDataDeNascimento = new JLabel("Data de Nascimento:");
		lblAdmFunDataDeNascimento.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunDataDeNascimento.setBounds(453, 148, 177, 30);
		JPAdmFuncionario.add(lblAdmFunDataDeNascimento);

		// texto : documento
		JLabel lblAdmFunDocumento = new JLabel("Documento:");
		lblAdmFunDocumento.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunDocumento.setBounds(453, 209, 108, 30);
		JPAdmFuncionario.add(lblAdmFunDocumento);

		// radiobutton : documento
		JRadioButton rbAdmFunCC = new JRadioButton("C.C.");
		rbAdmFunCC.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		rbAdmFunCC.setBounds(564, 212, 66, 25);
		JPAdmFuncionario.add(rbAdmFunCC);

		// radiobutton : documento
		JRadioButton rbAdmFunBI = new JRadioButton("B.I.");
		rbAdmFunBI.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		rbAdmFunBI.setBounds(643, 212, 57, 25);
		JPAdmFuncionario.add(rbAdmFunBI);

		// radiobutton : documento
		JRadioButton rbAdmFunPass = new JRadioButton("Passaporte");
		rbAdmFunPass.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		rbAdmFunPass.setBounds(712, 212, 138, 25);
		JPAdmFuncionario.add(rbAdmFunPass);

		// texto : numero do documento
		JLabel lblAdmFunNumero = new JLabel("Número de Identificação:");
		lblAdmFunNumero.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunNumero.setBounds(453, 237, 227, 30);
		JPAdmFuncionario.add(lblAdmFunNumero);

		// texto : contato
		JLabel lblAdmFunContacto = new JLabel("Contacto:");
		lblAdmFunContacto.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunContacto.setBounds(453, 303, 81, 31);
		JPAdmFuncionario.add(lblAdmFunContacto);

		JScrollBar scrollAdmFunLista = new JScrollBar();
		scrollAdmFunLista.setBounds(357, 122, 15, 428);
		JPAdmFuncionario.add(scrollAdmFunLista);

		// lista dos funcionarios
		JList lbLAdmFunLista = new JList();
		lbLAdmFunLista.setBounds(123, 122, 249, 428);
		JPAdmFuncionario.add(lbLAdmFunLista);

		// texto : username
		JLabel lblAdmFunUsername = new JLabel("UserName:");
		lblAdmFunUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunUsername.setBounds(453, 367, 120, 30);
		JPAdmFuncionario.add(lblAdmFunUsername);

		// texto : username
		JLabel lblAdmFunPassword = new JLabel("Password:");
		lblAdmFunPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunPassword.setBounds(453, 427, 153, 30);
		JPAdmFuncionario.add(lblAdmFunPassword);

		JButton btnAdmFunEliminar = new JButton("Eliminar");
		btnAdmFunEliminar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdmFunEliminar.setBounds(727, 38, 120, 38);
		JPAdmFuncionario.add(btnAdmFunEliminar);

		textAdmFunNome = new JTextField();
		textAdmFunNome.setColumns(10);
		textAdmFunNome.setBounds(463, 119, 351, 31);
		JPAdmFuncionario.add(textAdmFunNome);

		textAdmFunData = new JTextField();
		textAdmFunData.setColumns(10);
		textAdmFunData.setBounds(463, 179, 225, 31);
		JPAdmFuncionario.add(textAdmFunData);

		textAdmFunNumero = new JTextField();
		textAdmFunNumero.setColumns(10);
		textAdmFunNumero.setBounds(463, 270, 225, 31);
		JPAdmFuncionario.add(textAdmFunNumero);

		textAdmFunContato = new JTextField();
		textAdmFunContato.setColumns(10);
		textAdmFunContato.setBounds(463, 334, 225, 31);
		JPAdmFuncionario.add(textAdmFunContato);

		textAdmFunUser = new JTextField();
		textAdmFunUser.setColumns(10);
		textAdmFunUser.setBounds(463, 395, 225, 31);
		JPAdmFuncionario.add(textAdmFunUser);

		textAdmFunPass = new JTextField();
		textAdmFunPass.setColumns(10);
		textAdmFunPass.setBounds(463, 456, 225, 31);
		JPAdmFuncionario.add(textAdmFunPass);

		JButton btnAdmFunConfirmar_1 = new JButton("Confirmar");
		btnAdmFunConfirmar_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdmFunConfirmar_1.setBounds(512, 511, 120, 38);
		JPAdmFuncionario.add(btnAdmFunConfirmar_1);

		JButton btnAdmFunLimpar = new JButton("Limpar");
		btnAdmFunLimpar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdmFunLimpar.setBounds(675, 509, 120, 38);
		JPAdmFuncionario.add(btnAdmFunLimpar);

		btAdmFunNovo.setBounds(585, 38, 120, 38);
		JPAdmFuncionario.add(btAdmFunNovo);

		textAdmFunNome = new JTextField();
		textAdmFunNome.setColumns(10);
		textAdmFunNome.setBounds(463, 119, 351, 31);
		JPAdmFuncionario.add(textAdmFunNome);

		textAdmFunData = new JTextField();
		textAdmFunData.setColumns(10);
		textAdmFunData.setBounds(463, 179, 225, 31);
		JPAdmFuncionario.add(textAdmFunData);

		textAdmFunNumero = new JTextField();
		textAdmFunNumero.setColumns(10);
		textAdmFunNumero.setBounds(463, 270, 225, 31);
		JPAdmFuncionario.add(textAdmFunNumero);

		textAdmFunContato = new JTextField();
		textAdmFunContato.setColumns(10);
		textAdmFunContato.setBounds(463, 334, 225, 31);
		JPAdmFuncionario.add(textAdmFunContato);

		textAdmFunUser = new JTextField();
		textAdmFunUser.setColumns(10);
		textAdmFunUser.setBounds(463, 395, 225, 31);
		JPAdmFuncionario.add(textAdmFunUser);

		textAdmFunPass = new JTextField();
		textAdmFunPass.setColumns(10);
		textAdmFunPass.setBounds(463, 456, 225, 31);
		JPAdmFuncionario.add(textAdmFunPass);

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
		lblUsername_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsername_1.setBounds(144, 81, 131, 41);
		JPAdmGestao.add(lblUsername_1);

		// campo de texto na gestão da parte do administrador
		lblAdminGestUsername = new JTextField();
		lblAdminGestUsername.setBounds(144, 134, 271, 33);
		JPAdmGestao.add(lblAdminGestUsername);

		// texto : password
		JLabel lblPassword_1 = new JLabel("Password :");
		lblPassword_1.setVerifyInputWhenFocusTarget(false);
		lblPassword_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword_1.setBounds(144, 178, 131, 41);
		JPAdmGestao.add(lblPassword_1);

		// campo de texto na gestão da parte do administrador
		textAdminGestPass = new JTextField();
		textAdminGestPass.setColumns(10);
		textAdminGestPass.setBounds(144, 230, 271, 33);
		JPAdmGestao.add(textAdminGestPass);

		// texto : novausername
		JLabel textFieldAdminGestUsername = new JLabel("Nova Username :");
		textFieldAdminGestUsername.setVerifyInputWhenFocusTarget(false);
		textFieldAdminGestUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		textFieldAdminGestUsername.setBounds(144, 275, 191, 41);
		JPAdmGestao.add(textFieldAdminGestUsername);

		// campo de texto na gestão da parte do administrador
		textFieldAdminGestNovaUser = new JTextField();
		textFieldAdminGestNovaUser.setColumns(10);
		textFieldAdminGestNovaUser.setBounds(144, 327, 271, 33);
		JPAdmGestao.add(textFieldAdminGestNovaUser);

		// botao de confimar - submete a nova username
		JButton btnAdminGestConfirmar = new JButton("Confirmar");
		btnAdminGestConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdminGestConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnAdminGestConfirmar.setBounds(144, 415, 131, 41);
		JPAdmGestao.add(btnAdminGestConfirmar);

		// botao de cancelar - limpar
		JButton btnAdminGestCancelar = new JButton("Cancelar");
		btnAdminGestCancelar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdminGestCancelar.setBounds(294, 415, 131, 41);
		JPAdmGestao.add(btnAdminGestCancelar);

		textFieldAdminGestPass1 = new JTextField();
		textFieldAdminGestPass1.setColumns(10);
		textFieldAdminGestPass1.setBounds(579, 134, 271, 33);
		JPAdmGestao.add(textFieldAdminGestPass1);

		JLabel lblPassword_2 = new JLabel("Password :");
		lblPassword_2.setVerifyInputWhenFocusTarget(false);
		lblPassword_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword_2.setBounds(579, 81, 131, 41);
		JPAdmGestao.add(lblPassword_2);

		JLabel lblNovaPassword = new JLabel("Nova Password :");
		lblNovaPassword.setVerifyInputWhenFocusTarget(false);
		lblNovaPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNovaPassword.setBounds(579, 178, 168, 41);
		JPAdmGestao.add(lblNovaPassword);

		textFieldAdminGestNovaPass = new JTextField();
		textFieldAdminGestNovaPass.setColumns(10);
		textFieldAdminGestNovaPass.setBounds(579, 230, 271, 33);
		JPAdmGestao.add(textFieldAdminGestNovaPass);

		JLabel lblConfirmarNovaUsername = new JLabel("Confirmar Password :");
		lblConfirmarNovaUsername.setVerifyInputWhenFocusTarget(false);
		lblConfirmarNovaUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblConfirmarNovaUsername.setBounds(579, 275, 271, 41);
		JPAdmGestao.add(lblConfirmarNovaUsername);

		textFieldAdminGestConf = new JTextField();
		textFieldAdminGestConf.setColumns(10);
		textFieldAdminGestConf.setBounds(579, 327, 271, 33);
		JPAdmGestao.add(textFieldAdminGestConf);

		JButton buttonAdminGestConf = new JButton("Confirmar");
		buttonAdminGestConf.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		buttonAdminGestConf.setBounds(579, 415, 131, 41);
		JPAdmGestao.add(buttonAdminGestConf);

		JButton buttonAdminGestCan = new JButton("Cancelar");
		buttonAdminGestCan.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		buttonAdminGestCan.setBounds(729, 415, 131, 41);
		JPAdmGestao.add(buttonAdminGestCan);

		// Painel da estatistica da parte administrador
		JPanel JPAdmEstatistica = new JPanel();
		JPAdmEstatistica.setVisible(false);
		JPAdmEstatistica.setBounds(0, 0, 1042, 576);
		JPAdm.add(JPAdmEstatistica);
		JPAdmEstatistica.setLayout(null);

		// Painel do cliente da parte administrador
		JPanel JPAdmCliente = new JPanel();
		JPAdmCliente.setBounds(0, 0, 1042, 576);
		JPAdm.add(JPAdmCliente);
		JPAdmCliente.setVisible(false);
		JPAdmCliente.setLayout(null);

		JComboBox boxAdminCliePesquisa = new JComboBox();
		boxAdminCliePesquisa.setBounds(400, 16, 218, 38);
		JPAdmCliente.add(boxAdminCliePesquisa);

		JScrollBar scrollBarAdminClie = new JScrollBar();
		scrollBarAdminClie.setBounds(281, 85, 15, 441);
		JPAdmCliente.add(scrollBarAdminClie);

		JList listaAdminClie = new JList();
		listaAdminClie.setBounds(56, 85, 240, 441);
		JPAdmCliente.add(listaAdminClie);

		textAdminCliePesquisa = new JTextField();
		textAdminCliePesquisa.setBounds(410, 55, 196, 31);
		JPAdmCliente.add(textAdminCliePesquisa);
		textAdminCliePesquisa.setColumns(10);

		JLabel lblAdminClieNome = new JLabel("Nome :");
		lblAdminClieNome.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdminClieNome.setBounds(356, 115, 79, 23);
		JPAdmCliente.add(lblAdminClieNome);

		JLabel LblAdminClieDataDeNascimento = new JLabel("Data de Nascimento :");
		LblAdminClieDataDeNascimento.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		LblAdminClieDataDeNascimento.setBounds(356, 181, 218, 23);
		JPAdmCliente.add(LblAdminClieDataDeNascimento);

		JLabel lblAdminClieContacto_1 = new JLabel("Contacto :");
		lblAdminClieContacto_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdminClieContacto_1.setBounds(356, 318, 127, 23);
		JPAdmCliente.add(lblAdminClieContacto_1);

		JLabel lblAdminClieEndereo = new JLabel("Endereço :");
		lblAdminClieEndereo.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdminClieEndereo.setBounds(356, 383, 127, 23);
		JPAdmCliente.add(lblAdminClieEndereo);

		JScrollBar scrollBarAdminClieContas = new JScrollBar();
		scrollBarAdminClieContas.setBounds(961, 85, 15, 441);
		JPAdmCliente.add(scrollBarAdminClieContas);

		JList listAdminClie = new JList();
		listAdminClie.setBounds(736, 85, 240, 441);
		JPAdmCliente.add(listAdminClie);

		textAdminClieNome = new JTextField();
		textAdminClieNome.setColumns(10);
		textAdminClieNome.setBounds(366, 144, 297, 31);
		JPAdmCliente.add(textAdminClieNome);

		textAdminClieData = new JTextField();
		textAdminClieData.setColumns(10);
		textAdminClieData.setBounds(366, 209, 169, 31);
		JPAdmCliente.add(textAdminClieData);

		textAdminClieContato = new JTextField();
		textAdminClieContato.setColumns(10);
		textAdminClieContato.setBounds(366, 347, 169, 31);
		JPAdmCliente.add(textAdminClieContato);

		textAdminClieEndereco = new JTextField();
		textAdminClieEndereco.setColumns(10);
		textAdminClieEndereco.setBounds(366, 415, 297, 31);
		JPAdmCliente.add(textAdminClieEndereco);

		textAdminClieNif = new JTextField();
		textAdminClieNif.setColumns(10);
		textAdminClieNif.setBounds(366, 281, 169, 31);
		JPAdmCliente.add(textAdminClieNif);

		JLabel lblAdminClieNif = new JLabel("NIF :");
		lblAdminClieNif.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdminClieNif.setBounds(356, 252, 127, 23);
		JPAdmCliente.add(lblAdminClieNif);

		JButton btnadminClieConfirmar = new JButton("Confirmar");
		btnadminClieConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnadminClieConfirmar.setBounds(376, 488, 120, 38);
		JPAdmCliente.add(btnadminClieConfirmar);

		JButton btnAdminClieLimpar = new JButton("Limpar");
		btnAdminClieLimpar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdminClieLimpar.setBounds(522, 488, 120, 38);
		JPAdmCliente.add(btnAdminClieLimpar);

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
		btAdmEstatistica.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

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
		btAdmClientes.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

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
		btAdmGestao.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

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
		btAdmFuncionarios.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

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
