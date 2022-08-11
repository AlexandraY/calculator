import javax.swing.*;
import java.awt.GridLayout;

public class SimpleCalculatorGrid {

	public static void main(String[] args) {
		JPanel windowContent = new JPanel();
		GridLayout gr = new GridLayout(4,2,5,5);
		
		windowContent.setLayout(gr);
		
		JLabel label1 = new JLabel("Number 1:");
		JTextField field1 = new JTextField(10);
		
		JLabel label2 = new JLabel("Number 2:");
		JTextField field2=new JTextField(10);
		
		JLabel label3 = new JLabel("Sum:");
		JTextField field3=new JTextField(10);
		
		JButton go = new JButton("Add");
		
		windowContent.add(label1);
		windowContent.add(field1);
		windowContent.add(label2);
		windowContent.add(field2);
		windowContent.add(label3);
		windowContent.add(field3);
		windowContent.add(go);

		JFrame frame = new JFrame("My first calculator");
		frame.setContentPane(windowContent);
		
		frame.setSize(400,100);
		frame.setVisible(true);

	}

}
