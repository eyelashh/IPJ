import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JDialog;

public class JavaBank {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

	
		int counter = 1000;
		Thread t1 = new Thread(new Runnable() {
			Login log = new Login();
			@Override
			public void run() {
				log.run();
				//show(counter, "New Thread!");
			}
		});

		t1.start();

		//show(counter, "Main method!");
	}

//	private static void show(int counter, String msg) {
//		while (counter-- > 0) {
//
//			try {
//				BufferedReader fW = new BufferedReader(new FileReader(
//						"C:\\Users\\Joana\\eclipse-workspace\\IPJ\\Projecto_ViewComics\\dadosPagamento.txt"));
//				String s = fW.readLine();
//				System.out.println(s);
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
////			System.out.println(msg);
//			try {
//
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
}
