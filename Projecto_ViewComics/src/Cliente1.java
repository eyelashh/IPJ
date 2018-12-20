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
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class Cliente1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente1 window = new Cliente1();
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
	public Cliente1() {
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
					img = ImageIO.read(new File( "C:\\Users\\Joana\\Dropbox\\IPJ_ProjectoFinal\\Design\\ViewComics\\fundo.jpg"));
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
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)
					.addGap(277))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
					.addGap(31))
		);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Livros");
		btnNewButton.setBounds(32, 77, 284, 72);
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		panel.add(btnNewButton);
		
		Button button = new Button("New button");
		button.setBounds(1141, 26, 113, 36);
		panel.add(button);
		
		JButton btnCarrinhoDeCompras = new JButton("Carrinho de compras");
		btnCarrinhoDeCompras.setBounds(32, 174, 284, 72);
		btnCarrinhoDeCompras.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		panel.add(btnCarrinhoDeCompras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 637, 284, -355);
		panel.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(32, 278, 284, 389);
		panel.add(scrollPane_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(396, 278, 254, 389);
		panel.add(comboBox);
		
		JLabel lblAdicionarAoCarrinho = new JLabel("Adicionar ao carrinho");
		lblAdicionarAoCarrinho.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblAdicionarAoCarrinho.setBounds(763, 150, 170, 52);
		panel.add(lblAdicionarAoCarrinho);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		label.setBounds(389, 77, 170, 52);
		panel.add(label);
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
}