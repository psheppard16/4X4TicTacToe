
/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class EndScreen extends JPanel
{
    Window window;
    JButton MainMenu;
    JButton playAgain;
    JTextField win;
    JLabel label;
    public EndScreen(Window window)
    {
        this.window = window;
        window.setSize(700, 700);
        setLayout(null);
        setBounds(0, 0, 700, 700);
        /*
        try
        {
            label = new JLabel(new ImageIcon(ImageIO.read(new File(ajsfgasjkfaskjjka))));
            label.setBounds(0, 0, 700, 700);
        }
        catch (IOException e)
        {
            System.out.println("File read error");  
        }
        */
        add(label);
        if(window.redWon)
        {
            win = new JTextField("Red Wins!");
            win.setForeground(Color.GREEN);
        }
        else
        {
            win = new JTextField("Blue Wins!");
            win.setForeground(Color.RED);
        }
        win.setBounds(250, 0, 750, 100);
        win.setFont(new Font("Arial", Font.PLAIN, 110));
        win.setOpaque(false);
        win.setBorder(null);
        window.add(win);
        MainMenu = new JButton(new ButtonAction("Main Menu", KeyEvent.VK_A));
        MainMenu.setBounds(375, 500, 250, 100);
        window.add(MainMenu);
        playAgain = new JButton(new ButtonAction("Play Again", KeyEvent.VK_A));
        playAgain.setBounds(375, 650, 250, 100);
        window.add(playAgain);
    }

    private class ButtonAction extends AbstractAction 
    {
        public ButtonAction(String name, Integer mnemonic) 
        {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if (e.getActionCommand().equals("Main Menu"))
            {
                window.requestedScreen = "MainMenu";
            }
            else if (e.getActionCommand().equals("Play Again"))
            {
                window.requestedScreen = "GameLoop";
            }
        }
    }
}
