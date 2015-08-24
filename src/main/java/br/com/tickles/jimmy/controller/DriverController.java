package br.com.tickles.jimmy.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import br.com.tickles.jimmy.bean.Driver;
import br.com.tickles.jimmy.dao.DriverDao;

@ManagedBean
@SessionScoped
public class DriverController implements Serializable {

	private static final long serialVersionUID = -674602787486331825L;

	private Driver driver;
	private Driver selectedDriver;
	
	private List<Driver> drivers;

	
	public DriverController() {

		this.driver = new Driver();
		this.selectedDriver = new Driver();
	}
	
	public Driver getDriver(){
		return this.driver;
	}
	
	public void setDriver(Driver driver){
		this.driver = driver;
	}
	
	public Driver getSelectedDriver(){
		return this.selectedDriver;
	}
	
	public void setSelectedDriver(Driver selectedDriver){
		this.selectedDriver = selectedDriver;
	}

	public void save() {

/*		FacesContext context = FacesContext.getCurrentInstance();

		if (this.driver.getName() == null) {
			context.addMessage(null, new FacesMessage("Informe o nome do motorista."));
		}
		
		if (context.getMessageList() == null || context.getMessageList().isEmpty()) {
			context.addMessage(null, new FacesMessage("Salvo."));			
		}*/
		
		DriverDao driverDao = new DriverDao();
		
		driverDao.save(this.driver);
		
		this.drivers = driverDao.retrieveAll();
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Motorista incluído com sucesso."));
	}
	
	public List<Driver> getDrivers(){
		
		DriverDao driverDao = new DriverDao();
			
		this.drivers = driverDao.retrieveAll();
		
		return this.drivers;
	}

}
