import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu implements ActionListener {

    public GUI gui;
    public ArrayList<Player> playerList = new ArrayList<>();
    public int playerFields = 2;

    public Menu(){
        setGui();
        playerScreen();
        gui.setClicked(false);
        gui.clearPanel();
        gameScreen();
    }


    public void gameScreen() {
        gui.addLabel("Velg spill");
        gui.addButton("Sixty Seconds");
        gui.addButton("Mitt skip er lastet med");
        gui.addButton("Bussrutå");
        gui.addButton("Musikk quiz");
        while(!(gui.isClicked())) System.out.println();
        new SixtySeconds(gui, playerList);
    }

    public void playerScreen() {
        gui.addButton("start");
        gui.addCustomButton("Legg til spiller", this);
        gui.addLabel("spiller 1:");
        gui.addUserText();
        gui.addLabel("spiller 2:");
        gui.addUserText();
        while(!gui.isClicked()) System.out.println();
        addPlayers();
    }

    public void addPlayers() {
        for(JTextField i :  gui.getUserText()) {
            playerList.add(new Player(i.getText()));
        }
    }

    public void setGui() {
        gui = new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gui.addLabel("spiller " + (playerFields+1) + ":");
        gui.addUserText();
        playerFields++;
    }
}
