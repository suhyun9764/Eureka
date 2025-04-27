package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericBasicTest {
    public static void main(String[] args) {
        List<Box<String>> genericBoxes = new ArrayList<>();
        genericBoxes.add(new Box<>("a"));
        genericBoxes.add(new Box<>("b"));
//        boxes.add(new Box<>(2));    // 컴파일 오류

        List<Box<?>> wildBoxes = new ArrayList<>();
        wildBoxes.add(new Box<>(1));
        wildBoxes.add(new Box<>("a"));
        wildBoxes.add(new Box<>('b'));  // 여러 개의 타입 가능

        System.out.println(wildBoxes.toString());

        List<?> wildList = genericBoxes;
        System.out.println(wildList);
//        wildList.add(new Box<>("2"));   // 컴파일 오류

        List<Integer> list = new ArrayList<>();
        addNumbers(list);
    }

    public static void printList(List<? extends Number> list){
        for (Number num : list){
            System.out.println(num);
        }

        List<Integer> intList = Arrays.asList(1,2,3);
        printList(intList);	// 정상 동작
    }

    public static void addNumbers(List<? super Integer> list){
        list.add(10);
        list.add(20);

        Object o = list.get(0);
    }
}
