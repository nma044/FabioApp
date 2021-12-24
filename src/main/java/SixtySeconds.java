import java.util.ArrayList;
import java.util.Scanner;

public class SixtySeconds {
    public ArrayList<Player> playerList;
    public int round = 60;
    public GUI gui;

    public SixtySeconds(GUI gu, ArrayList<Player> players){
        playerList = players;
        gui = gu;
        gu.clearPanel();
        gu.addLabel("");
        gu.addButton("");
        play();
        new Menu();
    }

    private void setGui() {
        gui = new GUI();
        gui.addLabel("Sixty Seconds");
        gui.addButton("klikk");
    }

    private void setRoundTime() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Skriv inn rundelengde sekunder (Tomt for 60 sekunder)");
        if(scan.hasNextInt()) round = scan.nextInt();
        return;
    }

    private void play() {
            for (Player i : playerList) {
                gui.setClicked(false);
                gui.setText(0, i.getName() + " sin tur! Trykk stopp når det har gått " + round + " sekunder!");
                gui.setButtonText(0,"Trykk for å starte timer");
                while (!gui.isClicked()) {
                    System.out.println();
                }
                gui.setClicked(false);;
                long start = System.currentTimeMillis();
                gui.setButtonText(0,"Timer startet, trykk for å stoppe");
                while (!gui.isClicked()) {
                    System.out.println();
                }
                long slutt = System.currentTimeMillis();
                int tid = ((int)slutt - (int)start) / 1000;
                int slurker = Math.abs(round - tid);
                gui.setText(0, i.getName() + " stoppet etter " + tid + " sekunder, og må drikke " + slurker + " slurker!");
                gui.setClicked(false);
                gui.setButtonText(0,"Trykk for å gå videre");
                while (!gui.isClicked()) {
                    System.out.println();
                }
            }
        }


    private void addplayers() {
        System.out.println("Legg til spiller: (Tom for ferdig)");
        Scanner scan = new Scanner(System.in);
        String navn = null;
        while(!(navn = scan.nextLine()).isEmpty()) {
            playerList.add(new Player(navn));
            System.out.println("Legg til spiller: (Tom for ferdig)");
        }
    }

    public void setRound(int secs) {
        round = secs;
    }


}
