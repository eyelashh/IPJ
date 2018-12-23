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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppCliente {

	private JFrame frame;
	private JTextField txtTitulo1;
	private JTextField txtTitulo2;
	private JTextField txtTitulo3;
	private JTextField txtTitulo4;
	private JTextField txtTitulo5;
	private JTextField txtUnid1;
	private JTextField txtUnid2;
	private JTextField txtUnid3;
	private JTextField txtUnid4;
	private JTextField txtUnid5;
	private JTextField textField_12;
	private JPasswordField txtPassword;
	private JTextField txtUsername;

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
					
					// importar imagem para o background do panel, podemos faz�-lo da internet ou do ficheiro 
					
					// img = ImageIO.read(new URL( "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO.read(new File("/Users/tamarabarros/Dropbox/IPJ_ProjectoFinal/Design/viewcomics/fundo.jpg \r\n"));
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
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(918, 121, 189, 20);
		JPanelCabecalho.add(txtPassword);
		
		JLabel label_20 = new JLabel("Password:");
		label_20.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 21));
		label_20.setBounds(1018, 95, 89, 29);
		JPanelCabecalho.add(label_20);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(919, 70, 189, 20);
		JPanelCabecalho.add(txtUsername);
		
		JButton btnLogIn = new JButton("Entrar");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUsername.getText()=="a" && new String(txtPassword.getPassword()).equals("a"))
				{
					
				}
				if(txtUsername.getText()=="f" && new String(txtPassword.getPassword()).equals("f"))
				{
					
				}
			}
		});
		btnLogIn.setBackground(SystemColor.controlHighlight);
		btnLogIn.setBounds(1125, 95, 103, 27);
		JPanelCabecalho.add(btnLogIn);
		
		JPanel JPanelMenu = new JPanel() {
			@Override
			//o paint component vai pintar literalmente o componente
			protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				Image img;
				try {
					
					// importar imagem para o background do panel, podemos faz�-lo da internet ou do ficheiro 
					
					// img = ImageIO.read(new URL( "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO.read(new File(  "/Users/tamarabarros/Dropbox/IPJ_ProjectoFinal/Design/viewcomics/fundo2.jpg "));
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
		
		JButton btnLivros = new JButton("Livros");
		
		btnLivros.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 31));
		btnLivros.setBackground(SystemColor.controlHighlight);
		btnLivros.setBounds(26, 36, 176, 55);
		JPanelMenu.add(btnLivros);
		
		JButton btnCarrinho = new JButton("Carrinho");
		
		btnCarrinho.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnCarrinho.setBackground(SystemColor.controlHighlight);
		btnCarrinho.setBounds(26, 115, 176, 60);
		JPanelMenu.add(btnCarrinho);
		
		//painel principal que contem o painel Carrinho e o painel Livros
		
		JPanel JPanelPrincipal = new JPanel();
		JPanelPrincipal.setBounds(255, 185, 933, 544);
		frame.getContentPane().add(JPanelPrincipal);
		JPanelPrincipal.setLayout(null);
		
		JPanel JPLivros = new JPanel(){
			@Override
			//o paint component vai pintar literalmente o componente
			protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				Image img;
				try {
					
					// importar imagem para o background do panel, podemos faz�-lo da internet ou do ficheiro 
					
					// img = ImageIO.read(new URL( "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO.read(new File( "/Users/Joana/Dropbox/IPJ_ProjectoFinal/Design/viewcomics/wallpaperMarvel1.jpg "));
					g.drawImage(img,0,0,null); 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		JPLivros.setBounds(0, 0, 931, 544);
		JPanelPrincipal.add(JPLivros);
		JPLivros.setLayout(null);
		JPLivros.setVisible(false);
		
		Choice choiceAtributo = new Choice();
		choiceAtributo.setBounds(65, 63, 200, 20);
		JPLivros.add(choiceAtributo);
		
		TextField txtNomeAtributo = new TextField();
		txtNomeAtributo.setBounds(65, 96, 200, 22);
		JPLivros.add(txtNomeAtributo);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(SystemColor.controlHighlight);
		btnLimpar.setBounds(286, 63, 115, 20);
		JPLivros.add(btnLimpar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(SystemColor.controlHighlight);
		btnPesquisar.setBounds(286, 98, 115, 20);
		JPLivros.add(btnPesquisar);
		
		List listaLivros = new List();
		listaLivros.setBounds(65, 140, 289, 348);
		JPLivros.add(listaLivros);
		
		TextField txtSpecsLivro = new TextField();
		txtSpecsLivro.setBounds(376, 140, 260, 211);
		JPLivros.add(txtSpecsLivro);
		
		JButton btnRemoverUnidade = new JButton("-");
		btnRemoverUnidade.setBackground(SystemColor.controlHighlight);
		btnRemoverUnidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoverUnidade.setBounds(444, 63, 57, 39);
		JPLivros.add(btnRemoverUnidade);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(511, 67, 61, 34);
		JPLivros.add(textField_12);
		
		JButton btnAddUnidade = new JButton("+");
		btnAddUnidade.setBackground(SystemColor.controlHighlight);
		btnAddUnidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddUnidade.setBounds(582, 63, 54, 39);
		JPLivros.add(btnAddUnidade);
		
		JButton btnAddCarrinho = new JButton("Adicionar ao carrinho");
		btnAddCarrinho.setBackground(SystemColor.controlHighlight);
		btnAddCarrinho.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddCarrinho.setBounds(428, 11, 219, 42);
		JPLivros.add(btnAddCarrinho);
		
		//painel para o carrinho
		
		JPanel JPCarrinho = new JPanel();
		JPCarrinho.setBounds(0, 0, 931, 544);
		JPanelPrincipal.add(JPCarrinho);
		JPCarrinho.setLayout(null);
		
		//O painel nao inicia visivel
		JPCarrinho.setVisible(false);
		
		JLabel label_1 = new JLabel("T\u00EDtulo do livro");
		label_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_1.setBounds(68, 32, 144, 26);
		JPCarrinho.add(label_1);
		
		txtTitulo1 = new JTextField();
		txtTitulo1.setColumns(10);
		txtTitulo1.setBounds(68, 82, 220, 36);
		JPCarrinho.add(txtTitulo1);
		
		txtTitulo2 = new JTextField();
		txtTitulo2.setColumns(10);
		txtTitulo2.setBounds(68, 147, 220, 36);
		JPCarrinho.add(txtTitulo2);
		
		txtTitulo3 = new JTextField();
		txtTitulo3.setColumns(10);
		txtTitulo3.setBounds(68, 210, 220, 36);
		JPCarrinho.add(txtTitulo3);
		
		txtTitulo4 = new JTextField();
		txtTitulo4.setColumns(10);
		txtTitulo4.setBounds(68, 273, 220, 36);
		JPCarrinho.add(txtTitulo4);
		
		txtTitulo5 = new JTextField();
		txtTitulo5.setColumns(10);
		txtTitulo5.setBounds(68, 336, 220, 36);
		JPCarrinho.add(txtTitulo5);
		
		JButton btnRemoveUnid5 = new JButton("-");
		btnRemoveUnid5.setBounds(310, 336, 44, 36);
		JPCarrinho.add(btnRemoveUnid5);
		
		JButton btnRemoveUnid4 = new JButton("-");
		btnRemoveUnid4.setBounds(310, 273, 44, 36);
		JPCarrinho.add(btnRemoveUnid4);
		
		JButton btnRemoveUnid3 = new JButton("-");
		btnRemoveUnid3.setBounds(310, 210, 44, 36);
		JPCarrinho.add(btnRemoveUnid3);
		
		JButton btnRemoveUnid2 = new JButton("-");
		btnRemoveUnid2.setBounds(310, 147, 44, 36);
		JPCarrinho.add(btnRemoveUnid2);
		
		JButton btnRemoveUnid1 = new JButton("-");
		btnRemoveUnid1.setBounds(310, 82, 44, 36);
		JPCarrinho.add(btnRemoveUnid1);
		
		txtUnid1 = new JTextField();
		txtUnid1.setColumns(10);
		txtUnid1.setBounds(364, 82, 49, 36);
		JPCarrinho.add(txtUnid1);
		
		txtUnid2 = new JTextField();
		txtUnid2.setColumns(10);
		txtUnid2.setBounds(364, 147, 49, 36);
		JPCarrinho.add(txtUnid2);
		
		txtUnid3 = new JTextField();
		txtUnid3.setColumns(10);
		txtUnid3.setBounds(364, 210, 49, 36);
		JPCarrinho.add(txtUnid3);
		
		txtUnid4 = new JTextField();
		txtUnid4.setColumns(10);
		txtUnid4.setBounds(364, 273, 49, 36);
		JPCarrinho.add(txtUnid4);
		
		txtUnid5 = new JTextField();
		txtUnid5.setColumns(10);
		txtUnid5.setBounds(364, 336, 49, 36);
		JPCarrinho.add(txtUnid5);
		
		JButton btnAddUnid5 = new JButton("+");
		btnAddUnid5.setBounds(423, 336, 49, 36);
		JPCarrinho.add(btnAddUnid5);
		
		JButton btnAddUnid4 = new JButton("+");
		btnAddUnid4.setBounds(423, 273, 49, 36);
		JPCarrinho.add(btnAddUnid4);
		
		JButton btnAddUnid3 = new JButton("+");
		btnAddUnid3.setBounds(423, 210, 49, 36);
		JPCarrinho.add(btnAddUnid3);
		
		JButton btnAddUnid2 = new JButton("+");
		btnAddUnid2.setBounds(423, 147, 49, 36);
		JPCarrinho.add(btnAddUnid2);
		
		JButton btnAddUnid1 = new JButton("+");
		btnAddUnid1.setBounds(423, 82, 49, 36);
		JPCarrinho.add(btnAddUnid1);
		
		JLabel lblPreco1 = new JLabel("New label");
		lblPreco1.setBounds(532, 82, 49, 36);
		JPCarrinho.add(lblPreco1);
		
		JLabel lblPreco2 = new JLabel("New label");
		lblPreco2.setBounds(532, 147, 49, 36);
		JPCarrinho.add(lblPreco2);
		
		JLabel lblPreco3 = new JLabel("New label");
		lblPreco3.setBounds(532, 210, 49, 36);
		JPCarrinho.add(lblPreco3);
		
		JLabel lblPreco4 = new JLabel("New label");
		lblPreco4.setBounds(532, 273, 49, 36);
		JPCarrinho.add(lblPreco4);
		
		JLabel lblPreco5 = new JLabel("New label");
		lblPreco5.setBounds(532, 336, 49, 36);
		JPCarrinho.add(lblPreco5);
		
		JLabel lblTotal5 = new JLabel("New label");
		lblTotal5.setBounds(651, 336, 49, 36);
		JPCarrinho.add(lblTotal5);
		
		JLabel lblTotal4 = new JLabel("New label");
		lblTotal4.setBounds(651, 273, 82, 36);
		JPCarrinho.add(lblTotal4);
		
		JLabel lblTotal3 = new JLabel("New label");
		lblTotal3.setBounds(651, 210, 82, 36);
		JPCarrinho.add(lblTotal3);
		
		JLabel lblTotal2 = new JLabel("New label");
		lblTotal2.setBounds(651, 147, 82, 36);
		JPCarrinho.add(lblTotal2);
		
		JLabel lblTotal1 = new JLabel("New label");
		lblTotal1.setBounds(651, 82, 82, 36);
		JPCarrinho.add(lblTotal1);
		
		JButton btnLimpar5 = new JButton("limpar");
		btnLimpar5.setBackground(SystemColor.controlHighlight);
		btnLimpar5.setBounds(759, 340, 72, 29);
		JPCarrinho.add(btnLimpar5);
		
		JButton btnLimpar4 = new JButton("limpar");
		btnLimpar4.setBackground(SystemColor.controlHighlight);
		btnLimpar4.setBounds(759, 277, 72, 29);
		JPCarrinho.add(btnLimpar4);
		
		JButton btnLimpar3 = new JButton("limpar");
		btnLimpar3.setBackground(SystemColor.controlHighlight);
		btnLimpar3.setBounds(759, 214, 72, 29);
		JPCarrinho.add(btnLimpar3);
		
		JButton btnLimpar2 = new JButton("limpar");
		btnLimpar2.setBackground(SystemColor.controlHighlight);
		btnLimpar2.setBounds(759, 151, 72, 29);
		JPCarrinho.add(btnLimpar2);
		
		JButton btnLimpar1 = new JButton("limpar");
		btnLimpar1.setBackground(SystemColor.controlHighlight);
		btnLimpar1.setBounds(759, 86, 72, 29);
		JPCarrinho.add(btnLimpar1);
		
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
		
		JLabel lblQtddArtigos = new JLabel("New label");
		lblQtddArtigos.setBounds(235, 430, 46, 14);
		JPCarrinho.add(lblQtddArtigos);
		
		JLabel lblPreco = new JLabel("New label");
		lblPreco.setBounds(166, 456, 46, 14);
		JPCarrinho.add(lblPreco);
		
		JButton btnPagar = new JButton("PAGAR");
		btnPagar.setBounds(332, 414, 107, 36);
		JPCarrinho.add(btnPagar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(332, 470, 107, 36);
		JPCarrinho.add(btnCancelar);
		
		//tornar os respectivos paineis vis�veis ao clicar
		
		btnLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPCarrinho.setVisible(false);
				JPLivros.setVisible(true);
					
			}
		});
		
		btnCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPLivros.setVisible(false);
				JPCarrinho.setVisible(true);		
				
			}
		});
		
		
		
	}
}
