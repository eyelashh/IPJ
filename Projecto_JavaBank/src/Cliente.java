import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Utilizador {

	private ArrayList<Conta> contas;

	public Cliente(int idUtilizador, String nome, String sobrenome, LocalDate dataDeNascimento,
			String tipoIndentificacao, int numidentificacao, String morada, int contacto, String username,
			String password, ArrayList<Conta> contas) {
		super(idUtilizador, nome, sobrenome, dataDeNascimento, tipoIndentificacao, numidentificacao, morada, contacto,
				username, password);
		this.contas = contas;
	}
 
	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

}
