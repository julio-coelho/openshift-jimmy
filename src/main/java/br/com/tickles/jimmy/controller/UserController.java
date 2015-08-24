package br.com.tickles.jimmy.controller;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;

import br.com.tickles.jimmy.bean.Provider;
import br.com.tickles.jimmy.bean.User;
import br.com.tickles.jimmy.dao.UserDao;

@ManagedBean
@SessionScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = 1718732362417584552L;

	private static Logger log = Logger.getLogger(UserController.class);
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String onFacebookLogin(){
		
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		String uid = map.get("uid").toString();
        String email = map.get("email").toString();
        String firstName = map.get("firstName").toString();
        String lastName = map.get("lastName").toString();
		
        UserDao dao = new UserDao();
        user = dao.findFacebookUser(uid);
        
        if (user == null) {
        	
        	user = new User();
			user.setName(firstName);
			user.setSobrenome(lastName);
			user.setEmail(email);
			user.setUid(uid);
			
			Provider provider = new Provider();
			provider.setId(1);
			user.setProvider(provider);
			
			dao.create(user);
		}
        
        HttpSession session = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
        session.setAttribute("user", user);
        
        return "openUserForm";
	}
	
	public void onFacebookLogout() {
		
		log.info("Logout user");
	}
}
