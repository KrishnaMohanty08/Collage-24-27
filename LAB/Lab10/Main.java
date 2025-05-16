import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class StudentForm extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, ans;
	JTextField t1, t2;
	JRadioButton rb1, rb2;
	JButton b;
	JCheckBox check;
	String[] departments = {"CSE", "ECE", "EEE", "Mechanical", "Civil"};

	StudentForm(){
		setTitle("Student Form"); 

		l1 = new JLabel("Enter your name");
		l1.setBounds(60, 40, 200, 30);
		t1 = new JTextField();
		t1.setBounds(60, 70, 200, 30);

		l2 = new JLabel("Enter your roll number");
		l2.setBounds(60, 110, 200, 30);
		t2 = new JTextField();
		t2.setBounds(60, 140, 200, 30);

		l3 = new JLabel("Enter your gender");
		l3.setBounds(60, 180, 200, 30);
		rb1 = new JRadioButton("Male");
		rb1.setBounds(60, 210, 90, 30);
		rb2 = new JRadioButton("Female");
		rb2.setBounds(160, 210, 100, 30);

		check = new JCheckBox("Are you 18+?");
		check.setBounds(60, 320, 200, 30);

		b = new JButton("Submit");
		b.setBounds(60, 360, 200, 30);

		ans = new JLabel();
		ans.setBounds(60, 400, 500, 30);

		// Sabko add kardo bc
		add(l1); add(t1);
		add(l2); add(t2);
		add(l3); add(rb1); add(rb2);
		add(rb1);
		add(rb2);
		add(check);
		add(b); add(ans);


		b.addActionListener(this);

		setSize(600, 500);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e){
		String name = t1.getText();
		String roll = t2.getText();
		String gender = rb1.isSelected() ? "Male" : rb2.isSelected() ? "Female" : "Not selected";
		String ageStatus = check.isSelected() ? "18 or older" : "Under 18";

		ans.setText("Name: " + name + ", Roll: " + roll + ", Gender: " + gender + ",  Age: " + ageStatus);
	}
}

public class Main {
	public static void main(String[] args) {
		new StudentForm();
	}
}