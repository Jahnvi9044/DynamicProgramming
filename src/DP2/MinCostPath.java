
package DP2;

import java.util.*;


public class MinCostPath {

//Quetion : find the minimum cost required to cover the given distance
//      int[][] input={
//                    { 5, 7 ,2 ,4},
//                    {1, 8, 1, 3},
//                    {6, 2, 9, 5},
//                    {1, 6, 2, 8}};
//            int[][] arr=new int[input.length][input[0].length];
////op: 18


//    for the given input the ans is 18

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here

            int[][] input={
                    { 5, 7 ,2 ,4},
                    {1, 8, 1, 3},
                    {6, 2, 9, 5},
                    {1, 6, 2, 8}};
            int[][] arr=new int[input.length][input[0].length];
//op: 18
            System.out.println( minCostPathM(0, 0,input,arr));
            System.out.println( minCostPathDp(0, 0,input));
            System.out.println( minCostPath(0, 0,input));
        }

    }





    public static int minCostPath(int i , int j,int[][] input)
    {

        if(i==input.length-1 && j==input[0].length-1)
            return input[i][j];
        int ans1=Integer.MAX_VALUE,ans2=Integer.MAX_VALUE,ans3=Integer.MAX_VALUE;
        if( i+1<=input.length-1)
            ans1=minCostPath(i+1,j,input);

        if( i+1<=input.length-1 && j+1<=input.length-1 )
            ans2=minCostPath(i+1,j+1,input);

        if( j+1<=input[0].length-1)
            ans3=minCostPath(i,j+1,input);

        int myans=Math.min(Math.min(ans1,ans2),ans3);
        return myans+input[i][j];

    }

    public static int minCostPathM(int i , int j,int[][] input,int[][] arr)
    {

        if(i==input.length-1 && j==input[0].length-1)
            return input[i][j];


        if(arr[i][j]!=0)
            return arr[i][j];
        int ans1=Integer.MAX_VALUE,ans2=Integer.MAX_VALUE,ans3=Integer.MAX_VALUE;
        if( i+1<=input.length-1)
            ans1=minCostPathM(i+1,j,input,arr);

        if( i+1<=input.length-1 && j+1<=input.length-1 )
            ans2=minCostPathM(i+1,j+1,input,arr);

        if( j+1<=input[0].length-1)
            ans3=minCostPathM(i,j+1,input,arr);

        int myans=Math.min(Math.min(ans1,ans2),ans3);


        arr[i][j]=myans+input[i][j];
        return myans+input[i][j];

    }
    public static int minCostPathDp(int i , int j,int[][] input)
    {
        int[][] arr=new int[input.length][input[0].length];

        if(i==input.length-1 && j==input[0].length-1)
            return input[i][j];

        arr[0][0]=input[0][0];

        int ans1,ans2,ans3;

        for(i=0;i<input.length;i++)
        {

            for(j=0;j<input[0].length;j++)
            {
                if(i==0&&j==0)
                    continue;
                ans1=Integer.MAX_VALUE;
                ans2=Integer.MAX_VALUE;
                ans3=Integer.MAX_VALUE;

                if(i-1>=0)
                    ans1=arr[i-1][j];

                if(i-1>=0 && j-1>=0)
                    ans2=arr[i-1][j-1];

                if(j-1>=0)
                    ans3=arr[i][j-1];

                arr[i][j]=input[i][j]+Math.min(Math.min(ans1,ans2),ans3);
            }

        }

        //  for( i=0;i<input.length;i++)
        //  {
        // 	 for( j=0;j<input[0].length;j++)
        // 	 {
        // 		 System.out.print(arr[i][j]+" ");
        // 	 }

        // 	 System.out.println();
        //  }
        return arr[input.length-1][input[0].length-1];

    }

}

