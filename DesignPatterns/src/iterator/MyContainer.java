package iterator;

public class MyContainer<T> implements Container<T>{
    T[] objArray;

    @Override
    public Iterator<T> getIterator() {
        return new MyIterator();
    }

    public MyContainer(T[] objArray) {
        this.objArray = objArray;
    }

    private class MyIterator implements Iterator<T>{
        private int index;

        @Override
        public boolean hasNext() {
            if(index<objArray.length) return true;
            return false;
        }

        @Override
        public T next() {
            if(this.hasNext()) return objArray[index++];
            return null;
        }
    }
}
