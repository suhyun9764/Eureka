package basic.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSortTest {
    public static void main(String[] args) {
        List<Item> list = new ArrayList<>();
        list.add(new Item(3, "66"));
        list.add(new Item(2, "77"));
        list.add(new Item(5, "33"));
        list.add(new Item(8, "44"));

        System.out.println(list);

        // #1. Comparable
//        Collections.sort(list);
//        System.out.println(list);

        // #2. lamda
        Collections.sort(list, ((o1, o2) -> o1.itemId-o2.itemId));
        System.out.println(list);
    }

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
//static class Item implements Comparable<Item>{
//    int itemId;
//    String itemNm;
//
//    public Item(int itemId, String itemNm) {
//        this.itemId = itemId;
//        this.itemNm = itemNm;
//    }
//
//    @Override
//    public String toString() {
//        return "Item{" +
//                "itemId=" + itemId +
//                ", itemNm='" + itemNm + '\'' +
//                '}';
//    }
//
//    @Override
//    public int compareTo(Item o) {  // 정렬 기준
////            return this.itemId-o.itemId;
////            return o.itemId-this.itemId;
////            return this.itemNm.compareTo(o.itemNm);
//        // itemId 우선 비교하는 데 같은 값이면 itemNm비교
//        if(this.itemId==o.itemId)
//            return this.itemNm.compareTo(o.itemNm);
//
//        return this.itemId-o.itemId;
//    }

}

}