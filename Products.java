package Entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;
import java.util.Objects;


@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,property = "type")

public class Products implements Serializable {

    private  String type;
    private  String brand;
    private  int size;
    private  String color;
    private  double price;
    private  int eonCode;
    private  int count;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products)) return false;
        Products products = (Products) o;
        return getSize() == products.getSize() &&
                Double.compare(products.getPrice(), getPrice()) == 0 &&
                getEonCode() == products.getEonCode() &&
                getCount() == products.getCount() &&
                getType().equals(products.getType()) &&
                getBrand().equals(products.getBrand()) &&
                getColor().equals(products.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEonCode(), getType(), getBrand(), getSize(), getColor(), getPrice(), getCount());
    }

    public Products() {
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return
                "eonCode=" + eonCode +
                ", type=" + type + '\'' +
                ", brand=" + brand + '\'' +
                ", size=" + size +
                ", color=" + color + '\'' +
                ", price=" + price +
                ", count=" + count;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getEonCode() {
        return eonCode;
    }

    public void setEonCode(int eonCode) {
        this.eonCode = eonCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
