package _01_methods._5_FlappyBird;

import java.util.Random;

import javax.swing.JOptionPane;

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
    int pipeWidth = 80;
    Random random = new Random();
    int something = random.nextInt(7);

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
    	rect(pipeX, 0, pipeWidth, upperPipeHeight);
    	rect(pipeX, lowerY, pipeWidth, 700);
    	pipeX-=8;
    	teleportPipes();
    	if(intersectsPipes() == true) {
    		int retry = JOptionPane.showOptionDialog(null, "u died", "", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String [] {"revive :)", "ragequit", "..."}, null);
    		if(retry == 0) {
    			JOptionPane.showMessageDialog(null, "HA! bro really thought");
    			System.exit(0);
    		}
    		else if(retry == 2) {	
    			birdX = 60;
    		    birdY = 300;
    		    birdYVelocity = -10;
    		    gravity = 1;
    		    pipeX = 700;
    		    upperPipeHeight = (int) random(100, 400);
    		    pipeGap = 100;
    		    lowerY = upperPipeHeight + pipeGap;
    		    pipeWidth = 80;
    		}
    		else if(retry == 1) {
        		System.exit(0);
        	}
    	}
    		
    	}
    
    
    public void teleportPipes() {
    	if(pipeX <= -pipeWidth) {
    		pipeX = 800;
    		upperPipeHeight = (int) random(100, 400);
    		lowerY = upperPipeHeight + pipeGap;
    	}
    }
    
    boolean intersectsPipes() { 
        if (birdY < upperPipeHeight && birdX > pipeX && birdX < (pipeX+pipeWidth)){
           return true; }
       else if (birdY>lowerY && birdX > pipeX && birdX < (pipeX+pipeWidth)) {
           return true; }
       else { return false; }
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
