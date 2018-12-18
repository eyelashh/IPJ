import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JCheckBox;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.ButtonGroup;

/**
* Breve descrição do código
*
* @sid 2013
* @aid 1.1
*/

public class Interface extends JFrame {
	public Interface() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAnimais = new JMenu("Animais");
		menuBar.add(mnAnimais);
		
		JMenuItem mntmVaca = new JMenuItem("Vaca");
		mnAnimais.add(mntmVaca);
		
		JMenuItem mntmCo = new JMenuItem("C\u00E3o");
		mnAnimais.add(mntmCo);
		
		JMenuItem mntmGato = new JMenuItem("Gato");
		mnAnimais.add(mntmGato);
		
		JMenuItem mntmOvelha = new JMenuItem("Ovelha");
		mnAnimais.add(mntmOvelha);
	}
	
}

