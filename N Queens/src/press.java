import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class press{
   public regine r;
   public view view ;

   
   public void texte (int nr_sol,int dim)
   {
	   for(int k=1;k<=nr_sol;k++)
		{
			for(int i=0;i<dim;i++)
			{
				for(int j=0;j<dim;j++)
				{
					
					if((i+j)%2==0)
					{
						
						view.matrix[k-1][i][j].setBackground(Color.gray);
					}
					
					
					view.matrix[k-1][i][j].setText(r.vec[k][i+1][j+1].toString());
				}
			}
		}
   }
 
 press(regine r1, view view1) 
{
	super();
	this.r = r1;
	this.view = view1;
	view1.button_click(new ClickListener());
	view1.button_clear(new ClearListener());
}
     class ClearListener implements ActionListener
     {
    	
		@Override
		
		public void actionPerformed(ActionEvent e) {
			
			view.reset();
			
			
		}
	}

	class ClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) 
		{
			Integer input = null;
			
				String sel = view.getSelectedString();
				input = view.getUserInput();
				r.set_nr(0);
				r.back(1, input.intValue()); 
				System.out.println(r.nr_sol.intValue());
				if (sel.equals("JTextField")==true)
				{
					view v1=  new view(r.nr_sol.intValue(),input.intValue());
					view.setTotal(r.nr_sol.toString());
					texte(r.nr_sol.intValue(),input.intValue());
				}
				else
				{
					view.setTotal(r.nr_sol.toString());
	                view.main_frame.setVisible(false);
					view v1=  new view(r.nr_sol.intValue(),input.intValue(),r.vec);
				}
			    
			
			}

		}


	
  
}