package com.abin;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//Can you determine the number of ways of making change for a particular number of units using the given types of coins
public class CoinChange_1 {

    public static int getWays(int n, List<Integer> c) {
        return getWays(n, c, 0, new HashMap<String, Integer>());
    }

    public static int getWays(int n, List<Integer> c, int index, HashMap<String, Integer> memo) {
        if(n == 0) {
            return 1;
        }
        if(index >= c.size()) {
            return 0;
        }
        String key = n + "-" + index;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int amountWithCoin = 0;
        int ways =0;
        while(amountWithCoin <= n) {
            int remaining = n - amountWithCoin;
            ways += getWays(remaining, c, index + 1, memo);
            amountWithCoin += c.get(index);
        }
        memo.put(key, ways);
        return ways;
    }

    public static int change(int n, List<Integer> c) {
        int[] combinations = new int[n + 1];

        combinations[0] = 1;

        for(int coin : c) {
            for (int i = coin; i < combinations.length; i++) {
                combinations[i] += combinations[i - coin];
            }
        }
        return combinations[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String firstMultipleInput = bufferedReader.readLine();

        int n = Integer.parseInt(firstMultipleInput);


        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        //Memorization and Dynamic Programming
        long startTime = System.nanoTime();
        int ways = getWays(n, c);
        System.out.println((System.nanoTime() - startTime));
        System.out.println(ways);

        //Iteration and Dynamic Programming
        startTime = System.nanoTime();
        ways = change(n, c);
        System.out.println((System.nanoTime() - startTime));
        System.out.println(ways);


        bufferedReader.close();
    }

}
