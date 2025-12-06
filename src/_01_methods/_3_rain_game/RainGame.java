package _01_methods._3_rain_game;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

import javax.swing.JOptionPane;

/*
 * Goal: Make a game where the user has to catch rain drops in a bucket!
 * 
 * In the setup() method:
 * 1. If you are using an image for the bucket, load it and resize it here.
 *    A bucket image, bucket.png, has been provided if you want to use it.
 *    bucket = loadImage("images/bucket.png");
 *    bucket.resize(100, 100);  // you can choose values other than 100, 100
 * 
 * In the draw() method:
 * 2. Set a background color
 * 
 * 3. Draw a raindrop (ellipse) at the top of the screen
 * 
 * 4. Make the rain fall down the screen.
 *    Hint: make a variable for the raindrop's Y position and change it after
 *    you draw the raindrop.
 * 
 * 5. When the rain falls off the bottom of the canvas, start a new rain drop
 *    falling from the top.
 *    Each new drop should start at a random position (X position) at the top.
 *    Hint: This code will get a random number between 0 and the window width.
 *    int randomNumber = (int)random(width);
 * 
 * 6. Draw a bucket (rectangle or image) at the bottom of the screen.
 *    The bucket's width needs to be stored in the bucketWidth variable.
 * 
 * 7. Make the bucket move side-to-side with the mouse. Hint: use mouseX
 * 
 * 8. When the rain drop has fallen to the bucket, call the checkCatch() method
 *    to see if the rain drop is in the bucket.
 * 
 * 9. Show the current score on the screen using the code below.
 *    Change the color if it does not show up on your background.
 *    fill(0, 0, 0);
 *    textSize(16);
 *    text("Score: " + score, 20, 20);
 */
public class RainGame extends PApplet {
	static final int WIDTH = 600;
	static final int HEIGHT = 600;
	Random randy = new Random();
	int speed = 20;
	int dropX = randy.nextInt(601);
	int drop2X = randy.nextInt(601);
	int drop3X = randy.nextInt(601);
	int dropY = -5;
	int drop2Y = -175;
	int drop3Y = -345;
	int score = 0;
	int bucketWidth = 50;
	int bucketHeight;
	int hearts = 3;
	PImage person;
	int y;
	int x;

	// Sets the size of your canvas
	@Override
	public void settings() {
		size(WIDTH, HEIGHT);
	}

	@Override
	public void setup() {
		person = loadImage("images/stickman2.png");
		person.resize(90, 115);
	}

	@Override
	public void draw() {
		background(53, 214, 232);
		fill(129,255,0);
		stroke(129,255,0);
		ellipse(dropX, dropY, 30, 45);
		dropY += speed;
		if (dropY >= HEIGHT) {
			dropY = -5;
			dropX = randy.nextInt(601);
			score++;
			if(score >= 500) {
				JOptionPane.showMessageDialog(null, "You got jebaited. You just wasted 10 minutes of ur life. BWAHAHAHAHAHAHAHAHAHHAHAHAHAHAHHAHAHAHAHAHAH! U STINK");
			}
		}
		if (dropY >= 480) {
			checkCatch(dropX);
		}
		if (score > 50) {
			ellipse(drop2X, drop2Y, 30, 45);
			drop2Y += speed;
			if (drop2Y >= HEIGHT) {
				drop2Y = -5;
				drop2X = randy.nextInt(601);
				score++;
				if(score >= 500) {
					JOptionPane.showMessageDialog(null, "You got jebaited. You just wasted 10 minutes of ur life. BWAHAHAHAHAHAHAHAHAHHAHAHAHAHAHHAHAHAHAHAHAH! U STINK");
				}
			}
			if (drop2Y >= 480) {
				checkCatch(drop2X);
			}
		}
		if (score > 100) {
			ellipse(drop3X, drop3Y, 30, 45);
			drop2Y += speed;
			if (drop3Y >= HEIGHT) {
				drop3Y = -5;
				drop3X = randy.nextInt(601);
				score++;
				if(score >= 500) {
					JOptionPane.showMessageDialog(null, "You got jebaited. You just wasted 10 minutes of ur life. BWAHAHAHAHAHAHAHAHAHHAHAHAHAHAHHAHAHAHAHAHAH! U STINK");
				}
			}
			if (drop3Y >= 480) {
				checkCatch(drop3X);
			}
		}
		image(person, mouseX - 45, 474);
		fill(0, 0, 0);
		textSize(16);
		text("Score: " + score, 20, 20);
		text("do you have ultra instinct?", 20, 40);
		text("ur lives: " + hearts, 20, 60);
	}

	static public void main(String[] args) {
		PApplet.main(RainGame.class.getName());
	}

	void checkCatch(int dropX) {
		if (dropX > mouseX - 30 && dropX < mouseX + 30) {
			hearts--;
			if(hearts <= 0) {
				int retry = JOptionPane.showOptionDialog(null, "u died", "", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String [] {"Get another life", "Accept your fate and die"}, null);
				if(retry == 0) {
					drop2Y = -200;
					dropY = -5;
					score = 0;
					hearts = 3;
				}
				else {
					System.exit(0);
				}
			
			}
		}
	}	
	}
