import java.awt.*;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import java.util.Stack;
import java.awt.event.*;

import javax.swing.*;

class Calculator extends JFrame {
	private JPanel content;
	// data fields
	private JTextField _dataTF = new JTextField(10);
	// buttons - consider using an array
	private JButton b1 = new JButton("1");
	private JButton b2 = new JButton("2");
	private JButton b3 = new JButton("3");
	private JButton b4 = new JButton("4");
	private JButton b5 = new JButton("5");
	private JButton b6 = new JButton("6");
	private JButton b7 = new JButton("7");
	private JButton b8 = new JButton("8");
	private JButton b9 = new JButton("9");
	private JButton b0 = new JButton("0");
	
	private JButton bTimes 		= new JButton("*");
	private JButton bDivide 	= new JButton("/");
	private JButton bAdd 		= new JButton("+");
	private JButton bSubtract 	= new JButton("-");
	private JButton bPoint 		= new JButton(".");
	private JButton bEquals 	= new JButton("Enter");
	
	private JButton bCE       	= new JButton("LST X");
	private JButton bC       	= new JButton("ON");
	private JButton bDelete   	= new JButton("Del");
	private JButton bNegative 	= new JButton("CHS");
	//private JButton bPercent  	= new JButton("%");
	
	private Stack<Double> opStack = new Stack<Double>(); // the stack of operands
	private String op = ""; // the next operand
	private double lastX = 0;
	private static final Insets insets = new Insets(2, 2, 2, 2);
	
	public Calculator() {
		/* Build the GUI */
		buildGUI();
		addButtonListeners();
		
		// b1.doClick();
		
		/* Set up variables */
		//Stack for operations
		
		
		/* Listen for events */
		//assign listeners to each button.
		//test by writing button presses to std.out
		//System.out.println("this is a string");
	}

	private void buildGUI() {
		// 0. Button layout objects
		GridBagLayout gridLayout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		setFont(new Font("Monospaced", Font.PLAIN, 14));
		
		content = new JPanel();
		content.setBackground(Color.white);
		content.setLayout(gridLayout);
		content.setMinimumSize(new Dimension(300,400));
		content.setFont(new Font("Monospaced", Font.PLAIN, 14));
		// 1. The panel to add them to.
		content.setBackground(Color.white);
		content.setLayout(gridLayout);
		
		// 2. The buttons to add
		b1.setBackground(Color.ORANGE);
		b2.setBackground(Color.ORANGE);
		b3.setBackground(Color.ORANGE);
		b4.setBackground(Color.ORANGE);
		b5.setBackground(Color.ORANGE);
		b6.setBackground(Color.ORANGE);
		b7.setBackground(Color.ORANGE);
		b8.setBackground(Color.ORANGE);
		b9.setBackground(Color.ORANGE);
		b0.setBackground(Color.ORANGE);
		bPoint.setBackground(Color.ORANGE);

		
		bEquals.setBackground(Color.CYAN);
		
		b1.setFont(new Font("Monospaced", Font.BOLD, 40));
		b2.setFont(new Font("Monospaced", Font.BOLD, 40));
		b3.setFont(new Font("Monospaced", Font.BOLD, 40));
		b4.setFont(new Font("Monospaced", Font.BOLD, 40));
		b5.setFont(new Font("Monospaced", Font.BOLD, 40));
		b6.setFont(new Font("Monospaced", Font.BOLD, 40));
		b7.setFont(new Font("Monospaced", Font.BOLD, 40));
		b8.setFont(new Font("Monospaced", Font.BOLD, 40));
		b9.setFont(new Font("Monospaced", Font.BOLD, 40));
		b0.setFont(new Font("Monospaced", Font.BOLD, 40));
		bPoint.setFont(new Font("Monospaced", Font.BOLD, 40));
		
		bTimes.setFont(new Font("Monospaced", Font.BOLD, 40));
		bDivide.setFont(new Font("Monospaced", Font.BOLD, 40));
		bAdd.setFont(new Font("Monospaced", Font.BOLD, 40));
		bSubtract.setFont(new Font("Monospaced", Font.BOLD, 40));
		bPoint.setFont(new Font("Monospaced", Font.BOLD, 40));
		bEquals.setFont(new Font("Monospaced", Font.BOLD, 40));
		
		_dataTF.setFont(new Font("Monospaced", Font.BOLD, 25));
		
		bTimes.setBackground(Color.WHITE);
		bDivide.setBackground(Color.WHITE);
		bAdd.setBackground(Color.WHITE);
		bSubtract.setBackground(Color.WHITE);
		bEquals.setBackground(Color.MAGENTA);
		bNegative.setBackground(Color.WHITE);
		
		bCE.setFont(new Font("Monospaced", Font.BOLD, 40));
		bC.setFont(new Font("Monospaced", Font.BOLD, 40));
		bDelete.setFont(new Font("Monospaced", Font.BOLD, 40));
		bNegative.setFont(new Font("Monospaced", Font.BOLD, 40));
		//bPercent.setFont(new Font("Monospaced", Font.BOLD, 40));
		
		
		
		
		
		JPanel row0 = new JPanel();
		JPanel row1 = new JPanel();
		JPanel row2 = new JPanel();
		JPanel row3 = new JPanel();
		JPanel row4 = new JPanel();
		JPanel row5 = new JPanel();
		row1.setBackground(Color.white);
		row2.setBackground(Color.white);
		row3.setBackground(Color.white);
		row4.setBackground(Color.white);
		row5.setBackground(Color.white);
		
		
		int gridy = 0;
		
		// add display to row0
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		row0.setLayout(new GridLayout(1,1));
		row0.add(_dataTF, gbc);
		//addComponent(content,row1,0,gridy++,1,1,1D,1D,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
		addComponent(content,row0,0,gridy++,1,1,1D,1D,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
		
		// add display to row1
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		row1.setLayout(new GridLayout(1,4));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		row1.add(bC, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		row1.add(bCE, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		row1.add(bDelete, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		row1.add(bSubtract, gbc);
		/*
		gbc.gridx = 4;
		gbc.gridy = 0;
		row1.add(bPercent, gbc);
		*/
		addComponent(content,row1,0,gridy++,1,1,1D,1D,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
		
		
		
		// add buttons to row2
		gbc.gridx = 0;
		gbc.gridy = 0;
		row2.setLayout(new GridLayout(1,4));
		row2.add(b7, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		row2.add(b8, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		row2.add(b9, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		row2.add(bTimes, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		addComponent(content,row2,0,gridy++,1,1,1D,1D,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
		
		// add buttons to row3
		gbc.gridx = 0;
		gbc.gridy = 0;
		row3.setLayout(new GridLayout(1,4));
		row3.add(b4, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		row3.add(b5, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		row3.add(b6, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		row3.add(bDivide, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		addComponent(content,row3,0,gridy++,1,1,1D,1D,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
		
		// add buttons to row4
		gbc.gridx = 0;
		gbc.gridy = 0;
		row4.setLayout(new GridLayout(1,4));
		row4.add(b1, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		row4.add(b2, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		row4.add(b3, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		row4.add(bAdd, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		addComponent(content,row4,0,gridy++,1,1,1D,1D,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
		
		
		// add buttons to row5
		gbc.gridx = 0;
		gbc.gridy = 0;
		row5.setLayout(new GridLayout(1,4));
		row5.add(b0, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		row5.add(bPoint, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		//row5.add(bSubtract, gbc);
		row5.add(bNegative, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		row5.add(bEquals, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		addComponent(content,row5,0,gridy++,1,1,1D,1D,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
		
		
		
		// 4. Set window's title and other attributes
		//setLayout(new GridLayout(1,1));
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		add(content);
		pack();
		setMinimumSize(new Dimension(400,500));
		Image image = new ImageIcon("icons/calculatorImage2.png").getImage();
		setIconImage(image);
		_dataTF.grabFocus();
	}
	
	private void addButtonListeners() {
		b1.addActionListener(new CalculationBtnListener());
		b2.addActionListener(new CalculationBtnListener());
		b3.addActionListener(new CalculationBtnListener());
		b4.addActionListener(new CalculationBtnListener());
		b5.addActionListener(new CalculationBtnListener());
		b6.addActionListener(new CalculationBtnListener());
		b7.addActionListener(new CalculationBtnListener());
		b8.addActionListener(new CalculationBtnListener());
		b9.addActionListener(new CalculationBtnListener());
		b0.addActionListener(new CalculationBtnListener());
		
		bTimes.addActionListener(new CalculationBtnListener());
		bDivide.addActionListener(new CalculationBtnListener());
		bAdd.addActionListener(new CalculationBtnListener());
		bSubtract.addActionListener(new CalculationBtnListener());
		bPoint.addActionListener(new CalculationBtnListener());
		bEquals.addActionListener(new CalculationBtnListener());
		
		bCE.addActionListener(new CalculationBtnListener());
		bC.addActionListener(new CalculationBtnListener());
		bDelete.addActionListener(new CalculationBtnListener());
		bNegative.addActionListener(new CalculationBtnListener());
		//bPercent.addActionListener(new CalculationBtnListener());
		
	}
	
	private void addComponent(Container container, Component component, 
			int gridx, 		int gridy, 
			int gridwidth, 	int gridheight, 
			double weightx, double weighty, 
			int anchor, 	int fill) {
		GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, 0,0);
		container.add(component, gbc);
	}
	
	class CalculationBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//System.out.println("Button hit");
			//String dataStr = _dataTF.getText();
			// int res = Integer.parseInt(dataStr)*CONSTANT_VALUE;
			//_resTF.setText("" + res);
			JButton b = (JButton)e.getSource();
			switch (b.getText()) {
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
				case "0":
				case ".":
					System.out.println(b.getText());
					buildNumber(b.getText());
					break;
					
				case "ON": // clear stack, clear op
					System.out.println(b.getText());
					break;
				case "LST X": // The LAST X register preserves the value that was last in <code>op</code> BEFORE execution of a numeric operation.
					System.out.println(b.getText());
					hitLastX();
					break;
				case "Del": // delete
					System.out.println(b.getText());
					break;
	
				case "CHS": // negation operator
					System.out.println(b.getText());
					applyNegationOperator();
					break;
					
				case "*":
					System.out.println(b.getText());
					applyMultiplicationOperator();
					break;
				case "/":
					System.out.println(b.getText());
					applyDivisionOperator();
					break;
				case "+":
					System.out.println(b.getText());
					applyAdditionOperator();
					break;
				case "-":
					System.out.println(b.getText());
					applySubtractionOperator();
					break;
					
				case "Enter":
					System.out.println(b.getText());
					enterCommand();
					break;
					
				default:
					System.out.println("other");
					break;
			}
			
		}
	}
	
	
	/*
	 * Resets all variables to initial state.
	 */
	private void powerButton() {
		 opStack = new Stack<Double>();
		 op = "";
		 _dataTF.setText("");
	}
	
	private void hitLastX() {
		opStack.push(lastX);
		_dataTF.setText(Double.toString(lastX));
	}
	
	/*
	 * This function blindly adds characters to the input string and does no checking.
	 */
	private void buildNumber(String s) {
		op = op + s;
		System.out.println("op = " + op);
		_dataTF.setText(op);
	}
	
	/*
	 * This command is really important.
	 * 1. Parse <code>op</code> string to extract double.
	 * 2. If legitimate, push this value to the <code>opStack</code>
	 * 3. Else, state that there was an error with the input and don't push anything.
	 */
	private void enterCommand() {
		// Test to see that<code>op</code>is in fact a legitimate number
		Double x;
		try {
			System.out.println("op = " + op);
			x = Double.parseDouble(op);
			opStack.push(x);
			System.out.println(opStack);
			op = "";
		}
		catch (NumberFormatException e) {
			System.out.println("Sytax error:" + op);
			_dataTF.setText("Sytax error: " + op);
			op = "";
			System.out.println(opStack);
		}
		
	}
	
	// Operators
	private void applyNegationOperator() {
		if (opStack.isEmpty()) enterCommand();
		// now apply negation operator to top item in opStack.
		Double v;
		try {
			v = opStack.pop();
			lastX = v;
			v = -v;
			opStack.push(v);
			_dataTF.setText(Double.toString(v));
			System.out.println(opStack);
		}
		catch (java.util.EmptyStackException e) {
			// do nothing in this case.
		}
	}
	
	private void applyMultiplicationOperator() {
		enterCommand();
		double a, b, v;
		try {
			a = opStack.pop();
			lastX = a;
			b = opStack.pop();
			v = a*b;
			opStack.push(v);
			System.out.println(Double.toString(v));
			_dataTF.setText(Double.toString(v));
		}
		catch (java.util.EmptyStackException e) {
			System.out.println("Stack underflow. ");
			_dataTF.setText("Stack underflow. ");
			System.out.println(opStack);
		}
	}
	
	private void applyDivisionOperator() {
		enterCommand();
		double a, b, v;
		try {
			a = opStack.pop();
			lastX = a;
			b = opStack.pop();
			if (a == 0) throw new IllegalArgumentException();
			v = b/a;
			opStack.push(v);
			System.out.println(Double.toString(v));
			_dataTF.setText(Double.toString(v));
		}
		catch (java.util.EmptyStackException e) {
			System.out.println("Stack underflow. ");
			_dataTF.setText("Stack underflow. ");
			System.out.println(opStack);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Div by 0 error");
		}
	}
	
	private void applyAdditionOperator() {
		enterCommand();
		double a, b, v;
		try {
			a = opStack.pop();
			lastX = a;
			b = opStack.pop();
			v = a+b;
			opStack.push(v);
			lastX = v;
			System.out.println(Double.toString(v));
			_dataTF.setText(Double.toString(v));
		}
		catch (java.util.EmptyStackException e) {
			System.out.println("Stack underflow. ");
			_dataTF.setText("Stack underflow. ");
			System.out.println(opStack);
		}
	}
	
	
	private void applySubtractionOperator() {
		enterCommand();
		double a, b, v;
		try {
			a = opStack.pop();
			lastX = a;
			b = opStack.pop();
			v = b-a;
			opStack.push(v);
			lastX = v;
			System.out.println(Double.toString(v));
			_dataTF.setText(Double.toString(v));
		}
		catch (java.util.EmptyStackException e) {
			System.out.println("Stack underflow. ");
			_dataTF.setText("Stack underflow. ");
			System.out.println(opStack);
		}
	}
	
	public Stack<Double> getOpStack() {
		return opStack;
	}
	public static void main(String[] args) {
		Calculator w = new Calculator();
		w.setVisible(true);
		//System.out.println("this is the output of the system.");
	}
}
