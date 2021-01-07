package com.abin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SortListByOccurances {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] nums = br.readLine().trim().split("\\s");
            for(int i =0; i< n;i++) {
                arr[i] = Integer.parseInt(nums[i]);
            }
            int[] sortedNums = sorter(n, arr);
            System.out.println("Test output: " + sortedNums);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] sorter(int n, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i =0; i< arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], (map.get(arr[i]) + 1));
            } else {
                map.put(arr[i], 1);
            }
        }

        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list =
                new LinkedList<Map.Entry<Integer, Integer> >(map.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                if(o2.getValue() == o1.getValue()) {
                    return ((o2.getKey()).compareTo(o1.getKey()));
                }
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        int[] result = new int[map.size()];
        int i =0;
        for(Map.Entry<Integer, Integer> entry : list) {
            result[i] = entry.getKey();
            i++;
        }
        System.out.println("Test output: " + result);
        return result;
    }
}
