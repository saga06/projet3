package org.oc.beans;

import org.oc.beans.InfoSite;

public class Sector extends InfoSite {
    private String nameSector;
    private String descriptionSector;

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
}
