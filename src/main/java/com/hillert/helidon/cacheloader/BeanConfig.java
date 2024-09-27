package com.hillert.helidon.cacheloader;

import com.oracle.coherence.hibernate.cachestore.HibernateCacheStore;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BeanConfig {

	@PersistenceContext(unitName = "pu1")
	private EntityManager entityManager;

	@Produces
	@Named("hibernateCacheStore")
	HibernateCacheStore produceHibernateCacheStore() {
		SessionFactory sf = ((Session) entityManager.getDelegate()).getSessionFactory();
		return new HibernateCacheStore("com.hillert.helidon.cacheloader.Pokemon", sf);
	}
}
