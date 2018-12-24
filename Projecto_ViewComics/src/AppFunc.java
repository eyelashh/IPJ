import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JCheckBox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.TextField;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;

public class AppFunc {

	private JFrame frame;
	private JTextField textField_6;
	private JTextField txtQuantidadeCarrinhoFunc;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;

	/**
	 * Launch the application.
	 */

	// EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			AppFunc window = new AppFunc();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// });
	// }

	/**
	 * Create the application.
	 */
	public AppFunc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel JPanelCabecalho = new JPanel() {
			@Override
			// o paint component vai pintar literalmente o componente
			protected void paintComponent(Graphics g) {

				super.paintComponent(g);
				Image img;
				try {

					// importar imagem para o background do panel, podemos fazï¿½-lo da internet ou
					// do ficheiro

					// img = ImageIO.read(new URL(
					// "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO.read(new File("/Users/Joana/Dropbox/IPJ_ProjectoFinal/Design/viewcomics/fundo.jpg"));
					g.drawImage(img, 0, 0, null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		JPanelCabecalho.setBounds(0, 0, 1264, 183);
		frame.getContentPane().add(JPanelCabecalho);
		JPanelCabecalho.setLayout(null);

		JLabel label = new JLabel("ViewComics Inc.");
		label.setBounds(176, 30, 819, 118);
		label.setFont(new Font("Tempus Sans ITC", Font.BOLD, 98));
		JPanelCabecalho.add(label);

		JButton btnLogout = new JButton("LogOut");

		btnLogout.setBounds(1142, 56, 89, 23);
		JPanelCabecalho.add(btnLogout);

		JLabel lblBemVindonome = new JLabel("Bem Vindo -Nome - Funcion\u00E1rio");
		lblBemVindonome.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindonome.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		lblBemVindonome.setBounds(902, 11, 335, 27);
		JPanelCabecalho.add(lblBemVindonome);

		JPanel JPanelMenu = new JPanel() {
			@Override
			// o paint component vai pintar literalmente o componente
			protected void paintComponent(Graphics g) {

				super.paintComponent(g);
				Image img;
				try {

					// importar imagem para o background do panel, podemos fazï¿½-lo da internet ou
					// do ficheiro

					// img = ImageIO.read(new URL(
					// "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO.read(
							new File("/Users/Joana/Dropbox/IPJ_ProjectoFinal/Design/viewcomics/fundo2.jpg "));
					g.drawImage(img, 0, 0, null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		JPanelMenu.setBounds(0, 185, 245, 544);
		frame.getContentPane().add(JPanelMenu);
		JPanelMenu.setLayout(null);

		JButton btnCarrinhos = new JButton("Carrinhos");

		btnCarrinhos.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnCarrinhos.setBackground(SystemColor.controlHighlight);
		btnCarrinhos.setBounds(26, 108, 176, 60);
		JPanelMenu.add(btnCarrinhos);

		JButton btnLivros = new JButton("Livros");

		btnLivros.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 31));
		btnLivros.setBackground(SystemColor.controlHighlight);
		btnLivros.setBounds(26, 29, 176, 55);
		JPanelMenu.add(btnLivros);

		JButton btnGestaoFunc = new JButton();

		btnGestaoFunc.setText("<HTML> Gest\u00E3o de conta <HTML>");
		btnGestaoFunc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnGestaoFunc.setBackground(SystemColor.controlHighlight);
		btnGestaoFunc.setBounds(28, 200, 176, 96);
		JPanelMenu.add(btnGestaoFunc);

		JPanel JPanelPrincipal = new JPanel();
		JPanelPrincipal.setBounds(255, 185, 1009, 544);
		frame.getContentPane().add(JPanelPrincipal);
		JPanelPrincipal.setLayout(null);

		JPanel JPpagamento = new JPanel() {
			protected void paintComponent(Graphics g) {
			}
		};
		JPpagamento.setBounds(0, 0, 322, 397);
		JPanelPrincipal.add(JPpagamento);
		JPpagamento.setLayout(null);
		JPpagamento.setVisible(false);

		JComboBox comboBoxPagamento = new JComboBox();
		comboBoxPagamento.setBounds(65, 34, 199, 22);
		JPpagamento.add(comboBoxPagamento);
		comboBoxPagamento.addItem("(Seleccione o mï¿½todo de pagamento)");
		comboBoxPagamento.addItem("Dinheiro");
		comboBoxPagamento.addItem("Multibanco");

		JPanel JPGestao = new JPanel();
		JPGestao.setLayout(null);
		JPGestao.setBounds(0, 0, 1009, 544);
		JPanelPrincipal.add(JPGestao);
		JPGestao.setVisible(false);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(148, 144, 256, 26);
		JPGestao.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(148, 231, 256, 25);
		JPGestao.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(148, 329, 256, 26);
		JPGestao.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(493, 230, 256, 26);
		JPGestao.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(493, 329, 256, 26);
		JPGestao.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(493, 143, 256, 26);
		JPGestao.add(textField_5);

		JLabel label_1 = new JLabel("Username actual");
		label_1.setBounds(151, 122, 81, 14);
		JPGestao.add(label_1);

		JLabel label_2 = new JLabel("Palavra passe:");
		label_2.setBounds(148, 209, 81, 14);
		JPGestao.add(label_2);

		JLabel label_3 = new JLabel("Novo username:");
		label_3.setBounds(148, 304, 81, 14);
		JPGestao.add(label_3);

		JLabel label_4 = new JLabel("Palavra passe actual :");
		label_4.setBounds(497, 118, 148, 14);
		JPGestao.add(label_4);

		JLabel label_5 = new JLabel("Nova palavra passe :");
		label_5.setBounds(493, 205, 152, 14);
		JPGestao.add(label_5);

		JLabel label_6 = new JLabel("Confirma\u00E7\u00E3o da nova palavra passe :");
		label_6.setBounds(493, 304, 189, 14);
		JPGestao.add(label_6);

		JLabel label_7 = new JLabel("Actualizar nome :");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_7.setBounds(148, 75, 201, 36);
		JPGestao.add(label_7);

		JLabel label_8 = new JLabel("Actualizar palavra passe :");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_8.setBounds(493, 71, 298, 36);
		JPGestao.add(label_8);

		JButton button_3 = new JButton("Confirmar novo username");
		button_3.setBounds(184, 383, 165, 23);
		JPGestao.add(button_3);

		JButton button_6 = new JButton("Confirmar nova palavra passe ");
		button_6.setBounds(529, 383, 189, 23);
		JPGestao.add(button_6);

		JPanel JPCarrinhos = new JPanel() {
			@Override
			// o paint component vai pintar literalmente o componente
			protected void paintComponent(Graphics g) {

				super.paintComponent(g);
				Image img;
				try {

					// importar imagem para o background do panel, podemos fazê-lo da internet ou do
					// ficheiro

					// img = ImageIO.read(new URL(
					// "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO.read(
							new File("C:\\Users\\Joana\\Dropbox\\IPJ_ProjectoFinal\\Design\\ViewComics\\fundo4.jpg"));
					g.drawImage(img, 0, 0, null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		JPCarrinhos.setBounds(0, 0, 1009, 544);
		JPanelPrincipal.add(JPCarrinhos);
		JPCarrinhos.setLayout(null);
		JPCarrinhos.setVisible(false);

		textField_6 = new JTextField();
		textField_6.setBounds(59, 23, 153, 32);
		JPCarrinhos.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel = new JLabel("NIF");
		lblNewLabel.setBounds(26, 32, 46, 14);
		JPCarrinhos.add(lblNewLabel);

		JList list = new JList();
		list.setBounds(59, 97, 153, 394);
		JPCarrinhos.add(list);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(238, 28, 89, 23);
		JPCarrinhos.add(btnPesquisar);

		JLabel lblNewLabel_1 = new JLabel("TOTAL :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(378, 366, 46, 14);
		JPCarrinhos.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(425, 366, 46, 14);
		JPCarrinhos.add(lblNewLabel_2);

		JLabel lblValorAPagar = new JLabel("VALOR A PAGAR: ");
		lblValorAPagar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorAPagar.setBounds(378, 391, 105, 14);
		JPCarrinhos.add(lblValorAPagar);

		JLabel label_9 = new JLabel("New label");
		label_9.setBounds(490, 391, 46, 14);
		JPCarrinhos.add(label_9);

		JButton btnPagar = new JButton("Realizar pagamento");

		btnPagar.setBounds(367, 421, 164, 41);
		JPCarrinhos.add(btnPagar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(537, 421, 89, 41);
		JPCarrinhos.add(btnCancelar);

		JButton btnEliminar2 = new JButton("Eliminar");
		btnEliminar2.setBounds(588, 195, 70, 23);
		JPCarrinhos.add(btnEliminar2);

		JButton btnEliminar1 = new JButton("Eliminar");
		btnEliminar1.setBounds(588, 145, 70, 23);
		JPCarrinhos.add(btnEliminar1);

		JButton btnEliminar3 = new JButton("Eliminar");
		btnEliminar3.setBounds(588, 244, 70, 23);
		JPCarrinhos.add(btnEliminar3);

		JButton btnEliminar4 = new JButton("Eliminar");
		btnEliminar4.setBounds(588, 293, 70, 23);
		JPCarrinhos.add(btnEliminar4);

		JLabel lblNewLabel_3 = new JLabel("DETALHES DO CARRINHO :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(283, 62, 188, 23);
		JPCarrinhos.add(lblNewLabel_3);

		JLabel lblLivro = new JLabel("Livro");
		lblLivro.setBounds(284, 97, 65, 23);
		JPCarrinhos.add(lblLivro);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(359, 97, 97, 23);
		JPCarrinhos.add(lblQuantidade);

		JLabel lblValorAPagar_2 = new JLabel("Valor a pagar");
		lblValorAPagar_2.setBounds(466, 97, 115, 23);
		JPCarrinhos.add(lblValorAPagar_2);

		JLabel lblNewLabel_4 = new JLabel("livro1");
		lblNewLabel_4.setBounds(284, 154, 30, 14);
		JPCarrinhos.add(lblNewLabel_4);

		JLabel label_10 = new JLabel("livro1");
		label_10.setBounds(284, 204, 30, 14);
		JPCarrinhos.add(label_10);

		JLabel label_11 = new JLabel("livro1");
		label_11.setBounds(284, 253, 30, 14);
		JPCarrinhos.add(label_11);

		JLabel label_12 = new JLabel("livro1");
		label_12.setBounds(369, 154, 30, 14);
		JPCarrinhos.add(label_12);

		JLabel label_13 = new JLabel("livro1");
		label_13.setBounds(369, 204, 30, 14);
		JPCarrinhos.add(label_13);

		JLabel label_14 = new JLabel("livro1");
		label_14.setBounds(369, 253, 30, 14);
		JPCarrinhos.add(label_14);

		JLabel label_15 = new JLabel("livro1");
		label_15.setBounds(284, 302, 30, 14);
		JPCarrinhos.add(label_15);

		JLabel label_16 = new JLabel("livro1");
		label_16.setBounds(369, 302, 30, 14);
		JPCarrinhos.add(label_16);

		JLabel label_17 = new JLabel("livro1");
		label_17.setBounds(478, 154, 30, 14);
		JPCarrinhos.add(label_17);

		JLabel label_18 = new JLabel("livro1");
		label_18.setBounds(478, 204, 30, 14);
		JPCarrinhos.add(label_18);

		JLabel label_19 = new JLabel("livro1");
		label_19.setBounds(478, 253, 30, 14);
		JPCarrinhos.add(label_19);

		JLabel label_20 = new JLabel("livro1");
		label_20.setBounds(478, 302, 30, 14);
		JPCarrinhos.add(label_20);

		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPCarrinhos.setVisible(false);
				JPLivros.setVisible(false);
				JPpagamento.setVisible(true);
				JPmultibanco.setVisible(false);
				JPdinheiro.setVisible(false);
				JPGestao.setVisible(false);

			}
		});

		JPanel JPLivros = new JPanel() {
			@Override
			// o paint component vai pintar literalmente o componente
			protected void paintComponent(Graphics g) {

				super.paintComponent(g);
				Image img;
				try {

					// importar imagem para o background do panel, podemos fazê-lo da internet ou do
					// ficheiro

					// img = ImageIO.read(new URL(
					// "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO.read(new File(
							"C:\\Users\\Joana\\Dropbox\\IPJ_ProjectoFinal\\Design\\ViewComics\\calvinHobes.jpg"));
					g.drawImage(img, 0, 0, null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		JPLivros.setBounds(0, 0, 1009, 544);
		JPanelPrincipal.add(JPLivros);
		JPLivros.setLayout(null);
		JPLivros.setVisible(false);

		Choice choiceAtributoLivroFunc = new Choice();
		choiceAtributoLivroFunc.setBounds(27, 41, 200, 20);
		JPLivros.add(choiceAtributoLivroFunc);

		TextField txtAtributoLivroFunc = new TextField();
		txtAtributoLivroFunc.setBounds(27, 68, 200, 22);
		JPLivros.add(txtAtributoLivroFunc);

		JButton btnLimparLivroFunc = new JButton("Limpar");
		btnLimparLivroFunc.setBackground(SystemColor.controlHighlight);
		btnLimparLivroFunc.setBounds(264, 41, 115, 20);
		JPLivros.add(btnLimparLivroFunc);

		JButton btnPesquisarLivroFunc = new JButton("Pesquisar");
		btnPesquisarLivroFunc.setBackground(SystemColor.controlHighlight);
		btnPesquisarLivroFunc.setBounds(264, 68, 115, 20);
		JPLivros.add(btnPesquisarLivroFunc);

		List list_1 = new List();
		list_1.setBounds(27, 116, 289, 348);
		JPLivros.add(list_1);

		TextField textField_8 = new TextField();
		textField_8.setBounds(334, 116, 260, 211);
		JPLivros.add(textField_8);

		JButton btnRemoveCarrinhoFunc = new JButton("-");
		btnRemoveCarrinhoFunc.setBackground(SystemColor.controlHighlight);
		btnRemoveCarrinhoFunc.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnRemoveCarrinhoFunc.setBounds(639, 141, 54, 48);
		JPLivros.add(btnRemoveCarrinhoFunc);

		txtQuantidadeCarrinhoFunc = new JTextField();
		txtQuantidadeCarrinhoFunc.setColumns(10);
		txtQuantidadeCarrinhoFunc.setBounds(703, 150, 61, 34);
		JPLivros.add(txtQuantidadeCarrinhoFunc);

		JButton btnAddCarrinhoFunc = new JButton("+");
		btnAddCarrinhoFunc.setBackground(SystemColor.controlHighlight);
		btnAddCarrinhoFunc.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnAddCarrinhoFunc.setBounds(774, 141, 54, 48);
		JPLivros.add(btnAddCarrinhoFunc);

		JButton btnAddCarrinhoFinalFunc = new JButton("<HTML>Adicionar ao carrinho<HTML>");
		btnAddCarrinhoFinalFunc.setBackground(SystemColor.controlHighlight);
		btnAddCarrinhoFinalFunc.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnAddCarrinhoFinalFunc.setBounds(639, 200, 189, 63);
		JPLivros.add(btnAddCarrinhoFinalFunc);

		TextField txtNifCarrinhoFunc = new TextField();
		txtNifCarrinhoFunc.setBounds(433, 68, 200, 22);
		JPLivros.add(txtNifCarrinhoFunc);

		JLabel lblNifDoCliente = new JLabel("NIF DO CLIENTE");
		lblNifDoCliente.setBounds(439, 41, 115, 14);
		JPLivros.add(lblNifDoCliente);

		JLabel lblPesquisarPorCampo = new JLabel("PESQUISAR POR CAMPO");
		lblPesquisarPorCampo.setBounds(27, 21, 200, 14);
		JPLivros.add(lblPesquisarPorCampo);

		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(190, 145, 46, 25);

		JPanel JPdinheiro = new JPanel();
		JPdinheiro.setBounds(0, 0, 237, 282);
		JPanelPrincipal.add(JPdinheiro);
		JPdinheiro.setLayout(null);
		JPdinheiro.setVisible(false);

		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(24, 35, 145, 27);
		JPdinheiro.add(textField_14);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(24, 113, 174, 27);
		JPdinheiro.add(textField_15);

		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBounds(24, 197, 145, 27);
		JPdinheiro.add(textField_16);

		JLabel label_24 = new JLabel("Quantia recebida :");
		label_24.setBounds(24, 84, 126, 14);
		JPdinheiro.add(label_24);

		JLabel label_25 = new JLabel("Troco :");
		label_25.setBounds(24, 162, 86, 14);
		JPdinheiro.add(label_25);

		JLabel label_26 = new JLabel("A pagar :");
		label_26.setBounds(24, 10, 105, 14);
		JPdinheiro.add(label_26);

		JButton button_7 = new JButton("Concluir pagamento");
		button_7.setBounds(32, 248, 180, 23);
		JPdinheiro.add(button_7);

		JPanel JPmultibanco = new JPanel();
		JPmultibanco.setBounds(0, 0, 237, 282);
		JPanelPrincipal.add(JPmultibanco);
		JPmultibanco.setVisible(false);

		// Acï¿½oes dos botï¿½es

		btnGestaoFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPCarrinhos.setVisible(false);
				JPLivros.setVisible(false);
				JPpagamento.setVisible(false);
				JPmultibanco.setVisible(false);
				JPdinheiro.setVisible(false);
				JPGestao.setVisible(true);
			}
		});

		btnLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPCarrinhos.setVisible(false);
				JPLivros.setVisible(true);
				JPpagamento.setVisible(false);
				JPmultibanco.setVisible(false);
				JPdinheiro.setVisible(false);
				JPGestao.setVisible(false);
			}
		});

		btnCarrinhos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPCarrinhos.setVisible(true);
				JPLivros.setVisible(false);
				JPpagamento.setVisible(false);
				JPmultibanco.setVisible(false);
				JPdinheiro.setVisible(false);
				JPGestao.setVisible(false);
			}
		});
		// selecionar o mï¿½todo de pagamento para determinar qual a janela a aparecer a
		// seguir

		if (comboBoxPagamento.getSelectedItem().equals("Multibanco")) {
			JPmultibanco.setVisible(true);
		} else if (comboBoxPagamento.getSelectedItem().equals("Dinheiro")) {
			JPdinheiro.setVisible(true);
		}

		// LogOut

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AppCliente clt = new AppCliente();
				clt.run();
				frame.setVisible(false);
			}
		});

		// mudar a cor dos botoes ao passar o rato (mouseEntered & mouseClicked)
		//deixar a cor fixa ao clicar(mouse Clicked)
		//retirar a cor do anterior ao clicar em outro botão(mouse Clicked)
		
		//Livros

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
				btnCarrinhos.setBackground(SystemColor.controlHighlight);
				btnGestaoFunc.setBackground(SystemColor.controlHighlight);
			}
		});
		
		//Carrinhos
		
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
				btnGestaoFunc.setBackground(SystemColor.controlHighlight);
			}
		});
		
		// gestao
		
		btnGestaoFunc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnGestaoFunc.setBackground(Color.YELLOW);
			}

			public void mouseClicked(MouseEvent arg0) {
				btnGestaoFunc.setBackground(Color.YELLOW);
				btnLivros.setBackground(SystemColor.controlHighlight);
				btnCarrinhos.setBackground(SystemColor.controlHighlight);
			}
			public void mouseExited(MouseEvent arg0) {
				btnGestaoFunc.setBackground(SystemColor.controlHighlight);
			}
		});
	}
}
