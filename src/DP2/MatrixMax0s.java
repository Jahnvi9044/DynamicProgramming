package DP2;

import java.util.*;

//find the length of square matrix that ha max no of zeros

public class MatrixMax0s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here

            int[][] input={

                    {0 ,0 ,0, 0,0 },
                    {0 ,1 ,0 ,1 ,0},
                    {0, 0, 0, 0 ,0},
                    {1, 1, 0, 0 ,0}
            };
            System.out.println( findMaxSquareWithAllZeros(input) );
        }

    }





        public static int findMaxSquareWithAllZeros(int[][] input){

            /* Your class should be named Solution.
             * Don't write main() function.
             * Don't read input, it is passed as function argument.
             * Return output and don't print it.
             * Taking input and printing output is handled automatically.
             */


            int m =input.length;
            if(m==0)
                return 0;
            int n =input[0].length;


            int[][] arr=new int[m][n];
            int max=0;


            //    Initializing column 1 nas row 1
            for(int i=0;i<n;i++)
            {   if(input[0][i]==0)
            { arr[0][i]=1;
                max=1;
            }
            else arr[0][i]=0;

            }
            for(int j=0;j<m;j++)
            {
                if(input[j][0]==0)
                { arr[j][0]=1;
                    max=1;
                }
                else arr[j][0]=0;
            }


            for(int i=1;i<m;i++)
            {

                for(int j=1;j<n;j++)
                {
                    if(input[i][j]==0)
                    {
                        arr[i][j] = Math.min(arr[i-1][j],Math.min(arr[i-1][j-1],arr[i][j-1])) +1 ;
                        if(arr[i][j]>max)
                            max=arr[i][j];
                    }

                    else arr[i][j]=0;


                }

            }

            return max;

        }


    }

