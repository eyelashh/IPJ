import java.util.Date;

public class Utilizador {

	private int idUtilizador;
	private String nome;
	private String sobrenome;
<<<<<<< HEAD
	private LocalDate dataDeNascimento;
=======
	private Date dataDeNascimento;
>>>>>>> 7bf8d357392635a94d97902236e1c818ce772146
	private String tipoIndentificacao;
	private int numidentificacao;
	private String morada;
	private int contacto;
	private String username;
	private String password;

<<<<<<< HEAD
	public Utilizador(int idUtilizador, String nome, String sobrenome, LocalDate dataDeNascimento,
=======
	public Utilizador(int idUtilizador, String nome, String sobrenome, Date dataDeNascimento,
>>>>>>> 7bf8d357392635a94d97902236e1c818ce772146
			String tipoIndentificacao, int numidentificacao, String morada, int contacto, String username,
			String password) {
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

<<<<<<< HEAD
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
=======
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
>>>>>>> 7bf8d357392635a94d97902236e1c818ce772146
		this.dataDeNascimento = dataDeNascimento;
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

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
