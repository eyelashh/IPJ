import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Color;
import java.awt.TextField;
import java.awt.Window;
import java.awt.List;
import javax.swing.SwingConstants;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AppCliente implements Serializable {

	private JFrame frame;
	private JTextField txtQuantidadeAlterarLIVROS;
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	private JTextField txtStockLivros;
	private JTextField txtPrecoLivros;
	private JTextField txtDescricaoLivros;
	private JTextField txtAnoLivros;
	private JTextField txtAutorLivros;
	private JTextField txtTituloLivros;
	private static GestaoLivraria gl;
	private JTextField txtNifCarrinhoLIVROS;
	private JTextField txtQuantidadeActualLivros;
	private final ButtonGroup alterarQuantidadeCarrinhoLIVROS = new ButtonGroup();
	private JTextField txtIdLivros;
	private JTextField txtNifCARRINHO;
	private JTextField txtPrecoTotalCARRINHO;
	private JTextField txtTotalLivrosCARRINHO;
	private JPanel JPCarrinho;
	private JTable tabelaLivros;
	private JTable tabelaCarrinho;
	String[] colunasCarrinho = { "Id do livro", "Titulo", "Autor", "Preco unitario", "Quantidade", "Preco total" };
	DefaultTableModel modeloTabelaCarrinho = new DefaultTableModel(colunasCarrinho, 0);
	String[] colunasLivro = { "Id do livro", "Titulo", "Autor", "Ano", "Preco" };
	DefaultTableModel modeloTabelaLivros = new DefaultTableModel(colunasLivro, 0);

//a classe cliente nao precisa de um atributo utilizador porque nao precisa de se fazer login para entrar
	// na janela

	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			AppCliente window = new AppCliente();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public AppCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "serial", "unchecked", "rawtypes" })
	private void initialize() {

		GestaoLivraria gl = new GestaoLivraria();
		gl.run();

		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				gl.atualizaficheiro(gl.getViewComics().getUtilizadores(), gl.getViewComics().getCarrinhos(),
						gl.getViewComics().getLivros());
			}

		});
		frame.setBounds(100, 100, 1280, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel JPanelCabecalho = new JPanel();
		JPanelCabecalho.setBackground(new Color(255, 215, 0));

		JPanelCabecalho.setBounds(0, 0, 1264, 183);
		frame.getContentPane().add(JPanelCabecalho);
		JPanelCabecalho.setLayout(null);

		JLabel label = new JLabel("ViewComics Inc.");
		label.setBounds(59, 30, 785, 118);
		label.setFont(new Font("Tempus Sans ITC", Font.BOLD, 92));
		JPanelCabecalho.add(label);

		JLabel label_18 = new JLabel("\u00C1rea restrita (funcion\u00E1rio ou admin)");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_18.setBounds(898, 11, 356, 27);
		JPanelCabecalho.add(label_18);

		JLabel label_19 = new JLabel("Username:");
		label_19.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		label_19.setBounds(1015, 44, 98, 27);
		JPanelCabecalho.add(label_19);

		txtPassword = new JPasswordField();

		txtPassword.setBounds(918, 121, 189, 20);
		JPanelCabecalho.add(txtPassword);

		JLabel label_20 = new JLabel("Password:");
		label_20.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 21));
		label_20.setBounds(1018, 95, 89, 29);
		JPanelCabecalho.add(label_20);

		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(919, 70, 189, 20);
		JPanelCabecalho.add(txtUsername);
		JButton btnLogIn = new JButton("Entrar");

		btnLogIn.setBackground(SystemColor.controlHighlight);
		btnLogIn.setBounds(1125, 95, 103, 27);
		JPanelCabecalho.add(btnLogIn);

		JPanel JPanelMenu = new JPanel();
		JPanelMenu.setBackground(new Color(128, 128, 0));
		JPanelMenu.setBounds(0, 185, 245, 544);
		frame.getContentPane().add(JPanelMenu);
		JPanelMenu.setLayout(null);

		JButton btnLivros = new JButton("Livros");

		btnLivros.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 31));
		btnLivros.setBackground(SystemColor.controlHighlight);
		btnLivros.setBounds(26, 36, 176, 55);
		JPanelMenu.add(btnLivros);

		JButton btnCarrinho = new JButton("Carrinho");

		btnCarrinho.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnCarrinho.setBackground(SystemColor.controlHighlight);
		btnCarrinho.setBounds(26, 115, 176, 60);
		JPanelMenu.add(btnCarrinho);

		// painel principal que contem o painel Carrinho e o painel Livros

		JPanel JPanelPrincipal = new JPanel() {
			@Override
			// o paint component vai pintar literalmente o componente
			protected void paintComponent(Graphics g) {

				super.paintComponent(g);
				Image img;
				try {

					// img = ImageIO.read(new URL(
					// "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO.read(
							new File("/Users/Joana/Dropbox/IPJ_ProjectoFinal/Design/viewcomics/wallpaperMarvel.jpg "));
					g.drawImage(img, 0, 0, null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		JPanelPrincipal.setBounds(255, 185, 1009, 544);
		frame.getContentPane().add(JPanelPrincipal);
		JPanelPrincipal.setLayout(null);

		// painel para o carrinho

		JPCarrinho = new JPanel();
		JPCarrinho.setVisible(false);

		// JPanel JPLivros = new JPanel() {
		// @Override
		// // o paint component vai pintar literalmente o componente
		// protected void paintComponent(Graphics g) {
		//
		// super.paintComponent(g);
		// Image img;
		// try {

		// ou
		// // do
		// // ficheiro
		//
		// // img = ImageIO.read(new URL(
		// //
		// "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
		// img = ImageIO.read(new File(" "));
		// g.drawImage(img, 0, 0, null);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// }
		// };
		JPanel JPLivros = new JPanel();
		JPLivros.setBounds(0, 0, 1008, 544);
		JPanelPrincipal.add(JPLivros);
		JPLivros.setLayout(null);

		Choice choiceAtributoLivroCliente = new Choice();
		choiceAtributoLivroCliente.setBounds(144, 71, 211, 20);
		JPLivros.add(choiceAtributoLivroCliente);
		choiceAtributoLivroCliente.add("(por que criterio pretende pesquisar o livro)");
		choiceAtributoLivroCliente.add("Titulo");
		choiceAtributoLivroCliente.add("Autor");
		choiceAtributoLivroCliente.add("Id");
		choiceAtributoLivroCliente.add("Ano");

		TextField txtAtributoLivros = new TextField();
		txtAtributoLivros.setBounds(65, 96, 200, 22);
		JPLivros.add(txtAtributoLivros);

		// botaoPesquisarLivro
		JButton btnPesquisarLivro = new JButton("Pesquisar");
		btnPesquisarLivro.setBounds(112, 124, 115, 26);
		btnPesquisarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String criterioPesquisa=choiceAtributoLivroCliente.getSelectedItem();
				String pesquisa=txtAtributoLivros.getText();
				modeloTabelaLivros.setRowCount(0);
				gl.viewComics.tabelaLivrosCriterioSeleccao(modeloTabelaLivros, criterioPesquisa, pesquisa);
			}
		});
		btnPesquisarLivro.setBackground(SystemColor.controlHighlight);
		JPLivros.add(btnPesquisarLivro);

		txtQuantidadeAlterarLIVROS = new JTextField();
		txtQuantidadeAlterarLIVROS.setBounds(631, 127, 57, 43);
		txtQuantidadeAlterarLIVROS.setColumns(10);
		JPLivros.add(txtQuantidadeAlterarLIVROS);
		JRadioButton rbAdicionarQuantidadeLIVROS = new JRadioButton("Adicionar");
		rbAdicionarQuantidadeLIVROS.setBounds(694, 127, 109, 23);
		alterarQuantidadeCarrinhoLIVROS.add(rbAdicionarQuantidadeLIVROS);
		JPLivros.add(rbAdicionarQuantidadeLIVROS);

		JRadioButton rbRemoverQuantidadeLIVROS = new JRadioButton("Remover");
		rbRemoverQuantidadeLIVROS.setBounds(694, 147, 109, 23);
		alterarQuantidadeCarrinhoLIVROS.add(rbRemoverQuantidadeLIVROS);
		JPLivros.add(rbRemoverQuantidadeLIVROS);
		// actualiza o carrinho do nif inserido
		// dependendo
		// do radiobutton escolhido para acrescentar ou remover uma
		// certa quantidade de um item
		JButton btnAddCarrinhoFinalCliente = new JButton("Alterar carrinho");
		btnAddCarrinhoFinalCliente.setBounds(698, 79, 183, 42);
		btnAddCarrinhoFinalCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//int linha = tabelaLivros.getSelectedRow();
				int idLivroSelec = (int) tabelaLivros.getModel().getValueAt(tabelaLivros.getSelectedRow(), 0);
				//Livro l = gl.viewComics.livroId(idLivro);
				String qtdAlterarCarrinho = txtQuantidadeAlterarLIVROS.getText();
				String nif = txtNifCarrinhoLIVROS.getText();
				String stock = txtStockLivros.getText();
				if (!tabelaLivros.getSelectionModel().isSelectionEmpty()) {
					if (gl.viewComics.verificaNif(nif) == false) {
						JOptionPane.showMessageDialog(null,
								"O nif tem que conter 9 digitos. Verifique se foi inserido correctamente.");
						txtQuantidadeActualLivros.setText("0");
					} else if (gl.viewComics.verificaNif(nif)) {
						if (gl.viewComics.carrinhoExiste(nif)) {
							gl.viewComics.carrinhoExiste(nif);
							String quantidadeActualLIVROSstr = gl.viewComics.quantidadeCarrinho(idLivroSelec, nif);
							txtQuantidadeActualLivros.setText(quantidadeActualLIVROSstr);
							if (rbAdicionarQuantidadeLIVROS.isSelected()) {
								if (gl.viewComics.adicionarAoCarrinhoPossivel(qtdAlterarCarrinho, idLivroSelec,
										stock)) {
									quantidadeActualLIVROSstr = gl.viewComics.adicionarQuantidade(
											txtQuantidadeActualLivros.getText(), qtdAlterarCarrinho);
									int quantidadeActualLIVROSint = Integer.parseInt(quantidadeActualLIVROSstr);
//								gl.viewComics.updateConteudoCarrinho(nif, idLivroSelec, quantidadeActualLIVROSint);
									txtQuantidadeActualLivros.setText(quantidadeActualLIVROSstr);
									// actualiza o carrinho
									gl.viewComics.updateConteudoCarrinho(nif, idLivroSelec, quantidadeActualLIVROSint);

									// actualiza o stock
									String novoStockSTR = gl.viewComics.removerQuantidade(stock, qtdAlterarCarrinho);
									int novoStockINT = Integer.parseInt(novoStockSTR);
									gl.viewComics.alterarStockLivro(idLivroSelec, novoStockINT);

								} else {
									JOptionPane.showMessageDialog(null,
											"Não foi possível adicionar a quantidade desejada ao carrinho. Verifique o stock disponivel do livro em questao");
								}
							}
							if (rbRemoverQuantidadeLIVROS.isSelected()) {
								if (gl.viewComics.removerCarrinhoPossivel(qtdAlterarCarrinho, idLivroSelec, nif)) {
									quantidadeActualLIVROSstr = gl.viewComics
											.removerQuantidade(txtQuantidadeActualLivros.getText(), qtdAlterarCarrinho);
									int quantidadeActualLIVROSint = Integer.parseInt(quantidadeActualLIVROSstr);
//								gl.viewComics.updateConteudoCarrinho(nif, idLivroSelec, quantidadeActualLIVROSint);
									txtQuantidadeActualLivros.setText(quantidadeActualLIVROSstr);
									// actualizar carrinho
									gl.viewComics.updateConteudoCarrinho(nif, idLivroSelec, quantidadeActualLIVROSint);

									// actualizar stock
									String novoStockSTR = gl.viewComics.adicionarQuantidade(stock, qtdAlterarCarrinho);
									int novoStockINT = Integer.parseInt(novoStockSTR);
									gl.viewComics.alterarStockLivro(idLivroSelec, novoStockINT);

								} else {

									JOptionPane.showMessageDialog(null,
											"Não foi possível remover a quantidade referida do carrinho. Verifique a quantidade do carrinho");
								}

							}
						} else {
							JOptionPane.showMessageDialog(null,
									"O nif introduzido nao consta na nossa base de dados de carrinhos. Por favor primeiro crie um carrinho com o seu nif.");
						}

					}

				} else {
					JOptionPane.showMessageDialog(null,
							"Para alterar o carrinho por favor seleccione um livro da lista");
				}
				modeloTabelaLivros.setRowCount(0);
				gl.viewComics.livrosTabela(modeloTabelaLivros);
				tabelaLivros.getSelectionModel().isSelectionEmpty();
				
				
			}
		});
		btnAddCarrinhoFinalCliente.setBackground(SystemColor.controlHighlight);
		btnAddCarrinhoFinalCliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		JPLivros.add(btnAddCarrinhoFinalCliente);

		JLabel label_2 = new JLabel("Nome:");
		label_2.setBounds(493, 182, 48, 16);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		JPLivros.add(label_2);

		JLabel label_3 = new JLabel("Autor:");
		label_3.setBounds(493, 223, 48, 16);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		JPLivros.add(label_3);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(493, 264, 40, 16);
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 15));
		JPLivros.add(lblAno);

		JLabel label_5 = new JLabel("Descri\u00E7\u00E3o:");
		label_5.setBounds(466, 310, 87, 16);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		JPLivros.add(label_5);

		JLabel label_6 = new JLabel("Pre\u00E7o:");
		label_6.setBounds(493, 430, 48, 16);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		JPLivros.add(label_6);

		JLabel label_7 = new JLabel("Stock:");
		label_7.setBounds(493, 472, 48, 16);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		JPLivros.add(label_7);

		txtStockLivros = new JTextField();
		txtStockLivros.setBounds(563, 469, 87, 30);
		txtStockLivros.setEditable(false);
		txtStockLivros.setColumns(10);
		JPLivros.add(txtStockLivros);

		txtPrecoLivros = new JTextField();
		txtPrecoLivros.setBounds(563, 428, 87, 30);
		txtPrecoLivros.setEditable(false);
		txtPrecoLivros.setColumns(10);
		JPLivros.add(txtPrecoLivros);

		txtDescricaoLivros = new JTextField();
		txtDescricaoLivros.setBounds(563, 300, 345, 117);
		txtDescricaoLivros.setEditable(false);
		txtDescricaoLivros.setColumns(10);
		JPLivros.add(txtDescricaoLivros);

		txtAnoLivros = new JTextField();
		txtAnoLivros.setBounds(563, 259, 345, 30);
		txtAnoLivros.setEditable(false);
		txtAnoLivros.setColumns(10);
		JPLivros.add(txtAnoLivros);

		txtAutorLivros = new JTextField();
		txtAutorLivros.setBounds(563, 218, 345, 30);
		txtAutorLivros.setEditable(false);
		txtAutorLivros.setColumns(10);
		JPLivros.add(txtAutorLivros);

		txtTituloLivros = new JTextField();
		txtTituloLivros.setBounds(563, 177, 345, 30);
		txtTituloLivros.setEditable(false);
		txtTituloLivros.setColumns(10);
		JPLivros.add(txtTituloLivros);

		txtNifCarrinhoLIVROS = new JTextField("");
		txtNifCarrinhoLIVROS.setBounds(513, 31, 175, 40);
		JPLivros.add(txtNifCarrinhoLIVROS);
		txtNifCarrinhoLIVROS.setColumns(10);

		JLabel lblIntroduzaOSeu = new JLabel("INTRODUZA O SEU NIF");
		lblIntroduzaOSeu.setBounds(513, 11, 140, 20);
		lblIntroduzaOSeu.setFont(new Font("Tahoma", Font.BOLD, 11));
		JPLivros.add(lblIntroduzaOSeu);

		txtQuantidadeActualLivros = new JTextField();
		txtQuantidadeActualLivros.setBounds(631, 84, 57, 39);
		txtQuantidadeActualLivros.setEditable(false);
		JPLivros.add(txtQuantidadeActualLivros);
		txtQuantidadeActualLivros.setColumns(10);

		JLabel lblqtddCarrinho = new JLabel("No seu carrinho :");
		lblqtddCarrinho.setBounds(513, 84, 128, 22);
		lblqtddCarrinho.setFont(new Font("Tahoma", Font.BOLD, 13));
		JPLivros.add(lblqtddCarrinho);

		JButton btnLimparPesquisaCliente = new JButton("Limpar");
		btnLimparPesquisaCliente.setBounds(271, 96, 84, 38);
		btnLimparPesquisaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtAtributoLivros.setText("");
				
			}
		});
		btnLimparPesquisaCliente.setBackground(SystemColor.controlHighlight);
		JPLivros.add(btnLimparPesquisaCliente);

		txtIdLivros = new JTextField();
		txtIdLivros.setBounds(563, 138, 48, 30);
		txtIdLivros.setEditable(false);
		txtIdLivros.setColumns(10);
		JPLivros.add(txtIdLivros);

		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(512, 138, 29, 16);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		JPLivros.add(lblId);

		// verifica e insere a quantidade que existe de um item em um carrinho
		JButton btnVerificarCarrinhoLIVROS = new JButton("Criar carrinho");
		btnVerificarCarrinhoLIVROS.setBounds(698, 31, 183, 42);
		btnVerificarCarrinhoLIVROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nif = txtNifCarrinhoLIVROS.getText();
				if (gl.viewComics.verificaNif(nif)) {
					if (gl.viewComics.carrinhoExiste(nif)) {
						JOptionPane.showMessageDialog(null,
								"O nif que seleccionou ja corresponde a um carrinho em loja, para continuar compra basta alterar o seu carrinho");

					} else {
						Carrinho c = new Carrinho(nif);
						gl.viewComics.addCarrinho(c);
						JOptionPane.showMessageDialog(null, "O carrinho com o nif" + nif
								+ "foi criado com sucesso. O carrinho encontra-se vazio, pode seleccionar os livros! Boas compras!");

					}

				} else {

					JOptionPane.showMessageDialog(null,
							"O nif deve conter 9 digitos. Verifique se o introduziu correctamente.");
				}

			}

		});
		btnVerificarCarrinhoLIVROS.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnVerificarCarrinhoLIVROS.setBackground(SystemColor.controlHighlight);
		JPLivros.add(btnVerificarCarrinhoLIVROS);
		
		JComboBox cbOrdenarLIVROS = new JComboBox();
		cbOrdenarLIVROS.addItem("Titulo");
		cbOrdenarLIVROS.addItem("Ano");
		cbOrdenarLIVROS.addItem("Preco");
		JPLivros.add(cbOrdenarLIVROS);
		cbOrdenarLIVROS.setBounds(144, 38, 211, 20);
		cbOrdenarLIVROS.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				String seleccao=(String) cbOrdenarLIVROS.getSelectedItem();
				gl.viewComics.ordenarTabelaLivros(tabelaLivros, seleccao);
			}
		});
		

		JLabel lblNewLabel_2 = new JLabel("Filtrar por : ");
		lblNewLabel_2.setBounds(10, 71, 128, 20);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		JPLivros.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Ordenar por :");
		lblNewLabel_3.setBounds(65, 44, 73, 14);
		JPLivros.add(lblNewLabel_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(39, 185, 411, 314);
		JPLivros.add(scrollPane_1);

		tabelaLivros = new JTable(modeloTabelaLivros);
		tabelaLivros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = tabelaLivros.getSelectedRow();
				int idLivro = (int) tabelaLivros.getModel().getValueAt(linha, 0);
				String nif =txtNifCarrinhoLIVROS.getText();
				Livro l = gl.viewComics.livroId(idLivro);
				txtIdLivros.setText(Integer.toString(idLivro));
				txtTituloLivros.setText(l.getTitulo());
				txtAutorLivros.setText(l.getAutor());
				txtAnoLivros.setText(Integer.toString(l.getAno()));
				txtPrecoLivros.setText(Double.toString(l.getPreco()));	
				txtStockLivros.setText(Integer.toString(l.getStock()));
				String qtdNoCarrinho=gl.viewComics.quantidadeCarrinho(idLivro, nif);
				txtQuantidadeActualLivros.setText(qtdNoCarrinho);
			}
		});
		gl.viewComics.livrosTabela(modeloTabelaLivros);
		scrollPane_1.setViewportView(tabelaLivros);
		JPCarrinho.setBounds(0, 0, 1008, 544);
		JPanelPrincipal.add(JPCarrinho);
		JPCarrinho.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 129, 462, 221);
		JPCarrinho.add(scrollPane);
		tabelaCarrinho = new JTable(modeloTabelaCarrinho);

		txtNifCARRINHO = new JTextField();
		txtNifCARRINHO.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String nif = txtNifCARRINHO.getText();
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (gl.viewComics.carrinhoExiste(nif)) {
						Carrinho c = gl.viewComics.pesquisarCarrinho(nif);
						modeloTabelaCarrinho.setRowCount(0);
						// gl.viewComics.limpatabela(modeloTabelaCarrinho);
						gl.viewComics.carrinhoTabela(c, modeloTabelaCarrinho);
						String precoTotal = gl.viewComics.precoTotalCarrinho(c);
						String totalLivros = gl.viewComics.totalLivrosCarrinho(c);
						txtPrecoTotalCARRINHO.setText(precoTotal);
						txtTotalLivrosCARRINHO.setText(totalLivros);
					} else {
						JOptionPane.showMessageDialog(null,
								"O nif que indicou nao corresponde a um carrinho em loja. Confirme criou o seu carrinho");
					}
				}
			}
		});
		txtNifCARRINHO.setBounds(32, 79, 198, 25);
		JPCarrinho.add(txtNifCARRINHO);
		txtNifCARRINHO.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nif :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(32, 37, 57, 31);
		JPCarrinho.add(lblNewLabel);

		scrollPane.setViewportView(tabelaCarrinho);

		JButton btnNewButton = new JButton("<HTML>Pretendo dar o meu carrinnho como finalizado<HTML>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nif = txtNifCARRINHO.getText();
				Carrinho c = gl.viewComics.pesquisarCarrinho(nif);
				gl.viewComics.finalizarCarrinho(c);
			}
		});
		btnNewButton.setBounds(115, 361, 139, 59);
		JPCarrinho.add(btnNewButton);

		txtPrecoTotalCARRINHO = new JTextField();
		txtPrecoTotalCARRINHO.setBounds(317, 361, 86, 25);
		JPCarrinho.add(txtPrecoTotalCARRINHO);
		txtPrecoTotalCARRINHO.setColumns(10);

		txtTotalLivrosCARRINHO = new JTextField();
		txtTotalLivrosCARRINHO.setColumns(10);
		txtTotalLivrosCARRINHO.setBounds(317, 397, 84, 25);
		JPCarrinho.add(txtTotalLivrosCARRINHO);

		JLabel lblNewLabel_1 = new JLabel("\u20AC");
		lblNewLabel_1.setBounds(413, 361, 40, 25);
		JPCarrinho.add(lblNewLabel_1);

		JLabel lblItems = new JLabel("items");
		lblItems.setBounds(413, 395, 40, 25);
		JPCarrinho.add(lblItems);

		ButtonGroup alterarCarrinho = new ButtonGroup();

		// tornar os respectivos paineis visiveis ao clicar

		btnLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPCarrinho.setVisible(false);
				JPLivros.setVisible(true);

			}
		});

		btnCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPLivros.setVisible(false);
				JPCarrinho.setVisible(true);
				if (!txtNifCarrinhoLIVROS.getText().equals("")) {
					txtNifCARRINHO.setText(txtNifCarrinhoLIVROS.getText());

					if (gl.viewComics.carrinhoExiste(txtNifCARRINHO.getText())) {
						Carrinho c = gl.viewComics.pesquisarCarrinho(txtNifCARRINHO.getText());
						// gl.viewComics.limpatabela(modeloTabelaCarrinho);
						modeloTabelaCarrinho.setRowCount(0);
						gl.viewComics.carrinhoTabela(c, modeloTabelaCarrinho);
						String precoTotal = gl.viewComics.precoTotalCarrinho(c);
						String totalLivros = gl.viewComics.totalLivrosCarrinho(c);
						txtPrecoTotalCARRINHO.setText(precoTotal);
						txtTotalLivrosCARRINHO.setText(totalLivros);
					}

				}

			}
		});

		// botao para LogIn

		btnLogIn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String user = txtUsername.getText();
				String pass = new String(txtPassword.getPassword());
				boolean v = gl.getViewComics().verificarPassword(user, pass);
				if (v) {
					Utilizador utilizadorLogado = gl.getViewComics().loggado(user, pass);
					if (utilizadorLogado instanceof Funcionario) {
						AppFuncionario fun = new AppFuncionario((Funcionario) utilizadorLogado, gl);
						fun.run();
						frame.dispose();
					} else if (utilizadorLogado instanceof Administrador) {
						AppAdmin adm = new AppAdmin(utilizadorLogado, gl);
						adm.run();
						frame.dispose();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Username e/ou password incorrectos");
				}
			}

		});

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
				btnLivros.isSelected();
				btnLivros.setBackground(Color.YELLOW);
				btnCarrinho.setBackground(SystemColor.controlHighlight);

			}

		});

		// Carrinho

		btnCarrinho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnCarrinho.setBackground(Color.YELLOW);
			}

			public void mouseExited(MouseEvent arg0) {
				btnCarrinho.setBackground(SystemColor.controlHighlight);
			}

			public void mouseClicked(MouseEvent arg0) {
				btnCarrinho.setBackground(Color.YELLOW);
				btnLivros.setBackground(SystemColor.controlHighlight);
			}
		});
	}
}
