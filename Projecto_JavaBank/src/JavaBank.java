import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.swing.JDialog;

public class JavaBank {
	public static void main(String[] args) {
		
		File f= new File("C:\\Users\\Joana\\eclipse-workspace\\IPJ\\Projecto_ViewComics\\dadosPagamento.dat");
		Scanner sc;
		String s="";
		try {
			sc = new Scanner(f);
			 s=sc.next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(s);
		
		int counter = 1000;
		Thread t1 = new Thread(new Runnable() {
			//crio um objecto da classe login??
			Login log = new Login();
		//	log.run();
			
			@Override
			public void run() {
				//inicio um runnable para o login que criei??
				log.run();
				show(counter, "New Thread!");
			}
		});

		t1.start();

		show(counter, "Main method!");
	}
	
	private static void show(int counter, String msg) {
		while (counter-- > 0) {
//			System.out.println(msg);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
