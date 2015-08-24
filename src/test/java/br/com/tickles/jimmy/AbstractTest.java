package br.com.tickles.jimmy;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

import junit.framework.TestCase;

public abstract class AbstractTest extends TestCase {

	private static final String UNIT_NAME = "jimmy.persistence";

	private EntityManagerFactory emf = null;

	protected EntityManager em = null;
	
	private Session session = null;
	

	public EntityManager getEntityManager() {

		return em;
	}

	public Session getSession() {
		
		return session;
	}

	
	
	@Override
	protected void setUp() throws Exception {

		Map<String, Object> configOverrides = new HashMap<String, Object>();
		configOverrides.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/JIMMY_DEV");
		configOverrides.put("javax.persistence.jdbc.user", "JIMMY_USR");
		configOverrides.put("javax.persistence.jdbc.password", "JIMMY_PSW");
		configOverrides.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");	
		
		emf = Persistence.createEntityManagerFactory(UNIT_NAME, configOverrides);

		em = emf.createEntityManager();
		
		session = (Session) getEntityManager().getDelegate();
	}

}
