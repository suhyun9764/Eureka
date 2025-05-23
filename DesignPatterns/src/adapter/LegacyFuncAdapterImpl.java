package adapter;

public class LegacyFuncAdapterImpl implements LegacyFuncAdapter{
    // Legacy 코드를 활용하기 위한 코드
    private LegacyFunc legacyFunc;

    public LegacyFuncAdapterImpl(LegacyFunc legacyFunc) {
        this.legacyFunc = legacyFunc;
    }

    public int convertLegacyDataToNewData(int legacyData){
        return legacyData * 2;
    }
    @Override
    public int calc(int num) {
        int legacyData = legacyFunc.calc(num);
        return convertLegacyDataToNewData(legacyData);
    }
}
