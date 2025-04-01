import javax.swing.JLabel;
import javax.swing.JFrame;

public class Gui1 {
    JFrame j;
    JLabel l;
    //constructor
    Gui1(){
        j=new JFrame("My Window Program");
        j.setSize(500,500);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l=new JLabel("Welcome");
        j.add(l);
        j.setVisible(true);
    }
    public static void main(String[] args) {
        new Gui1();
    }
}
