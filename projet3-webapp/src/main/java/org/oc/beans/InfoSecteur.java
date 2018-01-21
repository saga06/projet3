package org.oc.beans;

import org.oc.beans.InfoSite;

public class InfoSecteur extends InfoSite {
    private String name;
    private String description;
    public int site_id;
    private int sector_id;

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


    public int getSite_id() {
        return site_id;
    }


    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public int getSector_id() {
        return sector_id;
    }


    public void setSector_id(int sector_id) {
        this.sector_id = sector_id;
    }
}

