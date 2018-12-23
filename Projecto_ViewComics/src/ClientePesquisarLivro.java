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
//import net.miginfocom.swing.MigLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;
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

public class ClientePesquisarLivro {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientePesquisarLivro window = new ClientePesquisarLivro();
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
	public ClientePesquisarLivro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel() {
			@Override
			//o paint component vai pintar literalmente o componente
			protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				Image img;
				try {
					
					// importar imagem para o background do panel, podemos fazê-lo da internet ou do ficheiro 
					
					// img = ImageIO.read(new URL( "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO.read(new File( "C:\\Users\\Joana\\Dropbox\\IPJ_ProjectoFinal\\Design\\ViewComics\\fundo2.jpg"));
					g.drawImage(img,0,0,null); 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
	
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Livros");
		btnNewButton.setBounds(45, 177, 176, 55);
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 31));
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("Entrar");
		btnNewButton_1.setBackground(SystemColor.controlHighlight);
		btnNewButton_1.setBounds(1135, 97, 103, 27);
		panel.add(btnNewButton_1);
		panel.add(btnNewButton);
		
		JButton btnCarrinhoDeCompras = new JButton("Carrinho");
		btnCarrinhoDeCompras.setForeground(Color.BLACK);
		btnCarrinhoDeCompras.setBounds(45, 254, 176, 60);
		btnCarrinhoDeCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCarrinhoDeCompras.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnCarrinhoDeCompras.setBackground(SystemColor.controlHighlight);
		panel.add(btnCarrinhoDeCompras);
		
		JButton btnNewButton_2 = new JButton("Limpar");
		btnNewButton_2.setBackground(SystemColor.controlHighlight);
		btnNewButton_2.setBounds(481, 177, 115, 20);
		panel.add(btnNewButton_2);
		
		Choice choice = new Choice();
		choice.setBounds(260, 177, 200, 20);
		panel.add(choice);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(260, 210, 200, 22);
		panel.add(textField_1);
		
		List list = new List();
		list.setBounds(261, 254, 289, 348);
		panel.add(list);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(571, 254, 260, 211);
		panel.add(textField_2);
		
		JPanel panel_1 = new JPanel() {
protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				Image img;
				try {
					
					// importar imagem para o background do panel, podemos fazê-lo da internet ou do ficheiro 
					
					// img = ImageIO.read(new URL( "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO.read(new File( "C:\\Users\\Joana\\Dropbox\\IPJ_ProjectoFinal\\Design\\ViewComics\\fundo.jpg"));
					g.drawImage(img,0,0,null); 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		panel_1.setBounds(857, 254, 333, 211);
		panel_1.setLayout(null);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.add(panel_1);
		
		JLabel lblAdicionarAoCarrinho = new JLabel("Adicionar ao carrinho");
		lblAdicionarAoCarrinho.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarAoCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblAdicionarAoCarrinho.setBounds(38, 27, 274, 34);
		panel_1.add(lblAdicionarAoCarrinho);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnAdicionar.setBounds(96, 149, 152, 42);
		panel_1.add(btnAdicionar);
		
		JButton btnEntrar = new JButton("-");
		btnEntrar.setBounds(62, 90, 54, 48);
		panel_1.add(btnEntrar);
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton button = new JButton("-");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(226, 90, 54, 48);
		panel_1.add(button);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(141, 99, 61, 34);
		panel_1.add(textField_3);
		
		JLabel lblAreaRestrita = new JLabel("\u00C1rea restrita (funcion\u00E1rio ou admin)");
		lblAreaRestrita.setBounds(908, 13, 356, 27);
		panel.add(lblAreaRestrita);
		lblAreaRestrita.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreaRestrita.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(1025, 46, 98, 27);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setBounds(934, 123, 189, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(1028, 97, 89, 29);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 21));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(934, 74, 189, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("ViewComics Inc.");
		lblNewLabel_1.setBounds(97, 13, 795, 85);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 95));
		panel.add(lblNewLabel_1);
		
		JLabel lblViewcomics = new JLabel()
		{
			@Override
			//o paint component vai pintar literalmente o componente
			protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				Image img;
				try {
					
					// importar imagem para o background do panel, podemos fazê-lo da internet ou do ficheiro 
					
					// img = ImageIO.read(new URL( "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO.read(new File( "C:\\Users\\Joana\\Dropbox\\IPJ_ProjectoFinal\\Design\\ViewComics\\fundo.jpg"));
					g.drawImage(img,0,0,null); 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		lblViewcomics.setBounds(-90, 0, 1354, 166);
		
		lblViewcomics.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewcomics.setFont(new Font("Papyrus", Font.BOLD, 46));
		panel.add(lblViewcomics);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(SystemColor.controlHighlight);
		btnPesquisar.setBounds(481, 212, 115, 20);
		panel.add(btnPesquisar);
		
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
}

