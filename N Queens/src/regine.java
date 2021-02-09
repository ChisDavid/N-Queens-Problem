
public class regine {

	public int maxsize =10;
	
	public String afis ;
	
	public Integer nr_sol= new Integer(0);
private	int nr=-1;


	public int [] x= new int [12];
	public Character [][]mat = new Character [12][12];
	public Character [][][] vec = new Character[15000][12][12];
	
	public int nu_se_ataca( int k)
	{
	    for(int j=1;j<k;j++)
	         if(x[k]==x[j] || (j+1==k && x[j]+1==x[k])|| (j+ x[j]==k+x[k])|| k-j==x[k]-x[j])
	           return 0;
	return 1;
	}
	
	
	public void set(int n)
	{
	    for(int i=1;i<=n;i++)
	    {
	        for(int j=1;j<=n;j++)
	       {
	           if(j==x[i])
	        	   mat[i][j]='R';
	         
	           else
	           
	        	   mat[i][j]=' ';

	    }
	    }
	}
	public void afisare(int n)
	{
		set(n);
		nr++;
		nr_sol= new Integer(nr);
		afis=nr_sol.toString();
	    System.out.println("solutia "+ nr);
	    
	    for(int i=1;i<=n;i++)
	    {
	    	for(int j=1;j<=n;j++)
	    	{
	   
	    		vec[nr_sol.intValue()][i][j]=mat[i][j];
	    		System.out.print(mat[i][j].charValue());
	    	
	    	}
	    	System.out.println();
	    }
	}

	public void back(int k, int n) {
		if (n < 4)
			afis = "Nu exista posibilitati";
		else {
			
			for (int j = 1; j <= n; j++) 
			{
				x[k] = j;
				if (nu_se_ataca(k) == 1) 
				{
					if (k == n)
						afisare(n);
					else
						back(k + 1, n);
				}
			}
		}
	}
	public void set_nr(int nr) 
	{
		this.nr = nr;
	}
}
