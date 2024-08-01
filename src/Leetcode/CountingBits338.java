package Leetcode;

import java.util.*;
//Done using dp in O(1) time complexity
public class CountingBits338 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
        {   int n=sc.nextInt();

            System.out.println(Arrays.toString(countBits(n)));

        }

    }



        public static  int[] countBits(int n) {
            int[] arr=new int[n+1];

            int i;
            i=1;
            int k=0;
            while(i<=n)
            {
                if( (i&(i-1)) ==0 ) {
                    arr[i] = 1;
                    i++;
                    k=1;
                    continue;
                }
                    arr[i]=arr[k]+1;
                    i++;
                    k++;

            }

            return arr;
        }
    }

