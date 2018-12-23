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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AppAdmin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppAdmin window = new AppAdmin();
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
	public AppAdmin() {
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
		
		JPanel JPanelMenu = new JPanel() {
			@Override
			//o paint component vai pintar literalmente o componente
			protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				Image img;
				try {
					
					// importar imagem para o background do panel, podemos faz�-lo da internet ou do ficheiro 
					
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
		
		JPanel panel = new JPanel();
		panel.setBounds(248, 185, 1016, 544);
		frame.getContentPane().add(panel);
	}
}
