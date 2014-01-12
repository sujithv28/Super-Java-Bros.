//  Sujith Vishwajith 
//  LevelPanel.java 
//  Level Panel for the Mario game. 

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

public class LevelPanel extends JPanel implements ActionListener, MouseListener 
{
	JButton back, forward;
	private Main panelswitch;
	private Image levelbackground, gsquare, rsquare, wlogo, star, life, castle, check;
	private int xcheck, ycheck, xmouse, ymouse;
	// Constructor adding on the images and button 
	public LevelPanel(Main l) 
	{
		xcheck = ycheck = 10000;
		addMouseListener(this);
		panelswitch = l;
		this.setLayout(null);
 		try 
 		{
            levelbackground = ImageIO.read(new File("/Users/sujith/Desktop/Programs/Mario Game/Backgrounds/levelselect.jpg"));
            gsquare = ImageIO.read(new File("/Users/sujith/Desktop/Programs/Mario Game/Level Buttons/green.png"));
            check = ImageIO.read(new File("/Users/sujith/Desktop/Programs/Mario Game/Level Buttons/check.png"));
            rsquare = ImageIO.read(new File("/Users/sujith/Desktop/Programs/Mario Game/Level Buttons/red.png"));
            wlogo = ImageIO.read(new File("/Users/sujith/Desktop/Programs/Mario Game/Level Buttons/wlogo.png"));
            star = ImageIO.read(new File("/Users/sujith/Desktop/Programs/Mario Game/Level Buttons/star.png"));
            life = ImageIO.read(new File("/Users/sujith/Desktop/Programs/Mario Game/Level Buttons/life.png"));
            castle = ImageIO.read(new File("/Users/sujith/Desktop/Programs/Mario Game/Level Buttons/castle.png"));
        }
        catch (IOException e)
        {
            System.out.print("Image not found!");
        }
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		repaint();
		//Button
		JButton back = new JButton("Back to Home Menu");
		back.setSize(200, 70);
		back.setLocation(325, 575);
		back.addActionListener(this);
		back.setBackground(Color.red);
		back.setForeground(Color.red);
		this.add(back);
		JButton forward = new JButton("Continue");
		forward.setSize(200, 70);
		forward.setLocation(555, 575);
		forward.addActionListener(this);
		forward.setBackground(Color.cyan);
		forward.setForeground(Color.blue);
		this.add(forward);

		//Background
		setBackground(Color.black);
		g.drawImage(levelbackground, -20, 0, null);

		g.drawImage(gsquare, 180, 100, null);
		g.drawImage(rsquare, 250, 145, null);
		g.drawImage(gsquare, 320, 190, null);
		g.drawImage(life, 390, 235, null);
		g.drawImage(star, 460, 280, null);
		g.drawImage(rsquare, 530, 235, null);
		g.drawImage(gsquare, 600, 190, null);
		g.drawImage(life, 670, 145, null);
		g.drawImage(star, 740, 100, null);
		g.drawImage(gsquare, 810, 145, null);
		g.drawImage(rsquare, 880, 190, null);
		g.drawImage(gsquare, 950, 235, null);
		g.drawImage(castle, 1015, 290, null);
		requestFocus();

		//Check drawn around level select
		g.drawImage(check, xcheck, ycheck, null);

		g.setColor(Color.white);
		g.setFont(new Font("Times New Roman", Font.BOLD, 50));
		g.drawString("Select Level", 400, 50);
	}
	
	// end paintComponent 
	public void actionPerformed(ActionEvent evt) 
	{
		String command = evt.getActionCommand();
		if (command.equals("Back to Home Menu"))
		{
			panelswitch.toIntroPanel();
		}
		if (command.equals("Continue"))
		{
			panelswitch.toLevel1();
		}
	}

	public void mouseClicked (MouseEvent e) 
	{
		xmouse = e.getX();
		ymouse = e.getY();
		if (xmouse >= 180 && xmouse <=225)
		{
			xcheck = 181;
			ycheck = 101;
		}
		else if (xmouse >=250  && xmouse <= 295) 
		{
			xcheck = 251;
			ycheck = 146;
		}
		else if (xmouse >=320  && xmouse <= 365)
		{
			xcheck = 321;
			ycheck = 191;
		}
		else if (xmouse >=390  && xmouse <= 435) 
		{
			xcheck = 391;
			ycheck = 236;
		}
		else if (xmouse >=460 && xmouse <= 505) 
		{
			xcheck = 461;
			ycheck = 281;
		}
		else if (xmouse >= 530 && xmouse <= 575) 
		{
			xcheck = 531;
			ycheck = 236;
		}
		else if (xmouse >= 600 && xmouse <= 645) 
		{
			xcheck = 601;
			ycheck = 191;
		}
		else if (xmouse >= 670 && xmouse <= 715) 
		{
			xcheck = 671;
			ycheck = 146;
		}
		else if (xmouse >= 740 && xmouse <= 785) 
		{
			xcheck = 741;
			ycheck = 101;
		}
		else if (xmouse >= 810 && xmouse <= 855) 
		{
			xcheck = 811;
			ycheck = 146;
		}
		else if (xmouse >= 880 && xmouse <= 925) 
		{
			xcheck = 881;
			ycheck = 191;
		}
		else if (xmouse >= 950 && xmouse <= 995) 
		{
			xcheck = 951;
			ycheck = 236;
		}
		else if (xmouse >= 1015 && xmouse <= 1060) 
		{
			xcheck = 1025;
			ycheck = 299;
		}
		repaint();
	}	
	
	public void mousePressed (MouseEvent e) {}

	public void mouseReleased (MouseEvent e) {}
	
	public void mouseEntered (MouseEvent e) {}
	
	public void mouseExited (MouseEvent e) {}

}