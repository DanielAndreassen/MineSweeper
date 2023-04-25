import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Square extends JPanel implements MouseListener {
    //att
    final int SIZE = 50;
    Window myWindow;

    boolean isMine;

    boolean isMarked = false;

    boolean isCovered = true;



    //const
    public Square(Window window) {
        myWindow = window;
        this.setBackground(Color.black);
        this.setBorder(BorderFactory.createLineBorder(Color.white, 3));
        this.setPreferredSize(new Dimension(SIZE, SIZE));
        this.addMouseListener(this);
        isThisMine();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);


    }

    public void drawFlag(Graphics g){
        g.setColor(Color.red);
        g.fillRect(8,10,23,15);
        g.drawLine(30,10,30,40);
    }




    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            if(!this.isMine){
                this.setBackground(Color.WHITE);
                repaint();
                this.isCovered = false;
            } else {
                this.setBackground(Color.red);
                repaint();
                //myWindow.setLoose();
            }


        }
        if(e.getButton() == MouseEvent.BUTTON3){
            drawFlag(getGraphics());
            this.isMarked = true;
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
         }
         if (z > 30){
             this.isMine = false;
         }
    }
    //getsett

}
