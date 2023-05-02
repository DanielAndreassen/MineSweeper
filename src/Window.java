import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame {

    public boolean loose = false;

    int myX = 1;

    int myY = 1;

    int amtBombs = 0;

    int amtFlags = 0;


    public Window(){
        this.setTitle("MineSweeper.");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel multiPanel = new JPanel();

        GridLayout layout = new GridLayout(14, 18);

        multiPanel.setLayout(layout);
        multiPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,10));

        for (int i = 0; i < 18*14; i++){
            multiPanel.add(new Square(this));
            myX=(i%18)+1;
            myY= ((i/17)+1);
            /*
            if(myX <= 18){
                myX++;
            }
            else {
                myX = 1;
                myY++;
            }

             */

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

    public int getMyX() {
        return myX;
    }

    public void setMyX(int myX) {
        this.myX = myX;
    }

    public int getMyY() {
        return myY;
    }

    public void setMyY(int myY) {
        this.myY = myY;
    }
}


