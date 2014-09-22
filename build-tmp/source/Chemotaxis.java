import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 Bacteria two;
 Bacteria [] colony = new Bacteria[5];
 int wait = 0;
 public void setup(){
 	size(300,300);
 	two = new Bacteria(150,100);
 	for(int i = 0; i < colony.length; i++){
 		colony[i] = new Bacteria(150,150);

 	}
 }   
 public void draw(){
 	background(0);
 	two.randomJump();
 	two.show(); 
    for(int i = 0; i < colony.length; i++){
 		colony[i].randomWalk();
 		colony[i].show();
 	}
 	wait  = wait + 1;

 }
 class Bacteria{
    int xpos, ypos;
    Bacteria(int x, int y){
    	xpos = x;
    	ypos = y;
    }
    public void randomWalk(){
    	fill(255,0,0);
        xpos = xpos + (int)(Math.random() * 11) - 5;
        ypos = ypos + (int)(Math.random() * 11) - 5;
        if((xpos > 300 || xpos < 0) || (ypos > 300 || ypos < 0)){
        	xpos = 150;
        	ypos = 150;
        }
    }
    public void randomJump(){
    	fill(0,255,0);
    	if(wait == 100){
    	    xpos = (int)(Math.random() * 300) + 1;
    	    ypos = (int)(Math.random() * 300) + 1;
    	    wait = 0;
    	}
    }
    public void show(){
    	ellipse(xpos,ypos,15,15);
    }
 }    
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
