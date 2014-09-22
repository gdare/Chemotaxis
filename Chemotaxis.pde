 Bacteria two;
 Bacteria [] colony = new Bacteria[5];
 int wait = 0;
 void setup(){
 	size(300,300);
 	two = new Bacteria(150,100);
 	for(int i = 0; i < colony.length; i++){
 		colony[i] = new Bacteria(150,150);

 	}
 }   
 void draw(){
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
    void randomWalk(){
    	fill(255,0,0);
        xpos = xpos + (int)(Math.random() * 11) - 5;
        ypos = ypos + (int)(Math.random() * 11) - 5;
        if((xpos > 300 || xpos < 0) || (ypos > 300 || ypos < 0)){
        	xpos = 150;
        	ypos = 150;
        }
    }
    void randomJump(){
    	fill(0,255,0);
    	if(wait == 100){
    	    xpos = (int)(Math.random() * 300) + 1;
    	    ypos = (int)(Math.random() * 300) + 1;
    	    wait = 0;
    	}
    }
    void show(){
    	ellipse(xpos,ypos,15,15);
    }
 }    