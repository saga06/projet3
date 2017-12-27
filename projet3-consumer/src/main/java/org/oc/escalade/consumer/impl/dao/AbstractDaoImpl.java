package org.oc.escalade.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDaoImpl {

    @Inject
    @Named("dataSourceProjet3")
    private DataSource dataSource;

    protected DataSource getDataSource(){
        return dataSource;
    }
}
