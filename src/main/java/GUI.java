import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI implements ActionListener {
    private JPanel panel;
    private boolean clicked = false;
    private JFrame frame = new JFrame();
    private ArrayList<JLabel> labels = new ArrayList<>();
    private ArrayList<JButton> buttons = new ArrayList<>();
    private ArrayList<JTextField> userText = new ArrayList<>();



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
        panel.setBackground(Color.DARK_GRAY);
    }
    // process the button clicks
    public void actionPerformed(ActionEvent e) {
        clicked = true;
    }

    public void setClicked(Boolean bool){
        clicked = bool;
    }

    public void setText(int index, String text) {
        labels.get(index).setText(text);
        frame.revalidate();
        frame.repaint();
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setButtonText(int index, String buttonText) {
        buttons.get(index).setText(buttonText);
        frame.revalidate();
        frame.repaint();
    }

    public void addButton(String buttonText){
        JButton butt = new JButton(buttonText);
        butt.setBackground(Color.lightGray);
        butt.setForeground(Color.black);
        panel.add(butt);
        buttons.add(butt);
        butt.addActionListener(this);
        frame.revalidate();
        frame.repaint();
    }

    public void addUserText(){
        JTextField textField = new JTextField();
        panel.add(textField);
        userText.add(textField);
        frame.revalidate();
        frame.repaint();
    }

    public void addLabel(String labelText){
        JLabel label = new JLabel(labelText);
        label.setForeground(Color.lightGray);
        panel.add(label);
        labels.add(label);
        frame.revalidate();
        frame.repaint();
    }

    public String getUserText(int index){
        return userText.get(index).getText();
    }

    public void removeButton(int index){
        panel.remove(buttons.get(0));
        buttons.remove(index);
    }

    public void addCustomButton(String buttontext, ActionListener act){
        JButton butt = new JButton(buttontext);
        butt.setBackground(Color.lightGray);
        butt.setForeground(Color.black);
        panel.add(butt);
        buttons.add(butt);
        butt.addActionListener(act);
        frame.revalidate();
        frame.repaint();
    }

    public ArrayList<JTextField> getUserText() {
        return userText;
    }

    public void setUserText(String text, int index){
        userText.get(index).setText(text);
    }

    public void clearPanel(){
        panel.removeAll();
        labels.clear();
        buttons.clear();
        userText.clear();
    }

    public ArrayList<JButton> getButtons() {
        return buttons;
    }

    public ArrayList<JLabel> getLabels() {
        return labels;
    }
}
