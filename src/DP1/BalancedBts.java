package DP1;

import java.util.*;

public class BalancedBts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here


            int n=sc.nextInt();
            long[] arr=new long[n+1];
            System.out.println(balancedBTsM( n, arr));
            System.out.println(balancedBTsDp( n));
        }

    }


    public static long balancedBTsM(int n,long[] arr){

        if(n==1||n==0)
            return 1;

        long x,y;
        if(arr[n-1]!=0)
            x=arr[n-1];
        else x=balancedBTsM(n-1,arr)%(1000000000+7);

        if(arr[n-2]!=0)
            y=arr[n-2];
        else y=balancedBTsM(n-2,arr)%(1000000000+7);

        arr[n]=(x*x%(1000000000+7)+2*x*y%(1000000000+7))%(1000000000+7);

        return arr[n];


    }


    public static long balancedBTs(long n){

        if(n==1||n==0)
            return 1;

        long x=balancedBTs(n-1);
        long y=balancedBTs(n-2);

        return x*x+2*x*y;


    }


    public static long balancedBTsDp(long n){
        int k=(int)n;
        long M=1000000000+7;
        long[] arr=new long[k+1];

        if(n==0||n==1)
        {
            return n;

        }
        arr[0]=1;
        arr[1]=1;
        long x,y;

        for(int i=2;i<=k;i++)
        {
             x=arr[i-1];
             y=arr[i-2];

            arr[i]=((2*x*y % M)+(x*x)%M) % M;


        }


        return arr[k];


    }


}
