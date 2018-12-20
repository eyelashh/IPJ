import java.util.ArrayList;

public class Banco {
	private int idBanco; 
	private String nome;
	private int contacto;
	private String morada; 
	private ArrayList<Conta> contas;
	private ArrayList<Utilizador> utlizadores;
	
	public Banco() {
		super();
	} 

	public Banco(int idBanco, String nome, int contacto, String morada, ArrayList<Conta> contas,
			ArrayList<Utilizador> utlizadores) {
		super();
		this.idBanco = idBanco;
		this.nome = nome;
		this.contacto = contacto;
		this.morada = morada;
		this.contas = contas;
		this.utlizadores = utlizadores;
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
		return utlizadores;
	}

	public void setUtlizadores(ArrayList<Utilizador> utlizadores) {
		this.utlizadores = utlizadores;
	}
	
	public void run()
	{
		System.out.println("Run!!!");
	}
	

}
