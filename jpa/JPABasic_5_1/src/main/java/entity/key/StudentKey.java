package entity.key;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentKey implements Serializable {
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
        ProductKey that = (ProductKey) o;
        return number == this.number && Objects.equals(code, this.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, number);
    }

    @Override
    public String toString() {
        return "ProductKey{" +
                "code='" + code + '\'' +
                ", number=" + number +
                '}';
    }
}
