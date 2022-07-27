module com.example.praktikum_database_2072007 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;


    opens com.example.praktikum_jasper_2072007 to javafx.fxml;
    exports com.example.praktikum_jasper_2072007;
    exports com.example.praktikum_jasper_2072007.model;
    exports com.example.praktikum_jasper_2072007.dao;
    exports com.example.praktikum_jasper_2072007.Controller;
    exports com.example.praktikum_jasper_2072007.util;
}