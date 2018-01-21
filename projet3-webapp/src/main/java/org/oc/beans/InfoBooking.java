package org.oc.beans;

public class InfoBooking {

    private int topoBooking_topo_id;
    private String borrower_nickname;
    private String date;


    public int getTopoBooking_topo_id() { return topoBooking_topo_id; }

    public void setTopoBooking_topo_id(int topoBooking_topo_id) { this.topoBooking_topo_id = topoBooking_topo_id; }

    public String getBorrower_nickname() { return borrower_nickname; }

    public void setBorrower_nickname(String borrower_nickname) { this.borrower_nickname = borrower_nickname; }

    public String getDate() { return date; }

    public void setDate(String date) {
        this.date = date;
    }

}

