import java.awt.EventQueue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Choice;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.List;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Label;
import java.awt.FlowLayout;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AppFuncionario implements Serializable {

	private JFrame frame;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField txtAtributoPesquisaLivro;
	private JTextField txtTituloLivro;
	private JTextField txtAutorLivro;
	private JTextField txtDataLivro;
	private JTextField txtDescricaoLivro;
	private JTextField txtPrecoLivro;
	private JTextField txtStockLivro;
	private JTextField txtUsername;
	private JTextField txtNovoUsername;
	private JPasswordField passwordAntiga;
	private JPasswordField passwordNovaConfirm;
	private JTextField textFieldNifPagamento;
	private JTextField txtTotalPAGAMENTO;
	private JTextField txtRecebidoPAGAMENTO;
	private JTextField txtTrocoPAGAMENTO;
	private JPasswordField passwordNova;
	private JPasswordField passwordAlterarUser;

	private GestaoLivraria gl;
	private Funcionario func;
	private JTextField txtPrecoCarrinho;
	private JTextField txtQuantidadeLivrosCarrinho;
	private JTable tabelaCarrinhos;
	String[] colunas = { "Id do livro", "Titulo", "Autor", "Preco unitario", "Quantidade", "Preco total" };
	DefaultTableModel modeloTabelaCarrinhos = new DefaultTableModel(colunas, 0) {
		public boolean isCellEditable(int rowIndex, int mColIndex) {
			return false;
		}
	};
	DefaultListModel<String> modeloListaNif = new DefaultListModel<String>();
	JPanel jpPagamento = new JPanel();
	JPanel jpFuncLivros = new JPanel();
	JPanel jpFuncConta = new JPanel();
	DefaultListModel<String> dmFunListaLivros = new DefaultListModel<String>();
	String[] OpcoesPesquisaLIVRO = new String[] { "Título", "Autor", "Ano" };
	String[] OpcoesPesquisaCARRINHO = new String[] { "NIF", "Finalizado", "Por finalizar" };
	JComboBox cbPesquisaCARRINHO = new JComboBox(OpcoesPesquisaCARRINHO);
	private JTextField txtNifPesquisaCARRINHO;
	private JTextField txtEstadoCarrinho;
	private JTextField txtNovaQuantidadeCARRINHO;
	private JTextField txtLivroSeleccionadoCARRINHO;
	private JTextField txtNifSeleccionado;
	String[] itens = new String[] { "Escolha o método de pagamento", "Dinheiro", "Multibanco" };

	/**
	 * Launch the application.
	 */
	// EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			AppFuncionario window = new AppFuncionario(func, gl);
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// });

	/**
	 * Create the application.
	 */
	public AppFuncionario(Funcionario f, GestaoLivraria livraria) {
		func = f;
		gl = livraria;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
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

		JPanel Paineltotal = new JPanel();
		Paineltotal.setBackground(Color.ORANGE);
		Paineltotal.setBounds(0, 0, 1262, 721);
		frame.getContentPane().add(Paineltotal);
		Paineltotal.setLayout(null);

		JPanel panelcabecalho = new JPanel();
		panelcabecalho.setBackground(new Color(255, 215, 0));
		panelcabecalho.setLayout(null);
		panelcabecalho.setBounds(0, 0, 1262, 176);
		Paineltotal.add(panelcabecalho);

//		{
//			@Override
//			protected void paintComponent(Graphics g) {
//
//				super.paintComponent(g);
//				Image img;
//				try {
//
//
//					img = ImageIO.read(new File(""));
//					g.drawImage(img, 0, 0, null);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//			}
//		};

		JLabel label_6 = new JLabel() {
			protected void paintComponent(Graphics g) {
			}
		};
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Papyrus", Font.BOLD, 46));
		label_6.setBounds(96, 67, 0, 0);
		panelcabecalho.add(label_6);

		JLabel label_7 = new JLabel("ViewComics Inc.");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tempus Sans ITC", Font.BOLD, 95));
		label_7.setBounds(101, 5, 730, 125);
		panelcabecalho.add(label_7);

		JLabel lblBemVindonome = new JLabel("Bem Vindo funcionrio");
		lblBemVindonome.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindonome.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		lblBemVindonome.setBounds(843, 15, 245, 27);
		panelcabecalho.add(lblBemVindonome);

		JButton btnLogOut = new JButton("LogOut");
		btnLogOut.setBackground(SystemColor.controlHighlight);
		btnLogOut.setBounds(1138, 54, 89, 23);
		panelcabecalho.add(btnLogOut);

		// label nome do funcionario
		JLabel lblFunNome = new JLabel("<html>" + func.getNome() + "<html>");
		lblFunNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblFunNome.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		lblFunNome.setBounds(1066, 15, 160, 27);
		panelcabecalho.add(lblFunNome);

		JPanel panelMenu = new JPanel();
//		{
//			@Override
//			protected void paintComponent(Graphics g) {
//
//				super.paintComponent(g);
//				Image img;
//				try {
//
//					// img = ImageIO.read(new URL(
//					// "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
//					img = ImageIO.read(new File(""));
//					g.drawImage(img, 0, 0, null);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//			}
//		};
		panelMenu.setLayout(null);
		panelMenu.setBounds(0, 176, 241, 545);
		Paineltotal.add(panelMenu);

		JPanel panelPrincipal = new JPanel();
		// cbPesquisaCARRINHO.add("Estado");

		jpPagamento.setBounds(0, 0, 219, 346);
		panelPrincipal.add(jpPagamento);
		jpPagamento.setLayout(null);
		jpPagamento.setVisible(false);

		JPanel jpDinheiro = new JPanel();
		jpDinheiro.setBounds(10, 190, 199, 171);
		jpPagamento.add(jpDinheiro);
		jpDinheiro.setLayout(null);
		jpDinheiro.setVisible(false);
		JComboBox comboBoxTipoPagamento = new JComboBox(itens);
		comboBoxTipoPagamento.setBounds(20, 24, 172, 22);
		comboBoxTipoPagamento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				// check whether there is any selection
				if (comboBoxTipoPagamento.getSelectedItem().equals("Dinheiro")) {
					jpDinheiro.setVisible(true);

				}
			}
		});
		jpPagamento.add(comboBoxTipoPagamento);

		textFieldNifPagamento = new JTextField();
		textFieldNifPagamento.setBounds(20, 94, 172, 22);
		jpPagamento.add(textFieldNifPagamento);
		textFieldNifPagamento.setColumns(10);

		JLabel lblNif_1 = new JLabel("NIF");
		lblNif_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNif_1.setBounds(22, 69, 46, 14);
		jpPagamento.add(lblNif_1);

		JLabel lblNewLabel_1 = new JLabel("A pagar :");
		lblNewLabel_1.setBounds(10, 11, 76, 23);
		jpDinheiro.add(lblNewLabel_1);

		JLabel lblRecebido = new JLabel("Recebido : ");
		lblRecebido.setBounds(10, 45, 76, 23);
		jpDinheiro.add(lblRecebido);

		JLabel lblTroco = new JLabel("Troco :");
		lblTroco.setBounds(10, 79, 76, 23);
		jpDinheiro.add(lblTroco);

		txtTotalPAGAMENTO = new JTextField();
		txtTotalPAGAMENTO.setBounds(72, 12, 86, 20);
		jpDinheiro.add(txtTotalPAGAMENTO);
		txtTotalPAGAMENTO.setColumns(10);

		txtRecebidoPAGAMENTO = new JTextField();
		txtRecebidoPAGAMENTO.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String totalComVirgula = txtTotalPAGAMENTO.getText();
					String totalSemVirgula = totalComVirgula.replace(',', '.');
					Double total = Double.parseDouble(totalSemVirgula);
					Double recebido = Double.parseDouble(txtRecebidoPAGAMENTO.getText());
					Double troco = recebido - total;
					DecimalFormat df = new DecimalFormat("#.##");
					String trocoSTR = df.format(troco);
					txtTrocoPAGAMENTO.setText(trocoSTR);
				}
			}
		});
		txtRecebidoPAGAMENTO.setColumns(10);
		txtRecebidoPAGAMENTO.setBounds(72, 45, 86, 20);
		jpDinheiro.add(txtRecebidoPAGAMENTO);

		txtTrocoPAGAMENTO = new JTextField();
		txtTrocoPAGAMENTO.setColumns(10);
		txtTrocoPAGAMENTO.setBounds(72, 80, 86, 20);
		jpDinheiro.add(txtTrocoPAGAMENTO);

		// botao concluir pagamento
		JButton btnConcluirPagamento = new JButton("Concluir");
		btnConcluirPagamento.setBackground(SystemColor.controlHighlight);
		btnConcluirPagamento.setBounds(33, 114, 125, 30);
		btnConcluirPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!txtTotalPAGAMENTO.getText().isEmpty()) {
					String nif = textFieldNifPagamento.getText();
					Carrinho c = gl.viewComics.pesquisarCarrinho(nif);
					String total =txtTotalPAGAMENTO.getText();
					String total2=total.replace(",", ".");
					double montante = Double.parseDouble(total2);
					HashMap<Integer, Integer> conteudoVenda = c.getConteudo();
					Venda v = new Venda(montante, conteudoVenda, nif);
					gl.viewComics.addVenda(v);
					gl.viewComics.incrementarVendasLivros(v);
				}
			}
		});
		jpDinheiro.add(btnConcluirPagamento);

		JPanel jpFuncCarrinhos = new JPanel();
		jpFuncCarrinhos.setBounds(0, 0, 825, 545);
		panelPrincipal.add(jpFuncCarrinhos);
		jpFuncCarrinhos.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(283, 140, 500, 178);
		jpFuncCarrinhos.add(scrollPane_1);
		tabelaCarrinhos = new JTable(modeloTabelaCarrinhos);
		tabelaCarrinhos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = tabelaCarrinhos.getSelectedRow();
				int idLivro = (int) tabelaCarrinhos.getModel().getValueAt(linha, 0);
				Livro l = gl.viewComics.livroId(idLivro);
				txtLivroSeleccionadoCARRINHO.setText(l.toString());

			}
		});
		scrollPane_1.setViewportView(tabelaCarrinhos);

		JLabel lblPreoDoCarrinho = new JLabel("Pre\u00E7o do carrinho :");
		lblPreoDoCarrinho.setBounds(283, 339, 163, 14);
		lblPreoDoCarrinho.setFont(new Font("Tahoma", Font.BOLD, 13));
		jpFuncCarrinhos.add(lblPreoDoCarrinho);

		JLabel lblQuantidadeDeLivros = new JLabel("Quantidade de livros :");
		lblQuantidadeDeLivros.setBounds(283, 366, 163, 14);
		lblQuantidadeDeLivros.setFont(new Font("Tahoma", Font.BOLD, 13));
		jpFuncCarrinhos.add(lblQuantidadeDeLivros);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 144, 200, 320);
		jpFuncCarrinhos.add(scrollPane);
		JList<String> listNifsClientes = new JList<String>(modeloListaNif);
		scrollPane.setViewportView(listNifsClientes);
		listNifsClientes.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				// limpa tabela
				modeloTabelaCarrinhos.setRowCount(0);

				// se a lista estiver seleccionada, copia para as caixas de texto
				if (!listNifsClientes.isSelectionEmpty()) {
					String nifSeleccionado = listNifsClientes.getSelectedValue();
					txtNifSeleccionado.setText(nifSeleccionado);
					Carrinho c = gl.viewComics.pesquisarCarrinho(nifSeleccionado);
					String estado = "";
					if (c.isFinalizado()) {
						txtEstadoCarrinho.setText("Finalizado");
						txtEstadoCarrinho.setBackground(Color.GREEN);
					} else {
						txtEstadoCarrinho.setText("Por finalizar");
						txtEstadoCarrinho.setBackground(Color.RED);
					}

					String precoCarrinho = gl.viewComics.precoTotalCarrinho(c);
					txtPrecoCarrinho.setText(precoCarrinho);
					String quantidadeItemsCarrinho = gl.viewComics.totalLivrosCarrinho(c);
					txtQuantidadeLivrosCarrinho.setText(quantidadeItemsCarrinho);

					gl.viewComics.carrinhoTabela(c, modeloTabelaCarrinhos);
				}
			}
		});

		JButton btnPesquisarCarrinhos = new JButton("Pesquisar");
		btnPesquisarCarrinhos.setBounds(25, 91, 104, 30);
		btnPesquisarCarrinhos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nif = txtNifPesquisaCARRINHO.getText();

				if (cbPesquisaCARRINHO.getSelectedItem().equals("NIF")) {
					modeloListaNif.removeAllElements();
					gl.viewComics.addArrayLista(gl.viewComics.listaNifs(nif), modeloListaNif);
				}

				else if (cbPesquisaCARRINHO.getSelectedItem().equals("Finalizado")) {
					modeloListaNif.removeAllElements();
					gl.viewComics.addArrayLista(gl.viewComics.carrinhosFinalizados(), modeloListaNif);

				} else if (cbPesquisaCARRINHO.getSelectedItem().equals("Por finalizar")) {
					modeloListaNif.removeAllElements();
					gl.viewComics.addArrayLista(gl.viewComics.carrinhosNAOFinalizados(), modeloListaNif);

				}

			}
		});
		btnPesquisarCarrinhos.setBackground(SystemColor.controlHighlight);
		jpFuncCarrinhos.add(btnPesquisarCarrinhos);

		JButton btnCancelar = new JButton("Eliminar carrinho");
		btnCancelar.setBounds(562, 384, 172, 30);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!listNifsClientes.isSelectionEmpty()) {
					String nif = listNifsClientes.getSelectedValue();
					Carrinho c = gl.viewComics.pesquisarCarrinho(nif);
					gl.viewComics.removeCarrinho(c);
				} else if (listNifsClientes.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Seleccione o nif da lista que corresponde ao carrinho que quer eliminar");
				}
			}
		});
		btnCancelar.setBackground(SystemColor.controlHighlight);
		jpFuncCarrinhos.add(btnCancelar);

		// botao de pagamento, abre a janela pagamento
		JButton btnPagamento = new JButton("Realizar pagamento");
		btnPagamento.setBounds(563, 332, 172, 30);
		btnPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpFuncCarrinhos.setVisible(false);
				jpFuncLivros.setVisible(false);
				jpFuncConta.setVisible(false);
				jpPagamento.setVisible(true);

				int nif = Integer.parseInt(listNifsClientes.getSelectedValue());
				textFieldNifPagamento.setText(nif + "");
				txtTotalPAGAMENTO.setText(txtPrecoCarrinho.getText());

			}
		});
		btnPagamento.setBackground(SystemColor.controlHighlight);
		jpFuncCarrinhos.add(btnPagamento);

		JButton bttLimparFun = new JButton("Limpar");
		bttLimparFun.setBounds(136, 91, 100, 30);
		bttLimparFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listNifsClientes.clearSelection();
				modeloListaNif.removeAllElements();
				gl.viewComics.addArrayLista(gl.viewComics.arrayNifs(), modeloListaNif);

			}
		});
		bttLimparFun.setBackground(SystemColor.controlHighlight);
		jpFuncCarrinhos.add(bttLimparFun);

		txtPrecoCarrinho = new JTextField();
		txtPrecoCarrinho.setBounds(418, 339, 51, 20);
		txtPrecoCarrinho.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPrecoCarrinho.setEditable(false);
		jpFuncCarrinhos.add(txtPrecoCarrinho);
		txtPrecoCarrinho.setColumns(10);

		txtQuantidadeLivrosCarrinho = new JTextField();
		txtQuantidadeLivrosCarrinho.setBounds(432, 364, 61, 20);
		txtQuantidadeLivrosCarrinho.setHorizontalAlignment(SwingConstants.RIGHT);
		txtQuantidadeLivrosCarrinho.setEditable(false);
		jpFuncCarrinhos.add(txtQuantidadeLivrosCarrinho);
		txtQuantidadeLivrosCarrinho.setColumns(10);

		JLabel label_8 = new JLabel("\u20AC");
		label_8.setBounds(473, 341, 31, 14);
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		jpFuncCarrinhos.add(label_8);

		JLabel lblConteudoDetalhadoDo = new JLabel("Conteudo detalhado do carrinho:");
		lblConteudoDetalhadoDo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConteudoDetalhadoDo.setBounds(283, 108, 275, 20);
		jpFuncCarrinhos.add(lblConteudoDetalhadoDo);

		JButton btnAlterarCARRINHO = new JButton("Alterar quantidades");
		btnAlterarCARRINHO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txtNovaQuantidadeCARRINHO.setEditable(true);

			}
		});
		btnAlterarCARRINHO.setBounds(635, 27, 148, 30);
		jpFuncCarrinhos.add(btnAlterarCARRINHO);

		JButton btnConcluirAlteracaoCARRINHO = new JButton("Concluir");
		btnConcluirAlteracaoCARRINHO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!listNifsClientes.isSelectionEmpty()) {
					String novaQuantidadeSTR = txtNovaQuantidadeCARRINHO.getText();
					String nif = txtNifSeleccionado.getText();
					int linha = tabelaCarrinhos.getSelectedRow();
					int idLivro = (int) tabelaCarrinhos.getModel().getValueAt(linha, 0);
					int novaQuantidadeINT = Integer.parseInt(novaQuantidadeSTR);
					tabelaCarrinhos.getModel().setValueAt(novaQuantidadeINT, linha, 4);
					gl.viewComics.updateConteudoCarrinho(nif, idLivro, novaQuantidadeINT);
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione o nif do carrinho");
				}
				txtNovaQuantidadeCARRINHO.setText("");
				txtNovaQuantidadeCARRINHO.setEditable(true);

			}
		});
		btnConcluirAlteracaoCARRINHO.setBounds(694, 106, 89, 23);
		jpFuncCarrinhos.add(btnConcluirAlteracaoCARRINHO);

		cbPesquisaCARRINHO.setBounds(25, 29, 211, 27);
		jpFuncCarrinhos.add(cbPesquisaCARRINHO);

		JLabel lblFiltrarPor = new JLabel("Filtrar por :");
		lblFiltrarPor.setBounds(25, 11, 104, 14);
		jpFuncCarrinhos.add(lblFiltrarPor);

		txtNifPesquisaCARRINHO = new JTextField();
		txtNifPesquisaCARRINHO.setBounds(25, 60, 155, 20);
		jpFuncCarrinhos.add(txtNifPesquisaCARRINHO);
		txtNifPesquisaCARRINHO.setColumns(10);

		txtEstadoCarrinho = new JTextField();
		txtEstadoCarrinho.setEditable(false);
		txtEstadoCarrinho.setBounds(283, 60, 125, 30);
		jpFuncCarrinhos.add(txtEstadoCarrinho);
		txtEstadoCarrinho.setColumns(10);

		txtNovaQuantidadeCARRINHO = new JTextField();
		txtNovaQuantidadeCARRINHO.setEditable(false);
		txtNovaQuantidadeCARRINHO.setBounds(694, 68, 86, 27);
		jpFuncCarrinhos.add(txtNovaQuantidadeCARRINHO);
		txtNovaQuantidadeCARRINHO.setColumns(10);

		txtLivroSeleccionadoCARRINHO = new JTextField();
		txtLivroSeleccionadoCARRINHO.setEditable(false);
		txtLivroSeleccionadoCARRINHO.setBounds(434, 67, 253, 30);
		jpFuncCarrinhos.add(txtLivroSeleccionadoCARRINHO);
		txtLivroSeleccionadoCARRINHO.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Livro seleccionado :");
		lblNewLabel_2.setBounds(434, 46, 148, 20);
		jpFuncCarrinhos.add(lblNewLabel_2);

		txtNifSeleccionado = new JTextField();
		txtNifSeleccionado.setEditable(false);
		txtNifSeleccionado.setBounds(283, 22, 125, 30);
		jpFuncCarrinhos.add(txtNifSeleccionado);
		txtNifSeleccionado.setColumns(10);

		jpFuncLivros.setBounds(0, 0, 825, 545);
		panelPrincipal.add(jpFuncLivros);
		jpFuncLivros.setLayout(null);
		jpFuncLivros.setVisible(false);
		JComboBox comboBoxAtributoLivro = new JComboBox(OpcoesPesquisaLIVRO);
		comboBoxAtributoLivro.setBounds(12, 13, 200, 30);
		jpFuncLivros.add(comboBoxAtributoLivro);

		txtAtributoPesquisaLivro = new JTextField();
		txtAtributoPesquisaLivro.setBounds(12, 57, 200, 30);
		jpFuncLivros.add(txtAtributoPesquisaLivro);
		txtAtributoPesquisaLivro.setColumns(10);

		// Guardar na lista o array/copia da lista de livros
		JList<String> listaLivros = new JList<String>(dmFunListaLivros);
		listaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaLivros.setBounds(22, 111, 190, 395);
		listaLivros.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {

				// se a lista estiver seleccionada, copia para as caixas de texto
				if (!listaLivros.isSelectionEmpty()) {

					String livroSeleccionadoSTR = listaLivros.getSelectedValue();
					int idLivroSeleccionado = gl.viewComics.obterIdLivro(livroSeleccionadoSTR);
					Livro l = gl.viewComics.livroId(idLivroSeleccionado);

					txtTituloLivro.setText(l.getTitulo());
					txtAutorLivro.setText(l.getAutor());
					txtDataLivro.setText(Integer.toString(l.getAno()));
					txtDescricaoLivro.setText(l.getDescricao());
					txtPrecoLivro.setText(Double.toString(l.getPreco()));
					txtStockLivro.setText(Integer.toString(l.getStock()));

				}
			}
		});
		jpFuncLivros.add(listaLivros);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(263, 120, 48, 16);
		jpFuncLivros.add(lblNewLabel);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAutor.setBounds(263, 170, 48, 16);
		jpFuncLivros.add(lblAutor);

		JLabel lblDescrio = new JLabel("Data:");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescrio.setBounds(271, 219, 40, 16);
		jpFuncLivros.add(lblDescrio);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStock.setBounds(263, 455, 48, 16);
		jpFuncLivros.add(lblStock);

		JLabel lblPreo_1 = new JLabel("Pre\u00E7o:");
		lblPreo_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPreo_1.setBounds(263, 404, 48, 16);
		jpFuncLivros.add(lblPreo_1);

		JLabel lblPreo = new JLabel("Descri\u00E7\u00E3o:");
		lblPreo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPreo.setBounds(224, 266, 87, 16);
		jpFuncLivros.add(lblPreo);

		txtTituloLivro = new JTextField();
		txtTituloLivro.setEditable(false);
		txtTituloLivro.setColumns(10);
		txtTituloLivro.setBounds(333, 114, 345, 30);
		jpFuncLivros.add(txtTituloLivro);

		txtAutorLivro = new JTextField();
		txtAutorLivro.setEditable(false);
		txtAutorLivro.setColumns(10);
		txtAutorLivro.setBounds(333, 164, 345, 30);
		jpFuncLivros.add(txtAutorLivro);

		txtDataLivro = new JTextField();
		txtDataLivro.setEditable(false);
		txtDataLivro.setColumns(10);
		txtDataLivro.setBounds(333, 213, 345, 30);
		jpFuncLivros.add(txtDataLivro);

		txtDescricaoLivro = new JTextField();
		txtDescricaoLivro.setEditable(false);
		txtDescricaoLivro.setColumns(10);
		txtDescricaoLivro.setBounds(333, 260, 345, 117);
		jpFuncLivros.add(txtDescricaoLivro);

		txtPrecoLivro = new JTextField();
		txtPrecoLivro.setEditable(false);
		txtPrecoLivro.setColumns(10);
		txtPrecoLivro.setBounds(333, 402, 345, 30);
		jpFuncLivros.add(txtPrecoLivro);

		txtStockLivro = new JTextField();
		txtStockLivro.setEditable(false);
		txtStockLivro.setColumns(10);
		txtStockLivro.setBounds(333, 453, 345, 30);
		jpFuncLivros.add(txtStockLivro);

		// botao para pesquisar o livro
		JButton btnPesquisarLivro = new JButton("Pesquisar");
		btnPesquisarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboBoxAtributoLivro.getSelectedItem().equals("Título")) {

					String titulo = txtAtributoPesquisaLivro.getText();
					dmFunListaLivros.removeAllElements();
					gl.viewComics.addArrayLista(gl.viewComics.listaTitulo(titulo), dmFunListaLivros);

				}
				if (comboBoxAtributoLivro.getSelectedItem().equals("Autor")) {

					String autor = txtAtributoPesquisaLivro.getText();
					dmFunListaLivros.removeAllElements();
					gl.viewComics.addArrayLista(gl.viewComics.listaAutor(autor), dmFunListaLivros);

				}
				if (comboBoxAtributoLivro.getSelectedItem().equals("Ano")) {

					String data = txtAtributoPesquisaLivro.getText();
					dmFunListaLivros.removeAllElements();
					gl.viewComics.addArrayLista(gl.viewComics.listaData(data), dmFunListaLivros);

				}

			}
		});
		btnPesquisarLivro.setBackground(SystemColor.controlHighlight);
		btnPesquisarLivro.setBounds(224, 16, 97, 25);
		jpFuncLivros.add(btnPesquisarLivro);

		// botao limpar secçao do livro
		JButton btnLimparLivro = new JButton("Limpar");
		btnLimparLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtAtributoPesquisaLivro.setText(null);
				txtTituloLivro.setText(null);
				txtAutorLivro.setText(null);
				txtDataLivro.setText(null);
				txtDescricaoLivro.setText(null);
				txtPrecoLivro.setText(null);
				txtStockLivro.setText(null);

			}
		});
		btnLimparLivro.setBackground(SystemColor.controlHighlight);
		btnLimparLivro.setBounds(224, 60, 97, 25);
		jpFuncLivros.add(btnLimparLivro);

		jpFuncConta.setBounds(0, 0, 825, 545);
		panelPrincipal.add(jpFuncConta);
		jpFuncConta.setLayout(null);
		jpFuncConta.setVisible(false);

		JLabel label = new JLabel("Alterar UserName:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setAlignmentX(0.5f);
		label.setBounds(105, 48, 203, 31);
		jpFuncConta.add(label);

		JLabel label_1 = new JLabel("UserName:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(67, 92, 113, 24);
		jpFuncConta.add(label_1);

		txtUsername = new JTextField(func.getUsername());
		txtUsername.setEditable(false);
		txtUsername.setBounds(67, 129, 279, 31);
		jpFuncConta.add(txtUsername);

		JLabel label_2 = new JLabel("Password:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(67, 173, 113, 24);
		jpFuncConta.add(label_2);

		JLabel label_3 = new JLabel("Novo UserName:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(67, 254, 171, 24);
		jpFuncConta.add(label_3);

		txtNovoUsername = new JTextField();
		txtNovoUsername.setBounds(67, 284, 279, 31);
		jpFuncConta.add(txtNovoUsername);

		passwordAlterarUser = new JPasswordField();
		passwordAlterarUser.setBounds(67, 202, 140, 31);
		jpFuncConta.add(passwordAlterarUser);
		panelPrincipal.setBackground(new Color(255, 250, 205));
		panelPrincipal.setBounds(240, 176, 1022, 545);
		Paineltotal.add(panelPrincipal);
		panelPrincipal.setLayout(null);

		// Combobox com os itens para pagamento
		// lista dos itens na comboBox

		// Lista do nifs dos carrinhos

		gl.viewComics.addArrayLista(gl.viewComics.arrayNifs(), modeloListaNif);

		// botao confirmar da username
		JButton btnConfirmarUsername = new JButton("Confirmar");
		btnConfirmarUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (func.getPassword().equals(String.valueOf(passwordAlterarUser.getPassword()))) {

					func.setUsername(txtNovoUsername.getText());
					passwordAlterarUser.setText(null);
					txtNovoUsername.setText(null);
					txtUsername.setText(func.getUsername());
					JOptionPane.showMessageDialog(null, "O username foi alterado com sucesso!");

				}

			}
		});
		btnConfirmarUsername.setBackground(SystemColor.controlHighlight);
		btnConfirmarUsername.setBounds(67, 359, 97, 25);
		jpFuncConta.add(btnConfirmarUsername);

		JButton btnCancelarUsername = new JButton("Cancelar");
		btnCancelarUsername.setBackground(SystemColor.controlHighlight);
		btnCancelarUsername.setBounds(249, 359, 97, 25);
		jpFuncConta.add(btnCancelarUsername);

		JLabel label_4 = new JLabel("Alterar PassWord:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_4.setAlignmentX(0.5f);
		label_4.setBounds(520, 50, 203, 31);
		jpFuncConta.add(label_4);

		JLabel label_5 = new JLabel("Password:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(520, 92, 113, 24);
		jpFuncConta.add(label_5);

		passwordAntiga = new JPasswordField();
		passwordAntiga.setBounds(520, 129, 279, 31);
		jpFuncConta.add(passwordAntiga);

		JLabel label_9 = new JLabel("Nova Password:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_9.setBounds(520, 173, 113, 24);
		jpFuncConta.add(label_9);

		JLabel label_10 = new JLabel("Confirmar Password:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_10.setBounds(520, 254, 171, 24);
		jpFuncConta.add(label_10);

		passwordNovaConfirm = new JPasswordField();
		passwordNovaConfirm.setBounds(520, 284, 279, 31);
		jpFuncConta.add(passwordNovaConfirm);

		// botao de confirmar da pass
		JButton btnConfirmarPasse = new JButton("Confirmar");
		btnConfirmarPasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if ((func.getPassword().equals(String.valueOf(passwordAntiga.getPassword())))
						&& (String.valueOf(passwordNovaConfirm.getPassword())
								.equals(String.valueOf(passwordNova.getPassword())))) {

					func.setPassword(String.valueOf(passwordNova.getPassword()));

					passwordAntiga.setText(null);
					passwordNovaConfirm.setText(null);
					passwordNova.setText(null);
					JOptionPane.showMessageDialog(null, "A password foi alterado com sucesso!");

				}

			}
		});
		btnConfirmarPasse.setBackground(SystemColor.controlHighlight);
		btnConfirmarPasse.setBounds(520, 359, 97, 25);
		jpFuncConta.add(btnConfirmarPasse);

		JButton btnCancelarPasse = new JButton("Cancelar");
		btnCancelarPasse.setBackground(SystemColor.controlHighlight);
		btnCancelarPasse.setBounds(676, 359, 97, 25);
		jpFuncConta.add(btnCancelarPasse);

		passwordNova = new JPasswordField();
		passwordNova.setBounds(520, 210, 235, 31);
		jpFuncConta.add(passwordNova);

		// criar um defaul model para guardar e fazer atualizaçoes da lista

		gl.viewComics.addArrayLista(gl.viewComics.arrayLivros(gl.viewComics.getLivros()), dmFunListaLivros);

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

		// botoes do menu
		JButton btnLivros = new JButton("Livros");
		btnLivros.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 31));
		btnLivros.setBackground(SystemColor.controlHighlight);
		btnLivros.setBounds(25, 13, 176, 55);
		btnLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpFuncCarrinhos.setVisible(false);
				jpFuncLivros.setVisible(true);
				jpFuncConta.setVisible(false);
				jpPagamento.setVisible(false);
			}
		});
		panelMenu.add(btnLivros);

		JButton btnCarrinhos = new JButton("Carrinhos");
		btnCarrinhos.setForeground(Color.BLACK);
		btnCarrinhos.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		btnCarrinhos.setBackground(SystemColor.controlHighlight);
		btnCarrinhos.setBounds(25, 81, 176, 60);
		btnCarrinhos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jpFuncCarrinhos.setVisible(true);
				jpFuncLivros.setVisible(false);
				jpFuncConta.setVisible(false);
				jpPagamento.setVisible(false);
			}
		});
		panelMenu.add(btnCarrinhos);

		JButton btnGestao = new JButton("Gestao Conta");
		btnGestao.setForeground(Color.BLACK);
		btnGestao.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		btnGestao.setBackground(SystemColor.controlHighlight);
		btnGestao.setBounds(25, 152, 176, 60);
		btnGestao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jpFuncCarrinhos.setVisible(false);
				jpFuncLivros.setVisible(false);
				jpFuncConta.setVisible(true);
				jpPagamento.setVisible(false);
			}
		});
		panelMenu.add(btnGestao);

		// mudar a cor de um botao ao passar o cursor do rato

		// mudar a cor dos botoes ao passar o rato (mouseEntered & mouseClicked)
		// deixar a cor fixa ao clicar(mouse Clicked)
		// retirar a cor do anterior ao clicar em outro boto(mouse Clicked)

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
				btnCarrinhos.setBackground(SystemColor.controlHighlight);
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
				btnCarrinhos.setBackground(SystemColor.controlHighlight);
			}
		});

		// Funcionarios

		btnCarrinhos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnCarrinhos.setBackground(Color.YELLOW);
			}

			public void mouseExited(MouseEvent arg0) {
				btnCarrinhos.setBackground(SystemColor.controlHighlight);
			}

			public void mouseClicked(MouseEvent arg0) {
				btnCarrinhos.setBackground(Color.YELLOW);
				btnLivros.setBackground(SystemColor.controlHighlight);
				btnGestao.setBackground(SystemColor.controlHighlight);

			}

		});

	}
}
