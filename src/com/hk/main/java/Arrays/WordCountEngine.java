package com.hk.main.java.Arrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class WordCountEngine {
     String[][] wordCountEngine(String document) {
        Map<String,Integer> map = new LinkedHashMap<>();
        String[] strs = document.split(" ");
        for(String str:strs){
            if("".equals(str))continue;
            StringBuilder sb =new StringBuilder();
            for(char c:str.toLowerCase().toCharArray()){
                if(c>='a' && c<='z'){
                    sb.append(c);
                }
            }
            String key = sb.toString();
            if(map.get(key)==null){
                map.put(key,1);
            }else{
                map.put(key,map.get(key)+1);
            }

        }
        String[][] strArr = new String[map.size()][2];
        int idx=0;
        for(String key : map.keySet()){
            strArr[idx][0]=key;
            strArr[idx++][1]=map.get(key)+"";
        }
        Arrays.sort(strArr,(a, b)->String.CASE_INSENSITIVE_ORDER.compare(b[1],a[1]));
        return strArr;

    }


    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        WordCountEngine w = new WordCountEngine();
        String s ="Practice makes perfect, you'll get perfecT by practice. just practice! just just just!!";
        String[][] strArr =  w.wordCountEngine(s);

    }
}
