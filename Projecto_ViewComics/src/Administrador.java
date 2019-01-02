import java.io.Serializable;

public class Administrador extends Utilizador implements  Serializable {

	public Administrador(String nome, String contato, String username, String password) {
		super(nome, contato, username, password);
		// TODO Auto-generated constructor stub

	}

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

}
