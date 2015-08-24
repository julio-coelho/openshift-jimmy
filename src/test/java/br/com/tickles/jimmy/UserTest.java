package br.com.tickles.jimmy;

import br.com.tickles.jimmy.bean.Provider;
import br.com.tickles.jimmy.bean.User;
import br.com.tickles.jimmy.dao.UserDao;

public class UserTest extends AbstractTest {

	public void testCRUD() {
		
		//DAO
		UserDao dao = new UserDao(getSession());
		
		//Insert
		User user_1 = new User();
    	user_1.setName("Julio");
    	user_1.setSobrenome("Coelho");
    	user_1.setUid("113460538930035530779");
    	user_1.setEmail("coelho.julio@gmail.com");
    	
    	Provider provider = new Provider();
    	provider.setId(1);    	
    	user_1.setProvider(provider);

    	Integer id = dao.create(user_1);

    	//Load
    	User user_2 = dao.read(id);
    	
        assertTrue( user_1.getName().equals(user_2.getName()));
        assertTrue( user_1.getSobrenome().equals(user_2.getSobrenome()));
        assertTrue( user_1.getUid().equals(user_2.getUid()));
        assertTrue( user_1.getEmail().equals(user_2.getEmail()));
        assertTrue( user_1.getProvider().getId().equals(user_2.getProvider().getId()));
        
        //Update
        user_2.setName("João");
        dao.update(user_2);
        
        //Load
        User user_3 = dao.read(id);
        
        assertTrue( user_3.getName().equals("João"));
        
        //Delete Test
        dao.delete(user_2);
	}
	
	public void testFindFacebookUser() {
		
		//DAO
		UserDao dao = new UserDao(getSession());
		
		User user = dao.findFacebookUser("113460538930035530773");

		assertTrue( user.getName().equals("Julio"));
        assertTrue( user.getSobrenome().equals("Coelho"));
        assertTrue( user.getUid().equals("113460538930035530773"));
        assertTrue( user.getEmail().equals("coelho.julio@gmail.com"));
        assertTrue( user.getProvider().getId().equals(1));
		
	}
	
}