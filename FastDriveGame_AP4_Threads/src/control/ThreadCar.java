package control;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ThreadCar extends JLabel implements Runnable{
	
	private Thread carThread = null;
	private int posX;
	private int posY;
	private ImageIcon carImg;
	private static int pos=0;
	private String name;
	
	// Default constructor	
	public ThreadCar() {
		
	}
	
	// Overcharged constructor
	public ThreadCar(String name, ImageIcon img, int posX, int posY) {
		super(img);
		this.name = name;
		this.carImg = img;
		this.posX = posX;
		this.posY = posY;
		
		carThread = new Thread(this, name);
		carThread.start();
	}

	
	@Override
	public void run() {
		
		// update each sec
		posX += new Random().nextInt(3) * 100;
		this.setLocation(posX, posY);
			
		if(posX >= 1280) {
			pos++;
			JOptionPane.showMessageDialog(null, pos + " | " + name);
			return;
		}
		try {		
			Thread.sleep(new Random().nextInt(5) * 100);
			run();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
