package com.webbutik.dataacces;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.webbutik.domain.Car;
import com.webbutik.domain.ModelOfCar;

/**
 * 
 * @author danijela repository av tabell modelOfCar implementation av interface
 *
 */
@Repository
public class ModelOfCarDataAccessProduktionVersion implements ModelOfCarDataAccess {

	/**
	 * Använda HibernateTemplate class method att persist the objekt av ModelOfCar
	 * klass
	 */
	@Autowired
	private HibernateTemplate template;

	/**
	 * Med hjalp av HibernateTemplate insert en ny model av bil i table modelOfCar
	 * Om model finns i tabel modelOfCAr kastar metod en exceprion
	 */
	@Override
	public void insert(ModelOfCar moc) throws CarFoundException {
//		List<ModelOfCar> results = template.execute(session -> {
//			Query<ModelOfCar> q = session.createQuery("from ModelOfCar where modelName=:modelName");
//			q.setParameter("modelName", moc.getModelName());
//			return q.list();
//		});
		
		List<ModelOfCar> results = hamtaModelOfBil(moc.getModelName());
		
		if (results.size() == 0)
			this.template.save(moc);
		else
			throw new CarFoundException();
		

	}

	/**
	 * Raderar en bil fran tabel modelOfCar med hjalp av id av model av bil i tabel
	 * Om bil finns inte i tabel kastar programmet exception
	 * DataIntegrityViolationException händer om man vill ta bort en model från modelOfCar tabell
	 * och den modelen fortfarande finns i tabell car. Den exception kommer vi att handla på client sida
	 */
	@Override
	public void remove(String modelName) throws CarNotFoundException {
//		List<ModelOfCar> results = template.execute(session -> {
//			Query<ModelOfCar> q = session.createQuery("from ModelOfCar where modelName=:modelName");
//			q.setParameter("modelName", modelName);
//			return q.list();
//		});
		List<ModelOfCar> results = hamtaModelOfBil(modelName);
		// template.delete(results.get(0));
		
		if (results.size() == 1)
			template.delete(results.get(0));
		else
			throw new CarNotFoundException();
	}

	/**
	 * Hamta en model av bil fran tabel modelOfCar pga av name av model Om bil finns
	 * inte i tabel kastar programmet exception
	 */
	@Override
	public ModelOfCar findByModel(String modelName) throws CarNotFoundException {
//		List<ModelOfCar> results = template.execute(session -> {
//			Query<ModelOfCar> q = session.createQuery("from ModelOfCar where modelName=:modelName");
//			q.setParameter("modelName", modelName);
//			return q.list();
//		});
		// return results.get(0);
		List<ModelOfCar> results = hamtaModelOfBil(modelName);
		if (results.size() == 1)
			return results.get(0);
		else
			throw new CarNotFoundException();

	}
	
	//hjälp metod
	/**
	 * Hjälp metoden
	 * @param modelName namn av model av bil
	 * @return List av modeler av bilar
	 */
	public List<ModelOfCar> hamtaModelOfBil(String modelName){
		List<ModelOfCar> results = template.execute(session -> {
			Query<ModelOfCar> q = session.createQuery("from ModelOfCar where modelName=:modelName");
			q.setParameter("modelName", modelName);
			return q.list();
		});
		return results;
		
	}

}
