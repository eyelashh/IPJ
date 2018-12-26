import java.time.LocalDate;

public class Administrador extends Utilizador {

	
	public Administrador(int idUtilizador, String nome, String sobrenome, LocalDate dataDeNascimento,
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
