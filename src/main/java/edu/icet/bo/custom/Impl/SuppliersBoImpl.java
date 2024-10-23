package edu.icet.bo.custom.Impl;

import edu.icet.bo.custom.SuppliersBo;
import edu.icet.dao.DaoFactory;
import edu.icet.dao.custom.SuppliersDao;
import edu.icet.dto.Suppliers;
import edu.icet.entity.SuppliersEntity;
import edu.icet.util.DaoType;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;

public class SuppliersBoImpl implements SuppliersBo {
    @Override
    public ObservableList<SuppliersEntity> getAll() {
        SuppliersDao suppliersDao= DaoFactory.getInstance().getDaoType(DaoType.SUPPLIERS);
        return suppliersDao.getAll();

    }

    @Override
    public boolean addSupplier(Suppliers suppliers) {
        SuppliersEntity suppliersEntity = new ModelMapper().map(suppliers, SuppliersEntity.class);
        SuppliersDao suppliersDao = DaoFactory.getInstance().getDaoType(DaoType.SUPPLIERS);
        suppliersDao.save(suppliersEntity);
        return false;
    }

    @Override
    public boolean deleteSupplier(Suppliers suppliers) {
        SuppliersEntity suppliersEntity = new ModelMapper().map(suppliers, SuppliersEntity.class);
        SuppliersDao suppliersDao = DaoFactory.getInstance().getDaoType(DaoType.SUPPLIERS);
        suppliersDao.delete(suppliersEntity);
        return false;
    }

    @Override
    public boolean updateSupplier(Suppliers suppliers) {
        SuppliersEntity suppliersEntity = new ModelMapper().map(suppliers, SuppliersEntity.class);
        SuppliersDao suppliersDao = DaoFactory.getInstance().getDaoType(DaoType.SUPPLIERS);
        suppliersDao.update(suppliersEntity);
        return false;
    }
}
