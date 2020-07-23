package com.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Travelimage {
    private int imageId;
    private String title;
    private String description;
    private Double latitude;
    private Double longitude;
    private Integer cityCode;
    private String countryRegionCodeIso;
    private Integer uid;
    private String path;
    private String content;
    private int hot;
    private Date timeUpload;
    private String theme;


    //the below attribute not in the database
    private String userName;
    private String country;
    private String city;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Date getTimeUpload() {
        return timeUpload;
    }

    public void setTimeUpload(Date timeUpload) {
        this.timeUpload = timeUpload;
    }

    @Basic
    @Column(name = "hot")
    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    @Id
    @Column(name = "ImageID")
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Latitude")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "Longitude")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "CityCode")
    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    @Basic
    @Column(name = "CountryRegionCodeISO")
    public String getCountryRegionCodeIso() {
        return countryRegionCodeIso;
    }

    public void setCountryRegionCodeIso(String countryRegionCodeIso) {
        this.countryRegionCodeIso = countryRegionCodeIso;
    }

    @Basic
    @Column(name = "UID")
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "PATH")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travelimage that = (Travelimage) o;
        return imageId == that.imageId &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(cityCode, that.cityCode) &&
                Objects.equals(countryRegionCodeIso, that.countryRegionCodeIso) &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(path, that.path) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId, title, description, latitude, longitude, cityCode, countryRegionCodeIso, uid, path, content);
    }
}
