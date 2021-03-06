import java.io.Serializable;
import java.util.Date;

public class Utilizador implements Serializable {

	private int idUtilizador;
	private String nome;
	private String sobrenome;
	private Date dataDeNascimento;
	private String tipoIndentificacao;
	private int numidentificacao;
	private String morada;
	private int contacto;
	private String username;
	private String password;

	public Utilizador(int idUtilizador, String nome, String sobrenome, Date dataDeNascimento, String tipoIndentificacao,
			int numidentificacao, String morada, int contacto, String username, String password) {
		super();
		this.idUtilizador = idUtilizador;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataDeNascimento = dataDeNascimento;
		this.tipoIndentificacao = tipoIndentificacao;
		this.numidentificacao = numidentificacao;
		this.morada = morada;
		this.contacto = contacto;
		this.username = username;
		this.password = password;

	}

	public Utilizador() {
		super();
	}

	public int getIdUtilizador() {
		return idUtilizador;
	}

	public void setIdUtilizador(int idUtilizador) {
		this.idUtilizador = idUtilizador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTipoIndentificacao() {
		return tipoIndentificacao;
	}

	public void setTipoIndentificacao(String tipoIndentificacao) {
		this.tipoIndentificacao = tipoIndentificacao;
	}

	public int getNumidentificacao() {
		return numidentificacao;
	}

	public void setNumidentificacao(int numidentificacao) {
		this.numidentificacao = numidentificacao;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public int getContacto() {
		return contacto;
	}

	public void setContacto(int contacto) {
		this.contacto = contacto;
	}

	public String getUsername() {
		return username;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
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

	public void setDataDeNascimento(Date date) {
		this.dataDeNascimento = date;

	}

	@Override
	public String toString() {
		return "Utilizador [idUtilizador=" + idUtilizador + ", nome=" + nome + ", sobrenome=" + sobrenome
				+ ", dataDeNascimento=" + dataDeNascimento + ", tipoIndentificacao=" + tipoIndentificacao
				+ ", numidentificacao=" + numidentificacao + ", morada=" + morada + ", contacto=" + contacto
				+ ", username=" + username + ", password=" + password + "]";
	}

}
