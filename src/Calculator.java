import java.awt.*;
import java.awt.event.ActionListener;
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
	
	private JButton bCE       	= new JButton("CE");
	private JButton bC       	= new JButton("C");
	private JButton bDelete   	= new JButton("Del");
	private JButton bNegative 	= new JButton("\u00B1");
	private JButton bPercent  	= new JButton("%");
	
	private static final int CONSTANT_VALUE = 5;
	
	private static final Insets insets = new Insets(2, 2, 2, 2);
	
	public Calculator() {
		/* Build the GUI */
		buildGUI();
		addButtonListeners();
		
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
		
		bEquals.setBackground(Color.CYAN);
		
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
		row1.setLayout(new GridLayout(1,5));
		
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
		row1.add(bNegative, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 0;
		row1.add(bPercent, gbc);
		
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
		row5.add(bSubtract, gbc);
		
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
		bPercent.addActionListener(new CalculationBtnListener());
		
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
			System.out.println("Button hit");
			//String dataStr = _dataTF.getText();
			// int res = Integer.parseInt(dataStr)*CONSTANT_VALUE;
			//_resTF.setText("" + res);
			JButton b = (JButton)e.getSource();
			switch (b.getText()) {
			case "1":
				System.out.println(b.getText());
				break;
			case "2":
				System.out.println(b.getText());
				break;
			case "3":
				System.out.println(b.getText());
				break;
			case "4":
				System.out.println(b.getText());
				break;
			case "5":
				System.out.println(b.getText());
				break;
			case "6":
				System.out.println(b.getText());
				break;
			case "7":
				System.out.println(b.getText());
				break;
			case "8":
				System.out.println(b.getText());
				break;
			case "9":
				System.out.println(b.getText());
				break;
			case "0":
				System.out.println(b.getText());
				break;
				
			case "C":
				System.out.println(b.getText());
				break;
			case "CE":
				System.out.println(b.getText());
				break;
			case "Del":
				System.out.println(b.getText());
				break;
			case "\u00B1":
				System.out.println(b.getText());
				break;
			case "%":
				System.out.println(b.getText());
				break;
			case "*":
				System.out.println(b.getText());
				break;
			case "/":
				System.out.println(b.getText());
				break;
			case "+":
				System.out.println(b.getText());
				break;
			case "Enter":
				System.out.println(b.getText());
				break;
			case ".":
				System.out.println(b.getText());
				break;
			case "-":
				System.out.println(b.getText());
				break;
				
			default:
				System.out.println("other");
				break;
			}
			
		}
	}
	
	private void appendNumberSymbol(String s) {
		
	}
	
	public static void main(String[] args) {
		Calculator w = new Calculator();
		w.setVisible(true);
		System.out.println("this is the output of the system.");
	}
}
