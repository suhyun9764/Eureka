package entity;

import jakarta.persistence.*;

import java.util.List;

// id, orders 없는 param 생성자, 기본생성자 추가
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private char gender;
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;

    public Customer() {
    }

    public Customer(String name, char gender, String phone) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", phone=" + phone + "]";
    }
}