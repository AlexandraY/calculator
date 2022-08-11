package alexandria.yushina.gmailcom;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.awt.color.*;
/*
 * my imperfect calculator
 */
public class Calculator {

JPanel p0;
JPanel p1;
JPanel p2;

JPanel pc;
JPanel pe;
JPanel pn;
JPanel ps;


 JFormattedTextField displayField;
 JFormattedTextField displayFieldForAll;

 JButton button[]=new JButton[10];
 JButton buttonPoint;
 JButton buttonEqual;
 JButton buttonPlus;
 JButton buttonMinus;
 JButton buttonMult;
 JButton buttonDev;
 JButton buttonC;


Calculator() {

	CalculatorEngine calcEngine =new CalculatorEngine(this);
	
	//create a panel for number
	pc = new JPanel();
	GridLayout g1 =new GridLayout(3,3);
	pc.setLayout(g1);
	
	for (int i=0; i<10; i++) {
		button[i] = new JButton(""+i);  
	}

	pc.add(button[7]);
	pc.add(button[8]);
	pc.add(button[9]);

	pc.add(button[4]);
	pc.add(button[5]);
	pc.add(button[6]);

	pc.add(button[1]);
	pc.add(button[2]);
	pc.add(button[3]);
	
	///create a panel for east
	pe = new JPanel();
	GridLayout g2 =new GridLayout(2,1);
	pe.setLayout(g2);
	
	buttonPlus = new JButton("+");
	pe.add(buttonPlus);
	
	buttonPoint = new JButton(".");
	pe.add(buttonPoint);
	
	ps = new JPanel();
	GridLayout g3  = new GridLayout(1,2);
	ps.setLayout(g3);
	
	ps.add(button[0]);
	buttonEqual = new JButton("=");
	ps.add(buttonEqual);
	
	
	pn = new JPanel();
	GridLayout g5 =new  GridLayout(1,4);
	pn.setLayout(g5);
	
	buttonC = new JButton("C");
	buttonMinus = new JButton("-");
	buttonMult = new JButton("*");
	buttonDev = new JButton("/");

	pn.add(buttonC);
	pn.add(buttonDev);
	pn.add(buttonMult);
	pn.add(buttonMinus);
	
	///Create a panel for text
	
	displayField = new JFormattedTextField();
	displayField.setHorizontalAlignment(JTextField.RIGHT );
	
	displayFieldForAll = new JFormattedTextField();
	displayFieldForAll.setHorizontalAlignment(JTextField.RIGHT);
	displayFieldForAll.setBackground(new Color(1,200,200,200));

	
	p1 = new JPanel();
	GridLayout g4 = new GridLayout(2,1);
	p1.setLayout(g4);
	
	p1.add(displayField);
	p1.add(displayFieldForAll);
	
	p2 =new JPanel();
	BorderLayout b2 = new BorderLayout();
	p2.setLayout(b2);

	p2.add("North",pn);
	p2.add("Center",pc);
	p2.add("East",pe);
	p2.add("South",ps);
	
	///Create a panel for general placed
	
	p0 = new JPanel();
	BorderLayout b1 = new BorderLayout();
	p0.setLayout(b1);
	
	p0.add("North", p1);
	p0.add("South", p2);

	
	JFrame frame = new JFrame();
	
		
	frame.setContentPane(p0);
	//frame.setSize(400, 400);
	frame.pack();
		
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	
	frame.setLocation(height/4, width/4);

	LocalDateTime time= LocalDateTime.now();
	
	frame.setTitle(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(time) ); 
	frame.setVisible(true);
			
	for (int i=0; i<10; i++) {
		button[i].addActionListener(calcEngine);  
	}
	buttonPlus.addActionListener(calcEngine);
	buttonMinus.addActionListener(calcEngine);
	buttonDev.addActionListener(calcEngine);
	buttonMult.addActionListener(calcEngine);
	buttonEqual.addActionListener(calcEngine);
	buttonPoint.addActionListener(calcEngine);
	buttonC.addActionListener(calcEngine);
	
}
	public static void main(String[] args) {

		Calculator calc = new Calculator(); 
	}
}
