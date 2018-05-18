

package com.hk.main.java.tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SumOfPairs {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 4, 6, 8, 9, 10, 10, 1, 2 };
        int sum = 11;
        List<int[]> lst = new ArrayList<>();
        lst = Arrays.asList(arr);
        Map<Integer, Integer> map = new HashMap<>();
        // lst.contains(6);
        for (int i = 0; i < arr.length; i++) {
            Integer count = 1;
            if (map.get(arr[i]) != null) {
                count = count + map.get(arr[i]);
            }
            map.put(arr[i], count);

        }
        for (int i = 0; i < arr.length; i++) {
            int k = sum - arr[i];
            if (map.containsKey(k) && map.containsKey(arr[i])) {
                System.out.println(arr[i] + ":" + k);
                Integer mapCountI = map.get(arr[i]);
                Integer mapCountK = map.get(k);
                if (mapCountI > 1) {
                    map.put(arr[i], --mapCountI);
                } else {
                    map.remove(arr[i]);
                }
                if (mapCountK > 1) {
                    map.put(k, --mapCountK);
                } else {
                    map.remove(k);
                }
            }
        }
    }

}
