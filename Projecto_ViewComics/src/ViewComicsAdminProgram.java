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
		
		JPanel panelFuncionarios = new JPanel();
		panelFuncionarios.setBounds(0, 0, 1022, 545);
		panelPrincipal.add(panelFuncionarios);
		panelFuncionarios.setLayout(null);
		
		JPanel panelStock = new JPanel();
		panelStock.setLayout(null);
		panelStock.setBounds(0, 0, 1022, 545);
		panelPrincipal.add(panelStock);
		
		JPanel panelEstatistica = new JPanel();
		panelEstatistica.setBounds(0, 0, 1022, 545);
		panelPrincipal.add(panelEstatistica);
		panelEstatistica.setLayout(null);
		
		JPanel panelGesConta = new JPanel();
		panelGesConta.setLayout(null);
		panelGesConta.setBounds(0, 0, 1022, 545);
		panelPrincipal.add(panelGesConta);
		
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
