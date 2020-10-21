package dh;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class dd extends JFrame
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

