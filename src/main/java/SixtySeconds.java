import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class SixtySeconds implements ActionListener {
    public ArrayList<Player> playerList;
    public int round = 60;
    public GUI gui;
    public long start;
    public long slutt;
    public JLabel label;
    public JButton button;
    public int player = 0;
    public boolean timer = false;
    public boolean newTurn = false;
    private Menu menu;

    public SixtySeconds(GUI gu, Menu men) {
        playerList = men.getPlayerList();
        gui = gu;
        gu.clearPanel();
        gu.addLabel("");
        gu.addCustomButton("", this);
        gu.addCustomButton("Tilbake", men);
        label = gu.getLabels().get(0);
        button = gu.getButtons().get(0);
        menu = men;
        newPlayerTurn();
    }

    public void newPlayerTurn(){
        newTurn = false;
        label.setText(playerList.get(player).getName() + " stop timeren når det har gått " + round + " sekunder!");
        button.setText("Trykk for å starte timer");
    }

    public void setRound(int secs) {
        round = secs;
    }

    public void actionPerformed(ActionEvent e) {
        if(newTurn) newPlayerTurn();
        else if(!timer) startTimer();
        else stopTimer();
    }

    private void stopTimer() {
        timer = false;
        slutt = System.currentTimeMillis();
        int tid = ((int) slutt - (int) start) / 1000;
        int slurker = Math.abs(round - tid);
        label.setText(playerList.get(player).getName() + " stoppet etter " + tid + " sekunder, og må drikke " + slurker + " slurker!");
        button.setText("Trykk for å gå videre");
        player++;
        if(player>(playerList.size()-1)) player = 0;
        newTurn = true;
    }

    private void startTimer() {
        timer = true;
        start = System.currentTimeMillis();
        button.setText("Timer startet, trykk for å stoppe");
    }
}