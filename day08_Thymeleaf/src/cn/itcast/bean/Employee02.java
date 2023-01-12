package cn.itcast.bean;

public class Employee02 {
    private Integer id;
    private String name;
    private Integer gender;// 0 男  1 女
    private Double salary;
    private Computer computer; // 对象关联

    public Employee02() {
    }

    public Employee02(Integer id, String name, Integer gender, Double salary, Computer computer) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.computer = computer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    public String toString() {
        return "Employee02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                ", computer=" + computer +
                '}';
    }
}
