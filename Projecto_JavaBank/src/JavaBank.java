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
			}
		});

		t1.start();

	}

}
