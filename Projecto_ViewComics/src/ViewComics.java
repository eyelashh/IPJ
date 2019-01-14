import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JDialog;

public class ViewComics implements Serializable {

	public static void main(String[] args) {

		int counter = 1000;
		Thread t1 = new Thread(new Runnable() {

			AppCliente cliente = new AppCliente();

			@Override
			public void run() {

				cliente.run();
				// show(counter, "New Thread!");
			}
		});

		t1.start();

	}

}
