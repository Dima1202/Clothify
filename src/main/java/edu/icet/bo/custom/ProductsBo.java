package edu.icet.bo.custom;

import edu.icet.bo.SuperBo;
import edu.icet.dao.CrudDao;
import edu.icet.dto.Products;
import edu.icet.entity.ProductsEntity;
import javafx.collections.ObservableList;

public interface ProductsBo extends SuperBo {

    ObservableList<ProductsEntity> getAll();
    boolean addProducts(Products products);

    boolean updateProducts(Products products);

    boolean deleteProducts(Products products);
}
