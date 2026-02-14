package _04_gui_from_scratch._3_sound_effects_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SoundEffect implements ActionListener {
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	public void sounds() {
		JFrame bob = new JFrame();
		JPanel joe = new JPanel();
		
		
		bob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		joe.add(button1);
		joe.add(button2);
		button1.addActionListener(this);
		button2.addActionListener(this);
		bob.add(joe);
		bob.pack();
		bob.setVisible(true);
		
		
	}
	
	private void playSound(String soundFile) {
		String path = "src/_04_gui_from_scratch/_3_sound_effects_machine/";
			File sound = new File(path+soundFile);
			if (sound.exists()) {
				new Thread(() -> {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000);
				}
				catch (Exception e) {
					System.out.println("Could not play this sound");
				}}).start();
	 		}
			else {
				System.out.println("File does not exist");
			}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		
		if(buttonPressed == button1) {
			playSound("cat_purr.wav");
		}
		if(buttonPressed == button2) {
			playSound("sawing-wood-daniel_simon.wav");
		}
	}
}
