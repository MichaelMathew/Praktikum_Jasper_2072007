package com.example.praktikum_jasper_2072007.dao;

import com.example.praktikum_jasper_2072007.model.Category;
import com.example.praktikum_jasper_2072007.util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDao implements daoInterface<Category> {

    @Override
    public ObservableList<Category> getData() {
        ObservableList<Category> cList;
        cList = FXCollections.observableArrayList();

        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "SELECT * FROM Category";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ResultSet hasil = ps.executeQuery();
            while (hasil.next()) {
                int id = hasil.getInt("idCategory");
                String nama = hasil.getString("namaCategory");
                Category c = new Category(id,nama);
                cList.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cList;
    }

    @Override
    public void addData(Category data) {
        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "INSERT INTO Category(idCategory,namaCategory) values(?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ps.setInt(1, data.getIdCategory());
            ps.setString(2, data.getNamaCategory());
            int hasil = ps.executeUpdate();
            if (hasil > 0) {
                System.out.println("Berhasil Add ygy");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteData(Category data) {
        return 0;
    }

    @Override
    public int updateData(Category data) {
        return 0;
    }
}
