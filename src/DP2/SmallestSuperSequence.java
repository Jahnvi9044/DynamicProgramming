package DP2;

import java.util.*;

//q:
//Smallest Super-Sequence
//Send Feedback
//Given two strings S and T with lengths M and N. Find and return the length of their shortest 'Super Sequence'.
//The shortest 'Super Sequence' of two strings is defined as the smallest string possible that will have both the given strings as its subsequences.
//Note:
//If the two strings do not have any common characters, then return the sum of the lengths of the two strings.
//Input Format:
//The first only line of input contains a string, that denotes the value of string S. The following line contains a string, that denotes the value of string T

//Sample Input 1:
//ab
//ac
//Sample Output 1:
//3
//Explanation of Sample Output 1:
//Their smallest super sequence can be "abc" which has length = 3.
//Sample Input 2:
//pqqrpt
//qerepct
//op:9
public class SmallestSuperSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here

        }

    }



        public static int smallestSuperSequence(String str1, String str2) {

            /* Your class should be named Solution
             * Don't write main().
             * Don't read input, it is passed as function argument.
             * Return output and don't print it.
             * Taking input and printing output is handled automatically.
             */



            return  smallestSuperSequenceDp(str1, str2);

        }

        public static int smallestSuperSequenceR(String s, String t)
        {
            if(s.length()==0)
                return t.length();
            if(t.length()==0)
                return s.length();


            if(s.charAt(0)==t.charAt(0))
            {
                return 1+smallestSuperSequenceR(s.substring(1), t.substring(1));
            }

            else{


                int ans1= smallestSuperSequenceR(s.substring(1), t);
                int ans2= smallestSuperSequenceR(s, t.substring(1));

                return Math.min(ans1,ans2)+1;


            }




        }





        public static int smallestSuperSequenceDp(String s, String t)
        {
            if(s.length()==0)
                return t.length();
            if(t.length()==0)
                return s.length();

            int n=s.length();
            int m=t.length();



            int[][] arr=new int[n+1][m+1];



            for(int i=0;i<=m;i++)
            {
                arr[0][i]=i;

            }
            for(int j=0;j<=n;j++)
            {
                arr[j][0]=j;

            }

            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=m;j++)
                {
                    if(s.charAt(n-i)==t.charAt(m-j))
                    {
                        arr[i][j]= 1+arr[i-1][j-1];
                    }
                    else{


                        int ans1= arr[i][j-1];
                        int ans2= arr[i-1][j];

                        arr[i][j]=Math.min(ans1,ans2)+1;


                    }

                }
            }


//    for(int i=0;i<=n;i++)
//    {
// 	   for(int j=0;j<=m;j++)
// 	   {
//               System.out.print(arr[i][j]+" ");
// 	   }

// 	   System.out.println();
//    }

            return arr[n][m];


        }


}
