package basic.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraySort {
    public static void main(String[] args) {
        // 배열 정렬
//
//        // int
//        int[] intArray = {3, 5, 2, 7, 9, 4};
//
//        System.out.println(Arrays.toString(intArray));
//        Arrays.sort(intArray);
//        System.out.println(Arrays.toString(intArray));
//
//        // String
//        String[] strArray = {"hello","abc","world","uplus"};
//        System.out.println(Arrays.toString(strArray));
//        Arrays.sort(strArray);
//        System.out.println(Arrays.toString(strArray));
//        Arrays.sort(strArray, Collections.reverseOrder());
//        System.out.println(Arrays.toString(strArray));

        // 사용자 정의 클래스
        Item[] itemArray = {new Item(3,"66"),new Item(2,"77"),new Item(5,"44"),new Item(8,"11")};
        System.out.println(Arrays.toString(itemArray));
        // #3 Comparator 인터페이스 이용 -lamda
        Arrays.sort(itemArray, (o1,o2)->o1.itemId-o2.itemId );

        System.out.println(Arrays.toString(itemArray));
    }

    // 객체들 을 정렬할 때 기준이 필요,
//    static class Item implements Comparable<Item>{
//        int itemId;
//        String itemNm;
//
//        public Item(int itemId, String itemNm) {
//            this.itemId = itemId;
//            this.itemNm = itemNm;
//        }
//
//        @Override
//        public String toString() {
//            return "Item{" +
//                    "itemId=" + itemId +
//                    ", itemNm='" + itemNm + '\'' +
//                    '}';
//        }
//
//        @Override
//        public int compareTo(Item o) {  // 정렬 기준
////            return this.itemId-o.itemId;
////            return o.itemId-this.itemId;
////            return this.itemNm.compareTo(o.itemNm);
//            // itemId 우선 비교하는 데 같은 값이면 itemNm비교
//            if(this.itemId==o.itemId)
//                return this.itemNm.compareTo(o.itemNm);
//
//            return this.itemId-o.itemId;
//        }

        static class Item {
        int itemId;
        String itemNm;

        public Item(int itemId, String itemNm) {
            this.itemId = itemId;
            this.itemNm = itemNm;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "itemId=" + itemId +
                    ", itemNm='" + itemNm + '\'' +
                    '}';
        }

    }
}
