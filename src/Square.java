import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Square extends JPanel implements MouseListener {
    //att
    final int SIZE = 50;

    int thisX;

    int thisY;


    Window myWindow;

    boolean isMine;

    boolean isMarked = false;

    boolean isCovered = true;

    int aroundMines = 0;



    //const
    public Square(Window window) { //window constructor
        myWindow = window;
        this.setBackground(Color.black);
        this.setBorder(BorderFactory.createLineBorder(Color.white, 3));
        this.setPreferredSize(new Dimension(SIZE, SIZE));
        thisX = this.myWindow.getMyX();
        thisY = this.myWindow.getMyY();
        this.addMouseListener(this);
        isThisMine();
    }
    @Override
    public void paintComponent(Graphics g){//paint component to draw things
        super.paintComponent(g);


    }

    public void drawFlag(Graphics g){ //draw flag
        g.setColor(Color.red);
        g.fillRect(8,10,23,15);
        g.drawLine(30,10,30,40);
    }

    public void drawMinesAround(Graphics g){ //draw number of bombs around a square
        String numb = String.valueOf(aroundMines);
        g.setColor(Color.blue);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 5));
        g.drawString(numb,0,0);
    }




    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            if(this.isMarked == true){// if a square is marked, it cant be clicked again

            }
            else {
                if(!this.isMine){// if the square is not a mine
                    this.setBackground(Color.WHITE);
                    repaint();
                    this.isCovered = false;
                    this.myWindow.countSurroundingMines();
                    drawMinesAround(getGraphics());
                    System.out.println(this.aroundMines);

                } else {
                    this.setBackground(Color.red);// if it is a bomb
                    repaint();
                    //myWindow.setLoose();
                }
            }
            System.out.println("X: "+this.thisX + "   Y: " + this.thisY);
        }
        if(e.getButton() == MouseEvent.BUTTON3){
           if(!this.isCovered || myWindow.getAmtFlags() <= 0){// if the amount of flags is 0 no flags can be placed

           }else {
               if (this.isMarked == true){// if there is a flag in the square a click will remove the flag that was placed
                   setBackground(Color.black);
                   this.isMarked = false;
                   myWindow.setAmtFlags(myWindow.getAmtFlags()+1);
                   repaint();
                   System.out.println("amount of flags left:"+ myWindow.getAmtFlags());
               }
               else {
                   drawFlag(getGraphics());
                   this.isMarked = true;
                   myWindow.setAmtFlags(myWindow.getAmtFlags()-1);
                   System.out.println("amount of flags left:"+ myWindow.getAmtFlags());
               }
           }

        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //meht

    public void isThisMine(){
         double x = Math.random();
         int z = (int) (x * 100);
         if(z < 30){
             this.isMine = true;
             myWindow.setAmtBombs(myWindow.getAmtBombs()+1);
             myWindow.setAmtFlags(myWindow.getAmtFlags()+1);
         }
         if (z > 30){
             this.isMine = false;
         }
    }
    //getsett


    public int getThisX() {
        return thisX;
    }

    public int getThisY() {
        return thisY;
    }

    public boolean isMine() {
        return isMine;
    }
}


