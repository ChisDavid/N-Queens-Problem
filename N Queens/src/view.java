
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.AncestorListener;



public class view 
{
	 public static JFrame main_frame = new JFrame("MAIN");
	public  static JFrame frame_Scroll1= new JFrame();
    public static ImageIcon [][][] imagini = new ImageIcon [15000][12][12];
    public static JButton click = new JButton("Click");
    public static JButton clear = new JButton("Clear");
    public static JTextField input = new JTextField(5);
    public static JTextField output = new JTextField(15);
   public static JPanel panel = new JPanel();
    public static JComboBox c = new JComboBox(new String[] {  "Imagini","JTextField" });
    public static JTextField[][][] matrix = new JTextField[15000][12][12];
    public regine r;
    public static String password ="pass";

    static void initimagini(int n, int nr_sol)
    {
        for (int k = 0; k < nr_sol; k++)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    imagini[k][i][j] = new ImageIcon();
                }
            }
        }
    }



    static void init(int n, int nr_sol)
    {
        for (int k = 0; k < nr_sol; k++)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    matrix[k][i][j] = new JTextField(2);
                }
            }
        }
    }

    public static JPanel createPanel(int nr_sol,int dim,Character a [][][]) {
        JPanel panel = new JPanel();
        int  distanta=0;
        
        panel.setLayout(new FlowLayout());
        
       
        initimagini(dim,nr_sol);
        for(int k=0;k<nr_sol;k++)
        {
        	  JPanel pozitie= new JPanel(new GridLayout(dim,dim));
        	for(int i=0;i<dim;i++)
        	{
        		for(int j=0;j<dim;j++)
        		{

        			  if (a[k + 1][i + 1][j + 1].equals('R') == true)
                      {
        				  
        				  if((i+j)%2==0)
        				  {
                         ImageIcon im = new ImageIcon("regina_alb.jpg");
                        
                          imagini[k][i][j] = im;
                          JLabel l = new JLabel(imagini[k][i][j]);
                          pozitie.add(l);
                          }
        				  else
        				  {
        					  ImageIcon im = new ImageIcon("regina_negru.jpg");
                              imagini[k][i][j] = im;
                              JLabel l = new JLabel(imagini[k][i][j]);
                              pozitie.add(l);
        				  }
                      }
        			  else {
                    
                    
                        if((i+j)%2==0)
                        {
                        	
                            ImageIcon im = new ImageIcon("patrat_alb.jpg");
                            imagini[k][i][j] = im;
                            JLabel l = new JLabel(imagini[k][i][j]);
                            pozitie.add(l);
                        }
                        else
                        {
                            ImageIcon im = new ImageIcon("patrat_negru.jpg");
                            imagini[k][i][j] = im;
                            JLabel l = new JLabel(imagini[k][i][j]);
                            pozitie.add(l);
                        }}
                      
                    
        		}
        	}
        	Integer s = new Integer(k+1);
        	JLabel sol = new JLabel("Solutia  "+s.toString());
        	
        	panel.add(sol);
        	panel.add(pozitie);
        }
      
        return panel;
     }
    
    
    
    
    
    
   
    static void add_to_panel(JPanel p,int dim,int nr_sol)
    {

        int z = 0;

        int distantieri=0;
        p.setLayout(new BorderLayout());
        
        //init(nr_sol,dim);
        for(int k=0; k<nr_sol; k++ )
        {
            for (int i = 0; i < dim; i++)
            {
                for (int j = 0; j < dim; j++)
                {
                    matrix[k][i][j].setSize(40, 40);
                    matrix[k][i][j].setLocation(i*50, j*50+k*50*dim+distantieri);
                    matrix[k][i][j].setFont(new Font("Serif",Font.CENTER_BASELINE,15));

                    p.add(matrix[k][i][j]);

                }
            }
            JLabel nr = new JLabel("solutia");

            distantieri=distantieri+100;

        }
    }
    public static void procedura(regine r1)
    {
  	  JPanel p = new JPanel();
  	 
  	
      output.setEditable(false);
      main_frame.setSize(480, 500);
      main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      main_frame.setLocationByPlatform(true);
   
      p.setLayout(null);
   
      JLabel l = new JLabel("Dati dimensiunea matricii      dim =", JLabel.LEFT);
    
      l.setBounds(5, 5, 300, 30);
      p.add(l);
      input.setSize(50, 20);
      input.setLocation(200, 10);
      p.add(input);
      c.setSize(100, 20);
      c.setLocation(350, 10);
      p.add(c);
      output.setSize(200, 50);
      output.setLocation(150, 100);
      p.add(output);
      click.setSize(70, 25);
      click.setLocation(150, 50);
      p.add(click);
      clear.setSize(70, 25);
      clear.setLocation(250, 50);
      p.add(clear);
      
      
      
      
      JButton log_out = new  JButton("Log out")	;
  	log_out.setBounds(180, 400, 100, 30);
  	log_out.addActionListener(new buton_log_out());
  	p.add(log_out);
  		
  	
      main_frame.setContentPane(p);
      main_frame.add(new JLabel ("ana are mere"));
     ImageIcon back_img = new ImageIcon("sah.jpg");
  		Image img = back_img.getImage();
  		Image temp_img = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
  		back_img = new ImageIcon(temp_img);
  		JLabel background = new JLabel("", back_img, JLabel.CENTER);
  		background.setBounds(-15, -20, 500, 500);
  		main_frame.add(background);
  		
  		main_frame.setVisible(true);
  		
  		
  		
  		
  	
  		
  		
  		
  		
  }
    view(int nr_sol,int dim,Character[][][] mat)
    {
    	 
    	
    	 JFrame frame_Scroll= new JFrame();
    	frame_Scroll1=frame_Scroll;
 	
 	  frame_Scroll.  setTitle("JScrollablePanel Test");
 	 frame_Scroll.  setLayout(new BorderLayout());
 	    
 	    
 	   JButton but = new JButton("back");
       but.addActionListener(new AL());
 	      JPanel panel = createPanel(nr_sol,dim,mat);
 	      but.setBounds(400, 400, 60, 30);
 	    panel.add(but);
 	     frame_Scroll.  add(new JScrollPane(panel));
 	    frame_Scroll.  setSize(1000, 500);
 	    
 	   frame_Scroll.   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	  frame_Scroll.   setLocationRelativeTo(null);
 	 frame_Scroll.  setVisible(true);
       
    	
    
    	

    }
    static class AL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			 frame_Scroll1.  setVisible(false);
			 main_frame.setVisible(true);
		
			
		}
    	
    }
    view(int nr_sol,int dim)
    {

        JFrame f1 = new JFrame("solutii");
        init(dim,nr_sol);
        add_to_panel(panel,dim,nr_sol);
        panel.setLayout(null);
       
        panel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
   
        f1.setVisible(true);

        f1.setSize(1000, 1000);
        f1.setContentPane(panel);
       


    }
  
    view(regine r1)
    {
    	  JPanel p = new JPanel();
    	 
    	 this.r=r1;
        output.setEditable(false);
        main_frame.setSize(480, 500);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setLocationByPlatform(true);
     
        p.setLayout(null);
     
        JLabel l = new JLabel("Dati dimensiunea matricii      dim =", JLabel.LEFT);
      
        l.setBounds(5, 5, 300, 30);
        p.add(l);
        input.setSize(50, 20);
        input.setLocation(200, 10);
        p.add(input);
        c.setSize(100, 20);
        c.setLocation(350, 10);
        p.add(c);
        output.setSize(200, 50);
        output.setLocation(150, 100);
        p.add(output);
        click.setSize(70, 25);
        click.setLocation(150, 50);
        p.add(click);
        clear.setSize(70, 25);
        clear.setLocation(250, 50);
        p.add(clear);
        
        
        
        
        JButton log_out = new  JButton("Log out")	;
    	log_out.setBounds(180, 400, 100, 30);
    	log_out.addActionListener(new buton_log_out());
    	p.add(log_out);
    		
    	
        main_frame.setContentPane(p);
        main_frame.add(new JLabel ("ana are mere"));
       ImageIcon back_img = new ImageIcon("sah.jpg");
    		Image img = back_img.getImage();
    		Image temp_img = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
    		back_img = new ImageIcon(temp_img);
    		JLabel background = new JLabel("", back_img, JLabel.CENTER);
    		background.setBounds(-15, -20, 500, 500);
    		main_frame.add(background);
    		
    		main_frame.setVisible(true);
    		
    		
    		
    		
    	
    		
    		
    		
    		
    }
    static class buton_log_out implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		     main_frame.setVisible(false);
		     mainclass m = new mainclass();
		     m.metoda();
			
		}
    	
    }
   
    void button_click(ActionListener m)
    {
        click.addActionListener(m);
    }
    void button_clear(ActionListener m)
    {
        clear.addActionListener(m);
    }
    void reset()
    {
        output.setText(" ");
       
        
    }
    Integer getUserInput()
    {
        return new Integer( input.getText());
    }

    void setTotal(String newTotal)
    {
        output.setText(newTotal);
    }


    String getSelectedString()
    {
        String sel;
        sel = (String)c.getSelectedItem();
        return sel;
    }
    void showError(String errMessage)
    {
        JOptionPane.showMessageDialog(null, this, errMessage, 0);
    }




}
