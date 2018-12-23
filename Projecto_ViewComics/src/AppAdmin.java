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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
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
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_17;
	private JTextField textField_19;

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
		
		JButton btnNewButton_2 = new JButton("LogOut");
		btnNewButton_2.setBackground(SystemColor.controlHighlight);
		btnNewButton_2.setBounds(1138, 54, 89, 23);
		panelcabecalho.add(btnNewButton_2);
		
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
		
		textField_9 = new JTextField();
		textField_9.setBounds(67, 129, 279, 31);
		jpAdmConta.add(textField_9);
		
		JLabel label_2 = new JLabel("Password:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(67, 173, 113, 24);
		jpAdmConta.add(label_2);
		
		textField_10 = new JTextField();
		textField_10.setBounds(67, 210, 279, 31);
		jpAdmConta.add(textField_10);
		
		JLabel label_3 = new JLabel("Novo UserName:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(67, 254, 171, 24);
		jpAdmConta.add(label_3);
		
		textField_11 = new JTextField();
		textField_11.setBounds(67, 284, 279, 31);
		jpAdmConta.add(textField_11);
		
		JButton button = new JButton("Confirmar");
		button.setBounds(67, 359, 97, 25);
		jpAdmConta.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(249, 359, 97, 25);
		jpAdmConta.add(button_1);
		
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
		
		JButton button_7 = new JButton("Confirmar");
		button_7.setBounds(520, 359, 97, 25);
		jpAdmConta.add(button_7);
		
		JButton button_8 = new JButton("Cancelar");
		button_8.setBounds(676, 359, 97, 25);
		jpAdmConta.add(button_8);
		
		jpAdmFuncionarios = new JPanel();
		jpAdmFuncionarios.setBounds(0, 0, 998, 519);
		panelPrincipal.add(jpAdmFuncionarios);
		jpAdmFuncionarios.setLayout(null);
		jpAdmFuncionarios.setVisible(false);
		
		JList list_2 = new JList();
		list_2.setBounds(62, 138, 190, 337);
		jpAdmFuncionarios.add(list_2);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(52, 84, 200, 30);
		jpAdmFuncionarios.add(textField_12);
		
		JButton button_2 = new JButton("Pesquisar");
		button_2.setBounds(264, 43, 97, 25);
		jpAdmFuncionarios.add(button_2);
		
		JButton button_3 = new JButton("Limpar");
		button_3.setBounds(264, 87, 97, 25);
		jpAdmFuncionarios.add(button_3);
		
		JLabel lblIdFuncionrio = new JLabel("Id funcion\u00E1rio :");
		lblIdFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdFuncionrio.setBounds(292, 146, 119, 22);
		jpAdmFuncionarios.add(lblIdFuncionrio);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(423, 138, 345, 30);
		jpAdmFuncionarios.add(textField_13);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(354, 189, 64, 25);
		jpAdmFuncionarios.add(lblNome);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(423, 188, 345, 30);
		jpAdmFuncionarios.add(textField_14);
		
		JLabel lblContacto = new JLabel("Contacto :");
		lblContacto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContacto.setBounds(331, 238, 87, 24);
		jpAdmFuncionarios.add(lblContacto);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(423, 237, 345, 30);
		jpAdmFuncionarios.add(textField_15);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(324, 303, 97, 16);
		jpAdmFuncionarios.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(328, 361, 107, 21);
		jpAdmFuncionarios.add(lblPassword);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(423, 298, 345, 30);
		jpAdmFuncionarios.add(textField_17);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(423, 358, 345, 30);
		jpAdmFuncionarios.add(textField_19);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(52, 44, 200, 22);
		jpAdmFuncionarios.add(comboBox_1);
		
		JButton btnFuncConfirm = new JButton("OK");
		btnFuncConfirm.setBounds(500, 428, 89, 23);
		jpAdmFuncionarios.add(btnFuncConfirm);
		
		JButton btnFuncCancelar = new JButton("Cancelar");
		btnFuncCancelar.setBounds(596, 428, 89, 23);
		jpAdmFuncionarios.add(btnFuncCancelar);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		panel.setBounds(823, 146, 140, 221);
		jpAdmFuncionarios.add(panel);
		panel.setLayout(null);
		
		JButton btnFuncNovo = new JButton("Novo");
		btnFuncNovo.setBounds(25, 36, 89, 23);
		panel.add(btnFuncNovo);
		
		JButton btnFuncEliminar = new JButton("Eliminar");
		btnFuncEliminar.setBounds(25, 92, 89, 23);
		panel.add(btnFuncEliminar);
		
		JButton btnFuncLimpar = new JButton("Limpar");
		btnFuncLimpar.setBounds(25, 153, 89, 23);
		panel.add(btnFuncLimpar);
		
		JPanel jpAdmLivros = new JPanel();
		jpAdmLivros.setLayout(null);
		jpAdmLivros.setBounds(12, 13, 998, 519);
		panelPrincipal.add(jpAdmLivros);
		jpAdmLivros.setVisible(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 13, 200, 30);
		jpAdmLivros.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(12, 57, 200, 30);
		jpAdmLivros.add(textField);
		textField.setColumns(10);
		
		JList list = new JList();
		list.setBounds(22, 111, 190, 395);
		jpAdmLivros.add(list);
		
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(333, 114, 345, 30);
		jpAdmLivros.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(333, 164, 345, 30);
		jpAdmLivros.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(333, 213, 345, 30);
		jpAdmLivros.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(333, 260, 345, 117);
		jpAdmLivros.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(333, 402, 345, 30);
		jpAdmLivros.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(333, 453, 345, 30);
		jpAdmLivros.add(textField_8);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setBounds(224, 16, 97, 25);
		jpAdmLivros.add(btnNewButton);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(224, 60, 97, 25);
		jpAdmLivros.add(btnLimpar);
		
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
