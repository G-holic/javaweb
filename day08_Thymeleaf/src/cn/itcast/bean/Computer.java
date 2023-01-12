package cn.itcast.bean;

public class Computer {
    private Integer id;
    private String brand;
    private Double price;

    public Computer() {
    }

    public Computer(Integer id, String brand, Double price) {
        this.id = id;
        this.brand = brand;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
