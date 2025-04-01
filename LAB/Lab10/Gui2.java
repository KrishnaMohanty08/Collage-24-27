import javax.swing.*;
import java.awt.event.*;

class MySwing1 extends JFrame implements ActionListener {
    JLabel l;
    JButton b;

    // Constructor
    MySwing1() {
        // Set up JFrame properties
        super("My Window");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Using absolute positioning

        // Label
        l = new JLabel("Welcome");
        l.setBounds(100, 50, 100, 30);
        add(l);

        // Button
        b = new JButton("Click");
        b.setBounds(100, 100, 80, 40);
        add(b);

        // Register event listener
        b.addActionListener(this);

        setVisible(true);
    }

    // Event Handling
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Click")) { // Case-sensitive fix
            l.setText("Bye");
        }
    }
}

public class Gui2 {
    public static void main(String[] args) {
        new MySwing1();
    }
}
