import java.io.Serializable;
import java.util.ArrayList;

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

	// 
	public ArrayList<Utilizador> getClientes() {

		ArrayList<Utilizador> clt = new ArrayList();
		for (Utilizador u : this.utilizadores) {
			if (u instanceof Cliente) {
				clt.add(u);
			}
		}
		return clt;
	}

}
