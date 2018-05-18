

package com.hk.main.java.tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LargetKthElement {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        int count = 1;
        int size = nums.length;
        if (size > 1) {
            for (int i = 0; i < size; i++) {
                if ((i + 1) >= size && nums[i] == nums[i + 1]) {
                    count++;
                } else {
                    if (count >= k) {
                        temp.add(new Integer(nums[i - 1]));

                    }
                    count = 1;
                }
            }
        } else if (k == 1) {
            temp.add(new Integer(nums[0]));
        }
        return temp;

    }
    public List<Integer> topKFrequent1(int[] nums, int k) {
        List<Integer> temp = new ArrayList<Integer>();
        Map<Integer,Integer> map= new HashMap<Integer,Integer>();
        int count =1;
        int size =nums.length;
        for(int i=0;i<size;i++){
           if(map.containsKey(nums[i])){
               map.put(new Integer(nums[i]),new Integer(map.get(nums[i]+1)));
           }else{
               map.put(new Integer(nums[i]),new Integer(1));
           }
        }
        map.forEach((key,v)->{
            temp.add(key);
        });
        return temp;
    }
    public static void main(String[] args) {
        LargetKthElement k= new LargetKthElement();
        int[] nums = new int[]{1,2,4,4,2,5,5,2};
        List<Integer> l= k.topKFrequent1(nums, 2);
        l.forEach(aa->{
            System.out.println(aa+",");
        });
    }

}
