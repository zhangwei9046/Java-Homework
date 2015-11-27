/*2. Based on problem 1, create a button and textarea on the same layout. 
 * Each time you click the button, it will read a string from ArrayList in order and show it in the textarea. 
 * When number of clicks beyond the ArrayList, pop up an alert menu. 
 */
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ShowString extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton click;
	private JTextArea text;
	private int count = 0;
	
	public ShowString() {
		this.setTitle("Show String");
		this.setLocation(360, 200);
		create();
		add();
		addListener();
		display();
	}
	public void create() {
		click = new JButton("CLICK");
		text = new JTextArea();
	}
	
	public void add() {
		Container con = getContentPane();
		JPanel j1 = new JPanel();
		JPanel j2 = new JPanel();
		con.add("North", j1);
		con.add("Center", j2);
		j1.add(click);
		j2.add(text);
		text.setLineWrap(true);
	}
	
	public void addListener() {
		click.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ReadFile rf = new ReadFile();
				File file = new File("/Users/ying/hello.txt");
				ArrayList<String> strings = rf.readFileIntoArrayList(file);
				if(count < strings.size()) {
					String s = strings.get(count);
					text.setText(s);
					count++;
				} else {
					JOptionPane.showMessageDialog(null, "No More Words", "Alert", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	class MyWindowAdapter extends WindowAdapter {
		
	}
	public void display() {
		setSize(500, 300);
		text.setSize(400, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ShowString();
	}

}
