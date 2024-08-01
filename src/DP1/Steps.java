package DP1;

import java.util.*;

public class Steps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here
            int n=sc.nextInt();
           long [] arr=new long[n+1];
            System.out.println(staircase(n));
            System.out.println(staircaseM(n,arr));
            System.out.println(staircaseDp(n));
        }

    }

    public static long staircase(int n) {
        //Your code goes here

        if(n==0)
        {
            return 1;

        }


        long count=staircase(n-1);;
        if(n>=2)
        {   count+=staircase(n-2);

        }

        if(n>=3)
        {   count+=staircase(n-3);

        }



        return count;


    }


    public static long staircaseM(int n,long[] arr) {
        //Your code goes here

        if(n==0)
        {
            return 1;

        }


        long count=0;
        if(arr[n-1]!=0)
            count=arr[n-1];
        else
            count=staircaseM(n-1,arr);
        if(n>=2)
        {
            if(arr[n-2]!=0)
                count+=arr[n-2];
            else
            count+=staircaseM(n-2,arr);

        }

        if(n>=3)
        {   if(arr[n-3]!=0)
            count+=arr[n-3];
            else
            count+=staircaseM(n-3,arr);


        }

        arr[n]=count;

        return arr[n];


    }



    public static long staircaseDp(int n) {
        int[] arr = new int[n + 1];
        arr[0]=1;
        arr[1]=1;
        arr[2]=2;
        for (int i = 3; i <= n; i++)
        {
            arr[i]=arr[i-1]+arr[i-2]+arr[i-3];

        }
        return arr[n];


    }


}

