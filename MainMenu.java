/**
 * Write a description of class MainMenu here.
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
public class MainMenu extends JPanel
{
    Window window;
    JButton play;
    JButton toggle;
    JButton instructions;
    JLabel label;
    JTextField title;
    /**
     * creates the main menu
     */
    public MainMenu(Window window)
    {
        this.window = window;
        /*
        try
        {
            label = new JLabel(new ImageIcon(ImageIO.read(new File("images/MainMenu.png"))));
            label.setBounds(0, 0, 700, 700);
        }
        catch (IOException e)
        {
            System.out.println("File read error");  
        }
        add(label);
        */
        setLayout(null);
        setBounds(0, 0, 1000, 1000);
        play = new JButton(new ButtonAction("Play Game", KeyEvent.VK_A));
        play.setBounds(375, 250, 250, 100);
        window.add(play);
        toggle = new JButton(new ButtonAction("Toggle Static and Flux", KeyEvent.VK_A));
        toggle.setBounds(375, 400, 250, 100);
        window.add(toggle);
        instructions = new JButton(new ButtonAction("Instructions", KeyEvent.VK_A));
        instructions.setBounds(375, 400, 250, 100);
        window.add(instructions);
        title = new JTextField("Four by Four Relative Tic-Tac-Toe with Slides, Flips and Addenda to the Rules to Equalize GamePlay");
        title.setBounds(250, 50, 500, 150);
        title.setFont(new Font("Arial", Font.PLAIN, 110));
        title.setForeground(Color.RED);
        title.setOpaque(false);
        title.setBorder(null);
        title.setEditable(false);
        window.add(title); 
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
            if (e.getActionCommand().equals("Play Game"))
            {
                window.requestedScreen = "GameLoop";
            }
            else if (e.getActionCommand().equals("Instructions"))
            {
                window.requestedScreen = "Instructions";
            }
            else if (e.getActionCommand().equals("Toggle Static and Flux"))
            {
                if (window.flux == true)
                {
                    window.flux = false;
                }
                else
                {
                    window.flux = true;
                }
            }
        }
    }
}
