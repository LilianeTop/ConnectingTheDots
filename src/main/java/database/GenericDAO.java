package database;

import java.util.ArrayList;

public interface GenericDAO<T> {
    public void storeOne(T type);
    public ArrayList<T> getAll();
    public void updateOne(T type);
    public void deleteOne(T type);
}
