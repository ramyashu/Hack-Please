package dh;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anvit
 */
package snakeanvit;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import javafx.stage.Stage;
public class randomcall {
    blocks b1;
    snake sn;
    Pane canvas;
    Stage stage;
    token t1;
    magnet m;
    shield sh;
    randomcall(blocks b,snake s,Pane cv,Stage st,token t,magnet m1,shield s1){
        b1=b;
        sn=s;
        canvas=cv;
        stage=st;
        t1=t;
        m=m1;
        sh=s1;
    }
    void select(randomcall h){
    //    System.out.println("yo"+sn.al.size());
  //      canvas.getChildren().add(b1.s);
        Random r=new Random();
        
        int x=r.nextInt(5)+1;
      //  System.out.println(b1.score);
       // canvas.getChildren().add(b1.s);
     //  x=2;
    //    x=4;
       //x=1;
       //System.out.println(x);
        if(x==1 || x==2){
            int u=r.nextInt(100);
           t1.c1.relocate(u+1000,b1.b2.getLayoutY()%800 + 200);
           t1.l.relocate(u+1010,b1.b2.getLayoutY()%800 + 200);
            //canvas.getChildren().addAll(t1.as);
           // boolean b=false;
           
            t1.move1(sn,canvas,h);
        }
        /*else if(x==3){
         //   System.out.println(m.mag);
            
            if(m.mag==true){
                final boolean k=true;
                t1.c1.relocate(r.nextInt(100)+1000,b1.b2.getLayoutY()%800 + 200);
            //canvas.getChildren().addAll(t1.as);
            t1.move1(sn,canvas,h);
         //   System.out.println("hi");
         //   m.mag=false;
            }
            else{
                m.c1.relocate(r.nextInt(100)+1000,b1.b2.getLayoutY()%700 + 200);
            //m.move1(canvas,sn,h);
            }
           //  m.move1(sn, canvas, h);
        }*/
        else if(x==4){
             sh.c1.relocate(r.nextInt(100)+1000,b1.b2.getLayoutY()%600 + 200);
            sh.move1(canvas,sn,h);
            
        }
        else{
            Random r9=new Random();
            
          //  System.out.println("fuck"+sn.al.size());
           b1. b1.setLayoutX(500);b1.b1.setLayoutY(0);
		    		b1.l1.setTranslateX(0);b1.l1.setTranslateY(15);
		    		b1.l1.setText(Integer.toString(r9.nextInt(50)));
		    		b1.b2.setLayoutX(700);b1.b2.setLayoutY(0);
		    		b1.l2.setTranslateX(0);b1.l2.setTranslateY(15);
		    		b1.l2.setText(Integer.toString(r9.nextInt(50)));
		    		b1.b3.setLayoutX(900);b1.b3.setLayoutY(0);
		    		b1.l3.setTranslateX(0);b1.l3.setTranslateY(15);
		    		b1.l3.setText(Integer.toString(3));
		    		b1.b4.setLayoutX(1100);b1.b4.setLayoutY(0);
		    		b1.l4.setTranslateX(0);b1.l4.setTranslateY(15);
		    		b1.l4.setText(Integer.toString(r9.nextInt(sn.al.size())));
                               // canvas.getChildren().add(b1.b3);
        //    System.out.println(b1.al.size());
            b1.move(sn,canvas,stage,h,sh.bl);
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//<ANVIT SACHDEV 2017333><RAMESHWAR MISHRA 2017180>

package snakeanvit;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.*;
/**
 *
 * @author anvit
 */
public class leaderboard extends Application {
    
    @Override
    public void start(final Stage stage) throws IOException{
        Image image = new Image(new FileInputStream("C:\\Users\\rameshwar mishra\\Desktop\\background2.jpg"));
        ImageView imageView = new ImageView(image); 
        imageView.setX(0); 
      imageView.setY(0); 
      imageView.setFitHeight(1000); 
      imageView.setFitWidth(2000);
        final Pane canvas = new Pane();
    	Scene scene = new Scene(canvas, 300, 300, Color.ALICEBLUE);
        final strartpage sp=new strartpage();
         Button btn = new Button();
         btn.setText("Back to Start Page");
         btn.relocate(10,10);
         btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
              //  System.out.println("Hello World!");
                try{
                sp.start(stage);
                }
                catch(Exception e){
                    
                }
            }
        });
        Text t=new Text("LEADERBOARD");
        t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
          t.setX(500);
          t.setY(100);
          Text t1=new Text("User          Score\rameshwar       50 -\nanvit         44 -\nrameshwar        43 -\nrameshwar          41-\nanvit          41");
        t1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
          t1.setX(500);
          t1.setY(200);
          
          canvas.getChildren().add(imageView);
           canvas.getChildren().add(t);
          canvas.getChildren().add(t1);
           canvas.getChildren().add(btn);
       stage.setTitle("Leaderboard");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

class dd extends JFrame
{
	JButton but;
	JTextField t1;
	JTextField t2;
	JTextField t3;
	JTextField t4;
	JTextField t5;
	JTextField t6;
	JTextField t7;
	JTextField t8;
	JTextField t9;
	JTextField t10;
	JLabel namelabel;
	JLabel namelabe;
	JLabel namelab;
	JLabel namela;
	JLabel namel;
	JLabel name;
	JLabel nam;
	JLabel na;
	JLabel n;
	JLabel n1;
	JLabel n2;
	JLabel n3;
	JLabel n4;
	JLabel n5;
	
	private JButton resultArea;
	public dd()
	{
		setLayout(new FlowLayout());
		
		setTitle("Report");
		setSize(200,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		namelabel= new JLabel("No of workers: ",JLabel.LEFT);
		add(namelabel);
		t1 = new JTextField(2);
		add(t1);
		namelabe= new JLabel("skill level: ",JLabel.LEFT);
		add(namelabe);		
		t2 = new JTextField(2);
		add(t2);
		namelab= new JLabel("No of hours worked: ",JLabel.LEFT);
		add(namelab);
		t3 = new JTextField(2);
		add(t3);
		namela= new JLabel("Insurance: ",JLabel.LEFT);
		add(namela);
		t4 = new JTextField(6);
		add(t4);
//		n5= new JLabel("  			 ");
//		add(n5);		

		but = new JButton("output");
		add(but);
		
		event ev = new event();
		but.addActionListener(ev);
		
		namel = new JLabel("      ");
		add(namel);
		n3 = new JLabel("      ");
		add(n3);		
//		name = new JLabel("output");
//		add(name);	
		nam = new JLabel("hours worked: ");
		add(nam);
		t5 = new JTextField(2);
		add(t5);
		na = new JLabel("hourly pay rate: ");
		add(na);
		t6 = new JTextField(2);
		add(t6);
		n = new JLabel("regular pay(40 hours): ");
		add(n);
		t7 = new JTextField(2);
		add(t7);
		n1 = new JLabel(" the overtime pay: ");
		add(n1);
		t8 = new JTextField(2);
		add(t8);	
		n2 = new JLabel("total reg. and OT pay: ");
		add(n2);
		t9 = new JTextField(2);
		add(t9);
		n4 = new JLabel("total item. reduction: ");
		add(n4);
		t10 = new JTextField(2);
		add(t10);
		
		
		
		setVisible(true);
	}
	public class event implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int k = Integer.parseInt(t3.getText());
			t5.setText(""+k);
			if(k<=40)
			{
				if(t2.getText().equals("1"))
				{
					t6.setText(""+170);
					int a = k*170;
					t7.setText(""+a);
					t8.setText(""+0);
					t9.setText(""+a);
					t10.setText(""+0);
				}
				else if(t2.getText().equals("2"))
				{
					t6.setText(""+200);
					int a = k*200;
					t7.setText(""+a);
					t8.setText(""+0);
					t9.setText(""+a);
					if(t4.getText().equals("Medical Insurance"))
					{
						if(k==0)
						{
							t10.setText(""+(-32.50));
						}
						else
						{
							double d = a - 32.50; 
							t10.setText(""+d);
						}
					}
					else if(t4.getText().equals("Dental Insurance"))
					{
						if(k==0)
						{
							t10.setText(""+(-20.00));
						}
						else
						{
							double d = a - 20.00; 
							t10.setText(""+d);
						}
					}
					else if(t4.getText().equals("Long Term Insurance"))
					{
						if(k==0)
						{
							t10.setText(""+(-10.00));
						}
						else
						{
							double d = a - 10.00; 
							t10.setText(""+d);
						}						
					}										
				}
				else if(t2.getText().equals("3"))
				{
					t6.setText(""+450);
					int a = k*450;
					t7.setText(""+a);
					t8.setText(""+0);
					t9.setText(""+a);
					if(t4.getText().equals("Medical Insurance"))
					{
						if(k==0)
						{
							t10.setText(""+(-32.50));
						}
						else
						{
							double d = a - 32.50; 
							t10.setText(""+d);
						}
					}
					else if(t4.getText().equals("Dental Insurance"))
					{
						if(k==0)
						{
							t10.setText(""+(-20.00));
						}
						else
						{
							double d = a - 20.00; 
							t10.setText(""+d);
						}
					}
					else if(t4.getText().equals("Long Term Insurance"))
					{
						if(k==0)
						{
							t10.setText(""+(-10.00));
						}
						else
						{
							double d = a - 10.00; 
							t10.setText(""+d);
						}						
					}					
				}
			}
			else
			{
				if(t2.getText().equals("1"))
				{
					t6.setText(""+170);
					double a = ((k-40)*(170)*1.5);
					int b = 40*170;
					t7.setText(""+b);
					t8.setText(""+a);
					double c= a+b; 
					t9.setText(""+c);
					t10.setText(""+0);
				}
				else if(t2.getText().equals("2"))
				{
					t6.setText(""+200);
					double a = ((k-40)*(200)*1.5);
					int b = 40*200;
					double c = a+b;
					t7.setText(""+b);
					t8.setText(""+a);
					t9.setText(""+c);
					if(t4.getText().equals("Medical Insurance"))
					{
						if(k==0)
						{
							t10.setText(""+(-32.50));
						}
						else
						{
							double d = a - 32.50; 
							t10.setText(""+d);
						}
					}
					else if(t4.getText().equals("Dental Insurance"))
					{
						if(k==0)
						{
							t10.setText(""+(-20.00));
						}
						else
						{
							double d = a - 20.00; 
							t10.setText(""+d);
						}						
					}
					else if(t4.getText().equals("Long Term Insurance"))
					{
						if(k==0)
						{
							t10.setText(""+(-10.00));
						}
						else
						{
							double d = a -10.00; 
							t10.setText(""+d);
						}
					}					
				}
				else if(t2.getText().equals("3"))
				{
					t6.setText(""+450);
					double a = ((k-40)*(450)*1.5);
					int b = 40 * 450;
					double c = a+b;
					t7.setText(""+b);
					t8.setText(""+a);
					t9.setText(""+c);
					if(t4.getText().equals("Medical Insurance"))
					{
						if(k==0)
						{
							t10.setText(""+(-32.50));
						}
						else
						{
							double d = a - 32.50; 
							t10.setText(""+d);
						}
					}
					else if(t4.getText().equals("Dental Insurance"))
					{
						if(k==0)
						{
							t10.setText(""+(-20.00));
						}
						else
						{
							double d = a - 20.00; 
							t10.setText(""+d);
						}
					}
					else if(t4.getText().equals("Long Term Insurance"))
					{
						if(k==0)
						{
							t10.setText(""+(-10.00));
						}
						else
						{
							double d = a - 10.00; 
							t10.setText(""+d);
						}
					}				
				}				
			}

		}
	}	


	public static void main(String[] args)
	{
		JFrame fr = new dd();
	}

}

