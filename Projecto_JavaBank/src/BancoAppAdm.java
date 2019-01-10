
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
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
import java.util.Date;

import javax.swing.JScrollBar;
import com.toedter.calendar.JDateChooser;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
	private Administrador adm;
	private GestaoBanco gb;
	private JTextField textAdmFunMorada;
	private JTextField tbadmcontanumero;
	private JTextField tbadmcontalimoperacao;
	private JTextField tbadmcontalimdia;
	private JTextField tbadmcontasaldo;
	private JTextField tbadmcontajuros;
	private JTextField tbadmcontalimmes;
	private JTextField tbadmcontacartaonome;
	private JTextField tbadmcontacartaocod;
	private JDateChooser dcadmcontadata;
	private JTextField tbadmnome;
	private JTextField tbadmapelido;
	private JTextField tbadmnident;
	private JTextField tbadmcontacto;
	private JTextField tbadmmorada;
	private JTable table;
	DefaultListModel<String> dlmcontaadm = new DefaultListModel<String>();
	// Modelo para tabela
	String[] colunas = { "IDOp", "Responsável", "Data", "Valor", "ContaDestino", "Cliente" };
	DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int rowIndex, int mColIndex) {
			if (mColIndex == 0) {
				return true;
			} else {
				return false;
			}
		}
	};
	private JTextField textFieldAdminDescr;
	private JTable table_1;

	// Modelo da tabela estatistica:
	String[] colunas3 = { "IDConta", "DataCriação", "DataFecho", "Saldo", "Aberta" };
	DefaultTableModel modeloTabelaEstatistica = new DefaultTableModel(colunas3, 0) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int rowIndex, int mColIndex) {
			if (mColIndex == 0) {
				return true;
			} else {
				return false;
			}
		}
	};
	private JTextField textFieldnNovasConta;
	private JTextField textFieldFechaConat;
	private JTextField textFieldTotalCapital;
	private JTextField textFieldBalanco;

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

		Validador val = new Validador();

		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				gb.atualizaficheiro(gb.javabank.getUtlizadores(), gb.javabank.getContas(), gb.javabank.getCartoes());
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

		// Botao de logout, metodo que vai buscar a class
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Lucida Grande", Font.PLAIN, 17));

		// logOut
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				gb.atualizaficheiro(gb.javabank.getUtlizadores(), gb.javabank.getContas(), gb.javabank.getCartoes());
				Login logout = new Login();
				frame.setVisible(false);
				logout.run();

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

		// lista dos funcionarios
		DefaultListModel<String> dmFun = new DefaultListModel<String>();
		gb.javabank.addelementoslist(gb.javabank.listaFunceAdm(gb.javabank.getUtlizadores()), dmFun);

		// Agrupei num grupo os radio button
		ButtonGroup bg = new ButtonGroup();

		// Box de pesquisa no Cliente
		String[] texto2 = new String[] { "Nome", "ID" };

		// Lista dos clientes
		DefaultListModel<String> dmClt = new DefaultListModel<String>();
		gb.javabank.addelementoslist(gb.javabank.listarClientes(gb.javabank.getUtlizadores()), dmClt);

		// Lista das contas dos clientes
		DefaultListModel<String> dmCltContas = new DefaultListModel<String>();

		// Painel do cliente da parte administrador
		JPanel JPAdmCliente = new JPanel();
		JPAdmCliente.setBounds(0, 0, 1042, 576);
		JPAdmCliente.setVisible(false);

		// Painel da funcionario da parte administrador
		JPanel JPAdmFuncionario = new JPanel();
		JPAdmFuncionario.setVisible(false);

		// Painel da estatistica da parte administrador
		JPanel JPAdmEstatistica = new JPanel();
		JPAdmEstatistica.setVisible(true);
		JPAdmEstatistica.setBounds(0, 0, 1042, 576);
		JPAdmEstatistica.setLayout(null);
		JPAdm.add(JPAdmEstatistica);

		JDateChooser dateChooserInicio = new JDateChooser();
		dateChooserInicio.setBounds(55, 49, 230, 33);
		JPAdmEstatistica.add(dateChooserInicio);

		JDateChooser dateChooserFim = new JDateChooser();
		dateChooserFim.setBounds(329, 49, 230, 33);
		JPAdmEstatistica.add(dateChooserFim);

		JLabel lblDataInicial = new JLabel("Data Inicio:");
		lblDataInicial.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblDataInicial.setBounds(39, 17, 124, 33);
		JPAdmEstatistica.add(lblDataInicial);

		JLabel lblDataFim = new JLabel("Data Fim:");
		lblDataFim.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblDataFim.setBounds(317, 17, 124, 33);
		JPAdmEstatistica.add(lblDataFim);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(143, 134, 729, 261);
		JPAdmEstatistica.add(scrollPane_1);
		table_1 = new JTable(modeloTabelaEstatistica);
		scrollPane_1.setViewportView(table_1);

		textFieldnNovasConta = new JTextField();
		textFieldnNovasConta.setEditable(false);
		textFieldnNovasConta.setBounds(455, 407, 321, 33);
		JPAdmEstatistica.add(textFieldnNovasConta);
		textFieldnNovasConta.setColumns(10);

		textFieldFechaConat = new JTextField();
		textFieldFechaConat.setEditable(false);
		textFieldFechaConat.setColumns(10);
		textFieldFechaConat.setBounds(455, 446, 321, 33);
		JPAdmEstatistica.add(textFieldFechaConat);

		textFieldTotalCapital = new JTextField();
		textFieldTotalCapital.setEditable(false);
		textFieldTotalCapital.setColumns(10);
		textFieldTotalCapital.setBounds(455, 491, 321, 33);
		JPAdmEstatistica.add(textFieldTotalCapital);

		JLabel lblContasNovas = new JLabel("Número de novas contas: ");
		lblContasNovas.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblContasNovas.setBounds(237, 407, 247, 33);
		JPAdmEstatistica.add(lblContasNovas);

		JLabel lblNmeroDeContas = new JLabel("Número de contas fechadas: ");
		lblNmeroDeContas.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNmeroDeContas.setBounds(212, 444, 247, 33);
		JPAdmEstatistica.add(lblNmeroDeContas);

		JLabel lblTotalCapital = new JLabel("Total Capital: ");
		lblTotalCapital.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblTotalCapital.setBounds(335, 489, 124, 33);
		JPAdmEstatistica.add(lblTotalCapital);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Date data1 = dateChooserInicio.getDate();
				Date data2 = dateChooserFim.getDate();

				modeloTabelaEstatistica.setRowCount(0);
				gb.javabank.preenchetabelaContaEstatistica(modeloTabelaEstatistica, gb.javabank.getContas(), data1,
						data2);

				int numeroContasNovas = gb.javabank.numeroContasAbertas(gb.javabank.getContas(), data1, data2);
				textFieldnNovasConta.setText(Integer.toString(numeroContasNovas));

				int numeroContasFechadas = gb.javabank.numeroContasFechadas(gb.javabank.getContas(), data1, data2);
				textFieldFechaConat.setText(Integer.toString(numeroContasFechadas));

				int totalCapital = gb.javabank.totalCapital(gb.javabank.getContas(), data1, data2);
				textFieldTotalCapital.setText(Integer.toString(totalCapital));

				double balanco = gb.javabank.balanco(gb.javabank.getContas(), data1, data2);
				textFieldBalanco.setText(Double.toString(balanco));

			}
		});
		btnPesquisar.setBounds(609, 53, 117, 29);
		JPAdmEstatistica.add(btnPesquisar);

		JButton btnLimpar_1 = new JButton("Limpar");
		btnLimpar_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dateChooserInicio.setDate(null);
				dateChooserFim.setDate(null);
				modeloTabelaEstatistica.setRowCount(0);
				textFieldnNovasConta.setText(null);
				textFieldFechaConat.setText(null);
				textFieldTotalCapital.setText(null);
				textFieldBalanco.setText(null);
			}
		});
		btnLimpar_1.setBounds(738, 53, 117, 29);
		JPAdmEstatistica.add(btnLimpar_1);

		JLabel lblBalano = new JLabel("Balanço: ");
		lblBalano.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblBalano.setBounds(374, 534, 73, 33);
		JPAdmEstatistica.add(lblBalano);

		textFieldBalanco = new JTextField();
		textFieldBalanco.setEditable(false);
		textFieldBalanco.setColumns(10);
		textFieldBalanco.setBounds(455, 536, 321, 33);
		JPAdmEstatistica.add(textFieldBalanco);
		JPAdmFuncionario.setLayout(null);
		JPAdmFuncionario.setBounds(0, 0, 1042, 576);
		JPAdm.add(JPAdmFuncionario);

		String[] texto = new String[] { "Nome", "ID" };
		JComboBox cbAdmFunPesq = new JComboBox(texto);
		cbAdmFunPesq.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		cbAdmFunPesq.setBounds(111, 13, 227, 34);
		JPAdmFuncionario.add(cbAdmFunPesq);

		// caixa de texto para escrever a procura do funcionario
		JTextField tbAdmFunPesq = new JTextField();
		tbAdmFunPesq.setBounds(111, 60, 227, 31);
		JPAdmFuncionario.add(tbAdmFunPesq);

		// texto : Nome
		JLabel lblAdmFunNome = new JLabel("Nome:");
		lblAdmFunNome.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunNome.setBounds(420, 111, 57, 30);
		JPAdmFuncionario.add(lblAdmFunNome);

		// texto : data de nascimento
		JLabel lblAdmFunDataDeNascimento = new JLabel("Data de Nascimento:");
		lblAdmFunDataDeNascimento.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunDataDeNascimento.setBounds(420, 171, 177, 30);
		JPAdmFuncionario.add(lblAdmFunDataDeNascimento);

		// texto : documento
		JLabel lblAdmFunDocumento = new JLabel("Documento:");
		lblAdmFunDocumento.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunDocumento.setBounds(420, 232, 108, 30);
		JPAdmFuncionario.add(lblAdmFunDocumento);

		// radiobutton : documento
		JRadioButton rbAdmFunCC = new JRadioButton("C.C.");
		rbAdmFunCC.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		rbAdmFunCC.setBounds(531, 235, 66, 25);
		JPAdmFuncionario.add(rbAdmFunCC);

		// radiobutton : documento
		JRadioButton rbAdmFunBI = new JRadioButton("B.I.");
		rbAdmFunBI.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		rbAdmFunBI.setBounds(610, 235, 57, 25);
		JPAdmFuncionario.add(rbAdmFunBI);

		// radiobutton : documento
		JRadioButton rbAdmFunPass = new JRadioButton("Passaporte");
		rbAdmFunPass.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		rbAdmFunPass.setBounds(679, 235, 138, 25);
		JPAdmFuncionario.add(rbAdmFunPass);
		bg.add(rbAdmFunCC);
		bg.add(rbAdmFunBI);
		bg.add(rbAdmFunPass);

		// texto : numero do documento
		JLabel lblAdmFunNumero = new JLabel("Número de Identificação:");
		lblAdmFunNumero.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunNumero.setBounds(420, 260, 227, 30);
		JPAdmFuncionario.add(lblAdmFunNumero);

		// texto : contato
		JLabel lblAdmFunContacto = new JLabel("Contacto:");
		lblAdmFunContacto.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunContacto.setBounds(420, 326, 81, 31);
		JPAdmFuncionario.add(lblAdmFunContacto);

		// texto : username
		JLabel lblAdmFunUsername = new JLabel("UserName:");
		lblAdmFunUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunUsername.setBounds(421, 464, 120, 30);
		JPAdmFuncionario.add(lblAdmFunUsername);

		// texto : username
		JLabel lblAdmFunPassword = new JLabel("Password:");
		lblAdmFunPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblAdmFunPassword.setBounds(689, 464, 153, 30);
		JPAdmFuncionario.add(lblAdmFunPassword);

		// Campos de texto - nome
		textAdmFunNome = new JTextField();
		textAdmFunNome.setColumns(10);
		textAdmFunNome.setBounds(430, 142, 217, 31);
		JPAdmFuncionario.add(textAdmFunNome);

		// Campos de texto - numero
		textAdmFunNumero = new JTextField();
		textAdmFunNumero.setColumns(10);
		textAdmFunNumero.setBounds(430, 293, 225, 31);
		JPAdmFuncionario.add(textAdmFunNumero);

		// Campos de texto - contato
		textAdmFunContato = new JTextField();
		textAdmFunContato.setColumns(10);
		textAdmFunContato.setBounds(430, 357, 225, 31);
		JPAdmFuncionario.add(textAdmFunContato);

		// Campos de texto - username
		textAdmFunUser = new JTextField();
		textAdmFunUser.setColumns(10);
		textAdmFunUser.setBounds(431, 492, 225, 31);
		JPAdmFuncionario.add(textAdmFunUser);

		// Campos de texto - pass
		textAdmFunPass = new JTextField();
		textAdmFunPass.setColumns(10);
		textAdmFunPass.setBounds(689, 492, 225, 31);
		JPAdmFuncionario.add(textAdmFunPass);

		JRadioButton rbadmfuncionario = new JRadioButton("Funcionario");
		rbadmfuncionario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rbadmfuncionario.setBounds(420, 84, 121, 25);
		JPAdmFuncionario.add(rbadmfuncionario);

		JRadioButton rbadmadministrador = new JRadioButton("Administrador");
		rbadmadministrador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rbadmadministrador.setBounds(539, 84, 138, 25);
		JPAdmFuncionario.add(rbadmadministrador);

		// Data do funcionario
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.setBounds(430, 202, 217, 31);
		JPAdmFuncionario.add(dateChooser);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblSobrenome.setBounds(666, 109, 120, 30);
		JPAdmFuncionario.add(lblSobrenome);

		textAdmFunSobrenome = new JTextField();
		textAdmFunSobrenome.setColumns(10);
		textAdmFunSobrenome.setBounds(676, 140, 217, 31);
		JPAdmFuncionario.add(textAdmFunSobrenome);

		textAdmFunMorada = new JTextField();
		textAdmFunMorada.setColumns(10);
		textAdmFunMorada.setBounds(430, 422, 225, 31);
		JPAdmFuncionario.add(textAdmFunMorada);

		JLabel lblMorada = new JLabel("Morada: ");
		lblMorada.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblMorada.setBounds(420, 389, 227, 30);
		JPAdmFuncionario.add(lblMorada);
		JList<String> lbLAdmFunLista = new JList<String>(dmFun);
		lbLAdmFunLista.setBounds(109, 109, 240, 441);
		// Metedo que seleciona e passa todos os argumentos para as caixas de texto :

		lbLAdmFunLista.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				bg.clearSelection();
				if (!lbLAdmFunLista.isSelectionEmpty()) {

					String s = lbLAdmFunLista.getSelectedValue();
					s = s.substring(0, s.indexOf(" "));

					Utilizador f = gb.javabank.selectUtilizador(Integer.parseInt(s), gb.javabank.getUtlizadores());

					textAdmFunNome.setText(f.getNome());
					textAdmFunSobrenome.setText(f.getSobrenome());
					textAdmFunMorada.setText(f.getMorada());
					textAdmFunContato.setText("" + f.getContacto());
					textAdmFunUser.setText(f.getUsername());
					textAdmFunPass.setText(f.getPassword());
					textAdmFunNumero.setText("" + f.getNumidentificacao());
					dateChooser.setDate(f.getDataDeNascimento());

					if (f.getTipoIndentificacao().equals("C.C.")) {
						rbAdmFunCC.setSelected(true);
					}
					if (f.getTipoIndentificacao().equals("B.I.")) {
						rbAdmFunBI.setSelected(true);
					}
					if (f.getTipoIndentificacao().equals("Passaporte")) {
						rbAdmFunPass.setSelected(true);
					}

					if (f instanceof Administrador) {
						rbadmadministrador.setSelected(true);
						rbadmfuncionario.setSelected(false);
					} else {
						rbadmadministrador.setSelected(false);
						rbadmfuncionario.setSelected(true);
					}
					rbadmadministrador.setEnabled(false);
					rbadmfuncionario.setEnabled(false);

				}
			}
		});
		JPAdmFuncionario.add(lbLAdmFunLista);

		JButton btnLimpar = new JButton("Limpar ");
		btnLimpar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnLimpar.setBounds(539, 13, 120, 38);
		// limpar pesquisa
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lbLAdmFunLista.clearSelection();
				textAdmFunNome.setText(null);
				textAdmFunSobrenome.setText(null);
				textAdmFunContato.setText(null);
				textAdmFunMorada.setText(null);
				bg.clearSelection();
				textAdmFunNumero.setText(null);
				textAdmFunPass.setText(null);
				textAdmFunUser.setText(null);
				dateChooser.setCalendar(null);
				tbAdmFunPesq.setText(null);
				rbadmfuncionario.setSelected(false);
				rbadmadministrador.setSelected(false);
				rbadmadministrador.setEnabled(true);
				rbadmfuncionario.setEnabled(true);
				;
				// faz atualiza�ao da lista (elimina e de seguida preenche tudo)
				dmFun.removeAllElements();
				gb.javabank.addelementoslist(gb.javabank.listaFunceAdm(gb.javabank.getUtlizadores()), dmFun);

			}
		});
		JPAdmFuncionario.add(btnLimpar);

		// Botao para criar novo funcionario
		JButton btAdmFunNovo = new JButton("Novo");
		btAdmFunNovo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		// acao do botao novo:
		btAdmFunNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lbLAdmFunLista.clearSelection();
				textAdmFunNome.setText(null);
				textAdmFunSobrenome.setText(null);
				textAdmFunContato.setText(null);
				textAdmFunMorada.setText(null);
				bg.clearSelection();
				textAdmFunNumero.setText(null);
				textAdmFunPass.setText(null);
				textAdmFunUser.setText(null);
				dateChooser.setCalendar(null);
				rbadmadministrador.setEnabled(true);
				rbadmfuncionario.setEnabled(true);
				// faz atualiza�ao da lista (elimina e de seguida preenche tudo)
				dmFun.removeAllElements();
				gb.javabank.addelementoslist(gb.javabank.listaFunceAdm(gb.javabank.getUtlizadores()), dmFun);

			}
		});

		btAdmFunNovo.setBounds(608, 525, 120, 38);
		JPAdmFuncionario.add(btAdmFunNovo);

		// botao confirmar funcionario
		JButton btnAdmFunConfirmar_1 = new JButton("Confirmar");
		btnAdmFunConfirmar_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdmFunConfirmar_1.setBounds(476, 525, 120, 38);

		// bt confirmar (adicionar ou alterar )
		btnAdmFunConfirmar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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

				// se nao estiver selecionado nenhum funcionario entao cria um novo/ caso exista
				// algum elemento selecionado da lista faz um update:
				if (lbLAdmFunLista.isSelectionEmpty()) {

					// adicionar funcionario:
					// criar automaticamente os 2 id;
					int id = (gb.javabank.getUtlizadores().get(gb.javabank.getUtlizadores().size() - 1)
							.getIdUtilizador()) + 1;
					int id2 = (gb.javabank.getUtlizadores().get(id + 1)).getIdUtilizador() + 1;
					if (id == 0) {
						id++;
					}

					if (id2 == id) {
						id2++;
					}

					if (rbadmfuncionario.isSelected()) {
						// esta a criar o novo funcionario:
						Utilizador fun = new Funcionario(id, textAdmFunNome.getText(), textAdmFunSobrenome.getText(),
								dateChooser.getDate(), opselect, Integer.parseInt(textAdmFunNumero.getText()),
								textAdmFunMorada.getText(), Integer.parseInt(textAdmFunContato.getText()),
								textAdmFunUser.getText(), textAdmFunPass.getText(), id2);
						gb.javabank.getUtlizadores().add(fun);

						// faz atualiza�ao da lista (elimina e de seguida preenche tudo)
						dmFun.removeAllElements();
						gb.javabank.addelementoslist(gb.javabank.listaFunceAdm(gb.javabank.getUtlizadores()), dmFun);
						JOptionPane.showMessageDialog(null, "Funcionario criado com sucesso!");
					} else {
						Utilizador adm = new Administrador(id, textAdmFunNome.getText(), textAdmFunSobrenome.getText(),
								dateChooser.getDate(), opselect, Integer.parseInt(textAdmFunNumero.getText()),
								textAdmFunMorada.getText(), Integer.parseInt(textAdmFunContato.getText()),
								textAdmFunUser.getText(), textAdmFunPass.getText());
						gb.javabank.getUtlizadores().add(adm);
						JOptionPane.showMessageDialog(null, "Administrador criado com sucesso!");
					}

				} else {
					// atualizar Funcionario ou admin:
					// seleciona id;
					String s = lbLAdmFunLista.getSelectedValue();
					s = s.substring(0, s.indexOf(" "));

					// metedo para atualizar:
					if (gb.javabank.selectUtilizador(Integer.parseInt(s),
							gb.javabank.getUtlizadores()) instanceof Funcionario) {
						gb.javabank.actualizaFun(
								(Funcionario) gb.javabank.selectUtilizador(Integer.parseInt(s),
										gb.javabank.getUtlizadores()),
								textAdmFunNome.getText(), textAdmFunSobrenome.getText(), dateChooser.getDate(),
								opselect, Integer.parseInt(textAdmFunNumero.getText()), textAdmFunMorada.getText(),
								Integer.parseInt(textAdmFunContato.getText()), textAdmFunUser.getText(),
								textAdmFunPass.getText());
					} else {
						gb.javabank.actualizaAdmin(
								(Administrador) gb.javabank.selectUtilizador(Integer.parseInt(s),
										gb.javabank.getUtlizadores()),
								textAdmFunNome.getText(), textAdmFunSobrenome.getText(), dateChooser.getDate(),
								opselect, Integer.parseInt(textAdmFunNumero.getText()), textAdmFunMorada.getText(),
								Integer.parseInt(textAdmFunContato.getText()), textAdmFunUser.getText(),
								textAdmFunPass.getText());
					}
					// faz atualiza�ao da lista (elimina e de seguida preenche tudo)
					dmFun.removeAllElements();
					gb.javabank.addelementoslist(gb.javabank.listaFunceAdm(gb.javabank.getUtlizadores()), dmFun);
					JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso!");

				}

				lbLAdmFunLista.clearSelection();
				textAdmFunNome.setText("");
				textAdmFunSobrenome.setText("");
				textAdmFunMorada.setText(null);
				textAdmFunContato.setText(null);
				bg.clearSelection();
				textAdmFunUser.setText("");
				textAdmFunPass.setText("");
				textAdmFunNumero.setText("");
				dateChooser.setDate(null);
				rbadmadministrador.setEnabled(true);
				rbadmfuncionario.setEnabled(true);
				rbadmadministrador.setSelected(false);
				rbadmfuncionario.setSelected(false);
			}
		});

		JPAdmFuncionario.add(btnAdmFunConfirmar_1);

		// botao eliminar funcionario
		JButton btnAdmFunEliminar = new JButton("Eliminar");
		btnAdmFunEliminar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdmFunEliminar.setBounds(740, 525, 120, 38);
		// metodo elimina funcionario
		btnAdmFunEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!lbLAdmFunLista.isSelectionEmpty()) {

					// ver o id selecionado
					String s = lbLAdmFunLista.getSelectedValue();
					s = s.substring(0, s.indexOf(" "));

					if (Integer.parseInt(s) == adm.getIdUtilizador()) {
						JOptionPane.showMessageDialog(null, "Nao pode eliminar o seu proprio utilizador!");
					} else {

						gb.javabank.eliminautilizador(Integer.parseInt(s), gb.javabank.getUtlizadores(),
								gb.javabank.getContas());

						// faz atualiza�ao da lista (elimina e de seguida preenche tudo)
						dmFun.removeAllElements();
						gb.javabank.addelementoslist(gb.javabank.listaFunceAdm(gb.javabank.getUtlizadores()), dmFun);
						JOptionPane.showMessageDialog(null, "Utilizador eliminado com sucesso!");
					}
				}

				lbLAdmFunLista.clearSelection();
				textAdmFunNome.setText("");
				textAdmFunSobrenome.setText("");
				textAdmFunMorada.setText(null);
				textAdmFunContato.setText(null);
				bg.clearSelection();
				textAdmFunUser.setText("");
				textAdmFunPass.setText("");
				textAdmFunNumero.setText("");
				dateChooser.setDate(null);

			}
		});
		JPAdmFuncionario.add(btnAdmFunEliminar);

		// Botao de procurar
		JButton btAdmFunProc = new JButton("Procurar");
		btAdmFunProc.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btAdmFunProc.setBounds(395, 13, 120, 38);
		// pesquisar funcionarios por atributos
		btAdmFunProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (cbAdmFunPesq.getSelectedItem().equals("ID")) {

					int id = Integer.parseInt(tbAdmFunPesq.getText());
					Utilizador u;

					if (gb.javabank.selectUtilizador(id, gb.javabank.getUtlizadores()) instanceof Funcionario) {
						u = (Funcionario) gb.javabank.selectUtilizador(id, gb.javabank.getUtlizadores());
					} else {
						u = (Administrador) gb.javabank.selectUtilizador(id, gb.javabank.getUtlizadores());
					}

					textAdmFunNome.setText(u.getNome());
					textAdmFunSobrenome.setText(u.getSobrenome());
					textAdmFunMorada.setText(u.getMorada());
					textAdmFunContato.setText(String.valueOf(u.getContacto()));
					textAdmFunUser.setText(u.getUsername());
					textAdmFunPass.setText(u.getPassword());
					textAdmFunNumero.setText("" + u.getNumidentificacao());
					dateChooser.setDate(u.getDataDeNascimento());

					if (u.getTipoIndentificacao().equals("C.C.")) {
						rbAdmFunCC.setSelected(true);
					}
					if (u.getTipoIndentificacao().equals("B.I.")) {
						rbAdmFunBI.setSelected(true);
					}
					if (u.getTipoIndentificacao().equals("Passaporte")) {
						rbAdmFunPass.setSelected(true);
					}

					dmFun.removeAllElements();
					// para o funcionario:

					dmFun.addElement(u.getIdUtilizador() + " " + u.getNome() + " " + u.getSobrenome());
				}

				if (cbAdmFunPesq.getSelectedItem().equals("Nome")) {

					String nome = tbAdmFunPesq.getText();

					Utilizador u = gb.javabank.selectUtilizadorNome(nome, gb.javabank.getUtlizadores());

					textAdmFunNome.setText(u.getNome());
					textAdmFunSobrenome.setText(u.getSobrenome());
					textAdmFunMorada.setText(u.getMorada());
					textAdmFunContato.setText(String.valueOf(u.getContacto()));
					textAdmFunUser.setText(u.getUsername());
					textAdmFunPass.setText(u.getPassword());
					textAdmFunNumero.setText("" + u.getNumidentificacao());
					dateChooser.setDate(u.getDataDeNascimento());

					if (u.getTipoIndentificacao().equals("C.C.")) {
						rbAdmFunCC.setSelected(true);
					}
					if (u.getTipoIndentificacao().equals("B.I.")) {
						rbAdmFunBI.setSelected(true);
					}
					if (u.getTipoIndentificacao().equals("Passaporte")) {
						rbAdmFunPass.setSelected(true);
					}

					dmFun.removeAllElements();
					dmFun.addElement(u.getIdUtilizador() + " " + u.getNome() + " " + u.getSobrenome());
				}

			}
		});
		JPAdmFuncionario.add(btAdmFunProc);

		// grupo de botoes:
		ButtonGroup bgadm = new ButtonGroup();
		bgadm.add(rbadmadministrador);
		bgadm.add(rbadmfuncionario);

		JPanel jpConta = new JPanel();
		jpConta.setBounds(0, 0, 1042, 576);
		JPAdm.add(jpConta);
		jpConta.setVisible(false);
		jpConta.setLayout(null);

		tbadmcontanumero = new JTextField();
		tbadmcontanumero.setBounds(341, 13, 253, 30);
		tbadmcontanumero.setEditable(false);
		tbadmcontanumero.setColumns(10);
		jpConta.add(tbadmcontanumero);

		dcadmcontadata = new JDateChooser();
		dcadmcontadata.setBounds(341, 56, 253, 30);
		dcadmcontadata.setEnabled(false);
		jpConta.add(dcadmcontadata);

		JLabel lblNewLabel_1 = new JLabel("Numero de Conta:");
		lblNewLabel_1.setBounds(191, 19, 138, 16);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jpConta.add(lblNewLabel_1);

		tbadmcontalimoperacao = new JTextField();
		tbadmcontalimoperacao.setBounds(341, 129, 253, 30);
		tbadmcontalimoperacao.setEditable(false);
		tbadmcontalimoperacao.setColumns(10);
		jpConta.add(tbadmcontalimoperacao);

		tbadmcontalimdia = new JTextField();
		tbadmcontalimdia.setBounds(341, 172, 253, 30);
		tbadmcontalimdia.setEditable(false);
		tbadmcontalimdia.setColumns(10);
		jpConta.add(tbadmcontalimdia);

		tbadmcontasaldo = new JTextField();
		tbadmcontasaldo.setBounds(341, 215, 253, 30);
		tbadmcontasaldo.setEditable(false);
		tbadmcontasaldo.setColumns(10);
		jpConta.add(tbadmcontasaldo);

		JLabel lblDataDaCriao = new JLabel("Data da Cria\u00E7\u00E3o:");
		lblDataDaCriao.setBounds(197, 62, 125, 24);
		lblDataDaCriao.setFont(new Font("Dialog", Font.PLAIN, 17));
		jpConta.add(lblDataDaCriao);

		JLabel lblPorOperao = new JLabel("Por Opera\u00E7\u00E3o:");
		lblPorOperao.setBounds(216, 130, 113, 24);
		lblPorOperao.setFont(new Font("Dialog", Font.PLAIN, 17));
		jpConta.add(lblPorOperao);

		JLabel lblPorDia = new JLabel("Por dia:");
		lblPorDia.setBounds(262, 173, 67, 24);
		lblPorDia.setFont(new Font("Dialog", Font.PLAIN, 17));
		jpConta.add(lblPorDia);

		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(278, 216, 51, 24);
		lblSaldo.setFont(new Font("Dialog", Font.PLAIN, 17));
		jpConta.add(lblSaldo);

		JLabel lblLimites = new JLabel("Limites de Levantamento:");
		lblLimites.setBounds(366, 99, 198, 24);
		lblLimites.setFont(new Font("Dialog", Font.PLAIN, 17));
		jpConta.add(lblLimites);

		JPanel panelContaPadm = new JPanel();
		panelContaPadm.setBounds(191, 258, 415, 111);
		jpConta.add(panelContaPadm);
		panelContaPadm.setLayout(null);

		JLabel lblContasPoupana = new JLabel("Contas Poupan\u00E7a:");
		lblContasPoupana.setBounds(211, 0, 138, 24);
		panelContaPadm.add(lblContasPoupana);
		lblContasPoupana.setFont(new Font("Dialog", Font.PLAIN, 17));

		tbadmcontajuros = new JTextField();
		tbadmcontajuros.setEditable(false);
		tbadmcontajuros.setBounds(150, 27, 253, 30);
		panelContaPadm.add(tbadmcontajuros);
		tbadmcontajuros.setColumns(10);

		JLabel lblJuros = new JLabel("Juros (%):");
		lblJuros.setBounds(54, 28, 84, 24);
		panelContaPadm.add(lblJuros);
		lblJuros.setFont(new Font("Dialog", Font.PLAIN, 17));

		JLabel lblLimiteMs = new JLabel("Limite M\u00EAs");
		lblLimiteMs.setBounds(54, 74, 84, 24);
		panelContaPadm.add(lblLimiteMs);
		lblLimiteMs.setFont(new Font("Dialog", Font.PLAIN, 17));

		tbadmcontalimmes = new JTextField();
		tbadmcontalimmes.setEditable(false);
		tbadmcontalimmes.setBounds(150, 73, 253, 30);
		panelContaPadm.add(tbadmcontalimmes);
		tbadmcontalimmes.setColumns(10);

		JPanel panelCartaoAdm = new JPanel();
		panelCartaoAdm.setBounds(191, 382, 415, 111);
		jpConta.add(panelCartaoAdm);
		panelCartaoAdm.setLayout(null);

		tbadmcontacartaonome = new JTextField();
		tbadmcontacartaonome.setEditable(false);
		tbadmcontacartaonome.setColumns(10);
		tbadmcontacartaonome.setBounds(154, 13, 247, 22);
		panelCartaoAdm.add(tbadmcontacartaonome);

		JDateChooser tbadmcontacartaovalidade = new JDateChooser();
		tbadmcontacartaovalidade.setEnabled(false);
		tbadmcontacartaovalidade.setBounds(154, 48, 247, 22);
		panelCartaoAdm.add(tbadmcontacartaovalidade);

		tbadmcontacartaocod = new JTextField();
		tbadmcontacartaocod.setEditable(false);
		tbadmcontacartaocod.setColumns(10);
		tbadmcontacartaocod.setBounds(154, 83, 247, 22);
		panelCartaoAdm.add(tbadmcontacartaocod);

		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(83, 15, 72, 16);
		panelCartaoAdm.add(label);

		JLabel label_1 = new JLabel("Validade");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(83, 54, 72, 16);
		panelCartaoAdm.add(label_1);

		JLabel label_2 = new JLabel("COD:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(83, 85, 59, 16);
		panelCartaoAdm.add(label_2);

		JButton btVoltarContasAdm = new JButton("Voltar");
		btVoltarContasAdm.setBounds(427, 538, 97, 25);
		jpConta.add(btVoltarContasAdm);

		JList<String> listcontasadm = new JList<String>(dlmcontaadm);
		listcontasadm.setBounds(12, 56, 147, 493);
		gb.javabank.addelementoslist(gb.javabank.listanumerodecontas(gb.javabank.getContas()), dlmcontaadm);
		listcontasadm.setVisible(false);
		jpConta.add(listcontasadm);

		JCheckBox cboxaberta = new JCheckBox("Aberta");
		cboxaberta.setBounds(341, 502, 113, 25);
		cboxaberta.setEnabled(false);
		jpConta.add(cboxaberta);

		JLabel lblContas = new JLabel("Contas:");
		lblContas.setBounds(12, 20, 67, 24);
		lblContas.setFont(new Font("Dialog", Font.PLAIN, 17));
		jpConta.add(lblContas);

		textFieldAdminDescr = new JTextField();
		textFieldAdminDescr.setBounds(644, 443, 373, 38);
		textFieldAdminDescr.setEditable(false);
		textFieldAdminDescr.setColumns(10);
		jpConta.add(textFieldAdminDescr);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(644, 59, 373, 372);
		jpConta.add(scrollPane);
		table = new JTable(modeloTabela);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int linha = table.getSelectedRow();
				int idDesc = (int) table.getModel().getValueAt(linha, 0);
				String descricao = gb.javabank.descricaoOpercacoes(idDesc);

				textFieldAdminDescr.setText(descricao);
			}
		});
		scrollPane.setViewportView(table);

		// Painel da gestao do administrador
		JPanel JPAdmGestao = new JPanel();
		JPAdmGestao.setBounds(0, 0, 1042, 576);
		JPAdm.add(JPAdmGestao);
		JPAdmGestao.setLayout(null);
		JPAdmGestao.setVisible(false);

		// limpa contas e sai do painel de contas para o painel cliente:
		btVoltarContasAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tbadmcontanumero.setText(null);
				dcadmcontadata.setDate(null);
				tbadmcontalimoperacao.setText(null);
				tbadmcontalimdia.setText(null);
				tbadmcontasaldo.setText(null);
				tbadmcontajuros.setText(null);
				tbadmcontalimmes.setText(null);
				tbadmcontacartaonome.setText(null);
				tbadmcontacartaovalidade.setDate(null);
				tbadmcontacartaocod.setText(null);

				cboxaberta.setVisible(false);
				JPAdmEstatistica.setVisible(false);
				JPAdmCliente.setVisible(true);
				JPAdmFuncionario.setVisible(false);
				JPAdmGestao.setVisible(false);
				jpConta.setVisible(false);
				panelContaPadm.setVisible(true);
				panelCartaoAdm.setVisible(true);

			}
		});

		listcontasadm.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				modeloTabela.setRowCount(0);

				cboxaberta.setVisible(true);
				Conta c = gb.javabank.SelectConta(Integer.parseInt(listcontasadm.getSelectedValue()),
						gb.javabank.getContas());

				tbadmcontanumero.setText(c.getIdConta() + "");
				dcadmcontadata.setDate(c.getDataCriacao());
				tbadmcontalimoperacao.setText(c.getValorMaxLevantamento() + "");
				tbadmcontalimdia.setText(c.getValorMaxDia() + "");
				tbadmcontasaldo.setText(c.getSaldo() + "");

				gb.javabank.preenchetabelaOperacoesTransferencia(modeloTabela, c);
				gb.javabank.preenchetabelaOperacoesDeposito(modeloTabela, c);
				gb.javabank.preenchetabelaOperacoesLevantamento(modeloTabela, c);

				if (c instanceof ContaCorrente) {
					if (((ContaCorrente) c).getCartao() != 0) {
						panelContaPadm.setVisible(false);
						panelCartaoAdm.setVisible(true);
						Cartao cartao = gb.javabank.obterCartao(gb.javabank.getCartoes(),
								((ContaCorrente) c).getCartao());
						tbadmcontacartaonome.setText(cartao.getNomeTitular());
						tbadmcontacartaovalidade.setDate(cartao.getDataValidade());
						tbadmcontacartaocod.setText(cartao.getCodvalidacao() + "");
					}
				} else {

					panelContaPadm.setVisible(true);
					panelCartaoAdm.setVisible(false);
					tbadmcontajuros.setText(((ContaPoupanca) c).getTaxaJuros() + "");
					tbadmcontalimmes.setText(((ContaPoupanca) c).getLimiteMensalDebito() + "");
				}

			}
		});

		// linha que separa na parte da gestao
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		separator_1.setBounds(705, 74, 29, 433);
		JPAdmGestao.add(separator_1);

		// texto : username
		JLabel lblUsername_1 = new JLabel("Username :");
		lblUsername_1.setVerifyInputWhenFocusTarget(false);
		lblUsername_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsername_1.setBounds(450, 85, 206, 41);
		JPAdmGestao.add(lblUsername_1);

		// campo de texto na gestão da parte do administrador

		lblAdminGestUsername = new JTextField(adm.getUsername());
		lblAdminGestUsername.setBounds(450, 138, 206, 33);
		JPAdmGestao.add(lblAdminGestUsername);

		// texto : password
		JLabel lblPassword_1 = new JLabel("Password :");
		lblPassword_1.setVerifyInputWhenFocusTarget(false);
		lblPassword_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword_1.setBounds(450, 182, 206, 41);
		JPAdmGestao.add(lblPassword_1);

		// campo de texto na gestão da parte do administrador
		textAdminGestPass = new JTextField();
		textAdminGestPass.setColumns(10);
		textAdminGestPass.setBounds(450, 234, 206, 33);
		JPAdmGestao.add(textAdminGestPass);

		// texto : novausername
		JLabel textFieldAdminGestUsername = new JLabel("Nova Username :");
		textFieldAdminGestUsername.setVerifyInputWhenFocusTarget(false);
		textFieldAdminGestUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		textFieldAdminGestUsername.setBounds(450, 279, 206, 41);
		JPAdmGestao.add(textFieldAdminGestUsername);

		// campo de texto na gestão da parte do administrador
		textFieldAdminGestNovaUser = new JTextField();
		textFieldAdminGestNovaUser.setColumns(10);
		textFieldAdminGestNovaUser.setBounds(450, 331, 206, 33);
		JPAdmGestao.add(textFieldAdminGestNovaUser);

		// botao de confimar - submete a nova username
		JButton btnAdminGestConfirmar = new JButton("Confirmar");
		btnAdminGestConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdminGestConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (adm.getPassword().equals(textAdminGestPass.getText())) {

					adm.setUsername(textFieldAdminGestNovaUser.getText());
					textAdminGestPass.setText(null);
					textFieldAdminGestNovaUser.setText(null);
					lblAdminGestUsername.setText(adm.getUsername());
					JOptionPane.showMessageDialog(null, "O username foi alterado com sucesso!");
				}
			}
		});
		btnAdminGestConfirmar.setBounds(412, 419, 131, 41);
		JPAdmGestao.add(btnAdminGestConfirmar);

		// botao de cancelar - limpar
		JButton btnAdminGestCancelar = new JButton("Cancelar");
		btnAdminGestCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textAdminGestPass.setText(null);
				textFieldAdminGestNovaUser.setText(null);

			}
		});
		btnAdminGestCancelar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdminGestCancelar.setBounds(562, 419, 131, 41);
		JPAdmGestao.add(btnAdminGestCancelar);

		// campo de texto na gestão da parte do administrador
		textFieldAdminGestPass1 = new JTextField();
		textFieldAdminGestPass1.setColumns(10);
		textFieldAdminGestPass1.setBounds(817, 138, 195, 33);
		JPAdmGestao.add(textFieldAdminGestPass1);

		// texto : password 2
		JLabel lblPassword_2 = new JLabel("Password :");
		lblPassword_2.setVerifyInputWhenFocusTarget(false);
		lblPassword_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword_2.setBounds(817, 85, 195, 41);
		JPAdmGestao.add(lblPassword_2);

		// texto : nova password
		JLabel lblNovaPassword = new JLabel("Nova Password :");
		lblNovaPassword.setVerifyInputWhenFocusTarget(false);
		lblNovaPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNovaPassword.setBounds(817, 182, 195, 41);
		JPAdmGestao.add(lblNovaPassword);

		// campo de texto na gestão da parte do administrador
		textFieldAdminGestNovaPass = new JTextField();
		textFieldAdminGestNovaPass.setColumns(10);
		textFieldAdminGestNovaPass.setBounds(817, 234, 195, 33);
		JPAdmGestao.add(textFieldAdminGestNovaPass);

		// texto : confirmar password
		JLabel lblConfirmarNovaPass = new JLabel("Confirmar Password :");
		lblConfirmarNovaPass.setVerifyInputWhenFocusTarget(false);
		lblConfirmarNovaPass.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblConfirmarNovaPass.setBounds(817, 279, 195, 41);
		JPAdmGestao.add(lblConfirmarNovaPass);

		// campo de texto na gestão da parte do administrador
		textFieldAdminGestConf = new JTextField();
		textFieldAdminGestConf.setColumns(10);
		textFieldAdminGestConf.setBounds(817, 331, 195, 33);
		JPAdmGestao.add(textFieldAdminGestConf);

		// botao de confimar - submete a nova pass
		JButton buttonAdminGestConf = new JButton("Confirmar");
		buttonAdminGestConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (adm.getPassword().equals(textFieldAdminGestPass1.getText())
						&& textFieldAdminGestConf.getText().equals(textFieldAdminGestNovaPass.getText())) {

					adm.setPassword(textFieldAdminGestNovaPass.getText());

					textFieldAdminGestPass1.setText(null);
					textFieldAdminGestConf.setText(null);
					textFieldAdminGestNovaPass.setText(null);
					JOptionPane.showMessageDialog(null, "A password foi alterado com sucesso!");

				}
			}
		});
		buttonAdminGestConf.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		buttonAdminGestConf.setBounds(761, 419, 131, 41);
		JPAdmGestao.add(buttonAdminGestConf);

		// botao de cancelar - limpar
		JButton buttonAdminGestCan = new JButton("Cancelar");
		buttonAdminGestCan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textFieldAdminGestPass1.setText(null);
				textFieldAdminGestConf.setText(null);
				textFieldAdminGestNovaPass.setText(null);
			}
		});
		buttonAdminGestCan.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		buttonAdminGestCan.setBounds(911, 419, 131, 41);
		JPAdmGestao.add(buttonAdminGestCan);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setAlignmentX(0.0f);
		separator_2.setBounds(371, 74, 29, 433);
		JPAdmGestao.add(separator_2);

		JLabel label_3 = new JLabel("Nome:");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_3.setBounds(12, 64, 57, 30);
		JPAdmGestao.add(label_3);

		tbadmnome = new JTextField();
		tbadmnome.setEditable(false);
		tbadmnome.setColumns(10);
		tbadmnome.setBounds(22, 95, 217, 31);
		JPAdmGestao.add(tbadmnome);

		tbadmapelido = new JTextField();
		tbadmapelido.setEditable(false);
		tbadmapelido.setColumns(10);
		tbadmapelido.setBounds(22, 166, 217, 31);
		JPAdmGestao.add(tbadmapelido);

		JLabel label_4 = new JLabel("Sobrenome:");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_4.setBounds(12, 135, 120, 30);
		JPAdmGestao.add(label_4);

		JDateChooser dcadmdtnasc = new JDateChooser();
		dcadmdtnasc.setEnabled(false);
		dcadmdtnasc.setBounds(22, 230, 217, 31);
		JPAdmGestao.add(dcadmdtnasc);

		JLabel label_5 = new JLabel("Data de Nascimento:");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_5.setBounds(12, 199, 177, 30);
		JPAdmGestao.add(label_5);

		JRadioButton rbadmcc = new JRadioButton("C.C.");
		rbadmcc.setEnabled(false);
		rbadmcc.setFont(new Font("Dialog", Font.PLAIN, 15));
		rbadmcc.setBounds(22, 270, 66, 25);
		JPAdmGestao.add(rbadmcc);

		JRadioButton rbadmbi = new JRadioButton("B.I.");
		rbadmbi.setEnabled(false);
		rbadmbi.setFont(new Font("Dialog", Font.PLAIN, 15));
		rbadmbi.setBounds(101, 270, 57, 25);
		JPAdmGestao.add(rbadmbi);

		JRadioButton rbadmpassporte = new JRadioButton("Passaporte");
		rbadmpassporte.setEnabled(false);
		rbadmpassporte.setFont(new Font("Dialog", Font.PLAIN, 15));
		rbadmpassporte.setBounds(170, 270, 138, 25);
		JPAdmGestao.add(rbadmpassporte);

		tbadmnident = new JTextField();
		tbadmnident.setEditable(false);
		tbadmnident.setColumns(10);
		tbadmnident.setBounds(14, 332, 225, 31);
		JPAdmGestao.add(tbadmnident);

		JLabel label_7 = new JLabel("N\u00C3\u00BAmero de Identifica\u00C3\u00A7\u00C3\u00A3o:");
		label_7.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_7.setBounds(4, 296, 227, 30);
		JPAdmGestao.add(label_7);

		JLabel label_8 = new JLabel("Contacto:");
		label_8.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_8.setBounds(4, 365, 81, 31);
		JPAdmGestao.add(label_8);

		tbadmcontacto = new JTextField();
		tbadmcontacto.setEditable(false);
		tbadmcontacto.setColumns(10);
		tbadmcontacto.setBounds(14, 396, 225, 31);
		JPAdmGestao.add(tbadmcontacto);

		JLabel label_9 = new JLabel("Morada: ");
		label_9.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_9.setBounds(4, 428, 227, 30);
		JPAdmGestao.add(label_9);

		tbadmmorada = new JTextField();
		tbadmmorada.setEditable(false);
		tbadmmorada.setColumns(10);
		tbadmmorada.setBounds(14, 461, 225, 31);
		JPAdmGestao.add(tbadmmorada);

		JPAdmCliente.setLayout(null);
		JPAdm.add(JPAdmCliente);
		JComboBox boxAdminCliePesquisa = new JComboBox(texto2);
		boxAdminCliePesquisa.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		boxAdminCliePesquisa.setBounds(400, 16, 218, 43);
		JPAdmCliente.add(boxAdminCliePesquisa);

		// caixa da data
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(366, 209, 217, 31);
		JPAdmCliente.add(dateChooser_1);

		JList<String> listaAdminClie = new JList<String>(dmClt);
		listaAdminClie.setBounds(56, 85, 240, 441);
		// Metedo que seleciona e passa todos os argumentos para as caixas de texto :

		listaAdminClie.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				dmCltContas.removeAllElements();
				bg.clearSelection();
				if (!listaAdminClie.isSelectionEmpty()) {

					String s = listaAdminClie.getSelectedValue();
					s = s.substring(0, s.indexOf("*"));
					Cliente c = (Cliente) gb.javabank.selectUtilizador(Integer.parseInt(s),
							gb.javabank.getUtlizadores());
					textAdminClieNome.setText(c.getNome());
					textAdminClieEndereco.setText(c.getMorada());
					textAdminClieContato.setText("" + c.getContacto());
					textAdminClieNif.setText("" + c.getNumidentificacao());
					dateChooser_1.setDate(c.getDataDeNascimento());
					dmCltContas.removeAllElements();

					gb.javabank.addelementoslist(gb.javabank.listacontadecliente(c, gb.javabank.getContas()),
							dmCltContas);

				}
			}
		});

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

		// lista de contas do admin:
		JList<String> listAdminClieContas = new JList<String>(dmCltContas);
		listAdminClieContas.setBounds(736, 85, 240, 441);
		JPAdmCliente.add(listAdminClieContas);

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

		// botao a limpar os dados no ecra
		JButton btnAdminClieLimpar = new JButton("Limpar");
		btnAdminClieLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dmCltContas.removeAllElements();
				listaAdminClie.clearSelection();
				listAdminClieContas.clearSelection();
				textAdminClieNome.setText(null);
				textAdminClieEndereco.setText(null);
				textAdminClieContato.setText(null);
				textAdminClieNif.setText(null);
				dateChooser_1.setDate(null);
				textAdminCliePesquisa.setText(null);

				// faz atualiza�ao da lista (elimina e de seguida preenche tudo)
				dmClt.removeAllElements();
				gb.javabank.addelementoslist(gb.javabank.listarClientes(gb.javabank.getUtlizadores()), dmClt);
				dmCltContas.removeAllElements();
				gb.javabank.addelementoslist(gb.javabank.listanumerodecontas(gb.javabank.getContas()), dmCltContas);
			}
		});
		btnAdminClieLimpar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdminClieLimpar.setBounds(522, 488, 120, 38);
		JPAdmCliente.add(btnAdminClieLimpar);

		JButton btnAdmCltPesquisar = new JButton("Pesquisar");
		btnAdmCltPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (boxAdminCliePesquisa.getSelectedItem().equals("ID")) {

					int id = Integer.parseInt(textAdminCliePesquisa.getText());

					Cliente c = (Cliente) gb.javabank.selectUtilizador(id, gb.javabank.getUtlizadores());

//					

					textAdminClieNome.setText(c.getNome());
					textAdminClieEndereco.setText(c.getMorada());
					textAdminClieContato.setText("" + c.getContacto());
					textAdminClieNif.setText("" + c.getNumidentificacao());
					dateChooser_1.setDate(c.getDataDeNascimento());

					dmClt.removeAllElements();
					dmClt.addElement(c.getIdUtilizador() + " " + c.getNome() + " " + c.getSobrenome());
					dmCltContas.removeAllElements();

				}

				if (boxAdminCliePesquisa.getSelectedItem().equals("Nome")) {

					String nome = textAdminCliePesquisa.getText();

					Cliente c = (Cliente) gb.javabank.selectUtilizadorNome(nome, gb.javabank.getUtlizadores());

					textAdminClieNome.setText(c.getNome());
					textAdminClieEndereco.setText(c.getMorada());
					textAdminClieContato.setText("" + c.getContacto());
					textAdminClieNif.setText("" + c.getNumidentificacao());
					dateChooser_1.setDate(c.getDataDeNascimento());

					dmClt.removeAllElements();
					dmClt.addElement(c.getIdUtilizador() + " " + c.getNome() + " " + c.getSobrenome());
					dmCltContas.removeAllElements();

				}

			}
		});

		btnAdmCltPesquisar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAdmCltPesquisar.setBounds(376, 488, 120, 38);
		JPAdmCliente.add(btnAdmCltPesquisar);

		JButton btVerConta = new JButton("Ver Conta");
		btVerConta.setBounds(879, 42, 97, 25);
		JPAdmCliente.add(btVerConta);

		JButton bttodascontas = new JButton("Todas as Conta");

		bttodascontas.setBounds(738, 42, 129, 25);
		JPAdmCliente.add(bttodascontas);

		// box onde escolhemos como queremos fazer a pesquisa do funcionario Nome ou ID

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
				jpConta.setVisible(false);

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
				jpConta.setVisible(false);
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
				jpConta.setVisible(false);

				// preenche dados do funcionario:

				tbadmnome.setText(adm.getNome());
				tbadmapelido.setText(adm.getSobrenome());
				dcadmdtnasc.setDate(adm.getDataDeNascimento());

				if (adm.getTipoIndentificacao().equals("C.C.")) {
					rbadmcc.setSelected(true);
				}
				if (adm.getTipoIndentificacao().equals("B.I.")) {
					rbadmbi.setSelected(true);
				}
				if (adm.getTipoIndentificacao().equals("Passaporte")) {
					rbadmpassporte.setSelected(true);
				}

				tbadmnident.setText(adm.getNumidentificacao() + "");
				tbadmcontacto.setText(adm.getContacto() + "");
				tbadmmorada.setText(adm.getMorada());

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
				jpConta.setVisible(false);
			}
		});
		btAdmFuncionarios.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		// Metedo para ver detalhes das contas selecionadas:
		btVerConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Visivel ao painel:
				JPAdmGestao.setVisible(false);
				JPAdmCliente.setVisible(false);
				JPAdmFuncionario.setVisible(false);
				JPAdmEstatistica.setVisible(false);
				jpConta.setVisible(true);
				listcontasadm.setVisible(false);
				listcontasadm.clearSelection();

				// preenche campos:

				int id = Integer.parseInt(listAdminClieContas.getSelectedValue());

				Conta cont = gb.javabank.SelectConta(id, gb.javabank.getContas());

				tbadmcontanumero.setText(cont.getIdConta() + "");
				dcadmcontadata.setDate(cont.getDataCriacao());
				tbadmcontalimoperacao.setText(cont.getValorMaxLevantamento() + "");
				tbadmcontalimdia.setText(cont.getValorMaxDia() + "");
				tbadmcontasaldo.setText(cont.getSaldo() + "");

				if (cont instanceof ContaCorrente) {
					if (((ContaCorrente) cont).getCartao() != 0) {
						panelContaPadm.setVisible(false);
						panelCartaoAdm.setVisible(true);
						Cartao c = gb.javabank.obterCartao(gb.javabank.getCartoes(),
								((ContaCorrente) cont).getCartao());
						tbadmcontacartaonome.setText(c.getNomeTitular());
						tbadmcontacartaovalidade.setDate(c.getDataValidade());
						tbadmcontacartaocod.setText(c.getCodvalidacao() + "");
					}
				} else {

					panelContaPadm.setVisible(true);
					panelCartaoAdm.setVisible(false);
					tbadmcontajuros.setText(((ContaPoupanca) cont).getTaxaJuros() + "");
					tbadmcontalimmes.setText(((ContaPoupanca) cont).getLimiteMensalDebito() + "");
				}

			}
		});

		bttodascontas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Visivel ao painel:
				JPAdmGestao.setVisible(false);
				JPAdmCliente.setVisible(false);
				JPAdmFuncionario.setVisible(false);
				JPAdmEstatistica.setVisible(false);
				jpConta.setVisible(true);
				listcontasadm.setVisible(true);

			}
		});

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
