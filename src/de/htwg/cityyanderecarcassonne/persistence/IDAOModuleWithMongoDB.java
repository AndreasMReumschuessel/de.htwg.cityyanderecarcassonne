package de.htwg.cityyanderecarcassonne.persistence;

import com.google.inject.AbstractModule;
import de.htwg.cityyanderecarcassonne.persistence.mongodb.MongoDBDAO;

public class IDAOModuleWithMongoDB extends AbstractModule {
    @Override
    public void configure() {
        bind(IDAO.class).to(MongoDBDAO.class);
    }
}
