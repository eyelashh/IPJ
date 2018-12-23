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
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.List;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class AppCliente {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_12;
	private JPasswordField passwordField;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppCliente window = new AppCliente();
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
	public AppCliente() {
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
		JPanelCabecalho.setBounds(0, 0, 1264, 183);
		frame.getContentPane().add(JPanelCabecalho);
		JPanelCabecalho.setLayout(null);
		
		JLabel label = new JLabel("ViewComics Inc.");
		label.setBounds(176, 30, 624, 118);
		label.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 90));
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(924, 72, 189, 20);
		JPanelCabecalho.add(passwordField);
		
		JLabel label_20 = new JLabel("Password:");
		label_20.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 21));
		label_20.setBounds(1018, 95, 89, 29);
		JPanelCabecalho.add(label_20);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(924, 121, 189, 20);
		JPanelCabecalho.add(textField_13);
		
		JButton button_22 = new JButton("Entrar");
		button_22.setBackground(SystemColor.controlHighlight);
		button_22.setBounds(1125, 95, 103, 27);
		JPanelCabecalho.add(button_22);
		
		JPanel JPanelMenu = new JPanel() {
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
		JPanelMenu.setBounds(0, 185, 245, 544);
		frame.getContentPane().add(JPanelMenu);
		JPanelMenu.setLayout(null);
		
		JButton button = new JButton("Livros");
		button.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 31));
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(26, 36, 176, 55);
		JPanelMenu.add(button);
		
		JButton button_1 = new JButton("Carrinho");
		button_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		button_1.setBackground(SystemColor.controlHighlight);
		button_1.setBounds(26, 115, 176, 60);
		JPanelMenu.add(button_1);
		
		JPanel JPanelPrincipal = new JPanel(){
			@Override
			//o paint component vai pintar literalmente o componente
			protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				Image img;
				try {
					
					// importar imagem para o background do panel, podemos fazê-lo da internet ou do ficheiro 
					
					// img = ImageIO.read(new URL( "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO.read(new File( "C:\\Users\\Joana\\Dropbox\\IPJ_ProjectoFinal\\Design\\ViewComics\\wallpaperMarvel.jpg"));
					g.drawImage(img,0,0,null); 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		JPanelPrincipal.setBounds(255, 185, 1009, 544);
		frame.getContentPane().add(JPanelPrincipal);
		JPanelPrincipal.setLayout(null);
		
		JPanel JPLivros = new JPanel();
		JPLivros.setBounds(0, 0, 1009, 544);
		JPanelPrincipal.add(JPLivros);
		JPLivros.setLayout(null);
		
		Choice choice = new Choice();
		choice.setBounds(65, 27, 200, 20);
		JPLivros.add(choice);
		
		TextField textField_10 = new TextField();
		textField_10.setBounds(65, 60, 200, 22);
		JPLivros.add(textField_10);
		
		JButton button_17 = new JButton("Limpar");
		button_17.setBackground(SystemColor.controlHighlight);
		button_17.setBounds(286, 27, 115, 20);
		JPLivros.add(button_17);
		
		JButton button_18 = new JButton("Pesquisar");
		button_18.setBackground(SystemColor.controlHighlight);
		button_18.setBounds(286, 62, 115, 20);
		JPLivros.add(button_18);
		
		List list = new List();
		list.setBounds(66, 104, 289, 348);
		JPLivros.add(list);
		
		TextField textField_11 = new TextField();
		textField_11.setBounds(376, 104, 260, 211);
		JPLivros.add(textField_11);
		
		JLabel label_17 = new JLabel("Adicionar ao carrinho");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 28));
		label_17.setBounds(700, 131, 274, 34);
		JPLivros.add(label_17);
		
		JButton button_19 = new JButton("-");
		button_19.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_19.setBounds(724, 194, 54, 48);
		JPLivros.add(button_19);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(803, 203, 61, 34);
		JPLivros.add(textField_12);
		
		JButton button_20 = new JButton("-");
		button_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_20.setBounds(888, 194, 54, 48);
		JPLivros.add(button_20);
		
		JButton button_21 = new JButton("Adicionar");
		button_21.setFont(new Font("Tahoma", Font.PLAIN, 23));
		button_21.setBounds(758, 253, 152, 42);
		JPLivros.add(button_21);
		
		JPanel JPCarrinho = new JPanel() {
			protected void paintComponent(Graphics g) {
			}
		};
		JPCarrinho.setBounds(0, 0, 1009, 544);
		JPanelPrincipal.add(JPCarrinho);
		JPCarrinho.setLayout(null);
		
		JLabel label_1 = new JLabel("T\u00EDtulo do livro");
		label_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_1.setBounds(68, 32, 144, 26);
		JPCarrinho.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(68, 82, 220, 36);
		JPCarrinho.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(68, 147, 220, 36);
		JPCarrinho.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(68, 210, 220, 36);
		JPCarrinho.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(68, 273, 220, 36);
		JPCarrinho.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(68, 336, 220, 36);
		JPCarrinho.add(textField_4);
		
		JButton button_2 = new JButton("-");
		button_2.setBounds(310, 336, 44, 36);
		JPCarrinho.add(button_2);
		
		JButton button_3 = new JButton("-");
		button_3.setBounds(310, 273, 44, 36);
		JPCarrinho.add(button_3);
		
		JButton button_4 = new JButton("-");
		button_4.setBounds(310, 210, 44, 36);
		JPCarrinho.add(button_4);
		
		JButton button_5 = new JButton("-");
		button_5.setBounds(310, 147, 44, 36);
		JPCarrinho.add(button_5);
		
		JButton button_6 = new JButton("-");
		button_6.setBounds(310, 82, 44, 36);
		JPCarrinho.add(button_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(364, 82, 49, 36);
		JPCarrinho.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(364, 147, 49, 36);
		JPCarrinho.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(364, 210, 49, 36);
		JPCarrinho.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(364, 273, 49, 36);
		JPCarrinho.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(364, 336, 49, 36);
		JPCarrinho.add(textField_9);
		
		JButton button_7 = new JButton("+");
		button_7.setBounds(423, 336, 49, 36);
		JPCarrinho.add(button_7);
		
		JButton button_8 = new JButton("+");
		button_8.setBounds(423, 273, 49, 36);
		JPCarrinho.add(button_8);
		
		JButton button_9 = new JButton("+");
		button_9.setBounds(423, 210, 49, 36);
		JPCarrinho.add(button_9);
		
		JButton button_10 = new JButton("+");
		button_10.setBounds(423, 147, 49, 36);
		JPCarrinho.add(button_10);
		
		JButton button_11 = new JButton("+");
		button_11.setBounds(423, 82, 49, 36);
		JPCarrinho.add(button_11);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(532, 82, 49, 36);
		JPCarrinho.add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(532, 147, 49, 36);
		JPCarrinho.add(label_3);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(532, 210, 49, 36);
		JPCarrinho.add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(532, 273, 49, 36);
		JPCarrinho.add(label_5);
		
		JLabel label_6 = new JLabel("New label");
		label_6.setBounds(532, 336, 49, 36);
		JPCarrinho.add(label_6);
		
		JLabel label_7 = new JLabel("New label");
		label_7.setBounds(651, 336, 49, 36);
		JPCarrinho.add(label_7);
		
		JLabel label_8 = new JLabel("New label");
		label_8.setBounds(651, 273, 82, 36);
		JPCarrinho.add(label_8);
		
		JLabel label_9 = new JLabel("New label");
		label_9.setBounds(651, 210, 82, 36);
		JPCarrinho.add(label_9);
		
		JLabel label_10 = new JLabel("New label");
		label_10.setBounds(651, 147, 82, 36);
		JPCarrinho.add(label_10);
		
		JLabel label_11 = new JLabel("New label");
		label_11.setBounds(651, 82, 82, 36);
		JPCarrinho.add(label_11);
		
		JButton button_12 = new JButton("limpar");
		button_12.setBackground(SystemColor.controlHighlight);
		button_12.setBounds(759, 340, 72, 29);
		JPCarrinho.add(button_12);
		
		JButton button_13 = new JButton("limpar");
		button_13.setBackground(SystemColor.controlHighlight);
		button_13.setBounds(759, 277, 72, 29);
		JPCarrinho.add(button_13);
		
		JButton button_14 = new JButton("limpar");
		button_14.setBackground(SystemColor.controlHighlight);
		button_14.setBounds(759, 214, 72, 29);
		JPCarrinho.add(button_14);
		
		JButton button_15 = new JButton("limpar");
		button_15.setBackground(SystemColor.controlHighlight);
		button_15.setBounds(759, 151, 72, 29);
		JPCarrinho.add(button_15);
		
		JButton button_16 = new JButton("limpar");
		button_16.setBackground(SystemColor.controlHighlight);
		button_16.setBounds(759, 86, 72, 29);
		JPCarrinho.add(button_16);
		
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(235, 430, 46, 14);
		JPCarrinho.add(lblNewLabel);
		
		JLabel label_16 = new JLabel("New label");
		label_16.setBounds(166, 456, 46, 14);
		JPCarrinho.add(label_16);
		
		JButton btnPagar = new JButton("PAGAR");
		btnPagar.setBounds(332, 414, 107, 36);
		JPCarrinho.add(btnPagar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(332, 470, 107, 36);
		JPCarrinho.add(btnCancelar);
	}
}
