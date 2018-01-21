package org.oc.dao;

import org.oc.beans.InfoComment;

import java.util.List;

public interface InfoCommentDao {
    void ajouter( InfoComment infoComment);
    List<InfoComment> lister(int ID);
}
