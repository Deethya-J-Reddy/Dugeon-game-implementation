import java.util.*;
public class DungeonGame 
{
	/* A utility function to find the minimum initial health required */
	public static int minInitialPoints(int r,int c)
	{
		dp[r-1][c-1]=1-points[r-1][c-1];
		dp[r-1][c-1]=dp[r-1][c-1]<=0?1:dp[r-1][c-1];
		for(int i=r-1;i>=0;i--)
		{
			for(int j=c-1;j>=0;j--)
			{
				if(i==r-1&&j==c-1)
					continue;
				int down=(i==r-1)?Integer.MAX_VALUE:dp[i+1][j]-points[i][j];
				int right=(j==c-1)?Integer.MAX_VALUE:dp[i][j+1]-points[i][j];
				int min=Math.min(down,right);
				dp[i][j]=min<=0?1:min;
			}
		}
		return dp[0][0];
	}
	/* To print the minimal health points needed in each cell */
	public static void showDP(int r,int c)
	{
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}	
	}
	public static int[][] points; // the dungeon matrix
	public static int[][] dp; // to store minimal health points 
	/* Driver program */
	public static void main (String args[])
	{
		Scanner inp = new Scanner(System.in);
		System.out.println("ENTER THE DUNGEON");
		System.out.println("Enter the number of rows and columns in the dungeon: ");
		int r = inp.nextInt();
		int c = inp.nextInt();
		points=new int[r][c];
		dp=new int[r][c];
		System.out.println("The demons are represented by negative integers and orbs by positive integers.\nEnter the dungeon cells: ");
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)
			{
				points[i][j]=inp.nextInt();
			}
		/* Printing the output */
		System.out.println("Minimum Health Required:  "+ minInitialPoints(r,c));
		System.out.println("DP table formed representing the minimum health required at each cell: ");
		showDP(r,c);
		inp.close();
	}
  }




