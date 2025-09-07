package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.ThreadCar;

@SuppressWarnings("serial")
public class Window extends JFrame implements ActionListener{

	// btn
	private JButton btnRun;
	private JButton btnCancel;
	// labels
	private JLabel lblRaceTrack;  
	private JLabel lblVelocimeter;
	// imgs
	private ImageIcon imgCar1;
	private ImageIcon imgCar2;
	private ImageIcon imgCar3;
	private ImageIcon raceTr;
	private ImageIcon velocimeter;
	
	
	public Window () {
		
		// base window elements
		this.setLayout(null);
		this.setSize(1280, 650);
		this.setLocation(50, 50);
		this.setResizable(false);
		getContentPane().setBackground(Color.white);
		
		this.setTitle("Drive Fast");
		
		velocimeter = new ImageIcon("./src/images/velocimeter.png");
		raceTr = new ImageIcon("./src/images/race-track");
		
		this.lblRaceTrack = new JLabel(raceTr);
		this.lblVelocimeter = new JLabel(velocimeter);
		
		// setting positions
		this.lblVelocimeter.setBounds(200, 490, 150, 150);
        this.lblRaceTrack.setBounds(0, 0, 1280, 650);
        
        this.add(lblRaceTrack);
        this.lblRaceTrack.add(lblVelocimeter);
        
        this.lblRaceTrack.setBackground(Color.BLACK);
        
        this.btnRun = new JButton("Start Rally");
        this.btnCancel = new JButton("Stop Rally");
                  // POSIONADO OS BOT�ES
        this.btnRun.setBounds(500, 550, 120, 50);
        this.btnCancel.setBounds(640, 550, 120, 50);
                    // INSERINDO AS IMAGENS DOS CARROS
        imgCar1 = new ImageIcon("./src/images/carro1.png");
        imgCar2 = new ImageIcon("./src/images/carro2.png");
        imgCar3 = new ImageIcon("./src/images/carro3.png");
       
        this.lblRaceTrack.add(btnRun);
        this.lblRaceTrack.add(btnCancel);

        this.setVisible(true);

        btnRun.addActionListener(this);
        btnCancel.addActionListener(this);

        JPanel jPanel = new JPanel();
        jPanel.setSize(300, 70);
        jPanel.setLayout(null);
        jPanel.setLocation(970, 510);
        jPanel.setBorder(BorderFactory.createTitledBorder("Vruuuumm"));
        jPanel.setVisible(true);

        this.repaint();
	}
	
	public JLabel JLabelCars(String name, ImageIcon img, int posX, int posY) {
		ThreadCar car = new ThreadCar(name, img, posX, posY);
		car.setSize(256, 141);
		car.setVisible(true);
		this.add(car);
		return car;
	}
	
	@Override
	public void actionPerformed(ActionEvent startRace) {
		// TODO Auto-generated method stub
		if(startRace.getSource() == this.btnRun) {
			this.lblRaceTrack.add(JLabelCars("Racer n1", imgCar1, 0, 50));
			this.lblRaceTrack.add(JLabelCars("Race n2", imgCar2, 0, 200));
			this.lblRaceTrack.add(JLabelCars("Race n3", imgCar3, 0, 350));
		}
		if(startRace.getSource() == this.btnCancel) {
			System.exit(0);
		}
	}
	
	
}
