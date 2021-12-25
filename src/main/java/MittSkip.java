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

    public MittSkip(GUI gu){
        gui = gu;
        gui.clearPanel();
        gui.addCustomButton("Mitt skip er lastet med, trykk for å starte",this);
        button = gui.getButtons().get(0);
        addTema();
    }

    private void addTema() {
        tema.add("Røde ting");
        tema.add("Sport");
        tema.add("Øl");
        tema.add("Norske byer");
        tema.add("Rap-artiser");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(tema.isEmpty()) button.setText("Ingen flere tema");
        Collections.shuffle(tema);
        button.setText(tema.get(0));
        tema.remove(0);
    }
}
