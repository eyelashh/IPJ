import java.io.Serializable;
import java.time.LocalDate;

<<<<<<< HEAD
public class Sessao implements  Serializable {
=======
public class Sessao implements Serializable{
>>>>>>> 3ea67d82b688c95db771c172bd92334c7496bfa5

	private int idSessao;
	private LocalDate horaAbertura;
	private double limite;
	private Utilizador user;

	public Sessao(int idSessao, LocalDate horaAbertura, double limite, Utilizador user) {
		super();
		this.idSessao = idSessao;
		this.horaAbertura = horaAbertura;
		this.limite = limite;
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

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public Utilizador getUser() {
		return user;
	}

	public void setUser(Utilizador user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Sessao [idSessao=" + idSessao + ", horaAbertura=" + horaAbertura + ", limite=" + limite + ", user="
				+ user + "]";
	}

}
