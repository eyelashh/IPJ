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
import javax.swing.event.ListSelectionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;

public class AppAdmin implements Serializable {

	private JFrame frame;
	private JPanel jpAdmFuncionarios;
	private JTextField txtAtributoPesquisaLivro;
	private JTextField txtTituloLivros;
	private JTextField txtAutorLivros;
	private JTextField txtAnoLivros;
	private JTextField txtPrecoLivros;
	private JTextField txtStockLivros;
	private JTextField txtUsernameALTERARUSER;
	private JTextField txtNovoUsernameALTERAUSER;
	private JPasswordField txtPasswordALTERAPASS;
	private JTextField txtAtributoSTOCK;
	private JTextField txtTituloSTOCK;
	private JTextField txtAutorSTOCK;
	private JTextField txtAnoSTOCK;
	private JTextField txtDescricaoSTOCK;
	private JTextField txtPrecoSTOCK;
	private JTextField txtAtributoFunc;
	private JTextField txtIdFunc;
	private JTextField txtNomeFunc;
	private JTextField txtContactoFunc;
	private JTextField txtUsernameFunc;
	private JTextField txtPassFunc;
	private static Utilizador admin;
	private static GestaoLivraria gl;
	private JTextField txtTESTE;
	private JTextField txtAtributoLivro;
	private JTextField txtIdLivros;
	private JTextField txtStockSTOCK;
	private JTextField txtAlterarStock;
	private final ButtonGroup rbGroupSTOCK = new ButtonGroup();
	private JPasswordField txtPasswordALTERAUSER;
	private JPasswordField txtNovaPassALTERAPASS;
	private JPasswordField txtConfirmaPassALTERAPASS;
	private final ButtonGroup rbGroupLIVROS = new ButtonGroup();
	private final ButtonGroup rbGroupFUNCIONARIOS = new ButtonGroup();
	private JTextField txtIdLivroSTOCK;

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
						gl.getViewComics().getLivros());
			}
		});
		DefaultListModel<String> modeloListaLivros = new DefaultListModel<String>();
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
		JButton btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.setForeground(Color.BLACK);
		btnFuncionarios.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		btnFuncionarios.setBackground(SystemColor.controlHighlight);
		btnFuncionarios.setBounds(25, 81, 176, 60);
		panelMenu.add(btnFuncionarios);
		JButton btnStock = new JButton("Gest\u00E3o Stock");
		btnStock.setForeground(Color.BLACK);
		btnStock.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		btnStock.setBackground(SystemColor.controlHighlight);
		btnStock.setBounds(25, 154, 176, 60);
		panelMenu.add(btnStock);
		JButton btnEstatisticas = new JButton("Estatisticas");
		btnEstatisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEstatisticas.setForeground(Color.BLACK);
		btnEstatisticas.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnEstatisticas.setBackground(SystemColor.controlHighlight);
		btnEstatisticas.setBounds(25, 227, 176, 60);
		panelMenu.add(btnEstatisticas);
		JButton btnGestao = new JButton("Gestao Conta");
		btnGestao.setForeground(Color.BLACK);
		btnGestao.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		btnGestao.setBackground(SystemColor.controlHighlight);
		btnGestao.setBounds(25, 300, 176, 60);
		panelMenu.add(btnGestao);
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(240, 176, 1022, 545);
		Paineltotal.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		DefaultListModel<String> modeloListaFUNCIONARIOS = new DefaultListModel<String>();
		
				JPanel jpAdmStock = new JPanel();
				jpAdmStock.setBounds(0, 0, 763, 545);
				panelPrincipal.add(jpAdmStock);
				jpAdmStock.setVisible(false);
				jpAdmStock.setLayout(null);
				
						JComboBox comboBoxAtributosSTOCK = new JComboBox();
						comboBoxAtributosSTOCK.setBounds(12, 13, 200, 30);
						jpAdmStock.add(comboBoxAtributosSTOCK);
						comboBoxAtributosSTOCK.addItem("(seleccione um campo de pesquisa"); // adicionar opcoes � combobox
						// com
						// os atributos de pesquisa
						comboBoxAtributosSTOCK.addItem("Titulo");
						comboBoxAtributosSTOCK.addItem("Autor");
						comboBoxAtributosSTOCK.addItem("Id");
						
								JButton btnPesquisarSTOCK = new JButton("Pesquisar");
								btnPesquisarSTOCK.setBounds(224, 16, 97, 25);
								btnPesquisarSTOCK.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										if (comboBoxAtributosSTOCK.getSelectedItem().equals("Titulo")) {
											modeloListaLivros.removeAllElements();
											String titulo = txtAtributoSTOCK.getText();
											gl.viewComics.addArrayLista(gl.viewComics.listaTitulo(titulo), modeloListaLivros);
										}
										else if (comboBoxAtributosSTOCK.getSelectedItem().equals("Autor")) {
											modeloListaLivros.removeAllElements();
											String autor = txtAtributoSTOCK.getText();
											gl.viewComics.addArrayLista(gl.viewComics.listaAutor(autor), modeloListaLivros);
										}
										else if (comboBoxAtributosSTOCK.getSelectedItem().equals("Id")) {
											modeloListaLivros.removeAllElements();
											String id = txtAtributoSTOCK.getText();
											gl.viewComics.addArrayLista(gl.viewComics.listaLivroId(id), modeloListaLivros);
										}
										else{
											JOptionPane.showMessageDialog(null, "Seleccione um campo para a pesquisa.");
										}

									}
								});
								jpAdmStock.add(btnPesquisarSTOCK);
								
								JScrollPane scrollPane = new JScrollPane();
								scrollPane.setBounds(12, 120, 200, 363);
								jpAdmStock.add(scrollPane);
								JList<String> listaLivrosSTOCK = new JList<String>(modeloListaLivros);
								scrollPane.setViewportView(listaLivrosSTOCK);
								
										listaLivrosSTOCK.addListSelectionListener(new ListSelectionListener() {
											public void valueChanged(ListSelectionEvent arg0) {
												if (!listaLivrosSTOCK.isSelectionEmpty()) {
													String livroSelecionado = listaLivrosSTOCK.getSelectedValue();
													int id = gl.viewComics.obterIdLivro(livroSelecionado);
													Livro l = gl.viewComics.livroId(id);
													txtIdLivroSTOCK.setText(Integer.toString(id));
													txtTituloSTOCK.setText(l.getTitulo());
													txtAutorSTOCK.setText(l.getAutor());
													txtStockSTOCK.setText(Integer.toString(l.getStock()));
													txtPrecoSTOCK.setText("" + l.getPreco());
													txtDescricaoSTOCK.setText(l.getDescricao());
													txtAnoSTOCK.setText("" + l.getAno());
								
												}
											}
										});
								txtAtributoSTOCK = new JTextField();
								txtAtributoSTOCK.setBounds(12, 57, 200, 30);
								txtAtributoSTOCK.setColumns(10);
								jpAdmStock.add(txtAtributoSTOCK);
								
										JButton btnLimparSTOCK = new JButton("Limpar campos");
										btnLimparSTOCK.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
												txtAtributoSTOCK.setText("");
												txtIdLivroSTOCK.setText("");
												txtTituloSTOCK.setText("");
												txtAnoSTOCK.setText("");
												txtDescricaoSTOCK.setText("");
												txtStockSTOCK.setText("");
												txtPrecoSTOCK.setText("");
												txtAlterarStock.setText("");
												modeloListaLivros.removeAllElements();
												gl.viewComics.addArrayLista(gl.viewComics.arrayLivros(gl.viewComics.getLivros()), modeloListaLivros);

											}
										});
										btnLimparSTOCK.setBounds(344, 16, 122, 25);
										jpAdmStock.add(btnLimparSTOCK);
										
												JLabel lblTtulo = new JLabel("T\u00EDtulo :");
												lblTtulo.setBounds(250, 76, 59, 24);
												lblTtulo.setFont(new Font("Tahoma", Font.BOLD, 15));
												jpAdmStock.add(lblTtulo);
												
														txtTituloSTOCK = new JTextField();
														txtTituloSTOCK.setBounds(321, 75, 345, 30);
														txtTituloSTOCK.setEditable(false);
														txtTituloSTOCK.setColumns(10);
														jpAdmStock.add(txtTituloSTOCK);
														
																txtAutorSTOCK = new JTextField();
																txtAutorSTOCK.setBounds(321, 116, 345, 30);
																txtAutorSTOCK.setEditable(false);
																txtAutorSTOCK.setColumns(10);
																jpAdmStock.add(txtAutorSTOCK);
																
																		txtAnoSTOCK = new JTextField();
																		txtAnoSTOCK.setBounds(321, 157, 345, 30);
																		txtAnoSTOCK.setEditable(false);
																		txtAnoSTOCK.setColumns(10);
																		jpAdmStock.add(txtAnoSTOCK);
																		
																				JLabel label_12 = new JLabel("Data:");
																				label_12.setBounds(269, 162, 40, 16);
																				label_12.setFont(new Font("Tahoma", Font.BOLD, 15));
																				jpAdmStock.add(label_12);
																				
																						JLabel label_13 = new JLabel("Autor:");
																						label_13.setBounds(261, 121, 48, 16);
																						label_13.setFont(new Font("Tahoma", Font.BOLD, 15));
																						jpAdmStock.add(label_13);
																						
																								JLabel label_14 = new JLabel("Descri\u00E7\u00E3o:");
																								label_14.setBounds(222, 198, 87, 16);
																								label_14.setFont(new Font("Tahoma", Font.BOLD, 15));
																								jpAdmStock.add(label_14);
																								
																										txtDescricaoSTOCK = new JTextField();
																										txtDescricaoSTOCK.setBounds(321, 198, 345, 117);
																										txtDescricaoSTOCK.setEditable(false);
																										txtDescricaoSTOCK.setColumns(10);
																										jpAdmStock.add(txtDescricaoSTOCK);
																										
																												JLabel label_15 = new JLabel("Pre\u00E7o:");
																												label_15.setBounds(261, 331, 48, 16);
																												label_15.setFont(new Font("Tahoma", Font.BOLD, 15));
																												jpAdmStock.add(label_15);
																												
																														txtPrecoSTOCK = new JTextField();
																														txtPrecoSTOCK.setBounds(321, 326, 87, 30);
																														txtPrecoSTOCK.setEditable(false);
																														txtPrecoSTOCK.setColumns(10);
																														jpAdmStock.add(txtPrecoSTOCK);
																														
																																JLabel label_16 = new JLabel("Stock:");
																																label_16.setBounds(261, 372, 48, 16);
																																label_16.setFont(new Font("Tahoma", Font.BOLD, 15));
																																jpAdmStock.add(label_16);
																																
																																		txtStockSTOCK = new JTextField();
																																		txtStockSTOCK.setBounds(321, 367, 87, 30);
																																		txtStockSTOCK.setEditable(false);
																																		txtStockSTOCK.setColumns(10);
																																		jpAdmStock.add(txtStockSTOCK);
																																		
																																				JRadioButton rbAdicionarStock = new JRadioButton("+");
																																				rbAdicionarStock.setBackground(new Color(173, 255, 47));
																																				rbAdicionarStock.setBounds(492, 387, 40, 16);
																																				rbGroupSTOCK.add(rbAdicionarStock);
																																				jpAdmStock.add(rbAdicionarStock);
																																				
																																						JRadioButton rbRemoverAoStock = new JRadioButton("-");
																																						rbRemoverAoStock.setFont(new Font("Tahoma", Font.BOLD, 11));
																																						rbRemoverAoStock.setBackground(new Color(255, 222, 173));
																																						rbRemoverAoStock.setBounds(492, 362, 40, 16);
																																						rbGroupSTOCK.add(rbRemoverAoStock);
																																						jpAdmStock.add(rbRemoverAoStock);
																																						
																																								txtAlterarStock = new JTextField();
																																								txtAlterarStock.setBounds(438, 362, 48, 41);
																																								txtAlterarStock.setEditable(false);
																																								jpAdmStock.add(txtAlterarStock);
																																								txtAlterarStock.setColumns(10);
																																								
																																										JButton btnConfirmarAlteracaoSTOCK = new JButton("CONFIRMAR");
																																										btnConfirmarAlteracaoSTOCK.setBackground(SystemColor.controlHighlight);
																																										btnConfirmarAlteracaoSTOCK.setBounds(378, 435, 97, 30);
																																										btnConfirmarAlteracaoSTOCK.addActionListener(new ActionListener() {
																																											public void actionPerformed(ActionEvent arg0) {

																																												if (!listaLivrosSTOCK.isSelectionEmpty()) {
																																													String seleccao = listaLivrosSTOCK.getSelectedValue();
																																													String quantidadeActual = txtStockSTOCK.getText();
																																													String quantidadeAlterar = txtAlterarStock.getText();
																																													int quantidadeNovaINT = 0;

																																													if (rbAdicionarStock.isSelected()) {

																																														String quantidadeNova = gl.viewComics.adicionarQuantidade(quantidadeActual, quantidadeAlterar);
																																														quantidadeNovaINT = Integer.valueOf(quantidadeNova);
																																														gl.viewComics.alterarStockLivro(seleccao, quantidadeNovaINT);

																																													} else if (rbRemoverAoStock.isSelected()) {
																																														String quantidadeNova = gl.viewComics.removerQuantidade(quantidadeActual, quantidadeAlterar);
																																														quantidadeNovaINT = Integer.valueOf(quantidadeNova);
																																														if (Integer.parseInt(quantidadeNova) >= 0) {
																																															gl.viewComics.alterarStockLivro(seleccao, quantidadeNovaINT);
																																														} else {
																																															JOptionPane.showMessageDialog(null,
																																																	"A quantidade total n�o poder� ser inferior a zero. Confirme os dados inseridos");
																																															txtStockSTOCK.setText(quantidadeActual);
																																														}
																																													} else {
																																														JOptionPane.showMessageDialog(null,
																																																"Se deseja alterar o stock seleccione a opcao desejada, caso contrario cancele a alteracao");

																																													}

																																													txtAlterarStock.setEditable(false);
																																													txtStockSTOCK.setText(Integer.toString(quantidadeNovaINT));
																																												} else {
																																													JOptionPane.showMessageDialog(null,
																																															"Se deseja alterar o stock seleccione o item, caso contrario cancele a alteracao");
																																												}
																																											}
																																										});
																																										jpAdmStock.add(btnConfirmarAlteracaoSTOCK);
																																												
																																														txtIdLivroSTOCK = new JTextField();
																																														txtIdLivroSTOCK.setEditable(false);
																																														txtIdLivroSTOCK.setColumns(10);
																																														txtIdLivroSTOCK.setBounds(607, 34, 59, 30);
																																														jpAdmStock.add(txtIdLivroSTOCK);
																																														
																																																JLabel lblId_1 = new JLabel("ID :");
																																																lblId_1.setFont(new Font("Tahoma", Font.BOLD, 15));
																																																lblId_1.setBounds(568, 35, 33, 24);
																																																jpAdmStock.add(lblId_1);
																																																
																																																		JButton btnAlterarStock = new JButton("Permitir alteracao de stock");
																																																		btnAlterarStock.setBackground(SystemColor.controlHighlight);
																																																		btnAlterarStock.setBounds(378, 408, 258, 24);
																																																		jpAdmStock.add(btnAlterarStock);
																																																		
																																																				JButton btnCancelar_1 = new JButton("CANCELAR");
																																																				btnCancelar_1.setBackground(SystemColor.controlHighlight);
																																																				btnCancelar_1.addActionListener(new ActionListener() {
																																																					public void actionPerformed(ActionEvent arg0) {
																																																						txtAlterarStock.setText("");
																																																						txtAlterarStock.setEditable(false);
																																																					}
																																																				});
																																																				btnCancelar_1.setBounds(539, 435, 97, 30);
																																																				jpAdmStock.add(btnCancelar_1);
																																																				btnAlterarStock.addActionListener(new ActionListener() {
																																																					public void actionPerformed(ActionEvent arg0) {
																																																						txtAlterarStock.setEditable(true);

																																																					}

																																																				});
		JPanel jpAdmLivros = new JPanel();
		jpAdmLivros.setLayout(null);
		jpAdmLivros.setBounds(0, 0, 763, 545);
		panelPrincipal.add(jpAdmLivros);
		jpAdmLivros.setVisible(false);

		JComboBox comboBoxAtributoLivro = new JComboBox();
		comboBoxAtributoLivro.setBounds(12, 13, 200, 30);
		jpAdmLivros.add(comboBoxAtributoLivro);

		JLabel lblNewLabel = new JLabel("T\u00EDtulo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(263, 145, 48, 16);
		jpAdmLivros.add(lblNewLabel);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAutor.setBounds(263, 195, 48, 16);
		jpAdmLivros.add(lblAutor);

		JLabel lblDescrio = new JLabel("Ano:");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescrio.setBounds(271, 244, 40, 16);
		jpAdmLivros.add(lblDescrio);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStock.setBounds(263, 484, 48, 16);
		jpAdmLivros.add(lblStock);

		JLabel lblPreo_1 = new JLabel("Pre\u00E7o:");
		lblPreo_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPreo_1.setBounds(263, 433, 48, 16);
		jpAdmLivros.add(lblPreo_1);

		JLabel lblPreo = new JLabel("Descri\u00E7\u00E3o:");
		lblPreo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPreo.setBounds(224, 286, 87, 16);
		jpAdmLivros.add(lblPreo);

		txtTituloLivros = new JTextField();
		txtTituloLivros.setEditable(false);
		txtTituloLivros.setColumns(10);
		txtTituloLivros.setBounds(341, 140, 345, 30);
		jpAdmLivros.add(txtTituloLivros);

		txtAutorLivros = new JTextField();
		txtAutorLivros.setEditable(false);
		txtAutorLivros.setColumns(10);
		txtAutorLivros.setBounds(341, 190, 345, 30);
		jpAdmLivros.add(txtAutorLivros);

		txtAnoLivros = new JTextField();
		txtAnoLivros.setEditable(false);
		txtAnoLivros.setColumns(10);
		txtAnoLivros.setBounds(341, 239, 86, 30);
		jpAdmLivros.add(txtAnoLivros);

		txtPrecoLivros = new JTextField();
		txtPrecoLivros.setEditable(false);
		txtPrecoLivros.setColumns(10);
		txtPrecoLivros.setBounds(341, 428, 86, 30);
		jpAdmLivros.add(txtPrecoLivros);

		txtStockLivros = new JTextField();
		txtStockLivros.setEditable(false);
		txtStockLivros.setColumns(10);
		txtStockLivros.setBounds(341, 479, 86, 30);
		jpAdmLivros.add(txtStockLivros);

		JTextArea txtDescricaoLivros = new JTextArea();
		txtDescricaoLivros.setEditable(false);
		txtDescricaoLivros.setBounds(341, 284, 345, 133);
		jpAdmLivros.add(txtDescricaoLivros);

		JButton btnPesquisarLivro = new JButton("Pesquisar");
		btnPesquisarLivro.setBackground(SystemColor.controlHighlight);
		btnPesquisarLivro.setBounds(224, 16, 97, 25);
		jpAdmLivros.add(btnPesquisarLivro);

		JButton btnLimparLivro = new JButton("Limpar");

		btnLimparLivro.setBackground(SystemColor.controlHighlight);
		btnLimparLivro.setBounds(224, 60, 97, 25);
		jpAdmLivros.add(btnLimparLivro);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 118, 200, 367);
		jpAdmLivros.add(scrollPane_1);

		txtAtributoLivro = new JTextField();
		txtAtributoLivro.setBounds(12, 62, 200, 23);
		jpAdmLivros.add(txtAtributoLivro);
		txtAtributoLivro.setColumns(10);

		JList<String> listaLivros = new JList<String>(modeloListaLivros);
		scrollPane_1.setViewportView(listaLivros);
		// caracter�sticas do livro seleccionado na JList
		listaLivros.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!listaLivros.isSelectionEmpty()) {
					String livroSelecionado = listaLivros.getSelectedValue();
					int id = gl.viewComics.obterIdLivro(livroSelecionado);
					Livro l = gl.viewComics.livroId(id);
					txtIdLivros.setText(Integer.toString(id));
					txtTituloLivros.setText(l.getTitulo());
					txtAutorLivros.setText(l.getAutor());
					txtStockLivros.setText(Integer.toString(l.getStock()));
					txtPrecoLivros.setText("" + l.getPreco());
					txtDescricaoLivros.setText(l.getDescricao());
					txtAnoLivros.setText("" + l.getAno());
				}
			}
		});
		comboBoxAtributoLivro.addItem("por que atributo pretende pesquisar o livro");
		comboBoxAtributoLivro.addItem("Titulo");
		comboBoxAtributoLivro.addItem("Autor");
		comboBoxAtributoLivro.addItem("Id");

		JRadioButton rbAlterarLivro = new JRadioButton("Alterar os dados do livro seleccionado");
		rbGroupLIVROS.add(rbAlterarLivro);
		rbAlterarLivro.setBounds(341, 42, 245, 23);
		jpAdmLivros.add(rbAlterarLivro);

		JRadioButton rbCriarLivro = new JRadioButton("Criar novo livro");
		rbGroupLIVROS.add(rbCriarLivro);
		rbCriarLivro.setBounds(341, 16, 187, 23);
		jpAdmLivros.add(rbCriarLivro);

		JRadioButton rbRemoverLivro = new JRadioButton("Remover o livro seleccionado da loja");
		rbGroupLIVROS.add(rbRemoverLivro);
		rbRemoverLivro.setBounds(341, 68, 245, 23);
		jpAdmLivros.add(rbRemoverLivro);

		JButton btnConfirmarAlteracoesLIVROS = new JButton("Confirmar");
		btnConfirmarAlteracoesLIVROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String titulo = txtTituloLivros.getText();
				String autor = txtAutorLivros.getText();
				String stock = txtStockLivros.getText();
				String descricao = txtDescricaoLivros.getText();
				String ano = txtAnoLivros.getText();
				String preco = txtPrecoLivros.getText();

				if (rbAlterarLivro.isSelected()) {
					if (!listaLivros.isSelectionEmpty()) {
						String seleccao = listaLivros.getSelectedValue();
						gl.viewComics.alterarLivro(seleccao, titulo, autor, preco, stock, ano, descricao);
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione um livro da lista por favor");
					}
				} else if (rbCriarLivro.isSelected()) {

					Livro l = new Livro(titulo, autor, Double.parseDouble(preco), Integer.parseInt(stock),
							Integer.parseInt(ano), descricao);
					gl.viewComics.addLivro(l);
				}

				else if (rbRemoverLivro.isSelected()) {
					if (!listaLivros.isSelectionEmpty()) {
						String seleccao = listaLivros.getSelectedValue();
						String id = txtIdLivros.getText();
						gl.viewComics.removerLivro(id, gl.viewComics.getLivros());
					} else {
						JOptionPane.showMessageDialog(null, "Seleccione um livro da lista por favor");
					}

				}
				txtAtributoLivro.setText("");
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

				modeloListaLivros.removeAllElements();
				gl.viewComics.addArrayLista(gl.viewComics.arrayLivros(gl.viewComics.getLivros()), modeloListaLivros);
				modeloListaLivros.removeAllElements();
				gl.viewComics.addArrayLista(gl.viewComics.arrayLivros(gl.viewComics.getLivros()), modeloListaLivros);
			}

		});
		btnConfirmarAlteracoesLIVROS.setBounds(479, 446, 143, 38);
		jpAdmLivros.add(btnConfirmarAlteracoesLIVROS);

		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(263, 107, 31, 16);
		jpAdmLivros.add(lblId);

		txtIdLivros = new JTextField();
		txtIdLivros.setEditable(false);
		txtIdLivros.setColumns(10);
		txtIdLivros.setBounds(341, 99, 73, 30);
		jpAdmLivros.add(txtIdLivros);

		JButton btnNewButton = new JButton("Permitir alteracoes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTituloLivros.setEditable(true);
				txtAutorLivros.setEditable(true);
				txtStockLivros.setEditable(true);
				txtDescricaoLivros.setEditable(true);
				txtAnoLivros.setEditable(true);
				txtPrecoLivros.setEditable(true);
			}
		});
		btnNewButton.setBounds(598, 7, 158, 42);
		jpAdmLivros.add(btnNewButton);

		JButton btnCancelar = new JButton("Cancelar");
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
		btnCancelar.setBounds(598, 60, 158, 38);
		jpAdmLivros.add(btnCancelar);

		// pesquisar livros consoante os atributos
		btnPesquisarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (comboBoxAtributoLivro.getSelectedItem().equals("Titulo")) {
					modeloListaLivros.removeAllElements();
					String titulo = txtAtributoLivro.getText();
					gl.viewComics.addArrayLista(gl.viewComics.listaTitulo(titulo), modeloListaLivros);
				}
				if (comboBoxAtributoLivro.getSelectedItem().equals("Autor")) {
					modeloListaLivros.removeAllElements();
					String autor = txtAtributoLivro.getText();
					gl.viewComics.addArrayLista(gl.viewComics.listaAutor(autor), modeloListaLivros);
				}
				if (comboBoxAtributoLivro.getSelectedItem().equals("Id")) {
					modeloListaLivros.removeAllElements();
					String id = txtAtributoLivro.getText();
					gl.viewComics.addArrayLista(gl.viewComics.listaLivroId(id), modeloListaLivros);
				}

			}
		});
		// bot�o limpar
		btnLimparLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtAtributoLivro.setText("");
				txtIdLivros.setText("");
				txtTituloLivros.setText("");
				txtAutorLivros.setText("");
				txtStockLivros.setText("");
				txtPrecoLivros.setText("");
				txtDescricaoLivros.setText("");
				txtAnoLivros.setText("");

				modeloListaLivros.removeAllElements();
				gl.viewComics.addArrayLista(gl.viewComics.arrayLivros(gl.viewComics.getLivros()), modeloListaLivros);

			}
		});

		jpAdmFuncionarios = new JPanel();
		jpAdmFuncionarios.setBounds(0, 0, 763, 545);
		panelPrincipal.add(jpAdmFuncionarios);
		jpAdmFuncionarios.setVisible(false);
		jpAdmFuncionarios.setLayout(null);
		txtAtributoFunc = new JTextField();
		txtAtributoFunc.setBounds(32, 69, 200, 30);
		txtAtributoFunc.setColumns(10);
		jpAdmFuncionarios.add(txtAtributoFunc);
		JButton btnPesquisaFunc = new JButton("Pesquisar");
		btnPesquisaFunc.setBounds(264, 28, 97, 25);
		btnPesquisaFunc.setBackground(SystemColor.controlHighlight);
		jpAdmFuncionarios.add(btnPesquisaFunc);
		JButton btnLimparPesquisaFunc = new JButton("Limpar");
		btnLimparPesquisaFunc.setBounds(264, 72, 97, 25);
		btnLimparPesquisaFunc.setBackground(SystemColor.controlHighlight);
		jpAdmFuncionarios.add(btnLimparPesquisaFunc);
		JLabel lblIdFuncionrio = new JLabel("Id funcion\u00E1rio :");
		lblIdFuncionrio.setBounds(264, 116, 119, 22);
		lblIdFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmFuncionarios.add(lblIdFuncionrio);
		txtIdFunc = new JTextField();
		txtIdFunc.setBounds(395, 108, 76, 30);
		txtIdFunc.setEditable(false);
		txtIdFunc.setColumns(10);
		jpAdmFuncionarios.add(txtIdFunc);
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(319, 149, 64, 25);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmFuncionarios.add(lblNome);

		txtNomeFunc = new JTextField();
		txtNomeFunc.setBounds(395, 149, 345, 30);
		txtNomeFunc.setEditable(false);
		txtNomeFunc.setColumns(10);
		jpAdmFuncionarios.add(txtNomeFunc);

		JLabel lblContacto = new JLabel("Contacto :");
		lblContacto.setBounds(302, 186, 87, 24);
		lblContacto.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmFuncionarios.add(lblContacto);

		txtContactoFunc = new JTextField();
		txtContactoFunc.setBounds(394, 185, 345, 30);
		txtContactoFunc.setEditable(false);
		txtContactoFunc.setColumns(10);
		jpAdmFuncionarios.add(txtContactoFunc);

		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setBounds(292, 231, 97, 16);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmFuncionarios.add(lblUsername);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(292, 270, 97, 21);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		jpAdmFuncionarios.add(lblPassword);

		txtUsernameFunc = new JTextField();
		txtUsernameFunc.setBounds(394, 226, 345, 30);
		txtUsernameFunc.setEditable(false);
		txtUsernameFunc.setColumns(10);
		jpAdmFuncionarios.add(txtUsernameFunc);

		txtPassFunc = new JTextField();
		txtPassFunc.setBounds(394, 267, 345, 30);
		txtPassFunc.setEditable(false);
		txtPassFunc.setColumns(10);
		jpAdmFuncionarios.add(txtPassFunc);

		JComboBox comboBoxAtributoFunc = new JComboBox();
		comboBoxAtributoFunc.setBounds(32, 29, 200, 22);
		jpAdmFuncionarios.add(comboBoxAtributoFunc);

		JButton btnCancelarFunc = new JButton("Cancelar");
		btnCancelarFunc.setBounds(581, 326, 89, 23);
		btnCancelarFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNomeFunc.setText("");
				txtContactoFunc.setText("");
				txtPassFunc.setText("");
				txtUsernameFunc.setText("");
				txtIdFunc.setText("");
				txtNomeFunc.setEditable(false);
				txtContactoFunc.setEditable(false);
				txtPassFunc.setEditable(false);
				txtUsernameFunc.setEditable(false);
				modeloListaFUNCIONARIOS.removeAllElements();
				gl.viewComics.addArrayLista(gl.viewComics.arrayFunc(gl.viewComics.getUtilizadores()),
						modeloListaFUNCIONARIOS);

			}
		});
		btnCancelarFunc.setBackground(SystemColor.controlHighlight);
		jpAdmFuncionarios.add(btnCancelarFunc);
		JList<String> listaFuncionarios = new JList<String>(modeloListaFUNCIONARIOS);
		listaFuncionarios.setBounds(32, 123, 200, 337);

		listaFuncionarios.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {

				String selecaoLista = listaFuncionarios.getSelectedValue();
				Utilizador f = gl.viewComics.devolveFunc(selecaoLista);
				txtIdFunc.setText(Integer.toString(f.getId()));
				txtNomeFunc.setText(f.getNome());
				txtContactoFunc.setText(f.getContato());
				txtUsernameFunc.setText(f.getUsername());
				txtPassFunc.setText(f.getPassword());
			}
		});
		jpAdmFuncionarios.add(listaFuncionarios);
		comboBoxAtributoFunc.addItem("Nome");
		comboBoxAtributoFunc.addItem("Id");
		comboBoxAtributoFunc.addItem("Username");
		comboBoxAtributoFunc.addItem("Contacto");

		JRadioButton rbAdicionarFUNCIONARIOS = new JRadioButton("Adicionar funcionario a loja");
		rbGroupFUNCIONARIOS.add(rbAdicionarFUNCIONARIOS);
		rbAdicionarFUNCIONARIOS.setBounds(525, 29, 186, 23);
		jpAdmFuncionarios.add(rbAdicionarFUNCIONARIOS);

		JRadioButton rbAlterarFUNCIONARIO = new JRadioButton("Alterar dados do funcionario seleccionado");
		rbGroupFUNCIONARIOS.add(rbAlterarFUNCIONARIO);
		rbAlterarFUNCIONARIO.setBounds(525, 55, 232, 23);
		jpAdmFuncionarios.add(rbAlterarFUNCIONARIO);

		JRadioButton rbRemoverFuncionario = new JRadioButton("Remover funcionario");
		rbGroupFUNCIONARIOS.add(rbRemoverFuncionario);
		rbRemoverFuncionario.setBounds(525, 81, 175, 23);
		jpAdmFuncionarios.add(rbRemoverFuncionario);

		JButton btnLimparCamposFUNCIONARIO = new JButton("Permitir alteracao dos campos");
		btnLimparCamposFUNCIONARIO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNomeFunc.setEditable(true);
				txtContactoFunc.setEditable(true);
				txtUsernameFunc.setEditable(true);
				txtPassFunc.setEditable(true);
				if (rbAdicionarFUNCIONARIOS.isSelected()) {
					if (rbAdicionarFUNCIONARIOS.isSelected())
						txtIdFunc.setText("");
					txtNomeFunc.setText("");
					txtContactoFunc.setText("");
					txtUsernameFunc.setText("");
					txtPassFunc.setText("");

				}
			}
		});
		btnLimparCamposFUNCIONARIO.setBounds(525, 116, 215, 23);
		jpAdmFuncionarios.add(btnLimparCamposFUNCIONARIO);

		JButton btnConfirmarFUNCIONARIOS2 = new JButton("Confirmar");
		btnConfirmarFUNCIONARIOS2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!listaFuncionarios.isSelectionEmpty()) {
					if (rbAdicionarFUNCIONARIOS.isSelected()) {
						String novoFuncNome = txtNomeFunc.getText();
						String novoFuncContacto = txtContactoFunc.getText();
						String novoFuncUsername = txtUsernameFunc.getText();
						String novoFuncPass = txtPassFunc.getText();
						Funcionario f = new Funcionario(novoFuncNome, novoFuncContacto, novoFuncUsername, novoFuncPass);
						int idINT = f.getId();
						txtIdFunc.setText(Integer.toString(idINT));
						gl.viewComics.addUtilizador(f);
						modeloListaFUNCIONARIOS.removeAllElements();
						gl.viewComics.addArrayLista(gl.viewComics.arrayFunc(gl.viewComics.getUtilizadores()),
								modeloListaFUNCIONARIOS);
						txtNomeFunc.setEditable(false);
						txtContactoFunc.setEditable(false);
						txtUsernameFunc.setEditable(false);
						txtPassFunc.setEditable(false);
						txtIdFunc.setText("");

					} else if (rbAlterarFUNCIONARIO.isSelected()) {
						String novoNome = txtNomeFunc.getText();
						String novoUsername = txtUsernameFunc.getText();
						String novaPass = txtPassFunc.getText();
						String novoContacto = txtContactoFunc.getText();
						String id = txtIdFunc.getText();
						gl.viewComics.alterarFuncionario(id, novoNome, novoContacto, novoUsername, novaPass);
						txtNomeFunc.setEditable(false);
						txtContactoFunc.setEditable(false);
						txtUsernameFunc.setEditable(false);
						txtPassFunc.setEditable(false);

						modeloListaFUNCIONARIOS.removeAllElements();
						gl.viewComics.addArrayLista(gl.viewComics.arrayFunc(gl.viewComics.getUtilizadores()),
								modeloListaFUNCIONARIOS);
						txtIdFunc.setText("");

					} else if (rbRemoverFuncionario.isSelected()) {
						String selecaoLista = listaFuncionarios.getSelectedValue();
						int id = gl.viewComics.obterIdFunc(selecaoLista);
						gl.viewComics.removerUtil(id, gl.viewComics.getUtilizadores());
						modeloListaFUNCIONARIOS.removeAllElements();
						gl.viewComics.addArrayLista(gl.viewComics.arrayFunc(gl.viewComics.getUtilizadores()),
								modeloListaFUNCIONARIOS);
						txtIdFunc.setText("");

					} else {
						JOptionPane.showMessageDialog(null, "Por favor seleccione a opcao desejada");
					}
				}

			}
		});
		btnConfirmarFUNCIONARIOS2.setBounds(447, 326, 89, 23);
		jpAdmFuncionarios.add(btnConfirmarFUNCIONARIOS2);
		btnLimparPesquisaFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloListaFUNCIONARIOS.removeAllElements();
				gl.viewComics.addArrayLista(gl.viewComics.arrayFunc(gl.viewComics.getUtilizadores()),
						modeloListaFUNCIONARIOS);

			}
		});

		// pesquisar funcionarios por atributos
		btnPesquisaFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (comboBoxAtributoFunc.getSelectedItem().equals("Nome")) {
					modeloListaFUNCIONARIOS.removeAllElements();
					String nome = txtAtributoFunc.getText();
					gl.viewComics.addArrayLista(gl.viewComics.listaFunPorNome(nome), modeloListaFUNCIONARIOS);
				}
				if (comboBoxAtributoFunc.getSelectedItem().equals("Id")) {
					modeloListaFUNCIONARIOS.removeAllElements();
					String id = txtAtributoFunc.getText();
					gl.viewComics.addArrayLista(gl.viewComics.listaFuncPorId(id), modeloListaFUNCIONARIOS);

				}
				if (comboBoxAtributoFunc.getSelectedItem().equals("Username")) {
					modeloListaFUNCIONARIOS.removeAllElements();
					String username = txtAtributoFunc.getText();
					gl.viewComics.addArrayLista(gl.viewComics.listaFunPorUsername(username), modeloListaFUNCIONARIOS);
				}
				if (comboBoxAtributoFunc.getSelectedItem().equals("Contacto")) {
					modeloListaFUNCIONARIOS.removeAllElements();
					String contacto = txtAtributoFunc.getText();
					gl.viewComics.addArrayLista(gl.viewComics.listaFuncPorContacto(contacto), modeloListaFUNCIONARIOS);
				}

			}
		});

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
		gl.viewComics.addArrayLista(gl.viewComics.arrayLivros(gl.viewComics.getLivros()), modeloListaLivros);
//		gl.viewComics.addArrayLista(gl.viewComics.arrayLivros(gl.viewComics.getLivros()), modeloListaLivros);

		gl.viewComics.addArrayLista(gl.viewComics.arrayFunc(gl.viewComics.getUtilizadores()), modeloListaFUNCIONARIOS);

		JPanel jpAdmEstatisticas = new JPanel();
		jpAdmEstatisticas.setBounds(0, 0, 763, 545);
		panelPrincipal.add(jpAdmEstatisticas);
		jpAdmEstatisticas.setLayout(null);
		jpAdmEstatisticas.setVisible(false);

		// encaminhar para os respectivos paineis ao clicar nos botoes

		btnLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpAdmStock.setVisible(false);
				jpAdmEstatisticas.setVisible(false);
				jpAdmLivros.setVisible(true);
				jpAdmConta.setVisible(false);
				jpAdmFuncionarios.setVisible(false);
			}
		});
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jpAdmStock.setVisible(false);
				jpAdmEstatisticas.setVisible(false);
				jpAdmLivros.setVisible(false);
				jpAdmConta.setVisible(false);
				jpAdmFuncionarios.setVisible(true);
			}
		});
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jpAdmStock.setVisible(true);
				jpAdmEstatisticas.setVisible(false);
				jpAdmLivros.setVisible(false);
				jpAdmConta.setVisible(false);
				jpAdmFuncionarios.setVisible(false);

			}
		});
		btnEstatisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jpAdmStock.setVisible(false);
				jpAdmEstatisticas.setVisible(true);
				jpAdmLivros.setVisible(false);
				jpAdmConta.setVisible(false);
				jpAdmFuncionarios.setVisible(false);
			}
		});
		btnGestao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jpAdmStock.setVisible(false);
				jpAdmEstatisticas.setVisible(false);
				jpAdmLivros.setVisible(false);
				jpAdmConta.setVisible(true);
				jpAdmFuncionarios.setVisible(false);
			}
		});

		// logOut

		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				gl.atualizaficheiro(gl.getViewComics().getUtilizadores(), gl.getViewComics().getCarrinhos(),
						gl.getViewComics().getLivros());

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
				btnStock.setBackground(SystemColor.controlHighlight);
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
				btnStock.setBackground(SystemColor.controlHighlight);
				btnFuncionarios.setBackground(SystemColor.controlHighlight);
				btnEstatisticas.setBackground(SystemColor.controlHighlight);

			}
		});

		// Stock

		btnStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnStock.setBackground(Color.YELLOW);
			}

			public void mouseExited(MouseEvent arg0) {
				btnStock.setBackground(SystemColor.controlHighlight);
			}

			public void mouseClicked(MouseEvent arg0) {
				btnStock.setBackground(Color.YELLOW);
				btnLivros.setBackground(SystemColor.controlHighlight);
				btnGestao.setBackground(SystemColor.controlHighlight);
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
				btnStock.setBackground(SystemColor.controlHighlight);
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
				btnStock.setBackground(SystemColor.controlHighlight);
				btnFuncionarios.setBackground(SystemColor.controlHighlight);
				btnGestao.setBackground(SystemColor.controlHighlight);
			}

		});

		// adicionar um funcionario � lista

	}
}
