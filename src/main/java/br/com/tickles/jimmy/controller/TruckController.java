package br.com.tickles.jimmy.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.jboss.logging.Logger;

import br.com.tickles.jimmy.bean.Truck;
import br.com.tickles.jimmy.dao.TruckDao;

@ManagedBean
@SessionScoped
public class TruckController implements Serializable {

	private static final long serialVersionUID = 4294353917171320977L;

	private static Logger log = Logger.getLogger(TruckController.class);
	
	public TruckController() {

		log.info("Debug TRUCK Constructor");
		
		truck = new Truck();
		selectedTruck = new Truck();
		dao = new TruckDao();
		trucks = dao.retrieveAll();
	}

	private Truck truck;
	private List<Truck> trucks;
	private Truck selectedTruck;
	
	private TruckDao dao;

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	public Truck getSelectedTruck() {
		return selectedTruck;
	}

	public void setSelectedTruck(Truck selectedTruck) {
		this.selectedTruck = selectedTruck;
	}

	public void save() {

		TruckDao dao = new TruckDao();
		dao.save(truck);

		this.setTruck(new Truck());
		
		this.trucks.add(truck);

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Parabéns", "Cadastro salvo com sucesso !!!"));

	}

	public List<Truck> getTrucks() {

		return trucks;
	}
}
