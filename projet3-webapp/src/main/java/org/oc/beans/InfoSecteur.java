package org.oc.beans;

import org.oc.beans.InfoSite;

public class InfoSecteur extends InfoSite {
    private String nameSector;
    private String descriptionSector;
    private int site_id;

    public String getNameSector() {
        return nameSector;
    }

    public void setNameSector(String nameSector) {
        this.nameSector = nameSector;
    }

    public String getDescriptionSector() {
        return descriptionSector;
    }

    public void setDescriptionSector(String descriptionSector) {
        this.descriptionSector = descriptionSector;
    }

    @Override
    public int getSite_id() {
        return site_id;
    }

    @Override
    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }
}

