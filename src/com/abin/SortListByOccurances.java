package com.abin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

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
            int[] sortedNums = get_sort(n, arr);
            System.out.println("Test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] get_sort(int n, int[] arr) {
        Arrays.sort(arr);
        reverse(arr);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i =0; i< n; i++) {
            int count =1;
            int lastPoint = 0;
            for (int j=i+1; j< n; j++) {
                lastPoint = j - 1;
                if (arr[i] == arr[j]) {
                    count++;
                } else {
                    break;
                }
            }
            map.put(arr[i], count);
            if (i>= n-1) {
                break;
            }
            i = lastPoint;
        }
        HashMap<Integer, Integer> sortedMap = sortByValue(map, false);
        List<Integer> sortedNumbers = new ArrayList<Integer>(sortedMap.keySet());

        System.out.println("Test output: " + sortedNumbers);
        return new int[0];
    }

    private static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> unsortMap, final boolean order)
    {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
    }

    private static void reverse(int[] input) {
        int last = input.length - 1;
        int middle = input.length/2;
        for(int i =0; i < middle; i++) {
            int temp = input[i];
            input[i] = input[last - i];
            input[last -i] = temp;
        }
    }
}
