import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.components.JSpinField;
import java.awt.BorderLayout;

public class AppFun {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			AppFun window = new AppFun();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the application.
	 */
	public AppFun() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
