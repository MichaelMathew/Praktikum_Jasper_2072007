package com.example.praktikum_jasper_2072007.dao;

import com.example.praktikum_jasper_2072007.model.Category;
import com.example.praktikum_jasper_2072007.model.Menu;
import com.example.praktikum_jasper_2072007.util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuDao implements daoInterface<Menu> {

    @Override
    public ObservableList<Menu> getData() {
        ObservableList<Menu> mList;
        mList = FXCollections.observableArrayList();

        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "SELECT m.idMenu, m.namaMenu, m.hargaMenu, m.description, c.namaCategory, c.idCategory FROM Menu m JOIN Category c ON m.Category_idCategory = c.idCategory";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ResultSet hasil = ps.executeQuery();
            while (hasil.next()) {
                int id = hasil.getInt("idMenu");
                String nama = hasil.getString("namaMenu");
                double harga = hasil.getDouble("hargaMenu");
                String description = hasil.getString("description");
                int CategoryId = hasil.getInt("idCategory");
                String CategoryName = hasil.getString("namaCategory");
                Category c = new Category(CategoryId, CategoryName);
                Menu m = new Menu(id, nama, harga,description,c);
                mList.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mList;
    }

    public void addData(Menu data) {
        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "INSERT INTO Menu(idMenu,namaMenu,hargaMenu,description,Category_idCategory) values(?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ps.setInt(1, data.getIdMenu());
            ps.setString(2, data.getNamaMenu());
            ps.setDouble(3,data.getHargaMenu());
            ps.setString(4,data.getDescription());
            ps.setInt(5,data.getCategory_idCategory().getIdCategory());
            int hasil = ps.executeUpdate();
            if (hasil > 0) {
                System.out.println("Berhasil Add ygy");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteData(Menu data) {
        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "DELETE FROM Menu WHERE idMenu = ?";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ps.setInt(1, data.getIdMenu());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }

    @Override
    public int updateData(Menu data) {
        Connection conn = MyConnection.getConnection();
        String kalimat_sql = "UPDATE Menu set namaMenu = ?, hargaMenu = ?,description = ?,Category_idCategory = ? WHERE idMenu = ?";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(kalimat_sql);
            ps.setString(1, data.getNamaMenu());
            ps.setDouble(2, data.getHargaMenu());
            ps.setString(3, data.getDescription());
            ps.setInt(4, data.getCategory_idCategory().getIdCategory());
            ps.setInt(5, data.getIdMenu());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }
}
