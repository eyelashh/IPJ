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

public class AppFunc {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		button.setBounds(26, 29, 176, 55);
		JPanelMenu.add(button);
		
		JButton button_1 = new JButton("Carrinhos");
		button_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		button_1.setBackground(SystemColor.controlHighlight);
		button_1.setBounds(26, 108, 176, 60);
		JPanelMenu.add(button_1);
		
		JButton button_2 = new JButton();
		button_2.setText("<HTML> Gest\u00E3o de conta <HTML>");
		button_2.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		button_2.setBackground(SystemColor.controlHighlight);
		button_2.setBounds(28, 200, 176, 96);
		JPanelMenu.add(button_2);
		
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
		
		JPanel JPCarrinhos = new JPanel();
		JPCarrinhos.setBounds(0, 0, 1009, 544);
		JPanelPrincipal.add(JPCarrinhos);
		JPCarrinhos.setLayout(null);
		
		textField_6 = new JTextField();
		textField_6.setBounds(59, 23, 153, 32);
		JPCarrinhos.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NIF");
		lblNewLabel.setBounds(26, 32, 46, 14);
		JPCarrinhos.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(59, 88, 153, 394);
		JPCarrinhos.add(list);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setBounds(238, 28, 89, 23);
		JPCarrinhos.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("TOTAL :");
		lblNewLabel_1.setBounds(222, 324, 76, 14);
		JPCarrinhos.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(269, 324, 46, 14);
		JPCarrinhos.add(lblNewLabel_2);
		
		JLabel lblValorAPagar = new JLabel("VALOR A PAGAR: ");
		lblValorAPagar.setBounds(222, 349, 105, 14);
		JPCarrinhos.add(lblValorAPagar);
		
		JLabel label_9 = new JLabel("New label");
		label_9.setBounds(316, 349, 46, 14);
		JPCarrinhos.add(label_9);
		
		JButton btnNewButton_1 = new JButton("Realizar pagamento");
		btnNewButton_1.setBounds(222, 393, 153, 41);
		JPCarrinhos.add(btnNewButton_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(222, 445, 89, 32);
		JPCarrinhos.add(btnCancelar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(842, 170, 89, 23);
		JPCarrinhos.add(btnEliminar);
		
		JButton button_4 = new JButton("Eliminar");
		button_4.setBounds(842, 117, 89, 23);
		JPCarrinhos.add(button_4);
		
		JButton button_5 = new JButton("Eliminar");
		button_5.setBounds(842, 219, 89, 23);
		JPCarrinhos.add(button_5);
		
		JButton button_6 = new JButton("Eliminar");
		button_6.setBounds(842, 268, 89, 23);
		JPCarrinhos.add(button_6);
		
		JPanel JPGestao = new JPanel() {
			protected void paintComponent(Graphics g) {
			}
		};
		JPGestao.setBounds(0, 0, 1009, 544);
		JPanelPrincipal.add(JPGestao);
		JPGestao.setLayout(null);
		
		JLabel label_1 = new JLabel("Actualizar nome");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		label_1.setBounds(50, 29, 223, 26);
		JPGestao.add(label_1);
		
		JLabel label_2 = new JLabel("Nome actual");
		label_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_2.setBounds(50, 85, 144, 26);
		JPGestao.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(50, 117, 220, 36);
		JPGestao.add(textField);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_3.setBounds(50, 183, 144, 26);
		JPGestao.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(50, 220, 220, 36);
		JPGestao.add(textField_1);
		
		JLabel label_4 = new JLabel("Novo nome");
		label_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_4.setBounds(50, 267, 144, 26);
		JPGestao.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(50, 304, 220, 36);
		JPGestao.add(textField_2);
		
		JLabel label_5 = new JLabel("Alterar palavra passe");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		label_5.setBounds(417, 29, 226, 26);
		JPGestao.add(label_5);
		
		JLabel label_6 = new JLabel("Palavra passe actual");
		label_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_6.setBounds(423, 80, 195, 26);
		JPGestao.add(label_6);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(423, 112, 220, 36);
		JPGestao.add(textField_3);
		
		JLabel label_7 = new JLabel("Nova palavra passe");
		label_7.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_7.setBounds(423, 159, 220, 26);
		JPGestao.add(label_7);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(423, 196, 220, 36);
		JPGestao.add(textField_4);
		
		JLabel label_8 = new JLabel("Confirmar nova palavra passe");
		label_8.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		label_8.setBounds(423, 243, 257, 26);
		JPGestao.add(label_8);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(423, 280, 220, 36);
		JPGestao.add(textField_5);
		
		JButton button_3 = new JButton("CONFIRMAR");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_3.setBackground(SystemColor.controlHighlight);
		button_3.setBounds(468, 349, 125, 29);
		JPGestao.add(button_3);
		
		JPanel JPLivros = new JPanel();
		JPLivros.setBounds(0, 0, 1009, 544);
		JPanelPrincipal.add(JPLivros);
	}
}
