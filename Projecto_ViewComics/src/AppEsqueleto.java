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

public class AppEsqueleto {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppEsqueleto window = new AppEsqueleto();
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
	public AppEsqueleto() {
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
					img = ImageIO.read(new File( "C:\\Users\\Tamara\\Dropbox\\IPJ_ProjectoFinal\\Design\\ViewComics\\fundo2.jpg"));
					g.drawImage(img,0,0,null); 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		JPanelMenu.setBounds(0, 185, 245, 544);
		frame.getContentPane().add(JPanelMenu);
		
		JPanel JPanelPagamento = new JPanel(){
			@Override
			//o paint component vai pintar literalmente o componente
			protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				Image img;
				try {
					
					// importar imagem para o background do panel, podemos faz�-lo da internet ou do ficheiro 
					
					// img = ImageIO.read(new URL( "https://conteudo.imguol.com.br/c/entretenimento/c4/2018/05/15/super-mario-odyssey-1526426783086_v2_1170x540.jpgx"));
					img = ImageIO.read(new File( "C:\\Users\\Joana\\Dropbox\\IPJ_ProjectoFinal\\Design\\ViewComics\\wallpaperMarvel.jpg"));
					g.drawImage(img,0,0,null); 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		JPanelPagamento.setBounds(326, 235, 322, 397);
		frame.getContentPane().add(JPanelPagamento);
		JPanelPagamento.setLayout(null);
		
		JComboBox comboBoxPagamento = new JComboBox();
		comboBoxPagamento.setBounds(65, 34, 199, 22);
		JPanelPagamento.add(comboBoxPagamento);
		comboBoxPagamento.addItem("Multibanco");
		comboBoxPagamento.addItem("Dinheiro");
		
		
		JPanel JPDinheiro = new JPanel();
		JPDinheiro.setBounds(45, 90, 237, 282);
		JPanelPagamento.add(JPDinheiro);
		JPDinheiro.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(24, 35, 145, 27);
		JPDinheiro.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(24, 113, 174, 27);
		JPDinheiro.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(24, 197, 145, 27);
		JPDinheiro.add(textField_2);
		
		JLabel lblQuantiaRecebida = new JLabel("Quantia recebida :");
		lblQuantiaRecebida.setBounds(24, 84, 126, 14);
		JPDinheiro.add(lblQuantiaRecebida);
		
		JLabel lblTroco = new JLabel("Troco :");
		lblTroco.setBounds(24, 162, 86, 14);
		JPDinheiro.add(lblTroco);
		
		JLabel lblAPagar = new JLabel("A pagar :");
		lblAPagar.setBounds(24, 10, 105, 14);
		JPDinheiro.add(lblAPagar);
		
		JButton btnConcluirPagamento = new JButton("Concluir pagamento");
		btnConcluirPagamento.setBounds(32, 248, 180, 23);
		JPDinheiro.add(btnConcluirPagamento);
		
		JPanel JPMultibanco = new JPanel();
		JPMultibanco.setBounds(45, 90, 237, 282);
		JPanelPagamento.add(JPMultibanco);
	}
}
