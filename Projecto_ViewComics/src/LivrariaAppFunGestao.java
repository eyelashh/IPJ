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

public class LivrariaAppFunGestao {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LivrariaAppFunGestao window = new LivrariaAppFunGestao();
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
	public LivrariaAppFunGestao() {
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
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Livros");
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 31));
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(47, 179, 176, 55);
		panel.add(btnNewButton);
		
		JButton btnCarrinhoDeCompras = new JButton("Carrinhos");
		btnCarrinhoDeCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCarrinhoDeCompras.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnCarrinhoDeCompras.setBackground(SystemColor.controlHighlight);
		btnCarrinhoDeCompras.setBounds(47, 258, 176, 60);
		panel.add(btnCarrinhoDeCompras);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.setBackground(SystemColor.controlHighlight);
		btnLogout.setBounds(1143, 33, 80, 43);
		panel.add(btnLogout);
		
		JLabel lblViewcomicsInc = new JLabel("ViewComics Inc.");
		lblViewcomicsInc.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 90));
		lblViewcomicsInc.setBounds(312, 34, 693, 71);
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
		
		//para adaptar o texto ao tamanho do botão escrever <HTML> antes e depois do texto do botão
		//desta forma ele vai passar para a linha seguinte quando o texto ja nao couber no botão, ex abaixo
		
		JButton btnGestoDeConta = new JButton();
		btnGestoDeConta.setText("<HTML> Gest\u00E3o de conta <HTML>");
		btnGestoDeConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnGestoDeConta.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		btnGestoDeConta.setBackground(SystemColor.controlHighlight);
		btnGestoDeConta.setBounds(49, 350, 176, 96);
		panel.add(btnGestoDeConta);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(386, 140, 275, 637);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Actualizar nome");
		label.setBounds(10, 57, 223, 26);
		panel_1.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("Nome actual");
		label_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_1.setBounds(10, 113, 144, 26);
		panel_1.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 145, 220, 36);
		panel_1.add(textField);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_2.setBounds(10, 211, 144, 26);
		panel_1.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 248, 220, 36);
		panel_1.add(textField_1);
		
		JLabel label_3 = new JLabel("Novo nome");
		label_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_3.setBounds(10, 295, 144, 26);
		panel_1.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 332, 220, 36);
		panel_1.add(textField_2);
		
		JButton button_1 = new JButton("CONFIRMAR");
		button_1.setBackground(SystemColor.controlHighlight);
		button_1.setBounds(56, 396, 125, 29);
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.control);
		panel_2.setBounds(753, 140, 275, 637);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_4 = new JLabel("Alterar palavra passe");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 20));
		label_4.setBounds(10, 57, 226, 26);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Palavra passe actual");
		label_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_5.setBounds(16, 108, 195, 26);
		panel_2.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(16, 140, 220, 36);
		panel_2.add(textField_3);
		
		JLabel label_6 = new JLabel("Nova palavra passe");
		label_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_6.setBounds(16, 187, 220, 26);
		panel_2.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(16, 224, 220, 36);
		panel_2.add(textField_4);
		
		JLabel label_7 = new JLabel("Confirmar nova palavra passe");
		label_7.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_7.setBounds(16, 271, 257, 26);
		panel_2.add(label_7);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(16, 308, 220, 36);
		panel_2.add(textField_5);
		
		JButton button = new JButton("CONFIRMAR");
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(61, 377, 125, 29);
		panel_2.add(button);
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
}

