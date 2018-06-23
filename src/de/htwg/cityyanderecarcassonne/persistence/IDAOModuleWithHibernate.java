package de.htwg.cityyanderecarcassonne.persistence;

import com.google.inject.AbstractModule;
import de.htwg.cityyanderecarcassonne.persistence.hibernate.HibernateDAO;

public class IDAOModuleWithHibernate extends AbstractModule {
    @Override
    public void configure() {
        bind(IDAO.class).to(HibernateDAO.class);
    }
}
