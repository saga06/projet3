package org.oc.beans;

public class InfoPoint extends InfoLongueur {
    private String name;
    private String description;
    public int length_id;
    private int point_id;

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

    public int getLength_id() {
        return length_id;
    }

    public void setLength_id(int length_id) {
        this.length_id = length_id;
    }

    public int getPoint_id() {
        return point_id;
    }

    public void setPoint_id(int point_id) {
        this.point_id = point_id;
    }
}
