//  Sujith Vishwajith 
//  Intro.java 
//  Intro Panel for the Mario game. 

import  java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import java.awt.image.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.*;
import javax.imageio.*;

public class IntroPanel extends JPanel implements ActionListener 
{
        private Image mario, background, textcover;
        int x;
        public JButton begin, help, savegame, highscores;
        private Main panelswitcher;
        
        //Constructor adding on the images and button
        public IntroPanel(Main m) {
            this.setLayout(null);
            panelswitcher = m;
            try {
                background = ImageIO.read(new File("/Users/sujith/Desktop/Programs/Mario Game/Intro Wallpapers/introback.jpg"));
                textcover = ImageIO.read(new File("/Users/sujith/Desktop/Programs/Mario Game/Intro Wallpapers/textcover.png"));
            }
                catch (IOException e){
                System.out.print("Image not found!");
            }
            RepaintAction action = new RepaintAction();//creates a new Repaint Action for the timer
            Timer mouth = new Timer(160, action);//new timer with 160ms for mouth and moving the monsters
            mouth.start();//starts the timer
        }

        private class RepaintAction implements ActionListener {

            public void actionPerformed(ActionEvent evt) {
                x = x + 1;
                if (x == 6) {
                    x = 0;
                }
                repaint(); // repainting to show the color changing
            }//end timermethod
        }//end RepaintAction

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            repaint();
            g.drawImage(background, 0, 0, null);
            

            //draws out name for credits
            g.setColor(Color.black);
            g.setFont(new Font("Calibri", Font.BOLD, 30));
            g.drawString("Made By:", 380, 315);
            g.drawString("Sujith Vishwajith", 380, 355);

            if (x == 1) {
                g.setColor(Color.white);
            } else if (x == 2) {
                g.setColor(Color.yellow);
            } else if (x == 3) {
                g.setColor(Color.green);
            } else if (x == 4) {
                g.setColor(Color.red);
            } else if (x == 0) {
                g.setColor(Color.cyan);
            } else if (x == 5) {
                g.setColor(Color.orange);
            }

            //Draw out the title depending on the color
            g.drawImage(textcover, 30, 30, null);
            g.setFont(new Font("Calibri", Font.BOLD, 80));
            g.drawString("    Super Java", 25, 120);
            g.drawString("     Brothers", 40, 210);

            //Drawing out the JButton for Start
            JButton begin = new JButton("Start Game");
            begin.setSize(330, 125);
            begin.setLocation(750, 125);
            begin.addActionListener(this);
            begin.setForeground(Color.BLACK);
            begin.setBackground(Color.BLACK);
            this.add(begin);

            //Drawing out the JButton for help
            JButton help = new JButton("How to Play");
            help.setSize(330, 125);
            help.setLocation(750, 265);
            help.addActionListener(this);
            help.setForeground(Color.RED);
            help.setBackground(Color.RED);
            this.add(help);

            //Drawing out the JButton for savegame
            JButton savegame = new JButton("Load Save");
            savegame.setSize(330, 125);
            savegame.setLocation(750, 405);
            savegame.addActionListener(this);
            savegame.setForeground(Color.BLUE);
            savegame.setBackground(Color.RED);
            this.add(savegame);

            //Drawing out the JButton for highscores
            JButton highscores = new JButton("High Scores");
            highscores.setSize(330, 100);
            highscores.setLocation(750, 545);
            highscores.addActionListener(this);
            highscores.setForeground(Color.BLACK);
            highscores.setBackground(Color.RED);
            this.add(highscores);

        }//end paintComponent

        public void actionPerformed(ActionEvent evt) {
            String command = evt.getActionCommand();
            if (command.equals("How to Play"))
            {  
                panelswitcher.toHelpPanel();
            }
            if (command.equals("Load Save")) 
            {
                panelswitcher.toLoadPanel();
            }
            if (command.equals("High Scores")) 
            {
                panelswitcher.toScorePanel();
            }
            if (command.equals("Start Game")) 
            {
                panelswitcher.toLevelPanel();
            }
        }
}