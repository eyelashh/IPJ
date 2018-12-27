import java.sql.Date;
import java.time.LocalDate;

public class GestoaBanco {

	Banco totta = new Banco();
	
	
	public GestoaBanco() {
		
		Utilizador u1 = new Utilizador(1, "Tamara", "Barros", Date.valueOf(LocalDate.of(2018, 04, 05)), "C.C.", 234567, "Rua Pinheiro", 2192873, "Tamara92", "Barros92");
		Utilizador u2 = new Utilizador(2, "Bruno", "Escada", Date.valueOf(LocalDate.of(2018, 04, 05)), "C.C.", 234567, "Rua Pinheiro", 2192873, "BrunoEs", "Escada43"); 
		Utilizador u3 = new Utilizador(3, "Joana", "Pestana", Date.valueOf(LocalDate.of(2018, 04, 05)), "C.C.", 234567, "Rua Pinheiro", 2192873, "eye", "pestana91");
		
		totta.addUtilizador(u1);
		totta.addUtilizador(u2);
		totta.addUtilizador(u3);
		
	}

}
