package org.oc.beans;

public class InfoTopo {

    private String topo_name;
    private String description;
    private boolean free;
    private int topo_id;
    private int site_id;
    private String owner_nickname;
    private String site_name;


    public String getOwner_nickname() { return owner_nickname; }

    public void setOwner_nickname(String owner_nickname) { this.owner_nickname = owner_nickname; }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getTopo_name() {
        return topo_name;
    }

    public void setTopo_name(String topo_name) {
        this.topo_name = topo_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getTopo_id() {
        return topo_id;
    }

    public void setTopo_id(int topo_id) {
        this.topo_id = topo_id;
    }

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }
}
