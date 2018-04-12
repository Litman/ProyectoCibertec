package com.example.ghostl.proyectocibertec.model;

public class PrincipalData {

    private String title;
    private String description;
    private String urlImage;
    private int typeData;

    public PrincipalData(String title, String description, String urlImage, int typeData) {
        this.title = title;
        this.description = description;
        this.urlImage = urlImage;
        this.typeData = typeData;
    }

    public int getTypeData() {
        return typeData;
    }

    public void setTypeData(int typeData) {
        this.typeData = typeData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "PrincipalData{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", typeData=" + typeData +
                '}';
    }
}
