package entity;

import embedded.MobileNumber;
import embedded.NameIdentifier;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee_id")
    private int id;
    @Column(name = "Employee_name")
    private NameIdentifier name;
    @Column(name = "Employee_address")
    private String address;
    @Column(name = "Employee_salary")
    private double salary;

    @ElementCollection
    @CollectionTable(
            name = "Employee_mobile_nos",
            joinColumns = @JoinColumn(name = "Employee_id")
        )
    private List<MobileNumber> mobileNumbers = new ArrayList<>();

    public List<MobileNumber> getMobileNumbers(){
        return mobileNumbers;
    }

    public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public Employee() {}

    public Employee(int id, NameIdentifier name, String address, double salary, List<MobileNumber> mobileNumbers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.mobileNumbers = mobileNumbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NameIdentifier getName() {
        return name;
    }

    public void setName(NameIdentifier name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name=" + name +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", mobileNumbers=" + mobileNumbers +
                '}';
    }
}
