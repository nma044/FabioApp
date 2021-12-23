import java.util.ArrayList;
import java.util.Scanner;

public class SixtySeconds {
    public ArrayList<Player> playerList = new ArrayList<>();
    public Boolean playing;
    public int round = 60;

    public SixtySeconds(){
        addplayers();
        setRoundTime();
        playing = true;
        play();
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
                System.out.println(i.getName() + " sin tur! Trykk stopp når det har gått " + round + " sekunder!");
                System.out.println("Trykk enter for å starte timer");
                Scanner scan = new Scanner(System.in);
                String enter = scan.nextLine();
                long start = System.currentTimeMillis();
                System.out.println("Timer startet, trykk enter for å stoppe");
                String slutte = scan.nextLine();
                long slutt = System.currentTimeMillis();
                int tid = ((int)slutt - (int)start) / 1000;
                int slurker = Math.abs(round - tid);
                System.out.println(i.getName() + " stoppet etter: " + tid + " sekunder, og må drikke " + slurker + " slurker!");
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
