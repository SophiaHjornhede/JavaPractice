package main;

import Biz.ProductsBiz;
import util.DataManagement;
import view.StoreView;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map chart = new HashMap();

    public static void main(String[] args) {

        DataManagement dm = new DataManagement();

        ProductsBiz newBiz = dm.readAllData();

        StoreView.menu(newBiz);

        dm.writeAllData(newBiz);

    }
}