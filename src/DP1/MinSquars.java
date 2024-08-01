package DP1;

import java.util.*;

public class MinSquars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here
            int n=sc.nextInt();

            int [] arr=new  int[n+1];
            System.out.println(findMinNoOfIntDp(n));
            System.out.println(findMinNoOfIntM(n,arr));
            System.out.println(findMinNoOfInt(n));
        }

    }


    public static int findMinNoOfInt(int n)
    {
        if(n==0)
            return 0;
         int   minInt=findMinNoOfInt(n-1);
         for(int i=2;i*i<=n;i++)
         {
             int q=findMinNoOfInt(n-i*i);
             if(q<minInt)
             {
                 minInt=q;
             }

         }
         return minInt+1;
    }



    public static int findMinNoOfIntM(int n,int[] arr)
    {
        if(n==0)
            return 0;
        int minInt;
        if(arr[n-1]!=0)
            minInt=arr[n-1];
        else minInt=findMinNoOfIntM(n-1,arr);
        for(int i=2;i*i<=n;i++)
        { int q=0;
            if(arr[n-i*i]!=0)
              q=arr[n-i*i];
            else
             q=findMinNoOfIntM(n-i*i,arr);

            if(q<minInt)
            {
                minInt=q;
            }

        }
        arr[n]=minInt+1;
        return arr[n];
    }


    public static int findMinNoOfIntDp(int n)
    {
        int[] arr=new int[n+1];
        if(n==0)
            return 0;
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=n;i++)
        {
            int minInt=arr[i-1];
            for(int j=2;j*j<=i;j++)
            {
                int q=arr[i-j*j];
                if(q<minInt)
                    minInt=q;
            }
            arr[i]=minInt+1;
        }
        return arr[n];
    }
}
