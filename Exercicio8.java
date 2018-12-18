import java.util.Scanner;

/**
 * Breve descrição do código
 *
 * @sid 2011
 * 
 * @aid 1.1
 */
public class Exercicio8 {

	public static void main(String[] args) {

		// begin_inputs

		Scanner sc = new Scanner(System.in);

		String data;

		System.out.print("Digite a data: ");
		data = sc.nextLine();

		String dia = data.substring(0, 2);
		String mes = data.substring(3, 5);
		String ano = data.substring(6, 10);

		int mes1 = Integer.parseInt(mes);

		
sc.close();
		// end_inputs

		String nomeMes = null;

		switch (mes1) {

		case 1:
			nomeMes = "Janeiro";
			break;
		case 2:
			nomeMes = "Fevereiro";
			break;
		case 3:
			nomeMes = "Março";
			break;
		case 4:
			nomeMes = "Abril";
			break;
		case 5:
			nomeMes = "Maio";
			break;
		case 6:
			nomeMes = "Junho";
			break;
		case 7:
			nomeMes = "Julho";
			break;
		case 8:
			nomeMes = "Agosto";
			break;
		case 9:
			nomeMes = "Setembro";
			break;
		case 10:
			nomeMes = "Outubro";
			break;
		case 11:
			nomeMes = "Novembro";
			break;
		case 12:
			nomeMes = "Dezembro";
			break;

		}

		System.out.println(dia + "/" + mes + "/" + ano + " - " + dia + "/" + nomeMes + "/" + ano);

	}

}
