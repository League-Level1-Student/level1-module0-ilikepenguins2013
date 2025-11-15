package _01_methods._1_houses;

import java.awt.Color;
import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */
public class Houses {
	Robot r = new Robot();
	Random rando = new Random();
	String [] sizes = {"small", "medium", "large"};
	Color [] colors = {Color.CYAN, Color.BLUE, Color.WHITE, Color.RED, Color.GREEN, Color.MAGENTA, Color.YELLOW};
	public void run() {
		Robot.setWindowColor(Color.BLACK);
		Robot.setWindowSize(1920, 600);
		r.setX(50);
		r.setY(440);
		r.setSpeed(100);
		r.setPenWidth(3);
		r.penDown();
		for(int i = 0; i < 26; i++) {
			for(int j = 0; j < 1; j++) {
			int randu = rando.nextInt(7);
			int randy = rando.nextInt(3);
			drawHouse(sizes[randy], colors[randu]);
			}
		}
		r.hide();
	}
	public void drawHouse(int height)  {
		r.move(height);
		if(height < 250) {
			drawPointy();
		}
		else {
			drawFlat();
		}
		r.move(height);
		r.turn(-90);
		r.setPenColor(Color.GREEN);
		r.move(30);
		r.turn(-90);
	}
	public void drawHouse(String height, Color color) {
		r.setPenColor(color);
		if(height.equalsIgnoreCase("small")) {
			drawHouse(60);
		}
		if(height.equalsIgnoreCase("medium")) {
			drawHouse(120);
		}
		if(height.equalsIgnoreCase("large")) {
			drawHouse(250);
		}
		
	}
	public void drawPointy() {
		r.turn(45);
		r.move(28);
		r.turn(90);
		r.move(28);
		r.turn(45);
	}
	public void drawFlat() {
		r.turn(90);
		r.move(40);
		r.turn(90);
	}
}