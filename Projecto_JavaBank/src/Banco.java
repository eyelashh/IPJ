import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;

public class Banco implements Serializable {
	private int idBanco;
	private String nome;
	private int contacto;
	private String morada;
	private ArrayList<Conta> contas;
	private ArrayList<Utilizador> utilizadores;
	// private static Banco banco = new Banco();

	public Banco() {
		super();
		this.utilizadores = new ArrayList<Utilizador>();
		this.contas = new ArrayList<Conta>();
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

	}

	// public static Banco getInstance() {
	// return banco;
	// }

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

	// isto lista todos os nomes e numeros dos funcionarios numa arraylist de
	// Strings para ser recebido nas listas de funcionario!
	protected String[] listaFunc(ArrayList<Utilizador> fun) {
		ArrayList<String> func = new ArrayList<String>();
		String f = "";

		for (int i = 0; i < fun.size(); i++) {
			if (fun.get(i) instanceof Funcionario) {
				f = fun.get(i).getIdUtilizador() + " " + fun.get(i).getNome();
				func.add(f);
			}
			f = null;
		}

		String[] funcionario = new String[func.size()];
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

	// este metedo recebe o modelo da lista e o array e adiciona os elementos para a
	// lista:
	protected void addelementoslist(String[] s, DefaultListModel<String> dm) {
		for (int i = 0; i < s.length; i++) {
			dm.addElement(s[i]);
		}
	}

	protected void eliminautilizador(int id, ArrayList<Utilizador> utilizador) {
		for (int i = 0; i < utilizador.size(); i++) {
			if (utilizador.get(i).getIdUtilizador() == id) {
				utilizador.remove(i);
			}
		}
	}

	protected void atualizautilizador(Cliente c, String nome, String sobrenome, Date dataDeNascimento, String tipoIndentificacao,
			int numidentificacao, String morada, int contacto, String username, String password) {
		
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
}
