package br.com.tickles.jimmy.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.tickles.jimmy.bean.Truck;

public class TruckDao extends AbstractDao {

	public void save(Truck truck) {
		
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.persist(truck);
		em.getTransaction().commit();
		
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Truck> retrieveAll() {
		
		EntityManager em = getEntityManager();
		
		List<Truck> trucks = em.createQuery("SELECT t FROM Truck t").getResultList();
		
		em.close();
		
		return trucks;
	}
	
}
