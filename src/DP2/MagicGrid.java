package DP2;

import java.util.*;
//Ee grid di hui hai  batana hai ki pos [0][0] se pos[n-1][m-1] tak min kitni engery lage ge pahuchne me
//        You are given a magic grid A with R rows and C columns. In the cells of the grid, you will either get magic juice, which increases your strength by [A[i][j]] points, or poison, which takes away [A[i][j]] strength points. If at any point of the journey, the strength points become less than or equal to zero, then you will die.
//        You have to start from the top-left corner cell (1.1) and reach at the bottom-right corner cell (R.C). From a cell (i,j). you can only move either one cell down or right i.e., to cell (i+1.j) or cell (i.j+1) and you can not move outside the magic grid. You have to find the minimum number of strength points with which you will be able to reach the destination cell.
//        Input format:
//        The first line contains the number of test cases T. T cases follow. Each test case consists of R C in th first line followed by the description of the grid in R lines,

//Sample Input 1:
//3
//23
//0 1 -3
//1 -2 0
//2 2
//0 1
//2 0
//3 4
//0 -2 -3 1
//-1 4 0 -2
//1 -2 -3 0
//Sample Output 1:
//2
//1
//2



public class MagicGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here

        }

    }




        public static int getMinimumStrength(int[][] grid) {

            /* Your class should be named Solution
             * Don't write main().
             * Don't read input, it is passed as function argument.
             * Return output and don't print it.
             * Taking input and printing output is handled automatically.
             */


            //  int[][] arr=new  int[grid.length][grid[0].length];
            //  for(int i=0;i<grid.length;i++)
            //  {
            //      for(int j=0;j<grid[0].length;j++)
            //      {
            //          arr[i][j]=100007;
            //      }
            //  }

            //   return   getMinimumStrengthR(grid,0,0,arr);



            return   getMinimumStrengthDp(grid);

        }


        public static  int getMinimumStrengthR(int[][] grid , int i ,int j,int[][] arr)
        {
            if(i==grid.length-1 && j==grid[0].length-1)
            {    arr[i][j]=0;
                return 0;}



            if(arr[i][j]!=100007)
            {
                return arr[i][j];
            }
            int ans1=Integer.MAX_VALUE;
            int ans2=Integer.MAX_VALUE;


            if(i+1<=grid.length-1)
                ans1=getMinimumStrengthR(grid,i+1,j,arr);

            if(j+1<=grid[0].length-1)
                ans2=getMinimumStrengthR(grid,i,j+1,arr);

            int myans=Math.min(ans1,ans2);


            if(grid[i][j]==0)
                myans++;
            if(grid[i][j]<0)
                myans+=Math.abs(grid[i][j]);

            if(grid[i][j]>0)
            {
                myans-=Math.abs(grid[i][j]);
                if(myans<0)
                    myans=0;
            }
            arr[i][j]=myans;
            return  myans;


        }



        public static int getMinimumStrengthDp(int[][] grid)
        {
            int n=grid.length;
            int m=grid[0].length;

            int[][] arr=new  int[grid.length][grid[0].length];
            for(int i=0;i<grid.length;i++)
            {
                for(int j=0;j<grid[0].length;j++)
                {
                    arr[i][j]=100007;
                }
            }

            for(int i=n-1;i>=0;i--)
            {
                for(int j=m-1;j>=0;j--)
                {
                    if(i==n-1 && j==m-1)
                    {
                        arr[i][j]=0;
                        continue;
                    }

                    int ans1=Integer.MAX_VALUE;
                    int ans2=Integer.MAX_VALUE;


                    int myans;
                    if(i+1<=n-1)
                        ans1=arr[i+1][j];
                    if(j+1<=m-1)
                        ans2=arr[i][j+1];
                    myans=Math.min(ans1,ans2);

                    if(grid[i][j]==0)
                        myans++;
                    if(grid[i][j]<0)
                        myans+=Math.abs(grid[i][j]);

                    if(grid[i][j]>0)
                    {
                        myans-=Math.abs(grid[i][j]);
                        if(myans<0)
                            myans=0;
                    }
                    arr[i][j]=myans;


                }
            }

            return arr[0][0];


        }

}
