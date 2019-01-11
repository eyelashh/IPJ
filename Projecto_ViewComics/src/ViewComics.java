import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JDialog;


public class ViewComics implements  Serializable {

	
	
	public static void main(String[] args) {	
		
		
	int counter = 1000;
	Thread t1 = new Thread(new Runnable() {
		
		AppCliente cliente = new AppCliente();
		
		@Override
		public void run() {
			
			cliente.run();
			//show(counter, "New Thread!");
		}
	});

	t1.start();

//	show(counter, "Main method!");
}

//private static void show(int counter, String msg) {
//	
//	//ler o ficheiro partilhado
//	while (counter-- > 0) {
//		
//		try {
//			BufferedReader fW=new BufferedReader(new FileReader("C:\\Users\\Joana\\eclipse-workspace\\IPJ\\Projecto_JavaBank\\Autorizacao.txt"));
//			String s=fW.readLine();
//			System.out.println(s);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//System.out.println(msg);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}



}
