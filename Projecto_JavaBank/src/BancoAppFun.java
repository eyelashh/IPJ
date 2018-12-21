
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
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.List;

public class BancoAppFun {

	private JFrame frame;
	private JTextField tbCltNome;
	private JTextField tbCltDnasc;
	private JTextField tbCltNum;
	private JTextField tbCltContacto;
	private JTextField tbCltUser;
	private JPasswordField tbCltPass;
	private JTextField tbContasOrdenar;
	private JTextField tbContasnum;
	private JTextField tbContasdtcriacao;
	private JTextField tbContaslimitelev;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					BancoAppFun window = new BancoAppFun();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
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
	
		
		JLabel lblBemVindo = new JLabel("Bem-Vindo(a) ");
		lblBemVindo.setVerifyInputWhenFocusTarget(false);
		lblBemVindo.setForeground(new Color(0, 0, 0));
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblBemVindo.setBounds(332, 13, 277, 74);
		JpanelCabecalho.add(lblBemVindo);
		
		JLabel lUtilizador = new JLabel("Funcionario");
		lUtilizador.setVerifyInputWhenFocusTarget(false);
		lUtilizador.setForeground(new Color(0, 0, 0));
		lUtilizador.setFont(new Font("Tahoma", Font.BOLD, 35));
		lUtilizador.setBounds(673, 13, 216, 74);
		JpanelCabecalho.add(lUtilizador);
		
		JPanel JpanelMenu = new JPanel();
		JpanelMenu.setBackground(new Color(240, 240, 240));
		JpanelMenu.setBounds(12, 126, 170, 580);
		frame.getContentPane().add(JpanelMenu);
		JpanelMenu.setLayout(null);
		
		JButton btFunCliente = new JButton("Clientes");
		btFunCliente.setBounds(12, 13, 146, 130);
		JpanelMenu.add(btFunCliente);
		btFunCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btFunConta = new JButton("Contas");
		btFunConta.setBounds(12, 156, 146, 130);
		JpanelMenu.add(btFunConta);
		btFunConta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btFunOperaes = new JButton("Opera\u00E7\u00F5es");
		btFunOperaes.setBounds(12, 303, 146, 130);
		JpanelMenu.add(btFunOperaes);
		btFunOperaes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btFunGesto = new JButton("Gest\u00E3o");
		btFunGesto.setBounds(12, 446, 146, 130);
		JpanelMenu.add(btFunGesto);
		btFunGesto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel JpanelPrincipal = new JPanel();
		JpanelPrincipal.setBackground(new Color(240, 240, 240));
		JpanelPrincipal.setBounds(194, 126, 1056, 582);
		frame.getContentPane().add(JpanelPrincipal);
		JpanelPrincipal.setLayout(null);
		
		JPanel jpanelClientes = new JPanel();
		jpanelClientes.setVisible(false);
		
		JPanel jpanelContas = new JPanel();
		jpanelContas.setBounds(12, 13, 1032, 556);
		JpanelPrincipal.add(jpanelContas);
		jpanelContas.setLayout(null);
		
		JComboBox cbContaspesqconta = new JComboBox();
		cbContaspesqconta.setBounds(12, 13, 279, 31);
		jpanelContas.add(cbContaspesqconta);
		
		JTextField tbContaspesqconta = new JTextField();
		tbContaspesqconta.setBounds(12, 57, 279, 31);
		jpanelContas.add(tbContaspesqconta);
		
		JComboBox cbContasOrdenar = new JComboBox();
		cbContasOrdenar.setBounds(366, 13, 279, 31);
		jpanelContas.add(cbContasOrdenar);
		
		tbContasOrdenar = new JTextField();
		tbContasOrdenar.setBounds(366, 57, 279, 31);
		jpanelContas.add(tbContasOrdenar);
		
		JList lContas = new JList();
		lContas.setBounds(12, 101, 279, 442);
		jpanelContas.add(lContas);
		
		JList lClientes = new JList();
		lClientes.setBounds(741, 101, 279, 442);
		jpanelContas.add(lClientes);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00BA de Conta:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(366, 124, 113, 24);
		jpanelContas.add(lblNewLabel_2);
		
		JLabel lblDataDeOperao = new JLabel("Data de Cria\u00E7\u00E3o:");
		lblDataDeOperao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataDeOperao.setBounds(366, 205, 113, 24);
		jpanelContas.add(lblDataDeOperao);
		
		JLabel lblLimiteDeLevantamento = new JLabel("Limite de Levantamento:");
		lblLimiteDeLevantamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLimiteDeLevantamento.setBounds(366, 286, 171, 24);
		jpanelContas.add(lblLimiteDeLevantamento);
		
		tbContasnum = new JTextField();
		tbContasnum.setBounds(366, 161, 279, 31);
		jpanelContas.add(tbContasnum);
		
		tbContasdtcriacao = new JTextField();
		tbContasdtcriacao.setBounds(366, 242, 279, 31);
		jpanelContas.add(tbContasdtcriacao);
		
		tbContaslimitelev = new JTextField();
		tbContaslimitelev.setBounds(366, 316, 279, 31);
		jpanelContas.add(tbContaslimitelev);
		
		JButton btContasConfirmar = new JButton("Confirmar");
		btContasConfirmar.setBounds(366, 391, 97, 25);
		jpanelContas.add(btContasConfirmar);
		
		JButton btContasCancelar = new JButton("Limpar");
		btContasCancelar.setBounds(548, 391, 97, 25);
		jpanelContas.add(btContasCancelar);
		
		JButton btContasNovo = new JButton("Novo");
		btContasNovo.setBounds(350, 471, 97, 25);
		jpanelContas.add(btContasNovo);
		
		JButton btContasEliminar = new JButton("Eliminar");
		btContasEliminar.setBounds(461, 471, 97, 25);
		jpanelContas.add(btContasEliminar);
		
		JButton btContasLimpar = new JButton("Cancelar");
		btContasLimpar.setBounds(570, 471, 97, 25);
		jpanelContas.add(btContasLimpar);
		
		JLabel lblClientes_1 = new JLabel("Clientes");
		lblClientes_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClientes_1.setBounds(741, 64, 57, 24);
		jpanelContas.add(lblClientes_1);
		jpanelClientes.setBounds(12, 13, 1032, 556);
		JpanelPrincipal.add(jpanelClientes);
		jpanelClientes.setLayout(null);
		
		JComboBox cbCltPesq = new JComboBox();
		cbCltPesq.setBounds(12, 13, 250, 30);
		jpanelClientes.add(cbCltPesq);
		
		JTextField tbCltPesq = new JTextField();
		tbCltPesq.setBounds(12, 56, 250, 30);
		jpanelClientes.add(tbCltPesq);
		
		JList lbClt = new JList();
		lbClt.setBounds(12, 142, 250, 401);
		jpanelClientes.add(lbClt);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(387, 99, 44, 30);
		jpanelClientes.add(lblNewLabel_1);
		
		JLabel lblDNascimento = new JLabel("D. Nascimento:");
		lblDNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDNascimento.setBounds(330, 142, 101, 30);
		jpanelClientes.add(lblDNascimento);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDocumento.setBounds(351, 185, 80, 30);
		jpanelClientes.add(lblDocumento);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNmero.setBounds(369, 228, 62, 30);
		jpanelClientes.add(lblNmero);
		
		JLabel lblContacto = new JLabel("Contacto:");
		lblContacto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContacto.setBounds(368, 271, 63, 30);
		jpanelClientes.add(lblContacto);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(351, 314, 80, 30);
		jpanelClientes.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(359, 357, 72, 30);
		jpanelClientes.add(lblPassword);
		
		tbCltNome = new JTextField();
		tbCltNome.setBounds(443, 97, 250, 30);
		jpanelClientes.add(tbCltNome);
		
		tbCltDnasc = new JTextField();
		tbCltDnasc.setBounds(443, 147, 250, 30);
		jpanelClientes.add(tbCltDnasc);
		
		tbCltNum = new JTextField();
		tbCltNum.setBounds(443, 233, 250, 30);
		jpanelClientes.add(tbCltNum);
		
		tbCltContacto = new JTextField();
		tbCltContacto.setBounds(443, 276, 250, 30);
		jpanelClientes.add(tbCltContacto);
		
		tbCltUser = new JTextField();
		tbCltUser.setBounds(443, 319, 250, 30);
		jpanelClientes.add(tbCltUser);
		
		tbCltPass = new JPasswordField();
		tbCltPass.setBounds(443, 362, 250, 30);
		jpanelClientes.add(tbCltPass);
		
		JList lbCltConta = new JList();
		lbCltConta.setBounds(770, 142, 250, 401);
		jpanelClientes.add(lbCltConta);
		
		JButton btCltPesquisa = new JButton("Pesquisa");
		btCltPesquisa.setBounds(280, 16, 97, 30);
		jpanelClientes.add(btCltPesquisa);
		
		JButton btCltNovo = new JButton("Novo");
		btCltNovo.setBounds(387, 16, 97, 30);
		jpanelClientes.add(btCltNovo);
		
		JButton btCltEliminar = new JButton("Eliminar");
		btCltEliminar.setBounds(496, 16, 97, 30);
		jpanelClientes.add(btCltEliminar);
		
		JButton btCltconfirmar = new JButton("Confirmar");
		btCltconfirmar.setBounds(443, 405, 97, 30);
		jpanelClientes.add(btCltconfirmar);
		
		JButton btCltLimpar = new JButton("Limpar");
		btCltLimpar.setBounds(596, 405, 97, 30);
		jpanelClientes.add(btCltLimpar);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClientes.setBounds(12, 99, 56, 30);
		jpanelClientes.add(lblClientes);
		
		JLabel lblContas = new JLabel("Contas");
		lblContas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContas.setBounds(770, 99, 56, 30);
		jpanelClientes.add(lblContas);
		
		JRadioButton rbCltcc = new JRadioButton("C.C.");
		rbCltcc.setBounds(439, 189, 56, 25);
		jpanelClientes.add(rbCltcc);
		
		JRadioButton rbCltbi = new JRadioButton("B.I.");
		rbCltbi.setBounds(512, 189, 56, 25);
		jpanelClientes.add(rbCltbi);
		
		JRadioButton rbCltPassaporte = new JRadioButton("Passaporte");
		rbCltPassaporte.setBounds(582, 189, 111, 25);
		jpanelClientes.add(rbCltPassaporte);

	}
}
