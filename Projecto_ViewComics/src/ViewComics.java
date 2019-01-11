import java.io.Serializable;

import javax.swing.JDialog;


public class ViewComics implements  Serializable {


	public static void main(String[] args) {	
	int counter = 1000;
	Thread t1 = new Thread(new Runnable() {
		//crio um objecto da classe cliente?
		AppCliente cliente = new AppCliente();
		
	//	log.run();
		
		@Override
		public void run() {
			//inicio um runnable para appCliente que criei??
			cliente.run();
			//show(counter, "New Thread!");
		}
	});

	t1.start();

	show(counter, "Main method!");
}

private static void show(int counter, String msg) {
	
	//ler o ficheiro partilhado
	while (counter-- > 0) {
		System.out.println(msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

}
