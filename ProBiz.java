package Biz;

import Entity.Products;

public interface ProBiz extends Biz<Products> {

    public Products searchByType(String type);
    public Products searchByBrand(String brand);
    public Products searchByColor(String color);

}
