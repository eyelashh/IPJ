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
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JCheckBox;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AppFunc {

	private JFrame frame;
	private JTextField textField_6;
	private JTextField textField_9;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppFunc window = new AppFunc();
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
	public AppFunc() {
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
					img = ImageIO.read(new File( "/Users/tamarabarros/Dropbox/IPJ_ProjectoFinal/Design/viewcomics/fundo.jpg \r\n" + 
							""));
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
		
		JPanel JPanelMenu = new JPanel() {
			@Override
			//o paint component vai pintar literalmente o componente
			protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				Image img;
				try {
					
					// importar imagem para o background do panel, podemos faz�-lo da internet ou do ficheiro 
					
					// img = ImageIO.read(new URL( "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO.read(new File( "/Users/tamarabarros/Dropbox/IPJ_ProjectoFinal/Design/viewcomics/fundo2.jpg "));
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
		
		JButton btnCarrinhos = new JButton("Carrinhos");
		
		btnCarrinhos.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnCarrinhos.setBackground(SystemColor.controlHighlight);
		btnCarrinhos.setBounds(26, 108, 176, 60);
		JPanelMenu.add(btnCarrinhos);
		
		
		
		JButton btnLivros = new JButton("Livros");
		
		btnLivros.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 31));
		btnLivros.setBackground(SystemColor.controlHighlight);
		btnLivros.setBounds(26, 29, 176, 55);
		JPanelMenu.add(btnLivros);
		
		JButton btnGestaoFunc = new JButton();
	
		btnGestaoFunc.setText("<HTML> Gest\u00E3o de conta <HTML>");
		btnGestaoFunc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnGestaoFunc.setBackground(SystemColor.controlHighlight);
		btnGestaoFunc.setBounds(28, 200, 176, 96);
		JPanelMenu.add(btnGestaoFunc);
		
		JPanel JPanelPrincipal = new JPanel(){
			@Override
			//o paint component vai pintar literalmente o componente
			protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				Image img;
				try {
					
					// importar imagem para o background do panel, podemos faz�-lo da internet ou do ficheiro 
					
					// img = ImageIO.read(new URL( "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO.read(new File( "/Users/tamarabarros/Dropbox/IPJ_ProjectoFinal/Design/viewcomics/wallpaperMarvel.jpg "));
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
		
		JPanel JPCarrinhos = new JPanel();
		JPCarrinhos.setBounds(0, 0, 1009, 544);
		JPanelPrincipal.add(JPCarrinhos);
		JPCarrinhos.setLayout(null);
		JPCarrinhos.setVisible(false);
		
		textField_6 = new JTextField();
		textField_6.setBounds(59, 23, 153, 32);
		JPCarrinhos.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NIF");
		lblNewLabel.setBounds(26, 32, 46, 14);
		JPCarrinhos.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(59, 97, 153, 394);
		JPCarrinhos.add(list);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(238, 28, 89, 23);
		JPCarrinhos.add(btnPesquisar);
		
		JLabel lblNewLabel_1 = new JLabel("TOTAL :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(378, 366, 46, 14);
		JPCarrinhos.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(425, 366, 46, 14);
		JPCarrinhos.add(lblNewLabel_2);
		
		JLabel lblValorAPagar = new JLabel("VALOR A PAGAR: ");
		lblValorAPagar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorAPagar.setBounds(378, 391, 105, 14);
		JPCarrinhos.add(lblValorAPagar);
		
		JLabel label_9 = new JLabel("New label");
		label_9.setBounds(490, 391, 46, 14);
		JPCarrinhos.add(label_9);
		
		JButton btnPagar = new JButton("Realizar pagamento");
		
		btnPagar.setBounds(367, 421, 141, 41);
		JPCarrinhos.add(btnPagar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(537, 421, 89, 41);
		JPCarrinhos.add(btnCancelar);
		
		JButton btnEliminar2 = new JButton("Eliminar");
		btnEliminar2.setBounds(588, 195, 70, 23);
		JPCarrinhos.add(btnEliminar2);
		
		JButton btnEliminar1 = new JButton("Eliminar");
		btnEliminar1.setBounds(588, 145, 70, 23);
		JPCarrinhos.add(btnEliminar1);
		
		JButton btnEliminar3 = new JButton("Eliminar");
		btnEliminar3.setBounds(588, 244, 70, 23);
		JPCarrinhos.add(btnEliminar3);
		
		JButton btnEliminar4 = new JButton("Eliminar");
		btnEliminar4.setBounds(588, 293, 70, 23);
		JPCarrinhos.add(btnEliminar4);
		
		JLabel lblNewLabel_3 = new JLabel("DETALHES DO CARRINHO :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(283, 62, 188, 23);
		JPCarrinhos.add(lblNewLabel_3);
		
		JLabel lblLivro = new JLabel("Livro");
		lblLivro.setBounds(284, 97, 30, 23);
		JPCarrinhos.add(lblLivro);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(359, 97, 61, 23);
		JPCarrinhos.add(lblQuantidade);
		
		JLabel lblValorAPagar_2 = new JLabel("Valor a pagar");
		lblValorAPagar_2.setBounds(466, 97, 70, 23);
		JPCarrinhos.add(lblValorAPagar_2);
		
		JLabel lblNewLabel_4 = new JLabel("livro1");
		lblNewLabel_4.setBounds(284, 154, 30, 14);
		JPCarrinhos.add(lblNewLabel_4);
		
		JLabel label_10 = new JLabel("livro1");
		label_10.setBounds(284, 204, 30, 14);
		JPCarrinhos.add(label_10);
		
		JLabel label_11 = new JLabel("livro1");
		label_11.setBounds(284, 253, 30, 14);
		JPCarrinhos.add(label_11);
		
		JLabel label_12 = new JLabel("livro1");
		label_12.setBounds(369, 154, 30, 14);
		JPCarrinhos.add(label_12);
		
		JLabel label_13 = new JLabel("livro1");
		label_13.setBounds(369, 204, 30, 14);
		JPCarrinhos.add(label_13);
		
		JLabel label_14 = new JLabel("livro1");
		label_14.setBounds(369, 253, 30, 14);
		JPCarrinhos.add(label_14);
		
		JLabel label_15 = new JLabel("livro1");
		label_15.setBounds(284, 302, 30, 14);
		JPCarrinhos.add(label_15);
		
		JLabel label_16 = new JLabel("livro1");
		label_16.setBounds(369, 302, 30, 14);
		JPCarrinhos.add(label_16);
		
		JLabel label_17 = new JLabel("livro1");
		label_17.setBounds(478, 154, 30, 14);
		JPCarrinhos.add(label_17);
		
		JLabel label_18 = new JLabel("livro1");
		label_18.setBounds(478, 204, 30, 14);
		JPCarrinhos.add(label_18);
		
		JLabel label_19 = new JLabel("livro1");
		label_19.setBounds(478, 253, 30, 14);
		JPCarrinhos.add(label_19);
		
		JLabel label_20 = new JLabel("livro1");
		label_20.setBounds(478, 302, 30, 14);
		JPCarrinhos.add(label_20);
		
		
		
		JPanel JPGestao = new JPanel();
		JPGestao.setLayout(null);
		JPGestao.setBounds(0, 0, 1009, 544);
		JPanelPrincipal.add(JPGestao);
		JPGestao.setVisible(false);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(148, 144, 256, 26);
		JPGestao.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(148, 231, 256, 25);
		JPGestao.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(148, 329, 256, 26);
		JPGestao.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(493, 230, 256, 26);
		JPGestao.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(493, 329, 256, 26);
		JPGestao.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(493, 143, 256, 26);
		JPGestao.add(textField_5);
		
		JLabel label_1 = new JLabel("Username actual");
		label_1.setBounds(151, 122, 81, 14);
		JPGestao.add(label_1);
		
		JLabel label_2 = new JLabel("Palavra passe:");
		label_2.setBounds(148, 209, 81, 14);
		JPGestao.add(label_2);
		
		JLabel label_3 = new JLabel("Novo username:");
		label_3.setBounds(148, 304, 81, 14);
		JPGestao.add(label_3);
		
		JLabel label_4 = new JLabel("Palavra passe actual :");
		label_4.setBounds(497, 118, 148, 14);
		JPGestao.add(label_4);
		
		JLabel label_5 = new JLabel("Nova palavra passe :");
		label_5.setBounds(493, 205, 152, 14);
		JPGestao.add(label_5);
		
		JLabel label_6 = new JLabel("Confirma\u00E7\u00E3o da nova palavra passe :");
		label_6.setBounds(493, 304, 189, 14);
		JPGestao.add(label_6);
		
		JLabel label_7 = new JLabel("Actualizar nome :");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_7.setBounds(148, 75, 201, 36);
		JPGestao.add(label_7);
		
		JLabel label_8 = new JLabel("Actualizar palavra passe :");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_8.setBounds(493, 71, 298, 36);
		JPGestao.add(label_8);
		
		JButton button_3 = new JButton("Confirmar novo username");
		button_3.setBounds(184, 383, 165, 23);
		JPGestao.add(button_3);
		
		JButton button_6 = new JButton("Confirmar nova palavra passe ");
		button_6.setBounds(529, 383, 189, 23);
		JPGestao.add(button_6);
		
		JPanel JPpagamento = new JPanel() {
			protected void paintComponent(Graphics g) {
			}
		};
		JPpagamento.setBounds(0, 0, 322, 397);
		JPanelPrincipal.add(JPpagamento);
		JPpagamento.setLayout(null);
		JPpagamento.setVisible(false);
		
		
		JComboBox comboBoxPagamento = new JComboBox();
		comboBoxPagamento.setBounds(65, 34, 199, 22);
		JPpagamento.add(comboBoxPagamento);
		comboBoxPagamento.addItem("(Seleccione o m�todo de pagamento)");
		comboBoxPagamento.addItem("Dinheiro");
		comboBoxPagamento.addItem("Multibanco");
	
		
		JPanel JPLivros = new JPanel();
		JPLivros.setBounds(0, 0, 1009, 544);
		JPanelPrincipal.add(JPLivros);
		JPLivros.setLayout(null);
		JPLivros.setVisible(false);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(190, 145, 46, 25);
		
		Choice choice = new Choice();
		choice.setBounds(61, 70, 200, 20);
		JPLivros.add(choice);
		
		TextField textField_7 = new TextField();
		textField_7.setBounds(61, 103, 200, 22);
		JPLivros.add(textField_7);
		
		JButton button = new JButton("Limpar");
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(282, 70, 115, 20);
		JPLivros.add(button);
		
		JButton button_1 = new JButton("Pesquisar");
		button_1.setBackground(SystemColor.controlHighlight);
		button_1.setBounds(282, 105, 115, 20);
		JPLivros.add(button_1);
		
		List list_1 = new List();
		list_1.setBounds(61, 147, 289, 348);
		JPLivros.add(list_1);
		
		TextField textField_8 = new TextField();
		textField_8.setBounds(372, 147, 260, 211);
		JPLivros.add(textField_8);
		
		JLabel label_21 = new JLabel("Adicionar ao carrinho");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 28));
		label_21.setBounds(696, 174, 274, 34);
		JPLivros.add(label_21);
		
		JButton button_2 = new JButton("-");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBounds(720, 237, 54, 48);
		JPLivros.add(button_2);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(799, 246, 61, 34);
		JPLivros.add(textField_9);
		
		JButton button_4 = new JButton("-");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_4.setBounds(884, 237, 54, 48);
		JPLivros.add(button_4);
		
		JButton button_5 = new JButton("Adicionar");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 23));
		button_5.setBounds(754, 296, 152, 42);
		JPLivros.add(button_5);
		
		TextField textField_10 = new TextField();
		textField_10.setBounds(706, 116, 200, 22);
		JPLivros.add(textField_10);
		
		JLabel lblNifDoCliente = new JLabel("NIF DO CLIENTE");
		lblNifDoCliente.setBounds(706, 89, 115, 14);
		JPLivros.add(lblNifDoCliente);
		
		JLabel lblPesquisarPorCampo = new JLabel("PESQUISAR POR CAMPO");
		lblPesquisarPorCampo.setBounds(61, 50, 136, 14);
		JPLivros.add(lblPesquisarPorCampo);
		
		JPanel JPdinheiro = new JPanel();
		JPdinheiro.setBounds(0, 0, 237, 282);
		JPanelPrincipal.add(JPdinheiro);
		JPdinheiro.setLayout(null);
		JPdinheiro.setVisible(false);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(24, 35, 145, 27);
		JPdinheiro.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(24, 113, 174, 27);
		JPdinheiro.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBounds(24, 197, 145, 27);
		JPdinheiro.add(textField_16);
		
		JLabel label_24 = new JLabel("Quantia recebida :");
		label_24.setBounds(24, 84, 126, 14);
		JPdinheiro.add(label_24);
		
		JLabel label_25 = new JLabel("Troco :");
		label_25.setBounds(24, 162, 86, 14);
		JPdinheiro.add(label_25);
		
		JLabel label_26 = new JLabel("A pagar :");
		label_26.setBounds(24, 10, 105, 14);
		JPdinheiro.add(label_26);
		
		JButton button_7 = new JButton("Concluir pagamento");
		button_7.setBounds(32, 248, 180, 23);
		JPdinheiro.add(button_7);
		
		JPanel JPmultibanco = new JPanel();
		JPmultibanco.setBounds(0, 0, 237, 282);
		JPanelPrincipal.add(JPmultibanco);
		JPmultibanco.setVisible(false);
		
		//Ac�oes dos bot�es
		
		btnGestaoFunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPCarrinhos.setVisible(false);
				JPLivros.setVisible(false);
				JPpagamento.setVisible(false);
				JPmultibanco.setVisible(false);
				JPdinheiro.setVisible(false);
				JPGestao.setVisible(true);
			}
		});
		
		btnLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPCarrinhos.setVisible(false);
				JPLivros.setVisible(true);
				JPpagamento.setVisible(false);
				JPmultibanco.setVisible(false);
				JPdinheiro.setVisible(false);
				JPGestao.setVisible(false);
			}
		});
		
		
		btnCarrinhos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPCarrinhos.setVisible(true);
				JPLivros.setVisible(false);
				JPpagamento.setVisible(false);
				JPmultibanco.setVisible(false);
				JPdinheiro.setVisible(false);
				JPGestao.setVisible(false);
			}
		});
		
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPCarrinhos.setVisible(false);
				JPLivros.setVisible(false);
				JPpagamento.setVisible(true);
				JPmultibanco.setVisible(false);
				JPdinheiro.setVisible(false);
				JPGestao.setVisible(false);
				
				
				
			}
		});
		//selecionar o m�todo de pagamento para determinar qual a janela a aparecer a seguir
		
		if (comboBoxPagamento.getSelectedItem().equals("Multibanco")) {
			JPmultibanco.setVisible(true);
		}
		else if (comboBoxPagamento.getSelectedItem().equals("Dinheiro")) {
			JPdinheiro.setVisible(true);
		}
		
		
		
	}
}
