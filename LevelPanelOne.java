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

public class LevelPanelOne extends JPanel implements ActionListener 
{
        private Main panelswitcher;
        
        //Constructor adding on the images and button
        public LevelPanelOne(Main m) {
            this.setLayout(null);
            panelswitcher = m;
 /*           try {

            }
            catch (IOException e)
            {
                System.out.print("Image not found!");
            }
*/
            RepaintAction action = new RepaintAction();//creates a new Repaint Action for the timer
            Timer mouth = new Timer(160, action);//new timer with 160ms for mouth and moving the monsters
            mouth.start();//starts the timer
        }

        private class RepaintAction implements ActionListener {
            public void actionPerformed(ActionEvent evt) {

                repaint();
            }//end timermethod
        }//end RepaintAction

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            repaint();
        }//end paintComponent

        public void actionPerformed(ActionEvent evt) {
            String command = evt.getActionCommand();
            if (command.equals(" "))
            {  
                panelswitcher.toHelpPanel();
            }
        }
}