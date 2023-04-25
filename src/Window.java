import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public boolean loose = false;


    public Window(){
        this.setTitle("MineSweeper.");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel multiPanel = new JPanel();

        GridLayout layout = new GridLayout(14, 18);

        multiPanel.setLayout(layout);
        multiPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,10));

        for (int i = 0; i < 18*14; i++){
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




}


