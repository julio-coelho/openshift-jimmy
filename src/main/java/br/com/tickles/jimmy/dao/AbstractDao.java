package br.com.tickles.jimmy.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public abstract class AbstractDao<T> {

	private static final String UNIT_NAME = "jimmy.persistence";

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);

	Session session = null;

	Session getSession() {

		if (session == null) {

			session = (Session) emf.createEntityManager().getDelegate();
		}

		return session;
	}
	
	EntityManager getEntityManager() {

		return emf.createEntityManager();
	}
}
