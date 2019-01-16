import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.JTextPane;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import javafx.scene.control.SingleSelectionModel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AppAdmin implements Serializable {

	private JFrame frame;
	private JPanel jpAdmGestaoUtil;
	private JTextField txtTituloLivros;
	private JTextField txtAutorLivros;
	private JTextField txtAnoLivros;
	private JTextField txtPrecoLivros;
	private JTextField txtStockLivros;
	private JTextField txtUsernameALTERARUSER;
	private JTextField txtNovoUsernameALTERAUSER;
	private JPasswordField txtPasswordALTERAPASS;
	private JTextField txtPesquisaUTILIZADOR;
	private JTextField txtIdFunc;
	private JTextField txtNomeUTILIZADOR;
	private JTextField txtContactoUTILIZADOR;
	private JTextField txtUsernameUTILIZADOR;
	private JTextField txtPassUTILIZADOR;
	private Utilizador admin;
	private GestaoLivraria gl;
	private JTextField txtPesquisaLIVROS;
	private JTextField txtIdLivros;
	private final ButtonGroup rbGroupSTOCK = new ButtonGroup();
	private JPasswordField txtPasswordALTERAUSER;
	private JPasswordField txtNovaPassALTERAPASS;
	private JPasswordField txtConfirmaPassALTERAPASS;
	private final ButtonGroup rbGroupLIVROS = new ButtonGroup();
	private final ButtonGroup rbGroupUtilizadores = new ButtonGroup();
	private JTextField txtLivroSelecSTATS;
	private JTable tabelaLivrosLIVROS;
	String[] colunasLivro = { "Id do livro", "Titulo", "Autor" };
	DefaultTableModel modeloTabelaLivrosLIVROS = new DefaultTableModel(colunasLivro, 0) {
		public boolean isCellEditable(int rowIndex, int mColIndex) {
			return false;
		}
	};
	String[] colunasFuncionario = { "ID", "Nome", "Username" };
	DefaultTableModel modeloTabelaUTILIZADORES = new DefaultTableModel(colunasFuncionario, 0) {
		public boolean isCellEditable(int rowIndex, int mColIndex) {
			return false;
		}

		public Class getColumnClass(int column) {
			Class returnValue;
			if ((column >= 0) && (column < getColumnCount())) {
				returnValue = getValueAt(0, column).getClass();
			} else {
				returnValue = Object.class;
			}
			return returnValue;
		}
	};
	String[] colunasVendas = { "ID", "Montante", "Data" };
	DefaultTableModel modeloVendasMontante = new DefaultTableModel(colunasVendas, 0) {
		public boolean isCellEditable(int rowIndex, int mColIndex) {
			return false;
		}

		public Class getColumnClass(int column) {
			Class returnValue;
			if ((column >= 0) && (column < getColumnCount())) {
				returnValue = getValueAt(0, column).getClass();
			} else {
				returnValue = Object.class;
			}
			return returnValue;
		}
	};
	String[] colunasLivroVendas = { "ID", "Titulo", "Vendas" };
	DefaultTableModel modeloLivroVendas = new DefaultTableModel(colunasLivroVendas, 0) {
		public boolean isCellEditable(int rowIndex, int mColIndex) {
			return false;
		}

		public Class getColumnClass(int column) {
			Class returnValue;
			if ((column >= 0) && (column < getColumnCount())) {
				returnValue = getValueAt(0, column).getClass();
			} else {
				returnValue = Object.class;
			}
			return returnValue;
		}
	};

	DefaultListModel<String> modeloListaPrecos = new DefaultListModel<String>();
	private JTable tabelaUtilizadores = new JTable(modeloTabelaUTILIZADORES);
	private JTable tabelaVendasMontante;
	private JTable tabelaLivroVendas;

	/**
	 * Launch the application.
	 */
	// EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			AppAdmin window = new AppAdmin(admin, gl);
			window.frame.setVisible(true);
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}
	// });

	/**
	 * Create the application.
	 */
	public AppAdmin(Utilizador a, GestaoLivraria gl) {
		this.admin = a;
		this.gl = gl;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		// passar tudo para ficheiros ao fechar
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				gl.atualizaficheiro(gl.getViewComics().getUtilizadores(), gl.getViewComics().getCarrinhos(),
						gl.getViewComics().getLivros(), gl.getViewComics().getVendas());
			}
		});
		DefaultListModel<String> modeloListaLivros = new DefaultListModel<String>();
		gl.viewComics.addArrayLista(gl.viewComics.arrayLivro(), modeloListaLivros);
		String usernameLogado = admin.getUsername();
		int idLogado = admin.getId();

		frame.setBounds(100, 100, 1280, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel Paineltotal = new JPanel();
		Paineltotal.setBackground(Color.ORANGE);
		Paineltotal.setBounds(0, 0, 1262, 721);
		frame.getContentPane().add(Paineltotal);
		Paineltotal.setLayout(null);

		JPanel panelcabecalho = new JPanel();
		panelcabecalho.setBackground(new Color(255, 215, 0));
		panelcabecalho.setBounds(0, 0, 1262, 176);
		Paineltotal.add(panelcabecalho);
		panelcabecalho.setLayout(null);

		JLabel label_6 = new JLabel();
		label_6.setBounds(96, 67, 0, 0);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Papyrus", Font.BOLD, 46));
		panelcabecalho.add(label_6);

		JLabel label_7 = new JLabel("ViewComics Inc.");
		label_7.setBounds(101, 5, 730, 125);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tempus Sans ITC", Font.BOLD, 95));
		panelcabecalho.add(label_7);

		JButton btnLogOut = new JButton("LogOut");
		btnLogOut.setBounds(1138, 54, 89, 23);
		btnLogOut.setBackground(SystemColor.controlHighlight);
		panelcabecalho.add(btnLogOut);

		JLabel lblBemVindo = new JLabel("Bem Vindo");
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		lblBemVindo.setBounds(941, 16, 113, 27);
		panelcabecalho.add(lblBemVindo);

		JPanel panelMenu = new JPanel();
		panelMenu.setLayout(null);
		panelMenu.setBounds(0, 176, 241, 545);
		Paineltotal.add(panelMenu);
		JButton btnLivros = new JButton("Livros");
		btnLivros.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 31));
		btnLivros.setBackground(SystemColor.controlHighlight);
		btnLivros.setBounds(25, 13, 176, 55);
		panelMenu.add(btnLivros);
		JButton btnFuncionarios = new JButton("<HTML>Gestao de utilizadores<HTML>");
		btnFuncionarios.setForeground(Color.BLACK);
		btnFuncionarios.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		btnFuncionarios.setBackground(SystemColor.controlHighlight);
		btnFuncionarios.setBounds(25, 81, 176, 62);
		panelMenu.add(btnFuncionarios);
		JButton btnEstatisticas = new JButton("Estatisticas");
		btnEstatisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEstatisticas.setForeground(Color.BLACK);
		btnEstatisticas.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnEstatisticas.setBackground(SystemColor.controlHighlight);
		btnEstatisticas.setBounds(25, 154, 176, 60);
		panelMenu.add(btnEstatisticas);
		JButton btnGestao = new JButton("<HTML>Conta pessoal<HTML>");
		btnGestao.setForeground(Color.BLACK);
		btnGestao.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		btnGestao.setBackground(SystemColor.controlHighlight);
		btnGestao.setBounds(25, 225, 176, 60);
		panelMenu.add(btnGestao);
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(240, 176, 1022, 545);
		Paineltotal.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		// gl.viewComics.livrosTabela(modeloTabelaLivrosLIVROS);

		JPanel jpAdmEstatisticas = new JPanel();
		jpAdmEstatisticas.setBounds(0, 0, 968, 545);
		panelPrincipal.add(jpAdmEstatisticas);
		jpAdmEstatisticas.setLayout(null);

		JLabel lblTabelaComData = new JLabel("Historico de precos");
		lblTabelaComData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTabelaComData.setBounds(193, 35, 152, 31);
		jpAdmEstatisticas.add(lblTabelaComData);

		JScrollPane scrollListaAlteracaoPrecos = new JScrollPane();
		scrollListaAlteracaoPrecos.setBounds(193, 113, 152, 421);
		jpAdmEstatisticas.add(scrollListaAlteracaoPrecos);

		JScrollPane scrollListaLivrosSTATS = new JScrollPane();
		scrollListaLivrosSTATS.setBounds(10, 67, 173, 467);
		jpAdmEstatisticas.add(scrollListaLivrosSTATS);

		JList<String> listaLivrosEstatistica = new JList<String>(modeloListaLivros);
		scrollListaLivrosSTATS.setViewportView(listaLivrosEstatistica);

		listaLivrosEstatistica.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!listaLivrosEstatistica.isSelectionEmpty()) {
					modeloListaPrecos.removeAllElements();
					String seleccao = listaLivrosEstatistica.getSelectedValue();
					txtLivroSelecSTATS.setText(seleccao.substring(0, seleccao.indexOf(",")));
					gl.viewComics.addArrayLista(gl.viewComics.precosHistoricoArray(seleccao), modeloListaPrecos);
					// String historicoPreco=gl.viewComics.devolvePrecosLivroSeleccionado(seleccao);
					// txtTesteSTATS.setText(historicoPreco);
				} else {
					JOptionPane.showMessageDialog(null, "seleccione um livro da lista");
				}
			}
		});

		txtLivroSelecSTATS = new JTextField();
		txtLivroSelecSTATS.setEditable(false);
		txtLivroSelecSTATS.setBounds(193, 67, 152, 33);
		jpAdmEstatisticas.add(txtLivroSelecSTATS);
		txtLivroSelecSTATS.setColumns(10);

		JScrollPane scrollVendasMontante = new JScrollPane();
		scrollVendasMontante.setBounds(360, 67, 230, 467);
		jpAdmEstatisticas.add(scrollVendasMontante);

		tabelaVendasMontante = new JTable(modeloVendasMontante);
		tabelaVendasMontante.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaVendasMontante.setAutoCreateRowSorter(true);
		scrollVendasMontante.setViewportView(tabelaVendasMontante);

		JScrollPane scrollLivroVendas = new JScrollPane();
		scrollLivroVendas.setBounds(600, 67, 341, 467);
		jpAdmEstatisticas.add(scrollLivroVendas);

		tabelaLivroVendas = new JTable(modeloLivroVendas);
		tabelaLivroVendas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaLivroVendas.setAutoCreateRowSorter(true);
		scrollLivroVendas.setViewportView(tabelaLivroVendas);
		JList<String> alteracoesPrecos = new JList<String>(modeloListaPrecos);
		alteracoesPrecos.setBounds(193, 114, 150, 420);
		jpAdmEstatisticas.add(alteracoesPrecos);
		
		JLabel lblVendas = new JLabel("Vendas");
		lblVendas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVendas.setBounds(365, 35, 152, 31);
		jpAdmEstatisticas.add(lblVendas);
		jpAdmEstatisticas.setVisible(false);

		
		
		JPanel jpAdmLivros = new JPanel();
		jpAdmLivros.setBounds(0, 0, 763, 545);
		panelPrincipal.add(jpAdmLivros);
		jpAdmLivros.setVisible(false);
		jpAdmLivros.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(394, 283, 345, 133);
		jpAdmLivros.add(scrollPane_3);

		JTextArea txtDescricaoLivros = new JTextArea();
		txtDescricaoLivros.setLineWrap(true);
		scrollPane_3.setViewportView(txtDescricaoLivros);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(629, 60, 97, 38);
		btnCancelar.setBackground(new Color(255, 204, 102));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTituloLivros.setEditable(false);
				txtAutorLivros.setEditable(false);
				txtStockLivros.setEditable(false);
				txtDescricaoLivros.setEditable(false);
				txtAnoLivros.setEditable(false);
				txtPrecoLivros.setEditable(false);
			}

		});
		jpAdmLivros.add(btnCancelar);

		JComboBox<String> cbCriterioPesquisaLIVROS = new JComboBox<String>();
		cbCriterioPesquisaLIVROS.setBounds(12, 57, 200, 30);
		jpAdmLivros.add(cbCriterioPesquisaLIVROS);

		JLabel lblNewLabel = new JLabel("T\u00EDtulo:");
		lblNewLabel.setBounds(334, 162, 48, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmLivros.add(lblNewLabel);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(334, 203, 48, 16);
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmLivros.add(lblAutor);

		JLabel lblDescrio = new JLabel("Ano:");
		lblDescrio.setBounds(341, 247, 40, 16);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmLivros.add(lblDescrio);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(334, 484, 48, 16);
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmLivros.add(lblStock);

		JLabel lblPreo_1 = new JLabel("Pre\u00E7o:");
		lblPreo_1.setBounds(334, 433, 48, 16);
		lblPreo_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmLivros.add(lblPreo_1);

		JLabel lblPreo = new JLabel("Descri\u00E7\u00E3o:");
		lblPreo.setBounds(297, 286, 87, 16);
		lblPreo.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmLivros.add(lblPreo);

		txtTituloLivros = new JTextField();
		txtTituloLivros.setBounds(395, 157, 264, 30);
		txtTituloLivros.setEditable(false);
		txtTituloLivros.setColumns(10);
		jpAdmLivros.add(txtTituloLivros);

		txtAutorLivros = new JTextField();
		txtAutorLivros.setBounds(395, 198, 233, 30);
		txtAutorLivros.setEditable(false);
		txtAutorLivros.setColumns(10);
		jpAdmLivros.add(txtAutorLivros);

		txtAnoLivros = new JTextField();
		txtAnoLivros.setBounds(394, 242, 86, 30);
		txtAnoLivros.setEditable(false);
		txtAnoLivros.setColumns(10);
		jpAdmLivros.add(txtAnoLivros);

		txtPrecoLivros = new JTextField();
		txtPrecoLivros.setBounds(394, 428, 86, 30);
		txtPrecoLivros.setEditable(false);
		txtPrecoLivros.setColumns(10);
		jpAdmLivros.add(txtPrecoLivros);

		txtStockLivros = new JTextField();
		txtStockLivros.setBounds(394, 479, 86, 30);
		txtStockLivros.setEditable(false);
		txtStockLivros.setColumns(10);
		jpAdmLivros.add(txtStockLivros);

		JButton btnPesquisarLivro = new JButton("Pesquisar");
		btnPesquisarLivro.setBounds(224, 60, 97, 25);
		btnPesquisarLivro.setBackground(SystemColor.controlHighlight);
		jpAdmLivros.add(btnPesquisarLivro);

		JButton btnLimparLivro = new JButton("Limpar");
		btnLimparLivro.setBounds(224, 89, 97, 25);

		btnLimparLivro.setBackground(SystemColor.controlHighlight);
		jpAdmLivros.add(btnLimparLivro);

		txtPesquisaLIVROS = new JTextField();
		txtPesquisaLIVROS.setBounds(12, 90, 200, 23);
		jpAdmLivros.add(txtPesquisaLIVROS);
		txtPesquisaLIVROS.setColumns(10);
		cbCriterioPesquisaLIVROS.addItem("Titulo");
		cbCriterioPesquisaLIVROS.addItem("Autor");
		cbCriterioPesquisaLIVROS.addItem("Id");

		JRadioButton rbAlterarLivro = new JRadioButton("Alterar os dados do livro seleccionado");
		rbAlterarLivro.setBounds(341, 42, 220, 23);
		rbGroupLIVROS.add(rbAlterarLivro);
		jpAdmLivros.add(rbAlterarLivro);

		JRadioButton rbCriarLivro = new JRadioButton("Criar novo livro");
		rbCriarLivro.setBounds(341, 16, 187, 23);
		rbGroupLIVROS.add(rbCriarLivro);
		jpAdmLivros.add(rbCriarLivro);

		JRadioButton rbRemoverLivro = new JRadioButton("Remover o livro seleccionado da loja");
		rbRemoverLivro.setBounds(341, 68, 245, 23);
		rbGroupLIVROS.add(rbRemoverLivro);
		jpAdmLivros.add(rbRemoverLivro);

		JButton btnConfirmarAlteracoesLIVROS = new JButton("Confirmar");
		btnConfirmarAlteracoesLIVROS.setBounds(543, 433, 143, 38);
		btnConfirmarAlteracoesLIVROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String titulo = txtTituloLivros.getText();
				String autor = txtAutorLivros.getText();
				String stock = txtStockLivros.getText();
				String descricao = txtDescricaoLivros.getText();
				String ano = txtAnoLivros.getText();
				String preco = txtPrecoLivros.getText();

				if (rbAlterarLivro.isSelected() || rbRemoverLivro.isSelected()) {

					if (!tabelaLivrosLIVROS.getSelectionModel().isSelectionEmpty()) {
						int linha = tabelaLivrosLIVROS.convertRowIndexToModel(tabelaLivrosLIVROS.getSelectedRow());
						int idLivroSelec = (int) tabelaLivrosLIVROS.getModel().getValueAt(linha, 0);

						Livro l = gl.viewComics.livroId(idLivroSelec);
						// alterarLivro
						if (rbAlterarLivro.isSelected()) {
							if ((!titulo.isEmpty()) && (!autor.isEmpty()) && (!stock.isEmpty()) && (!ano.isEmpty())
									&& (!preco.isEmpty())) {

								double precoAntigo = l.getPreco();

								gl.viewComics.alterarLivro(idLivroSelec, titulo, autor, preco, stock, ano, descricao);
								// guarda o preco no arrayList de historico de precos do livro em questao
								double precoNovo = Double.parseDouble(txtPrecoLivros.getText());
								if (precoNovo != precoAntigo) {
									Preco p = new Preco(precoNovo);
									gl.viewComics.updatePrecoLivro(idLivroSelec, p);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios por favor");
							}
						} else if (rbRemoverLivro.isSelected()) {
							gl.viewComics.removerLivro(idLivroSelec, gl.viewComics.getLivros());
						}
					}
				}

				else if (rbCriarLivro.isSelected()) {
					if ((!titulo.isEmpty()) && (!autor.isEmpty()) && (!stock.isEmpty()) && (!ano.isEmpty())
							&& (!preco.isEmpty())) {
						Livro novoLivro = new Livro(titulo, autor, Double.parseDouble(preco), Integer.parseInt(stock),
								Integer.parseInt(ano), txtDescricaoLivros.getText());
						gl.viewComics.addLivro(novoLivro);
					} else {
						JOptionPane.showMessageDialog(null, "Certifique-se que preencheu todos os campos obrigatorios");
					}
				}
				txtPesquisaLIVROS.setText("");
				txtIdLivros.setText("");
				txtTituloLivros.setText("");
				txtAutorLivros.setText("");
				txtStockLivros.setText("");
				txtPrecoLivros.setText("");
				txtDescricaoLivros.setText("");
				txtAnoLivros.setText("");
				txtTituloLivros.setEditable(false);
				txtAutorLivros.setEditable(false);
				txtStockLivros.setEditable(false);
				txtDescricaoLivros.setEditable(false);
				txtAnoLivros.setEditable(false);
				txtPrecoLivros.setEditable(false);

				modeloTabelaLivrosLIVROS.setRowCount(0);
				gl.viewComics.livrosTabela(modeloTabelaLivrosLIVROS);
			}
		});
		jpAdmLivros.add(btnConfirmarAlteracoesLIVROS);

		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(334, 124, 31, 16);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmLivros.add(lblId);

		txtIdLivros = new JTextField();
		txtIdLivros.setBounds(395, 116, 73, 30);
		txtIdLivros.setEditable(false);
		txtIdLivros.setColumns(10);
		jpAdmLivros.add(txtIdLivros);

		JButton btnNewButton = new JButton("<HTML>Permitir alteracoes<HTML>");
		btnNewButton.setBounds(629, 13, 97, 42);
		btnNewButton.setBackground(new Color(204, 255, 153));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbCriarLivro.isSelected()) {
					txtIdLivros.setText("");
					txtTituloLivros.setText("");
					txtAutorLivros.setText("");
					txtStockLivros.setText("");
					txtDescricaoLivros.setText("");
					txtAnoLivros.setText("");
					txtPrecoLivros.setText("");
				}
				txtTituloLivros.setEditable(true);
				txtAutorLivros.setEditable(true);
				txtStockLivros.setEditable(true);
				txtDescricaoLivros.setEditable(true);
				txtAnoLivros.setEditable(true);
				txtPrecoLivros.setEditable(true);
			}
		});
		jpAdmLivros.add(btnNewButton);

		JLabel label = new JLabel("*");
		label.setBounds(662, 165, 25, 14);
		jpAdmLivros.add(label);

		JLabel label_4 = new JLabel("*");
		label_4.setBounds(633, 201, 25, 14);
		jpAdmLivros.add(label_4);

		JLabel label_8 = new JLabel("*");
		label_8.setBounds(490, 250, 25, 14);
		jpAdmLivros.add(label_8);

		JLabel label_11 = new JLabel("*");
		label_11.setBounds(490, 436, 25, 14);
		jpAdmLivros.add(label_11);

		JLabel label_17 = new JLabel("*");
		label_17.setBounds(490, 487, 25, 14);
		jpAdmLivros.add(label_17);

		JLabel lblCamposDe = new JLabel("(*) campos de preenchimento obrigatorio");
		lblCamposDe.setBounds(543, 471, 220, 14);
		lblCamposDe.setFont(new Font("Tahoma", Font.PLAIN, 9));
		jpAdmLivros.add(lblCamposDe);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 124, 277, 397);
		jpAdmLivros.add(scrollPane);

		tabelaLivrosLIVROS = new JTable(modeloTabelaLivrosLIVROS);
		tabelaLivrosLIVROS.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaLivrosLIVROS.setAutoCreateRowSorter(true);
		tabelaLivrosLIVROS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(tabelaLivrosLIVROS.getSelectedRow());
				int linha = tabelaLivrosLIVROS.convertRowIndexToModel(tabelaLivrosLIVROS.getSelectedRow());
				System.out.println(linha);
				int idLivro = (int) tabelaLivrosLIVROS.getModel().getValueAt(linha, 0);
				System.out.println(idLivro);
				Livro l = gl.viewComics.livroId(idLivro);
				txtIdLivros.setText(Integer.toString(idLivro));
				txtTituloLivros.setText(l.getTitulo());
				txtAutorLivros.setText(l.getAutor());
				txtAnoLivros.setText(Integer.toString(l.getAno()));
				txtPrecoLivros.setText(Double.toString(l.getPreco()));
				txtStockLivros.setText(Integer.toString(l.getStock()));
				txtDescricaoLivros.setText(l.getDescricao());
			}
		});
		scrollPane.setViewportView(tabelaLivrosLIVROS);

		JComboBox cbCriterioOrdenacaoLIVROS = new JComboBox();
		cbCriterioOrdenacaoLIVROS.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String seleccao = (String) cbCriterioOrdenacaoLIVROS.getSelectedItem();

			}
		});
		cbCriterioOrdenacaoLIVROS.setBounds(163, 24, 158, 25);
		jpAdmLivros.add(cbCriterioOrdenacaoLIVROS);
		cbCriterioOrdenacaoLIVROS.addItem("Titulo");
		cbCriterioOrdenacaoLIVROS.addItem("ID");

		JLabel lblCriterioDeOrdenacao = new JLabel("criterio de ordenacao :");
		lblCriterioDeOrdenacao.setBounds(36, 24, 117, 25);
		jpAdmLivros.add(lblCriterioDeOrdenacao);

		// pesquisar livros consoante os atributos
		btnPesquisarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String criterioPesquisa = (String) cbCriterioPesquisaLIVROS.getSelectedItem();
				String pesquisa = txtPesquisaLIVROS.getText();
				modeloTabelaLivrosLIVROS.setRowCount(0);
				gl.viewComics.tabelaLivrosCriterioSeleccao(modeloTabelaLivrosLIVROS, criterioPesquisa, pesquisa);

			}
		});
		// bot�o limpar
		btnLimparLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPesquisaLIVROS.setText("");
				txtIdLivros.setText("");
				txtTituloLivros.setText("");
				txtAutorLivros.setText("");
				txtStockLivros.setText("");
				txtPrecoLivros.setText("");
				txtDescricaoLivros.setText("");
				txtAnoLivros.setText("");

//				modeloListaLivros.removeAllElements();
//				gl.viewComics.addArrayLista(gl.viewComics.arrayLivros(gl.viewComics.getLivros()), modeloListaLivros);

			}
		});

		jpAdmGestaoUtil = new JPanel();
		jpAdmGestaoUtil.setBounds(0, 0, 763, 545);
		panelPrincipal.add(jpAdmGestaoUtil);
		jpAdmGestaoUtil.setVisible(false);
		jpAdmGestaoUtil.setLayout(null);
		txtPesquisaUTILIZADOR = new JTextField();
		txtPesquisaUTILIZADOR.setBounds(10, 93, 200, 30);
		txtPesquisaUTILIZADOR.setColumns(10);
		jpAdmGestaoUtil.add(txtPesquisaUTILIZADOR);
		JButton btnPesquisaFunc = new JButton("Pesquisar");
		btnPesquisaFunc.setBounds(220, 59, 97, 25);
		btnPesquisaFunc.setBackground(SystemColor.controlHighlight);
		jpAdmGestaoUtil.add(btnPesquisaFunc);
		JButton btnLimparPesquisaFunc = new JButton("Limpar");
		btnLimparPesquisaFunc.setBounds(220, 96, 64, 25);
		btnLimparPesquisaFunc.setBackground(SystemColor.controlHighlight);
		jpAdmGestaoUtil.add(btnLimparPesquisaFunc);
		JLabel lblIdFuncionrio = new JLabel("Id funcion\u00E1rio :");
		lblIdFuncionrio.setBounds(319, 201, 119, 22);
		lblIdFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmGestaoUtil.add(lblIdFuncionrio);
		txtIdFunc = new JTextField();
		txtIdFunc.setBounds(448, 199, 76, 30);
		txtIdFunc.setEditable(false);
		txtIdFunc.setColumns(10);
		jpAdmGestaoUtil.add(txtIdFunc);
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(332, 234, 64, 25);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmGestaoUtil.add(lblNome);

		txtNomeUTILIZADOR = new JTextField();
		txtNomeUTILIZADOR.setBounds(408, 234, 345, 30);
		txtNomeUTILIZADOR.setEditable(false);
		txtNomeUTILIZADOR.setColumns(10);
		jpAdmGestaoUtil.add(txtNomeUTILIZADOR);

		JLabel lblContacto = new JLabel("Contacto :");
		lblContacto.setBounds(315, 271, 87, 24);
		lblContacto.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmGestaoUtil.add(lblContacto);

		txtContactoUTILIZADOR = new JTextField();
		txtContactoUTILIZADOR.setBounds(407, 270, 345, 30);
		txtContactoUTILIZADOR.setEditable(false);
		txtContactoUTILIZADOR.setColumns(10);
		jpAdmGestaoUtil.add(txtContactoUTILIZADOR);

		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(305, 316, 97, 16);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmGestaoUtil.add(lblUsername);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(305, 355, 97, 21);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmGestaoUtil.add(lblPassword);

		txtUsernameUTILIZADOR = new JTextField();
		txtUsernameUTILIZADOR.setBounds(407, 311, 345, 30);
		txtUsernameUTILIZADOR.setEditable(false);
		txtUsernameUTILIZADOR.setColumns(10);
		jpAdmGestaoUtil.add(txtUsernameUTILIZADOR);

		txtPassUTILIZADOR = new JTextField();
		txtPassUTILIZADOR.setBounds(407, 352, 345, 30);
		txtPassUTILIZADOR.setEditable(false);
		txtPassUTILIZADOR.setColumns(10);
		jpAdmGestaoUtil.add(txtPassUTILIZADOR);

		JComboBox<String> cbPesquisaUTILIZADOR = new JComboBox<String>();
		cbPesquisaUTILIZADOR.setBounds(10, 60, 200, 22);
		jpAdmGestaoUtil.add(cbPesquisaUTILIZADOR);

		JButton btnCancelarFunc = new JButton("Cancelar");
		btnCancelarFunc.setBounds(594, 411, 89, 23);
		btnCancelarFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNomeUTILIZADOR.setText("");
				txtContactoUTILIZADOR.setText("");
				txtPassUTILIZADOR.setText("");
				txtUsernameUTILIZADOR.setText("");
				txtIdFunc.setText("");
				txtNomeUTILIZADOR.setEditable(false);
				txtContactoUTILIZADOR.setEditable(false);
				txtPassUTILIZADOR.setEditable(false);
				txtUsernameUTILIZADOR.setEditable(false);

			}
		});
		btnCancelarFunc.setBackground(SystemColor.controlHighlight);
		jpAdmGestaoUtil.add(btnCancelarFunc);
		cbPesquisaUTILIZADOR.addItem("Nome");
		cbPesquisaUTILIZADOR.addItem("Id");
		cbPesquisaUTILIZADOR.addItem("Username");
		cbPesquisaUTILIZADOR.addItem("Contacto");

		JRadioButton rbAdicionarFUNCIONARIO = new JRadioButton("Adicionar funcionario ");
		rbAdicionarFUNCIONARIO.setBounds(305, 159, 164, 23);
		rbGroupUtilizadores.add(rbAdicionarFUNCIONARIO);
		jpAdmGestaoUtil.add(rbAdicionarFUNCIONARIO);

		JRadioButton rbAlterarUTILIZADOR = new JRadioButton("Alterar dados do utilizador seleccionado");
		rbAlterarUTILIZADOR.setBounds(502, 131, 232, 23);
		rbGroupUtilizadores.add(rbAlterarUTILIZADOR);
		jpAdmGestaoUtil.add(rbAlterarUTILIZADOR);

		JRadioButton rbRemoverUTILIZADOR = new JRadioButton("Remover utilizador seleccionado");
		rbRemoverUTILIZADOR.setBounds(502, 159, 215, 23);
		rbGroupUtilizadores.add(rbRemoverUTILIZADOR);
		jpAdmGestaoUtil.add(rbRemoverUTILIZADOR);

		JButton btnLimparCamposFUNCIONARIO = new JButton("Permitir alteracao dos campos");
		btnLimparCamposFUNCIONARIO.setBounds(538, 200, 215, 23);
		btnLimparCamposFUNCIONARIO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNomeUTILIZADOR.setEditable(true);
				txtContactoUTILIZADOR.setEditable(true);
				txtUsernameUTILIZADOR.setEditable(true);
				txtPassUTILIZADOR.setEditable(true);
				if (rbAdicionarFUNCIONARIO.isSelected()) {
					if (rbAdicionarFUNCIONARIO.isSelected())
						txtIdFunc.setText("");
					txtNomeUTILIZADOR.setText("");
					txtContactoUTILIZADOR.setText("");
					txtUsernameUTILIZADOR.setText("");
					txtPassUTILIZADOR.setText("");

				}
			}
		});
		jpAdmGestaoUtil.add(btnLimparCamposFUNCIONARIO);

		JRadioButton rbAdicionarAdministrador = new JRadioButton("Adicionar um administrador");
		rbAdicionarAdministrador.setBounds(305, 131, 173, 23);
		rbGroupUtilizadores.add(rbAdicionarAdministrador);
		jpAdmGestaoUtil.add(rbAdicionarAdministrador);
		btnLimparPesquisaFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloTabelaUTILIZADORES.setRowCount(0);
				gl.viewComics.tabelaUtilizadores(modeloTabelaUTILIZADORES);
			}
		});

		JButton btnConfirmarFUNCIONARIOS2 = new JButton("Confirmar");
		btnConfirmarFUNCIONARIOS2.setBounds(460, 411, 89, 23);
		btnConfirmarFUNCIONARIOS2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String nome = txtNomeUTILIZADOR.getText();
				String contacto = txtContactoUTILIZADOR.getText();
				String username = txtUsernameUTILIZADOR.getText();
				String password = txtPassUTILIZADOR.getText();

				if (rbAdicionarFUNCIONARIO.isSelected()) {
					Funcionario f = new Funcionario(nome, contacto, username, password);
					gl.viewComics.addUtilizador(f);
				} else if (rbAdicionarAdministrador.isSelected()) {
					Administrador a = new Administrador(nome, contacto, username, password);
					gl.viewComics.addUtilizador(a);
				} else if (rbAlterarUTILIZADOR.isSelected()) {

					if (!tabelaUtilizadores.getSelectionModel().isSelectionEmpty()) {
						int idUtil = (int) tabelaUtilizadores.getModel().getValueAt(tabelaUtilizadores.getSelectedRow(),
								0);
						gl.viewComics.alterarUtilizador(idUtil, nome, contacto, usernameLogado, password);
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione o utilizador da lista que deseja alterar");
					}
				} else if (rbRemoverUTILIZADOR.isSelected()) {

					if (!tabelaUtilizadores.getSelectionModel().isSelectionEmpty()) {
						int idUtil = (int) tabelaUtilizadores.getModel().getValueAt(tabelaUtilizadores.getSelectedRow(),
								0);
						gl.viewComics.removerUtil(idUtil);
					} else {
						JOptionPane.showMessageDialog(null,
								"Seleccione o utilizador da lista que deseja remover da loja");
					}

				}
				modeloTabelaUTILIZADORES.setRowCount(0);
				gl.viewComics.tabelaUtilizadores(modeloTabelaUTILIZADORES);
				tabelaUtilizadores.getSelectionModel().isSelectionEmpty();
				txtNomeUTILIZADOR.setEditable(false);
				txtContactoUTILIZADOR.setEditable(false);
				txtUsernameUTILIZADOR.setEditable(false);
				txtPassUTILIZADOR.setEditable(false);
			}
		});
		jpAdmGestaoUtil.add(btnConfirmarFUNCIONARIOS2);

		JScrollPane scrollUtilizadores = new JScrollPane();
		scrollUtilizadores.setBounds(10, 137, 272, 382);
		jpAdmGestaoUtil.add(scrollUtilizadores);
		tabelaUtilizadores = new JTable(modeloTabelaUTILIZADORES);
		tabelaUtilizadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollUtilizadores.setViewportView(tabelaUtilizadores);
		tabelaUtilizadores.setAutoCreateRowSorter(true);
		tabelaUtilizadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!tabelaUtilizadores.getSelectionModel().isSelectionEmpty()) {
					int linha = tabelaUtilizadores.convertRowIndexToModel(tabelaUtilizadores.getSelectedRow());
					int idUtil = (int) tabelaUtilizadores.getModel().getValueAt(linha, 0);
					Utilizador u = gl.viewComics.devolveUtilizador(idUtil);
					txtIdFunc.setText(Integer.toString(idUtil));
					txtNomeUTILIZADOR.setText(u.getNome());
					txtContactoUTILIZADOR.setText(u.getContato());
					txtUsernameUTILIZADOR.setText(u.getUsername());
					txtPassUTILIZADOR.setText(u.getPassword());
				}
			}
		});

		// pesquisar funcionarios por atributos
		btnPesquisaFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloTabelaUTILIZADORES.setRowCount(0);
				String seleccao = (String) cbPesquisaUTILIZADOR.getSelectedItem();
				String pesquisa = txtPesquisaUTILIZADOR.getText();
				gl.viewComics.tabelaUtilizadoresCriterioSeleccao(modeloTabelaUTILIZADORES, seleccao, pesquisa);

			}
		});
		gl.viewComics.tabelaVendaMontante(modeloVendasMontante);
		gl.viewComics.tabelaLivrosVendas(modeloLivroVendas);
		gl.viewComics.livrosTabela(modeloTabelaLivrosLIVROS);
		gl.viewComics.tabelaUtilizadores(modeloTabelaUTILIZADORES);

		JPanel jpAdmConta = new JPanel();
		jpAdmConta.setBackground(SystemColor.menu);
		jpAdmConta.setBounds(0, 0, 763, 545);
		panelPrincipal.add(jpAdmConta);
		jpAdmConta.setLayout(null);
		jpAdmConta.setVisible(false);

		JLabel lblAlterarUsername = new JLabel("Alterar Username:");
		lblAlterarUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAlterarUsername.setAlignmentX(0.5f);
		lblAlterarUsername.setBounds(105, 48, 203, 31);
		jpAdmConta.add(lblAlterarUsername);

		JLabel label_1 = new JLabel("UserName:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(67, 92, 113, 24);
		jpAdmConta.add(label_1);

		txtUsernameALTERARUSER = new JTextField(usernameLogado);
		txtUsernameALTERARUSER.setEditable(false);
		txtUsernameALTERARUSER.setBounds(67, 129, 279, 31);
		jpAdmConta.add(txtUsernameALTERARUSER);

		JLabel label_2 = new JLabel("Password:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(67, 173, 113, 24);
		jpAdmConta.add(label_2);

		JLabel label_3 = new JLabel("Novo UserName:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(67, 254, 171, 24);
		jpAdmConta.add(label_3);

		txtNovoUsernameALTERAUSER = new JTextField();
		txtNovoUsernameALTERAUSER.setBounds(67, 284, 279, 31);
		jpAdmConta.add(txtNovoUsernameALTERAUSER);

		JButton btnConfirmarALTERAUSER = new JButton("Confirmar");
		btnConfirmarALTERAUSER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = txtUsernameALTERARUSER.getText();
				char[] pass = txtPasswordALTERAUSER.getPassword();
				String novoUsername = txtNovoUsernameALTERAUSER.getText();
				gl.viewComics.alterarUsername(username, pass, novoUsername);
				txtPasswordALTERAUSER.setText("");
				txtNovoUsernameALTERAUSER.setText("");
			}
		});
		btnConfirmarALTERAUSER.setBackground(SystemColor.controlHighlight);
		btnConfirmarALTERAUSER.setBounds(67, 359, 97, 25);
		jpAdmConta.add(btnConfirmarALTERAUSER);

		JButton btnCancelarALTERAUSER = new JButton("Cancelar");
		btnCancelarALTERAUSER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPasswordALTERAUSER.setText("");
				txtNovoUsernameALTERAUSER.setText("");
			}
		});
		btnCancelarALTERAUSER.setBackground(SystemColor.controlHighlight);
		btnCancelarALTERAUSER.setBounds(249, 359, 97, 25);
		jpAdmConta.add(btnCancelarALTERAUSER);

		JLabel lblAlterarPassword = new JLabel("Alterar Password:");
		lblAlterarPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAlterarPassword.setAlignmentX(0.5f);
		lblAlterarPassword.setBounds(432, 48, 203, 31);
		jpAdmConta.add(lblAlterarPassword);

		JLabel label_5 = new JLabel("Password:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(432, 90, 113, 24);
		jpAdmConta.add(label_5);

		txtPasswordALTERAPASS = new JPasswordField();
		txtPasswordALTERAPASS.setBounds(432, 127, 279, 31);
		jpAdmConta.add(txtPasswordALTERAPASS);

		JLabel label_9 = new JLabel("Nova Password:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_9.setBounds(432, 171, 113, 24);
		jpAdmConta.add(label_9);

		JLabel label_10 = new JLabel("Confirmar Password:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_10.setBounds(432, 252, 171, 24);
		jpAdmConta.add(label_10);

		JButton btnConfirmarALTERAPASS = new JButton("Confirmar");
		btnConfirmarALTERAPASS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] passActualALTERAPASS = txtPasswordALTERAPASS.getPassword();
				char[] passNovaALTERAPASS = txtNovaPassALTERAPASS.getPassword();
				char[] passNovaConfirmALTERAPASS = txtConfirmaPassALTERAPASS.getPassword();
				gl.viewComics.alterarPassword(usernameLogado, passActualALTERAPASS, passNovaALTERAPASS,
						passNovaConfirmALTERAPASS);
				txtPasswordALTERAPASS.setText("");
				txtNovaPassALTERAPASS.setText("");
				txtConfirmaPassALTERAPASS.setText("");

			}
		});
		btnConfirmarALTERAPASS.setBackground(SystemColor.controlHighlight);
		btnConfirmarALTERAPASS.setBounds(432, 357, 97, 25);
		jpAdmConta.add(btnConfirmarALTERAPASS);

		JButton btnCancelarALTERAPASS = new JButton("Cancelar");
		btnCancelarALTERAPASS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPasswordALTERAPASS.setText("");
				txtPasswordALTERAPASS.setText("");
				txtPasswordALTERAPASS.setText("");
			}
		});
		btnCancelarALTERAPASS.setBackground(SystemColor.controlHighlight);
		btnCancelarALTERAPASS.setBounds(588, 357, 97, 25);
		jpAdmConta.add(btnCancelarALTERAPASS);

		txtPasswordALTERAUSER = new JPasswordField();
		txtPasswordALTERAUSER.setBounds(67, 213, 279, 30);
		jpAdmConta.add(txtPasswordALTERAUSER);

		txtNovaPassALTERAPASS = new JPasswordField();
		txtNovaPassALTERAPASS.setBounds(432, 206, 279, 31);
		jpAdmConta.add(txtNovaPassALTERAPASS);

		txtConfirmaPassALTERAPASS = new JPasswordField();
		txtConfirmaPassALTERAPASS.setBounds(432, 285, 279, 29);
		jpAdmConta.add(txtConfirmaPassALTERAPASS);

		// encaminhar para os respectivos paineis ao clicar nos botoes

		btnLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jpAdmEstatisticas.setVisible(false);
				jpAdmLivros.setVisible(true);
				jpAdmConta.setVisible(false);
				jpAdmGestaoUtil.setVisible(false);
			}
		});
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				jpAdmEstatisticas.setVisible(false);
				jpAdmLivros.setVisible(false);
				jpAdmConta.setVisible(false);
				jpAdmGestaoUtil.setVisible(true);
			}
		});

		btnEstatisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				jpAdmEstatisticas.setVisible(true);
				jpAdmLivros.setVisible(false);
				jpAdmConta.setVisible(false);
				jpAdmGestaoUtil.setVisible(false);
			}
		});
		btnGestao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				jpAdmEstatisticas.setVisible(false);
				jpAdmLivros.setVisible(false);
				jpAdmConta.setVisible(true);
				jpAdmGestaoUtil.setVisible(false);
			}
		});

		// logOut

		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				gl.atualizaficheiro(gl.getViewComics().getUtilizadores(), gl.getViewComics().getCarrinhos(),
						gl.getViewComics().getLivros(), gl.getViewComics().getVendas());

				AppCliente clt = new AppCliente();
				clt.run();
				frame.setVisible(false);
			}
		});

		// mudar a cor de um botao ao passar o cursor do rato

		// mudar a cor dos botoes ao passar o rato (mouseEntered & mouseClicked)
		// deixar a cor fixa ao clicar(mouse Clicked)
		// retirar a cor do anterior ao clicar em outro bot�o(mouse Clicked)

		// Livros

		btnLivros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnLivros.setBackground(Color.YELLOW);
			}

			public void mouseExited(MouseEvent arg0) {
				btnLivros.setBackground(SystemColor.controlHighlight);
			}

			public void mouseClicked(MouseEvent arg0) {
				btnLivros.setBackground(Color.YELLOW);
				btnGestao.setBackground(SystemColor.controlHighlight);
				btnFuncionarios.setBackground(SystemColor.controlHighlight);
				btnEstatisticas.setBackground(SystemColor.controlHighlight);
			}
		});

		// GestaoConta

		btnGestao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnGestao.setBackground(Color.YELLOW);
			}

			public void mouseExited(MouseEvent arg0) {

				btnGestao.setBackground(SystemColor.controlHighlight);
			}

			public void mouseClicked(MouseEvent arg0) {
				btnGestao.setBackground(Color.YELLOW);
				btnLivros.setBackground(SystemColor.controlHighlight);
				btnFuncionarios.setBackground(SystemColor.controlHighlight);
				btnEstatisticas.setBackground(SystemColor.controlHighlight);

			}
		});

		// Funcionarios

		btnFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnFuncionarios.setBackground(Color.YELLOW);
			}

			public void mouseExited(MouseEvent arg0) {
				btnFuncionarios.setBackground(SystemColor.controlHighlight);
			}

			public void mouseClicked(MouseEvent arg0) {
				btnFuncionarios.setBackground(Color.YELLOW);
				btnLivros.setBackground(SystemColor.controlHighlight);
				btnGestao.setBackground(SystemColor.controlHighlight);
				btnEstatisticas.setBackground(SystemColor.controlHighlight);
			}

		});

		// Estatisticas

		btnEstatisticas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnEstatisticas.setBackground(Color.YELLOW);
			}

			public void mouseExited(MouseEvent arg0) {
				btnEstatisticas.setBackground(SystemColor.controlHighlight);

			}

			public void mouseClicked(MouseEvent arg0) {

				btnEstatisticas.setBackground(Color.YELLOW);
				btnLivros.setBackground(SystemColor.controlHighlight);
				btnFuncionarios.setBackground(SystemColor.controlHighlight);
				btnGestao.setBackground(SystemColor.controlHighlight);
			}

		});

		// adicionar um funcionario � lista

	}
}
