import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;

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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
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
import java.awt.Label;
import java.awt.FlowLayout;

public class AppAdmin {

	private JFrame frame;
	private JTextField textField_2;
	private JTextField textField_4;
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

	/**
	 * Launch the application.
	 */
		//EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppAdmin window = new AppAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		//});
	

	/**
	 * Create the application.
	 */
	public AppAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel Paineltotal = new JPanel();
		Paineltotal.setBackground(Color.ORANGE);
		Paineltotal.setBounds(0, 0, 1262, 721);
		frame.getContentPane().add(Paineltotal);
		Paineltotal.setLayout(null);
		
		JPanel panelcabecalho = new JPanel();
		panelcabecalho.setLayout(null);
		panelcabecalho.setBounds(0, 0, 1262, 176);
		Paineltotal.add(panelcabecalho);
		
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
		
		JLabel label_8 = new JLabel("Bem Vindo -Nome - Administrador");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		label_8.setBounds(892, 13, 335, 27);
		panelcabecalho.add(label_8);
		
		JButton btnLogOut = new JButton("LogOut");
		btnLogOut.setBackground(SystemColor.controlHighlight);
		btnLogOut.setBounds(1138, 54, 89, 23);
		panelcabecalho.add(btnLogOut);
		
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
		
		JPanel jpAdmStock = new JPanel();
		jpAdmStock.setBounds(0, 0, 998, 519);
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
		
		JList list_1 = new JList();
		list_1.setBounds(12, 120, 200, 363);
		jpAdmStock.add(list_1);
		
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
		
		JPanel jpAdmLivros = new JPanel();
		jpAdmLivros.setLayout(null);
		jpAdmLivros.setBounds(12, 13, 998, 519);
		panelPrincipal.add(jpAdmLivros);
		jpAdmLivros.setVisible(false);
		
		JComboBox comboBoxAtributoLivro = new JComboBox();
		comboBoxAtributoLivro.setBounds(12, 13, 200, 30);
		jpAdmLivros.add(comboBoxAtributoLivro);
		
		txtAtributoPesquisaLivro = new JTextField();
		txtAtributoPesquisaLivro.setBounds(12, 57, 200, 30);
		jpAdmLivros.add(txtAtributoPesquisaLivro);
		txtAtributoPesquisaLivro.setColumns(10);
		
		JList listaLivros = new JList();
		listaLivros.setBounds(22, 111, 190, 395);
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
		btnPesquisarLivro.setBounds(224, 16, 97, 25);
		jpAdmLivros.add(btnPesquisarLivro);
		
		JButton btnLimparLivro = new JButton("Limpar");
		btnLimparLivro.setBounds(224, 60, 97, 25);
		jpAdmLivros.add(btnLimparLivro);
		
		jpAdmFuncionarios = new JPanel();
		jpAdmFuncionarios.setBounds(0, 0, 998, 519);
		panelPrincipal.add(jpAdmFuncionarios);
		jpAdmFuncionarios.setLayout(null);
		jpAdmFuncionarios.setVisible(false);
		
		JList listaAtributosFunc = new JList();
		listaAtributosFunc.setBounds(62, 138, 190, 337);
		jpAdmFuncionarios.add(listaAtributosFunc);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(52, 84, 200, 30);
		jpAdmFuncionarios.add(textField_12);
		
		JButton btnPesquisaAtributoFunc = new JButton("Pesquisar");
		btnPesquisaAtributoFunc.setBounds(264, 43, 97, 25);
		jpAdmFuncionarios.add(btnPesquisaAtributoFunc);
		
		JButton btnLimparPesquisaFunc = new JButton("Limpar");
		btnLimparPesquisaFunc.setBounds(264, 87, 97, 25);
		jpAdmFuncionarios.add(btnLimparPesquisaFunc);
		
		JLabel lblIdFuncionrio = new JLabel("Id funcion\u00E1rio :");
		lblIdFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdFuncionrio.setBounds(292, 146, 119, 22);
		jpAdmFuncionarios.add(lblIdFuncionrio);
		
		txtIdFunc = new JTextField();
		txtIdFunc.setColumns(10);
		txtIdFunc.setBounds(423, 138, 345, 30);
		jpAdmFuncionarios.add(txtIdFunc);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(354, 189, 64, 25);
		jpAdmFuncionarios.add(lblNome);
		
		txtNomeFunc = new JTextField();
		txtNomeFunc.setColumns(10);
		txtNomeFunc.setBounds(423, 188, 345, 30);
		jpAdmFuncionarios.add(txtNomeFunc);
		
		JLabel lblContacto = new JLabel("Contacto :");
		lblContacto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContacto.setBounds(331, 238, 87, 24);
		jpAdmFuncionarios.add(lblContacto);
		
		txtContactoFunc = new JTextField();
		txtContactoFunc.setColumns(10);
		txtContactoFunc.setBounds(423, 237, 345, 30);
		jpAdmFuncionarios.add(txtContactoFunc);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(324, 303, 97, 16);
		jpAdmFuncionarios.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(328, 361, 107, 21);
		jpAdmFuncionarios.add(lblPassword);
		
		txtUsernameFunc = new JTextField();
		txtUsernameFunc.setColumns(10);
		txtUsernameFunc.setBounds(423, 298, 345, 30);
		jpAdmFuncionarios.add(txtUsernameFunc);
		
		txtPassFunc = new JTextField();
		txtPassFunc.setColumns(10);
		txtPassFunc.setBounds(423, 358, 345, 30);
		jpAdmFuncionarios.add(txtPassFunc);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(52, 44, 200, 22);
		jpAdmFuncionarios.add(comboBox_1);
		
		JButton btnConfirmFunc = new JButton("OK");
		btnConfirmFunc.setBounds(500, 428, 89, 23);
		jpAdmFuncionarios.add(btnConfirmFunc);
		
		JButton btnCancelarFunc = new JButton("Cancelar");
		btnCancelarFunc.setBounds(596, 428, 89, 23);
		jpAdmFuncionarios.add(btnCancelarFunc);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(823, 146, 140, 221);
		jpAdmFuncionarios.add(panel);
		panel.setLayout(null);
		
		JButton btnNovoFunc = new JButton("Novo");
		btnNovoFunc.setBounds(25, 36, 89, 23);
		panel.add(btnNovoFunc);
		
		JButton btnEliminarFunc = new JButton("Eliminar");
		btnEliminarFunc.setBounds(25, 92, 89, 23);
		panel.add(btnEliminarFunc);
		
		JButton btnLimparCamposFunc = new JButton("Limpar");
		btnLimparCamposFunc.setBounds(25, 153, 89, 23);
		panel.add(btnLimparCamposFunc);
		
		JPanel jpAdmConta = new JPanel();
		jpAdmConta.setBounds(0, 0, 998, 519);
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
		btnConfirmarUsername.setBounds(67, 359, 97, 25);
		jpAdmConta.add(btnConfirmarUsername);
		
		JButton btnCancelarUsername = new JButton("Cancelar");
		btnCancelarUsername.setBounds(249, 359, 97, 25);
		jpAdmConta.add(btnCancelarUsername);
		
		JLabel label_4 = new JLabel("Alterar PassWord:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_4.setAlignmentX(0.5f);
		label_4.setBounds(520, 50, 203, 31);
		jpAdmConta.add(label_4);
		
		JLabel label_5 = new JLabel("Password:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(520, 92, 113, 24);
		jpAdmConta.add(label_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(520, 129, 279, 31);
		jpAdmConta.add(passwordField);
		
		JLabel label_9 = new JLabel("Nova Password:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_9.setBounds(520, 173, 113, 24);
		jpAdmConta.add(label_9);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(520, 210, 279, 31);
		jpAdmConta.add(passwordField_1);
		
		JLabel label_10 = new JLabel("Confirmar Password:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_10.setBounds(520, 254, 171, 24);
		jpAdmConta.add(label_10);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(520, 284, 279, 31);
		jpAdmConta.add(passwordField_2);
		
		JButton btnConfirmarPasse = new JButton("Confirmar");
		btnConfirmarPasse.setBounds(520, 359, 97, 25);
		jpAdmConta.add(btnConfirmarPasse);
		
		JButton btnCancelarPasse = new JButton("Cancelar");
		btnCancelarPasse.setBounds(676, 359, 97, 25);
		jpAdmConta.add(btnCancelarPasse);
		
		JPanel jpAdmEstatisticas = new JPanel();
		jpAdmEstatisticas.setBounds(0, 0, 998, 519);
		panelPrincipal.add(jpAdmEstatisticas);
		jpAdmEstatisticas.setLayout(null);
		
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
	}
}
