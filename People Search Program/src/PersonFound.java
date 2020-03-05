
import javax.swing.*;
import BreezySwing.*;

public class PersonFound extends GBDialog {
	
	People[] people;
	ArrayList array;
	boolean isbin;
	People person;
	
	
	public PersonFound(JFrame frm, People[] p, ArrayList a, boolean b, People s) {
		super(frm);
		
		
		people = p;
		array = a;
		isbin = b;
		person = s;
		
		if (s == null) {
			textLabel.setText("The searched person is not in the array");
			editButton.setVisible(false);
			deleteButton.setVisible(false);
		} else {
			textLabel.setText("Person found: " + person.getName() + ", " + person.getAge());
		}
		
		if (isbin == true)
			counterLabel.setText("Number of comparisons: " + array.getBincount());
		else counterLabel.setText("Number of comparisons: " + array.getSeqcount());
		
		nameLabel.setVisible(false);
		nameField.setVisible(false);
		nchangeButton.setVisible(false);
		ageLabel.setVisible(false);
		ageField.setVisible(false);
		achangeButton.setVisible(false);
		
		setTitle("Search");
		setSize(600,400);
		setVisible(true);
		
	}
	
	JLabel textLabel = addLabel("",1,1,2,1);
	JLabel counterLabel = addLabel("",1,3,1,1);
	
	JButton editButton = addButton("Edit person",2,1,1,1);
	JButton deleteButton = addButton("Delete Person",2,2,1,1);
	JButton exitButton = addButton("Exit",2,3,1,1);
	
	JLabel nameLabel = addLabel("Name: ",3,1,1,1);
	JTextField nameField = addTextField("",3,2,1,1);
	JButton nchangeButton = addButton("Edit",3,3,1,1);
	
	JLabel ageLabel = addLabel("Age: ",4,1,1,1);
	IntegerField ageField = addIntegerField(0,4,2,1,1);
	JButton achangeButton = addButton("Edit",4,3,1,1);
	
	public void buttonClicked(JButton button) {
		if (button == editButton) {
			nameLabel.setVisible(true);
			nameField.setVisible(true);
			nchangeButton.setVisible(true);
			ageLabel.setVisible(true);
			ageField.setVisible(true);
			achangeButton.setVisible(true);
			
		}
		
		if (button == deleteButton) {
			array.removePerson(person);
			dispose();
		}
		
		if (button == exitButton) {
			dispose();
		}
		
		if (button == nchangeButton) {
			if (isWhitespace(nameField.getText())) {
				messageBox("Invalid input");
				return;
			}
			person.setName(nameField.getText());
			
			
			nameField.setText("");
		}
		
		if (button == achangeButton) {
			if (!ageField.isValidNumber() || ageField.getNumber() <= 0) {
				messageBox("Invalid Input");
			}
			person.setAge(ageField.getNumber());
			
			ageField.setNumber(0);
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
