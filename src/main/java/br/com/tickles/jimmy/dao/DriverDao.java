package br.com.tickles.jimmy.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.tickles.jimmy.bean.Driver;

public class DriverDao extends AbstractDao{

	public void save(Driver driver){
		
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.persist(driver);		
		em.getTransaction().commit();
		
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Driver> retrieveAll(){
		
		EntityManager em = getEntityManager();
		
		List<Driver> drivers = em.createQuery("SELECT d FROM Driver d").getResultList();
		
		em.close();
		
		return drivers;
	}
}
