package br.com.tickles.jimmy.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.tickles.jimmy.bean.User;

public class UserDao extends AbstractDao<User> {

	public UserDao () {
		
	}
	
	public UserDao(Session session) {
		
		this.session = session;
	}
	
	public Integer create(User user) {
		return (Integer) getSession().save(user);
	}

	public User read(Integer id) {
		return (User) getSession().get(User.class, id);
	}

	public void update(User user) {
		getSession().update(user);
		getSession().flush();
	}

	public void delete(User user) {
		getSession().delete(user);
		getSession().flush();
	}

	public User findFacebookUser(String uid) {

		Criteria c = getSession().createCriteria(User.class);
		c.add(Restrictions.eq("provider.id", 1));
		c.add(Restrictions.eq("uid", uid));

		return (User) c.uniqueResult();
	}
}
