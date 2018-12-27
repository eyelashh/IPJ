
import java.util.ArrayList;
import java.util.Date;


public class Cliente extends Utilizador {

	private ArrayList<Conta> contas;

	public Cliente(int idUtilizador, String nome, String sobrenome,Date dataDeNascimento,
			String tipoIndentificacao, int numidentificacao, String morada, int contacto, String username,
			String password) {
		super(idUtilizador, nome, sobrenome, dataDeNascimento, tipoIndentificacao, numidentificacao, morada, contacto,
				username, password);
		this.contas = new ArrayList<Conta>();
	}
 
	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

}
