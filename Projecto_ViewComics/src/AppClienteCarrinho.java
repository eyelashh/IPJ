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

public class AppClienteCarrinho {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppClienteCarrinho window = new AppClienteCarrinho();
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
	public AppClienteCarrinho() {
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
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JLabel label_11 = new JLabel("\u00C1rea restrita (funcion\u00E1rio ou admin)");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_11.setBounds(908, 0, 356, 27);
		panel.add(label_11);
		
		JButton btnNewButton = new JButton("Livros");
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 31));
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(47, 179, 176, 55);
		panel.add(btnNewButton);
		
		JButton btnCarrinhoDeCompras = new JButton("Carrinho");
		btnCarrinhoDeCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel label_12 = new JLabel("Username:");
		label_12.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		label_12.setBounds(1025, 33, 98, 27);
		panel.add(label_12);
		btnCarrinhoDeCompras.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnCarrinhoDeCompras.setBackground(SystemColor.controlHighlight);
		btnCarrinhoDeCompras.setBounds(47, 258, 176, 60);
		panel.add(btnCarrinhoDeCompras);
		
		JLabel label_13 = new JLabel("Password:");
		label_13.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 21));
		label_13.setBounds(1028, 84, 89, 29);
		panel.add(label_13);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(256, 179, 825, 388);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo do livro");
		lblTtulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblTtulo.setBounds(10, 22, 144, 26);
		panel_1.add(lblTtulo);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblQuantidade.setBounds(290, 22, 91, 26);
		panel_1.add(lblQuantidade);
		
		JLabel lblPreo = new JLabel("Pre\u00E7oUnit\u00E1rio");
		lblPreo.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblPreo.setBounds(439, 22, 111, 26);
		panel_1.add(lblPreo);
		
		JLabel lblValorTotal = new JLabel("Valor total");
		lblValorTotal.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblValorTotal.setBounds(579, 22, 82, 26);
		panel_1.add(lblValorTotal);
		
		JLabel lblLimpar = new JLabel("Limpar");
		lblLimpar.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblLimpar.setBounds(712, 22, 61, 26);
		panel_1.add(lblLimpar);
		
		textField_1 = new JTextField();
		textField_1.setBounds(306, 72, 49, 36);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(306, 137, 49, 36);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(306, 200, 49, 36);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(306, 263, 49, 36);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(306, 326, 49, 36);
		panel_1.add(textField_5);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.setBounds(252, 72, 44, 36);
		panel_1.add(btnNewButton_1);
		
		JButton button = new JButton("+");
		button.setBounds(365, 72, 49, 36);
		panel_1.add(button);
		
		JButton button_1 = new JButton("-");
		button_1.setBounds(252, 137, 44, 36);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("-");
		button_2.setBounds(252, 200, 44, 36);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("-");
		button_3.setBounds(252, 263, 44, 36);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("-");
		button_4.setBounds(252, 326, 44, 36);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("+");
		button_5.setBounds(365, 137, 49, 36);
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("+");
		button_6.setBounds(365, 200, 49, 36);
		panel_1.add(button_6);
		
		JButton button_7 = new JButton("+");
		button_7.setBounds(365, 263, 49, 36);
		panel_1.add(button_7);
		
		JButton button_8 = new JButton("+");
		button_8.setBounds(365, 326, 49, 36);
		panel_1.add(button_8);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(474, 72, 49, 36);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setBounds(474, 137, 49, 36);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(474, 200, 49, 36);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(474, 263, 49, 36);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(474, 326, 49, 36);
		panel_1.add(label_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(10, 72, 220, 36);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(10, 137, 220, 36);
		panel_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(10, 200, 220, 36);
		panel_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(10, 263, 220, 36);
		panel_1.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(10, 326, 220, 36);
		panel_1.add(textField_10);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(593, 72, 82, 36);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(593, 137, 82, 36);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("New label");
		label_6.setBounds(593, 200, 82, 36);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("New label");
		label_7.setBounds(593, 263, 82, 36);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("New label");
		label_8.setBounds(593, 326, 49, 36);
		panel_1.add(label_8);
		
		JButton btnNewButton_2 = new JButton("limpar");
		btnNewButton_2.setBackground(SystemColor.controlHighlight);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(701, 76, 72, 29);
		panel_1.add(btnNewButton_2);
		
		JButton button_9 = new JButton("limpar");
		button_9.setBackground(SystemColor.controlHighlight);
		button_9.setBounds(701, 141, 72, 29);
		panel_1.add(button_9);
		
		JButton button_10 = new JButton("limpar");
		button_10.setBackground(SystemColor.controlHighlight);
		button_10.setBounds(701, 204, 72, 29);
		panel_1.add(button_10);
		
		JButton button_11 = new JButton("limpar");
		button_11.setBackground(SystemColor.controlHighlight);
		button_11.setBounds(701, 267, 72, 29);
		panel_1.add(button_11);
		
		JButton button_12 = new JButton("limpar");
		button_12.setBackground(SystemColor.controlHighlight);
		button_12.setBounds(701, 330, 72, 29);
		panel_1.add(button_12);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(934, 61, 189, 20);
		panel.add(passwordField);
		
		JButton button_13 = new JButton("Entrar");
		button_13.setBackground(SystemColor.controlHighlight);
		button_13.setBounds(1135, 84, 103, 27);
		panel.add(button_13);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(934, 110, 189, 20);
		panel.add(textField);
		
		JLabel lblViewcomicsInc = new JLabel("ViewComics Inc.");
		lblViewcomicsInc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 90));
		lblViewcomicsInc.setBounds(170, 33, 693, 71);
		panel.add(lblViewcomicsInc);
		
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
		lblViewcomics.setBounds(-62, 0, 1326, 141);
		lblViewcomics.setFont(new Font("Papyrus", Font.BOLD, 46));
		panel.add(lblViewcomics);
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
}

