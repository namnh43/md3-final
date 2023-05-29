package model;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNum;
    private long salary;
    private String department;

    public Employee() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee(int id, String name, String email, String address, String phoneNum, long salary, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.department = department;
    }

    public Employee(String name, String email, String address, String phoneNum, long salary, String department) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.department = department;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
