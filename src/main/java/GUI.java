import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI implements ActionListener {
    private JPanel panel;
    private boolean clicked = false;
    private JLabel label = new JLabel("Text");
    private JFrame frame = new JFrame();
    ArrayList<JButton> buttons = new ArrayList<>();

    public GUI() {
        // the panel with the button and text
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 400);
        panel.add(label);
    }
    // process the button clicks
    public void actionPerformed(ActionEvent e) {
        clicked = true;
    }

    public void setClicked(Boolean bool){
        clicked = bool;
    }

    public void setText(String text) {
        label.setText(text);
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setButtonText(int index, String buttonText) {
        buttons.get(index).setText(buttonText);
    }
    public void addButton(String buttontext){
        JButton butt = new JButton(buttontext);
        panel.add(butt);
        buttons.add(butt);
        butt.addActionListener(this);
    }


}
