package com.example.ghostl.proyectocibertec.model;

public class PrincipalData {

    private String title;
    private String description;
    private String urlImage;
    private int typeData;
    private int eventId;
    private String latitude;
    private String longitude;
    private String location;

    public PrincipalData(String title, String description, String urlImage, int typeData, int eventId, String latitude, String longitude, String location) {
        this.title = title;
        this.description = description;
        this.urlImage = urlImage;
        this.typeData = typeData;
        this.eventId = eventId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location = location;
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

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "PrincipalData{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", typeData=" + typeData +
                ", eventId=" + eventId +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
