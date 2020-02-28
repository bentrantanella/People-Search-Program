import javax.swing.*;
import BreezySwing.*;


public class SearchGUI extends GBFrame {
	
	public static void main(String[] args) {
		JFrame frm = new SearchGUI();
		frm.setTitle("People Search");
		frm.setSize(600, 200);
		frm.setVisible(true);
		
	}

	
	JLabel addStudentLabel = addLabel("Add a new student:",1,1,2,1);
	JLabel nameLabel = addLabel("Name:",2,1,1,1);
	JTextField nameField = addTextField("",2,2,1,1);
	JLabel ageLabel = addLabel("Age:",2,3,1,1);
	IntegerField ageField = addIntegerField(0,2,4,1,1);
	JButton addButton = addButton("Add",2,5,1,1);
	
	JButton seqSearchButton = addButton("Sequential Search",3,1,1,1);
	JButton binSearchButton = addButton("Binary Search",3,2,1,1);
	JButton printButton = addButton("Print",3,3,1,1);
	
	JTextArea outputArea = addTextArea("",4,1,4,1);
	
	public SearchGUI() {
		seqSearchButton.setEnabled(false);
		binSearchButton.setEnabled(false);
		printButton.setEnabled(false);
	}
	
	int arrcount = 0;
	People[] finalarr;
	String output = "";
	
	
	public void buttonClicked(JButton button) {
		if (button == addButton) {
			if (isWhitespace(nameField.getText()) || ageField.getNumber() <= 0) {
				messageBox("Invalid Inputs");
				return;
			}
			
			People p = new People(ageField.getNumber(), nameField.getText());
			if (arrcount == 0) {
				finalarr = new People[1];
				finalarr[0] = p;
			} else {
				People[] temparr = new People[arrcount];
				for(int i = 0; i < finalarr.length; i++)
					temparr[i] = finalarr[i];
				
				finalarr = new People[arrcount + 1];
				for(int i = 0; i < finalarr.length - 1; i++)
					finalarr[i] = temparr[i];
				
				finalarr[arrcount] = p;
				
				
			}
			
			output += nameField.getText() + ", " + ageField.getNumber() + "\n\n";
			outputArea.setText(output);
			
			arrcount++;
			
			seqSearchButton.setEnabled(true);
			binSearchButton.setEnabled(true);
			printButton.setEnabled(true);
			
		}
		
		if (button == seqSearchButton) {
			
		}
		
		if (button == binSearchButton) {
			
		}
		
		if (button == printButton) {
			String output = "";
			
			for(int i = 0; i < finalarr.length; i++) {
				output += finalarr[i].getName() + ", " + finalarr[i].getAge() + "\n";
			}
			
			messageBox(output);
		}
	}
	
	public boolean isWhitespace(String s) {
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ')
				return false;
		}
		return true;
	}
}
