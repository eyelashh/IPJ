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

public class ViewComicsAdminProgram {

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
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewComicsAdminProgram window = new ViewComicsAdminProgram();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewComicsAdminProgram() {
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
		
		JPanel panelMenu = new JPanel();
		panelMenu.setLayout(null);
		panelMenu.setBounds(0, 176, 241, 545);
		Paineltotal.add(panelMenu);
		
		JButton button_2 = new JButton("Livros");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 31));
		button_2.setBackground(SystemColor.controlHighlight);
		button_2.setBounds(25, 13, 176, 55);
		panelMenu.add(button_2);
		
		JButton button_3 = new JButton("Funcionarios");
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		button_3.setBackground(SystemColor.controlHighlight);
		button_3.setBounds(25, 81, 176, 60);
		panelMenu.add(button_3);
		
		JButton button_4 = new JButton("Gest\u00E3o Stock");
		button_4.setForeground(Color.BLACK);
		button_4.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		button_4.setBackground(SystemColor.controlHighlight);
		button_4.setBounds(25, 154, 176, 60);
		panelMenu.add(button_4);
		
		JButton button_5 = new JButton("Estatisticas");
		button_5.setForeground(Color.BLACK);
		button_5.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		button_5.setBackground(SystemColor.controlHighlight);
		button_5.setBounds(25, 227, 176, 60);
		panelMenu.add(button_5);
		
		JButton button_6 = new JButton("Gestao Conta");
		button_6.setForeground(Color.BLACK);
		button_6.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
		button_6.setBackground(SystemColor.controlHighlight);
		button_6.setBounds(25, 300, 176, 60);
		panelMenu.add(button_6);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(240, 176, 1022, 545);
		Paineltotal.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JPanel jpAdmStock = new JPanel();
		jpAdmStock.setLayout(null);
		jpAdmStock.setBounds(12, 13, 998, 519);
		panelPrincipal.add(jpAdmStock);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(12, 13, 200, 30);
		jpAdmStock.add(comboBox_1);
		
		JButton button_9 = new JButton("Pesquisar");
		button_9.setBounds(224, 16, 97, 25);
		jpAdmStock.add(button_9);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(12, 57, 200, 30);
		jpAdmStock.add(textField_12);
		
		JButton button_10 = new JButton("Limpar");
		button_10.setBounds(224, 60, 97, 25);
		jpAdmStock.add(button_10);
		
		JLabel label_11 = new JLabel("Nome:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_11.setBounds(263, 120, 48, 16);
		jpAdmStock.add(label_11);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(333, 114, 345, 30);
		jpAdmStock.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(333, 164, 345, 30);
		jpAdmStock.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(333, 213, 345, 30);
		jpAdmStock.add(textField_15);
		
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
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(333, 260, 345, 117);
		jpAdmStock.add(textField_16);
		
		JLabel label_15 = new JLabel("Pre\u00E7o:");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_15.setBounds(263, 396, 48, 16);
		jpAdmStock.add(label_15);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(333, 390, 345, 30);
		jpAdmStock.add(textField_17);
		
		JLabel label_16 = new JLabel("Stock:");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_16.setBounds(263, 430, 48, 16);
		jpAdmStock.add(label_16);
		
		JList list_1 = new JList();
		list_1.setBounds(12, 120, 200, 363);
		jpAdmStock.add(list_1);
		
		JButton button_11 = new JButton("Pesquisar");
		button_11.setBounds(363, 16, 97, 25);
		jpAdmStock.add(button_11);
		
		JButton button_12 = new JButton("Pesquisar");
		button_12.setBounds(472, 16, 97, 25);
		jpAdmStock.add(button_12);
		
		JButton button_13 = new JButton("Pesquisar");
		button_13.setBounds(581, 16, 97, 25);
		jpAdmStock.add(button_13);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.setBounds(437, 427, 48, 25);
		jpAdmStock.add(btnNewButton_1);
		
		JButton button_14 = new JButton("+");
		button_14.setBounds(556, 427, 48, 25);
		jpAdmStock.add(button_14);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(497, 424, 48, 30);
		jpAdmStock.add(textField_18);
		
		JButton button_15 = new JButton("Pesquisar");
		button_15.setBounds(333, 481, 97, 25);
		jpAdmStock.add(button_15);
		
		JButton button_16 = new JButton("Pesquisar");
		button_16.setBounds(581, 481, 97, 25);
		jpAdmStock.add(button_16);
		
		JPanel jpAdmLivros = new JPanel();
		jpAdmLivros.setLayout(null);
		jpAdmLivros.setBounds(12, 13, 998, 519);
		panelPrincipal.add(jpAdmLivros);
		
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
		
		JPanel jpAdmConta = new JPanel();
		jpAdmConta.setBounds(12, 13, 998, 519);
		panelPrincipal.add(jpAdmConta);
		jpAdmConta.setLayout(null);
		
		JLabel label = new JLabel("Alterar UserName:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setAlignmentX(0.5f);
		label.setBounds(111, 87, 203, 31);
		jpAdmConta.add(label);
		
		JLabel label_1 = new JLabel("UserName:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(73, 131, 113, 24);
		jpAdmConta.add(label_1);
		
		textField_9 = new JTextField();
		textField_9.setBounds(73, 168, 279, 31);
		jpAdmConta.add(textField_9);
		
		JLabel label_2 = new JLabel("Password:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(73, 212, 113, 24);
		jpAdmConta.add(label_2);
		
		textField_10 = new JTextField();
		textField_10.setBounds(73, 249, 279, 31);
		jpAdmConta.add(textField_10);
		
		JLabel label_3 = new JLabel("Novo UserName:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(73, 293, 171, 24);
		jpAdmConta.add(label_3);
		
		textField_11 = new JTextField();
		textField_11.setBounds(73, 323, 279, 31);
		jpAdmConta.add(textField_11);
		
		JButton button = new JButton("Confirmar");
		button.setBounds(73, 398, 97, 25);
		jpAdmConta.add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(255, 398, 97, 25);
		jpAdmConta.add(button_1);
		
		JLabel label_4 = new JLabel("Alterar PassWord:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label_4.setAlignmentX(0.5f);
		label_4.setBounds(684, 87, 203, 31);
		jpAdmConta.add(label_4);
		
		JLabel label_5 = new JLabel("Password:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(646, 131, 113, 24);
		jpAdmConta.add(label_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(646, 168, 279, 31);
		jpAdmConta.add(passwordField);
		
		JLabel label_9 = new JLabel("Nova Password:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_9.setBounds(646, 212, 113, 24);
		jpAdmConta.add(label_9);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(646, 249, 279, 31);
		jpAdmConta.add(passwordField_1);
		
		JLabel label_10 = new JLabel("Confirmar Password:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_10.setBounds(646, 293, 171, 24);
		jpAdmConta.add(label_10);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(646, 323, 279, 31);
		jpAdmConta.add(passwordField_2);
		
		JButton button_7 = new JButton("Confirmar");
		button_7.setBounds(646, 398, 97, 25);
		jpAdmConta.add(button_7);
		
		JButton button_8 = new JButton("Cancelar");
		button_8.setBounds(828, 398, 97, 25);
		jpAdmConta.add(button_8);
		
		jpAdmFuncionarios = new JPanel();
		jpAdmFuncionarios.setLayout(null);
		jpAdmFuncionarios.setBounds(12, 13, 998, 519);
		panelPrincipal.add(jpAdmFuncionarios);
		
		JPanel jpAdmEstatisticas = new JPanel();
		jpAdmEstatisticas.setLayout(null);
		jpAdmEstatisticas.setBounds(12, 13, 998, 519);
		panelPrincipal.add(jpAdmEstatisticas);
		
	}
}
