import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.Random;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import javax.imageio.ImageIO;
public class Pipe
{
    public int pipeType;
    //1 = linear pipe
    //2 = left turn
    //3 = right turn
    //4 = join
    //5 = split
    //6 = source
    //7 = sink
    public int Orientation = 1;
    //1 through 4 for rotation
    public Pipe nextPipe[] = new Pipe[2]; 
    //Records the next pipe. It has an option of a second nextPipe for splits.
    public int maxFlowRate;
    //records the pipes maxFlowRate
    public int flowRate;
    //records the actual flowRate
    public Pipe Sources[] = new Pipe[60];
    //records all of the sources a particular pipe is connected to
    public Pipe Sinks[] = new Pipe[60];
    public int x;
    public int y;
    //the x and y coordinates
    public Pipe(int pipeType, int maxFlowRate, int x, int y, Pipe[][] Grid)
    {
        this.pipeType = pipeType;
        this.maxFlowRate = maxFlowRate;
        this.x = x;
        this.y = y;
        Connect(Grid);
    }

    public void Connect(Pipe[][] Grid){
        switch(pipeType){
            case 1: setNextPipe(Grid[x+1][y]);
            if(nextPipe[0] != null){
            nextPipe[0].flowRate = this.flowRate;
        }
            break;
            case 2:
            break;
            case 3:
            break;
            case 4:
            break;
            case 5:
            break;
            case 6: setNextPipe(Grid[x+1][y]);
            if(nextPipe[0] != null){
            nextPipe[0].flowRate = this.maxFlowRate;
        }
            break;
            case 7: nextPipe = null;
            break;
            default: System.out.println("That is an unnaceptable entry for pipeType");
        }
        //There is an error where the Grid is empty, so the nextPipe is empty. 
    }

    public void setNextPipe(Pipe nextPipe){
        this.nextPipe[0] = nextPipe;
    }

    public int returnPipeType(){
        return this.pipeType;   
    }
    
    public int returnX(){
        return this.x;
    }
    
    public int returnY(){
        return this.y;
    }
    
}