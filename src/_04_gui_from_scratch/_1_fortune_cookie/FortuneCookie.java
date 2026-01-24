package _04_gui_from_scratch._1_fortune_cookie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FortuneCookie implements ActionListener {
	Random randy = new Random();
	int numby = randy.nextInt(5);
	public void showButton() {
        JFrame frame = new JFrame();
        JButton button = new JButton();
        frame.add(button);
        frame.pack();
        button.addActionListener(this);
       
        frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "woohoo");
			if(numby == 0) {
				JOptionPane.showMessageDialog(null, "you will die");
			}
			if(numby == 1) {
				JOptionPane.showMessageDialog(null, "you will be bored");
			}
			if(numby == 2) {
				JOptionPane.showMessageDialog(null, "you will get a job.(yeah i know, feel the pain)");
			}
			if(numby == 3) {
				JOptionPane.showMessageDialog(null, "you will find a home");
			}
			if(numby == 4) {
				JOptionPane.showMessageDialog(null, "you will breathe");
			}
		
	}
}
