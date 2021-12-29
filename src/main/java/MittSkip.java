import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MittSkip implements ActionListener {
    public ArrayList<String> tema = new ArrayList<>();
    public GUI gui;
    public JButton button;
    private boolean ferdig = false;
    private Menu menu;

    public MittSkip(GUI gu, Menu men){
        gui = gu;
        gui.clearPanel();
        gui.addCustomButton("Mitt skip er lastet med, trykk for å starte",this);
        gui.addCustomButton("Tilbake", men);
        button = gui.getButtons().get(0);
        menu = men;
        addTema();
    }

    private void addTema() {
        tema.add("Røde ting");
        tema.add("Sport");
        tema.add("Øl");
        tema.add("Norske byer");
        tema.add("Rap-artister");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (ferdig) menu.gameScreen();
        if(tema.isEmpty()){
            button.setText("Ingen flere tema");
            ferdig = true;
            return;
        }
        Collections.shuffle(tema);
        button.setText("Mitt skip er lastet med " + tema.get(0));
        tema.remove(0);
    }
}
