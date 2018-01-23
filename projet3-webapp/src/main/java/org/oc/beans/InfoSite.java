package org.oc.beans;

public class InfoSite {
    private String name;
    private String location;
    private String zipcode;
    private String description;
    private int site_id;
    private String latitude;
    private String longitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
            this.name = name;
        }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSite_id() { return site_id; }

    public void setSite_id(int site_id) { this.site_id = site_id; }

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
}
