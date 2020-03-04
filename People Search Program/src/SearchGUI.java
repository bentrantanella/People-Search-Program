import javax.swing.*;
import BreezySwing.*;


public class SearchGUI extends GBFrame {
	
	public static void main(String[] args) {
		JFrame frm = new SearchGUI();
		frm.setTitle("People Search");
		frm.setSize(700, 400);
		frm.setVisible(true);
	}

	
	JLabel addStudentLabel = addLabel("Add a new student:",1,1,2,1);
	JLabel nameLabel = addLabel("Name:",2,1,1,1);
	JTextField nameField = addTextField("",2,2,1,1);
	JLabel ageLabel = addLabel("Age:",2,3,1,1);
	IntegerField ageField = addIntegerField(0,2,4,1,1);
	JButton addButton = addButton("Add",2,5,1,1);
	
	JLabel searchLabel = addLabel("Search: ",3,1,1,1);
	JTextField searchField = addTextField("",3,2,1,1);
	JButton seqSearchButton = addButton("Sequential Search",3,3,2,1);
	JButton binSearchButton = addButton("Binary Search",3,5,1,1);
	JButton printButton = addButton("Print Alphabetically",7,1,2,1);
	
	JTextArea outputArea = addTextArea("",4,1,5,3);
	
	public SearchGUI() {
		seqSearchButton.setEnabled(false);
		binSearchButton.setEnabled(false);
		printButton.setEnabled(false);
		searchField.setEditable(false);
	}
	
	String output = "";
	
	ArrayList a = new ArrayList();
	
	public void buttonClicked(JButton button) {
		if (button == addButton) {
			if (isWhitespace(nameField.getText()) || ageField.getNumber() <= 0) {
				messageBox("Invalid Inputs");
				return;
			}
			
			People person = new People(ageField.getNumber(), nameField.getText());
			
			a.addPerson(person);
			
			People[] arr = a.getFinalarr();
			System.out.println(arr.length);
			String out = "";
			for(int i = 0; i < arr.length; i++) {
				out += arr[i].getName() + ", " + arr[i].getAge() + "\n\n";
			}
			
			outputArea.setText(out);
			
			seqSearchButton.setEnabled(true);
			binSearchButton.setEnabled(true);
			printButton.setEnabled(true);
			searchField.setEditable(true);
			
			nameField.setText("");
			ageField.setNumber(0);
			
		}
		
		if (button == seqSearchButton) {
			People p = a.searchArray(false, searchField.getText());
			PersonFound f = new PersonFound(this, a.getFinalarr(), a, false, p);
			
			
			People[] arr = a.getFinalarr();
			System.out.println(arr.length);
			String out = "";
			for(int i = 0; i < arr.length; i++) {
				out += arr[i].getName() + ", " + arr[i].getAge() + "\n\n";
			}
			
			outputArea.setText(out);
			
			searchField.setText("");
		}
		
		if (button == binSearchButton) {
			People p = a.searchArray(true,  searchField.getText());
			PersonFound f = new PersonFound(this, a.getFinalarr(), a, true, p);
			
			
			People[] arr = a.getFinalarr();
			System.out.println(arr.length);
			String out = "";
			for(int i = 0; i < arr.length; i++) {
				out += arr[i].getName() + ", " + arr[i].getAge() + "\n\n";
			}
			
			outputArea.setText(out);
			
			searchField.setText("");
		}
		
		if (button == printButton) {
			a.sort();
			People[] arr = a.getFinalarr();
			
			String out = "";
			for(int i = 0; i < arr.length; i++) {
				out += arr[i].getName() + ", " + arr[i].getAge() + "\n\n";
			}
			
			messageBox(out);
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
