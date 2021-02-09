import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class mainclass {
	public static String password ="pass";
	 static JFrame f11= new JFrame ("test");
	 static JTextField username = new JTextField(20);
	 
	 public static void metoda()
	 {

	       f11.setVisible(true);
	       f11.setSize(700, 100);
	       
	       
	       JLabel l11= new JLabel("Password :");
	       JLabel l12 = new JLabel("Username :");
	       l11.setLocation(10,10);
	       JPanel p11= new JPanel();
	      
	       
	       username.setLocation(10,10);
	      // p11.add(username);
	       f11.add(p11);
	       
	       p11.add(l12);
	       p11.add(username);
	       p11.add(l11);
	       
	       
	       JPasswordField pass = new JPasswordField(10);
	       pass.setLocation(100, 100);
	       pass.setEchoChar('*');
	       JButton ok= new JButton("Log in");
	       pass.addActionListener(new AL());
	      // p11.add(l11);
	      // p11.add(pass);
	       p11.add(pass);
	       p11.add(ok);
	     
	    }
	    static class AL implements ActionListener
	    {
	    	

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JPasswordField input =(JPasswordField) e.getSource();
				
				char[] passy = input.getPassword();
				String p= new String(passy);
				if(p.equals(password)==true)
				{
					if(username.getText().equals("chis_david_27"))
					{
					regine r= new regine();
					view v= new view(r);
					 press pre = new press(r,v);
					 f11.setVisible(false);
					}
					else
					{
					   JOptionPane.showMessageDialog(null, "Ati introdus un username gresit");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Ati introdus  o parola gresita");
				}
				
			}
	 }
	public static void main(String[] args) {
		
		metoda();
		
		
	}

}
