import java.awt.HeadlessException;
import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * @author Joana
 *
 */
public class Livraria implements Serializable {

	private int idLivraria;
	private String nome;
	private ArrayList<Utilizador> utilizadores;
	private ArrayList<Livro> livros;
	private ArrayList<Carrinho> carrinhos;
	private ArrayList<Venda> vendas;

	// para efeitos de historico de vendas, cada vez que um carrinho e
	// eliminado/pago o seu conteudo transforma-se
	// no conteï¿½do de uma venda que tem uma data espcifica tambem como atributo

	public Livraria() {
		super();
		this.utilizadores = new ArrayList<Utilizador>();
		this.livros = new ArrayList<Livro>();
		this.carrinhos = new ArrayList<Carrinho>();
		this.vendas = new ArrayList<Venda>();
	}

	public Livraria(int idLivraria, String nome, ArrayList<Utilizador> utilizadores, ArrayList<Livro> livros,
			 ArrayList<Carrinho> carrinhos,
			ArrayList<Venda> vendas) {
		super();
		this.idLivraria = idLivraria;
		this.nome = nome;
		this.utilizadores = utilizadores;
		this.livros = livros;
		this.carrinhos = carrinhos;
		this.vendas = vendas;
	}

	// criar mï¿½todo estï¿½tico para retornar a instï¿½ncia da classe

	public int getIdLivraria() {
		return idLivraria;
	}

	public void setIdLivraria(int idLivraria) {
		this.idLivraria = idLivraria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Utilizador> getUtilizadores() {
		return utilizadores;
	}

	public void setUtilizadores(ArrayList<Utilizador> utilizadores) {
		this.utilizadores = utilizadores;
	}

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}

	public ArrayList<Carrinho> getCarrinhos() {
		return carrinhos;
	}

	public void setCarrinhos(ArrayList<Carrinho> carrinhos) {
		this.carrinhos = carrinhos;
	}

	public ArrayList<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(ArrayList<Venda> vendas) {
		this.vendas = vendas;
	}

	@Override
	public String toString() {
		return "Livraria [idLivraria=" + idLivraria + ", nome=" + nome + ", utilizadores=" + utilizadores + ", livros="
				+ livros + ", carrinhos=" + carrinhos + ", vendas=" + vendas + "]";
	}

	// adiciona livro
	protected void addLivro(Livro l) {
		this.livros.add(l);
	}

	// remove um livro
	protected void removeLivros(Livro l) {
		this.livros.remove(l);
	}

	protected void addVenda(Venda v) {
		this.vendas.add(v);
	}

	protected void removeVenda(Venda v) {
		this.vendas.remove(v);
	}

	/**
	 * @param idLivro
	 * @return o stock para um dado livro atraves do seu id
	 */
	protected String devolveStock(int idLivro) {
		ArrayList<Livro> livros = this.livros;
		int stockINT = 0;
		for (Livro l : livros) {
			stockINT = l.getStock();
		}
		String stockSTR = Integer.toString(stockINT);
		return stockSTR;
	}

	/**
	 * @param idLivro
	 * @param quantidadeTotal Altera o stock de um livro através do id e da nova
	 *                        quantidade de stock, util para a actualizacao de stock
	 *                        e carrinhos
	 */
	protected void alterarStockLivro(int idLivro, int quantidadeTotal) {

		for (Livro l : this.livros) {
			if (l.getIdLivro() == idLivro) {
				l.setStock(quantidadeTotal);
				JOptionPane.showMessageDialog(null, "O stock do livro " + l.getTitulo()
						+ " foi alterado com sucesso. Existem agora " + quantidadeTotal + " exemplares.");
			}
		}
	}

	// adiciona utilizadores
	protected void addUtilizador(Utilizador u) {
		this.utilizadores.add(u);
	}

	// remove utilizadores
	protected void removeUtilizador(Utilizador u) {
		this.utilizadores.remove(u);
	}

	// adiciona um carrinho
	protected void addCarrinho(Carrinho c) {
		this.carrinhos.add(c);
	}

	// remove um carrinho
	protected void removeCarrinho(Carrinho c) {
		this.carrinhos.remove(c);
	}

	/**
	 * Altera um utilizador já existente no sistema
	 * 
	 * @param id
	 * @param nome
	 * @param contacto
	 * @param username
	 * @param password
	 */
	protected void alterarUtilizador(int id, String nome, String contacto, String username, String password) {

		boolean funcionarioAlterado = false;
		for (Utilizador u : this.utilizadores) {
			if (u.getId() == id) {
				u.setNome(nome);
				u.setContato(contacto);
				u.setUsername(username);
				u.setPassword(password);
				funcionarioAlterado = true;
			}
		}
		if (funcionarioAlterado) {
			JOptionPane.showMessageDialog(null, "Os dados do utilizador de id " + id + " foram alterados com sucesso");

		} else {
			JOptionPane.showMessageDialog(null, "Nao foi possivel alterar os dados");
		}

	}

	// adiciona funcionario
//	protected void adicionarFuncionario(String nome, String contacto, String username, String password) {
//
//		this.utilizadores.add(new Funcionario(nome, contacto, username, password));
//
//	}

	/**
	 * Remove um livro da arrayList de livros em loja
	 * 
	 * @param idLivro
	 * @param livros
	 */
	protected void removeLivro(int idLivro, ArrayList<Livro> livros) {

		for (int i = 0; i < livros.size(); i++) {
			if (livros.get(i).getIdLivro() == idLivro) {
				livros.remove(i);
			}
		}

	}

	/**
	 * Confirma se um dado carrinho existe na loja, sendo que este é identificado
	 * pelo seu nif
	 * 
	 * @param nif
	 * @return
	 */
	protected boolean carrinhoExiste(String nif) {

		for (Carrinho c : this.carrinhos) {
			if (c.getNif().equals(nif)) {
				return true;
			}
		}
		return false;

	}

	/**
	 * retorna o preco de um dado livro atraves do seu id
	 * 
	 * @param id
	 * @return preco de um livro
	 */
	protected double precoLivro(int id) {

		double preco = 0;
		// procura no array de livros se o id do livro existe, se sim retorna o preï¿½o
		// da uma unidade do livro
		for (Livro l : this.livros) {
			if (l.getIdLivro() == id) {
				preco = l.getPreco();
			}
		}
		return preco;
	}

	/**
	 * Calcula o preco total do carrinho percorrendo todos os livros do carrinho,
	 * obtendo o seu preco, e fazendo o somatorio
	 * 
	 * @param c
	 * @return
	 */
	protected String precoTotalCarrinho(Carrinho c) {

		double precoTotalDOUBLE = 0;

		for (Livro l : this.livros) {
			if (!c.getConteudo().isEmpty()) {
				if (c.getConteudo().containsKey(l.getIdLivro())) {
					int id = l.getIdLivro();
					precoTotalDOUBLE += precoLivro(id) * (c.getConteudo().get(id));
				}
			} else
				precoTotalDOUBLE = 0;

		}
		DecimalFormat df = new DecimalFormat("#.##");
		String precoTotalSTR = df.format(precoTotalDOUBLE);

		return precoTotalSTR;

	}

	/**
	 * Devolve o numero total de livros num carrinho
	 * 
	 * @param carrinho c
	 * @return
	 */
	protected String totalLivrosCarrinho(Carrinho c) {

		int quantidadeTotalItemsINT = 0;

		if (!c.getConteudo().isEmpty()) {
			HashMap<Integer, Integer> hm = c.getConteudo();
			ArrayList<Integer> quantidade = new ArrayList<Integer>(hm.values());
			for (int q : quantidade) {
				quantidadeTotalItemsINT += q;
			}
		}
		String quantidadeTotalItemsSTR = Integer.toString(quantidadeTotalItemsINT);
		return quantidadeTotalItemsSTR;
	}

	protected double trocoCarrinho(double recebido, double total) {

		double troco = 0;

		troco = recebido - total;

		return troco;

	}

	// listar hashMap(livro e qtd) tendo em conta o nif do cliente

	/**
	 * @param nif
	 * @return
	 */
	protected String[] listaHashMap(String nif) {

		ArrayList<String> listaC = new ArrayList<String>();

		for (Carrinho c : this.carrinhos) {

			// Loop over String keys.
			for (Entry<Integer, Integer> pair : c.getConteudo().entrySet()) {

				if (c.getNif().equals(nif)) {

					String a = pair.getKey().toString() + "::" + pair.getValue().toString();
					listaC.add(a);

				}
			}
		}

		String[] listalivro = new String[listaC.size()];
		listalivro = listaC.toArray(listalivro);

		return listalivro;

	}

	/**
	 * Metodo para verificar se o username e a password coindidem para a gestao de
	 * conta de utilizador
	 * 
	 * @param username
	 * @param password
	 * @return boolean
	 */
	protected boolean verificarPassword(String username, String password) {

		boolean dadosCorrectos = false;

		for (Utilizador u : this.utilizadores) {
			String userEntrada = u.getUsername();
			String passEntrada = u.getPassword();
			if ((userEntrada.equals(username)) && (passEntrada.equals(password))) {
				dadosCorrectos = true;
			}
		}
		return dadosCorrectos;

	}

	/**
	 * Altera um livro existente em loja
	 * 
	 * @param idLivro
	 * @param titulo
	 * @param autor
	 * @param preco
	 * @param stock
	 * @param ano
	 * @param descricao
	 */
	protected void alterarLivro(int idLivro, String titulo, String autor, String preco, String stock, String ano,
			String descricao) {

		for (Livro l : this.livros) {
			if (l.getIdLivro() == idLivro) {
				l.setTitulo(titulo);
				l.setAutor(autor);
				l.setPreco(Double.parseDouble(preco));
				l.setStock(Integer.parseInt(stock));
				l.setAno(Integer.parseInt(ano));
				l.setDescricao(descricao);
			}
		}

	}

	/**
	 * Cria um novo livro em loja com os paramtetros necessarios
	 * 
	 * @param idSTR
	 * @param titulo
	 * @param autor
	 * @param preco
	 * @param stock
	 * @param ano
	 * @param descricao
	 */
	protected void criarLivro(String idSTR, String titulo, String autor, String preco, String stock, String ano,
			String descricao) {

		int idINT = Integer.parseInt(idSTR);
		for (Livro l : this.livros) {
			if (l.getIdLivro() == idINT) {
				l.setTitulo(titulo);
				l.setAutor(autor);
				l.setPreco(Double.parseDouble(preco));
				l.setStock(Integer.parseInt(stock));
				l.setAno(Integer.parseInt(ano));
				l.setDescricao(descricao);
			}
		}

	}

	/**
	 * Verifica o utilizador que se encontra loggado
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	protected Utilizador loggado(String username, String password) {

		Utilizador u_log = new Utilizador();

		for (Utilizador u : this.utilizadores) {
			String usernameIN = u.getUsername();
			String passIN = u.getPassword();
			if ((usernameIN.equals(username)) && (passIN.equals(password))) {
				u_log = u;
			}
		}
		return u_log;
	}

	/**
	 * Altera username confirmando previamente se a password inserida pelo user é
	 * referente ao username inserido
	 * 
	 * @param username
	 * @param pass
	 * @param novoUsername
	 */
	protected void alterarUsername(String username, char[] pass, String novoUsername) {

		String passSTR = String.valueOf(pass);
		boolean usernameAlterado = false;
		for (Utilizador u : this.utilizadores) {
			if ((u.getUsername().equals(username)) && (u.getPassword().equals(passSTR))) {
				u.setUsername(novoUsername);
				usernameAlterado = true;
			}
		}
		if (usernameAlterado) {
			JOptionPane.showMessageDialog(null, "Alteracao efectuada com sucesso!Novo username: " + novoUsername);
		} else {
			JOptionPane.showMessageDialog(null,
					"Nï¿½o foi possï¿½vel efectuar a alteraï¿½ï¿½o de username, confira os dados inseridos");
		}

	}

	/**
	 * Altera username confirmando previamente se a password antiga inserida pelo
	 * user esta correcta, pedindo para confirmar a nova password
	 * 
	 * @param username
	 * @param pass
	 * @param novaPass
	 * @param novaPassConfirm
	 */
	protected void alterarPassword(String username, char[] pass, char[] novaPass, char[] novaPassConfirm) {

		String passSTR = String.valueOf(pass);
		String novaPassSTR = String.valueOf(novaPass);
		String novaPassConfirmSTR = String.valueOf(novaPassConfirm);

		boolean passAlterada = false;

		for (Utilizador u : this.utilizadores) {
			if ((u.getUsername().equals(username)) && (u.getPassword().equals(passSTR))) {
				if (novaPassSTR.equals(novaPassConfirmSTR)) {
					u.setPassword(novaPassSTR);
					passAlterada = true;
				}
			}
		}
		if (passAlterada) {
			JOptionPane.showMessageDialog(null, "Alteracao efectuada com sucesso!A sua pass ï¿½ agora " + novaPassSTR);
		} else {
			JOptionPane.showMessageDialog(null,
					"Nï¿½o foi possï¿½vel efectuar a alteraï¿½ï¿½o de password, confira os dados inseridos");
		}

	}

	/**
	 * Adiciona um array qualquer a um modelo para, se necessário, formatar uma
	 * JList
	 * 
	 * @param s
	 * @param dm
	 */
	protected void addArrayLista(String[] s, DefaultListModel<String> dm) {

		for (int i = 0; i < s.length; i++) {
			dm.addElement(s[i]);
		}
	}

	/**
	 * Retorna uma copia de um livro com um determinado id, para situacoes em que
	 * seja necessario mostrar os atributos de um livro por ex
	 * 
	 * @param id
	 * @return
	 */
	protected Livro livroId(int id) {
		Livro livro = null;
		for (Livro l : this.livros) {
			if (l.getIdLivro() == id) {
				livro = l;
			}
		}
		return livro;

	}

	/**
	 * Cria um array de funcionarios para meter em qualquer lista
	 * 
	 * @param util
	 * @return
	 */
	protected String[] arrayFunc(ArrayList<Utilizador> util) {

		ArrayList<String> utilizadores = new ArrayList();
		ArrayList<Utilizador> utils = util;

		for (Utilizador u : util) {
			utilizadores.add(u.toString());
		}

		String[] utilArray = utilizadores.toArray(new String[utilizadores.size()]);
		return utilArray;

	}
	
	protected String[] arrayLivro() {

		ArrayList<String> livrosSTR =new ArrayList();
		ArrayList <Livro> livros =this.livros;

		for (Livro l: livros) {
			livrosSTR.add(l.toString());
		}

		String[] livrosArray = livrosSTR.toArray(new String[livrosSTR.size()]);
		return livrosArray;

	}

	/**
	 * Devolve uma copia de um utilizador com determinado id de forma a poder
	 * visualizar os seus valores dos seus atributos
	 * 
	 * @param id
	 * @return
	 */
	protected Utilizador devolveUtilizador(int id) {

		ArrayList<Utilizador> users = this.utilizadores;
		Utilizador func = new Utilizador();

		for (Utilizador u : users) {
			if (u.getId() == id) {
				func = u;
			}
		}
		return func;
	}

	/**
	 * Remove um utilizador da lista de utilizadores da livraria através do seu id
	 * 
	 * @param id
	 */
	protected void removerUtil(int id) {

		for (int i = 0; i < this.utilizadores.size(); i++) {
			if (utilizadores.get(i).getId() == id) {
				utilizadores.remove(i);
			}
		}
	}

	/**
	 * Remove um livro de um arrayList através do seu id
	 * 
	 * @param idLivro
	 * @param livros
	 */
	protected void removerLivro(int idLivro, ArrayList<Livro> livros) {

		for (int i = 0; i < livros.size(); i++) {
			if (livros.get(i).getIdLivro() == idLivro) {
				livros.remove(i);
			}
		}
	}

	/**
	 * Recebe duas strings e efectua o seu somatorio devolvendo o mesmo em string,
	 * util para operaçoes rapidas das caixas de texto
	 * 
	 * @param actual
	 * @param adicionar
	 * @return
	 */
	protected String adicionarQuantidade(String actual, String adicionar) {
		String totalStr = actual;
		if ((actual != null) && (adicionar != null)) {
			int actualInt = Integer.valueOf(actual);
			int adicionarInt = Integer.parseInt(adicionar);

			int totalInt = actualInt + adicionarInt;
			totalStr = Integer.toString(totalInt);

		} else {
			totalStr = actual;
		}
		return totalStr;
	}

	/**
	 * Recebe duas strings e efectua a sua subtraccao devolvendo o mesmo em string,
	 * util para operaçoes rapidas das caixas de texto
	 * 
	 * @param actual
	 * @param adicionar
	 * @return
	 */
	protected String removerQuantidade(String actual, String subtrair) {
		int actualInt = Integer.parseInt(actual);
		int subtrairInt = Integer.parseInt(subtrair);

		int totalInt = actualInt - subtrairInt;
		String totalStr = Integer.toString(totalInt);
		return totalStr;
	}

	/**
	 * Verifica se é possível remover uma quantidade de um certo livro de um
	 * carrinho de forma a voltar a adiciona-la posteriormente ao stock
	 * 
	 * @param qtdremovidaCarrinhoSTR
	 * @param idLivro
	 * @param nif
	 * @return
	 */
	protected boolean removerCarrinhoPossivel(String qtdremovidaCarrinhoSTR, int idLivro, String nif) {

		boolean remocaoPossivel = false;
		Carrinho c = pesquisarCarrinho(nif);
		int qtdRemovidaCarrinhoINT = Integer.parseInt(qtdremovidaCarrinhoSTR);

		int qtdContidaCarrinhoINT = c.getConteudo().get(idLivro);
		if (qtdRemovidaCarrinhoINT <= qtdContidaCarrinhoINT) {
			remocaoPossivel = true;
		}
		return remocaoPossivel;

	}

	/**
	 * Verifica se é possível adicionar uma quantidade de um certo livro a um
	 * carrinho atraves da verificacao do seu stock
	 * 
	 * @param qtdremovidaCarrinhoSTR
	 * @param idLivro
	 * @param nif
	 * @return
	 */
	protected boolean adicionarAoCarrinhoPossivel(String qtdadicionadaCarrinhoSTR, int idLivro, String stockLivroSTR) {

		boolean adicaoPossivel = false;
		int qtdAdicionadaCarrinhoINT = Integer.parseInt(qtdadicionadaCarrinhoSTR);
		int stockLivroINT = Integer.parseInt(stockLivroSTR);

		if (qtdAdicionadaCarrinhoINT <= stockLivroINT) {
			adicaoPossivel = true;
		}
		return adicaoPossivel;

	}

	/**
	 * Devolve a quantidade de um livro em um carrinho chamando o metodo proprio
	 * depois de encontrar o carrinho desejado atraves do nif
	 * 
	 * @param idLivro
	 * @param nif
	 * @return
	 */
	protected String quantidadeCarrinho(int idLivro, String nif) {

		int quantidadeInt = 0;
		for (Carrinho c : this.carrinhos) {
			if (c.getNif().equals(nif)) {
				quantidadeInt = c.quantidadeLivro(idLivro);

			}
		}

		String quantidadeStr = Integer.toString(quantidadeInt);

		return quantidadeStr;
	}

	/**
	 * Actualiza o conteudo de um carrinho no que diz respeito a um determinado
	 * livro
	 * 
	 * @param nif
	 * @param idLivro
	 * @param quantidade
	 */
	protected void updateConteudoCarrinho(String nif, int idLivro, int quantidade) {
		for (Carrinho c : this.carrinhos) {
			if (c.getNif().equals(nif)) {
				c.updateCarrinho(idLivro, quantidade);
			}
		}
	}

	/**
	 * Verifica se o nif introduzido so tem digitos e o comprimento 9
	 * 
	 * @param nif
	 * @return
	 */
	protected boolean verificaNif(String nif) {

		if (nif.matches("([0-9]{9})")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retorna um array com todos os nifs / carrinhos em loja, estejam finalizados
	 * ou por finalizar
	 * 
	 * @return
	 */
	protected String[] arrayNifs() {

		String[] nifs = new String[carrinhos.size()];
		String s = "";
		for (int i = 0; i < carrinhos.size(); i++) {
			s = "" + carrinhos.get(i).getNif();
			nifs[i] = s;
			s = "";

		}
		return nifs;
	}

	protected String[] listaNifs(String nif) {

		ArrayList<String> listaT = new ArrayList<String>();
		String t = "";
		for (Carrinho c : this.carrinhos) {
			if (c.getNif().contains(nif)) {
				t = c.toString();
				listaT.add(t);

			}
			t = "";
		}
		String[] listaTitulo = new String[listaT.size()];
		listaTitulo = listaT.toArray(listaTitulo);

		return listaTitulo;
	}

	/**
	 * Devolve copia do carrinho correspondente ao nif de input
	 * 
	 * @param nif
	 * @return
	 */
	protected Carrinho pesquisarCarrinho(String nif) {

		Carrinho carrinhoNif = new Carrinho();
		for (Carrinho c : this.carrinhos) {
			if (c.getNif().equals(nif)) {
				carrinhoNif = c;
			}
		}
		return carrinhoNif;
	}

	/**
	 * Adiciona a tabela de todos os utilizadores a um modelo de tabela que ira
	 * corresponder a tabela de utilizadores
	 * 
	 * @param dtm
	 */
	protected void tabelaUtilizadores(DefaultTableModel dtm) {

		ArrayList<Utilizador> users = this.utilizadores;

		for (Utilizador u : users) {
			int id = u.getId();
			String nome = u.getNome();
			String username = u.getUsername();
			Object[] data = { id, nome, username };
			dtm.addRow(data);
		}

	}

	/**
	 * consoante a string seleccao, e o criterio de pesquisa escolhido numa comboBox
	 * devolve uma tabela que seleccione os utilizadores e os atribua ao table model
	 * consoante a necessidade
	 * 
	 * @param dtm
	 * @param criterioSeleccao
	 * @param pesquisa
	 */
	protected void tabelaUtilizadoresCriterioSeleccao(DefaultTableModel dtm, String criterioSeleccao, String pesquisa) {

		ArrayList<Utilizador> users = this.utilizadores;

		for (Utilizador u : users) {
			int id = u.getId();
			String nome = u.getNome();
			String username = u.getUsername();

			Object[] data = { id, nome, username };

			if (criterioSeleccao.equals("Id")) {
				if (Integer.toString(id).contains(pesquisa.toLowerCase())) {
					dtm.addRow(data);
				}
			}
			if (criterioSeleccao.equals("Nome")) {
				if (nome.toLowerCase().contains(pesquisa.toLowerCase())) {
					dtm.addRow(data);
				}
			}
			if (criterioSeleccao.equals("Username")) {
				if (username.toLowerCase().contains(pesquisa)) {
					dtm.addRow(data);
				}
			}

		}

	}

	/**
	 * Atribui os livros e os respectivos atibutos a uum defaulTableModel para que
	 * sejam ilustrados todos os livros e as suas caracteristicas no tipo de dados
	 * respectivo
	 * 
	 * @param dtm
	 */
	protected void livrosTabela(DefaultTableModel dtm) {

		ArrayList<Livro> livros = this.livros;

		for (Livro l : livros) {
			int id = l.getIdLivro();
			String titulo = l.getTitulo();
			String autor = l.getAutor();
			int ano = l.getAno();
			double preco = l.getPreco();

			Object[] data = { id, titulo, autor, ano, preco };
			dtm.addRow(data);
		}

	}

	/**
	 * Atribui os livros a um default table model consoante o criterio de pesquise e
	 * a pesquisa respectiva a esse criterio de modo a filtra los para quando se
	 * efectua uma escolha do comboBox de values tipo String
	 * 
	 * @param dtm
	 * @param criterioSeleccao
	 * @param pesquisa
	 */
	protected void tabelaLivrosCriterioSeleccao(DefaultTableModel dtm, String criterioSeleccao, String pesquisa) {

		ArrayList<Livro> livros = this.livros;

		for (Livro l : livros) {
			int id = l.getIdLivro();
			String titulo = l.getTitulo();
			String autor = l.getAutor();
			int ano = l.getAno();
			double preco = l.getPreco();

			Object[] data = { id, titulo, autor, ano, preco };
			if (criterioSeleccao.equals("Titulo")) {
				if (titulo.toLowerCase().contains(pesquisa.toLowerCase())) {
					dtm.addRow(data);
				}
			}
			if (criterioSeleccao.equals("Autor")) {
				if (autor.toLowerCase().contains(pesquisa.toLowerCase())) {
					dtm.addRow(data);
				}
			}
			if (criterioSeleccao.equals("Id")) {
				if (Integer.toString(id).contains(pesquisa)) {
					dtm.addRow(data);
				}
			}
			if (criterioSeleccao.equals("Ano")) {
				if (Integer.toString(ano).contains(pesquisa)) {
					dtm.addRow(data);
				}
			}

		}

	}

	/**
	 * Devolve os dados para o preenchimento da tabela dos livros mas agora
	 * filtrando por preço maximo e minimo que seram inseridos pelo utilizador
	 * 
	 * @param dtm
	 * @param criterioSeleccao
	 * @param precoMINstr
	 * @param precoMAXstr
	 */
	protected void tabelaLivrosFiltrarPreco(DefaultTableModel dtm, String criterioSeleccao, String precoMINstr,
			String precoMAXstr) {

		ArrayList<Livro> livros = this.livros;

		precoMINstr = precoMINstr.replaceAll(",", ".");
		precoMAXstr = precoMAXstr.replaceAll(",", ".");

		double precoMIN = Double.parseDouble(precoMINstr);
		double precoMAX = Double.parseDouble(precoMAXstr);

		for (Livro l : livros) {
			int id = l.getIdLivro();
			String titulo = l.getTitulo();
			String autor = l.getAutor();
			int ano = l.getAno();
			double preco = l.getPreco();

			Object[] data = { id, titulo, autor, ano, preco };
			if (criterioSeleccao.equals("Preco")) {
				if ((preco >= precoMIN) && (preco <= precoMAX)) {
					dtm.addRow(data);
				}
			}
		}

	}

	/**
	 * primeiro sao seleccionados todos os livros que estao num carrinho em
	 * especifico e depois disso os mesmos sao tabelados e tambem calculado o seu
	 * preco por tipo de livro e a sua quantidade de forma a que se possa
	 * seleccionar um carrinho e obter o seu conteudo nao so em termos de tipo de
	 * conteudo mas em peso economico e quantidade
	 * 
	 * @param car
	 * @param dtm
	 */
	protected void carrinhoTabela(Carrinho car, DefaultTableModel dtm) {

		Carrinho c = car;
		ArrayList<Livro> livrosNoCarrinho = new ArrayList<Livro>();
		HashMap<Integer, Integer> hm = c.getConteudo();
		for (Livro l : this.livros) {
			if (!c.getConteudo().isEmpty()) {
				if (c.getConteudo().containsKey(l.getIdLivro())) {
					livrosNoCarrinho.add(l);

				}
			}
		}
		for (Livro l : livrosNoCarrinho) {
			int id = l.getIdLivro();
			String titulo = l.getTitulo();
			String autor = l.getAutor();
			double preco = l.getPreco();
			int quantidade = hm.get(id);
			double precoTotal = hm.get(id) * preco;

			Object[] data = { id, titulo, autor, preco, quantidade, precoTotal };
			dtm.addRow(data);
		}

	}

	/**
	 * Altera o atributo finalizado do carrinho para true de forma a que este possa
	 * ser pago
	 * 
	 * @param car
	 */
	protected void finalizarCarrinho(Carrinho car) {
		ArrayList<Carrinho> carrinhos = this.carrinhos;

		for (Carrinho c : carrinhos) {
			if ((c == car) && (c.getConteudo() != null)) {
				c.setFinalizado(true);
				car = c;
			}
		}
		if (car.isFinalizado()) {
			JOptionPane.showMessageDialog(null,
					"O carrinho foi dado como finalizado. Dirija-se ao funcionario para proceder ao seu pagamento");
		} else if (!car.isFinalizado()) {

			JOptionPane.showMessageDialog(null,
					"Nï¿½o foi possï¿½vel finalizar o carrinho porque nï¿½o consta na base de dados ou porque ainda se encontra vazio. Confirme o nif introduzido e/ou o conteudo do respectivo carrinho.");
		}

	}

	/**
	 * devolve um array de carrinhos de estado finalizado , util para colocar na
	 * lista dos nifs/carrinhos de forma a que o funcionario possa ver que carrinhos
	 * estao finalizados e prontos para serem pagos
	 * 
	 * @return
	 */
	protected String[] carrinhosFinalizados() {
		ArrayList<Carrinho> carrinhos = this.carrinhos;
		ArrayList<String> nifCarrinhosFinalizados = new ArrayList<String>();
		String nifFinalizado = "";

		for (Carrinho c : carrinhos) {
			if (c.isFinalizado()) {
				nifFinalizado = c.getNif();
				nifCarrinhosFinalizados.add(nifFinalizado);
			}

		}
		String[] finalizados = new String[(nifCarrinhosFinalizados.size())];
		finalizados = nifCarrinhosFinalizados.toArray(finalizados);

		return finalizados;

	}

	/**
	 * devolve um array de carrinhos de estado nao finalizado , util para colocar na
	 * lista dos nifs/carrinhos de forma a que o funcionario tenha acesso
	 * 
	 * @return
	 */
	protected String[] carrinhosNAOFinalizados() {
		ArrayList<Carrinho> carrinhos = this.carrinhos;
		ArrayList<String> nifCarrinhosNAOFinalizados = new ArrayList<String>();
		String nifNAOFinalizado = "";

		for (Carrinho c : carrinhos) {
			if (!c.isFinalizado()) {
				nifNAOFinalizado = c.getNif();
				nifCarrinhosNAOFinalizados.add(nifNAOFinalizado);
			}

		}
		String[] naoFinalizados = new String[(nifCarrinhosNAOFinalizados.size())];
		naoFinalizados = nifCarrinhosNAOFinalizados.toArray(naoFinalizados);

		return naoFinalizados;

	}

// METODOS ESTATISTICA

	/**
	 * sendo a alteracao do preco do livro importante para o estudo estatistico cada
	 * vez que existe uma alteracao de preco de um livro e adicionada uma
	 * 'AlteracaoPreco' ao arraylist (historico) de todas as suas alteracoes de
	 * preco
	 * 
	 * @param idLivro
	 * @param p
	 */
	protected void updatePrecoLivro(int idLivro, Preco p) {

		for (Livro l : this.livros) {
			if (l.getIdLivro() == idLivro) {
				l.addAlteracaoPreco(p);
			}
		}
	}

	protected String devolvePrecosLivroSeleccionado(String seleccao) {
		ArrayList<Livro> livros = this.livros;
		String historicoPreco = "nao ha historico";
		for (Livro l : livros) {
			if (l.toString().equals(seleccao))
				historicoPreco = l.getPrecos().toString();
		}
		return historicoPreco;
	}

	/**
	 * Retorna o array do historico dos precos do livro selecionado
	 * 
	 * @param seleccao
	 * @return
	 */
	protected String[] precosHistoricoArray(String seleccao) {

		ArrayList<Livro> livros = this.livros;
		String preco = "";
		ArrayList<String> precosLista = new ArrayList<String>();
		Livro livroSelec = null;
		// procura o livro e passa o para a variavel livroSelec
		for (Livro l : livros) {
			if (l.toString().equals(seleccao)) {
				livroSelec = l;
			}

		}
		// passa todo o historial de precos para string enquanto o passa para um string
		// array
		for (Preco p : livroSelec.getPrecos()) {
			precosLista.add(p.toString());
		}
		String[] precosArray = new String[precosLista.size()];
		precosArray = precosLista.toArray(precosArray);

		return precosArray;

	}

	/**
	 * Traduz todas as vendas da loja para um modelo de tabela para efeitos de
	 * historial de vendas
	 * 
	 * @param dtm
	 */
	protected void tabelaVendaMontante(DefaultTableModel dtm) {
		ArrayList<Venda> vendas = this.vendas;
		for (Venda v : vendas) {
			int idVenda = v.getId();
			double montante = v.getMontante();
			LocalDate data = v.getData();
			Object[] dados = { idVenda, montante, data };
			dtm.addRow(dados);
		}
	}

	/**
	 * Sendo que as vendas da livraria possuem um conteudo de idLivro e quantidade,
	 * tal e qual como os carrinhos, e os livros teem o proprio atributo inteiro
	 * vendas Cada vez que surge uma venda o seu conteudo e percorrido e para cada
	 * livro que conste na hashmap conteudo da venda sao incrementadas as vendas
	 * desse livro atraves do metodo da classe livro incrementarVendas, tambem
	 * chamado neste metodo
	 * 
	 * @param v
	 */
	protected void incrementarVendasLivros(Venda v) {

		HashMap<Integer, Integer> venda = v.getConteudoVenda();
		// id livro , quantidade

		for (HashMap.Entry<Integer, Integer> entry : venda.entrySet()) {
			int id = entry.getKey();
			int quantidade = entry.getValue();
			for (Livro l : this.livros) {
				if (l.getIdLivro() == id) {
					l.incrementarVendas(quantidade);
				}
			}
		}

	}

	/**
	 * devolve uma tabela com os livros e o numero de vendas ate a data dos mesmos,
	 * sendo possivel ver qual o livro mais ou menos vendido
	 * 
	 * @param dtm
	 */
	protected void tabelaLivrosVendas(DefaultTableModel dtm) {

		ArrayList<Livro> livros = this.livros;

		for (Livro l : livros) {
			int id = l.getIdLivro();
			String titulo = l.getTitulo();
			int vendas = l.getVendas();
			Object[] dados = { id, titulo, vendas };
			dtm.addRow(dados);
		}

	}

	/**
	 * verifica se o ficheiro dados de pagamento existe ou nao, se existir escreve a
	 * string dados de pagamento no formato "montante numcartao pin" que é importada
	 * da caixa dos dados de pagamento
	 * 
	 * @param s
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	protected void escreveDadosPagamentoFicheiro(String s) throws ClassNotFoundException, IOException {

		File f = new File("dadosPagamento.txt");
		if (f.exists()) {
			BufferedWriter fW = new BufferedWriter(new FileWriter("dadosPagamento.txt"));
			fW.write(s);
			fW.newLine();
			fW.close();

		} else {
			f.createNewFile();
			BufferedWriter fW = new BufferedWriter(new FileWriter("dadosPagamento.txt"));
			fW.write(s);
			fW.newLine();
			fW.close();
		}

	}

	// metodo para escrever no ficheiro
	/**
	 * Verifica se o ficheiro de autorizacao escrito pelo banco apos envio dos dados
	 * de pagamento para o mesmo tem escrito AUTORIZACAO ou nao. Se estiver
	 * autorizado retorna true, se nao , falso.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	protected boolean verificaAutorizacao() throws ClassNotFoundException, IOException {

		File f = new File("Autorizacao.txt");
		BufferedReader fR = new BufferedReader(new FileReader("Autorizacao.txt"));

		String s = fR.readLine();
		System.out.println(s);

		if (s.equals("AUTORIZADO")) {
			return true;

		} else {
			return false;
		}

	}

//metodo que inicia uma thread que escreve no ficheiro e espera pela autorizacao
	/**
	 * A partir do momento que é realizado um pagamento via multibanco inicia-se uma
	 * thread que espera pela autorizacao desse pagamento durante algum tempo, se a
	 * certo ponto o pagamento for dado como autorizado pelo banco é visto pela
	 * livraria e aparece uma mensagem de aviso de autorizacao e o contador da
	 * thread e zerado assim como o ficheiro de dados de pagamento, o carrinho
	 * respectivo a esse pagamento tambem e removido da loja.
	 * 
	 * @param s
	 * @param nif
	 */
	protected void threadWaitAutorizacao(String s, String nif, double montante) {

		Carrinho c = pesquisarCarrinho(nif);
		boolean aprovado = false;

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				int counter = 50;
				try {
					escreveDadosPagamentoFicheiro(s);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while (counter-- > 0) {

					// thread espera por autorizacao durante 100
					System.out.println("wait");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try {
						if (verificaAutorizacao()) {
							JOptionPane.showMessageDialog(null, "Pagamento autorizado");
							Carrinho c = pesquisarCarrinho(nif);

							HashMap<Integer, Integer> conteudoVenda = c.getConteudo();
							Venda v = new Venda(montante, conteudoVenda, nif);
							addVenda(v);
							incrementarVendasLivros(v);
							removeCarrinho(c);
							resetFile();
							counter = 0;
						}
					} catch (HeadlessException | ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		});
		t1.start();

	}

	/**
	 * Metodo para fazer 'reset' ao ficheiro de dados , usado quando se obtem uma
	 * autorizacao
	 * 
	 * @throws IOException
	 */
	protected void resetFile() throws IOException {

		File f = new File("dadosPagamento.txt");
		BufferedWriter fW = new BufferedWriter(new FileWriter("dadosPagamento.txt"));
		fW.write("00 00 00");
		fW.newLine();
		fW.close();

	}
}
