# Java Swing Documentation

## Introduction
Swing is a GUI (Graphical User Interface) toolkit in Java that provides a set of lightweight components for building rich desktop applications. It is part of Java's standard library (`javax.swing` package) and is built on top of AWT (Abstract Window Toolkit).

## Features of Swing
- **Lightweight**: Does not rely on native OS components.
- **Pluggable Look and Feel**: Can change appearance without modifying underlying functionality.
- **Event-Driven**: Uses listeners for user interactions.
- **Rich Components**: Provides advanced UI elements like tables, trees, and sliders.
- **MVC Architecture**: Uses Model-View-Controller design pattern.

## Setting Up Swing
Swing is included in Java SE, so no external setup is required. Simply import the `javax.swing` package:

```java
import javax.swing.*;
```

## Creating a Basic Swing Application
```java
import javax.swing.*;

public class SwingExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Swing Example");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JLabel label = new JLabel("Hello, Swing!", SwingConstants.CENTER);
            frame.add(label);
            
            frame.setVisible(true);
        });
    }
}
```

## Common Swing Components
| Component | Description |
|-----------|------------|
| `JFrame`  | Main application window |
| `JPanel`  | Container for components |
| `JLabel`  | Displays text or images |
| `JButton` | Clickable button |
| `JTextField` | Single-line text input |
| `JTextArea` | Multi-line text input |
| `JCheckBox` | Checkbox for selection |
| `JRadioButton` | Radio button for exclusive selection |
| `JComboBox` | Dropdown list |
| `JTable` | Displays tabular data |

## Event Handling in Swing
Swing uses the **Event Delegation Model**, where components listen for user actions. Example of handling a button click:

```java
import javax.swing.*;
import java.awt.event.*;

public class ButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example");
        JButton button = new JButton("Click Me");
        
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Button Clicked!"));
        
        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

## Swing Layout Managers
Swing provides various layout managers to arrange components:
- **FlowLayout**: Places components in a row.
- **BorderLayout**: Divides the container into five regions (NORTH, SOUTH, EAST, WEST, CENTER).
- **GridLayout**: Arranges components in a grid of rows and columns.
- **BoxLayout**: Places components in a single row or column.
- **GridBagLayout**: More flexible grid-based layout.

## Advanced Topics
### **1. JMenu and JMenuBar**
Menus can be added to a Swing application:
```java
JMenuBar menuBar = new JMenuBar();
JMenu menu = new JMenu("File");
JMenuItem menuItem = new JMenuItem("Open");
menu.add(menuItem);
menuBar.add(menu);
frame.setJMenuBar(menuBar);
```

### **2. JTable for Tabular Data**
```java
String[][] data = {{"1", "Alice"}, {"2", "Bob"}};
String[] columns = {"ID", "Name"};
JTable table = new JTable(data, columns);
frame.add(new JScrollPane(table));
```

### **3. JTabbedPane for Multiple Tabs**
```java
JTabbedPane tabbedPane = new JTabbedPane();
tabbedPane.addTab("Tab 1", new JLabel("Content of Tab 1"));
frame.add(tabbedPane);
```

## Conclusion
Swing is a powerful toolkit for developing Java desktop applications. With its rich set of components, event handling mechanism, and layout management, Swing remains a popular choice for GUI-based Java applications.

---

For more details, refer to the [official Java Swing documentation](https://docs.oracle.com/javase/tutorial/uiswing/).

