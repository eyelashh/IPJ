import java.sql.Date;
import java.time.LocalDate;

public class GestoaBanco {

	
	public GestoaBanco() {
		
		Funcionario u1 = new Funcionario(1, "Tamara", "Barros", Date.valueOf(LocalDate.of(2018, 04, 05)), "C.C.", 234567, "Rua Pinheiro", 2192873, "Tamara92", "Barros92", 9);
		Cliente u2 = new Cliente(2, "Bruno", "Escada", Date.valueOf(LocalDate.of(2018, 04, 05)), "C.C.", 234567, "Rua Pinheiro", 2192873, "BrunoEs", "Escada43"); 
		Administrador u3 = new Administrador(3, "Joana", "Pestana", Date.valueOf(LocalDate.of(2018, 04, 05)), "C.C.", 234567, "Rua Pinheiro", 2192873, "eye", "pestana91");
		
		Banco.getInstance().addUtilizador(u1);
		Banco.getInstance().addUtilizador(u2);
		Banco.getInstance().addUtilizador(u3);

		
	}

}
