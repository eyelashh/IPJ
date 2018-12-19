import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.Panel;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.Box;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import java.awt.ScrollPane;
import java.awt.Font;

public class JavaBankProgram {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaBankProgram window = new JavaBankProgram();
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
	public JavaBankProgram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel JpanelCabecalho = new JPanel();
		JpanelCabecalho.setBackground(new Color(65, 106, 105));
		JpanelCabecalho.setBounds(12, 13, 1238, 100);
		frame.getContentPane().add(JpanelCabecalho);
		JpanelCabecalho.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Login dialog = new Login();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(frame);
					dialog.setVisible(true);
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(1129, 35, 97, 25);
		JpanelCabecalho.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("JavaBank");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setVerifyInputWhenFocusTarget(false);
		lblNewLabel.setForeground(new Color(188, 127, 82));
		lblNewLabel.setBounds(12, 13, 175, 74);
		JpanelCabecalho.add(lblNewLabel);
		
		JLabel lblBemVindo = new JLabel("Bem-Vindo(a) -");
		lblBemVindo.setVerifyInputWhenFocusTarget(false);
		lblBemVindo.setForeground(new Color(0, 0, 0));
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblBemVindo.setBounds(384, 13, 277, 74);
		JpanelCabecalho.add(lblBemVindo);
		
		JLabel lblUtilizador = new JLabel("Utilizador");
		lblUtilizador.setVerifyInputWhenFocusTarget(false);
		lblUtilizador.setForeground(new Color(0, 0, 0));
		lblUtilizador.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblUtilizador.setBounds(673, 13, 277, 74);
		JpanelCabecalho.add(lblUtilizador);
		
		JPanel JpanelPrincipal = new JPanel();
		JpanelPrincipal.setBackground(Color.WHITE);
		JpanelPrincipal.setBounds(194, 126, 1056, 582);
		frame.getContentPane().add(JpanelPrincipal);
		JpanelPrincipal.setLayout(null);
		
		
		JPanel JpanelMenu = new JPanel();
		JpanelMenu.setBackground(new Color(255, 255, 255));
		JpanelMenu.setBounds(12, 126, 170, 580);
		frame.getContentPane().add(JpanelMenu);
		JpanelMenu.setLayout(null);
		
		JPanel JPanelAdmin = new JPanel();
		JPanelAdmin.setLayout(null);
		JPanelAdmin.setBackground(Color.WHITE);
		JPanelAdmin.setBounds(0, 0, 170, 580);
		JpanelMenu.add(JPanelAdmin);
		
		JButton BAdmEstatistica = new JButton("Estatist\u00EDcas");
		BAdmEstatistica.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BAdmEstatistica.setBounds(12, 13, 146, 130);
		JPanelAdmin.add(BAdmEstatistica);
		
		JButton BAdmFuncionarios = new JButton("Funcion\u00E1rios");
		BAdmFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 17));
		BAdmFuncionarios.setBounds(12, 156, 146, 130);
		JPanelAdmin.add(BAdmFuncionarios);
		
		JButton BAdmClientes = new JButton("Cart\u00E3o");
		BAdmClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BAdmClientes.setBounds(12, 299, 146, 130);
		JPanelAdmin.add(BAdmClientes);
		
		JButton BAdmGestao = new JButton("Gest\u00E3o");
		BAdmGestao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BAdmGestao.setBounds(12, 442, 146, 130);
		JPanelAdmin.add(BAdmGestao);
		
		JPanel JPanelCliente = new JPanel();
		JPanelCliente.setBounds(0, 0, 170, 580);
		JpanelMenu.add(JPanelCliente);
		JPanelCliente.setLayout(null);
		JPanelCliente.setBackground(Color.WHITE);
		
		JButton BCltConmov = new JButton("Conta\r\n/Movimentos");
		BCltConmov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BCltConmov.setFont(new Font("Tahoma", Font.PLAIN, 13));
		BCltConmov.setBounds(12, 13, 146, 130);
		JPanelCliente.add(BCltConmov);
		
		JButton BCltTransferencia = new JButton("Transfer\u00EAncia");
		BCltTransferencia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		BCltTransferencia.setBounds(12, 156, 146, 130);
		JPanelCliente.add(BCltTransferencia);
		
		JButton BCltCartao = new JButton("Cart\u00E3o");
		BCltCartao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BCltCartao.setBounds(12, 299, 146, 130);
		JPanelCliente.add(BCltCartao);
		
		JButton BCltGestao = new JButton("Gest\u00E3o");
		BCltGestao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BCltGestao.setBounds(12, 442, 146, 130);
		JPanelCliente.add(BCltGestao);
		
		JPanel JPanelFuncionario = new JPanel();
		JPanelFuncionario.setBounds(0, 0, 170, 580);
		JpanelMenu.add(JPanelFuncionario);
		JPanelFuncionario.setBackground(Color.WHITE);
		JPanelFuncionario.setLayout(null);
		
		JButton BFunCliente = new JButton("Clientes");
		BFunCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BFunCliente.setBounds(12, 13, 146, 130);
		JPanelFuncionario.add(BFunCliente);
		
		JButton BFunConta = new JButton("Conta");
		BFunConta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BFunConta.setBounds(12, 156, 146, 130);
		JPanelFuncionario.add(BFunConta);
		
		JButton BFunOperaes = new JButton("Opera\u00E7\u00F5es");
		BFunOperaes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BFunOperaes.setBounds(12, 299, 146, 130);
		JPanelFuncionario.add(BFunOperaes);
		
		JButton BFunGesto = new JButton("Gest\u00E3o");
		BFunGesto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BFunGesto.setBounds(12, 442, 146, 130);
		JPanelFuncionario.add(BFunGesto);
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
