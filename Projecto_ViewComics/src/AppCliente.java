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
import javax.swing.event.ListSelectionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AppCliente implements Serializable {

	private JFrame frame;
	private JTextField txtQuantidadeAlterarLIVROS;
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	private JTextField txtStockLivros;
	private JTextField txtPrecoLivros;
	private JTextField txtDescricaoLivros;
	private JTextField txtDataLivros;
	private JTextField txtAutorLivros;
	private JTextField txtTituloLivros;
	private static GestaoLivraria gl;
	private JTextField txtNifCarrinhoLIVROS;
	private JTextField txtQuantidadeActualLivros;
	private final ButtonGroup alterarQuantidadeCarrinhoLIVROS = new ButtonGroup();
	private JTextField txtIdLivros;
	private JTextField txtNifCARRINHO;
	private JTable table;
	private JTextField txtPrecoTotalCARRINHO;
	private JTextField txtTotalLivrosCARRINHO;

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

					// importar imagem para o background do panel, podemos faz�-lo da internet ou
					// do
					// ficheiro

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

		JPanel JPCarrinho = new JPanel();
		JPCarrinho.setBounds(0, 0, 1008, 544);
		JPanelPrincipal.add(JPCarrinho);
		JPCarrinho.setLayout(null);
		table = new JTable();
		String[] colunas = { "Id do livro", "Titulo", "Autor", "Preco unitario", "Quantidade", "Preco total" };
		DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 129, 462, 221);
		JPCarrinho.add(scrollPane);
		table = new JTable(modeloTabela);

		txtNifCARRINHO = new JTextField();
		txtNifCARRINHO.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String nif = txtNifCARRINHO.getText();
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (gl.viewComics.carrinhoExiste(nif)) {
						Carrinho c = gl.viewComics.pesquisarCarrinho(nif);
						gl.viewComics.carrinhoTabela(c, modeloTabela);
						String precoTotal=gl.viewComics.precoTotalCarrinho(c);
						String totalLivros=gl.viewComics.totalLivrosCarrinho(c);
						txtPrecoTotalCARRINHO.setText(precoTotal);
						txtTotalLivrosCARRINHO.setText(totalLivros);
					} else {
						JOptionPane.showMessageDialog(null,
								"O nif que indicou n�o corresponde a um carrinho em loja. Confirme se j� criou o seu carrinho");
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

		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("<HTML>Pretendo dar o meu carrinnho como finalizado<HTML>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nif=txtNifCARRINHO.getText();
				Carrinho c=gl.viewComics.pesquisarCarrinho(nif);
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

		// O painel nao inicia visivel
		JPCarrinho.setVisible(false);

		// JPanel JPLivros = new JPanel() {
		// @Override
		// // o paint component vai pintar literalmente o componente
		// protected void paintComponent(Graphics g) {
		//
		// super.paintComponent(g);
		// Image img;
		// try {
		//
		// // importar imagem para o background do panel, podemos faz�-lo da internet
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
		JPLivros.setVisible(false);

		Choice choiceAtributoLivroCliente = new Choice();
		choiceAtributoLivroCliente.setBounds(65, 63, 200, 20);
		JPLivros.add(choiceAtributoLivroCliente);
		choiceAtributoLivroCliente.add("(por que crit�rio pretende pesquisar o livro)");
		choiceAtributoLivroCliente.add("Titulo");
		choiceAtributoLivroCliente.add("Autor");
		choiceAtributoLivroCliente.add("Id");

		TextField txtAtributoLivros = new TextField();
		txtAtributoLivros.setBounds(65, 96, 200, 22);
		JPLivros.add(txtAtributoLivros);
		DefaultListModel<String> modeloLista = new DefaultListModel<String>();
		JList<String> listaLivros = new JList<String>(modeloLista);
		listaLivros.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {

				if (!listaLivros.isSelectionEmpty()) {

					String livroSeleccionadoSTR = listaLivros.getSelectedValue();
					int idLivroSeleccionado = gl.viewComics.obterIdLivro(livroSeleccionadoSTR);
					Livro l = gl.viewComics.livroId(idLivroSeleccionado);

					txtIdLivros.setText(Integer.toString(gl.viewComics.obterIdLivro(livroSeleccionadoSTR)));
					txtTituloLivros.setText(l.getTitulo());
					txtAutorLivros.setText(l.getAutor());
					txtDataLivros.setText(Integer.toString(l.getAno()));
					txtDescricaoLivros.setText(l.getDescricao());
					txtStockLivros.setText(Integer.toString(l.getStock()));
					txtPrecoLivros.setText("" + l.getPreco());
					String nif = txtNifCarrinhoLIVROS.getText();
					String quantidadeActual = gl.viewComics.quantidadeCarrinho(idLivroSeleccionado, nif);
					txtQuantidadeActualLivros.setText(quantidadeActual);

				}
			}
		});
		listaLivros.setBounds(65, 140, 289, 348);
		JPLivros.add(listaLivros);

		// botaoPesquisarLivro
		JButton btnPesquisarLivro = new JButton("Pesquisar");
		btnPesquisarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (choiceAtributoLivroCliente.getSelectedItem().equals("Titulo")) {
					String titulo = txtAtributoLivros.getText();
					modeloLista.removeAllElements();
					gl.viewComics.addArrayLista(gl.viewComics.listaTitulo(titulo), modeloLista);

				} else if (choiceAtributoLivroCliente.getSelectedItem().equals("Autor")) {
					String autor = txtAtributoLivros.getText();
					modeloLista.removeAllElements();
					gl.viewComics.addArrayLista(gl.viewComics.listaAutor(autor), modeloLista);

				} else if (choiceAtributoLivroCliente.getSelectedItem().equals("Id")) {
					String id = txtAtributoLivros.getText();
					modeloLista.removeAllElements();
					gl.viewComics.addArrayLista(gl.viewComics.listaLivroId(id), modeloLista);

				}

			}
		});
		btnPesquisarLivro.setBackground(SystemColor.controlHighlight);
		btnPesquisarLivro.setBounds(286, 98, 115, 20);
		JPLivros.add(btnPesquisarLivro);

		txtQuantidadeAlterarLIVROS = new JTextField();
		txtQuantidadeAlterarLIVROS.setColumns(10);
		txtQuantidadeAlterarLIVROS.setBounds(816, 129, 40, 41);
		JPLivros.add(txtQuantidadeAlterarLIVROS);
		JRadioButton rbAdicionarQuantidadeLIVROS = new JRadioButton("Adicionar");
		alterarQuantidadeCarrinhoLIVROS.add(rbAdicionarQuantidadeLIVROS);
		rbAdicionarQuantidadeLIVROS.setBounds(862, 127, 109, 23);
		JPLivros.add(rbAdicionarQuantidadeLIVROS);

		JRadioButton rbRemoverQuantidadeLIVROS = new JRadioButton("Remover");
		alterarQuantidadeCarrinhoLIVROS.add(rbRemoverQuantidadeLIVROS);
		rbRemoverQuantidadeLIVROS.setBounds(862, 147, 109, 23);
		JPLivros.add(rbRemoverQuantidadeLIVROS);
		// actualiza o carrinho do nif inserido e com as altera��es pedidas
		// dependendo
		// do radiobutton escolhido para acrescentar ou remover uma
		// certa quantidade de um item
		JButton btnAddCarrinhoFinalCliente = new JButton("Alterar carrinho");
		btnAddCarrinhoFinalCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String livroSeleccionado = listaLivros.getSelectedValue();
				int idLivroSelec = gl.viewComics.obterIdLivro(livroSeleccionado);

				String nif = txtNifCarrinhoLIVROS.getText();

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
							quantidadeActualLIVROSstr = gl.viewComics.adicionarQuantidade(
									txtQuantidadeActualLivros.getText(), txtQuantidadeAlterarLIVROS.getText());
							int quantidadeActualLIVROSint = Integer.parseInt(quantidadeActualLIVROSstr);
							gl.viewComics.updateConteudoCarrinho(nif, idLivroSelec, quantidadeActualLIVROSint);
							txtQuantidadeActualLivros.setText(quantidadeActualLIVROSstr);
							gl.viewComics.updateConteudoCarrinho(nif, idLivroSelec, quantidadeActualLIVROSint);

						}
						if (rbRemoverQuantidadeLIVROS.isSelected()) {
							quantidadeActualLIVROSstr = gl.viewComics.removerQuantidade(
									txtQuantidadeActualLivros.getText(), txtQuantidadeAlterarLIVROS.getText());
							int quantidadeActualLIVROSint = Integer.parseInt(quantidadeActualLIVROSstr);
							gl.viewComics.updateConteudoCarrinho(nif, idLivroSelec, quantidadeActualLIVROSint);
							txtQuantidadeActualLivros.setText(quantidadeActualLIVROSstr);
							gl.viewComics.updateConteudoCarrinho(nif, idLivroSelec, quantidadeActualLIVROSint);

						}
					} else {
						JOptionPane.showMessageDialog(null,
								"O nif introduzido n�o consta na nossa base de dados de carrinhos. Por favor primeiro crie um carrinho com o seu nif.");
					}
//				modeloLista.removeAllElements();
//				gl.viewComics.addArrayLista(gl.viewComics.arrayLivros(gl.viewComics.getLivros()), modeloLista);
//				txtNifCarrinhoLIVROS.setText("---------");
				}
			}
		});
		btnAddCarrinhoFinalCliente.setBackground(SystemColor.controlHighlight);
		btnAddCarrinhoFinalCliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddCarrinhoFinalCliente.setBounds(746, 84, 183, 42);
		JPLivros.add(btnAddCarrinhoFinalCliente);

		JLabel label_2 = new JLabel("Nome:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(443, 182, 48, 16);
		JPLivros.add(label_2);

		JLabel label_3 = new JLabel("Autor:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(443, 223, 48, 16);
		JPLivros.add(label_3);

		JLabel label_4 = new JLabel("Data:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(443, 264, 40, 16);
		JPLivros.add(label_4);

		JLabel label_5 = new JLabel("Descri\u00E7\u00E3o:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(416, 310, 87, 16);
		JPLivros.add(label_5);

		JLabel label_6 = new JLabel("Pre\u00E7o:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(443, 430, 48, 16);
		JPLivros.add(label_6);

		JLabel label_7 = new JLabel("Stock:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_7.setBounds(443, 472, 48, 16);
		JPLivros.add(label_7);

		txtStockLivros = new JTextField();
		txtStockLivros.setEditable(false);
		txtStockLivros.setColumns(10);
		txtStockLivros.setBounds(513, 469, 87, 30);
		JPLivros.add(txtStockLivros);

		txtPrecoLivros = new JTextField();
		txtPrecoLivros.setEditable(false);
		txtPrecoLivros.setColumns(10);
		txtPrecoLivros.setBounds(513, 428, 87, 30);
		JPLivros.add(txtPrecoLivros);

		txtDescricaoLivros = new JTextField();
		txtDescricaoLivros.setEditable(false);
		txtDescricaoLivros.setColumns(10);
		txtDescricaoLivros.setBounds(513, 300, 345, 117);
		JPLivros.add(txtDescricaoLivros);

		txtDataLivros = new JTextField();
		txtDataLivros.setEditable(false);
		txtDataLivros.setColumns(10);
		txtDataLivros.setBounds(513, 259, 345, 30);
		JPLivros.add(txtDataLivros);

		txtAutorLivros = new JTextField();
		txtAutorLivros.setEditable(false);
		txtAutorLivros.setColumns(10);
		txtAutorLivros.setBounds(513, 218, 345, 30);
		JPLivros.add(txtAutorLivros);

		txtTituloLivros = new JTextField();
		txtTituloLivros.setEditable(false);
		txtTituloLivros.setColumns(10);
		txtTituloLivros.setBounds(513, 177, 345, 30);
		JPLivros.add(txtTituloLivros);

		txtNifCarrinhoLIVROS = new JTextField("---------");
		txtNifCarrinhoLIVROS.setBounds(513, 34, 175, 29);
		JPLivros.add(txtNifCarrinhoLIVROS);
		txtNifCarrinhoLIVROS.setColumns(10);

		JLabel lblIntroduzaOSeu = new JLabel("INTRODUZA O SEU NIF");
		lblIntroduzaOSeu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIntroduzaOSeu.setBounds(519, 11, 140, 20);
		JPLivros.add(lblIntroduzaOSeu);

		txtQuantidadeActualLivros = new JTextField();
		txtQuantidadeActualLivros.setEditable(false);
		txtQuantidadeActualLivros.setBounds(657, 71, 40, 30);
		JPLivros.add(txtQuantidadeActualLivros);
		txtQuantidadeActualLivros.setColumns(10);

		JLabel lblqtddCarrinho = new JLabel("Quantidade deste item no seu carrinho:");
		lblqtddCarrinho.setBounds(462, 75, 232, 22);
		JPLivros.add(lblqtddCarrinho);

		JButton btnLimparPesquisaCliente = new JButton("Limpar");
		btnLimparPesquisaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtAtributoLivros.setText("");
				modeloLista.removeAllElements();
				gl.viewComics.addArrayLista(gl.viewComics.arrayLivros(gl.viewComics.getLivros()), modeloLista);
			}
		});
		btnLimparPesquisaCliente.setBackground(SystemColor.controlHighlight);
		btnLimparPesquisaCliente.setBounds(286, 63, 115, 20);
		JPLivros.add(btnLimparPesquisaCliente);

		txtIdLivros = new JTextField();
		txtIdLivros.setEditable(false);
		txtIdLivros.setColumns(10);
		txtIdLivros.setBounds(513, 138, 48, 30);
		JPLivros.add(txtIdLivros);

		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(462, 138, 29, 16);
		JPLivros.add(lblId);

		// verifica e insere a quantidade que existe de um item em um carrinho
		JButton btnVerificarCarrinhoLIVROS = new JButton("Criar carrinho");
		btnVerificarCarrinhoLIVROS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nif = txtNifCarrinhoLIVROS.getText();
				if (gl.viewComics.verificaNif(nif)) {
					if (gl.viewComics.carrinhoExiste(nif)) {
						JOptionPane.showMessageDialog(null,
								"O nif que seleccionou j� corresponde a um carrinho em loja, para continuar compra basta alterar o seu carrinho");

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
		btnVerificarCarrinhoLIVROS.setBounds(746, 31, 183, 42);
		JPLivros.add(btnVerificarCarrinhoLIVROS);

		DefaultListModel<String> modeloListaNif = new DefaultListModel<String>();

		gl.viewComics.addArrayLista(gl.viewComics.arrayLivros(gl.viewComics.getLivros()), modeloLista);

		ButtonGroup alterarCarrinho = new ButtonGroup();

		// tornar os respectivos paineis vis�veis ao clicar

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

		// fazer logIn premindo Enter

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
