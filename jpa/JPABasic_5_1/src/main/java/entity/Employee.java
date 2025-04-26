package entity;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @Column(name="id")
//    @GeneratedValue(strategy = GenerationType.AUTO) // Hibernate에 위임 ( Hibernate가 DB에 맞게 처리 - mysql : sequence)
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // Entity table의 id 컬럼 이용 ( Auto Increment)
    // GenerationType.SEQUENCE, GenerationType.TABLE 은 별도의 TABLE 또는 SEQUENCE를 생성
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;
    private String name;
    private String address;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
