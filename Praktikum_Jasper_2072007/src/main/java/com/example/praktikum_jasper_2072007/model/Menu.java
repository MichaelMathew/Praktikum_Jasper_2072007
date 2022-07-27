package com.example.praktikum_jasper_2072007.model;

public class Menu {
    private int idMenu;
    private String namaMenu;
    private double hargaMenu;
    private String description;
    private Category Category_idCategory;

    public Menu(int idMenu, String namaMenu, double hargaMenu, String description, Category category_idCategory) {
        this.idMenu = idMenu;
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
        this.description = description;
        Category_idCategory = category_idCategory;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public double getHargaMenu() {
        return hargaMenu;
    }

    public void setHargaMenu(double hargaMenu) {
        this.hargaMenu = hargaMenu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory_idCategory() {
        return Category_idCategory;
    }

    public void setCategory_idCategory(Category category_idCategory) {
        Category_idCategory = category_idCategory;
    }
}
