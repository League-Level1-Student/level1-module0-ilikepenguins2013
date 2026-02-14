package _04_gui_from_scratch._4_cuteness_tv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TV_thingy implements ActionListener {

	public  void run() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton b1 = new JButton();
		JButton b2 = new JButton();
		JButton b3 = new JButton();
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		frame.add(panel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
