package _01_methods._5_FlappyBird;

import processing.core.PApplet;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    int birdX = 60;
    int birdY = 300;
    int birdYVelocity = -10;
    int gravity = 1;

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        
    }

    @Override
    public void draw() {
    	background(135, 206, 235);
    	fill(72, 62, 73);
    	stroke(72, 62, 73);
    	ellipse(birdX, birdY, 45, 45);
    	birdY+=birdYVelocity;
    	birdYVelocity+=gravity;
    	
    	
    	
    }
    
    public void mousePressed() {
    	if(mousePressed) {
    		birdYVelocity = -10;
    	}
    }

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
