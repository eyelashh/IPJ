import java.io.Serializable;
import java.util.Date;

public class Administrador extends Utilizador implements Serializable {

	//alteracao
	public Administrador(int idUtilizador, String nome, String sobrenome, Date dataDeNascimento,
			String tipoIndentificacao, int numidentificacao, String morada, int contacto, String username,
			String password) {
		super(idUtilizador, nome, sobrenome, dataDeNascimento, tipoIndentificacao, numidentificacao, morada, contacto, username,
				password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Administrador []";
	}
	
	 
 
	

}
