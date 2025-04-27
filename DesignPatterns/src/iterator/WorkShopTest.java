package iterator;

public class WorkShopTest {
    public static void main(String[] args) {
        String[] strArray = {"abc","def"};
        Integer[] intArray = {1,2,3,4,5};
        Character[] charArray = {'a','b','c'};
        Object[] objArray = {1,"d",'c'};

        // String
        MyContainer<String> myContainer1 = new MyContainer<>(strArray);
        Iterator<String> iterator1 = myContainer1.getIterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println();

        // Integer
        MyContainer<Integer> myContainer2 = new MyContainer<>(intArray);
        Iterator<Integer> iterator2 = myContainer2.getIterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

        System.out.println();

        // Character
        MyContainer<Character> myContainer3 = new MyContainer<>(charArray);
        Iterator<Character> iterator3 = myContainer3.getIterator();
        while (iterator3.hasNext()){
            System.out.println(iterator3.next());
        }

        System.out.println();

        // wild card
        // 타입의 유연성
        // 수정, 추가 불가(읽기 전용)
        MyContainer<?> myContainer4 = new MyContainer<>(strArray);
        Iterator<?> iterator4 = myContainer4.getIterator();
        while (iterator4.hasNext()){
            Object next = iterator4.next();
            System.out.println(next+" "+next.getClass().toString());
        }
//        myContainer4.objArray[0] = 1;

        System.out.println();
        // Object
        // 타입의 안정성
        // 수정, 추가 가능
        MyContainer<Object> myContainer5 = new MyContainer<>(strArray);
        Iterator<Object> iterator5 = myContainer5.getIterator();
        while (iterator5.hasNext()){
            Object next = iterator5.next();
            System.out.println(next+" "+next.getClass().toString());
        }
        myContainer5.objArray[0] = 1;


    }
}
