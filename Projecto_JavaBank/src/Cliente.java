
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Cliente extends Utilizador implements Serializable {

	private ArrayList<Integer> contas;
	private int contapoupanca;

	public Cliente(int idUtilizador, String nome, String sobrenome,Date dataDeNascimento,
			String tipoIndentificacao, int numidentificacao, String morada, int contacto, String username,
			String password,int contapoupanca) {
		super(idUtilizador, nome, sobrenome, dataDeNascimento, tipoIndentificacao, numidentificacao, morada, contacto,
				username, password);
		this.contas = new ArrayList<Integer>();
		this.contapoupanca = contapoupanca;
	}
 
	public ArrayList<Integer> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Integer> contas) {
		this.contas = contas;
	}

	public int getContapoupanca() {
		return contapoupanca;
	}

	public void setContapoupanca(int contapoupanca) {
		this.contapoupanca = contapoupanca;
	}
	
	
	

}
