
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ComboBoxModel;
import javax.swing.JPasswordField;

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
	private static Cliente clt;
	private static GestaoBanco gb;
	private JTextField textFieldNumCartao;
	private JTextField txtSaldoConta;
	private JTextField textMontTransf;
	private JTextField textContaDestino;
	private JPasswordField passwordFieldAntiga;
	private JPasswordField passwordFieldAntiga1;
	private JPasswordField passwordFieldNovaPass;
	private JPasswordField passwordFieldConfPass;

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

		// Incia a criaçao de todos os componentes

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

		// modelo que lista as contas no panel contas movimentos
		DefaultListModel<String> dmListaContas = new DefaultListModel<String>();
		gb.javabank.addelementoslist(gb.javabank.listacontadecliente(clt, gb.javabank.getContas()), dmListaContas);

		// modelo para combobox pesquisaContasJPCartao
		DefaultComboBoxModel<String> pesquisaContasCartao = new DefaultComboBoxModel<>(
				gb.javabank.listacontasordem(clt, gb.javabank.getContas()));

		// box onde escolhemos qual conta o cliente quer ver
		String[] contas = new String[] { "Conta a ordem", "Conta Poupança" };

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
		JPCltTransferencia.setBounds(0, 0, 716, 439);
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
		dateChooser.setEnabled(false);
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
				;

			}
		});
		button_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button_5.setBounds(402, 364, 116, 38);
		JPCltTransferencia.add(button_5);

		// confirma a tranferencia feita
		JButton button_1 = new JButton("Confirmar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((coBoxPesquisaContas.getSelectedIndex() == 0) && (textMontTransf.getText().isEmpty())
						&& (textContaDestino.getText().isEmpty())) {

					JOptionPane.showMessageDialog(null, "Falta preencher os campos obrigatórios!");

				} else {
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

		JLabel textFieldCltNumero1 = new JLabel("Número:");
		textFieldCltNumero1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textFieldCltNumero1.setBounds(128, 277, 94, 16);
		JPCltCM.add(textFieldCltNumero1);

		textFieldCltNumeroConta = new JTextField();
		textFieldCltNumeroConta.setEditable(false);
		textFieldCltNumeroConta.setBounds(141, 305, 217, 30);
		JPCltCM.add(textFieldCltNumeroConta);

		JLabel textFieldCltData1 = new JLabel("Data de Criação:");
		textFieldCltData1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textFieldCltData1.setBounds(128, 338, 270, 16);
		JPCltCM.add(textFieldCltData1);

		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblSaldo.setBounds(128, 404, 270, 16);
		JPCltCM.add(lblSaldo);

		textFieldCltSaldoConta = new JTextField();
		textFieldCltSaldoConta.setEditable(false);
		textFieldCltSaldoConta.setBounds(138, 432, 185, 30);
		JPCltCM.add(textFieldCltSaldoConta);

		JButton btnCltLimpar = new JButton("Limpar");

		btnCltLimpar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnCltLimpar.setBounds(221, 481, 120, 38);
		JPCltCM.add(btnCltLimpar);

		JLabel textCltCartao = new JLabel("Cartão:");
		textCltCartao.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		textCltCartao.setBounds(599, 74, 270, 16);
		JPCltCM.add(textCltCartao);

		textFieldCltCartao = new JTextField();
		textFieldCltCartao.setEditable(false);
		textFieldCltCartao.setBounds(599, 101, 174, 30);
		JPCltCM.add(textFieldCltCartao);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setEnabled(false);
		dateChooser_1.setBounds(138, 366, 217, 31);
		JPCltCM.add(dateChooser_1);

		JList<String> listContasCliente = new JList<String>(dmListaContas);
		// selecionar conta e preencher so campos correctos:
		listContasCliente.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				if (!listContasCliente.isSelectionEmpty()) {

					String numeroConta = listContasCliente.getSelectedValue();

					Conta c = gb.javabank.SelectConta(Integer.parseInt(numeroConta), gb.javabank.getContas());

					textFieldCltNumeroConta.setText(Integer.toString(c.getIdConta()));
					dateChooser_1.setDate(c.getDataCriacao());
					textFieldCltSaldoConta.setText(Double.toString(c.getSaldo()));

					Cartao c1 = gb.javabank.obterCartao(Integer.parseInt(numeroConta));
					textFieldCltCartao.setText(c1.getNomeTitular());
					textFieldNumCartao.setText(Integer.toString(c1.getnCartao()));
					// cartao:

				}
			}
		});
		listContasCliente.setBounds(94, 96, 379, 158);
		JPCltCM.add(listContasCliente);

		// combobox com uma string de lista e ao escolher uma faz um update a lista
		JComboBox comboBoxCltConta = new JComboBox(contas);
		comboBoxCltConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// seleciona as contas:

				if (comboBoxCltConta.getSelectedIndex() == 0) {
					dmListaContas.removeAllElements();
					gb.javabank.addelementoslist(gb.javabank.listacontasordem(clt, gb.javabank.getContas()),
							dmListaContas);
				} else {
					dmListaContas.removeAllElements();
					gb.javabank.addelementoslist(gb.javabank.listacontaspoupanca(clt, gb.javabank.getContas()),
							dmListaContas);
				}

			}
		});
		comboBoxCltConta.setBounds(94, 51, 196, 39);
		JPCltCM.add(comboBoxCltConta);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(599, 143, 379, 354);
		JPCltCM.add(scrollPane);
		JList listCltListaMovimentos = new JList(dmlistaOpe);
		// selecionar conta e preencher so campos correctos:
		listCltListaMovimentos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

			}
		});
		scrollPane.setViewportView(listCltListaMovimentos);

		textFieldNumCartao = new JTextField();
		textFieldNumCartao.setEditable(false);
		textFieldNumCartao.setBounds(810, 102, 168, 30);
		JPCltCM.add(textFieldNumCartao);

		// botao limpar
		btnCltLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listContasCliente.clearSelection();
				textFieldCltNumeroConta.setText("");
				dateChooser_1.setDate(null);
				textFieldCltSaldoConta.setText("");
				textFieldCltCartao.setText("");
				comboBoxCltConta.getSelectedIndex();
				textFieldNumCartao.setText("");

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
		comboBoxContasCartao.setBounds(622, 93, 249, 39);
		JPCltCartao.add(comboBoxContasCartao);

		JLabel lblNomeAGravar = new JLabel("Nome:");
		lblNomeAGravar.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNomeAGravar.setBounds(622, 144, 229, 23);
		JPCltCartao.add(lblNomeAGravar);

		textFieldNomeCartao = new JTextField();

		textFieldNomeCartao.setBounds(632, 176, 229, 31);
		JPCltCartao.add(textFieldNomeCartao);

		JLabel lblCdigoDigitos = new JLabel("COD:");
		lblCdigoDigitos.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblCdigoDigitos.setBounds(622, 294, 172, 23);
		JPCltCartao.add(lblCdigoDigitos);

		textFieldCOD = new JTextField();
		textFieldCOD.setEditable(false);
		textFieldCOD.setBounds(634, 318, 227, 30);
		JPCltCartao.add(textFieldCOD);

		JDateChooser dateChooserCartao = new JDateChooser();
		dateChooserCartao.setEnabled(false);
		dateChooserCartao.setDate(Date.valueOf(LocalDate.now()));
		dateChooserCartao.setBounds(632, 251, 219, 31);
		JPCltCartao.add(dateChooserCartao);

		JButton btnPedirCarto = new JButton("Pedir Cartão");
		btnPedirCarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboBoxContasCartao.getSelectedIndex() == 0) {

					// falta verificar se o cartao ja existe nesta conta senao cria um novo
					
					String s = (String) comboBoxContasCartao.getSelectedItem();
					Conta conta = gb.javabank.SelectConta(Integer.parseInt(s), gb.javabank.getContas());

					int id = 0;
					do {
						id = (int) (Math.random() * 1000);

					} while (id < 100 || id > 1000);
					textFieldCOD.setText("" + id);

					
				} else {

				}
			}
		});
		btnPedirCarto.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnPedirCarto.setBounds(622, 379, 120, 38);
		JPCltCartao.add(btnPedirCarto);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				comboBoxContasCartao.getSelectedIndex();
				textFieldNomeCartao.setText("");
				dateChooserCartao.setDate(Date.valueOf(LocalDate.now()));
				textFieldCOD.setText("");

			}
		});
		btnLimpar.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnLimpar.setBounds(766, 380, 120, 38);
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
		label_11.setBounds(622, 223, 72, 16);
		JPCltCartao.add(label_11);
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

		JLabel label_1 = new JLabel("Nova Password :");
		label_1.setVerifyInputWhenFocusTarget(false);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_1.setBounds(570, 192, 168, 41);
		JPCltGestao.add(label_1);

		JLabel label_2 = new JLabel("Confirmar Password :");
		label_2.setVerifyInputWhenFocusTarget(false);
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_2.setBounds(570, 289, 271, 41);
		JPCltGestao.add(label_2);

		// botao confirmar alteracao da pass
		JButton button = new JButton("Confirmar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (clt.getPassword().equals(String.valueOf(passwordFieldAntiga1.getPassword()))
						&& (String.valueOf(passwordFieldConfPass.getPassword())
								.equals(String.valueOf(passwordFieldNovaPass.getPassword())))) {

					clt.setPassword(String.valueOf(passwordFieldNovaPass.getPassword()));

					passwordFieldAntiga1.setText(null);
					passwordFieldConfPass.setText(null);
					passwordFieldNovaPass.setText(null);
					JOptionPane.showMessageDialog(null, "A password foi alterado com sucesso!");

				}
			}
		});

		button.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button.setBounds(570, 429, 131, 41);
		JPCltGestao.add(button);

		// botao cancelar da alteracao da pass
		JButton button_2 = new JButton("Cancelar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				passwordFieldAntiga1.setText(null);
				passwordFieldConfPass.setText(null);
				passwordFieldNovaPass.setText(null);
			}
		});
		button_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button_2.setBounds(720, 429, 131, 41);
		JPCltGestao.add(button_2);

		// botao cancelar alterar user
		JButton button_3 = new JButton("Cancelar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordFieldAntiga.setText(null);
				txtCltNewUser.setText(null);

			}
		});
		button_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button_3.setBounds(285, 429, 131, 41);
		JPCltGestao.add(button_3);

		// botao confirmar da alteraçao do user
		JButton button_4 = new JButton("Confirmar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (clt.getPassword().equals(String.valueOf(passwordFieldAntiga.getPassword()))) {

					clt.setUsername(txtCltNewUser.getText());
					passwordFieldAntiga.setText(null);
					txtCltNewUser.setText(null);
					textCltUser.setText(clt.getUsername());
					JOptionPane.showMessageDialog(null, "O username foi alterado com sucesso!");
				}
			}
		});

		button_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		button_4.setBounds(135, 429, 131, 41);
		JPCltGestao.add(button_4);

		txtCltNewUser = new JTextField();
		txtCltNewUser.setColumns(10);
		txtCltNewUser.setBounds(135, 341, 271, 33);
		JPCltGestao.add(txtCltNewUser);

		JLabel label_3 = new JLabel("Nova Username :");
		label_3.setVerifyInputWhenFocusTarget(false);
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_3.setBounds(135, 289, 191, 41);
		JPCltGestao.add(label_3);

		JLabel label_4 = new JLabel("Password :");
		label_4.setVerifyInputWhenFocusTarget(false);
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_4.setBounds(135, 192, 131, 41);
		JPCltGestao.add(label_4);

		textCltUser = new JTextField(clt.getUsername());
		textCltUser.setBounds(135, 148, 271, 33);
		textCltUser.setEditable(false);
		JPCltGestao.add(textCltUser);

		JLabel label_5 = new JLabel("Username :");
		label_5.setVerifyInputWhenFocusTarget(false);
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_5.setBounds(135, 95, 131, 41);
		JPCltGestao.add(label_5);

		passwordFieldAntiga = new JPasswordField();
		passwordFieldAntiga.setBounds(135, 244, 271, 33);
		JPCltGestao.add(passwordFieldAntiga);

		passwordFieldAntiga1 = new JPasswordField();
		passwordFieldAntiga1.setBounds(580, 147, 271, 33);
		JPCltGestao.add(passwordFieldAntiga1);

		passwordFieldNovaPass = new JPasswordField();
		passwordFieldNovaPass.setBounds(580, 245, 271, 33);
		JPCltGestao.add(passwordFieldNovaPass);

		passwordFieldConfPass = new JPasswordField();
		passwordFieldConfPass.setBounds(580, 342, 271, 33);
		JPCltGestao.add(passwordFieldConfPass);

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
