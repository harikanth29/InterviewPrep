package com.hk.main.java.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BusiestTimeInMall {
     int findBusiestPeriod(int[][] data) {
        // your code goes here
        Map<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<data.length;i++){
            int key = data[i][0];
            int cnt = data[i][2]==1?data[i][1]:-data[i][1];
            if(map.get(key)==null){

                data[i][1]=cnt;
                map.put(key,data[i]);
            }else{

                int[] tmp =map.get(key);
                tmp[1]+=cnt;
                map.put(key,tmp);
            }
        }
        int res =0,idx=0;
        int[][] arr = new int[map.size()][];
        for(int[] val:map.values()){
            arr[idx++]=val;
        }
        Arrays.sort(arr,(a, b)->Integer.compare(a[1],b[1]));
        return arr[arr.length-1][0];
    }


    public static void main(String[] args) {
        int[][] data = new int[][]{{1487799425,14,1},{1487799425,4,1},{1487799425,2,1},{1487800378,10,1},{1487801478,18,1},{1487901013,1,1},{1487901211,7,1},{1487901211,7,1}};
        BusiestTimeInMall sol= new BusiestTimeInMall();
        int res =sol.findBusiestPeriod(data);
        System.out.println("Res:"+res);
    }
}
