import java.util.ArrayList;
import java.util.Scanner;

public class SixtySeconds {
    public ArrayList<Player> playerList = new ArrayList<>();
    public Boolean playing;
    public int round = 60;
    public GUI gui;

    public SixtySeconds(){
        addplayers();
        setRoundTime();
        setGui();
        playing = true;
        play();
    }

    private void setGui() {
        gui = new GUI();
        gui.setText("Sixty Seconds");
        gui.addButton("klikk");
    }

    private void setRoundTime() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Skriv inn rundelengde sekunder (Tomt for 60 sekunder)");
        if(scan.hasNextInt()) round = scan.nextInt();
        return;
    }

    private void play() {
        while (playing) {
            for (Player i : playerList) {
                gui.setClicked(false);
                gui.setText(i.getName() + " sin tur! Trykk stopp når det har gått " + round + " sekunder!");
                while (!gui.isClicked()) gui.setButtonText(0,"Trykk for å starte timer");
                gui.setClicked(false);;
                long start = System.currentTimeMillis();
                while (!gui.isClicked()) gui.setButtonText(0,"Timer startet, trykk for å stoppe");
                long slutt = System.currentTimeMillis();
                int tid = ((int)slutt - (int)start) / 1000;
                int slurker = Math.abs(round - tid);
                gui.setText(i.getName() + " stoppet etter " + tid + " sekunder, og må drikke " + slurker + " slurker!");
                gui.setClicked(false);
                while (!gui.isClicked()) gui.setButtonText(0,"Trykk for å gå videre");
            }
        playing = false;
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
