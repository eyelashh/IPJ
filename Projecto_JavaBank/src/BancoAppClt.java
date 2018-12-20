
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BancoAppClt {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BancoAppClt window = new BancoAppClt();
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
	public BancoAppClt() {
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
		btnLogin.setBounds(1070, 30, 117, 38);
		JpanelCabecalho.add(btnLogin);
		
		
		
		JLabel lblNewLabel = new JLabel("JavaBank");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setVerifyInputWhenFocusTarget(false);
		lblNewLabel.setForeground(new Color(188, 127, 82));
		lblNewLabel.setBounds(37, 13, 175, 74);
		JpanelCabecalho.add(lblNewLabel);
	
		
		JLabel lblBemVindo = new JLabel("Bem-Vindo(a) -");
		lblBemVindo.setVerifyInputWhenFocusTarget(false);
		lblBemVindo.setForeground(new Color(0, 0, 0));
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblBemVindo.setBounds(332, 13, 277, 74);
		JpanelCabecalho.add(lblBemVindo);
		
		JLabel lUtilizador = new JLabel("Utilizador");
		lUtilizador.setVerifyInputWhenFocusTarget(false);
		lUtilizador.setForeground(new Color(0, 0, 0));
		lUtilizador.setFont(new Font("Tahoma", Font.BOLD, 35));
		lUtilizador.setBounds(673, 13, 189, 74);
		JpanelCabecalho.add(lUtilizador);
		
		
		JPanel JpanelMenu = new JPanel();
		JpanelMenu.setBackground(new Color(255, 255, 255));
		JpanelMenu.setBounds(12, 126, 170, 580);
		frame.getContentPane().add(JpanelMenu);
		JpanelMenu.setLayout(null);
		
		JPanel JPanelCliente = new JPanel();
		JPanelCliente.setBounds(0, 0, 170, 580);
		JpanelMenu.add(JPanelCliente);
		JPanelCliente.setLayout(null);
		JPanelCliente.setBackground(Color.WHITE);
		
		JButton btCltConmov = new JButton("Conta\r\n/Movimentos");
		btCltConmov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btCltConmov.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btCltConmov.setBounds(12, 13, 146, 130);
		JPanelCliente.add(btCltConmov);
		
		JButton btCltTransferencia = new JButton("Transfer\u00EAncia");
		btCltTransferencia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btCltTransferencia.setBounds(12, 156, 146, 130);
		JPanelCliente.add(btCltTransferencia);
		
		JButton btCltCartao = new JButton("Cart\u00E3o");
		btCltCartao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btCltCartao.setBounds(12, 299, 146, 130);
		JPanelCliente.add(btCltCartao);
		
		JButton btCltGestao = new JButton("Gest\u00E3o");
		btCltGestao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btCltGestao.setBounds(12, 442, 146, 130);
		JPanelCliente.add(btCltGestao);
		
		JPanel JpanelPrincipal = new JPanel();
		JpanelPrincipal.setBackground(Color.WHITE);
		JpanelPrincipal.setBounds(194, 126, 1056, 582);
		frame.getContentPane().add(JpanelPrincipal);
		JpanelPrincipal.setLayout(null);
		
		JTextField tbAdmFunPesq = new JTextField();
		tbAdmFunPesq.setBounds(12, 52, 240, 30);
		tbAdmFunPesq.setColumns(10);
	}

}
