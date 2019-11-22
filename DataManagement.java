package util;

import Biz.ProductsBiz;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DataManagement {

    public ProductsBiz readAllData(){
        ProductsBiz pB = new ProductsBiz();

        try
        {
            pB=new ObjectMapper().reader(ProductsBiz.class).readValue(new File("Products.json"));

        }catch (IOException e){
            System.out.println("File error");
        }
        return pB;
    }

    public void writeAllData(ProductsBiz pB){
        ObjectMapper oM=new ObjectMapper();
        try{
            oM.writerWithDefaultPrettyPrinter().writeValue(new File("Products.json"),pB);
        }catch (IOException e){
            System.out.println("File Write error!");
        }

    }
}
