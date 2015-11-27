import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 330;
	public static final int HEIGHT = 250;
	private JTextField result;
	private JPanel showPane;
	private JPanel buttonPane;
	private JButton[] buttons;
	public Calculator() {
		super("Calculator");
		create();
		addListener();
		setSize(HEIGHT, WIDTH);
		setLocation(500, 150);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
				
		
	}
	
	public void create() {
		result = new JTextField("0", 9);
		result.setEditable(false);
		result.setHorizontalAlignment(JTextField.RIGHT);
		result.setFont(new Font("Arial", Font.PLAIN, 31));
		Container con = getContentPane();
		showPane = new JPanel();
		showPane.add(result);
		con.add("North", showPane);
		
		buttonPane = new JPanel();
		con.add("Center", buttonPane);
		buttonPane.setLayout(new GridLayout(4, 4));
		buttons = new JButton[16];
		for (int i = 0; i < 10;i++) {
			buttons[i] = new JButton(Integer.toString(i));
		}
		buttons[10] = new JButton("+");
		buttons[11] = new JButton("-");
		buttons[12] = new JButton("*");
		buttons[13] = new JButton("/");
		buttons[14] = new JButton("=");
		buttons[15] = new JButton(".");
		buttonPane.add(buttons[7]);
		buttonPane.add(buttons[8]);
		buttonPane.add(buttons[9]);
		buttonPane.add(buttons[10]);
		buttonPane.add(buttons[4]);
		buttonPane.add(buttons[5]);
		buttonPane.add(buttons[6]);
		buttonPane.add(buttons[11]);
		buttonPane.add(buttons[1]);
		buttonPane.add(buttons[2]);
		buttonPane.add(buttons[3]);
		buttonPane.add(buttons[12]);
		buttonPane.add(buttons[0]);
		buttonPane.add(buttons[15]);
		buttonPane.add(buttons[13]);
		buttonPane.add(buttons[14]);
	}
	
	public void addListener() {
		ButtonListener b = new ButtonListener();
		for (int i = 0; i < 16; i++) {
			buttons[i].addActionListener(b);
		}
	}
	
	class ButtonListener implements ActionListener {
		private boolean operatorPressed;
		private String lastButton = "0";
		private String lastOperator = "+";
		private float total;
		private float current;
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String str = ((JButton) e.getSource()).getText();
			if(Character.isDigit(str.charAt(0))) {
				handleNumber(str);
			} else if (str.equals(".")){
				handlePoint();
			} else {
				calculate(str);
			}
		}

		private void handlePoint() {
			String strVal = result.getText();
			if (Character.isDigit(lastButton.charAt(0))) {
				strVal += '.';
			} else {
				strVal = "0.";
			}
			result.setText(strVal);
		}

		private void calculate(String str) {
			operatorPressed = true;
			if (Character.isDigit(lastButton.charAt(0))) {	
				if (lastOperator.equals("+") || lastOperator.equals("-")) {
					int len = Math.max(digitsAfterPoint(total), digitsAfterPoint(current));
					if (lastOperator.equals("+")) {
						total += current;
					}
					if (lastOperator.equals("-")) {
						total -= current;
					}
					if (total - (int) total == 0) {
						result.setText((int) total + "");
					} else {
						String s = Float.toString(total);
						int i = 0;
						while(s.charAt(i) != '.') {
							i++;
						}
						s = s.substring(0, i + 1 + len);
						total = new Float(s).floatValue();
						result.setText(s);
					}
				}
				if (lastOperator.equals("*") || lastOperator.equals("/")) {
					if (lastOperator.equals("*")) {
						total *= current;
					}
					if (lastOperator.equals("/")) {
							total /= current;
					}
					if (total - (int) total == 0) {
						result.setText((int) total + "");
					} else {
						result.setText(total + "");
					}
				}
			}
			lastOperator = str;
			lastButton = str;
		}

		private void handleNumber(String str) {
			lastButton = str;
			String strVal = result.getText();
			if (!operatorPressed) {
				if (strVal.equals("0")) {
					strVal = "";
				}
				strVal += str;
			} else {
				operatorPressed = false;
				strVal = str;
			}
			result.setText(strVal);
			current = new Float(strVal).floatValue();
		}	
	}
	
	//Find how many digits after the point
	private int digitsAfterPoint(float total) {
		String s = Float.toString(total);
		int i = 0;
		while(i < s.length()) {
			if(s.charAt(i) == '.') {
				break;
			}
			i++;
		}
		return s.length() - i - 1;
	}
	public static void main(String[] args) {
		new Calculator();
	}
}
