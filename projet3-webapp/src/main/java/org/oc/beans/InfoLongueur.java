package org.oc.beans;

public class InfoLongueur extends InfoVoie {
    private String name;
    private String description;
    public int way_id;
    private int length_id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWay_id() {
        return way_id;
    }

    public void setWay_id(int way_id) {
        this.way_id = way_id;
    }

    public int getLength_id() {
        return length_id;
    }

    public void setLength_id(int length_id) {
        this.length_id = length_id;
    }
}