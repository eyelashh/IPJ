
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JScrollBar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BancoAppAdm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JTextField lblAdminGestUsername;
	private JTextField textAdminGestPass;
	private JTextField textFieldAdminGestNovaUser;
	private JTextField textFieldAdminGestPass1;
	private JTextField textFieldAdminGestNovaPass;
	private JTextField textFieldAdminGestConf;
	private JTextField textAdminCliePesquisa;
	private JTextField textAdminClieNome;
	private JTextField textAdminClieContato;
	private JTextField textAdminClieEndereco;
	private JTextField textAdminClieNif;
	private JTextField textAdmFunNome;
	private JTextField textAdmFunNumero;
	private JTextField textAdmFunContato;
	private JTextField textAdmFunUser;
	private JTextField textAdmFunPass;
	private JTextField textAdmFunSobrenome;
	private static Administrador adm;
	private static GestaoBanco gb;
	private JTextField textAdmFunMorada;

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			BancoAppAdm window = new BancoAppAdm(adm, gb);
			window.frame.setVisible(true);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Nao foi possivel abrir o funcionario");
		}
	}

	/**
	 * Create the application.
	 */
	public BancoAppAdm(Administrador a, GestaoBanco g) {
		adm = a;
		gb = g;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					gb.atualizaficheiro(gb.javabank.getUtlizadores(), gb.javabank.getContas());

					Login logout = new Login();
					logout.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					logout.setLocationRelativeTo(frame);
					logout.setVisible(true);
					frame.setVisible(false);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnLogout.setBounds(1070, 30, 143, 42);
		JpanelCabecalho.add(btnLogout);

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
		JLabel lUtilizador = new JLabel(adm.getNome());
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

		// Painel da funcionario da parte administrador
		JPanel JPAdmFuncionario = new JPanel();
		JPAdmFuncionario.setVisible(false);
		JPAdmFuncionario.setLayout(null);
		JPAdmFuncionario.setBounds(0, 0, 1042, 576);
		JPAdm.add(JPAdmFuncionario);

		// box onde escolhemos como queremos fazer a pesquisa do funcionario Nome ou ID
		String[] texto = new String[] { "Nome", "ID" };
		JComboBox cbAdmFunPesq = new JComboBox(texto);
		cbAdmFunPesq.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		cbAdmFunPesq.setBounds(133, 40, 227, 34);
		JPAdmFuncionario.add(cbAdmFunPesq);

		// caixa de texto para escrever a procura do funcionario
		JTextField tbAdmFunPesq = new JTextField();
		tbAdmFunPesq.setBounds(133, 77, 227, 31);
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

		// Agrupei num grupo os radio button
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbAdmFunCC);
		bg.add(rbAdmFunBI);
		bg.add(rbAdmFunPass);

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
		JList lbLAdmFunLista = new JList(gb.javabank.listaFunc(gb.javabank.getUtlizadores()));
		lbLAdmFunLista.setBounds(123, 122, 249, 428);
		JPAdmFuncionario.add(lbLAdmFunLista);
		DefaultListModel lm = new DefaultListModel();
		lm.addElement(lbLAdmFunLista);

		// texto : username
		JLabel lblAdmFunUsername = new JLabel("UserName:");
		lblAdmFunUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunUsername.setBounds(454, 441, 120, 30);
		JPAdmFuncionario.add(lblAdmFunUsername);

		// texto : username
		JLabel lblAdmFunPassword = new JLabel("Password:");
		lblAdmFunPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunPassword.setBounds(712, 441, 153, 30);
		JPAdmFuncionario.add(lblAdmFunPassword);

		// botao eliminar funcionario
		JButton btnAdmFunEliminar = new JButton("Eliminar");
		btnAdmFunEliminar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdmFunEliminar.setBounds(727, 38, 120, 38);
		JPAdmFuncionario.add(btnAdmFunEliminar);

		// Campos de texto - nome
		textAdmFunNome = new JTextField();
		textAdmFunNome.setColumns(10);
		textAdmFunNome.setBounds(463, 119, 217, 31);
		JPAdmFuncionario.add(textAdmFunNome);

		// Campos de texto - numero
		textAdmFunNumero = new JTextField();
		textAdmFunNumero.setColumns(10);
		textAdmFunNumero.setBounds(463, 270, 225, 31);
		JPAdmFuncionario.add(textAdmFunNumero);

		// Campos de texto - contato
		textAdmFunContato = new JTextField();
		textAdmFunContato.setColumns(10);
		textAdmFunContato.setBounds(463, 334, 225, 31);
		JPAdmFuncionario.add(textAdmFunContato);

		// Campos de texto - username
		textAdmFunUser = new JTextField();
		textAdmFunUser.setColumns(10);
		textAdmFunUser.setBounds(464, 469, 225, 31);
		JPAdmFuncionario.add(textAdmFunUser);

		// Campos de texto - pass
		textAdmFunPass = new JTextField();
		textAdmFunPass.setColumns(10);
		textAdmFunPass.setBounds(722, 469, 225, 31);
		JPAdmFuncionario.add(textAdmFunPass);

		// Data do funcionario
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.setBounds(463, 179, 217, 31);
		JPAdmFuncionario.add(dateChooser);

		// botao confirmar funcionario
		JButton btnAdmFunConfirmar_1 = new JButton("Confirmar");
		btnAdmFunConfirmar_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdmFunConfirmar_1.setBounds(611, 512, 120, 38);
		JPAdmFuncionario.add(btnAdmFunConfirmar_1);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblSobrenome.setBounds(699, 86, 120, 30);
		JPAdmFuncionario.add(lblSobrenome);

		textAdmFunSobrenome = new JTextField();
		textAdmFunSobrenome.setColumns(10);
		textAdmFunSobrenome.setBounds(709, 117, 217, 31);
		JPAdmFuncionario.add(textAdmFunSobrenome);

		textAdmFunMorada = new JTextField();
		textAdmFunMorada.setColumns(10);
		textAdmFunMorada.setBounds(463, 399, 225, 31);
		JPAdmFuncionario.add(textAdmFunMorada);

		JLabel lblMorada = new JLabel("Morada: ");
		lblMorada.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblMorada.setBounds(453, 366, 227, 30);
		JPAdmFuncionario.add(lblMorada);

		// Painel da estatistica da parte administrador
		JPanel JPAdmEstatistica = new JPanel();
		JPAdmEstatistica.setVisible(true);
		JPAdmEstatistica.setBounds(0, 0, 1042, 576);
		JPAdm.add(JPAdmEstatistica);
		JPAdmEstatistica.setLayout(null);

		// Painel do cliente da parte administrador
		JPanel JPAdmCliente = new JPanel();
		JPAdmCliente.setBounds(0, 0, 1042, 576);
		JPAdm.add(JPAdmCliente);
		JPAdmCliente.setVisible(false);
		JPAdmCliente.setLayout(null);

		// Box de pesquisa no Cliente
		JComboBox boxAdminCliePesquisa = new JComboBox();
		boxAdminCliePesquisa.setBounds(400, 16, 218, 38);
		JPAdmCliente.add(boxAdminCliePesquisa);

		JScrollBar scrollBarAdminClie = new JScrollBar();
		scrollBarAdminClie.setBounds(281, 85, 15, 441);
		JPAdmCliente.add(scrollBarAdminClie);

		// Lista dos clientes
		JList listaAdminClie = new JList();
		listaAdminClie.setBounds(56, 85, 240, 441);
		JPAdmCliente.add(listaAdminClie);

		// text onde podemos fazer pesquisas
		textAdminCliePesquisa = new JTextField();
		textAdminCliePesquisa.setBounds(410, 55, 196, 31);
		JPAdmCliente.add(textAdminCliePesquisa);
		textAdminCliePesquisa.setColumns(10);

		// texto do nome
		JLabel lblAdminClieNome = new JLabel("Nome :");
		lblAdminClieNome.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdminClieNome.setBounds(356, 115, 79, 23);
		JPAdmCliente.add(lblAdminClieNome);

		// texto da data
		JLabel LblAdminClieDataDeNascimento = new JLabel("Data de Nascimento :");
		LblAdminClieDataDeNascimento.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		LblAdminClieDataDeNascimento.setBounds(356, 181, 218, 23);
		JPAdmCliente.add(LblAdminClieDataDeNascimento);

		// texto do contato
		JLabel lblAdminClieContacto_1 = new JLabel("Contacto :");
		lblAdminClieContacto_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdminClieContacto_1.setBounds(356, 318, 127, 23);
		JPAdmCliente.add(lblAdminClieContacto_1);

		// texto do endereço
		JLabel lblAdminClieEndereo = new JLabel("Endereço :");
		lblAdminClieEndereo.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdminClieEndereo.setBounds(356, 383, 127, 23);
		JPAdmCliente.add(lblAdminClieEndereo);

		JScrollBar scrollBarAdminClieContas = new JScrollBar();
		scrollBarAdminClieContas.setBounds(961, 85, 15, 441);
		JPAdmCliente.add(scrollBarAdminClieContas);

		// Lista das contas dos clientes
		JList listAdminClie = new JList();
		listAdminClie.setBounds(736, 85, 240, 441);
		JPAdmCliente.add(listAdminClie);

		// campos de texto para o nome
		textAdminClieNome = new JTextField();
		textAdminClieNome.setColumns(10);
		textAdminClieNome.setBounds(366, 144, 297, 31);
		JPAdmCliente.add(textAdminClieNome);

		// campos de texto para o contatco
		textAdminClieContato = new JTextField();
		textAdminClieContato.setColumns(10);
		textAdminClieContato.setBounds(366, 347, 169, 31);
		JPAdmCliente.add(textAdminClieContato);

		// campos de texto para o endereco
		textAdminClieEndereco = new JTextField();
		textAdminClieEndereco.setColumns(10);
		textAdminClieEndereco.setBounds(366, 415, 297, 31);
		JPAdmCliente.add(textAdminClieEndereco);

		// campos de texto para o nif
		textAdminClieNif = new JTextField();
		textAdminClieNif.setColumns(10);
		textAdminClieNif.setBounds(366, 281, 169, 31);
		JPAdmCliente.add(textAdminClieNif);

		// texto do nif
		JLabel lblAdminClieNif = new JLabel("NIF :");
		lblAdminClieNif.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdminClieNif.setBounds(356, 252, 127, 23);
		JPAdmCliente.add(lblAdminClieNif);

		// botao a confirmar
		JButton btnadminClieConfirmar = new JButton("Confirmar");
		btnadminClieConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnadminClieConfirmar.setBounds(376, 488, 120, 38);
		JPAdmCliente.add(btnadminClieConfirmar);

		// botao a limpar os dados no ecra
		JButton btnAdminClieLimpar = new JButton("Limpar");
		btnAdminClieLimpar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdminClieLimpar.setBounds(522, 488, 120, 38);
		JPAdmCliente.add(btnAdminClieLimpar);

		// caixa da data
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(366, 209, 217, 31);
		JPAdmCliente.add(dateChooser_1);

		// Painel da gestao do administrador
		JPanel JPAdmGestao = new JPanel();
		JPAdmGestao.setBounds(0, 0, 1042, 576);
		JPAdm.add(JPAdmGestao);
		JPAdmGestao.setLayout(null);
		JPAdmGestao.setVisible(false);

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

		// campo de texto na gestão da parte do administrador
		textFieldAdminGestPass1 = new JTextField();
		textFieldAdminGestPass1.setColumns(10);
		textFieldAdminGestPass1.setBounds(579, 134, 271, 33);
		JPAdmGestao.add(textFieldAdminGestPass1);

		// texto : password 2
		JLabel lblPassword_2 = new JLabel("Password :");
		lblPassword_2.setVerifyInputWhenFocusTarget(false);
		lblPassword_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword_2.setBounds(579, 81, 131, 41);
		JPAdmGestao.add(lblPassword_2);

		// texto : nova password
		JLabel lblNovaPassword = new JLabel("Nova Password :");
		lblNovaPassword.setVerifyInputWhenFocusTarget(false);
		lblNovaPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNovaPassword.setBounds(579, 178, 168, 41);
		JPAdmGestao.add(lblNovaPassword);

		// campo de texto na gestão da parte do administrador
		textFieldAdminGestNovaPass = new JTextField();
		textFieldAdminGestNovaPass.setColumns(10);
		textFieldAdminGestNovaPass.setBounds(579, 230, 271, 33);
		JPAdmGestao.add(textFieldAdminGestNovaPass);

		// texto : confirmar password
		JLabel lblConfirmarNovaPass = new JLabel("Confirmar Password :");
		lblConfirmarNovaPass.setVerifyInputWhenFocusTarget(false);
		lblConfirmarNovaPass.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblConfirmarNovaPass.setBounds(579, 275, 271, 41);
		JPAdmGestao.add(lblConfirmarNovaPass);

		// campo de texto na gestão da parte do administrador
		textFieldAdminGestConf = new JTextField();
		textFieldAdminGestConf.setColumns(10);
		textFieldAdminGestConf.setBounds(579, 327, 271, 33);
		JPAdmGestao.add(textFieldAdminGestConf);

		// botao de confimar - submete a nova pass
		JButton buttonAdminGestConf = new JButton("Confirmar");
		buttonAdminGestConf.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		buttonAdminGestConf.setBounds(579, 415, 131, 41);
		JPAdmGestao.add(buttonAdminGestConf);

		// botao de cancelar - limpar
		JButton buttonAdminGestCan = new JButton("Cancelar");
		buttonAdminGestCan.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		buttonAdminGestCan.setBounds(729, 415, 131, 41);
		JPAdmGestao.add(buttonAdminGestCan);

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

		// acao do botao novo:
		btAdmFunNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textAdmFunNome.setText(null);
				textAdmFunSobrenome.setText(null);
				textAdmFunContato.setText(null);
				textAdmFunMorada.setText(null);
				bg.clearSelection();
				textAdmFunNumero.setText(null);
				textAdmFunPass.setText(null);
				textAdmFunUser.setText(null);
				dateChooser.setCalendar(null);

			}
		});

		// bt confirmar (adicionar ou alterar )
		btnAdmFunConfirmar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// se nao estiver selecionado nenhum funcionario entao cria um novo/ caso exista
				// algum elemento selecionado da lista faz um update:
				if (!lbLAdmFunLista.isSelectionEmpty()) {
					// adicionar Cliente:

					// criar automaticamente o id;
					int id = (gb.javabank.getUtlizadores().get(gb.javabank.getUtlizadores().size() - 1)
							.getIdUtilizador()) + 1;
					int id2 = (gb.javabank.getUtlizadores().get(id)).getIdUtilizador() + 1;
					if (id == 0) {
						id++;
					}

					if (id2 == id) {
						id2++;
					}

					// valida qual dos botoes estao atualizados:
					String opselect = "";
					if (rbAdmFunCC.isSelected()) {
						opselect = rbAdmFunCC.getText();
					}
					if (rbAdmFunBI.isSelected()) {
						opselect = rbAdmFunBI.getText();
					}
					if (rbAdmFunPass.isSelected()) {
						opselect = rbAdmFunPass.getText();
					}

					// esta a criar o novo funcionario:
					Utilizador func = new Funcionario(id, textAdmFunNome.getText(), textAdmFunSobrenome.getText(),
							dateChooser.getDate(), opselect, Integer.parseInt(textAdmFunNumero.getText()),
							textAdmFunMorada.getText(), Integer.parseInt(textAdmFunContato.getText()),
							textAdmFunUser.getText(), textAdmFunPass.getText(), id2);
					gb.javabank.getUtlizadores().add(func);

				} else {
					// atualizar Cliente:
					
					

				}

			}
		});

		// Metedo que seleciona e passa todos os argumentos para as caixas de texto :

		/*lbClt.addListSelectionListener(new ListSelectionListener() {

		lbLAdmFunLista.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				if (!lbLAdmFunLista.isSelectionEmpty()) {
					
					String s = (String) lbLAdmFunLista.getSelectedValue();
					s = s.substring(0, s.indexOf(" "));
					Funcionario f = (Funcionario) gb.javabank.selectUtilizador(Integer.parseInt(s),
							gb.javabank.getUtlizadores());

					textAdmFunNome.setText(f.getNome());
					textAdmFunSobrenome.setText(f.getSobrenome());
					textAdmFunMorada.setText(f.getMorada());
					textAdmFunContato.setText("" + f.getContacto());
					textAdmFunUser.setText(f.getUsername());
					textAdmFunPass.setText(f.getPassword());
					textAdmFunNumero.setText("" + f.getNumidentificacao());

					if (f.getTipoIndentificacao().equals("C.C.")) {
						rbAdmFunCC.setSelected(true);
					}
					if (f.getTipoIndentificacao().equals("B.I.")) {
						rbAdmFunBI.setSelected(true);
					}
					if (f.getTipoIndentificacao().equals("Passaporte")) {
						rbAdmFunPass.setSelected(true);
					}

				}
			}
		});*/

		btAdmFunProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tbAdmFunPesq.getText().equals(gb.javabank.getUtlizadores().get(0).getNome())){
				
				String s = (String) tbAdmFunPesq.getText();
				s= s.substring(0, s.indexOf("*"));
				Cliente c = (Cliente) gb.javabank.selectUtilizador(Integer.parseInt(s), gb.javabank.getUtlizadores());


				textAdmFunNome.setText(c.getNome());
				textAdmFunSobrenome.setText(c.getSobrenome());
				textAdmFunMorada.setText(c.getMorada());
				textAdmFunContato.setText(""+c.getContacto());
				textAdmFunUser.setText(c.getUsername());
				textAdmFunPass.setText(c.getPassword());
				textAdmFunNumero.setText(""+c.getNumidentificacao());
				
				
				lbLAdmFunLista.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
				c.getIdUtilizador();
				c.getNome();
			}
		});
				}
		}
		});

	}
}
