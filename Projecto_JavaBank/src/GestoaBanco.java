import java.time.LocalDate;

public class GestoaBanco {

	public void inicializar() {

		Banco totta = new Banco();

		totta.addUtilizador(new Utilizador(12, "Carlos", "Silva", LocalDate.of(1980, 04, 12), "C.C.", 231778243,
				"Avendida Andrade", 934562763, "CarlosAdmin2018", "C2018Admin"));

	}

}
