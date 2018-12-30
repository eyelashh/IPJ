import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;


public class Utilizador implements  Serializable {



	private int id;
	private static AtomicInteger aiUtil=new AtomicInteger(0);
	private String nome;
	private int contato;
	private String username;
	private String password;
	
	
	public Utilizador() {
		super();
		
	}

	public Utilizador(String nome, int contato, String username, String password) {
		super();
		this.id = aiUtil.incrementAndGet();
		this.nome = nome;
		this.contato = contato;
		this.username = username;
		this.password = password;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getContato() {
		return contato;
	}

	public void setContato(int contato) {
		this.contato = contato;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return id +" | nome=" + nome + ", contato=" + contato + ", username=" + username
				+ ", password=" + password + "]";
	}

}
