import javax.swing.JFrame;

public class ViewComics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InterfaceGrafica ig = new InterfaceGrafica();

		ig.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ig.setBounds(100, 100, 1280, 780);
		ig.pack();
		ig.setVisible(true);

	}

}
