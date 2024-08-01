package DP1;

import java.util.*;

public class minStepstoOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here
            int n=sc.nextInt();
            System.out.println(countMinStepsToOneDp(n));

            int[] arr=new int[n+1];

            System.out.println(countMinStepsToOneM(n,arr));

            System.out.println(countMinStepsToOne(n));

        }

    }



        public static int countMinStepsToOne(int n) {

            if(n<=1)
                return 0;


            int min=countMinStepsToOne(n-1);

            // op1
            if(n%3==0)
            {
                int op3=countMinStepsToOne(n/3);
                if(op3<min)
                {
                    min= op3;
                }

            }

            // op2
            if( n%2==0)
            {
                int op2=countMinStepsToOne(n/2);
                if(op2<min)
                {
                    min=op2;
                }

            }


            return min+1 ;
        }
         public static int countMinStepsToOneM(int n,int[] arr) {



        if(n<=1)
        {
            arr[n]=0;
            return 0;
        }
          int min;
        if(arr[n-1]!=0)
          min=arr[n-1];
         else
          min = countMinStepsToOneM(n-1,arr);



        // op1
        if(n%3==0)
        {


            int op3;
            if(arr[n/3]!=0)
                op3=arr[n/3];
            else
                op3=countMinStepsToOneM(n/3,arr);
            if(op3<min)
            {
                min=op3;
            }

        }

        // op2
             if(n%2==0)
             {


                 int op3;
                 if(arr[n/2]!=0)
                     op3=arr[n/2];
                 else
                     op3=countMinStepsToOneM(n/2,arr);
                 if(op3<min)
                 {
                     min=op3;
                 }

             }

        arr[n]= min+1;
        return min+1 ;
    }
         public static int countMinStepsToOneDp(int n)
          {   int[] arr=new int[n+1];

        arr[0]=0;
        arr[1]=0;
        for(int i=2 ;i<=n;i++)
        {
            int min;
            min=arr[i-1];
            if(i%2==0)
            {
                int q2=arr[i/2];
                if(min>q2)
                    min=q2;
            }

            if(i%3==0)
            {
                int q2=arr[i/3];
                if(min>q2)
                    min=q2;
            }

            arr[i]=min+1;


        }

        return arr[n];

    }

}
