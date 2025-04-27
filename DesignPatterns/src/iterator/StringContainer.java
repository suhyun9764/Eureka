package iterator;

public class StringContainer implements Container{
    String[] strArray = {"hello","iterator","pattern"};

    @Override
    public Iterator getIterator() {
        return new StringIterator();
    }

    // 클래스 내부에 private iterator 구현 객체를 생성
    private class StringIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext() {
            if(index<strArray.length) return true;
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()) return strArray[index++];
            return null;
        }
    }


}
