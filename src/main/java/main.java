public class main {

    public static void main (String[] args) {

        GUI gui = new GUI();
        gui.setText("Velg spill");
        gui.addButton("Sixty Seconds");
        gui.addButton("Mitt skip er lastet med");
        while(!(gui.isClicked())) System.out.println();
        new SixtySeconds();


    }

}
