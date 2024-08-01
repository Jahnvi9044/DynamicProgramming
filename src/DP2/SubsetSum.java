package DP2;

import java.util.*;
//ip:4 2 5 6 7
//op:14
public class SubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here

        }

    }


        static boolean isSubsetPresent(int[] arr, int n, int sum) {

            return isSubsetPresentDp(arr, n, sum);

        }

        static boolean isSubsetPresentDp(int[] arr, int n, int sum) {

            boolean [][] dp=new boolean[n+1][sum+1];
            for(int i=0;i<n+1;i++)
                dp[i][0]=true;

            for(  int i = n-1 ; i >=0 ; i-- )
            {
                for(  int j = sum ; j >= 0 ; j--)
                {
                    if( arr[i] <= j )
                    {

                        dp[i][j]=dp[i+1][j-arr[i]];

                    }


                    if(dp[i][j] == false)
                        dp[i][j] =dp[i+1][j];
                }
            }

            return  dp[0][sum];

        }

}
