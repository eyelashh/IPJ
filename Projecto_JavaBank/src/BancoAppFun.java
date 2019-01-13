
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class BancoAppFun implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private Funcionario func;
	private GestaoBanco gb;
	private JTextField tbCltApelido;
	private JTextField tbCltNum;
	private JTextField tbContasSaldo;
	private JTextField tbContaslimitelevdia;
	private JTextField tblJuros;
	private JTextField tbllimitemes;
	private JDateChooser dateChooser_2;
	private JTextField tbnomecartao;
	private JTextField tbcodcartao;
	private JTextField tbfunnome;
	private JTextField tbfunapelido;
	private JTextField tbfunident;
	private JTextField tbfuncontacto;
	private JTextField tbfunmorada;
	private JTextField tbfunidfunc;
	JPanel jpanelMovimentos = new JPanel();
	JPanel jpanelEliminarContaDataFecho = new JPanel();
	JPanel jpanelOperacoes = new JPanel();
	JPanel jpanelClientes = new JPanel();
	// Tabela clientes nas contas
	private JTable tableClts;
	// Tabela dos movimentos das operações
	private JTable tableMovimentos;
	// Tabela clientes no painel cliente
	private JTable tableListaClts;
	// Default Lista contas painel conta:
	DefaultListModel<String> dmconta = new DefaultListModel<String>();
	// grupo doa botoes CC BI Passport
	ButtonGroup bg = new ButtonGroup();
	// grupo doa botoes conta Corrente e Poupança
	ButtonGroup bgconta = new ButtonGroup();
	// Aqui estive a adicionar itens ao combobox de pesquisa
	String[] itens = new String[] { "Nome", "ID" };
	// Modelo para tabela movimentos
	String[] colunas = { "Tipo", "IDOperacao", "Responsavel", "Data", "Valor", "ContaDestino", "Cliente" };
	// Modelo lista para a tabela dos movimentos
	DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0) {
		public boolean isCellEditable(int rowIndex, int mColIndex) {
			return false;
		}
	};

	// modelo lista das contas dos clientes do painel cliente
	DefaultListModel<String> dlmcontacliente = new DefaultListModel<String>();
	// modelo combobox lista as contas abertas
	DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();

	// Modelo da tabela clientes:
	String[] colunas3 = { "ID", "Nome" };
	DefaultTableModel modeloTabelaCliente = new DefaultTableModel(colunas3, 0) {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Class getColumnClass(int c) {
			switch (c) {
			case 0:
				return Integer.class;
			default:
				return String.class;
			}
		}

		public boolean isCellEditable(int rowIndex, int mColIndex) {
			return false;
		}
	};

	// Modelo da tabela clientes checkBox:
	String[] colunas2 = { "Check", "ID", "Nome" };
	DefaultTableModel model = new DefaultTableModel(colunas2, 0) {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("rawtypes")
		public Class getColumnClass(int c) {
			switch (c) {
			case 0:
				return Boolean.class;
			case 1:
				return Integer.class;
			default:
				return String.class;
			}
		}

		public boolean isCellEditable(int rowIndex, int mColIndex) {
			if (mColIndex == 0) {
				return true;
			} else {
				return false;
			}
		}
	};
	private JTextField tbncartao;
	private JTextField tbdescop;

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
		JButton btnLogOut = new JButton("Logout");
		btnLogOut.setFont(new Font("Lucida Grande", Font.PLAIN, 17));

		// logOut

		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				gb.atualizaficheiro(gb.javabank.getUtlizadores(), gb.javabank.getContas(), gb.javabank.getCartoes());

				Login logout;
				try {
					logout = new Login();
					logout.run();
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		// Preencher tabela apartir do tablemodel:
		gb.javabank.preenchetabelaclientes(model, gb.javabank.getUtlizadores());

		// Painel da gestao do administrador
		JPanel jpanelGestao = new JPanel();
		jpanelGestao.setVisible(false);

		// Painel da conta da parte funcionario
		JPanel jpanelContas = new JPanel();
		jpanelContas.setVisible(false);

		// lista das contas no painel contas
		JList<String> lContas = new JList<String>(dmconta);
		lContas.setBounds(24, 109, 240, 386);
		jpanelContas.add(lContas);

		JRadioButton rdbtnContaCorrente = new JRadioButton("Conta Corrente");
		rdbtnContaCorrente.setSelected(true);
		rdbtnContaCorrente.setBounds(424, 81, 132, 25);
		jpanelContas.add(rdbtnContaCorrente);

		JRadioButton rdbtnContaPoupanca = new JRadioButton("Conta Poupan\u00E7a");
		rdbtnContaPoupanca.setBounds(560, 81, 144, 25);
		jpanelContas.add(rdbtnContaPoupanca);

		JPanel panelCartao = new JPanel();
		panelCartao.setVisible(false);

		JDateChooser dtcartao = new JDateChooser();
		dtcartao.setBounds(72, 67, 190, 22);
		panelCartao.add(dtcartao);
		panelCartao.setBounds(752, 394, 278, 169);
		jpanelContas.add(panelCartao);
		panelCartao.setLayout(null);

		// Tabela clientes nas contas
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(768, 47, 262, 334);
		jpanelContas.add(scrollPane_1);
		tableClts = new JTable(model);
		scrollPane_1.setViewportView(tableClts);

		JTextField tbContaspesqconta = new JTextField();
		tbContaspesqconta.setBounds(26, 63, 238, 31);
		jpanelContas.add(tbContaspesqconta);

		// botao eliminar

		jpanelContas.setBounds(0, 0, 1042, 576);
		JpanelPrincipal.add(jpanelContas);
		jpanelContas.setLayout(null);

		JComboBox<String> cbContaspesqconta = new JComboBox<String>();
		cbContaspesqconta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((cbContaspesqconta.getSelectedItem().equals("Conta poupanca"))
						|| (cbContaspesqconta.getSelectedItem().equals("Conta corrente"))) {
					tbContaspesqconta.setText("");
					tbContaspesqconta.setEditable(false);

				} else if ((cbContaspesqconta.getSelectedItem().equals("Numero de conta"))) {
					tbContaspesqconta.setText("");
					tbContaspesqconta.setEditable(true);
				}
			}
		});
		cbContaspesqconta.setBounds(26, 17, 238, 38);
		jpanelContas.add(cbContaspesqconta);
		cbContaspesqconta.addItem("Numero de conta");
		cbContaspesqconta.addItem("Contas corrente");
		cbContaspesqconta.addItem("Contas poupanca");

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
		btContasConfirmar.setBounds(356, 471, 120, 38);
		jpanelContas.add(btContasConfirmar);

		JButton btContasNovo = new JButton("Novo");

		btContasNovo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btContasNovo.setBounds(488, 471, 120, 38);
		jpanelContas.add(btContasNovo);

		JButton btContasEliminar = new JButton("Eliminar");

		btContasEliminar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btContasEliminar.setBounds(620, 471, 120, 38);
		jpanelContas.add(btContasEliminar);

		JLabel lblClientes_1 = new JLabel("Clientes");
		lblClientes_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblClientes_1.setBounds(768, 17, 164, 24);
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

		JLabel lblLimiteDeLevantamento_1 = new JLabel("Por dia:");
		lblLimiteDeLevantamento_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblLimiteDeLevantamento_1.setBounds(356, 294, 67, 24);
		jpanelContas.add(lblLimiteDeLevantamento_1);

		tbContaslimitelevdia = new JTextField();
		tbContaslimitelevdia.setBounds(448, 293, 279, 31);
		jpanelContas.add(tbContaslimitelevdia);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dmconta.removeAllElements();
				if (cbContaspesqconta.getSelectedItem().equals("Numero de conta")) {
					String numConta = tbContaspesqconta.getText();
					String[] contasNumConta = gb.javabank.listaContasNumContaAbertas(numConta);
					gb.javabank.addelementoslist(contasNumConta, dmconta);

				} else if (cbContaspesqconta.getSelectedItem().equals("Contas corrente")) {

					String[] contasCorrent = gb.javabank.listaContasCorrente();
					gb.javabank.addelementoslist(contasCorrent, dmconta);

				} else if (cbContaspesqconta.getSelectedItem().equals("Contas poupanca")) {
					String[] contasPoup = gb.javabank.listaContasPoupanca();
					gb.javabank.addelementoslist(contasPoup, dmconta);

				}
			}
		});
		btnPesquisar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnPesquisar.setBounds(280, 35, 99, 38);
		jpanelContas.add(btnPesquisar);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblTipo.setBounds(356, 79, 44, 24);
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
		bgconta.add(rdbtnContaPoupanca);
		bgconta.add(rdbtnContaCorrente);

		JButton btPedirCartao = new JButton("Pedir Cartao");
		btPedirCartao.setVisible(false);
		btPedirCartao.setFont(new Font("Dialog", Font.PLAIN, 15));
		btPedirCartao.setBounds(548, 521, 120, 38);
		jpanelContas.add(btPedirCartao);

		JLabel VALIDADE = new JLabel("Validade");
		VALIDADE.setFont(new Font("Tahoma", Font.PLAIN, 15));
		VALIDADE.setBounds(12, 67, 72, 16);
		panelCartao.add(VALIDADE);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(12, 40, 72, 16);
		panelCartao.add(lblNome);

		tbnomecartao = new JTextField();
		tbnomecartao.setBounds(72, 38, 190, 22);
		panelCartao.add(tbnomecartao);
		tbnomecartao.setColumns(10);

		JLabel lblCod = new JLabel("COD:");
		lblCod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCod.setBounds(12, 98, 59, 16);
		panelCartao.add(lblCod);

		tbcodcartao = new JTextField();
		tbcodcartao.setEditable(false);
		tbcodcartao.setColumns(10);
		tbcodcartao.setBounds(72, 96, 190, 22);
		panelCartao.add(tbcodcartao);

		JButton btCartao = new JButton("Criar cartao");
		btCartao.setBounds(108, 131, 112, 25);
		panelCartao.add(btCartao);

		tbncartao = new JTextField();
		tbncartao.setEditable(false);
		tbncartao.setColumns(10);
		tbncartao.setBounds(72, 13, 190, 22);
		panelCartao.add(tbncartao);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumero.setBounds(12, 15, 59, 16);
		panelCartao.add(lblNumero);

		JButton btnMovimentos = new JButton("Movimentos");
		btnMovimentos.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnMovimentos.setBounds(416, 521, 120, 38);
		btnMovimentos.setVisible(false);

		jpanelContas.add(btnMovimentos);

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
				Conta c;
				ArrayList<Integer> clientes = new ArrayList<Integer>();
				if (lContas.isSelectionEmpty()) {
					// CRIA NOVA CONTA
					if (rdbtnContaCorrente.isSelected()) {
						// conta Corrente:
						// cartao nulo inicialmente;
						c = new ContaCorrente(Integer.parseInt(tbContasnum.getText()), dateChooser_2.getDate(), null,
								Double.parseDouble(tbContasSaldo.getText()), clientes,
								Double.parseDouble(tbContaslimitelevop.getText()),
								Double.parseDouble(tbContaslimitelevdia.getText()), 0, true);
						gb.javabank.getContas().add(c);
						gb.javabank.atruibuititularCCorrente(model, c, gb.javabank.getUtlizadores());
						JOptionPane.showMessageDialog(null, "Conta adicionada com sucesso!");
					} else {
						// conta Poupanca:
						c = new ContaPoupanca(Integer.parseInt(tbContasnum.getText()), dateChooser_2.getDate(), null,
								Double.parseDouble(tbContasSaldo.getText()), clientes,
								Double.parseDouble(tbContaslimitelevop.getText()),
								Double.parseDouble(tbContaslimitelevdia.getText()),
								Double.parseDouble(tblJuros.getText()), Double.parseDouble(tbllimitemes.getText()),
								true);
						gb.javabank.getContas().add(c);
						gb.javabank.atruibuititularCPoupanca(model, c, gb.javabank.getUtlizadores());
						JOptionPane.showMessageDialog(null, "Conta adicionada com sucesso!");
					}
				} else {
					// Atualizar:
					c = gb.javabank.SelectConta(Integer.parseInt(lContas.getSelectedValue()), gb.javabank.getContas());
					if (c instanceof ContaCorrente) {
						gb.javabank.atualizarconta(c, Double.parseDouble(tbContaslimitelevop.getText()),
								Double.parseDouble(tbContaslimitelevdia.getText()), 0, 0);
					} else {
						gb.javabank.atualizarconta(c, Double.parseDouble(tbContaslimitelevop.getText()),
								Double.parseDouble(tbContaslimitelevdia.getText()),
								Double.parseDouble(tblJuros.getText()), Double.parseDouble(tbllimitemes.getText()));
					}
					gb.javabank.eliminacontaemcliente(gb.javabank.getUtlizadores(), gb.javabank
							.SelectConta(Integer.parseInt(lContas.getSelectedValue()), gb.javabank.getContas()));
					gb.javabank.atruibuititularCPoupanca(model, c, gb.javabank.getUtlizadores());
					JOptionPane.showMessageDialog(null, "Conta Atualizada com sucesso!");

				}
				dmconta.removeAllElements();
				gb.javabank.addelementoslist(gb.javabank.listanumerodecontasabertas(gb.javabank.getContas()), dmconta);
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
				panelCartao.setVisible(false);
				btPedirCartao.setVisible(false);
				btnMovimentos.setVisible(false);
				tbContaspesqconta.setText("");
				tbContasnum.setEnabled(false);
				;
				dateChooser_2.setEnabled(false);
				tbContaslimitelevop.setEnabled(false);
				;
				tbContasSaldo.setEnabled(false);
				;
				tbContasSaldo.setEnabled(false);
				;
				tbContaslimitelevdia.setEnabled(false);
				;
				rdbtnContaCorrente.setEnabled(false);
				;
				rdbtnContaPoupanca.setEnabled(false);
				;
				tblJuros.setEnabled(false);
				;
				tbllimitemes.setEnabled(false);
				;

			}

		});

		// prepara campos para cria�ao de nova conta ou atualiza a lista selecionada:
		btContasNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// coloca os campos editaveis
				tbContasnum.setEnabled(true);

				dateChooser_2.setEnabled(true);
				tbContaslimitelevop.setEnabled(true);
				;
				tbContasSaldo.setEnabled(true);
				;
				tbContasSaldo.setEnabled(true);
				;
				tbContaslimitelevdia.setEnabled(true);
				;
				rdbtnContaCorrente.setEnabled(true);
				;
				rdbtnContaPoupanca.setEnabled(true);
				;
				tblJuros.setEnabled(true);
				;
				tbllimitemes.setEnabled(true);
				;

				gb.javabank.limpatabela(model);
				gb.javabank.preenchetabelaclientes(model, gb.javabank.getUtlizadores());

				int numconta = val.idConta(gb.javabank.getContas());
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
				panelCartao.setVisible(false);
				btPedirCartao.setVisible(false);

			}
		});
		// selecionar conta e preencher so campos correctos:
		lContas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				gb.javabank.limpatabela(model);
				gb.javabank.preenchetabelaclientes(model, gb.javabank.getUtlizadores());

				if (!lContas.isSelectionEmpty()) {

					Conta c = gb.javabank.SelectConta(Integer.parseInt(lContas.getSelectedValue()),
							gb.javabank.getContas());

					tbContasnum.setText("" + c.getIdConta());
					dateChooser_2.setDate(c.getDataCriacao());
					dateChooser_2.setEnabled(false);
					tbContaslimitelevop.setText("" + c.getValorMaxLevantamento());
					tbContasSaldo.setText("" + c.getSaldo());
					tbContasSaldo.setEditable(false);
					tbContaslimitelevdia.setText(c.getValorMaxDia() + "");
					btnMovimentos.setVisible(true);

					if (c instanceof ContaPoupanca) {
						rdbtnContaPoupanca.setSelected(true);
						rdbtnContaCorrente.setSelected(false);
						Double juros = ((ContaPoupanca) c).getTaxaJuros();
						tblJuros.setText(juros + "");
						Double limite = ((ContaPoupanca) c).getLimiteMensalDebito();
						tbllimitemes.setText("" + limite);
						panelCartao.setVisible(false);
						btPedirCartao.setVisible(false);

					} else {
						rdbtnContaPoupanca.setSelected(false);
						rdbtnContaCorrente.setSelected(true);

						if (((ContaCorrente) c).getCartao() == 0) {
							btPedirCartao.setVisible(true);
							btCartao.setVisible(false);
							panelCartao.setVisible(false);
							dtcartao.setVisible(false);
							;
							tbnomecartao.setVisible(false);
							;
							tbcodcartao.setVisible(false);
							;
							tbncartao.setVisible(false);
							;

						}

						if (((ContaCorrente) c).getCartao() != 0) {

							Cartao card = gb.javabank.obterCartao(gb.javabank.getCartoes(),
									((ContaCorrente) c).getCartao());

							dtcartao.setDate(card.getDataValidade());
							tbnomecartao.setText(card.getNomeTitular());
							tbcodcartao.setText(card.getCodvalidacao() + "");
							tbncartao.setText(card.getnCartao() + "");

							btPedirCartao.setVisible(false);
							btCartao.setVisible(false);
							panelCartao.setVisible(true);
							dtcartao.setEnabled(false);
							tbnomecartao.setEditable(false);
							tbnomecartao.setEnabled(false);
							tbcodcartao.setEditable(false);
							tbcodcartao.setEnabled(false);

							// ver situacao se o cartao expirou ou nao

							if (card.getDataValidade().before(Date.valueOf(LocalDate.now()))) {

								// o cartao expirou aqui
								Cartao card2 = gb.javabank.obterCartao(gb.javabank.getCartoes(), card.getnCartao());
								card2.setAtivo(false);
								card2.setIdconta(0);
								((ContaCorrente) c).setCartao(0);

								btPedirCartao.setVisible(true);
								panelCartao.setVisible(true);
								tbnomecartao.setEditable(true);

								JOptionPane.showMessageDialog(null, "Cartão revalidado!! Novo cartão criado!!");

							}

						}

					}
					gb.javabank.limpatabela(model);
					gb.javabank.preenchetabelaclientes(model, gb.javabank.getUtlizadores());
					/// seleciona os clientes que estao como titulares � conta:
					gb.javabank.mostratitulares(c, model);

				}
			}
		});

		btPedirCartao.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Conta c = gb.javabank.SelectConta(Integer.parseInt(lContas.getSelectedValue()),
						gb.javabank.getContas());

				if (((ContaCorrente) c).getCartao() == 0) {

					//
					panelCartao.setVisible(true);
					dtcartao.setVisible(true);
					tbnomecartao.setVisible(true);
					tbncartao.setVisible(true);
					tbcodcartao.setVisible(true);
					btCartao.setVisible(true);

					//
					dtcartao.setEnabled(true);
					tbnomecartao.setEditable(true);
					tbnomecartao.setEnabled(true);

					//
					tbnomecartao.setText(null);
					dtcartao.setDate(null);
					tbcodcartao.setText(null);
					tbncartao.setText(null);

				} else if (((ContaCorrente) c).getCartao() != 0) {
					panelCartao.setVisible(true);
					tbnomecartao.setEditable(false);
					dtcartao.setEnabled(false);
					btCartao.setVisible(false);
				}

			}
		});

		btCartao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = val.valIdCartao(gb.javabank.getCartoes());
				int codval = val.valCodCartao();
				Conta c = gb.javabank.SelectConta(Integer.parseInt(lContas.getSelectedValue()),
						gb.javabank.getContas());

				if (val.valTitularCartao(tbnomecartao.getText())) {

					Calendar cal = new GregorianCalendar();
					Date.valueOf(LocalDate.now());
					cal.add(Calendar.YEAR, 5);

					Cartao cartao = new Cartao(id, tbnomecartao.getText(), cal.getTime(), codval, c.getIdConta(), true);
					gb.javabank.getCartoes().add(cartao);
					((ContaCorrente) c).setCartao(cartao.getnCartao());
					tbcodcartao.setText(codval + "");
					tbncartao.setText(id + "");
					dtcartao.setDate(cal.getTime());
					;

					dtcartao.setEnabled(false);
					tbnomecartao.setEditable(false);
					tbcodcartao.setEditable(false);
					tbncartao.setEditable(false);
					JOptionPane.showMessageDialog(null, "Cartao criado com sucesso");
					btCartao.setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(null, "Nome de cartao invalido. corriga o nome do titular");
				}

			}
		});

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gb.javabank.limpatabela(model);
				gb.javabank.preenchetabelaclientes(model, gb.javabank.getUtlizadores());

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
				panelCartao.setVisible(false);
				btPedirCartao.setVisible(false);
				btnMovimentos.setVisible(false);
				tbContaspesqconta.setText("");
				dmconta.removeAllElements();
				gb.javabank.addelementoslist(gb.javabank.listanumerodecontasabertas(gb.javabank.getContas()), dmconta);

			}

		});

		btnLimpar.setBounds(85, 507, 99, 38);
		jpanelContas.add(btnLimpar);

		btnMovimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpanelContas.setVisible(false);
				jpanelMovimentos.setVisible(true);

				if (!lContas.isSelectionEmpty()) {
					String idConta = lContas.getSelectedValue();
					Conta c = gb.javabank.SelectConta(Integer.parseInt(idConta), gb.javabank.getContas());

					gb.javabank.limpatabela(modeloTabela);
					gb.javabank.preenchetabelaOperacoesTodas(modeloTabela, c);
					// gb.javabank.preenchetabelaOperacoesTransferencia(modeloTabela, c);
					// gb.javabank.preenchetabelaOperacoesDeposito(modeloTabela, c);
					// gb.javabank.preenchetabelaOperacoesLevantamento(modeloTabela, c);
				}
			}
		});

		// elimina contas:
		btContasEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!lContas.isSelectionEmpty()) {

					jpanelEliminarContaDataFecho.setVisible(true);
					jpanelContas.setVisible(false);
				}

				jpanelEliminarContaDataFecho.setVisible(true);
				jpanelContas.setVisible(false);
				jpanelClientes.setVisible(false);
				jpanelMovimentos.setVisible(false);
				jpanelGestao.setVisible(false);
				jpanelOperacoes.setVisible(false);

			}
		});

		// Painel principal da operaçoes

		jpanelOperacoes.setBounds(0, 0, 1042, 576);
		JpanelPrincipal.add(jpanelOperacoes);
		jpanelOperacoes.setVisible(false);
		jpanelOperacoes.setLayout(null);

		// combobox com a lista das contas abertas
		JComboBox<String> cbOperacoesConta = new JComboBox<String>(dcbm);
		cbOperacoesConta.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String s = (String) cbOperacoesConta.getSelectedItem();
				if (s != null) {
					Conta c = gb.javabank.SelectConta(Integer.parseInt(s), gb.javabank.getContas());
					tbContasaldoc.setText("" + c.getSaldo());
				}

			}
		});

		JPanel JpanelOpDeposito = new JPanel();
		JpanelOpDeposito.setVisible(false);
		JPanel JpanelOpLevantamento = new JPanel();
		JpanelOpLevantamento.setVisible(false);

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
		btLevConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Conta c = gb.javabank.SelectConta(Integer.parseInt((String) cbOperacoesConta.getSelectedItem()),
						gb.javabank.getContas());

				if (dateChooser4.getDate().after(c.getDataCriacao())) {

					if (val.valValorOperacao(tbLevMontante.getText())) {

						double levantamento = Double.parseDouble(tbLevMontante.getText());

						java.util.Date data = dateChooser4.getDate();

						gb.javabank.maxlevantamentoOperacaoDiaMes(c, levantamento, func, data);
						tbContasaldoc.setText(Double.toString(c.getSaldo()));

						tbLevMontante.setText(null);

					} else {
						JOptionPane.showMessageDialog(null, "Valor inserido esta incorrecto");
					}

				} else {
					JOptionPane.showMessageDialog(null, "A data inserida é anterior a data da criacao da conta!!!");

				}

			}

		});
		btLevConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btLevConfirmar.setBounds(201, 219, 120, 38);
		JpanelOpLevantamento.add(btLevConfirmar);

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

		// efectuar deposito:
		btDepConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Seleciona conta:
				String s = (String) cbOperacoesConta.getSelectedItem();
				Conta c = gb.javabank.SelectConta(Integer.parseInt(s), gb.javabank.getContas());

				if (dtchdeposito.getDate().after(c.getDataCriacao())) {

					if (val.valValorOperacao(tbDepMontante.getText())) {

						// faz deposito:
						double saldo = (c.getSaldo()) + Double.parseDouble(tbDepMontante.getText());
						c.setSaldo(saldo);
						// cria opera�ao:
						int idop = 1;
						if (c.getOperacoes().size() != 0) {
							idop = c.getOperacoes().get(c.getOperacoes().size() - 1).getIdOperacao() + 1;
						}
						String descricao = dtchdeposito.getDate() + " - Deposito: valor " + tbDepMontante.getText();

						Operacao op = new Deposito(idop, func, dtchdeposito.getDate(),
								Double.parseDouble(tbDepMontante.getText()), descricao);
						c.getOperacoes().add(op);
						tbContasaldoc.setText(c.getSaldo() + "");
						JOptionPane.showMessageDialog(null, "Deposito efectuado!");
						tbDepMontante.setText("");

					} else {
						JOptionPane.showMessageDialog(null, "Valor inserido esta incorrecto");
					}

				} else {
					JOptionPane.showMessageDialog(null, "A data inserida é anterior a data da criacao da conta!!!");

				}

			}
		});
		cbOperacoesConta.setBounds(578, 72, 249, 39);
		jpanelOperacoes.add(cbOperacoesConta);

		JTextField tbOperacoespesqClt = new JTextField();
		tbOperacoespesqClt.setBounds(188, 92, 250, 31);
		jpanelOperacoes.add(tbOperacoespesqClt);

		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (val.valContaTransferir(tbOperacoespesqClt.getText())) {
					int id = Integer.parseInt(tbOperacoespesqClt.getText());
					boolean existe = gb.javabank.existeconta(dcbm, id);

					if (existe) {
						cbOperacoesConta.setSelectedItem(id + "");
					} else {
						JOptionPane.showMessageDialog(null, "Conta nao encontrada!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Formato errado!");
				}

			}

		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.setBounds(258, 131, 116, 38);
		jpanelOperacoes.add(btnNewButton);

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

		JLabel lblDataDaOperao = new JLabel("Data da Operação:");
		lblDataDaOperao.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblDataDaOperao.setBounds(158, 168, 189, 23);
		JpanelOpTransferencia.add(lblDataDaOperao);

		JButton btnConfirmar = new JButton("Confirmar");

		btnConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnConfirmar.setBounds(118, 253, 116, 38);
		JpanelOpTransferencia.add(btnConfirmar);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(168, 198, 162, 31);
		JpanelOpTransferencia.add(dateChooser_1);

		JLabel lblNewLabel_4 = new JLabel("Numero de Conta:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(188, 63, 149, 16);
		jpanelOperacoes.add(lblNewLabel_4);

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

		// efectuar transferencia
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valortransf = Double.parseDouble(tbTransMontante.getText());
				String s = (String) cbOperacoesConta.getSelectedItem();
				Conta corigem = gb.javabank.SelectConta(Integer.parseInt(s), gb.javabank.getContas());
				Conta cdestino;
				try {
					if (dateChooser_1.getDate().after(corigem.getDataCriacao())) {

						cdestino = gb.javabank.SelectConta(Integer.parseInt(tbTransContaDestino.getText()),
								gb.javabank.getContas());

						if (corigem.getSaldo() >= valortransf && !corigem.equals(cdestino)) {
							// gerado ids:
							int idoporigem = 1;
							if (corigem.getOperacoes().size() != 0) {
								idoporigem = corigem.getOperacoes().get(corigem.getOperacoes().size() - 1)
										.getIdOperacao() + 1;
							}
							int iddestino = 1;
							if (cdestino.getOperacoes().size() != 0) {
								iddestino = cdestino.getOperacoes().get(cdestino.getOperacoes().size() - 1)
										.getIdOperacao() + 1;
							}

							cdestino.setSaldo(cdestino.getSaldo() + valortransf);
							corigem.setSaldo(corigem.getSaldo() - valortransf);

							// faz transferencia;
							String descorigem = dateChooser_1.getDate() + " - Transferencia efectuada para conta "
									+ cdestino.getIdConta() + " valor: " + valortransf;
							String descdestino = dateChooser_1.getDate() + " - Transferencia recebida da conta "
									+ corigem.getIdConta() + " valor: " + valortransf;
							Operacao oporigem = new Transferencia(idoporigem, func, dateChooser_1.getDate(),
									valortransf, descorigem, cdestino, null);
							Operacao opdestino = new Transferencia(iddestino, func, dateChooser_1.getDate(),
									valortransf, descdestino, corigem, null);

							corigem.getOperacoes().add(oporigem);
							cdestino.getOperacoes().add(opdestino);

							JOptionPane.showMessageDialog(null, "Transferencia realizada com sucesso");
							tbTransMontante.setText("");
							tbTransContaDestino.setText(null);
							tbContasaldoc.setText(corigem.getSaldo() + "");

						} else {
							if (corigem.getSaldo() < valortransf) {
								JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
							}
							if (corigem.equals(cdestino)) {
								JOptionPane.showMessageDialog(null, "Numero de conta de destino invalido");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "A data inserida é anterior a data da criacao da conta!!!");

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Numero de conta de destino invalido");
				}

			}
		});

		// painel movimentos onde aparece a tabela das operaçoes

		jpanelMovimentos.setBounds(0, 0, 1065, 585);
		JpanelPrincipal.add(jpanelMovimentos);
		jpanelMovimentos.setLayout(null);

		// Tabela dos movimentos das operações
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 97, 936, 247);
		jpanelMovimentos.add(scrollPane);
		tableMovimentos = new JTable(modeloTabela);
		tableMovimentos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int linha = tableMovimentos.getSelectedRow();
				int id = (int) tableMovimentos.getModel().getValueAt(linha, 0);
				String desc = gb.javabank.descricaoOpercacoes(id);
				tbdescop.setText(desc);
			}
		});
		scrollPane.setViewportView(tableMovimentos);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jpanelMovimentos.setVisible(false);
				jpanelContas.setVisible(true);
				modeloTabela.setRowCount(0);
				tbdescop.setText("");

			}
		});
		btnVoltar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnVoltar.setBounds(469, 478, 120, 38);
		jpanelMovimentos.add(btnVoltar);

		btnVoltar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnVoltar.setBounds(469, 478, 120, 38);
		jpanelMovimentos.add(btnVoltar);

		tbdescop = new JTextField();
		tbdescop.setBounds(55, 378, 936, 30);
		jpanelMovimentos.add(tbdescop);
		tbdescop.setColumns(10);

		String[] pesquisaTipoOperacao = { "Todos", "Transferencias", "Depositos", "Levantamentos", "Pagamentos" };
		JComboBox cbTipoOperacao = new JComboBox(pesquisaTipoOperacao);
		cbTipoOperacao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				modeloTabela.setRowCount(0);

				Conta c = gb.javabank.SelectConta(Integer.parseInt((String) lContas.getSelectedValue()),
						gb.javabank.getContas());
				if (cbTipoOperacao.getSelectedItem().equals("Todos")) {
					gb.javabank.preenchetabelaOperacoesTodas(modeloTabela, c);

				} else if (cbTipoOperacao.getSelectedItem().equals("Depositos")) {
					gb.javabank.preenchetabelaOperacoesDeposito(modeloTabela, c);

				} else if (cbTipoOperacao.getSelectedItem().equals("Transferencias")) {
					gb.javabank.preenchetabelaOperacoesTransferencia(modeloTabela, c);

				} else if (cbTipoOperacao.getSelectedItem().equals("Levantamentos")) {
					gb.javabank.preenchetabelaOperacoesLevantamento(modeloTabela, c);

				} else if (cbTipoOperacao.getSelectedItem().equals("Pagamentos")) {
					gb.javabank.preenchetabelaOperacoesPagamento(modeloTabela, c);

				} else {
					gb.javabank.preenchetabelaOperacoesTodas(modeloTabela, c);
				}
			}
		});
		cbTipoOperacao.setBounds(706, 35, 255, 22);
		jpanelMovimentos.add(cbTipoOperacao);
		jpanelMovimentos.setVisible(false);

		// Painel principal CLientes

		jpanelClientes.setBounds(0, 0, 1042, 576);
		JpanelPrincipal.add(jpanelClientes);
		jpanelClientes.setVisible(true);
		jpanelClientes.setLayout(null);
		jpanelClientes.setLayout(null);

		// Pedir cartao

		JComboBox cbCltPesq = new JComboBox(itens);
		cbCltPesq.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		cbCltPesq.setBounds(47, 12, 227, 34);
		jpanelClientes.add(cbCltPesq);

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
		bg.add(rbCltcc);
		bg.add(rbCltbi);
		bg.add(rbCltPassaporte);

		JTextField tbCltPesq = new JTextField();
		tbCltPesq.setBounds(47, 49, 227, 30);
		jpanelClientes.add(tbCltPesq);

		JDateChooser dateChooser_3 = new JDateChooser();
		dateChooser_3.setBounds(457, 147, 260, 31);
		jpanelClientes.add(dateChooser_3);

		JButton btCltPesquisa = new JButton("Pesquisa");

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

		// lista das contas dos clientes
		JList<String> lbCltConta = new JList<String>(dlmcontacliente);
		lbCltConta.setBounds(780, 92, 240, 441);
		gb.javabank.addelementoslist(gb.javabank.listaContasCorrente(), dlmcontacliente);
		gb.javabank.addelementoslist(gb.javabank.listaContasPoupanca(), dlmcontacliente);
		jpanelClientes.add(lbCltConta);

		// botao novo para criar novo cliente
		JButton btCltNovo = new JButton("Novo");
		btCltNovo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btCltNovo.setBounds(467, 22, 120, 38);
		// a�ao do botao novo:
		btCltNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// limpa tudo:

				tableListaClts.clearSelection();
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
		jpanelClientes.add(btCltNovo);

		// botao eliminar cliente
		JButton btCltEliminar = new JButton("Eliminar");
		btCltEliminar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btCltEliminar.setBounds(609, 22, 120, 38);

		jpanelClientes.add(btCltEliminar);

		JButton btCltconfirmar = new JButton("Confirmar");

		btCltconfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btCltconfirmar.setBounds(506, 505, 120, 38);
		jpanelClientes.add(btCltconfirmar);

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

		// botao pesquisar cliente
		btCltPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modeloTabelaCliente.setRowCount(0);

				if (cbCltPesq.getSelectedItem().equals("Nome")) {
					String nome = tbCltPesq.getText();
					gb.javabank.preenchetabelaclientesNome(modeloTabelaCliente, nome);

				} else if (cbCltPesq.getSelectedItem().equals("ID")) {
					String id = tbCltPesq.getText();
					gb.javabank.preenchetabelaclientesID(modeloTabelaCliente, Integer.parseInt(id));

				}

			}
		});

		// Tabela clientes no painel cliente
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(48, 92, 240, 363);
		jpanelClientes.add(scrollPane_2);
		tableListaClts = new JTable(modeloTabelaCliente);
		tableListaClts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dlmcontacliente.removeAllElements();
				// quando o rato seleciona uma linha da tabela:
				bg.clearSelection();

				int linha = tableListaClts.getSelectedRow();
				int idCliente = (int) tableListaClts.getModel().getValueAt(linha, 0);
				Cliente c = (Cliente) gb.javabank.selectUtilizador(idCliente, gb.javabank.getUtlizadores());
				// preenche as textfields
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

				// mostra na lista as contas deste cliente
				dlmcontacliente.removeAllElements();
				gb.javabank.addelementoslist(gb.javabank.listacontadecliente(c, gb.javabank.getContas()),
						dlmcontacliente);

			}
		});
		scrollPane_2.setViewportView(tableListaClts);

		JButton btnLimparClt = new JButton("Limpar pesquisa");
		btnLimparClt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tbCltNome.setText("");
				tbCltApelido.setText("");
				tbCltMorada.setText(null);
				tbCltContacto.setText(null);
				bg.clearSelection();
				tbCltUser.setText("");
				tbCltPass.setText("");
				tbCltNum.setText("");
				dateChooser_3.setDate(null);
				tbCltPesq.setText("");

				modeloTabelaCliente.setRowCount(0);
				dlmcontacliente.removeAllElements();
				gb.javabank.preenchetabelaclientes2(modeloTabelaCliente, gb.javabank.getUtlizadores());
				gb.javabank.addelementoslist(gb.javabank.listaContasCorrente(), dlmcontacliente);
				gb.javabank.addelementoslist(gb.javabank.listaContasPoupanca(), dlmcontacliente);
			}
		});
		btnLimparClt.setBounds(97, 466, 133, 23);
		jpanelClientes.add(btnLimparClt);

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
				if (tableListaClts.getSelectedRow() == -1) {
					// adicionar Cliente:
					// criar automaticamente o id;
					int id = val.ValUtilizadorid(gb.javabank.getUtlizadores());

					// esta a ser criado o novo cliente:
					Utilizador clt = new Cliente(id, tbCltNome.getText(), tbCltApelido.getText(),
							dateChooser_3.getDate(), opselect, Integer.parseInt(tbCltNum.getText()),
							tbCltMorada.getText(), Integer.parseInt(tbCltContacto.getText()), tbCltUser.getText(),
							tbCltPass.getText(), 0);
					gb.javabank.getUtlizadores().add(clt);
					// faz atualiza�ao da lista (elimina e de seguida preenche tudo)
					modeloTabelaCliente.setRowCount(0);
					gb.javabank.preenchetabelaclientes2(modeloTabelaCliente, gb.javabank.getUtlizadores());
					JOptionPane.showMessageDialog(null, "Cliente criado com sucesso!");

				} else {
					// atualizar Cliente:
					// seleciona id;
					int linha = tableListaClts.getSelectedRow();
					int idCliente = (int) tableListaClts.getModel().getValueAt(linha, 0);
					Cliente clt = (Cliente) gb.javabank.selectUtilizador(idCliente, gb.javabank.getUtlizadores());

					// metedo para atualizar:
					gb.javabank.atualizacliente(clt, tbCltNome.getText(), tbCltApelido.getText(),
							dateChooser_3.getDate(), opselect, Integer.parseInt(tbCltNum.getText()),
							tbCltMorada.getText(), Integer.parseInt(tbCltContacto.getText()), tbCltUser.getText(),
							tbCltPass.getText());
					JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");

				}

				// limpa campos e atualiza lista de cliente
				tableListaClts.clearSelection();
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

				// atualiza lista contas e tabela cliente;
				dlmcontacliente.removeAllElements();
				modeloTabelaCliente.setRowCount(0);
				gb.javabank.preenchetabelaclientes2(modeloTabelaCliente, gb.javabank.getUtlizadores());

			}
		});

		btCltEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// primeiro ve qual o id selecionado!
				int linha = tableListaClts.getSelectedRow();
				int idCliente = (int) tableListaClts.getModel().getValueAt(linha, 0);

				// elimina o cliente:
				gb.javabank.eliminautilizador(idCliente, gb.javabank.getUtlizadores(), gb.javabank.getContas());

				// depois limpa os campos do formulario:
				tableListaClts.clearSelection();
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
				modeloTabelaCliente.setRowCount(0);
				gb.javabank.preenchetabelaclientes2(modeloTabelaCliente, gb.javabank.getUtlizadores());
				dlmcontacliente.removeAllElements();

			}
		});

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setAlignmentX(0.0f);
		separator_2.setBounds(390, 83, 13, 433);
		jpanelGestao.add(separator_2);

		JLabel label_1 = new JLabel("Nome:");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_1.setBounds(47, 55, 57, 30);
		jpanelGestao.add(label_1);

		tbfunnome = new JTextField();
		tbfunnome.setEditable(false);
		tbfunnome.setColumns(10);
		tbfunnome.setBounds(57, 86, 217, 31);
		jpanelGestao.add(tbfunnome);

		JLabel label_2 = new JLabel("Sobrenome:");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_2.setBounds(47, 126, 120, 30);
		jpanelGestao.add(label_2);

		tbfunapelido = new JTextField();
		tbfunapelido.setEditable(false);
		tbfunapelido.setColumns(10);
		tbfunapelido.setBounds(57, 157, 217, 31);
		jpanelGestao.add(tbfunapelido);

		JLabel label_3 = new JLabel("Data de Nascimento:");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_3.setBounds(47, 190, 177, 30);
		jpanelGestao.add(label_3);

		JDateChooser dtfunnasc = new JDateChooser();
		dtfunnasc.setEnabled(false);
		dtfunnasc.setBounds(57, 221, 217, 31);
		jpanelGestao.add(dtfunnasc);

		JRadioButton rbfuncc = new JRadioButton("C.C.");
		rbfuncc.setFont(new Font("Dialog", Font.PLAIN, 15));
		rbfuncc.setEnabled(false);
		rbfuncc.setBounds(57, 261, 66, 25);
		jpanelGestao.add(rbfuncc);

		JRadioButton rbfunbi = new JRadioButton("B.I.");
		rbfunbi.setFont(new Font("Dialog", Font.PLAIN, 15));
		rbfunbi.setEnabled(false);
		rbfunbi.setBounds(136, 261, 57, 25);
		jpanelGestao.add(rbfunbi);

		JRadioButton rbfuncpass = new JRadioButton("Passaporte");
		rbfuncpass.setFont(new Font("Dialog", Font.PLAIN, 15));
		rbfuncpass.setEnabled(false);
		rbfuncpass.setBounds(205, 261, 138, 25);
		jpanelGestao.add(rbfuncpass);

		JLabel label_4 = new JLabel("N\u00C3\u00BAmero de Identifica\u00C3\u00A7\u00C3\u00A3o:");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_4.setBounds(39, 287, 227, 30);
		jpanelGestao.add(label_4);

		tbfunident = new JTextField();
		tbfunident.setEditable(false);
		tbfunident.setColumns(10);
		tbfunident.setBounds(49, 323, 225, 31);
		jpanelGestao.add(tbfunident);

		JLabel label_6 = new JLabel("Contacto:");
		label_6.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_6.setBounds(39, 356, 81, 31);
		jpanelGestao.add(label_6);

		tbfuncontacto = new JTextField();
		tbfuncontacto.setEditable(false);
		tbfuncontacto.setColumns(10);
		tbfuncontacto.setBounds(49, 387, 225, 31);
		jpanelGestao.add(tbfuncontacto);

		JLabel label_7 = new JLabel("Morada: ");
		label_7.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_7.setBounds(39, 419, 227, 30);
		jpanelGestao.add(label_7);

		tbfunmorada = new JTextField();
		tbfunmorada.setEditable(false);
		tbfunmorada.setColumns(10);
		tbfunmorada.setBounds(49, 452, 225, 31);
		jpanelGestao.add(tbfunmorada);

		tbfunidfunc = new JTextField();
		tbfunidfunc.setEditable(false);
		tbfunidfunc.setColumns(10);
		tbfunidfunc.setBounds(47, 529, 225, 31);
		jpanelGestao.add(tbfunidfunc);

		JLabel lblIdFuncionario = new JLabel("ID Funcionario:");
		lblIdFuncionario.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblIdFuncionario.setBounds(47, 496, 227, 30);
		jpanelGestao.add(lblIdFuncionario);

		jpanelGestao.setBounds(0, 0, 1042, 576);
		JpanelPrincipal.add(jpanelGestao);
		jpanelGestao.setLayout(null);

		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsername_1.setBounds(415, 81, 131, 41);
		jpanelGestao.add(lblUsername_1);

		tbGestaoUsername = new JTextField();
		tbGestaoUsername.setEditable(false);
		tbGestaoUsername.setBounds(415, 134, 271, 33);
		jpanelGestao.add(tbGestaoUsername);

		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword_1.setBounds(415, 178, 131, 41);
		jpanelGestao.add(lblPassword_1);

		tbGestaopassuser = new JPasswordField();
		tbGestaopassuser.setBounds(415, 230, 271, 33);
		jpanelGestao.add(tbGestaopassuser);

		JLabel lblNovaPassword = new JLabel("Novo UserName:");
		lblNovaPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNovaPassword.setBounds(415, 275, 191, 41);
		jpanelGestao.add(lblNovaPassword);

		tbGestaoNovoUser = new JTextField();
		tbGestaoNovoUser.setBounds(415, 327, 271, 33);
		jpanelGestao.add(tbGestaoNovoUser);

		JButton btGestaouserconfirmar = new JButton("Confirmar");
		btGestaouserconfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btGestaouserconfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (val.valUsername(tbGestaoNovoUser.getText(), gb.javabank.getUtlizadores())) {
					if (func.getPassword().equals(new String(tbGestaopassuser.getPassword()))) {
						func.setUsername(tbGestaoNovoUser.getText());
						tbGestaoUsername.setText(null);
						tbGestaopassuser.setText(null);
						tbGestaoNovoUser.setText(null);
						JOptionPane.showMessageDialog(null, "Alteracao de Nome efectuado com sucesso");
						lUtilizador.setText(func.getNome());
					} else {

						JOptionPane.showMessageDialog(null, "Dados errados! Confirme o que escreveu!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "O username j� existe, insira outro pf.");

				}

			}
		});
		btGestaouserconfirmar.setBounds(415, 415, 131, 41);
		jpanelGestao.add(btGestaouserconfirmar);

		JButton btGestaouserCancelar = new JButton("Cancelar");
		btGestaouserCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbGestaopassuser.setText(null);
				tbGestaoNovoUser.setText(null);
			}
		});
		btGestaouserCancelar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btGestaouserCancelar.setBounds(565, 415, 131, 41);
		jpanelGestao.add(btGestaouserCancelar);

		JLabel lblPassword_2 = new JLabel("Password:");
		lblPassword_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword_2.setBounds(749, 81, 131, 41);
		jpanelGestao.add(lblPassword_2);

		tbGestaoPass = new JPasswordField();
		tbGestaoPass.setBounds(749, 134, 271, 33);
		jpanelGestao.add(tbGestaoPass);

		JLabel lblPassword_3 = new JLabel("Nova Password:");
		lblPassword_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPassword_3.setBounds(749, 178, 168, 41);
		jpanelGestao.add(lblPassword_3);

		tbGestaoNovapass = new JPasswordField();
		tbGestaoNovapass.setBounds(749, 230, 271, 33);
		jpanelGestao.add(tbGestaoNovapass);

		JLabel lblConfirmarPassword = new JLabel("Confirmar Password:");
		lblConfirmarPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblConfirmarPassword.setBounds(749, 275, 271, 41);
		jpanelGestao.add(lblConfirmarPassword);

		tbGestaoConfirmPass = new JPasswordField();
		tbGestaoConfirmPass.setBounds(749, 327, 271, 33);
		jpanelGestao.add(tbGestaoConfirmPass);

		JButton btGestaopassConfirmar = new JButton("Confirmar");
		btGestaopassConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((func.getPassword().equals(new String(tbGestaoPass.getPassword())))
						&& new String(tbGestaoNovapass.getPassword())
								.equals(new String(tbGestaoConfirmPass.getPassword()))) {

					if (val.valPassword(String.valueOf(tbGestaoNovapass.getPassword()))) {

						func.setPassword(new String(tbGestaoNovapass.getPassword()));
						JOptionPane.showMessageDialog(null, "Altera��o efectuada com sucesso!");
						tbGestaoPass.setText(null);
						tbGestaoNovapass.setText(null);
						tbGestaoConfirmPass.setText(null);

					} else {
						JOptionPane.showMessageDialog(null, "Password nao cumpre requisitos");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Dados errados! Confirme os dados introduzidos!");
				}
			}
		});
		btGestaopassConfirmar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btGestaopassConfirmar.setBounds(749, 415, 131, 41);
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
		btGestaopassCancelar.setBounds(899, 415, 131, 41);
		jpanelGestao.add(btGestaopassCancelar);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setAlignmentX(0.0f);
		separator_1.setBounds(708, 83, 29, 433);
		jpanelGestao.add(separator_1);

		jpanelEliminarContaDataFecho.setBounds(0, 0, 1042, 576);
		JpanelPrincipal.add(jpanelEliminarContaDataFecho);
		jpanelEliminarContaDataFecho.setVisible(false);
		jpanelEliminarContaDataFecho.setLayout(null);

		JDateChooser dateChooserFechoConta = new JDateChooser();
		dateChooserFechoConta.setBounds(392, 126, 269, 35);
		jpanelEliminarContaDataFecho.add(dateChooserFechoConta);

		JButton bttConfirmarEliminacao = new JButton("Confirmar Eliminacao");

		bttConfirmarEliminacao.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		bttConfirmarEliminacao.setBounds(432, 198, 178, 38);
		jpanelEliminarContaDataFecho.add(bttConfirmarEliminacao);

		JLabel lblDataDeFecho = new JLabel("Data de fecho:");
		lblDataDeFecho.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblDataDeFecho.setBounds(453, 89, 178, 24);
		jpanelEliminarContaDataFecho.add(lblDataDeFecho);

		JButton btnVoltar_1 = new JButton("Voltar");
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jpanelContas.setVisible(true);
				jpanelEliminarContaDataFecho.setVisible(false);

			}
		});
		btnVoltar_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnVoltar_1.setBounds(466, 249, 99, 38);
		jpanelEliminarContaDataFecho.add(btnVoltar_1);

		bttConfirmarEliminacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				gb.javabank.eliminacontaemcliente(gb.javabank.getUtlizadores(),
						gb.javabank.SelectConta(Integer.parseInt(lContas.getSelectedValue()), gb.javabank.getContas()));

				gb.javabank.eliminaconta(Integer.parseInt(tbContasnum.getText()), dateChooserFechoConta.getDate(),
						gb.javabank.getContas());
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
				gb.javabank.addelementoslist(gb.javabank.listanumerodecontasabertas(gb.javabank.getContas()), dmconta);
				tbnomecartao.setText(null);
				dtcartao.setDate(null);
				tbcodcartao.setText(null);
				panelCartao.setVisible(false);
				jpanelEliminarContaDataFecho.setVisible(false);
				JOptionPane.showMessageDialog(null, "Conta eliminada com sucesso!");

			}
		});
		// Preencher tabela apartir do tablemodel:
		gb.javabank.preenchetabelaclientes2(modeloTabelaCliente, gb.javabank.getUtlizadores());
		gb.javabank.addelementoslist(gb.javabank.listanumerodecontasabertas(gb.javabank.getContas()), dmconta);
		// metodo que vai buscar as contas
		gb.javabank.addelementoslist(gb.javabank.listanumerodecontasabertas(gb.javabank.getContas()), dcbm);

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
				jpanelMovimentos.setVisible(false);
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
		btFunConta.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		// coloca o painel conta visivel:
		btFunConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpanelClientes.setVisible(false);
				jpanelContas.setVisible(true);
				jpanelGestao.setVisible(false);
				jpanelOperacoes.setVisible(false);
				jpanelMovimentos.setVisible(false);
				lContas.clearSelection();
				gb.javabank.limpatabela(model);
				gb.javabank.preenchetabelaclientes(model, gb.javabank.getUtlizadores());

				// limpa painel:
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

				btnMovimentos.setVisible(false);
				btPedirCartao.setVisible(false);

				// coloca os campos nao editaveis:
				tbContasnum.setEnabled(false);
				;
				dateChooser_2.setEnabled(false);
				tbContaslimitelevop.setEnabled(false);
				;
				tbContasSaldo.setEnabled(false);
				;
				tbContasSaldo.setEnabled(false);
				;
				tbContaslimitelevdia.setEnabled(false);
				;
				rdbtnContaCorrente.setEnabled(false);
				;
				rdbtnContaPoupanca.setEnabled(false);
				;
				tblJuros.setEnabled(false);
				;
				tbllimitemes.setEnabled(false);
				;

			}
		});

		JpanelMenu.add(btFunConta);

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
				jpanelMovimentos.setVisible(false);
				dcbm.removeAllElements();
				gb.javabank.addelementoslist(gb.javabank.listanumerodecontasabertas(gb.javabank.getContas()), dcbm);

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
				jpanelMovimentos.setVisible(false);
				tbGestaoUsername.setText(func.getUsername());
				tbfunnome.setText(func.getNome());
				tbfunapelido.setText(func.getSobrenome());
				dtfunnasc.setDate(func.getDataDeNascimento());
				tbfunident.setText(func.getNumidentificacao() + "");
				tbfuncontacto.setText(func.getContacto() + "");
				tbfunmorada.setText(func.getMorada());
				tbfunidfunc.setText(func.getIdFuncionario() + "");

				if (func.getTipoIndentificacao().equals("C.C.")) {
					rbfuncc.setSelected(true);
				}
				if (func.getTipoIndentificacao().equals("B.I.")) {
					rbfunbi.setSelected(true);
				}
				if (func.getTipoIndentificacao().equals("Passaporte")) {
					rbfuncpass.setSelected(true);

				}

			}
		});

		btFunGesto.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		// botao cliente accao que muda de cor

		btFunGesto.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

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
				jpanelClientes.setVisible(false);
				jpanelContas.setVisible(false);
				jpanelOperacoes.setVisible(false);
				jpanelMovimentos.setVisible(false);

				tbGestaoUsername.setText(func.getUsername());
				tbfunnome.setText(func.getNome());
				tbfunapelido.setText(func.getSobrenome());
				dtfunnasc.setDate(func.getDataDeNascimento());
				tbfunident.setText(func.getNumidentificacao() + "");
				tbfuncontacto.setText(func.getContacto() + "");
				tbfunmorada.setText(func.getMorada());
				tbfunidfunc.setText(func.getIdFuncionario() + "");

				if (func.getTipoIndentificacao().equals("C.C.")) {
					rbfuncc.setSelected(true);
				}
				if (func.getTipoIndentificacao().equals("B.I.")) {
					rbfunbi.setSelected(true);
				}
				if (func.getTipoIndentificacao().equals("Passaporte")) {
					rbfuncpass.setSelected(true);
				}

				jpanelGestao.setVisible(true);

			}
		});

	}
}
