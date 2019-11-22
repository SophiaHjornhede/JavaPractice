package Biz;

import java.io.Serializable;
import java.util.Map;

public interface Biz<T> extends Serializable {

    public boolean addProducts(T t);
    public boolean sellProducts(T t);
    public T search(T t);
    public Map<String, T> showAll();

}
