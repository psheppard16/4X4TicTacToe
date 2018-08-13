
/**
 * Write a description of class PlayField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.EmptyBorder;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
public class GameLoop extends JPanel
{
    Insets insets;
    String menu;
    Window window;
    Timer gameLoop;
    JTextField whosTurn;
    boolean won;
    String turn;
    Tile[][] board;
    /**
     * runs the game
     */
    public GameLoop(Window window)
    {
        turn = "red";
        won = false;
        this.window = window;
        window.setSize(1200, 700);
        setBounds(0, 0, 700, 700);
        setLayout(null);

        whosTurn = new JTextField(turn + "'s turn");
        whosTurn.setBounds(1000, 0, 500, 100);
        whosTurn.setFont(new Font("Arial", Font.PLAIN, 30));
        whosTurn.setForeground(Color.BLACK);
        whosTurn.setOpaque(false);
        whosTurn.setBorder(null);
        whosTurn.setEditable(false);
        window.add(whosTurn);

        board = new Tile[7][7];
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                board[i][j] = new Tile(this, i, j);
                this.add(board[i][j].button);
            }
        }

        TimerTask newFrame = new TimerTask()
            {
                public void run() 
                {
                    requestFocus();
                    updateButton();
                    refreshScreen();                   
                }
            };
        gameLoop = new Timer();
        gameLoop.scheduleAtFixedRate(newFrame, 0, 33);
    }

    public void updateButton()
    {
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                board[i][j].button.setText(board[i][j].type + board[i][j].titleNumber);
            }
        }
    }

    public void refreshScreen()
    {
        repaint();
        revalidate();
    }

    public void paintComponent(Graphics g)
    {
        //g.drawImage(space1.image, space1.xPos, space1.yPos, null);
    }

    public void actionPerformed(ActionEvent e) 
    {
        try
        {
            String k = e.getActionCommand();
            int i = (int)(k.charAt(k.length() - 2));
            int j = (int)(k.charAt(k.length() - 1));
            board[i][j].type = turn;
        }
        catch (NumberFormatException g)
        {
            
        }
        if (e.getActionCommand().equals("red"))
        {
            
        } 
        else if (e.getActionCommand().equals("blue"))
        {
            
        }
    }
}