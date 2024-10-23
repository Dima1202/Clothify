package edu.icet.bo.custom.Impl;

import edu.icet.bo.custom.ProductsBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.ProductDao;
import edu.icet.dto.Products;
import edu.icet.entity.ProductsEntity;
import edu.icet.util.DaoType;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;

public class ProductsBoImpl implements ProductsBo {
    @Override
    public ObservableList<ProductsEntity> getAll() {
        ProductDao productDao= DaoFactory.getInstance().getDaoType(DaoType.PRODUCTS);
        return productDao.getAll();
    }

    @Override
    public boolean addProducts(Products products) {
        ProductsEntity entity=new ModelMapper().map(products, ProductsEntity.class);
        ProductDao productDao=DaoFactory.getInstance().getDaoType(DaoType.PRODUCTS);
        productDao.save(entity);
        return false;

    }

    @Override
    public boolean updateProducts(Products products) {
        ProductsEntity entity=new ModelMapper().map(products, ProductsEntity.class);
        ProductDao productDao=DaoFactory.getInstance().getDaoType(DaoType.PRODUCTS);
        productDao.update(entity);

        return false;
    }

    @Override
    public boolean deleteProducts(Products products) {
        ProductsEntity entity=new ModelMapper().map(products, ProductsEntity.class);
        ProductDao productDao=DaoFactory.getInstance().getDaoType(DaoType.PRODUCTS);
        productDao.delete(entity);
        return false;
    }
}
