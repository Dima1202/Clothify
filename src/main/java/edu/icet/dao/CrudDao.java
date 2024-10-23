package edu.icet.dao;

import javafx.collections.ObservableList;

public interface CrudDao <T> extends SuperDao {

    ObservableList<T> getAll();
    boolean save(T t);

    boolean update(T t);

    boolean delete(T t);
}
