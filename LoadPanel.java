//  Sujith Vishwajith 
//  LoadPanel.java 
//  Load Panel for the Mario game. 

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

public class LoadPanel extends JPanel implements ActionListener 
{
	JButton back;
	private Main panelswitch;
	// Constructor adding on the images and button 
	public LoadPanel(Main l) 
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
		back.setBackground(Color.black);
		back.setForeground(Color.black);
		this.add(back);

		//Background
		setBackground(Color.green);
		g.setColor(Color.black);
		g.setFont(new Font("Times New Roman", Font.BOLD, 50));
		g.drawString("Load Saves", 430, 50);
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