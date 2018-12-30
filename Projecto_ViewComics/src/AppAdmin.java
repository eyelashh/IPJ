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
import javax.swing.JTree;
import javax.swing.JTextPane;
import javax.swing.AbstractListModel;

public class AppAdmin implements Serializable {

	// atributos ssss

	private JFrame frame;
	private JPanel jpAdmFuncionarios;
	private JTextField txtAtributoPesquisaLivro;
	private JTextField txtTituloLivro;
	private JTextField txtAutorLivro;
	private JTextField txtDataLivro;
	private JTextField txtDescricaoLivro;
	private JTextField txtPrecoLivro;
	private JTextField txtStockLivro;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtNovoUsername;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField txtNomeAtributo;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtData;
	private JTextField txtDescricao;
	private JTextField txtPreco;
	private JTextField textField_18;
	private JTextField textField_12;
	private JTextField txtIdFunc;
	private JTextField txtNomeFunc;
	private JTextField txtContactoFunc;
	private JTextField txtUsernameFunc;
	private JTextField txtPassFunc;

	private static Utilizador admin;
	private static GestaoLivraria gl;
	private JTextField txtTESTE;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	// EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			AppAdmin window = new AppAdmin(admin, gl);
			window.frame.setVisible(true);
		} catch (Exception e) {
			//e.printStackTrace();
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
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				gl.atualizaficheiro(gl.getViewComics().getUtilizadores(), gl.getViewComics().getCarrinhos(),gl.getViewComics().getLivros());
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
//				{
//			@Override
//			protected void paintComponent(Graphics g) {
//
//				super.paintComponent(g);
//				Image img;
//				try {
//
//					// img = ImageIO.read(new URL(
//					// "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
//					img = ImageIO.read(new File("/Users/Joana/Dropbox/IPJ_ProjectoFinal/Design/viewcomics/fundo2.jpg"));
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

		JPanel panelPrincipal = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {

				super.paintComponent(g);
				Image img;
				try {

					// img = ImageIO.read(new URL(
					// "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO
							.read(new File("/Users/Joana/Dropbox/IPJ_ProjectoFinal/Design/viewcomics/luckyluke.jpg"));
					g.drawImage(img, 0, 0, null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		panelPrincipal.setBounds(240, 176, 1022, 545);
		Paineltotal.add(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel jpAdmLivros = new JPanel();
		jpAdmLivros.setLayout(null);
		jpAdmLivros.setBounds(0, 0, 763, 545);
		panelPrincipal.add(jpAdmLivros);
		jpAdmLivros.setVisible(false);

		JComboBox comboBoxAtributoLivro = new JComboBox();
		comboBoxAtributoLivro.setBounds(12, 13, 200, 30);
		jpAdmLivros.add(comboBoxAtributoLivro);

		//LISTAR LIVROS
		DefaultListModel<String>modeloListaLivros=new DefaultListModel<String>();
		JList<String> listaLivros = new JList<String>(modeloListaLivros);
		listaLivros.setBounds(22, 118, 190, 427);
		gl.viewComics.addArrayLista( gl.viewComics.arrayLivros(gl.viewComics.getLivros()), modeloListaLivros);
		jpAdmLivros.add(listaLivros);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(263, 120, 48, 16);
		jpAdmLivros.add(lblNewLabel);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAutor.setBounds(263, 170, 48, 16);
		jpAdmLivros.add(lblAutor);

		JLabel lblDescrio = new JLabel("Data:");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescrio.setBounds(271, 219, 40, 16);
		jpAdmLivros.add(lblDescrio);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStock.setBounds(263, 455, 48, 16);
		jpAdmLivros.add(lblStock);

		JLabel lblPreo_1 = new JLabel("Pre\u00E7o:");
		lblPreo_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPreo_1.setBounds(263, 404, 48, 16);
		jpAdmLivros.add(lblPreo_1);

		JLabel lblPreo = new JLabel("Descri\u00E7\u00E3o:");
		lblPreo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPreo.setBounds(224, 266, 87, 16);
		jpAdmLivros.add(lblPreo);

		txtTituloLivro = new JTextField();
		txtTituloLivro.setColumns(10);
		txtTituloLivro.setBounds(333, 114, 345, 30);
		jpAdmLivros.add(txtTituloLivro);

		txtAutorLivro = new JTextField();
		txtAutorLivro.setColumns(10);
		txtAutorLivro.setBounds(333, 164, 345, 30);
		jpAdmLivros.add(txtAutorLivro);

		txtDataLivro = new JTextField();
		txtDataLivro.setColumns(10);
		txtDataLivro.setBounds(333, 213, 345, 30);
		jpAdmLivros.add(txtDataLivro);

		txtDescricaoLivro = new JTextField();
		txtDescricaoLivro.setColumns(10);
		txtDescricaoLivro.setBounds(333, 260, 345, 117);
		jpAdmLivros.add(txtDescricaoLivro);

		txtPrecoLivro = new JTextField();
		txtPrecoLivro.setColumns(10);
		txtPrecoLivro.setBounds(333, 402, 345, 30);
		jpAdmLivros.add(txtPrecoLivro);

		txtStockLivro = new JTextField();
		txtStockLivro.setColumns(10);
		txtStockLivro.setBounds(333, 453, 345, 30);
		jpAdmLivros.add(txtStockLivro);

		JButton btnPesquisarLivro = new JButton("Pesquisar");

		btnPesquisarLivro.setBackground(SystemColor.controlHighlight);
		btnPesquisarLivro.setBounds(224, 16, 97, 25);
		jpAdmLivros.add(btnPesquisarLivro);

		JButton btnLimparLivro = new JButton("Limpar");
		btnLimparLivro.setBackground(SystemColor.controlHighlight);
		btnLimparLivro.setBounds(224, 60, 97, 25);
		jpAdmLivros.add(btnLimparLivro);
		
		textField = new JTextField();
		textField.setBounds(12, 62, 200, 23);
		jpAdmLivros.add(textField);
		textField.setColumns(10);

		JPanel jpAdmStock = new JPanel();
		jpAdmStock.setBounds(0, 0, 763, 545);
		panelPrincipal.add(jpAdmStock);
		jpAdmStock.setLayout(null);
		jpAdmStock.setVisible(false);

		JComboBox comboBoxAtributos = new JComboBox();
		comboBoxAtributos.setBounds(12, 13, 200, 30);
		jpAdmStock.add(comboBoxAtributos);

		JButton button_9 = new JButton("Pesquisar");
		button_9.setBounds(224, 16, 97, 25);
		jpAdmStock.add(button_9);

		txtNomeAtributo = new JTextField();
		txtNomeAtributo.setColumns(10);
		txtNomeAtributo.setBounds(12, 57, 200, 30);
		jpAdmStock.add(txtNomeAtributo);

		JButton button_10 = new JButton("Limpar");
		button_10.setBounds(224, 60, 97, 25);
		jpAdmStock.add(button_10);

		JLabel lblTtulo = new JLabel("T\u00EDtulo :");
		lblTtulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTtulo.setBounds(251, 115, 70, 24);
		jpAdmStock.add(lblTtulo);

		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(333, 114, 345, 30);
		jpAdmStock.add(txtTitulo);

		txtAutor = new JTextField();
		txtAutor.setColumns(10);
		txtAutor.setBounds(333, 164, 345, 30);
		jpAdmStock.add(txtAutor);

		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(333, 213, 345, 30);
		jpAdmStock.add(txtData);

		JLabel label_12 = new JLabel("Data:");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_12.setBounds(271, 219, 40, 16);
		jpAdmStock.add(label_12);

		JLabel label_13 = new JLabel("Autor:");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_13.setBounds(263, 170, 48, 16);
		jpAdmStock.add(label_13);

		JLabel label_14 = new JLabel("Descri\u00E7\u00E3o:");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_14.setBounds(224, 266, 87, 16);
		jpAdmStock.add(label_14);

		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(333, 260, 345, 117);
		jpAdmStock.add(txtDescricao);

		JLabel label_15 = new JLabel("Pre\u00E7o:");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_15.setBounds(263, 396, 48, 16);
		jpAdmStock.add(label_15);

		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(333, 390, 345, 30);
		jpAdmStock.add(txtPreco);

		JLabel label_16 = new JLabel("Stock:");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_16.setBounds(263, 430, 48, 16);
		jpAdmStock.add(label_16);

		JList listaLivrosStock = new JList();
		listaLivrosStock.setBounds(12, 120, 200, 363);
		jpAdmStock.add(listaLivrosStock);

		JButton btnRemoveStock = new JButton("-");
		btnRemoveStock.setBounds(437, 427, 48, 25);
		jpAdmStock.add(btnRemoveStock);

		JButton btnAddStock = new JButton("+");
		btnAddStock.setBounds(556, 427, 48, 25);
		jpAdmStock.add(btnAddStock);

		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(497, 424, 48, 30);
		jpAdmStock.add(textField_18);

		JButton btnConfirmar = new JButton("OK");
		btnConfirmar.setBounds(333, 481, 97, 25);
		jpAdmStock.add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(581, 481, 97, 25);
		jpAdmStock.add(btnCancelar);

		JPanel jpAdmConta = new JPanel();
		jpAdmConta.setBackground(SystemColor.menu);
		jpAdmConta.setBounds(0, 0, 763, 545);
		panelPrincipal.add(jpAdmConta);
		jpAdmConta.setLayout(null);
		jpAdmConta.setVisible(false);

		JLabel label = new JLabel("Alterar UserName:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setAlignmentX(0.5f);
		label.setBounds(105, 48, 203, 31);
		jpAdmConta.add(label);

		JLabel label_1 = new JLabel("UserName:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(67, 92, 113, 24);
		jpAdmConta.add(label_1);

		txtUsername = new JTextField();
		txtUsername.setBounds(67, 129, 279, 31);
		jpAdmConta.add(txtUsername);

		JLabel label_2 = new JLabel("Password:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(67, 173, 113, 24);
		jpAdmConta.add(label_2);

		txtPassword = new JTextField();
		txtPassword.setBounds(67, 210, 279, 31);
		jpAdmConta.add(txtPassword);

		JLabel label_3 = new JLabel("Novo UserName:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(67, 254, 171, 24);
		jpAdmConta.add(label_3);

		txtNovoUsername = new JTextField();
		txtNovoUsername.setBounds(67, 284, 279, 31);
		jpAdmConta.add(txtNovoUsername);

		JButton btnConfirmarUsername = new JButton("Confirmar");
		btnConfirmarUsername.setBackground(SystemColor.controlHighlight);
		btnConfirmarUsername.setBounds(67, 359, 97, 25);
		jpAdmConta.add(btnConfirmarUsername);

		JButton btnCancelarUsername = new JButton("Cancelar");
		btnCancelarUsername.setBackground(SystemColor.controlHighlight);
		btnCancelarUsername.setBounds(249, 359, 97, 25);
		jpAdmConta.add(btnCancelarUsername);

		JLabel label_4 = new JLabel("Alterar PassWord:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_4.setAlignmentX(0.5f);
		label_4.setBounds(432, 48, 203, 31);
		jpAdmConta.add(label_4);

		JLabel label_5 = new JLabel("Password:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(432, 90, 113, 24);
		jpAdmConta.add(label_5);

		passwordField = new JPasswordField();
		passwordField.setBounds(432, 127, 279, 31);
		jpAdmConta.add(passwordField);

		JLabel label_9 = new JLabel("Nova Password:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_9.setBounds(432, 171, 113, 24);
		jpAdmConta.add(label_9);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(432, 208, 279, 31);
		jpAdmConta.add(passwordField_1);

		JLabel label_10 = new JLabel("Confirmar Password:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_10.setBounds(432, 252, 171, 24);
		jpAdmConta.add(label_10);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(432, 282, 279, 31);
		jpAdmConta.add(passwordField_2);

		JButton btnConfirmarPasse = new JButton("Confirmar");
		btnConfirmarPasse.setBackground(SystemColor.controlHighlight);
		btnConfirmarPasse.setBounds(432, 357, 97, 25);
		jpAdmConta.add(btnConfirmarPasse);

		JButton btnCancelarPasse = new JButton("Cancelar");
		btnCancelarPasse.setBackground(SystemColor.controlHighlight);
		btnCancelarPasse.setBounds(588, 357, 97, 25);
		jpAdmConta.add(btnCancelarPasse);

		jpAdmFuncionarios = new JPanel();
		jpAdmFuncionarios.setBounds(0, 0, 763, 545);
		panelPrincipal.add(jpAdmFuncionarios);
		jpAdmFuncionarios.setLayout(null);
		jpAdmFuncionarios.setVisible(false);

		JList listaAtributosFunc = new JList();
		listaAtributosFunc.setBounds(42, 123, 190, 337);
		jpAdmFuncionarios.add(listaAtributosFunc);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(32, 69, 200, 30);
		jpAdmFuncionarios.add(textField_12);

		JButton btnPesquisaAtributoFunc = new JButton("Pesquisar");
		btnPesquisaAtributoFunc.setBackground(SystemColor.controlHighlight);
		btnPesquisaAtributoFunc.setBounds(264, 28, 97, 25);
		jpAdmFuncionarios.add(btnPesquisaAtributoFunc);

		JButton btnLimparPesquisaFunc = new JButton("Limpar");
		btnLimparPesquisaFunc.setBackground(SystemColor.controlHighlight);
		btnLimparPesquisaFunc.setBounds(264, 72, 97, 25);
		jpAdmFuncionarios.add(btnLimparPesquisaFunc);

		JLabel lblIdFuncionrio = new JLabel("Id funcion\u00E1rio :");
		lblIdFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdFuncionrio.setBounds(264, 116, 119, 22);
		jpAdmFuncionarios.add(lblIdFuncionrio);

		txtIdFunc = new JTextField();
		txtIdFunc.setColumns(10);
		txtIdFunc.setBounds(395, 108, 345, 30);
		jpAdmFuncionarios.add(txtIdFunc);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(319, 149, 64, 25);
		jpAdmFuncionarios.add(lblNome);

		txtNomeFunc = new JTextField();
		txtNomeFunc.setColumns(10);
		txtNomeFunc.setBounds(395, 149, 345, 30);
		jpAdmFuncionarios.add(txtNomeFunc);

		JLabel lblContacto = new JLabel("Contacto :");
		lblContacto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContacto.setBounds(302, 186, 87, 24);
		jpAdmFuncionarios.add(lblContacto);

		txtContactoFunc = new JTextField();
		txtContactoFunc.setColumns(10);
		txtContactoFunc.setBounds(394, 185, 345, 30);
		jpAdmFuncionarios.add(txtContactoFunc);

		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(292, 231, 97, 16);
		jpAdmFuncionarios.add(lblUsername);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(292, 270, 97, 21);
		jpAdmFuncionarios.add(lblPassword);

		txtUsernameFunc = new JTextField();
		txtUsernameFunc.setColumns(10);
		txtUsernameFunc.setBounds(394, 226, 345, 30);
		jpAdmFuncionarios.add(txtUsernameFunc);

		txtPassFunc = new JTextField();
		txtPassFunc.setColumns(10);
		txtPassFunc.setBounds(394, 267, 345, 30);
		jpAdmFuncionarios.add(txtPassFunc);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(32, 29, 200, 22);
		jpAdmFuncionarios.add(comboBox_1);

		JButton btnConfirmFunc = new JButton("OK");
		btnConfirmFunc.setBackground(SystemColor.controlHighlight);
		btnConfirmFunc.setBounds(464, 437, 89, 23);
		jpAdmFuncionarios.add(btnConfirmFunc);

		JButton btnCancelarFunc = new JButton("Cancelar");
		btnCancelarFunc.setBackground(SystemColor.controlHighlight);
		btnCancelarFunc.setBounds(574, 437, 89, 23);
		jpAdmFuncionarios.add(btnCancelarFunc);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(490, 308, 140, 115);
		jpAdmFuncionarios.add(panel);
		panel.setLayout(null);

		JButton btnNovoFunc = new JButton("Novo");
		btnNovoFunc.setBackground(SystemColor.controlHighlight);
		btnNovoFunc.setBounds(25, 11, 89, 23);
		panel.add(btnNovoFunc);

		JButton btnEliminarFunc = new JButton("Eliminar");
		btnEliminarFunc.setBackground(SystemColor.controlHighlight);
		btnEliminarFunc.setBounds(25, 45, 89, 23);
		panel.add(btnEliminarFunc);

		JButton btnLimparCamposFunc = new JButton("Limpar");
		btnLimparCamposFunc.setBackground(SystemColor.controlHighlight);
		btnLimparCamposFunc.setBounds(25, 79, 89, 23);
		panel.add(btnLimparCamposFunc);

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

		// FUNCIONALIDADES DOS DIFERENTES SEPARADORES

		// LIVROS

		comboBoxAtributoLivro.addItem("por que atributo pretende pesquisar o livro");
		comboBoxAtributoLivro.addItem("Titulo");
		comboBoxAtributoLivro.addItem("Autor");
		comboBoxAtributoLivro.addItem("Id");

		btnPesquisarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String[] listaTeste = { "a", "b", "c" };
				listaLivros.setListData(listaTeste);

				if (comboBoxAtributoLivro.getSelectedItem().equals("Titulo")) {

//					String titulo = txtAtributoPesquisaLivro.getText();
//					
//					String [] listaT=gl.getViewComics().listaTitulo(titulo);
				}
				if (comboBoxAtributoLivro.getSelectedItem().equals("Autor")) {
					
					
				}

			}
		});
	}
}
