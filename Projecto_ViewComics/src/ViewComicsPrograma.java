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

public class ViewComicsPrograma {

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
					ViewComicsPrograma window = new ViewComicsPrograma();
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
	public ViewComicsPrograma() {
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
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE))
		);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(837, 204, 98, 36);
		lblUsername.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(842, 291, 93, 39);
		lblPassword.setFont(new Font("Tempus Sans ITC", Font.BOLD, 21));
		
		JLabel lblViewcomics = new JLabel("ViewComics");
		lblViewcomics.setBounds(727, 121, 304, 72);
		lblViewcomics.setFont(new Font("Papyrus", Font.BOLD, 46));
		
		textField = new JTextField();
		textField.setBounds(673, 244, 448, 36);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(673, 330, 448, 36);
		panel.setLayout(null);
		panel.add(lblViewcomics);
		panel.add(lblUsername);
		panel.add(lblPassword);
		panel.add(passwordField);
		panel.add(textField);
		
		JButton btnNewButton = new JButton("Livros");
		btnNewButton.setBounds(47, 130, 200, 72);
		panel.add(btnNewButton);
		
		Button button = new Button("New button");
		button.setBounds(1141, 26, 113, 36);
		panel.add(button);
		
		JButton btnCarrinhoDeCompras = new JButton("Carrinho de compras");
		btnCarrinhoDeCompras.setBounds(47, 240, 200, 72);
		panel.add(btnCarrinhoDeCompras);
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
}

