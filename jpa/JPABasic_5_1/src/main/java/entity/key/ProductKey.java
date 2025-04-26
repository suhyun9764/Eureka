package entity.key;

import java.io.Serializable;
import java.util.Objects;

public class ProductKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;
    private int number;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductKey key = (ProductKey) o;
        return number == key.number && Objects.equals(code, key.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, number);
    }
}
