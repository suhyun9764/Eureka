package iterator;

// java.util에서 제공하는 Iterator 대신 우리만의 iterator 를 작성
// 컬렉션을 순회하기 위한 메서드를 제공
public interface Iterator<T> {
    boolean hasNext();
    T next();  // generic 적용
}
