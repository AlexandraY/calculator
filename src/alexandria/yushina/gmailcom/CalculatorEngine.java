package alexandria.yushina.gmailcom;

import java.awt.event.ActionListener;
//import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener{
	
	Calculator parent;
	char selectedAction = ' '; //for + - * /
	double currentResult = 0;
	
	CalculatorEngine(Calculator parent){
		this.parent = parent;
	}
	
	public void actionPerformed(ActionEvent e) {
	
	JButton clickedButton=null;
	Object eventSource = e.getSource();
	if (eventSource instanceof JButton) {
		
		clickedButton = (JButton)eventSource;
		
		String clickedButtonLabel = clickedButton.getText();
		String dispFieldText = parent.displayField.getText();
		String dispFieldTextAll = parent.displayFieldForAll.getText();
		
		double displayValue=0;
		
		if (!"".equals(clickedButtonLabel)) {
			try {
			displayValue = Double.parseDouble(dispFieldText);
			} catch (Exception exc) {
			//	System.out.println("This is not a number");
			}
		}
		
		if (eventSource == parent.buttonPlus) {
			selectedAction = '+';
			currentResult  = displayValue;
			parent.displayField.setText("");
			parent.displayFieldForAll.setText(dispFieldTextAll+clickedButtonLabel);
		}else if (eventSource == parent.buttonC) {
			//selectedAction = 'C';
			parent.displayField.setText("");
			parent.displayFieldForAll.setText("");
		}else if (eventSource == parent.buttonMinus) {
				selectedAction = '-';
				currentResult = displayValue;
				parent.displayField.setText("");
				parent.displayFieldForAll.setText(dispFieldTextAll+clickedButtonLabel);
		}else if (eventSource == parent.buttonDev) {
			selectedAction = '/';
			currentResult = displayValue;
			parent.displayField.setText("");
			parent.displayFieldForAll.setText(dispFieldTextAll+clickedButtonLabel);
		}else if (eventSource == parent.buttonMult) {
			selectedAction = '*';
			currentResult = displayValue;
			parent.displayField.setText("");
			parent.displayFieldForAll.setText(dispFieldTextAll+clickedButtonLabel);
		}else if (eventSource == parent.buttonPoint) {
			currentResult = displayValue;
			///the second point is impossible
			if (clickedButtonLabel.indexOf('.') != -1) {
				parent.displayField.setText(dispFieldText+clickedButtonLabel);
				parent.displayFieldForAll.setText(dispFieldTextAll+clickedButtonLabel);
			}
		}else if (eventSource == parent.buttonEqual) {
				if (selectedAction == '+') {
					currentResult += displayValue;
					parent.displayField.setText("" + currentResult);
					parent.displayFieldForAll.setText(dispFieldTextAll + clickedButtonLabel+"" + currentResult);
					
				} else if (selectedAction == '-') {
					currentResult -= displayValue;
					parent.displayField.setText("" + currentResult);
					parent.displayFieldForAll.setText(dispFieldTextAll + clickedButtonLabel+"" + currentResult);
					
				} else if (selectedAction == '*') {
					currentResult *= displayValue;
					parent.displayField.setText("" + currentResult);
					parent.displayFieldForAll.setText(dispFieldTextAll + clickedButtonLabel+"" + currentResult);
					
				} else if (selectedAction == '/') {
					
						if (displayValue !=0){
						currentResult /= displayValue;
						parent.displayField.setText("" + currentResult);
						parent.displayFieldForAll.setText(dispFieldTextAll + clickedButtonLabel+"" + currentResult);
						} else {
							parent.displayField.setText("" + currentResult); //previouse result
							parent.displayFieldForAll.setText(dispFieldTextAll.substring(0, dispFieldTextAll.length()-1));
							parent.displayField.setText("It is forbidden devision by zero");
							
						}
				}
		} else {
			
		parent.displayField.setText(dispFieldText+clickedButtonLabel);
		parent.displayFieldForAll.setText(dispFieldTextAll+clickedButtonLabel);
	}
	}
	}
}
