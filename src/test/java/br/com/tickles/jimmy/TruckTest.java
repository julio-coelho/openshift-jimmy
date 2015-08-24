package br.com.tickles.jimmy;

import br.com.tickles.jimmy.bean.Truck;

public class TruckTest extends AbstractTest {
	
    public void testInsert()
    {
    	Truck truck = new Truck();
    	truck.setFrota(2);
    	truck.setPlaca("CIH1199");

    	getEntityManager().getTransaction().begin();
    	getEntityManager().persist(truck);
    	getEntityManager().getTransaction().commit();
    	    	
        assertTrue( true );
    }
	
}
