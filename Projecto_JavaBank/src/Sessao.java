import java.time.LocalDate;

public class Sessao {
	private int idSessao;
	private LocalDate horaAbertura;
	private LocalDate limiteTempo;
	private Utilizador user;
	
	
	public Sessao() {
		super();
	}
	
	public Sessao(int idSessao, LocalDate horaAbertura, LocalDate limiteTempo, Utilizador user) {
		super();
		this.idSessao = idSessao;
		this.horaAbertura = horaAbertura;
		this.limiteTempo = limiteTempo;
		this.user = user;
	}
	
	public int getIdSessao() {
		return idSessao;
	}
	public void setIdSessao(int idSessao) {
		this.idSessao = idSessao;
	}
	public LocalDate getHoraAbertura() {
		return horaAbertura;
	}
	public void setHoraAbertura(LocalDate horaAbertura) {
		this.horaAbertura = horaAbertura;
	}
	public LocalDate getLimiteTempo() {
		return limiteTempo;
	}
	public void setLimiteTempo(LocalDate limiteTempo) {
		this.limiteTempo = limiteTempo;
	}
	public Utilizador getUser() {
		return user;
	}
	public void setUser(Utilizador user) {
		this.user = user;
	}
	
	
	
}
