package Biz;

import Entity.Products;
import view.StoreView;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class ProductsBiz implements ProBiz {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductsBiz)) return false;
        ProductsBiz that = (ProductsBiz) o;
        return Objects.equals(wareHouseList, that.wareHouseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wareHouseList);
    }

    private List<Products> wareHouseList= new ArrayList<>(10);

    public List<Products> getWareHouseList() {
        return wareHouseList;
    }

    public static void addProducts(ProductsBiz biz) {

        System.out.println("We have several types of products in our store, they are:");
        System.out.println("jackets");
        System.out.println("shoes");
        System.out.println("gloves");
        System.out.println("pants");
        System.out.println("");

        Products tmp = new Products();

        try {
            Scanner s = new Scanner(System.in);

            System.out.println("What is the product's type you want to add in this time?");
            String type = s.nextLine();
            if(type.equals("jackets")||type.equals("shoes")||type.equals("gloves")||type.equals("pants")) {
                tmp.setType(type);
            }else {
                System.out.println("Unavailable products type, please re-do it.");
                StoreView.menu(biz);
                }

            System.out.println("What is the product's eon-code?");
            int eonCode = s.nextInt();
            tmp.setEonCode(eonCode);

            System.out.println("What is the product's brand?");
            String brand = s.nextLine();
            tmp.setBrand(brand);

            System.out.println("What is the product's color?");
            String color = s.nextLine();
            tmp.setColor(color);

            System.out.println("What is the product's size?");
            int size = s.nextInt();
            tmp.setSize(size);

            System.out.println("What is the product's price?");
            int price = s.nextInt();
            tmp.setPrice(price);

            System.out.println("How many products in this type?");
            int count = s.nextInt();
            tmp.setCount(count);
        } catch (Exception e) {
            System.out.println("Error creating product!");
            e.printStackTrace();
        }

        System.out.println("");
        System.out.println("Now the new products are added up successfully. ");
        System.out.println("Do you want to see the all the products list from our wareHouse? Make your choice below.");
        System.out.println("");

        biz.add(tmp);
        //productsInWarehouse(biz);
    }

    public static void sellProducts(ProductsBiz biz) {

        Scanner s = new Scanner(System.in);

        System.out.println("");
        System.out.println("You can sell the products by scanning/typing the product code.");
        System.out.println("Do you want to see all the available products? type 'y' to have a check, type any other key to continue.");
        System.out.println("");

        String choice = s.nextLine();
        if (choice.equals("y")) {
            productsInWarehouse(biz);
            System.out.println("");
            System.out.println("The product code is:  ");

        }else {
            System.out.println("");
            System.out.println("The product code is:  ");
        }

        try {
            //int tmp= s.nextInt();
            readKeyboard(biz, s);

        } catch (Exception e)
        {
            System.out.println("Error selecting");
        }
    }

    private static void readKeyboard(ProductsBiz biz, Scanner s) {
        String choice;
        choice = s.nextLine();  // new
        int tmp = Integer.parseInt(choice);
        removeProduct(biz,tmp);
    }

    public static void removeProduct(ProductsBiz biz, int ean){

        for(int i=0; i<biz.getWareHouseList().size();i++)
        {
            System.out.println(biz.getWareHouseList().get(i).getEonCode());
            if( biz.getWareHouseList().get(i).getEonCode()==ean&&biz.getWareHouseList().get(i).getCount()==0 ) {
                System.out.println("No products left.");
                break;
            }
            if( biz.getWareHouseList().get(i).getEonCode()==ean){
                int prod=biz.getWareHouseList().get(i).getCount();
                biz.getWareHouseList().get(i).setCount(prod-1);
                System.out.println("The chosen product is successfully removed from the warehouse." );
                return;
            }
            break;
        }
        System.out.println("");
        System.out.println("Wrong product code!");
        System.out.println("");
    }


    public static void searchType(ProductsBiz biz){

        System.out.println("We have several types of products in our store, they are:");
        System.out.println("jackets");
        System.out.println("shoes");
        System.out.println("gloves");
        System.out.println("pants");

        System.out.println("Please write down the products type you want to search in the store:");

        List<Products> type = new ArrayList<>(biz.getWareHouseList());

        Scanner s = new Scanner(System.in);
        String sTemp= s.nextLine();
        List<Products> result = type.stream()
                .filter(x -> sTemp.equals(x.getType()))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    public static void searchColor(ProductsBiz biz){

        System.out.println("Please write down the products color you want to search in the store:");

        List<Products> color = new ArrayList<>(biz.getWareHouseList());

        Scanner s = new Scanner(System.in);
        String sTemp= s.nextLine();
        List<Products> result = color.stream()
                .filter(x -> sTemp.equals(x.getColor()))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
        }


    public static void searchBrand(ProductsBiz biz){

        System.out.println("Please write down the products brand you want to search in the store:");

        List<Products> brand = new ArrayList<>(biz.getWareHouseList());

        Scanner s = new Scanner(System.in);
        String sTemp= s.nextLine();
        List<Products> result = brand.stream()
                .filter(x -> sTemp.equals(x.getBrand()))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }


    void add(Products p){
        wareHouseList.add(p);
    }


    public static void productsInWarehouse(ProductsBiz biz) {

        System.out.println("************************** Star-Light Baby Store: Warehouse info ************************** ");
        System.out.println("");

        biz.getWareHouseList().stream().forEach(e -> System.out.println("Product code: " + e.getEonCode() + ", Type: " + e.getType() +
                ", Brand: " + e.getBrand() + ", Size; " + e.getSize() + " , Color: " + e.getColor() +
                ", Price: " + e.getPrice() +  ", Amount: " + e.getCount()));
    }


    @Override
    public Products searchByType(String type) {
        return null;
    }

    @Override
    public Products searchByBrand(String brand) {
        return null;
    }

    @Override
    public Products searchByColor(String color) {
        return null;
    }

    @Override
    public boolean addProducts(Products products) {
        return false;
    }

    @Override
    public boolean sellProducts(Products products) {
        return false;
    }

    @Override
    public Products search(Products products) {
        return null;
    }

    @Override
    public Map<String, Products> showAll() {
        return null;
    }
}



