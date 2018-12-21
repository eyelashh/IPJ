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
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
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
		
		lblViewcomics.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewcomics.setBounds(-80, 0, 1144, 115);
		lblViewcomics.setFont(new Font("Papyrus", Font.BOLD, 46));
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ViewComics Inc.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 67));
		lblNewLabel_1.setBounds(262, 13, 569, 85);
		panel.add(lblNewLabel_1);
		panel.add(lblViewcomics);
		
		JButton btnNewButton = new JButton("Livros");
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 31));
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(47, 141, 176, 55);
		panel.add(btnNewButton);
		
		JButton btnCarrinhoDeCompras = new JButton("Carrinho");
		btnCarrinhoDeCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCarrinhoDeCompras.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnCarrinhoDeCompras.setBackground(SystemColor.controlHighlight);
		btnCarrinhoDeCompras.setBounds(47, 234, 176, 60);
		panel.add(btnCarrinhoDeCompras);
		
		// painel da área restrita 
		JPanel panel_2 = new JPanel() {
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
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(1064, 0, 200, 220);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(101, 46, 98, 27);
		panel_2.add(lblUsername);
		lblUsername.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		
		JLabel lblAreaRestrita = new JLabel("\u00C1rea restrita");
		lblAreaRestrita.setHorizontalAlignment(SwingConstants.CENTER);
		//para mudar a cor de uma label temos que primeiro mete-la opaca e depois a cor

		lblAreaRestrita.setBounds(0, 0, 199, 34);
		panel_2.add(lblAreaRestrita);
		lblAreaRestrita.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		
		textField = new JTextField();
		textField.setBounds(10, 73, 189, 27);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(110, 99, 89, 29);
		panel_2.add(lblPassword);
		lblPassword.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 21));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 129, 189, 27);
		panel_2.add(passwordField);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(59, 167, 89, 23);
		panel_2.add(btnEntrar);
		
		JButton btnNewButton_2 = new JButton("Limpar");
		btnNewButton_2.setBounds(483, 141, 115, 20);
		panel.add(btnNewButton_2);
		
		Choice choice = new Choice();
		choice.setBounds(262, 141, 200, 44);
		panel.add(choice);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(262, 174, 200, 22);
		panel.add(textField_1);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(483, 174, 115, 20);
		panel.add(btnPesquisar);
		
		List list = new List();
		list.setBounds(262, 234, 200, 348);
		panel.add(list);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(484, 301, 225, 208);
		panel.add(textField_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
}

