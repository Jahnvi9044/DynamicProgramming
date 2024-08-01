package DP2;

import java.util.*;

public class MinNoOfChoclate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here

        }

    }



    public static int getMin(int arr[], int N){

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        return getMinDp(arr,N);

    }

    public static int getMinDp(int arr[], int n){

        int[] dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++)
        {
            if(arr[i-1]>=arr[i])
            {   dp[i]=1;

            }
            else {
                dp[i]=dp[i-1]+1;
            }


        }


        for(int i=n-2;i>=0;i--)
        {   if(arr[i]>arr[i+1]&& dp[i]<=dp[i+1])
            dp[i]=dp[i+1]+1;


        }
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=dp[i];

        return sum;

    }
}
