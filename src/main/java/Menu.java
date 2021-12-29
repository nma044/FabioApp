import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu implements ActionListener {

    public GUI gui;
    public ArrayList<Player> playerList = new ArrayList<>();
    public int playerFields = 2;
    boolean sixty = false;
    public String[] type = {"Hjerter","Kløver","Ruter","Spar"};
    public String[] tall = {"To","Tre","Fire","Fem","Seks","Syv","Åtte","Ni","Ti","Knekt","Dame","Konge","Ess"};

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
        gui.addCustomButton("Legg til flere spillere", this);
    }

    public void playerScreen() {
        gui.addCustomButton("start",this);
        gui.addCustomButton("Legg til spiller", this);
        gui.addLabel("spiller 1:");
        gui.addUserText();
        gui.addLabel("spiller 2:");
        gui.addUserText();
    }

    private void newPLayerScreen() {
        gui.clearPanel();
        gui.addCustomButton("start",this);
        gui.addCustomButton("Legg til spiller", this);
        playerFields = 0;
        for(int i = 0; i<playerList.size();i++){
            gui.addLabel("spiller " + (i+1) + ":");
            gui.addUserText();
            gui.getUserText().get(i).setText(playerList.get(i).getName());
            playerFields++;
        }
    }

    public void addPlayers() {
        playerList.clear();
        for (JTextField i : gui.getUserText()) {
            if (!(i.getText().isEmpty())) playerList.add(new Player(i.getText()));
        }
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sixtyButton = null;
        JButton mittSkipButton = null;
        JButton spillerButton = null;
        JButton startButton = null;
        JButton backButton = null;
        JButton leggTilButton = null;
        for (JButton i : gui.getButtons()) {
            if (i.getText() == "Sixty Seconds") sixtyButton = i;
            if (i.getText() == "Mitt skip er lastet med") mittSkipButton = i;
            if (i.getText() == "Legg til spiller") spillerButton = i;
            if (i.getText() == "start") startButton = i;
            if (i.getText() == "Tilbake") backButton = i;
            if (i.getText() == "Legg til flere spillere") leggTilButton = i;
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
        if(e.getSource().equals(sixtyButton)) new SixtySeconds(gui, this);
        if(e.getSource().equals(mittSkipButton)) new MittSkip(gui, this);
        if(e.getSource().equals(backButton)) gameScreen();
        if(e.getSource().equals(leggTilButton)) newPLayerScreen();
    }

}
