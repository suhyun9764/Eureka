package lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LamdaTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.stream()
                .forEach(x->{

                });

//        Calculator calculator = new Calculator() {
//            @Override
//            public int getResult(int a, int b) {
//                return a+b;
//            }
//        };

//        System.out.println(calculator.getResult(1,2));

//        Calculator lambdaCalculator = (x,y)->
//            int i = x + y;

        Predicate<Integer> isEven = x -> x % 2 == 0;
//        System.out.println(lambdaCalculator.getResult(1,2));
    }

    @FunctionalInterface
    interface Calculator{
        void getResult(int a, int b);
    }
}
