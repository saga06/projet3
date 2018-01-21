package org.oc.dao;

import org.oc.beans.InfoBooking;

import java.util.List;

public interface InfoBookingDao {
    void ajouter( InfoBooking infoBooking);
    List<InfoBooking> lister(int ID);
}
