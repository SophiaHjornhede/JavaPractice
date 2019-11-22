package view;

import Biz.ProductsBiz;

import java.util.Scanner;

public class StoreView {


    public static void menu(ProductsBiz biz) {
        System.out.println(" ");
        System.out.println("****** Welcome to the Star-light Baby Store ****** ");
        System.out.println(" ");
        System.out.println("Please choose one of the following options: ");
        System.out.println("1, Add up new products, ");
        System.out.println("2, Sell products. ");
        System.out.println("3, Search products.");
        System.out.println("4, Show all the products in the warehouse. ");
        System.out.println("5, Quit the system. ");

        menuOptions(biz);
    }

    public static void menuOptions(ProductsBiz biz) {

        Scanner s = new Scanner(System.in);
        String option = s.nextLine();
        switch (option) {
            case "1":
                biz.addProducts(biz);
                menu(biz);
                break;

            case "2":
                ProductsBiz.sellProducts(biz);
                menu(biz);
                break;

            case "3":
                System.out.println("you can search the products by the Type, Brand and Color.");
                System.out.println("Please choose:");
                System.out.println("1, search by type.");
                System.out.println("2, search by brand.");
                System.out.println("3, search by color.");
                searchOption(biz);
                menu(biz);
                break;

            case "4":
                ProductsBiz.productsInWarehouse(biz);
                menu(biz);
                break;

            case "5":
                System.out.println("Thank you for your visit and welcome back! ");
                break;
        }
    }

    public static void searchOption(ProductsBiz biz) {

        Scanner ss = new Scanner(System.in);
        String option = ss.nextLine();
        switch (option) {
            case "1":
                ProductsBiz.searchType(biz);
                break;

            case "2":
                ProductsBiz.searchBrand(biz);
                break;

            case "3":
                ProductsBiz.searchColor(biz);
                break;
        }
    }
}
