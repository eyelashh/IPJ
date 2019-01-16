import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Banco implements Serializable {
	private int idBanco;
	private String nome;
	private int contacto;
	private String morada;
	private ArrayList<Conta> contas;
	private ArrayList<Utilizador> utilizadores;
	private ArrayList<Cartao> cartoes;
	private Validador val;

	public Banco() {
		super();
		this.utilizadores = new ArrayList<Utilizador>();
		this.contas = new ArrayList<Conta>();
		this.cartoes = new ArrayList<Cartao>();
		this.val = new Validador();
	}

	public Banco(int idBanco, String nome, int contacto, String morada, ArrayList<Conta> contas,
			ArrayList<Utilizador> utlizadores) {
		super();
		this.idBanco = idBanco;
		this.nome = nome;
		this.contacto = contacto;
		this.morada = morada;
		this.contas = new ArrayList<Conta>();
		this.utilizadores = new ArrayList<Utilizador>();
		this.cartoes = new ArrayList<Cartao>();
		this.val = new Validador();

	}

	public ArrayList<Cartao> getCartoes() {
		return cartoes;
	}

	public void setCartoes(ArrayList<Cartao> cartoes) {
		this.cartoes = cartoes;
	}

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getContacto() {
		return contacto;
	}

	public void setContacto(int contacto) {
		this.contacto = contacto;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

	public ArrayList<Utilizador> getUtlizadores() {
		return utilizadores;
	}

	public void setUtlizadores(ArrayList<Utilizador> utlizadores) {
		this.utilizadores = utlizadores;
	}

	public void run() {
		System.out.println("Run!!!");
	}

	/**
	 * @param u este metodo adiciona utilizadores
	 */
	public void addUtilizador(Utilizador u) {
		this.utilizadores.add(u);
	}

	/**
	 * @param u este metodo remove utilizadores
	 */
	public void removeUtilizador(Utilizador u) {
		this.utilizadores.remove(u);
	}

	/**
	 * @param user
	 * @param pass
	 * @return este metodo verifica se o username e a password inserida pelo
	 *         utilizador ao logar est� correcta
	 */
	public boolean verificarUserPass(String user, String pass) {

		boolean verificar = false;

		for (Utilizador u : this.utilizadores) {
			if ((pass.equals(u.getPassword())) && (user.equals(u.getUsername()))) {
				verificar = true;
			}

		}
		return verificar;
	}

	/**
	 * @param username
	 * @param password
	 * @return este metodo retorna o utilizador logado
	 */
	public Utilizador logado(String username, String password) {

		Utilizador u_log = new Utilizador();

		for (Utilizador u : this.utilizadores) {
			if ((u.getUsername().equals(username)) && (u.getPassword().equals(password))) {
				u_log = u;
			}
		}
		return u_log;
	}

	/**
	 * @param fun
	 * @return este metodo lista o id e o nome dos clientes
	 */
	protected String[] listarClientes(ArrayList<Utilizador> clt) {
		ArrayList<String> cliente = new ArrayList<String>();
		String s = "";
		for (int i = 0; i < clt.size(); i++) {
			if (clt.get(i) instanceof Cliente) {
				s = clt.get(i).getIdUtilizador() + "*" + clt.get(i).getNome();
				cliente.add(s);
			}
			s = null;
		}

		String[] clientes = new String[cliente.size()];
		clientes = cliente.toArray(clientes);

		return clientes;
	}

	/**
	 * @param cont
	 * @return este metodo lista o id de todas as contas que se encontram abertas
	 */
	protected String[] listanumerodecontasabertas(ArrayList<Conta> cont) {

		ArrayList<String> arrAxu = new ArrayList<String>();

		String s = "";
		for (int i = 0; i < cont.size(); i++) {

			if (cont.get(i).isAberta()) {
				s = "" + cont.get(i).getIdConta();
				arrAxu.add(s);
			}
		}
		String[] numcontas = new String[arrAxu.size()];
		numcontas = arrAxu.toArray(numcontas);
		return numcontas;
	}

	/**
	 * @param cont
	 * @return este metodo lista o id de todas as contas
	 */
	protected String[] listanumerodecontas(ArrayList<Conta> cont) {
		String[] numcontas = new String[cont.size()];
		String s = "";
		for (int i = 0; i < cont.size(); i++) {

			s = "" + cont.get(i).getIdConta();
			numcontas[i] = s;
			s = "";

		}
		return numcontas;
	}

	/**
	 * @param idCliente
	 * @return este metodo lista o id de todas as contas associadas ao id cliente
	 */
	protected String[] listaContasIdCliente(String idCliente) {

		ArrayList<Utilizador> utilizadores = this.utilizadores;
		ArrayList<Integer> idcontasClienteINT = new ArrayList<Integer>();
		ArrayList<String> idContasClienteSTR = new ArrayList<String>();

		Cliente c = null;
		for (Utilizador u : utilizadores) {
			String idSTR = Integer.toString(u.getIdUtilizador());
			if ((idSTR.contains(idCliente)) && (u instanceof Cliente)) {
				c = (Cliente) u;
				idcontasClienteINT = c.getContas();
			}
		}
		for (int id : idcontasClienteINT) {

			String idSTR = Integer.toString(id);
			idContasClienteSTR.add(idSTR);
		}
		String[] contasCliente = new String[idContasClienteSTR.size()];
		contasCliente = idContasClienteSTR.toArray(contasCliente);

		return contasCliente;

	}

	/**
	 * @param c
	 * @param contas
	 * @return este metodo lista as contas de um determinado cliente
	 */
	protected String[] listacontadecliente(Cliente c, ArrayList<Conta> contas) {
		ArrayList<String> listprov = new ArrayList<String>();
		String s = "";
		for (int i = 0; i < contas.size(); i++) {
			for (int x = 0; x < c.getContas().size(); x++) {
				if (contas.get(i).getIdConta() == c.getContas().get(x)) {
					s = c.getContas().get(x) + "";
					listprov.add(s);
				}
			}
		}
		if (c.getContapoupanca() != 0) {
			listprov.add(c.getContapoupanca() + "");
		}
		String[] lista = new String[listprov.size()];
		lista = listprov.toArray(lista);
		return lista;
	}

	/**
	 * @param c
	 * @param contas
	 * @return este metodo lista todas as contas a ordem de um determinado cliente
	 */
	protected String[] listacontasordem(Cliente c, ArrayList<Conta> contas) {

		ArrayList<String> listprov = new ArrayList<String>();

		for (int i = 0; i < contas.size(); i++) {
			for (int j = 0; j < c.getContas().size(); j++) {
				if ((contas.get(i) instanceof ContaCorrente) && (contas.get(i).isAberta() == true)
						&& (contas.get(i).getIdConta() == c.getContas().get(j))) {
					listprov.add(c.getContas().get(j) + "");
				}
			}
		}

		String[] lista = new String[listprov.size()];
		lista = listprov.toArray(lista);
		return lista;
	}

	/**
	 * @param c
	 * @param contas
	 * @returneste metodo lista todas as contas poupanca de um determinado cliente
	 */
	protected String[] listacontaspoupanca(Cliente c, ArrayList<Conta> contas) {

		ArrayList<String> listprov = new ArrayList<String>();

		for (int i = 0; i < contas.size(); i++) {
			for (int j = 0; j < c.getContas().size(); j++) {
				if ((contas.get(i) instanceof ContaPoupanca) && (contas.get(i).isAberta())
						&& (contas.get(i).getIdConta() == c.getContapoupanca())) {
					String idSTR = Integer.toString(((ContaPoupanca) contas.get(i)).getIdConta());
					listprov.add(idSTR);
				}
			}
		}

		String[] lista = new String[listprov.size()];
		lista = listprov.toArray(lista);
		return lista;
	}

	/**
	 * @return este metodo lista todas as contas poupanca
	 */
	protected String[] listaContasPoupanca() {

		ArrayList<String> idsContaPoupanca = new ArrayList<String>();

		for (int i = 0; i < this.contas.size(); i++) {

			if ((contas.get(i) instanceof ContaPoupanca)) {
				String idSTR = Integer.toString(((ContaPoupanca) contas.get(i)).getIdConta());
				idsContaPoupanca.add(idSTR);
			}
		}
		String[] contasP = new String[idsContaPoupanca.size()];
		contasP = idsContaPoupanca.toArray(contasP);

		return contasP;
	}

	/**
	 * @returneste metodo lista todas as contas a ordem
	 */
	protected String[] listaContasCorrente() {

		ArrayList<String> idsContasCorrente = new ArrayList<String>();

		for (int i = 0; i < this.contas.size(); i++) {

			if ((contas.get(i) instanceof ContaCorrente) && contas.get(i).isAberta() == true) {
				String idSTR = Integer.toString(((ContaCorrente) contas.get(i)).getIdConta());
				idsContasCorrente.add(idSTR);
			}
		}
		String[] contasCorrente = new String[idsContasCorrente.size()];
		contasCorrente = idsContasCorrente.toArray(contasCorrente);

		return contasCorrente;
	}

	/**
	 * @param fun
	 * @return este metodo lista todos os funcionario com o seu id e nome
	 */
	protected String[] listaFunceAdm(ArrayList<Utilizador> fun) {
		ArrayList<String> func = new ArrayList<String>();
		String f = "";

		for (int i = 0; i < fun.size(); i++) {
			if (fun.get(i) instanceof Funcionario || fun.get(i) instanceof Administrador) {
				f = fun.get(i).getIdUtilizador() + " " + fun.get(i).getNome();
				func.add(f);
			}
			f = null;
		}

		String[] funcionario = new String[func.size() + 1];
		funcionario = func.toArray(funcionario);

		return funcionario;
	}

	/**
	 * @param numUtil
	 * @param list
	 * @return este metodo retorna o utilizador recebendo o seu id
	 */
	protected Utilizador selectUtilizador(int numUtil, ArrayList<Utilizador> list) {
		Utilizador u = new Utilizador();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdUtilizador() == numUtil) {
				u = list.get(i);
			}
		}
		return u;
	}

	/**
	 * @param nome
	 * @param list
	 * @return este metodo retorna o utilizador recebendo o seu nome
	 */
	protected Utilizador selectUtilizadorNome(String nome, ArrayList<Utilizador> list) {
		Utilizador u = new Utilizador();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNome().equals(nome)) {
				u = list.get(i);
			}
		}
		return u;
	}

	/**
	 * @param s
	 * @return este metodo retorna o id de um utilizador recebendo uma string
	 */
	protected int obterId(String s) {

		int id = 0;
		if (s != null) {
			for (Utilizador l : this.utilizadores) {
				if (s.equals(l.toString())) {
					id = l.getIdUtilizador();
				}
			}
		}
		return id;

	}

	/**
	 * @param numconta
	 * @param contas
	 * @return este metodo retorna a conta recebendo o id da conta
	 */
	protected Conta SelectConta(int numconta, ArrayList<Conta> contas) {
		Conta c = new Conta();

		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getIdConta() == numconta) {
				c = contas.get(i);
			}
		}
		return c;
	}

	/**
	 * @param idCliente
	 * @param contas
	 * @return este metodo retorna a conta de um cliente
	 */
	protected Conta selectContaCliente(ArrayList<Integer> idCliente, ArrayList<Conta> contas) {
		Conta c = new Conta();

		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getClientes() == idCliente) {
				c = contas.get(i);
			}
		}
		return c;
	}

	/**
	 * @param s
	 * @param dm este metodo recebe o modelo da lista e o array e adiciona os
	 *           elementos a lista
	 */
	protected void addelementoslist(String[] s, DefaultListModel<String> dm) {
		for (int i = 0; i < s.length; i++) {
			dm.addElement(s[i]);

		}
	}

	/**
	 * @param s
	 * @param dm este metodo receb o modelo da combobox e o array e adiciona os
	 *           elementos a combobox
	 */
	protected void addelementoslist(String[] s, DefaultComboBoxModel<String> dm) {
		for (int i = 0; i < s.length; i++) {
			dm.addElement(s[i]);

		}
	}

	/**
	 * @param id
	 * @param utilizador
	 * @param contas     este metodo elimina um determinado utilizador recebendo o
	 *                   seu id
	 */
	protected void eliminautilizador(int id, ArrayList<Utilizador> utilizador, ArrayList<Conta> contas) {

		Integer remove = 0;
		for (int x = 0; x < contas.size(); x++) {
			for (int y = 0; y < contas.get(x).getClientes().size(); y++) {
				if (contas.get(x).getClientes().get(y) == id) {
					remove = id;
					contas.get(x).getClientes().remove(remove);
				}
			}

		}

		for (int i = 0; i < utilizador.size(); i++) {
			if (utilizador.get(i).getIdUtilizador() == id) {
				utilizador.remove(i);
			}

		}
	}

	/**
	 * @param f
	 * @param nome
	 * @param sobrenome
	 * @param dataDeNascimento
	 * @param tipoIndentificacao
	 * @param numidentificacao
	 * @param morada
	 * @param contacto
	 * @param username
	 * @param password           este metodo atualiza os dados do funcionario
	 */
	protected void actualizaFun(Funcionario f, String nome, String sobrenome, Date dataDeNascimento,
			String tipoIndentificacao, int numidentificacao, String morada, int contacto, String username,
			String password) {

		f.setNome(nome);
		f.setSobrenome(sobrenome);
		f.setDataDeNascimento(dataDeNascimento);
		f.setTipoIndentificacao(tipoIndentificacao);
		f.setNumidentificacao(numidentificacao);
		f.setMorada(morada);
		f.setContacto(contacto);
		f.setUsername(username);
		f.setPassword(password);

	}

	/**
	 * @param adm
	 * @param nome
	 * @param sobrenome
	 * @param dataDeNascimento
	 * @param tipoIndentificacao
	 * @param numidentificacao
	 * @param morada
	 * @param contacto
	 * @param username
	 * @param password           este metodo atualiza os dados do administrador
	 */
	protected void actualizaAdmin(Administrador adm, String nome, String sobrenome, Date dataDeNascimento,
			String tipoIndentificacao, int numidentificacao, String morada, int contacto, String username,
			String password) {

		adm.setNome(nome);
		adm.setSobrenome(sobrenome);
		adm.setDataDeNascimento(dataDeNascimento);
		adm.setTipoIndentificacao(tipoIndentificacao);
		adm.setNumidentificacao(numidentificacao);
		adm.setMorada(morada);
		adm.setContacto(contacto);
		adm.setUsername(username);
		adm.setPassword(password);

	}

	/**
	 * @param c
	 * @param nome
	 * @param sobrenome
	 * @param dataDeNascimento
	 * @param tipoIndentificacao
	 * @param numidentificacao
	 * @param morada
	 * @param contacto
	 * @param username
	 * @param password           este metodo atualiza os dados do cliente
	 */
	protected void atualizacliente(Cliente c, String nome, String sobrenome, Date dataDeNascimento,
			String tipoIndentificacao, int numidentificacao, String morada, int contacto, String username,
			String password) {

		c.setNome(nome);
		c.setSobrenome(sobrenome);
		c.setDataDeNascimento(dataDeNascimento);
		c.setTipoIndentificacao(tipoIndentificacao);
		c.setNumidentificacao(numidentificacao);
		c.setMorada(morada);
		c.setContacto(contacto);
		c.setUsername(username);
		c.setPassword(password);
	}

	/**
	 * @param c
	 * @param valorMaxLevantamento
	 * @param valorMaxDia
	 * @param taxaJuros
	 * @param limiteMensalDebito   este metodo atualiza os dados da conta
	 */
	protected void atualizarconta(Conta c, double valorMaxLevantamento, double valorMaxDia, double taxaJuros,
			double limiteMensalDebito) {
		c.setValorMaxLevantamento(valorMaxLevantamento);
		c.setValorMaxDia(valorMaxDia);

		if (c instanceof ContaPoupanca) {
			((ContaPoupanca) c).setTaxaJuros(taxaJuros);
			((ContaPoupanca) c).setLimiteMensalDebito(limiteMensalDebito);

		}

	}

	// elimina contas:
	/**
	 * @param id
	 * @param datafecho
	 * @param contas    este metodo elimina a conta recebendo um id e coloca essa
	 *                  contada fechada, com o saldo nulo e com a sua data de fecho
	 */
	protected void eliminaconta(int id, Date datafecho, ArrayList<Conta> contas) {
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getIdConta() == id) {
				contas.get(i).setAberta(false);
				contas.get(i).setSaldo(0);
				contas.get(i).setDataFecho(datafecho);

			}
		}
	}

	/**
	 * @param model
	 * @param clientes este metodo preenche a tabela com uma checklist o id do
	 *                 cliente e o seu nome recebendo o modelo da tabela
	 */
	protected void preenchetabelaclientes(DefaultTableModel model, ArrayList<Utilizador> clientes) {
		int id = 0;
		String nome;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i) instanceof Cliente) {
				id = clientes.get(i).getIdUtilizador();
				nome = clientes.get(i).getNome();
				model.addRow(new Object[] { false, id, nome });

			}
		}
	}

	// preenche tabela conta na estatistica:
	/**
	 * @param model
	 * @param contas
	 * @param data1
	 * @param data2  este metodo preenche a tabela da estatistica com o id da conta,
	 *               a data de criacao, a data de fecho, o saldo da conta e o estado
	 *               da conta, recebendo o modelo da tabela
	 */
	protected void preenchetabelaContaEstatistica(DefaultTableModel model, ArrayList<Conta> contas, Date data1,
			Date data2) {
		int idConta = 0;
		Date dataCriacao;
		Date dataFecho;
		Double saldo;
		boolean estadoConta;

		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getDataCriacao().after(data1) && contas.get(i).getDataCriacao().before(data2)) {

				idConta = contas.get(i).getIdConta();
				dataCriacao = contas.get(i).getDataCriacao();
				dataFecho = contas.get(i).getDataFecho();
				saldo = contas.get(i).getSaldo();
				estadoConta = contas.get(i).isAberta();

				model.addRow(new Object[] { idConta, dataCriacao, dataFecho, saldo, estadoConta });
			}
		}
	}

	/**
	 * @param contas
	 * @param data1
	 * @param data2
	 * @return este metodo retorna a quantidade de contas abertas que existem entre
	 *         duas datas inseridas pelo utilizador para dados estatisticos
	 */
	protected int numeroContasAbertas(ArrayList<Conta> contas, Date data1, Date data2) {

		int cont = 0;

		for (int i = 0; i < contas.size(); i++) {
			if ((contas.get(i).getDataCriacao().after(data1) && contas.get(i).getDataCriacao().before(data2))
					&& contas.get(i).isAberta() == true) {
				cont++;
			}
		}
		return cont;
	}

	/**
	 * @param contas
	 * @param data1
	 * @param data2
	 * @return este metodo retorna a quantidade de contas fechadas que existem entre
	 *         duas datas inseridas pelo utilizador para dados estatisticos
	 */
	protected int numeroContasFechadas(ArrayList<Conta> contas, Date data1, Date data2) {

		int cont = 0;

		for (int i = 0; i < contas.size(); i++) {
			if ((contas.get(i).getDataCriacao().after(data1) && contas.get(i).getDataCriacao().before(data2))
					&& contas.get(i).isAberta() == false) {
				cont++;
			}
		}
		return cont;
	}

	/**
	 * @param contas
	 * @param data1
	 * @param data2
	 * @return este metodo retorna o total de capital entre duas datas inseridas
	 *         pelo utilizador para dados estatisticos
	 */
	protected int totalCapital(ArrayList<Conta> contas, Date data1, Date data2) {

		int soma = 0;

		for (int i = 0; i < contas.size(); i++) {
			if ((contas.get(i).getDataCriacao().after(data1) && contas.get(i).getDataCriacao().before(data2))) {

				soma += contas.get(i).getSaldo();

			}
		}
		return soma;
	}

	/**
	 * @param contas
	 * @param data1
	 * @param data2
	 * @return este metodo retorna a soma total dos levantamento entre duas datas
	 *         inseridas pelo utilizador para fazer o balanco para os dados
	 *         estatisticos
	 */
	protected double somaLevant(ArrayList<Conta> contas, Date data1, Date data2) {

		double soma = 0;

		for (int i = 0; i < contas.size(); i++) {
			for (int j = 0; j < contas.get(i).getOperacoes().size(); j++) {

				if ((contas.get(i).getDataCriacao().after(data1) && contas.get(i).getDataCriacao().before(data2))
						&& contas.get(i).isAberta() == true
						&& contas.get(i).getOperacoes().get(j) instanceof Levantamento) {

					soma += ((Levantamento) contas.get(i).getOperacoes().get(j)).getValor();

				}

			}
		}
		return soma;
	}

	/**
	 * @param contas
	 * @param data1
	 * @param data2
	 * @return este metodo retorna a soma total dos depositos entre duas datas
	 *         inseridas pelo utilizador para fazer o balanco para os dados
	 *         estatisticos
	 */
	protected double somaDepo(ArrayList<Conta> contas, Date data1, Date data2) {

		double soma2 = 0;

		for (int i = 0; i < contas.size(); i++) {
			for (int j = 0; j < contas.get(i).getOperacoes().size(); j++) {

				if ((contas.get(i).getDataCriacao().after(data1) && contas.get(i).getDataCriacao().before(data2))
						&& contas.get(i).isAberta() == true
						&& contas.get(i).getOperacoes().get(j) instanceof Deposito) {

					soma2 += ((Deposito) contas.get(i).getOperacoes().get(j)).getValor();

				}

			}
		}
		return soma2;
	}

	/**
	 * @param contas
	 * @param data1
	 * @param data2
	 * @return este metodo retorna o balanco entre duas datas inseridas pelo
	 *         utilizador para os dados estatisticos
	 */
	protected double balanco(ArrayList<Conta> contas, Date data1, Date data2) {

		double balanco = 0;

		for (int i = 0; i < contas.size(); i++) {
			for (int j = 0; j < contas.get(i).getOperacoes().size(); j++) {

				if ((contas.get(i).getDataCriacao().after(data1) && contas.get(i).getDataCriacao().before(data2))
						&& contas.get(i).isAberta() == true) {

					balanco = this.somaDepo(getContas(), data1, data2) - this.somaLevant(getContas(), data1, data2);

				}

			}
		}
		return balanco;
	}

	/**
	 * @param model
	 * @param clientes este metodo preenche a tabela cliente com os seu ide e nome
	 *                 recebendo o modelo da tabela
	 */
	protected void preenchetabelaclientes2(DefaultTableModel model, ArrayList<Utilizador> clientes) {
		int id = 0;
		String nome;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i) instanceof Cliente) {
				id = clientes.get(i).getIdUtilizador();
				nome = clientes.get(i).getNome();
				model.addRow(new Object[] { id, nome });

			}
		}
	}

	/**
	 * @param nomeCliente
	 * @return este metodo retorna uma lista dos cliente recebendo o nome do cliente
	 */
	protected String[] listaClientesNome(String nomeCliente) {

		ArrayList<Utilizador> util = this.utilizadores;
		ArrayList<String> utilNome = new ArrayList<String>();
		String cliente = "";

		for (Utilizador c : util) {
			String nome = c.getNome();
			if ((nome.toLowerCase().contains(nomeCliente.toLowerCase())) && (c instanceof Cliente)) {
				cliente = "" + c.getIdUtilizador() + "*" + c.getNome();
				utilNome.add(cliente);
			}
		}

		String[] clientesNome = new String[utilNome.size()];
		clientesNome = utilNome.toArray(clientesNome);

		return clientesNome;
	}

	// preenche tabela clientes no cliente pelo nome:
	/**
	 * @param model
	 * @param nome  este metodo preenche a tabela
	 */
	protected void preenchetabelaclientesNome(DefaultTableModel model, String nome) {
		int id = 0;

		for (int i = 0; i < utilizadores.size(); i++) {
			String nomeCliente = utilizadores.get(i).getNome();
			if ((nomeCliente.toLowerCase().contains(nome.toLowerCase())) && (utilizadores.get(i) instanceof Cliente)) {

				id = utilizadores.get(i).getIdUtilizador();

				model.addRow(new Object[] { id, nomeCliente });

			}
		}
	}

	// preenche tabela clientes no cliente pelo id:
	/**
	 * @param model
	 * @param idCliente este metedo foi criado para seja preenchido a tabela com
	 *                  cliente com id que foi dado como parametro.
	 */
	protected void preenchetabelaclientesID(DefaultTableModel model, int idCliente) {
		int id = 0;
		String cliente;
		for (int i = 0; i < utilizadores.size(); i++) {
			if ((utilizadores.get(i).getIdUtilizador() == idCliente) && (utilizadores.get(i) instanceof Cliente)) {

				id = utilizadores.get(i).getIdUtilizador();
				cliente = utilizadores.get(i).getNome();
				model.addRow(new Object[] { id, cliente });

			}
		}
	}

	// preenche tabela operaçoes no cliente:
	/**
	 * @param model
	 * @param c     preenche tabela opera�oes correnspondente a uma conta c
	 */
	protected void preenchetabelaOperacoesTransferencia(DefaultTableModel model, Conta c) {

		for (int i = 0; i < contas.size(); i++) {

			for (int j = 0; j < contas.get(i).getOperacoes().size(); j++) {

				if ((contas.get(i).getIdConta() == c.getIdConta())
						&& contas.get(i).getOperacoes().get(j) instanceof Transferencia) {
					String tipo = "Transferencia";
					int id = contas.get(i).getOperacoes().get(j).getIdOperacao();
					Funcionario resp = contas.get(i).getOperacoes().get(j).getResponsavel();
					Date data = contas.get(i).getOperacoes().get(j).getDataOperacao();
					Double valor = contas.get(i).getOperacoes().get(j).getValor();
					int contadestino = ((Transferencia) contas.get(i).getOperacoes().get(j)).getcontatransf()
							.getIdConta();
					Cliente clt = ((Transferencia) contas.get(i).getOperacoes().get(j)).getClt();

					Object[] texto = { id, tipo, resp, data, valor, contadestino, clt };
					model.addRow(texto);

				}

			}
		}

	}

	// vai buscar a descricao
	/**
	 * @param idOperacao
	 * @return
	 * 
	 * 		devolte a descricao de uma operacao.
	 */
	protected String descricaoOpercacoes(int idOperacao) {

		String desc = "";

		for (int i = 0; i < contas.size(); i++) {

			for (int j = 0; j < contas.get(i).getOperacoes().size(); j++) {

				if (contas.get(i).getOperacoes().get(j).getIdOperacao() == idOperacao) {

					desc = contas.get(i).getOperacoes().get(j).getDescricao();

				}
			}

		}
		return desc;

	}

	// preenche tabela operaçoes no cliente:
	/**
	 * @param model
	 * @param c
	 * 
	 *              preenche uma tabela filtrando apenas os depositos
	 */
	protected void preenchetabelaOperacoesDeposito(DefaultTableModel model, Conta c) {

		for (int i = 0; i < contas.size(); i++) {

			for (int j = 0; j < contas.get(i).getOperacoes().size(); j++) {

				if ((contas.get(i).getIdConta() == c.getIdConta())
						&& contas.get(i).getOperacoes().get(j) instanceof Deposito) {
					String tipo = "Deposito";
					int id = contas.get(i).getOperacoes().get(j).getIdOperacao();
					Funcionario resp = contas.get(i).getOperacoes().get(j).getResponsavel();
					Date data = contas.get(i).getOperacoes().get(j).getDataOperacao();
					Double valor = contas.get(i).getOperacoes().get(j).getValor();

					Object[] texto = { id, tipo, resp, data, valor, null, null };
					model.addRow(texto);
				}

			}
		}

	}

	// preenche tabela operaçoes no cliente:
	/**
	 * @param model
	 * @param c     preenche uma tabela filtrando apenas os levantamentos
	 */
	protected void preenchetabelaOperacoesLevantamento(DefaultTableModel model, Conta c) {

		for (int i = 0; i < contas.size(); i++) {

			for (int j = 0; j < contas.get(i).getOperacoes().size(); j++) {

				if ((contas.get(i).getIdConta() == c.getIdConta())
						&& contas.get(i).getOperacoes().get(j) instanceof Levantamento) {
					String tipo = "Levantamento";
					int id = contas.get(i).getOperacoes().get(j).getIdOperacao();
					Funcionario resp = contas.get(i).getOperacoes().get(j).getResponsavel();
					Date data = contas.get(i).getOperacoes().get(j).getDataOperacao();
					Double valor = contas.get(i).getOperacoes().get(j).getValor();

					Object[] texto = { id, tipo, resp, data, valor, null, null };
					model.addRow(texto);

				}

			}
		}

	}

	/**
	 * @param model
	 * @param c     preenche uma tabela filtrando apenas os pagamentos
	 */
	protected void preenchetabelaOperacoesPagamento(DefaultTableModel model, Conta c) {

		for (int i = 0; i < contas.size(); i++) {

			for (int j = 0; j < contas.get(i).getOperacoes().size(); j++) {

				if ((contas.get(i).getIdConta() == c.getIdConta())
						&& contas.get(i).getOperacoes().get(j) instanceof Pagamento) {
					String tipo = "Pagamento";
					int id = contas.get(i).getOperacoes().get(j).getIdOperacao();
					Date data = contas.get(i).getOperacoes().get(j).getDataOperacao();
					Double valor = contas.get(i).getOperacoes().get(j).getValor();

					Object[] texto = { id, tipo, null, data, valor, null, null };
					model.addRow(texto);

				}

			}
		}

	}

	/**
	 * @param model
	 * @param c     preenche uma tabela com todas as opera�oes
	 */
	protected void preenchetabelaOperacoesTodas(DefaultTableModel model, int idConta) {

		ArrayList<Conta> contas = this.contas;

		for (int i = 0; i < contas.size(); i++) {

			if (contas.get(i).getIdConta() == idConta) {

				for (int j = 0; j < contas.get(i).getOperacoes().size(); j++) {

					Operacao o = contas.get(i).getOperacoes().get(j);
					int id = o.getIdOperacao();
					Funcionario resp = o.getResponsavel();
					double valor = o.getValor();
					Date data = o.getDataOperacao();
					String tipo = "";
					Cliente cliente = null;
					int contaDestino = 0;

					if (o instanceof Levantamento) {
						tipo = "Levantamento";

					} else if (o instanceof Deposito) {
						tipo = "Deposito";

					} else if (o instanceof Transferencia) {
						tipo = "Transferencia";
						cliente = ((Transferencia) o).getClt();
						contaDestino = ((Transferencia) o).getcontatransf().getIdConta();

					} else if (o instanceof Pagamento) {
						tipo = "Pagamento";
					}

					Object[] dados = { id, tipo, resp, data, valor, contaDestino, cliente };
					model.addRow(dados);

				}
			}

		}
	}

	// lista das operacoes
	/**
	 * @param idConta
	 * @param contas
	 * @return constroi um array de string que depois � lido pelas jlist
	 */
	protected String[] arrayOperacoes(ArrayList<Integer> idConta, ArrayList<Conta> contas) {

		ArrayList<String> operacoes = new ArrayList<String>();
		String o = "";

		for (int i = 0; i < contas.size(); i++) {
			if ((contas.get(i) instanceof ContaCorrente) && (idConta.contains(contas.get(i).getIdConta()))) {
				o = contas.get(i).getOperacoes().toString();
				operacoes.add(o);
			}
			o = null;
		}

		String[] op = new String[operacoes.size() + 1];
		op = operacoes.toArray(op);
		return op;
	}

	// remove todas as linhas da tabela:
	protected void limpatabela(DefaultTableModel model) {
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}

	// atribuir cliente a conta e conta ao cliente;
	/**
	 * @param model
	 * @param c
	 * @param clientes metedo para atribuir titulares a uma conta corrente.
	 */
	protected void atruibuititularCCorrente(DefaultTableModel model, Conta c, ArrayList<Utilizador> clientes) {
		Utilizador clt;
		Integer idconta;
		Integer idclt;

		for (int i = 0; i < model.getRowCount(); i++) {
			if ((Boolean) model.getValueAt(i, 0) == true) {
				clt = this.selectUtilizador((int) model.getValueAt(i, 1), clientes);
				if (clt instanceof Cliente) {
					// c.getClientes().add(clt.getIdUtilizador());
					// if (c instanceof ContaCorrente) {
					idconta = c.getIdConta();
					idclt = clt.getIdUtilizador();
					((Cliente) clt).getContas().add(idconta);
					c.getClientes().add(idclt);
					// }
				}
			}
		}
	}

	/**
	 * @param model
	 * @param c
	 * @param clientes metedo para atribuir titulares a uma conta poupanca.
	 */
	protected void atruibuititularCPoupanca(DefaultTableModel model, Conta c, ArrayList<Utilizador> clientes) {
		Utilizador clt;
		for (int i = 0; i < model.getRowCount(); i++) {
			if ((Boolean) model.getValueAt(i, 0) == true) {
				clt = this.selectUtilizador((int) model.getValueAt(i, 1), clientes);
				{
					if (clt instanceof Cliente) {
						if (((Cliente) clt).getContapoupanca() == 0) {
							((Cliente) clt).setContapoupanca(c.getIdConta());
							c.getClientes().add(clt.getIdUtilizador());
						} else {
							JOptionPane.showMessageDialog(null, "O/A cliente " + clt.getNome()
									+ " ja tem uma conta poupan�a neste banco. Nao sera adicionado como titular!");
						}
					}
				}
			}
		}
	}

	// faz "Check" true aos clientes que sao titulares da conta selecionada:
	/**
	 * @param c
	 * @param model preenche o modelo de lista dos titulares de determinada conta.
	 */
	protected void mostratitulares(Conta c, DefaultTableModel model) {
		int idclt = 0;
		int idtabela = 0;
		for (int x = 0; x < c.getClientes().size(); x++) {
			idclt = c.getClientes().get(x);
			for (int i = 0; i < model.getRowCount(); i++) {
				idtabela = (int) model.getValueAt(i, 1);
				if (idtabela == idclt) {
					model.setValueAt(true, i, 0);
				}
			}
		}

	}

	// Elimina todas as contas nos clientes:
	/**
	 * @param clientes
	 * @param c        metedo para remover uma conta dentro de um cliente
	 */
	protected void eliminacontaemcliente(ArrayList<Utilizador> clientes, Conta c) {
		// remover id de contas dentro dos clientes:
		Integer idconta = c.getIdConta();
		Integer id = 0;

		for (int i = 0; i < clientes.size(); i++) {

			if (clientes.get(i) instanceof Cliente) {
				for (int x = 0; x < ((Cliente) clientes.get(i)).getContas().size(); x++) {

					if (c instanceof ContaCorrente) {
						if (((Cliente) clientes.get(i)).getContas().get(x) == idconta) {
							((Cliente) clientes.get(i)).getContas().remove(idconta);
							id = ((Cliente) clientes.get(i)).getIdUtilizador();
							c.getClientes().remove(id);
						}
					} else {
						if (((Cliente) clientes.get(i)).getContapoupanca() == idconta) {
							((Cliente) clientes.get(i)).setContapoupanca(0);
							id = ((Cliente) clientes.get(i)).getIdUtilizador();
							c.getClientes().remove(id);
						}
					}
				}
			}
		}

	}

	// retorna o cartao
	/**
	 * @param cartoes
	 * @param id
	 * @return cartao que serve para receber informa�ao de uma cartao selecionado
	 *         por id.
	 */
	protected Cartao obterCartao(ArrayList<Cartao> cartoes, int id) {

		Cartao card = new Cartao();

		if (cartoes.size() != 0) {

			for (int j = 0; j < cartoes.size(); j++) {
				if (cartoes.get(j).getnCartao() == id) {

					card = cartoes.get(j);

				}
			}

		}

		return card;

	}

	// cria um cartão

	/**
	 * @param idConta
	 * @param card
	 * @param c       cria um cartao para uma conta
	 */
	public void criaCartao(int idConta, Cartao card, Conta c) {
		int i = 0;

		for (i = 0; i < contas.size(); i++) {
			if ((contas.get(i) instanceof ContaCorrente)) {

				this.cartoes.add(card);
				((ContaCorrente) c).setCartao(card.getnCartao());

			}
		}
	}

	// retorna a conta atraves do seu numero
	/**
	 * @param numConta
	 * @return cria um array de contas abertas para ser lido numa jlist
	 */
	protected String[] listaContasNumContaAbertas(String numConta) {

		ArrayList<Conta> contas = this.contas;
		ArrayList<String> contaNum = new ArrayList<String>();

		for (Conta c : contas) {
			String numContaSTR = Integer.toString(c.getIdConta());
			if (numContaSTR.contains(numConta) && c.isAberta() == true) {
				contaNum.add(numContaSTR);
			}
		}

		String[] contaId = new String[contaNum.size()];
		contaId = contaNum.toArray(contaId);

		return contaId;
	}

	/**
	 * @param idCliente
	 * @return devolve o um array para criar a jlist por id.
	 */
	protected String[] listaClientesID(String idCliente) {

		ArrayList<Utilizador> util = this.utilizadores;
		ArrayList<String> utilId = new ArrayList<String>();
		String cliente = "";

		for (Utilizador u : util) {
			String idSTR = Integer.toString(u.getIdUtilizador());
			if ((idSTR.contains(idCliente)) && (u instanceof Cliente)) {
				cliente = "" + u.getIdUtilizador() + "*" + u.getNome() + " " + u.getSobrenome();
				utilId.add(cliente);
			}
		}

		String[] clientesID = new String[utilId.size()];
		clientesID = utilId.toArray(clientesID);

		return clientesID;
	}

	// metedo que confirma se a conta existe (usado nas opera�oes)
	/**
	 * @param dcbm
	 * @param id
	 * @return verifica se existe ou nao a conta selecionada.
	 */
	protected boolean existeconta(DefaultComboBoxModel<String> dcbm, int id) {
		boolean existe = false;

		for (int i = 0; i < dcbm.getSize(); i++) {
			if (dcbm.getElementAt(i).equals(id + "")) {
				existe = true;
			}
		}

		return existe;
	}

	/**
	 * @param contasp metedo que serve para aplicar juros nas contas poupanca
	 */
	protected void pagajuros(ArrayList<Conta> contasp) {
		LocalDate localDate = LocalDate.now();
		Date agora = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		Validador val = new Validador();

		for (int i = 0; i < contasp.size(); i++) {
			if (contasp.get(i) instanceof ContaPoupanca) {
				if (!((ContaPoupanca) contasp.get(i)).getPagajuros().after(agora)) {
					// faz aumento de juros
					// cria operacao
					// altera�ao da data de juros
					// 1:
					double jurosdeposito = (contasp.get(i).getSaldo() * ((ContaPoupanca) contasp.get(i)).getTaxaJuros())
							/ 100;
					contasp.get(i).setSaldo(contasp.get(i).getSaldo() + jurosdeposito);
					// 2:
					Operacao op = new Deposito(val.validoperacoes(contasp.get(i).getOperacoes()), null, agora,
							jurosdeposito, "Pagamento de juros no valor de: " + jurosdeposito);
					contasp.get(i).getOperacoes().add(op);
					// 3:
					Calendar cal = Calendar.getInstance();
					cal.setTime(((ContaPoupanca) contasp.get(i)).getPagajuros());
					cal.add(Calendar.YEAR, 1);
					((ContaPoupanca) contasp.get(i)).setPagajuros(cal.getTime());
				}

			}
		}
	}

	/**
	 * @param c
	 * @param levantamento
	 * @param func
	 * @param data         metedo que valida autoriza�ao de pagamentos por
	 *                     dia/opera�ao e mes.
	 */
	protected void maxlevantamentoOperacaoDiaMes(Conta c, double levantamento, Funcionario func, Date data) {

		Validador val = new Validador();
		double valortotaldia = 0;
		double valortotalmes = 0;
		String desc = data + " - Levantamento no valor de " + levantamento;

		if (c.getSaldo() >= levantamento) {

			if (levantamento <= c.getValorMaxLevantamento()) {

				for (int i = 0; i < c.getOperacoes().size(); i++) {

					if (c.getOperacoes().get(i) instanceof Levantamento) {

						if (c.getOperacoes().get(i).getDataOperacao().equals(data)) {

							valortotaldia = valortotaldia + c.getOperacoes().get(i).getValor();
						}
					}
				}

				if (c.getValorMaxDia() >= valortotaldia + levantamento) {
					if (c instanceof ContaCorrente) {

						Operacao lev = new Levantamento(val.validoperacoes(c.getOperacoes()), func, data, levantamento,
								desc);

						c.getOperacoes().add(lev);
						c.setSaldo(c.getSaldo() - levantamento);

						JOptionPane.showMessageDialog(null,
								"Levantamento efectuado com sucesso!!! Hoje ainda pode levantar "
										+ ((valortotaldia + levantamento) - c.getValorMaxDia()));
					}
					//

					if (c instanceof ContaPoupanca) {

						for (int i = 0; i < c.getOperacoes().size(); i++) {

							if (c.getOperacoes().get(i) instanceof Levantamento) {

								// retiro o mes e o anor da data introduzida pelo utilizador
								LocalDate dataIntroduzida = data.toInstant().atZone(ZoneId.systemDefault())
										.toLocalDate();
								int mes = dataIntroduzida.getMonthValue();
								int ano = dataIntroduzida.getYear();

								// retiro o mes e o ano da data da operacao
								LocalDate dataop = c.getOperacoes().get(i).getDataOperacao().toInstant()
										.atZone(ZoneId.systemDefault()).toLocalDate();
								int mes2 = dataop.getMonthValue();
								int ano2 = dataop.getYear();

								if (mes == mes2 && ano == ano2) {

									valortotalmes += c.getOperacoes().get(i).getValor();
								}
							}
						}

						if (valortotalmes + levantamento <= ((ContaPoupanca) c).getLimiteMensalDebito()) {

							Operacao lev2 = new Levantamento(val.validoperacoes(c.getOperacoes()), func, data,
									levantamento, desc);
							c.getOperacoes().add(lev2);
							c.setSaldo(c.getSaldo() - levantamento);
							JOptionPane.showMessageDialog(null, "Levantamento efectuado com sucesso!!!  ");

						} else {

							JOptionPane.showMessageDialog(null, "Não pode efectura mais levantamentos este mes!");

						}

					}

				} else {

					JOptionPane.showMessageDialog(null, "Ultrapassou o montante por Dia");
				}

			} else

			{
				JOptionPane.showMessageDialog(null, "Ultrapassou o montante por Operacao");
			}

		}

	}

	/**
	 * @param nCartao
	 * @return devolve conta recebendo o id do cartao
	 */
	protected Conta obterContaPorCartao(int nCartao) {
		ArrayList<Conta> contas = this.contas;
		Conta conta = new Conta();
		for (Conta c : contas) {
			if (((ContaCorrente) c).getCartao() == nCartao) {
				conta = c;
			}
		}
		return conta;
	}
	// recebe os dados de pagamento da livraria

	/**
	 * @param montantePagamento
	 * @param numCartao         retira ao saldo o valor pago na livraria.
	 */
	protected void actualizaSaldoEOperacoesAposPagamento(double montantePagamento, int numCartao) {

		int idConta = 0;

		for (Cartao c : this.cartoes) {
			if (c.getnCartao() == numCartao) {
				idConta = c.getIdconta();
			}
		}

		for (Conta c : this.contas) {

			if (c.getIdConta() == idConta) {
				double novoSaldo = c.getSaldo() - montantePagamento;
				c.setSaldo(novoSaldo);
				int id = val.validoperacoes(c.getOperacoes());
				Date today = Calendar.getInstance().getTime();
				String str = today + " Pagamento livraria no valor de " + montantePagamento;
				Operacao op = new Pagamento(id, today, montantePagamento, str);
				c.getOperacoes().add(op);
			}

		}
	}

	/**
	 * @return
	 * @throws IOException le os dados de pagamentos recebido pela livraria no
	 *                     ficheiro.
	 */
	public String lerDadosPagamento() throws IOException {

		BufferedReader fR = new BufferedReader(new FileReader(new File("dadosPagamento.txt")));
		String dadosPagamento = fR.readLine();

		return dadosPagamento;

	}

	/**
	 * @throws IOException escreve 00 00 00 no ficheiro de dados de pagamentos apos
	 *                     pagamento efectuado
	 */
	public void resetDadosPagamento() throws IOException {
		BufferedWriter fW = new BufferedWriter(new FileWriter("dadosPagamento.txt"));
		fW.write("00 00 00");
		fW.newLine();
		fW.close();

	}

	/**
	 * @throws IOException escreve resposta no ficheiro autoriza�ao para ser lido na
	 *                     livraria.
	 */
	public void fileAutoriza() throws IOException {

		String autorizacao = "AUTORIZADO";
		File f = new File("Autorizacao.txt");
		if (f.exists()) {

			BufferedWriter fW = new BufferedWriter(new FileWriter("Autorizacao.txt"));
			fW.write(autorizacao);
			fW.newLine();
			fW.close();

		} else {
			f.createNewFile();

			BufferedWriter fW = new BufferedWriter(new FileWriter("Autorizacao.txt"));
			fW.write(autorizacao);
			fW.newLine();
			fW.close();
		}
	}

	/**
	 * @throws IOException escreve resposta no ficheiro autoriza�ao para ser lido na
	 *                     livraria.
	 */
	public void fileNaoAutoriza() throws IOException {

		String autorizacao = "NAO AUTORIZADO";
		File f = new File("Autorizacao.txt");
		if (f.exists()) {

			BufferedWriter fW = new BufferedWriter(new FileWriter("Autorizacao.txt"));
			fW.write(autorizacao);
			fW.newLine();
			fW.close();

		} else {
			f.createNewFile();

			BufferedWriter fW = new BufferedWriter(new FileWriter("Autorizacao.txt"));
			fW.write(autorizacao);
			fW.newLine();
			fW.close();
		}
	}

	/**
	 * @return
	 * @throws IOException valida dados para pagamentos verifica as condicoes
	 *                     (existencia do cartao , cod Validacao,
	 *                     montantedisponivel)
	 * 
	 */
	protected boolean autorizaVenda() throws IOException {

		boolean autorizado = false;

		String dadosPagamento = lerDadosPagamento();
		Scanner sc = new Scanner(dadosPagamento);
		String montanteSTR = "";
		String ncartaoSTR = "";
		String pinSTR = "";
		while (sc.hasNext()) {
			montanteSTR = sc.next();
			ncartaoSTR = sc.next();
			pinSTR = sc.next();
		}
		montanteSTR = montanteSTR.replaceAll(",", ".");
		double montante = Double.parseDouble(montanteSTR);
		int nCartao = Integer.parseInt(ncartaoSTR);
		int pin = Integer.parseInt(pinSTR);

		ArrayList<Cartao> cartoes = this.cartoes;

		// verifica as condicoes (existencia do cartao , cod Validacao, montante
		// disponivel)
		for (Cartao c : cartoes) {
			if (c.getnCartao() == nCartao) {
				if (c.getCodvalidacao() == pin) {
					if (obterContaPorCartao(nCartao).getSaldo() > montante) {
						actualizaSaldoEOperacoesAposPagamento(montante, nCartao);
						autorizado = true;

					}

				}
			}
		}
		return autorizado;

	}

	/**
	 * @throws IOException metedo de thread
	 */
	public void threadLeDadosAutoriza() throws IOException {

		fileNaoAutoriza();

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {

				while (true) {
					System.out.println("A aguardar dados correctos");

<<<<<<< HEAD
						try {
							if (autorizaVenda()) {
									
									fileAutoriza();
									resetDadosPagamento();
									
=======
					try {
						if (autorizaVenda()) {

							fileAutoriza();
							resetDadosPagamento();
>>>>>>> 45e2f8f9375ef8a91990e565e731ca93b15c2eda
//									JOptionPane.showMessageDialog(null, "Pagamento autorizado");

						}
<<<<<<< HEAD
						
					
=======
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

>>>>>>> 45e2f8f9375ef8a91990e565e731ca93b15c2eda
				}
			}

		});

		t2.start();

	}
}
