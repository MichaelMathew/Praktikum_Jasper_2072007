package com.example.praktikum_jasper_2072007.model;

public class Category {
    private int idCategory;
    private String namaCategory;

    public Category(int idCategory, String namaCategory) {
        this.idCategory = idCategory;
        this.namaCategory = namaCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNamaCategory() {
        return namaCategory;
    }

    public void setNamaCategory(String namaCategory) {
        this.namaCategory = namaCategory;
    }

    @Override
    public String toString() {
        return namaCategory;
    }
}
