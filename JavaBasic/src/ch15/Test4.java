package ch15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test4 {
    public static void main(String[] args) {
        // Map< Key, value >
        // Key의 중복 허용 x : 이전 value를 덮어 쓴다.
        Map<String, Integer> map = new HashMap<>();
        map.put("aaa",50);
        map.put("aaa",60);
        map.put("aaa",70);
        map.put("bbb",50);
        map.put("ccc",50);
        map.put("ddd",50);


        System.out.println(map.size());
        System.out.println(map.get("aaa"));
        System.out.println(map.containsKey("aaa"));

        // keyset을 이용한 순회
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            String k = iterator.next();
            Integer v = map.get(k);
            System.out.println(k+ " "+ v);
        }
    }
}
