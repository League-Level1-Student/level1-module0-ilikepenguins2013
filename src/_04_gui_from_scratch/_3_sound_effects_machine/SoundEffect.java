package _04_gui_from_scratch._3_sound_effects_machine;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SoundEffect {
	public void sounds() {
		JFrame bob = new JFrame();
		JPanel joe = new JPanel();
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		
		bob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		joe.add(button1);
		joe.add(button2);
		bob.add(joe);
		bob.pack();
		bob.setVisible(true);
	}
}
