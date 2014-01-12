//  Sujith Vishwajith 
//  HelpPanel.java 
//  Help Panel for the Mario game. 

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

public class HelpPanel extends JPanel implements ActionListener
{
	JButton back;
	JTextArea help;
	private Main panelswitch;
	// Constructor adding on the images and button 
	public HelpPanel(Main l) 
	{
		panelswitch = l;
		this.setLayout(null);
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		repaint();
		//Button
		JButton back = new JButton("Back to Home Menu");
		back.setSize(330, 70);
		back.setLocation(385, 595);
		back.addActionListener(this);
		back.setBackground(Color.red);
		back.setForeground(Color.black);
		this.add(back);

		//Background
		setBackground(Color.cyan);
		g.setColor(Color.white);
		g.fillRect(70, 70, 955, 500);
		g.setColor(Color.black);
		g.setFont(new Font("Times New Roman", Font.BOLD, 50));
		g.drawString("How To Play the Game", 290, 50);
	}
	
	// end paintComponent 
	public void actionPerformed(ActionEvent evt) 
	{
		String command = evt.getActionCommand();
		if (command.equals("Back to Home Menu"))
		{
			panelswitch.toIntroPanel();
		}
	}
}
