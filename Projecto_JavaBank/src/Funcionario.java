import java.io.Serializable;
import java.util.Date;

public class Funcionario extends Utilizador implements Serializable {
	private int idFuncionario;

	public Funcionario(int idUtilizador, String nome, String sobrenome, Date dataDeNascimento,
			String tipoIndentificacao, int numidentificacao, String morada, int contacto, String username,
			String password, int idFuncionario) {
		super(idUtilizador, nome, sobrenome, dataDeNascimento, tipoIndentificacao, numidentificacao, morada, contacto,
				username, password);
		this.idFuncionario = idFuncionario;
		
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}
 
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	
	
	

}
