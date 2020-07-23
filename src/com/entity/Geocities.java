package com.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Geocities {
    private int geoNameId;
    private String asciiName;
    private String countryRegionCodeIso;
    private Double latitude;
    private Double longitude;
    private String featureCode;
    private Integer admin1Code;
    private String admin2Code;
    private Integer population;
    private Integer elevation;
    private String timeZone;

    @Id
    @Column(name = "GeoNameID")
    public int getGeoNameId() {
        return geoNameId;
    }

    public void setGeoNameId(int geoNameId) {
        this.geoNameId = geoNameId;
    }

    @Basic
    @Column(name = "AsciiName")
    public String getAsciiName() {
        return asciiName;
    }

    public void setAsciiName(String asciiName) {
        this.asciiName = asciiName;
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
    @Column(name = "FeatureCode")
    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    @Basic
    @Column(name = "Admin1Code")
    public Integer getAdmin1Code() {
        return admin1Code;
    }

    public void setAdmin1Code(Integer admin1Code) {
        this.admin1Code = admin1Code;
    }

    @Basic
    @Column(name = "Admin2Code")
    public String getAdmin2Code() {
        return admin2Code;
    }

    public void setAdmin2Code(String admin2Code) {
        this.admin2Code = admin2Code;
    }

    @Basic
    @Column(name = "Population")
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Basic
    @Column(name = "Elevation")
    public Integer getElevation() {
        return elevation;
    }

    public void setElevation(Integer elevation) {
        this.elevation = elevation;
    }

    @Basic
    @Column(name = "TimeZone")
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Geocities geocities = (Geocities) o;
        return geoNameId == geocities.geoNameId &&
                Objects.equals(asciiName, geocities.asciiName) &&
                Objects.equals(countryRegionCodeIso, geocities.countryRegionCodeIso) &&
                Objects.equals(latitude, geocities.latitude) &&
                Objects.equals(longitude, geocities.longitude) &&
                Objects.equals(featureCode, geocities.featureCode) &&
                Objects.equals(admin1Code, geocities.admin1Code) &&
                Objects.equals(admin2Code, geocities.admin2Code) &&
                Objects.equals(population, geocities.population) &&
                Objects.equals(elevation, geocities.elevation) &&
                Objects.equals(timeZone, geocities.timeZone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geoNameId, asciiName, countryRegionCodeIso, latitude, longitude, featureCode, admin1Code, admin2Code, population, elevation, timeZone);
    }
}
