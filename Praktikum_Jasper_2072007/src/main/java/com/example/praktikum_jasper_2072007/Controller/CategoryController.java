package com.example.praktikum_jasper_2072007.Controller;

import com.example.praktikum_jasper_2072007.dao.CategoryDao;
import com.example.praktikum_jasper_2072007.model.Category;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class CategoryController {

    public TextField txtID;
    public TextField txtName;
    public Button BtnSave;
    public TableView<Category> TableCategory;
    public TableColumn<Integer,Category> ColID;
    public TableColumn<String,Category> ColCategory;
    ObservableList<Category> cList_tampilan;

    public void initialize() throws IOException {
        ShowData();
    }

    public void ShowData(){
        CategoryDao dao = new CategoryDao();
        cList_tampilan = dao.getData();
        TableCategory.setItems(cList_tampilan);

        ColID.setCellValueFactory(new PropertyValueFactory<>("idCategory"));
        ColCategory.setCellValueFactory(new PropertyValueFactory<>("namaCategory"));
    }

    public void SaveData(ActionEvent actionEvent) {
        CategoryDao dao = new CategoryDao();
        if (txtID.getText().isEmpty() || txtName.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Please Fill all the field",ButtonType.OK);
            alert.show();
        } else {
            dao.addData(new Category(Integer.parseInt(txtID.getText()), txtName.getText()));
            ShowData();
        }
    }

}
