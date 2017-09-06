import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.*;

class Calculator extends JFrame {
	private JPanel content;
	// data fields
	private JTextField _dataTF = new JTextField(10);
	// buttons - consider using an array
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	JButton b5 = new JButton("5");
	JButton b6 = new JButton("6");
	JButton b7 = new JButton("7");
	JButton b8 = new JButton("8");
	JButton b9 = new JButton("9");
	JButton b0 = new JButton("0");
	JButton bTimes = new JButton("*");
	JButton bDivide = new JButton("/");
	JButton bAdd = new JButton("+");
	JButton bSubtract = new JButton("-");
	JButton bPoint = new JButton(".");
	JButton bEquals = new JButton("=");
	
	private static final int CONSTANT_VALUE = 5;
	
	private static final Insets insets = new Insets(2, 2, 2, 2);
	
	public Calculator() {
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
		
		b1.setSize(30, 35);
		b2.setSize(30, 35);
		b3.setSize(30, 35);
		b4.setSize(30, 35);
		b5.setSize(30, 35);
		b6.setSize(30, 35);
		b7.setSize(30, 35);
		b8.setSize(30, 35);
		b9.setSize(30, 35);
		b0.setSize(30, 35);
		
		JPanel row1 = new JPanel();
		JPanel row2 = new JPanel();
		JPanel row3 = new JPanel();
		JPanel row4 = new JPanel();
		JPanel row5 = new JPanel();

		
		// add display to row1
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		row1.setLayout(new GridBagLayout());
		row1.add(_dataTF, gbc);
		int gridy = 0;
		addComponent(content,row1,0,gridy++,1,1,1D,1D,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
		
		// add buttons to row2
		gbc.gridx = 0;
		gbc.gridy = 0;
		row2.setLayout(new GridBagLayout());
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
		row3.setLayout(new GridBagLayout());
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
		row4.setLayout(new GridBagLayout());
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
		row5.setLayout(new GridBagLayout());
		row5.add(b0, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		row5.add(bPoint, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		row5.add(bEquals, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 0;
		row5.add(bSubtract, gbc);
		
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
		//setMinimumSize(new Dimension(300,400));
		Image image = new ImageIcon("icons/calculatorImage2.png").getImage();
		setIconImage(image);
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
			String dataStr = _dataTF.getText();
			// int res = Integer.parseInt(dataStr)*CONSTANT_VALUE;
			//_resTF.setText("" + res);
		}
	}
	
	public static void main(String[] args) {
		Calculator w = new Calculator();
		w.setVisible(true);
	}
}
