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
	private JTextField tbLivrosStock;
	private JTextField tbLivrosPreco;
	private JTextField tbLivrosDescricao;
	private JTextField tbLivrosData;
	private JTextField tbLivrosAutor;
	private JTextField tbLivrosTitulo;
	private JTextField tbLivrosPesq;
	private JTextField tbFuncionariopesq;
	private JTextField tbFuncionarioNfun;
	private JTextField tbFuncionarioNome;
	private JTextField tbFuncionarioContacto;
	private JTextField tbFuncionarioUser;
	private JPasswordField tbFuncionarioPass;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		
		JPanel panelStock = new JPanel();
		panelStock.setBounds(0, 0, 1022, 545);
		panelPrincipal.add(panelStock);
		panelStock.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 26, 251, 30);
		panelStock.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(12, 61, 251, 30);
		panelStock.add(textField);
		
		JButton button = new JButton("Limpar");
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(275, 27, 115, 29);
		panelStock.add(button);
		
		JButton button_1 = new JButton("Pesquisar");
		button_1.setBackground(SystemColor.controlHighlight);
		button_1.setBounds(275, 62, 115, 29);
		panelStock.add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(459, 108, 277, 22);
		panelStock.add(textField_1);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(396, 104, 44, 30);
		panelStock.add(label);
		
		JLabel label_1 = new JLabel("Autor:");
		label_1.setBounds(396, 158, 44, 30);
		panelStock.add(label_1);
		
		JLabel label_2 = new JLabel("Data:");
		label_2.setBounds(404, 216, 36, 30);
		panelStock.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(459, 220, 277, 22);
		panelStock.add(textField_3);
		
		JLabel label_3 = new JLabel("Descri\u00E7\u00E3o:");
		label_3.setBounds(374, 278, 66, 30);
		panelStock.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setDropMode(DropMode.ON_OR_INSERT_ROWS);
		textField_4.setColumns(10);
		textField_4.setBounds(459, 282, 277, 118);
		panelStock.add(textField_4);
		
		JLabel label_4 = new JLabel("Pre\u00E7o:");
		label_4.setBounds(396, 402, 44, 30);
		panelStock.add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(459, 406, 277, 22);
		panelStock.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(459, 162, 277, 22);
		panelStock.add(textField_6);
		
		JList lGestaoLivros = new JList();
		lGestaoLivros.setBounds(12, 104, 251, 428);
		panelStock.add(lGestaoLivros);
		
		JButton btnNewButton = new JButton("-");
		btnNewButton.setBounds(516, 436, 44, 25);
		panelStock.add(btnNewButton);
		
		JButton button_7 = new JButton("+");
		button_7.setBounds(637, 436, 44, 25);
		panelStock.add(button_7);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setText("1");
		textField_7.setColumns(10);
		textField_7.setBounds(561, 437, 75, 22);
		panelStock.add(textField_7);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(396, 440, 44, 30);
		panelStock.add(lblStock);
		
		JButton button_8 = new JButton("Novo");
		button_8.setBounds(432, 26, 97, 30);
		panelStock.add(button_8);
		
		JButton button_9 = new JButton("Eliminar");
		button_9.setBounds(541, 26, 97, 30);
		panelStock.add(button_9);
		
		JButton button_10 = new JButton("Limpar");
		button_10.setBounds(656, 26, 97, 30);
		panelStock.add(button_10);
		
		JButton button_11 = new JButton("Ok");
		button_11.setBounds(459, 491, 97, 30);
		panelStock.add(button_11);
		
		JButton button_12 = new JButton("Cancelar");
		button_12.setBounds(639, 491, 97, 30);
		panelStock.add(button_12);
		
		JPanel panelFuncionarios = new JPanel();
		panelFuncionarios.setBounds(0, 0, 1022, 545);
		panelPrincipal.add(panelFuncionarios);
		panelFuncionarios.setLayout(null);
		
		JComboBox cbFuncionariopesq = new JComboBox();
		cbFuncionariopesq.setBounds(12, 26, 308, 30);
		panelFuncionarios.add(cbFuncionariopesq);
		
		tbFuncionariopesq = new JTextField();
		tbFuncionariopesq.setBounds(12, 69, 308, 30);
		panelFuncionarios.add(tbFuncionariopesq);
		tbFuncionariopesq.setColumns(10);
		
		JList lFuncionario = new JList();
		lFuncionario.setBounds(12, 150, 308, 382);
		panelFuncionarios.add(lFuncionario);
		
		tbFuncionarioNfun = new JTextField();
		tbFuncionarioNfun.setColumns(10);
		tbFuncionarioNfun.setBounds(470, 150, 308, 30);
		panelFuncionarios.add(tbFuncionarioNfun);
		
		tbFuncionarioNome = new JTextField();
		tbFuncionarioNome.setColumns(10);
		tbFuncionarioNome.setBounds(470, 198, 308, 30);
		panelFuncionarios.add(tbFuncionarioNome);
		
		tbFuncionarioContacto = new JTextField();
		tbFuncionarioContacto.setColumns(10);
		tbFuncionarioContacto.setBounds(470, 248, 308, 30);
		panelFuncionarios.add(tbFuncionarioContacto);
		
		tbFuncionarioUser = new JTextField();
		tbFuncionarioUser.setColumns(10);
		tbFuncionarioUser.setBounds(470, 307, 308, 30);
		panelFuncionarios.add(tbFuncionarioUser);
		
		tbFuncionarioPass = new JPasswordField();
		tbFuncionarioPass.setColumns(10);
		tbFuncionarioPass.setBounds(470, 362, 308, 30);
		panelFuncionarios.add(tbFuncionarioPass);
		
		JButton btFuncionarioLimparpesq = new JButton("Limpar");
		btFuncionarioLimparpesq.setBounds(332, 29, 97, 30);
		panelFuncionarios.add(btFuncionarioLimparpesq);
		
		JButton btFuncionarioPesquisar = new JButton("Pesquisar");
		btFuncionarioPesquisar.setBounds(332, 72, 97, 30);
		panelFuncionarios.add(btFuncionarioPesquisar);
		
		JButton btFuncionarioOk = new JButton("Ok");
		btFuncionarioOk.setBounds(470, 419, 97, 30);
		panelFuncionarios.add(btFuncionarioOk);
		
		JButton btFuncionarioCancelar = new JButton("Cancelar");
		btFuncionarioCancelar.setBounds(681, 419, 97, 30);
		panelFuncionarios.add(btFuncionarioCancelar);
		
		JButton btFuncionarioNovo = new JButton("Novo");
		btFuncionarioNovo.setBounds(470, 29, 97, 30);
		panelFuncionarios.add(btFuncionarioNovo);
		
		JButton btFuncionarioEliminar = new JButton("Eliminar");
		btFuncionarioEliminar.setBounds(579, 29, 97, 30);
		panelFuncionarios.add(btFuncionarioEliminar);
		
		JButton btFuncionarioLimpar = new JButton("Limpar");
		btFuncionarioLimpar.setBounds(694, 29, 97, 30);
		panelFuncionarios.add(btFuncionarioLimpar);
		
		JLabel lblFuncionario = new JLabel("Funcionario:");
		lblFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFuncionario.setBounds(12, 112, 82, 30);
		panelFuncionarios.add(lblFuncionario);
		
		JLabel lblNFuncionario = new JLabel("N\u00BA Funcionario:");
		lblNFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNFuncionario.setBounds(332, 150, 105, 30);
		panelFuncionarios.add(lblNFuncionario);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(381, 198, 56, 30);
		panelFuncionarios.add(lblNome);
		
		JLabel lblContacto = new JLabel("Contacto:");
		lblContacto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContacto.setBounds(369, 248, 68, 30);
		panelFuncionarios.add(lblContacto);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(355, 307, 82, 30);
		panelFuncionarios.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(369, 362, 68, 30);
		panelFuncionarios.add(lblPassword);
		
		JPanel panelLivros = new JPanel();
		panelLivros.setLayout(null);
		panelLivros.setBounds(0, 0, 1022, 545);
		panelPrincipal.add(panelLivros);
		
		JButton btLivrosLimpar = new JButton("Limpar");
		btLivrosLimpar.setBackground(SystemColor.controlHighlight);
		btLivrosLimpar.setBounds(275, 27, 115, 29);
		panelLivros.add(btLivrosLimpar);
		
		JButton btLivrosPesquisar = new JButton("Pesquisar");
		btLivrosPesquisar.setBackground(SystemColor.controlHighlight);
		btLivrosPesquisar.setBounds(275, 62, 115, 29);
		panelLivros.add(btLivrosPesquisar);
		
		JLabel label_27 = new JLabel("Stock:");
		label_27.setBounds(297, 437, 44, 30);
		panelLivros.add(label_27);
		
		tbLivrosStock = new JTextField();
		tbLivrosStock.setColumns(10);
		tbLivrosStock.setBounds(360, 441, 277, 22);
		panelLivros.add(tbLivrosStock);
		
		tbLivrosPreco = new JTextField();
		tbLivrosPreco.setColumns(10);
		tbLivrosPreco.setBounds(360, 406, 277, 22);
		panelLivros.add(tbLivrosPreco);
		
		JLabel label_28 = new JLabel("Pre\u00E7o:");
		label_28.setBounds(297, 402, 44, 30);
		panelLivros.add(label_28);
		
		tbLivrosDescricao = new JTextField();
		tbLivrosDescricao.setDropMode(DropMode.ON_OR_INSERT_ROWS);
		tbLivrosDescricao.setColumns(10);
		tbLivrosDescricao.setBounds(360, 282, 277, 118);
		panelLivros.add(tbLivrosDescricao);
		
		JLabel label_29 = new JLabel("Descri\u00E7\u00E3o:");
		label_29.setBounds(275, 278, 66, 30);
		panelLivros.add(label_29);
		
		tbLivrosData = new JTextField();
		tbLivrosData.setColumns(10);
		tbLivrosData.setBounds(360, 220, 277, 22);
		panelLivros.add(tbLivrosData);
		
		JLabel label_30 = new JLabel("Data:");
		label_30.setBounds(305, 216, 36, 30);
		panelLivros.add(label_30);
		
		tbLivrosAutor = new JTextField();
		tbLivrosAutor.setColumns(10);
		tbLivrosAutor.setBounds(360, 162, 277, 22);
		panelLivros.add(tbLivrosAutor);
		
		JLabel label_31 = new JLabel("Autor:");
		label_31.setBounds(297, 158, 44, 30);
		panelLivros.add(label_31);
		
		JLabel label_32 = new JLabel("Nome:");
		label_32.setBounds(297, 104, 44, 30);
		panelLivros.add(label_32);
		
		tbLivrosTitulo = new JTextField();
		tbLivrosTitulo.setColumns(10);
		tbLivrosTitulo.setBounds(360, 108, 277, 22);
		panelLivros.add(tbLivrosTitulo);
		
		JComboBox cbLivrosPesq = new JComboBox();
		cbLivrosPesq.setBounds(12, 26, 251, 30);
		panelLivros.add(cbLivrosPesq);
		
		tbLivrosPesq = new JTextField();
		tbLivrosPesq.setColumns(10);
		tbLivrosPesq.setBounds(12, 61, 251, 30);
		panelLivros.add(tbLivrosPesq);
		
		JList lLivros = new JList();
		lLivros.setBounds(12, 104, 251, 428);
		panelLivros.add(lLivros);
		
	}
}
