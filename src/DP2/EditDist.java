package DP2;

import java.util.*;
//Question :




//Find the minimum no. of changes that have to be made to equate th eto strings , minimum changes in string s that are
//required to be made

// String s1="adef";
//                String s2="bedf";
//the ans ==3
public class EditDist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here


            {

                String s1="adef";
                String s2="bedf";


                int m=s1.length();
                int n=s2.length();


                int[][] arr=new int[m+1][n+1];

                for(int i=0;i<=m;i++)
                {
                    for(int j=0;j<=n;j++)
                    {
                        arr[i][j]=-1;
                    }
                }


                System.out.println(editDistM(s1, s2,arr));


                System.out.println(editDistDp(s1,s2));
            }


        }

    }




        public static int editDist(String s, String t)
        {

            if(s.length()==0)
                return t.length();


            if(t.length()==0)
                return s.length();


            if(s.charAt(0)==t.charAt(0))
            {
                return editDist(s.substring(1), t.substring(1));
            }


            else {
                int ans1=editDist(s.substring(1), t);
                int ans2=editDist(s.substring(1), t.substring(1));

                int ans3=editDist(s, t.substring(1));

                return Math.min(ans1,Math.min(ans2,ans3))+1;


            }


        }





        public static int editDistM(String s, String t,int[][] arr)
        {

            int m=s.length();
            int n=t.length();

            if(s.length()==0)
                return t.length();


            if(t.length()==0)
                return s.length();

            if(arr[m][n]!=-1)
            {
                return arr[m][n];
            }


            if(s.charAt(0)==t.charAt(0))
            {
                arr[m][n]= editDistM(s.substring(1), t.substring(1),arr);
            }


            else {
                int ans1=editDistM(s.substring(1), t,arr);
                int ans2=editDistM(s.substring(1), t.substring(1),arr);

                int ans3=editDistM(s, t.substring(1),arr);

                arr[m][n]= Math.min(ans1,Math.min(ans2,ans3))+1;


            }

            return arr[m][n];


        }






    public static int editDistDp(String s, String t) {

        int m = s.length();
        int n = t.length();


        int[][] arr = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                arr[i][j] = -1;

                if (i == 0)
                    arr[i][j] = j;
                if (j== 0)
                    arr[i][j] = i;

            }
        }


        if (s.length() == 0)
            return t.length();


        if (t.length() == 0)
            return s.length();

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (s.charAt(m - i) == t.charAt(n - j))
                {
                    arr[i][j] = arr[i - 1][j - 1];
                }
                else
                {
                    int ans1 = arr[i][j - 1];
                    int ans2 = arr[i - 1][j - 1];

                    int ans3 = arr[i-1][j];

                    arr[i][j] = Math.min(ans1, Math.min(ans2, ans3)) + 1;


                }

            }



        }
        return arr[m][n];
    }
}
