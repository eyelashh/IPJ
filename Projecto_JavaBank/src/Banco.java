import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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

	public Banco() {
		super();
		this.utilizadores = new ArrayList<Utilizador>();
		this.contas = new ArrayList<Conta>();
		this.cartoes = new ArrayList<Cartao>();
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

	// adiciona utilizadores
	public void addUtilizador(Utilizador u) {
		this.utilizadores.add(u);
	}

	// remove utilizadores
	public void removeUtilizador(Utilizador u) {
		this.utilizadores.remove(u);
	}

	// verificar se a pass e o user estao corretos
	public boolean verificarUserPass(String user, String pass) {

		boolean verificar = false;

		for (Utilizador u : this.utilizadores) {
			if ((pass.equals(u.getPassword())) && (user.equals(u.getUsername()))) {
				verificar = true;
			}

		}
		return verificar;
	}

	// verificar o nome da pessoa que está logado
	public Utilizador logado(String username, String password) {

		Utilizador u_log = new Utilizador();

		for (Utilizador u : this.utilizadores) {
			if ((u.getUsername().equals(username)) && (u.getPassword().equals(password))) {
				u_log = u;
			}
		}
		return u_log;
	}

	// isto lista todos os nomes e numeros dos clientes numa arraylist de Strings
	// para ser recebido nas listas de clientes!
	protected String[] listarClientes(ArrayList<Utilizador> fun) {
		ArrayList<String> clts = new ArrayList<String>();
		String s = "";
		for (int i = 0; i < fun.size(); i++) {
			if (fun.get(i) instanceof Cliente) {
				s = fun.get(i).getIdUtilizador() + "*" + fun.get(i).getNome();
				clts.add(s);
			}
			s = null;
		}

		String[] clientes = new String[clts.size()];
		clientes = clts.toArray(clientes);

		return clientes;
	}

	// isto lista o numero de contas num array unico:

	protected String[] listanumerodecontasabertas(ArrayList<Conta> cont) {
		
		ArrayList<String> arrAxu = new ArrayList<String> ();
		
		
		
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

	protected String[] listanumerodecontas(ArrayList<Conta> cont) {
		String[] numcontas = new String[cont.size()];
		String s = "";
		for (int i = 0; i < cont.size(); i++) {
			if (cont.get(i).isAberta()) {
				s = "" + cont.get(i).getIdConta();
				numcontas[i] = s;
				s = "";
			}
		}
		return numcontas;
	}

	// retorna as contas de um cliente atraves do seu id
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

	// lista a conta de um determinado cliente
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

//lista a conta de um determinado cliente
	protected String[] listacontasordem(Cliente c, ArrayList<Conta> contas) {

		ArrayList<String> listprov = new ArrayList<String>();

		for (int i = 0; i < contas.size(); i++) {
			for (int j = 0; j < c.getContas().size(); j++) {
				if ((contas.get(i) instanceof ContaCorrente) && (contas.get(i).isAberta() == true) && (contas.get(i).getIdConta() == c.getContas().get(j))) {
					listprov.add(c.getContas().get(j) + "");
				}
			}
		}

		String[] lista = new String[listprov.size()];
		lista = listprov.toArray(lista);
		return lista;
	}

	// lista a conta de um determinado cliente
	protected String[] listacontaspoupanca(Cliente c, ArrayList<Conta> contas) {

		ArrayList<String> listprov = new ArrayList<String>();

		for (int i = 0; i < this.contas.size(); i++) {
			for (int j = 0; j < c.getContas().size(); j++) {


				if ((contas.get(i) instanceof ContaPoupanca) && (contas.get(i).isAberta() == true)
						&& (contas.get(i).getIdConta() == c.getContas().get(j))) {
					String idSTR = Integer.toString(((ContaPoupanca) contas.get(i)).getIdConta());
					listprov.add(idSTR);
					
				}
			}
		}

		String[] lista = new String[listprov.size()];
		lista = listprov.toArray(lista);
		return lista;
	}

	// retorna o array das contas poupan�a
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

	// retorna o array das contas corrente
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

	// isto lista todos os nomes e numeros dos funcionarios numa arraylist de
	// Strings para ser recebido nas listas de funcionario!

	protected String[] listaFunceAdm(ArrayList<Utilizador> fun) {
		ArrayList<String> func = new ArrayList<String>();
		String f = "";

		for (int i = 0; i < fun.size(); i++) {
			if (fun.get(i) instanceof Funcionario || fun.get(i) instanceof Administrador) {
				f = fun.get(i).getIdUtilizador() + " " + fun.get(i).getNome() + " " + fun.get(i).getSobrenome();
				func.add(f);
			}
			f = null;
		}

		String[] funcionario = new String[func.size() + 1];
		funcionario = func.toArray(funcionario);

		return funcionario;
	}

	// metedo que retorna um utilizador qualquer recebendo o seu id;
	protected Utilizador selectUtilizador(int numUtil, ArrayList<Utilizador> list) {
		Utilizador u = new Utilizador();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdUtilizador() == numUtil) {
				u = list.get(i);
			}
		}
		return u;
	}

	// metedo que retorna um utilizador qualquer recebendo o seu nome;
	// serve para a pesquisa:
	protected Utilizador selectUtilizadorNome(String nome, ArrayList<Utilizador> list) {
		Utilizador u = new Utilizador();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNome().equals(nome)) {
				u = list.get(i);
			}
		}
		return u;
	}

	// extrair o id de uma string
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

//seleciona a conta
	protected Conta SelectConta(int numconta, ArrayList<Conta> contas) {
		Conta c = new Conta();

		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getIdConta() == numconta) {
				c = contas.get(i);
			}
		}
		return c;
	}

	// seleciona e retorna a conta de um cliente
	protected Conta selectContaCliente(ArrayList<Integer> idCliente, ArrayList<Conta> contas) {
		Conta c = new Conta();

		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getClientes() == idCliente) {
				c = contas.get(i);
			}
		}
		return c;
	}

	// este metedo recebe o modelo da lista e o array e adiciona os elementos para a
	// lista:
	protected void addelementoslist(String[] s, DefaultListModel<String> dm) {
		for (int i = 0; i < s.length; i++) {
			dm.addElement(s[i]);

		}
	}

	protected void addelementoslist(String[] s, DefaultComboBoxModel<String> dm) {
		for (int i = 0; i < s.length; i++) {
			dm.addElement(s[i]);

		}
	}

	// elimina utilizador do arraylist
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

	// atualiza dados do funcionario
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

	// atualiza dados do Cliente;
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

	// atualiza contas

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
	protected void eliminaconta(int id, Date datafecho, ArrayList<Conta> contas) {
		for (int i = 0; i < contas.size(); i++) {
			if (contas.get(i).getIdConta() == id) {
				contas.get(i).setAberta(false);
				contas.get(i).setSaldo(0);
				contas.get(i).setDataFecho(datafecho);
			}
		}
	}

	// preenche tabela clientes na conta:
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

	// retornar quantas contas abertas existem:
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

	// retornar quantas contas fechadas existem:
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

	// faz o total de capital:
	protected int totalCapital(ArrayList<Conta> contas, Date data1, Date data2) {

		int soma = 0;

		for (int i = 0; i < contas.size(); i++) {
			if ((contas.get(i).getDataCriacao().after(data1) && contas.get(i).getDataCriacao().before(data2))) {

				soma += contas.get(i).getSaldo();

			}
		}
		return soma;
	}

	// faz a soma dos levantamentos:
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

	// faz a soma dos depositos:
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

	// faz o balanco :
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

	// preenche tabela clientes no cliente:
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

	protected String[] listaClientesNome(String nomeCliente) {

		ArrayList<Utilizador> util = this.utilizadores;
		ArrayList<String> utilNome = new ArrayList<String>();
		String cliente = "";

		for (Utilizador c : util) {
			String nome = c.getNome();
			if ((nome.toLowerCase().contains(nomeCliente.toLowerCase())) && (c instanceof Cliente)) {
				cliente = "" + c.getIdUtilizador() + "*" + c.getNome() + " " + c.getSobrenome();
				utilNome.add(cliente);
			}
		}

		String[] clientesNome = new String[utilNome.size()];
		clientesNome = utilNome.toArray(clientesNome);

		return clientesNome;
	}

	// preenche tabela clientes no cliente pelo nome:
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
	protected void preenchetabelaOperacoesTransferencia(DefaultTableModel model, Conta c) {

		for (int i = 0; i < contas.size(); i++) {

			for (int j = 0; j < contas.get(i).getOperacoes().size(); j++) {

				if ((contas.get(i).getIdConta() == c.getIdConta())
						&& contas.get(i).getOperacoes().get(j) instanceof Transferencia) {

					int id = contas.get(i).getOperacoes().get(j).getIdOperacao();
					Funcionario resp = contas.get(i).getOperacoes().get(j).getResponsavel();
					Date data = contas.get(i).getOperacoes().get(j).getDataOperacao();
					Double valor = contas.get(i).getOperacoes().get(j).getValor();
					int contadestino = ((Transferencia) contas.get(i).getOperacoes().get(j)).getcontatransf()
							.getIdConta();
					Cliente clt = ((Transferencia) contas.get(i).getOperacoes().get(j)).getClt();

					Object[] texto = { id, resp, data, valor, contadestino, clt };
					model.addRow(texto);

				}

			}
		}

	}

	// vai buscar a descricao
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
	protected void preenchetabelaOperacoesDeposito(DefaultTableModel model, Conta c) {

		for (int i = 0; i < contas.size(); i++) {

			for (int j = 0; j < contas.get(i).getOperacoes().size(); j++) {

				if ((contas.get(i).getIdConta() == c.getIdConta())
						&& contas.get(i).getOperacoes().get(j) instanceof Deposito) {

					int id = contas.get(i).getOperacoes().get(j).getIdOperacao();
					Funcionario resp = contas.get(i).getOperacoes().get(j).getResponsavel();
					Date data = contas.get(i).getOperacoes().get(j).getDataOperacao();
					Double valor = contas.get(i).getOperacoes().get(j).getValor();

					Object[] texto = { id, resp, data, valor, null, null };
					model.addRow(texto);
				}

			}
		}

	}

	// preenche tabela operaçoes no cliente:
	protected void preenchetabelaOperacoesLevantamento(DefaultTableModel model, Conta c) {

		for (int i = 0; i < contas.size(); i++) {

			for (int j = 0; j < contas.get(i).getOperacoes().size(); j++) {

				if ((contas.get(i).getIdConta() == c.getIdConta())
						&& contas.get(i).getOperacoes().get(j) instanceof Levantamento) {

					int id = contas.get(i).getOperacoes().get(j).getIdOperacao();
					Funcionario resp = contas.get(i).getOperacoes().get(j).getResponsavel();
					Date data = contas.get(i).getOperacoes().get(j).getDataOperacao();
					Double valor = contas.get(i).getOperacoes().get(j).getValor();

					Object[] texto = { id, resp, data, valor, null, null };
					model.addRow(texto);

				}

			}
		}

	}

	// lista das operacoes
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
	protected void eliminacontaemcliente(ArrayList<Utilizador> clientes, Conta c) {
		// remover id de contas dentro dos clientes:

		Cliente clt;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i) instanceof Cliente) {

				for (int x = 0; x < ((Cliente) clientes.get(i)).getContas().size(); x++) {
					if (((Cliente) clientes.get(i)).getContas().get(x) == c.getIdConta()) {
						((Cliente) clientes.get(i)).getContas().remove(x);
						Integer id = ((Cliente) clientes.get(i)).getIdUtilizador();
						c.getClientes().remove(id);
					}
				}

			}
		}

	}

	// retorna o cartao
	protected Cartao obterCartao(ArrayList<Cartao> cartoes, int id) {

		Cartao card = new Cartao();

		if (cartoes.size() != 0) {

			for (int j = 0; j < cartoes.size(); j++) {
				if (cartoes.get(j).getCodvalidacao() == id) {

					card = cartoes.get(j);

				}
			}

		}

		return card;

	}

	// cria um cartão

	public void criaCartao(int idConta, Cartao card, Conta c) {
		int i = 0;

		for (i = 0; i < contas.size(); i++) {
			if ((contas.get(i) instanceof ContaCorrente)) {

				this.cartoes.add(card);
				((ContaCorrente) c).setCartao(card.getCodvalidacao());

			}
		}
	}

	protected Cartao selecionacartao(ArrayList<Cartao> cartoes, int id) {
		Cartao card = null;
		for (int i = 0; i < cartoes.size(); i++) {
			if (cartoes.get(i).getCodvalidacao() == id) {
				card = cartoes.get(i);
			}
		}

		return card;

	}
	
	


	// retorna a conta atraves do seu numero
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
	protected boolean existeconta(DefaultComboBoxModel<String> dcbm, int id) {
		boolean existe = false;

		for (int i = 0; i < dcbm.getSize(); i++) {
			if (dcbm.getElementAt(i).equals(id + "")) {
				existe = true;
			}
		}

		return existe;
	}

}
