package ch16;

public class CalculableImplMinus implements Calculable{
    @Override
    public void calculate(int x, int y) {
        System.out.println(x-y);
    }
}
