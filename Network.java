import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.Random;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import javax.imageio.ImageIO;
public class Network extends JFrame implements ActionListener, MouseListener
{
    Canvas myGraphic;
    final String Source = "Source.png";
    ImageIcon SourceIcon = new ImageIcon(Source);
    final String Sink = "Sink.png";
    ImageIcon SinkIcon = new ImageIcon(Sink);
    final String linearPipe = "Pipes2.png";
    ImageIcon PipeIcon = new ImageIcon(linearPipe);
    Pipe Grid[][] = new Pipe[10][10];
    public Network(){
        //NOTES:
        //You should not use the array
        //A pipe should only have position defined based on 
        int x = 500;
        int y = 500;
        Scanner inputStream = new Scanner(System.in);
        String Titlename = "WaterNetwork";
        setTitle(Titlename);
        this.getContentPane().setPreferredSize(new Dimension(x,y));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.toFront();
        this.setVisible(true);

        JMenuBar Bar = new JMenuBar();
        this.setJMenuBar(Bar);
        JMenu Menu1 = new JMenu("Menu1");
        Bar.add(Menu1);
        JMenuItem Item1 = new JMenuItem("Item number 1");
        Item1.setAccelerator(KeyStroke.getKeyStroke("DOWN"));
        Item1.addActionListener(this);
        Menu1.add(Item1);
        addMouseListener(this); 
        JPanel stage = new JPanel();
        stage.setPreferredSize(new Dimension(x,y));
        Canvas myGraphic = new Canvas();
        stage.add(myGraphic);

        Grid[1][1] = new Pipe(6, 10, 5, 5, Grid);
        Grid[2][1] = new Pipe(1, 10, 2, 1, Grid);
        Grid[3][1] = new Pipe(7, 10, 3, 1, Grid);
        Grid[1][1].Connect(Grid);
        Grid[2][1].Connect(Grid);
        Grid[3][1].Connect(Grid);
        boolean Run = true;
        int a = 0;
        int b = 0;
        try{
            while(Run == true){
                while(y<10){
                    while(x<10){
                        Grid[x][y].Connect(Grid);
                        x = x + 1;
                    }
                    x = 0;
                    y = y + 1;
                }
                repaint();
                Thread.sleep(1000);
            }
        } catch(InterruptedException e){}
    }

    public void actionPerformed(ActionEvent Event){
        Scanner inputStream = new Scanner(System.in);
        String command = Event.getActionCommand(); //this makes the string Command equal the name of the item which was clicked on (eg if I click Item4, it prints out "Item number 4" in the text box
        switch(command){
            case "Item number 1": System.exit(0);
            break;
            default: System.out.println("X");
        }
    }

    public void InteractingWithMouse(){
        JDialog InteractingWithMouse = new JDialog(this);
        InteractingWithMouse.setBounds(200,200,1,1); //(x spawn coordinates, y spawn coordinates, x size, y size)
        InteractingWithMouse.toFront();
        InteractingWithMouse.setTitle("Hello");
        TextArea Text= new TextArea("Greetings, planet!");
        InteractingWithMouse.add(Text);
        InteractingWithMouse.setVisible(true);
    }

    void MakeADialog(String String1, int x, int y){
        JDialog DialogBox3 = new JDialog(this);
        DialogBox3.setBounds(x,y,10*String1.length(),80);
        DialogBox3.toFront();
        DialogBox3.setTitle("Hello");
        TextArea Text3= new TextArea(String1);
        DialogBox3.add(Text3);
        DialogBox3.setVisible(true);
    }

    public void paint(Graphics G){
        super.paint(G);
        int a = 0; //equivalent to x;
        int b = 0; //equivalent to y;
        while(b < 10){
            while(a < 10){
                if(Grid[a][b] != null){
                    if(Grid[a][b].returnPipeType() == 1){
                        PipeIcon.paintIcon(this, G, Grid[a][b].returnX()*50, Grid[a][b].returnY()*50);
                    }else if(Grid[a][b].returnPipeType() == 2){
                    }else if(Grid[a][b].returnPipeType() == 3){
                    }else if(Grid[a][b].returnPipeType() == 4){
                    }else if(Grid[a][b].returnPipeType() == 5){
                    }else if(Grid[a][b].returnPipeType() == 6){
                        SourceIcon.paintIcon(this, G, Grid[a][b].returnX()*50, Grid[a][b].returnY()*50);
                    }else if(Grid[a][b].returnPipeType() == 7){
                        SinkIcon.paintIcon(this, G, Grid[a][b].returnX()*50, Grid[a][b].returnY()*50);
                    }
                }
                a = a + 1;
            }
            a = 0;
            b = b + 1;
        }
        a = 0;
        b = 0;
        PipeIcon.paintIcon(this, G, 100,100);
    }

    public void mouseExited(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}

    public void mouseReleased(MouseEvent e){}

    public void mousePressed(MouseEvent e){}

    public void mouseClicked(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
    }
}
