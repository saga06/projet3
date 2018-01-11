package org.oc.dao;

import java.util.List;

import org.oc.beans.InfoSite;

// On a ici une interface qui définit simplement les méthodes sans les implémenter
// C'est donc l'intermédiaire où l'on peut y ajouter d'autres méthodes (supprimer, etc...)
public interface InfoSiteDao {
    void ajouter( InfoSite infoSite);
    List<InfoSite> lister();
}
