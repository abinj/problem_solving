package com.abin;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int j = arr.length -1;
        int count = arr.length;
        // System.out.println(count);
        int neg_count =0, pos_count =0, zeros =0;
        for(int  i=0; i<arr.length; i++) {
            if(arr[i] > 0) {
                pos_count++;
            } else if(arr[i] == 0) {
                zeros++;
            } else {
                neg_count++;
            }
            if(i==j) {
                break;
            }
            if(arr[j] >0) {
                pos_count++;
            } else if(arr[j] == 0) {
                zeros++;
            } else {
                neg_count++;
            }
            if(j-i == 1) {
                break;
            }
            j--;

        }
        NumberFormat df = new DecimalFormat("##.######");
        // System.out.println(pos_count);
        // System.out.println(neg_count);
        // System.out.println(zeros);
        System.out.format("%6f\n",(double)pos_count/count);
        System.out.format("%6f\n",(double)neg_count/count);
        System.out.format("%6f",(double)zeros/count);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
