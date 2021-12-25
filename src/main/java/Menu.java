import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu implements ActionListener {

    public GUI gui;
    public ArrayList<Player> playerList = new ArrayList<>();
    public int playerFields = 2;
    boolean sixty = false;

    public Menu(GUI gu) {
        gui = gu;
        gui.clearPanel();
        playerScreen();
    }


    public void gameScreen() {
        gui.clearPanel();
        gui.addLabel("Velg spill");
        gui.addCustomButton("Sixty Seconds", this);
        gui.addCustomButton("Mitt skip er lastet med", this);
        gui.addButton("Bussrutå");
        gui.addButton("Musikk quiz");
    }

    public void playerScreen() {
        gui.addCustomButton("start",this);
        gui.addCustomButton("Legg til spiller", this);
        gui.addLabel("spiller 1:");
        gui.addUserText();
        gui.addLabel("spiller 2:");
        gui.addUserText();
    }

    public void addPlayers() {
        for (JTextField i : gui.getUserText()) {
            if (!(i.getText().isEmpty())) playerList.add(new Player(i.getText()));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sixtyButton = null;
        JButton mittSkipButton = null;
        JButton spillerButton = null;
        JButton startButton = null;
        for (JButton i : gui.getButtons()) {
            if (i.getText() == "Sixty Seconds") sixtyButton = i;
            if (i.getText() == "Mitt skip er lastet med") mittSkipButton = i;
            if (i.getText() == "Legg til spiller") spillerButton = i;
            if (i.getText() == "start") startButton = i;
        }
        if(e.getSource().equals(spillerButton)){
        gui.addLabel("spiller " + (playerFields + 1) + ":");
        gui.addUserText();
        playerFields++;
        }
        if(e.getSource().equals((startButton))){
            addPlayers();
            gameScreen();
        }
        if(e.getSource().equals(sixtyButton)) new SixtySeconds(gui, playerList);
        if(e.getSource().equals(mittSkipButton)) new MittSkip(gui);
    }

}
