package org.oc.beans;

import org.oc.beans.Sector;

public class Way extends Sector {
    private String nameWay;
    private int heightWay;
    private String quotationWay;

    public String getNameWay() {
        return nameWay;
    }

    public void setNameWay(String nameWay) {
        this.nameWay = nameWay;
    }

    public int getHeightWay() {
        return heightWay;
    }

    public void setHeightWay(int heightWay) {
        this.heightWay = heightWay;
    }

    public String getQuotationWay() {
        return quotationWay;
    }

    public void setQuotationWay(String quotationWay) {
        this.quotationWay = quotationWay;
    }
}