import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.SwingConstants;

public class InterfaceGrafica extends JFrame {

	private JButton login;
	private JButton livros, livros1, livros2;
	private JButton carrinhoCompra, carrinhoCompra1, carrinhoCompra2;

	private JPanel logInLayout, pesquisaLivroLayout, carrinhoComprasLayout, contentPanel;
	private CardLayout cardLayout = new CardLayout();

	public InterfaceGrafica() {
		super("ViewComics");
		
		login = new JButton("LogIn");
		login.setBounds(319, 303, 79, 29);
		login.setAlignmentX(Component.CENTER_ALIGNMENT);
		livros = new JButton("Livros");
		livros.setBounds(19, 29, 82, 29);
		livros1 = new JButton("Livros");
		livros2 = new JButton("Livros");
		carrinhoCompra = new JButton("Carrinho de Compras");
		carrinhoCompra.setBounds(6, 74, 152, 35);
		carrinhoCompra1 = new JButton("Carrinho de Compras");
		carrinhoCompra2 = new JButton("Carrinho de Compras");
		
		contentPanel = new JPanel();
		logInLayout = new JPanel();
		pesquisaLivroLayout = new JPanel();
		carrinhoComprasLayout = new JPanel();
		
		actionListener al = new actionListener();
		
		login.addActionListener(al);
		livros.addActionListener(al);
		carrinhoCompra.addActionListener(al);
		logInLayout.setLayout(null);
		
		logInLayout.add(login);
		logInLayout.add(livros);
		logInLayout.add(carrinhoCompra);
		pesquisaLivroLayout.add(livros1);
		pesquisaLivroLayout.add(carrinhoCompra1);
		carrinhoComprasLayout.add(livros2);
		carrinhoComprasLayout.add(carrinhoCompra2);
		

		contentPanel.setLayout(cardLayout);
		

		contentPanel.add(logInLayout, "logInLayout");
		contentPanel.add(pesquisaLivroLayout, "pesquisaLivroLayout");
		contentPanel.add(carrinhoComprasLayout, "carrinhoComprasLayout");
		
		this.setContentPane(contentPanel);
		
		cardLayout.show(contentPanel, "logInLayout");
		//cardLayout.show(contentPanel, "pesquisaLivroLayout");
		//cardLayout.show(contentPanel, "carrinhoComprasLayout");

	}
	
	public class actionListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			JButton src = (JButton) event.getSource();
			
			//if(src.equals(login))
			//	cardLayout.show(contentPanel, "logInLayout");
			if(src.equals(livros))
				cardLayout.show(contentPanel, "pesquisaLivroLayout");
			if(src.equals(livros1))
				cardLayout.show(contentPanel, "pesquisaLivroLayout");
			if(src.equals(livros2))
				cardLayout.show(contentPanel, "pesquisaLivroLayout");
			if(src.equals(carrinhoCompra))
				cardLayout.show(contentPanel, "carrinhoComprasLayout");
			if(src.equals(carrinhoCompra1))
				cardLayout.show(contentPanel, "carrinhoComprasLayout");
			if(src.equals(carrinhoCompra2))
				cardLayout.show(contentPanel, "carrinhoComprasLayout");
			
		}
	}

}
