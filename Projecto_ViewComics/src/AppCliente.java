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

public class AppCliente implements Serializable {

	private JFrame frame;
	private JTextField txtTitulo1;
	private JTextField txtTitulo2;
	private JTextField txtTitulo3;
	private JTextField txtTitulo4;
	private JTextField txtTitulo5;
	private JTextField txtUnid1;
	private JTextField txtUnid2;
	private JTextField txtUnid3;
	private JTextField txtUnid4;
	private JTextField txtUnid5;
	private JTextField txtQuantidadeCarrinhoCliente;
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	private JTextField txtNifCliente;
	private JTextField tbLivrosStock;
	private JTextField tbLivrosPreco;
	private JTextField tbLivrosDescricao;
	private JTextField tbData;
	private JTextField tbLivrosAutor;
	private JTextField tbLivrosNome;
	private static GestaoLivraria gl;

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

//		JPanel JPLivros = new JPanel() {
//			@Override
//			// o paint component vai pintar literalmente o componente
//			protected void paintComponent(Graphics g) {
//
//				super.paintComponent(g);
//				Image img;
//				try {
//
//					// importar imagem para o background do panel, podemos faz�-lo da internet ou
//					// do
//					// ficheiro
//
//					// img = ImageIO.read(new URL(
//					// "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
//					img = ImageIO.read(new File(" "));
//					g.drawImage(img, 0, 0, null);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//			}
//		};
		JPanel JPLivros = new JPanel();
		JPLivros.setBounds(0, 0, 1008, 544);
		JPanelPrincipal.add(JPLivros);
		JPLivros.setLayout(null);
		JPLivros.setVisible(false);

		Choice choiceAtributoLivroCliente = new Choice();
		choiceAtributoLivroCliente.setBounds(65, 63, 200, 20);
		JPLivros.add(choiceAtributoLivroCliente);

		TextField txtNomeAtributoLivroCliente = new TextField();
		txtNomeAtributoLivroCliente.setBounds(65, 96, 200, 22);
		JPLivros.add(txtNomeAtributoLivroCliente);

		JButton btnLimparPesquisaCliente = new JButton("Limpar");
		btnLimparPesquisaCliente.setBackground(SystemColor.controlHighlight);
		btnLimparPesquisaCliente.setBounds(286, 63, 115, 20);
		JPLivros.add(btnLimparPesquisaCliente);

		JButton btnPesquisarLivroCliente = new JButton("Pesquisar");
		btnPesquisarLivroCliente.setBackground(SystemColor.controlHighlight);
		btnPesquisarLivroCliente.setBounds(286, 98, 115, 20);
		JPLivros.add(btnPesquisarLivroCliente);
		
		DefaultListModel<String> modeloLista=new DefaultListModel();
		JList <String>listaLivros = new JList<String>(modeloLista);
		listaLivros.setBounds(65, 140, 289, 348);
		JPLivros.add(listaLivros);
		gl.viewComics.addArrayLista(gl.viewComics.arrayLivros(gl.viewComics.getLivros()), modeloLista);
		
	

		JButton btnRemoveCarrinhoCliente = new JButton("-");
		btnRemoveCarrinhoCliente.setBackground(SystemColor.controlHighlight);
		btnRemoveCarrinhoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoveCarrinhoCliente.setBounds(444, 63, 57, 39);
		JPLivros.add(btnRemoveCarrinhoCliente);

		txtQuantidadeCarrinhoCliente = new JTextField();
		txtQuantidadeCarrinhoCliente.setColumns(10);
		txtQuantidadeCarrinhoCliente.setBounds(511, 67, 61, 34);
		JPLivros.add(txtQuantidadeCarrinhoCliente);

		JButton btnAddCarrinhoCliente = new JButton("+");
		btnAddCarrinhoCliente.setBackground(SystemColor.controlHighlight);
		btnAddCarrinhoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddCarrinhoCliente.setBounds(582, 63, 54, 39);
		JPLivros.add(btnAddCarrinhoCliente);

		JButton btnAddCarrinhoFinalCliente = new JButton("Adicionar ao carrinho");
		btnAddCarrinhoFinalCliente.setBackground(SystemColor.controlHighlight);
		btnAddCarrinhoFinalCliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddCarrinhoFinalCliente.setBounds(428, 11, 219, 42);
		JPLivros.add(btnAddCarrinhoFinalCliente);

		JLabel label_2 = new JLabel("Nome:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(443, 146, 48, 16);
		JPLivros.add(label_2);

		JLabel label_3 = new JLabel("Autor:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(443, 196, 48, 16);
		JPLivros.add(label_3);

		JLabel label_4 = new JLabel("Data:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(451, 245, 40, 16);
		JPLivros.add(label_4);

		JLabel label_5 = new JLabel("Descri\u00E7\u00E3o:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(404, 292, 87, 16);
		JPLivros.add(label_5);

		JLabel label_6 = new JLabel("Pre\u00E7o:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(443, 430, 48, 16);
		JPLivros.add(label_6);

		JLabel label_7 = new JLabel("Stock:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_7.setBounds(443, 481, 48, 16);
		JPLivros.add(label_7);

		tbLivrosStock = new JTextField();
		tbLivrosStock.setColumns(10);
		tbLivrosStock.setBounds(513, 479, 345, 30);
		JPLivros.add(tbLivrosStock);

		tbLivrosPreco = new JTextField();
		tbLivrosPreco.setColumns(10);
		tbLivrosPreco.setBounds(513, 428, 345, 30);
		JPLivros.add(tbLivrosPreco);

		tbLivrosDescricao = new JTextField();
		tbLivrosDescricao.setColumns(10);
		tbLivrosDescricao.setBounds(513, 286, 345, 117);
		JPLivros.add(tbLivrosDescricao);

		tbData = new JTextField();
		tbData.setColumns(10);
		tbData.setBounds(513, 239, 345, 30);
		JPLivros.add(tbData);

		tbLivrosAutor = new JTextField();
		tbLivrosAutor.setColumns(10);
		tbLivrosAutor.setBounds(513, 190, 345, 30);
		JPLivros.add(tbLivrosAutor);

		tbLivrosNome = new JTextField();
		tbLivrosNome.setColumns(10);
		tbLivrosNome.setBounds(513, 140, 345, 30);
		JPLivros.add(tbLivrosNome);

		// painel para o carrinho

		JPanel JPCarrinho = new JPanel();
		JPCarrinho.setBounds(0, 0, 1008, 544);
		JPanelPrincipal.add(JPCarrinho);
		JPCarrinho.setLayout(null);

		// O painel nao inicia visivel
		JPCarrinho.setVisible(false);

		JLabel label_1 = new JLabel("T\u00EDtulo do livro");
		label_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_1.setBounds(68, 32, 144, 26);
		JPCarrinho.add(label_1);

		txtTitulo1 = new JTextField();
		txtTitulo1.setColumns(10);
		txtTitulo1.setBounds(68, 82, 220, 36);
		JPCarrinho.add(txtTitulo1);

		txtTitulo2 = new JTextField();
		txtTitulo2.setColumns(10);
		txtTitulo2.setBounds(68, 147, 220, 36);
		JPCarrinho.add(txtTitulo2);

		txtTitulo3 = new JTextField();
		txtTitulo3.setColumns(10);
		txtTitulo3.setBounds(68, 210, 220, 36);
		JPCarrinho.add(txtTitulo3);

		txtTitulo4 = new JTextField();
		txtTitulo4.setColumns(10);
		txtTitulo4.setBounds(68, 273, 220, 36);
		JPCarrinho.add(txtTitulo4);

		txtTitulo5 = new JTextField();
		txtTitulo5.setColumns(10);
		txtTitulo5.setBounds(68, 336, 220, 36);
		JPCarrinho.add(txtTitulo5);

		JButton btnRemoveUnid5 = new JButton("-");
		btnRemoveUnid5.setBackground(SystemColor.controlHighlight);
		btnRemoveUnid5.setBounds(310, 336, 44, 36);
		JPCarrinho.add(btnRemoveUnid5);

		JButton btnRemoveUnid4 = new JButton("-");
		btnRemoveUnid4.setBackground(SystemColor.controlHighlight);
		btnRemoveUnid4.setBounds(310, 273, 44, 36);
		JPCarrinho.add(btnRemoveUnid4);

		JButton btnRemoveUnid3 = new JButton("-");
		btnRemoveUnid3.setBackground(SystemColor.controlHighlight);
		btnRemoveUnid3.setBounds(310, 210, 44, 36);
		JPCarrinho.add(btnRemoveUnid3);

		JButton btnRemoveUnid2 = new JButton("-");
		btnRemoveUnid2.setBackground(SystemColor.controlHighlight);
		btnRemoveUnid2.setBounds(310, 147, 44, 36);
		JPCarrinho.add(btnRemoveUnid2);

		JButton btnRemoveUnid1 = new JButton("-");
		btnRemoveUnid1.setBackground(SystemColor.controlHighlight);
		btnRemoveUnid1.setBounds(310, 82, 44, 36);
		JPCarrinho.add(btnRemoveUnid1);

		txtUnid1 = new JTextField();
		txtUnid1.setColumns(10);
		txtUnid1.setBounds(364, 82, 49, 36);
		JPCarrinho.add(txtUnid1);

		txtUnid2 = new JTextField();
		txtUnid2.setColumns(10);
		txtUnid2.setBounds(364, 147, 49, 36);
		JPCarrinho.add(txtUnid2);

		txtUnid3 = new JTextField();
		txtUnid3.setColumns(10);
		txtUnid3.setBounds(364, 210, 49, 36);
		JPCarrinho.add(txtUnid3);

		txtUnid4 = new JTextField();
		txtUnid4.setColumns(10);
		txtUnid4.setBounds(364, 273, 49, 36);
		JPCarrinho.add(txtUnid4);

		txtUnid5 = new JTextField();
		txtUnid5.setColumns(10);
		txtUnid5.setBounds(364, 336, 49, 36);
		JPCarrinho.add(txtUnid5);

		JButton btnAddUnid5 = new JButton("+");
		btnAddUnid5.setBackground(SystemColor.controlHighlight);
		btnAddUnid5.setBounds(423, 336, 49, 36);
		JPCarrinho.add(btnAddUnid5);

		JButton btnAddUnid4 = new JButton("+");
		btnAddUnid4.setBackground(SystemColor.controlHighlight);
		btnAddUnid4.setBounds(423, 273, 49, 36);
		JPCarrinho.add(btnAddUnid4);

		JButton btnAddUnid3 = new JButton("+");
		btnAddUnid3.setBackground(SystemColor.controlHighlight);
		btnAddUnid3.setBounds(423, 210, 49, 36);
		JPCarrinho.add(btnAddUnid3);

		JButton btnAddUnid2 = new JButton("+");
		btnAddUnid2.setBackground(SystemColor.controlHighlight);
		btnAddUnid2.setBounds(423, 147, 49, 36);
		JPCarrinho.add(btnAddUnid2);

		JButton btnAddUnid1 = new JButton("+");
		btnAddUnid1.setBackground(SystemColor.controlHighlight);
		btnAddUnid1.setBounds(423, 82, 49, 36);
		JPCarrinho.add(btnAddUnid1);

		JLabel lblPreco1 = new JLabel("New label");
		lblPreco1.setBounds(532, 82, 49, 36);
		JPCarrinho.add(lblPreco1);

		JLabel lblPreco2 = new JLabel("New label");
		lblPreco2.setBounds(532, 147, 49, 36);
		JPCarrinho.add(lblPreco2);

		JLabel lblPreco3 = new JLabel("New label");
		lblPreco3.setBounds(532, 210, 49, 36);
		JPCarrinho.add(lblPreco3);

		JLabel lblPreco4 = new JLabel("New label");
		lblPreco4.setBounds(532, 273, 49, 36);
		JPCarrinho.add(lblPreco4);

		JLabel lblPreco5 = new JLabel("New label");
		lblPreco5.setBounds(532, 336, 49, 36);
		JPCarrinho.add(lblPreco5);

		JLabel lblTotal5 = new JLabel("New label");
		lblTotal5.setBounds(651, 336, 49, 36);
		JPCarrinho.add(lblTotal5);

		JLabel lblTotal4 = new JLabel("New label");
		lblTotal4.setBounds(651, 273, 82, 36);
		JPCarrinho.add(lblTotal4);

		JLabel lblTotal3 = new JLabel("New label");
		lblTotal3.setBounds(651, 210, 82, 36);
		JPCarrinho.add(lblTotal3);

		JLabel lblTotal2 = new JLabel("New label");
		lblTotal2.setBounds(651, 147, 82, 36);
		JPCarrinho.add(lblTotal2);

		JLabel lblTotal1 = new JLabel("New label");
		lblTotal1.setBounds(651, 82, 82, 36);
		JPCarrinho.add(lblTotal1);

		JButton btnLimpar5 = new JButton("limpar");
		btnLimpar5.setBackground(SystemColor.controlHighlight);
		btnLimpar5.setBounds(759, 340, 72, 29);
		JPCarrinho.add(btnLimpar5);

		JButton btnLimpar4 = new JButton("limpar");
		btnLimpar4.setBackground(SystemColor.controlHighlight);
		btnLimpar4.setBounds(759, 277, 72, 29);
		JPCarrinho.add(btnLimpar4);

		JButton btnLimpar3 = new JButton("limpar");
		btnLimpar3.setBackground(SystemColor.controlHighlight);
		btnLimpar3.setBounds(759, 214, 72, 29);
		JPCarrinho.add(btnLimpar3);

		JButton btnLimpar2 = new JButton("limpar");
		btnLimpar2.setBackground(SystemColor.controlHighlight);
		btnLimpar2.setBounds(759, 151, 72, 29);
		JPCarrinho.add(btnLimpar2);

		JButton btnLimpar1 = new JButton("limpar");
		btnLimpar1.setBackground(SystemColor.controlHighlight);
		btnLimpar1.setBounds(759, 86, 72, 29);
		JPCarrinho.add(btnLimpar1);

		JLabel label_12 = new JLabel("Limpar");
		label_12.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_12.setBounds(770, 32, 61, 26);
		JPCarrinho.add(label_12);

		JLabel label_13 = new JLabel("Valor total");
		label_13.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_13.setBounds(637, 32, 82, 26);
		JPCarrinho.add(label_13);

		JLabel label_14 = new JLabel("Pre\u00E7oUnit\u00E1rio");
		label_14.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_14.setBounds(497, 32, 111, 26);
		JPCarrinho.add(label_14);

		JLabel label_15 = new JLabel("Quantidade");
		label_15.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_15.setBounds(348, 32, 91, 26);
		JPCarrinho.add(label_15);

		JLabel lblNmeroDeArtigos = new JLabel("N\u00FAmero de artigos no carrinho:");
		lblNmeroDeArtigos.setBounds(73, 424, 176, 26);
		JPCarrinho.add(lblNmeroDeArtigos);

		JLabel lblPreoAPagar = new JLabel("Pre\u00E7o a pagar:");
		lblPreoAPagar.setBounds(73, 450, 72, 26);
		JPCarrinho.add(lblPreoAPagar);

		JLabel lblQtddArtigos = new JLabel("New label");
		lblQtddArtigos.setBounds(235, 430, 46, 14);
		JPCarrinho.add(lblQtddArtigos);

		JLabel lblPreco = new JLabel("New label");
		lblPreco.setBounds(166, 456, 46, 14);
		JPCarrinho.add(lblPreco);

		JButton btnPagar = new JButton("PAGAR");
		btnPagar.setBackground(SystemColor.controlHighlight);
		btnPagar.setBounds(332, 414, 107, 36);
		JPCarrinho.add(btnPagar);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBackground(SystemColor.controlHighlight);
		btnCancelar.setBounds(332, 470, 107, 36);
		JPCarrinho.add(btnCancelar);

		txtNifCliente = new JTextField();
		txtNifCliente.setColumns(10);
		txtNifCliente.setBounds(480, 440, 220, 26);
		JPCarrinho.add(txtNifCliente);

		JLabel lblNewLabel = new JLabel("Antes do pagamento introduza o seu NIF");
		lblNewLabel.setBounds(485, 414, 270, 14);
		JPCarrinho.add(lblNewLabel);

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
						AppFuncionario fun = new AppFuncionario(utilizadorLogado,gl);
						fun.run();
						frame.dispose();
					} else if (utilizadorLogado instanceof Administrador) {
						AppAdmin adm = new AppAdmin(utilizadorLogado,gl);
						adm.run();
						frame.dispose();
					}

				}
				else {
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
