package methodchain;

public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("abc");
        sb.append("def");

        sb.append("ghi").append("jk;");
        System.out.println(sb);

        // Calculator - patter 적용전
        Calculator calculator = new Calculator();

        // 3 + 5
        calculator.setFirst(3);
        calculator.setSecond(5);
        calculator.add();

        // 3 - 1
        calculator.setSecond(1);
        calculator.sub();

        // Calculator - pattern 적용 후
        Calculator calc = new Calculator();
        calc.setFirst(3).setSecond(5).add().setSecond(1).sub();
    }
}
