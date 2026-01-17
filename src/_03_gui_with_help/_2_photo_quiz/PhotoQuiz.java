package _03_gui_with_help._2_photo_quiz;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */

import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PhotoQuiz {

	public void run() {

		JFrame quizWindow = new JFrame();
		
		// This will make sure the program exits when you close the window
		quizWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 1. find an image on the internet, and put its URL in a String
		// variable (from your browser, right click on the image, and select
		// “Copy Image Address” )
		String noli = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQy9JULXpEDrWh1-Iw348l5t7gYYsjMJE_4A&s";
		// 2. create a variable of type "Component" that will hold your image
		Component voidstar;
		// 3. use the "createImage()" method below to initialize your Component
		voidstar = createImage(noli);
		// 4. add the image to the quiz window
		quizWindow.add(voidstar);
		// 5. call the pack() method on the quiz window
		quizWindow.pack();
		quizWindow.setVisible(true);
		// 6. ask a question that relates to the image
		String question1 = JOptionPane.showInputDialog("who is this?");
		// 7. print "CORRECT" if the user gave the right answer
		if(question1.equalsIgnoreCase("noli")) {
			JOptionPane.showMessageDialog(null, "I can't stop winning");
		}
		// 8. print "INCORRECT" if the answer is wrong
		else {
			JOptionPane.showMessageDialog(null, "Aw dang it");
		}
		// 9. remove the component from the quiz window (you may not see the
		// effect of this until step 12)
		quizWindow.remove(voidstar);
		// 10. find another image and create it (might take more than one line
		// of code)
		String ms4 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6Mas3h0qHZHq9DMRMLm17HUb5mRAYKAEgMQ&s";
		Component m4;
		m4 = createImage(ms4);
		// 11. add the second image to the quiz window
		quizWindow.add(m4);
		// 12. pack the quiz window
		quizWindow.pack();
		// 13. ask another question
		String question2 = JOptionPane.showInputDialog("what skin for veeronica is this");
		// 14+ check answer, say if correct or incorrect, etc.
		if(question2.equalsIgnoreCase("ms4") || question2.equalsIgnoreCase("m4") || question2.equalsIgnoreCase("milestone 4")) {
			JOptionPane.showMessageDialog(null, "i can't stop winning");
		}
		else {
			JOptionPane.showMessageDialog(null,  "aw dang it");
		}

	}

	private Component createImage(String imageUrl) {
		JLabel imageLabel = new JLabel();
		URL url;
		try {
			url = new URL(imageUrl);
			Icon icon = new ImageIcon(url);
			imageLabel.setIcon(icon);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "I can't find your image!!");
		}
		
		return imageLabel;
	}

	/* OPTIONAL */
	// *14. add scoring to your quiz
	// *15. make something happen when mouse enters image
	// (imageComponent.addMouseMotionListener())
}
