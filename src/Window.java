import javax.swing.*;
import java.awt.*;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Arrays;

/*
This in the class for the JFrame,
 */

public class Window extends JFrame {

    public boolean loose = false;

    int myX = 1;

    int myY = 1;

    int amtBombs = 0;

    int amtFlags = 0;

    Square mySquare = new Square(this);

    Square[][] cords = new Square[16][16];

    public Window(){  // window constructor
        this.setTitle("MineSweeper.");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel multiPanel = new JPanel();

        GridLayout layout = new GridLayout(15, 15);

        multiPanel.setLayout(layout);
        multiPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,10));

        for (int i = 1; i <= 15; i++ ){
            for (int j = 1; j <= 15; j++){
                myX=j;
                myY=i;
                multiPanel.add(cords[j][i] = new Square(this));
            }
        }


        this.add(multiPanel);
        this.pack();
        this.setVisible(true);

    }


    public boolean isLoose(){ //getter and setter to control what and when the player looses.
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

    public void countSurroundingMines() { // test to try and count surrounding bombs.
        // Loop through all cells of the game board
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                // If the current cell does not contain a mine
                if (!this.mySquare.isMine()) {
                    int count = 0;
                    // Check the cells surrounding the current cell
                    // and increment the count if there is a mine
                    // Top Cell
                    if (mySquare.getThisX() == i-1 && mySquare.getThisY() == j && mySquare.isMine()==true) count++;
                    // Bottom Cell
                    if (mySquare.getThisX() == i+1 && mySquare.getThisY() == j && mySquare.isMine()==true) count++;
                    // Left Cell
                    if (mySquare.getThisX() == i && mySquare.getThisY() == j-1 && mySquare.isMine()==true) count++;
                    // Right Cell
                    if (mySquare.getThisX() == i && mySquare.getThisY() == j+1 && mySquare.isMine()==true) count++;
                    // Top Left Diagonal
                    if (mySquare.getThisX() == i-1 && mySquare.getThisY() == j-1 && mySquare.isMine()==true) count++;
                    // Bottom Right Diagonal
                    if (mySquare.getThisX() == i+1 && mySquare.getThisY() == j+1 && mySquare.isMine()==true) count++;
                    // Top Right Diagonal
                    if (mySquare.getThisX() == i-1 && mySquare.getThisY() == j+1 && mySquare.isMine()==true) count++;
                    // Bottom Left Diagonal
                    if (mySquare.getThisX() == i+1 && mySquare.getThisY() == j-1 && mySquare.isMine()==true) count++;
                    // Store the count in the "surroundingMines" array
                    this.mySquare.aroundMines = count;
                }
            }
        }
    }

}


