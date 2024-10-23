package edu.icet.bo.custom;

import edu.icet.bo.SuperBo;
import edu.icet.dto.Suppliers;
import edu.icet.entity.SuppliersEntity;
import javafx.collections.ObservableList;

public interface SuppliersBo extends SuperBo {

    ObservableList<SuppliersEntity> getAll();

    boolean addSupplier(Suppliers suppliers);

    boolean deleteSupplier(Suppliers suppliers);

    boolean updateSupplier(Suppliers suppliers);
}
