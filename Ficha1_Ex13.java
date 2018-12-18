import java.util.Scanner;

/**
* Breve descrição do código
*
* @sid 2013
* @aid 1.13
*/

public class Ficha1_Ex13 {

	public static void main(String[] args) {
		
Scanner sc= new Scanner(System.in);
		
		//begin_inputs
		
		System.out.println("Cateto 1: ");
		double cateto1 = sc.nextDouble();
		System.out.println("Cateto 2 ");
		double cateto2 = sc.nextDouble();
		
		
		//end_inputs
		
		sc.close();
		double Hipotenusa = Math.sqrt((cateto1*cateto1)+(cateto2*cateto2));
		
		System.out.println("hipotenusa = " +  Hipotenusa);
		
		

	}

}
