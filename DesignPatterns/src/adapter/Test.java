package adapter;

public class Test {
    public static void main(String[] args) {
        LegacyFuncImpl legacyFunc = new LegacyFuncImpl();
        System.out.println(legacyFunc.calc(10));

        LegacyFuncAdapterImpl legacyFuncAdapter = new LegacyFuncAdapterImpl(legacyFunc);
        System.out.println(legacyFuncAdapter.calc(10 ));
    }
}
