package DP1;

import java.util.*;

public class ByteLandian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here
            long n=sc.nextLong();
            System.out.println(bytelandianDp(n,new HashMap<>()));
            System.out.println(bytelandian(n,new HashMap<>()));
        }

    }

    public static long bytelandianDp(long n, HashMap<Long, Long> memo) {
        // Write your code here
        int k=(int)n;
        long[] arr=new long[k+1];

        if(  n==1||n==0)
        {
            return n;
        }

        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=k;i++)
        {

            long q2= arr[i/2];
            long q3= arr[i/3];
            long q4= arr[i/4];


            long ans=i;
            long sum=q2+q3+q4;
            if(sum>i)
            {
                ans=sum;
            }

            arr[i]=ans;
        }

        return arr[k];
    }


     public static long bytelandian(long n, HashMap<Long, Long> memo) {
         // Write your code here


         if(  n==1||n==0)
     	{ return n;}

     	long q2= bytelandian(n/2, memo);
     	long q3= bytelandian(n/3, memo);
         long q4= bytelandian(n/4, memo);

         long ans=n;
     	long sum=q2+q3+q4;
     	if(sum>n)
     	{
     		ans=sum;
     	}

     	return ans;
     }



    public static long bytelandianM(long n, HashMap<Long, Long> memo) {
        // Write your code here
        //Handle base case for n=0,1
        if (n<12)
        {
            memo.put(n,n);
            return n;
        }

        if(!memo.containsKey(n))
        {   long ans1=bytelandianM(n/2,memo);
            long ans2=bytelandianM(n/3,memo);
            long ans3=bytelandianM(n/4,memo);

            long currVal=ans1+ans2+ans3;
            if (currVal>n)
                memo.put(n,currVal);
            else
                memo.put(n,n);


        }
        return memo.get(n);
    }
//    The condition (!memo.containsKey(n)) is checking whether the memoization
//    HashMap (memo) contains a key for the current value of n. If the key is not present,
//    it means that the result for this particular value of n has not been memoized yet,
//    and the code proceeds to calculate and memoize it.



//    If !memo.containsKey(n) is true, it means that the HashMap does not yet have a
//    memoized  result for the current value of n.


}
