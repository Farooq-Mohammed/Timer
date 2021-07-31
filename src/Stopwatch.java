import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Stopwatch implements ActionListener {

	JFrame frame = new JFrame();
	JButton startButton = new JButton("Start");
	JButton resetButton = new JButton("Reset");
	JButton addTime_sec = new JButton("+15 sec");
	JButton addTime_min = new JButton("+1 min");
	JLabel timeLabel = new JLabel();
	
	int elapsedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	
	boolean started = false;
	
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			elapsedTime += 1000;
			hours = (elapsedTime/3600000)%24;
			minutes = (elapsedTime/60000)%60;
			seconds = (elapsedTime/1000)%60;
			hours_string = String.format("%02d", hours);
			minutes_string = String.format("%02d", minutes);
			seconds_string = String.format("%02d", seconds);
			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
			
		}
	});
	
	public Stopwatch() {
		
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		timeLabel.setBounds(100,100,200,100);
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startButton.setBounds(100, 200, 100, 50);
		startButton.setFont(new Font("Ink Free",Font.PLAIN,20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		addTime_sec.setBounds(100, 250, 100, 50);
		addTime_sec.setFont(new Font("Ink Free",Font.PLAIN,20));
		addTime_sec.setFocusable(false);
		addTime_sec.addActionListener(this);
		
		resetButton.setBounds(200, 200, 100, 50);
		resetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		addTime_min.setBounds(200, 250, 100, 50);
		addTime_min.setFont(new Font("Ink Free",Font.PLAIN,20));
		addTime_min.setFocusable(false);
		addTime_min.addActionListener(this);
		
		frame.add(startButton);
		frame.add(resetButton);
		frame.add(addTime_sec);
		frame.add(addTime_min);
		frame.add(timeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Stop Watch tutorial");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==startButton) {
			start();
			if(started==false) {
				started = true;
				startButton.setText("Stop");
				start();
			}else {
				started = false;
				startButton.setText("Start");
				stop();
			}
		}
		if(e.getSource()==resetButton) {
			started=false;
			startButton.setText("Start");
			reset();
		}
		if(e.getSource()==addTime_sec) {
			elapsedTime+=15000;
		}
		if(e.getSource()==addTime_min) {
			elapsedTime+=60000;
		}
		
	}
	
	void start() {
		timer.start();
	}
	
	void stop() {
		timer.stop();
	}
	
	void reset() {
		timer.stop();
		elapsedTime = 0;
		seconds = 0;
		minutes =0 ;
		hours=0;
		hours_string = String.format("%02d", hours);
		minutes_string = String.format("%02d", minutes);
		seconds_string = String.format("%02d", seconds);
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		
	}

}
