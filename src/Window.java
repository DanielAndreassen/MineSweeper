import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public boolean loose = false;

    int i = 0;

    int amtBombs = 0;

    int amtFlags = 0;


    public Window(){
        this.setTitle("MineSweeper.");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel multiPanel = new JPanel();

        GridLayout layout = new GridLayout(14, 18);

        multiPanel.setLayout(layout);
        multiPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,10));

        for (i = 0; i < 18*14; i++){
            multiPanel.add(new Square(this));
        }

        this.add(multiPanel);
        this.pack();
        this.setVisible(true);
    }



    public boolean isLoose(){
        return loose;
    }

    public void setLoose(){
        this.loose = !this.loose;
    }

    public int getAmtBombs() {
        return amtBombs;
    }

    public void setAmtBombs(int amtBombs) {
        this.amtBombs = amtBombs;
    }

    public int getAmtFlags() {
        return amtFlags;
    }

    public void setAmtFlags(int amtFlags) {
        this.amtFlags = amtFlags;
    }
}


