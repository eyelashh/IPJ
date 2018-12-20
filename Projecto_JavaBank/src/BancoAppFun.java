
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

public class BancoAppFun {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BancoAppFun window = new BancoAppFun();
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
	public BancoAppFun() {
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
		
		JPanel JPanelFuncionario = new JPanel();
		JPanelFuncionario.setBounds(0, 0, 170, 580);
		JpanelMenu.add(JPanelFuncionario);
		JPanelFuncionario.setBackground(Color.WHITE);
		JPanelFuncionario.setLayout(null);
		
		JButton btFunCliente = new JButton("Clientes");
		btFunCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btFunCliente.setBounds(12, 13, 146, 130);
		JPanelFuncionario.add(btFunCliente);
		
		JButton btFunConta = new JButton("Conta");
		btFunConta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btFunConta.setBounds(12, 156, 146, 130);
		JPanelFuncionario.add(btFunConta);
		
		JButton btFunOperaes = new JButton("Opera\u00E7\u00F5es");
		btFunOperaes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btFunOperaes.setBounds(12, 299, 146, 130);
		JPanelFuncionario.add(btFunOperaes);
		
		JButton btFunGesto = new JButton("Gest\u00E3o");
		btFunGesto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btFunGesto.setBounds(12, 442, 146, 130);
		JPanelFuncionario.add(btFunGesto);
		
		JPanel JpanelPrincipal = new JPanel();
		JpanelPrincipal.setBackground(Color.WHITE);
		JpanelPrincipal.setBounds(194, 126, 1056, 582);
		frame.getContentPane().add(JpanelPrincipal);
		JpanelPrincipal.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 1032, 556);
		JpanelPrincipal.add(panel);

	}
}
