package edu.icet.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.icet.bo.BoFactory;
import edu.icet.bo.custom.ProductsBo;
import edu.icet.bo.custom.SuppliersBo;
import edu.icet.dao.custom.ProductDao;
import edu.icet.dto.Products;
import edu.icet.dto.Suppliers;
import edu.icet.entity.ProductsEntity;
import edu.icet.entity.SuppliersEntity;
import edu.icet.util.BoType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class UserDashboardController  implements Initializable {

    private AnchorPane loadPage;

    @FXML
    private JFXButton btn;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnAdd1;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnDelete1;

    @FXML
    private JFXButton btnManageEmployee;

    @FXML
    private JFXButton btnOrders;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private JFXButton btnProducts;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnUpdate1;

    @FXML
    private JFXComboBox<String> cmbCategory;

    @FXML
    private TableColumn<?, ?> colCatogary;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colSize;

    @FXML
    private TableColumn<?, ?> colSupplierAddress;

    @FXML
    private TableColumn<?, ?> colSupplierContact;

    @FXML
    private TableColumn<?, ?> colSupplierID;

    @FXML
    private TableColumn<?, ?> colSupplierName;

    @FXML
    private TableColumn<?, ?> colSupplierProductName;

    @FXML
    private Label lblProduct;

    @FXML
    private Label lblProduct1;

    @FXML
    private AnchorPane productsPage;

    @FXML
    private AnchorPane suppliersPage;

    @FXML
    private TableView<ProductsEntity> tblProductView;

    @FXML
    private TableView<SuppliersEntity> tblProductView1;

    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtItemName;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private JFXTextField txtSize;

    @FXML
    private JFXTextField txtSupplierAddress;

    @FXML
    private JFXTextField txtSupplierContact;

    @FXML
    private JFXTextField txtSupplierID;

    @FXML
    private JFXTextField txtSupplierName;

    @FXML
    private JFXTextField txtSupplierProductName;


    @FXML
    void btnAddProductOnAction(ActionEvent event) {
        Products products=new Products(Integer.parseInt(txtItemCode.getText()),
                txtItemName.getText(),
                txtSize.getText(),
                Integer.parseInt(txtQuantity.getText()),
                Double.parseDouble(txtPrice.getText()),
                cmbCategory.getValue());

        ProductsBo productsBo=BoFactory.getInstance().getBoType(BoType.PRODUCTS);
        productsBo.addProducts(products);
    }

    @FXML
    void btnDashboardPageOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteProductOnAction(ActionEvent event) {
        Products products=new Products(Integer.parseInt(txtItemCode.getText()),
                txtItemName.getText(),
                txtSize.getText(),
                Integer.parseInt(txtQuantity.getText()),
                Double.parseDouble(txtPrice.getText()),
                cmbCategory.getValue());

        ProductsBo productsBo=BoFactory.getInstance().getBoType(BoType.PRODUCTS);
        productsBo.deleteProducts(products);
    }

    @FXML
    void btnManageEmployeePageOnAction(ActionEvent event) {

    }

    @FXML
    void btnOrderPageOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderPageOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {

    }



    @FXML
    void btnProductPageOnAction(ActionEvent event) {
        loadPage.setVisible(false);
        loadPage=productsPage;
        loadPage.setVisible(true);

        ProductsBo productsBo= BoFactory.getInstance().getBoType(BoType.PRODUCTS);

        colItemCode.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colCatogary.setCellValueFactory(new PropertyValueFactory<>("category"));
        tblProductView.setItems(productsBo.getAll());

    }

    @FXML
    void btnSuppliersPageOnAction(ActionEvent event) {
        loadPage.setVisible(false);
        loadPage=suppliersPage;
        loadPage.setVisible(true);
        loadSupplierTable();



    }

    private void loadSupplierTable() {
        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);

        colSupplierID.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colSupplierName.setCellValueFactory(new PropertyValueFactory<>("suppliersName"));
        colSupplierContact.setCellValueFactory(new PropertyValueFactory<>("suppliersContact"));
        colSupplierAddress.setCellValueFactory(new PropertyValueFactory<>("suppliersAddress"));
        colSupplierProductName.setCellValueFactory(new PropertyValueFactory<>("suppliersProductName"));
        tblProductView1.setItems(suppliersBo.getAll());

        //suppliersBo.getAll();

    }


    @FXML
    void btnUpdateProductOnAction(ActionEvent event) {
        Products products=new Products(Integer.parseInt(txtItemCode.getText()),
                txtItemName.getText(),
                txtSize.getText(),
                Integer.parseInt(txtQuantity.getText()),
                Double.parseDouble(txtPrice.getText()),
                cmbCategory.getValue());

        ProductsBo productsBo=BoFactory.getInstance().getBoType(BoType.PRODUCTS);
        productsBo.updateProducts(products);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPage=productsPage;
        loadPage.setVisible(true);

        ObservableList<String> category= FXCollections.observableArrayList();
        category.add("Gents");
        category.add("Ladies");
        category.add("Kids");
        cmbCategory.setItems(category);
        
        tblProductView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)-> {
            if (newValue!=null){
                setTextToValues(newValue);
            }
        });

        tblProductView1.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)-> {
            if (newValue!=null){
                setTextToSuppliersValues(newValue);
            }
        });

            


    }

    private void setTextToSuppliersValues(SuppliersEntity newValue) {
        txtSupplierID.setText(newValue.getSupplierId().toString());
        txtSupplierName.setText(newValue.getSuppliersName());
        txtSupplierContact.setText(newValue.getSuppliersContact());
        txtSupplierAddress.setText(newValue.getSuppliersAddress().toString());
        txtSupplierProductName.setText(newValue.getSuppliersProductName().toString());

    }

    private void setTextToValues(ProductsEntity newValue) {
        txtItemCode.setText(newValue.getItemCode().toString());
        txtItemName.setText(newValue.getItemName());
        txtSize.setText(newValue.getSize());
        txtQuantity.setText(newValue.getQty().toString());
        txtPrice.setText(newValue.getPrice().toString());
        cmbCategory.setValue(newValue.getCategory());
    }














    @FXML
    void btnAddSupplierOnAction(ActionEvent event) {
        Suppliers suppliers=new Suppliers(Integer.parseInt(
                txtSupplierID.getText()),
                txtSupplierName.getText(),
                txtSupplierContact.getText(),
                txtSupplierAddress.getText(),
                txtSupplierProductName.getText()
        );

        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);
        suppliersBo.addSupplier(suppliers);
    }

    @FXML
    void btnDeleteSupplierOnAction(ActionEvent event) {
        Suppliers suppliers=new Suppliers(Integer.parseInt(
                txtSupplierID.getText()),
                txtSupplierName.getText(),
                txtSupplierContact.getText(),
                txtSupplierAddress.getText(),
                txtSupplierProductName.getText()
        );

        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);
        suppliersBo.deleteSupplier(suppliers);
    }



    @FXML
    void btnUpdateSupplierOnAction(ActionEvent event) {
        Suppliers suppliers=new Suppliers(Integer.parseInt(
                txtSupplierID.getText()),
                txtSupplierName.getText(),
                txtSupplierContact.getText(),
                txtSupplierAddress.getText(),
                txtSupplierProductName.getText()
        );

        SuppliersBo suppliersBo=BoFactory.getInstance().getBoType(BoType.SUPPLIERS);
        suppliersBo.updateSupplier(suppliers);
    }









}
