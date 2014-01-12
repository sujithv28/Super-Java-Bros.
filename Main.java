// Sujith Vishwajith
// Main.java
// Main program which calls all the other files

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;

public class Main
{
    JFrame frame;
    private Container containMe;
    private CardLayout cards; //the cardlayout
    private IntroPanel introPanel; //first panel
    private HelpPanel helpPanel;
    private HighScoresPanel scorePanel;
    private LoadPanel loadPanel;
    private LevelPanel levelPanel;
    private LevelPanelOne levelPanel1;

    public static void main (String[] args)
    {
        Main game = new Main();
        game.Run(game);
    }

    public void Run(Main g)
    {
        frame = new JFrame("Super Java Bros."); //new jframe with game title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stop program when exit
        containMe = new Container();
        cards = new CardLayout();
        containMe.setLayout(cards);
        
        frame.add(containMe); //add mainpanel to frame
        introPanel = new IntroPanel(g);
        helpPanel = new HelpPanel(g);
        scorePanel = new HighScoresPanel(g);
        loadPanel = new LoadPanel(g);
        levelPanel = new LevelPanel(g);
        levelPanel1 = new LevelPanelOne(g);
        
        containMe.add(introPanel, "Intro Panel");
        containMe.add(helpPanel, "Help Panel");
        containMe.add(scorePanel, "High Score Panel");
        containMe.add(loadPanel, "Load Panel");
        containMe.add(levelPanel, "Level Panel");
        containMe.add(levelPanel1, "Level 1 Panel");

        frame.setSize(1100, 700);   // explicitly set size in pixels
        frame.setLocation(30, 30);
        frame.setVisible(true);     // set to false to make invisible
        frame.setResizable(false);
    }

    public void toHelpPanel()
    {
        cards.show(containMe, "Help Panel");

    }

    public void toIntroPanel()
    {
        cards.show(containMe, "Intro Panel");
    }

    public void toScorePanel()
    {
        cards.show(containMe, "High Score Panel");
    }

    public void toLoadPanel()
    {
        cards.show(containMe, "Load Panel");
    }

    public void toLevelPanel()
    {
        cards.show(containMe, "Level Panel");
    }

    public void toLevel1()
    {
        cards.show(containMe, "Level 1 Panel");

    }
    
}