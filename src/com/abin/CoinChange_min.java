package com.abin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CoinChange_min {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String firstMultipleInput = bufferedReader.readLine();

        int v = Integer.parseInt(firstMultipleInput);


        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        int min_coins = get_min_coins(v, c);
        System.out.println(min_coins);
    }

    private static int get_min_coins(int v, List<Integer> c) {
        int[] table = new int[v+1];
        table[0] = 0;

        for (int i = 1; i <= v; i++) {
            table[i] = Integer.MAX_VALUE;
        }

        for(int i =1; i<= v; i++) {
            for (Integer coin : c) {
                if (coin <= i) {
                    int sub_res = table[i - coin];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i]) {
                        table[i] = sub_res + 1;
                    }
                }
            }
        }
        return table[v];
    }
}
