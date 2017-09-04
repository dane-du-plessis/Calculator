import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.*;

class Calculator extends JFrame {
	private JPanel controlPanel;
	// data fields
	private JTextField _dataTF = new JTextField(3);
	// buttons
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
	
	private static final int CONSTANT_VALUE = 5;
	
	public Calculator() {
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		// 0. Button layout objects
		GridBagLayout gridLayout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setFont(new Font("SansSerif", Font.BOLD, 14));
		//setLayout(gridLayout);
		
		// 1. The panel to add them to.
		JPanel p = new JPanel();
		p.setBackground(Color.white);
		p.setLayout(gridLayout);
		
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
		
		
		// 2. Add the buttons
		
		//gbc.fill = GridBagConstraints.REMAINDER;
		gbc.weightx = 0;
		//gbc.weighty = 0;
		//gbc.anchor = GridBagConstraints.PAGE_START;
		//gbc.ipadx = 30;
		gbc.gridwidth = 3;
		p.add(_dataTF, gbc);
		
		
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		//gbc.weightx = 1;
		gbc.ipady = 0;
		gbc.ipadx = 0;
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		p.add(b1, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		p.add(b2, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		p.add(b3, gbc);
		//
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		p.add(b4, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		p.add(b5, gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		p.add(b6, gbc);
		// 
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		p.add(b7, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		p.add(b8, gbc);

		gbc.gridx = 2;
		gbc.gridy = 3;
		p.add(b9, gbc);
		//
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		p.add(b0, gbc);
		
		
		
		controlPanel.add(p);
		controlPanel.setMinimumSize(new Dimension(300,400));
		
		//setContentPane(p);
		//pack();
		//makeButton("", gridLayout, gbc);
		
		// 4. Set window's title and other attributes
		setLayout(new GridLayout(1,1));
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		add(controlPanel);
		setMinimumSize(new Dimension(300,400));
		Image image = new ImageIcon("icons/calculatorImage2.png").getImage();
		setIconImage(image);
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
