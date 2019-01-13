
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
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;

public class BancoAppClt implements Serializable {

	private JFrame frame;
	private JTextField textFieldCltNumeroConta;
	private JTextField textFieldCltSaldoConta;
	private JTextField textFieldCltCartao;
	private JTextField tbCltTransfSaldo;
	private JTextField tbCltTransfMontante;
	private JTextField tbCltTransfDestino;
	private JTextField txtCltNewUser;
	private JTextField textCltUser;
	private JTextField textFieldNomeCartao;
	private JTextField textFieldCOD;
	private Cliente clt;
	private GestaoBanco gb;
	private JTextField textFieldCodCartao;
	private JTextField txtSaldoConta;
	private JTextField textMontTransf;
	private JTextField textContaDestino;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldAntiga;
	private JPasswordField passwordFieldNovaPass;
	private JPasswordField passwordFieldConfPass;
	private JTable table;
	private JTextField textFieldNomeClt;
	private JTextField textFieldApelidoClt;
	private JTextField textFieldNumIdentClt;
	private JTextField textFieldMorada;
	private JTextField textFieldContactoClt;
	private JTextField textFieldUserClt;
	private JTextField textFieldPassClt;
	private JTextField textFieldCltDescr;
	private JTextField tbcltcartaonumero;
	private JTextField tbNCartao;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			BancoAppClt window = new BancoAppClt(clt, gb);
			window.frame.setVisible(true);

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Nao foi possivel abrir o cliente");
		}
	}

	/**
	 * Create the application.
	 */
	public BancoAppClt(Cliente c, GestaoBanco g) {
		clt = c;
		gb = g;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		Validador val = new Validador();

		// Incia a criaçao de todos os componentes

		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				gb.atualizaficheiro(gb.javabank.getUtlizadores(), gb.javabank.getContas(), gb.javabank.getCartoes());

				// teste
			}
		});
		frame.setBounds(100, 100, 1280, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		// Modelo para tabela
		String[] colunas = { "IDOp", "Responsável", "Data", "Valor", "ContaDestino", "Cliente" };
		DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};

		// modelo que lista as contas no panel contas movimentos
		DefaultListModel<String> dmListaContas = new DefaultListModel<String>();
		gb.javabank.addelementoslist(gb.javabank.listacontadecliente(clt, gb.javabank.getContas()), dmListaContas);

		// modelo para combobox pesquisaContasJPCartao
		DefaultComboBoxModel<String> pesquisaContasCartao = new DefaultComboBoxModel<>(
				gb.javabank.listacontasordem(clt, gb.javabank.getContas()));

		// box onde escolhemos qual conta o cliente quer ver
		String[] contas = new String[] { "Numero de conta", "Conta a ordem", "Conta Poupanca" };

		ButtonGroup bg = new ButtonGroup();

		// Painel de cabeçalho
		JPanel JpanelCabecalho = new JPanel();
		JpanelCabecalho.setBackground(new Color(65, 106, 105));
		JpanelCabecalho.setBounds(0, 0, 1280, 130);
		frame.getContentPane().add(JpanelCabecalho);
		JpanelCabecalho.setLayout(null);

		// Botao de logout, metodo que vai buscar a class
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					gb.atualizaficheiro(gb.javabank.getUtlizadores(), gb.javabank.getContas(),
							gb.javabank.getCartoes());

					Login logout = new Login();
					frame.setVisible(false);
					logout.run();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnLogout.setBounds(1070, 30, 143, 42);
		JpanelCabecalho.add(btnLogout);

		// texto no cabeçalho :Java
		JLabel lblNewLabel = new JLabel("JavaBank");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setVerifyInputWhenFocusTarget(false);
		lblNewLabel.setForeground(new Color(188, 127, 82));
		lblNewLabel.setBounds(34, 21, 227, 74);
		JpanelCabecalho.add(lblNewLabel);

		// modelo de combobox no panel Transferencia que contem as contas do cliente e
		// ao seleccionar coloca o saldo dessa conta
		DefaultComboBoxModel<String> pesquisaContas = new DefaultComboBoxModel<>(
				gb.javabank.listacontadecliente(clt, gb.javabank.getContas()));

		// modelo para a lista das operacoes
		DefaultListModel<String> dmlistaOpe = new DefaultListModel<String>();
		gb.javabank.addelementoslist(gb.javabank.arrayOperacoes(clt.getContas(), gb.javabank.getContas()), dmlistaOpe);

		// texto no cabeçalho : Bem vindo
		JLabel lblBemVindo = new JLabel("Bem-Vindo(a) -");
		lblBemVindo.setVerifyInputWhenFocusTarget(false);
		lblBemVindo.setForeground(new Color(0, 0, 0));
		lblBemVindo.setFont(new Font("Helvetica", Font.PLAIN, 33));
		lblBemVindo.setBounds(348, 41, 243, 52);
		JpanelCabecalho.add(lblBemVindo);

		// texto no cabeçalho : utilizador
		JLabel lUtilizador = new JLabel(clt.getNome());
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
		JpanelPrincipal.setBounds(198, 142, 1065, 598);
		frame.getContentPane().add(JpanelPrincipal);
		JpanelPrincipal.setLayout(null);

		// Painel principal gestao
		JPanel JPCltGestao = new JPanel();
		JPCltGestao.setVisible(false);

		// Painel principal transferencia
		JPanel JPCltTransferencia = new JPanel();
		JPCltTransferencia.setBounds(16, 16, 1032, 563);
		JpanelPrincipal.add(JPCltTransferencia);
		JPCltTransferencia.setLayout(null);
		JPCltTransferencia.setVisible(false);

		JLabel label_7 = new JLabel("Saldo :");
		label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_7.setBounds(420, 59, 162, 23);
		JPCltTransferencia.add(label_7);
		JComboBox coBoxPesquisaContas = new JComboBox(pesquisaContas);
		coBoxPesquisaContas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// seleciona as contas:

				if (coBoxPesquisaContas.getSelectedIndex() == 0) {

					String s = (String) coBoxPesquisaContas.getSelectedItem();
					Conta corigem = gb.javabank.SelectConta(Integer.parseInt(s), gb.javabank.getContas());

					txtSaldoConta.setText(Double.toString(corigem.getSaldo()));

				} else {

					String s = (String) coBoxPesquisaContas.getSelectedItem();
					Conta corigem = gb.javabank.SelectConta(Integer.parseInt(s), gb.javabank.getContas());

					txtSaldoConta.setText(Double.toString(corigem.getSaldo()));

				}

			}
		});
		coBoxPesquisaContas.setBounds(121, 88, 235, 27);
		JPCltTransferencia.add(coBoxPesquisaContas);

		JLabel label_6 = new JLabel("Conta:");
		label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_6.setBounds(111, 59, 64, 23);
		JPCltTransferencia.add(label_6);

		txtSaldoConta = new JTextField();
		txtSaldoConta.setEditable(false);
		txtSaldoConta.setEditable(false);
		txtSaldoConta.setBounds(430, 85, 169, 31);
		JPCltTransferencia.add(txtSaldoConta);

		JLabel label_8 = new JLabel("Montante:");
		label_8.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_8.setBounds(304, 145, 97, 23);
		JPCltTransferencia.add(label_8);

		textMontTransf = new JTextField();
		textMontTransf.setBounds(314, 170, 162, 30);
		JPCltTransferencia.add(textMontTransf);

		JLabel label_9 = new JLabel("Conta destino:");
		label_9.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_9.setBounds(304, 212, 137, 23);
		JPCltTransferencia.add(label_9);

		textContaDestino = new JTextField();
		textContaDestino.setBounds(314, 237, 162, 30);
		JPCltTransferencia.add(textContaDestino);

		JLabel label_10 = new JLabel("Data da Operação:");
		label_10.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_10.setBounds(304, 279, 189, 23);
		JPCltTransferencia.add(label_10);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDate(Date.valueOf(LocalDate.now()));
		dateChooser.setBounds(314, 309, 162, 31);
		JPCltTransferencia.add(dateChooser);

		// botao cancelar ou limpar
		JButton button_5 = new JButton("Cancelar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textMontTransf.setText("");
				textContaDestino.setText("");
				dateChooser.setDate(Date.valueOf(LocalDate.now()));
			}
		});
		button_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button_5.setBounds(402, 364, 116, 38);
		JPCltTransferencia.add(button_5);

		// confirma a tranferencia feita
		JButton button_1 = new JButton("Confirmar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (val.valValorOperacao(textMontTransf.getText())
						&& val.valContaTransferir(textContaDestino.getText())) {
					double valortransf = Double.parseDouble(textMontTransf.getText());

					String s = (String) coBoxPesquisaContas.getSelectedItem();

					Conta corigem = gb.javabank.SelectConta(Integer.parseInt(s), gb.javabank.getContas());

					Conta cdestino;

					try {

						String numContaDestino = textContaDestino.getText();
						cdestino = gb.javabank.SelectConta(Integer.parseInt(numContaDestino), gb.javabank.getContas());

						if ((corigem.getSaldo() >= valortransf) && (!corigem.equals(cdestino))) {

							// gerado ids:
							int idoperacaoorigem = 1;
							if (corigem.getOperacoes().size() != 0) {
								idoperacaoorigem = corigem.getOperacoes().get(corigem.getOperacoes().size() - 1)
										.getIdOperacao() + 1;
							}
							int idoperacaodestino = 1;
							if (cdestino.getOperacoes().size() != 0) {
								idoperacaodestino = cdestino.getOperacoes().get(cdestino.getOperacoes().size() - 1)
										.getIdOperacao() + 1;
							}
							// faz transferencia;
							cdestino.setSaldo(cdestino.getSaldo() + valortransf);
							corigem.setSaldo(corigem.getSaldo() - valortransf);

							String descricaoCorigem = dateChooser.getDate() + " - Transferencia efectuada para conta "
									+ cdestino.getIdConta() + " valor: " + valortransf;
							String descricaoCdestino = dateChooser.getDate() + " - Transferencia recebida da conta "
									+ corigem.getIdConta() + " valor: " + valortransf;

							// adicionar ao array das operacoes
							Operacao oporigem = new Transferencia(idoperacaoorigem, null, dateChooser.getDate(),
									valortransf, descricaoCorigem, cdestino, clt);
							Operacao opdestino = new Transferencia(idoperacaodestino, null, dateChooser.getDate(),
									valortransf, descricaoCdestino, corigem, clt);

							corigem.getOperacoes().add(oporigem);
							cdestino.getOperacoes().add(opdestino);

							txtSaldoConta.setText(Double.toString(corigem.getSaldo()));
							dmlistaOpe.removeAllElements();
							gb.javabank.addelementoslist(
									gb.javabank.arrayOperacoes(clt.getContas(), gb.javabank.getContas()), dmlistaOpe);
							JOptionPane.showMessageDialog(null, "Transferencia realizada com sucesso");

						} else {
							if (corigem.getSaldo() < valortransf) {
								JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
							}
							if (corigem.equals(cdestino)) {
								JOptionPane.showMessageDialog(null, "Numero de conta de destino invalido");
							}
						}

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Numero de conta de destino invalido");
					}
				} else {

				}
			}
		});
		button_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button_1.setBounds(264, 364, 116, 38);
		JPCltTransferencia.add(button_1);

		// Painel principal cliente
		JPanel JPCltCM = new JPanel();
		JPCltCM.setBounds(16, 16, 1032, 563);
		JpanelPrincipal.add(JPCltCM);
		JPCltCM.setLayout(null);
		JPCltCM.setVisible(true);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(479, 121, 498, 354);
		JPCltCM.add(scrollPane);
		table = new JTable(modeloTabela);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int linha = table.getSelectedRow();
				int idDesc = (int) table.getModel().getValueAt(linha, 0);
				String descricao = gb.javabank.descricaoOpercacoes(idDesc);

				textFieldCltDescr.setText(descricao);
			}
		});
		scrollPane.setViewportView(table);

		JLabel textFieldCltNumero1 = new JLabel("Número:");
		textFieldCltNumero1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textFieldCltNumero1.setBounds(119, 269, 94, 16);
		JPCltCM.add(textFieldCltNumero1);

		textFieldCltNumeroConta = new JTextField();
		textFieldCltNumeroConta.setEditable(false);
		textFieldCltNumeroConta.setBounds(132, 297, 185, 30);
		JPCltCM.add(textFieldCltNumeroConta);

		JLabel textFieldCltData1 = new JLabel("Data de Criação:");
		textFieldCltData1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textFieldCltData1.setBounds(119, 330, 270, 16);
		JPCltCM.add(textFieldCltData1);

		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblSaldo.setBounds(119, 396, 270, 16);
		JPCltCM.add(lblSaldo);

		textFieldCltSaldoConta = new JTextField();
		textFieldCltSaldoConta.setEditable(false);
		textFieldCltSaldoConta.setBounds(129, 424, 185, 30);
		JPCltCM.add(textFieldCltSaldoConta);

		JButton btnCltLimpar = new JButton("Limpar");

		btnCltLimpar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnCltLimpar.setBounds(169, 476, 120, 38);
		JPCltCM.add(btnCltLimpar);

		JLabel textCltCartao = new JLabel("Cartão:");
		textCltCartao.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textCltCartao.setBounds(479, 51, 79, 16);
		JPCltCM.add(textCltCartao);

		textFieldCltCartao = new JTextField();
		textFieldCltCartao.setEditable(false);
		textFieldCltCartao.setBounds(479, 78, 174, 30);
		JPCltCM.add(textFieldCltCartao);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setEnabled(false);
		dateChooser_1.setBounds(129, 358, 185, 31);
		JPCltCM.add(dateChooser_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(94, 96, 252, 158);
		JPCltCM.add(scrollPane_1);

		JList<String> listContasCliente = new JList<String>(dmListaContas);
		scrollPane_1.setViewportView(listContasCliente);
		// selecionar conta e preencher so campos correctos:
		listContasCliente.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				modeloTabela.setRowCount(0);

				if (!listContasCliente.isSelectionEmpty()) {

					String numeroConta = listContasCliente.getSelectedValue();

					Conta c = gb.javabank.SelectConta(Integer.parseInt(numeroConta), gb.javabank.getContas());

					textFieldCltNumeroConta.setText(Integer.toString(c.getIdConta()));
					dateChooser_1.setDate(c.getDataCriacao());
					textFieldCltSaldoConta.setText(Double.toString(c.getSaldo()));
					textFieldCltCartao.setText(null);
					textFieldCodCartao.setText(null);
					tbNCartao.setText(null);
					textFieldCltDescr.setText(null);

					// cartao:

					if (c instanceof ContaCorrente) {
						Cartao card = gb.javabank.obterCartao(gb.javabank.getCartoes(),
								((ContaCorrente) c).getCartao());

						textFieldCltCartao.setText(card.getNomeTitular());
						textFieldCodCartao.setText(Integer.toString(card.getCodvalidacao()));
						tbNCartao.setText(Integer.toString(card.getnCartao()));
					}

					gb.javabank.preenchetabelaOperacoesTransferencia(modeloTabela, c);
					gb.javabank.preenchetabelaOperacoesDeposito(modeloTabela, c);
					gb.javabank.preenchetabelaOperacoesLevantamento(modeloTabela, c);

				}
			}
		});

		// combobox com uma string de lista e ao escolher uma faz um update a lista
		JComboBox comboBoxCltConta = new JComboBox(contas);
		comboBoxCltConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// seleciona as contas:

				if (comboBoxCltConta.getSelectedItem().equals("Conta a ordem")) {
					// preenche a lista de contas
					dmListaContas.removeAllElements();
					gb.javabank.addelementoslist(gb.javabank.listacontasordem(clt, gb.javabank.getContas()),
							dmListaContas);

					// limpa os campos
					textFieldCltNumeroConta.setText(null);
					dateChooser_1.setDate(null);
					textFieldCltSaldoConta.setText(null);
					textFieldCltCartao.setText(null);
					textFieldCodCartao.setText(null);
					tbNCartao.setText(null);
					textFieldCltDescr.setText(null);
					modeloTabela.setRowCount(0);

				} else if (comboBoxCltConta.getSelectedItem().equals("Conta Poupanca")) {
					// preenche a lista de contas
					dmListaContas.removeAllElements();
					gb.javabank.addelementoslist(gb.javabank.listacontaspoupanca(clt, gb.javabank.getContas()),
							dmListaContas);

					// limpa os campos
					textFieldCltNumeroConta.setText(null);
					dateChooser_1.setDate(null);
					textFieldCltSaldoConta.setText(null);
					textFieldCltCartao.setText(null);
					textFieldCodCartao.setText(null);
					tbNCartao.setText(null);
					textFieldCltDescr.setText(null);
					modeloTabela.setRowCount(0);

				} else if (comboBoxCltConta.getSelectedItem().equals("Numero de conta")) {
					// preenche a lista de contas
					dmListaContas.removeAllElements();
					gb.javabank.addelementoslist(gb.javabank.listacontadecliente(clt, gb.javabank.getContas()),
							dmListaContas);

					// limpa os campos
					textFieldCltNumeroConta.setText(null);
					dateChooser_1.setDate(null);
					textFieldCltSaldoConta.setText(null);
					textFieldCltCartao.setText(null);
					textFieldCodCartao.setText(null);
					tbNCartao.setText(null);
					textFieldCltDescr.setText(null);
					modeloTabela.setRowCount(0);

				}

			}
		});
		comboBoxCltConta.setBounds(94, 51, 196, 39);
		JPCltCM.add(comboBoxCltConta);

		textFieldCodCartao = new JTextField();
		textFieldCodCartao.setEditable(false);
		textFieldCodCartao.setBounds(830, 78, 147, 30);
		JPCltCM.add(textFieldCodCartao);

		textFieldCltDescr = new JTextField();
		textFieldCltDescr.setBounds(479, 487, 498, 35);
		JPCltCM.add(textFieldCltDescr);
		textFieldCltDescr.setColumns(10);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblCodigo.setBounds(827, 48, 129, 23);
		JPCltCM.add(lblCodigo);

		tbNCartao = new JTextField();
		tbNCartao.setEditable(false);
		tbNCartao.setBounds(665, 78, 147, 30);
		JPCltCM.add(tbNCartao);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNumero.setBounds(665, 48, 129, 23);
		JPCltCM.add(lblNumero);

		// botao limpar
		btnCltLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listContasCliente.clearSelection();
				textFieldCltNumeroConta.setText("");
				dateChooser_1.setDate(null);
				textFieldCltSaldoConta.setText("");
				textFieldCltCartao.setText("");
				comboBoxCltConta.getSelectedIndex();
				textFieldCodCartao.setText("");
				tbNCartao.setText("");
				dmListaContas.removeAllElements();
				gb.javabank.addelementoslist(gb.javabank.listacontadecliente(clt, gb.javabank.getContas()),
						dmListaContas);

			}
		});

		// Painel principal cartao
		JPanel JPCltCartao = new JPanel();
		JPCltCartao.setBounds(16, 16, 1032, 563);
		JpanelPrincipal.add(JPCltCartao);
		JPCltCartao.setLayout(null);
		JPCltCartao.setVisible(false);

		JComboBox comboBoxContasCartao = new JComboBox(pesquisaContasCartao);

		comboBoxContasCartao.setBounds(623, 82, 249, 39);
		JPCltCartao.add(comboBoxContasCartao);

		JLabel lblNomeAGravar = new JLabel("Nome:");
		lblNomeAGravar.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNomeAGravar.setBounds(623, 203, 229, 23);
		JPCltCartao.add(lblNomeAGravar);

		textFieldNomeCartao = new JTextField();

		textFieldNomeCartao.setBounds(633, 235, 239, 31);
		JPCltCartao.add(textFieldNomeCartao);

		JLabel lblCdigoDigitos = new JLabel("COD:");
		lblCdigoDigitos.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblCdigoDigitos.setBounds(623, 353, 172, 23);
		JPCltCartao.add(lblCdigoDigitos);

		textFieldCOD = new JTextField();
		textFieldCOD.setEditable(false);
		textFieldCOD.setBounds(635, 377, 227, 30);
		JPCltCartao.add(textFieldCOD);

		JDateChooser dateChooserCartao = new JDateChooser();
		dateChooserCartao.setEnabled(false);
		dateChooserCartao.setDate(Date.valueOf(LocalDate.now()));
		dateChooserCartao.setBounds(633, 310, 239, 31);
		JPCltCartao.add(dateChooserCartao);

		JButton btnPedirCarto = new JButton("Pedir Cartão");
		btnPedirCarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboBoxContasCartao.getSelectedIndex() != -1) {

					String s = (String) comboBoxContasCartao.getSelectedItem();
					Conta conta = gb.javabank.SelectConta(Integer.parseInt(s), gb.javabank.getContas());

					// verifica se a conta já tem cartao
					if (((ContaCorrente) conta).getCartao() != 0) {

						Cartao card = gb.javabank.obterCartao(gb.javabank.getCartoes(),
								((ContaCorrente) conta).getCartao());

						// ver situacao se o cartao expirou ou nao

						if (card.getDataValidade().before(Date.valueOf(LocalDate.now()))) {

							Cartao card2 = gb.javabank.obterCartao(gb.javabank.getCartoes(), card.getnCartao());
							card2.setAtivo(false);
							card2.setIdconta(0);
							((ContaCorrente) conta).setCartao(0);

							textFieldNomeCartao.setEditable(true);
							JOptionPane.showMessageDialog(null, "Cartão revalidado!! Novo cartão criado!!");

						} else {
							JOptionPane.showMessageDialog(null,
									"Já existe um cartão associado a sua conta dentro da data de validade!");

							textFieldCOD.setText(null);
							tbcltcartaonumero.setText(null);
							textFieldNomeCartao.setText(null);
							dateChooserCartao.setDate(null);
							textFieldCOD.setEditable(false);
							dateChooserCartao.setEnabled(false);
							textFieldNomeCartao.setEditable(false);
							tbcltcartaonumero.setEditable(false);
							;

						}

					}

					// adiciona um cartao á conta
					if (((ContaCorrente) conta).getCartao() == 0) {

						// gera o codigo de 3 digitos:
						// gera numero de cartao de 5 digitoas;
						int idcartao = val.valIdCartao(gb.javabank.getCartoes());
						int nvalcartao = val.valCodCartao();

						if (val.valTitularCartao(textFieldNomeCartao.getText())) {

							Calendar cal = new GregorianCalendar();
							Date.valueOf(LocalDate.now());
							cal.add(Calendar.YEAR, 5);

							Cartao card = new Cartao(idcartao, textFieldNomeCartao.getText(), cal.getTime(), nvalcartao,
									conta.getIdConta(), true);
							gb.javabank.criaCartao(Integer.parseInt(s), card, conta);

							textFieldCOD.setText(nvalcartao + "");
							tbcltcartaonumero.setText(idcartao + "");
							textFieldNomeCartao.setEditable(false);
							dateChooserCartao.setEnabled(false);
							dateChooserCartao.setDate(cal.getTime());
							textFieldCOD.setEditable(false);
							JOptionPane.showMessageDialog(null, "Cartao criado com sucesso");
						} else {

							JOptionPane.showMessageDialog(null, "Corrija o nome no cartao!");
						}

					}

				}
			}
		});
		btnPedirCarto.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnPedirCarto.setBounds(623, 438, 120, 38);
		JPCltCartao.add(btnPedirCarto);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				comboBoxContasCartao.getSelectedIndex();
				tbcltcartaonumero.setText("");
				textFieldNomeCartao.setText("");
				dateChooserCartao.setDate(null);
				textFieldCOD.setText("");

			}
		});
		btnLimpar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnLimpar.setBounds(767, 439, 120, 38);
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
		lblNewLabel_1.setIcon(
				new ImageIcon("/Users/tamarabarros/Dropbox/IPJ_ProjectoFinal/Design/JavaBank2/imagens/cartao34.jpg"));
		lblNewLabel_1.setBounds(99, 93, 335, 207);
		JPCltCartao.add(lblNewLabel_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.BLACK);
		separator_2.setAlignmentX(0.0f);
		separator_2.setBounds(509, 69, 29, 433);
		JPCltCartao.add(separator_2);

		JLabel label_11 = new JLabel("Validade");
		label_11.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_11.setBounds(623, 282, 72, 16);
		JPCltCartao.add(label_11);

		tbcltcartaonumero = new JTextField();
		tbcltcartaonumero.setEditable(false);
		tbcltcartaonumero.setBounds(632, 159, 240, 31);
		JPCltCartao.add(tbcltcartaonumero);

		JLabel lblNumeroDoCartao = new JLabel("Numero do Cartao:");
		lblNumeroDoCartao.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNumeroDoCartao.setBounds(622, 127, 229, 23);
		JPCltCartao.add(lblNumeroDoCartao);

		comboBoxContasCartao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxContasCartao.getSelectedIndex() != -1) {
					ContaCorrente conta = (ContaCorrente) gb.javabank.SelectConta(
							Integer.parseInt((String) comboBoxContasCartao.getSelectedItem()), gb.javabank.getContas());
					Cartao c = gb.javabank.obterCartao(gb.javabank.getCartoes(), conta.getCartao());
					textFieldNomeCartao.setText(c.getNomeTitular());
					tbcltcartaonumero.setText(c.getnCartao() + "");
					dateChooserCartao.setDate(c.getDataValidade());
					textFieldCOD.setText(c.getCodvalidacao() + "");
				}
			}
		});
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
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label.setBounds(612, 272, 131, 41);
		JPCltGestao.add(label);

		JLabel label_1 = new JLabel("Nova Password (8 caracteres com 1 numero e 1 letra) :");
		label_1.setVerifyInputWhenFocusTarget(false);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_1.setBounds(612, 341, 168, 26);
		JPCltGestao.add(label_1);

		JLabel label_2 = new JLabel("Confirmar Password :");
		label_2.setVerifyInputWhenFocusTarget(false);
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_2.setBounds(612, 399, 175, 33);
		JPCltGestao.add(label_2);

		// botao confirmar alteracao da pass
		JButton button = new JButton("Confirmar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (clt.getPassword().equals(String.valueOf(passwordFieldAntiga.getPassword()))
						&& (String.valueOf(passwordFieldConfPass.getPassword())
								.equals(String.valueOf(passwordFieldNovaPass.getPassword())))) {

					if (val.valPassword(String.valueOf(passwordFieldNovaPass.getPassword()))) {
						clt.setPassword(String.valueOf(passwordFieldNovaPass.getPassword()));

						passwordFieldAntiga.setText(null);
						passwordFieldConfPass.setText(null);
						passwordFieldNovaPass.setText(null);
						JOptionPane.showMessageDialog(null, "A password foi alterada com sucesso!");

					} else {
						JOptionPane.showMessageDialog(null, "Password nao cumpre requisitos");
					}
				} else {
					if (!clt.getPassword().equals(String.valueOf(passwordFieldAntiga.getPassword()))) {
						JOptionPane.showMessageDialog(null, "A atual password esta errada!");
					}

					if ((String.valueOf(passwordFieldConfPass.getPassword())
							.equals(String.valueOf(passwordFieldNovaPass.getPassword())))) {
						JOptionPane.showMessageDialog(null, "A nova password e confirma�ao nao correspondem!");
					}

				}
			}
		});

		button.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button.setBounds(643, 478, 110, 32);
		JPCltGestao.add(button);

		// botao cancelar da alteracao da pass
		JButton button_2 = new JButton("Cancelar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				passwordFieldAntiga.setText(null);
				passwordFieldConfPass.setText(null);
				passwordFieldNovaPass.setText(null);
			}
		});
		button_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button_2.setBounds(765, 478, 110, 32);
		JPCltGestao.add(button_2);

		// botao cancelar alterar user
		JButton button_3 = new JButton("Cancelar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(null);
				txtCltNewUser.setText(null);

			}
		});
		button_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button_3.setBounds(763, 239, 110, 32);
		JPCltGestao.add(button_3);

		// botao confirmar da alteraçao do user
		JButton button_4 = new JButton("Confirmar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (val.valUsername(txtCltNewUser.getText(), gb.javabank.getUtlizadores())) {
					if (clt.getPassword().equals(String.valueOf(passwordField.getPassword()))) {

						clt.setUsername(txtCltNewUser.getText());
						passwordField.setText(null);
						txtCltNewUser.setText(null);
						textCltUser.setText(clt.getUsername());
						JOptionPane.showMessageDialog(null, "O username foi alterado com sucesso!");
					} else {
						JOptionPane.showMessageDialog(null, "PassWord errada");

					}
				} else {

					JOptionPane.showMessageDialog(null, "O username j� existe, insira outro pf.");
				}

			}
		});

		button_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button_4.setBounds(642, 239, 110, 32);
		JPCltGestao.add(button_4);

		txtCltNewUser = new JTextField();
		txtCltNewUser.setColumns(10);
		txtCltNewUser.setBounds(622, 194, 271, 33);
		JPCltGestao.add(txtCltNewUser);

		JLabel label_3 = new JLabel("Nova Username :");
		label_3.setVerifyInputWhenFocusTarget(false);
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_3.setBounds(613, 166, 191, 26);
		JPCltGestao.add(label_3);

		JLabel label_4 = new JLabel("Password :");
		label_4.setVerifyInputWhenFocusTarget(false);
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_4.setBounds(612, 102, 131, 41);
		JPCltGestao.add(label_4);

		textCltUser = new JTextField(clt.getUsername());
		textCltUser.setBounds(622, 75, 271, 33);
		textCltUser.setEditable(false);
		JPCltGestao.add(textCltUser);

		JLabel label_5 = new JLabel("Username :");
		label_5.setVerifyInputWhenFocusTarget(false);
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_5.setBounds(612, 42, 131, 41);
		JPCltGestao.add(label_5);

		passwordField = new JPasswordField();
		passwordField.setBounds(622, 133, 271, 33);
		JPCltGestao.add(passwordField);

		passwordFieldAntiga = new JPasswordField();
		passwordFieldAntiga.setBounds(622, 308, 271, 33);
		JPCltGestao.add(passwordFieldAntiga);

		passwordFieldNovaPass = new JPasswordField();
		passwordFieldNovaPass.setBounds(622, 368, 271, 33);
		JPCltGestao.add(passwordFieldNovaPass);

		passwordFieldConfPass = new JPasswordField();
		passwordFieldConfPass.setBounds(622, 433, 271, 33);
		JPCltGestao.add(passwordFieldConfPass);

		JLabel label_12 = new JLabel("Nome:");
		label_12.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_12.setBounds(61, 52, 57, 30);
		JPCltGestao.add(label_12);

		textFieldNomeClt = new JTextField(clt.getNome());
		textFieldNomeClt.setBounds(61, 83, 179, 31);
		textFieldNomeClt.setEditable(false);
		JPCltGestao.add(textFieldNomeClt);

		textFieldApelidoClt = new JTextField(clt.getSobrenome());
		textFieldApelidoClt.setEditable(false);
		textFieldApelidoClt.setBounds(252, 83, 193, 31);
		JPCltGestao.add(textFieldApelidoClt);

		JLabel label_13 = new JLabel("Apelido:");
		label_13.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_13.setBounds(252, 52, 72, 30);
		JPCltGestao.add(label_13);

		JLabel label_14 = new JLabel("D. Nascimento:");
		label_14.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_14.setBounds(71, 112, 131, 30);
		JPCltGestao.add(label_14);

		JDateChooser dateChooserNascimClt = new JDateChooser(clt.getDataDeNascimento());
		dateChooserNascimClt.setEnabled(false);
		dateChooserNascimClt.setBounds(81, 144, 260, 31);
		JPCltGestao.add(dateChooserNascimClt);

		JLabel label_15 = new JLabel("Documento:");
		label_15.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_15.setBounds(61, 176, 108, 30);
		JPCltGestao.add(label_15);

		JRadioButton radioButton = new JRadioButton("C.C.", false);
		radioButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		radioButton.setBounds(169, 178, 66, 25);
		radioButton.setEnabled(false);
		JPCltGestao.add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("B.I.");
		radioButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		radioButton_1.setEnabled(false);
		radioButton_1.setBounds(236, 177, 57, 25);

		JPCltGestao.add(radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton("Passaporte");
		radioButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		radioButton_2.setBounds(293, 177, 138, 25);
		radioButton_2.setEnabled(false);
		JPCltGestao.add(radioButton_2);
		bg.add(radioButton);
		bg.add(radioButton_1);
		bg.add(radioButton_2);

		JLabel label_16 = new JLabel("Número:");
		label_16.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_16.setBounds(71, 210, 91, 30);
		JPCltGestao.add(label_16);

		textFieldNumIdentClt = new JTextField(Integer.toString(clt.getNumidentificacao()));
		textFieldNumIdentClt.setEditable(false);
		textFieldNumIdentClt.setBounds(81, 242, 271, 31);
		JPCltGestao.add(textFieldNumIdentClt);

		JLabel label_17 = new JLabel("Morada:");
		label_17.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_17.setBounds(71, 274, 66, 30);
		JPCltGestao.add(label_17);

		textFieldMorada = new JTextField(clt.getMorada());
		textFieldMorada.setEditable(false);
		textFieldMorada.setBounds(81, 302, 271, 31);
		JPCltGestao.add(textFieldMorada);

		JLabel label_18 = new JLabel("Contacto:");
		label_18.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_18.setBounds(71, 335, 81, 31);
		JPCltGestao.add(label_18);

		textFieldContactoClt = new JTextField(Integer.toString(clt.getContacto()));
		textFieldContactoClt.setEditable(false);
		textFieldContactoClt.setBounds(81, 364, 271, 33);
		JPCltGestao.add(textFieldContactoClt);

		JLabel label_19 = new JLabel("Username:");
		label_19.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_19.setBounds(71, 394, 115, 30);
		JPCltGestao.add(label_19);

		textFieldUserClt = new JTextField(clt.getUsername());
		textFieldUserClt.setEditable(false);
		textFieldUserClt.setBounds(82, 424, 271, 33);
		JPCltGestao.add(textFieldUserClt);

		JLabel label_20 = new JLabel("Password:");
		label_20.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		label_20.setBounds(71, 460, 91, 30);
		JPCltGestao.add(label_20);

		textFieldPassClt = new JTextField(clt.getPassword());
		textFieldPassClt.setEditable(false);
		textFieldPassClt.setBounds(81, 493, 271, 31);
		JPCltGestao.add(textFieldPassClt);

		JTextField tbAdmFunPesq = new JTextField();
		tbAdmFunPesq.setBounds(12, 52, 240, 30);
		tbAdmFunPesq.setColumns(10);

		// Botão conta/movimentos do menu
		JButton btCltConmov = new JButton();
		btCltConmov.setText("<html>" + "Conta/\nMovimentos" + "<html>");
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
				JPCltTransferencia.setVisible(false);
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

				JPCltTransferencia.setVisible(true);
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
				JPCltTransferencia.setVisible(false);
				JPCltGestao.setVisible(false);

				// limpar os campos
				comboBoxContasCartao.getSelectedIndex();
				tbcltcartaonumero.setText("");
				textFieldNomeCartao.setText("");
				dateChooserCartao.setDate(null);
				textFieldCOD.setText("");

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
				JPCltTransferencia.setVisible(false);
				JPCltGestao.setVisible(true);

				if (clt.getTipoIndentificacao().equals("C.C.")) {
					radioButton.setSelected(true);
				}
				if (clt.getTipoIndentificacao().equals("B.I.")) {
					radioButton_1.setSelected(true);
				}
				if (clt.getTipoIndentificacao().equals("Passaporte")) {
					radioButton_2.setSelected(true);
				}
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
