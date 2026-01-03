package _01_methods._5_FlappyBird;

import processing.core.PApplet;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    int birdX = 60;
    int birdY = 300;
    int birdYVelocity = -10;
    int gravity = 1;
    int pipeX = 700;
    int upperPipeHeight = (int) random(100, 400);
    int pipeGap = 100;
    int lowerY = upperPipeHeight + pipeGap;

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
    	noStroke();
    	fill(72, 62, 73);
    	ellipse(birdX, birdY, 45, 45);
    	birdY+=birdYVelocity;
    	birdYVelocity+=gravity;
    	fill(30, 240, 56);
    	rect(pipeX, 0, 80, upperPipeHeight);
    	rect(pipeX, lowerY, 80, 700);
    	pipeX-=8;
    	teleportPipes();
    	
    }
    
    public void teleportPipes() {
    	if(pipeX <= -80) {
    		pipeX = 800;
    		upperPipeHeight = (int) random(100, 400);
    		lowerY = upperPipeHeight + pipeGap;
    	}
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
