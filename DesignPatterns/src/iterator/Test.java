package iterator;

public class Test {
    public static void main(String[] args) {
        StringContainer container = new StringContainer();
        Iterator iterator = container.getIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
